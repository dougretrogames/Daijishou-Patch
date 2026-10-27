import os

base_dir = r"build_tmp/jadx_1.8.1_clean/sources/com/magneticchen/daijishou"

def show_snippet(rel_path, target_line):
    full_path = os.path.join(base_dir, rel_path)
    if not os.path.exists(full_path):
        print(f"File not found: {full_path}")
        return
    with open(full_path, encoding='utf-8') as f:
        lines = f.readlines()
    start = max(0, target_line - 10)
    end = min(len(lines), target_line + 10)
    print(f"\n--- {rel_path} (around line {target_line}) ---")
    for i in range(start, end):
        prefix = ">> " if (i + 1) == target_line else "   "
        print(f"{prefix}{i+1}: {lines[i]}", end='')

show_snippet(r"features\retroachievements\v2\RetroAchievementsManager.java", 427)
show_snippet(r"ui\widget\widgets\rss\RSSWidgetNavFragment.java", 194)
show_snippet(r"data\db\repositories\DaijishouExtensionRepository.java", 255)
show_snippet(r"features\retroachievements\v2\RetroAchievementsManager$refreshUserProfile$3$emit$1.java", 19)
show_snippet(r"ui\activities\abstract_classes\DaijishouServiceLauncher$serviceConnection$1.java", 13)
show_snippet(r"data\live\ConnectionLiveData.java", 77)
