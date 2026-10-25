package org.apache.commons.io.comparator;

import java.io.File;
import java.util.Comparator;
import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CompositeFileComparator$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ File f$1;

    public /* synthetic */ CompositeFileComparator$$ExternalSyntheticLambda1(File file, File file2) {
        this.f$0 = file;
        this.f$1 = file2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Integer.valueOf(((Comparator) obj).compare(this.f$0, this.f$1));
    }
}
