import os

src_dir = 'app_sources/sources/com/magneticchen/daijishou/view_models'
dst_dir = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/model'

for fname in os.listdir(src_dir):
    if fname.startswith('DaijishouSynchronizationModel'):
        src_p = os.path.join(src_dir, fname)
        dst_p = os.path.join(dst_dir, fname)
        with open(src_p, 'r', encoding='utf-8') as f:
            c = f.read()
        c = c.replace('package com.magneticchen.daijishou.view_models;', 'package com.magneticchen.daijishou.ui.model;')
        c = c.replace('com.magneticchen.daijishou.view_models.', 'com.magneticchen.daijishou.ui.model.')
        c = c.replace('com.magneticchen.daijishou.repositories.', 'com.magneticchen.daijishou.data.db.repositories.')
        c = c.replace('com.magneticchen.daijishou.daijishou_library_db.', 'com.magneticchen.daijishou.data.db.entity.')
        c = c.replace('com.magneticchen.daijishou.activities.', 'com.magneticchen.daijishou.ui.activities.')
        c = c.replace('com.magneticchen.daijishou.backup_and_restore.', 'com.magneticchen.daijishou.data.backup.')
        c = c.replace('com.magneticchen.daijishou.application_data.', 'com.magneticchen.daijishou.data.')
        c = c.replace('com.magneticchen.daijishou.scraper.', 'com.magneticchen.daijishou.data.scraper.')
        c = c.replace('com.magneticchen.daijishou.google_drive.', 'com.magneticchen.daijishou.features.')
        c = c.replace('com.magneticchen.daijishou.retro_achievements.', 'com.magneticchen.daijishou.features.retroachievements.')
        with open(dst_p, 'w', encoding='utf-8') as f:
            f.write(c)

print('Migrated DaijishouSynchronizationModel!')
