package androidx.webkit.internal;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class WebViewRenderProcessImpl$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ WebViewRendererBoundaryInterface f$0;

    public /* synthetic */ WebViewRenderProcessImpl$$ExternalSyntheticLambda0(WebViewRendererBoundaryInterface webViewRendererBoundaryInterface) {
        this.f$0 = webViewRendererBoundaryInterface;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return WebViewRenderProcessImpl.lambda$forInvocationHandler$0(this.f$0);
    }
}
