package org.apache.commons.io.function;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOStream$$ExternalSyntheticLambda16 implements Predicate {
    public final /* synthetic */ IOPredicate f$0;

    public /* synthetic */ IOStream$$ExternalSyntheticLambda16(IOPredicate iOPredicate) {
        this.f$0 = iOPredicate;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return Erase.test(this.f$0, obj);
    }
}
