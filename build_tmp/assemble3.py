import os, zipfile, json

base = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
orig = os.path.join(base, 'Daijishou v1.5.0.apk')
out = os.path.join(base, 'build_tmp', 'unsigned3.apk')
lib4_apk = os.path.join(base, 'build_tmp', 'lib4.apk')
appdex = os.path.join(base, 'build_tmp', 'app7.apk')
res_apk = os.path.join(base, 'build_tmp', 'apktool_res.apk')
appdex_entry = 'classes.dex'

zin = zipfile.ZipFile(orig)
skip = set()
for n in zin.namelist():
    if n.startswith('classes') and n.endswith('.dex'):
        skip.add(n)
    if n.startswith('META-INF/') and (n.endswith('.SF') or n.endswith('.RSA') or n.endswith('.DSA') or n.endswith('.MF')):
        skip.add(n)

repl = {'classes4.dex': zipfile.ZipFile(lib4_apk).read('classes.dex')}
# Note: resources.arsc from apktool changes resource IDs (breaking hardcoded R.id/drawable constants in dex)
# Keep original byte-exact resources.arsc as required by HANDOFF.md §6.

keep_dex = ['classes.dex', 'classes2.dex', 'classes3.dex', 'classes5.dex', 'classes6.dex']

with zipfile.ZipFile(out, 'w', zipfile.ZIP_DEFLATED) as zout:
    for info in zin.infolist():
        if info.filename in skip:
            continue
        data = repl.get(info.filename, zin.read(info.filename))
        if info.filename == 'kotlin-tooling-metadata.json':
            try:
                meta = json.loads(data.decode('utf-8'))
                meta['buildSystemVersion'] = '8.14.6'
                data = json.dumps(meta, indent=2).encode('utf-8')
            except Exception:
                pass
        zout.writestr(info, data)
    for n in keep_dex:
        zout.writestr(n, zin.read(n), zipfile.ZIP_DEFLATED)
    zout.writestr('classes4.dex', repl['classes4.dex'], zipfile.ZIP_DEFLATED)
    zout.writestr('classes7.dex', zipfile.ZipFile(appdex).read(appdex_entry), zipfile.ZIP_STORED)
zin.close()
print('wrote', out, os.path.getsize(out))
