import os, re, json

BASE = r'C:\Users\Douglas\Documents\Daijishou'
ORIG = os.path.join(BASE, 'smali_orig_app')
COMP = os.path.join(BASE, 'build_tmp', 'smali_compiled')

meth_re = re.compile(r'^\.method\s+(.*)$')
field_re = re.compile(r'^\.field\s+(.*)$')
ref_re = re.compile(r'L(com/magneticchen/daijishou/[\w$]+(?:/[\w$]+)*);')


def parse_members(path):
    methods = set()
    fields = set()
    with open(path, 'r', encoding='utf-8', errors='replace') as fh:
        for line in fh:
            line = line.rstrip('\n')
            if line.startswith('.method'):
                m = re.search(r'([A-Za-z_$<][\w$<>]*)\s*\(([^)]*)\)(\S+)', line)
                if m:
                    methods.add((m.group(1), '(' + m.group(2) + ')' + m.group(3)))
            elif line.startswith('.field'):
                m = re.search(r'([A-Za-z_$][\w$]*):(\S+?)(?:\s*=\s*.*)?$', line)
                if m:
                    fields.add((m.group(1), m.group(2)))
    return methods, fields


def collect(root):
    out = {}
    for dirpath, _, files in os.walk(root):
        for fn in files:
            if not fn.endswith('.smali'):
                continue
            full = os.path.join(dirpath, fn)
            rel = os.path.relpath(full, root).replace('\\', '/')[:-6]
            if not rel.startswith('com/magneticchen/daijishou'):
                continue
            out[rel] = parse_members(full)
    return out


orig = collect(ORIG)
comp = collect(COMP)
print('orig classes:', len(orig), 'compiled classes:', len(comp))

renames = {}       # class -> list of (kind, orig_name, desc, jadx_name)
ambiguous = []
only_orig = []
only_comp = []

for cls in sorted(set(orig) & set(comp)):
    om, of = orig[cls]
    cm, cf = comp[cls]

    for kind, oset, cset in (('m', om, cm), ('f', of, cf)):
        odesc = {}
        for name, desc in oset:
            odesc.setdefault(desc, []).append(name)
        cdesc = {}
        for name, desc in cset:
            cdesc.setdefault(desc, []).append(name)
        for desc in set(odesc) & set(cdesc):
            onames = odesc[desc]
            cnames = cdesc[desc]
            if set(onames) == set(cnames):
                continue
            # pair up by name first
            common = [n for n in onames if n in cnames]
            left_o = [n for n in onames if n not in cnames]
            left_c = [n for n in cnames if n not in onames]
            if common:
                # members with an unchanged name might still be renamed variants;
                # only pair the leftovers when unambiguous
                pass
            if len(left_o) == 1 and len(left_c) == 1:
                renames.setdefault(cls, []).append((kind, left_o[0], desc, left_c[0]))
            elif len(left_o) == 0 and len(left_c) == 0:
                pass
            else:
                ambiguous.append((cls, kind, desc, onames, cnames))

    om_names = {(n, d) for n, d in om}
    cm_names = {(n, d) for n, d in cm}
    # ignore <init>/<clinit> and synthetic
    extra_o = om_names - cm_names
    extra_c = cm_names - om_names
    if extra_o:
        only_orig.append((cls, sorted(extra_o)))
    if extra_c:
        only_comp.append((cls, sorted(extra_c)))

n_ren = sum(len(v) for v in renames.values())
print('member renames:', n_ren, 'in classes:', len(renames))
print('ambiguous desc groups:', len(ambiguous))
for a in ambiguous[:20]:
    print('  AMB', a)
print('methods only in original:', sum(len(x[1]) for x in only_orig))
print('methods only in compiled:', sum(len(x[1]) for x in only_comp))

json.dump(renames, open(os.path.join(BASE, 'build_tmp', 'member_renames.json'), 'w'), indent=0)
json.dump({'only_orig': only_orig, 'only_comp': only_comp, 'ambiguous': ambiguous},
          open(os.path.join(BASE, 'build_tmp', 'member_diff.json'), 'w'), indent=0)

for cls in list(renames)[:5]:
    print(cls)
    for r in renames[cls][:6]:
        print('   ', r)
