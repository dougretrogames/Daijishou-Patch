import os, struct, zipfile, sys

SRC = r'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars'
DST = r'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars_compile'
ACC_SYNTHETIC = 0x1000
ACC_BRIDGE = 0x0040

CP_SIZES = {3: 4, 4: 4, 5: 8, 6: 8, 7: 2, 8: 2, 9: 4, 10: 4, 11: 4,
            12: 4, 15: 3, 16: 2, 17: 4, 18: 4, 19: 2, 20: 2}


class ClassFile:
    def __init__(self, data):
        b = data
        self.b = b
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
            elif tag in CP_SIZES:
                off += CP_SIZES[tag]
                if tag in (5, 6):
                    i += 1
            else:
                raise ValueError(tag)
            i += 1
        self.cp_end = off

        pos = off
        pos += 6  # access, this, super
        ifc = struct.unpack_from('>H', b, pos)[0]
        pos += 2 + 2 * ifc
        self.head_end = pos
        self.this = utf[classref[struct.unpack_from('>H', b, off + 2)[0]]]

        fcount = struct.unpack_from('>H', b, pos)[0]
        pos += 2
        for _ in range(fcount):
            pos += 6
            acount = struct.unpack_from('>H', b, pos)[0]
            pos += 2
            for _a in range(acount):
                pos += 2
                ln = struct.unpack_from('>I', b, pos)[0]
                pos += 4 + ln
        self.fields_end = pos

        mcount = struct.unpack_from('>H', b, pos)[0]
        pos += 2
        self.methods = []
        for _ in range(mcount):
            start = pos
            flags = struct.unpack_from('>H', b, pos)[0]
            name = utf[struct.unpack_from('>H', b, pos + 2)[0]]
            desc = utf[struct.unpack_from('>H', b, pos + 4)[0]]
            pos += 6
            acount = struct.unpack_from('>H', b, pos)[0]
            pos += 2
            for _a in range(acount):
                pos += 2
                ln = struct.unpack_from('>I', b, pos)[0]
                pos += 4 + ln
            self.methods.append((name, desc, flags, b[start:pos]))
        self.methods_end = pos


def params(desc):
    i = desc.index(')')
    return desc[:i + 1]


def ret(desc):
    return desc[desc.index(')') + 1:]


hierarchy = {}
files = {}
for fn in sorted(os.listdir(SRC)):
    if not fn.endswith('.jar'):
        continue
    z = zipfile.ZipFile(os.path.join(SRC, fn))
    for n in z.namelist():
        if not n.endswith('.class'):
            continue
        cf = ClassFile(z.read(n))
        files[cf.this] = cf
        # superclass
        pos = cf.cp_end
        # re-read this/super via raw indices is not stored; use javap-free approach below
print('parsed', len(files))


def is_subtype(a, b, seen=None):
    if a == b:
        return True
    if seen is None:
        seen = set()
    if a in seen:
        return False
    seen.add(a)
    cf = files.get(a)
    if cf is None:
        return False
    for s in cf.supers:
        if is_subtype(s, b, seen):
            return True
    return False


# second parse to capture supers/interfaces
for name, cf in files.items():
    b = cf.b
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
        elif tag in CP_SIZES:
            off += CP_SIZES[tag]
            if tag in (5, 6):
                i += 1
        else:
            raise ValueError(tag)
        i += 1
    pos = off + 4  # access_flags, this_class
    sup = struct.unpack_from('>H', b, pos)[0]
    pos += 2
    ifc = struct.unpack_from('>H', b, pos)[0]
    pos += 2
    supers = []
    if sup:
        supers.append(utf[classref[sup]])
    for k in range(ifc):
        supers.append(utf[classref[struct.unpack_from('>H', b, pos + 2 * k)[0]]])
    cf.supers = supers


def choose(cands):
    if len(cands) == 1:
        return cands[0]
    rets = [ret(c[1]) for c in cands]

    def refname(d):
        return d[1:-1] if d.startswith('L') and d.endswith(';') else None

    # prefer a candidate whose return type is a subtype of all other return types
    for c in cands:
        r = refname(ret(c[1]))
        if r is None:
            continue
        if all(o == ret(c[1]) or (refname(o) is not None and is_subtype(r, refname(o)))
               for o in rets):
            return c
    # else: non-void, non-Object, non-bridge
    def score(c):
        r = ret(c[1])
        s = 0
        if r != 'V':
            s += 2
        if r != 'Ljava/lang/Object;':
            s += 1
        if not (c[2] & ACC_BRIDGE):
            s += 1
        return s
    return max(cands, key=score)


def rebuild(cf):
    b = cf.b
    groups = {}
    order = []
    for m in cf.methods:
        key = (m[0], params(m[1]))
        if key not in groups:
            groups[key] = []
            order.append(key)
        groups[key].append(m)
    kept = [choose(groups[k]) for k in order]
    out = bytearray()
    out += b[:10]
    out += b[10:cf.cp_end]
    out += b[cf.cp_end:cf.head_end]
    out += b[cf.head_end:cf.fields_end]
    out += struct.pack('>H', len(kept))
    for m in kept:
        raw = bytearray(m[3])
        struct.pack_into('>H', raw, 0, m[2] & ~ACC_SYNTHETIC)
        out += raw
    out += b[cf.methods_end:]
    return bytes(out)


os.makedirs(DST, exist_ok=True)
for fn in sorted(os.listdir(SRC)):
    if not fn.endswith('.jar'):
        continue
    zin = zipfile.ZipFile(os.path.join(SRC, fn))
    out = os.path.join(DST, fn)
    with zipfile.ZipFile(out, 'w', zipfile.ZIP_DEFLATED) as zout:
        for info in zin.infolist():
            data = zin.read(info.filename)
            if info.filename.endswith('.class'):
                cf = files.get(info.filename[:-6])
                data = rebuild(cf) if cf is not None else data
            zout.writestr(info, data)
    zin.close()
    print('wrote', out, os.path.getsize(out))
