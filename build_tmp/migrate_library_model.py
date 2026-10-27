import os

src_dir = 'app_sources/sources/com/magneticchen/daijishou/view_models'
dst_dir = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/model'

new_methods = '''
    public final com.magneticchen.daijishou.data.db.entity.portables.PlatformShareable exportPlatform(com.magneticchen.daijishou.data.db.entity.PlatformEntity platformEntity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        java.util.List<Long> playerIdList = platformEntity.getPlayerIdList();
        com.magneticchen.daijishou.data.db.entity.portables.PlatformEntityPortable platformEntityPortable = new com.magneticchen.daijishou.data.db.entity.portables.PlatformEntityPortable(platformEntity.getName(), platformEntity.getUniqueId(), platformEntity.getShortname(), platformEntity.getDescription(), platformEntity.getAcceptedFilenameRegex(), platformEntity.getScraperSourceList(), platformEntity.getBoxArtAspectRatioId(), platformEntity.getUseCustomBoxArtAspectRatio(), platformEntity.getCustomBoxArtAspectRatio(), platformEntity.getScreenAspectRatioId(), platformEntity.getUseCustomScreenAspectRatio(), platformEntity.getCustomScreenAspectRatio(), (java.util.List) null, platformEntity.getExtra(), 4096, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        int size = playerIdList.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i = 0; i < size; i++) {
            com.magneticchen.daijishou.data.db.entity.PlayerEntity playerByIdStatically = this.daijishouLibraryRepository.getPlayerByIdStatically(playerIdList.get(i).longValue());
            arrayList.add(playerByIdStatically == null ? null : new com.magneticchen.daijishou.data.db.entity.portables.PlayerEntityPortable(playerByIdStatically.getName(), playerByIdStatically.getUniqueId(), playerByIdStatically.getDescription(), playerByIdStatically.getAcceptedFilenameRegex(), playerByIdStatically.getAmStartArguments(), playerByIdStatically.getKillPackageProcesses(), playerByIdStatically.getKillPackageProcessesWarning(), playerByIdStatically.getExtra()));
        }
        java.util.ArrayList arrayList2 = arrayList;
        java.util.Collections.swap(arrayList2, playerIdList.indexOf(Long.valueOf(platformEntity.getDefaultPlayerId())), 0);
        return new com.magneticchen.daijishou.data.db.entity.portables.PlatformShareable(20, platformEntityPortable, kotlin.collections.CollectionsKt.filterNotNull(arrayList2));
    }

    public final com.magneticchen.daijishou.data.db.entity.portables.FavoriteItemsShareable exportPlatformFavoriteItems(com.magneticchen.daijishou.data.db.entity.PlatformEntity platformEntity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        java.util.List favoritePlayableItemsByAttachedPlatformIdStatically$default = com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository.getFavoritePlayableItemsByAttachedPlatformIdStatically$default(this.daijishouLibraryRepository, platformEntity.getId(), 0, 2, null);
        int size = favoritePlayableItemsByAttachedPlatformIdStatically$default.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((com.magneticchen.daijishou.data.db.entity.PlayableItemEntity) favoritePlayableItemsByAttachedPlatformIdStatically$default.get(i)).getMd5());
        }
        return new com.magneticchen.daijishou.data.db.entity.portables.FavoriteItemsShareable(20, arrayList);
    }

    public final com.magneticchen.daijishou.data.db.entity.PlayableItemEntity toggleIsPlayableItemCompleted(com.magneticchen.daijishou.data.db.entity.PlayableItemEntity playableItemEntity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        com.magneticchen.daijishou.data.db.entity.PlayableItemEntity playableItemEntityCopy$default = com.magneticchen.daijishou.data.db.entity.PlayableItemEntity.copy$default(playableItemEntity, 0L, null, false, false, null, 0, null, false, null, null, false, false, false, false, null, null, null, null, null, null, false, null, 0, null, null, false, false, null, 268435455, null);
        if (getDefaultSharedPreferences().getBoolean(com.magneticchen.daijishou.data.BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), com.magneticchen.daijishou.data.BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()) && playableItemEntity.getDisjointSetPrimaryPlayableItemId() != null) {
            injectPlayableItemWithMergedInfo(playableItemEntityCopy$default);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator it = playableItemEntityCopy$default.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds().iterator();
            while (it.hasNext()) {
                com.magneticchen.daijishou.data.db.entity.PlayableItemEntity playableItemByIdStatically = this.daijishouLibraryRepository.getPlayableItemByIdStatically(((Number) it.next()).longValue());
                if (playableItemByIdStatically != null) {
                    playableItemByIdStatically.setCompleted(!playableItemEntityCopy$default.getMergedInfo().getMergedIsCompleted());
                    arrayList.add(playableItemByIdStatically);
                }
            }
            com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
            com.magneticchen.daijishou.data.db.entity.PlayableItemEntity[] playableItemEntityArr = (com.magneticchen.daijishou.data.db.entity.PlayableItemEntity[]) arrayList.toArray(new com.magneticchen.daijishou.data.db.entity.PlayableItemEntity[0]);
            daijishouLibraryRepository.updatePlayableItems((com.magneticchen.daijishou.data.db.entity.PlayableItemEntity[]) java.util.Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
            playableItemEntityCopy$default.setCompleted(!playableItemEntityCopy$default.getMergedInfo().getMergedIsCompleted());
            playableItemEntityCopy$default.getMergedInfo().setMergedIsCompleted(!playableItemEntityCopy$default.getMergedInfo().getMergedIsCompleted());
            return playableItemEntityCopy$default;
        }
        playableItemEntityCopy$default.setCompleted(!playableItemEntityCopy$default.isCompleted());
        this.daijishouLibraryRepository.updatePlayableItem(playableItemEntityCopy$default);
        return playableItemEntityCopy$default;
    }
'''

for fname in os.listdir(src_dir):
    if fname.startswith('DaijishouLibraryModel'):
        src_p = os.path.join(src_dir, fname)
        dst_p = os.path.join(dst_dir, fname)
        with open(src_p, 'r', encoding='utf-8') as f:
            c = f.read()
        c = c.replace('package com.magneticchen.daijishou.view_models;', 'package com.magneticchen.daijishou.ui.model;')
        c = c.replace('com.magneticchen.daijishou.view_models.', 'com.magneticchen.daijishou.ui.model.')
        c = c.replace('com.magneticchen.daijishou.repositories.', 'com.magneticchen.daijishou.data.db.repositories.')
        c = c.replace('com.magneticchen.daijishou.daijishou_library_db.portables.', 'com.magneticchen.daijishou.data.db.entity.portables.')
        c = c.replace('com.magneticchen.daijishou.daijishou_library_db.', 'com.magneticchen.daijishou.data.db.entity.')
        c = c.replace('com.magneticchen.daijishou.activities.', 'com.magneticchen.daijishou.ui.activities.')
        c = c.replace('com.magneticchen.daijishou.application_data.', 'com.magneticchen.daijishou.data.')
        c = c.replace('com.magneticchen.daijishou.scraper.', 'com.magneticchen.daijishou.data.scraper.')
        c = c.replace('com.magneticchen.daijishou.retro_achievements.', 'com.magneticchen.daijishou.features.retroachievements.')
        
        if fname == 'DaijishouLibraryModel.java':
            # Append new methods before the last closing brace
            last_brace_idx = c.rfind('}')
            c = c[:last_brace_idx] + new_methods + '\n}\n'
            
        with open(dst_p, 'w', encoding='utf-8') as f:
            f.write(c)

print('Migrated DaijishouLibraryModel!')
