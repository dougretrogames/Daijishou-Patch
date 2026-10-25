import zipfile, os

d = zipfile.ZipFile(r'C:\Users\Douglas\Documents\Daijishou\build_tmp\ext_assets\extensions\dummy.zip')
for n in ('manifest.json', 'index.js', 'helloword.js'):
    print('==', n)
    print(d.read(n)[:1500].decode('utf-8', 'replace'))
d.close()

print('== bootstrap tail')
s = open(r'C:\Users\Douglas\Documents\Daijishou\build_tmp\ext_assets\extension_v8_runtime\bootstrap.js', encoding='utf-8', errors='replace').read()
print(s[1200:4000])
print('== postscript')
print(open(r'C:\Users\Douglas\Documents\Daijishou\build_tmp\ext_assets\extension_v8_runtime\postscript.js', encoding='utf-8', errors='replace').read()[:600])
