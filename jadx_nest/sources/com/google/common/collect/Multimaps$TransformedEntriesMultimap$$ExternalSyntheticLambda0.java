package com.google.common.collect;

import java.util.Collection;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class Multimaps$TransformedEntriesMultimap$$ExternalSyntheticLambda0 implements Maps.EntryTransformer {
    public final /* synthetic */ Multimaps.TransformedEntriesMultimap f$0;

    public /* synthetic */ Multimaps$TransformedEntriesMultimap$$ExternalSyntheticLambda0(Multimaps.TransformedEntriesMultimap transformedEntriesMultimap) {
        this.f$0 = transformedEntriesMultimap;
    }

    @Override // com.google.common.collect.Maps.EntryTransformer
    public final Object transformEntry(Object obj, Object obj2) {
        return this.f$0.m3351x893217c0(obj, (Collection) obj2);
    }
}
