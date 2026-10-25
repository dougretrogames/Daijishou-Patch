package org.apache.commons.collections4;

import java.util.Set;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SetUtils$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ Set f$0;

    public /* synthetic */ SetUtils$$ExternalSyntheticLambda0(Set set) {
        this.f$0 = set;
    }

    @Override // org.apache.commons.collections4.Predicate
    public final boolean evaluate(Object obj) {
        return SetUtils.lambda$difference$0(this.f$0, obj);
    }
}
