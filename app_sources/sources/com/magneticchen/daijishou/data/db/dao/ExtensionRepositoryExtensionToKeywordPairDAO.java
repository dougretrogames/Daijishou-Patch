package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToKeywordPairEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExtensionRepositoryExtensionToKeywordPairDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\r\u001a\u00020\u000eH'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H'J'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b2\u0006\u0010\u0015\u001a\u00020\u0011H'J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0011H'J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000b2\u0006\u0010\u0018\u001a\u00020\u000eH'J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0018\u001a\u00020\u000eH'J$\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000b2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH'J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH'J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u001f\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005H'¢\u0006\u0002\u0010\t¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionToKeywordPairDAO;", "", "delete", "", "extensionRepositoryExtensionToKeywordPairEntity", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToKeywordPairEntity;", "deleteAll", "extensionRepositoryExtensionToKeywordPairEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToKeywordPairEntity;)V", "findWithKeyword", "Landroidx/lifecycle/LiveData;", "", "search", "", "findWithKeywordStatically", "insert", "", "insertAll", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToKeywordPairEntity;)Ljava/util/List;", "selectById", "id", "selectByIdStatically", "selectByKeyword", "keyword", "selectByKeywordStatically", "selectByRepositoryIdAndExtensionId", "repositoryId", "extensionId", "selectByRepositoryIdAndExtensionIdStatically", "update", "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ExtensionRepositoryExtensionToKeywordPairDAO {
    void delete(ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity);

    void deleteAll(ExtensionRepositoryExtensionToKeywordPairEntity... extensionRepositoryExtensionToKeywordPairEntityArr);

    LiveData<List<ExtensionRepositoryExtensionToKeywordPairEntity>> findWithKeyword(String str);

    List<ExtensionRepositoryExtensionToKeywordPairEntity> findWithKeywordStatically(String str);

    long insert(ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity);

    List<Long> insertAll(ExtensionRepositoryExtensionToKeywordPairEntity... extensionRepositoryExtensionToKeywordPairEntityArr);

    LiveData<ExtensionRepositoryExtensionToKeywordPairEntity> selectById(long j);

    ExtensionRepositoryExtensionToKeywordPairEntity selectByIdStatically(long j);

    LiveData<List<ExtensionRepositoryExtensionToKeywordPairEntity>> selectByKeyword(String str);

    List<ExtensionRepositoryExtensionToKeywordPairEntity> selectByKeywordStatically(String str);

    LiveData<List<ExtensionRepositoryExtensionToKeywordPairEntity>> selectByRepositoryIdAndExtensionId(String str, String str2);

    List<ExtensionRepositoryExtensionToKeywordPairEntity> selectByRepositoryIdAndExtensionIdStatically(String str, String str2);

    void update(ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity);

    void updateAll(ExtensionRepositoryExtensionToKeywordPairEntity... extensionRepositoryExtensionToKeywordPairEntityArr);
}
