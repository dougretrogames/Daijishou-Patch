import os

jadx_dir = r"build_tmp/jadx_1.8.1_no_inline/sources/com/magneticchen/daijishou"

# 1. DaijishouLibraryRepository.java
fpath = os.path.join(jadx_dir, "data/db/repositories/DaijishouLibraryRepository.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('?? r12 = "";', 'String r12 = "";')
c = c.replace('?? r16 = "";', 'String r16 = "";')
c = c.replace('?? r3 = groupValues3.get(2);', 'String r3 = groupValues3.get(2);')
c = c.replace('?? r11 = r16;', 'String r11 = r16;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 2. ui/widget/widgets/category/CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1.java
fpath = os.path.join(jadx_dir, "ui/widget/widgets/category/CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('?? r15 = (PlayableItemEntity) obj3;', 'PlayableItemEntity r15 = (PlayableItemEntity) obj3;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 3. ui/model/DaijishouLibraryModel.java
fpath = os.path.join(jadx_dir, "ui/model/DaijishouLibraryModel.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
# Replace ?? r18; and r18 = true; r18 = z3; pairArr[r18]
c = c.replace('?? r18;', 'int r18 = 1;')
c = c.replace('r18 = true;', 'r18 = 1;')
c = c.replace('r18 = z3;', 'r18 = z3 ? 1 : 0;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 4. features/retroachievements/RetroAchievementsManager.java
fpath = os.path.join(jadx_dir, "features/retroachievements/RetroAchievementsManager.java")
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

print("Fixes applied successfully!")
