package org.apache.commons.codec.language.bm;

import java.util.function.IntPredicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class Rule$$ExternalSyntheticLambda10 implements IntPredicate {
    public final /* synthetic */ char f$0;

    public /* synthetic */ Rule$$ExternalSyntheticLambda10(char c) {
        this.f$0 = c;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        return Rule.lambda$contains$2(this.f$0, i);
    }
}
