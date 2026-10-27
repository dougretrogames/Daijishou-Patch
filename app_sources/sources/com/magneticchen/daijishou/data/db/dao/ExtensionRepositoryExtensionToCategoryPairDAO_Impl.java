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
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToCategoryPairEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class ExtensionRepositoryExtensionToCategoryPairDAO_Impl implements ExtensionRepositoryExtensionToCategoryPairDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToCategoryPairEntity> __deletionAdapterOfExtensionRepositoryExtensionToCategoryPairEntity;
    private final EntityInsertionAdapter<ExtensionRepositoryExtensionToCategoryPairEntity> __insertionAdapterOfExtensionRepositoryExtensionToCategoryPairEntity;
    private final EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToCategoryPairEntity> __updateAdapterOfExtensionRepositoryExtensionToCategoryPairEntity;

    public ExtensionRepositoryExtensionToCategoryPairDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfExtensionRepositoryExtensionToCategoryPairEntity = new EntityInsertionAdapter<ExtensionRepositoryExtensionToCategoryPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ExtensionRepositoryExtensionToCategoryPairEntity` (`id`,`repository_id`,`extension_id`,`category`) VALUES (nullif(?, 0),?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionToCategoryPairEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getRepositoryId());
                statement.bindString(3, entity.getExtensionId());
                statement.bindString(4, entity.getCategory());
            }
        };
        this.__deletionAdapterOfExtensionRepositoryExtensionToCategoryPairEntity = new EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToCategoryPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `ExtensionRepositoryExtensionToCategoryPairEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionToCategoryPairEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfExtensionRepositoryExtensionToCategoryPairEntity = new EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToCategoryPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `ExtensionRepositoryExtensionToCategoryPairEntity` SET `id` = ?,`repository_id` = ?,`extension_id` = ?,`category` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionToCategoryPairEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getRepositoryId());
                statement.bindString(3, entity.getExtensionId());
                statement.bindString(4, entity.getCategory());
                statement.bindLong(5, entity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public long insert(final ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfExtensionRepositoryExtensionToCategoryPairEntity.insertAndReturnId(extensionRepositoryExtensionToCategoryPairEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public List<Long> insertAll(final ExtensionRepositoryExtensionToCategoryPairEntity... extensionRepositoryExtensionToCategoryPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfExtensionRepositoryExtensionToCategoryPairEntity.insertAndReturnIdsList(extensionRepositoryExtensionToCategoryPairEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public void delete(final ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionRepositoryExtensionToCategoryPairEntity.handle(extensionRepositoryExtensionToCategoryPairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public void deleteAll(final ExtensionRepositoryExtensionToCategoryPairEntity... extensionRepositoryExtensionToCategoryPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionRepositoryExtensionToCategoryPairEntity.handleMultiple(extensionRepositoryExtensionToCategoryPairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public void update(final ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionRepositoryExtensionToCategoryPairEntity.handle(extensionRepositoryExtensionToCategoryPairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public void updateAll(final ExtensionRepositoryExtensionToCategoryPairEntity... extensionRepositoryExtensionToCategoryPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionRepositoryExtensionToCategoryPairEntity.handleMultiple(extensionRepositoryExtensionToCategoryPairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public LiveData<ExtensionRepositoryExtensionToCategoryPairEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToCategoryPairEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionToCategoryPairEntity"}, false, new Callable<ExtensionRepositoryExtensionToCategoryPairEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionRepositoryExtensionToCategoryPairEntity call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionToCategoryPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    return cursorQuery.moveToFirst() ? new ExtensionRepositoryExtensionToCategoryPairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "category"))) : null;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public ExtensionRepositoryExtensionToCategoryPairEntity selectByIdStatically(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToCategoryPairEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? new ExtensionRepositoryExtensionToCategoryPairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "category"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public LiveData<List<ExtensionRepositoryExtensionToCategoryPairEntity>> selectByRepositoryIdAndExtensionId(final String repositoryId, final String extensionId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToCategoryPairEntity WHERE repository_id = ? AND extension_id = ?", 2);
        roomSQLiteQueryAcquire.bindString(1, repositoryId);
        roomSQLiteQueryAcquire.bindString(2, extensionId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionToCategoryPairEntity"}, false, new Callable<List<ExtensionRepositoryExtensionToCategoryPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO_Impl.5
            @Override // java.util.concurrent.Callable
            public List<ExtensionRepositoryExtensionToCategoryPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionToCategoryPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionRepositoryExtensionToCategoryPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public List<ExtensionRepositoryExtensionToCategoryPairEntity> selectByRepositoryIdAndExtensionIdStatically(final String repositoryId, final String extensionId) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToCategoryPairEntity WHERE repository_id = ? AND extension_id = ?", 2);
        roomSQLiteQueryAcquire.bindString(1, repositoryId);
        roomSQLiteQueryAcquire.bindString(2, extensionId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionRepositoryExtensionToCategoryPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public LiveData<List<ExtensionRepositoryExtensionToCategoryPairEntity>> selectByCategory(final String category) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToCategoryPairEntity WHERE category = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, category);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionToCategoryPairEntity"}, false, new Callable<List<ExtensionRepositoryExtensionToCategoryPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<ExtensionRepositoryExtensionToCategoryPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionToCategoryPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionRepositoryExtensionToCategoryPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO
    public List<ExtensionRepositoryExtensionToCategoryPairEntity> selectByCategoryStatically(final String category) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToCategoryPairEntity WHERE category = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, category);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionRepositoryExtensionToCategoryPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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
