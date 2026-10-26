package com.magneticchen.daijishou;

import android.app.ActivityManager;
import android.os.Process;
import android.widget.Toast;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* INFO: compiled from: DaijishouApplication.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouApplication$useDebugModeLiveDataObserver$1 extends Lambda<Unit> implements Function1<Boolean, Unit> {
    final /* synthetic */ DaijishouApplication this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouApplication$useDebugModeLiveDataObserver$1(DaijishouApplication daijishouApplication) {
        super(1);
        this.this$0 = daijishouApplication;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (this.this$0.firstTime) {
            DaijishouApplication daijishouApplication = this.this$0;
            daijishouApplication.useDebugMode = daijishouApplication.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue());
        }
        if (z && !this.this$0.firstTime) {
            Toast.makeText(this.this$0.getApplicationContext(), "Debug mode on.", 0).show();
        } else if (this.this$0.useDebugMode != z) {
            Toast.makeText(this.this$0.getApplicationContext(), "Debug mode off.", 0).show();
        }
        this.this$0.useDebugMode = z;
        this.this$0.firstTime = false;
        if (z) {
            Thread.setDefaultUncaughtExceptionHandler(new DaijishouApplication$useDebugModeLiveDataObserver$1$$ExternalSyntheticLambda0(this.this$0));
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(DaijishouApplication this$0, Thread thread, Throwable th) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLogger().error(this$0, String.valueOf(th.getMessage()));
        DaijishouApplication.WrappedLogger logger = this$0.getLogger();
        Intrinsics.checkNotNull(th);
        logger.error(this$0, ExceptionsKt.stackTraceToString(th));
        try {
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new DaijishouApplication$useDebugModeLiveDataObserver$1$1$1(this$0, null), 2, null);
        } catch (Exception e) {
            this$0.getLogger().error(this$0, ExceptionsKt.stackTraceToString(e));
        }
        new DaijishouApplication$useDebugModeLiveDataObserver$1$1$2(this$0, th).start();
        try {
            Thread.sleep(3000L);
            Object systemService = this$0.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ((ActivityManager) systemService).killBackgroundProcesses(this$0.getPackageName());
            Process.killProcess(Process.myPid());
        } catch (InterruptedException unused) {
        }
    }
}
