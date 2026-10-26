package org.apache.commons.io.function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOPredicate$$ExternalSyntheticLambda0 implements IOPredicate {
    public final /* synthetic */ IOPredicate f$0;

    public /* synthetic */ IOPredicate$$ExternalSyntheticLambda0(IOPredicate iOPredicate) {
        this.f$0 = iOPredicate;
    }

    @Override // org.apache.commons.io.function.IOPredicate
    public final boolean test(Object obj) {
        return IOPredicate.lambda$negate$3(this.f$0, obj);
    }
}
