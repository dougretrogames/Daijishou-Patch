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
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToKeywordPairEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class ExtensionRepositoryExtensionToKeywordPairDAO_Impl implements ExtensionRepositoryExtensionToKeywordPairDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToKeywordPairEntity> __deletionAdapterOfExtensionRepositoryExtensionToKeywordPairEntity;
    private final EntityInsertionAdapter<ExtensionRepositoryExtensionToKeywordPairEntity> __insertionAdapterOfExtensionRepositoryExtensionToKeywordPairEntity;
    private final EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToKeywordPairEntity> __updateAdapterOfExtensionRepositoryExtensionToKeywordPairEntity;

    public ExtensionRepositoryExtensionToKeywordPairDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfExtensionRepositoryExtensionToKeywordPairEntity = new EntityInsertionAdapter<ExtensionRepositoryExtensionToKeywordPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ExtensionRepositoryExtensionToKeywordPairEntity` (`id`,`repository_id`,`extension_id`,`keyword`) VALUES (nullif(?, 0),?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionToKeywordPairEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getRepositoryId());
                statement.bindString(3, entity.getExtensionId());
                statement.bindString(4, entity.getKeyword());
            }
        };
        this.__deletionAdapterOfExtensionRepositoryExtensionToKeywordPairEntity = new EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToKeywordPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `ExtensionRepositoryExtensionToKeywordPairEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionToKeywordPairEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfExtensionRepositoryExtensionToKeywordPairEntity = new EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToKeywordPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `ExtensionRepositoryExtensionToKeywordPairEntity` SET `id` = ?,`repository_id` = ?,`extension_id` = ?,`keyword` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionToKeywordPairEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getRepositoryId());
                statement.bindString(3, entity.getExtensionId());
                statement.bindString(4, entity.getKeyword());
                statement.bindLong(5, entity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public long insert(final ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfExtensionRepositoryExtensionToKeywordPairEntity.insertAndReturnId(extensionRepositoryExtensionToKeywordPairEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public List<Long> insertAll(final ExtensionRepositoryExtensionToKeywordPairEntity... extensionRepositoryExtensionToKeywordPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfExtensionRepositoryExtensionToKeywordPairEntity.insertAndReturnIdsList(extensionRepositoryExtensionToKeywordPairEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public void delete(final ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionRepositoryExtensionToKeywordPairEntity.handle(extensionRepositoryExtensionToKeywordPairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public void deleteAll(final ExtensionRepositoryExtensionToKeywordPairEntity... extensionRepositoryExtensionToKeywordPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionRepositoryExtensionToKeywordPairEntity.handleMultiple(extensionRepositoryExtensionToKeywordPairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public void update(final ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionRepositoryExtensionToKeywordPairEntity.handle(extensionRepositoryExtensionToKeywordPairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public void updateAll(final ExtensionRepositoryExtensionToKeywordPairEntity... extensionRepositoryExtensionToKeywordPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionRepositoryExtensionToKeywordPairEntity.handleMultiple(extensionRepositoryExtensionToKeywordPairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public LiveData<ExtensionRepositoryExtensionToKeywordPairEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToKeywordPairEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionToKeywordPairEntity"}, false, new Callable<ExtensionRepositoryExtensionToKeywordPairEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionRepositoryExtensionToKeywordPairEntity call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionToKeywordPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    return cursorQuery.moveToFirst() ? new ExtensionRepositoryExtensionToKeywordPairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "keyword"))) : null;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public ExtensionRepositoryExtensionToKeywordPairEntity selectByIdStatically(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToKeywordPairEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? new ExtensionRepositoryExtensionToKeywordPairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "keyword"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public LiveData<List<ExtensionRepositoryExtensionToKeywordPairEntity>> selectByRepositoryIdAndExtensionId(final String repositoryId, final String extensionId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToKeywordPairEntity WHERE repository_id = ? AND extension_id = ?", 2);
        roomSQLiteQueryAcquire.bindString(1, repositoryId);
        roomSQLiteQueryAcquire.bindString(2, extensionId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionToKeywordPairEntity"}, false, new Callable<List<ExtensionRepositoryExtensionToKeywordPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO_Impl.5
            @Override // java.util.concurrent.Callable
            public List<ExtensionRepositoryExtensionToKeywordPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionToKeywordPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "keyword");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionRepositoryExtensionToKeywordPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public List<ExtensionRepositoryExtensionToKeywordPairEntity> selectByRepositoryIdAndExtensionIdStatically(final String repositoryId, final String extensionId) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToKeywordPairEntity WHERE repository_id = ? AND extension_id = ?", 2);
        roomSQLiteQueryAcquire.bindString(1, repositoryId);
        roomSQLiteQueryAcquire.bindString(2, extensionId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "keyword");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionRepositoryExtensionToKeywordPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public LiveData<List<ExtensionRepositoryExtensionToKeywordPairEntity>> selectByKeyword(final String keyword) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToKeywordPairEntity WHERE keyword = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, keyword);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionToKeywordPairEntity"}, false, new Callable<List<ExtensionRepositoryExtensionToKeywordPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<ExtensionRepositoryExtensionToKeywordPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionToKeywordPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "keyword");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionRepositoryExtensionToKeywordPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public List<ExtensionRepositoryExtensionToKeywordPairEntity> selectByKeywordStatically(final String keyword) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToKeywordPairEntity WHERE keyword = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, keyword);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "keyword");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionRepositoryExtensionToKeywordPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public LiveData<List<ExtensionRepositoryExtensionToKeywordPairEntity>> findWithKeyword(final String search) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToKeywordPairEntity WHERE keyword LIKE '%' || ? || '%'", 1);
        roomSQLiteQueryAcquire.bindString(1, search);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionToKeywordPairEntity"}, false, new Callable<List<ExtensionRepositoryExtensionToKeywordPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO_Impl.7
            @Override // java.util.concurrent.Callable
            public List<ExtensionRepositoryExtensionToKeywordPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionToKeywordPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "keyword");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionRepositoryExtensionToKeywordPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO
    public List<ExtensionRepositoryExtensionToKeywordPairEntity> findWithKeywordStatically(final String search) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToKeywordPairEntity WHERE keyword LIKE '%' || ? || '%'", 1);
        roomSQLiteQueryAcquire.bindString(1, search);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "keyword");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionRepositoryExtensionToKeywordPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4)));
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
