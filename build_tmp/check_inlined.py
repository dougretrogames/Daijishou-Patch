import os

files = [f for f in os.listdir('app_sources/sources/com/magneticchen/daijishou/backup_and_restore') if 'inlined' in f]
for fname in files:
    p = os.path.join('app_sources/sources/com/magneticchen/daijishou/backup_and_restore', fname)
    with open(p, encoding='utf-8') as f:
        print(fname, '-->')
        print(f.read())
