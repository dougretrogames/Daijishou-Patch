package org.apache.commons.io.filefilter;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class NameFileFilter$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ NameFileFilter f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ NameFileFilter$$ExternalSyntheticLambda0(NameFileFilter nameFileFilter, String str) {
        this.f$0 = nameFileFilter;
        this.f$1 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.m5578xeb0d6bf5(this.f$1, (String) obj);
    }
}
