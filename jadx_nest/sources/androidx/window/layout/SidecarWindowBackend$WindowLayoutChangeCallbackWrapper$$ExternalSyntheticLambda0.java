package androidx.window.layout;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SidecarWindowBackend$WindowLayoutChangeCallbackWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SidecarWindowBackend.WindowLayoutChangeCallbackWrapper f$0;
    public final /* synthetic */ WindowLayoutInfo f$1;

    public /* synthetic */ SidecarWindowBackend$WindowLayoutChangeCallbackWrapper$$ExternalSyntheticLambda0(SidecarWindowBackend.WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
        this.f$0 = windowLayoutChangeCallbackWrapper;
        this.f$1 = windowLayoutInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.m3248accept$lambda0(this.f$0, this.f$1);
    }
}
