package org.apache.commons.collections4.bag;

import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class AbstractMapBag$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ AbstractMapBag f$0;

    public /* synthetic */ AbstractMapBag$$ExternalSyntheticLambda0(AbstractMapBag abstractMapBag) {
        this.f$0 = abstractMapBag;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.add(obj);
    }
}
