import re

with open("build_tmp/test_181_javac_err.log", encoding="utf-8") as f:
    text = f.read()

# Find all "cannot find symbol"
symbols = set()
for m in re.finditer(r'cannot find symbol\s+symbol:\s+([^\n]+)\s+location:\s+([^\n]+)', text):
    sym = m.group(1).strip()
    loc = m.group(2).strip()
    symbols.add((sym, loc))

print("=== Cannot find symbol ===")
for sym, loc in sorted(symbols):
    print(f"  {sym} in {loc}")

# Find all "package ... does not exist"
pkgs = set()
for m in re.finditer(r'package ([^\s]+) does not exist', text):
    pkgs.add(m.group(1))

print("\n=== Missing Packages ===")
for p in sorted(pkgs):
    print(f"  {p}")
