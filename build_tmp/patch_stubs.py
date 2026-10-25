import os, re, json

BASE = r'C:\Users\Douglas\Documents\Daijishou'
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
ORIG = os.path.join(BASE, 'smali_orig_app')

d = json.load(open(os.path.join(BASE, 'build_tmp', 'class_map.json')))
mapping = d['map']          # original internal -> jadx internal
inv = d['inv']              # jadx internal -> original internal
stubs = d['stubs']          # jadx internal -> count

ref_re = re.compile(r'L([\w$]+(?:/[\w$]+)*);')

patched = 0
missing = []
for jadx in sorted(stubs):
    orig = inv.get(jadx, jadx)
    src_path = os.path.join(ORIG, *orig.split('/')) + '.smali'
    dst_path = os.path.join(RECON, *jadx.split('/')) + '.smali'
    if not os.path.exists(src_path):
        missing.append((jadx, orig))
        continue
    with open(src_path, 'r', encoding='utf-8') as fh:
        text = fh.read()

    def sub(m):
        name = m.group(1)
        return 'L' + mapping.get(name, name) + ';'

    text = ref_re.sub(sub, text)
    if not os.path.exists(os.path.dirname(dst_path)):
        missing.append((jadx, orig))
        continue
    with open(dst_path, 'w', encoding='utf-8', newline='\n') as fh:
        fh.write(text)
    patched += 1

print('stub classes:', len(stubs))
print('patched:', patched)
print('missing:', len(missing))
for m in missing:
    print('  ', m)

if os.environ.get('NO_ORIG', '1') == '1' and len(stubs) > 0:
    raise RuntimeError(f"FALHA [No-Orig]: {len(stubs)} classes-stub ainda estao ativas no pipeline!")
