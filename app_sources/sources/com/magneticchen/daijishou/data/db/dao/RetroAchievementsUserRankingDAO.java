package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserRankingEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: RetroAchievementsUserRankingDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u0014\u001a\u00020\u000fH'J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u000fH'J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00032\u0006\u0010\u0017\u001a\u00020\u0018H'J$\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H'J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H'J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0017\u001a\u00020\u0018H'J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\u001e\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/RetroAchievementsUserRankingDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "retroAchievementsUserRankingEntity", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserRankingEntity;", "deleteAll", "retroAchievementsUserRankingEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserRankingEntity;)V", "insert", "", "insertAll", "", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserRankingEntity;)Ljava/util/List;", "selectById", "id", "selectByIdStatically", "selectByPerspective", "whosePerspective", "", "selectByPerspectiveAndGranularity", "granularity", "selectByPerspectiveAndGranularityStatically", "selectByPerspectiveStatically", "update", "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RetroAchievementsUserRankingDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity);

    void deleteAll(RetroAchievementsUserRankingEntity... retroAchievementsUserRankingEntityArr);

    long insert(RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity);

    List<Long> insertAll(RetroAchievementsUserRankingEntity... retroAchievementsUserRankingEntityArr);

    LiveData<RetroAchievementsUserRankingEntity> selectById(long j);

    RetroAchievementsUserRankingEntity selectByIdStatically(long j);

    LiveData<List<RetroAchievementsUserRankingEntity>> selectByPerspective(String str);

    LiveData<List<RetroAchievementsUserRankingEntity>> selectByPerspectiveAndGranularity(String str, int i);

    List<RetroAchievementsUserRankingEntity> selectByPerspectiveAndGranularityStatically(String str, int i);

    List<RetroAchievementsUserRankingEntity> selectByPerspectiveStatically(String str);

    void update(RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity);

    void updateAll(RetroAchievementsUserRankingEntity... retroAchievementsUserRankingEntityArr);
}
