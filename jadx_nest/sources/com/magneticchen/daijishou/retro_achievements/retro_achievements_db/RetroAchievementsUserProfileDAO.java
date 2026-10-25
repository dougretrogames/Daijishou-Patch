package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: RetroAchievementsUserProfileDAO.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u0014\u001a\u00020\u0015H'J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0015H'J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\u0018\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "retroAchievementsUserProfileEntity", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "deleteAll", "retroAchievementsUserProfileEntities", "", "([Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;)V", "insert", "", "insertAll", "", "([Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;)Ljava/util/List;", "selectById", "id", "", "selectByIdStatically", ConfigConstants.CONFIG_KEY_UPDATE, "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RetroAchievementsUserProfileDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity);

    void deleteAll(RetroAchievementsUserProfileEntity... retroAchievementsUserProfileEntities);

    long insert(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity);

    List<Long> insertAll(RetroAchievementsUserProfileEntity... retroAchievementsUserProfileEntities);

    LiveData<RetroAchievementsUserProfileEntity> selectById(String id2);

    RetroAchievementsUserProfileEntity selectByIdStatically(String id2);

    void update(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity);

    void updateAll(RetroAchievementsUserProfileEntity... retroAchievementsUserProfileEntities);
}
