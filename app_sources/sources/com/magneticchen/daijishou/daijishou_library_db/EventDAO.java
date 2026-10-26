package com.magneticchen.daijishou.daijishou_library_db;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: EventDAO.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00072\n\u0010\u000f\u001a\u00020\u0010\"\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0011H'J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0011H'J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0011H'J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0011H'J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00192\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0007H'J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u0003H'J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u0003H'J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H'J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H'J\u0018\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u0013\u001a\u00020\u0011H'J\u0012\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0011H'J\u0010\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003H'J\n\u0010#\u001a\u0004\u0018\u00010\tH'J.\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u00032\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0004H'J(\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0004H'J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J!\u0010+\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH'¢\u0006\u0002\u0010\r¨\u0006,"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/EventDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "eventEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;", "deleteAll", "eventEntities", "", "([Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;)V", "deleteAllByIds", "ids", "", "", "deleteAllByPlatformId", "id", "deleteAllByPlayableItemId", "deleteAllByPlayerId", "deleteById", "insert", "insertAll", "", "([Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;)Ljava/util/List;", "nukeTable", "selectAll", "selectAllIds", "selectAllIdsStatically", "selectAllStatically", "selectById", "selectByIdStatically", "selectLatest", "selectLatestStatically", "selectRecentByEvent", NotificationCompat.CATEGORY_EVENT, "afterDate", "Ljava/util/Date;", "limit", "selectRecentByEventStatically", ConfigConstants.CONFIG_KEY_UPDATE, "updateAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface EventDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(EventEntity eventEntity);

    void deleteAll(EventEntity... eventEntities);

    void deleteAllByIds(long... ids);

    void deleteAllByPlatformId(long id2);

    void deleteAllByPlayableItemId(long id2);

    void deleteAllByPlayerId(long id2);

    void deleteById(long id2);

    long insert(EventEntity eventEntity);

    List<Long> insertAll(EventEntity... eventEntities);

    void nukeTable();

    LiveData<List<EventEntity>> selectAll();

    LiveData<List<Long>> selectAllIds();

    List<Long> selectAllIdsStatically();

    List<EventEntity> selectAllStatically();

    LiveData<EventEntity> selectById(long id2);

    EventEntity selectByIdStatically(long id2);

    LiveData<EventEntity> selectLatest();

    EventEntity selectLatestStatically();

    LiveData<List<EventEntity>> selectRecentByEvent(int event, Date afterDate, int limit);

    List<EventEntity> selectRecentByEventStatically(int event, Date afterDate, int limit);

    void update(EventEntity eventEntity);

    void updateAll(EventEntity... eventEntities);

    /* INFO: compiled from: EventDAO.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ LiveData selectRecentByEvent$default(EventDAO eventDAO, int i, Date date, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByEvent");
            }
            if ((i3 & 4) != 0) {
                i2 = 512;
            }
            return eventDAO.selectRecentByEvent(i, date, i2);
        }

        public static /* synthetic */ List selectRecentByEventStatically$default(EventDAO eventDAO, int i, Date date, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByEventStatically");
            }
            if ((i3 & 4) != 0) {
                i2 = 512;
            }
            return eventDAO.selectRecentByEventStatically(i, date, i2);
        }
    }
}
