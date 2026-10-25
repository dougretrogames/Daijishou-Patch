package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "invoke", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1<T> extends Lambda implements Function1<SupportSQLiteDatabase, T> {
    final /* synthetic */ Function1<SupportSQLiteStatement, T> $block;
    final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, Function1<? super SupportSQLiteStatement, ? extends T> function1) {
        super(1);
        this.this$0 = autoClosingSupportSqliteStatement;
        this.$block = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = db.compileStatement(this.this$0.sql);
        this.this$0.doBinds(supportSQLiteStatementCompileStatement);
        return this.$block.invoke(supportSQLiteStatementCompileStatement);
    }
}
