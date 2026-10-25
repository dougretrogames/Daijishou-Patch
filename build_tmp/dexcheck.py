import os

dexdir = r'C:\Users\Douglas\Documents\Daijishou\build_tmp\dex_out'
needles = [b'Lcom/magneticchen/daijishou/activities/MainActivity;',
           b'Lcom/magneticchen/daijishou/support/DaijishouSupport;',
           b'Lcom/magneticchen/daijishou/daijishou_library_db/PlatformDAO_Impl;']
found = {n: 0 for n in needles}
for fn in sorted(os.listdir(dexdir)):
    if not fn.endswith('.dex'):
        continue
    data = open(os.path.join(dexdir, fn), 'rb').read()
    for n in needles:
        if n in data:
            found[n] += 1
    print(fn, len(data))
for n, c in found.items():
    print(n.decode(), 'found in', c, 'dex files')
