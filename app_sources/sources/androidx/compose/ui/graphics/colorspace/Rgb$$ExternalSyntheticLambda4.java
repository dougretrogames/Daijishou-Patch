package androidx.compose.ui.graphics.colorspace;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class Rgb$$ExternalSyntheticLambda4 implements DoubleFunction {
    public final /* synthetic */ Rgb f$0;

    public /* synthetic */ Rgb$$ExternalSyntheticLambda4(Rgb rgb) {
        this.f$0 = rgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        return Rgb.eotfFunc$lambda$1(this.f$0, d);
    }
}
