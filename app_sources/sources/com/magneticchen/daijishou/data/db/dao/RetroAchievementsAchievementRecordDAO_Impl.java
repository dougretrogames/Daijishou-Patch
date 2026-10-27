package com.magneticchen.daijishou.data.db.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.magneticchen.daijishou.data.RoomDatabaseConverters;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsAchievementRecordEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class RetroAchievementsAchievementRecordDAO_Impl implements RetroAchievementsAchievementRecordDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsAchievementRecordEntity> __deletionAdapterOfRetroAchievementsAchievementRecordEntity;
    private final EntityInsertionAdapter<RetroAchievementsAchievementRecordEntity> __insertionAdapterOfRetroAchievementsAchievementRecordEntity;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsAchievementRecordEntity> __updateAdapterOfRetroAchievementsAchievementRecordEntity;

    public RetroAchievementsAchievementRecordDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRetroAchievementsAchievementRecordEntity = new EntityInsertionAdapter<RetroAchievementsAchievementRecordEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `RetroAchievementsAchievementRecordEntity` (`id`,`game_record_id`,`achievement_id`,`game_id`,`user_id`,`ordering_index`,`name`,`description`,`url`,`image_url`,`unlock_rate`,`points`,`unlocked_player_count`,`unlocked_hardcore_user_count`,`is_hardcore_unlocked`,`is_unlocked`,`unlocked_timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
                supportSQLiteStatement.bindLong(1, retroAchievementsAchievementRecordEntity.getId());
                supportSQLiteStatement.bindLong(2, retroAchievementsAchievementRecordEntity.getGameRecordId());
                supportSQLiteStatement.bindLong(3, retroAchievementsAchievementRecordEntity.getAchievementId());
                if (retroAchievementsAchievementRecordEntity.getGameId() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, retroAchievementsAchievementRecordEntity.getGameId().longValue());
                }
                if (retroAchievementsAchievementRecordEntity.getUserId() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, retroAchievementsAchievementRecordEntity.getUserId());
                }
                supportSQLiteStatement.bindLong(6, retroAchievementsAchievementRecordEntity.getOrderingIndex());
                supportSQLiteStatement.bindString(7, retroAchievementsAchievementRecordEntity.getName());
                if (retroAchievementsAchievementRecordEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, retroAchievementsAchievementRecordEntity.getDescription());
                }
                if (retroAchievementsAchievementRecordEntity.getUrl() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, retroAchievementsAchievementRecordEntity.getUrl());
                }
                if (retroAchievementsAchievementRecordEntity.getImageUrl() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, retroAchievementsAchievementRecordEntity.getImageUrl());
                }
                supportSQLiteStatement.bindDouble(11, retroAchievementsAchievementRecordEntity.getUnlockRate());
                supportSQLiteStatement.bindLong(12, retroAchievementsAchievementRecordEntity.getPoints());
                supportSQLiteStatement.bindLong(13, retroAchievementsAchievementRecordEntity.getUnlockedPlayerCount());
                supportSQLiteStatement.bindLong(14, retroAchievementsAchievementRecordEntity.getUnlockedHardcorePlayerCount());
                supportSQLiteStatement.bindLong(15, retroAchievementsAchievementRecordEntity.isHardcoreUnlocked() ? 1L : 0L);
                supportSQLiteStatement.bindLong(16, retroAchievementsAchievementRecordEntity.isUnlocked() ? 1L : 0L);
                Long lFromDate = RetroAchievementsAchievementRecordDAO_Impl.this.__roomDatabaseConverters.fromDate(retroAchievementsAchievementRecordEntity.getUnlockedTimestamp());
                if (lFromDate == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindLong(17, lFromDate.longValue());
                }
            }
        };
        this.__deletionAdapterOfRetroAchievementsAchievementRecordEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsAchievementRecordEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `RetroAchievementsAchievementRecordEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsAchievementRecordEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfRetroAchievementsAchievementRecordEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsAchievementRecordEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `RetroAchievementsAchievementRecordEntity` SET `id` = ?,`game_record_id` = ?,`achievement_id` = ?,`game_id` = ?,`user_id` = ?,`ordering_index` = ?,`name` = ?,`description` = ?,`url` = ?,`image_url` = ?,`unlock_rate` = ?,`points` = ?,`unlocked_player_count` = ?,`unlocked_hardcore_user_count` = ?,`is_hardcore_unlocked` = ?,`is_unlocked` = ?,`unlocked_timestamp` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
                supportSQLiteStatement.bindLong(1, retroAchievementsAchievementRecordEntity.getId());
                supportSQLiteStatement.bindLong(2, retroAchievementsAchievementRecordEntity.getGameRecordId());
                supportSQLiteStatement.bindLong(3, retroAchievementsAchievementRecordEntity.getAchievementId());
                if (retroAchievementsAchievementRecordEntity.getGameId() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, retroAchievementsAchievementRecordEntity.getGameId().longValue());
                }
                if (retroAchievementsAchievementRecordEntity.getUserId() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, retroAchievementsAchievementRecordEntity.getUserId());
                }
                supportSQLiteStatement.bindLong(6, retroAchievementsAchievementRecordEntity.getOrderingIndex());
                supportSQLiteStatement.bindString(7, retroAchievementsAchievementRecordEntity.getName());
                if (retroAchievementsAchievementRecordEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, retroAchievementsAchievementRecordEntity.getDescription());
                }
                if (retroAchievementsAchievementRecordEntity.getUrl() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, retroAchievementsAchievementRecordEntity.getUrl());
                }
                if (retroAchievementsAchievementRecordEntity.getImageUrl() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, retroAchievementsAchievementRecordEntity.getImageUrl());
                }
                supportSQLiteStatement.bindDouble(11, retroAchievementsAchievementRecordEntity.getUnlockRate());
                supportSQLiteStatement.bindLong(12, retroAchievementsAchievementRecordEntity.getPoints());
                supportSQLiteStatement.bindLong(13, retroAchievementsAchievementRecordEntity.getUnlockedPlayerCount());
                supportSQLiteStatement.bindLong(14, retroAchievementsAchievementRecordEntity.getUnlockedHardcorePlayerCount());
                supportSQLiteStatement.bindLong(15, retroAchievementsAchievementRecordEntity.isHardcoreUnlocked() ? 1L : 0L);
                supportSQLiteStatement.bindLong(16, retroAchievementsAchievementRecordEntity.isUnlocked() ? 1L : 0L);
                Long lFromDate = RetroAchievementsAchievementRecordDAO_Impl.this.__roomDatabaseConverters.fromDate(retroAchievementsAchievementRecordEntity.getUnlockedTimestamp());
                if (lFromDate == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindLong(17, lFromDate.longValue());
                }
                supportSQLiteStatement.bindLong(18, retroAchievementsAchievementRecordEntity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public long insert(final RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfRetroAchievementsAchievementRecordEntity.insertAndReturnId(retroAchievementsAchievementRecordEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public List<Long> insertAll(final RetroAchievementsAchievementRecordEntity... retroAchievementsAchievementRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfRetroAchievementsAchievementRecordEntity.insertAndReturnIdsList(retroAchievementsAchievementRecordEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public void delete(final RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsAchievementRecordEntity.handle(retroAchievementsAchievementRecordEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public void deleteAll(final RetroAchievementsAchievementRecordEntity... retroAchievementsAchievementRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsAchievementRecordEntity.handleMultiple(retroAchievementsAchievementRecordEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public void update(final RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsAchievementRecordEntity.handle(retroAchievementsAchievementRecordEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public void updateAll(final RetroAchievementsAchievementRecordEntity... retroAchievementsAchievementRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsAchievementRecordEntity.handleMultiple(retroAchievementsAchievementRecordEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public LiveData<Integer> countAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsAchievementRecordEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsAchievementRecordEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsAchievementRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsAchievementRecordEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public LiveData<RetroAchievementsAchievementRecordEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsAchievementRecordEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsAchievementRecordEntity"}, false, new Callable<RetroAchievementsAchievementRecordEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RetroAchievementsAchievementRecordEntity call() throws Exception {
                RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsAchievementRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_record_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievement_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ordering_index");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlock_rate");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_player_count");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_hardcore_user_count");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_hardcore_unlocked");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_unlocked");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_timestamp");
                        if (cursorQuery.moveToFirst()) {
                            retroAchievementsAchievementRecordEntity = new RetroAchievementsAchievementRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.getString(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.getFloat(columnIndexOrThrow11), cursorQuery.getInt(columnIndexOrThrow12), cursorQuery.getLong(columnIndexOrThrow13), cursorQuery.getLong(columnIndexOrThrow14), cursorQuery.getInt(columnIndexOrThrow15) != 0, cursorQuery.getInt(columnIndexOrThrow16) != 0, RetroAchievementsAchievementRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow17) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow17))));
                        } else {
                            retroAchievementsAchievementRecordEntity = null;
                        }
                        cursorQuery.close();
                        return retroAchievementsAchievementRecordEntity;
                    } catch (Throwable th) {
                        th = th;
                        cursorQuery.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public RetroAchievementsAchievementRecordEntity selectByIdStatically(final long id2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsAchievementRecordEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_record_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievement_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ordering_index");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlock_rate");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_player_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_hardcore_user_count");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_hardcore_unlocked");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_unlocked");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_timestamp");
                    if (cursorQuery.moveToFirst()) {
                        retroAchievementsAchievementRecordEntity = new RetroAchievementsAchievementRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.getString(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.getFloat(columnIndexOrThrow11), cursorQuery.getInt(columnIndexOrThrow12), cursorQuery.getLong(columnIndexOrThrow13), cursorQuery.getLong(columnIndexOrThrow14), cursorQuery.getInt(columnIndexOrThrow15) != 0, cursorQuery.getInt(columnIndexOrThrow16) != 0, this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow17) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow17))));
                    } else {
                        retroAchievementsAchievementRecordEntity = null;
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return retroAchievementsAchievementRecordEntity;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public LiveData<List<RetroAchievementsAchievementRecordEntity>> selectByGameRecordId(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsAchievementRecordEntity WHERE game_record_id = ? ORDER BY ordering_index ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsAchievementRecordEntity"}, false, new Callable<List<RetroAchievementsAchievementRecordEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsAchievementRecordEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(RetroAchievementsAchievementRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_record_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievement_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ordering_index");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlock_rate");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_player_count");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_hardcore_user_count");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_hardcore_unlocked");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_unlocked");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_timestamp");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow2);
                            long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                            Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                            String string = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            int i2 = cursorQuery.getInt(columnIndexOrThrow6);
                            String string2 = cursorQuery.getString(columnIndexOrThrow7);
                            String string3 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string5 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            float f = cursorQuery.getFloat(columnIndexOrThrow11);
                            int i3 = cursorQuery.getInt(columnIndexOrThrow12);
                            long j4 = cursorQuery.getLong(columnIndexOrThrow13);
                            int i4 = i;
                            long j5 = cursorQuery.getLong(i4);
                            int i5 = columnIndexOrThrow;
                            int i6 = columnIndexOrThrow15;
                            boolean z = cursorQuery.getInt(i6) != 0;
                            columnIndexOrThrow15 = i6;
                            int i7 = columnIndexOrThrow16;
                            boolean z2 = cursorQuery.getInt(i7) != 0;
                            columnIndexOrThrow16 = i7;
                            int i8 = columnIndexOrThrow17;
                            try {
                                arrayList.add(new RetroAchievementsAchievementRecordEntity(j, j2, j3, lValueOf, string, i2, string2, string3, string4, string5, f, i3, j4, j5, z, z2, RetroAchievementsAchievementRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i8) ? null : Long.valueOf(cursorQuery.getLong(i8)))));
                                cursorQuery = cursorQuery;
                                columnIndexOrThrow = i5;
                                columnIndexOrThrow17 = i8;
                                columnIndexOrThrow13 = columnIndexOrThrow13;
                                i = i4;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        cursorQuery = cursorQuery;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursorQuery = cursorQuery;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public List<RetroAchievementsAchievementRecordEntity> selectByGameRecordIdStatically(final long id2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsAchievementRecordEntity WHERE game_record_id = ? ORDER BY ordering_index ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_record_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievement_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ordering_index");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlock_rate");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_player_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_hardcore_user_count");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_hardcore_unlocked");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_unlocked");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_timestamp");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow2);
                        long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                        Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                        String string = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        int i2 = cursorQuery.getInt(columnIndexOrThrow6);
                        String string2 = cursorQuery.getString(columnIndexOrThrow7);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        float f = cursorQuery.getFloat(columnIndexOrThrow11);
                        int i3 = cursorQuery.getInt(columnIndexOrThrow12);
                        long j4 = cursorQuery.getLong(columnIndexOrThrow13);
                        int i4 = i;
                        long j5 = cursorQuery.getLong(i4);
                        int i5 = columnIndexOrThrow;
                        int i6 = columnIndexOrThrow15;
                        boolean z = cursorQuery.getInt(i6) != 0;
                        columnIndexOrThrow15 = i6;
                        int i7 = columnIndexOrThrow16;
                        boolean z2 = cursorQuery.getInt(i7) != 0;
                        columnIndexOrThrow16 = i7;
                        int i8 = columnIndexOrThrow17;
                        try {
                            arrayList.add(new RetroAchievementsAchievementRecordEntity(j, j2, j3, lValueOf, string, i2, string2, string3, string4, string5, f, i3, j4, j5, z, z2, this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i8) ? null : Long.valueOf(cursorQuery.getLong(i8)))));
                            columnIndexOrThrow11 = columnIndexOrThrow11;
                            columnIndexOrThrow = i5;
                            columnIndexOrThrow17 = i8;
                            i = i4;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public LiveData<List<RetroAchievementsAchievementRecordEntity>> selectByUserId(final String userId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsAchievementRecordEntity WHERE lower(user_id) = lower(?) ORDER BY unlocked_timestamp DESC", 1);
        roomSQLiteQueryAcquire.bindString(1, userId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsAchievementRecordEntity"}, false, new Callable<List<RetroAchievementsAchievementRecordEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO_Impl.7
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsAchievementRecordEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(RetroAchievementsAchievementRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_record_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievement_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ordering_index");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlock_rate");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_player_count");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_hardcore_user_count");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_hardcore_unlocked");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_unlocked");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_timestamp");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow2);
                            long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                            Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                            String string = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            int i2 = cursorQuery.getInt(columnIndexOrThrow6);
                            String string2 = cursorQuery.getString(columnIndexOrThrow7);
                            String string3 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            String string5 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            float f = cursorQuery.getFloat(columnIndexOrThrow11);
                            int i3 = cursorQuery.getInt(columnIndexOrThrow12);
                            long j4 = cursorQuery.getLong(columnIndexOrThrow13);
                            int i4 = i;
                            long j5 = cursorQuery.getLong(i4);
                            int i5 = columnIndexOrThrow;
                            int i6 = columnIndexOrThrow15;
                            boolean z = cursorQuery.getInt(i6) != 0;
                            columnIndexOrThrow15 = i6;
                            int i7 = columnIndexOrThrow16;
                            boolean z2 = cursorQuery.getInt(i7) != 0;
                            columnIndexOrThrow16 = i7;
                            int i8 = columnIndexOrThrow17;
                            try {
                                arrayList.add(new RetroAchievementsAchievementRecordEntity(j, j2, j3, lValueOf, string, i2, string2, string3, string4, string5, f, i3, j4, j5, z, z2, RetroAchievementsAchievementRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i8) ? null : Long.valueOf(cursorQuery.getLong(i8)))));
                                cursorQuery = cursorQuery;
                                columnIndexOrThrow = i5;
                                columnIndexOrThrow17 = i8;
                                columnIndexOrThrow13 = columnIndexOrThrow13;
                                i = i4;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        cursorQuery = cursorQuery;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursorQuery = cursorQuery;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO
    public List<RetroAchievementsAchievementRecordEntity> selectByUserIdStatically(final String userId) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsAchievementRecordEntity WHERE lower(user_id) = lower(?) ORDER BY unlocked_timestamp DESC", 1);
        roomSQLiteQueryAcquire.bindString(1, userId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_record_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievement_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ordering_index");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlock_rate");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_player_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_hardcore_user_count");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_hardcore_unlocked");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_unlocked");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_timestamp");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow2);
                        long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                        Long lValueOf = cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                        String string = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        int i2 = cursorQuery.getInt(columnIndexOrThrow6);
                        String string2 = cursorQuery.getString(columnIndexOrThrow7);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        float f = cursorQuery.getFloat(columnIndexOrThrow11);
                        int i3 = cursorQuery.getInt(columnIndexOrThrow12);
                        long j4 = cursorQuery.getLong(columnIndexOrThrow13);
                        int i4 = i;
                        long j5 = cursorQuery.getLong(i4);
                        int i5 = columnIndexOrThrow;
                        int i6 = columnIndexOrThrow15;
                        boolean z = cursorQuery.getInt(i6) != 0;
                        columnIndexOrThrow15 = i6;
                        int i7 = columnIndexOrThrow16;
                        boolean z2 = cursorQuery.getInt(i7) != 0;
                        columnIndexOrThrow16 = i7;
                        int i8 = columnIndexOrThrow17;
                        try {
                            arrayList.add(new RetroAchievementsAchievementRecordEntity(j, j2, j3, lValueOf, string, i2, string2, string3, string4, string5, f, i3, j4, j5, z, z2, this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i8) ? null : Long.valueOf(cursorQuery.getLong(i8)))));
                            columnIndexOrThrow11 = columnIndexOrThrow11;
                            columnIndexOrThrow = i5;
                            columnIndexOrThrow17 = i8;
                            i = i4;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
