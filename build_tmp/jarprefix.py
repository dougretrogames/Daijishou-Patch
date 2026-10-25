import zipfile, os, collections

jars = r'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars_pub2'

skip = ('META-INF/',)

for fn in sorted(os.listdir(jars)):
    z = zipfile.ZipFile(os.path.join(jars, fn))
    names = z.namelist()
    pref = collections.Counter()
    for n in names:
        if n.endswith('/') or n.startswith(skip):
            continue
        parts = n.split('/')
        if len(parts) >= 2:
            key = '/'.join(parts[:2])
        else:
            key = parts[0]
        pref[key] += 1
    print('==', fn, len(names))
    for k, v in pref.most_common(15):
        print('   ', k, v)
    z.close()
