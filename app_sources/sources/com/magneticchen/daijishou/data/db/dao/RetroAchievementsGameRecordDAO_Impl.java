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
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.magneticchen.daijishou.data.RoomDatabaseConverters;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsGameRecordEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class RetroAchievementsGameRecordDAO_Impl implements RetroAchievementsGameRecordDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsGameRecordEntity> __deletionAdapterOfRetroAchievementsGameRecordEntity;
    private final EntityInsertionAdapter<RetroAchievementsGameRecordEntity> __insertionAdapterOfRetroAchievementsGameRecordEntity;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsGameRecordEntity> __updateAdapterOfRetroAchievementsGameRecordEntity;

    public RetroAchievementsGameRecordDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRetroAchievementsGameRecordEntity = new EntityInsertionAdapter<RetroAchievementsGameRecordEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `RetroAchievementsGameRecordEntity` (`id`,`user_id`,`game_id`,`name`,`url`,`image_url`,`guide_url`,`forum_topic_id`,`console_id`,`console_name`,`rating`,`rating_votes_count`,`total_player_count`,`distinct_player_count`,`distinct_casual_player_count`,`distinct_hardcore_player_count`,`released_date`,`released_date_granularity`,`achievements_count`,`unlocked_achievements_count`,`last_updated_timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsGameRecordEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getUserId());
                statement.bindLong(3, entity.getGameId());
                if (entity.getName() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getName());
                }
                if (entity.getUrl() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getUrl());
                }
                if (entity.getImageUrl() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getImageUrl());
                }
                if (entity.getGuideUrl() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getGuideUrl());
                }
                if (entity.getForumTopicId() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindLong(8, entity.getForumTopicId().intValue());
                }
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
                if (entity.getRating() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindDouble(11, entity.getRating().floatValue());
                }
                statement.bindLong(12, entity.getRatingVotesCount());
                statement.bindLong(13, entity.getTotalPlayerCount());
                statement.bindLong(14, entity.getDistinctPlayerCount());
                statement.bindLong(15, entity.getDistinctCasualPlayerCount());
                statement.bindLong(16, entity.getDistinctHardcorePlayerCount());
                Long lFromDate = RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getReleasedDate());
                if (lFromDate == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindLong(17, lFromDate.longValue());
                }
                if (entity.getReleasedDateGranularity() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getReleasedDateGranularity());
                }
                statement.bindLong(19, entity.getAchievementsCount());
                statement.bindLong(20, entity.getUnlockedAchievementsCount());
                Long lFromDate2 = RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdatedTimestamp());
                if (lFromDate2 == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindLong(21, lFromDate2.longValue());
                }
            }
        };
        this.__deletionAdapterOfRetroAchievementsGameRecordEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsGameRecordEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `RetroAchievementsGameRecordEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsGameRecordEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfRetroAchievementsGameRecordEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsGameRecordEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `RetroAchievementsGameRecordEntity` SET `id` = ?,`user_id` = ?,`game_id` = ?,`name` = ?,`url` = ?,`image_url` = ?,`guide_url` = ?,`forum_topic_id` = ?,`console_id` = ?,`console_name` = ?,`rating` = ?,`rating_votes_count` = ?,`total_player_count` = ?,`distinct_player_count` = ?,`distinct_casual_player_count` = ?,`distinct_hardcore_player_count` = ?,`released_date` = ?,`released_date_granularity` = ?,`achievements_count` = ?,`unlocked_achievements_count` = ?,`last_updated_timestamp` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsGameRecordEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getUserId());
                statement.bindLong(3, entity.getGameId());
                if (entity.getName() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getName());
                }
                if (entity.getUrl() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getUrl());
                }
                if (entity.getImageUrl() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getImageUrl());
                }
                if (entity.getGuideUrl() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getGuideUrl());
                }
                if (entity.getForumTopicId() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindLong(8, entity.getForumTopicId().intValue());
                }
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
                if (entity.getRating() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindDouble(11, entity.getRating().floatValue());
                }
                statement.bindLong(12, entity.getRatingVotesCount());
                statement.bindLong(13, entity.getTotalPlayerCount());
                statement.bindLong(14, entity.getDistinctPlayerCount());
                statement.bindLong(15, entity.getDistinctCasualPlayerCount());
                statement.bindLong(16, entity.getDistinctHardcorePlayerCount());
                Long lFromDate = RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getReleasedDate());
                if (lFromDate == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindLong(17, lFromDate.longValue());
                }
                if (entity.getReleasedDateGranularity() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getReleasedDateGranularity());
                }
                statement.bindLong(19, entity.getAchievementsCount());
                statement.bindLong(20, entity.getUnlockedAchievementsCount());
                Long lFromDate2 = RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdatedTimestamp());
                if (lFromDate2 == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindLong(21, lFromDate2.longValue());
                }
                statement.bindLong(22, entity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public long insert(final RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfRetroAchievementsGameRecordEntity.insertAndReturnId(retroAchievementsGameRecordEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public List<Long> insertAll(final RetroAchievementsGameRecordEntity... retroAchievementsGameRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfRetroAchievementsGameRecordEntity.insertAndReturnIdsList(retroAchievementsGameRecordEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public void delete(final RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsGameRecordEntity.handle(retroAchievementsGameRecordEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public void deleteAll(final RetroAchievementsGameRecordEntity... retroAchievementsGameRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsGameRecordEntity.handleMultiple(retroAchievementsGameRecordEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public void update(final RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsGameRecordEntity.handle(retroAchievementsGameRecordEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public void updateAll(final RetroAchievementsGameRecordEntity... retroAchievementsGameRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsGameRecordEntity.handleMultiple(retroAchievementsGameRecordEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public LiveData<Integer> countAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsGameRecordEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsGameRecordEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsGameRecordEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public LiveData<RetroAchievementsGameRecordEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsGameRecordEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsGameRecordEntity"}, false, new Callable<RetroAchievementsGameRecordEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RetroAchievementsGameRecordEntity call() throws Exception {
                RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                        if (cursorQuery.moveToFirst()) {
                            try {
                                retroAchievementsGameRecordEntity = new RetroAchievementsGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8)), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11)), cursorQuery.getInt(columnIndexOrThrow12), cursorQuery.getInt(columnIndexOrThrow13), cursorQuery.getLong(columnIndexOrThrow14), cursorQuery.getLong(columnIndexOrThrow15), cursorQuery.getLong(columnIndexOrThrow16), RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow17) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow17))), cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18), cursorQuery.getInt(columnIndexOrThrow19), cursorQuery.getInt(columnIndexOrThrow20), RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21))));
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        } else {
                            retroAchievementsGameRecordEntity = null;
                        }
                        cursorQuery.close();
                        return retroAchievementsGameRecordEntity;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public RetroAchievementsGameRecordEntity selectByIdStatically(final long id2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsGameRecordEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    if (cursorQuery.moveToFirst()) {
                        try {
                            retroAchievementsGameRecordEntity = new RetroAchievementsGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8)), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11)), cursorQuery.getInt(columnIndexOrThrow12), cursorQuery.getInt(columnIndexOrThrow13), cursorQuery.getLong(columnIndexOrThrow14), cursorQuery.getLong(columnIndexOrThrow15), cursorQuery.getLong(columnIndexOrThrow16), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow17) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow17))), cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18), cursorQuery.getInt(columnIndexOrThrow19), cursorQuery.getInt(columnIndexOrThrow20), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21))));
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    } else {
                        retroAchievementsGameRecordEntity = null;
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return retroAchievementsGameRecordEntity;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public LiveData<List<RetroAchievementsGameRecordEntity>> selectByIds(final long... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM RetroAchievementsGameRecordEntity WHERE id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(") ORDER BY id");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (long j : ids) {
            roomSQLiteQueryAcquire.bindLong(i, j);
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsGameRecordEntity"}, false, new Callable<List<RetroAchievementsGameRecordEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsGameRecordEntity> call() throws Exception {
                Cursor cursor;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                        int i2 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j2 = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.getString(columnIndexOrThrow2);
                            long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                            String string2 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                            String string3 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                            String string5 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                            Long lValueOf = cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9));
                            String string6 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            Float fValueOf = cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11));
                            int i3 = cursorQuery.getInt(columnIndexOrThrow12);
                            int i4 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i5 = i2;
                            long j4 = cursorQuery.getLong(i5);
                            int i6 = columnIndexOrThrow;
                            int i7 = columnIndexOrThrow15;
                            long j5 = cursorQuery.getLong(i7);
                            columnIndexOrThrow15 = i7;
                            int i8 = columnIndexOrThrow16;
                            long j6 = cursorQuery.getLong(i8);
                            columnIndexOrThrow16 = i8;
                            int i9 = columnIndexOrThrow17;
                            try {
                                Date date = RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i9) ? null : Long.valueOf(cursorQuery.getLong(i9)));
                                int i10 = columnIndexOrThrow18;
                                String string7 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                                int i11 = columnIndexOrThrow19;
                                int i12 = cursorQuery.getInt(i11);
                                columnIndexOrThrow18 = i10;
                                int i13 = columnIndexOrThrow20;
                                int i14 = cursorQuery.getInt(i13);
                                columnIndexOrThrow20 = i13;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                cursor = cursorQuery;
                                try {
                                    arrayList.add(new RetroAchievementsGameRecordEntity(j2, string, j3, string2, string3, string4, string5, numValueOf, lValueOf, string6, fValueOf, i3, i4, j4, j5, j6, date, string7, i12, i14, RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21)))));
                                    columnIndexOrThrow2 = columnIndexOrThrow2;
                                    cursorQuery = cursor;
                                    columnIndexOrThrow = i6;
                                    columnIndexOrThrow17 = i9;
                                    i2 = i5;
                                    columnIndexOrThrow19 = i11;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorQuery;
                                cursor.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public List<RetroAchievementsGameRecordEntity> selectByIdsStatically(final long... ids) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM RetroAchievementsGameRecordEntity WHERE id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(") ORDER BY id");
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
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    int i2 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j2 = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.getString(columnIndexOrThrow2);
                        long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                        Long lValueOf = cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9));
                        String string6 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        Float fValueOf = cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11));
                        int i3 = cursorQuery.getInt(columnIndexOrThrow12);
                        int i4 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i5 = i2;
                        long j4 = cursorQuery.getLong(i5);
                        int i6 = columnIndexOrThrow;
                        int i7 = columnIndexOrThrow15;
                        long j5 = cursorQuery.getLong(i7);
                        columnIndexOrThrow15 = i7;
                        int i8 = columnIndexOrThrow16;
                        long j6 = cursorQuery.getLong(i8);
                        columnIndexOrThrow16 = i8;
                        int i9 = columnIndexOrThrow17;
                        try {
                            Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i9) ? null : Long.valueOf(cursorQuery.getLong(i9)));
                            int i10 = columnIndexOrThrow18;
                            String string7 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                            int i11 = columnIndexOrThrow19;
                            int i12 = cursorQuery.getInt(i11);
                            columnIndexOrThrow18 = i10;
                            int i13 = columnIndexOrThrow20;
                            int i14 = cursorQuery.getInt(i13);
                            columnIndexOrThrow20 = i13;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            columnIndexOrThrow19 = i11;
                            arrayList.add(new RetroAchievementsGameRecordEntity(j2, string, j3, string2, string3, string4, string5, numValueOf, lValueOf, string6, fValueOf, i3, i4, j4, j5, j6, date, string7, i12, i14, this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21)))));
                            columnIndexOrThrow = i6;
                            columnIndexOrThrow13 = columnIndexOrThrow13;
                            i2 = i5;
                            columnIndexOrThrow17 = i9;
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
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public LiveData<RetroAchievementsGameRecordEntity> selectByUserIdAndGameId(final String userId, final long gameId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsGameRecordEntity WHERE lower(user_id) = lower(?) AND game_id =?", 2);
        roomSQLiteQueryAcquire.bindString(1, userId);
        roomSQLiteQueryAcquire.bindLong(2, gameId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsGameRecordEntity"}, false, new Callable<RetroAchievementsGameRecordEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO_Impl.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RetroAchievementsGameRecordEntity call() throws Exception {
                RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                        if (cursorQuery.moveToFirst()) {
                            try {
                                retroAchievementsGameRecordEntity = new RetroAchievementsGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8)), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11)), cursorQuery.getInt(columnIndexOrThrow12), cursorQuery.getInt(columnIndexOrThrow13), cursorQuery.getLong(columnIndexOrThrow14), cursorQuery.getLong(columnIndexOrThrow15), cursorQuery.getLong(columnIndexOrThrow16), RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow17) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow17))), cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18), cursorQuery.getInt(columnIndexOrThrow19), cursorQuery.getInt(columnIndexOrThrow20), RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21))));
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        } else {
                            retroAchievementsGameRecordEntity = null;
                        }
                        cursorQuery.close();
                        return retroAchievementsGameRecordEntity;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public RetroAchievementsGameRecordEntity selectByUserIdAndGameIdStatically(final String userId, final long gameId) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsGameRecordEntity WHERE lower(user_id) = lower(?) AND game_id =?", 2);
        roomSQLiteQueryAcquire.bindString(1, userId);
        roomSQLiteQueryAcquire.bindLong(2, gameId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    if (cursorQuery.moveToFirst()) {
                        try {
                            retroAchievementsGameRecordEntity = new RetroAchievementsGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8)), cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10), cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11)), cursorQuery.getInt(columnIndexOrThrow12), cursorQuery.getInt(columnIndexOrThrow13), cursorQuery.getLong(columnIndexOrThrow14), cursorQuery.getLong(columnIndexOrThrow15), cursorQuery.getLong(columnIndexOrThrow16), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow17) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow17))), cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18), cursorQuery.getInt(columnIndexOrThrow19), cursorQuery.getInt(columnIndexOrThrow20), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21))));
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    } else {
                        retroAchievementsGameRecordEntity = null;
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return retroAchievementsGameRecordEntity;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public LiveData<List<RetroAchievementsGameRecordEntity>> selectByUserId(final String id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsGameRecordEntity WHERE (user_id) = lower(?) ORDER BY rating_votes_count ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsGameRecordEntity"}, false, new Callable<List<RetroAchievementsGameRecordEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO_Impl.8
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsGameRecordEntity> call() throws Exception {
                Cursor cursor;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.getString(columnIndexOrThrow2);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow3);
                            String string2 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                            String string3 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                            String string5 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                            Long lValueOf = cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9));
                            String string6 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            Float fValueOf = cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11));
                            int i2 = cursorQuery.getInt(columnIndexOrThrow12);
                            int i3 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i4 = i;
                            long j3 = cursorQuery.getLong(i4);
                            int i5 = columnIndexOrThrow;
                            int i6 = columnIndexOrThrow15;
                            long j4 = cursorQuery.getLong(i6);
                            columnIndexOrThrow15 = i6;
                            int i7 = columnIndexOrThrow16;
                            long j5 = cursorQuery.getLong(i7);
                            columnIndexOrThrow16 = i7;
                            int i8 = columnIndexOrThrow17;
                            try {
                                Date date = RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i8) ? null : Long.valueOf(cursorQuery.getLong(i8)));
                                int i9 = columnIndexOrThrow18;
                                String string7 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                                int i10 = columnIndexOrThrow19;
                                int i11 = cursorQuery.getInt(i10);
                                columnIndexOrThrow18 = i9;
                                int i12 = columnIndexOrThrow20;
                                int i13 = cursorQuery.getInt(i12);
                                columnIndexOrThrow20 = i12;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                cursor = cursorQuery;
                                try {
                                    arrayList.add(new RetroAchievementsGameRecordEntity(j, string, j2, string2, string3, string4, string5, numValueOf, lValueOf, string6, fValueOf, i2, i3, j3, j4, j5, date, string7, i11, i13, RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21)))));
                                    columnIndexOrThrow2 = columnIndexOrThrow2;
                                    cursorQuery = cursor;
                                    columnIndexOrThrow = i5;
                                    columnIndexOrThrow17 = i8;
                                    i = i4;
                                    columnIndexOrThrow19 = i10;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorQuery;
                                cursor.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public List<RetroAchievementsGameRecordEntity> selectByUserIdStatically(final String id2) throws Throwable {
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsGameRecordEntity WHERE (user_id) = lower(?) ORDER BY rating_votes_count ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.getString(columnIndexOrThrow2);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow3);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                        Long lValueOf = cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9));
                        String string6 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        Float fValueOf = cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11));
                        int i2 = cursorQuery.getInt(columnIndexOrThrow12);
                        int i3 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i4 = i;
                        long j3 = cursorQuery.getLong(i4);
                        int i5 = columnIndexOrThrow;
                        int i6 = columnIndexOrThrow15;
                        long j4 = cursorQuery.getLong(i6);
                        columnIndexOrThrow15 = i6;
                        int i7 = columnIndexOrThrow16;
                        long j5 = cursorQuery.getLong(i7);
                        columnIndexOrThrow16 = i7;
                        int i8 = columnIndexOrThrow17;
                        try {
                            Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i8) ? null : Long.valueOf(cursorQuery.getLong(i8)));
                            int i9 = columnIndexOrThrow18;
                            String string7 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                            int i10 = columnIndexOrThrow19;
                            int i11 = cursorQuery.getInt(i10);
                            columnIndexOrThrow18 = i9;
                            int i12 = columnIndexOrThrow20;
                            int i13 = cursorQuery.getInt(i12);
                            columnIndexOrThrow20 = i12;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            cursor = cursorQuery;
                            try {
                                arrayList.add(new RetroAchievementsGameRecordEntity(j, string, j2, string2, string3, string4, string5, numValueOf, lValueOf, string6, fValueOf, i2, i3, j3, j4, j5, date, string7, i11, i13, this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21)))));
                                cursorQuery = cursor;
                                columnIndexOrThrow = i5;
                                columnIndexOrThrow19 = i10;
                                i = i4;
                                columnIndexOrThrow17 = i8;
                                columnIndexOrThrow13 = columnIndexOrThrow13;
                            } catch (Throwable th) {
                                th = th;
                                cursor.close();
                                roomSQLiteQuery.release();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                            cursor.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            cursor = cursorQuery;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public LiveData<List<RetroAchievementsGameRecordEntity>> selectByUserIdAndGameIds(final String userId, final long... gameIds) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM RetroAchievementsGameRecordEntity WHERE lower(user_id) = lower(");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(") AND game_id IN (");
        int length = gameIds.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length + 1);
        roomSQLiteQueryAcquire.bindString(1, userId);
        int i = 2;
        for (long j : gameIds) {
            roomSQLiteQueryAcquire.bindLong(i, j);
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsGameRecordEntity"}, false, new Callable<List<RetroAchievementsGameRecordEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO_Impl.9
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsGameRecordEntity> call() throws Exception {
                Cursor cursor;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                        int i2 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j2 = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.getString(columnIndexOrThrow2);
                            long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                            String string2 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                            String string3 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                            String string5 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                            Long lValueOf = cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9));
                            String string6 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            Float fValueOf = cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11));
                            int i3 = cursorQuery.getInt(columnIndexOrThrow12);
                            int i4 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i5 = i2;
                            long j4 = cursorQuery.getLong(i5);
                            int i6 = columnIndexOrThrow;
                            int i7 = columnIndexOrThrow15;
                            long j5 = cursorQuery.getLong(i7);
                            columnIndexOrThrow15 = i7;
                            int i8 = columnIndexOrThrow16;
                            long j6 = cursorQuery.getLong(i8);
                            columnIndexOrThrow16 = i8;
                            int i9 = columnIndexOrThrow17;
                            try {
                                Date date = RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i9) ? null : Long.valueOf(cursorQuery.getLong(i9)));
                                int i10 = columnIndexOrThrow18;
                                String string7 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                                int i11 = columnIndexOrThrow19;
                                int i12 = cursorQuery.getInt(i11);
                                columnIndexOrThrow18 = i10;
                                int i13 = columnIndexOrThrow20;
                                int i14 = cursorQuery.getInt(i13);
                                columnIndexOrThrow20 = i13;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                cursor = cursorQuery;
                                try {
                                    arrayList.add(new RetroAchievementsGameRecordEntity(j2, string, j3, string2, string3, string4, string5, numValueOf, lValueOf, string6, fValueOf, i3, i4, j4, j5, j6, date, string7, i12, i14, RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21)))));
                                    columnIndexOrThrow2 = columnIndexOrThrow2;
                                    cursorQuery = cursor;
                                    columnIndexOrThrow = i6;
                                    columnIndexOrThrow17 = i9;
                                    i2 = i5;
                                    columnIndexOrThrow19 = i11;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorQuery;
                                cursor.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public List<RetroAchievementsGameRecordEntity> selectByUserIdAndGameIdsStatically(final String userId, final long... gameIds) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM RetroAchievementsGameRecordEntity WHERE lower(user_id) = lower(");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(") AND game_id IN (");
        int length = gameIds.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(") ");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length + 1);
        roomSQLiteQueryAcquire.bindString(1, userId);
        int i = 2;
        for (long j : gameIds) {
            roomSQLiteQueryAcquire.bindLong(i, j);
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    int i2 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j2 = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.getString(columnIndexOrThrow2);
                        long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                        Long lValueOf = cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9));
                        String string6 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        Float fValueOf = cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11));
                        int i3 = cursorQuery.getInt(columnIndexOrThrow12);
                        int i4 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i5 = i2;
                        long j4 = cursorQuery.getLong(i5);
                        int i6 = columnIndexOrThrow;
                        int i7 = columnIndexOrThrow15;
                        long j5 = cursorQuery.getLong(i7);
                        columnIndexOrThrow15 = i7;
                        int i8 = columnIndexOrThrow16;
                        long j6 = cursorQuery.getLong(i8);
                        columnIndexOrThrow16 = i8;
                        int i9 = columnIndexOrThrow17;
                        try {
                            Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i9) ? null : Long.valueOf(cursorQuery.getLong(i9)));
                            int i10 = columnIndexOrThrow18;
                            String string7 = cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10);
                            int i11 = columnIndexOrThrow19;
                            int i12 = cursorQuery.getInt(i11);
                            columnIndexOrThrow18 = i10;
                            int i13 = columnIndexOrThrow20;
                            int i14 = cursorQuery.getInt(i13);
                            columnIndexOrThrow20 = i13;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            columnIndexOrThrow19 = i11;
                            arrayList.add(new RetroAchievementsGameRecordEntity(j2, string, j3, string2, string3, string4, string5, numValueOf, lValueOf, string6, fValueOf, i3, i4, j4, j5, j6, date, string7, i12, i14, this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21)))));
                            columnIndexOrThrow = i6;
                            columnIndexOrThrow13 = columnIndexOrThrow13;
                            i2 = i5;
                            columnIndexOrThrow17 = i9;
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
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public LiveData<List<RetroAchievementsGameRecordEntity>> selectByGameId(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsGameRecordEntity WHERE game_id = ? ORDER BY game_id ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsGameRecordEntity"}, false, new Callable<List<RetroAchievementsGameRecordEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO_Impl.10
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsGameRecordEntity> call() throws Exception {
                Cursor cursor;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.getString(columnIndexOrThrow2);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow3);
                            String string2 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                            String string3 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                            String string5 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                            Long lValueOf = cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9));
                            String string6 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                            Float fValueOf = cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11));
                            int i2 = cursorQuery.getInt(columnIndexOrThrow12);
                            int i3 = cursorQuery.getInt(columnIndexOrThrow13);
                            int i4 = i;
                            long j3 = cursorQuery.getLong(i4);
                            int i5 = columnIndexOrThrow;
                            int i6 = columnIndexOrThrow15;
                            long j4 = cursorQuery.getLong(i6);
                            columnIndexOrThrow15 = i6;
                            int i7 = columnIndexOrThrow16;
                            long j5 = cursorQuery.getLong(i7);
                            columnIndexOrThrow16 = i7;
                            int i8 = columnIndexOrThrow17;
                            try {
                                Date date = RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i8) ? null : Long.valueOf(cursorQuery.getLong(i8)));
                                int i9 = columnIndexOrThrow18;
                                String string7 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                                int i10 = columnIndexOrThrow19;
                                int i11 = cursorQuery.getInt(i10);
                                columnIndexOrThrow18 = i9;
                                int i12 = columnIndexOrThrow20;
                                int i13 = cursorQuery.getInt(i12);
                                columnIndexOrThrow20 = i12;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                cursor = cursorQuery;
                                try {
                                    arrayList.add(new RetroAchievementsGameRecordEntity(j, string, j2, string2, string3, string4, string5, numValueOf, lValueOf, string6, fValueOf, i2, i3, j3, j4, j5, date, string7, i11, i13, RetroAchievementsGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21)))));
                                    columnIndexOrThrow2 = columnIndexOrThrow2;
                                    cursorQuery = cursor;
                                    columnIndexOrThrow = i5;
                                    columnIndexOrThrow17 = i8;
                                    i = i4;
                                    columnIndexOrThrow19 = i10;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorQuery;
                                cursor.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO
    public List<RetroAchievementsGameRecordEntity> selectByGameIdStatically(final long id2) throws Throwable {
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsGameRecordEntity WHERE game_id = ? ORDER BY game_id ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guide_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rating_votes_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_player_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_player_count");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_casual_player_count");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "distinct_hardcore_player_count");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "released_date_granularity");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unlocked_achievements_count");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.getString(columnIndexOrThrow2);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow3);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                        Long lValueOf = cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9));
                        String string6 = cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10);
                        Float fValueOf = cursorQuery.isNull(columnIndexOrThrow11) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow11));
                        int i2 = cursorQuery.getInt(columnIndexOrThrow12);
                        int i3 = cursorQuery.getInt(columnIndexOrThrow13);
                        int i4 = i;
                        long j3 = cursorQuery.getLong(i4);
                        int i5 = columnIndexOrThrow;
                        int i6 = columnIndexOrThrow15;
                        long j4 = cursorQuery.getLong(i6);
                        columnIndexOrThrow15 = i6;
                        int i7 = columnIndexOrThrow16;
                        long j5 = cursorQuery.getLong(i7);
                        columnIndexOrThrow16 = i7;
                        int i8 = columnIndexOrThrow17;
                        try {
                            Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i8) ? null : Long.valueOf(cursorQuery.getLong(i8)));
                            int i9 = columnIndexOrThrow18;
                            String string7 = cursorQuery.isNull(i9) ? null : cursorQuery.getString(i9);
                            int i10 = columnIndexOrThrow19;
                            int i11 = cursorQuery.getInt(i10);
                            columnIndexOrThrow18 = i9;
                            int i12 = columnIndexOrThrow20;
                            int i13 = cursorQuery.getInt(i12);
                            columnIndexOrThrow20 = i12;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            cursor = cursorQuery;
                            try {
                                arrayList.add(new RetroAchievementsGameRecordEntity(j, string, j2, string2, string3, string4, string5, numValueOf, lValueOf, string6, fValueOf, i2, i3, j3, j4, j5, date, string7, i11, i13, this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow21) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow21)))));
                                cursorQuery = cursor;
                                columnIndexOrThrow = i5;
                                columnIndexOrThrow19 = i10;
                                i = i4;
                                columnIndexOrThrow17 = i8;
                                columnIndexOrThrow13 = columnIndexOrThrow13;
                            } catch (Throwable th) {
                                th = th;
                                cursor.close();
                                roomSQLiteQuery.release();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                            cursor.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            cursor = cursorQuery;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
