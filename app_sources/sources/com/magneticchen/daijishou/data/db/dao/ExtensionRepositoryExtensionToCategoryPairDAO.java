package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToCategoryPairEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExtensionRepositoryExtensionToCategoryPairDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H'J'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00102\u0006\u0010\u0015\u001a\u00020\u000bH'J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u000bH'J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H'J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H'J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionToCategoryPairDAO;", "", "delete", "", "extensionRepositoryExtensionToCategoryPairEntity", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToCategoryPairEntity;", "deleteAll", "extensionRepositoryExtensionToCategoryPairEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToCategoryPairEntity;)V", "insert", "", "insertAll", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToCategoryPairEntity;)Ljava/util/List;", "selectByCategory", "Landroidx/lifecycle/LiveData;", "category", "", "selectByCategoryStatically", "selectById", "id", "selectByIdStatically", "selectByRepositoryIdAndExtensionId", "repositoryId", "extensionId", "selectByRepositoryIdAndExtensionIdStatically", "update", "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ExtensionRepositoryExtensionToCategoryPairDAO {
    void delete(ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity);

    void deleteAll(ExtensionRepositoryExtensionToCategoryPairEntity... extensionRepositoryExtensionToCategoryPairEntityArr);

    long insert(ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity);

    List<Long> insertAll(ExtensionRepositoryExtensionToCategoryPairEntity... extensionRepositoryExtensionToCategoryPairEntityArr);

    LiveData<List<ExtensionRepositoryExtensionToCategoryPairEntity>> selectByCategory(String str);

    List<ExtensionRepositoryExtensionToCategoryPairEntity> selectByCategoryStatically(String str);

    LiveData<ExtensionRepositoryExtensionToCategoryPairEntity> selectById(long j);

    ExtensionRepositoryExtensionToCategoryPairEntity selectByIdStatically(long j);

    LiveData<List<ExtensionRepositoryExtensionToCategoryPairEntity>> selectByRepositoryIdAndExtensionId(String str, String str2);

    List<ExtensionRepositoryExtensionToCategoryPairEntity> selectByRepositoryIdAndExtensionIdStatically(String str, String str2);

    void update(ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity);

    void updateAll(ExtensionRepositoryExtensionToCategoryPairEntity... extensionRepositoryExtensionToCategoryPairEntityArr);
}
