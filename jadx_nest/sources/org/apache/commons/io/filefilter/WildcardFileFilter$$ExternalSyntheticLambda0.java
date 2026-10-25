package org.apache.commons.io.filefilter;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class WildcardFileFilter$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ WildcardFileFilter f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ WildcardFileFilter$$ExternalSyntheticLambda0(WildcardFileFilter wildcardFileFilter, String str) {
        this.f$0 = wildcardFileFilter;
        this.f$1 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.m5583xf9a09e68(this.f$1, (String) obj);
    }
}
