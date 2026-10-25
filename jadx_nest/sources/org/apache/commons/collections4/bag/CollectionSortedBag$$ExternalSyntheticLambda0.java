package org.apache.commons.collections4.bag;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CollectionSortedBag$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ CollectionSortedBag f$0;

    public /* synthetic */ CollectionSortedBag$$ExternalSyntheticLambda0(CollectionSortedBag collectionSortedBag) {
        this.f$0 = collectionSortedBag;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.contains(obj);
    }
}
