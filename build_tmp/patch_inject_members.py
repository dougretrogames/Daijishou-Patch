import os, re, json

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
ORIG = os.path.join(BASE, 'smali_orig_app')

cm = json.load(open(os.path.join(BASE, 'build_tmp', 'class_map.json')))
mapping = cm['map']
inv = cm['inv']
mren = json.load(open(os.path.join(BASE, 'build_tmp', 'member_renames.json')))
patched = set(json.load(open(os.path.join(BASE, 'build_tmp', 'patched_classes.json'))))

lookup = {}
for cls, lst in mren.items():
    for kind, orig, desc, jadx in lst:
        lookup[(cls, kind, orig, desc)] = jadx

SKIP = {(c, 'm', o, d) for (c, k, o, d) in lookup if o == 'invokeSuspend'}

APP = r'com/magneticchen/daijishou/[\w$]+(?:/[\w$]+)*'
ref_m = re.compile(r'L(' + APP + r');->([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)')
ref_f = re.compile(r'L(' + APP + r');->([A-Za-z_$][\w$]*):(\S+?)(?=[\s,\n]|$)')


def path_of(root, cls):
    return os.path.join(root, *cls.split('/')) + '.smali'


def parse_members(path):
    ms, fs = set(), set()
    for line in open(path, 'r', encoding='utf-8', errors='replace'):
        s = line.strip()
        if s.startswith('.method '):
            m = re.match(r'\.method\s+(.*?)([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)', s)
            if m:
                ms.add((m.group(2), '(' + m.group(3) + ')' + m.group(4)))
        elif s.startswith('.field '):
            m = re.match(r'\.field\s+(.*?)([A-Za-z_$][\w$]*):(\S+)', s)
            if m:
                fs.add((m.group(2), m.group(3)))
    return ms, fs


def member_blocks(path):
    """Return {('m'|'f', name, desc): text} for method blocks and field lines."""
    out = {}
    lines = open(path, 'r', encoding='utf-8', errors='replace').read().split('\n')
    i = 0
    while i < len(lines):
        s = lines[i].strip()
        if s.startswith('.method '):
            m = re.match(r'\.method\s+(.*?)([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)', s)
            if m:
                name = m.group(2)
                desc = '(' + m.group(3) + ')' + m.group(4)
                j = i
                while j < len(lines) and not lines[j].strip().startswith('.end method'):
                    j += 1
                out[('m', name, desc)] = '\n'.join(lines[i:j + 1])
                i = j + 1
                continue
        elif s.startswith('.field '):
            m = re.match(r'\.field\s+(.*?)([A-Za-z_$][\w$]*):(\S+)', s)
            if m:
                out[('f', m.group(2), m.group(3))] = lines[i]
        i += 1
    return out


def rewrite(text, cls):
    def sub_m(mm):
        c, name, desc = mm.group(1), mm.group(2), '(' + mm.group(3) + ')' + mm.group(4)
        key = (c, 'm', name, desc)
        if key in lookup and key not in SKIP:
            return 'L' + c + ';->' + lookup[key] + desc
        return mm.group(0)

    def sub_f(mm):
        c, name, desc = mm.group(1), mm.group(2), mm.group(3).strip()
        key = (c, 'f', name, desc)
        if key in lookup:
            return 'L' + c + ';->' + lookup[key] + ':' + desc
        return mm.group(0)

    text = ref_m.sub(sub_m, text)
    text = ref_f.sub(sub_f, text)

    def sub_cls(mm):
        n = mm.group(1)
        return 'L' + mapping.get(n, n) + ';'

    return re.sub(r'L(' + APP + r');', sub_cls, text)


state = {}
for cls in patched:
    p = path_of(RECON, cls)
    if os.path.exists(p):
        state[cls] = parse_members(p)

orig_blocks = {}


def get_blocks(orig_cls):
    if orig_cls not in orig_blocks:
        p = path_of(ORIG, orig_cls)
        orig_blocks[orig_cls] = member_blocks(p) if os.path.exists(p) else {}
    return orig_blocks[orig_cls]


injected = []
for rnd in range(6):
    new_injections = 0
    # scan every patched file for missing app members
    for cls in sorted(patched):
        p = path_of(RECON, cls)
        if not os.path.exists(p):
            continue
        text = open(p, 'r', encoding='utf-8', errors='replace').read()
        needed = []
        for m in ref_m.finditer(text):
            c, name = m.group(1), m.group(2)
            desc = '(' + m.group(3) + ')' + m.group(4)
            if c == cls:
                continue
            needed.append(('m', c, name, desc))
        for m in ref_f.finditer(text):
            c, name, typ = m.group(1), m.group(2), m.group(3).strip()
            if c == cls:
                continue
            needed.append(('f', c, name, typ))

        for kind, c, name, desc in needed:
            cp = path_of(RECON, c)
            if not os.path.exists(cp):
                continue
            if c not in state:
                state[c] = parse_members(cp)
            have = state[c][0] if kind == 'm' else state[c][1]
            key = (name, desc)
            if key in have:
                continue
            orig_cls = inv.get(c, c)
            blk = get_blocks(orig_cls).get((kind, name, desc))
            if blk is None:
                continue
            blk = rewrite(blk, c)
            with open(cp, 'a', encoding='utf-8', newline='\n') as fh:
                fh.write('\n' + blk + '\n')
            if kind == 'm':
                state[c][0].add(key)
            else:
                state[c][1].add(key)
            injected.append((c, kind, name, desc))
            new_injections += 1
    print('round', rnd, 'injected', new_injections)
    if new_injections == 0:
        break

print('total injected:', len(injected))
for x in injected[:40]:
    print('  ', x)
