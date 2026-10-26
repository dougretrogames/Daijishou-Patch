package org.jsoup.internal;

import java.io.IOException;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class QuietAppendable$BaseAppendable$$ExternalSyntheticLambda0 implements QuietAppendable.BaseAppendable.Action {
    public final /* synthetic */ QuietAppendable.BaseAppendable f$0;
    public final /* synthetic */ char f$1;

    public /* synthetic */ QuietAppendable$BaseAppendable$$ExternalSyntheticLambda0(QuietAppendable.BaseAppendable baseAppendable, char c) {
        this.f$0 = baseAppendable;
        this.f$1 = c;
    }

    @Override // org.jsoup.internal.QuietAppendable.BaseAppendable.Action
    public final void append() throws IOException {
        this.f$0.m5868xb60436fc(this.f$1);
    }
}
