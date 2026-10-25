import os, re, json, collections

BASE = r'C:\Users\Douglas\Documents\Daijishou'
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
COMP = os.path.join(BASE, 'build_tmp', 'smali_compiled')
ORIG = os.path.join(BASE, 'smali_orig_app')

cm = json.load(open(os.path.join(BASE, 'build_tmp', 'class_map.json')))
stubs = cm['stubs']
inv = cm['inv']

mre = re.compile(r'\.method\s+(.*?)([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)')
fre = re.compile(r'\.field\s+(.*?)([A-Za-z_$][\w$]*):(\S+)')


def parse(path):
    ms, fs = {}, {}
    if not os.path.exists(path):
        return ms, fs
    for line in open(path, 'r', encoding='utf-8', errors='replace'):
        s = line.strip()
        if s.startswith('.method '):
            m = mre.match(s)
            if m:
                ms[(m.group(2), '(' + m.group(3) + ')' + m.group(4))] = m.group(1).strip()
        elif s.startswith('.field '):
            m = fre.match(s)
            if m:
                fs[(m.group(2), m.group(3))] = m.group(1).strip()
    return ms, fs


def p(root, cls):
    return os.path.join(root, *cls.split('/')) + '.smali'


rows = []
for cls in sorted(stubs):
    orig_cls = inv.get(cls, cls)
    rm, rf = parse(p(RECON, cls))
    om, of = parse(p(ORIG, orig_cls))
    cmm, cf = parse(p(COMP, cls))
    miss_m = [k for k in cmm if k not in rm]
    miss_f = [k for k in cf if k not in rf]
    if not miss_m and not miss_f:
        continue
    rows.append((cls, orig_cls, miss_m, miss_f, om, of, len(rm), len(cmm)))

print('stub classes with missing compiled members:', len(rows), 'of', len(stubs))
tot_m = sum(len(r[2]) for r in rows)
tot_f = sum(len(r[3]) for r in rows)
print('missing methods:', tot_m, 'missing fields:', tot_f)
for cls, oc, mm, mf, om, of, nr, nc in rows:
    print('==', cls, '(orig', oc + ')')
    print('   recon m/f:', nr, 'compiled m:', nc)
    for name, desc in mm:
        cands = [n for (n, d) in om if d == desc]
        exact = name in cands
        print('   missM', name + desc, '| exact' if exact else '| cands ' + str(cands)[:200])
    for name, typ in mf:
        cands = [n for (n, t) in of if t == typ]
        print('   missF', name + ':' + typ, '| cands', cands[:6])
