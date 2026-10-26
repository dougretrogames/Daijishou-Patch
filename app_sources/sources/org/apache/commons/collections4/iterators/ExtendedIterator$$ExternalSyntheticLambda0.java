package org.apache.commons.collections4.iterators;

import java.util.function.Function;
import org.apache.commons.collections4.Transformer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class ExtendedIterator$$ExternalSyntheticLambda0 implements Transformer {
    public final /* synthetic */ Function f$0;

    public /* synthetic */ ExtendedIterator$$ExternalSyntheticLambda0(Function function) {
        this.f$0 = function;
    }

    @Override // org.apache.commons.collections4.Transformer
    public final Object transform(Object obj) {
        return this.f$0.apply(obj);
    }
}
