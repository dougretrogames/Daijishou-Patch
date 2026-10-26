import os, subprocess, shutil, zipfile

if os.environ.get('JAVA_HOME') and os.path.exists(os.path.join(os.environ['JAVA_HOME'], 'bin', 'java.exe')):
    jd = os.path.join(os.environ['JAVA_HOME'], 'bin', 'java.exe')
elif os.path.exists(r'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin\java.exe'):
    jd = r'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin\java.exe'
else:
    jd = 'java'
base = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
apktool = os.path.join(base, 'tools', 'apktool_2.11.1.jar')
if not os.path.exists(apktool):
    apktool = 'apktool'
orig_apk = os.path.join(base, 'Daijishou v1.5.0.apk')
res_dir = os.path.join(base, 'build_tmp', 'apktool_res')
out_apk = os.path.join(base, 'build_tmp', 'apktool_res.apk')

# 1. Decode resources if not already decoded
if not os.path.exists(res_dir):
    print("Decoding resources from original APK...")
    p = subprocess.run([jd, '-jar', apktool, 'd', '-s', '-f', orig_apk, '-o', res_dir], capture_output=True, text=True)
    if p.returncode != 0:
        print("Decode error:", p.stderr)
        raise RuntimeError("apktool decode failed")
    print("Decode complete.")

# 2. Copy modified strings.xml to apktool_res/res/
print("Syncing translated strings.xml...")
src_res = os.path.join(base, 'res_translations') if os.path.exists(os.path.join(base, 'res_translations')) else os.path.join(base, 'jadx-1.5.6', 'resources', 'res')
dst_res = os.path.join(res_dir, 'res')

locales = [
    'values-pt', 'values-pt-rBR', 'values-es', 'values-fr',
    'values-de', 'values-it', 'values-ja', 'values-ko',
    'values-zh', 'values-zh-rTW', 'values-hi'
]

for loc in locales:
    src_file = os.path.join(src_res, loc, 'strings.xml')
    dst_loc_dir = os.path.join(dst_res, loc)
    os.makedirs(dst_loc_dir, exist_ok=True)
    dst_file = os.path.join(dst_loc_dir, 'strings.xml')
    shutil.copy2(src_file, dst_file)
    print(f"Synced {loc}/strings.xml")

# 3. Ensure API 24 compatibility for adaptive icons and apktool.yml
old_mipmap = os.path.join(res_dir, 'res', 'mipmap-anydpi')
v26_mipmap = os.path.join(res_dir, 'res', 'mipmap-anydpi-v26')
if os.path.exists(old_mipmap) and not os.path.exists(v26_mipmap):
    shutil.move(old_mipmap, v26_mipmap)
    print("Moved mipmap-anydpi to mipmap-anydpi-v26")

yml_path = os.path.join(res_dir, 'apktool.yml')
if os.path.exists(yml_path):
    with open(yml_path, 'r', encoding='utf-8') as f:
        yml = f.read()
    yml = yml.replace("minSdkVersion: '26'", "minSdkVersion: '24'").replace("minSdkVersion: 26", "minSdkVersion: 24")
    with open(yml_path, 'w', encoding='utf-8') as f:
        f.write(yml)

# 4. Build apktool_res.apk
print("Building resources with apktool...")
p_build = subprocess.run([jd, '-jar', apktool, 'b', res_dir, '-o', out_apk], capture_output=True, text=True)
if p_build.returncode != 0:
    print("Build error:", p_build.stderr)
    raise RuntimeError("apktool build failed")

print("Apktool built:", out_apk, f"({os.path.getsize(out_apk):,} bytes)")

with zipfile.ZipFile(out_apk) as z:
    info = z.getinfo('resources.arsc')
    print(f"resources.arsc size: {info.file_size:,} bytes")

print("SUCCESS: resources rebuilt successfully!")
