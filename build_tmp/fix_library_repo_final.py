p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

# 1. Replace Iterator<T> with Iterator
c = c.replace('Iterator<T>', 'Iterator')

# 2. Fix line 690 map2.keySet()
c = c.replace(
    'for (String str11 : map2.keySet()) {',
    'for (Object str11_obj : map2.keySet()) {\n            String str11 = (String) str11_obj;'
)

# 3. Fix throws Exception in Function0 invoke
c = c.replace('public /* bridge */ /* synthetic */ Unit invoke() throws Exception {', 'public /* bridge */ /* synthetic */ Unit invoke() {')
c = c.replace('public final void invoke2() throws Exception {', 'public final void invoke2() {')

# 4. Fix function1 cast
c = c.replace(
    'Function1<PlatformEntity, Unit> function2 = function1;',
    'Function1 function2 = (Function1) function1;'
)

# 5. Fix Map.Entry loops around line 1193 and 1242
c = c.replace(
    'for (Map.Entry entry : linkedHashMap.entrySet()) {',
    'for (Object obj_entry : linkedHashMap.entrySet()) {\n            Map.Entry entry = (Map.Entry) obj_entry;'
)
c = c.replace(
    'for (Map.Entry entry2 : linkedHashMap.entrySet()) {',
    'for (Object obj_entry2 : linkedHashMap.entrySet()) {\n            Map.Entry entry2 = (Map.Entry) obj_entry2;'
)

# 6. Fix searchPlayableItemsByKeyword loop
old_while = '''                size = 1.0f / listFindWithNameAndDescriptionStatically$default.size();
                f += size;
                while (r9.hasNext()) {
                    if (list != null) {
                        playableItemEntityWithCount = (PlayableItemEntityWithCount) map.get(Long.valueOf(playableItemEntity.getId()));
                        if (playableItemEntityWithCount != null) {
                            playableItemEntityWithCount.setMatchCount(playableItemEntityWithCount.getMatchCount() + 1);
                            playableItemEntityWithCount.setRanking(playableItemEntityWithCount.getRanking() + size);
                        } else {
                            map.put(Long.valueOf(playableItemEntity.getId()), new PlayableItemEntityWithCount(playableItemEntity, 1, listSplit.size(), DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, 24, null));
                        }
                    } else {
                        playableItemEntityWithCount = (PlayableItemEntityWithCount) map.get(Long.valueOf(playableItemEntity.getId()));
                        if (playableItemEntityWithCount != null) {
                            playableItemEntityWithCount.setMatchCount(playableItemEntityWithCount.getMatchCount() + 1);
                            playableItemEntityWithCount.setRanking(playableItemEntityWithCount.getRanking() + size);
                        } else {
                            map.put(Long.valueOf(playableItemEntity.getId()), new PlayableItemEntityWithCount(playableItemEntity, 1, listSplit.size(), DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, 24, null));
                        }
                    }
                }'''

new_while = '''                size = 1.0f / listFindWithNameAndDescriptionStatically$default.size();
                f += size;
                for (PlayableItemEntity playableItemEntity : listFindWithNameAndDescriptionStatically$default) {
                    if (list == null || list.indexOf(Long.valueOf(playableItemEntity.getId())) < 0) {
                        playableItemEntityWithCount = (PlayableItemEntityWithCount) map.get(Long.valueOf(playableItemEntity.getId()));
                        if (playableItemEntityWithCount != null) {
                            playableItemEntityWithCount.setMatchCount(playableItemEntityWithCount.getMatchCount() + 1);
                            playableItemEntityWithCount.setRanking(playableItemEntityWithCount.getRanking() + size);
                        } else {
                            map.put(Long.valueOf(playableItemEntity.getId()), new PlayableItemEntityWithCount(playableItemEntity, 1, listSplit.size(), DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, 24, null));
                        }
                    }
                }'''
c = c.replace(old_while, new_while)

# 7. Fix comparators in searchPlayableItemsByKeyword
c = c.replace('public final int compare(T t, T t2) {', 'public final int compare(Object t, Object t2) {')

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed DaijishouLibraryRepository.java')
