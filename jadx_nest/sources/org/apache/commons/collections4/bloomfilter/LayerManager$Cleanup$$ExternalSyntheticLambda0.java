package org.apache.commons.collections4.bloomfilter;

import java.util.Deque;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class LayerManager$Cleanup$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Predicate f$0;

    public /* synthetic */ LayerManager$Cleanup$$ExternalSyntheticLambda0(Predicate predicate) {
        this.f$0 = predicate;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((Deque) obj).removeIf(this.f$0);
    }
}
