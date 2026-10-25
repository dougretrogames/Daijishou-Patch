package org.apache.commons.collections4.map;

import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class AbstractReferenceMap$ReferenceKeySet$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ List f$0;

    public /* synthetic */ AbstractReferenceMap$ReferenceKeySet$$ExternalSyntheticLambda0(List list) {
        this.f$0 = list;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.add(obj);
    }
}
