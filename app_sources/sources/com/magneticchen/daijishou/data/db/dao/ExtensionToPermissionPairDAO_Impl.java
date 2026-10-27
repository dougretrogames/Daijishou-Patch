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
import androidx.sqlite.db.SupportSQLiteStatement;
import com.magneticchen.daijishou.data.db.entity.ExtensionToPermissionPairEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class ExtensionToPermissionPairDAO_Impl implements ExtensionToPermissionPairDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ExtensionToPermissionPairEntity> __deletionAdapterOfExtensionToPermissionPairEntity;
    private final EntityInsertionAdapter<ExtensionToPermissionPairEntity> __insertionAdapterOfExtensionToPermissionPairEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByExtensionId;
    private final EntityDeletionOrUpdateAdapter<ExtensionToPermissionPairEntity> __updateAdapterOfExtensionToPermissionPairEntity;

    public ExtensionToPermissionPairDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfExtensionToPermissionPairEntity = new EntityInsertionAdapter<ExtensionToPermissionPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ExtensionToPermissionPairEntity` (`id`,`extension_id`,`permission`,`extra`) VALUES (nullif(?, 0),?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionToPermissionPairEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getExtensionId());
                statement.bindString(3, entity.getPermission());
                statement.bindString(4, entity.getExtra());
            }
        };
        this.__deletionAdapterOfExtensionToPermissionPairEntity = new EntityDeletionOrUpdateAdapter<ExtensionToPermissionPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `ExtensionToPermissionPairEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionToPermissionPairEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfExtensionToPermissionPairEntity = new EntityDeletionOrUpdateAdapter<ExtensionToPermissionPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `ExtensionToPermissionPairEntity` SET `id` = ?,`extension_id` = ?,`permission` = ?,`extra` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionToPermissionPairEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getExtensionId());
                statement.bindString(3, entity.getPermission());
                statement.bindString(4, entity.getExtra());
                statement.bindLong(5, entity.getId());
            }
        };
        this.__preparedStmtOfDeleteByExtensionId = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO_Impl.4
            public String createQuery() {
                return "DELETE FROM ExtensionToPermissionPairEntity WHERE extension_id = ?";
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public long insert(final ExtensionToPermissionPairEntity extensionToPermissionPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfExtensionToPermissionPairEntity.insertAndReturnId(extensionToPermissionPairEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public List<Long> insertAll(final ExtensionToPermissionPairEntity... extensionToPermissionPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfExtensionToPermissionPairEntity.insertAndReturnIdsList(extensionToPermissionPairEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public void delete(final ExtensionToPermissionPairEntity extensionToPermissionPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionToPermissionPairEntity.handle(extensionToPermissionPairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public void deleteAll(final ExtensionToPermissionPairEntity... extensionToPermissionPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionToPermissionPairEntity.handleMultiple(extensionToPermissionPairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public void update(final ExtensionToPermissionPairEntity extensionToPermissionPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionToPermissionPairEntity.handle(extensionToPermissionPairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public void updateAll(final ExtensionToPermissionPairEntity... extensionToPermissionPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionToPermissionPairEntity.handleMultiple(extensionToPermissionPairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public void deleteByExtensionId(final String extensionId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByExtensionId.acquire();
        supportSQLiteStatementAcquire.bindString(1, extensionId);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteByExtensionId.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteByExtensionId.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public LiveData<ExtensionToPermissionPairEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionToPermissionPairEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionToPermissionPairEntity"}, false, new Callable<ExtensionToPermissionPairEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionToPermissionPairEntity call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionToPermissionPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    return cursorQuery.moveToFirst() ? new ExtensionToPermissionPairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "permission")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra"))) : null;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public ExtensionToPermissionPairEntity selectByIdStatically(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionToPermissionPairEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? new ExtensionToPermissionPairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "permission")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public LiveData<List<ExtensionToPermissionPairEntity>> selectByExtensionId(final String id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionToPermissionPairEntity WHERE extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionToPermissionPairEntity"}, false, new Callable<List<ExtensionToPermissionPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<ExtensionToPermissionPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionToPermissionPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "permission");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionToPermissionPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
                    }
                    cursorQuery.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public List<ExtensionToPermissionPairEntity> selectByExtensionIdStatically(final String id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionToPermissionPairEntity WHERE extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "permission");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionToPermissionPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public LiveData<List<ExtensionToPermissionPairEntity>> selectByPermission(final String permission) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionToPermissionPairEntity WHERE permission = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, permission);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionToPermissionPairEntity"}, false, new Callable<List<ExtensionToPermissionPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO_Impl.7
            @Override // java.util.concurrent.Callable
            public List<ExtensionToPermissionPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionToPermissionPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "permission");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionToPermissionPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
                    }
                    cursorQuery.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO
    public List<ExtensionToPermissionPairEntity> selectByPermissionStatically(final String permission) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionToPermissionPairEntity WHERE permission = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, permission);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "permission");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionToPermissionPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
