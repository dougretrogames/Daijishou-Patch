package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;

/* INFO: compiled from: InvalidationTracker.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"androidx/room/InvalidationTracker$refreshRunnable$1", "Ljava/lang/Runnable;", "checkUpdatedTable", "", "", "run", "", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InvalidationTracker$refreshRunnable$1 implements Runnable {
    final /* synthetic */ InvalidationTracker this$0;

    InvalidationTracker$refreshRunnable$1(InvalidationTracker invalidationTracker) {
        this.this$0 = invalidationTracker;
    }

    @Override // java.lang.Runnable
    public void run() {
        Set<Integer> setEmptySet;
        AutoCloser autoCloser;
        Lock closeLock$room_runtime_release = this.this$0.getDatabase().getCloseLock$room_runtime_release();
        closeLock$room_runtime_release.lock();
        try {
            try {
                if (!this.this$0.ensureInitialization$room_runtime_release()) {
                    closeLock$room_runtime_release.unlock();
                    AutoCloser autoCloser2 = this.this$0.autoCloser;
                    if (autoCloser2 != null) {
                        autoCloser2.decrementCountAndScheduleClose();
                        return;
                    }
                    return;
                }
                if (!this.this$0.getPendingRefresh().compareAndSet(true, false)) {
                    closeLock$room_runtime_release.unlock();
                    AutoCloser autoCloser3 = this.this$0.autoCloser;
                    if (autoCloser3 != null) {
                        autoCloser3.decrementCountAndScheduleClose();
                        return;
                    }
                    return;
                }
                if (this.this$0.getDatabase().inTransaction()) {
                    closeLock$room_runtime_release.unlock();
                    AutoCloser autoCloser4 = this.this$0.autoCloser;
                    if (autoCloser4 != null) {
                        autoCloser4.decrementCountAndScheduleClose();
                        return;
                    }
                    return;
                }
                SupportSQLiteDatabase writableDatabase = this.this$0.getDatabase().getOpenHelper().getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    setEmptySet = checkUpdatedTable();
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    closeLock$room_runtime_release.unlock();
                    autoCloser = this.this$0.autoCloser;
                    if (autoCloser != null) {
                        autoCloser.decrementCountAndScheduleClose();
                    }
                    if (setEmptySet.isEmpty()) {
                        return;
                    }
                    SafeIterableMap<InvalidationTracker.Observer, InvalidationTracker.ObserverWrapper> observerMap$room_runtime_release = this.this$0.getObserverMap$room_runtime_release();
                    InvalidationTracker invalidationTracker = this.this$0;
                    synchronized (observerMap$room_runtime_release) {
                        Iterator<Map.Entry<K, V>> it = invalidationTracker.getObserverMap$room_runtime_release().iterator();
                        while (it.hasNext()) {
                            ((InvalidationTracker.ObserverWrapper) ((Map.Entry) it.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(setEmptySet);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLiteException e) {
                Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
                setEmptySet = SetsKt.emptySet();
                closeLock$room_runtime_release.unlock();
                autoCloser = this.this$0.autoCloser;
                if (autoCloser != null) {
                }
            } catch (IllegalStateException e2) {
                Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e2);
                setEmptySet = SetsKt.emptySet();
                closeLock$room_runtime_release.unlock();
                autoCloser = this.this$0.autoCloser;
                if (autoCloser != null) {
                }
            }
        } catch (Throwable th2) {
            closeLock$room_runtime_release.unlock();
            AutoCloser autoCloser5 = this.this$0.autoCloser;
            if (autoCloser5 != null) {
                autoCloser5.decrementCountAndScheduleClose();
            }
            throw th2;
        }
    }

    private final Set<Integer> checkUpdatedTable() {
        InvalidationTracker invalidationTracker = this.this$0;
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        Cursor cursorQuery$default = RoomDatabase.query$default(invalidationTracker.getDatabase(), new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL), null, 2, null);
        try {
            Cursor cursor = cursorQuery$default;
            while (cursor.moveToNext()) {
                setCreateSetBuilder.add(Integer.valueOf(cursor.getInt(0)));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursorQuery$default, null);
            Set<Integer> setBuild = SetsKt.build(setCreateSetBuilder);
            if (setBuild.isEmpty()) {
                return setBuild;
            }
            if (this.this$0.getCleanupStatement() == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            SupportSQLiteStatement cleanupStatement = this.this$0.getCleanupStatement();
            if (cleanupStatement == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            cleanupStatement.executeUpdateDelete();
            return setBuild;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursorQuery$default, th);
                throw th2;
            }
        }
    }
}
