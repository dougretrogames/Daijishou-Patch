package org.apache.commons.io.function;

import java.util.function.BinaryOperator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOStream$$ExternalSyntheticLambda0 implements BinaryOperator {
    public final /* synthetic */ IOBinaryOperator f$0;

    public /* synthetic */ IOStream$$ExternalSyntheticLambda0(IOBinaryOperator iOBinaryOperator) {
        this.f$0 = iOBinaryOperator;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return Erase.apply(this.f$0, obj, obj2);
    }
}
