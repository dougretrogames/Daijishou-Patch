package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 extends MutablePropertyReference1Impl {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1() {
        super(SupportSQLiteDatabase.class, "version", "getVersion()I", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object obj) {
        return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public void set(Object obj, Object obj2) {
        ((SupportSQLiteDatabase) obj).setVersion(((Number) obj2).intValue());
    }
}
