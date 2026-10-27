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
import com.magneticchen.daijishou.data.db.entity.ExtensionEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class ExtensionDAO_Impl implements ExtensionDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ExtensionEntity> __deletionAdapterOfExtensionEntity;
    private final EntityInsertionAdapter<ExtensionEntity> __insertionAdapterOfExtensionEntity;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<ExtensionEntity> __updateAdapterOfExtensionEntity;

    public ExtensionDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfExtensionEntity = new EntityInsertionAdapter<ExtensionEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ExtensionEntity` (`id`,`name`,`description`,`icon`,`is_preloaded`,`is_nsfw`,`version`,`api_level`,`is_top_level`,`is_enabled`,`categories`,`last_update_timestamp`,`installation_timestamp`,`repository_base_url`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ExtensionEntity extensionEntity) {
                supportSQLiteStatement.bindString(1, extensionEntity.getId());
                if (extensionEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, extensionEntity.getName());
                }
                if (extensionEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, extensionEntity.getDescription());
                }
                if (extensionEntity.getIcon() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, extensionEntity.getIcon());
                }
                supportSQLiteStatement.bindLong(5, extensionEntity.isPreloaded() ? 1L : 0L);
                supportSQLiteStatement.bindLong(6, extensionEntity.isNSFW() ? 1L : 0L);
                supportSQLiteStatement.bindString(7, extensionEntity.getVersion());
                if (extensionEntity.getApiLevel() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, extensionEntity.getApiLevel().intValue());
                }
                supportSQLiteStatement.bindLong(9, extensionEntity.isTopLevel() ? 1L : 0L);
                supportSQLiteStatement.bindLong(10, extensionEntity.isEnabled() ? 1L : 0L);
                supportSQLiteStatement.bindString(11, ExtensionDAO_Impl.this.__roomDatabaseConverters.fromMutableStringList(extensionEntity.getCategories()));
                Long lFromDate = ExtensionDAO_Impl.this.__roomDatabaseConverters.fromDate(extensionEntity.getLastUpdateTimestamp());
                if (lFromDate == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, lFromDate.longValue());
                }
                Long lFromDate2 = ExtensionDAO_Impl.this.__roomDatabaseConverters.fromDate(extensionEntity.getInstallationTimestamp());
                if (lFromDate2 == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, lFromDate2.longValue());
                }
                if (extensionEntity.getRepositoryBaseUrl() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, extensionEntity.getRepositoryBaseUrl());
                }
            }
        };
        this.__deletionAdapterOfExtensionEntity = new EntityDeletionOrUpdateAdapter<ExtensionEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `ExtensionEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final ExtensionEntity entity) {
                statement.bindString(1, entity.getId());
            }
        };
        this.__updateAdapterOfExtensionEntity = new EntityDeletionOrUpdateAdapter<ExtensionEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `ExtensionEntity` SET `id` = ?,`name` = ?,`description` = ?,`icon` = ?,`is_preloaded` = ?,`is_nsfw` = ?,`version` = ?,`api_level` = ?,`is_top_level` = ?,`is_enabled` = ?,`categories` = ?,`last_update_timestamp` = ?,`installation_timestamp` = ?,`repository_base_url` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ExtensionEntity extensionEntity) {
                supportSQLiteStatement.bindString(1, extensionEntity.getId());
                if (extensionEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, extensionEntity.getName());
                }
                if (extensionEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, extensionEntity.getDescription());
                }
                if (extensionEntity.getIcon() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, extensionEntity.getIcon());
                }
                supportSQLiteStatement.bindLong(5, extensionEntity.isPreloaded() ? 1L : 0L);
                supportSQLiteStatement.bindLong(6, extensionEntity.isNSFW() ? 1L : 0L);
                supportSQLiteStatement.bindString(7, extensionEntity.getVersion());
                if (extensionEntity.getApiLevel() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, extensionEntity.getApiLevel().intValue());
                }
                supportSQLiteStatement.bindLong(9, extensionEntity.isTopLevel() ? 1L : 0L);
                supportSQLiteStatement.bindLong(10, extensionEntity.isEnabled() ? 1L : 0L);
                supportSQLiteStatement.bindString(11, ExtensionDAO_Impl.this.__roomDatabaseConverters.fromMutableStringList(extensionEntity.getCategories()));
                Long lFromDate = ExtensionDAO_Impl.this.__roomDatabaseConverters.fromDate(extensionEntity.getLastUpdateTimestamp());
                if (lFromDate == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, lFromDate.longValue());
                }
                Long lFromDate2 = ExtensionDAO_Impl.this.__roomDatabaseConverters.fromDate(extensionEntity.getInstallationTimestamp());
                if (lFromDate2 == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, lFromDate2.longValue());
                }
                if (extensionEntity.getRepositoryBaseUrl() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, extensionEntity.getRepositoryBaseUrl());
                }
                supportSQLiteStatement.bindString(15, extensionEntity.getId());
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public long insert(final ExtensionEntity extensionEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfExtensionEntity.insertAndReturnId(extensionEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public List<Long> insertAll(final ExtensionEntity... extensionEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfExtensionEntity.insertAndReturnIdsList(extensionEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public void delete(final ExtensionEntity extensionEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionEntity.handle(extensionEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public void deleteAll(final ExtensionEntity... extensionEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExtensionEntity.handleMultiple(extensionEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public void update(final ExtensionEntity extensionEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionEntity.handle(extensionEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public void updateAll(final ExtensionEntity... extensionEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExtensionEntity.handleMultiple(extensionEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public LiveData<Integer> countAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM ExtensionEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(ExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM ExtensionEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public LiveData<List<String>> selectAllIds() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM ExtensionEntity ORDER BY id ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionEntity"}, false, new Callable<List<String>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.5
            @Override // java.util.concurrent.Callable
            public List<String> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public List<String> selectAllIdsStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM ExtensionEntity ORDER BY id ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public LiveData<List<ExtensionEntity>> selectAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity ORDER BY id ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionEntity"}, false, new Callable<List<ExtensionEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<ExtensionEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                    int i = columnIndexOrThrow13;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string5 = cursorQuery.getString(columnIndexOrThrow7);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                        boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                        boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                        int i2 = columnIndexOrThrow;
                        List<String> mutableStringList = ExtensionDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                        Date date = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                        int i3 = i;
                        i = i3;
                        Date date2 = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)));
                        if (date2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        int i4 = columnIndexOrThrow14;
                        arrayList.add(new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4)));
                        columnIndexOrThrow14 = i4;
                        columnIndexOrThrow = i2;
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public List<ExtensionEntity> selectAllStatically() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity ORDER BY id ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                    String string5 = cursorQuery.getString(columnIndexOrThrow7);
                    Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                    boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                    boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                    int i2 = columnIndexOrThrow;
                    List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                    Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                    int i3 = i;
                    i = i3;
                    Date date2 = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)));
                    if (date2 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    int i4 = columnIndexOrThrow14;
                    arrayList.add(new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4)));
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow = i2;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public LiveData<ExtensionEntity> selectById(final String id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionEntity"}, false, new Callable<ExtensionEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ExtensionEntity call() throws Exception {
                ExtensionEntity extensionEntity;
                Cursor cursorQuery = DBUtil.query(ExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string5 = cursorQuery.getString(columnIndexOrThrow7);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                        boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                        boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                        List<String> mutableStringList = ExtensionDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                        Date date = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                        Date date2 = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow13) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow13)));
                        if (date2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        extensionEntity = new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                    } else {
                        extensionEntity = null;
                    }
                    cursorQuery.close();
                    return extensionEntity;
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public ExtensionEntity selectByIdStatically(final String id2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        ExtensionEntity extensionEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                    String string5 = cursorQuery.getString(columnIndexOrThrow7);
                    Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                    boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                    boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                    List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                    Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                    Date date2 = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow13) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow13)));
                    if (date2 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    extensionEntity = new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                } else {
                    extensionEntity = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return extensionEntity;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public LiveData<List<ExtensionEntity>> selectEnabled() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity WHERE is_enabled = 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionEntity"}, false, new Callable<List<ExtensionEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.8
            @Override // java.util.concurrent.Callable
            public List<ExtensionEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                    int i = columnIndexOrThrow13;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string5 = cursorQuery.getString(columnIndexOrThrow7);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                        boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                        boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                        int i2 = columnIndexOrThrow;
                        List<String> mutableStringList = ExtensionDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                        Date date = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                        int i3 = i;
                        i = i3;
                        Date date2 = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)));
                        if (date2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        int i4 = columnIndexOrThrow14;
                        arrayList.add(new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4)));
                        columnIndexOrThrow14 = i4;
                        columnIndexOrThrow = i2;
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public List<ExtensionEntity> selectEnabledStatically() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity WHERE is_enabled = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                    String string5 = cursorQuery.getString(columnIndexOrThrow7);
                    Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                    boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                    boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                    int i2 = columnIndexOrThrow;
                    List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                    Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                    int i3 = i;
                    i = i3;
                    Date date2 = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)));
                    if (date2 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    int i4 = columnIndexOrThrow14;
                    arrayList.add(new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4)));
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow = i2;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public LiveData<List<ExtensionEntity>> selectPreloaded() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity WHERE is_preloaded = 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionEntity"}, false, new Callable<List<ExtensionEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.9
            @Override // java.util.concurrent.Callable
            public List<ExtensionEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                    int i = columnIndexOrThrow13;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string5 = cursorQuery.getString(columnIndexOrThrow7);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                        boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                        boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                        int i2 = columnIndexOrThrow;
                        List<String> mutableStringList = ExtensionDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                        Date date = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                        int i3 = i;
                        i = i3;
                        Date date2 = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)));
                        if (date2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        int i4 = columnIndexOrThrow14;
                        arrayList.add(new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4)));
                        columnIndexOrThrow14 = i4;
                        columnIndexOrThrow = i2;
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public List<ExtensionEntity> selectPreloadedStatically() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity WHERE is_preloaded = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                    String string5 = cursorQuery.getString(columnIndexOrThrow7);
                    Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                    boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                    boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                    int i2 = columnIndexOrThrow;
                    List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                    Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                    int i3 = i;
                    i = i3;
                    Date date2 = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)));
                    if (date2 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    int i4 = columnIndexOrThrow14;
                    arrayList.add(new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4)));
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow = i2;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public LiveData<List<ExtensionEntity>> selectTopLevel() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity WHERE is_top_level = 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionEntity"}, false, new Callable<List<ExtensionEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.10
            @Override // java.util.concurrent.Callable
            public List<ExtensionEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                    int i = columnIndexOrThrow13;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string5 = cursorQuery.getString(columnIndexOrThrow7);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                        boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                        boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                        int i2 = columnIndexOrThrow;
                        List<String> mutableStringList = ExtensionDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                        Date date = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                        int i3 = i;
                        i = i3;
                        Date date2 = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)));
                        if (date2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        int i4 = columnIndexOrThrow14;
                        arrayList.add(new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4)));
                        columnIndexOrThrow14 = i4;
                        columnIndexOrThrow = i2;
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public List<ExtensionEntity> selectTopLevelStatically() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity WHERE is_top_level = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                    String string5 = cursorQuery.getString(columnIndexOrThrow7);
                    Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                    boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                    boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                    int i2 = columnIndexOrThrow;
                    List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                    Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                    int i3 = i;
                    i = i3;
                    Date date2 = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)));
                    if (date2 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    int i4 = columnIndexOrThrow14;
                    arrayList.add(new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4)));
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow = i2;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public LiveData<List<ExtensionEntity>> selectTopLevelAndEnabled() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity WHERE is_top_level = 1 AND is_enabled = 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExtensionEntity"}, false, new Callable<List<ExtensionEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl.11
            @Override // java.util.concurrent.Callable
            public List<ExtensionEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ExtensionDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                    int i = columnIndexOrThrow13;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        String string5 = cursorQuery.getString(columnIndexOrThrow7);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                        boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                        boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                        int i2 = columnIndexOrThrow;
                        List<String> mutableStringList = ExtensionDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                        Date date = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                        int i3 = i;
                        i = i3;
                        Date date2 = ExtensionDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)));
                        if (date2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        int i4 = columnIndexOrThrow14;
                        arrayList.add(new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4)));
                        columnIndexOrThrow14 = i4;
                        columnIndexOrThrow = i2;
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

    @Override // com.magneticchen.daijishou.data.db.dao.ExtensionDAO
    public List<ExtensionEntity> selectTopLevelAndEnabledStatically() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtensionEntity WHERE is_top_level = 1 AND is_enabled = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_preloaded");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_nsfw");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "api_level");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top_level");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_enabled");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categories");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installation_timestamp");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "repository_base_url");
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                    String string5 = cursorQuery.getString(columnIndexOrThrow7);
                    Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow8));
                    boolean z3 = cursorQuery.getInt(columnIndexOrThrow9) != 0;
                    boolean z4 = cursorQuery.getInt(columnIndexOrThrow10) != 0;
                    int i2 = columnIndexOrThrow;
                    List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow11));
                    Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                    int i3 = i;
                    i = i3;
                    Date date2 = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(i3) ? null : Long.valueOf(cursorQuery.getLong(i3)));
                    if (date2 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    int i4 = columnIndexOrThrow14;
                    arrayList.add(new ExtensionEntity(string, string2, string3, string4, z, z2, string5, numValueOf, z3, z4, mutableStringList, date, date2, cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4)));
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow = i2;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
