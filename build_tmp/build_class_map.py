import os, re, json

ROOT = r'C:\Users\Douglas\Documents\Daijishou\jadx_nest\sources\com\magneticchen\daijishou'
renamed_re = re.compile(r'/\* JADX INFO: renamed from: ([^,\s]+), reason:')
class_re = re.compile(r'\b(?:class|interface|enum)\s+([A-Za-z_$][\w$]*)')
stub_re = re.compile(r'Method not decompiled: ([A-Za-z0-9_$.]+)\.[A-Za-z_$][\w$]*\(')

mapping = {}


def scan(path):
    src = open(path, 'r', encoding='utf-8', errors='replace').read()
    pkgm = re.search(r'^package ([^;]+);', src, re.M)
    pkg = pkgm.group(1) if pkgm else ''
    classes = []
    i, n = 0, len(src)
    stack = []
    pending = []
    depth = 0
    while i < n:
        if src.startswith('/*', i):
            end = src.find('*/', i + 2)
            if end < 0:
                end = n - 2
            seg = src[i:end + 2]
            m = renamed_re.search(seg)
            if m:
                pending.append(m.group(1))
            i = end + 2
            continue
        if src.startswith('//', i):
            end = src.find('\n', i)
            i = n if end < 0 else end + 1
            continue
        ch = src[i]
        if ch == '"' or ch == "'":
            q = ch
            j = i + 1
            while j < n:
                if src[j] == '\\':
                    j += 2
                    continue
                if src[j] == q:
                    j += 1
                    break
                j += 1
            i = j
            continue
        if ch == '{':
            depth += 1
            i += 1
            continue
        if ch == '}':
            depth -= 1
            if stack and stack[-1][2] == depth:
                name, _, _, start = stack.pop()
                classes.append((name, start, i))
            i += 1
            continue
        m = class_re.match(src, i)
        if m and (i == 0 or not (src[i - 1].isalnum() or src[i - 1] in '_$.')):
            simple = m.group(1)
            jadx = (pkg + '.' if pkg else '') + '$'.join([s[1] for s in stack] + [simple])
            if pending:
                for orig in pending:
                    if '.' in orig:
                        mapping[orig.replace('.', '/')] = jadx.replace('.', '/')
                pending = []
            stack.append((jadx, simple, depth, i))
            i = m.end()
            continue
        i += 1
    return src, classes


stubs = {}
for dirpath, _, files in os.walk(ROOT):
    for fn in files:
        if not fn.endswith('.java'):
            continue
        path = os.path.join(dirpath, fn)
        src, classes = scan(path)
        for m in stub_re.finditer(src):
            pos = m.start()
            best = None
            for name, s, e in classes:
                if s <= pos <= e:
                    if best is None or (e - s) < (best[2] - best[1]):
                        best = (name, s, e)
            if best is None:
                continue
            jadx = best[0].replace('.', '/')
            if jadx.startswith('com/magneticchen/daijishou'):
                stubs[jadx] = stubs.get(jadx, 0) + 1

inv = {}
for orig, jadx in mapping.items():
    inv.setdefault(jadx, orig)

print('mapped:', len(mapping))
print('stub classes:', len(stubs), 'methods:', sum(stubs.values()))

base = r'C:\Users\Douglas\Documents\Daijishou\smali_orig_app'
miss = []
for j in stubs:
    o = inv.get(j, j)
    if not os.path.exists(os.path.join(base, o + '.smali')):
        miss.append((j, o))
print('stub classes missing original smali:', len(miss))
for m in miss[:10]:
    print(' ', m)
json.dump({'map': mapping, 'inv': inv, 'stubs': stubs}, open(r'C:\Users\Douglas\Documents\Daijishou\build_tmp\class_map.json', 'w'), indent=0)
