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
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserRankingEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class RetroAchievementsUserRankingDAO_Impl implements RetroAchievementsUserRankingDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsUserRankingEntity> __deletionAdapterOfRetroAchievementsUserRankingEntity;
    private final EntityInsertionAdapter<RetroAchievementsUserRankingEntity> __insertionAdapterOfRetroAchievementsUserRankingEntity;
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsUserRankingEntity> __updateAdapterOfRetroAchievementsUserRankingEntity;

    public RetroAchievementsUserRankingDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRetroAchievementsUserRankingEntity = new EntityInsertionAdapter<RetroAchievementsUserRankingEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `RetroAchievementsUserRankingEntity` (`id`,`user_id`,`whose_perspective`,`granularity`,`url`,`image_url`,`earned_points`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserRankingEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getUserId());
                statement.bindString(3, entity.getWhosePerspective());
                statement.bindLong(4, entity.getGranularity());
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
                statement.bindLong(7, entity.getEarnedPoints());
            }
        };
        this.__deletionAdapterOfRetroAchievementsUserRankingEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsUserRankingEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `RetroAchievementsUserRankingEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserRankingEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfRetroAchievementsUserRankingEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsUserRankingEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `RetroAchievementsUserRankingEntity` SET `id` = ?,`user_id` = ?,`whose_perspective` = ?,`granularity` = ?,`url` = ?,`image_url` = ?,`earned_points` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserRankingEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getUserId());
                statement.bindString(3, entity.getWhosePerspective());
                statement.bindLong(4, entity.getGranularity());
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
                statement.bindLong(7, entity.getEarnedPoints());
                statement.bindLong(8, entity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public long insert(final RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfRetroAchievementsUserRankingEntity.insertAndReturnId(retroAchievementsUserRankingEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public List<Long> insertAll(final RetroAchievementsUserRankingEntity... retroAchievementsUserRankingEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfRetroAchievementsUserRankingEntity.insertAndReturnIdsList(retroAchievementsUserRankingEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public void delete(final RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsUserRankingEntity.handle(retroAchievementsUserRankingEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public void deleteAll(final RetroAchievementsUserRankingEntity... retroAchievementsUserRankingEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsUserRankingEntity.handleMultiple(retroAchievementsUserRankingEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public void update(final RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsUserRankingEntity.handle(retroAchievementsUserRankingEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public void updateAll(final RetroAchievementsUserRankingEntity... retroAchievementsUserRankingEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsUserRankingEntity.handleMultiple(retroAchievementsUserRankingEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public LiveData<Integer> countAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsUserRankingEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserRankingEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserRankingDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsUserRankingEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public LiveData<RetroAchievementsUserRankingEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserRankingEntity"}, false, new Callable<RetroAchievementsUserRankingEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RetroAchievementsUserRankingEntity call() throws Exception {
                RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserRankingDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "whose_perspective");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "granularity");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "earned_points");
                    if (cursorQuery.moveToFirst()) {
                        retroAchievementsUserRankingEntity = new RetroAchievementsUserRankingEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7));
                    }
                    return retroAchievementsUserRankingEntity;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public RetroAchievementsUserRankingEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "whose_perspective");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "granularity");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "earned_points");
            if (cursorQuery.moveToFirst()) {
                retroAchievementsUserRankingEntity = new RetroAchievementsUserRankingEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7));
            }
            return retroAchievementsUserRankingEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public LiveData<List<RetroAchievementsUserRankingEntity>> selectByPerspectiveAndGranularity(final String whosePerspective, final int granularity) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE lower(whose_perspective) = lower(?) AND granularity = ? ORDER BY earned_points DESC", 2);
        roomSQLiteQueryAcquire.bindString(1, whosePerspective);
        roomSQLiteQueryAcquire.bindLong(2, granularity);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserRankingEntity"}, false, new Callable<List<RetroAchievementsUserRankingEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserRankingEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserRankingDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "whose_perspective");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "granularity");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "earned_points");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new RetroAchievementsUserRankingEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public List<RetroAchievementsUserRankingEntity> selectByPerspectiveAndGranularityStatically(final String whosePerspective, final int granularity) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE lower(whose_perspective) = lower(?) AND granularity = ? ORDER BY earned_points DESC", 2);
        roomSQLiteQueryAcquire.bindString(1, whosePerspective);
        roomSQLiteQueryAcquire.bindLong(2, granularity);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "whose_perspective");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "granularity");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "earned_points");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new RetroAchievementsUserRankingEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public LiveData<List<RetroAchievementsUserRankingEntity>> selectByPerspective(final String whosePerspective) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE lower(whose_perspective) = lower(? )ORDER BY earned_points DESC", 1);
        roomSQLiteQueryAcquire.bindString(1, whosePerspective);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserRankingEntity"}, false, new Callable<List<RetroAchievementsUserRankingEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO_Impl.7
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserRankingEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserRankingDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "whose_perspective");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "granularity");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "earned_points");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new RetroAchievementsUserRankingEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO
    public List<RetroAchievementsUserRankingEntity> selectByPerspectiveStatically(final String whosePerspective) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE lower(whose_perspective) = lower(?) ORDER BY earned_points DESC", 1);
        roomSQLiteQueryAcquire.bindString(1, whosePerspective);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "whose_perspective");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "granularity");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "earned_points");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new RetroAchievementsUserRankingEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
