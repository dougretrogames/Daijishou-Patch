package org.eclipse.jgit.lib;

import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class RefDatabase$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ RefDatabase$$ExternalSyntheticLambda3(String str) {
        this.f$0 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return RefDatabase.lambda$2(this.f$0, (Ref) obj);
    }
}
