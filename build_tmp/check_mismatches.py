import os, re

base_dir = r"build_tmp/jadx_1.8.1_no_inline/sources/com/magneticchen/daijishou"
mismatches = []

for root, dirs, files in os.walk(base_dir):
    for f in files:
        if f.endswith('.java'):
            full_path = os.path.join(root, f)
            with open(full_path, 'r', encoding='utf-8', errors='replace') as fp:
                content = fp.read()
            # Match top-level public class/interface/enum
            m = re.search(r'public\s+(?:final\s+|abstract\s+)?(?:class|interface|enum|@interface)\s+([A-Za-z0-9_$]+)', content)
            if m:
                cls_name = m.group(1)
                expected_fname = cls_name + '.java'
                if expected_fname != f:
                    mismatches.append((os.path.relpath(full_path, base_dir), f, expected_fname, cls_name))

print(f"Total filename mismatches: {len(mismatches)}")
for rel, f, exp, cls in mismatches:
    print(f"File: {f} -> Expected: {exp} (Class: {cls})")
