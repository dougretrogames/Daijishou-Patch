import os
import subprocess

jdk = r"C:\Program Files\Eclipse Adoptium\jdk-21.0.12.101-hotspot\bin\javac.exe"
android = os.path.expandvars(r"%LOCALAPPDATA%\Android\Sdk\platforms\android-35\android.jar")
jars = os.path.abspath(r"reconstructed/jars_compile/*")
classpath = f"{jars};{android}"
out_dir = os.path.abspath(r"build_tmp/test_181_classes")

os.makedirs(out_dir, exist_ok=True)

cmd = [
    jdk,
    "-J-Xmx6g",
    "-nowarn",
    "-proc:none",
    "-encoding", "UTF-8",
    "-source", "8",
    "-target", "8",
    "-bootclasspath", android,
    "-classpath", classpath,
    "-Xmaxerrs", "500",
    "-d", out_dir,
    "@build_tmp/test_181_sources.txt"
]

proc = subprocess.run(cmd, capture_output=True, text=True, encoding='utf-8', errors='replace')
print("Exit code:", proc.returncode)
with open("build_tmp/test_181_javac_err.log", "w", encoding="utf-8") as f:
    f.write(proc.stderr)
print(f"Stderr length: {len(proc.stderr)} chars")
lines = proc.stderr.splitlines()
print("First 20 lines of errors:")
for l in lines[:20]:
    print(l)
