package com.github.kittinunf.fuel.core.interceptors;

import com.github.kittinunf.fuel.core.Encoding;
import com.github.kittinunf.fuel.core.FuelManager;
import com.github.kittinunf.fuel.core.Headers;
import com.github.kittinunf.fuel.core.Method;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.fuel.core.ResponseKt;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RedirectionInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0003\u001a2\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\b\u001a\u00020\t\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"redirectStatusWithGets", "", "", "redirectResponseInterceptor", "Lkotlin/Function1;", "Lkotlin/Function2;", "Lcom/github/kittinunf/fuel/core/Request;", "Lcom/github/kittinunf/fuel/core/Response;", "manager", "Lcom/github/kittinunf/fuel/core/FuelManager;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class RedirectionInterceptorKt {
    private static final List<Integer> redirectStatusWithGets = CollectionsKt.listOf((Object[]) new Integer[]{301, 302, 303});

    /* JADX INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.RedirectionInterceptorKt$redirectResponseInterceptor$1, reason: invalid class name */
    /* JADX INFO: compiled from: RedirectionInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Function2;", "Lcom/github/kittinunf/fuel/core/Request;", "Lcom/github/kittinunf/fuel/core/Response;", "next", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function1<Function2<? super Request, ? super Response, ? extends Response>, Function2<? super Request, ? super Response, ? extends Response>> {
        final /* synthetic */ FuelManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FuelManager fuelManager) {
            super(1);
            this.$manager = fuelManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Function2<? super Request, ? super Response, ? extends Response> invoke(Function2<? super Request, ? super Response, ? extends Response> function2) {
            return invoke2((Function2<? super Request, ? super Response, Response>) function2);
        }

        /* JADX INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.RedirectionInterceptorKt$redirectResponseInterceptor$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RedirectionInterceptor.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Response;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "response", "invoke"}, k = 3, mv = {1, 4, 0})
        static final class C00311 extends Lambda implements Function2<Request, Response, Response> {
            final /* synthetic */ Function2 $next;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00311(Function2 function2) {
                super(2);
                this.$next = function2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Response invoke(Request request, Response response) {
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!ResponseKt.isStatusRedirection(response) || Intrinsics.areEqual((Object) request.getExecutionOptions().getAllowRedirects(), (Object) false)) {
                    return (Response) this.$next.invoke(request, response);
                }
                Collection<String> collection = response.get("Location");
                if (collection.isEmpty()) {
                    collection = response.get("Content-Location");
                }
                String str = (String) CollectionsKt.lastOrNull(collection);
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    return (Response) this.$next.invoke(request, response);
                }
                URL url = new URI((String) CollectionsKt.first(StringsKt.split$default((CharSequence) str2, new char[]{'?'}, false, 0, 6, (Object) null))).isAbsolute() ? new URL(str) : new URL(request.getUrl(), str);
                Method method = RedirectionInterceptorKt.redirectStatusWithGets.contains(Integer.valueOf(response.getStatusCode())) ? Method.GET : request.getMethod();
                String string = url.toString();
                Intrinsics.checkNotNullExpressionValue(string, "newUrl.toString()");
                Request requestHeader = AnonymousClass1.this.$manager.request(new Encoding(method, string, null, null, 12, null)).header(Headers.INSTANCE.from(request.getHeaders()));
                if (!Intrinsics.areEqual(url.getHost(), request.getUrl().getHost())) {
                    requestHeader.getHeaders().remove((Object) "Authorization");
                }
                Request requestResponseProgress = requestHeader.requestProgress(request.getExecutionOptions().getRequestProgress()).responseProgress(request.getExecutionOptions().getResponseProgress());
                if (method == request.getMethod() && !request.getBody().isEmpty() && !request.getBody().isConsumed()) {
                    requestResponseProgress = requestResponseProgress.body(request.getBody());
                }
                return (Response) this.$next.invoke(request, requestResponseProgress.response().getSecond());
            }
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Function2<Request, Response, Response> invoke2(Function2<? super Request, ? super Response, Response> next) {
            Intrinsics.checkNotNullParameter(next, "next");
            return new C00311(next);
        }
    }

    public static final Function1<Function2<? super Request, ? super Response, Response>, Function2<Request, Response, Response>> redirectResponseInterceptor(FuelManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        return new AnonymousClass1(manager);
    }
}
