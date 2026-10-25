package org.jsoup.select;

import java.util.HashSet;
import java.util.function.Predicate;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Selector$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ HashSet f$0;

    public /* synthetic */ Selector$$ExternalSyntheticLambda0(HashSet hashSet) {
        this.f$0 = hashSet;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.add((Element) obj);
    }
}
