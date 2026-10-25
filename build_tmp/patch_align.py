import os, re, json, sys

BASE = r'C:\Users\Douglas\Documents\Daijishou'
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
COMP = os.path.join(BASE, 'build_tmp', 'smali_compiled')
ORIG = os.path.join(BASE, 'smali_orig_app')

cmap = json.load(open(os.path.join(BASE, 'build_tmp', 'class_map.json')))
stubs = cmap['stubs']
inv = cmap['inv']
mapping = cmap['map']
mren = json.load(open(os.path.join(BASE, 'build_tmp', 'member_renames.json')))
patched = json.load(open(os.path.join(BASE, 'build_tmp', 'patched_classes.json')))
APP = 'com/magneticchen/daijishou'

LIB_ROOTS = [os.path.join(BASE, x) for x in ('smali', 'smali_classes3', 'smali_classes4', 'smali_classes5', 'smali_classes6')]
PLATFORM = ('java/', 'javax/', 'android/', 'dalvik/', 'sun/', 'libcore/', 'org/apache/', 'org/json/', 'org/w3c/', 'org/xml/', 'com/android/internal/')

lib_index = {}
for root in LIB_ROOTS:
    if not os.path.isdir(root):
        continue
    for dirpath, _, fs in os.walk(root):
        for fn in fs:
            if fn.endswith('.smali'):
                full = os.path.join(dirpath, fn)
                rel = os.path.relpath(full, root).replace('\\', '/')[:-6]
                lib_index.setdefault(rel, full)

cls_re = re.compile(r'^\.class\s+(.*?)(L[^\s;]+;)\s*$')
sup_re = re.compile(r'^\.super\s+(L[^\s;]+;)')
imp_re = re.compile(r'^\.implements\s+(L[^\s;]+;)')
meth_re = re.compile(r'^\.method\s+(.*?)([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)\s*$')
fld_re = re.compile(r'^\.field\s+(.*?)([A-Za-z_$][\w$]*):(\S+?)(?:\s*=.*)?\s*$')
ref_m = re.compile(r'L([\w/$]+);->([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)')
ref_f = re.compile(r'L([\w/$]+);->([A-Za-z_$][\w$]*):(\S+?)(?=[\s,\n]|$)')


def path_of(root, cls):
    return os.path.join(root, *cls.split('/')) + '.smali'


def parse_file(full):
    """Return dict with class info and member flags."""
    name = sup = None
    imps = []
    methods = {}
    fields = {}
    lines = open(full, 'r', encoding='utf-8', errors='replace').read().split('\n')
    for idx, line in enumerate(lines):
        if line.startswith('.class '):
            m = cls_re.match(line)
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
            m = meth_re.match(line)
            if m:
                methods[(m.group(2), '(' + m.group(3) + ')' + m.group(4))] = (m.group(1).strip(), idx)
        elif line.startswith('.field '):
            m = fld_re.match(line)
            if m:
                fields[(m.group(2), m.group(3))] = (m.group(1).strip(), idx)
    return {'name': name, 'super': sup, 'imps': imps, 'methods': methods, 'fields': fields, 'lines': lines}


def member_blocks(full):
    out = {}
    lines = open(full, 'r', encoding='utf-8', errors='replace').read().split('\n')
    i = 0
    while i < len(lines):
        s = lines[i].strip()
        if s.startswith('.method '):
            m = meth_re.match(s)
            if m:
                key = ('m', m.group(2), '(' + m.group(3) + ')' + m.group(4))
                j = i
                while j < len(lines) and not lines[j].strip().startswith('.end method'):
                    j += 1
                out[key] = '\n'.join(lines[i:j + 1])
                i = j + 1
                continue
        elif s.startswith('.field '):
            m = fld_re.match(s)
            if m:
                out[('f', m.group(2), m.group(3))] = lines[i]
        i += 1
    return out


# member renames from the original tree (orig name -> jadx name)
lookup = {}
for cls, lst in mren.items():
    for kind, orig, desc, jadx in lst:
        lookup[(cls, kind, orig, desc)] = jadx
SKIP_RENAME = {(c, k, o, d) for (c, k, o, d) in lookup if o == 'invokeSuspend'}


def rewrite_orig(block, cls):
    def sub_m(mm):
        c, name, desc = mm.group(1), mm.group(2), '(' + mm.group(3) + ')' + mm.group(4)
        key = (c, 'm', name, desc)
        if key in lookup and key not in SKIP_RENAME:
            return 'L' + c + ';->' + lookup[key] + desc
        return mm.group(0)

    def sub_f(mm):
        c, name, typ = mm.group(1), mm.group(2), mm.group(3).strip()
        key = (c, 'f', name, typ)
        if key in lookup:
            return 'L' + c + ';->' + lookup[key] + ':' + typ
        return mm.group(0)

    block = ref_m.sub(sub_m, block)
    block = ref_f.sub(sub_f, block)

    return re.sub(r'L([\w/$]+);', lambda mm: 'L' + mapping.get(mm.group(1), mm.group(1)) + ';', block)


state = {}
for cls in patched:
    p = path_of(RECON, cls)
    if os.path.exists(p):
        state[cls] = parse_file(p)
print('patched classes present:', len(state))

# ---------------------------------------------------------------- step 1: renames
renames = {}   # (cls, kind, old, desc) -> (new, compiled_flags)
for cls in sorted(state):
    st = state[cls]
    cp = path_of(COMP, cls)
    if not os.path.exists(cp):
        continue
    comp = parse_file(cp)
    for kind, rmap, cmapk in (('m', st['methods'], comp['methods']), ('f', st['fields'], comp['fields'])):
        comp_names = {k[0] for k in cmapk}
        for (cname, cdesc), (cflags, _) in cmapk.items():
            if (cname, cdesc) in rmap:
                continue
            if kind == 'm' and cname in ('<init>', '<clinit>'):
                continue
            if kind == 'm' and cname == 'invokeSuspendImpl' and ('invokeSuspend', cdesc) in rmap:
                continue
            if kind == 'm' and re.fullmatch(r'access\$\d+', cname):
                continue
            cands = [k for k in rmap if k[1] == cdesc and k[0] not in comp_names]
            pref = [k for k in cands if k[0] == cname + '$delegate']
            if pref:
                cands = pref
            else:
                non_acc = [k for k in cands if not k[0].startswith('access$')]
                if non_acc:
                    cands = non_acc
            if 'SplashScreenActivity$AnonymousClass1$AnonymousClass2' in cls:
                print('  DBG', cname + cdesc, 'cands=', cands)
            if len(cands) == 1:
                old = cands[0][0]
                if old == cname:
                    continue
                renames[(cls, kind, old, cdesc)] = (cname, cflags)

print('renames selected:', len(renames))
for k, v in list(renames.items())[:40]:
    print('  ', k, '->', v[0])

if renames:
    # apply declarations + references globally
    by_class = {}
    for (cls, kind, old, desc), (new, flags) in renames.items():
        by_class.setdefault((cls, kind, desc), []).append((old, new, flags))

    def fix_line(line, cur_cls):
        if line.startswith('.method '):
            m = meth_re.match(line)
            if m:
                desc = '(' + m.group(3) + ')' + m.group(4)
                for old, new, flags in by_class.get((cur_cls, 'm', desc), []):
                    if m.group(2) == old:
                        return '.method ' + flags + ' ' + new + desc
        elif line.startswith('.field '):
            m = fld_re.match(line)
            if m:
                for old, new, flags in by_class.get((cur_cls, 'f', m.group(3)), []):
                    if m.group(2) == old:
                        tail_start = line.find(':' + m.group(3)) + 1 + len(m.group(3))
                        return '.field ' + flags + ' ' + new + ':' + m.group(3) + line[tail_start:]
        return line

    def fix_refs(line):
        def sub_m(mm):
            c, name, desc = mm.group(1), mm.group(2), '(' + mm.group(3) + ')' + mm.group(4)
            for old, new, flags in by_class.get((c, 'm', desc), []):
                if name == old:
                    return 'L' + c + ';->' + new + desc
            return mm.group(0)

        def sub_f(mm):
            c, name, typ = mm.group(1), mm.group(2), mm.group(3).strip()
            for old, new, flags in by_class.get((c, 'f', typ), []):
                if name == old:
                    return 'L' + c + ';->' + new + ':' + typ
            return mm.group(0)

        return ref_f.sub(sub_f, ref_m.sub(sub_m, line))

    nfiles = 0
    for dirpath, _, fs in os.walk(RECON):
        for fn in fs:
            if not fn.endswith('.smali'):
                continue
            full = os.path.join(dirpath, fn)
            cur_cls = os.path.relpath(full, RECON).replace('\\', '/')[:-6]
            text = open(full, 'r', encoding='utf-8', errors='replace').read()
            lines = text.split('\n')
            out = [fix_refs(fix_line(l, cur_cls)) for l in lines]
            new = '\n'.join(out)
            if new != text:
                with open(full, 'w', encoding='utf-8', newline='\n') as fh:
                    fh.write(new)
                nfiles += 1
    print('files updated by renames:', nfiles)
    for cls in state:
        state[cls] = parse_file(path_of(RECON, cls))

json.dump({('%s|%s|%s|%s' % k): v for k, v in renames.items()},
          open(os.path.join(BASE, 'build_tmp', 'align_renames.json'), 'w'), indent=0)

# ---------------------------------------------------------------- step 2: injection
# full class index (recon + libraries) for reference resolution
classes = {}
def lookup_class(cls):
    if cls in classes:
        return classes[cls]
    p = path_of(RECON, cls)
    if not os.path.exists(p):
        p = lib_index.get(cls)
    if not p:
        return None
    st = parse_file(p)
    classes[cls] = st
    return st

for cls in state:
    classes[cls] = state[cls]


def resolve(cls, name, desc, is_field, seen=None):
    seen = seen or set()
    unknown = False
    while cls and cls not in seen:
        seen.add(cls)
        st = lookup_class(cls)
        if st is None:
            return 'unknown'
        if (name, desc) in (st['fields'] if is_field else st['methods']):
            return 'found'
        for i in st['imps']:
            r = resolve(i, name, desc, is_field, seen)
            if r == 'found':
                return 'found'
            if r == 'unknown':
                unknown = True
        cls = st['super']
    if unknown:
        return 'unknown'
    return 'missing'


blocks_cache = {}


def get_blocks(root, cls):
    key = (root, cls)
    if key not in blocks_cache:
        p = path_of(root, cls)
        blocks_cache[key] = member_blocks(p) if os.path.exists(p) else {}
    return blocks_cache[key]


def append_method(cls, key, block):
    p = path_of(RECON, cls)
    with open(p, 'a', encoding='utf-8', newline='\n') as fh:
        fh.write('\n' + block + '\n')


def insert_field(cls, line):
    p = path_of(RECON, cls)
    lines = open(p, 'r', encoding='utf-8', errors='replace').read().split('\n')
    pos = 0
    for i, l in enumerate(lines):
        if l.startswith('.field '):
            pos = i + 1
    if pos == 0:
        for i, l in enumerate(lines):
            if l.startswith('.method ') or l.startswith('.annotation '):
                pos = i
                break
    lines.insert(pos, line)
    with open(p, 'w', encoding='utf-8', newline='\n') as fh:
        fh.write('\n'.join(lines))


injected = []
for cls in sorted(state):
    st = state[cls]
    orig_cls = inv.get(cls, cls)
    comp = parse_file(path_of(COMP, cls)) if os.path.exists(path_of(COMP, cls)) else None
    if not comp:
        continue
    cb = get_blocks(COMP, cls)
    for kind, rmap, cmapk in (('m', st['methods'], comp['methods']), ('f', st['fields'], comp['fields'])):
        for key in cmapk:
            if key in rmap:
                continue
            name, desc = key
            if kind == 'm' and name == '<clinit>':
                continue
            if kind == 'm' and name == 'invokeSuspendImpl' and ('invokeSuspend', desc) in rmap:
                continue
            blk = cb.get((kind, name, desc))
            if blk is None:
                continue
            if kind == 'm':
                append_method(cls, key, blk)
                rmap[key] = (cmapk[key][0], -1)
            else:
                insert_field(cls, blk)
                rmap[key] = (cmapk[key][0], -1)
            injected.append((cls, kind, name, desc))
    state[cls] = parse_file(path_of(RECON, cls))
print('injected compiled members (bulk):', len(injected))

# ---------------------------------------------------------------- step 3: reference closure
for rnd in range(8):
    new = 0
    for dirpath, _, fs in os.walk(RECON):
        for fn in fs:
            if not fn.endswith('.smali'):
                continue
            full = os.path.join(dirpath, fn)
            src_cls = os.path.relpath(full, RECON).replace('\\', '/')[:-6]
            text = open(full, 'r', encoding='utf-8', errors='replace').read()
            scan = '\n'.join(l.split('#', 1)[0] for l in text.split('\n'))
            need = []
            for m in ref_m.finditer(scan):
                t = m.group(1)
                if not t.startswith(APP):
                    continue
                name = m.group(2)
                desc = '(' + m.group(3) + ')' + m.group(4)
                if resolve(t, name, desc, False) == 'found':
                    continue
                need.append(('m', t, name, desc))
            for m in ref_f.finditer(scan):
                t = m.group(1)
                if not t.startswith(APP):
                    continue
                name = m.group(2)
                typ = m.group(3).strip()
                if resolve(t, name, typ, True) == 'found':
                    continue
                need.append(('f', t, name, typ))
            for kind, t, name, desc in need:
                st = lookup_class(t)
                if st is None:
                    continue
                if (name, desc) in (st['fields'] if kind == 'f' else st['methods']):
                    continue
                blk = None
                src = None
                cb = get_blocks(COMP, t).get((kind, name, desc))
                if cb is not None:
                    blk, src = cb, 'comp'
                else:
                    oc = inv.get(t, t)
                    ob = get_blocks(ORIG, oc).get((kind, name, desc))
                    if ob is not None:
                        blk, src = rewrite_orig(ob, t), 'orig'
                if blk is None:
                    continue
                if kind == 'm':
                    append_method(t, (name, desc), blk)
                    st['methods'][(name, desc)] = ('', -1)
                else:
                    insert_field(t, blk)
                    st['fields'][(name, desc)] = ('', -1)
                new += 1
    print('closure round', rnd, 'injected', new)
    if new == 0:
        break

json.dump(injected, open(os.path.join(BASE, 'build_tmp', 'align_injected.json'), 'w'), indent=0)
print('done')
