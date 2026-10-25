import os, re, json

BASE = r'C:\Users\Douglas\Documents\Daijishou'
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
APP = 'com/magneticchen/daijishou'

meth_re = re.compile(r'^\.method\s+(.*?)([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)\s*$')
sup_re = re.compile(r'^\.super\s+(L[^\s;]+;)')
inv_re = re.compile(r'^(?P<indent>\s*)invoke-direct(?P<range>/range)?\s+\{[^}]*\},\s+L(?P<cls>[\w/$]+);->(?P<name>[A-Za-z_$<][\w$<>]*)\((?P<params>[^)]*)\)(?P<ret>\S+)\s*$')

classes = {}
for dirpath, _, fs in os.walk(RECON):
    for fn in fs:
        if not fn.endswith('.smali'):
            continue
        full = os.path.join(dirpath, fn)
        name = sup = None
        methods = {}
        for line in open(full, 'r', encoding='utf-8', errors='replace'):
            s = line.rstrip('\n')
            if s.startswith('.super '):
                m = sup_re.match(s)
                if m:
                    sup = m.group(1)[1:-1]
            elif s.startswith('.method '):
                m = meth_re.match(s)
                if m:
                    methods[(m.group(2), '(' + m.group(3) + ')' + m.group(4))] = m.group(1)
            elif s.startswith('.class '):
                m = re.match(r'^\.class\s+.*?(L[^\s;]+;)\s*$', s)
                if m:
                    name = m.group(1)[1:-1]
        if name:
            classes[name] = (sup, methods)

print('app classes parsed:', len(classes))


def flags_of(cls, name, desc, seen=None):
    seen = seen or set()
    while cls and cls not in seen:
        seen.add(cls)
        if cls not in classes:
            return None
        sup, methods = classes[cls]
        if (name, desc) in methods:
            return methods[(name, desc)]
        cls = sup
    return None


changed = 0
files_changed = 0
for dirpath, _, fs in os.walk(RECON):
    for fn in fs:
        if not fn.endswith('.smali'):
            continue
        full = os.path.join(dirpath, fn)
        text = open(full, 'r', encoding='utf-8', errors='replace').read()
        out = []
        local = 0
        for line in text.split('\n'):
            m = inv_re.match(line)
            if m:
                cls = m.group('cls')
                name = m.group('name')
                desc = '(' + m.group('params') + ')' + m.group('ret')
                if name not in ('<init>', '<clinit>'):
                    flags = flags_of(cls, name, desc)
                    if flags is not None and 'private' not in flags.split():
                        line = line.replace('invoke-direct', 'invoke-virtual', 1)
                        local += 1
            out.append(line)
        if local:
            with open(full, 'w', encoding='utf-8', newline='\n') as fh:
                fh.write('\n'.join(out))
            files_changed += 1
            changed += local

print('invoke-direct normalized:', changed, 'in files:', files_changed)
