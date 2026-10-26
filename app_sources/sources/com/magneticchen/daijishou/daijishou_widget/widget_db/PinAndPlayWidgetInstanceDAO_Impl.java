package com.magneticchen.daijishou.daijishou_widget.widget_db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.magneticchen.daijishou.application_data.RoomDatabaseConverters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/* INFO: loaded from: classes4.dex */
public final class PinAndPlayWidgetInstanceDAO_Impl implements PinAndPlayWidgetInstanceDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PinAndPlayWidgetInstanceEntity> __deletionAdapterOfPinAndPlayWidgetInstanceEntity;
    private final EntityInsertionAdapter<PinAndPlayWidgetInstanceEntity> __insertionAdapterOfPinAndPlayWidgetInstanceEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<PinAndPlayWidgetInstanceEntity> __updateAdapterOfPinAndPlayWidgetInstanceEntity;

    public PinAndPlayWidgetInstanceDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPinAndPlayWidgetInstanceEntity = new AnonymousClass1(__db);
        this.__deletionAdapterOfPinAndPlayWidgetInstanceEntity = new AnonymousClass2(__db);
        this.__updateAdapterOfPinAndPlayWidgetInstanceEntity = new AnonymousClass3(__db);
        this.__preparedStmtOfDeleteById = new AnonymousClass4(__db);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<PinAndPlayWidgetInstanceEntity> {
        AnonymousClass1(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `PinAndPlayWidgetInstanceEntity` (`id`,`playable_item_id`,`alternative_image_path`,`last_update_timestamp`) VALUES (nullif(?, 0),?,?,?)";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(final SupportSQLiteStatement statement, final PinAndPlayWidgetInstanceEntity entity) {
            statement.bindLong(1, entity.getId());
            if (entity.getPlayableItemId() == null) {
                statement.bindNull(2);
            } else {
                statement.bindLong(2, entity.getPlayableItemId().longValue());
            }
            if (entity.getAlternativeImagePath() == null) {
                statement.bindNull(3);
            } else {
                statement.bindString(3, entity.getAlternativeImagePath());
            }
            Long lFromDate = PinAndPlayWidgetInstanceDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdateTimestamp());
            if (lFromDate == null) {
                statement.bindNull(4);
            } else {
                statement.bindLong(4, lFromDate.longValue());
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends EntityDeletionOrUpdateAdapter<PinAndPlayWidgetInstanceEntity> {
        AnonymousClass2(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `PinAndPlayWidgetInstanceEntity` WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(final SupportSQLiteStatement statement, final PinAndPlayWidgetInstanceEntity entity) {
            statement.bindLong(1, entity.getId());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends EntityDeletionOrUpdateAdapter<PinAndPlayWidgetInstanceEntity> {
        AnonymousClass3(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `PinAndPlayWidgetInstanceEntity` SET `id` = ?,`playable_item_id` = ?,`alternative_image_path` = ?,`last_update_timestamp` = ? WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(final SupportSQLiteStatement statement, final PinAndPlayWidgetInstanceEntity entity) {
            statement.bindLong(1, entity.getId());
            if (entity.getPlayableItemId() == null) {
                statement.bindNull(2);
            } else {
                statement.bindLong(2, entity.getPlayableItemId().longValue());
            }
            if (entity.getAlternativeImagePath() == null) {
                statement.bindNull(3);
            } else {
                statement.bindString(3, entity.getAlternativeImagePath());
            }
            Long lFromDate = PinAndPlayWidgetInstanceDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdateTimestamp());
            if (lFromDate == null) {
                statement.bindNull(4);
            } else {
                statement.bindLong(4, lFromDate.longValue());
            }
            statement.bindLong(5, entity.getId());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO_Impl$4, reason: invalid class name */
    class AnonymousClass4 extends SharedSQLiteStatement {
        AnonymousClass4(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM PinAndPlayWidgetInstanceEntity WHERE id=?";
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public long insert(final PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfPinAndPlayWidgetInstanceEntity.insertAndReturnId(pinAndPlayWidgetInstanceEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public List<Long> insertAll(final PinAndPlayWidgetInstanceEntity... pinAndPlayWidgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfPinAndPlayWidgetInstanceEntity.insertAndReturnIdsList(pinAndPlayWidgetInstanceEntity);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public void delete(final PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPinAndPlayWidgetInstanceEntity.handle(pinAndPlayWidgetInstanceEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public void update(final PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPinAndPlayWidgetInstanceEntity.handle(pinAndPlayWidgetInstanceEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public void deleteById(final long id2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteById.acquire();
        supportSQLiteStatementAcquire.bindLong(1, id2);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteById.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteById.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO_Impl$5, reason: invalid class name */
    class AnonymousClass5 implements Callable<Integer> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass5(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Integer numValueOf = null;
            Cursor cursorQuery = DBUtil.query(PinAndPlayWidgetInstanceDAO_Impl.this.__db, this.val$_statement, false, null);
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
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public LiveData<Integer> countAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PinAndPlayWidgetInstanceEntity"}, false, new AnonymousClass5(RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM PinAndPlayWidgetInstanceEntity", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM PinAndPlayWidgetInstanceEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO_Impl$6, reason: invalid class name */
    class AnonymousClass6 implements Callable<List<PinAndPlayWidgetInstanceEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass6(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<PinAndPlayWidgetInstanceEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PinAndPlayWidgetInstanceDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "alternative_image_path");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    Long lValueOf = cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2));
                    String string = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    Date date = PinAndPlayWidgetInstanceDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                    if (date == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    arrayList.add(new PinAndPlayWidgetInstanceEntity(j, lValueOf, string, date));
                }
                cursorQuery.close();
                return arrayList;
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }

        protected void finalize() {
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public LiveData<List<PinAndPlayWidgetInstanceEntity>> selectAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PinAndPlayWidgetInstanceEntity"}, false, new AnonymousClass6(RoomSQLiteQuery.acquire("SELECT * FROM PinAndPlayWidgetInstanceEntity ORDER BY id ASC", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public List<PinAndPlayWidgetInstanceEntity> selectAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PinAndPlayWidgetInstanceEntity ORDER BY id ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "alternative_image_path");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                long j = cursorQuery.getLong(columnIndexOrThrow);
                Long lValueOf = cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2));
                String string = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                arrayList.add(new PinAndPlayWidgetInstanceEntity(j, lValueOf, string, date));
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

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public LiveData<PinAndPlayWidgetInstanceEntity> selectById(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PinAndPlayWidgetInstanceEntity WHERE id=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PinAndPlayWidgetInstanceEntity"}, false, new AnonymousClass7(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO_Impl$7, reason: invalid class name */
    class AnonymousClass7 implements Callable<PinAndPlayWidgetInstanceEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass7(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public PinAndPlayWidgetInstanceEntity call() throws Exception {
            PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity = null;
            Long lValueOf = null;
            Cursor cursorQuery = DBUtil.query(PinAndPlayWidgetInstanceDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "alternative_image_path");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                if (cursorQuery.moveToFirst()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2));
                    String string = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    if (!cursorQuery.isNull(columnIndexOrThrow4)) {
                        lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                    }
                    Date date = PinAndPlayWidgetInstanceDAO_Impl.this.__roomDatabaseConverters.toDate(lValueOf);
                    if (date == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    pinAndPlayWidgetInstanceEntity = new PinAndPlayWidgetInstanceEntity(j, lValueOf2, string, date);
                }
                cursorQuery.close();
                return pinAndPlayWidgetInstanceEntity;
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }

        protected void finalize() {
            this.val$_statement.release();
        }
    }

    /* WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
    	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public PinAndPlayWidgetInstanceEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PinAndPlayWidgetInstanceEntity WHERE id=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "alternative_image_path");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2));
                String string = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                if (!cursorQuery.isNull(columnIndexOrThrow4)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                }
                Date date = this.__roomDatabaseConverters.toDate(lValueOf);
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                pinAndPlayWidgetInstanceEntity = new PinAndPlayWidgetInstanceEntity(j2, lValueOf2, string, date);
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return pinAndPlayWidgetInstanceEntity;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public LiveData<PinAndPlayWidgetInstanceEntity> selectByPlayableItemId(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PinAndPlayWidgetInstanceEntity WHERE playable_item_id=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PinAndPlayWidgetInstanceEntity"}, false, new AnonymousClass8(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO_Impl$8, reason: invalid class name */
    class AnonymousClass8 implements Callable<PinAndPlayWidgetInstanceEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass8(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public PinAndPlayWidgetInstanceEntity call() throws Exception {
            PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity = null;
            Long lValueOf = null;
            Cursor cursorQuery = DBUtil.query(PinAndPlayWidgetInstanceDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "alternative_image_path");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                if (cursorQuery.moveToFirst()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2));
                    String string = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    if (!cursorQuery.isNull(columnIndexOrThrow4)) {
                        lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                    }
                    Date date = PinAndPlayWidgetInstanceDAO_Impl.this.__roomDatabaseConverters.toDate(lValueOf);
                    if (date == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    pinAndPlayWidgetInstanceEntity = new PinAndPlayWidgetInstanceEntity(j, lValueOf2, string, date);
                }
                cursorQuery.close();
                return pinAndPlayWidgetInstanceEntity;
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }

        protected void finalize() {
            this.val$_statement.release();
        }
    }

    /* WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
    	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public PinAndPlayWidgetInstanceEntity selectByPlayableItemIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PinAndPlayWidgetInstanceEntity WHERE playable_item_id=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "alternative_image_path");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2));
                String string = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                if (!cursorQuery.isNull(columnIndexOrThrow4)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4));
                }
                Date date = this.__roomDatabaseConverters.toDate(lValueOf);
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                pinAndPlayWidgetInstanceEntity = new PinAndPlayWidgetInstanceEntity(j2, lValueOf2, string, date);
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return pinAndPlayWidgetInstanceEntity;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public LiveData<List<PinAndPlayWidgetInstanceEntity>> selectByPlayableItemIds(final long... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM PinAndPlayWidgetInstanceEntity WHERE playable_item_id IN (");
        int length = ids.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length);
        int i = 1;
        for (long j : ids) {
            roomSQLiteQueryAcquire.bindLong(i, j);
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PinAndPlayWidgetInstanceEntity"}, false, new AnonymousClass9(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO_Impl$9, reason: invalid class name */
    class AnonymousClass9 implements Callable<List<PinAndPlayWidgetInstanceEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass9(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<PinAndPlayWidgetInstanceEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(PinAndPlayWidgetInstanceDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "alternative_image_path");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    Long lValueOf = cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2));
                    String string = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    Date date = PinAndPlayWidgetInstanceDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                    if (date == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    arrayList.add(new PinAndPlayWidgetInstanceEntity(j, lValueOf, string, date));
                }
                cursorQuery.close();
                return arrayList;
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }

        protected void finalize() {
            this.val$_statement.release();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO
    public List<PinAndPlayWidgetInstanceEntity> selectByPlayableItemIdsStatically(final long... ids) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM PinAndPlayWidgetInstanceEntity WHERE playable_item_id IN (");
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
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playable_item_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "alternative_image_path");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                Long lValueOf = cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2));
                String string = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                arrayList.add(new PinAndPlayWidgetInstanceEntity(j2, lValueOf, string, date));
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
