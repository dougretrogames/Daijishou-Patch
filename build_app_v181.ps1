param(
    [string]$OutApk = "Daijishou-v1.8.1-release.apk",
    [string]$BaseApk = "base_apk/Daijishou_v1.8.1_426.apk",
    [string]$ApktoolJar = "tools/apktool_3.0.3.jar",
    [string]$WorkDir = "build_tmp/apktool_1.8.1_v3",
    [string]$Keystore = "build_tmp/debug.keystore"
)

$ErrorActionPreference = "Stop"

Write-Host "=================================================="
Write-Host "Iniciando Build Automatizado Daijishou v1.8.1 (426)"
Write-Host "=================================================="

# 1. Garantir diretórios base
if (-not (Test-Path "tools")) { New-Item -ItemType Directory -Force "tools" | Out-Null }
if (-not (Test-Path "build_tmp")) { New-Item -ItemType Directory -Force "build_tmp" | Out-Null }

# 2. Garantir Apktool 3.0.3
if (-not (Test-Path $ApktoolJar)) {
    Write-Host "Baixando Apktool 3.0.3..."
    $apktoolUrl = "https://bitbucket.org/iBotPeaches/apktool/downloads/apktool_3.0.3.jar"
    [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
    Invoke-WebRequest -Uri $apktoolUrl -OutFile $ApktoolJar
}

# 3. Localizar Android SDK Build-Tools e plataformas
$sdk = if ($env:ANDROID_HOME -and (Test-Path $env:ANDROID_HOME)) {
    $env:ANDROID_HOME
} elseif ($env:ANDROID_SDK_ROOT -and (Test-Path $env:ANDROID_SDK_ROOT)) {
    $env:ANDROID_SDK_ROOT
} elseif (Test-Path "C:\Android\android-sdk") {
    "C:\Android\android-sdk"
} else {
    Join-Path $env:LOCALAPPDATA "Android\Sdk"
}
Write-Host "Android SDK: $sdk"

$buildToolsDir = Get-ChildItem -Path (Join-Path $sdk "build-tools") | Sort-Object Name -Descending | Select-Object -First 1
if (-not $buildToolsDir) { throw "Android build-tools nao encontrado em $sdk" }
Write-Host "Build-Tools: $($buildToolsDir.FullName)"

$zipalign = Join-Path $buildToolsDir.FullName "zipalign.exe"
$apksigner = Join-Path $buildToolsDir.FullName "apksigner.bat"
$d8 = Join-Path $buildToolsDir.FullName "d8.bat"

$androidJar = (Get-ChildItem -Path (Join-Path $sdk "platforms") -Filter "android.jar" -Recurse | Sort-Object FullName -Descending | Select-Object -First 1).FullName
Write-Host "Android Jar: $androidJar"

$javac = (Get-Command javac.exe -ErrorAction SilentlyContinue)
if ($javac) { $javac = $javac.Source } else { $javac = "javac" }

# 4. Decodificar APK base se a pasta de trabalho nao existir
if (-not (Test-Path (Join-Path $WorkDir "AndroidManifest.xml"))) {
    Write-Host "`n[1/5] Decodificando APK base com Apktool 3.0.3..."
    if (-not (Test-Path $BaseApk)) {
        throw "Arquivo base $BaseApk nao encontrado!"
    }
    java -jar $ApktoolJar d $BaseApk -o $WorkDir -f
} else {
    Write-Host "`n[1/5] Pasta de trabalho $WorkDir ja pronta."
}

# 5. Aplicar Patches de patches_181
Write-Host "`n[2/5] Aplicando patches (bateria, preferências, permissões, minSdk 24)..."
Copy-Item "patches_181/AndroidManifest.xml" (Join-Path $WorkDir "AndroidManifest.xml") -Force
Copy-Item "patches_181/apktool.yml" (Join-Path $WorkDir "apktool.yml") -Force

# Copiar recursos patcheados
Copy-Item -Path "patches_181/res/*" -Destination (Join-Path $WorkDir "res") -Recurse -Force

# Garantir separador de adaptive-icon para API 24/25
$oldMipmap = Join-Path $WorkDir "res/mipmap-anydpi"
$newMipmap = Join-Path $WorkDir "res/mipmap-anydpi-v26"
if (Test-Path $oldMipmap) {
    if (Test-Path $newMipmap) { Remove-Item -Recurse -Force $newMipmap }
    Rename-Item -Path $oldMipmap -NewName "mipmap-anydpi-v26" -Force
}

# Copiar smalis patcheados (bateria e MainActivity)
Copy-Item -Path "patches_181/smali_classes4/*" -Destination (Join-Path $WorkDir "smali_classes4") -Recurse -Force

# 6. Compilar MusicManager com javac + d8 (--min-api 24)
Write-Host "`n[3/5] Compilando MusicManager com javac e d8 (min-api 24)..."
$audioClassesDir = "build_tmp/audio_classes"
if (Test-Path $audioClassesDir) { Remove-Item -Recurse -Force $audioClassesDir }
New-Item -ItemType Directory -Force -Path $audioClassesDir | Out-Null

$audioSrcs = @(
    "app_sources/sources/com/magneticchen/daijishou/audio/MusicManager.java",
    "app_sources/sources/com/magneticchen/daijishou/audio/MusicStrings.java"
)

$jars = (Resolve-Path "reconstructed/jars_compile/*" -ErrorAction SilentlyContinue) -join ";"
$cp = if ($jars) { "$jars;$androidJar" } else { $androidJar }

& $javac -nowarn -proc:none -source 8 -target 8 -bootclasspath $androidJar -cp $cp -d $audioClassesDir $audioSrcs

$audioDexDir = "build_tmp/audio_dex"
if (Test-Path $audioDexDir) { Remove-Item -Recurse -Force $audioDexDir }
New-Item -ItemType Directory -Force -Path $audioDexDir | Out-Null

$classFiles = Get-ChildItem -Path $audioClassesDir -Filter "*.class" -Recurse | ForEach-Object { $_.FullName }
& $d8 --release --output $audioDexDir --min-api 24 $classFiles

# Desmontar classes.dex do audio e copiar smalis para smali_classes4
$dummyZip = "build_tmp/audio_dummy.zip"
if (Test-Path $dummyZip) { Remove-Item -Force $dummyZip }
Compress-Archive -Path (Join-Path $audioDexDir "classes.dex") -DestinationPath $dummyZip -Force

$audioSmaliDir = "build_tmp/audio_smali_apktool"
if (Test-Path $audioSmaliDir) { Remove-Item -Recurse -Force $audioSmaliDir }
java -jar $ApktoolJar d $dummyZip -o $audioSmaliDir -f -r

$destSmaliAudio = Join-Path $WorkDir "smali_classes4/com/magneticchen/daijishou/audio"
if (-not (Test-Path $destSmaliAudio)) { New-Item -ItemType Directory -Force -Path $destSmaliAudio | Out-Null }
Get-ChildItem -Path (Join-Path $audioSmaliDir "smali/com/magneticchen/daijishou/audio") | ForEach-Object {
    Copy-Item -Path $_.FullName -Destination $destSmaliAudio -Force
}

# 7. Compilar APK com Apktool 3.0.3
Write-Host "`n[4/5] Recompilando APK com Apktool 3.0.3..."
$patchedApk = "build_tmp/daijishou_181_patched.apk"
if (Test-Path $patchedApk) { Remove-Item -Force $patchedApk }
java -jar $ApktoolJar b $WorkDir -o $patchedApk

# 8. Alinhamento e Assinatura
Write-Host "`n[5/5] Executando zipalign e apksigner (v1, v2 e v3 habilitados para minSdk 24)..."
$alignedApk = "build_tmp/aligned_181.apk"
if (Test-Path $alignedApk) { Remove-Item -Force $alignedApk }
& $zipalign -f -p 4 $patchedApk $alignedApk

# Criar debug keystore se nao existir
if (-not (Test-Path $Keystore)) {
    Write-Host "Criando debug.keystore..."
    $keytool = (Get-Command keytool.exe -ErrorAction SilentlyContinue)
    $keytoolPath = if ($keytool) { $keytool.Source } else { "keytool" }
    & $keytoolPath -genkey -v -keystore $Keystore -storepass android -alias androiddebugkey -keypass android -keyalg RSA -keysize 2048 -validity 10000 -dname "CN=Android Debug,O=Android,C=US"
}

if (Test-Path $OutApk) { Remove-Item -Force $OutApk }
& $apksigner sign --ks $Keystore --ks-pass pass:android --key-pass pass:android --ks-key-alias androiddebugkey --min-sdk-version 24 --v1-signing-enabled true --v2-signing-enabled true --v3-signing-enabled true --out $OutApk $alignedApk

Write-Host "`n=== Verificacao de Assinatura ==="
& $apksigner verify --verbose --min-sdk-version 23 --max-sdk-version 23 $OutApk
& $apksigner verify --verbose --min-sdk-version 24 $OutApk

Write-Host "`n=== SUCESSO: Build concluido em $OutApk ==="
