package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class OrFileFilter$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ File f$0;

    public /* synthetic */ OrFileFilter$$ExternalSyntheticLambda0(File file) {
        this.f$0 = file;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((IOFileFilter) obj).accept(this.f$0);
    }
}
