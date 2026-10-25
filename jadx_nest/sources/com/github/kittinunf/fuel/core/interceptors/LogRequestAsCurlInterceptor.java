package com.github.kittinunf.fuel.core.interceptors;

import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.extensions.FormattingKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: LoggingInterceptors.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u000022\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u00030\u0001j\u0002`\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J1\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003H\u0096\u0002¨\u0006\b"}, d2 = {"Lcom/github/kittinunf/fuel/core/interceptors/LogRequestAsCurlInterceptor;", "Lkotlin/Function1;", "Lcom/github/kittinunf/fuel/core/Request;", "Lcom/github/kittinunf/fuel/core/RequestTransformer;", "Lcom/github/kittinunf/fuel/core/FoldableRequestInterceptor;", "()V", "invoke", "next", "fuel"}, k = 1, mv = {1, 4, 0})
public final class LogRequestAsCurlInterceptor implements Function1<Function1<? super Request, ? extends Request>, Function1<? super Request, ? extends Request>> {
    public static final LogRequestAsCurlInterceptor INSTANCE = new LogRequestAsCurlInterceptor();

    private LogRequestAsCurlInterceptor() {
    }

    /* JADX INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.LogRequestAsCurlInterceptor$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoggingInterceptors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Request;", "request", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function1<Request, Request> {
        final /* synthetic */ Function1 $next;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1) {
            super(1);
            this.$next = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Request invoke(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            System.out.println((Object) FormattingKt.cUrlString(request));
            return (Request) this.$next.invoke(request);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public Function1<Request, Request> invoke(Function1<? super Request, ? extends Request> next) {
        Intrinsics.checkNotNullParameter(next, "next");
        return new AnonymousClass1(next);
    }
}
