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
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.magneticchen.daijishou.data.db.entity.ExtensionDependencyPairEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class ExtensionDependencyPairDAO_Impl implements ExtensionDependencyPairDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ExtensionDependencyPairEntity> __deletionAdapterOfExtensionDependencyPairEntity;
    private final EntityInsertionAdapter<ExtensionDependencyPairEntity> __insertionAdapterOfExtensionDependencyPairEntity;
    private final EntityDeletionOrUpdateAdapter<ExtensionDependencyPairEntity> __updateAdapterOfExtensionDependencyPairEntity;

    public ExtensionDependencyPairDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfExtensionDependencyPairEntity = new EntityInsertionAdapter<ExtensionDependencyPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ExtensionDependencyPairEntity` (`id`,`provider_extension_id`,`requirer_extension_id`,`version_constraint`,`extra`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionDependencyPairEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getProviderExtensionId());
                statement.bindString(3, entity.getRequirerExtensionId());
                statement.bindString(4, entity.getVersionConstraint());
                statement.bindString(5, entity.getExtra());
            }
        };
        this.__deletionAdapterOfExtensionDependencyPairEntity = new EntityDeletionOrUpdateAdapter<ExtensionDependencyPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `ExtensionDependencyPairEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionDependencyPairEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfExtensionDependencyPairEntity = new EntityDeletionOrUpdateAdapter<ExtensionDependencyPairEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `ExtensionDependencyPairEntity` SET `id` = ?,`provider_extension_id` = ?,`requirer_extension_id` = ?,`version_constraint` = ?,`extra` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionDependencyPairEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getProviderExtensionId());
                statement.bindString(3, entity.getRequirerExtensionId());
                statement.bindString(4, entity.getVersionConstraint());
                statement.bindString(5, entity.getExtra());
                statement.bindLong(6, entity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public long insert(final ExtensionDependencyPairEntity extensionDependencyPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfExtensionDependencyPairEntity.insertAndReturnId(extensionDependencyPairEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public List<Long> insertAll(final ExtensionDependencyPairEntity... extensionDependencyPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfExtensionDependencyPairEntity.insertAndReturnIdsList(extensionDependencyPairEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public void delete(final ExtensionDependencyPairEntity extensionDependencyPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionDependencyPairEntity.handle(extensionDependencyPairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public void deleteAll(final ExtensionDependencyPairEntity... extensionDependencyPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionDependencyPairEntity.handleMultiple(extensionDependencyPairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public void update(final ExtensionDependencyPairEntity extensionDependencyPairEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionDependencyPairEntity.handle(extensionDependencyPairEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public void updateAll(final ExtensionDependencyPairEntity... extensionDependencyPairEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionDependencyPairEntity.handleMultiple(extensionDependencyPairEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public LiveData<ExtensionDependencyPairEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDependencyPairEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDependencyPairEntity"}, false, new Callable<ExtensionDependencyPairEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionDependencyPairEntity call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDependencyPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    return cursorQuery.moveToFirst() ? new ExtensionDependencyPairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra"))) : null;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public ExtensionDependencyPairEntity selectByIdStatically(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDependencyPairEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? new ExtensionDependencyPairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public LiveData<ExtensionDependencyPairEntity> selectByIds(final long... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM ExtensionDependencyPairEntity WHERE id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (long j : ids) {
            roomSQLiteQueryAcquire.bindLong(i, j);
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDependencyPairEntity"}, false, new Callable<ExtensionDependencyPairEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionDependencyPairEntity call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDependencyPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    return cursorQuery.moveToFirst() ? new ExtensionDependencyPairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra"))) : null;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public ExtensionDependencyPairEntity selectByIdsStatically(final long... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM ExtensionDependencyPairEntity WHERE id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (long j : ids) {
            roomSQLiteQueryAcquire.bindLong(i, j);
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? new ExtensionDependencyPairEntity(cursorQuery.getLong(CursorUtil.getColumnIndexOrThrow(cursorQuery, "id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint")), cursorQuery.getString(CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public LiveData<List<ExtensionDependencyPairEntity>> selectByBothExtensionIdsContainedInExtensionIdList(final String... extensionIds) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM ExtensionDependencyPairEntity WHERE provider_extension_id IN (");
        int length = extensionIds.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(") AND requirer_extension_id IN (");
        int length2 = extensionIds.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length2);
        sbNewStringBuilder.append(")");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length2 + length);
        int i = 1;
        for (String str : extensionIds) {
            roomSQLiteQueryAcquire.bindString(i, str);
            i++;
        }
        int i2 = length + 1;
        for (String str2 : extensionIds) {
            roomSQLiteQueryAcquire.bindString(i2, str2);
            i2++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDependencyPairEntity"}, false, new Callable<List<ExtensionDependencyPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<ExtensionDependencyPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDependencyPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionDependencyPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public List<ExtensionDependencyPairEntity> selectByBothExtensionIdsContainedInExtensionIdListStatically(final String... extensionIds) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM ExtensionDependencyPairEntity WHERE provider_extension_id IN (");
        int length = extensionIds.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(") AND requirer_extension_id IN (");
        int length2 = extensionIds.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length2);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length2 + length);
        int i = 1;
        for (String str : extensionIds) {
            roomSQLiteQueryAcquire.bindString(i, str);
            i++;
        }
        int i2 = length + 1;
        for (String str2 : extensionIds) {
            roomSQLiteQueryAcquire.bindString(i2, str2);
            i2++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionDependencyPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public LiveData<Integer> countByProviderExtensionId(final String id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM ExtensionDependencyPairEntity WHERE provider_extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDependencyPairEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(ExtensionDependencyPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public int countByProviderExtensionIdStatically(final String id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM ExtensionDependencyPairEntity WHERE provider_extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public LiveData<List<ExtensionDependencyPairEntity>> selectByProviderExtensionId(final String id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDependencyPairEntity WHERE provider_extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDependencyPairEntity"}, false, new Callable<List<ExtensionDependencyPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.8
            @Override // java.util.concurrent.Callable
            public List<ExtensionDependencyPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDependencyPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionDependencyPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public List<ExtensionDependencyPairEntity> selectByProviderExtensionIdStatically(final String id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDependencyPairEntity WHERE provider_extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionDependencyPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public LiveData<List<ExtensionDependencyPairEntity>> selectByProviderExtensionIds(final String... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM ExtensionDependencyPairEntity WHERE provider_extension_id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (String str : ids) {
            roomSQLiteQueryAcquire.bindString(i, str);
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDependencyPairEntity"}, false, new Callable<List<ExtensionDependencyPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.9
            @Override // java.util.concurrent.Callable
            public List<ExtensionDependencyPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDependencyPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionDependencyPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public List<ExtensionDependencyPairEntity> selectByProviderExtensionIdsStatically(final String... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM ExtensionDependencyPairEntity WHERE provider_extension_id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (String str : ids) {
            roomSQLiteQueryAcquire.bindString(i, str);
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionDependencyPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public LiveData<Integer> countByRequirerExtensionId(final String id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM ExtensionDependencyPairEntity WHERE requirer_extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDependencyPairEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(ExtensionDependencyPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public int countByRequirerExtensionIdStatically(final String id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM ExtensionDependencyPairEntity WHERE requirer_extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public LiveData<List<ExtensionDependencyPairEntity>> selectByRequirerExtensionId(final String id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDependencyPairEntity WHERE requirer_extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDependencyPairEntity"}, false, new Callable<List<ExtensionDependencyPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.11
            @Override // java.util.concurrent.Callable
            public List<ExtensionDependencyPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDependencyPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionDependencyPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public List<ExtensionDependencyPairEntity> selectByRequirerExtensionIdStatically(final String id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionDependencyPairEntity WHERE requirer_extension_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionDependencyPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public LiveData<List<ExtensionDependencyPairEntity>> selectByRequirerExtensionIds(final String... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM ExtensionDependencyPairEntity WHERE requirer_extension_id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (String str : ids) {
            roomSQLiteQueryAcquire.bindString(i, str);
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionDependencyPairEntity"}, false, new Callable<List<ExtensionDependencyPairEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl.12
            @Override // java.util.concurrent.Callable
            public List<ExtensionDependencyPairEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDependencyPairDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ExtensionDependencyPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO
    public List<ExtensionDependencyPairEntity> selectByRequirerExtensionIdsStatically(final String... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM ExtensionDependencyPairEntity WHERE requirer_extension_id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (String str : ids) {
            roomSQLiteQueryAcquire.bindString(i, str);
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "provider_extension_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requirer_extension_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version_constraint");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new ExtensionDependencyPairEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getString(columnIndexOrThrow5)));
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
