import os, struct, zipfile, sys, json

SRC = sys.argv[1] if len(sys.argv) > 1 else r'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars_nosyn'


def parse(data):
    b = data
    cp_count = struct.unpack_from('>H', b, 8)[0]
    off = 10
    utf = {}
    classref = {}
    i = 1
    while i < cp_count:
        tag = b[off]; off += 1
        if tag == 1:
            ln = struct.unpack_from('>H', b, off)[0]
            utf[i] = b[off + 2:off + 2 + ln].decode('utf-8', 'replace')
            off += 2 + ln
        elif tag == 7:
            classref[i] = struct.unpack_from('>H', b, off)[0]
            off += 2
        elif tag in (3, 4):
            off += 4
        elif tag in (5, 6):
            off += 8; i += 1
        elif tag in (8, 16, 19, 20):
            off += 2
        elif tag in (9, 10, 11, 12, 17, 18):
            off += 4
        elif tag == 15:
            off += 3
        else:
            raise ValueError(tag)
        i += 1

    acc = struct.unpack_from('>H', b, off)[0]; off += 2
    this = utf[classref[struct.unpack_from('>H', b, off)[0]]]; off += 2
    sup = struct.unpack_from('>H', b, off)[0]; off += 2
    supname = utf[classref[sup]] if sup else None
    ifc = struct.unpack_from('>H', b, off)[0]; off += 2
    ifaces = [utf[classref[struct.unpack_from('>H', b, off + 2 * k)[0]]] for k in range(ifc)]
    off += 2 * ifc

    fields = []
    for kind in ('field', 'method'):
        count = struct.unpack_from('>H', b, off)[0]; off += 2
        for _ in range(count):
            f = struct.unpack_from('>H', b, off)[0]
            name = utf[struct.unpack_from('>H', b, off + 2)[0]]
            desc = utf[struct.unpack_from('>H', b, off + 4)[0]]
            off += 6
            acount = struct.unpack_from('>H', b, off)[0]; off += 2
            for _a in range(acount):
                off += 2
                ln = struct.unpack_from('>I', b, off)[0]
                off += 4 + ln
            if kind == 'method':
                fields.append((name, desc, f))
    return this, acc, supname, ifaces, fields


allinfo = {}
for fn in sorted(os.listdir(SRC)):
    if not fn.endswith('.jar'):
        continue
    z = zipfile.ZipFile(os.path.join(SRC, fn))
    for n in z.namelist():
        if not n.endswith('.class'):
            continue
        try:
            this, acc, sup, ifc, methods = parse(z.read(n))
        except Exception as e:
            print('ERR', fn, n, e)
            continue
        allinfo[this] = (acc, sup, ifc, methods)

print('classes:', len(allinfo))
hits = []
for this, (acc, sup, ifc, methods) in allinfo.items():
    groups = {}
    for name, desc, f in methods:
        if name.startswith('<'):
            continue
        key = (name, desc[:desc.index(')') + 1])
        groups.setdefault(key, []).append((desc, f))
    for key, lst in groups.items():
        rets = {d for d, _ in lst}
        if len(rets) > 1:
            hits.append((this, key[0], key[1], [d for d, _ in lst]))
print('classes with duplicate-return methods:', len(hits))
for h in sorted(hits):
    print(h[0], h[1], h[2], h[3])
