package com.github.kittinunf.fuel.core.requests;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: CancellableRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "com/github/kittinunf/fuel/core/requests/CancellableRequest$join$3$1$1", "com/github/kittinunf/fuel/core/requests/CancellableRequest$$special$$inlined$also$lambda$1"}, k = 3, mv = {1, 4, 0})
final class CancellableRequest$join$$inlined$fold$lambda$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Throwable $error$inlined;
    final /* synthetic */ CancellableRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CancellableRequest$join$$inlined$fold$lambda$1(Throwable th, CancellableRequest cancellableRequest) {
        super(0);
        this.$error$inlined = th;
        this.this$0 = cancellableRequest;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "[CancellableRequest] joined to " + this.$error$inlined;
    }
}
