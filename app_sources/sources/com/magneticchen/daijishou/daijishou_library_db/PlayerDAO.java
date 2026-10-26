package com.magneticchen.daijishou.daijishou_library_db;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: PlayerDAO.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00072\n\u0010\u000f\u001a\u00020\u0010\"\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0011H'J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00150\u00032\u0006\u0010\u0016\u001a\u00020\u0017H'J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00152\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00150\u0003H'J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150\u0003H'J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H'J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H'J\u0018\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u0013\u001a\u00020\u0011H'J$\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00150\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H'J\u001e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H'J\u0012\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0011H'J\u0012\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\u0017H'J\u0018\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010%\u001a\u00020\u0017H'J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010(\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u0006)"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/PlayerDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "playerEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayerEntity;", "deleteAll", "playerEntities", "", "([Lcom/magneticchen/daijishou/daijishou_library_db/PlayerEntity;)V", "deleteAllByIds", "ids", "", "", "deleteById", "id", "findWithName", "", "search", "", "findWithNameStatically", "insert", "insertAll", "([Lcom/magneticchen/daijishou/daijishou_library_db/PlayerEntity;)Ljava/util/List;", "selectAll", "selectAllIds", "selectAllIdsStatically", "selectAllStatically", "selectById", "selectByIdList", "selectByIdListStatically", "selectByIdStatically", "selectByName", "name", "selectByNameStatically", ConfigConstants.CONFIG_KEY_UPDATE, "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PlayerDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(PlayerEntity playerEntity);

    void deleteAll(PlayerEntity... playerEntities);

    void deleteAllByIds(long... ids);

    void deleteById(long id2);

    LiveData<List<PlayerEntity>> findWithName(String search);

    List<PlayerEntity> findWithNameStatically(String search);

    long insert(PlayerEntity playerEntity);

    List<Long> insertAll(PlayerEntity... playerEntities);

    LiveData<List<PlayerEntity>> selectAll();

    LiveData<List<Long>> selectAllIds();

    List<Long> selectAllIdsStatically();

    List<PlayerEntity> selectAllStatically();

    LiveData<PlayerEntity> selectById(long id2);

    LiveData<List<PlayerEntity>> selectByIdList(List<Long> id2);

    List<PlayerEntity> selectByIdListStatically(List<Long> id2);

    PlayerEntity selectByIdStatically(long id2);

    PlayerEntity selectByName(String name);

    LiveData<PlayerEntity> selectByNameStatically(String name);

    void update(PlayerEntity playerEntity);

    void updateAll(PlayerEntity... playerEntities);
}
