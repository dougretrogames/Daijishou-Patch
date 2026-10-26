package androidx.appcompat.app;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class AppCompatDelegate$SerialExecutor$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AppCompatDelegate.SerialExecutor f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ AppCompatDelegate$SerialExecutor$$ExternalSyntheticLambda0(AppCompatDelegate.SerialExecutor serialExecutor, Runnable runnable) {
        this.f$0 = serialExecutor;
        this.f$1 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m5x45c145d(this.f$1);
    }
}
