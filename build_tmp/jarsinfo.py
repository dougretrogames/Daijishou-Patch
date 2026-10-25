import zipfile, os

jars = r'C:\Users\Douglas\Documents\Daijishou\reconstructed\jars_pub2'
libs = r'C:\Users\Douglas\Documents\Daijishou\reconstructed\libs_pub2'
app_prefix = 'com/magneticchen/daijishou/'

for base in (jars, libs):
    print('==', base)
    for fn in sorted(os.listdir(base)):
        z = zipfile.ZipFile(os.path.join(base, fn))
        names = z.namelist()
        app = sum(1 for n in names if n.startswith(app_prefix))
        kot = sum(1 for n in names if n.startswith('kotlin/collections/CollectionsKt'))
        ax = sum(1 for n in names if n.startswith('androidx/'))
        print(fn, 'entries', len(names), 'app-pkg', app, 'kotlinstdlib', kot, 'androidx', ax)
        z.close()
