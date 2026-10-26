package com.github.kittinunf.fuel.core;

import com.github.kittinunf.fuel.core.interceptors.ParameterEncoder;
import com.github.kittinunf.fuel.core.interceptors.RedirectionInterceptorKt;
import com.github.kittinunf.fuel.core.requests.DownloadRequest;
import com.github.kittinunf.fuel.core.requests.DownloadRequestKt;
import com.github.kittinunf.fuel.core.requests.UploadRequest;
import com.github.kittinunf.fuel.core.requests.UploadRequestKt;
import com.github.kittinunf.fuel.util.DelegatesKt;
import java.net.Proxy;
import java.security.KeyStore;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* INFO: compiled from: FuelManager.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0089\u00012\u00020\u00012\u00020\u0002:\u0002\u0089\u0001B\u0005¢\u0006\u0002\u0010\u0003J>\u0010n\u001a\u00020\u000026\u0010o\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0Xj\u0002`Z\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0Xj\u0002`Z0Xj\u0002`[JJ\u0010p\u001a\u00020\u00002B\u0010o\u001a>\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020^0]j\u0002`_\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020^0]j\u0002`_0Xj\u0002``J\u0010\u0010q\u001a\u00020Y2\u0006\u0010r\u001a\u00020YH\u0002J4\u0010s\u001a\u00020Y2\u0006\u0010t\u001a\u00020u2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J4\u0010s\u001a\u00020Y2\u0006\u0010w\u001a\u00020\u00062\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J<\u0010x\u001a\u00020y2\u0006\u0010t\u001a\u00020u2\u0006\u0010z\u001a\u00020{2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J<\u0010x\u001a\u00020y2\u0006\u0010w\u001a\u00020\u00062\u0006\u0010z\u001a\u00020{2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J4\u0010|\u001a\u00020Y2\u0006\u0010t\u001a\u00020u2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J4\u0010|\u001a\u00020Y2\u0006\u0010w\u001a\u00020\u00062\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J4\u0010}\u001a\u00020Y2\u0006\u0010t\u001a\u00020u2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J4\u0010}\u001a\u00020Y2\u0006\u0010w\u001a\u00020\u00062\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J4\u0010~\u001a\u00020Y2\u0006\u0010t\u001a\u00020u2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J4\u0010~\u001a\u00020Y2\u0006\u0010w\u001a\u00020\u00062\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J4\u0010\u007f\u001a\u00020Y2\u0006\u0010t\u001a\u00020u2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J4\u0010\u007f\u001a\u00020Y2\u0006\u0010w\u001a\u00020\u00062\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J5\u0010\u0080\u0001\u001a\u00020Y2\u0006\u0010t\u001a\u00020u2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J5\u0010\u0080\u0001\u001a\u00020Y2\u0006\u0010w\u001a\u00020\u00062\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J\u0007\u0010\u0081\u0001\u001a\u00020\u0000J\u0007\u0010\u0082\u0001\u001a\u00020\u0000J?\u0010\u0083\u0001\u001a\u00020\u000026\u0010o\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0Xj\u0002`Z\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0Xj\u0002`Z0Xj\u0002`[JK\u0010\u0084\u0001\u001a\u00020\u00002B\u0010o\u001a>\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020^0]j\u0002`_\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020^0]j\u0002`_0Xj\u0002``J<\u0010r\u001a\u00020Y2\u0006\u0010z\u001a\u00020{2\u0006\u0010t\u001a\u00020u2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J<\u0010r\u001a\u00020Y2\u0006\u0010z\u001a\u00020{2\u0006\u0010w\u001a\u00020\u00062\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J\u0011\u0010r\u001a\u00020Y2\u0007\u0010t\u001a\u00030\u0085\u0001H\u0016J\u0007\u0010\u0086\u0001\u001a\u00020\u0000J>\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u0010t\u001a\u00020u2\u0006\u0010z\u001a\u00020{2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016J>\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u0010w\u001a\u00020\u00062\u0006\u0010z\u001a\u00020{2\"\u0010v\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u000fH\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR2\u0010\u000b\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r0\fj\u0002`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010#\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\"8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010!\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R+\u0010*\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010!\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R+\u0010=\u001a\u00020<2\u0006\u0010\u0019\u001a\u00020<8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010!\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u00020JX\u0086\u000e¢\u0006\u0010\n\u0002\bO\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010URD\u0010V\u001a8\u00124\u00122\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0Xj\u0002`Z\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0Xj\u0002`Z0Xj\u0002`[0WX\u0082\u0004¢\u0006\u0002\n\u0000RP\u0010\\\u001aD\u0012@\u0012>\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020^0]j\u0002`_\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020^0]j\u0002`_0Xj\u0002``0WX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010b\u001a\u00020a2\u0006\u0010\u0019\u001a\u00020a8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010!\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010h\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010L\"\u0004\bj\u0010NR\u001a\u0010k\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010L\"\u0004\bm\u0010N¨\u0006\u008a\u0001"}, d2 = {"Lcom/github/kittinunf/fuel/core/FuelManager;", "Lcom/github/kittinunf/fuel/core/RequestFactory;", "Lcom/github/kittinunf/fuel/core/RequestFactory$Convenience;", "()V", "baseHeaders", "", "", "getBaseHeaders", "()Ljava/util/Map;", "setBaseHeaders", "(Ljava/util/Map;)V", "baseParams", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "getBaseParams", "()Ljava/util/List;", "setBaseParams", "(Ljava/util/List;)V", "basePath", "getBasePath", "()Ljava/lang/String;", "setBasePath", "(Ljava/lang/String;)V", "<set-?>", "Ljava/util/concurrent/Executor;", "callbackExecutor", "getCallbackExecutor", "()Ljava/util/concurrent/Executor;", "setCallbackExecutor", "(Ljava/util/concurrent/Executor;)V", "callbackExecutor$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/github/kittinunf/fuel/core/Client;", "client", "getClient", "()Lcom/github/kittinunf/fuel/core/Client;", "setClient", "(Lcom/github/kittinunf/fuel/core/Client;)V", "client$delegate", "Ljava/util/concurrent/ExecutorService;", "executorService", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "setExecutorService", "(Ljava/util/concurrent/ExecutorService;)V", "executorService$delegate", "forceMethods", "", "getForceMethods", "()Z", "setForceMethods", "(Z)V", "hook", "Lcom/github/kittinunf/fuel/core/Client$Hook;", "getHook", "()Lcom/github/kittinunf/fuel/core/Client$Hook;", "setHook", "(Lcom/github/kittinunf/fuel/core/Client$Hook;)V", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "getHostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)V", "hostnameVerifier$delegate", "keystore", "Ljava/security/KeyStore;", "getKeystore", "()Ljava/security/KeyStore;", "setKeystore", "(Ljava/security/KeyStore;)V", "progressBufferSize", "", "getProgressBufferSize", "()I", "setProgressBufferSize", "(I)V", "progressBufferSize$1", "proxy", "Ljava/net/Proxy;", "getProxy", "()Ljava/net/Proxy;", "setProxy", "(Ljava/net/Proxy;)V", "requestInterceptors", "", "Lkotlin/Function1;", "Lcom/github/kittinunf/fuel/core/Request;", "Lcom/github/kittinunf/fuel/core/RequestTransformer;", "Lcom/github/kittinunf/fuel/core/FoldableRequestInterceptor;", "responseInterceptors", "Lkotlin/Function2;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/fuel/core/ResponseTransformer;", "Lcom/github/kittinunf/fuel/core/FoldableResponseInterceptor;", "Ljavax/net/ssl/SSLSocketFactory;", "socketFactory", "getSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "setSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)V", "socketFactory$delegate", "timeoutInMillisecond", "getTimeoutInMillisecond", "setTimeoutInMillisecond", "timeoutReadInMillisecond", "getTimeoutReadInMillisecond", "setTimeoutReadInMillisecond", "addRequestInterceptor", "interceptor", "addResponseInterceptor", "applyOptions", "request", "delete", "convertible", "Lcom/github/kittinunf/fuel/core/RequestFactory$PathStringConvertible;", "parameters", "path", "download", "Lcom/github/kittinunf/fuel/core/requests/DownloadRequest;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "get", "head", "patch", "post", "put", "removeAllRequestInterceptors", "removeAllResponseInterceptors", "removeRequestInterceptor", "removeResponseInterceptor", "Lcom/github/kittinunf/fuel/core/RequestFactory$RequestConvertible;", "reset", "upload", "Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final class FuelManager implements RequestFactory, RequestFactory.Convenience {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(FuelManager.class, "client", "getClient()Lcom/github/kittinunf/fuel/core/Client;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(FuelManager.class, "socketFactory", "getSocketFactory()Ljavax/net/ssl/SSLSocketFactory;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(FuelManager.class, "hostnameVerifier", "getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(FuelManager.class, "executorService", "getExecutorService()Ljava/util/concurrent/ExecutorService;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(FuelManager.class, "callbackExecutor", "getCallbackExecutor()Ljava/util/concurrent/Executor;", 0))};

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReadWriteProperty instance$delegate = DelegatesKt.readWriteLazy(FuelManager$Companion$instance$2.INSTANCE);
    private Map<String, String> baseHeaders;
    private String basePath;
    private boolean forceMethods;
    private KeyStore keystore;
    private Proxy proxy;

    /* INFO: renamed from: client$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty client = DelegatesKt.readWriteLazy(new FuelManager$client$2(this));
    private int timeoutInMillisecond = 15000;
    private int timeoutReadInMillisecond = 15000;

    /* INFO: renamed from: progressBufferSize$1, reason: from kotlin metadata */
    private int progressBufferSize = 8192;
    private Client.Hook hook = new DefaultHook();
    private List<? extends Pair<String, ? extends Object>> baseParams = CollectionsKt.emptyList();

    /* INFO: renamed from: socketFactory$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty socketFactory = DelegatesKt.readWriteLazy(new FuelManager$socketFactory$2(this));

    /* INFO: renamed from: hostnameVerifier$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty hostnameVerifier = DelegatesKt.readWriteLazy(FuelManager$hostnameVerifier$2.INSTANCE);

    /* INFO: renamed from: executorService$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty executorService = DelegatesKt.readWriteLazy(FuelManager$executorService$2.INSTANCE);
    private final List<Function1<Function1<? super Request, ? extends Request>, Function1<Request, Request>>> requestInterceptors = CollectionsKt.mutableListOf(ParameterEncoder.INSTANCE);
    private final List<Function1<Function2<? super Request, ? super Response, Response>, Function2<Request, Response, Response>>> responseInterceptors = CollectionsKt.mutableListOf(RedirectionInterceptorKt.redirectResponseInterceptor(this));

    /* INFO: renamed from: callbackExecutor$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty callbackExecutor = DelegatesKt.readWriteLazy(FuelManager$callbackExecutor$2.INSTANCE);

    public final Executor getCallbackExecutor() {
        return (Executor) this.callbackExecutor.getValue(this, $$delegatedProperties[4]);
    }

    public final Client getClient() {
        return (Client) this.client.getValue(this, $$delegatedProperties[0]);
    }

    public final ExecutorService getExecutorService() {
        return (ExecutorService) this.executorService.getValue(this, $$delegatedProperties[3]);
    }

    public final HostnameVerifier getHostnameVerifier() {
        return (HostnameVerifier) this.hostnameVerifier.getValue(this, $$delegatedProperties[2]);
    }

    public final SSLSocketFactory getSocketFactory() {
        return (SSLSocketFactory) this.socketFactory.getValue(this, $$delegatedProperties[1]);
    }

    public final void setCallbackExecutor(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "<set-?>");
        this.callbackExecutor.setValue(this, $$delegatedProperties[4], executor);
    }

    public final void setClient(Client client) {
        Intrinsics.checkNotNullParameter(client, "<set-?>");
        this.client.setValue(this, $$delegatedProperties[0], client);
    }

    public final void setExecutorService(ExecutorService executorService) {
        Intrinsics.checkNotNullParameter(executorService, "<set-?>");
        this.executorService.setValue(this, $$delegatedProperties[3], executorService);
    }

    public final void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        Intrinsics.checkNotNullParameter(hostnameVerifier, "<set-?>");
        this.hostnameVerifier.setValue(this, $$delegatedProperties[2], hostnameVerifier);
    }

    public final void setSocketFactory(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter(sSLSocketFactory, "<set-?>");
        this.socketFactory.setValue(this, $$delegatedProperties[1], sSLSocketFactory);
    }

    public final Proxy getProxy() {
        return this.proxy;
    }

    public final void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public final String getBasePath() {
        return this.basePath;
    }

    public final void setBasePath(String str) {
        this.basePath = str;
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

    public final int getProgressBufferSize() {
        return this.progressBufferSize;
    }

    public final void setProgressBufferSize(int i) {
        this.progressBufferSize = i;
    }

    public final Client.Hook getHook() {
        return this.hook;
    }

    public final void setHook(Client.Hook hook) {
        Intrinsics.checkNotNullParameter(hook, "<set-?>");
        this.hook = hook;
    }

    public final Map<String, String> getBaseHeaders() {
        return this.baseHeaders;
    }

    public final void setBaseHeaders(Map<String, String> map) {
        this.baseHeaders = map;
    }

    public final List<Pair<String, Object>> getBaseParams() {
        return this.baseParams;
    }

    public final void setBaseParams(List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.baseParams = list;
    }

    public final KeyStore getKeystore() {
        return this.keystore;
    }

    public final void setKeystore(KeyStore keyStore) {
        this.keystore = keyStore;
    }

    public final boolean getForceMethods() {
        return this.forceMethods;
    }

    public final void setForceMethods(boolean z) {
        this.forceMethods = z;
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory
    public Request request(Method method, String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(path, "path");
        return applyOptions(request(new Encoding(method, path, this.basePath, parameters == null ? this.baseParams : CollectionsKt.plus((Collection) this.baseParams, (Iterable) parameters)).getRequest()));
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory
    public Request request(Method method, RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return request(method, convertible.getPath(), parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory
    public Request request(RequestFactory.RequestConvertible convertible) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return applyOptions(convertible.getRequest());
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public DownloadRequest download(String path, Method method, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(method, "method");
        return DownloadRequestKt.download(applyOptions(new Encoding(method, path, this.basePath, parameters == null ? this.baseParams : CollectionsKt.plus((Collection) this.baseParams, (Iterable) parameters)).getRequest()));
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public UploadRequest upload(String path, Method method, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(method, "method");
        return UploadRequestKt.upload(applyOptions(new Encoding(method, path, this.basePath, parameters == null ? this.baseParams : CollectionsKt.plus((Collection) this.baseParams, (Iterable) parameters)).getRequest()));
    }

    public final FuelManager addRequestInterceptor(Function1<? super Function1<? super Request, ? extends Request>, ? extends Function1<? super Request, ? extends Request>> interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.requestInterceptors.add(interceptor);
        return this;
    }

    public final FuelManager addResponseInterceptor(Function1<? super Function2<? super Request, ? super Response, Response>, ? extends Function2<? super Request, ? super Response, Response>> interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.responseInterceptors.add(interceptor);
        return this;
    }

    public final FuelManager removeRequestInterceptor(Function1<? super Function1<? super Request, ? extends Request>, ? extends Function1<? super Request, ? extends Request>> interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.requestInterceptors.remove(interceptor);
        return this;
    }

    public final FuelManager removeResponseInterceptor(Function1<? super Function2<? super Request, ? super Response, Response>, ? extends Function2<? super Request, ? super Response, Response>> interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.responseInterceptors.remove(interceptor);
        return this;
    }

    public final FuelManager removeAllRequestInterceptors() {
        this.requestInterceptors.clear();
        return this;
    }

    public final FuelManager removeAllResponseInterceptors() {
        this.responseInterceptors.clear();
        return this;
    }

    private final Request applyOptions(Request request) {
        Set<String> setKeySet = request.getHeaders().keySet();
        Headers.Companion companion = Headers.INSTANCE;
        Map<String, String> mapEmptyMap = this.baseHeaders;
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Headers headersFrom = companion.from(mapEmptyMap);
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            headersFrom.remove(it.next());
        }
        Request requestHeader = request.header(headersFrom);
        Client client = getClient();
        SSLSocketFactory socketFactory = getSocketFactory();
        HostnameVerifier hostnameVerifier = getHostnameVerifier();
        Executor callbackExecutor = getCallbackExecutor();
        List<Function1<Function1<? super Request, ? extends Request>, Function1<Request, Request>>> list = this.requestInterceptors;
        Function1<Request, Request> function1Invoke = FuelManager$applyOptions$1$1.INSTANCE;
        if (!list.isEmpty()) {
            ListIterator<Function1<Function1<? super Request, ? extends Request>, Function1<Request, Request>>> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                function1Invoke = listIterator.previous().invoke(function1Invoke);
            }
        }
        Function1<Request, Request> function1 = function1Invoke;
        List<Function1<Function2<? super Request, ? super Response, Response>, Function2<Request, Response, Response>>> list2 = this.responseInterceptors;
        Function2<Request, Response, Response> function2Invoke = FuelManager$applyOptions$1$3.INSTANCE;
        if (!list2.isEmpty()) {
            ListIterator<Function1<Function2<? super Request, ? super Response, Response>, Function2<Request, Response, Response>>> listIterator2 = list2.listIterator(list2.size());
            while (listIterator2.hasPrevious()) {
                function2Invoke = listIterator2.previous().invoke(function2Invoke);
            }
        }
        RequestExecutionOptions requestExecutionOptions = new RequestExecutionOptions(client, socketFactory, hostnameVerifier, getExecutorService(), callbackExecutor, function1, function2Invoke);
        requestExecutionOptions.setTimeoutInMillisecond(this.timeoutInMillisecond);
        requestExecutionOptions.setTimeoutReadInMillisecond(this.timeoutReadInMillisecond);
        requestExecutionOptions.setForceMethods(this.forceMethods);
        Unit unit = Unit.INSTANCE;
        requestHeader.setExecutionOptions(requestExecutionOptions);
        return requestHeader;
    }

    /* INFO: compiled from: FuelManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/github/kittinunf/fuel/core/FuelManager$Companion;", "", "()V", "<set-?>", "Lcom/github/kittinunf/fuel/core/FuelManager;", "instance", "getInstance", "()Lcom/github/kittinunf/fuel/core/FuelManager;", "setInstance", "(Lcom/github/kittinunf/fuel/core/FuelManager;)V", "instance$delegate", "Lkotlin/properties/ReadWriteProperty;", "progressBufferSize", "", "getProgressBufferSize", "()I", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "instance", "getInstance()Lcom/github/kittinunf/fuel/core/FuelManager;", 0))};

        public final FuelManager getInstance() {
            return (FuelManager) FuelManager.instance$delegate.getValue(FuelManager.INSTANCE, $$delegatedProperties[0]);
        }

        public final void setInstance(FuelManager fuelManager) {
            Intrinsics.checkNotNullParameter(fuelManager, "<set-?>");
            FuelManager.instance$delegate.setValue(FuelManager.INSTANCE, $$delegatedProperties[0], fuelManager);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getProgressBufferSize() {
            return FuelManager.INSTANCE.getInstance().getProgressBufferSize();
        }
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request get(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return request(Method.GET, path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request get(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return request(Method.GET, convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request post(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return request(Method.POST, path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request post(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return request(Method.POST, convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request put(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return request(Method.PUT, path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request put(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return request(Method.PUT, convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request patch(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return request(Method.PATCH, path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request patch(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return request(Method.PATCH, convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request delete(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return request(Method.DELETE, path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request delete(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return request(Method.DELETE, convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public DownloadRequest download(RequestFactory.PathStringConvertible convertible, Method method, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        Intrinsics.checkNotNullParameter(method, "method");
        return download(convertible.getPath(), method, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public UploadRequest upload(RequestFactory.PathStringConvertible convertible, Method method, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        Intrinsics.checkNotNullParameter(method, "method");
        return upload(convertible.getPath(), method, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request head(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return request(Method.HEAD, path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request head(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return request(Method.HEAD, convertible, parameters);
    }

    public final FuelManager reset() {
        FuelManager fuelManager = new FuelManager();
        setClient(fuelManager.getClient());
        this.proxy = fuelManager.proxy;
        this.basePath = fuelManager.basePath;
        this.timeoutInMillisecond = fuelManager.timeoutInMillisecond;
        this.timeoutReadInMillisecond = fuelManager.timeoutReadInMillisecond;
        this.baseHeaders = fuelManager.baseHeaders;
        this.baseParams = fuelManager.baseParams;
        this.keystore = fuelManager.keystore;
        setSocketFactory(fuelManager.getSocketFactory());
        setHostnameVerifier(fuelManager.getHostnameVerifier());
        setExecutorService(fuelManager.getExecutorService());
        List<Function1<Function1<? super Request, ? extends Request>, Function1<Request, Request>>> list = this.requestInterceptors;
        list.clear();
        list.addAll(fuelManager.requestInterceptors);
        List<Function1<Function2<? super Request, ? super Response, Response>, Function2<Request, Response, Response>>> list2 = this.responseInterceptors;
        list2.clear();
        list2.addAll(fuelManager.responseInterceptors);
        setCallbackExecutor(fuelManager.getCallbackExecutor());
        return this;
    }
}
