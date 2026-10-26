package com.github.kittinunf.fuel.core.requests;

import androidx.core.app.NotificationCompat;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RequestTaskCallbacks.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/RequestTaskCallbacks;", "Ljava/util/concurrent/Callable;", "Lcom/github/kittinunf/fuel/core/Response;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "task", "onSuccess", "Lkotlin/Function1;", "", "Lcom/github/kittinunf/fuel/core/requests/RequestSuccessCallback;", "onFailure", "Lkotlin/Function2;", "Lcom/github/kittinunf/fuel/core/FuelError;", "Lcom/github/kittinunf/fuel/core/requests/RequestFailureCallback;", "(Lcom/github/kittinunf/fuel/core/Request;Ljava/util/concurrent/Callable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", NotificationCompat.CATEGORY_CALL, "fuel"}, k = 1, mv = {1, 4, 0})
public final class RequestTaskCallbacks implements Callable<Response> {
    private final Function2<FuelError, Response, Unit> onFailure;
    private final Function1<Response, Unit> onSuccess;
    private final Request request;
    private final Callable<Response> task;

    /* WARN: Multi-variable type inference failed */
    public RequestTaskCallbacks(Request request, Callable<Response> task, Function1<? super Response, Unit> onSuccess, Function2<? super FuelError, ? super Response, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        this.request = request;
        this.task = task;
        this.onSuccess = onSuccess;
        this.onFailure = onFailure;
    }

    public /* synthetic */ RequestTaskCallbacks(Request request, Callable callable, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(request, (i & 2) != 0 ? RequestTaskKt.toTask(request) : callable, function1, function2);
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.requests.RequestTaskCallbacks$call$1, reason: invalid class name */
    /* INFO: compiled from: RequestTaskCallbacks.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function0<String> {
        AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "[RequestTaskCallbacks] start request task\n\r\t" + RequestTaskCallbacks.this.request;
        }
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Response call() {
        Object objM3752constructorimpl;
        Object objM3752constructorimpl2;
        Fuel.INSTANCE.trace(new AnonymousClass1());
        try {
            Result.Companion companion = Result.INSTANCE;
            RequestTaskCallbacks requestTaskCallbacks = this;
            objM3752constructorimpl = Result.m3752constructorimpl(this.task.call());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM3752constructorimpl = Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3759isSuccessimpl(objM3752constructorimpl)) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Response it = (Response) objM3752constructorimpl;
                Function1<Response, Unit> function1 = this.onSuccess;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                function1.invoke(it);
                objM3752constructorimpl2 = Result.m3752constructorimpl(it);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM3752constructorimpl = ResultKt.createFailure(th2);
                objM3752constructorimpl2 = Result.m3752constructorimpl(objM3752constructorimpl);
            }
        } else {
            objM3752constructorimpl2 = Result.m3752constructorimpl(objM3752constructorimpl);
        }
        Throwable thM3755exceptionOrNullimpl = Result.m3755exceptionOrNullimpl(objM3752constructorimpl2);
        if (thM3755exceptionOrNullimpl != null) {
            FuelError fuelErrorWrap$default = FuelError.Companion.wrap$default(FuelError.INSTANCE, thM3755exceptionOrNullimpl, null, 2, null);
            this.onFailure.invoke(fuelErrorWrap$default, fuelErrorWrap$default.getResponse());
            objM3752constructorimpl2 = fuelErrorWrap$default.getResponse();
        }
        return (Response) objM3752constructorimpl2;
    }
}
