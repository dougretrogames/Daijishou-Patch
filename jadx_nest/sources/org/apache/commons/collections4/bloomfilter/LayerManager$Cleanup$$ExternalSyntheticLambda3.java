package org.apache.commons.collections4.bloomfilter;

import java.util.Deque;
import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class LayerManager$Cleanup$$ExternalSyntheticLambda3 implements Consumer {
    public final /* synthetic */ int f$0;

    public /* synthetic */ LayerManager$Cleanup$$ExternalSyntheticLambda3(int i) {
        this.f$0 = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        LayerManager.Cleanup.lambda$onMaxSize$1(this.f$0, (Deque) obj);
    }
}
