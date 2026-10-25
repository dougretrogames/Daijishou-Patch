package com.google.common.escape;

import com.google.common.base.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Escaper$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Escaper f$0;

    public /* synthetic */ Escaper$$ExternalSyntheticLambda0(Escaper escaper) {
        this.f$0 = escaper;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return this.f$0.escape((String) obj);
    }
}
