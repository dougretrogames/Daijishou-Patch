package com.magneticchen.daijishou.daijishou_library_db;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: PlatformDAO.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001a\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0003H'J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\u0003H'J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u000fH'J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0003H'J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u0018\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\"\u001a\u00020\u0018H'J\u0012\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u0018H'J\u0018\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010%\u001a\u00020\u0011H'J\u0012\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\u0011H'J\u0018\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010(\u001a\u00020\u0011H'J\u0012\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010(\u001a\u00020\u0011H'J\u0014\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0003H'J\u0014\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0003H'J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010/\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0012\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u0011H'¨\u00062"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/PlatformDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "platformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "deleteAll", "platformEntities", "", "([Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;)V", "findWithBothNameAndShortName", "", "search", "", "findWithBothNameAndShortNameStatically", "findWithName", "findWithNameStatically", "findWithShortName", "findWithShortNameStatically", "insert", "", "insertAll", "([Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;)Ljava/util/List;", "selectAll", "selectAllIds", "selectAllIdsStatically", "selectAllOrderedByShortName", "selectAllOrderedByShortNameStatically", "selectAllStatically", "selectById", "id", "selectByIdStatically", "selectByShortname", "shortname", "selectByShortnameStatically", "selectByUniqueId", "uniqueId", "selectByUniqueIdStatically", "selectVisible", "selectVisibleOrderedByShortName", "selectVisibleOrderedByShortNameStatically", "selectVisibleStatically", ConfigConstants.CONFIG_KEY_UPDATE, "updateAll", "updateWallpaperPathAll", "wallpaperPath", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PlatformDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(PlatformEntity platformEntity);

    void deleteAll(PlatformEntity... platformEntities);

    LiveData<List<PlatformEntity>> findWithBothNameAndShortName(String search);

    List<PlatformEntity> findWithBothNameAndShortNameStatically(String search);

    LiveData<List<PlatformEntity>> findWithName(String search);

    List<PlatformEntity> findWithNameStatically(String search);

    LiveData<List<PlatformEntity>> findWithShortName(String search);

    List<PlatformEntity> findWithShortNameStatically(String search);

    long insert(PlatformEntity platformEntity);

    List<Long> insertAll(PlatformEntity... platformEntities);

    LiveData<List<PlatformEntity>> selectAll();

    LiveData<List<Long>> selectAllIds();

    List<Long> selectAllIdsStatically();

    LiveData<List<PlatformEntity>> selectAllOrderedByShortName();

    List<PlatformEntity> selectAllOrderedByShortNameStatically();

    List<PlatformEntity> selectAllStatically();

    LiveData<PlatformEntity> selectById(long id2);

    PlatformEntity selectByIdStatically(long id2);

    LiveData<PlatformEntity> selectByShortname(String shortname);

    PlatformEntity selectByShortnameStatically(String shortname);

    LiveData<PlatformEntity> selectByUniqueId(String uniqueId);

    PlatformEntity selectByUniqueIdStatically(String uniqueId);

    LiveData<List<PlatformEntity>> selectVisible();

    LiveData<List<PlatformEntity>> selectVisibleOrderedByShortName();

    List<PlatformEntity> selectVisibleOrderedByShortNameStatically();

    List<PlatformEntity> selectVisibleStatically();

    void update(PlatformEntity platformEntity);

    void updateAll(PlatformEntity... platformEntities);

    void updateWallpaperPathAll(String wallpaperPath);
}
