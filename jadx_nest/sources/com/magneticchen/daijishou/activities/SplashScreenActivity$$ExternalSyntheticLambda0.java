package com.magneticchen.daijishou.activities;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SplashScreenActivity$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SplashScreenActivity f$0;

    public /* synthetic */ SplashScreenActivity$$ExternalSyntheticLambda0(SplashScreenActivity splashScreenActivity) {
        this.f$0 = splashScreenActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            SplashScreenActivity.finishWithDelay$lambda$0(this.f$0);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
