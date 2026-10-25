package androidx.webkit;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class WebViewCompat$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ WebViewCompat.WebViewStartUpCallback f$0;
    public final /* synthetic */ WebViewStartUpResult f$1;

    public /* synthetic */ WebViewCompat$$ExternalSyntheticLambda1(WebViewCompat.WebViewStartUpCallback webViewStartUpCallback, WebViewStartUpResult webViewStartUpResult) {
        this.f$0 = webViewStartUpCallback;
        this.f$1 = webViewStartUpResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.onSuccess(this.f$1);
    }
}
