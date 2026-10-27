param(
    [string]$ApktoolJar = "tools/apktool_3.0.3.jar",
    [string]$BuildDir = "build_tmp/apktool_1.8.1_v3",
    [string]$OutApk = "Daijishou-v1.8.1-release.apk",
    [string]$Keystore = "build_tmp/debug.keystore"
)

$ErrorActionPreference = "Stop"

Write-Host "=== Iniciando Pipeline de Compilacao do Daijishou v1.8.1 ==="

# 1. Localizar ferramentas do Android SDK
$buildToolsDir = Get-ChildItem -Path "$env:LOCALAPPDATA\Android\Sdk\build-tools" | Sort-Object Name -Descending | Select-Object -First 1
$zipalign = Join-Path $buildToolsDir.FullName "zipalign.exe"
$apksigner = Join-Path $buildToolsDir.FullName "apksigner.bat"

Write-Host "Build Tools: $($buildToolsDir.FullName)"
Write-Host "Zipalign: $zipalign"
Write-Host "Apksigner: $apksigner"

# 2. Recompilar classes de áudio com D8 (min-api 24)
Write-Host "`n[1/4] Recompilando classes customizadas com javac + d8 (min-api 24)..."
python build_tmp/patch_listener.py
python build_tmp/patch_mediastore.py

$androidJar = (Get-ChildItem -Path "$env:LOCALAPPDATA\Android\Sdk\platforms" -Filter "android.jar" -Recurse | Sort-Object FullName -Descending | Select-Object -First 1).FullName
$javac = (Get-Command javac.exe).Source
$d8 = Join-Path $buildToolsDir.FullName "d8.bat"
$jars = (Resolve-Path "reconstructed/jars_compile/*") -join ";"
$cp = "$jars;$androidJar"

$audioClassesDir = "build_tmp/audio_classes"
if (Test-Path $audioClassesDir) { Remove-Item -Recurse -Force $audioClassesDir }
New-Item -ItemType Directory -Force -Path $audioClassesDir | Out-Null

$audioSrcs = @(
    "build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicManager.java",
    "build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicStrings.java"
)

& $javac -nowarn -proc:none -source 8 -target 8 -bootclasspath $androidJar -cp $cp -d $audioClassesDir $audioSrcs
if ($LASTEXITCODE -ne 0) { throw "Falha na compilacao javac do MusicManager" }

$audioDexDir = "build_tmp/audio_dex"
if (Test-Path $audioDexDir) { Remove-Item -Recurse -Force $audioDexDir }
New-Item -ItemType Directory -Force -Path $audioDexDir | Out-Null

$classFiles = Get-ChildItem -Path $audioClassesDir -Filter "*.class" -Recurse | ForEach-Object { $_.FullName }
& $d8 --release --output $audioDexDir --min-api 24 $classFiles
if ($LASTEXITCODE -ne 0) { throw "Falha na conversao dex pelo D8" }

# Injetar smali desmontado em smali_classes4
$dummyApk = "build_tmp/audio_dummy.apk"
Compress-Archive -Path (Join-Path $audioDexDir "classes.dex") -DestinationPath $dummyApk -Force

$audioSmaliDir = "build_tmp/audio_smali_apktool"
if (Test-Path $audioSmaliDir) { Remove-Item -Recurse -Force $audioSmaliDir }
java -jar $ApktoolJar d $dummyApk -o $audioSmaliDir -f -r

$destSmaliDir = Join-Path $BuildDir "smali_classes4/com/magneticchen/daijishou/audio"
Get-ChildItem -Path (Join-Path $audioSmaliDir "smali/com/magneticchen/daijishou/audio") | ForEach-Object {
    Copy-Item -Path $_.FullName -Destination $destSmaliDir -Force
}

# 3. Montar APK com Apktool 3.0.3
Write-Host "`n[2/4] Montando APK com Apktool 3.0.3..."
$patchedApk = "build_tmp/daijishou_181_patched.apk"
java -jar $ApktoolJar b $BuildDir -o $patchedApk
if ($LASTEXITCODE -ne 0) { throw "Falha no build pelo Apktool" }

# 4. Zipalign
Write-Host "`n[3/4] Alinhando APK (zipalign 4 bytes)..."
$alignedApk = "build_tmp/aligned_181.apk"
if (Test-Path $alignedApk) { Remove-Item -Force $alignedApk }
& $zipalign -f -p 4 $patchedApk $alignedApk
if ($LASTEXITCODE -ne 0) { throw "Falha no zipalign" }

# 5. Assinar com v1, v2 e v3 (min-sdk 24)
Write-Host "`n[4/4] Assinando com apksigner (v1, v2 e v3 habilitados para minSdk 24)..."
& $apksigner sign --ks $Keystore --ks-pass pass:android --key-pass pass:android --ks-key-alias androiddebugkey --min-sdk-version 24 --v1-signing-enabled true --v2-signing-enabled true --v3-signing-enabled true --out $OutApk $alignedApk
if ($LASTEXITCODE -ne 0) { throw "Falha na assinatura pelo apksigner" }

# 6. Validar assinaturas
Write-Host "`n=== Verificando Assinaturas do APK Gerado ==="
& $apksigner verify --verbose $OutApk

Write-Host "`nSUCESSO: Build concluido em $OutApk"
