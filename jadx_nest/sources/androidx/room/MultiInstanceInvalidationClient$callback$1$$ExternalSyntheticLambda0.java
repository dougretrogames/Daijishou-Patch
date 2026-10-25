package androidx.room;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class MultiInstanceInvalidationClient$callback$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ MultiInstanceInvalidationClient f$0;
    public final /* synthetic */ String[] f$1;

    public /* synthetic */ MultiInstanceInvalidationClient$callback$1$$ExternalSyntheticLambda0(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        this.f$0 = multiInstanceInvalidationClient;
        this.f$1 = strArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0(this.f$0, this.f$1);
    }
}
