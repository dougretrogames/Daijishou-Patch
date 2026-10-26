package androidx.lifecycle;

import kotlinx.coroutines.channels.ProducerScope;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class FlowLiveDataConversions$asFlow$1$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ ProducerScope f$0;

    public /* synthetic */ FlowLiveDataConversions$asFlow$1$$ExternalSyntheticLambda0(ProducerScope producerScope) {
        this.f$0 = producerScope;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f$0.mo5255trySendJP2dKIU(obj);
    }
}
