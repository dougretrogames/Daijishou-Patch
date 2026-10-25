param(
  [Parameter(Mandatory=$true)][string]$SrcRoot,
  [Parameter(Mandatory=$true)][string]$ArgFile,
  [Parameter(Mandatory=$true)][string]$OutDir,
  [Parameter(Mandatory=$true)][string]$LogFile,
  [string]$JarDir = 'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars_pub2',
  [string]$LibDir = 'C:\Users\Douglas\Documents\Daijishou\reconstructed\libs_pub2'
)
$ErrorActionPreference = 'Continue'
$javac  = 'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin\javac.exe'
$android= 'C:\Users\Douglas\AppData\Local\Android\Sdk\platforms\android-35\android.jar'
$libs   = if ([string]::IsNullOrEmpty($LibDir)) { '' } else { Join-Path $LibDir '*' }
$jars   = Join-Path $JarDir '*'

# (re)generate argfile
$files = Get-ChildItem -Path $SrcRoot -Recurse -Filter '*.java' |
         ForEach-Object { '"' + $_.FullName.Replace('\','/') + '"' }
[System.IO.File]::WriteAllText($ArgFile, ($files -join "`n"), (New-Object System.Text.UTF8Encoding($false)))

if (Test-Path $OutDir) { Remove-Item -Recurse -Force $OutDir }
New-Item -ItemType Directory -Force -Path $OutDir | Out-Null

$classpath = if ([string]::IsNullOrEmpty($LibDir)) { "$jars;$android" } else { "$libs;$jars;$android" }
$args = @(
  '-J-Xmx6g','-nowarn','-proc:none','-encoding','UTF-8','-source','8','-target','8',
  '-bootclasspath',$android,
  '-classpath',$classpath,
  '-Xmaxerrs','40000',
  '-d',$OutDir,
  "@$ArgFile"
)
$p = Start-Process -FilePath $javac -ArgumentList $args -Wait -PassThru -NoNewWindow `
      -RedirectStandardError $LogFile -RedirectStandardOutput "$LogFile.stdout"
"files: $($files.Count)"
"exit=$($p.ExitCode)"
