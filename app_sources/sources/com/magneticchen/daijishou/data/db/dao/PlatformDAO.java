package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlatformDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001a\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0003H'J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\u0003H'J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u000fH'J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0003H'J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u0018\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\"\u001a\u00020\u0018H'J\u0012\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u0018H'J\u0018\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010%\u001a\u00020\u0011H'J\u0012\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\u0011H'J\u0018\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010(\u001a\u00020\u0011H'J\u0012\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010(\u001a\u00020\u0011H'J\u0014\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0003H'J\u0014\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0003H'J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010/\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0012\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u0011H'¨\u00062"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/PlatformDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "platformEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "deleteAll", "platformEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;)V", "findWithBothNameAndShortName", "", "search", "", "findWithBothNameAndShortNameStatically", "findWithName", "findWithNameStatically", "findWithShortName", "findWithShortNameStatically", "insert", "", "insertAll", "([Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;)Ljava/util/List;", "selectAll", "selectAllIds", "selectAllIdsStatically", "selectAllOrderedByShortName", "selectAllOrderedByShortNameStatically", "selectAllStatically", "selectById", "id", "selectByIdStatically", "selectByShortname", "shortname", "selectByShortnameStatically", "selectByUniqueId", "uniqueId", "selectByUniqueIdStatically", "selectVisible", "selectVisibleOrderedByShortName", "selectVisibleOrderedByShortNameStatically", "selectVisibleStatically", "update", "updateAll", "updateWallpaperPathAll", "wallpaperPath", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PlatformDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(PlatformEntity platformEntity);

    void deleteAll(PlatformEntity... platformEntityArr);

    LiveData<List<PlatformEntity>> findWithBothNameAndShortName(String str);

    List<PlatformEntity> findWithBothNameAndShortNameStatically(String str);

    LiveData<List<PlatformEntity>> findWithName(String str);

    List<PlatformEntity> findWithNameStatically(String str);

    LiveData<List<PlatformEntity>> findWithShortName(String str);

    List<PlatformEntity> findWithShortNameStatically(String str);

    long insert(PlatformEntity platformEntity);

    List<Long> insertAll(PlatformEntity... platformEntityArr);

    LiveData<List<PlatformEntity>> selectAll();

    LiveData<List<Long>> selectAllIds();

    List<Long> selectAllIdsStatically();

    LiveData<List<PlatformEntity>> selectAllOrderedByShortName();

    List<PlatformEntity> selectAllOrderedByShortNameStatically();

    List<PlatformEntity> selectAllStatically();

    LiveData<PlatformEntity> selectById(long j);

    PlatformEntity selectByIdStatically(long j);

    LiveData<PlatformEntity> selectByShortname(String str);

    PlatformEntity selectByShortnameStatically(String str);

    LiveData<PlatformEntity> selectByUniqueId(String str);

    PlatformEntity selectByUniqueIdStatically(String str);

    LiveData<List<PlatformEntity>> selectVisible();

    LiveData<List<PlatformEntity>> selectVisibleOrderedByShortName();

    List<PlatformEntity> selectVisibleOrderedByShortNameStatically();

    List<PlatformEntity> selectVisibleStatically();

    void update(PlatformEntity platformEntity);

    void updateAll(PlatformEntity... platformEntityArr);

    void updateWallpaperPathAll(String str);
}
