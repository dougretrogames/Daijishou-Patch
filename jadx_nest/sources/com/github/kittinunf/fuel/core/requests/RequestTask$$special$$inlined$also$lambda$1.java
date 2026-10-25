package com.github.kittinunf.fuel.core.requests;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RequestTask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/github/kittinunf/fuel/core/requests/RequestTask$call$3$2$1$1"}, k = 3, mv = {1, 4, 0})
final class RequestTask$$special$$inlined$also$lambda$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Throwable $error$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RequestTask$$special$$inlined$also$lambda$1(Throwable th) {
        super(0);
        this.$error$inlined = th;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "[RequestTask] execution error\n\r\t" + this.$error$inlined;
    }
}
