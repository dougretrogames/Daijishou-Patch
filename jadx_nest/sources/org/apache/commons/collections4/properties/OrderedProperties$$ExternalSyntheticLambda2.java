package org.apache.commons.collections4.properties;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class OrderedProperties$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ OrderedProperties f$0;
    public final /* synthetic */ BiConsumer f$1;

    public /* synthetic */ OrderedProperties$$ExternalSyntheticLambda2(OrderedProperties orderedProperties, BiConsumer biConsumer) {
        this.f$0 = orderedProperties;
        this.f$1 = biConsumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.m5546x46362603(this.f$1, obj);
    }
}
