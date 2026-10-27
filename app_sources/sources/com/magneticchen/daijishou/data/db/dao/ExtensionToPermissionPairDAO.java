package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.ExtensionToPermissionPairEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExtensionToPermissionPairDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H'J'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u00132\u0006\u0010\u0014\u001a\u00020\fH'J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0014\u001a\u00020\fH'J\u0018\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00132\u0006\u0010\u0014\u001a\u00020\u000eH'J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u000eH'J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u00132\u0006\u0010\u0019\u001a\u00020\fH'J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0019\u001a\u00020\fH'J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/ExtensionToPermissionPairDAO;", "", "delete", "", "extensionToPermissionPairEntity", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionToPermissionPairEntity;", "deleteAll", "extensionToPermissionPairEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionToPermissionPairEntity;)V", "deleteByExtensionId", "extensionId", "", "insert", "", "insertAll", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionToPermissionPairEntity;)Ljava/util/List;", "selectByExtensionId", "Landroidx/lifecycle/LiveData;", "id", "selectByExtensionIdStatically", "selectById", "selectByIdStatically", "selectByPermission", "permission", "selectByPermissionStatically", "update", "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ExtensionToPermissionPairDAO {
    void delete(ExtensionToPermissionPairEntity extensionToPermissionPairEntity);

    void deleteAll(ExtensionToPermissionPairEntity... extensionToPermissionPairEntityArr);

    void deleteByExtensionId(String str);

    long insert(ExtensionToPermissionPairEntity extensionToPermissionPairEntity);

    List<Long> insertAll(ExtensionToPermissionPairEntity... extensionToPermissionPairEntityArr);

    LiveData<List<ExtensionToPermissionPairEntity>> selectByExtensionId(String str);

    List<ExtensionToPermissionPairEntity> selectByExtensionIdStatically(String str);

    LiveData<ExtensionToPermissionPairEntity> selectById(long j);

    ExtensionToPermissionPairEntity selectByIdStatically(long j);

    LiveData<List<ExtensionToPermissionPairEntity>> selectByPermission(String str);

    List<ExtensionToPermissionPairEntity> selectByPermissionStatically(String str);

    void update(ExtensionToPermissionPairEntity extensionToPermissionPairEntity);

    void updateAll(ExtensionToPermissionPairEntity... extensionToPermissionPairEntityArr);
}
