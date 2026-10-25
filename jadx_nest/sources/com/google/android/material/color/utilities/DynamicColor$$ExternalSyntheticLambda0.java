package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DynamicColor$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ TonalPalette f$0;

    public /* synthetic */ DynamicColor$$ExternalSyntheticLambda0(TonalPalette tonalPalette) {
        this.f$0 = tonalPalette;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return DynamicColor.lambda$fromArgb$0(this.f$0, (DynamicScheme) obj);
    }
}
