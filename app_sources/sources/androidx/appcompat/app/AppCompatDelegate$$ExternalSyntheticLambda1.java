package androidx.appcompat.app;

import android.content.Context;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class AppCompatDelegate$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ AppCompatDelegate$$ExternalSyntheticLambda1(Context context) {
        this.f$0 = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppCompatDelegate.syncRequestedAndStoredLocales(this.f$0);
    }
}
