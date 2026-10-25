import os, re, subprocess

root = r'C:\Users\Douglas\Documents\Daijishou\jadx_nest\sources\com\magneticchen\daijishou'

starts = {}
for dp, _, fns in os.walk(root):
    for fn in fns:
        if not fn.endswith('.java'):
            continue
        p = os.path.join(dp, fn)
        s = open(p, encoding='utf-8', errors='replace').read()
        for m in re.findall(r'startWith = "([^"]+)"', s):
            starts.setdefault(m, os.path.relpath(p, root))
for k in sorted(starts):
    print(repr(k), '->', starts[k])

print('== DaijishouUriHandler')
p = os.path.join(root, 'daijishou_uri', 'DaijishouUriHandler.java')
s = open(p, encoding='utf-8', errors='replace').read()
print(s[:4000])
