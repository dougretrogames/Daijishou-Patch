import re

with open("build_tmp/test_181_javac_err.log", encoding="utf-8") as f:
    lines = f.readlines()

errors = []
for line in lines:
    m = re.match(r'^(.*\.java):(\d+): error: (.*)$', line.strip())
    if m:
        errors.append((m.group(1), m.group(2), m.group(3)))

print(f"Total parsed errors: {len(errors)}")

# Group by error message prefix
groups = {}
for path, lno, msg in errors:
    # simplify
    prefix = msg
    if "is already defined in" in msg:
        prefix = "method X is already defined in Y"
    elif "cannot find symbol" in msg:
        prefix = "cannot find symbol: " + msg.split("symbol:")[-1] if "symbol:" in msg else "cannot find symbol"
    elif "package" in msg and "does not exist" in msg:
        prefix = "package X does not exist"
    elif "cannot be accessed from outside package" in msg:
        prefix = "class X is not public / cannot be accessed from outside package"
    elif "should be declared in a file named" in msg:
        prefix = "class X is public, should be declared in file named X.java"
    elif "non-static class" in msg:
        prefix = "non-static class cannot be referenced from static context"
    
    groups.setdefault(prefix, []).append((path, lno, msg))

for pfx, lst in sorted(groups.items(), key=lambda x: len(x[1]), reverse=True):
    print(f"\n--- [{len(lst)}] {pfx} ---")
    for path, lno, msg in lst[:5]:
        rel = path.split("sources\\com\\magneticchen\\daijishou\\")[-1]
        print(f"  {rel}:{lno} -> {msg}")
