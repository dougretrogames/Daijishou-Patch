package androidx.activity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda0(ComponentActivity componentActivity) {
        this.f$0 = componentActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.invalidateMenu();
    }
}
