package androidx.webkit.internal;

import androidx.webkit.OutcomeReceiverCompat;
import androidx.webkit.PrefetchException;
import androidx.webkit.PrefetchNetworkException;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.PrefetchOperationCallbackBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* INFO: loaded from: classes3.dex */
public class PrefetchOperationCallbackAdapter {

    /* INFO: renamed from: androidx.webkit.internal.PrefetchOperationCallbackAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements PrefetchOperationCallbackBoundaryInterface {
        final /* synthetic */ OutcomeReceiverCompat val$callback;

        AnonymousClass1(OutcomeReceiverCompat outcomeReceiverCompat) {
            this.val$callback = outcomeReceiverCompat;
        }

        @Override // org.chromium.support_lib_boundary.PrefetchOperationCallbackBoundaryInterface
        public void onSuccess() {
            this.val$callback.onResult(null);
        }

        @Override // org.chromium.support_lib_boundary.PrefetchOperationCallbackBoundaryInterface
        public void onFailure(int i, String str, int i2) {
            if (i == 1) {
                this.val$callback.onError(new PrefetchNetworkException(str, i2));
            } else {
                this.val$callback.onError(new PrefetchException(str));
            }
        }
    }

    public static InvocationHandler buildInvocationHandler(OutcomeReceiverCompat<Void, PrefetchException> outcomeReceiverCompat) {
        return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new AnonymousClass1(outcomeReceiverCompat));
    }
}
