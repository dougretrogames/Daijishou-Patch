package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class FilteredEntryMultimap$Keys$1$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ Predicate f$0;

    public /* synthetic */ FilteredEntryMultimap$Keys$1$$ExternalSyntheticLambda0(Predicate predicate) {
        this.f$0 = predicate;
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        return this.f$0.apply(Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size()));
    }
}
