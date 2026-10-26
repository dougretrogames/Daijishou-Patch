package androidx.profileinstaller;

import android.content.Context;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class ProfileInstallerInitializer$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ ProfileInstallerInitializer$$ExternalSyntheticLambda1(Context context) {
        this.f$0 = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProfileInstallerInitializer.writeInBackground(this.f$0);
    }
}
