import os

src_dir = 'app_sources/sources/com/magneticchen/daijishou/repositories'
dst_dir = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/data/db/repositories'

for fname in os.listdir(src_dir):
    if fname.startswith('DaijishouLibraryRepository$'):
        src_p = os.path.join(src_dir, fname)
        dst_p = os.path.join(dst_dir, fname)
        with open(src_p, 'r', encoding='utf-8') as f:
            c = f.read()
        c = c.replace('package com.magneticchen.daijishou.repositories;', 'package com.magneticchen.daijishou.data.db.repositories;')
        c = c.replace('com.magneticchen.daijishou.repositories.', 'com.magneticchen.daijishou.data.db.repositories.')
        c = c.replace('com.magneticchen.daijishou.daijishou_library_db.', 'com.magneticchen.daijishou.data.db.entity.')
        with open(dst_p, 'w', encoding='utf-8') as f:
            f.write(c)

print('Copied auxiliary repo classes')
