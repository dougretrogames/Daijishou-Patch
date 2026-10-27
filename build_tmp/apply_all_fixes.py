import os, re

base_dir = r"build_tmp/jadx_1.8.1_clean/sources/com/magneticchen/daijishou"

# 1. DaijishouLibraryRepository.java
fpath = os.path.join(base_dir, "data/db/repositories/DaijishouLibraryRepository.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('?? r12 = "";', 'String r12 = "";')
c = c.replace('?? r16 = "";', 'String r16 = "";')
c = c.replace('?? r3 = groupValues3.get(2);', 'String r3 = groupValues3.get(2);')
c = c.replace('?? r11 = r16;', 'String r11 = r16;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 2. ui/widget/widgets/category/CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1.java
fpath = os.path.join(base_dir, "ui/widget/widgets/category/CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('?? r15 = (PlayableItemEntity) obj3;', 'PlayableItemEntity r15 = (PlayableItemEntity) obj3;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 3. ui/model/DaijishouLibraryModel.java
fpath = os.path.join(base_dir, "ui/model/DaijishouLibraryModel.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('?? r18;', 'int r18 = 1;')
c = c.replace('r18 = true;', 'r18 = 1;')
c = c.replace('r18 = z3;', 'r18 = z3 ? 1 : 0;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 4. features/retroachievements/RetroAchievementsManager.java
fpath = os.path.join(base_dir, "features/retroachievements/RetroAchievementsManager.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('?? r6;', 'long r6 = 0L;')
c = c.replace('?? r7;', 'long r7 = 0L;')
c = c.replace('?? r20;', 'long r20 = 0L;')
c = c.replace('?? r21;', 'long r21 = 0L;')
c = c.replace('?? r22;', 'long r22 = 0L;')
c = c.replace('?? retroAchievementsRepository = retroAchievementsManager.getRetroAchievementsRepository();',
              'com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository = retroAchievementsManager.getRetroAchievementsRepository();')
c = c.replace('?? r23 = r6;', 'long r23 = r6;')
c = c.replace('?? retroAchievementsRepository3 = retroAchievementsManager.getRetroAchievementsRepository();',
              'com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository3 = retroAchievementsManager.getRetroAchievementsRepository();')
c = c.replace('?? r24 = r6;', 'long r24 = r6;')
c = c.replace('?? retroAchievementsRepository5 = retroAchievementsManager.getRetroAchievementsRepository();',
              'com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository5 = retroAchievementsManager.getRetroAchievementsRepository();')
c = c.replace('?? r25 = r6;', 'long r25 = r6;')
c = c.replace('?? retroAchievementsRepository7 = retroAchievementsManager.getRetroAchievementsRepository();',
              'com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository7 = retroAchievementsManager.getRetroAchievementsRepository();')
c = c.replace('?? r26 = r6;', 'long r26 = r6;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 5. Fix truncated sortedByDesc classes (remove public so filename mismatch is not an error)
for fn in [
    "RetroAchievementsRepository$searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$$inlined$sortedByDesc109.java",
    "RetroAchievementsRepository$searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$$inlined$sortedByDesc112.java"
]:
    p = os.path.join(base_dir, "data/db/repositories", fn)
    if os.path.exists(p):
        with open(p, "r", encoding="utf-8") as f:
            content = f.read()
        content = content.replace("public final class RetroAchievementsRepository", "final class RetroAchievementsRepository")
        with open(p, "w", encoding="utf-8") as f:
            f.write(content)

# 6. Fix Kotlin facade renames
RENAMES = {
    'BuildersKt__Builders_commonKt': 'BuildersKt',
    'JobKt__JobKt': 'JobKt',
    'FlowKt__ErrorsKt': 'FlowKt',
}
facade_count = 0
for root, dirs, files in os.walk(base_dir):
    for f in files:
        if f.endswith('.java'):
            p = os.path.join(root, f)
            with open(p, 'r', encoding='utf-8') as fh:
                s = fh.read()
            new_s = s
            for a, b in RENAMES.items():
                new_s = new_s.replace(a, b)
            if new_s != s:
                with open(p, 'w', encoding='utf-8') as fh:
                    fh.write(new_s)
                facade_count += 1
print(f"Facade renames applied to {facade_count} files.")

print("All fixes applied!")
