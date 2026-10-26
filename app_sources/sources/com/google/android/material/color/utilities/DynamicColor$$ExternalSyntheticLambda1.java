package com.google.android.material.color.utilities;

import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class DynamicColor$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ Hct f$0;

    public /* synthetic */ DynamicColor$$ExternalSyntheticLambda1(Hct hct) {
        this.f$0 = hct;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Double.valueOf(this.f$0.getTone());
    }
}
