import os

src_dir = 'app_sources/sources/com/magneticchen/daijishou/backup_and_restore'
dst_dir = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/data/backup'

# 1. Adapt and copy the two comparator files
for fname in [
    'BackupAndRestore$restoreFromListOfBackupData$lambda$15$$inlined$sortBy$1.java',
    'BackupAndRestore$restoreFromListOfBackupData$lambda$15$$inlined$sortedBy$1.java'
]:
    with open(os.path.join(src_dir, fname), 'r', encoding='utf-8') as f:
        content = f.read()
    content = content.replace('package com.magneticchen.daijishou.backup_and_restore;', 'package com.magneticchen.daijishou.data.backup;')
    with open(os.path.join(dst_dir, fname), 'w', encoding='utf-8') as f:
        f.write(content)

# 2. Adapt BackupAndRestore.java
with open(os.path.join(src_dir, 'BackupAndRestore.java'), 'r', encoding='utf-8') as f:
    content = f.read()

content = content.replace('package com.magneticchen.daijishou.backup_and_restore;', 'package com.magneticchen.daijishou.data.backup;')
content = content.replace('com.magneticchen.daijishou.backup_and_restore.modules.', 'com.magneticchen.daijishou.data.backup.modules.')
content = content.replace('com.magneticchen.daijishou.backup_and_restore.', 'com.magneticchen.daijishou.data.backup.')

with open(os.path.join(dst_dir, 'BackupAndRestore.java'), 'w', encoding='utf-8') as f:
    f.write(content)

print('BackupAndRestore adapted successfully!')
