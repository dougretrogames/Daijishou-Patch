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
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserAwardEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class RetroAchievementsUserAwardDAO_Impl implements RetroAchievementsUserAwardDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsUserAwardEntity> __deletionAdapterOfRetroAchievementsUserAwardEntity;
    private final EntityInsertionAdapter<RetroAchievementsUserAwardEntity> __insertionAdapterOfRetroAchievementsUserAwardEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByConsoleId;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUserId;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsUserAwardEntity> __updateAdapterOfRetroAchievementsUserAwardEntity;

    public RetroAchievementsUserAwardDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRetroAchievementsUserAwardEntity = new EntityInsertionAdapter<RetroAchievementsUserAwardEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `RetroAchievementsUserAwardEntity` (`id`,`user_id`,`award_type`,`award_data`,`award_data_extra`,`award_at`,`display_order`,`title`,`console_id`,`console_name`,`flags`,`image_url`,`last_updated_timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserAwardEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getUserId());
                statement.bindString(3, entity.getAwardType());
                statement.bindLong(4, entity.getAwardData());
                if (entity.getAwardDataExtra() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindLong(5, entity.getAwardDataExtra().intValue());
                }
                Long lFromDate = RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getAwardedAt());
                if (lFromDate == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindLong(6, lFromDate.longValue());
                }
                statement.bindLong(7, entity.getDisplayOrder());
                statement.bindString(8, entity.getTitle());
                if (entity.getConsoleId() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindLong(9, entity.getConsoleId().longValue());
                }
                if (entity.getConsoleName() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getConsoleName());
                }
                if (entity.getFlags() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindLong(11, entity.getFlags().intValue());
                }
                if (entity.getImageUrl() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getImageUrl());
                }
                Long lFromDate2 = RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdatedTimestamp());
                if (lFromDate2 == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindLong(13, lFromDate2.longValue());
                }
            }
        };
        this.__deletionAdapterOfRetroAchievementsUserAwardEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsUserAwardEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `RetroAchievementsUserAwardEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserAwardEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfRetroAchievementsUserAwardEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsUserAwardEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `RetroAchievementsUserAwardEntity` SET `id` = ?,`user_id` = ?,`award_type` = ?,`award_data` = ?,`award_data_extra` = ?,`award_at` = ?,`display_order` = ?,`title` = ?,`console_id` = ?,`console_name` = ?,`flags` = ?,`image_url` = ?,`last_updated_timestamp` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserAwardEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getUserId());
                statement.bindString(3, entity.getAwardType());
                statement.bindLong(4, entity.getAwardData());
                if (entity.getAwardDataExtra() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindLong(5, entity.getAwardDataExtra().intValue());
                }
                Long lFromDate = RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getAwardedAt());
                if (lFromDate == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindLong(6, lFromDate.longValue());
                }
                statement.bindLong(7, entity.getDisplayOrder());
                statement.bindString(8, entity.getTitle());
                if (entity.getConsoleId() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindLong(9, entity.getConsoleId().longValue());
                }
                if (entity.getConsoleName() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getConsoleName());
                }
                if (entity.getFlags() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindLong(11, entity.getFlags().intValue());
                }
                if (entity.getImageUrl() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getImageUrl());
                }
                Long lFromDate2 = RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdatedTimestamp());
                if (lFromDate2 == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindLong(13, lFromDate2.longValue());
                }
                statement.bindLong(14, entity.getId());
            }
        };
        this.__preparedStmtOfDeleteByUserId = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.4
            public String createQuery() {
                return "DELETE FROM RetroAchievementsUserAwardEntity WHERE user_id = ?";
            }
        };
        this.__preparedStmtOfDeleteByConsoleId = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.5
            public String createQuery() {
                return "DELETE FROM RetroAchievementsUserAwardEntity WHERE console_id = ?";
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public long insert(final RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfRetroAchievementsUserAwardEntity.insertAndReturnId(retroAchievementsUserAwardEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public List<Long> insertAll(final RetroAchievementsUserAwardEntity... retroAchievementsGameRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfRetroAchievementsUserAwardEntity.insertAndReturnIdsList(retroAchievementsGameRecordEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public void delete(final RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsUserAwardEntity.handle(retroAchievementsUserAwardEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public void deleteAll(final RetroAchievementsUserAwardEntity... retroAchievementsGameRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsUserAwardEntity.handleMultiple(retroAchievementsGameRecordEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public void update(final RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsUserAwardEntity.handle(retroAchievementsUserAwardEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public void updateAll(final RetroAchievementsUserAwardEntity... retroAchievementsGameRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsUserAwardEntity.handleMultiple(retroAchievementsGameRecordEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public int deleteByUserId(final String userId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByUserId.acquire();
        supportSQLiteStatementAcquire.bindString(1, userId);
        try {
            this.__db.beginTransaction();
            try {
                int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteByUserId.release(supportSQLiteStatementAcquire);
                return iExecuteUpdateDelete;
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteByUserId.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public int deleteByConsoleId(final long consoleId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByConsoleId.acquire();
        supportSQLiteStatementAcquire.bindLong(1, consoleId);
        try {
            this.__db.beginTransaction();
            try {
                int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteByConsoleId.release(supportSQLiteStatementAcquire);
                return iExecuteUpdateDelete;
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteByConsoleId.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public LiveData<Integer> countAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsUserAwardEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserAwardEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserAwardDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsUserAwardEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public LiveData<List<RetroAchievementsUserAwardEntity>> selectAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserAwardEntity ORDER BY display_order ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserAwardEntity"}, false, new Callable<List<RetroAchievementsUserAwardEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.7
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserAwardEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserAwardDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i = columnIndexOrThrow;
                        int i2 = columnIndexOrThrow13;
                        columnIndexOrThrow13 = i2;
                        arrayList.add(new RetroAchievementsUserAwardEntity(j, cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i2) ? null : Long.valueOf(cursorQuery.getLong(i2)))));
                        columnIndexOrThrow = i;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public List<RetroAchievementsUserAwardEntity> selectAllStatically() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserAwardEntity ORDER BY display_order ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    int i = columnIndexOrThrow;
                    int i2 = columnIndexOrThrow13;
                    columnIndexOrThrow13 = i2;
                    arrayList.add(new RetroAchievementsUserAwardEntity(j, cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i2) ? null : Long.valueOf(cursorQuery.getLong(i2)))));
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public LiveData<RetroAchievementsUserAwardEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserAwardEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserAwardEntity"}, false, new Callable<RetroAchievementsUserAwardEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RetroAchievementsUserAwardEntity call() throws Exception {
                RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity = null;
                Long lValueOf = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserAwardDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    if (cursorQuery.moveToFirst()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.getString(columnIndexOrThrow2);
                        String string2 = cursorQuery.getString(columnIndexOrThrow3);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow4);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5));
                        Date date = RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)));
                        int i = cursorQuery.getInt(columnIndexOrThrow7);
                        String string3 = cursorQuery.getString(columnIndexOrThrow8);
                        Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9));
                        String string4 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        String string5 = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12);
                        if (!cursorQuery.isNull(columnIndexOrThrow13)) {
                            lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow13));
                        }
                        retroAchievementsUserAwardEntity = new RetroAchievementsUserAwardEntity(j, string, string2, j2, numValueOf, date, i, string3, lValueOf2, string4, numValueOf2, string5, RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(lValueOf));
                    }
                    return retroAchievementsUserAwardEntity;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public RetroAchievementsUserAwardEntity selectByIdStatically(final long id2) {
        RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserAwardEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            if (cursorQuery.moveToFirst()) {
                retroAchievementsUserAwardEntity = new RetroAchievementsUserAwardEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow13) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow13))));
            } else {
                retroAchievementsUserAwardEntity = null;
            }
            return retroAchievementsUserAwardEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public LiveData<List<RetroAchievementsUserAwardEntity>> selectByIds(final long... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM RetroAchievementsUserAwardEntity WHERE id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(") ORDER BY display_order");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (long j : ids) {
            roomSQLiteQueryAcquire.bindLong(i, j);
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserAwardEntity"}, false, new Callable<List<RetroAchievementsUserAwardEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.9
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserAwardEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserAwardDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j2 = cursorQuery.getLong(columnIndexOrThrow);
                        int i2 = columnIndexOrThrow;
                        int i3 = columnIndexOrThrow13;
                        columnIndexOrThrow13 = i3;
                        arrayList.add(new RetroAchievementsUserAwardEntity(j2, cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)))));
                        columnIndexOrThrow = i2;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public List<RetroAchievementsUserAwardEntity> selectByIdsStatically(final long... ids) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM RetroAchievementsUserAwardEntity WHERE id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(") ORDER BY display_order");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (long j : ids) {
            roomSQLiteQueryAcquire.bindLong(i, j);
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    long j2 = cursorQuery.getLong(columnIndexOrThrow);
                    int i2 = columnIndexOrThrow;
                    int i3 = columnIndexOrThrow13;
                    columnIndexOrThrow13 = i3;
                    arrayList.add(new RetroAchievementsUserAwardEntity(j2, cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)))));
                    columnIndexOrThrow = i2;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public LiveData<List<RetroAchievementsUserAwardEntity>> selectByUserId(final String userId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserAwardEntity WHERE user_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, userId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserAwardEntity"}, false, new Callable<List<RetroAchievementsUserAwardEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.10
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserAwardEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserAwardDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i = columnIndexOrThrow;
                        int i2 = columnIndexOrThrow13;
                        columnIndexOrThrow13 = i2;
                        arrayList.add(new RetroAchievementsUserAwardEntity(j, cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i2) ? null : Long.valueOf(cursorQuery.getLong(i2)))));
                        columnIndexOrThrow = i;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public List<RetroAchievementsUserAwardEntity> selectByUserIdStatically(final String userId) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserAwardEntity WHERE user_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, userId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    int i = columnIndexOrThrow;
                    int i2 = columnIndexOrThrow13;
                    columnIndexOrThrow13 = i2;
                    arrayList.add(new RetroAchievementsUserAwardEntity(j, cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i2) ? null : Long.valueOf(cursorQuery.getLong(i2)))));
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public LiveData<List<RetroAchievementsUserAwardEntity>> selectByUserIdAndAwardData(final String userId, final long awardData) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserAwardEntity WHERE user_id = ? AND award_data = ?", 2);
        roomSQLiteQueryAcquire.bindString(1, userId);
        roomSQLiteQueryAcquire.bindLong(2, awardData);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserAwardEntity"}, false, new Callable<List<RetroAchievementsUserAwardEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.11
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserAwardEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserAwardDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i = columnIndexOrThrow;
                        int i2 = columnIndexOrThrow13;
                        columnIndexOrThrow13 = i2;
                        arrayList.add(new RetroAchievementsUserAwardEntity(j, cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i2) ? null : Long.valueOf(cursorQuery.getLong(i2)))));
                        columnIndexOrThrow = i;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public List<RetroAchievementsUserAwardEntity> selectByUserIdAndAwardDataStatically(final String userId, final long awardData) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserAwardEntity WHERE user_id = ? AND award_data = ?", 2);
        roomSQLiteQueryAcquire.bindString(1, userId);
        roomSQLiteQueryAcquire.bindLong(2, awardData);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    int i = columnIndexOrThrow;
                    int i2 = columnIndexOrThrow13;
                    columnIndexOrThrow13 = i2;
                    arrayList.add(new RetroAchievementsUserAwardEntity(j, cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i2) ? null : Long.valueOf(cursorQuery.getLong(i2)))));
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public LiveData<List<RetroAchievementsUserAwardEntity>> selectByConsoleId(final long consoleId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserAwardEntity WHERE console_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, consoleId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserAwardEntity"}, false, new Callable<List<RetroAchievementsUserAwardEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO_Impl.12
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserAwardEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserAwardDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i = columnIndexOrThrow;
                        int i2 = columnIndexOrThrow13;
                        columnIndexOrThrow13 = i2;
                        arrayList.add(new RetroAchievementsUserAwardEntity(j, cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), RetroAchievementsUserAwardDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i2) ? null : Long.valueOf(cursorQuery.getLong(i2)))));
                        columnIndexOrThrow = i;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO
    public List<RetroAchievementsUserAwardEntity> selectByConsoleIdStatically(final long consoleId) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserAwardEntity WHERE console_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, consoleId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_data_extra");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "award_at");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_order");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flags");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    int i = columnIndexOrThrow;
                    int i2 = columnIndexOrThrow13;
                    columnIndexOrThrow13 = i2;
                    arrayList.add(new RetroAchievementsUserAwardEntity(j, cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6))), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i2) ? null : Long.valueOf(cursorQuery.getLong(i2)))));
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
