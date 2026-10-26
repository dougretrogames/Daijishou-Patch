package org.jsoup.internal;

import java.io.IOException;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class QuietAppendable$BaseAppendable$$ExternalSyntheticLambda1 implements QuietAppendable.BaseAppendable.Action {
    public final /* synthetic */ QuietAppendable.BaseAppendable f$0;
    public final /* synthetic */ char[] f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ QuietAppendable$BaseAppendable$$ExternalSyntheticLambda1(QuietAppendable.BaseAppendable baseAppendable, char[] cArr, int i, int i2) {
        this.f$0 = baseAppendable;
        this.f$1 = cArr;
        this.f$2 = i;
        this.f$3 = i2;
    }

    @Override // org.jsoup.internal.QuietAppendable.BaseAppendable.Action
    public final void append() throws IOException {
        this.f$0.m5869xf98f54bd(this.f$1, this.f$2, this.f$3);
    }
}
