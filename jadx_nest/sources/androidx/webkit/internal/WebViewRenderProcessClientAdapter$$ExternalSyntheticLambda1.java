package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class WebViewRenderProcessClientAdapter$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ WebViewRenderProcessClient f$0;
    public final /* synthetic */ WebView f$1;
    public final /* synthetic */ WebViewRenderProcess f$2;

    public /* synthetic */ WebViewRenderProcessClientAdapter$$ExternalSyntheticLambda1(WebViewRenderProcessClient webViewRenderProcessClient, WebView webView, WebViewRenderProcess webViewRenderProcess) {
        this.f$0 = webViewRenderProcessClient;
        this.f$1 = webView;
        this.f$2 = webViewRenderProcess;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.onRenderProcessUnresponsive(this.f$1, this.f$2);
    }
}
