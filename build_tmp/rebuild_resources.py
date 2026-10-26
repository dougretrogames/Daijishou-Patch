import os, subprocess, shutil, zipfile

jd = r'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin\java.exe'
apktool = r'tools\apktool_2.11.1.jar'
orig_apk = 'Daijishou v1.5.0.apk'
res_dir = 'build_tmp/apktool_res'
out_apk = 'build_tmp/apktool_res.apk'

# 1. Decode resources if not already decoded
if not os.path.exists(res_dir):
    print("Decoding resources from original APK...")
    p = subprocess.run([jd, '-jar', apktool, 'd', '-s', '-f', orig_apk, '-o', res_dir], capture_output=True, text=True)
    if p.returncode != 0:
        print("Decode error:", p.stderr)
        raise RuntimeError("apktool decode failed")
    print("Decode complete.")

# 2. Copy modified strings.xml from jadx-1.5.6/resources/res/ to apktool_res/res/
print("Syncing translated strings.xml...")
src_res = os.path.join('jadx-1.5.6', 'resources', 'res')
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

# 3. Build apktool_res.apk
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
