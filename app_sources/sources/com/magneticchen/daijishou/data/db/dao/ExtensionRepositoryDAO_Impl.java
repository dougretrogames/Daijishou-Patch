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
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class ExtensionRepositoryDAO_Impl implements ExtensionRepositoryDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ExtensionRepositoryEntity> __deletionAdapterOfExtensionRepositoryEntity;
    private final EntityInsertionAdapter<ExtensionRepositoryEntity> __insertionAdapterOfExtensionRepositoryEntity;
    private final EntityDeletionOrUpdateAdapter<ExtensionRepositoryEntity> __updateAdapterOfExtensionRepositoryEntity;

    public ExtensionRepositoryDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfExtensionRepositoryEntity = new EntityInsertionAdapter<ExtensionRepositoryEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ExtensionRepositoryEntity` (`id`,`name`,`description`,`base_url`,`revisions`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryEntity entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getName() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getName());
                }
                if (entity.getDescription() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getDescription());
                }
                statement.bindString(4, entity.getBaseUrl());
                statement.bindLong(5, entity.getRevisions());
            }
        };
        this.__deletionAdapterOfExtensionRepositoryEntity = new EntityDeletionOrUpdateAdapter<ExtensionRepositoryEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `ExtensionRepositoryEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfExtensionRepositoryEntity = new EntityDeletionOrUpdateAdapter<ExtensionRepositoryEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `ExtensionRepositoryEntity` SET `id` = ?,`name` = ?,`description` = ?,`base_url` = ?,`revisions` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryEntity entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getName() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getName());
                }
                if (entity.getDescription() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getDescription());
                }
                statement.bindString(4, entity.getBaseUrl());
                statement.bindLong(5, entity.getRevisions());
                statement.bindLong(6, entity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO
    public long insert(final ExtensionRepositoryEntity extensionRepositoryEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfExtensionRepositoryEntity.insertAndReturnId(extensionRepositoryEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO
    public List<Long> insertAll(final ExtensionRepositoryEntity... extensionRepositoryEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfExtensionRepositoryEntity.insertAndReturnIdsList(extensionRepositoryEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO
    public void delete(final ExtensionRepositoryEntity extensionRepositoryEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionRepositoryEntity.handle(extensionRepositoryEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO
    public void deleteAll(final ExtensionRepositoryEntity... extensionRepositoryEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionRepositoryEntity.handleMultiple(extensionRepositoryEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO
    public void update(final ExtensionRepositoryEntity extensionRepositoryEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionRepositoryEntity.handle(extensionRepositoryEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO
    public void updateAll(final ExtensionRepositoryEntity... extensionRepositoryEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionRepositoryEntity.handleMultiple(extensionRepositoryEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO
    public LiveData<ExtensionRepositoryEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryEntity"}, false, new Callable<ExtensionRepositoryEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionRepositoryEntity call() throws Exception {
                ExtensionRepositoryEntity extensionRepositoryEntity = null;
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "base_url");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "revisions");
                    if (cursorQuery.moveToFirst()) {
                        extensionRepositoryEntity = new ExtensionRepositoryEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5));
                    }
                    return extensionRepositoryEntity;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO
    public ExtensionRepositoryEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        ExtensionRepositoryEntity extensionRepositoryEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "base_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "revisions");
            if (cursorQuery.moveToFirst()) {
                extensionRepositoryEntity = new ExtensionRepositoryEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5));
            }
            return extensionRepositoryEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO
    public LiveData<List<ExtensionRepositoryEntity>> selectAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryEntity"}, false, new Callable<List<ExtensionRepositoryEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO_Impl.5
            @Override // java.util.concurrent.Callable
            public List<ExtensionRepositoryEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "base_url");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "revisions");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionRepositoryEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO
    public List<ExtensionRepositoryEntity> selectAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "base_url");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "revisions");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionRepositoryEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5)));
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
