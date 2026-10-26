package androidx.fragment.app;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ SpecialEffectsController.Operation f$0;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect f$1;

    public /* synthetic */ DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda5(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.TransitionEffect transitionEffect) {
        this.f$0 = operation;
        this.f$1 = transitionEffect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.onCommit$lambda$11$lambda$10(this.f$0, this.f$1);
    }
}
