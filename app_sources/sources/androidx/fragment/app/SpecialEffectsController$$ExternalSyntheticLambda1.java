package androidx.fragment.app;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class SpecialEffectsController$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ SpecialEffectsController f$0;
    public final /* synthetic */ SpecialEffectsController.FragmentStateManagerOperation f$1;

    public /* synthetic */ SpecialEffectsController$$ExternalSyntheticLambda1(SpecialEffectsController specialEffectsController, SpecialEffectsController.FragmentStateManagerOperation fragmentStateManagerOperation) {
        this.f$0 = specialEffectsController;
        this.f$1 = fragmentStateManagerOperation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpecialEffectsController.enqueue$lambda$4$lambda$3(this.f$0, this.f$1);
    }
}
