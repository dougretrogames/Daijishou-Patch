package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToAuthorPairEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExtensionRepositoryExtensionToAuthorPairDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H'J'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00102\u0006\u0010\u0015\u001a\u00020\u000bH'J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u000bH'J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H'J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H'J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionToAuthorPairDAO;", "", "delete", "", "extensionRepositoryExtensionToAuthorPairEntity", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToAuthorPairEntity;", "deleteAll", "extensionRepositoryExtensionToAuthorPairEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToAuthorPairEntity;)V", "insert", "", "insertAll", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToAuthorPairEntity;)Ljava/util/List;", "selectByEmail", "Landroidx/lifecycle/LiveData;", "email", "", "selectByEmailStatically", "selectById", "id", "selectByIdStatically", "selectByRepositoryIdAndExtensionId", "repositoryId", "extensionId", "selectByRepositoryIdAndExtensionIdStatically", "update", "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ExtensionRepositoryExtensionToAuthorPairDAO {
    void delete(ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity);

    void deleteAll(ExtensionRepositoryExtensionToAuthorPairEntity... extensionRepositoryExtensionToAuthorPairEntityArr);

    long insert(ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity);

    List<Long> insertAll(ExtensionRepositoryExtensionToAuthorPairEntity... extensionRepositoryExtensionToAuthorPairEntityArr);

    LiveData<List<ExtensionRepositoryExtensionToAuthorPairEntity>> selectByEmail(String str);

    List<ExtensionRepositoryExtensionToAuthorPairEntity> selectByEmailStatically(String str);

    LiveData<ExtensionRepositoryExtensionToAuthorPairEntity> selectById(long j);

    ExtensionRepositoryExtensionToAuthorPairEntity selectByIdStatically(long j);

    LiveData<List<ExtensionRepositoryExtensionToAuthorPairEntity>> selectByRepositoryIdAndExtensionId(String str, String str2);

    List<ExtensionRepositoryExtensionToAuthorPairEntity> selectByRepositoryIdAndExtensionIdStatically(String str, String str2);

    void update(ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity);

    void updateAll(ExtensionRepositoryExtensionToAuthorPairEntity... extensionRepositoryExtensionToAuthorPairEntityArr);
}
