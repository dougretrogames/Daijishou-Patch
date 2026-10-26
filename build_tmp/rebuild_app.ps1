$ErrorActionPreference = 'Continue'
$base = (Get-Item $PSScriptRoot).Parent.FullName
$tmp  = Join-Path $base 'build_tmp'
$d    = Join-Path $tmp 'smali_build7'

# Detect Java
$jd = if ($env:JAVA_HOME -and (Test-Path "$env:JAVA_HOME\bin\java.exe")) {
    "$env:JAVA_HOME\bin\java.exe"
} elseif (Test-Path 'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin\java.exe') {
    'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin\java.exe'
} else {
    'java.exe'
}

# Detect apktool
$apk = if (Test-Path (Join-Path $base 'tools\apktool_2.11.1.jar')) {
    Join-Path $base 'tools\apktool_2.11.1.jar'
} elseif (Test-Path 'C:\Users\Douglas\AppData\Local\apk-editor-studio\apktool\apktool_2.11.1.jar') {
    'C:\Users\Douglas\AppData\Local\apk-editor-studio\apktool\apktool_2.11.1.jar'
} else {
    (Get-ChildItem (Join-Path $base 'tools') -Filter 'apktool*.jar' -ErrorAction SilentlyContinue | Select-Object -First 1).FullName
}

# Detect Android SDK Build-Tools
$android_root = if ($env:ANDROID_HOME) { $env:ANDROID_HOME }
                elseif ($env:ANDROID_SDK_ROOT) { $env:ANDROID_SDK_ROOT }
                elseif (Test-Path "$env:LOCALAPPDATA\Android\Sdk") { "$env:LOCALAPPDATA\Android\Sdk" }
                else { "C:\Android\android-sdk" }

$bt = Join-Path $android_root 'build-tools\35.0.0'
if (-not (Test-Path $bt)) {
    $bts = Get-ChildItem (Join-Path $android_root 'build-tools') -Directory -ErrorAction SilentlyContinue | Sort-Object Name -Descending
    if ($bts) { $bt = $bts[0].FullName }
}

Remove-Item -Recurse -Force $d -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Force (Join-Path $d 'smali') | Out-Null
Copy-Item (Join-Path $tmp 'smali_recon\*') (Join-Path $d 'smali') -Recurse -Force
New-Item -ItemType Directory -Force (Join-Path $d 'res\values') | Out-Null
Set-Content -Path (Join-Path $d 'AndroidManifest.xml') -Encoding UTF8 -Value '<manifest xmlns:android="http://schemas.android.com/apk/res/android" package="com.rebuild.app"><application/></manifest>'
Set-Content -Path (Join-Path $d 'apktool.yml') -Encoding UTF8 -Value @'
version: 2.11.1
apkFileName: app.apk
isFrameworkApk: false
usesFramework:
  ids:
  - 1
sdkInfo:
  minSdkVersion: '24'
  targetSdkVersion: '35'
packageInfo:
  forcedPackageId: '127'
  renameManifestPackage: null
versionInfo:
  versionCode: '1'
  versionName: '1.0'
resourcesAreCompressed: false
sharedLibrary: false
sparseResources: false
unknownFiles: {}
doNotCompress: []
'@

Push-Location $tmp
Remove-Item app7.apk -Force -ErrorAction SilentlyContinue
& $jd -Xmx6g -jar $apk b $d -o app7.apk 2>&1 | Select-Object -Last 6
if (-not (Test-Path (Join-Path $tmp 'app7.apk'))) { Pop-Location; throw 'apktool build failed' }
if (-not (Test-Path (Join-Path $tmp 'apktool_res.apk'))) {
    Write-Host "apktool_res.apk not found, rebuilding resources..."
    python (Join-Path $tmp 'rebuild_resources.py')
}
python -I assemble3.py
& (Join-Path $bt 'zipalign.exe') -f -p 4 unsigned3.apk aligned3.apk
& (Join-Path $bt 'apksigner.bat') sign --ks debug.keystore --ks-pass pass:android --key-pass pass:android --ks-key-alias androiddebugkey --out (Join-Path $base 'Daijishou v1.5.0-reconstructed.apk') aligned3.apk
& (Join-Path $bt 'apksigner.bat') verify (Join-Path $base 'Daijishou v1.5.0-reconstructed.apk') 2>&1 | Select-Object -First 3
Get-Item (Join-Path $base 'Daijishou v1.5.0-reconstructed.apk') | Select-Object Length
Pop-Location
