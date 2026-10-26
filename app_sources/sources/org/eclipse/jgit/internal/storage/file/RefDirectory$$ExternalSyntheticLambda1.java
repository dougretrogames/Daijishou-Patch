package org.eclipse.jgit.internal.storage.file;

import java.util.function.Predicate;
import org.eclipse.jgit.lib.Ref;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class RefDirectory$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ String[] f$0;

    public /* synthetic */ RefDirectory$$ExternalSyntheticLambda1(String[] strArr) {
        this.f$0 = strArr;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return RefDirectory.lambda$0(this.f$0, (Ref) obj);
    }
}
