package org.eclipse.jgit.transport;

import java.util.Objects;
import java.util.function.Predicate;
import org.eclipse.jgit.revwalk.RevCommit;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda8 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return Objects.nonNull((RevCommit) obj);
    }
}
