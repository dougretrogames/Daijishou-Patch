package org.jsoup.nodes;

import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Element$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ Class f$0;

    public /* synthetic */ Element$$ExternalSyntheticLambda1(Class cls) {
        this.f$0 = cls;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f$0.cast((Node) obj);
    }
}
