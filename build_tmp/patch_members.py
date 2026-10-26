import os, re, json

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
COMP = os.path.join(BASE, 'build_tmp', 'smali_compiled')

mren = json.load(open(os.path.join(BASE, 'build_tmp', 'member_renames.json')))

# lookup: (class, kind, name, desc) -> jadx name
lookup = {}
for cls, lst in mren.items():
    for kind, orig, desc, jadx in lst:
        lookup[(cls, kind, orig, desc)] = jadx

SKIP = set()
# suspend-lambda shim: keep original invokeSuspend when super stays SuspendLambda
for cls, lst in mren.items():
    for kind, orig, desc, jadx in lst:
        if orig == 'invokeSuspend' and jadx == 'invokeSuspendImpl':
            SKIP.add((cls, kind, orig, desc))

# identify original-derived files: differing from compiled counterpart
patched = []
for dirpath, _, files in os.walk(RECON):
    for fn in files:
        if not fn.endswith('.smali'):
            continue
        full = os.path.join(dirpath, fn)
        rel = os.path.relpath(full, RECON).replace('\\', '/')
        cls = rel[:-6]
        if not cls.startswith('com/magneticchen/daijishou'):
            continue
        cpath = os.path.join(COMP, *cls.split('/')) + '.smali'
        r = open(full, 'r', encoding='utf-8', errors='replace').read()
        if not os.path.exists(cpath):
            patched.append(cls)
            continue
        c = open(cpath, 'r', encoding='utf-8', errors='replace').read()
        if r != c:
            patched.append(cls)

print('original-derived files:', len(patched))

decl_m = re.compile(r'^(\.method\s+(?:[^\n]*?\s)?)([A-Za-z_$<][\w$<>]*)\(')
decl_f = re.compile(r'^(\.field\s+(?:[^\n]*?\s)?)([A-Za-z_$][\w$]*):(\S+?)(?:\s*=.*)?\s*$')
ref_m = re.compile(r'(L(com/magneticchen/daijishou/[\w$]+(?:/[\w$]+)*);)->([A-Za-z_$<][\w$<>]*)(\((?:[^()]|\([^()]*\))*\)\S+)')
ref_f = re.compile(r'(L(com/magneticchen/daijishou/[\w$]+(?:/[\w$]+)*);)->([A-Za-z_$][\w$]*):(\S+?)(?=[\s,\n]|$)')

changed_files = 0
changed_members = 0


def fix_method_decl(line, cls):
    m = decl_m.match(line)
    if not m:
        return line, False
    name = m.group(2)
    rest = line[m.end(2):]
    pm = re.match(r'\(([^)]*)\)(\S+)', rest)
    if not pm:
        return line, False
    desc = '(' + pm.group(1) + ')' + pm.group(2)
    key = (cls, 'm', name, desc)
    if key in lookup and key not in SKIP:
        return line[:m.start(2)] + lookup[key] + line[m.end(2):], True
    return line, False


def fix_field_decl(line, cls):
    m = decl_f.match(line)
    if not m:
        return line, False
    name = m.group(2)
    desc = m.group(3)
    key = (cls, 'f', name, desc)
    if key in lookup:
        return line[:m.start(2)] + lookup[key] + line[m.end(2):], True
    return line, False


def fix_refs(line):
    out = []
    n = 0

    def sub_m(mm):
        nonlocal n
        cls = mm.group(2)
        name = mm.group(3)
        desc = mm.group(4)
        desc = re.sub(r'\s+', '', desc)
        key = (cls, 'm', name, desc)
        if key in lookup and key not in SKIP:
            n += 1
            return 'L' + cls + ';->' + lookup[key] + desc
        return mm.group(0)

    def sub_f(mm):
        nonlocal n
        cls = mm.group(2)
        name = mm.group(3)
        desc = mm.group(4).strip()
        key = (cls, 'f', name, desc)
        if key in lookup:
            n += 1
            return 'L' + cls + ';->' + lookup[key] + ':' + desc
        return mm.group(0)

    line = ref_m.sub(sub_m, line)
    line = ref_f.sub(sub_f, line)
    return line, n


for cls in patched:
    p = os.path.join(RECON, *cls.split('/')) + '.smali'
    text = open(p, 'r', encoding='utf-8', errors='replace').read()
    lines = text.split('\n')
    out = []
    local = 0
    for line in lines:
        new, c1 = fix_method_decl(line, cls)
        if not c1:
            new, c2 = fix_field_decl(line, cls)
        else:
            c2 = False
        new2, c3 = fix_refs(new)
        if c1 or c2 or c3:
            local += 1
        out.append(new2)
    if local:
        with open(p, 'w', encoding='utf-8', newline='\n') as fh:
            fh.write('\n'.join(out))
        changed_files += 1
        changed_members += local

print('files updated:', changed_files, 'member occurrences updated:', changed_members)
json.dump(patched, open(os.path.join(BASE, 'build_tmp', 'patched_classes.json'), 'w'), indent=0)
