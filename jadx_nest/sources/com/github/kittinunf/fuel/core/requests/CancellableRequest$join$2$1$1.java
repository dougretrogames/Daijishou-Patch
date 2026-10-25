package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.Response;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: CancellableRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class CancellableRequest$join$2$1$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Response $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CancellableRequest$join$2$1$1(Response response) {
        super(0);
        this.$it = response;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "[CancellableRequest] joined to " + this.$it;
    }
}
