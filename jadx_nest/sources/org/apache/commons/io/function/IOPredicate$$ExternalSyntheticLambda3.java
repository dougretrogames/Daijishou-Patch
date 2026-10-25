package org.apache.commons.io.function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOPredicate$$ExternalSyntheticLambda3 implements IOPredicate {
    public final /* synthetic */ IOPredicate f$0;
    public final /* synthetic */ IOPredicate f$1;

    public /* synthetic */ IOPredicate$$ExternalSyntheticLambda3(IOPredicate iOPredicate, IOPredicate iOPredicate2) {
        this.f$0 = iOPredicate;
        this.f$1 = iOPredicate2;
    }

    @Override // org.apache.commons.io.function.IOPredicate
    public final boolean test(Object obj) {
        return IOPredicate.lambda$or$4(this.f$0, this.f$1, obj);
    }
}
