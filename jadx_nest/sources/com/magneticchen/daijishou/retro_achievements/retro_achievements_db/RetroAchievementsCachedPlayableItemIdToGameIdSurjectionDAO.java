package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0007H'J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u00032\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0018\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0018\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\u001e\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;", "deleteAll", "retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities", "", "([Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;)V", "deleteById", "id", "", "deleteByPlayableItemId", "insert", "insertAll", "", "([Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;)Ljava/util/List;", "nukeTable", "selectByGameId", "selectByGameIdStatically", "selectById", "selectByIdStatically", "selectByPlayableItemId", "selectByPlayableItemIdStatically", ConfigConstants.CONFIG_KEY_UPDATE, "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity);

    void deleteAll(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity... retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities);

    void deleteById(long id2);

    void deleteByPlayableItemId(long id2);

    long insert(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity);

    List<Long> insertAll(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity... retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities);

    void nukeTable();

    LiveData<List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity>> selectByGameId(long id2);

    List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> selectByGameIdStatically(long id2);

    LiveData<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> selectById(long id2);

    RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity selectByIdStatically(long id2);

    LiveData<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> selectByPlayableItemId(long id2);

    RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity selectByPlayableItemIdStatically(long id2);

    void update(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity);

    void updateAll(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity... retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities);
}
