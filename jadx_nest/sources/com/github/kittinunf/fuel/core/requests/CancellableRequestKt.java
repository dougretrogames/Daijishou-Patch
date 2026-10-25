package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CancellableRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0006"}, d2 = {"isCancelled", "", "Lcom/github/kittinunf/fuel/core/Request;", "(Lcom/github/kittinunf/fuel/core/Request;)Z", "tryCancel", "mayInterruptIfRunning", "fuel"}, k = 2, mv = {1, 4, 0})
public final class CancellableRequestKt {
    public static /* synthetic */ boolean tryCancel$default(Request request, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return tryCancel(request, z);
    }

    public static final boolean tryCancel(Request tryCancel, boolean z) {
        Intrinsics.checkNotNullParameter(tryCancel, "$this$tryCancel");
        Request request = tryCancel.getRequest().getEnabledFeatures().get(CancellableRequest.INSTANCE.getFEATURE());
        if (!(request instanceof CancellableRequest)) {
            request = null;
        }
        CancellableRequest cancellableRequest = (CancellableRequest) request;
        if (cancellableRequest != null) {
            return cancellableRequest.cancel(z);
        }
        return false;
    }

    public static final boolean isCancelled(Request isCancelled) {
        Intrinsics.checkNotNullParameter(isCancelled, "$this$isCancelled");
        CancellableRequest cancellableRequest = CancellableRequest.INSTANCE.getFor(isCancelled.getRequest());
        if (cancellableRequest != null) {
            return cancellableRequest.isCancelled();
        }
        return false;
    }
}
