import difflib

old_file = 'app_sources/sources/com/magneticchen/daijishou/google_drive/GoogleDrive.java'
new_file = 'build_tmp/jadx_1.8.1_clean/sources/com/magneticchen/daijishou/features/GoogleDrive.java'

with open(old_file, encoding='utf-8') as f1, open(new_file, encoding='utf-8') as f2:
    lines1 = f1.readlines()
    lines2 = f2.readlines()

print(f"GoogleDrive: old lines={len(lines1)}, new lines={len(lines2)}")

# Check methods
def get_methods(lines):
    methods = []
    for l in lines:
        if 'public ' in l or 'private ' in l:
            if '(' in l and ')' in l and '{' in l:
                methods.append(l.strip())
    return methods

old_m = get_methods(lines1)
new_m = get_methods(lines2)
print(f"Methods: old={len(old_m)}, new={len(new_m)}")
diff = list(difflib.unified_diff(old_m, new_m))
print("Method diff:")
for d in diff:
    print(d)
