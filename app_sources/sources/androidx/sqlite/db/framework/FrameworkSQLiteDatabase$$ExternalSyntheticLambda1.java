package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import kotlin.jvm.functions.Function4;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class FrameworkSQLiteDatabase$$ExternalSyntheticLambda1 implements SQLiteDatabase.CursorFactory {
    public final /* synthetic */ Function4 f$0;

    public /* synthetic */ FrameworkSQLiteDatabase$$ExternalSyntheticLambda1(Function4 function4) {
        this.f$0 = function4;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return FrameworkSQLiteDatabase.query$lambda$0(this.f$0, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }
}
