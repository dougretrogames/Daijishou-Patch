package org.apache.commons.io.function;

import java.util.function.UnaryOperator;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOUnaryOperator$$ExternalSyntheticLambda0 implements UnaryOperator {
    public final /* synthetic */ IOUnaryOperator f$0;

    public /* synthetic */ IOUnaryOperator$$ExternalSyntheticLambda0(IOUnaryOperator iOUnaryOperator) {
        this.f$0 = iOUnaryOperator;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Uncheck.apply(this.f$0, obj);
    }
}
