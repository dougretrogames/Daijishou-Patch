import zipfile, os, json

apk = r'C:\Users\Douglas\Documents\Daijishou\Daijishou v1.5.0.apk'
out = r'C:\Users\Douglas\Documents\Daijishou\build_tmp\ext_assets'
os.makedirs(out, exist_ok=True)
z = zipfile.ZipFile(apk)
for n in z.namelist():
    if n.startswith('assets/daijishou_extension/'):
        data = z.read(n)
        p = os.path.join(out, n.split('assets/daijishou_extension/')[1].replace('/', os.sep))
        os.makedirs(os.path.dirname(p), exist_ok=True)
        open(p, 'wb').write(data)
z.close()

for dp, _, fns in os.walk(out):
    for fn in fns:
        print(os.path.relpath(os.path.join(dp, fn), out))

print('== bootstrap.js (head)')
print(open(os.path.join(out, 'extension_v8_runtime', 'bootstrap.js'), encoding='utf-8', errors='replace').read()[:1200])

print('== dummy.zip contents')
d = zipfile.ZipFile(os.path.join(out, 'extensions', 'dummy.zip'))
for n in d.namelist()[:30]:
    print('  ', n)
print('== dummy.json if any')
for n in d.namelist():
    if n.endswith('.json'):
        print(n, d.read(n)[:800].decode('utf-8', 'replace'))
d.close()
