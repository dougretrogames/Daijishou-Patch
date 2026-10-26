param(
    [switch]$NoOrig = $true
)

$ErrorActionPreference = 'Stop'

# Detect Java 21
if ($env:JAVA_HOME -and (Test-Path "$env:JAVA_HOME\bin\javac.exe")) {
    $jd21 = "$env:JAVA_HOME\bin"
} elseif (Test-Path 'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin\javac.exe') {
    $jd21 = 'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin'
    $env:JAVA_HOME = 'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1'
} else {
    $jd21 = (Get-Command javac.exe).Source | Split-Path
}

# Detect Android SDK
$android_root = if ($env:ANDROID_HOME) { $env:ANDROID_HOME }
                elseif ($env:ANDROID_SDK_ROOT) { $env:ANDROID_SDK_ROOT }
                elseif (Test-Path "$env:LOCALAPPDATA\Android\Sdk") { "$env:LOCALAPPDATA\Android\Sdk" }
                else { "C:\Android\android-sdk" }

$android = Join-Path $android_root 'platforms\android-35\android.jar'
if (-not (Test-Path $android)) {
    $platforms = Get-ChildItem (Join-Path $android_root 'platforms') -Directory -ErrorAction SilentlyContinue | Sort-Object Name -Descending
    if ($platforms) { $android = Join-Path $platforms[0].FullName 'android.jar' }
}

$bt = Join-Path $android_root 'build-tools\35.0.0'
if (-not (Test-Path $bt)) {
    $bts = Get-ChildItem (Join-Path $android_root 'build-tools') -Directory -ErrorAction SilentlyContinue | Sort-Object Name -Descending
    if ($bts) { $bt = $bts[0].FullName }
}

$env:NO_ORIG   = if ($NoOrig) { '1' } else { '0' }

Write-Host "=== [Build Cycle] Modo No-Orig: $NoOrig ==="

Write-Host "=== 1) Compilando nest sources com javac ==="
$javac_args = @(
    "-J-Xmx6g",
    "-nowarn",
    "-proc:none",
    "-encoding", "UTF-8",
    "-source", "8",
    "-target", "8",
    "-bootclasspath", $android,
    "-classpath", "reconstructed\jars_compile\*;$android",
    "-Xmaxerrs", "40000",
    "-d", "nest_classes_compile",
    "@nest_sources_compile.txt"
)
& "$jd21\javac.exe" $javac_args
if ($LASTEXITCODE -ne 0) { throw "javac failed with exit code $LASTEXITCODE" }

Write-Host "=== 2) Gerando app_classes_compile.jar e classes.dex com d8 ==="
if (-not (Test-Path build_tmp\app_dex)) { New-Item -ItemType Directory -Force build_tmp\app_dex | Out-Null }
if (-not (Test-Path build_tmp\app_dex_rel)) { New-Item -ItemType Directory -Force build_tmp\app_dex_rel | Out-Null }
& "$jd21\jar.exe" cf build_tmp\app_classes_compile.jar -C nest_classes_compile .
if ($LASTEXITCODE -ne 0) { throw "jar failed with exit code $LASTEXITCODE" }

& "$bt\d8.bat" --release --min-api 24 --lib $android --output build_tmp\app_dex_rel build_tmp\app_classes_compile.jar
if ($LASTEXITCODE -ne 0) { throw "d8 failed with exit code $LASTEXITCODE" }

Copy-Item build_tmp\app_dex_rel\classes.dex build_tmp\app_dex\classes.dex -Force

Write-Host "=== 3) Descompilando com baksmali ==="
$baksmali = if (Test-Path 'tools\baksmali-2.5.2.jar') { 'tools\baksmali-2.5.2.jar' } else { (Get-ChildItem 'tools' -Filter 'baksmali*.jar')[0].FullName }
& "$jd21\java.exe" -jar $baksmali d build_tmp\app_dex\classes.dex -o build_tmp\smali_compiled
if ($LASTEXITCODE -ne 0) { throw "baksmali failed with exit code $LASTEXITCODE" }

Write-Host "=== 3.1) Atualizando class_map.json com build_class_map.py ==="
python -I build_tmp\build_class_map.py
if ($LASTEXITCODE -ne 0) { throw "build_class_map failed with exit code $LASTEXITCODE" }

Write-Host "=== 4) Executando run_pipeline.ps1 ==="
powershell -ExecutionPolicy Bypass -File build_tmp\run_pipeline.ps1
if ($LASTEXITCODE -ne 0) { throw "pipeline failed with exit code $LASTEXITCODE" }

if ($NoOrig) {
    Write-Host "=== 4.1) Validando Gate No-Orig com verify_no_orig.py ==="
    python -I build_tmp\verify_no_orig.py
    if ($LASTEXITCODE -ne 0) { throw "verify_no_orig failed: build contem dependencias de referencia!" }
}

Write-Host "=== 5) Executando rebuild_app.ps1 ==="
powershell -ExecutionPolicy Bypass -File build_tmp\rebuild_app.ps1
if ($LASTEXITCODE -ne 0) { throw "rebuild failed with exit code $LASTEXITCODE" }

Write-Host "=== BUILD COMPLETO COM SUCESSO! ==="
