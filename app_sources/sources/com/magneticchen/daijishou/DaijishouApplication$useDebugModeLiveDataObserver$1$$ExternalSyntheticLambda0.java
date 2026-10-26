package com.magneticchen.daijishou;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DaijishouApplication$useDebugModeLiveDataObserver$1$$ExternalSyntheticLambda0 implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ DaijishouApplication f$0;

    public /* synthetic */ DaijishouApplication$useDebugModeLiveDataObserver$1$$ExternalSyntheticLambda0(DaijishouApplication daijishouApplication) {
        this.f$0 = daijishouApplication;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            DaijishouApplication$useDebugModeLiveDataObserver$1.invoke$lambda$0(this.f$0, thread, th);
        } catch (Throwable th2) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th2);
        }
    }
}
