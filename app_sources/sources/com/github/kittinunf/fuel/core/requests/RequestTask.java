package com.github.kittinunf.fuel.core.requests;

import androidx.core.app.NotificationCompat;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.Client;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.HttpException;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.RequestExecutionOptions;
import com.github.kittinunf.fuel.core.Response;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: RequestTask.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u0002H\u0016J \u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u001cj\u0002`\u001d2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J \u0010\u001f\u001a\u00020\u00022\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u001cj\u0002`\u001dH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012j\u0002`\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/RequestTask;", "Ljava/util/concurrent/Callable;", "Lcom/github/kittinunf/fuel/core/Response;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "(Lcom/github/kittinunf/fuel/core/Request;)V", "client", "Lcom/github/kittinunf/fuel/core/Client;", "getClient", "()Lcom/github/kittinunf/fuel/core/Client;", "client$delegate", "Lkotlin/Lazy;", "executor", "Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "getExecutor", "()Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "executor$delegate", "interruptCallback", "Lkotlin/Function1;", "", "Lcom/github/kittinunf/fuel/core/InterruptCallback;", "getInterruptCallback", "()Lkotlin/jvm/functions/Function1;", "interruptCallback$delegate", "getRequest$fuel", "()Lcom/github/kittinunf/fuel/core/Request;", NotificationCompat.CATEGORY_CALL, "executeRequest", "Lkotlin/Pair;", "Lcom/github/kittinunf/fuel/core/requests/RequestTaskResult;", "prepareRequest", "prepareResponse", "result", "fuel"}, k = 1, mv = {1, 4, 0})
public final class RequestTask implements Callable<Response> {

    /* INFO: renamed from: client$delegate, reason: from kotlin metadata */
    private final Lazy client;

    /* INFO: renamed from: executor$delegate, reason: from kotlin metadata */
    private final Lazy executor;

    /* INFO: renamed from: interruptCallback$delegate, reason: from kotlin metadata */
    private final Lazy interruptCallback;
    private final Request request;

    private final Client getClient() {
        return (Client) this.client.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    public final RequestExecutionOptions getExecutor() {
        return (RequestExecutionOptions) this.executor.getValue();
    }

    private final Function1<Request, Unit> getInterruptCallback() {
        return (Function1) this.interruptCallback.getValue();
    }

    public RequestTask(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        this.interruptCallback = LazyKt.lazy(new RequestTask$interruptCallback$2(this));
        this.executor = LazyKt.lazy(new RequestTask$executor$2(this));
        this.client = LazyKt.lazy(new RequestTask$client$2(this));
    }

    /* INFO: renamed from: getRequest$fuel, reason: from getter */
    public final Request getRequest() {
        return this.request;
    }

    private final Request prepareRequest(Request request) {
        return getExecutor().getRequestTransformer().invoke(request);
    }

    private final Pair<Request, Response> executeRequest(Request request) throws Throwable {
        Object objM3752constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            RequestTask requestTask = this;
            objM3752constructorimpl = Result.m3752constructorimpl(new Pair(request, getClient().executeRequest(request)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM3752constructorimpl = Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM3755exceptionOrNullimpl = Result.m3755exceptionOrNullimpl(objM3752constructorimpl);
        if (thM3755exceptionOrNullimpl != null) {
            Result.Companion companion3 = Result.INSTANCE;
            throw FuelError.INSTANCE.wrap(thM3755exceptionOrNullimpl, new Response(request.getUrl(), 0, null, null, 0L, null, 62, null));
        }
        ResultKt.throwOnFailure(objM3752constructorimpl);
        return (Pair) objM3752constructorimpl;
    }

    private final Response prepareResponse(Pair<? extends Request, Response> result) throws Throwable {
        Object objM3752constructorimpl;
        Object objM3752constructorimpl2;
        Request requestComponent1 = result.component1();
        Response responseComponent2 = result.component2();
        try {
            Result.Companion companion = Result.INSTANCE;
            RequestTask requestTask = this;
            objM3752constructorimpl = Result.m3752constructorimpl(getExecutor().getResponseTransformer().invoke(requestComponent1, responseComponent2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM3752constructorimpl = Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3759isSuccessimpl(objM3752constructorimpl)) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Response response = (Response) objM3752constructorimpl;
                if (getExecutor().getResponseValidator().invoke(response).booleanValue()) {
                    objM3752constructorimpl2 = Result.m3752constructorimpl(response);
                } else {
                    throw FuelError.INSTANCE.wrap(new HttpException(response.getStatusCode(), response.getResponseMessage()), response);
                }
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
            Result.Companion companion5 = Result.INSTANCE;
            throw FuelError.INSTANCE.wrap(thM3755exceptionOrNullimpl, responseComponent2);
        }
        ResultKt.throwOnFailure(objM3752constructorimpl2);
        return (Response) objM3752constructorimpl2;
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Response call() throws Throwable {
        Object objM3752constructorimpl;
        Object objM3752constructorimpl2;
        Object objM3752constructorimpl3;
        Object objM3752constructorimpl4;
        try {
            Result.Companion companion = Result.INSTANCE;
            RequestTask requestTask = this;
            objM3752constructorimpl = Result.m3752constructorimpl(prepareRequest(this.request));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM3752constructorimpl = Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3759isSuccessimpl(objM3752constructorimpl)) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                objM3752constructorimpl2 = Result.m3752constructorimpl(executeRequest((Request) objM3752constructorimpl));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM3752constructorimpl = ResultKt.createFailure(th2);
                objM3752constructorimpl2 = Result.m3752constructorimpl(objM3752constructorimpl);
            }
        } else {
            objM3752constructorimpl2 = Result.m3752constructorimpl(objM3752constructorimpl);
        }
        if (Result.m3759isSuccessimpl(objM3752constructorimpl2)) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Pair<? extends Request, Response> pair = (Pair) objM3752constructorimpl2;
                try {
                    Result.Companion companion6 = Result.INSTANCE;
                    RequestTask requestTask2 = this;
                    objM3752constructorimpl3 = Result.m3752constructorimpl(prepareResponse(pair));
                } catch (Throwable th3) {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM3752constructorimpl3 = Result.m3752constructorimpl(ResultKt.createFailure(th3));
                }
                Throwable thM3755exceptionOrNullimpl = Result.m3755exceptionOrNullimpl(objM3752constructorimpl3);
                if (thM3755exceptionOrNullimpl != null) {
                    Result.Companion companion8 = Result.INSTANCE;
                    Fuel.INSTANCE.trace(new RequestTask$$special$$inlined$also$lambda$1(thM3755exceptionOrNullimpl));
                    throw FuelError.INSTANCE.wrap(thM3755exceptionOrNullimpl, pair.getSecond());
                }
                ResultKt.throwOnFailure(objM3752constructorimpl3);
                objM3752constructorimpl4 = Result.m3752constructorimpl((Response) objM3752constructorimpl3);
            } catch (Throwable th4) {
                Result.Companion companion9 = Result.INSTANCE;
                objM3752constructorimpl2 = ResultKt.createFailure(th4);
                objM3752constructorimpl4 = Result.m3752constructorimpl(objM3752constructorimpl2);
            }
        } else {
            objM3752constructorimpl4 = Result.m3752constructorimpl(objM3752constructorimpl2);
        }
        Throwable thM3755exceptionOrNullimpl2 = Result.m3755exceptionOrNullimpl(objM3752constructorimpl4);
        if (thM3755exceptionOrNullimpl2 != null) {
            Fuel.INSTANCE.trace(new RequestTask$call$4$1(thM3755exceptionOrNullimpl2));
            if ((thM3755exceptionOrNullimpl2 instanceof FuelError) && ((FuelError) thM3755exceptionOrNullimpl2).getCausedByInterruption()) {
                Fuel.INSTANCE.trace(new RequestTask$call$4$2(thM3755exceptionOrNullimpl2));
                getInterruptCallback().invoke(this.request);
            }
        }
        ResultKt.throwOnFailure(objM3752constructorimpl4);
        return (Response) objM3752constructorimpl4;
    }
}
