package com.github.kittinunf.fuel.core;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* INFO: compiled from: FuelError.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001d2\u00060\u0001j\u0002`\u0002:\u0001\u001dB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JA\u0010\u0014\u001a\u000e\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015j\u0002`\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015j\u0002`\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015j\u0002`\u0017H\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/github/kittinunf/fuel/core/FuelError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "", "response", "Lcom/github/kittinunf/fuel/core/Response;", "(Ljava/lang/Throwable;Lcom/github/kittinunf/fuel/core/Response;)V", "causedByInterruption", "", "getCausedByInterruption", "()Z", "errorData", "", "getErrorData", "()[B", "getException", "()Ljava/lang/Throwable;", "getResponse", "()Lcom/github/kittinunf/fuel/core/Response;", "buildRelativeStack", "", "Ljava/lang/StackTraceElement;", "Lcom/github/kittinunf/fuel/core/StackTrace;", "wrapped", "cause", "([Ljava/lang/StackTraceElement;[Ljava/lang/StackTraceElement;)[Ljava/lang/StackTraceElement;", "toString", "", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public class FuelError extends Exception {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Response response;

    public /* synthetic */ FuelError(Throwable th, Response response, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? Response.Companion.error$default(Response.INSTANCE, null, 1, null) : response);
    }

    public final Response getResponse() {
        return this.response;
    }

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FuelError(Throwable exception, Response response) {
        super(exception.getMessage(), exception);
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(response, "response");
        this.response = response;
        StackTraceElement[] stackTrace = getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "this.stackTrace");
        StackTraceElement[] stackTrace2 = exception.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace2, "exception.stackTrace");
        setStackTrace(buildRelativeStack(stackTrace, stackTrace2));
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = getException().getMessage();
        if (message == null) {
            message = getException().getClass().getCanonicalName();
        }
        StringBuilder sbAppend = new StringBuilder().append(sb.append(message).append("\r\n").toString());
        StringBuilder sb2 = new StringBuilder();
        StackTraceElement[] stackTrace = getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            StringBuilder sbAppend2 = sb2.append("\t" + stackTraceElement);
            Intrinsics.checkNotNullExpressionValue(sbAppend2, "append(value)");
            StringsKt.appendln(sbAppend2);
        }
        Throwable cause = getCause();
        if (cause != null) {
            sb2.append("Caused by: ");
            StringBuilder sbAppend3 = sb2.append(cause.toString());
            Intrinsics.checkNotNullExpressionValue(sbAppend3, "append(value)");
            StringsKt.appendln(sbAppend3);
            if (!(cause instanceof FuelError)) {
                StackTraceElement[] stackTrace2 = cause.getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace2, "it.stackTrace");
                for (StackTraceElement stackTraceElement2 : stackTrace2) {
                    StringBuilder sbAppend4 = sb2.append("\t" + stackTraceElement2);
                    Intrinsics.checkNotNullExpressionValue(sbAppend4, "append(value)");
                    StringsKt.appendln(sbAppend4);
                }
            }
        }
        Unit unit = Unit.INSTANCE;
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return sbAppend.append(string).toString();
    }

    public final Throwable getException() {
        FuelError cause = this;
        while ((cause instanceof FuelError) && cause.getCause() != null) {
            cause = cause.getCause();
            Intrinsics.checkNotNull(cause);
        }
        return cause;
    }

    public final byte[] getErrorData() {
        return this.response.getData();
    }

    public final boolean getCausedByInterruption() {
        return (getException() instanceof InterruptedException) || (getException() instanceof InterruptedIOException);
    }

    /* INFO: compiled from: FuelError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/github/kittinunf/fuel/core/FuelError$Companion;", "", "()V", "wrap", "Lcom/github/kittinunf/fuel/core/FuelError;", "it", "", "response", "Lcom/github/kittinunf/fuel/core/Response;", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FuelError wrap$default(Companion companion, Throwable th, Response response, int i, Object obj) {
            if ((i & 2) != 0) {
                response = Response.Companion.error$default(Response.INSTANCE, null, 1, null);
            }
            return companion.wrap(th, response);
        }

        public final FuelError wrap(Throwable it, Response response) {
            Intrinsics.checkNotNullParameter(it, "it");
            Intrinsics.checkNotNullParameter(response, "response");
            if (it instanceof BubbleFuelError) {
                return new BubbleFuelError(((BubbleFuelError) it).getInner());
            }
            return it instanceof FuelError ? new BubbleFuelError((FuelError) it) : new FuelError(it, response);
        }
    }

    private final StackTraceElement[] buildRelativeStack(StackTraceElement[] wrapped, StackTraceElement[] cause) {
        StackTraceElement stackTraceElement;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement2 : wrapped) {
            int length = cause.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    stackTraceElement = null;
                    break;
                }
                stackTraceElement = cause[i];
                if (Intrinsics.areEqual(stackTraceElement, stackTraceElement2)) {
                    break;
                }
                i++;
            }
            if (stackTraceElement != null) {
                break;
            }
            arrayList.add(stackTraceElement2);
        }
        Object[] array = arrayList.toArray(new StackTraceElement[0]);
        if (array != null) {
            return (StackTraceElement[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
