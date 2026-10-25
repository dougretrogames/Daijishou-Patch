package org.eclipse.jgit.transport;

import java.util.function.Predicate;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda9 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((Ref) obj).getName().startsWith(Constants.R_HEADS);
    }
}
