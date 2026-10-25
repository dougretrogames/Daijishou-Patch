package org.apache.commons.collections4.bloomfilter;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class LayerManager$ExtendCheck$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ double f$0;

    public /* synthetic */ LayerManager$ExtendCheck$$ExternalSyntheticLambda0(double d) {
        this.f$0 = d;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return LayerManager.ExtendCheck.lambda$advanceOnSaturation$1(this.f$0, (LayerManager) obj);
    }
}
