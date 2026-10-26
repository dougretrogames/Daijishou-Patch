package androidx.core.widget;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class ContentLoadingProgressBar$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar f$0;

    public /* synthetic */ ContentLoadingProgressBar$$ExternalSyntheticLambda3(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f$0 = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.hideOnUiThread();
    }
}
