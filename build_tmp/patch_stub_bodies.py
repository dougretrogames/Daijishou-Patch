import os, re, json, glob

BASE = r'C:\Users\Douglas\Documents\Daijishou'
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
ORIG = os.path.join(BASE, 'smali_orig_app')
APP = 'com/magneticchen/daijishou'

cm = json.load(open(os.path.join(BASE, 'build_tmp', 'class_map.json')))
mapping = cm['map']
inv = cm['inv']

mren_path = os.path.join(BASE, 'build_tmp', 'member_renames.json')
mren = json.load(open(mren_path)) if os.path.exists(mren_path) else {}
lookup = {}
for cls, lst in mren.items():
    for item in lst:
        kind, orig_name, desc, jadx_name = item
        lookup[(cls, kind, orig_name, desc)] = jadx_name
SKIP_RENAME = {(c, k, o, d) for (c, k, o, d) in lookup if o == 'invokeSuspend'}

meth_re = re.compile(r'^\.method\s+(.*?)([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)\s*$')
ref_m = re.compile(r'L([\w/$]+);->([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)')
ref_f = re.compile(r'L([\w/$]+);->([A-Za-z_$][\w$]*):(\S+?)(?=[\s,\n]|$)')
cls_re = re.compile(r'L([\w/$]+);')


def path_of(root, cls):
    return os.path.join(root, *cls.split('/')) + '.smali'


def parse_methods(full):
    out = {}
    lines = open(full, 'r', encoding='utf-8', errors='replace').read().split('\n')
    i = 0
    while i < len(lines):
        s = lines[i]
        if s.startswith('.method '):
            m = meth_re.match(s)
            if m:
                key = (m.group(2), '(' + m.group(3) + ')' + m.group(4))
                j = i
                while j < len(lines) and not lines[j].startswith('.end method'):
                    j += 1
                out[key] = (i, j)
            i += 1
            continue
        i += 1
    return out


def remap_body(body, src_cls, dst_cls, dst_name, desc):
    """Rewrite member refs, lambda-call refs and class refs of an ORIG body."""

    def sub_m(mm):
        c, name, d = mm.group(1), mm.group(2), '(' + mm.group(3) + ')' + mm.group(4)
        key = (c, 'm', name, d)
        if key in lookup and key not in SKIP_RENAME:
            return 'L' + c + ';->' + lookup[key] + d
        return mm.group(0)

    def sub_f(mm):
        c, name, typ = mm.group(1), mm.group(2), mm.group(3).strip()
        key = (c, 'f', name, typ)
        if key in lookup:
            return 'L' + c + ';->' + lookup[key] + ':' + typ
        return mm.group(0)

    body = ref_m.sub(sub_m, body)
    body = ref_f.sub(sub_f, body)

    # the JADX-compiled method is no longer in the lambda class: redirect recursion into it
    if dst_name.startswith('invokeSuspendImpl$'):
        suffix = dst_name[len('invokeSuspendImpl$'):]
        body = body.replace('L' + src_cls + ';->invokeSuspend$' + suffix + '(',
                            'L' + dst_cls + ';->' + dst_name + '(')
        body = body.replace('L' + src_cls + ';->access$invokeSuspend$' + suffix + '(',
                            'L' + dst_cls + ';->' + dst_name + '(')

    body = cls_re.sub(lambda mm: 'L' + mapping.get(mm.group(1), mm.group(1)) + ';', body)
    if 'L' + src_cls + ';' in body:
        print('  WARN leftover refs to', src_cls)
    return body


def find_impl(cls, name, desc):
    """Return (src_cls, src_file, start, end) of an implementation in the original tree."""
    orig_cls = inv.get(cls, cls)
    candidates = []
    # direct
    p = path_of(ORIG, orig_cls)
    if os.path.exists(p):
        candidates.append((orig_cls, p))
    # suspend lambdas lifted into the class by JADX
    if name.startswith('invokeSuspendImpl$'):
        for p in sorted(glob.glob(os.path.join(os.path.dirname(path_of(ORIG, orig_cls)),
                                               os.path.basename(orig_cls) + '$*.smali'))):
            candidates.append((os.path.relpath(p, ORIG).replace('\\', '/')[:-6], p))

    priority = [name]
    if name == 'invokeSuspendImpl':
        priority.append('invokeSuspend')
    elif name.startswith('invokeSuspendImpl$'):
        suffix = name[len('invokeSuspendImpl$'):]
        priority.append('invokeSuspend$' + suffix)
        priority.append('access$invokeSuspend$' + suffix)

    parsed = [(src_cls, p, parse_methods(p)) for src_cls, p in candidates]
    for want in priority:
        for src_cls, p, ms in parsed:
            for (mname, mdesc), (a, b) in ms.items():
                if mname == want and mdesc == desc:
                    return src_cls, p, a, b
    return None


repaired = []
for dirpath, _, fs in os.walk(RECON):
    for fn in fs:
        if not fn.endswith('.smali'):
            continue
        full = os.path.join(dirpath, fn)
        cls = os.path.relpath(full, RECON).replace('\\', '/')[:-6]
        if not cls.startswith(APP):
            continue
        lines = open(full, 'r', encoding='utf-8', errors='replace').read().split('\n')
        if not any('Method not decompiled' in l for l in lines):
            continue
        ms = parse_methods(full)
        targets = []
        for (name, desc), (a, b) in ms.items():
            if any('Method not decompiled' in l for l in lines[a:b + 1]):
                targets.append((name, desc, a, b))
        for name, desc, a, b in targets:
            found = find_impl(cls, name, desc)
            if not found:
                print('NO IMPL', cls, name + desc)
                continue
            src_cls, src_file, sa, sb = found
            src_lines = open(src_file, 'r', encoding='utf-8', errors='replace').read().split('\n')
            body = '\n'.join(src_lines[sa + 1:sb])
            body = remap_body(body, src_cls, cls, name, desc)
            header = lines[a]
            rest = lines[b:]  # keep .end method onwards
            new_lines = lines[:a] + [header] + body.split('\n') + rest
            lines = new_lines
            ms = parse_methods(full)
            repaired.append((cls, name, desc, src_cls))
            # write immediately (indices refresh via re-parse next target)

        with open(full, 'w', encoding='utf-8', newline='\n') as fh:
            fh.write('\n'.join(lines))

print('repaired methods:', len(repaired))
for r in repaired:
    print('  ', r[0], '->', r[1] + r[2], '| from', r[3])

if os.environ.get('NO_ORIG', '1') == '1' and len(repaired) > 0:
    raise RuntimeError(f"FALHA [No-Orig]: {len(repaired)} metodos ainda estao sendo restaurados a partir de smali_orig_app!")
