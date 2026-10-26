package androidx.fragment.app;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultSpecialEffectsController$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController f$0;
    public final /* synthetic */ SpecialEffectsController.Operation f$1;

    public /* synthetic */ DefaultSpecialEffectsController$$ExternalSyntheticLambda0(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController.Operation operation) {
        this.f$0 = defaultSpecialEffectsController;
        this.f$1 = operation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultSpecialEffectsController.collectEffects$lambda$2(this.f$0, this.f$1);
    }
}
