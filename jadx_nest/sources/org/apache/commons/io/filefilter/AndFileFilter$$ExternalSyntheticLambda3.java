package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class AndFileFilter$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ AndFileFilter$$ExternalSyntheticLambda3(File file, String str) {
        this.f$0 = file;
        this.f$1 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((IOFileFilter) obj).accept(this.f$0, this.f$1);
    }
}
