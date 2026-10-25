package org.eclipse.jgit.transport;

import java.util.function.Predicate;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda12 implements Predicate {
    public final /* synthetic */ Predicate f$0;
    public final /* synthetic */ Predicate f$1;

    public /* synthetic */ UploadPack$$ExternalSyntheticLambda12(Predicate predicate, Predicate predicate2) {
        this.f$0 = predicate;
        this.f$1 = predicate2;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return UploadPack.lambda$25(this.f$0, this.f$1, (Ref) obj);
    }
}
