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
import androidx.sqlite.db.SupportSQLiteStatement;
import com.magneticchen.daijishou.application_data.RoomDatabaseConverters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/* INFO: loaded from: classes4.dex */
public final class ImageBlockWidgetInstanceDAO_Impl implements ImageBlockWidgetInstanceDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ImageBlockWidgetInstanceEntity> __deletionAdapterOfImageBlockWidgetInstanceEntity;
    private final EntityInsertionAdapter<ImageBlockWidgetInstanceEntity> __insertionAdapterOfImageBlockWidgetInstanceEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<ImageBlockWidgetInstanceEntity> __updateAdapterOfImageBlockWidgetInstanceEntity;

    public ImageBlockWidgetInstanceDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfImageBlockWidgetInstanceEntity = new AnonymousClass1(__db);
        this.__deletionAdapterOfImageBlockWidgetInstanceEntity = new AnonymousClass2(__db);
        this.__updateAdapterOfImageBlockWidgetInstanceEntity = new AnonymousClass3(__db);
        this.__preparedStmtOfDeleteById = new AnonymousClass4(__db);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<ImageBlockWidgetInstanceEntity> {
        AnonymousClass1(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `ImageBlockWidgetInstanceEntity` (`id`,`image_path`,`last_update_timestamp`) VALUES (nullif(?, 0),?,?)";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(final SupportSQLiteStatement statement, final ImageBlockWidgetInstanceEntity entity) {
            statement.bindLong(1, entity.getId());
            if (entity.getImagePath() == null) {
                statement.bindNull(2);
            } else {
                statement.bindString(2, entity.getImagePath());
            }
            Long lFromDate = ImageBlockWidgetInstanceDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdateTimestamp());
            if (lFromDate == null) {
                statement.bindNull(3);
            } else {
                statement.bindLong(3, lFromDate.longValue());
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends EntityDeletionOrUpdateAdapter<ImageBlockWidgetInstanceEntity> {
        AnonymousClass2(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `ImageBlockWidgetInstanceEntity` WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(final SupportSQLiteStatement statement, final ImageBlockWidgetInstanceEntity entity) {
            statement.bindLong(1, entity.getId());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends EntityDeletionOrUpdateAdapter<ImageBlockWidgetInstanceEntity> {
        AnonymousClass3(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `ImageBlockWidgetInstanceEntity` SET `id` = ?,`image_path` = ?,`last_update_timestamp` = ? WHERE `id` = ?";
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(final SupportSQLiteStatement statement, final ImageBlockWidgetInstanceEntity entity) {
            statement.bindLong(1, entity.getId());
            if (entity.getImagePath() == null) {
                statement.bindNull(2);
            } else {
                statement.bindString(2, entity.getImagePath());
            }
            Long lFromDate = ImageBlockWidgetInstanceDAO_Impl.this.__roomDatabaseConverters.fromDate(entity.getLastUpdateTimestamp());
            if (lFromDate == null) {
                statement.bindNull(3);
            } else {
                statement.bindLong(3, lFromDate.longValue());
            }
            statement.bindLong(4, entity.getId());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO_Impl$4, reason: invalid class name */
    class AnonymousClass4 extends SharedSQLiteStatement {
        AnonymousClass4(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM ImageBlockWidgetInstanceEntity WHERE id=?";
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
    public long insert(final ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfImageBlockWidgetInstanceEntity.insertAndReturnId(imageBlockWidgetInstanceEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
    public List<Long> insertAll(final ImageBlockWidgetInstanceEntity... imageBlockWidgetInstanceEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfImageBlockWidgetInstanceEntity.insertAndReturnIdsList(imageBlockWidgetInstanceEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
    public void delete(final ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfImageBlockWidgetInstanceEntity.handle(imageBlockWidgetInstanceEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
    public void update(final ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfImageBlockWidgetInstanceEntity.handle(imageBlockWidgetInstanceEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
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

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO_Impl$5, reason: invalid class name */
    class AnonymousClass5 implements Callable<Integer> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass5(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Integer numValueOf = null;
            Cursor cursorQuery = DBUtil.query(ImageBlockWidgetInstanceDAO_Impl.this.__db, this.val$_statement, false, null);
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

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
    public LiveData<Integer> countAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ImageBlockWidgetInstanceEntity"}, false, new AnonymousClass5(RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM ImageBlockWidgetInstanceEntity", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM ImageBlockWidgetInstanceEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO_Impl$6, reason: invalid class name */
    class AnonymousClass6 implements Callable<List<ImageBlockWidgetInstanceEntity>> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass6(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<ImageBlockWidgetInstanceEntity> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(ImageBlockWidgetInstanceDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_path");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    Date date = ImageBlockWidgetInstanceDAO_Impl.this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                    if (date == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    arrayList.add(new ImageBlockWidgetInstanceEntity(j, string, date));
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

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
    public LiveData<List<ImageBlockWidgetInstanceEntity>> selectAll() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ImageBlockWidgetInstanceEntity"}, false, new AnonymousClass6(RoomSQLiteQuery.acquire("SELECT * FROM ImageBlockWidgetInstanceEntity ORDER BY id ASC", 0)));
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
    public List<ImageBlockWidgetInstanceEntity> selectAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ImageBlockWidgetInstanceEntity ORDER BY id ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_path");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                long j = cursorQuery.getLong(columnIndexOrThrow);
                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                Date date = this.__roomDatabaseConverters.toDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                arrayList.add(new ImageBlockWidgetInstanceEntity(j, string, date));
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

    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
    public LiveData<ImageBlockWidgetInstanceEntity> selectById(final long id2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ImageBlockWidgetInstanceEntity WHERE id=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ImageBlockWidgetInstanceEntity"}, false, new AnonymousClass7(roomSQLiteQueryAcquire));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO_Impl$7, reason: invalid class name */
    class AnonymousClass7 implements Callable<ImageBlockWidgetInstanceEntity> {
        final /* synthetic */ RoomSQLiteQuery val$_statement;

        AnonymousClass7(final RoomSQLiteQuery val$_statement) {
            this.val$_statement = val$_statement;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public ImageBlockWidgetInstanceEntity call() throws Exception {
            ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity = null;
            Long lValueOf = null;
            Cursor cursorQuery = DBUtil.query(ImageBlockWidgetInstanceDAO_Impl.this.__db, this.val$_statement, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_path");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
                if (cursorQuery.moveToFirst()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                    if (!cursorQuery.isNull(columnIndexOrThrow3)) {
                        lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3));
                    }
                    Date date = ImageBlockWidgetInstanceDAO_Impl.this.__roomDatabaseConverters.toDate(lValueOf);
                    if (date == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                    }
                    imageBlockWidgetInstanceEntity = new ImageBlockWidgetInstanceEntity(j, string, date);
                }
                cursorQuery.close();
                return imageBlockWidgetInstanceEntity;
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
    @Override // com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO
    public ImageBlockWidgetInstanceEntity selectByIdStatically(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ImageBlockWidgetInstanceEntity WHERE id=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_path");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_timestamp");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                if (!cursorQuery.isNull(columnIndexOrThrow3)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3));
                }
                Date date = this.__roomDatabaseConverters.toDate(lValueOf);
                if (date == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.");
                }
                imageBlockWidgetInstanceEntity = new ImageBlockWidgetInstanceEntity(j2, string, date);
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return imageBlockWidgetInstanceEntity;
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
