package androidx.compose.ui.graphics.colorspace;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Rgb$$ExternalSyntheticLambda0 implements DoubleFunction {
    public final /* synthetic */ Rgb f$0;

    public /* synthetic */ Rgb$$ExternalSyntheticLambda0(Rgb rgb) {
        this.f$0 = rgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        return Rgb.oetfFunc$lambda$0(this.f$0, d);
    }
}
