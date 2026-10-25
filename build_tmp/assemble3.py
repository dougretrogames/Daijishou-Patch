import os, zipfile

orig = r'C:\Users\Douglas\Documents\Daijishou\Daijishou v1.5.0.apk'
out = r'C:\Users\Douglas\Documents\Daijishou\build_tmp\unsigned3.apk'
lib4_apk = r'C:\Users\Douglas\Documents\Daijishou\build_tmp\lib4.apk'
appdex = r'C:\Users\Douglas\Documents\Daijishou\build_tmp\app7.apk'
appdex_entry = 'classes.dex'

zin = zipfile.ZipFile(orig)
skip = set()
for n in zin.namelist():
    if n.startswith('classes') and n.endswith('.dex'):
        skip.add(n)
    if n.startswith('META-INF/') and (n.endswith('.SF') or n.endswith('.RSA') or n.endswith('.DSA') or n.endswith('.MF')):
        skip.add(n)

repl = {'classes4.dex': zipfile.ZipFile(lib4_apk).read('classes.dex')}
keep_dex = ['classes.dex', 'classes2.dex', 'classes3.dex', 'classes5.dex', 'classes6.dex']

with zipfile.ZipFile(out, 'w', zipfile.ZIP_DEFLATED) as zout:
    for info in zin.infolist():
        if info.filename in skip:
            continue
        data = repl.get(info.filename, zin.read(info.filename))
        zout.writestr(info, data)
    for n in keep_dex:
        zout.writestr(n, zin.read(n), zipfile.ZIP_DEFLATED)
    zout.writestr('classes4.dex', repl['classes4.dex'], zipfile.ZIP_DEFLATED)
    zout.writestr('classes7.dex', zipfile.ZipFile(appdex).read(appdex_entry), zipfile.ZIP_STORED)
zin.close()
print('wrote', out, os.path.getsize(out))
