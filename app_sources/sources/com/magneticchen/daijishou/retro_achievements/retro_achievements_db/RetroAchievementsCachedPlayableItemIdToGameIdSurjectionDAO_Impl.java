package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.magneticchen.daijishou.application_data.RoomDatabaseConverters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* INFO: loaded from: classes4.dex */
public final class RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl implements RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> __deletionAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
    private final EntityInsertionAdapter<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> __insertionAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByPlayableItemId;
    private final SharedSQLiteStatement __preparedStmtOfNukeTable;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> __updateAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;

    public RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = new AnonymousClass1(__db);
        this.__deletionAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = new AnonymousClass2(__db);
        this.__updateAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = new AnonymousClass3(__db);
        this.__preparedStmtOfNukeTable = new AnonymousClass4(__db);
        this.__preparedStmtOfDeleteById = new AnonymousClass5(__db);
        this.__preparedStmtOfDeleteByPlayableItemId = new AnonymousClass6(__db);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> {
        AnonymousClass1(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity` (`id`,`is_permanent`,`playable_item_id`,`game_id`,`last_updated_timestamp`) VALUES (nullif(?, 0),?,?,?,?)";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) {
            supportSQLiteStatement.bindLong(1, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getId());
            supportSQLiteStatement.bindLong(2, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.isPermanent() ? 1L : 0L);
            supportSQLiteStatement.bindLong(3, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getPlayableItemId());
            supportSQLiteStatement.bindLong(4, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getGameId());
            Long lFromDate = RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl.this.__roomDatabaseConverters.fromDate(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getLastUpdatedTimestamp());
            if (lFromDate == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, lFromDate.longValue());
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends EntityDeletionOrUpdateAdapter<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> {
        AnonymousClass2(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity` WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(final SupportSQLiteStatement statement, final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity entity) {
            statement.bindLong(1, entity.getId());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends EntityDeletionOrUpdateAdapter<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> {
        AnonymousClass3(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity` SET `id` = ?,`is_permanent` = ?,`playable_item_id` = ?,`game_id` = ?,`last_updated_timestamp` = ? WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) {
            supportSQLiteStatement.bindLong(1, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getId());
            supportSQLiteStatement.bindLong(2, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.isPermanent() ? 1L : 0L);
            supportSQLiteStatement.bindLong(3, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getPlayableItemId());
            supportSQLiteStatement.bindLong(4, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getGameId());
            Long lFromDate = RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl.this.__roomDatabaseConverters.fromDate(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getLastUpdatedTimestamp());
            if (lFromDate == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, lFromDate.longValue());
            }
            supportSQLiteStatement.bindLong(6, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getId());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl$4, reason: invalid class name */
    class AnonymousClass4 extends SharedSQLiteStatement {
        AnonymousClass4(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity";
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl$5, reason: invalid class name */
    class AnonymousClass5 extends SharedSQLiteStatement {
        AnonymousClass5(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity WHERE id = ?";
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl$6, reason: invalid class name */
    class AnonymousClass6 extends SharedSQLiteStatement {
        AnonymousClass6(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity WHERE playable_item_id = ?";
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public long insert(final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.insertAndReturnId(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public List<Long> insertAll(final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity... retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.insertAndReturnIdsList(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public void delete(final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.handle(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public void deleteAll(final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity... retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.handleMultiple(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public void update(final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.handle(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public void updateAll(final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity... retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.handleMultiple(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public void deleteByPlayableItemId(final long id2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByPlayableItemId.acquire();
        supportSQLiteStatementAcquire.bindLong(1, id2);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteByPlayableItemId.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteByPlayableItemId.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl$7, reason: invalid class name */
    class AnonymousClass7 implements Callable<Integer> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass7(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Integer numValueOf = null;
            Cursor cursorQuery = DBUtil.query(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl.this.__db, this.val$_statement, false, null);
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public LiveData<Integer> countAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity"}, false, new AnonymousClass7(RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity", 0)));
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public LiveData<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> selectById(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity"}, false, new AnonymousClass8(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl$8, reason: invalid class name */
    class AnonymousClass8 implements Callable<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass8(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity call() throws Exception {
            RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = null;
            Long lValueOf = null;
            Cursor cursorQuery = DBUtil.query(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_permanent");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                if (cursorQuery.moveToFirst()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow2) != 0;
                    long j2 = cursorQuery.getLong(columnIndexOrThrow3);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow4);
                    if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                        lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                    }
                    retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(j, z, j2, j3, RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl.this.__roomDatabaseConverters.toDate(lValueOf));
                }
                return retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
            } finally {
                cursorQuery.close();
            }
        }

        protected void finalize() {
            this.val$_statement.release();
        }
    }

    /* WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
    	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_permanent");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                boolean z = cursorQuery.getInt(columnIndexOrThrow2) != 0;
                long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                long j4 = cursorQuery.getLong(columnIndexOrThrow4);
                if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                }
                retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(j2, z, j3, j4, this.__roomDatabaseConverters.toDate(lValueOf));
            }
            return retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public LiveData<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> selectByPlayableItemId(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity WHERE playable_item_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity"}, false, new AnonymousClass9(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl$9, reason: invalid class name */
    class AnonymousClass9 implements Callable<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass9(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity call() throws Exception {
            RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = null;
            Long lValueOf = null;
            Cursor cursorQuery = DBUtil.query(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_permanent");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                if (cursorQuery.moveToFirst()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow2) != 0;
                    long j2 = cursorQuery.getLong(columnIndexOrThrow3);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow4);
                    if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                        lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                    }
                    retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(j, z, j2, j3, RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl.this.__roomDatabaseConverters.toDate(lValueOf));
                }
                return retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
            } finally {
                cursorQuery.close();
            }
        }

        protected void finalize() {
            this.val$_statement.release();
        }
    }

    /* WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
    	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity selectByPlayableItemIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity WHERE playable_item_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_permanent");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                boolean z = cursorQuery.getInt(columnIndexOrThrow2) != 0;
                long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                long j4 = cursorQuery.getLong(columnIndexOrThrow4);
                if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                }
                retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(j2, z, j3, j4, this.__roomDatabaseConverters.toDate(lValueOf));
            }
            return retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public LiveData<List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity>> selectByGameId(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity WHERE game_id = ? ORDER BY game_id ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity"}, false, new AnonymousClass10(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl$10, reason: invalid class name */
    class AnonymousClass10 implements Callable<List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass10(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_permanent");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2) != 0, cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)))));
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

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO
    public List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> selectByGameIdStatically(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity WHERE game_id = ? ORDER BY game_id ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_permanent");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "game_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated_timestamp");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2) != 0, cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)))));
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
