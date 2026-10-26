package com.magneticchen.daijishou.daijishou_library_db;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
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
import com.magneticchen.daijishou.application_data.RoomDatabaseConverters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/* INFO: loaded from: classes4.dex */
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
        this.__insertionAdapterOfEventEntity = new AnonymousClass1(__db);
        this.__deletionAdapterOfEventEntity = new AnonymousClass2(__db);
        this.__updateAdapterOfEventEntity = new AnonymousClass3(__db);
        this.__preparedStmtOfNukeTable = new AnonymousClass4(__db);
        this.__preparedStmtOfDeleteById = new AnonymousClass5(__db);
        this.__preparedStmtOfDeleteAllByPlayableItemId = new AnonymousClass6(__db);
        this.__preparedStmtOfDeleteAllByPlatformId = new AnonymousClass7(__db);
        this.__preparedStmtOfDeleteAllByPlayerId = new AnonymousClass8(__db);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<EventEntity> {
        AnonymousClass1(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `EventEntity` (`id`,`event`,`timestamp`,`playable_item_id`,`platform_id`,`player_id`,`parcelable`,`extra`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
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
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends EntityDeletionOrUpdateAdapter<EventEntity> {
        AnonymousClass2(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `EventEntity` WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(final SupportSQLiteStatement statement, final EventEntity entity) {
            statement.bindLong(1, entity.getId());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends EntityDeletionOrUpdateAdapter<EventEntity> {
        AnonymousClass3(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `EventEntity` SET `id` = ?,`event` = ?,`timestamp` = ?,`playable_item_id` = ?,`platform_id` = ?,`player_id` = ?,`parcelable` = ?,`extra` = ? WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
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
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$4, reason: invalid class name */
    class AnonymousClass4 extends SharedSQLiteStatement {
        AnonymousClass4(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM EventEntity";
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$5, reason: invalid class name */
    class AnonymousClass5 extends SharedSQLiteStatement {
        AnonymousClass5(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM EventEntity WHERE id = ?";
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$6, reason: invalid class name */
    class AnonymousClass6 extends SharedSQLiteStatement {
        AnonymousClass6(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM EventEntity WHERE playable_item_id =?";
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$7, reason: invalid class name */
    class AnonymousClass7 extends SharedSQLiteStatement {
        AnonymousClass7(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM EventEntity WHERE platform_id =?";
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$8, reason: invalid class name */
    class AnonymousClass8 extends SharedSQLiteStatement {
        AnonymousClass8(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM EventEntity WHERE player_id =?";
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$9, reason: invalid class name */
    class AnonymousClass9 implements Callable<Integer> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass9(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Integer numValueOf = null;
            Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, this.val$_statement, false, null);
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
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public LiveData<Integer> countAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new AnonymousClass9(RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM EventEntity", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM EventEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$10, reason: invalid class name */
    class AnonymousClass10 implements Callable<List<Long>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass10(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<Long> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, this.val$_statement, false, null);
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
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public LiveData<List<Long>> selectAllIds() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new AnonymousClass10(RoomSQLiteQuery.acquire("SELECT id FROM EventEntity ORDER BY timestamp ASC", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public List<Long> selectAllIdsStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM EventEntity ORDER BY timestamp ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
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

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$11, reason: invalid class name */
    class AnonymousClass11 implements Callable<List<EventEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass11(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<EventEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NotificationCompat.CATEGORY_EVENT);
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
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public LiveData<List<EventEntity>> selectAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new AnonymousClass11(RoomSQLiteQuery.acquire("SELECT * FROM EventEntity ORDER BY timestamp ASC", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public List<EventEntity> selectAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity ORDER BY timestamp ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NotificationCompat.CATEGORY_EVENT);
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

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$12, reason: invalid class name */
    class AnonymousClass12 implements Callable<EventEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass12(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public EventEntity call() throws Exception {
            EventEntity eventEntity = null;
            Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NotificationCompat.CATEGORY_EVENT);
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
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public LiveData<EventEntity> selectLatest() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new AnonymousClass12(RoomSQLiteQuery.acquire("SELECT * FROM EventEntity ORDER BY timestamp DESC LIMIT 1", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public EventEntity selectLatestStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity ORDER BY timestamp DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        EventEntity eventEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NotificationCompat.CATEGORY_EVENT);
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public LiveData<List<EventEntity>> selectRecentByEvent(final int event, final Date afterDate, final int limit) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity WHERE event = ? AND timestamp >= ? ORDER BY timestamp DESC LIMIT ?", 3);
        roomSQLiteQueryAcquire.bindLong(1, event);
        Long lFromDate = this.__roomDatabaseConverters.fromDate(afterDate);
        if (lFromDate == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindLong(2, lFromDate.longValue());
        }
        roomSQLiteQueryAcquire.bindLong(3, limit);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new AnonymousClass13(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$13, reason: invalid class name */
    class AnonymousClass13 implements Callable<List<EventEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass13(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<EventEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NotificationCompat.CATEGORY_EVENT);
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
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NotificationCompat.CATEGORY_EVENT);
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public LiveData<EventEntity> selectById(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"EventEntity"}, false, new AnonymousClass14(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.EventDAO_Impl$14, reason: invalid class name */
    class AnonymousClass14 implements Callable<EventEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass14(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public EventEntity call() throws Exception {
            EventEntity eventEntity = null;
            Cursor cursorQuery = DBUtil.query(EventDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NotificationCompat.CATEGORY_EVENT);
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
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
    public EventEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM EventEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        EventEntity eventEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NotificationCompat.CATEGORY_EVENT);
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.EventDAO
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
