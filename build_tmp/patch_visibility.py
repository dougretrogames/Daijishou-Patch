import os, re, json

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
COMP = os.path.join(BASE, 'build_tmp', 'smali_compiled')
patched = json.load(open(os.path.join(BASE, 'build_tmp', 'patched_classes.json')))

VIS = {'public': 3, 'protected': 2, 'private': 0}


def vis_of(flags):
    for tok in flags.split():
        if tok in VIS:
            return VIS[tok]
    return 1  # package-private


def parse_file(path):
    cls_flags = ''
    methods = {}
    fields = {}
    lines = open(path, 'r', encoding='utf-8', errors='replace').read().split('\n')
    for idx, line in enumerate(lines):
        s = line.strip()
        if s.startswith('.class '):
            m = re.match(r'\.class\s+(.*?)\s*L[\w/$]+;$', s)
            if m:
                cls_flags = m.group(1)
        elif s.startswith('.method '):
            m = re.match(r'\.method\s+(.*?)([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)', s)
            if m:
                flags, name, params, ret = m.groups()
                methods[(name, '(' + params + ')' + ret)] = (vis_of(flags), flags, idx)
        elif s.startswith('.field '):
            m = re.match(r'\.field\s+(.*?)([A-Za-z_$][\w$]*):(\S+)', s)
            if m:
                flags, name, typ = m.groups()
                fields[(name, typ)] = (vis_of(flags), flags, idx)
    return cls_flags, methods, fields, lines


VIS_TOKENS = ('public', 'protected', 'private')


def set_vis(flags, target_vis):
    toks = [t for t in flags.split() if t not in VIS_TOKENS]
    word = {3: 'public', 2: 'protected', 0: 'private'}.get(target_vis)
    if word:
        toks.insert(0, word)
    return ' '.join(toks)


changed = 0
classes_touched = 0

for cls in patched:
    rp = os.path.join(RECON, *cls.split('/')) + '.smali'
    cp = os.path.join(COMP, *cls.split('/')) + '.smali'
    if not os.path.exists(rp):
        continue
    rcls, rmeth, rfield, rlines = parse_file(rp)
    if os.path.exists(cp):
        ccls, cmeth, cfield, _ = parse_file(cp)
    else:
        ccls, cmeth, cfield = '', {}, {}
    touched = False

    if ccls and vis_of(ccls) > vis_of(rcls):
        new = set_vis(rcls, vis_of(ccls))
        for i, line in enumerate(rlines):
            if line.strip().startswith('.class '):
                rlines[i] = re.sub(r'(\.class\s+).*?(\s*L[\w/$]+;$)', lambda m: m.group(1) + new + m.group(2), line)
                touched = True
                break

    for kind, rmap, cmap, prefix in (('m', rmeth, cmeth, '.method '), ('f', rfield, cfield, '.field ')):
        for key, (rvis, rflags, idx) in rmap.items():
            if key not in cmap:
                continue
            cvis = cmap[key][0]
            if cvis <= rvis:
                continue
            newflags = set_vis(rflags, cvis)
            if kind == 'm':
                name, desc = key
                newline = prefix + newflags + ' ' + name + desc
            else:
                name, typ = key
                orig_line = rlines[idx]
                tail_start = orig_line.find(':' + typ) + 1 + len(typ)
                tail = orig_line[tail_start:]
                newline = prefix + newflags + ' ' + name + ':' + typ + tail
            rlines[idx] = newline
            touched = True
            changed += 1

    if touched:
        with open(rp, 'w', encoding='utf-8', newline='\n') as fh:
            fh.write('\n'.join(rlines))
        classes_touched += 1

print('classes touched:', classes_touched, 'members widened:', changed)
