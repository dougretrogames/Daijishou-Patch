package androidx.core.app;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0 implements SharedElementCallback.OnSharedElementsReadyListener {
    public final /* synthetic */ android.app.SharedElementCallback.OnSharedElementsReadyListener f$0;

    public /* synthetic */ ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0(android.app.SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f$0 = onSharedElementsReadyListener;
    }

    @Override // androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener
    public final void onSharedElementsReady() {
        ActivityCompat.Api23Impl.onSharedElementsReady(this.f$0);
    }
}
