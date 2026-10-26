package org.apache.commons.io.function;

import java.util.function.BinaryOperator;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOBinaryOperator$$ExternalSyntheticLambda0 implements BinaryOperator {
    public final /* synthetic */ IOBinaryOperator f$0;

    public /* synthetic */ IOBinaryOperator$$ExternalSyntheticLambda0(IOBinaryOperator iOBinaryOperator) {
        this.f$0 = iOBinaryOperator;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return Uncheck.apply(this.f$0, obj, obj2);
    }
}
