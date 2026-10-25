package androidx.compose.ui.graphics;

import java.util.function.DoubleUnaryOperator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpaceVerificationHelper$$ExternalSyntheticLambda0 implements DoubleUnaryOperator {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ColorSpaceVerificationHelper$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // java.util.function.DoubleUnaryOperator
    public final double applyAsDouble(double d) {
        return ColorSpaceVerificationHelper.androidColorSpace$lambda$0(this.f$0, d);
    }
}
