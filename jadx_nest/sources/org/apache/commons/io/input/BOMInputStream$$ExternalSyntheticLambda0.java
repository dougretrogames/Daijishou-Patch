package org.apache.commons.io.input;

import java.util.function.Predicate;
import org.apache.commons.io.ByteOrderMark;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class BOMInputStream$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ BOMInputStream f$0;

    public /* synthetic */ BOMInputStream$$ExternalSyntheticLambda0(BOMInputStream bOMInputStream) {
        this.f$0 = bOMInputStream;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.matches((ByteOrderMark) obj);
    }
}
