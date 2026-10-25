package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ AbstractComposeView f$0;

    public /* synthetic */ ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0(AbstractComposeView abstractComposeView) {
        this.f$0 = abstractComposeView;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ViewCompositionStrategy_androidKt.installForLifecycle$lambda$1(this.f$0, lifecycleOwner, event);
    }
}
