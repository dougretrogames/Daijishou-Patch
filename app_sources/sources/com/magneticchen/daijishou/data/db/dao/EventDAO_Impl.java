package com.magneticchen.daijishou.data.db.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.magneticchen.daijishou.data.RoomDatabaseConverters;
import com.magneticchen.daijishou.data.db.entity.EventEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class EventDAO_Impl implements EventDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<EventEntity> __deletionAdapterOfEventEntity;
    private final EntityInsertionAdapter<EventEntity> __insertionAdapterOfEventEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllByPlatformId;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllByPlayableItemId;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllByPlayerId;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final SharedSQLiteStatement __preparedStmtOfNukeTable;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<EventEntity> __updateAdapterOfEventEntity;

    public EventDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfEventEntity = new EntityInsertionAdapter<EventEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `EventEntity` (`id`,`event`,`timestamp`,`playable_item_id`,`platform_id`,`player_id`,`parcelable`,`extra`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final EventEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getEvent());
                Long lFromDate = EventDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getTimestamp());
                if (lFromDate == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindLong(3, lFromDate.longValue());
                }
                if (entity.getPlayableItemId() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, entity.getPlayableItemId().longValue());
                }
                if (entity.getPlatformId() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindLong(5, entity.getPlatformId().longValue());
                }
                if (entity.getPlayerId() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindLong(6, entity.getPlayerId().longValue());
                }
                String strFromParcelable = EventDAO_Impl.this.__roomDatabaseConverters.fromParcelable(entity.getParcelable());
                if (strFromParcelable == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, strFromParcelable);
                }
                statement.bindString(8, entity.getExtra());
            }
        };
        this.__deletionAdapterOfEventEntity = new EntityDeletionOrUpdateAdapter<EventEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `EventEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final EventEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfEventEntity = new EntityDeletionOrUpdateAdapter<EventEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `EventEntity` SET `id` = ?,`event` = ?,`timestamp` = ?,`playable_item_id` = ?,`platform_id` = ?,`player_id` = ?,`parcelable` = ?,`extra` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final EventEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getEvent());
                Long lFromDate = EventDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getTimestamp());
                if (lFromDate == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindLong(3, lFromDate.longValue());
                }
                if (entity.getPlayableItemId() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, entity.getPlayableItemId().longValue());
                }
                if (entity.getPlatformId() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindLong(5, entity.getPlatformId().longValue());
                }
                if (entity.getPlayerId() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindLong(6, entity.getPlayerId().longValue());
                }
                String strFromParcelable = EventDAO_Impl.this.__roomDatabaseConverters.fromParcelable(entity.getParcelable());
                if (strFromParcelable == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, strFromParcelable);
                }
                statement.bindString(8, entity.getExtra());
                statement.bindLong(9, entity.getId());
            }
        };
        this.__preparedStmtOfNukeTable = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.4
            public String createQuery() {
                return "DELETE FROM EventEntity";
            }
        };
        this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.5
            public String createQuery() {
                return "DELETE FROM EventEntity WHERE id = ?";
            }
        };
        this.__preparedStmtOfDeleteAllByPlayableItemId = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.6
            public String createQuery() {
                return "DELETE FROM EventEntity WHERE playable_item_id =?";
            }
        };
        this.__preparedStmtOfDeleteAllByPlatformId = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.7
            public String createQuery() {
                return "DELETE FROM EventEntity WHERE platform_id =?";
            }
        };
        this.__preparedStmtOfDeleteAllByPlayerId = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.8
            public String createQuery() {
                return "DELETE FROM EventEntity WHERE player_id =?";
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public long insert(final EventEntity eventEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfEventEntity.insertAndReturnId(eventEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public List<Long> insertAll(final EventEntity... eventEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfEventEntity.insertAndReturnIdsList(eventEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public void delete(final EventEntity eventEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfEventEntity.handle(eventEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public void deleteAll(final EventEntity... eventEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfEventEntity.handleMultiple(eventEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public void update(final EventEntity eventEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfEventEntity.handle(eventEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public void updateAll(final EventEntity... eventEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfEventEntity.handleMultiple(eventEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public void nukeTable() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfNukeTable.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfNukeTable.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfNukeTable.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public void deleteById(final long id2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteById.acquire();
        supportSQLiteStatementAcquire.bindLong(1, id2);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteById.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteById.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public void deleteAllByPlayableItemId(final long id2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAllByPlayableItemId.acquire();
        supportSQLiteStatementAcquire.bindLong(1, id2);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteAllByPlayableItemId.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteAllByPlayableItemId.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public void deleteAllByPlatformId(final long id2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAllByPlatformId.acquire();
        supportSQLiteStatementAcquire.bindLong(1, id2);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteAllByPlatformId.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteAllByPlatformId.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public void deleteAllByPlayerId(final long id2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAllByPlayerId.acquire();
        supportSQLiteStatementAcquire.bindLong(1, id2);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteAllByPlayerId.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteAllByPlayerId.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public LiveData<Integer> countAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM EventEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                        numValueOf = Integer.valueOf(cursorQuery.getInt(0));
                    }
                    return numValueOf;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM EventEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public LiveData<List<Long>> selectAllIds() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM EventEntity ORDER BY timestamp ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new Callable<List<Long>>() { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.10
            @Override // java.util.concurrent.Callable
            public List<Long> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(Long.valueOf(cursorQuery.getLong(0)));
                    }
                    cursorQuery.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public List<Long> selectAllIdsStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM EventEntity ORDER BY timestamp ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(Long.valueOf(cursorQuery.getLong(0)));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public LiveData<List<EventEntity>> selectAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity ORDER BY timestamp ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new Callable<List<EventEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.11
            @Override // java.util.concurrent.Callable
            public List<EventEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "platform_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parcelable");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i = cursorQuery.getInt(columnIndexOrThrow2);
                        Date date = EventDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                        if (date == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                        Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                        Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                        String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        arrayList.add(new EventEntity(j, i, date, lValueOf, lValueOf2, lValueOf3, string == null ? null : EventDAO_Impl.this.__roomDatabaseConverters.toParcelable(string), cursorQuery.getString(columnIndexOrThrow8)));
                    }
                    cursorQuery.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public List<EventEntity> selectAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity ORDER BY timestamp ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "platform_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parcelable");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                long j = cursorQuery.getLong(columnIndexOrThrow);
                int i = cursorQuery.getInt(columnIndexOrThrow2);
                Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                arrayList.add(new EventEntity(j, i, date, lValueOf, lValueOf2, lValueOf3, string == null ? null : this.__roomDatabaseConverters.toParcelable(string), cursorQuery.getString(columnIndexOrThrow8)));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public LiveData<EventEntity> selectLatest() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity ORDER BY timestamp DESC LIMIT 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new Callable<EventEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public EventEntity call() throws Exception {
                EventEntity eventEntity = null;
                Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "platform_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parcelable");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    if (cursorQuery.moveToFirst()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i = cursorQuery.getInt(columnIndexOrThrow2);
                        Date date = EventDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                        if (date == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                        Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                        Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                        String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        eventEntity = new EventEntity(j, i, date, lValueOf, lValueOf2, lValueOf3, string != null ? EventDAO_Impl.this.__roomDatabaseConverters.toParcelable(string) : null, cursorQuery.getString(columnIndexOrThrow8));
                    }
                    cursorQuery.close();
                    return eventEntity;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public EventEntity selectLatestStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity ORDER BY timestamp DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        EventEntity eventEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "platform_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parcelable");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            if (cursorQuery.moveToFirst()) {
                long j = cursorQuery.getLong(columnIndexOrThrow);
                int i = cursorQuery.getInt(columnIndexOrThrow2);
                Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                eventEntity = new EventEntity(j, i, date, lValueOf, lValueOf2, lValueOf3, string != null ? this.__roomDatabaseConverters.toParcelable(string) : null, cursorQuery.getString(columnIndexOrThrow8));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return eventEntity;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public LiveData<List<EventEntity>> selectRecentByEvent(final int event, final Date afterDate, final int limit) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity WHERE event = ? AND timestamp >= ? ORDER BY timestamp DESC LIMIT ?", 3);
        roomSQLiteQueryAcquire.bindLong(1, event);
        Long lFromDate = this.__roomDatabaseConverters.fromDate(afterDate);
        if (lFromDate == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindLong(2, lFromDate.longValue());
        }
        roomSQLiteQueryAcquire.bindLong(3, limit);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new Callable<List<EventEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.13
            @Override // java.util.concurrent.Callable
            public List<EventEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "platform_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parcelable");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i = cursorQuery.getInt(columnIndexOrThrow2);
                        Date date = EventDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                        if (date == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                        Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                        Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                        String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        arrayList.add(new EventEntity(j, i, date, lValueOf, lValueOf2, lValueOf3, string == null ? null : EventDAO_Impl.this.__roomDatabaseConverters.toParcelable(string), cursorQuery.getString(columnIndexOrThrow8)));
                    }
                    cursorQuery.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public List<EventEntity> selectRecentByEventStatically(final int event, final Date afterDate, final int limit) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity WHERE event = ? AND timestamp >= ? ORDER BY timestamp DESC LIMIT ?", 3);
        roomSQLiteQueryAcquire.bindLong(1, event);
        Long lFromDate = this.__roomDatabaseConverters.fromDate(afterDate);
        if (lFromDate == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindLong(2, lFromDate.longValue());
        }
        roomSQLiteQueryAcquire.bindLong(3, limit);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "platform_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parcelable");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                long j = cursorQuery.getLong(columnIndexOrThrow);
                int i = cursorQuery.getInt(columnIndexOrThrow2);
                Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                arrayList.add(new EventEntity(j, i, date, lValueOf, lValueOf2, lValueOf3, string == null ? null : this.__roomDatabaseConverters.toParcelable(string), cursorQuery.getString(columnIndexOrThrow8)));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public LiveData<EventEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new Callable<EventEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.EventDAO_Impl.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public EventEntity call() throws Exception {
                EventEntity eventEntity = null;
                Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "platform_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parcelable");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    if (cursorQuery.moveToFirst()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i = cursorQuery.getInt(columnIndexOrThrow2);
                        Date date = EventDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                        if (date == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                        Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                        Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                        String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        eventEntity = new EventEntity(j, i, date, lValueOf, lValueOf2, lValueOf3, string != null ? EventDAO_Impl.this.__roomDatabaseConverters.toParcelable(string) : null, cursorQuery.getString(columnIndexOrThrow8));
                    }
                    cursorQuery.close();
                    return eventEntity;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public EventEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        EventEntity eventEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "platform_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parcelable");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                int i = cursorQuery.getInt(columnIndexOrThrow2);
                Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                eventEntity = new EventEntity(j2, i, date, lValueOf, lValueOf2, lValueOf3, string != null ? this.__roomDatabaseConverters.toParcelable(string) : null, cursorQuery.getString(columnIndexOrThrow8));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return eventEntity;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.EventDAO
    public void deleteAllByIds(final long... ids) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM EventEntity WHERE id IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, ids.length);
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        int i = 1;
        for (long j : ids) {
            supportSQLiteStatementCompileStatement.bindLong(i, j);
            i++;
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
