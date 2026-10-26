package com.github.kittinunf.fuel.core.interceptors;

import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: LoggingInterceptors.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002>\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00050\u0001j\u0002`\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007J=\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0096\u0002¨\u0006\n"}, d2 = {"Lcom/github/kittinunf/fuel/core/interceptors/LogResponseInterceptor;", "Lkotlin/Function1;", "Lkotlin/Function2;", "Lcom/github/kittinunf/fuel/core/Request;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/fuel/core/ResponseTransformer;", "Lcom/github/kittinunf/fuel/core/FoldableResponseInterceptor;", "()V", "invoke", "next", "fuel"}, k = 1, mv = {1, 4, 0})
public final class LogResponseInterceptor implements Function1<Function2<? super Request, ? super Response, ? extends Response>, Function2<? super Request, ? super Response, ? extends Response>> {
    public static final LogResponseInterceptor INSTANCE = new LogResponseInterceptor();

    private LogResponseInterceptor() {
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Function2<? super Request, ? super Response, ? extends Response> invoke(Function2<? super Request, ? super Response, ? extends Response> function2) {
        return invoke2((Function2<? super Request, ? super Response, Response>) function2);
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.LogResponseInterceptor$invoke$1, reason: invalid class name */
    /* INFO: compiled from: LoggingInterceptors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Response;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "response", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function2<Request, Response, Response> {
        final /* synthetic */ Function2 $next;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function2 function2) {
            super(2);
            this.$next = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Response invoke(Request request, Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            System.out.println((Object) response.toString());
            return (Response) this.$next.invoke(request, response);
        }
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Function2<Request, Response, Response> invoke2(Function2<? super Request, ? super Response, Response> next) {
        Intrinsics.checkNotNullParameter(next, "next");
        return new AnonymousClass1(next);
    }
}
