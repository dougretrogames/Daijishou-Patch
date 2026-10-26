package com.magneticchen.daijishou.activities;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda9(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MainActivity.useDefaultWallpaper$lambda$3(this.f$0);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
