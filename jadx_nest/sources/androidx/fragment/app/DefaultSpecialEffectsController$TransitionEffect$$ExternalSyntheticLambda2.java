package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ ArrayList f$0;

    public /* synthetic */ DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda2(ArrayList arrayList) {
        this.f$0 = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$14(this.f$0);
    }
}
