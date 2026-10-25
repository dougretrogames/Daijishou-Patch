import os, re, json, sys

BASE = r'C:\Users\Douglas\Documents\Daijishou'
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
APP = 'com/magneticchen/daijishou'

LIB_ROOTS = [os.path.join(BASE, x) for x in ('smali', 'smali_classes3', 'smali_classes5', 'smali_classes6')]
PLATFORM = ('java/', 'javax/', 'android/', 'dalvik/', 'sun/', 'libcore/', 'org/apache/', 'org/json/', 'org/w3c/', 'org/xml/', 'com/android/internal/')

lib_index = {}
for root in LIB_ROOTS:
    if not os.path.isdir(root):
        continue
    for dirpath, _, fs in os.walk(root):
        for fn in fs:
            if not fn.endswith('.smali'):
                continue
            full = os.path.join(dirpath, fn)
            rel = os.path.relpath(full, root).replace('\\', '/')[:-6]
            lib_index.setdefault(rel, full)
print('library classes indexed:', len(lib_index))

cls_re = re.compile(r'^\.class\s+(.*?)(L[^\s;]+;)\s*$')
sup_re = re.compile(r'^\.super\s+(L[^\s;]+;)')
imp_re = re.compile(r'^\.implements\s+(L[^\s;]+;)')
meth_re = re.compile(r'^\.method\s+(.*?)([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)\s*$')
fld_re = re.compile(r'^\.field\s+(.*?)([A-Za-z_$][\w$]*):(\S+?)(?:\s*=.*)?\s*$')
ref_m = re.compile(r'L([\w/$]+);->([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)')
ref_f = re.compile(r'L([\w/$]+);->([A-Za-z_$][\w$]*):(\S+?)(?=[\s,\n]|$)')


def parse_file(full):
    name = sup = None
    imps = []
    methods = set()
    fields = set()
    for line in open(full, 'r', encoding='utf-8', errors='replace'):
        if line.startswith('.class '):
            m = cls_re.match(line.rstrip('\n'))
            if m:
                name = m.group(2)[1:-1]
        elif line.startswith('.super '):
            m = sup_re.match(line)
            if m:
                sup = m.group(1)[1:-1]
        elif line.startswith('.implements '):
            m = imp_re.match(line)
            if m:
                imps.append(m.group(1)[1:-1])
        elif line.startswith('.method '):
            m = meth_re.match(line.rstrip('\n'))
            if m:
                methods.add((m.group(2), '(' + m.group(3) + ')' + m.group(4)))
        elif line.startswith('.field '):
            m = fld_re.match(line.rstrip('\n'))
            if m:
                fields.add((m.group(2), m.group(3)))
    return name, sup, imps, methods, fields

classes = {}
files = {}
for dirpath, _, fs in os.walk(RECON):
    for fn in fs:
        if not fn.endswith('.smali'):
            continue
        full = os.path.join(dirpath, fn)
        name, sup, imps, methods, fields = parse_file(full)
        if name:
            classes[name] = (sup, imps, methods, fields)
            files[name] = full

app = {k: v for k, v in classes.items() if k.startswith(APP)}
print('app classes in recon:', len(app))

UNKNOWN = object()


def lookup(cls):
    if cls in classes:
        return classes[cls]
    p = lib_index.get(cls)
    if not p:
        return UNKNOWN
    name, sup, imps, methods, fields = parse_file(p)
    classes[cls] = (sup, imps, methods, fields)
    return classes[cls]


def resolve(cls, name, desc, is_field, seen=None):
    """returns 'found', 'missing', or 'unknown'"""
    seen = seen or set()
    unknown = False
    while cls and cls not in seen:
        seen.add(cls)
        got = lookup(cls)
        if got is UNKNOWN:
            if cls.startswith(PLATFORM) or cls in ('java/lang/Object',):
                return 'unknown' if cls != 'java/lang/Object' else ('found' if name == '<init>' else 'missing')
            return 'unknown'
        sup, imps, ms, fs = got
        if (name, desc) in (fs if is_field else ms):
            return 'found'
        for i in imps:
            r = resolve(i, name, desc, is_field, seen)
            if r == 'found':
                return 'found'
            if r == 'unknown':
                unknown = True
        cls = sup
    return 'unknown' if unknown else 'missing'


missing_m = {}
missing_f = {}
unknown_m = set()
unknown_f = set()
for cls in app:
    full = files[cls]
    for lineno, line in enumerate(open(full, 'r', encoding='utf-8', errors='replace'), 1):
        line = line.split('#', 1)[0]
        if '->' not in line:
            continue
        for m in ref_m.finditer(line):
            target = m.group(1)
            if not target.startswith(APP):
                continue
            name = m.group(2)
            desc = '(' + m.group(3) + ')' + m.group(4)
            r = resolve(target, name, desc, False)
            if r == 'missing':
                missing_m.setdefault((target, name, desc), []).append(cls + ':' + str(lineno))
            elif r == 'unknown':
                unknown_m.add((target, name, desc))
        for m in ref_f.finditer(line):
            target = m.group(1)
            if not target.startswith(APP):
                continue
            name = m.group(2)
            typ = m.group(3).strip()
            r = resolve(target, name, typ, True)
            if r == 'missing':
                missing_f.setdefault((target, name, typ), []).append(cls + ':' + str(lineno))
            elif r == 'unknown':
                unknown_f.add((target, name, typ))

print('missing method refs:', len(missing_m), 'sites:', sum(len(v) for v in missing_m.values()), '| unknown:', len(unknown_m))
print('missing field refs:', len(missing_f), 'sites:', sum(len(v) for v in missing_f.values()), '| unknown:', len(unknown_f))
print()
for (t, n, d), sites in sorted(missing_m.items()):
    print('M', t, '->', n + d, '| sites', len(sites), '| e.g.', sites[0])
print()
for (t, n, ty), sites in sorted(missing_f.items()):
    print('F', t, '->', n + ':' + ty, '| sites', len(sites), '| e.g.', sites[0])

json.dump({'methods': [list(k) + [len(v), v[:6]] for k, v in missing_m.items()],
           'fields': [list(k) + [len(v), v[:6]] for k, v in missing_f.items()],
           'unknown_methods': [list(k) for k in unknown_m],
           'unknown_fields': [list(k) for k in unknown_f]},
          open(os.path.join(BASE, 'build_tmp', 'missing_refs.json'), 'w'), indent=0)
