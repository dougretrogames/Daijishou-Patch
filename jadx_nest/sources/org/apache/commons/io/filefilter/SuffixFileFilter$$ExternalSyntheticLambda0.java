package org.apache.commons.io.filefilter;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SuffixFileFilter$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ SuffixFileFilter f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ SuffixFileFilter$$ExternalSyntheticLambda0(SuffixFileFilter suffixFileFilter, String str) {
        this.f$0 = suffixFileFilter;
        this.f$1 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.m5582xab06a59f(this.f$1, (String) obj);
    }
}
