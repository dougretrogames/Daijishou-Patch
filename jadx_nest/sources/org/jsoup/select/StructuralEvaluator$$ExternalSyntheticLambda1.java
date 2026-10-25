package org.jsoup.select;

import java.util.function.Function;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class StructuralEvaluator$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ StructuralEvaluator f$0;
    public final /* synthetic */ Element f$1;

    public /* synthetic */ StructuralEvaluator$$ExternalSyntheticLambda1(StructuralEvaluator structuralEvaluator, Element element) {
        this.f$0 = structuralEvaluator;
        this.f$1 = element;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f$0.m5879lambda$memoMatches$0$orgjsoupselectStructuralEvaluator(this.f$1, (Node) obj);
    }
}
