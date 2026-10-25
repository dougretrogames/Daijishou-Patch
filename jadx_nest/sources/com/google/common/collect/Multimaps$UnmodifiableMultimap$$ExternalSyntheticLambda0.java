package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Multimaps$UnmodifiableMultimap$$ExternalSyntheticLambda0 implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return Multimaps.unmodifiableValueCollection((Collection) obj);
    }
}
