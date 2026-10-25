package androidx.transition;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Transition$TransitionNotification$$ExternalSyntheticLambda4 implements Transition.TransitionNotification {
    @Override // androidx.transition.Transition.TransitionNotification
    public final void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionResume(transition);
    }
}
