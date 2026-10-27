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
import com.magneticchen.daijishou.data.db.entity.ExtensionDataEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class ExtensionDataDAO_Impl implements ExtensionDataDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ExtensionDataEntity> __deletionAdapterOfExtensionDataEntity;
    private final EntityInsertionAdapter<ExtensionDataEntity> __insertionAdapterOfExtensionDataEntity;
    private final EntityDeletionOrUpdateAdapter<ExtensionDataEntity> __updateAdapterOfExtensionDataEntity;

    public ExtensionDataDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfExtensionDataEntity = new EntityInsertionAdapter<ExtensionDataEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ExtensionDataEntity` (`id`,`extension_id`,`key_string`,`is_public`,`data_json_string`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ExtensionDataEntity extensionDataEntity) {
                supportSQLiteStatement.bindLong(1, extensionDataEntity.getId());
                supportSQLiteStatement.bindString(2, extensionDataEntity.getExtensionId());
                supportSQLiteStatement.bindString(3, extensionDataEntity.getKeyString());
                supportSQLiteStatement.bindLong(4, extensionDataEntity.isPublic() ? 1L : 0L);
                supportSQLiteStatement.bindString(5, extensionDataEntity.getDataJsonString());
            }
        };
        this.__deletionAdapterOfExtensionDataEntity = new EntityDeletionOrUpdateAdapter<ExtensionDataEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `ExtensionDataEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionDataEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfExtensionDataEntity = new EntityDeletionOrUpdateAdapter<ExtensionDataEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `ExtensionDataEntity` SET `id` = ?,`extension_id` = ?,`key_string` = ?,`is_public` = ?,`data_json_string` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ExtensionDataEntity extensionDataEntity) {
                supportSQLiteStatement.bindLong(1, extensionDataEntity.getId());
                supportSQLiteStatement.bindString(2, extensionDataEntity.getExtensionId());
                supportSQLiteStatement.bindString(3, extensionDataEntity.getKeyString());
                supportSQLiteStatement.bindLong(4, extensionDataEntity.isPublic() ? 1L : 0L);
                supportSQLiteStatement.bindString(5, extensionDataEntity.getDataJsonString());
                supportSQLiteStatement.bindLong(6, extensionDataEntity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public long insert(final ExtensionDataEntity extensionDataEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfExtensionDataEntity.insertAndReturnId(extensionDataEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public List<Long> insertAll(final ExtensionDataEntity... extensionDataEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfExtensionDataEntity.insertAndReturnIdsList(extensionDataEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public void delete(final ExtensionDataEntity extensionDataEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionDataEntity.handle(extensionDataEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public void deleteAll(final ExtensionDataEntity... extensionDataEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionDataEntity.handleMultiple(extensionDataEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public void update(final ExtensionDataEntity extensionDataEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionDataEntity.handle(extensionDataEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public void updateAll(final ExtensionDataEntity... extensionDataEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionDataEntity.handleMultiple(extensionDataEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public LiveData<ExtensionDataEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDataEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDataEntity"}, false, new Callable<ExtensionDataEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionDataEntity call() throws Exception {
                ExtensionDataEntity extensionDataEntity = null;
                Cursor cursorQuery = DBUtil.query(ExtensionDataDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key_string");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_public");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_json_string");
                    if (cursorQuery.moveToFirst()) {
                        extensionDataEntity = new ExtensionDataEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0, cursorQuery.getString(columnIndexOrThrow5));
                    }
                    return extensionDataEntity;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public ExtensionDataEntity selectByIdStatically(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDataEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        ExtensionDataEntity extensionDataEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key_string");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_public");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_json_string");
            if (cursorQuery.moveToFirst()) {
                extensionDataEntity = new ExtensionDataEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0, cursorQuery.getString(columnIndexOrThrow5));
            }
            return extensionDataEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public LiveData<List<ExtensionDataEntity>> selectByExtensionId(final long extensionId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDataEntity WHERE extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, extensionId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDataEntity"}, false, new Callable<List<ExtensionDataEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO_Impl.5
            @Override // java.util.concurrent.Callable
            public List<ExtensionDataEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDataDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key_string");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_public");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_json_string");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionDataEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0, cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public List<ExtensionDataEntity> selectByExtensionIdStatically(final long extensionId) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDataEntity WHERE extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, extensionId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key_string");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_public");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_json_string");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionDataEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0, cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public LiveData<ExtensionDataEntity> selectByExtensionIdAndKey(final long extensionId, final String keyString) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDataEntity WHERE extension_id = ? AND key_string = ?", 2);
        roomSQLiteQueryAcquire.bindLong(1, extensionId);
        roomSQLiteQueryAcquire.bindString(2, keyString);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDataEntity"}, false, new Callable<ExtensionDataEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO_Impl.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionDataEntity call() throws Exception {
                ExtensionDataEntity extensionDataEntity = null;
                Cursor cursorQuery = DBUtil.query(ExtensionDataDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key_string");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_public");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_json_string");
                    if (cursorQuery.moveToFirst()) {
                        extensionDataEntity = new ExtensionDataEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0, cursorQuery.getString(columnIndexOrThrow5));
                    }
                    return extensionDataEntity;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO
    public ExtensionDataEntity selectByExtensionIdAndKeyStatically(final long extensionId, final String keyString) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDataEntity WHERE extension_id = ? AND key_string = ?", 2);
        roomSQLiteQueryAcquire.bindLong(1, extensionId);
        roomSQLiteQueryAcquire.bindString(2, keyString);
        this.__db.assertNotSuspendingTransaction();
        ExtensionDataEntity extensionDataEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key_string");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_public");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data_json_string");
            if (cursorQuery.moveToFirst()) {
                extensionDataEntity = new ExtensionDataEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0, cursorQuery.getString(columnIndexOrThrow5));
            }
            return extensionDataEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
