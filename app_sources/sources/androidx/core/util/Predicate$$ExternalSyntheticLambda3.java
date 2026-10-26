package androidx.core.util;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class Predicate$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ Predicate f$0;
    public final /* synthetic */ Predicate f$1;

    public /* synthetic */ Predicate$$ExternalSyntheticLambda3(Predicate predicate, Predicate predicate2) {
        this.f$0 = predicate;
        this.f$1 = predicate2;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return Predicate.lambda$and$0(this.f$0, this.f$1, obj);
    }
}
