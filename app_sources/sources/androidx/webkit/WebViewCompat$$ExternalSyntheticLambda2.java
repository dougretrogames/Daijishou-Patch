package androidx.webkit;

import android.os.Handler;
import android.os.Looper;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class WebViewCompat$$ExternalSyntheticLambda2 implements WebViewCompat.WebViewStartUpCallback {
    public final /* synthetic */ WebViewCompat.WebViewStartUpCallback f$0;

    public /* synthetic */ WebViewCompat$$ExternalSyntheticLambda2(WebViewCompat.WebViewStartUpCallback webViewStartUpCallback) {
        this.f$0 = webViewStartUpCallback;
    }

    @Override // androidx.webkit.WebViewCompat.WebViewStartUpCallback
    public final void onSuccess(WebViewStartUpResult webViewStartUpResult) {
        new Handler(Looper.getMainLooper()).post(new WebViewCompat$$ExternalSyntheticLambda1(this.f$0, webViewStartUpResult));
    }
}
