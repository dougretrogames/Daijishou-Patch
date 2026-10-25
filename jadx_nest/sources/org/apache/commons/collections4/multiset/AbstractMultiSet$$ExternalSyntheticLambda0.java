package org.apache.commons.collections4.multiset;

import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class AbstractMultiSet$$ExternalSyntheticLambda0 implements Transformer {
    @Override // org.apache.commons.collections4.Transformer
    public final Object transform(Object obj) {
        return ((MultiSet.Entry) obj).getElement();
    }
}
