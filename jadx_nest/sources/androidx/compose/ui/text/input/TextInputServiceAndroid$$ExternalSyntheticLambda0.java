package androidx.compose.ui.text.input;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class TextInputServiceAndroid$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ TextInputServiceAndroid f$0;

    public /* synthetic */ TextInputServiceAndroid$$ExternalSyntheticLambda0(TextInputServiceAndroid textInputServiceAndroid) {
        this.f$0 = textInputServiceAndroid;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextInputServiceAndroid.sendInputCommand$lambda$1(this.f$0);
    }
}
