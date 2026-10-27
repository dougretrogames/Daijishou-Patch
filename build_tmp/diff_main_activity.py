import difflib

f1_path = 'app_sources/sources/com/magneticchen/daijishou/activities/MainActivity.java'
f2_path = 'build_tmp/jadx_1.8.1_default/sources/com/magneticchen/daijishou/ui/activities/MainActivity.java'

with open(f1_path, encoding='utf-8', errors='replace') as f1, \
     open(f2_path, encoding='utf-8', errors='replace') as f2:
    lines1 = f1.readlines()
    lines2 = f2.readlines()

print(f"MainActivity 1.5.0: {len(lines1)} lines")
print(f"MainActivity 1.8.1: {len(lines2)} lines")
