package androidx.room;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class AutoCloser$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AutoCloser f$0;

    public /* synthetic */ AutoCloser$$ExternalSyntheticLambda0(AutoCloser autoCloser) {
        this.f$0 = autoCloser;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AutoCloser.executeAutoCloser$lambda$0(this.f$0);
    }
}
