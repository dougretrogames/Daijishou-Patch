import re, os

classes_to_check = [
    ("activities/MainActivity.java", "ui/activities/MainActivity.java"),
    ("DaijishouApplication.java", "DaijishouApplication.java"),
    ("repositories/DaijishouLibraryRepository.java", "data/db/repositories/DaijishouLibraryRepository.java"),
    ("retro_achievements/RetroAchievementsManager.java", "features/retroachievements/RetroAchievementsManager.java"),
    ("daijishou_widget/WidgetsManager.java", "ui/widget/WidgetsManager.java"),
    ("cache/CachedBitmapLoader.java", "cache/CachedBitmapLoader.java"),
    ("audio/AudioManager.java", "features/AudioManager.java"),
    ("backup_and_restore/BackupAndRestore.java", "data/backup/BackupAndRestore.java"),
    ("activities/DaijishouAppCompatActivity.java", "ui/activities/abstract_classes/DaijishouAppCompatActivity.java"),
    ("daijishou_recycler_view/DaijishouRecyclerView.java", "ui/daijishou_recycler_view/DaijishouRecyclerView.java")
]

def extract_method_signatures(filepath):
    if not os.path.exists(filepath):
        return set()
    with open(filepath, encoding='utf-8', errors='replace') as f:
        content = f.read()
    # find methods: (public|protected|private|static|final) ... name(...)
    methods = set()
    pattern = r'(?:public|protected|private)\s+[\w\<\>\[\]\,\s\?]+\s+([a-zA-Z0-9_]+)\s*\([^\)]*\)'
    for m in re.finditer(pattern, content):
        name = m.group(1)
        if name not in ['if', 'while', 'for', 'switch', 'catch']:
            methods.add(name)
    return methods

for old_rel, new_rel in classes_to_check:
    old_p = os.path.join("app_sources/sources/com/magneticchen/daijishou", old_rel)
    new_p = os.path.join("build_tmp/jadx_1.8.1_clean/sources/com/magneticchen/daijishou", new_rel)
    old_m = extract_method_signatures(old_p)
    new_m = extract_method_signatures(new_p)
    added = new_m - old_m
    removed = old_m - new_m
    print(f"\n=== {os.path.basename(old_rel)} ===")
    print(f"Old methods: {len(old_m)}, New methods: {len(new_m)}")
    if added:
        print(f"  Added in 1.8.1: {sorted(added)}")
    if removed:
        print(f"  Removed in 1.8.1: {sorted(removed)}")
    if not added and not removed:
        print("  Identical method set!")
