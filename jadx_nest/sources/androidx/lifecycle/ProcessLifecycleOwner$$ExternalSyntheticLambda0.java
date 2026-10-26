package androidx.lifecycle;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class ProcessLifecycleOwner$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ProcessLifecycleOwner f$0;

    public /* synthetic */ ProcessLifecycleOwner$$ExternalSyntheticLambda0(ProcessLifecycleOwner processLifecycleOwner) {
        this.f$0 = processLifecycleOwner;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProcessLifecycleOwner.delayedPauseRunnable$lambda$0(this.f$0);
    }
}
