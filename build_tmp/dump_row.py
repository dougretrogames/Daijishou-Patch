import re, sys

sys.stdout.reconfigure(errors='replace')
path = sys.argv[1]
y = int(sys.argv[2])
x = open(path, encoding='utf-8').read()
for m in re.finditer(r'<node[^>]*>', x):
    tag = m.group(0)
    b = re.search(r'bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', tag)
    if not b:
        continue
    x1, y1, x2, y2 = map(int, b.groups())
    if not (y1 <= y <= y2):
        continue
    t = re.search(r'text="([^"]*)"', tag)
    c = re.search(r'class="([^"]*)"', tag)
    ck = re.search(r'clickable="([^"]*)"', tag)
    print((t.group(1) if t else '')[:50], '|', c.group(1) if c else '', '| clickable', ck.group(1) if ck else '?', '|', b.group(0))
