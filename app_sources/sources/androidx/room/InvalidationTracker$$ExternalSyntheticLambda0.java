package androidx.room;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class InvalidationTracker$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ InvalidationTracker f$0;

    public /* synthetic */ InvalidationTracker$$ExternalSyntheticLambda0(InvalidationTracker invalidationTracker) {
        this.f$0 = invalidationTracker;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.onAutoCloseCallback();
    }
}
