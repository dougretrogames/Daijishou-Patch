package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpaceVerificationHelper$$ExternalSyntheticLambda3 implements DoubleFunction {
    public final /* synthetic */ ColorSpace f$0;

    public /* synthetic */ ColorSpaceVerificationHelper$$ExternalSyntheticLambda3(ColorSpace colorSpace) {
        this.f$0 = colorSpace;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        return ColorSpaceVerificationHelper.composeColorSpace$lambda$3(this.f$0, d);
    }
}
