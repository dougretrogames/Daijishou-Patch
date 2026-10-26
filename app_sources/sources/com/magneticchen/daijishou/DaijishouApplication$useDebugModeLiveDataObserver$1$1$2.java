package com.magneticchen.daijishou;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: DaijishouApplication.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/magneticchen/daijishou/DaijishouApplication$useDebugModeLiveDataObserver$1$1$2", "Ljava/lang/Thread;", "run", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouApplication$useDebugModeLiveDataObserver$1$1$2 extends Thread {
    final /* synthetic */ Throwable $e;
    final /* synthetic */ DaijishouApplication this$0;

    DaijishouApplication$useDebugModeLiveDataObserver$1$1$2(DaijishouApplication daijishouApplication, Throwable th) {
        this.this$0 = daijishouApplication;
        this.$e = th;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        Context applicationContext = this.this$0.getApplicationContext();
        Throwable e = this.$e;
        Intrinsics.checkNotNullExpressionValue(e, "$e");
        Toast.makeText(applicationContext, "Debug mode error: " + ExceptionsKt.stackTraceToString(e), 1).show();
        Looper.loop();
    }
}
