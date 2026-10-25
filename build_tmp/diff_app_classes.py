import zipfile, os

jar = r'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars_pub2\classes4.jar'
z = zipfile.ZipFile(jar)
jarnames = set(n for n in z.namelist() if n.startswith('com/magneticchen/daijishou/') and n.endswith('.class'))
z.close()

cls = r'C:\Users\Douglas\Documents\Daijishou\nest_classes'
rels = set()
for dp, _, fns in os.walk(cls):
    for fn in fns:
        if fn.endswith('.class'):
            rels.add(os.path.relpath(os.path.join(dp, fn), cls).replace('\\', '/'))

missing = sorted(jarnames - rels)
extra = sorted(rels - jarnames)
print('in jar not compiled:', len(missing))
for n in missing:
    print('  ', n)
print('compiled not in jar:', len(extra))
for n in extra[:50]:
    print('  +', n)
