package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class ProfileInstallerInitializer$$ExternalSyntheticLambda0 implements Choreographer.FrameCallback {
    public final /* synthetic */ ProfileInstallerInitializer f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ ProfileInstallerInitializer$$ExternalSyntheticLambda0(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f$0 = profileInstallerInitializer;
        this.f$1 = context;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.f$0.m3227x451635a(this.f$1, j);
    }
}
