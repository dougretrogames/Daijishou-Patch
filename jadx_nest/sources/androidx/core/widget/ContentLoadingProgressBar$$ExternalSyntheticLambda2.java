package androidx.core.widget;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ContentLoadingProgressBar$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar f$0;

    public /* synthetic */ ContentLoadingProgressBar$$ExternalSyntheticLambda2(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f$0 = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.showOnUiThread();
    }
}
