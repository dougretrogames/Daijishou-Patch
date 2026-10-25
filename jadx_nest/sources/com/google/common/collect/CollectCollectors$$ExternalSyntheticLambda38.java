package com.google.common.collect;

import java.util.TreeMap;
import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda38 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ImmutableSortedMap.copyOfSorted((TreeMap) obj);
    }
}
