package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: RetroAchievementsGameRecordDAO.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00032\u0006\u0010\u0014\u001a\u00020\u000fH'J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0014\u001a\u00020\u000fH'J\u0018\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u0014\u001a\u00020\u000fH'J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u000fH'J \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00032\n\u0010\u0019\u001a\u00020\u001a\"\u00020\u000fH'J\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\n\u0010\u0019\u001a\u00020\u001a\"\u00020\u000fH'J\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00032\u0006\u0010\u0014\u001a\u00020\u001dH'J \u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u000fH'J\u001a\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u000fH'J(\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00032\u0006\u0010\u001f\u001a\u00020\u001d2\n\u0010#\u001a\u00020\u001a\"\u00020\u000fH'J\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u001f\u001a\u00020\u001d2\n\u0010#\u001a\u00020\u001a\"\u00020\u000fH'J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0014\u001a\u00020\u001dH'J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010'\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u0006("}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "retroAchievementsGameRecordEntity", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "deleteAll", "retroAchievementsGameRecordEntities", "", "([Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;)V", "insert", "", "insertAll", "", "([Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;)Ljava/util/List;", "selectByGameId", "id", "selectByGameIdStatically", "selectById", "selectByIdStatically", "selectByIds", "ids", "", "selectByIdsStatically", "selectByUserId", "", "selectByUserIdAndGameId", "userId", "gameId", "selectByUserIdAndGameIdStatically", "selectByUserIdAndGameIds", "gameIds", "selectByUserIdAndGameIdsStatically", "selectByUserIdStatically", ConfigConstants.CONFIG_KEY_UPDATE, "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RetroAchievementsGameRecordDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity);

    void deleteAll(RetroAchievementsGameRecordEntity... retroAchievementsGameRecordEntities);

    long insert(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity);

    List<Long> insertAll(RetroAchievementsGameRecordEntity... retroAchievementsGameRecordEntities);

    LiveData<List<RetroAchievementsGameRecordEntity>> selectByGameId(long id2);

    List<RetroAchievementsGameRecordEntity> selectByGameIdStatically(long id2);

    LiveData<RetroAchievementsGameRecordEntity> selectById(long id2);

    RetroAchievementsGameRecordEntity selectByIdStatically(long id2);

    LiveData<List<RetroAchievementsGameRecordEntity>> selectByIds(long... ids);

    List<RetroAchievementsGameRecordEntity> selectByIdsStatically(long... ids);

    LiveData<List<RetroAchievementsGameRecordEntity>> selectByUserId(String id2);

    LiveData<RetroAchievementsGameRecordEntity> selectByUserIdAndGameId(String userId, long gameId);

    RetroAchievementsGameRecordEntity selectByUserIdAndGameIdStatically(String userId, long gameId);

    LiveData<List<RetroAchievementsGameRecordEntity>> selectByUserIdAndGameIds(String userId, long... gameIds);

    List<RetroAchievementsGameRecordEntity> selectByUserIdAndGameIdsStatically(String userId, long... gameIds);

    List<RetroAchievementsGameRecordEntity> selectByUserIdStatically(String id2);

    void update(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity);

    void updateAll(RetroAchievementsGameRecordEntity... retroAchievementsGameRecordEntities);
}
