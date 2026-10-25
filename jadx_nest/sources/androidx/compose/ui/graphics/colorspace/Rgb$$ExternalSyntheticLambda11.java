package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Rgb$$ExternalSyntheticLambda11 implements DoubleFunction {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ Rgb$$ExternalSyntheticLambda11(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        return Rgb._init_$lambda$5(this.f$0, d);
    }
}
