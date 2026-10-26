package androidx.transition;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class Transition$TransitionNotification$$ExternalSyntheticLambda2 implements Transition.TransitionNotification {
    @Override // androidx.transition.Transition.TransitionNotification
    public final void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionCancel(transition);
    }
}
