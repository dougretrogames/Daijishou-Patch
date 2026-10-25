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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final class PlayerDAO_Impl implements PlayerDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PlayerEntity> __deletionAdapterOfPlayerEntity;
    private final EntityInsertionAdapter<PlayerEntity> __insertionAdapterOfPlayerEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final EntityDeletionOrUpdateAdapter<PlayerEntity> __updateAdapterOfPlayerEntity;

    public PlayerDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPlayerEntity = new AnonymousClass1(__db);
        this.__deletionAdapterOfPlayerEntity = new AnonymousClass2(__db);
        this.__updateAdapterOfPlayerEntity = new AnonymousClass3(__db);
        this.__preparedStmtOfDeleteById = new AnonymousClass4(__db);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<PlayerEntity> {
        AnonymousClass1(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `PlayerEntity` (`id`,`unique_id`,`player`,`name`,`description`,`am_start_arguments`,`kill_package_processes`,`kill_package_processes_warning`,`accepted_filename_regex`,`extra`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PlayerEntity playerEntity) {
            supportSQLiteStatement.bindLong(1, playerEntity.getId());
            if (playerEntity.getUniqueId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, playerEntity.getUniqueId());
            }
            supportSQLiteStatement.bindLong(3, playerEntity.getPlayer());
            supportSQLiteStatement.bindString(4, playerEntity.getName());
            if (playerEntity.getDescription() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, playerEntity.getDescription());
            }
            supportSQLiteStatement.bindString(6, playerEntity.getAmStartArguments());
            supportSQLiteStatement.bindLong(7, playerEntity.getKillPackageProcesses() ? 1L : 0L);
            supportSQLiteStatement.bindLong(8, playerEntity.getKillPackageProcessesWarning() ? 1L : 0L);
            supportSQLiteStatement.bindString(9, playerEntity.getAcceptedFilenameRegex());
            supportSQLiteStatement.bindString(10, playerEntity.getExtra());
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends EntityDeletionOrUpdateAdapter<PlayerEntity> {
        AnonymousClass2(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `PlayerEntity` WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(final SupportSQLiteStatement statement, final PlayerEntity entity) {
            statement.bindLong(1, entity.getId());
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends EntityDeletionOrUpdateAdapter<PlayerEntity> {
        AnonymousClass3(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `PlayerEntity` SET `id` = ?,`unique_id` = ?,`player` = ?,`name` = ?,`description` = ?,`am_start_arguments` = ?,`kill_package_processes` = ?,`kill_package_processes_warning` = ?,`accepted_filename_regex` = ?,`extra` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PlayerEntity playerEntity) {
            supportSQLiteStatement.bindLong(1, playerEntity.getId());
            if (playerEntity.getUniqueId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, playerEntity.getUniqueId());
            }
            supportSQLiteStatement.bindLong(3, playerEntity.getPlayer());
            supportSQLiteStatement.bindString(4, playerEntity.getName());
            if (playerEntity.getDescription() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, playerEntity.getDescription());
            }
            supportSQLiteStatement.bindString(6, playerEntity.getAmStartArguments());
            supportSQLiteStatement.bindLong(7, playerEntity.getKillPackageProcesses() ? 1L : 0L);
            supportSQLiteStatement.bindLong(8, playerEntity.getKillPackageProcessesWarning() ? 1L : 0L);
            supportSQLiteStatement.bindString(9, playerEntity.getAcceptedFilenameRegex());
            supportSQLiteStatement.bindString(10, playerEntity.getExtra());
            supportSQLiteStatement.bindLong(11, playerEntity.getId());
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$4, reason: invalid class name */
    class AnonymousClass4 extends SharedSQLiteStatement {
        AnonymousClass4(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM PlayerEntity WHERE id = ?";
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public long insert(final PlayerEntity playerEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfPlayerEntity.insertAndReturnId(playerEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public List<Long> insertAll(final PlayerEntity... playerEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfPlayerEntity.insertAndReturnIdsList(playerEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public void delete(final PlayerEntity playerEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPlayerEntity.handle(playerEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public void deleteAll(final PlayerEntity... playerEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPlayerEntity.handleMultiple(playerEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public void update(final PlayerEntity playerEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPlayerEntity.handle(playerEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public void updateAll(final PlayerEntity... playerEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPlayerEntity.handleMultiple(playerEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$5, reason: invalid class name */
    class AnonymousClass5 implements Callable<Integer> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass5(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Integer numValueOf = null;
            Cursor cursorQuery = DBUtil.query(PlayerDAO_Impl.this.__db, this.val$_statement, false, null);
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public LiveData<Integer> countAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayerEntity"}, false, new AnonymousClass5(RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM PlayerEntity", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM PlayerEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$6, reason: invalid class name */
    class AnonymousClass6 implements Callable<List<Long>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass6(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<Long> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayerDAO_Impl.this.__db, this.val$_statement, false, null);
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public LiveData<List<Long>> selectAllIds() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayerEntity"}, false, new AnonymousClass6(RoomSQLiteQuery.acquire("SELECT id FROM PlayerEntity ORDER BY name ASC", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public List<Long> selectAllIdsStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM PlayerEntity ORDER BY name ASC", 0);
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$7, reason: invalid class name */
    class AnonymousClass7 implements Callable<List<PlayerEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass7(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<PlayerEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayerDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_start_arguments");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes_warning");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accepted_filename_regex");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new PlayerEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getString(columnIndexOrThrow9), cursorQuery.getString(columnIndexOrThrow10)));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public LiveData<List<PlayerEntity>> selectAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayerEntity"}, false, new AnonymousClass7(RoomSQLiteQuery.acquire("SELECT * FROM PlayerEntity ORDER BY name ASC", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public List<PlayerEntity> selectAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayerEntity ORDER BY name ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_start_arguments");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes_warning");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accepted_filename_regex");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new PlayerEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getString(columnIndexOrThrow9), cursorQuery.getString(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public LiveData<PlayerEntity> selectById(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayerEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayerEntity"}, false, new AnonymousClass8(roomSQLiteQueryAcquire));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$8, reason: invalid class name */
    class AnonymousClass8 implements Callable<PlayerEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass8(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public PlayerEntity call() throws Exception {
            PlayerEntity playerEntity = null;
            Cursor cursorQuery = DBUtil.query(PlayerDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_start_arguments");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes_warning");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accepted_filename_regex");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                if (cursorQuery.moveToFirst()) {
                    playerEntity = new PlayerEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getString(columnIndexOrThrow9), cursorQuery.getString(columnIndexOrThrow10));
                }
                return playerEntity;
            } finally {
                cursorQuery.close();
            }
        }

        protected void finalize() {
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public PlayerEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayerEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        PlayerEntity playerEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_start_arguments");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes_warning");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accepted_filename_regex");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            if (cursorQuery.moveToFirst()) {
                playerEntity = new PlayerEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getString(columnIndexOrThrow9), cursorQuery.getString(columnIndexOrThrow10));
            }
            return playerEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public PlayerEntity selectByName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayerEntity WHERE name = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        this.__db.assertNotSuspendingTransaction();
        PlayerEntity playerEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_start_arguments");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes_warning");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accepted_filename_regex");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            if (cursorQuery.moveToFirst()) {
                playerEntity = new PlayerEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getString(columnIndexOrThrow9), cursorQuery.getString(columnIndexOrThrow10));
            }
            return playerEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public LiveData<PlayerEntity> selectByNameStatically(final String name) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayerEntity WHERE name = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, name);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayerEntity"}, false, new AnonymousClass9(roomSQLiteQueryAcquire));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$9, reason: invalid class name */
    class AnonymousClass9 implements Callable<PlayerEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass9(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public PlayerEntity call() throws Exception {
            PlayerEntity playerEntity = null;
            Cursor cursorQuery = DBUtil.query(PlayerDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_start_arguments");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes_warning");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accepted_filename_regex");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                if (cursorQuery.moveToFirst()) {
                    playerEntity = new PlayerEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getString(columnIndexOrThrow9), cursorQuery.getString(columnIndexOrThrow10));
                }
                return playerEntity;
            } finally {
                cursorQuery.close();
            }
        }

        protected void finalize() {
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public LiveData<List<PlayerEntity>> selectByIdList(final List<Long> id2) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM PlayerEntity WHERE id IN (");
        int size = id2.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        Iterator<Long> it = id2.iterator();
        int i = 1;
        while (it.hasNext()) {
            roomSQLiteQueryAcquire.bindLong(i, it.next().longValue());
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayerEntity"}, false, new AnonymousClass10(roomSQLiteQueryAcquire));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$10, reason: invalid class name */
    class AnonymousClass10 implements Callable<List<PlayerEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass10(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<PlayerEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayerDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_start_arguments");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes_warning");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accepted_filename_regex");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new PlayerEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getString(columnIndexOrThrow9), cursorQuery.getString(columnIndexOrThrow10)));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public List<PlayerEntity> selectByIdListStatically(final List<Long> id2) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM PlayerEntity WHERE id IN (");
        int size = id2.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        Iterator<Long> it = id2.iterator();
        int i = 1;
        while (it.hasNext()) {
            roomSQLiteQueryAcquire.bindLong(i, it.next().longValue());
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_start_arguments");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes_warning");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accepted_filename_regex");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new PlayerEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getString(columnIndexOrThrow9), cursorQuery.getString(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public LiveData<List<PlayerEntity>> findWithName(final String search) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayerEntity WHERE name LIKE '%' || ? || '%' ORDER BY name ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, search);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlayerEntity"}, false, new AnonymousClass11(roomSQLiteQueryAcquire));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.PlayerDAO_Impl$11, reason: invalid class name */
    class AnonymousClass11 implements Callable<List<PlayerEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass11(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<PlayerEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PlayerDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_start_arguments");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes_warning");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accepted_filename_regex");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new PlayerEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getString(columnIndexOrThrow9), cursorQuery.getString(columnIndexOrThrow10)));
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public List<PlayerEntity> findWithNameStatically(final String search) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayerEntity WHERE name LIKE '%' || ? || '%' ORDER BY name ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, search);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "am_start_arguments");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "kill_package_processes_warning");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accepted_filename_regex");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new PlayerEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getString(columnIndexOrThrow9), cursorQuery.getString(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.PlayerDAO
    public void deleteAllByIds(final long... ids) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM PlayerEntity WHERE id IN (");
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
