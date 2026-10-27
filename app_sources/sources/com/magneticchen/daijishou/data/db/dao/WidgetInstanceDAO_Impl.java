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
import com.magneticchen.daijishou.data.RoomDatabaseConverters;
import com.magneticchen.daijishou.data.db.entity.WidgetInstanceEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class WidgetInstanceDAO_Impl implements WidgetInstanceDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<WidgetInstanceEntity> __deletionAdapterOfWidgetInstanceEntity;
    private final EntityInsertionAdapter<WidgetInstanceEntity> __insertionAdapterOfWidgetInstanceEntity;
    private final SharedSQLiteStatement __preparedStmtOfDecreasePositionFromPosition;
    private final SharedSQLiteStatement __preparedStmtOfSetPositionById;
    private final SharedSQLiteStatement __preparedStmtOfSwiftPositionBetween;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<WidgetInstanceEntity> __updateAdapterOfWidgetInstanceEntity;

    public WidgetInstanceDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWidgetInstanceEntity = new EntityInsertionAdapter<WidgetInstanceEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR ABORT INTO `WidgetInstanceEntity` (`id`,`widget_id`,`widget_instance_id`,`added_date_timestamp`,`position`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final WidgetInstanceEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getWidgetId());
                statement.bindLong(3, entity.getWidgetInstanceId());
                Long lFromDate = WidgetInstanceDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getAddedDateTimestamp());
                if (lFromDate == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, lFromDate.longValue());
                }
                statement.bindLong(5, entity.getPosition());
            }
        };
        this.__deletionAdapterOfWidgetInstanceEntity = new EntityDeletionOrUpdateAdapter<WidgetInstanceEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `WidgetInstanceEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final WidgetInstanceEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfWidgetInstanceEntity = new EntityDeletionOrUpdateAdapter<WidgetInstanceEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `WidgetInstanceEntity` SET `id` = ?,`widget_id` = ?,`widget_instance_id` = ?,`added_date_timestamp` = ?,`position` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final WidgetInstanceEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getWidgetId());
                statement.bindLong(3, entity.getWidgetInstanceId());
                Long lFromDate = WidgetInstanceDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getAddedDateTimestamp());
                if (lFromDate == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, lFromDate.longValue());
                }
                statement.bindLong(5, entity.getPosition());
                statement.bindLong(6, entity.getId());
            }
        };
        this.__preparedStmtOfSwiftPositionBetween = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO_Impl.4
            public String createQuery() {
                return "UPDATE WidgetInstanceEntity SET position = position+MIN(1, MAX(-1, ?-?)) WHERE position>=MIN(?, ?) AND position<=MAX(?, ?)";
            }
        };
        this.__preparedStmtOfDecreasePositionFromPosition = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO_Impl.5
            public String createQuery() {
                return "UPDATE WidgetInstanceEntity SET position = position-1 WHERE position>=?";
            }
        };
        this.__preparedStmtOfSetPositionById = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO_Impl.6
            public String createQuery() {
                return "UPDATE WidgetInstanceEntity SET position=? WHERE id=?";
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public long insertRaw(final WidgetInstanceEntity widgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfWidgetInstanceEntity.insertAndReturnId(widgetInstanceEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public List<Long> insertAllRaw(final WidgetInstanceEntity... widgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfWidgetInstanceEntity.insertAndReturnIdsList(widgetInstanceEntity);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public void deleteRaw(final WidgetInstanceEntity widgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfWidgetInstanceEntity.handle(widgetInstanceEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public void update(final WidgetInstanceEntity widgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfWidgetInstanceEntity.handle(widgetInstanceEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public void swiftPositionBetween(final int fromPosition, final int toPosition) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSwiftPositionBetween.acquire();
        long j = fromPosition;
        supportSQLiteStatementAcquire.bindLong(1, j);
        long j2 = toPosition;
        supportSQLiteStatementAcquire.bindLong(2, j2);
        supportSQLiteStatementAcquire.bindLong(3, j);
        supportSQLiteStatementAcquire.bindLong(4, j2);
        supportSQLiteStatementAcquire.bindLong(5, j);
        supportSQLiteStatementAcquire.bindLong(6, j2);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfSwiftPositionBetween.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfSwiftPositionBetween.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public void decreasePositionFromPosition(final int position) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDecreasePositionFromPosition.acquire();
        supportSQLiteStatementAcquire.bindLong(1, position);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDecreasePositionFromPosition.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDecreasePositionFromPosition.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public void setPositionById(final long id2, final int position) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetPositionById.acquire();
        supportSQLiteStatementAcquire.bindLong(1, position);
        supportSQLiteStatementAcquire.bindLong(2, id2);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfSetPositionById.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfSetPositionById.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public Integer getMaxPositionStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT MAX(position) FROM WidgetInstanceEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Integer numValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                numValueOf = Integer.valueOf(cursorQuery.getInt(0));
            }
            return numValueOf;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public LiveData<Integer> countAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM WidgetInstanceEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WidgetInstanceEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO_Impl.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(WidgetInstanceDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM WidgetInstanceEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public LiveData<List<WidgetInstanceEntity>> selectAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM WidgetInstanceEntity ORDER BY position ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WidgetInstanceEntity"}, false, new Callable<List<WidgetInstanceEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO_Impl.8
            @Override // java.util.concurrent.Callable
            public List<WidgetInstanceEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(WidgetInstanceDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widget_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widget_instance_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "added_date_timestamp");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.getString(columnIndexOrThrow2);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow3);
                        Date date = WidgetInstanceDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                        if (date == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                        }
                        arrayList.add(new WidgetInstanceEntity(j, string, j2, date, cursorQuery.getInt(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public List<WidgetInstanceEntity> selectAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM WidgetInstanceEntity ORDER BY position ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widget_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widget_instance_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "added_date_timestamp");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                long j = cursorQuery.getLong(columnIndexOrThrow);
                String string = cursorQuery.getString(columnIndexOrThrow2);
                long j2 = cursorQuery.getLong(columnIndexOrThrow3);
                Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                arrayList.add(new WidgetInstanceEntity(j, string, j2, date, cursorQuery.getInt(columnIndexOrThrow5)));
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

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public LiveData<List<Long>> selectAllIds() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM WidgetInstanceEntity ORDER BY position ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WidgetInstanceEntity"}, false, new Callable<List<Long>>() { // from class: com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO_Impl.9
            @Override // java.util.concurrent.Callable
            public List<Long> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(WidgetInstanceDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public List<Long> selectAllIdsStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM WidgetInstanceEntity ORDER BY position ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
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

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public WidgetInstanceEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM WidgetInstanceEntity WHERE id=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        WidgetInstanceEntity widgetInstanceEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widget_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widget_instance_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "added_date_timestamp");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                String string = cursorQuery.getString(columnIndexOrThrow2);
                long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                if (!cursorQuery.isNull(columnIndexOrThrow4)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                }
                Date date = this.__roomDatabaseConverters.toDate(lValueOf);
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                widgetInstanceEntity = new WidgetInstanceEntity(j2, string, j3, date, cursorQuery.getInt(columnIndexOrThrow5));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return widgetInstanceEntity;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public WidgetInstanceEntity selectByWidgetIdAndWidgetInstanceIdStatically(String str, long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM WidgetInstanceEntity WHERE widget_id=? AND widget_instance_id=?", 2);
        roomSQLiteQueryAcquire.bindString(1, str);
        roomSQLiteQueryAcquire.bindLong(2, j);
        this.__db.assertNotSuspendingTransaction();
        WidgetInstanceEntity widgetInstanceEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widget_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "widget_instance_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "added_date_timestamp");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                String string = cursorQuery.getString(columnIndexOrThrow2);
                long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                if (!cursorQuery.isNull(columnIndexOrThrow4)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                }
                Date date = this.__roomDatabaseConverters.toDate(lValueOf);
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                widgetInstanceEntity = new WidgetInstanceEntity(j2, string, j3, date, cursorQuery.getInt(columnIndexOrThrow5));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return widgetInstanceEntity;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public void delete(final WidgetInstanceEntity widgetInstanceEntity) {
        WidgetInstanceDAO.DefaultImpls.delete(this, widgetInstanceEntity);
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public void deleteById(final long id2) {
        WidgetInstanceDAO.DefaultImpls.deleteById(this, id2);
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public long insert(final WidgetInstanceEntity widgetInstanceEntity) {
        return WidgetInstanceDAO.DefaultImpls.insert(this, widgetInstanceEntity);
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public void movePosition(final long id2, final int fromPosition, final int toPosition) {
        WidgetInstanceDAO.DefaultImpls.movePosition(this, id2, fromPosition, toPosition);
    }

    @Override // com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO
    public List<Long> insertAll(final WidgetInstanceEntity... widgetInstanceEntities) {
        return WidgetInstanceDAO.DefaultImpls.insertAll(this, widgetInstanceEntities);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
