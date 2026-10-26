package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.util.List;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class FuturesGetChecked$$ExternalSyntheticLambda1 implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return Boolean.valueOf(((List) obj).contains(Throwable.class));
    }
}
