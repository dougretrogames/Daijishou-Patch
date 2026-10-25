package org.jsoup.nodes;

import java.util.concurrent.atomic.AtomicBoolean;
import org.jsoup.select.NodeFilter;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Element$$ExternalSyntheticLambda5 implements NodeFilter {
    public final /* synthetic */ AtomicBoolean f$0;

    public /* synthetic */ Element$$ExternalSyntheticLambda5(AtomicBoolean atomicBoolean) {
        this.f$0 = atomicBoolean;
    }

    @Override // org.jsoup.select.NodeFilter
    public final NodeFilter.FilterResult head(Node node, int i) {
        return Element.lambda$hasText$1(this.f$0, node, i);
    }
}
