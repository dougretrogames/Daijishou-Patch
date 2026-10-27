import struct

def get_classes_from_dex_file(path):
    with open(path, 'rb') as f:
        dex_bytes = f.read()
    string_ids_size, string_ids_off = struct.unpack_from('<II', dex_bytes, 0x38)
    type_ids_size, type_ids_off = struct.unpack_from('<II', dex_bytes, 0x40)
    class_defs_size, class_defs_off = struct.unpack_from('<II', dex_bytes, 0x60)
    
    string_offsets = [struct.unpack_from('<I', dex_bytes, string_ids_off + i*4)[0] for i in range(string_ids_size)]
    
    def get_string(idx):
        off = string_offsets[idx]
        while dex_bytes[off] & 0x80:
            off += 1
        off += 1
        end = dex_bytes.find(b'\0', off)
        return dex_bytes[off:end].decode('utf-8', errors='replace')

    type_descriptors = []
    for i in range(type_ids_size):
        str_idx = struct.unpack_from('<I', dex_bytes, type_ids_off + i*4)[0]
        type_descriptors.append(get_string(str_idx))
        
    classes = []
    for i in range(class_defs_size):
        class_idx = struct.unpack_from('<I', dex_bytes, class_defs_off + i*32)[0]
        classes.append(type_descriptors[class_idx])
    return classes

classes = get_classes_from_dex_file('build_tmp/dex181_classes4.dex')
pkgs = {}
for c in classes:
    # Lcom/magneticchen/daijishou/... -> com.magneticchen.daijishou
    parts = c[1:-1].split('/')
    if len(parts) > 1:
        pkg = '.'.join(parts[:3])
    else:
        pkg = parts[0]
    pkgs[pkg] = pkgs.get(pkg, 0) + 1

print(f"Total classes in classes4.dex: {len(classes)}")
for p, cnt in sorted(pkgs.items(), key=lambda x: x[1], reverse=True):
    print(f"  {p}: {cnt} classes")
