import os, zipfile

orig = r'C:\Users\Douglas\Documents\Daijishou\Daijishou v1.5.0.apk'
out = r'C:\Users\Douglas\Documents\Daijishou\build_tmp\unsigned.apk'
dexdir = r'C:\Users\Douglas\Documents\Daijishou\build_tmp\dex_out'

zin = zipfile.ZipFile(orig)
skip = set()
for n in zin.namelist():
    if n.startswith('classes') and n.endswith('.dex'):
        skip.add(n)
    if n.startswith('META-INF/') and (n.endswith('.SF') or n.endswith('.RSA') or n.endswith('.DSA') or n.endswith('.MF')):
        skip.add(n)

with zipfile.ZipFile(out, 'w', zipfile.ZIP_DEFLATED) as zout:
    for info in zin.infolist():
        if info.filename in skip:
            continue
        zout.writestr(info, zin.read(info.filename))
    for fn in sorted(os.listdir(dexdir)):
        if fn.endswith('.dex'):
            with open(os.path.join(dexdir, fn), 'rb') as f:
                data = f.read()
            zout.writestr(fn, data, zipfile.ZIP_STORED)
    print('added dex files')
zin.close()
print('wrote', out, os.path.getsize(out))
