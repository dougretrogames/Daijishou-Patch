package org.eclipse.jgit.util;

import java.util.function.BinaryOperator;
import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class RefList$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ BinaryOperator f$0;

    public /* synthetic */ RefList$$ExternalSyntheticLambda3(BinaryOperator binaryOperator) {
        this.f$0 = binaryOperator;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return RefList.lambda$3(this.f$0, (RefList.Builder) obj);
    }
}
