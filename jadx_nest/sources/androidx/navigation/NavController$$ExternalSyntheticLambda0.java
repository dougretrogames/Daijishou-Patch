package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class NavController$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ NavController f$0;

    public /* synthetic */ NavController$$ExternalSyntheticLambda0(NavController navController) {
        this.f$0 = navController;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        NavController.lifecycleObserver$lambda$2(this.f$0, lifecycleOwner, event);
    }
}
