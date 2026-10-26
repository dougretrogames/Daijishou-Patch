package com.github.kittinunf.fuel.toolbox;

import com.github.kittinunf.fuel.core.Body;
import com.github.kittinunf.fuel.core.Client;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.FuelManager;
import com.github.kittinunf.fuel.core.HeaderName;
import com.github.kittinunf.fuel.core.Headers;
import com.github.kittinunf.fuel.core.Method;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.fuel.core.requests.CancellableRequestKt;
import com.github.kittinunf.fuel.core.requests.DefaultBody;
import com.github.kittinunf.fuel.toolbox.extensions.ForceMethodKt;
import com.github.kittinunf.fuel.util.DecodeStreamKt;
import com.github.kittinunf.fuel.util.ProgressInputStream;
import com.github.kittinunf.fuel.util.ProgressOutputStream;
import com.google.api.client.googleapis.MethodOverride;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.protocol.HTTP;
import org.eclipse.jgit.util.HttpSupport;

/* INFO: compiled from: HttpClient.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0002R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/github/kittinunf/fuel/toolbox/HttpClient;", "Lcom/github/kittinunf/fuel/core/Client;", "proxy", "Ljava/net/Proxy;", "useHttpCache", "", "decodeContent", "hook", "Lcom/github/kittinunf/fuel/core/Client$Hook;", "(Ljava/net/Proxy;ZZLcom/github/kittinunf/fuel/core/Client$Hook;)V", "getDecodeContent", "()Z", "setDecodeContent", "(Z)V", "getHook", "()Lcom/github/kittinunf/fuel/core/Client$Hook;", "setHook", "(Lcom/github/kittinunf/fuel/core/Client$Hook;)V", "getUseHttpCache", "setUseHttpCache", "awaitRequest", "Lcom/github/kittinunf/fuel/core/Response;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "(Lcom/github/kittinunf/fuel/core/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dataStream", "Ljava/io/InputStream;", "connection", "Ljava/net/HttpURLConnection;", "doRequest", "ensureRequestActive", "", "establishConnection", "executeRequest", "retrieveResponse", "sendRequest", "setBodyIfDoOutput", "setDoOutput", "method", "Lcom/github/kittinunf/fuel/core/Method;", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final class HttpClient implements Client {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> SUPPORTED_DECODING = CollectionsKt.listOf((Object[]) new String[]{HttpSupport.ENCODING_GZIP, "deflate; q=0.5"});
    private boolean decodeContent;
    private Client.Hook hook;
    private final Proxy proxy;
    private boolean useHttpCache;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Method.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Method.GET.ordinal()] = 1;
            iArr[Method.HEAD.ordinal()] = 2;
            iArr[Method.OPTIONS.ordinal()] = 3;
            iArr[Method.TRACE.ordinal()] = 4;
            iArr[Method.DELETE.ordinal()] = 5;
            iArr[Method.POST.ordinal()] = 6;
            iArr[Method.PUT.ordinal()] = 7;
            iArr[Method.PATCH.ordinal()] = 8;
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.toolbox.HttpClient$retrieveResponse$3, reason: invalid class name */
    /* INFO: compiled from: HttpClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass3 extends Lambda implements Function0<Long> {
        final /* synthetic */ Ref.ObjectRef $contentLength;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.ObjectRef objectRef) {
            super(0);
            this.$contentLength = objectRef;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* WARN: Multi-variable type inference failed */
        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            Long l = (Long) this.$contentLength.element;
            if (l != null) {
                return l.longValue();
            }
            return -1L;
        }
    }

    public HttpClient(Proxy proxy, boolean z, boolean z2, Client.Hook hook) {
        Intrinsics.checkNotNullParameter(hook, "hook");
        this.proxy = proxy;
        this.useHttpCache = z;
        this.decodeContent = z2;
        this.hook = hook;
    }

    /* WARN: Illegal instructions before constructor call */
    public /* synthetic */ HttpClient(Proxy proxy, boolean z, boolean z2, Client.Hook hook, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            proxy = null;
        }
        this(proxy, (i & 2) != 0 ? true : z, (i & 4) != 0 ? true : z2, hook);
    }

    public final boolean getUseHttpCache() {
        return this.useHttpCache;
    }

    public final void setUseHttpCache(boolean z) {
        this.useHttpCache = z;
    }

    public final boolean getDecodeContent() {
        return this.decodeContent;
    }

    public final void setDecodeContent(boolean z) {
        this.decodeContent = z;
    }

    public final Client.Hook getHook() {
        return this.hook;
    }

    public final void setHook(Client.Hook hook) {
        Intrinsics.checkNotNullParameter(hook, "<set-?>");
        this.hook = hook;
    }

    @Override // com.github.kittinunf.fuel.core.Client
    public Response executeRequest(Request request) throws FuelError {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            return doRequest(request);
        } catch (IOException e) {
            this.hook.httpExchangeFailed(request, e);
            throw FuelError.INSTANCE.wrap(e, new Response(request.getUrl(), 0, null, null, 0L, null, 62, null));
        } catch (InterruptedException e2) {
            throw FuelError.INSTANCE.wrap(e2, new Response(request.getUrl(), 0, null, null, 0L, null, 62, null));
        }
    }

    /* INFO: Access modifiers changed from: private */
    public final void ensureRequestActive(Request request, HttpURLConnection connection) throws InterruptedException {
        boolean zIsCancelled = CancellableRequestKt.isCancelled(request);
        if (!zIsCancelled) {
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
            if (!threadCurrentThread.isInterrupted()) {
                return;
            }
        }
        if (connection != null) {
            connection.disconnect();
        }
        throw new InterruptedException("[HttpClient] could not ensure Request was active: cancelled=" + zIsCancelled);
    }

    @Override // com.github.kittinunf.fuel.core.Client
    public Object awaitRequest(Request request, Continuation<? super Response> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        try {
            Response responseDoRequest = doRequest(request);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m3752constructorimpl(responseDoRequest));
        } catch (IOException e) {
            this.hook.httpExchangeFailed(request, e);
            FuelError fuelErrorWrap = FuelError.INSTANCE.wrap(e, new Response(request.getUrl(), 0, null, null, 0L, null, 62, null));
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(fuelErrorWrap)));
        } catch (InterruptedException e2) {
            FuelError fuelErrorWrap2 = FuelError.INSTANCE.wrap(e2, new Response(request.getUrl(), 0, null, null, 0L, null, 62, null));
            Result.Companion companion3 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(fuelErrorWrap2)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final Response doRequest(Request request) throws IllegalAccessException, InterruptedException, IOException {
        HttpURLConnection httpURLConnectionEstablishConnection = establishConnection(request);
        sendRequest(request, httpURLConnectionEstablishConnection);
        return retrieveResponse(request, httpURLConnectionEstablishConnection);
    }

    private final void sendRequest(Request request, HttpURLConnection connection) throws IllegalAccessException, InterruptedException, IOException {
        ensureRequestActive(request, connection);
        connection.setConnectTimeout(Math.max(request.getExecutionOptions().getTimeoutInMillisecond(), 0));
        connection.setReadTimeout(Math.max(request.getExecutionOptions().getTimeoutReadInMillisecond(), 0));
        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
            httpsURLConnection.setSSLSocketFactory(request.getExecutionOptions().getSocketFactory());
            httpsURLConnection.setHostnameVerifier(request.getExecutionOptions().getHostnameVerifier());
        }
        if (request.getExecutionOptions().getForceMethods()) {
            ForceMethodKt.forceMethod(connection, request.getMethod());
            if (connection.getRequestMethod() != request.getMethod().getValue()) {
                connection.setRequestMethod(INSTANCE.coerceMethod(request.getMethod()).getValue());
                connection.setRequestProperty(MethodOverride.HEADER, request.getMethod().getValue());
            }
        } else {
            connection.setRequestMethod(INSTANCE.coerceMethod(request.getMethod()).getValue());
            if (Intrinsics.areEqual(request.getMethod().getValue(), "PATCH")) {
                connection.setRequestProperty(MethodOverride.HEADER, request.getMethod().getValue());
            }
        }
        connection.setDoInput(true);
        Boolean useHttpCache = request.getExecutionOptions().getUseHttpCache();
        connection.setUseCaches(useHttpCache != null ? useHttpCache.booleanValue() : this.useHttpCache);
        connection.setInstanceFollowRedirects(false);
        request.getHeaders().transformIterate(new HttpClient$sendRequest$1$1(connection), new HttpClient$sendRequest$1$2(connection));
        connection.setRequestProperty("TE", Headers.INSTANCE.collapse(new HeaderName("TE"), SUPPORTED_DECODING));
        this.hook.preConnect(connection, request);
        setDoOutput(connection, request.getMethod());
        setBodyIfDoOutput(connection, request);
        connection.connect();
    }

    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r2v13, types: [T, java.lang.Long] */
    private final Response retrieveResponse(Request request, HttpURLConnection connection) throws InterruptedException, IOException {
        boolean z;
        String str;
        ByteArrayInputStream byteArrayInputStream;
        ensureRequestActive(request, connection);
        this.hook.postConnect(request);
        Headers.Companion companion = Headers.INSTANCE;
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        Intrinsics.checkNotNullExpressionValue(headerFields, "connection.headerFields");
        Headers headersFrom = companion.from(headerFields);
        Collection<? extends String> collection = headersFrom.get((Object) "Transfer-Encoding");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            CollectionsKt.addAll(arrayList, StringsKt.split$default((CharSequence) it.next(), new char[]{AbstractJsonLexerKt.COMMA}, false, 0, 6, (Object) null));
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (String str2 : arrayList2) {
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            arrayList3.add(StringsKt.trim((CharSequence) str2).toString());
        }
        ArrayList arrayList4 = arrayList3;
        String str3 = (String) CollectionsKt.lastOrNull(headersFrom.get((Object) "Content-Encoding"));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str4 = (String) CollectionsKt.lastOrNull(headersFrom.get((Object) "Content-Length"));
        objectRef.element = str4 != null ? Long.valueOf(Long.parseLong(str4)) : 0;
        Boolean decodeContent = request.getExecutionOptions().getDecodeContent();
        boolean z2 = (!(decodeContent != null ? decodeContent.booleanValue() : this.decodeContent) || str3 == null || Intrinsics.areEqual(str3, HTTP.IDENTITY_CODING)) ? false : true;
        if (z2) {
            headersFrom.remove((Object) "Content-Encoding");
            headersFrom.remove((Object) "Content-Length");
            objectRef.element = null;
        }
        headersFrom.remove((Object) "Transfer-Encoding");
        ArrayList arrayList5 = arrayList4;
        if ((arrayList5 instanceof Collection) && arrayList5.isEmpty()) {
            z = false;
            break;
        }
        Iterator it2 = arrayList5.iterator();
        do {
            if (!it2.hasNext()) {
                z = false;
                break;
            }
            str = (String) it2.next();
        } while (!((StringsKt.isBlank(str) || Intrinsics.areEqual(str, HTTP.IDENTITY_CODING)) ? false : true));
        if (z) {
            headersFrom.remove((Object) "Content-Length");
            objectRef.element = -1L;
        }
        InputStream inputStreamDataStream = dataStream(request, connection);
        if (inputStreamDataStream == null || (byteArrayInputStream = DecodeStreamKt.decode$default(inputStreamDataStream, arrayList5, (Function2) null, 2, (Object) null)) == null) {
            byteArrayInputStream = new ByteArrayInputStream(new byte[0]);
        }
        if (z2 && str3 != null) {
            byteArrayInputStream = DecodeStreamKt.decode$default(byteArrayInputStream, str3, (Function2) null, 2, (Object) null);
        }
        ProgressInputStream progressInputStream = new ProgressInputStream(byteArrayInputStream, new HttpClient$retrieveResponse$progressStream$1(this, request, objectRef, new WeakReference(connection)));
        URL url = request.getUrl();
        Long l = (Long) objectRef.element;
        long jLongValue = l != null ? l.longValue() : -1L;
        int responseCode = connection.getResponseCode();
        String responseMessage = connection.getResponseMessage();
        if (responseMessage == null) {
            responseMessage = "";
        }
        return new Response(url, responseCode, responseMessage, headersFrom, jLongValue, DefaultBody.Companion.from$default(DefaultBody.INSTANCE, new AnonymousClass2(progressInputStream), new AnonymousClass3(objectRef), null, 4, null));
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.toolbox.HttpClient$retrieveResponse$2, reason: invalid class name */
    /* INFO: compiled from: HttpClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/InputStream;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass2 extends Lambda implements Function0<InputStream> {
        final /* synthetic */ ProgressInputStream $progressStream;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ProgressInputStream progressInputStream) {
            super(0);
            this.$progressStream = progressInputStream;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InputStream invoke() {
            FilterInputStream filterInputStream = this.$progressStream;
            return filterInputStream instanceof BufferedInputStream ? (BufferedInputStream) filterInputStream : new BufferedInputStream(filterInputStream, FuelManager.INSTANCE.getProgressBufferSize());
        }
    }

    private final InputStream dataStream(Request request, HttpURLConnection connection) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            InputStream inputStreamInterpretResponseStream = this.hook.interpretResponseStream(request, connection.getInputStream());
            if (inputStreamInterpretResponseStream != null) {
                bufferedInputStream = inputStreamInterpretResponseStream instanceof BufferedInputStream ? (BufferedInputStream) inputStreamInterpretResponseStream : new BufferedInputStream(inputStreamInterpretResponseStream, 8192);
            } else {
                bufferedInputStream = null;
            }
            return bufferedInputStream;
        } catch (IOException unused) {
            InputStream inputStreamInterpretResponseStream2 = this.hook.interpretResponseStream(request, connection.getErrorStream());
            if (inputStreamInterpretResponseStream2 != null) {
                bufferedInputStream2 = inputStreamInterpretResponseStream2 instanceof BufferedInputStream ? (BufferedInputStream) inputStreamInterpretResponseStream2 : new BufferedInputStream(inputStreamInterpretResponseStream2, 8192);
            }
            return bufferedInputStream2;
        }
    }

    private final HttpURLConnection establishConnection(Request request) throws IOException {
        URLConnection uRLConnectionOpenConnection;
        URL url = request.getUrl();
        Proxy proxy = this.proxy;
        if (proxy == null || (uRLConnectionOpenConnection = url.openConnection(proxy)) == null) {
            uRLConnectionOpenConnection = url.openConnection();
        }
        if (uRLConnectionOpenConnection != null) {
            return (HttpURLConnection) uRLConnectionOpenConnection;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
    }

    private final void setBodyIfDoOutput(HttpURLConnection connection, Request request) throws IOException {
        Long lValueOf;
        BufferedOutputStream outputStream;
        Body body = request.getBody();
        if (connection.getDoOutput()) {
            if (body.isEmpty()) {
                connection.setFixedLengthStreamingMode(0L);
                return;
            }
            Long length = body.getLength();
            if (length != null && length.longValue() != -1) {
                connection.setFixedLengthStreamingMode(length.longValue());
            } else {
                connection.setChunkedStreamingMode(4096);
            }
            if (request.getExecutionOptions().getRequestProgress().isNotSet()) {
                outputStream = connection.getOutputStream();
            } else {
                if ((length != null ? length.longValue() : -1L) > 0) {
                    Intrinsics.checkNotNull(length);
                    lValueOf = Long.valueOf(length.longValue());
                } else {
                    lValueOf = null;
                }
                OutputStream outputStream2 = connection.getOutputStream();
                Intrinsics.checkNotNullExpressionValue(outputStream2, "connection.outputStream");
                ProgressOutputStream progressOutputStream = new ProgressOutputStream(outputStream2, new HttpClient$setBodyIfDoOutput$outputStream$1(this, request, lValueOf, connection));
                outputStream = progressOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) progressOutputStream : new BufferedOutputStream(progressOutputStream, FuelManager.INSTANCE.getProgressBufferSize());
            }
            Intrinsics.checkNotNullExpressionValue(outputStream, "outputStream");
            body.writeTo(outputStream);
            connection.getOutputStream().flush();
        }
    }

    private final void setDoOutput(HttpURLConnection connection, Method method) {
        switch (WhenMappings.$EnumSwitchMapping$0[method.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                connection.setDoOutput(false);
                return;
            case 5:
            case 6:
            case 7:
            case 8:
                connection.setDoOutput(true);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* INFO: compiled from: HttpClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/github/kittinunf/fuel/toolbox/HttpClient$Companion;", "", "()V", "SUPPORTED_DECODING", "", "", "coerceMethod", "Lcom/github/kittinunf/fuel/core/Method;", "method", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* INFO: Access modifiers changed from: private */
        public final Method coerceMethod(Method method) {
            return method == Method.PATCH ? Method.POST : method;
        }
    }
}
