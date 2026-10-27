import os, re

base_dir = r"build_tmp/jadx_1.8.1_no_inline/sources/com/magneticchen/daijishou"
target_files = [
    "data/db/repositories/DaijishouLibraryRepository.java",
    "features/retroachievements/RetroAchievementsManager.java",
    "ui/model/DaijishouLibraryModel.java",
    "ui/widget/widgets/category/CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1.java"
]

for tf in target_files:
    full_path = os.path.join(base_dir, tf)
    with open(full_path, encoding='utf-8') as f:
        lines = f.readlines()
    print(f"\n=== {tf} ===")
    for i, line in enumerate(lines):
        if "??" in line:
            print(f"Line {i+1}: {line.strip()}")
