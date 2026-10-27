import zipfile, os

with zipfile.ZipFile('Daijishou_v1.8.1_426.apk') as zin, zipfile.ZipFile('build_tmp/dummy4.apk', 'w') as zout:
    zout.writestr('classes.dex', zin.read('classes4.dex'))
    with zipfile.ZipFile('build_tmp/lib4.apk') as zlib:
        zout.writestr('AndroidManifest.xml', zlib.read('AndroidManifest.xml'))
        zout.writestr('resources.arsc', zlib.read('resources.arsc'))

print('Created dummy4.apk with classes4.dex from 1.8.1')
