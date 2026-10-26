package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.RequestExecutionOptions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RequestTask.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "invoke"}, k = 3, mv = {1, 4, 0})
final class RequestTask$executor$2 extends Lambda implements Function0<RequestExecutionOptions> {
    final /* synthetic */ RequestTask this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RequestTask$executor$2(RequestTask requestTask) {
        super(0);
        this.this$0 = requestTask;
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RequestExecutionOptions invoke() {
        return this.this$0.getRequest().getExecutionOptions();
    }
}
