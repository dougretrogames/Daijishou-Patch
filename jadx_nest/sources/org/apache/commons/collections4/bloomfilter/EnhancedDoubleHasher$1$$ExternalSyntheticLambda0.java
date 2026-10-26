package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class EnhancedDoubleHasher$1$$ExternalSyntheticLambda0 implements IntPredicate {
    public final /* synthetic */ int[] f$0;
    public final /* synthetic */ int[] f$1;

    public /* synthetic */ EnhancedDoubleHasher$1$$ExternalSyntheticLambda0(int[] iArr, int[] iArr2) {
        this.f$0 = iArr;
        this.f$1 = iArr2;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        return EnhancedDoubleHasher.AnonymousClass1.lambda$asIndexArray$0(this.f$0, this.f$1, i);
    }
}
