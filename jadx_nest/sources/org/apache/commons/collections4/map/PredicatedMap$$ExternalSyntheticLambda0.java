package org.apache.commons.collections4.map;

import java.util.function.BiConsumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PredicatedMap$$ExternalSyntheticLambda0 implements BiConsumer {
    public final /* synthetic */ PredicatedMap f$0;

    public /* synthetic */ PredicatedMap$$ExternalSyntheticLambda0(PredicatedMap predicatedMap) {
        this.f$0 = predicatedMap;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        this.f$0.validate(obj, obj2);
    }
}
