package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: RetroAchievementsUserAwardDAO.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0016\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00162\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00160\u0003H'J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H'J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00160\u00032\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u001d\u001a\u00020\u0010H'J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u0010H'J \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00160\u00032\n\u0010 \u001a\u00020!\"\u00020\u0010H'J\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\u0010 \u001a\u00020!\"\u00020\u0010H'J\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00160\u00032\u0006\u0010\u0012\u001a\u00020\u0013H'J$\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00160\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0010H'J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0010H'J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010)\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u0006*"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "retroAchievementsUserAwardEntity", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardEntity;", "deleteAll", "retroAchievementsGameRecordEntities", "", "([Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardEntity;)V", "deleteByConsoleId", "consoleId", "", "deleteByUserId", "userId", "", "insert", "insertAll", "", "([Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardEntity;)Ljava/util/List;", "selectAll", "selectAllStatically", "selectByConsoleId", "selectByConsoleIdStatically", "selectById", "id", "selectByIdStatically", "selectByIds", "ids", "", "selectByIdsStatically", "selectByUserId", "selectByUserIdAndAwardData", "awardData", "selectByUserIdAndAwardDataStatically", "selectByUserIdStatically", ConfigConstants.CONFIG_KEY_UPDATE, "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RetroAchievementsUserAwardDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity);

    void deleteAll(RetroAchievementsUserAwardEntity... retroAchievementsGameRecordEntities);

    int deleteByConsoleId(long consoleId);

    int deleteByUserId(String userId);

    long insert(RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity);

    List<Long> insertAll(RetroAchievementsUserAwardEntity... retroAchievementsGameRecordEntities);

    LiveData<List<RetroAchievementsUserAwardEntity>> selectAll();

    List<RetroAchievementsUserAwardEntity> selectAllStatically();

    LiveData<List<RetroAchievementsUserAwardEntity>> selectByConsoleId(long consoleId);

    List<RetroAchievementsUserAwardEntity> selectByConsoleIdStatically(long consoleId);

    LiveData<RetroAchievementsUserAwardEntity> selectById(long id2);

    RetroAchievementsUserAwardEntity selectByIdStatically(long id2);

    LiveData<List<RetroAchievementsUserAwardEntity>> selectByIds(long... ids);

    List<RetroAchievementsUserAwardEntity> selectByIdsStatically(long... ids);

    LiveData<List<RetroAchievementsUserAwardEntity>> selectByUserId(String userId);

    LiveData<List<RetroAchievementsUserAwardEntity>> selectByUserIdAndAwardData(String userId, long awardData);

    List<RetroAchievementsUserAwardEntity> selectByUserIdAndAwardDataStatically(String userId, long awardData);

    List<RetroAchievementsUserAwardEntity> selectByUserIdStatically(String userId);

    void update(RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity);

    void updateAll(RetroAchievementsUserAwardEntity... retroAchievementsGameRecordEntities);
}
