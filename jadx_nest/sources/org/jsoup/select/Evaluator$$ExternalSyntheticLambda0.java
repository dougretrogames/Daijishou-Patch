package org.jsoup.select;

import java.util.function.Predicate;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Evaluator$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ Evaluator f$0;
    public final /* synthetic */ Element f$1;

    public /* synthetic */ Evaluator$$ExternalSyntheticLambda0(Evaluator evaluator, Element element) {
        this.f$0 = evaluator;
        this.f$1 = element;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.m5877lambda$asNodePredicate$1$orgjsoupselectEvaluator(this.f$1, (Node) obj);
    }
}
