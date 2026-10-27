package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserIndependentGameRecordEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: RetroAchievementsUserIndependentGameRecordDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0016\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H'J&\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u00032\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H'J.\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0004H'J(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0004H'J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H'J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u00032\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0018\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u001f\u001a\u00020\u0010H'J\u0012\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\u0010H'J \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u00032\n\u0010\"\u001a\u00020#\"\u00020\u0010H'J\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\n\u0010\"\u001a\u00020#\"\u00020\u0010H'J\u0018\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0012\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010(\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u0006)"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/RetroAchievementsUserIndependentGameRecordDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "retroAchievementsUserIndependentGameRecordEntity", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;", "deleteAll", "retroAchievementsGameRecordEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;)V", "deleteByConsoleId", "consoleId", "", "findWithName", "", "search", "", "limit", "findWithNameAndConsoleId", "findWithNameAndConsoleIdStatically", "findWithNameStatically", "insert", "insertAll", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;)Ljava/util/List;", "selectByConsoleId", "selectByConsoleIdStatically", "selectById", "id", "selectByIdStatically", "selectByIds", "ids", "", "selectByIdsStatically", "selectFirstByConsoleId", "selectFirstByConsoleIdStatically", "update", "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RetroAchievementsUserIndependentGameRecordDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity);

    void deleteAll(RetroAchievementsUserIndependentGameRecordEntity... retroAchievementsUserIndependentGameRecordEntityArr);

    int deleteByConsoleId(long j);

    LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> findWithName(String str, int i);

    LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> findWithNameAndConsoleId(String str, long j, int i);

    List<RetroAchievementsUserIndependentGameRecordEntity> findWithNameAndConsoleIdStatically(String str, long j, int i);

    List<RetroAchievementsUserIndependentGameRecordEntity> findWithNameStatically(String str, int i);

    long insert(RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity);

    List<Long> insertAll(RetroAchievementsUserIndependentGameRecordEntity... retroAchievementsUserIndependentGameRecordEntityArr);

    LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> selectByConsoleId(long j);

    List<RetroAchievementsUserIndependentGameRecordEntity> selectByConsoleIdStatically(long j);

    LiveData<RetroAchievementsUserIndependentGameRecordEntity> selectById(long j);

    RetroAchievementsUserIndependentGameRecordEntity selectByIdStatically(long j);

    LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> selectByIds(long... jArr);

    List<RetroAchievementsUserIndependentGameRecordEntity> selectByIdsStatically(long... jArr);

    LiveData<RetroAchievementsUserIndependentGameRecordEntity> selectFirstByConsoleId(long j);

    RetroAchievementsUserIndependentGameRecordEntity selectFirstByConsoleIdStatically(long j);

    void update(RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity);

    void updateAll(RetroAchievementsUserIndependentGameRecordEntity... retroAchievementsUserIndependentGameRecordEntityArr);

    /* JADX INFO: compiled from: RetroAchievementsUserIndependentGameRecordDAO.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ LiveData findWithName$default(RetroAchievementsUserIndependentGameRecordDAO retroAchievementsUserIndependentGameRecordDAO, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithName");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return retroAchievementsUserIndependentGameRecordDAO.findWithName(str, i);
        }

        public static /* synthetic */ List findWithNameStatically$default(RetroAchievementsUserIndependentGameRecordDAO retroAchievementsUserIndependentGameRecordDAO, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithNameStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return retroAchievementsUserIndependentGameRecordDAO.findWithNameStatically(str, i);
        }

        public static /* synthetic */ LiveData findWithNameAndConsoleId$default(RetroAchievementsUserIndependentGameRecordDAO retroAchievementsUserIndependentGameRecordDAO, String str, long j, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithNameAndConsoleId");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return retroAchievementsUserIndependentGameRecordDAO.findWithNameAndConsoleId(str, j, i);
        }

        public static /* synthetic */ List findWithNameAndConsoleIdStatically$default(RetroAchievementsUserIndependentGameRecordDAO retroAchievementsUserIndependentGameRecordDAO, String str, long j, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithNameAndConsoleIdStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return retroAchievementsUserIndependentGameRecordDAO.findWithNameAndConsoleIdStatically(str, j, i);
        }
    }
}
