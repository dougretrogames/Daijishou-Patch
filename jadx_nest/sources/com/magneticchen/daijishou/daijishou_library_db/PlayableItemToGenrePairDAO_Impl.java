package com.magneticchen.daijishou.daijishou_library_db;

import android.database.Cursor;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* INFO: loaded from: classes4.dex */
public final class PlayableItemToGenrePairDAO_Impl implements PlayableItemToGenrePairDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PlayableItemToGenrePairEntity> __deletionAdapterOfPlayableItemToGenrePairEntity;
    private final EntityInsertionAdapter<PlayableItemToGenrePairEntity> __insertionAdapterOfPlayableItemToGenrePairEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByGenreId;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByPlayableItemId;
    private final SharedSQLiteStatement __preparedStmtOfNukeTable;
    private final EntityDeletionOrUpdateAdapter<PlayableItemToGenrePairEntity> __updateAdapterOfPlayableItemToGenrePairEntity;

    public PlayableItemToGenrePairDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPlayableItemToGenrePairEntity = new AnonymousClass1(__db);
        this.__deletionAdapterOfPlayableItemToGenrePairEntity = new AnonymousClass2(__db);
        this.__updateAdapterOfPlayableItemToGenrePairEntity = new AnonymousClass3(__db);
        this.__preparedStmtOfNukeTable = new AnonymousClass4(__db);
        this.__preparedStmtOfDeleteById = new AnonymousClass5(__db);
        this.__preparedStmtOfDeleteByGenreId = new AnonymousClass6(__db);
        this.__preparedStmtOfDeleteByPlayableItemId = new AnonymousClass7(__db);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<PlayableItemToGenrePairEntity> {
        AnonymousClass1(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `PlayableItemToGenrePairEntity` (`id`,`playable_item_id`,`genre_id`,`extra`) VALUES (nullif(?, 0),?,?,?)";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(final SupportSQLiteStatement statement, final PlayableItemToGenrePairEntity entity) {
            statement.bindLong(1, entity.getId());
            statement.bindLong(2, entity.getPlayableItemId());
            statement.bindString(3, entity.getGenreId());
            statement.bindString(4, entity.getExtra());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends EntityDeletionOrUpdateAdapter<PlayableItemToGenrePairEntity> {
        AnonymousClass2(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `PlayableItemToGenrePairEntity` WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(final SupportSQLiteStatement statement, final PlayableItemToGenrePairEntity entity) {
            statement.bindLong(1, entity.getId());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends EntityDeletionOrUpdateAdapter<PlayableItemToGenrePairEntity> {
        AnonymousClass3(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `PlayableItemToGenrePairEntity` SET `id` = ?,`playable_item_id` = ?,`genre_id` = ?,`extra` = ? WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(final SupportSQLiteStatement statement, final PlayableItemToGenrePairEntity entity) {
            statement.bindLong(1, entity.getId());
            statement.bindLong(2, entity.getPlayableItemId());
            statement.bindString(3, entity.getGenreId());
            statement.bindString(4, entity.getExtra());
            statement.bindLong(5, entity.getId());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$4, reason: invalid class name */
    class AnonymousClass4 extends SharedSQLiteStatement {
        AnonymousClass4(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM PlayableItemToGenrePairEntity";
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$5, reason: invalid class name */
    class AnonymousClass5 extends SharedSQLiteStatement {
        AnonymousClass5(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM PlayableItemToGenrePairEntity WHERE id = ?";
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$6, reason: invalid class name */
    class AnonymousClass6 extends SharedSQLiteStatement {
        AnonymousClass6(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM PlayableItemToGenrePairEntity WHERE genre_id = ?";
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$7, reason: invalid class name */
    class AnonymousClass7 extends SharedSQLiteStatement {
        AnonymousClass7(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM PlayableItemToGenrePairEntity WHERE playable_item_id = ?";
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public long insert(final PlayableItemToGenrePairEntity playableItemToGenrePairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfPlayableItemToGenrePairEntity.insertAndReturnId(playableItemToGenrePairEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public List<Long> insertAll(final PlayableItemToGenrePairEntity... playableItemToGenrePairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfPlayableItemToGenrePairEntity.insertAndReturnIdsList(playableItemToGenrePairEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public void delete(final PlayableItemToGenrePairEntity playableItemToGenrePairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPlayableItemToGenrePairEntity.handle(playableItemToGenrePairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public void deleteAll(final PlayableItemToGenrePairEntity... playableItemToGenrePairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPlayableItemToGenrePairEntity.handleMultiple(playableItemToGenrePairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public void update(final PlayableItemToGenrePairEntity playableItemToGenrePairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPlayableItemToGenrePairEntity.handle(playableItemToGenrePairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public void updateAll(final PlayableItemToGenrePairEntity... playableItemToGenrePairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPlayableItemToGenrePairEntity.handleMultiple(playableItemToGenrePairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public void deleteByGenreId(final String id2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByGenreId.acquire();
        supportSQLiteStatementAcquire.bindString(1, id2);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteByGenreId.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteByGenreId.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
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

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$8, reason: invalid class name */
    class AnonymousClass8 implements Callable<Integer> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass8(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Integer numValueOf = null;
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<Integer> countAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity"}, false, new AnonymousClass8(RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM PlayableItemToGenrePairEntity", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM PlayableItemToGenrePairEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$9, reason: invalid class name */
    class AnonymousClass9 implements Callable<List<Long>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass9(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<Long> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<List<Long>> selectAllIds() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity"}, false, new AnonymousClass9(RoomSQLiteQuery.acquire("SELECT id FROM PlayableItemToGenrePairEntity ORDER BY genre_id ASC", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public List<Long> selectAllIdsStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM PlayableItemToGenrePairEntity ORDER BY genre_id ASC", 0);
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<List<String>> selectGenreIdsByPlatformId(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT PlayableItemToGenrePairEntity.genre_id FROM PlayableItemToGenrePairEntity, PlayableItemEntity WHERE PlayableItemEntity.attached_platform_id == ? AND PlayableItemToGenrePairEntity.playable_item_id == PlayableItemEntity.id GROUP BY genre_id ORDER BY count(genre_id) DESC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity", "PlayableItemEntity"}, false, new AnonymousClass10(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$10, reason: invalid class name */
    class AnonymousClass10 implements Callable<List<String>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass10(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(0));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public List<String> selectGenreIdsByPlatformIdStatically(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT PlayableItemToGenrePairEntity.genre_id FROM PlayableItemToGenrePairEntity, PlayableItemEntity WHERE PlayableItemEntity.attached_platform_id == ? AND PlayableItemToGenrePairEntity.playable_item_id == PlayableItemEntity.id GROUP BY genre_id ORDER BY count(genre_id) DESC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<List<String>> selectGenreIdsByPlatformIdAndVisibility(long j, boolean z) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT PlayableItemToGenrePairEntity.genre_id FROM PlayableItemToGenrePairEntity, PlayableItemEntity WHERE PlayableItemEntity.attached_platform_id == ? AND PlayableItemEntity.is_visible == ? AND PlayableItemToGenrePairEntity.playable_item_id == PlayableItemEntity.id GROUP BY genre_id ORDER BY count(genre_id) DESC", 2);
        roomSQLiteQueryAcquire.bindLong(1, j);
        roomSQLiteQueryAcquire.bindLong(2, z ? 1L : 0L);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity", "PlayableItemEntity"}, false, new AnonymousClass11(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$11, reason: invalid class name */
    class AnonymousClass11 implements Callable<List<String>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass11(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(0));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public List<String> selectGenreIdsByPlatformIdAndVisibilityStatically(long j, boolean z) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT PlayableItemToGenrePairEntity.genre_id FROM PlayableItemToGenrePairEntity, PlayableItemEntity WHERE PlayableItemEntity.attached_platform_id == ? AND PlayableItemEntity.is_visible == ? AND PlayableItemToGenrePairEntity.playable_item_id == PlayableItemEntity.id GROUP BY genre_id ORDER BY count(genre_id) DESC", 2);
        roomSQLiteQueryAcquire.bindLong(1, j);
        roomSQLiteQueryAcquire.bindLong(2, z ? 1L : 0L);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
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

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$12, reason: invalid class name */
    class AnonymousClass12 implements Callable<List<String>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass12(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(0));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<List<String>> selectAllGenreIds() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity"}, false, new AnonymousClass12(RoomSQLiteQuery.acquire("SELECT genre_id FROM PlayableItemToGenrePairEntity GROUP BY genre_id ORDER BY count(id) DESC", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public List<String> selectAllGenreIdsStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT genre_id FROM PlayableItemToGenrePairEntity GROUP BY genre_id ORDER BY count(id) DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
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

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$13, reason: invalid class name */
    class AnonymousClass13 implements Callable<List<PlayableItemToGenrePairEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass13(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<PlayableItemToGenrePairEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new PlayableItemToGenrePairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<List<PlayableItemToGenrePairEntity>> selectAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity"}, false, new AnonymousClass13(RoomSQLiteQuery.acquire("SELECT * FROM PlayableItemToGenrePairEntity ORDER BY genre_id ASC", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public List<PlayableItemToGenrePairEntity> selectAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayableItemToGenrePairEntity ORDER BY genre_id ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new PlayableItemToGenrePairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<PlayableItemToGenrePairEntity> selectById(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayableItemToGenrePairEntity WHERE id = ? ORDER BY playable_item_id COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity"}, false, new AnonymousClass14(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$14, reason: invalid class name */
    class AnonymousClass14 implements Callable<PlayableItemToGenrePairEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass14(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public PlayableItemToGenrePairEntity call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                return cursorQuery.moveToFirst() ? new PlayableItemToGenrePairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra"))) : null;
            } finally {
                cursorQuery.close();
            }
        }

        protected void finalize() {
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public PlayableItemToGenrePairEntity selectByIdStatically(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayableItemToGenrePairEntity WHERE id = ?  ORDER BY playable_item_id COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? new PlayableItemToGenrePairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<List<PlayableItemToGenrePairEntity>> selectByGenreId(final String id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayableItemToGenrePairEntity WHERE genre_id = ? ORDER BY playable_item_id COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity"}, false, new AnonymousClass15(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$15, reason: invalid class name */
    class AnonymousClass15 implements Callable<List<PlayableItemToGenrePairEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass15(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<PlayableItemToGenrePairEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new PlayableItemToGenrePairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public List<PlayableItemToGenrePairEntity> selectByGenreIdStatically(final String id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayableItemToGenrePairEntity WHERE genre_id = ?  ORDER BY playable_item_id COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new PlayableItemToGenrePairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<List<Long>> selectPlayableItemIdsByGenreId(final String id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT playable_item_id FROM PlayableItemToGenrePairEntity WHERE genre_id = ? ORDER BY playable_item_id COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity"}, false, new AnonymousClass16(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$16, reason: invalid class name */
    class AnonymousClass16 implements Callable<List<Long>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass16(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<Long> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public List<Long> selectPlayableItemIdsByGenreIdStatically(final String id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT playable_item_id FROM PlayableItemToGenrePairEntity WHERE genre_id = ?  ORDER BY playable_item_id COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<List<PlayableItemToGenrePairEntity>> selectByPlayableItemId(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayableItemToGenrePairEntity WHERE playable_item_id = ? ORDER BY genre_id COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity"}, false, new AnonymousClass17(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$17, reason: invalid class name */
    class AnonymousClass17 implements Callable<List<PlayableItemToGenrePairEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass17(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<PlayableItemToGenrePairEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new PlayableItemToGenrePairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public List<PlayableItemToGenrePairEntity> selectByPlayableItemIdStatically(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayableItemToGenrePairEntity WHERE playable_item_id = ?  ORDER BY genre_id COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new PlayableItemToGenrePairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getLong(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public LiveData<List<String>> selectGenreIdsByPlayableItemId(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT genre_id FROM PlayableItemToGenrePairEntity WHERE playable_item_id = ? ORDER BY genre_id COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayableItemToGenrePairEntity"}, false, new AnonymousClass18(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO_Impl$18, reason: invalid class name */
    class AnonymousClass18 implements Callable<List<String>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass18(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayableItemToGenrePairDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(0));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public List<String> selectGenreIdsByPlayableItemIdStatically(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT genre_id FROM PlayableItemToGenrePairEntity WHERE playable_item_id = ?  ORDER BY genre_id COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO
    public void deleteByIds(final long... ids) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM PlayableItemToGenrePairEntity WHERE id IN (");
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
