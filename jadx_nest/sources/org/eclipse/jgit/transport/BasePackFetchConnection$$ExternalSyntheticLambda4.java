package org.eclipse.jgit.transport;

import java.util.Objects;
import java.util.function.Predicate;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class BasePackFetchConnection$$ExternalSyntheticLambda4 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return Objects.nonNull((ObjectId) obj);
    }
}
