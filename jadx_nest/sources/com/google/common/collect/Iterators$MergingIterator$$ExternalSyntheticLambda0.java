package com.google.common.collect;

import java.util.Comparator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Iterators$MergingIterator$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ Comparator f$0;

    public /* synthetic */ Iterators$MergingIterator$$ExternalSyntheticLambda0(Comparator comparator) {
        this.f$0 = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f$0.compare(((PeekingIterator) obj).peek(), ((PeekingIterator) obj2).peek());
    }
}
