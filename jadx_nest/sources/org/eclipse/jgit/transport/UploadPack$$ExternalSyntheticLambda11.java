package org.eclipse.jgit.transport;

import java.util.Collection;
import java.util.function.Predicate;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda11 implements Predicate {
    public final /* synthetic */ Collection f$0;

    public /* synthetic */ UploadPack$$ExternalSyntheticLambda11(Collection collection) {
        this.f$0 = collection;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return UploadPack.lambda$3(this.f$0, (Ref) obj);
    }
}
