package com.github.kittinunf.fuel.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RequestExecutionOptions.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/github/kittinunf/fuel/core/Response;", "invoke"}, k = 3, mv = {1, 4, 0})
final class RequestExecutionOptions$responseValidator$1 extends Lambda implements Function1<Response, Boolean> {
    public static final RequestExecutionOptions$responseValidator$1 INSTANCE = new RequestExecutionOptions$responseValidator$1();

    RequestExecutionOptions$responseValidator$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Response response) {
        return Boolean.valueOf(invoke2(response));
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return (ResponseKt.isServerError(response) || ResponseKt.isClientError(response)) ? false : true;
    }
}
