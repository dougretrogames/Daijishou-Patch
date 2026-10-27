p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

target = 'public final int compare(T t, T t2) {'
assert target in c, 'target not found'

c = c.replace(target, 'public final int compare(Object t, Object t2) {')

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed RetroAchievementsRepository.java successfully')
