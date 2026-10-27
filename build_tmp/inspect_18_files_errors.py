import re
from collections import defaultdict

with open("build_tmp/test_181_default_javac_err.log", encoding="utf-8") as f:
    lines = f.readlines()

errors_by_file = defaultdict(list)
for line in lines:
    m = re.match(r'^(.*\.java):(\d+): error: (.*)$', line.strip())
    if m:
        file_path, line_no, msg = m.groups()
        file_name = file_path.split("sources\\com\\magneticchen\\daijishou\\")[-1]
        errors_by_file[file_name].append((int(line_no), msg))

for fname in sorted(errors_by_file.keys(), key=lambda k: len(errors_by_file[k])):
    errs = errors_by_file[fname]
    print(f"\n==========================================")
    print(f"{fname} ({len(errs)} errors)")
    print(f"==========================================")
    # categorize within this file
    cat = defaultdict(int)
    for lno, msg in errs:
        cat[msg.split(':')[0]] += 1
    for c, cnt in sorted(cat.items(), key=lambda x: x[1], reverse=True):
        print(f"   [{cnt}] {c}")
