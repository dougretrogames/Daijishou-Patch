import re
from collections import defaultdict

with open("build_tmp/test_181_javac_err.log", encoding="utf-8") as f:
    lines = f.readlines()

errors_by_file = defaultdict(list)
error_patterns = defaultdict(int)

current_file = None
current_line_no = None

for line in lines:
    m = re.match(r'^(.*\.java):(\d+): error: (.*)$', line.strip())
    if m:
        file_path, line_no, msg = m.groups()
        file_name = file_path.split("sources\\com\\magneticchen\\daijishou\\")[-1]
        errors_by_file[file_name].append((line_no, msg))
        # generalize msg
        gen_msg = re.sub(r'\'[^\']*\'', "''", msg)
        gen_msg = re.sub(r'package [^\s]+', "package ...", gen_msg)
        error_patterns[gen_msg] += 1

print(f"Total error lines: {sum(len(v) for v in errors_by_file.values())}")
print(f"Total distinct files with errors: {len(errors_by_file)}")
print("\nTop error categories:")
for pattern, count in sorted(error_patterns.items(), key=lambda x: x[1], reverse=True)[:20]:
    print(f"  [{count}] {pattern}")

print("\nFiles with most errors:")
for fname, errs in sorted(errors_by_file.items(), key=lambda x: len(x[1]), reverse=True)[:15]:
    print(f"  {fname}: {len(errs)} errors")
