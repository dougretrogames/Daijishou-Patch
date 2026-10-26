package retrofit2;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes6.dex */
public final /* synthetic */ class DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f$0;
    public final /* synthetic */ Callback f$1;
    public final /* synthetic */ Throwable f$2;

    public /* synthetic */ DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda1(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1, Callback callback, Throwable th) {
        this.f$0 = anonymousClass1;
        this.f$1 = callback;
        this.f$2 = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m6576x714e864(this.f$1, this.f$2);
    }
}
