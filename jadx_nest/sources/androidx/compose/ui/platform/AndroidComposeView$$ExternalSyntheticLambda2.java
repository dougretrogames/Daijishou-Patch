package androidx.compose.ui.platform;

import android.view.ViewTreeObserver;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda2 implements ViewTreeObserver.OnTouchModeChangeListener {
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda2(AndroidComposeView androidComposeView) {
        this.f$0 = androidComposeView;
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public final void onTouchModeChanged(boolean z) {
        AndroidComposeView.touchModeChangeListener$lambda$3(this.f$0, z);
    }
}
