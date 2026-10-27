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
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToAuthorPairEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class ExtensionRepositoryExtensionToAuthorPairDAO_Impl implements ExtensionRepositoryExtensionToAuthorPairDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToAuthorPairEntity> __deletionAdapterOfExtensionRepositoryExtensionToAuthorPairEntity;
    private final EntityInsertionAdapter<ExtensionRepositoryExtensionToAuthorPairEntity> __insertionAdapterOfExtensionRepositoryExtensionToAuthorPairEntity;
    private final EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToAuthorPairEntity> __updateAdapterOfExtensionRepositoryExtensionToAuthorPairEntity;

    public ExtensionRepositoryExtensionToAuthorPairDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfExtensionRepositoryExtensionToAuthorPairEntity = new EntityInsertionAdapter<ExtensionRepositoryExtensionToAuthorPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ExtensionRepositoryExtensionToAuthorPairEntity` (`id`,`repository_id`,`extension_id`,`email`,`name`,`url`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionToAuthorPairEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getRepositoryId());
                statement.bindString(3, entity.getExtensionId());
                statement.bindString(4, entity.getEmail());
                if (entity.getName() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getName());
                }
                if (entity.getUrl() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getUrl());
                }
            }
        };
        this.__deletionAdapterOfExtensionRepositoryExtensionToAuthorPairEntity = new EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToAuthorPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `ExtensionRepositoryExtensionToAuthorPairEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionToAuthorPairEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfExtensionRepositoryExtensionToAuthorPairEntity = new EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionToAuthorPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `ExtensionRepositoryExtensionToAuthorPairEntity` SET `id` = ?,`repository_id` = ?,`extension_id` = ?,`email` = ?,`name` = ?,`url` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionToAuthorPairEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getRepositoryId());
                statement.bindString(3, entity.getExtensionId());
                statement.bindString(4, entity.getEmail());
                if (entity.getName() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getName());
                }
                if (entity.getUrl() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getUrl());
                }
                statement.bindLong(7, entity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public long insert(final ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfExtensionRepositoryExtensionToAuthorPairEntity.insertAndReturnId(extensionRepositoryExtensionToAuthorPairEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public List<Long> insertAll(final ExtensionRepositoryExtensionToAuthorPairEntity... extensionRepositoryExtensionToAuthorPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfExtensionRepositoryExtensionToAuthorPairEntity.insertAndReturnIdsList(extensionRepositoryExtensionToAuthorPairEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public void delete(final ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionRepositoryExtensionToAuthorPairEntity.handle(extensionRepositoryExtensionToAuthorPairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public void deleteAll(final ExtensionRepositoryExtensionToAuthorPairEntity... extensionRepositoryExtensionToAuthorPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionRepositoryExtensionToAuthorPairEntity.handleMultiple(extensionRepositoryExtensionToAuthorPairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public void update(final ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionRepositoryExtensionToAuthorPairEntity.handle(extensionRepositoryExtensionToAuthorPairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public void updateAll(final ExtensionRepositoryExtensionToAuthorPairEntity... extensionRepositoryExtensionToAuthorPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionRepositoryExtensionToAuthorPairEntity.handleMultiple(extensionRepositoryExtensionToAuthorPairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public LiveData<ExtensionRepositoryExtensionToAuthorPairEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToAuthorPairEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionToAuthorPairEntity"}, false, new Callable<ExtensionRepositoryExtensionToAuthorPairEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionRepositoryExtensionToAuthorPairEntity call() throws Exception {
                ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity = null;
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionToAuthorPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "email");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    if (cursorQuery.moveToFirst()) {
                        extensionRepositoryExtensionToAuthorPairEntity = new ExtensionRepositoryExtensionToAuthorPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    }
                    return extensionRepositoryExtensionToAuthorPairEntity;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public ExtensionRepositoryExtensionToAuthorPairEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToAuthorPairEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "email");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            if (cursorQuery.moveToFirst()) {
                extensionRepositoryExtensionToAuthorPairEntity = new ExtensionRepositoryExtensionToAuthorPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
            }
            return extensionRepositoryExtensionToAuthorPairEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public LiveData<List<ExtensionRepositoryExtensionToAuthorPairEntity>> selectByRepositoryIdAndExtensionId(final String repositoryId, final String extensionId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToAuthorPairEntity WHERE repository_id = ? AND extension_id = ?", 2);
        roomSQLiteQueryAcquire.bindString(1, repositoryId);
        roomSQLiteQueryAcquire.bindString(2, extensionId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionToAuthorPairEntity"}, false, new Callable<List<ExtensionRepositoryExtensionToAuthorPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO_Impl.5
            @Override // java.util.concurrent.Callable
            public List<ExtensionRepositoryExtensionToAuthorPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionToAuthorPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "email");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionRepositoryExtensionToAuthorPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public List<ExtensionRepositoryExtensionToAuthorPairEntity> selectByRepositoryIdAndExtensionIdStatically(final String repositoryId, final String extensionId) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToAuthorPairEntity WHERE repository_id = ? AND extension_id = ?", 2);
        roomSQLiteQueryAcquire.bindString(1, repositoryId);
        roomSQLiteQueryAcquire.bindString(2, extensionId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "email");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionRepositoryExtensionToAuthorPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public LiveData<List<ExtensionRepositoryExtensionToAuthorPairEntity>> selectByEmail(final String email) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToAuthorPairEntity WHERE email = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, email);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionToAuthorPairEntity"}, false, new Callable<List<ExtensionRepositoryExtensionToAuthorPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<ExtensionRepositoryExtensionToAuthorPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionToAuthorPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "email");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionRepositoryExtensionToAuthorPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO
    public List<ExtensionRepositoryExtensionToAuthorPairEntity> selectByEmailStatically(final String email) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionToAuthorPairEntity WHERE email = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, email);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "email");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionRepositoryExtensionToAuthorPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)));
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
