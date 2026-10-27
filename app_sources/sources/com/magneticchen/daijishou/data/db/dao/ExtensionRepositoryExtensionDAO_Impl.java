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
import com.magneticchen.daijishou.data.RoomDatabaseConverters;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class ExtensionRepositoryExtensionDAO_Impl implements ExtensionRepositoryExtensionDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionEntity> __deletionAdapterOfExtensionRepositoryExtensionEntity;
    private final EntityInsertionAdapter<ExtensionRepositoryExtensionEntity> __insertionAdapterOfExtensionRepositoryExtensionEntity;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionEntity> __updateAdapterOfExtensionRepositoryExtensionEntity;

    public ExtensionRepositoryExtensionDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfExtensionRepositoryExtensionEntity = new EntityInsertionAdapter<ExtensionRepositoryExtensionEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ExtensionRepositoryExtensionEntity` (`id`,`repository_id`,`extension_id`,`name`,`description`,`version_code`,`version_name`,`github_url_string`,`github_stars`,`dependencies`,`api_level`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getRepositoryId());
                statement.bindString(3, entity.getExtensionId());
                if (entity.getName() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getName());
                }
                statement.bindString(5, entity.getDescription());
                statement.bindLong(6, entity.getVersionCode());
                if (entity.getVersionName() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getVersionName());
                }
                statement.bindString(8, entity.getGithubUrlString());
                statement.bindLong(9, entity.getGithubStars());
                statement.bindString(10, ExtensionRepositoryExtensionDAO_Impl.this.__roomDatabaseConverters.fromMutableStringList(entity.getDependencies()));
                if (entity.getApiLevel() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindLong(11, entity.getApiLevel().intValue());
                }
            }
        };
        this.__deletionAdapterOfExtensionRepositoryExtensionEntity = new EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `ExtensionRepositoryExtensionEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfExtensionRepositoryExtensionEntity = new EntityDeletionOrUpdateAdapter<ExtensionRepositoryExtensionEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `ExtensionRepositoryExtensionEntity` SET `id` = ?,`repository_id` = ?,`extension_id` = ?,`name` = ?,`description` = ?,`version_code` = ?,`version_name` = ?,`github_url_string` = ?,`github_stars` = ?,`dependencies` = ?,`api_level` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionRepositoryExtensionEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getRepositoryId());
                statement.bindString(3, entity.getExtensionId());
                if (entity.getName() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getName());
                }
                statement.bindString(5, entity.getDescription());
                statement.bindLong(6, entity.getVersionCode());
                if (entity.getVersionName() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getVersionName());
                }
                statement.bindString(8, entity.getGithubUrlString());
                statement.bindLong(9, entity.getGithubStars());
                statement.bindString(10, ExtensionRepositoryExtensionDAO_Impl.this.__roomDatabaseConverters.fromMutableStringList(entity.getDependencies()));
                if (entity.getApiLevel() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindLong(11, entity.getApiLevel().intValue());
                }
                statement.bindLong(12, entity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public long insert(final ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfExtensionRepositoryExtensionEntity.insertAndReturnId(extensionRepositoryExtensionEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public List<Long> insertAll(final ExtensionRepositoryExtensionEntity... extensionRepositoryExtensionEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfExtensionRepositoryExtensionEntity.insertAndReturnIdsList(extensionRepositoryExtensionEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public void delete(final ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionRepositoryExtensionEntity.handle(extensionRepositoryExtensionEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public void deleteAll(final ExtensionRepositoryExtensionEntity... extensionRepositoryExtensionEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionRepositoryExtensionEntity.handleMultiple(extensionRepositoryExtensionEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public void update(final ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionRepositoryExtensionEntity.handle(extensionRepositoryExtensionEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public void updateAll(final ExtensionRepositoryExtensionEntity... extensionRepositoryExtensionEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionRepositoryExtensionEntity.handleMultiple(extensionRepositoryExtensionEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public LiveData<ExtensionRepositoryExtensionEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionEntity"}, false, new Callable<ExtensionRepositoryExtensionEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionRepositoryExtensionEntity call() throws Exception {
                ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity = null;
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_code");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_url_string");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_stars");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dependencies");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
                    if (cursorQuery.moveToFirst()) {
                        extensionRepositoryExtensionEntity = new ExtensionRepositoryExtensionEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), ExtensionRepositoryExtensionDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
                    }
                    return extensionRepositoryExtensionEntity;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public ExtensionRepositoryExtensionEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_code");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_url_string");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_stars");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dependencies");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
            if (cursorQuery.moveToFirst()) {
                extensionRepositoryExtensionEntity = new ExtensionRepositoryExtensionEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
            }
            return extensionRepositoryExtensionEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public LiveData<List<ExtensionRepositoryExtensionEntity>> selectByExtensionId(final String extensionId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionEntity WHERE extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, extensionId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionEntity"}, false, new Callable<List<ExtensionRepositoryExtensionEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO_Impl.5
            @Override // java.util.concurrent.Callable
            public List<ExtensionRepositoryExtensionEntity> call() throws Exception {
                String str = null;
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_code");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_url_string");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_stars");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dependencies");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionRepositoryExtensionEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? str : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? str : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), ExtensionRepositoryExtensionDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11))));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public List<ExtensionRepositoryExtensionEntity> selectByExtensionIdStatically(final String extensionId) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionEntity WHERE extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, extensionId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_code");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_url_string");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_stars");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dependencies");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                int i = columnIndexOrThrow;
                arrayList.add(new ExtensionRepositoryExtensionEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11))));
                columnIndexOrThrow = i;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public LiveData<List<ExtensionRepositoryExtensionEntity>> selectByRepositoryId(final String repositoryId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionEntity WHERE repository_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, repositoryId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionEntity"}, false, new Callable<List<ExtensionRepositoryExtensionEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<ExtensionRepositoryExtensionEntity> call() throws Exception {
                String str = null;
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_code");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_url_string");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_stars");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dependencies");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionRepositoryExtensionEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? str : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? str : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), ExtensionRepositoryExtensionDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11))));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public List<ExtensionRepositoryExtensionEntity> selectByRepositoryIdStatically(final String repositoryId) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionEntity WHERE repository_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, repositoryId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_code");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_url_string");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_stars");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dependencies");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                int i = columnIndexOrThrow;
                arrayList.add(new ExtensionRepositoryExtensionEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11))));
                columnIndexOrThrow = i;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public LiveData<ExtensionRepositoryExtensionEntity> selectByRepositoryIdAndExtensionId(final String repositoryId, final String extensionId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionEntity WHERE repository_id = ? AND extension_id = ?", 2);
        roomSQLiteQueryAcquire.bindString(1, repositoryId);
        roomSQLiteQueryAcquire.bindString(2, extensionId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionRepositoryExtensionEntity"}, false, new Callable<ExtensionRepositoryExtensionEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO_Impl.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionRepositoryExtensionEntity call() throws Exception {
                ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity = null;
                Cursor cursorQuery = DBUtil.query(ExtensionRepositoryExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_code");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_name");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_url_string");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_stars");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dependencies");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
                    if (cursorQuery.moveToFirst()) {
                        extensionRepositoryExtensionEntity = new ExtensionRepositoryExtensionEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), ExtensionRepositoryExtensionDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
                    }
                    return extensionRepositoryExtensionEntity;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO
    public ExtensionRepositoryExtensionEntity selectByRepositoryIdAndExtensionIdStatically(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionRepositoryExtensionEntity WHERE repository_id = ? AND extension_id = ?", 2);
        roomSQLiteQueryAcquire.bindString(1, str);
        roomSQLiteQueryAcquire.bindString(2, str2);
        this.__db.assertNotSuspendingTransaction();
        ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_code");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_name");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_url_string");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "github_stars");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dependencies");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
            if (cursorQuery.moveToFirst()) {
                extensionRepositoryExtensionEntity = new ExtensionRepositoryExtensionEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getString(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
            }
            return extensionRepositoryExtensionEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
