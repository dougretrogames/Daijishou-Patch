package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongPredicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IndexExtractor$$ExternalSyntheticLambda0 implements LongPredicate {
    public final /* synthetic */ LongPredicate f$0;

    public /* synthetic */ IndexExtractor$$ExternalSyntheticLambda0(LongPredicate longPredicate) {
        this.f$0 = longPredicate;
    }

    @Override // java.util.function.LongPredicate
    public final boolean test(long j) {
        return this.f$0.test(j);
    }
}
