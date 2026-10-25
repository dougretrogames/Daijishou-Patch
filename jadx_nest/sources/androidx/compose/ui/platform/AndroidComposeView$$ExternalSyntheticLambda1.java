package androidx.compose.ui.platform;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda1 implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda1(AndroidComposeView androidComposeView) {
        this.f$0 = androidComposeView;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        this.f$0.updatePositionCacheAndDispatch();
    }
}
