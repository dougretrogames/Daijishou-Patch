package org.jsoup.select;

import java.util.function.Predicate;
import org.jsoup.nodes.Element;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class Evaluator$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ Evaluator f$0;
    public final /* synthetic */ Element f$1;

    public /* synthetic */ Evaluator$$ExternalSyntheticLambda1(Evaluator evaluator, Element element) {
        this.f$0 = evaluator;
        this.f$1 = element;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.m5878lambda$asPredicate$0$orgjsoupselectEvaluator(this.f$1, (Element) obj);
    }
}
