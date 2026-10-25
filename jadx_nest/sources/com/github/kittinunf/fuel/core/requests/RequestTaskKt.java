package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequestTask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000*$\b\u0002\u0010\u0004\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u00052\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0005¨\u0006\u0006"}, d2 = {"toTask", "Ljava/util/concurrent/Callable;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/fuel/core/Request;", "RequestTaskResult", "Lkotlin/Pair;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class RequestTaskKt {
    public static final Callable<Response> toTask(Request toTask) {
        Intrinsics.checkNotNullParameter(toTask, "$this$toTask");
        return new RequestTask(toTask);
    }
}
