import os, struct, zipfile, sys

SRC = r'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars'
DST = r'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars_nosyn'
ACC_SYNTHETIC = 0x1000

CP_SIZES = {3: 4, 4: 4, 5: 8, 6: 8, 7: 2, 8: 2, 9: 4, 10: 4, 11: 4,
            12: 4, 15: 3, 16: 2, 17: 4, 18: 4, 19: 2, 20: 2}


def transform(data):
    b = bytearray(data)
    if b[:4] != b'\xca\xfe\xba\xbe':
        return data
    cp_count = struct.unpack_from('>H', b, 8)[0]
    off = 10
    i = 1
    while i < cp_count:
        tag = b[off]
        off += 1
        if tag == 1:
            ln = struct.unpack_from('>H', b, off)[0]
            off += 2 + ln
        elif tag in CP_SIZES:
            off += CP_SIZES[tag]
            if tag in (5, 6):
                i += 1
        else:
            raise ValueError('bad cp tag %d at %d' % (tag, off - 1))
        i += 1

    access_off = off
    struct.pack_into('>H', b, access_off,
                     struct.unpack_from('>H', b, access_off)[0] & ~ACC_SYNTHETIC)

    off += 2  # access_flags
    off += 2  # this_class
    off += 2  # super_class
    ifc = struct.unpack_from('>H', b, off)[0]
    off += 2 + 2 * ifc

    for _kind in ('field', 'method'):
        count = struct.unpack_from('>H', b, off)[0]
        off += 2
        for _ in range(count):
            flags = struct.unpack_from('>H', b, off)[0]
            struct.pack_into('>H', b, off, flags & ~ACC_SYNTHETIC)
            off += 6  # access, name, desc
            acount = struct.unpack_from('>H', b, off)[0]
            off += 2
            for _a in range(acount):
                off += 2  # name index
                ln = struct.unpack_from('>I', b, off)[0]
                off += 4 + ln
    return bytes(b)


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
                data = transform(data)
            zout.writestr(info, data)
    zin.close()
    print('wrote', out, os.path.getsize(out))
