package androidx.lifecycle;

import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LifecycleKt$eventFlow$1$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ ProducerScope f$0;

    public /* synthetic */ LifecycleKt$eventFlow$1$$ExternalSyntheticLambda0(ProducerScope producerScope) {
        this.f$0 = producerScope;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f$0.mo5255trySendJP2dKIU(event);
    }
}
