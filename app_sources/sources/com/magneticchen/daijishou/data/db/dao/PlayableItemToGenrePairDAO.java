package com.magneticchen.daijishou.data.db.dao;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.PlayableItemToGenrePairEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlayableItemToGenrePairDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0012H'J\u0014\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u00020\u0015\"\u00020\u0012H'J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0012H'J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00192\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0007H'J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u0003H'J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190\u0003H'J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019H'J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00190\u0003H'J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H'J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H'J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u00032\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u000f\u001a\u00020\u0012H'J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0012H'J\u001c\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u00032\u0006\u0010\u000f\u001a\u00020\u0012H'J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0006\u0010\u000f\u001a\u00020\u0012H'J\u001c\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190\u00032\u0006\u0010\u000f\u001a\u00020\u0012H'J&\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190\u00032\u0006\u0010\u000f\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020+H'J \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\u000f\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020+H'J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\u000f\u001a\u00020\u0012H'J\u001c\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190\u00032\u0006\u0010\u000f\u001a\u00020\u0012H'J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\u000f\u001a\u00020\u0012H'J\u001c\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00190\u00032\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120\u00192\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u00102\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u00103\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u00064"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/PlayableItemToGenrePairDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "playableItemToGenrePairEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;", "deleteAll", "playableItemToGenrePairEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;)V", "deleteByGenreId", "id", "", "deleteById", "", "deleteByIds", "ids", "", "deleteByPlayableItemId", "insert", "insertAll", "", "([Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;)Ljava/util/List;", "nukeTable", "selectAll", "selectAllGenreIds", "selectAllGenreIdsStatically", "selectAllIds", "selectAllIdsStatically", "selectAllStatically", "selectByGenreId", "selectByGenreIdStatically", "selectById", "selectByIdStatically", "selectByPlayableItemId", "selectByPlayableItemIdStatically", "selectGenreIdsByPlatformId", "selectGenreIdsByPlatformIdAndVisibility", "visibility", "", "selectGenreIdsByPlatformIdAndVisibilityStatically", "selectGenreIdsByPlatformIdStatically", "selectGenreIdsByPlayableItemId", "selectGenreIdsByPlayableItemIdStatically", "selectPlayableItemIdsByGenreId", "selectPlayableItemIdsByGenreIdStatically", "update", "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PlayableItemToGenrePairDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(PlayableItemToGenrePairEntity playableItemToGenrePairEntity);

    void deleteAll(PlayableItemToGenrePairEntity... playableItemToGenrePairEntityArr);

    void deleteByGenreId(String str);

    void deleteById(long j);

    void deleteByIds(long... jArr);

    void deleteByPlayableItemId(long j);

    long insert(PlayableItemToGenrePairEntity playableItemToGenrePairEntity);

    List<Long> insertAll(PlayableItemToGenrePairEntity... playableItemToGenrePairEntityArr);

    void nukeTable();

    LiveData<List<PlayableItemToGenrePairEntity>> selectAll();

    LiveData<List<String>> selectAllGenreIds();

    List<String> selectAllGenreIdsStatically();

    LiveData<List<Long>> selectAllIds();

    List<Long> selectAllIdsStatically();

    List<PlayableItemToGenrePairEntity> selectAllStatically();

    LiveData<List<PlayableItemToGenrePairEntity>> selectByGenreId(String str);

    List<PlayableItemToGenrePairEntity> selectByGenreIdStatically(String str);

    LiveData<PlayableItemToGenrePairEntity> selectById(long j);

    PlayableItemToGenrePairEntity selectByIdStatically(long j);

    LiveData<List<PlayableItemToGenrePairEntity>> selectByPlayableItemId(long j);

    List<PlayableItemToGenrePairEntity> selectByPlayableItemIdStatically(long j);

    LiveData<List<String>> selectGenreIdsByPlatformId(long j);

    LiveData<List<String>> selectGenreIdsByPlatformIdAndVisibility(long j, boolean z);

    List<String> selectGenreIdsByPlatformIdAndVisibilityStatically(long j, boolean z);

    List<String> selectGenreIdsByPlatformIdStatically(long j);

    LiveData<List<String>> selectGenreIdsByPlayableItemId(long j);

    List<String> selectGenreIdsByPlayableItemIdStatically(long j);

    LiveData<List<Long>> selectPlayableItemIdsByGenreId(String str);

    List<Long> selectPlayableItemIdsByGenreIdStatically(String str);

    void update(PlayableItemToGenrePairEntity playableItemToGenrePairEntity);

    void updateAll(PlayableItemToGenrePairEntity... playableItemToGenrePairEntityArr);

    /* JADX INFO: compiled from: PlayableItemToGenrePairDAO.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ LiveData selectGenreIdsByPlatformIdAndVisibility$default(PlayableItemToGenrePairDAO playableItemToGenrePairDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectGenreIdsByPlatformIdAndVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemToGenrePairDAO.selectGenreIdsByPlatformIdAndVisibility(j, z);
        }

        public static /* synthetic */ List selectGenreIdsByPlatformIdAndVisibilityStatically$default(PlayableItemToGenrePairDAO playableItemToGenrePairDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectGenreIdsByPlatformIdAndVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemToGenrePairDAO.selectGenreIdsByPlatformIdAndVisibilityStatically(j, z);
        }
    }
}
