package androidx.webkit.internal;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebViewNavigationBoundaryInterface;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class WebNavigationClientAdapter$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ WebViewNavigationBoundaryInterface f$0;

    public /* synthetic */ WebNavigationClientAdapter$$ExternalSyntheticLambda3(WebViewNavigationBoundaryInterface webViewNavigationBoundaryInterface) {
        this.f$0 = webViewNavigationBoundaryInterface;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return WebNavigationClientAdapter.lambda$onNavigationRedirected$1(this.f$0);
    }
}
