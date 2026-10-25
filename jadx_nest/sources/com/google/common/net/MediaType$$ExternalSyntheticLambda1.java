package com.google.common.net;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultiset;
import java.util.Collection;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class MediaType$$ExternalSyntheticLambda1 implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return ImmutableMultiset.copyOf((Collection) obj);
    }
}
