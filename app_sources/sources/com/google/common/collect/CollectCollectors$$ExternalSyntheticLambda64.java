package com.google.common.collect;

import java.util.Collection;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda64 implements Consumer {
    public final /* synthetic */ Collection f$0;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda64(Collection collection) {
        this.f$0 = collection;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.add(obj);
    }
}
