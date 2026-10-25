package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SuspendableRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"suspendable", "Lcom/github/kittinunf/fuel/core/requests/SuspendableRequest;", "Lcom/github/kittinunf/fuel/core/Request;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class SuspendableRequestKt {
    public static final SuspendableRequest suspendable(Request suspendable) {
        Intrinsics.checkNotNullParameter(suspendable, "$this$suspendable");
        return SuspendableRequest.INSTANCE.enableFor(suspendable);
    }
}
