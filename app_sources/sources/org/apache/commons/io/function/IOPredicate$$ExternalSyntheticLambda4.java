package org.apache.commons.io.function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOPredicate$$ExternalSyntheticLambda4 implements IOPredicate {
    public final /* synthetic */ IOPredicate f$0;
    public final /* synthetic */ IOPredicate f$1;

    public /* synthetic */ IOPredicate$$ExternalSyntheticLambda4(IOPredicate iOPredicate, IOPredicate iOPredicate2) {
        this.f$0 = iOPredicate;
        this.f$1 = iOPredicate2;
    }

    @Override // org.apache.commons.io.function.IOPredicate
    public final boolean test(Object obj) {
        return IOPredicate.lambda$and$1(this.f$0, this.f$1, obj);
    }
}
