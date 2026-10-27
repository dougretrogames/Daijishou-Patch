import os, subprocess

jadx_dir = os.path.abspath(r'build_tmp/sources_181_merged/com/magneticchen/daijishou')
sources = []
for root, dirs, files in os.walk(jadx_dir):
    for f in files:
        if f.endswith('.java'):
            sources.append(os.path.join(root, f).replace('\\', '/'))

print(f'Total java files in merged: {len(sources)}')
argfile = 'build_tmp/test_181_merged_sources.txt'
with open(argfile, 'w', encoding='utf-8') as f:
    f.write('\n'.join(f'"{s}"' for s in sources))

jdk = r"C:\Program Files\Eclipse Adoptium\jdk-21.0.12.101-hotspot\bin\javac.exe"
android = os.path.expandvars(r"%LOCALAPPDATA%\Android\Sdk\platforms\android-35\android.jar")
jars = os.path.abspath(r"reconstructed/jars_compile/*")
classpath = f"{jars};{android}"
out_dir = os.path.abspath(r"build_tmp/test_181_merged_classes")
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
    f"@{argfile}"
]

proc = subprocess.run(cmd, capture_output=True, text=True, encoding='utf-8', errors='replace')
print("Exit code:", proc.returncode)
with open("build_tmp/test_181_merged_javac_err.log", "w", encoding="utf-8") as f:
    f.write(proc.stderr)
print(f"Stderr length: {len(proc.stderr)} chars")
