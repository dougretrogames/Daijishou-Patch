import os, zipfile

src = r'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars_pub'
dst = r'C:\Users\Douglas\Documents\Daijishou\build_tmp\jars_clean2'
os.makedirs(dst, exist_ok=True)

for fn in sorted(os.listdir(src)):
    if not fn.endswith('.jar'):
        continue
    zin = zipfile.ZipFile(os.path.join(src, fn))
    out = os.path.join(dst, fn)
    with zipfile.ZipFile(out, 'w', zipfile.ZIP_DEFLATED) as zout:
        for info in zin.infolist():
            n = info.filename
            if n.startswith('com/magneticchen/daijishou/'):
                continue
            if n.startswith('META-INF/') and (n.endswith('.SF') or n.endswith('.RSA') or n.endswith('.DSA')):
                continue
            if n == 'module-info.class':
                continue
            zout.writestr(info, zin.read(n))
    zin.close()
    print('wrote', out, os.path.getsize(out))
