import os

src_p = 'app_sources/sources/com/magneticchen/daijishou/repositories/DaijishouLibraryRepository.java'
dst_p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository.java'

with open(src_p, 'r', encoding='utf-8') as f:
    c = f.read()

# Package and imports update
c = c.replace('package com.magneticchen.daijishou.repositories;', 'package com.magneticchen.daijishou.data.db.repositories;')
c = c.replace('package com.magneticchen.daijishou.repositories.', 'package com.magneticchen.daijishou.data.db.repositories.')
c = c.replace('com.magneticchen.daijishou.repositories.', 'com.magneticchen.daijishou.data.db.repositories.')
c = c.replace('com.magneticchen.daijishou.daijishou_library_db.', 'com.magneticchen.daijishou.data.db.entity.')
# Fix entities and DAOs imports
c = c.replace('com.magneticchen.daijishou.data.db.entity.DaijishouLibraryDatabase', 'com.magneticchen.daijishou.data.db.DaijishouLibraryDatabase')
c = c.replace('com.magneticchen.daijishou.data.db.entity.DaijishouLibraryDAO', 'com.magneticchen.daijishou.data.db.dao.DaijishouLibraryDAO')
c = c.replace('com.magneticchen.daijishou.data.db.entity.GameDAO', 'com.magneticchen.daijishou.data.db.dao.GameDAO')
c = c.replace('com.magneticchen.daijishou.data.db.entity.PlatformDAO', 'com.magneticchen.daijishou.data.db.dao.PlatformDAO')
c = c.replace('com.magneticchen.daijishou.data.db.entity.PlayerDAO', 'com.magneticchen.daijishou.data.db.dao.PlayerDAO')
c = c.replace('com.magneticchen.daijishou.data.db.entity.ItemDAO', 'com.magneticchen.daijishou.data.db.dao.ItemDAO')
c = c.replace('com.magneticchen.daijishou.application_data.', 'com.magneticchen.daijishou.data.')
c = c.replace('com.magneticchen.daijishou.activities.', 'com.magneticchen.daijishou.ui.activities.')
c = c.replace('com.magneticchen.daijishou.view_models.', 'com.magneticchen.daijishou.ui.model.')

with open(dst_p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Migrated DaijishouLibraryRepository.java')
