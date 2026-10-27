package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.ExtensionEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExtensionDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u0003H'J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00110\u0003H'J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H'J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H'J\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u0019\u001a\u00020\u0015H'J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\u0015H'J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u0003H'J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H'J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u0003H'J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H'J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u0003H'J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u0003H'J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H'J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H'J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010$\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u0006%"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/ExtensionDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "extensionEntity", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionEntity;", "deleteAll", "extensionEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionEntity;)V", "insert", "", "insertAll", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionEntity;)Ljava/util/List;", "selectAll", "selectAllIds", "", "selectAllIdsStatically", "selectAllStatically", "selectById", "id", "selectByIdStatically", "selectEnabled", "selectEnabledStatically", "selectPreloaded", "selectPreloadedStatically", "selectTopLevel", "selectTopLevelAndEnabled", "selectTopLevelAndEnabledStatically", "selectTopLevelStatically", "update", "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ExtensionDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(ExtensionEntity extensionEntity);

    void deleteAll(ExtensionEntity... extensionEntityArr);

    long insert(ExtensionEntity extensionEntity);

    List<Long> insertAll(ExtensionEntity... extensionEntityArr);

    LiveData<List<ExtensionEntity>> selectAll();

    LiveData<List<String>> selectAllIds();

    List<String> selectAllIdsStatically();

    List<ExtensionEntity> selectAllStatically();

    LiveData<ExtensionEntity> selectById(String str);

    ExtensionEntity selectByIdStatically(String str);

    LiveData<List<ExtensionEntity>> selectEnabled();

    List<ExtensionEntity> selectEnabledStatically();

    LiveData<List<ExtensionEntity>> selectPreloaded();

    List<ExtensionEntity> selectPreloadedStatically();

    LiveData<List<ExtensionEntity>> selectTopLevel();

    LiveData<List<ExtensionEntity>> selectTopLevelAndEnabled();

    List<ExtensionEntity> selectTopLevelAndEnabledStatically();

    List<ExtensionEntity> selectTopLevelStatically();

    void update(ExtensionEntity extensionEntity);

    void updateAll(ExtensionEntity... extensionEntityArr);
}
