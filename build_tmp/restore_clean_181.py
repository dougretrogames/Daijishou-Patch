import os, shutil

base_default = 'build_tmp/jadx_1.8.1_default/sources/com/magneticchen/daijishou'
base_merged = 'build_tmp/sources_181_merged/com/magneticchen/daijishou'

# 1. Clean aux files in ui/model that are from 1.5.0
for d in ['ui/model', 'features', 'features/retroachievements']:
    target_d = os.path.join(base_merged, d)
    default_d = os.path.join(base_default, d)
    if not os.path.exists(default_d):
        continue
    default_files = set(os.listdir(default_d))
    for f in os.listdir(target_d):
        if f not in default_files and '$' in f:
            p = os.path.join(target_d, f)
            if os.path.isfile(p):
                os.remove(p)

# 2. Restore the original 1.8.1 versions of the 4 files
files_to_restore = [
    'ui/model/DaijishouSynchronizationModel.java',
    'ui/model/DaijishouLibraryModel.java',
    'ui/model/SynchronizationOfPlatform.java',
    'features/GoogleDrive.java',
    'features/retroachievements/RetroAchievementsManager.java'
]

for f in files_to_restore:
    src = os.path.join(base_default, f)
    dst = os.path.join(base_merged, f)
    shutil.copy(src, dst)

print('Restored 1.8.1 clean files!')
