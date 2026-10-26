package org.apache.commons.collections4.collection;

import java.util.Collection;
import java.util.function.Consumer;
import org.apache.commons.collections4.iterators.IteratorChain;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class CompositeCollection$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ IteratorChain f$0;

    public /* synthetic */ CompositeCollection$$ExternalSyntheticLambda0(IteratorChain iteratorChain) {
        this.f$0 = iteratorChain;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.addIterator(((Collection) obj).iterator());
    }
}
