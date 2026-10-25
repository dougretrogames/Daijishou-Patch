$ErrorActionPreference = 'Stop'
$jd21   = 'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin'
$android= "$env:LOCALAPPDATA\Android\Sdk\platforms\android-35\android.jar"
$bt     = "$env:LOCALAPPDATA\Android\Sdk\build-tools\35.0.0"
$env:JAVA_HOME = 'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1'

Write-Host "=== 1) Compilando nest sources com javac ==="
& "$jd21\javac.exe" -J-Xmx6g -nowarn -proc:none -encoding UTF-8 -source 8 -target 8 `
  -bootclasspath $android -classpath "reconstructed\jars_compile\*;$android" `
  -Xmaxerrs 40000 -d nest_classes_compile "@nest_sources_compile.txt"
if ($LASTEXITCODE -ne 0) { throw "javac failed with exit code $LASTEXITCODE" }

Write-Host "=== 2) Gerando app_classes_compile.jar e classes.dex com d8 ==="
if (-not (Test-Path build_tmp\app_dex)) { New-Item -ItemType Directory -Force build_tmp\app_dex | Out-Null }
if (-not (Test-Path build_tmp\app_dex_rel)) { New-Item -ItemType Directory -Force build_tmp\app_dex_rel | Out-Null }
& "$jd21\jar.exe" cf build_tmp\app_classes_compile.jar -C nest_classes_compile .
if ($LASTEXITCODE -ne 0) { throw "jar failed with exit code $LASTEXITCODE" }

& "$bt\d8.bat" --release --min-api 26 --lib $android --output build_tmp\app_dex_rel build_tmp\app_classes_compile.jar
if ($LASTEXITCODE -ne 0) { throw "d8 failed with exit code $LASTEXITCODE" }

Copy-Item build_tmp\app_dex_rel\classes.dex build_tmp\app_dex\classes.dex -Force

Write-Host "=== 3) Descompilando com baksmali ==="
& "$jd21\java.exe" -jar tools\baksmali-2.5.2.jar d build_tmp\app_dex\classes.dex -o build_tmp\smali_compiled
if ($LASTEXITCODE -ne 0) { throw "baksmali failed with exit code $LASTEXITCODE" }

Write-Host "=== 3.1) Atualizando class_map.json com build_class_map.py ==="
python -I build_tmp\build_class_map.py
if ($LASTEXITCODE -ne 0) { throw "build_class_map failed with exit code $LASTEXITCODE" }

Write-Host "=== 4) Executando run_pipeline.ps1 ==="
powershell -ExecutionPolicy Bypass -File build_tmp\run_pipeline.ps1
if ($LASTEXITCODE -ne 0) { throw "pipeline failed with exit code $LASTEXITCODE" }

Write-Host "=== 5) Executando rebuild_app.ps1 ==="
powershell -ExecutionPolicy Bypass -File build_tmp\rebuild_app.ps1
if ($LASTEXITCODE -ne 0) { throw "rebuild failed with exit code $LASTEXITCODE" }

Write-Host "=== BUILD COMPLETO COM SUCESSO! ==="
