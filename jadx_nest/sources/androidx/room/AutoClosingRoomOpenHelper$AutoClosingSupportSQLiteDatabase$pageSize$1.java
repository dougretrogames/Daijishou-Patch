package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1 extends MutablePropertyReference1Impl {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1() {
        super(SupportSQLiteDatabase.class, "pageSize", "getPageSize()J", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public void set(Object obj, Object obj2) {
        ((SupportSQLiteDatabase) obj).setPageSize(((Number) obj2).longValue());
    }
}
