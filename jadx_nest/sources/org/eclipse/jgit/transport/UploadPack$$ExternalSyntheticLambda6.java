package org.eclipse.jgit.transport;

import java.util.Objects;
import java.util.function.Predicate;
import org.eclipse.jgit.revwalk.RevObject;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda6 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return Objects.nonNull((RevObject) obj);
    }
}
