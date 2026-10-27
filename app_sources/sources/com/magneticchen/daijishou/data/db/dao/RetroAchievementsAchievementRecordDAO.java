package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsAchievementRecordEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: RetroAchievementsAchievementRecordDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00032\u0006\u0010\u0014\u001a\u00020\u000fH'J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0014\u001a\u00020\u000fH'J\u0018\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u0014\u001a\u00020\u000fH'J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u000fH'J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00032\u0006\u0010\u0019\u001a\u00020\u001aH'J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0019\u001a\u00020\u001aH'J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\u001d\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/RetroAchievementsAchievementRecordDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "retroAchievementsAchievementRecordEntity", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;", "deleteAll", "retroAchievementsAchievementRecordEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;)V", "insert", "", "insertAll", "", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;)Ljava/util/List;", "selectByGameRecordId", "id", "selectByGameRecordIdStatically", "selectById", "selectByIdStatically", "selectByUserId", "userId", "", "selectByUserIdStatically", "update", "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RetroAchievementsAchievementRecordDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity);

    void deleteAll(RetroAchievementsAchievementRecordEntity... retroAchievementsAchievementRecordEntityArr);

    long insert(RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity);

    List<Long> insertAll(RetroAchievementsAchievementRecordEntity... retroAchievementsAchievementRecordEntityArr);

    LiveData<List<RetroAchievementsAchievementRecordEntity>> selectByGameRecordId(long j);

    List<RetroAchievementsAchievementRecordEntity> selectByGameRecordIdStatically(long j);

    LiveData<RetroAchievementsAchievementRecordEntity> selectById(long j);

    RetroAchievementsAchievementRecordEntity selectByIdStatically(long j);

    LiveData<List<RetroAchievementsAchievementRecordEntity>> selectByUserId(String str);

    List<RetroAchievementsAchievementRecordEntity> selectByUserIdStatically(String str);

    void update(RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity);

    void updateAll(RetroAchievementsAchievementRecordEntity... retroAchievementsAchievementRecordEntityArr);
}
