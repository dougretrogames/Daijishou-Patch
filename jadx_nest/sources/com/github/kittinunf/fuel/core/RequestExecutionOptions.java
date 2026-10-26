package com.github.kittinunf.fuel.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: RequestExecutionOptions.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f\u0012\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\u0002`\u0013¢\u0006\u0002\u0010\u0014J\u0014\u0010U\u001a\u00020-2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020-0WJ\t\u0010X\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010[\u001a\u00020\tHÆ\u0003J\t\u0010\\\u001a\u00020\u000bHÆ\u0003J\u0019\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000fHÆ\u0003J\u001f\u0010^\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\u0002`\u0013HÆ\u0003Jy\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f2\u001e\b\u0002\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\u0002`\u0013HÆ\u0001J\u0013\u0010`\u001a\u00020\u00162\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020JHÖ\u0001J'\u0010c\u001a\u00020-2\u001c\u0010d\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\u0002`\u0013H\u0086\u0002J\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00120f2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00120hJ\t\u0010i\u001a\u00020jHÖ\u0001R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R!\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020-0\rj\u0002`.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R0\u00101\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020-0\rj\u0002`.02X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u00107\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b;\u00100R\u0011\u0010<\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\b=\u0010:R0\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\u0002`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR*\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\rj\u0002`CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00100\"\u0004\bE\u0010FR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\u001e\u0010R\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\bS\u0010\u0018\"\u0004\bT\u0010\u001a¨\u0006k"}, d2 = {"Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "", "client", "Lcom/github/kittinunf/fuel/core/Client;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "executorService", "Ljava/util/concurrent/ExecutorService;", "callbackExecutor", "Ljava/util/concurrent/Executor;", "requestTransformer", "Lkotlin/Function1;", "Lcom/github/kittinunf/fuel/core/Request;", "Lcom/github/kittinunf/fuel/core/RequestTransformer;", "responseTransformer", "Lkotlin/Function2;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/fuel/core/ResponseTransformer;", "(Lcom/github/kittinunf/fuel/core/Client;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "allowRedirects", "", "getAllowRedirects", "()Ljava/lang/Boolean;", "setAllowRedirects", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCallbackExecutor", "()Ljava/util/concurrent/Executor;", "getClient", "()Lcom/github/kittinunf/fuel/core/Client;", "decodeContent", "getDecodeContent", "setDecodeContent", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "forceMethods", "getForceMethods", "()Z", "setForceMethods", "(Z)V", "getHostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "interruptCallback", "", "Lcom/github/kittinunf/fuel/core/InterruptCallback;", "getInterruptCallback", "()Lkotlin/jvm/functions/Function1;", "interruptCallbacks", "", "getInterruptCallbacks", "()Ljava/util/Collection;", "setInterruptCallbacks", "(Ljava/util/Collection;)V", "requestProgress", "Lcom/github/kittinunf/fuel/core/Progress;", "getRequestProgress", "()Lcom/github/kittinunf/fuel/core/Progress;", "getRequestTransformer", "responseProgress", "getResponseProgress", "getResponseTransformer", "()Lkotlin/jvm/functions/Function2;", "setResponseTransformer", "(Lkotlin/jvm/functions/Function2;)V", "responseValidator", "Lcom/github/kittinunf/fuel/core/ResponseValidator;", "getResponseValidator", "setResponseValidator", "(Lkotlin/jvm/functions/Function1;)V", "getSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "timeoutInMillisecond", "", "getTimeoutInMillisecond", "()I", "setTimeoutInMillisecond", "(I)V", "timeoutReadInMillisecond", "getTimeoutReadInMillisecond", "setTimeoutReadInMillisecond", "useHttpCache", "getUseHttpCache", "setUseHttpCache", "callback", "f", "Lkotlin/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "plusAssign", "next", "submit", "Ljava/util/concurrent/Future;", "task", "Ljava/util/concurrent/Callable;", "toString", "", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class RequestExecutionOptions {
    private Boolean allowRedirects;
    private final Executor callbackExecutor;
    private final Client client;
    private Boolean decodeContent;
    private final ExecutorService executorService;
    private boolean forceMethods;
    private final HostnameVerifier hostnameVerifier;
    private final Function1<Request, Unit> interruptCallback;
    private Collection<Function1<Request, Unit>> interruptCallbacks;
    private final Progress requestProgress;
    private final Function1<Request, Request> requestTransformer;
    private final Progress responseProgress;
    private Function2<? super Request, ? super Response, Response> responseTransformer;
    private Function1<? super Response, Boolean> responseValidator;
    private final SSLSocketFactory socketFactory;
    private int timeoutInMillisecond;
    private int timeoutReadInMillisecond;
    private Boolean useHttpCache;

    /* WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestExecutionOptions copy$default(RequestExecutionOptions requestExecutionOptions, Client client, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ExecutorService executorService, Executor executor, Function1 function1, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            client = requestExecutionOptions.client;
        }
        if ((i & 2) != 0) {
            sSLSocketFactory = requestExecutionOptions.socketFactory;
        }
        if ((i & 4) != 0) {
            hostnameVerifier = requestExecutionOptions.hostnameVerifier;
        }
        if ((i & 8) != 0) {
            executorService = requestExecutionOptions.executorService;
        }
        if ((i & 16) != 0) {
            executor = requestExecutionOptions.callbackExecutor;
        }
        if ((i & 32) != 0) {
            function1 = requestExecutionOptions.requestTransformer;
        }
        if ((i & 64) != 0) {
            function2 = requestExecutionOptions.responseTransformer;
        }
        Function1 function3 = function1;
        Function2 function4 = function2;
        Executor executor2 = executor;
        HostnameVerifier hostnameVerifier2 = hostnameVerifier;
        return requestExecutionOptions.copy(client, sSLSocketFactory, hostnameVerifier2, executorService, executor2, function3, function4);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final Client getClient() {
        return this.client;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final SSLSocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    /* INFO: renamed from: component3, reason: from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    /* INFO: renamed from: component4, reason: from getter */
    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    /* INFO: renamed from: component5, reason: from getter */
    public final Executor getCallbackExecutor() {
        return this.callbackExecutor;
    }

    public final Function1<Request, Request> component6() {
        return this.requestTransformer;
    }

    public final Function2<Request, Response, Response> component7() {
        return this.responseTransformer;
    }

    public final RequestExecutionOptions copy(Client client, SSLSocketFactory socketFactory, HostnameVerifier hostnameVerifier, ExecutorService executorService, Executor callbackExecutor, Function1<? super Request, ? extends Request> requestTransformer, Function2<? super Request, ? super Response, Response> responseTransformer) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(callbackExecutor, "callbackExecutor");
        Intrinsics.checkNotNullParameter(requestTransformer, "requestTransformer");
        Intrinsics.checkNotNullParameter(responseTransformer, "responseTransformer");
        return new RequestExecutionOptions(client, socketFactory, hostnameVerifier, executorService, callbackExecutor, requestTransformer, responseTransformer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestExecutionOptions)) {
            return false;
        }
        RequestExecutionOptions requestExecutionOptions = (RequestExecutionOptions) other;
        return Intrinsics.areEqual(this.client, requestExecutionOptions.client) && Intrinsics.areEqual(this.socketFactory, requestExecutionOptions.socketFactory) && Intrinsics.areEqual(this.hostnameVerifier, requestExecutionOptions.hostnameVerifier) && Intrinsics.areEqual(this.executorService, requestExecutionOptions.executorService) && Intrinsics.areEqual(this.callbackExecutor, requestExecutionOptions.callbackExecutor) && Intrinsics.areEqual(this.requestTransformer, requestExecutionOptions.requestTransformer) && Intrinsics.areEqual(this.responseTransformer, requestExecutionOptions.responseTransformer);
    }

    public int hashCode() {
        Client client = this.client;
        int iHashCode = (client != null ? client.hashCode() : 0) * 31;
        SSLSocketFactory sSLSocketFactory = this.socketFactory;
        int iHashCode2 = (iHashCode + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        int iHashCode3 = (iHashCode2 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        ExecutorService executorService = this.executorService;
        int iHashCode4 = (iHashCode3 + (executorService != null ? executorService.hashCode() : 0)) * 31;
        Executor executor = this.callbackExecutor;
        int iHashCode5 = (iHashCode4 + (executor != null ? executor.hashCode() : 0)) * 31;
        Function1<Request, Request> function1 = this.requestTransformer;
        int iHashCode6 = (iHashCode5 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Function2<? super Request, ? super Response, Response> function2 = this.responseTransformer;
        return iHashCode6 + (function2 != null ? function2.hashCode() : 0);
    }

    public String toString() {
        return "RequestExecutionOptions(client=" + this.client + ", socketFactory=" + this.socketFactory + ", hostnameVerifier=" + this.hostnameVerifier + ", executorService=" + this.executorService + ", callbackExecutor=" + this.callbackExecutor + ", requestTransformer=" + this.requestTransformer + ", responseTransformer=" + this.responseTransformer + ")";
    }

    /* WARN: Multi-variable type inference failed */
    public RequestExecutionOptions(Client client, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ExecutorService executorService, Executor callbackExecutor, Function1<? super Request, ? extends Request> requestTransformer, Function2<? super Request, ? super Response, Response> responseTransformer) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(callbackExecutor, "callbackExecutor");
        Intrinsics.checkNotNullParameter(requestTransformer, "requestTransformer");
        Intrinsics.checkNotNullParameter(responseTransformer, "responseTransformer");
        this.client = client;
        this.socketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.executorService = executorService;
        this.callbackExecutor = callbackExecutor;
        this.requestTransformer = requestTransformer;
        this.responseTransformer = responseTransformer;
        this.requestProgress = new Progress(null, 1, null);
        this.responseProgress = new Progress(null, 1, null);
        this.timeoutInMillisecond = 15000;
        this.timeoutReadInMillisecond = 15000;
        this.interruptCallbacks = new ArrayList();
        this.responseValidator = RequestExecutionOptions$responseValidator$1.INSTANCE;
        this.interruptCallback = new RequestExecutionOptions$interruptCallback$1(this);
    }

    public final Client getClient() {
        return this.client;
    }

    /* WARN: Illegal instructions before constructor call */
    public /* synthetic */ RequestExecutionOptions(Client client, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ExecutorService executorService, Executor executor, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        SSLSocketFactory sSLSocketFactory2;
        HostnameVerifier hostnameVerifier2;
        if ((i & 2) != 0) {
            sSLSocketFactory2 = null;
        } else {
            sSLSocketFactory2 = sSLSocketFactory;
        }
        if ((i & 4) != 0) {
            hostnameVerifier2 = null;
        } else {
            hostnameVerifier2 = hostnameVerifier;
        }
        this(client, sSLSocketFactory2, hostnameVerifier2, executorService, executor, function1, function2);
    }

    public final SSLSocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    public final Executor getCallbackExecutor() {
        return this.callbackExecutor;
    }

    public final Function1<Request, Request> getRequestTransformer() {
        return this.requestTransformer;
    }

    public final Function2<Request, Response, Response> getResponseTransformer() {
        return this.responseTransformer;
    }

    public final void setResponseTransformer(Function2<? super Request, ? super Response, Response> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.responseTransformer = function2;
    }

    public final Progress getRequestProgress() {
        return this.requestProgress;
    }

    public final Progress getResponseProgress() {
        return this.responseProgress;
    }

    public final int getTimeoutInMillisecond() {
        return this.timeoutInMillisecond;
    }

    public final void setTimeoutInMillisecond(int i) {
        this.timeoutInMillisecond = i;
    }

    public final int getTimeoutReadInMillisecond() {
        return this.timeoutReadInMillisecond;
    }

    public final void setTimeoutReadInMillisecond(int i) {
        this.timeoutReadInMillisecond = i;
    }

    public final Boolean getDecodeContent() {
        return this.decodeContent;
    }

    public final void setDecodeContent(Boolean bool) {
        this.decodeContent = bool;
    }

    public final Boolean getAllowRedirects() {
        return this.allowRedirects;
    }

    public final void setAllowRedirects(Boolean bool) {
        this.allowRedirects = bool;
    }

    public final Boolean getUseHttpCache() {
        return this.useHttpCache;
    }

    public final void setUseHttpCache(Boolean bool) {
        this.useHttpCache = bool;
    }

    public final Collection<Function1<Request, Unit>> getInterruptCallbacks() {
        return this.interruptCallbacks;
    }

    public final void setInterruptCallbacks(Collection<Function1<Request, Unit>> collection) {
        Intrinsics.checkNotNullParameter(collection, "<set-?>");
        this.interruptCallbacks = collection;
    }

    public final boolean getForceMethods() {
        return this.forceMethods;
    }

    public final void setForceMethods(boolean z) {
        this.forceMethods = z;
    }

    public final Function1<Response, Boolean> getResponseValidator() {
        return this.responseValidator;
    }

    public final void setResponseValidator(Function1<? super Response, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.responseValidator = function1;
    }

    public final void callback(Function0<Unit> f) {
        Intrinsics.checkNotNullParameter(f, "f");
        this.callbackExecutor.execute(new RequestExecutionOptionsKt$sam$java_lang_Runnable$0(f));
    }

    public final Future<Response> submit(Callable<Response> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Future<Response> futureSubmit = this.executorService.submit(task);
        Intrinsics.checkNotNullExpressionValue(futureSubmit, "executorService.submit(task)");
        return futureSubmit;
    }

    public final Function1<Request, Unit> getInterruptCallback() {
        return this.interruptCallback;
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.RequestExecutionOptions$plusAssign$1, reason: invalid class name */
    /* INFO: compiled from: RequestExecutionOptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Response;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "response", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function2<Request, Response, Response> {
        final /* synthetic */ Function2 $next;
        final /* synthetic */ Function2 $previous;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function2 function2, Function2 function3) {
            super(2);
            this.$next = function2;
            this.$previous = function3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Response invoke(Request request, Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            return (Response) this.$next.invoke(request, this.$previous.invoke(request, response));
        }
    }

    public final void plusAssign(Function2<? super Request, ? super Response, Response> next) {
        Intrinsics.checkNotNullParameter(next, "next");
        this.responseTransformer = new AnonymousClass1(next, this.responseTransformer);
    }
}
