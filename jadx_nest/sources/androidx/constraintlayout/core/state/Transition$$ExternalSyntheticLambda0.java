package androidx.constraintlayout.core.state;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Transition$$ExternalSyntheticLambda0 implements Interpolator {
    public final /* synthetic */ String f$0;

    public /* synthetic */ Transition$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public final float getInterpolation(float f) {
        return Transition.lambda$getInterpolator$0(this.f$0, f);
    }
}
