package androidx.webkit;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class WebViewCompat$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ WebViewCompat.WebViewStartUpCallback f$0;

    public /* synthetic */ WebViewCompat$$ExternalSyntheticLambda3(WebViewCompat.WebViewStartUpCallback webViewStartUpCallback) {
        this.f$0 = webViewStartUpCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.onSuccess(new WebViewCompat.NullReturningWebViewStartUpResult(null));
    }
}
