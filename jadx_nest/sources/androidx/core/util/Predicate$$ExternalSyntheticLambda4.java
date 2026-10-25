package androidx.core.util;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Predicate$$ExternalSyntheticLambda4 implements Predicate {
    public final /* synthetic */ Predicate f$0;

    public /* synthetic */ Predicate$$ExternalSyntheticLambda4(Predicate predicate) {
        this.f$0 = predicate;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return Predicate.lambda$negate$1(this.f$0, obj);
    }
}
