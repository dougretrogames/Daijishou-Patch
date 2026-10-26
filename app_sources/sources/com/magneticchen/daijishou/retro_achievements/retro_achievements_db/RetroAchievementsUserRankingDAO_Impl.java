package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* INFO: loaded from: classes4.dex */
public final class RetroAchievementsUserRankingDAO_Impl implements RetroAchievementsUserRankingDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsUserRankingEntity> __deletionAdapterOfRetroAchievementsUserRankingEntity;
    private final EntityInsertionAdapter<RetroAchievementsUserRankingEntity> __insertionAdapterOfRetroAchievementsUserRankingEntity;
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsUserRankingEntity> __updateAdapterOfRetroAchievementsUserRankingEntity;

    public RetroAchievementsUserRankingDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRetroAchievementsUserRankingEntity = new AnonymousClass1(__db);
        this.__deletionAdapterOfRetroAchievementsUserRankingEntity = new AnonymousClass2(__db);
        this.__updateAdapterOfRetroAchievementsUserRankingEntity = new AnonymousClass3(__db);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<RetroAchievementsUserRankingEntity> {
        AnonymousClass1(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `RetroAchievementsUserRankingEntity` (`id`,`user_id`,`whose_perspective`,`granularity`,`url`,`image_url`,`earned_points`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
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
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends EntityDeletionOrUpdateAdapter<RetroAchievementsUserRankingEntity> {
        AnonymousClass2(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `RetroAchievementsUserRankingEntity` WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserRankingEntity entity) {
            statement.bindLong(1, entity.getId());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends EntityDeletionOrUpdateAdapter<RetroAchievementsUserRankingEntity> {
        AnonymousClass3(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `RetroAchievementsUserRankingEntity` SET `id` = ?,`user_id` = ?,`whose_perspective` = ?,`granularity` = ?,`url` = ?,`image_url` = ?,`earned_points` = ? WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
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
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
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

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO_Impl$4, reason: invalid class name */
    class AnonymousClass4 implements Callable<Integer> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass4(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Integer numValueOf = null;
            Cursor cursorQuery = DBUtil.query(RetroAchievementsUserRankingDAO_Impl.this.__db, this.val$_statement, false, null);
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
    public LiveData<Integer> countAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserRankingEntity"}, false, new AnonymousClass4(RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsUserRankingEntity", 0)));
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsUserRankingEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
    public LiveData<RetroAchievementsUserRankingEntity> selectById(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserRankingEntity"}, false, new AnonymousClass5(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO_Impl$5, reason: invalid class name */
    class AnonymousClass5 implements Callable<RetroAchievementsUserRankingEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass5(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public RetroAchievementsUserRankingEntity call() throws Exception {
            RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity = null;
            Cursor cursorQuery = DBUtil.query(RetroAchievementsUserRankingDAO_Impl.this.__db, this.val$_statement, false, null);
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
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
    public RetroAchievementsUserRankingEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
    public LiveData<List<RetroAchievementsUserRankingEntity>> selectByPerspectiveAndGranularity(final String whosePerspective, final int granularity) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE lower(whose_perspective) = lower(?) AND granularity = ? ORDER BY earned_points DESC", 2);
        roomSQLiteQueryAcquire.bindString(1, whosePerspective);
        roomSQLiteQueryAcquire.bindLong(2, granularity);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserRankingEntity"}, false, new AnonymousClass6(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO_Impl$6, reason: invalid class name */
    class AnonymousClass6 implements Callable<List<RetroAchievementsUserRankingEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass6(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<RetroAchievementsUserRankingEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(RetroAchievementsUserRankingDAO_Impl.this.__db, this.val$_statement, false, null);
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
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
    public List<RetroAchievementsUserRankingEntity> selectByPerspectiveAndGranularityStatically(final String whosePerspective, final int granularity) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE lower(whose_perspective) = lower(?) AND granularity = ? ORDER BY earned_points DESC", 2);
        roomSQLiteQueryAcquire.bindString(1, whosePerspective);
        roomSQLiteQueryAcquire.bindLong(2, granularity);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
    public LiveData<List<RetroAchievementsUserRankingEntity>> selectByPerspective(final String whosePerspective) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE lower(whose_perspective) = lower(? )ORDER BY earned_points DESC", 1);
        roomSQLiteQueryAcquire.bindString(1, whosePerspective);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserRankingEntity"}, false, new AnonymousClass7(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO_Impl$7, reason: invalid class name */
    class AnonymousClass7 implements Callable<List<RetroAchievementsUserRankingEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass7(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<RetroAchievementsUserRankingEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(RetroAchievementsUserRankingDAO_Impl.this.__db, this.val$_statement, false, null);
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
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingDAO
    public List<RetroAchievementsUserRankingEntity> selectByPerspectiveStatically(final String whosePerspective) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserRankingEntity WHERE lower(whose_perspective) = lower(?) ORDER BY earned_points DESC", 1);
        roomSQLiteQueryAcquire.bindString(1, whosePerspective);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
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
