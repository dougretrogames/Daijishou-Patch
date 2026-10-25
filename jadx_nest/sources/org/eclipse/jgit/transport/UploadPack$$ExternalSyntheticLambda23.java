package org.eclipse.jgit.transport;

import java.util.Set;
import java.util.function.Predicate;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda23 implements Predicate {
    public final /* synthetic */ Set f$0;

    public /* synthetic */ UploadPack$$ExternalSyntheticLambda23(Set set) {
        this.f$0 = set;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.contains((ObjectId) obj);
    }
}
