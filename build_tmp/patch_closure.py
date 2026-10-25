import os, re, json

BASE = r'C:\Users\Douglas\Documents\Daijishou'
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
ORIG = os.path.join(BASE, 'smali_orig_app')

d = json.load(open(os.path.join(BASE, 'build_tmp', 'class_map.json')))
mapping = d['map']     # original internal -> jadx internal
inv = d['inv']         # jadx internal -> original internal
stubs = d['stubs']

ref_re = re.compile(r'L(com/magneticchen/daijishou/[\w$]+(?:/[\w$]+)*);')


def path_of(root, name):
    return os.path.join(root, *name.split('/')) + '.smali'


recon = set()
for dirpath, _, files in os.walk(RECON):
    for fn in files:
        if fn.endswith('.smali'):
            full = os.path.join(dirpath, fn)
            rel = os.path.relpath(full, RECON).replace('\\', '/')[:-6]
            recon.add(rel)

print('recon classes:', len(recon))

queue = []
for jadx in stubs:
    queue.append(jadx)

copied = []
added = []

while queue:
    jadx = queue.pop()
    p = path_of(RECON, jadx)
    if not os.path.exists(p):
        continue
    text = open(p, 'r', encoding='utf-8').read()
    for m in ref_re.finditer(text):
        ref = m.group(1)
        target = mapping.get(ref, ref)
        if target in recon:
            continue
        orig_path = path_of(ORIG, ref)
        if not os.path.exists(orig_path):
            continue
        src = open(orig_path, 'r', encoding='utf-8').read()
        src = ref_re.sub(lambda mm: 'L' + mapping.get(mm.group(1), mm.group(1)) + ';', src)
        dst = path_of(RECON, target)
        os.makedirs(os.path.dirname(dst), exist_ok=True)
        with open(dst, 'w', encoding='utf-8', newline='\n') as fh:
            fh.write(src)
        recon.add(target)
        copied.append((target, ref))
        queue.append(target)

print('copied missing classes:', len(copied))
for t, o in copied:
    print('  ', o, '->', t)
