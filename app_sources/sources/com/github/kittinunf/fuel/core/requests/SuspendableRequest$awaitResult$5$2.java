package com.github.kittinunf.fuel.core.requests;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: SuspendableRequest.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class SuspendableRequest$awaitResult$5$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Throwable $error;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuspendableRequest$awaitResult$5$2(Throwable th) {
        super(0);
        this.$error = th;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "[RequestTask] execution error\n\r\t" + this.$error;
    }
}
