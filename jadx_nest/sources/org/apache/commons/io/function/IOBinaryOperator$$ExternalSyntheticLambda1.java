package org.apache.commons.io.function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOBinaryOperator$$ExternalSyntheticLambda1 implements IOBinaryOperator {
    public final /* synthetic */ IOComparator f$0;

    public /* synthetic */ IOBinaryOperator$$ExternalSyntheticLambda1(IOComparator iOComparator) {
        this.f$0 = iOComparator;
    }

    @Override // org.apache.commons.io.function.IOBiFunction
    public final Object apply(Object obj, Object obj2) {
        return IOBinaryOperator.lambda$maxBy$0(this.f$0, obj, obj2);
    }
}
