package org.apache.commons.collections4.bag;

import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class CollectionBag$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ CollectionBag f$0;

    public /* synthetic */ CollectionBag$$ExternalSyntheticLambda0(CollectionBag collectionBag) {
        this.f$0 = collectionBag;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.contains(obj);
    }
}
