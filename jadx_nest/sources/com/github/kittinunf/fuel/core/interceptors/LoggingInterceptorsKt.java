package com.github.kittinunf.fuel.core.interceptors;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.fuel.core.extensions.FormattingKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: LoggingInterceptors.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0001H\u0007\u001a2\u0010\u0003\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00040\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00040\u00010\u0001\"\u0004\b\u0000\u0010\u0004H\u0007\u001a\u001a\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¨\u0006\b"}, d2 = {"cUrlLoggingRequestInterceptor", "Lkotlin/Function1;", "Lcom/github/kittinunf/fuel/core/Request;", "loggingRequestInterceptor", ExifInterface.GPS_DIRECTION_TRUE, "loggingResponseInterceptor", "Lkotlin/Function2;", "Lcom/github/kittinunf/fuel/core/Response;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class LoggingInterceptorsKt {

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.LoggingInterceptorsKt$loggingRequestInterceptor$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: LoggingInterceptors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/Function1;", ExifInterface.GPS_DIRECTION_TRUE, "next", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class C01921<T> extends Lambda implements Function1<Function1<? super T, ? extends T>, Function1<? super T, ? extends T>> {
        public static final C01921 INSTANCE = new C01921();

        C01921() {
            super(1);
        }

        /* INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.LoggingInterceptorsKt$loggingRequestInterceptor$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: LoggingInterceptors.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "t", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
        static final class C00301 extends Lambda implements Function1<T, T> {
            final /* synthetic */ Function1 $next;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00301(Function1 function1) {
                super(1);
                this.$next = function1;
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(T t) {
                System.out.println(t);
                return (T) this.$next.invoke(t);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Function1<T, T> invoke(Function1<? super T, ? extends T> next) {
            Intrinsics.checkNotNullParameter(next, "next");
            return new C00301(next);
        }
    }

    @Deprecated(message = "Use LogRequestInterceptor", replaceWith = @ReplaceWith(expression = "LogRequestInterceptor", imports = {}))
    public static final <T> Function1<Function1<? super T, ? extends T>, Function1<T, T>> loggingRequestInterceptor() {
        return C01921.INSTANCE;
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.LoggingInterceptorsKt$cUrlLoggingRequestInterceptor$1, reason: invalid class name */
    /* INFO: compiled from: LoggingInterceptors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/github/kittinunf/fuel/core/Request;", "next", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function1<Function1<? super Request, ? extends Request>, Function1<? super Request, ? extends Request>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.LoggingInterceptorsKt$cUrlLoggingRequestInterceptor$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: LoggingInterceptors.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Request;", "r", "invoke"}, k = 3, mv = {1, 4, 0})
        static final class C00291 extends Lambda implements Function1<Request, Request> {
            final /* synthetic */ Function1 $next;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00291(Function1 function1) {
                super(1);
                this.$next = function1;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Request invoke(Request r) {
                Intrinsics.checkNotNullParameter(r, "r");
                System.out.println((Object) FormattingKt.cUrlString(r));
                return (Request) this.$next.invoke(r);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Function1<Request, Request> invoke(Function1<? super Request, ? extends Request> next) {
            Intrinsics.checkNotNullParameter(next, "next");
            return new C00291(next);
        }
    }

    @Deprecated(message = "Use LogRequestAsCurlInterceptor", replaceWith = @ReplaceWith(expression = "LogRequestAsCurlInterceptor", imports = {}))
    public static final Function1<Function1<? super Request, ? extends Request>, Function1<Request, Request>> cUrlLoggingRequestInterceptor() {
        return AnonymousClass1.INSTANCE;
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.LoggingInterceptorsKt$loggingResponseInterceptor$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: LoggingInterceptors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Response;", "<anonymous parameter 0>", "Lcom/github/kittinunf/fuel/core/Request;", "response", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class C01931 extends Lambda implements Function2<Request, Response, Response> {
        public static final C01931 INSTANCE = new C01931();

        C01931() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Response invoke(Request request, Response response) {
            Intrinsics.checkNotNullParameter(request, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(response, "response");
            System.out.println(response);
            return response;
        }
    }

    @Deprecated(message = "Use LogRequestAsCurlInterceptor (remove braces)", replaceWith = @ReplaceWith(expression = "LogResponseInterceptor", imports = {}))
    public static final Function2<Request, Response, Response> loggingResponseInterceptor() {
        return C01931.INSTANCE;
    }
}
