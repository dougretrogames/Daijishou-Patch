import os, re

base_dir = r"build_tmp/jadx_1.8.1_clean/sources/com/magneticchen/daijishou"
duplicate_outer_files = []

for root, dirs, files in os.walk(base_dir):
    for f in files:
        if f.endswith('.java') and '$' in f:
            full_path = os.path.join(root, f)
            with open(full_path, 'r', encoding='utf-8', errors='replace') as fp:
                content = fp.read()
            m = re.search(r'public\s+(?:final\s+|abstract\s+)?(?:class|interface|enum)\s+([A-Za-z0-9_]+)', content)
            if m:
                cls_name = m.group(1)
                expected = cls_name + '.java'
                if '$' not in cls_name:
                    # It declared an outer class inside an inner class file!
                    duplicate_outer_files.append((os.path.relpath(full_path, base_dir), f, cls_name))

print(f"Total files declaring outer class inside $ file: {len(duplicate_outer_files)}")
for rel, f, cls in duplicate_outer_files:
    print(f"  {rel} -> declared {cls}")
