package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ExtendedIterator$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ java.util.function.Predicate f$0;

    public /* synthetic */ ExtendedIterator$$ExternalSyntheticLambda1(java.util.function.Predicate predicate) {
        this.f$0 = predicate;
    }

    @Override // org.apache.commons.collections4.Predicate
    public final boolean evaluate(Object obj) {
        return this.f$0.test(obj);
    }
}
