package com.github.kittinunf.fuel.core;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RequestExecutionOptions.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "request", "Lcom/github/kittinunf/fuel/core/Request;", "invoke"}, k = 3, mv = {1, 4, 0})
final class RequestExecutionOptions$interruptCallback$1 extends Lambda implements Function1<Request, Unit> {
    final /* synthetic */ RequestExecutionOptions this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RequestExecutionOptions$interruptCallback$1(RequestExecutionOptions requestExecutionOptions) {
        super(1);
        this.this$0 = requestExecutionOptions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Request request) {
        invoke2(request);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Iterator<T> it = this.this$0.getInterruptCallbacks().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(request);
        }
    }
}
