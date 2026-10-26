package androidx.compose.ui.platform;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda3(AndroidComposeView androidComposeView) {
        this.f$0 = androidComposeView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AndroidComposeView.sendHoverExitEvent$lambda$5(this.f$0);
    }
}
