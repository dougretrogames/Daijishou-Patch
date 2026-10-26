package org.apache.commons.io.filefilter;

import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PrefixFileFilter$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ PrefixFileFilter f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ PrefixFileFilter$$ExternalSyntheticLambda0(PrefixFileFilter prefixFileFilter, String str) {
        this.f$0 = prefixFileFilter;
        this.f$1 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.m5580x16e103a0(this.f$1, (String) obj);
    }
}
