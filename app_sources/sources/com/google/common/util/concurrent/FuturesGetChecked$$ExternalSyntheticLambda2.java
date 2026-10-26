package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import java.util.Arrays;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class FuturesGetChecked$$ExternalSyntheticLambda2 implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return Arrays.asList(((Constructor) obj).getParameterTypes());
    }
}
