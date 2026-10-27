import os, re

base_dir = r"build_tmp/sources_181_merged/com/magneticchen/daijishou"

files_to_fix = [
    "ui/activities/MainActivity.java",
    "ui/model/LibraryViewModel.java",
    "ui/widget/widgets/activity/ActivityWidgetContinueFaceFragment.java",
    "ui/widget/widgets/rss/RSSWidgetNavFragment.java"
]

for rel in files_to_fix:
    p = os.path.join(base_dir, rel)
    with open(p, "r", encoding="utf-8") as fp:
        c = fp.read()
    # Replace method/constructor declaration without body with {}
    new_c = re.sub(r'([A-Za-z0-9_$]+\(\s*\))\s*\n\s*(@Override|public|protected|private)', r'\1 {}\n        \2', c)
    with open(p, "w", encoding="utf-8") as fp:
        fp.write(new_c)

print("Fixed empty constructor bodies!")
