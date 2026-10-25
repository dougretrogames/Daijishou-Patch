package org.apache.commons.io.output;

import java.io.Writer;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilterCollectionWriter$$ExternalSyntheticLambda10 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return Objects.nonNull((Writer) obj);
    }
}
