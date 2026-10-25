package org.jsoup.nodes;

import org.jsoup.select.NodeVisitor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Element$$ExternalSyntheticLambda3 implements NodeVisitor {
    public final /* synthetic */ StringBuilder f$0;

    public /* synthetic */ Element$$ExternalSyntheticLambda3(StringBuilder sb) {
        this.f$0 = sb;
    }

    @Override // org.jsoup.select.NodeVisitor
    public final void head(Node node, int i) {
        Element.lambda$data$2(this.f$0, node, i);
    }
}
