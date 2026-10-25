package androidx.webkit.internal;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class JavaScriptReplyProxyImpl$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ JsReplyProxyBoundaryInterface f$0;

    public /* synthetic */ JavaScriptReplyProxyImpl$$ExternalSyntheticLambda0(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.f$0 = jsReplyProxyBoundaryInterface;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return JavaScriptReplyProxyImpl.lambda$forInvocationHandler$0(this.f$0);
    }
}
