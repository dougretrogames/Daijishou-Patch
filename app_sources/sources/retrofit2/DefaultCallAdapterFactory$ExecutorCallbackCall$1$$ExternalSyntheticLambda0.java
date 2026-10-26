package retrofit2;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes6.dex */
public final /* synthetic */ class DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f$0;
    public final /* synthetic */ Callback f$1;
    public final /* synthetic */ Response f$2;

    public /* synthetic */ DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda0(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1, Callback callback, Response response) {
        this.f$0 = anonymousClass1;
        this.f$1 = callback;
        this.f$2 = response;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m6577xddacc936(this.f$1, this.f$2);
    }
}
