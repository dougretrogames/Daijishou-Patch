package androidx.fragment.app;

import kotlin.jvm.internal.Ref;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ Ref.ObjectRef f$0;

    public /* synthetic */ DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda3(Ref.ObjectRef objectRef) {
        this.f$0 = objectRef;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$4(this.f$0);
    }
}
