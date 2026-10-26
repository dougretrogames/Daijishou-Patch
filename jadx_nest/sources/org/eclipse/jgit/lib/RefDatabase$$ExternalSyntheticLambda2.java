package org.eclipse.jgit.lib;

import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class RefDatabase$$ExternalSyntheticLambda2 implements Predicate {
    public final /* synthetic */ ObjectId f$0;

    public /* synthetic */ RefDatabase$$ExternalSyntheticLambda2(ObjectId objectId) {
        this.f$0 = objectId;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return RefDatabase.lambda$3(this.f$0, (Ref) obj);
    }
}
