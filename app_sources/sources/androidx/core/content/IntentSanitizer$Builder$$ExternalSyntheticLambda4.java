package androidx.core.content;

import androidx.core.util.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class IntentSanitizer$Builder$$ExternalSyntheticLambda4 implements Predicate {
    public final /* synthetic */ Class f$0;
    public final /* synthetic */ Predicate f$1;

    public /* synthetic */ IntentSanitizer$Builder$$ExternalSyntheticLambda4(Class cls, Predicate predicate) {
        this.f$0 = cls;
        this.f$1 = predicate;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return IntentSanitizer.Builder.lambda$allowExtra$13(this.f$0, this.f$1, obj);
    }
}
