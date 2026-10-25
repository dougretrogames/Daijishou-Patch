package androidx.compose.ui.platform;

import androidx.customview.poolingcontainer.PoolingContainerListener;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 implements PoolingContainerListener {
    public final /* synthetic */ AbstractComposeView f$0;

    public /* synthetic */ ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0(AbstractComposeView abstractComposeView) {
        this.f$0 = abstractComposeView;
    }

    @Override // androidx.customview.poolingcontainer.PoolingContainerListener
    public final void onRelease() {
        this.f$0.disposeComposition();
    }
}
