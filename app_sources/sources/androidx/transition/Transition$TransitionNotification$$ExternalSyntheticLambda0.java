package androidx.transition;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class Transition$TransitionNotification$$ExternalSyntheticLambda0 implements Transition.TransitionNotification {
    @Override // androidx.transition.Transition.TransitionNotification
    public final void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionStart(transition, z);
    }
}
