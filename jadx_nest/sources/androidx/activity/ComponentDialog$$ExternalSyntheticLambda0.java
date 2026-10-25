package androidx.activity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentDialog$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ComponentDialog f$0;

    public /* synthetic */ ComponentDialog$$ExternalSyntheticLambda0(ComponentDialog componentDialog) {
        this.f$0 = componentDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentDialog.onBackPressedDispatcher$lambda$1(this.f$0);
    }
}
