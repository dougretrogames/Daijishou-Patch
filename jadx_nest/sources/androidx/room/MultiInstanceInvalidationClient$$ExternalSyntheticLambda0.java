package androidx.room;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class MultiInstanceInvalidationClient$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ MultiInstanceInvalidationClient f$0;

    public /* synthetic */ MultiInstanceInvalidationClient$$ExternalSyntheticLambda0(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.f$0 = multiInstanceInvalidationClient;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MultiInstanceInvalidationClient.setUpRunnable$lambda$1(this.f$0);
    }
}
