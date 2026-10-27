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
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserIndependentGameRecordEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class RetroAchievementsUserIndependentGameRecordDAO_Impl implements RetroAchievementsUserIndependentGameRecordDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsUserIndependentGameRecordEntity> __deletionAdapterOfRetroAchievementsUserIndependentGameRecordEntity;
    private final EntityInsertionAdapter<RetroAchievementsUserIndependentGameRecordEntity> __insertionAdapterOfRetroAchievementsUserIndependentGameRecordEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByConsoleId;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsUserIndependentGameRecordEntity> __updateAdapterOfRetroAchievementsUserIndependentGameRecordEntity;

    public RetroAchievementsUserIndependentGameRecordDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRetroAchievementsUserIndependentGameRecordEntity = new EntityInsertionAdapter<RetroAchievementsUserIndependentGameRecordEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `RetroAchievementsUserIndependentGameRecordEntity` (`id`,`name`,`url`,`image_url`,`forum_topic_id`,`console_id`,`console_name`,`achievements_count`,`points`,`date_modified`,`last_updated_timestamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserIndependentGameRecordEntity entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getName() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getName());
                }
                if (entity.getUrl() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUrl());
                }
                if (entity.getImageUrl() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getImageUrl());
                }
                if (entity.getForumTopicId() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindLong(5, entity.getForumTopicId().longValue());
                }
                if (entity.getConsoleId() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindLong(6, entity.getConsoleId().longValue());
                }
                if (entity.getConsoleName() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getConsoleName());
                }
                statement.bindLong(8, entity.getAchievementsCount());
                statement.bindLong(9, entity.getPoints());
                Long lFromDate = RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getDateModified());
                if (lFromDate == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindLong(10, lFromDate.longValue());
                }
                Long lFromDate2 = RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdatedTimestamp());
                if (lFromDate2 == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindLong(11, lFromDate2.longValue());
                }
            }
        };
        this.__deletionAdapterOfRetroAchievementsUserIndependentGameRecordEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsUserIndependentGameRecordEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `RetroAchievementsUserIndependentGameRecordEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserIndependentGameRecordEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfRetroAchievementsUserIndependentGameRecordEntity = new EntityDeletionOrUpdateAdapter<RetroAchievementsUserIndependentGameRecordEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `RetroAchievementsUserIndependentGameRecordEntity` SET `id` = ?,`name` = ?,`url` = ?,`image_url` = ?,`forum_topic_id` = ?,`console_id` = ?,`console_name` = ?,`achievements_count` = ?,`points` = ?,`date_modified` = ?,`last_updated_timestamp` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final RetroAchievementsUserIndependentGameRecordEntity entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getName() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getName());
                }
                if (entity.getUrl() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUrl());
                }
                if (entity.getImageUrl() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getImageUrl());
                }
                if (entity.getForumTopicId() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindLong(5, entity.getForumTopicId().longValue());
                }
                if (entity.getConsoleId() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindLong(6, entity.getConsoleId().longValue());
                }
                if (entity.getConsoleName() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getConsoleName());
                }
                statement.bindLong(8, entity.getAchievementsCount());
                statement.bindLong(9, entity.getPoints());
                Long lFromDate = RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getDateModified());
                if (lFromDate == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindLong(10, lFromDate.longValue());
                }
                Long lFromDate2 = RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdatedTimestamp());
                if (lFromDate2 == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindLong(11, lFromDate2.longValue());
                }
                statement.bindLong(12, entity.getId());
            }
        };
        this.__preparedStmtOfDeleteByConsoleId = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.4
            public String createQuery() {
                return "DELETE FROM RetroAchievementsUserIndependentGameRecordEntity WHERE console_id = ?";
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public long insert(final RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfRetroAchievementsUserIndependentGameRecordEntity.insertAndReturnId(retroAchievementsUserIndependentGameRecordEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public List<Long> insertAll(final RetroAchievementsUserIndependentGameRecordEntity... retroAchievementsGameRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfRetroAchievementsUserIndependentGameRecordEntity.insertAndReturnIdsList(retroAchievementsGameRecordEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public void delete(final RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsUserIndependentGameRecordEntity.handle(retroAchievementsUserIndependentGameRecordEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public void deleteAll(final RetroAchievementsUserIndependentGameRecordEntity... retroAchievementsGameRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsUserIndependentGameRecordEntity.handleMultiple(retroAchievementsGameRecordEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public void update(final RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsUserIndependentGameRecordEntity.handle(retroAchievementsUserIndependentGameRecordEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public void updateAll(final RetroAchievementsUserIndependentGameRecordEntity... retroAchievementsGameRecordEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsUserIndependentGameRecordEntity.handleMultiple(retroAchievementsGameRecordEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public LiveData<Integer> countAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsUserIndependentGameRecordEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserIndependentGameRecordEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsUserIndependentGameRecordEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public LiveData<RetroAchievementsUserIndependentGameRecordEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserIndependentGameRecordEntity"}, false, new Callable<RetroAchievementsUserIndependentGameRecordEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RetroAchievementsUserIndependentGameRecordEntity call() throws Exception {
                RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity = null;
                Long lValueOf = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    if (cursorQuery.moveToFirst()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                        Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                        String string4 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        int i = cursorQuery.getInt(columnIndexOrThrow8);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow9);
                        Date date = RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10)));
                        if (!cursorQuery.isNull(columnIndexOrThrow11)) {
                            lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11));
                        }
                        retroAchievementsUserIndependentGameRecordEntity = new RetroAchievementsUserIndependentGameRecordEntity(j, string, string2, string3, lValueOf2, lValueOf3, string4, i, j2, date, RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(lValueOf));
                    }
                    return retroAchievementsUserIndependentGameRecordEntity;
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
    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public RetroAchievementsUserIndependentGameRecordEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                String string4 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                int i = cursorQuery.getInt(columnIndexOrThrow8);
                long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10)));
                if (!cursorQuery.isNull(columnIndexOrThrow11)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11));
                }
                retroAchievementsUserIndependentGameRecordEntity = new RetroAchievementsUserIndependentGameRecordEntity(j2, string, string2, string3, lValueOf2, lValueOf3, string4, i, j3, date, this.__roomDatabaseConverters.toDate(lValueOf));
            }
            return retroAchievementsUserIndependentGameRecordEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> selectByIds(final long... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(") ORDER BY id");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (long j : ids) {
            roomSQLiteQueryAcquire.bindLong(i, j);
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserIndependentGameRecordEntity"}, false, new Callable<List<RetroAchievementsUserIndependentGameRecordEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserIndependentGameRecordEntity> call() throws Exception {
                String str = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new RetroAchievementsUserIndependentGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? str : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? str : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? str : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), cursorQuery.isNull(columnIndexOrThrow6) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)), cursorQuery.isNull(columnIndexOrThrow7) ? str : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10))), RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)))));
                        str = null;
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public List<RetroAchievementsUserIndependentGameRecordEntity> selectByIdsStatically(final long... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE id IN (");
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
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                int i2 = columnIndexOrThrow;
                arrayList.add(new RetroAchievementsUserIndependentGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10))), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)))));
                columnIndexOrThrow = i2;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> selectByConsoleId(final long consoleId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE console_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, consoleId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserIndependentGameRecordEntity"}, false, new Callable<List<RetroAchievementsUserIndependentGameRecordEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.8
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserIndependentGameRecordEntity> call() throws Exception {
                String str = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new RetroAchievementsUserIndependentGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? str : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? str : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? str : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), cursorQuery.isNull(columnIndexOrThrow6) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)), cursorQuery.isNull(columnIndexOrThrow7) ? str : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10))), RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)))));
                        str = null;
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public List<RetroAchievementsUserIndependentGameRecordEntity> selectByConsoleIdStatically(final long consoleId) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE console_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, consoleId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                int i = columnIndexOrThrow;
                arrayList.add(new RetroAchievementsUserIndependentGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10))), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)))));
                columnIndexOrThrow = i;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public LiveData<RetroAchievementsUserIndependentGameRecordEntity> selectFirstByConsoleId(final long consoleId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE console_id=? LIMIT 1", 1);
        roomSQLiteQueryAcquire.bindLong(1, consoleId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserIndependentGameRecordEntity"}, false, new Callable<RetroAchievementsUserIndependentGameRecordEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RetroAchievementsUserIndependentGameRecordEntity call() throws Exception {
                RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity = null;
                Long lValueOf = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    if (cursorQuery.moveToFirst()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                        Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                        String string4 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        int i = cursorQuery.getInt(columnIndexOrThrow8);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow9);
                        Date date = RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10)));
                        if (!cursorQuery.isNull(columnIndexOrThrow11)) {
                            lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11));
                        }
                        retroAchievementsUserIndependentGameRecordEntity = new RetroAchievementsUserIndependentGameRecordEntity(j, string, string2, string3, lValueOf2, lValueOf3, string4, i, j2, date, RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(lValueOf));
                    }
                    return retroAchievementsUserIndependentGameRecordEntity;
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
    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public RetroAchievementsUserIndependentGameRecordEntity selectFirstByConsoleIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE console_id=? LIMIT 1", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                Long lValueOf3 = cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6));
                String string4 = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                int i = cursorQuery.getInt(columnIndexOrThrow8);
                long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10)));
                if (!cursorQuery.isNull(columnIndexOrThrow11)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11));
                }
                retroAchievementsUserIndependentGameRecordEntity = new RetroAchievementsUserIndependentGameRecordEntity(j2, string, string2, string3, lValueOf2, lValueOf3, string4, i, j3, date, this.__roomDatabaseConverters.toDate(lValueOf));
            }
            return retroAchievementsUserIndependentGameRecordEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> findWithName(final String search, final int limit) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE name LIKE '%' || ? || '%' ORDER BY name COLLATE NOCASE ASC LIMIT ?", 2);
        roomSQLiteQueryAcquire.bindString(1, search);
        roomSQLiteQueryAcquire.bindLong(2, limit);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserIndependentGameRecordEntity"}, false, new Callable<List<RetroAchievementsUserIndependentGameRecordEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.10
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserIndependentGameRecordEntity> call() throws Exception {
                String str = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new RetroAchievementsUserIndependentGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? str : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? str : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? str : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), cursorQuery.isNull(columnIndexOrThrow6) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)), cursorQuery.isNull(columnIndexOrThrow7) ? str : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10))), RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)))));
                        str = null;
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public List<RetroAchievementsUserIndependentGameRecordEntity> findWithNameStatically(final String search, final int limit) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE name LIKE '%' || ? || '%' ORDER BY name COLLATE NOCASE ASC LIMIT ?", 2);
        roomSQLiteQueryAcquire.bindString(1, search);
        roomSQLiteQueryAcquire.bindLong(2, limit);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                int i = columnIndexOrThrow;
                arrayList.add(new RetroAchievementsUserIndependentGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10))), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)))));
                columnIndexOrThrow = i;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> findWithNameAndConsoleId(final String search, final long consoleId, final int limit) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE console_id=? AND name LIKE '%' || ? || '%' ORDER BY name COLLATE NOCASE ASC LIMIT ?", 3);
        roomSQLiteQueryAcquire.bindLong(1, consoleId);
        roomSQLiteQueryAcquire.bindString(2, search);
        roomSQLiteQueryAcquire.bindLong(3, limit);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsUserIndependentGameRecordEntity"}, false, new Callable<List<RetroAchievementsUserIndependentGameRecordEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO_Impl.11
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public List<RetroAchievementsUserIndependentGameRecordEntity> call() throws Exception {
                String str = null;
                Cursor cursorQuery = DBUtil.query(RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new RetroAchievementsUserIndependentGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? str : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? str : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? str : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), cursorQuery.isNull(columnIndexOrThrow6) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)), cursorQuery.isNull(columnIndexOrThrow7) ? str : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? str : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10))), RetroAchievementsUserIndependentGameRecordDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)))));
                        str = null;
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

    @Override // com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO
    public List<RetroAchievementsUserIndependentGameRecordEntity> findWithNameAndConsoleIdStatically(final String search, final long consoleId, final int limit) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsUserIndependentGameRecordEntity WHERE console_id=? AND name LIKE '%' || ? || '%' ORDER BY name COLLATE NOCASE ASC LIMIT ?", 3);
        roomSQLiteQueryAcquire.bindLong(1, consoleId);
        roomSQLiteQueryAcquire.bindString(2, search);
        roomSQLiteQueryAcquire.bindLong(3, limit);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forum_topic_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "console_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "achievements_count");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "points");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date_modified");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                int i = columnIndexOrThrow;
                arrayList.add(new RetroAchievementsUserIndependentGameRecordEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow10) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow10))), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)))));
                columnIndexOrThrow = i;
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
