package androidx.savedstate;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SavedStateRegistry$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ SavedStateRegistry f$0;

    public /* synthetic */ SavedStateRegistry$$ExternalSyntheticLambda0(SavedStateRegistry savedStateRegistry) {
        this.f$0 = savedStateRegistry;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistry.performAttach$lambda$4(this.f$0, lifecycleOwner, event);
    }
}
