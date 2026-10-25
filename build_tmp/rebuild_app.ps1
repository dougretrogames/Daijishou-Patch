$ErrorActionPreference = 'Continue'
$jd   = 'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin\java.exe'
$apk  = 'C:\Users\Douglas\AppData\Local\apk-editor-studio\apktool\apktool_2.11.1.jar'
$bt   = 'C:\Users\Douglas\AppData\Local\Android\Sdk\build-tools\35.0.0'
$base = 'C:\Users\Douglas\Documents\Daijishou'
$tmp  = Join-Path $base 'build_tmp'
$d    = Join-Path $tmp 'smali_build7'

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
  minSdkVersion: '26'
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
python -I assemble3.py
& (Join-Path $bt 'zipalign.exe') -f -p 4 unsigned3.apk aligned3.apk
& (Join-Path $bt 'apksigner.bat') sign --ks debug.keystore --ks-pass pass:android --key-pass pass:android --ks-key-alias androiddebugkey --out (Join-Path $base 'Daijishou v1.5.0-reconstructed.apk') aligned3.apk
& (Join-Path $bt 'apksigner.bat') verify (Join-Path $base 'Daijishou v1.5.0-reconstructed.apk') 2>&1 | Select-Object -First 3
Get-Item (Join-Path $base 'Daijishou v1.5.0-reconstructed.apk') | Select-Object Length
Pop-Location
