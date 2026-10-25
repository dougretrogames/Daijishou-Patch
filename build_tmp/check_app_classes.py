import zipfile, os

jar = r'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars_pub2\classes4.jar'
z = zipfile.ZipFile(jar)
names = [n for n in z.namelist() if n.startswith('com/magneticchen/daijishou/')]
root = [n for n in names if n.count('/') == 3]
print('app pkg entries', len(names))
print('top-level entries:', root[:40])
print('R entries:', [n for n in names if n.startswith('com/magneticchen/daijishou/R')][:20])
z.close()

cls = r'C:\Users\Douglas\Documents\Daijishou\nest_classes'
rels = set()
for dp, _, fns in os.walk(cls):
    for fn in fns:
        if fn.endswith('.class'):
            rels.add(os.path.relpath(os.path.join(dp, fn), cls).replace('\\', '/'))
print('compiled classes', len(rels))
print('R in compiled:', [r for r in rels if r.startswith('com/magneticchen/daijishou/R')][:10])
print('support in compiled:', [r for r in rels if 'support/Daijishou' in r][:10])

sdk = r'C:\Users\Douglas\AppData\Local\Android\Sdk\platforms'
print('platforms', os.listdir(sdk) if os.path.isdir(sdk) else 'none')
