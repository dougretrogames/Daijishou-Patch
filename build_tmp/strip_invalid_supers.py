import os, re

base_dir = r"build_tmp/sources_181_merged/com/magneticchen/daijishou"
count = 0

for root, dirs, files in os.walk(base_dir):
    for f in files:
        if f.endswith('.java'):
            p = os.path.join(root, f)
            with open(p, 'r', encoding='utf-8', errors='replace') as fp:
                c = fp.read()
            new_c = re.sub(r'\{\s*super\(\d+\);\s*\}', '', c)
            if new_c != c:
                with open(p, 'w', encoding='utf-8') as fp:
                    fp.write(new_c)
                count += 1

print(f"Removed invalid super(N) across {count} files!")
