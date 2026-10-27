import re
from collections import defaultdict

with open("build_tmp/test_181_clean_javac_err.log", encoding="utf-8") as f:
    lines = f.readlines()

errors_by_file = defaultdict(list)
for line in lines:
    m = re.match(r'^(.*\.java):(\d+): error: (.*)$', line.strip())
    if m:
        file_path, line_no, msg = m.groups()
        file_name = file_path.split("sources\\com\\magneticchen\\daijishou\\")[-1]
        errors_by_file[file_name].append((line_no, msg))

for fname in sorted(errors_by_file.keys(), key=lambda k: len(errors_by_file[k])):
    errs = errors_by_file[fname]
    print(f"\n==========================================")
    print(f"{fname} ({len(errs)} errors)")
    print(f"==========================================")
    for lno, msg in errs[:10]:
        print(f"  Line {lno}: {msg}")
