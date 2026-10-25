import re, sys

sys.stdout.reconfigure(errors='replace')
path = sys.argv[1]
x = open(path, encoding='utf-8').read()
for m in re.finditer(r'<node[^>]*>', x):
    tag = m.group(0)
    t = re.search(r'text="([^"]*)"', tag)
    b = re.search(r'bounds="([^"]*)"', tag)
    c = re.search(r'class="([^"]*)"', tag)
    d = re.search(r'content-desc="([^"]*)"', tag)
    if t and t.group(1).strip():
        print(repr(t.group(1)), b.group(1) if b else '', c.group(1) if c else '')
    elif d and d.group(1).strip():
        print('[desc]', repr(d.group(1)), b.group(1) if b else '', c.group(1) if c else '')
