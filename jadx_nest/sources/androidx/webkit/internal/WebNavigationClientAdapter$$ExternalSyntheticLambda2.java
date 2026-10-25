package androidx.webkit.internal;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebViewPageBoundaryInterface;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class WebNavigationClientAdapter$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ WebViewPageBoundaryInterface f$0;

    public /* synthetic */ WebNavigationClientAdapter$$ExternalSyntheticLambda2(WebViewPageBoundaryInterface webViewPageBoundaryInterface) {
        this.f$0 = webViewPageBoundaryInterface;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return WebNavigationClientAdapter.lambda$onPageDeleted$3(this.f$0);
    }
}
