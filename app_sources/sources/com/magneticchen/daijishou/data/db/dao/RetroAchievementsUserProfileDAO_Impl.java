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
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserProfileEntity;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class RetroAchievementsUserProfileDAO_Impl implements RetroAchievementsUserProfileDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsUserProfileEntity> __deletionAdapterOfRetroAchievementsUserProfileEntity;
    private final EntityInsertionAdapter<RetroAchievementsUserProfileEntity> __insertionAdapterOfRetroAchievementsUserProfileEntity;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsUserProfileEntity> __updateAdapterOfRetroAchievementsUserProfileEntity;

    public RetroAchievementsUserProfileDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRetroAchievementsUserProfileEntity = new EntityInsertionAdapter<RetroAchievementsUserProfileEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `RetroAchievementsUserProfileEntity` (`id`,`url`,`image_url`,`softcore_points`,`hardcore_points`,`rich_presence_msg`,`motto`,`last_game_id`,`average_completion_percentage`,`recent_played_game_ids`,`completion_progress_game_ids`,`last_updated_timestamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserProfileEntity entity) {
                statement.bindString(1, entity.getId());
                if (entity.getUrl() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getUrl());
                }
                if (entity.getImageUrl() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getImageUrl());
                }
                statement.bindLong(4, entity.getSoftcorePoints());
                statement.bindLong(5, entity.getHardcorePoints());
                if (entity.getRichPresenceMsg() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getRichPresenceMsg());
                }
                if (entity.getMotto() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getMotto());
                }
                if (entity.getLastGameID() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindLong(8, entity.getLastGameID().longValue());
                }
                statement.bindDouble(9, entity.getAverageCompletionPercentage());
                statement.bindString(10, RetroAchievementsUserProfileDAO_Impl.this.__roomDatabaseConverters.fromMutableLongList(entity.getRecentPlayedGameIds()));
                statement.bindString(11, RetroAchievementsUserProfileDAO_Impl.this.__roomDatabaseConverters.fromMutableLongList(entity.getCompletionProgressGameIds()));
                Long lFromDate = RetroAchievementsUserProfileDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdatedTimestamp());
                if (lFromDate == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindLong(12, lFromDate.longValue());
                }
            }
        };
        this.__deletionAdapterOfRetroAchievementsUserProfileEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsUserProfileEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `RetroAchievementsUserProfileEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserProfileEntity entity) {
                statement.bindString(1, entity.getId());
            }
        };
        this.__updateAdapterOfRetroAchievementsUserProfileEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsUserProfileEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `RetroAchievementsUserProfileEntity` SET `id` = ?,`url` = ?,`image_url` = ?,`softcore_points` = ?,`hardcore_points` = ?,`rich_presence_msg` = ?,`motto` = ?,`last_game_id` = ?,`average_completion_percentage` = ?,`recent_played_game_ids` = ?,`completion_progress_game_ids` = ?,`last_updated_timestamp` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserProfileEntity entity) {
                statement.bindString(1, entity.getId());
                if (entity.getUrl() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getUrl());
                }
                if (entity.getImageUrl() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getImageUrl());
                }
                statement.bindLong(4, entity.getSoftcorePoints());
                statement.bindLong(5, entity.getHardcorePoints());
                if (entity.getRichPresenceMsg() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getRichPresenceMsg());
                }
                if (entity.getMotto() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getMotto());
                }
                if (entity.getLastGameID() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindLong(8, entity.getLastGameID().longValue());
                }
                statement.bindDouble(9, entity.getAverageCompletionPercentage());
                statement.bindString(10, RetroAchievementsUserProfileDAO_Impl.this.__roomDatabaseConverters.fromMutableLongList(entity.getRecentPlayedGameIds()));
                statement.bindString(11, RetroAchievementsUserProfileDAO_Impl.this.__roomDatabaseConverters.fromMutableLongList(entity.getCompletionProgressGameIds()));
                Long lFromDate = RetroAchievementsUserProfileDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdatedTimestamp());
                if (lFromDate == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindLong(12, lFromDate.longValue());
                }
                statement.bindString(13, entity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO
    public long insert(final RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfRetroAchievementsUserProfileEntity.insertAndReturnId(retroAchievementsUserProfileEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO
    public List<Long> insertAll(final RetroAchievementsUserProfileEntity... retroAchievementsUserProfileEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfRetroAchievementsUserProfileEntity.insertAndReturnIdsList(retroAchievementsUserProfileEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO
    public void delete(final RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsUserProfileEntity.handle(retroAchievementsUserProfileEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO
    public void deleteAll(final RetroAchievementsUserProfileEntity... retroAchievementsUserProfileEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsUserProfileEntity.handleMultiple(retroAchievementsUserProfileEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO
    public void update(final RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsUserProfileEntity.handle(retroAchievementsUserProfileEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO
    public void updateAll(final RetroAchievementsUserProfileEntity... retroAchievementsUserProfileEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsUserProfileEntity.handleMultiple(retroAchievementsUserProfileEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO
    public LiveData<Integer> countAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsUserProfileEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserProfileEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserProfileDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsUserProfileEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO
    public LiveData<RetroAchievementsUserProfileEntity> selectById(final String id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserProfileEntity WHERE lower(id) = lower(?)", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserProfileEntity"}, false, new Callable<RetroAchievementsUserProfileEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RetroAchievementsUserProfileEntity call() throws Exception {
                RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity = null;
                Long lValueOf = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserProfileDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "softcore_points");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hardcore_points");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rich_presence_msg");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "motto");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_game_id");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "average_completion_percentage");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recent_played_game_ids");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "completion_progress_game_ids");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        int i = cursorQuery.getInt(columnIndexOrThrow4);
                        int i2 = cursorQuery.getInt(columnIndexOrThrow5);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                        String string5 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow8) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8));
                        float f = cursorQuery.getFloat(columnIndexOrThrow9);
                        List<Long> mutableLongList = RetroAchievementsUserProfileDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow10));
                        List<Long> mutableLongList2 = RetroAchievementsUserProfileDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow11));
                        if (!cursorQuery.isNull(columnIndexOrThrow12)) {
                            lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12));
                        }
                        retroAchievementsUserProfileEntity = new RetroAchievementsUserProfileEntity(string, string2, string3, i, i2, string4, string5, lValueOf2, f, mutableLongList, mutableLongList2, RetroAchievementsUserProfileDAO_Impl.this.__roomDatabaseConverters.toDate(lValueOf));
                    }
                    return retroAchievementsUserProfileEntity;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO
    public RetroAchievementsUserProfileEntity selectByIdStatically(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserProfileEntity WHERE lower(id) = lower(?)", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        this.__db.assertNotSuspendingTransaction();
        RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "softcore_points");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hardcore_points");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rich_presence_msg");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "motto");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_game_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "average_completion_percentage");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recent_played_game_ids");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "completion_progress_game_ids");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(columnIndexOrThrow);
                String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                int i = cursorQuery.getInt(columnIndexOrThrow4);
                int i2 = cursorQuery.getInt(columnIndexOrThrow5);
                String string4 = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6);
                String string5 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow8) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8));
                float f = cursorQuery.getFloat(columnIndexOrThrow9);
                List<Long> mutableLongList = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow10));
                List<Long> mutableLongList2 = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow11));
                if (!cursorQuery.isNull(columnIndexOrThrow12)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12));
                }
                retroAchievementsUserProfileEntity = new RetroAchievementsUserProfileEntity(string, string2, string3, i, i2, string4, string5, lValueOf2, f, mutableLongList, mutableLongList2, this.__roomDatabaseConverters.toDate(lValueOf));
            }
            return retroAchievementsUserProfileEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
