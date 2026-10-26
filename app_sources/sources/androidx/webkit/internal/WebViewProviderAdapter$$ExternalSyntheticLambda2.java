package androidx.webkit.internal;

import android.webkit.ValueCallback;
import androidx.webkit.PrerenderOperationCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class WebViewProviderAdapter$$ExternalSyntheticLambda2 implements ValueCallback {
    public final /* synthetic */ PrerenderOperationCallback f$0;

    public /* synthetic */ WebViewProviderAdapter$$ExternalSyntheticLambda2(PrerenderOperationCallback prerenderOperationCallback) {
        this.f$0 = prerenderOperationCallback;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        this.f$0.onPrerenderActivated();
    }
}
