import os

src_dir = 'app_sources/sources/com/magneticchen/daijishou/google_drive'
dst_dir = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/features'

for fname in os.listdir(src_dir):
    if fname.startswith('GoogleDrive'):
        src_p = os.path.join(src_dir, fname)
        dst_p = os.path.join(dst_dir, fname)
        with open(src_p, 'r', encoding='utf-8') as f:
            c = f.read()
        c = c.replace('package com.magneticchen.daijishou.google_drive;', 'package com.magneticchen.daijishou.features;')
        c = c.replace('com.magneticchen.daijishou.google_drive.', 'com.magneticchen.daijishou.features.')
        c = c.replace('com.magneticchen.daijishou.activities.', 'com.magneticchen.daijishou.ui.activities.')
        c = c.replace('com.magneticchen.daijishou.application_data.', 'com.magneticchen.daijishou.data.')
        with open(dst_p, 'w', encoding='utf-8') as f:
            f.write(c)

print('Migrated GoogleDrive!')
