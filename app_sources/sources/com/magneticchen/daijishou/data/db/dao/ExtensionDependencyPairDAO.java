package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.ExtensionDependencyPairEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExtensionDependencyPairDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0016\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'J!\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0010\"\u00020\rH'¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH'J'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0010\"\u00020\rH'¢\u0006\u0002\u0010\u0016J-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u00032\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\"\u00020\u0006H'¢\u0006\u0002\u0010\u0019J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\"\u00020\u0006H'¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00032\u0006\u0010\u0005\u001a\u00020\u0013H'J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0013H'J\u001c\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00032\n\u0010\u001f\u001a\u00020 \"\u00020\u0013H'J\u0016\u0010!\u001a\u0004\u0018\u00010\r2\n\u0010\u001f\u001a\u00020 \"\u00020\u0013H'J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010\u0005\u001a\u00020\u0006H'J-\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u00032\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\"\u00020\u0006H'¢\u0006\u0002\u0010\u0019J'\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\"\u00020\u0006H'¢\u0006\u0002\u0010\u001bJ\u001c\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010\u0005\u001a\u00020\u0006H'J-\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u00032\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\"\u00020\u0006H'¢\u0006\u0002\u0010\u0019J'\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\"\u00020\u0006H'¢\u0006\u0002\u0010\u001bJ\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'J!\u0010+\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0010\"\u00020\rH'¢\u0006\u0002\u0010\u0011¨\u0006,"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/ExtensionDependencyPairDAO;", "", "countByProviderExtensionId", "Landroidx/lifecycle/LiveData;", "", "id", "", "countByProviderExtensionIdStatically", "countByRequirerExtensionId", "countByRequirerExtensionIdStatically", "delete", "", "extensionDependencyPairEntity", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionDependencyPairEntity;", "deleteAll", "extensionDependencyPairEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionDependencyPairEntity;)V", "insert", "", "insertAll", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionDependencyPairEntity;)Ljava/util/List;", "selectByBothExtensionIdsContainedInExtensionIdList", "extensionIds", "([Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "selectByBothExtensionIdsContainedInExtensionIdListStatically", "([Ljava/lang/String;)Ljava/util/List;", "selectById", "selectByIdStatically", "selectByIds", "ids", "", "selectByIdsStatically", "selectByProviderExtensionId", "selectByProviderExtensionIdStatically", "selectByProviderExtensionIds", "selectByProviderExtensionIdsStatically", "selectByRequirerExtensionId", "selectByRequirerExtensionIdStatically", "selectByRequirerExtensionIds", "selectByRequirerExtensionIdsStatically", "update", "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ExtensionDependencyPairDAO {
    LiveData<Integer> countByProviderExtensionId(String str);

    int countByProviderExtensionIdStatically(String str);

    LiveData<Integer> countByRequirerExtensionId(String str);

    int countByRequirerExtensionIdStatically(String str);

    void delete(ExtensionDependencyPairEntity extensionDependencyPairEntity);

    void deleteAll(ExtensionDependencyPairEntity... extensionDependencyPairEntityArr);

    long insert(ExtensionDependencyPairEntity extensionDependencyPairEntity);

    List<Long> insertAll(ExtensionDependencyPairEntity... extensionDependencyPairEntityArr);

    LiveData<List<ExtensionDependencyPairEntity>> selectByBothExtensionIdsContainedInExtensionIdList(String... strArr);

    List<ExtensionDependencyPairEntity> selectByBothExtensionIdsContainedInExtensionIdListStatically(String... strArr);

    LiveData<ExtensionDependencyPairEntity> selectById(long j);

    ExtensionDependencyPairEntity selectByIdStatically(long j);

    LiveData<ExtensionDependencyPairEntity> selectByIds(long... jArr);

    ExtensionDependencyPairEntity selectByIdsStatically(long... jArr);

    LiveData<List<ExtensionDependencyPairEntity>> selectByProviderExtensionId(String str);

    List<ExtensionDependencyPairEntity> selectByProviderExtensionIdStatically(String str);

    LiveData<List<ExtensionDependencyPairEntity>> selectByProviderExtensionIds(String... strArr);

    List<ExtensionDependencyPairEntity> selectByProviderExtensionIdsStatically(String... strArr);

    LiveData<List<ExtensionDependencyPairEntity>> selectByRequirerExtensionId(String str);

    List<ExtensionDependencyPairEntity> selectByRequirerExtensionIdStatically(String str);

    LiveData<List<ExtensionDependencyPairEntity>> selectByRequirerExtensionIds(String... strArr);

    List<ExtensionDependencyPairEntity> selectByRequirerExtensionIdsStatically(String... strArr);

    void update(ExtensionDependencyPairEntity extensionDependencyPairEntity);

    void updateAll(ExtensionDependencyPairEntity... extensionDependencyPairEntityArr);
}
