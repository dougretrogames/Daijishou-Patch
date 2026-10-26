package com.haroldadmin.cnradapter;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;

/* INFO: compiled from: Extensions.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0083\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2(\u0010\f\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00040\rH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a4\u0010\u0010\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0086\u0002¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"executeWithRetry", "Lcom/haroldadmin/cnradapter/NetworkResponse;", ExifInterface.GPS_DIRECTION_TRUE, "U", "", "times", "", "initialDelay", "", "maxDelay", "factor", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(IJJDLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "(Lcom/haroldadmin/cnradapter/NetworkResponse;)Ljava/lang/Object;", "coroutines-network-response-adapter"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsKt {

    /* INFO: renamed from: com.haroldadmin.cnradapter.ExtensionsKt$executeWithRetry$1, reason: invalid class name */
    /* INFO: compiled from: Extensions.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
    @DebugMetadata(c = "com.haroldadmin.cnradapter.ExtensionsKt", f = "Extensions.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {27, 29, 35}, m = "executeWithRetry", n = {"block", "currentDelay", "maxDelay", "factor", "block", "currentDelay", "maxDelay", "factor"}, s = {"L$0", "L$1", "J$0", "D$0", "L$0", "L$1", "J$0", "D$0"})
    static final class AnonymousClass1<T, U> extends ContinuationImpl {
        double D$0;
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtensionsKt.executeWithRetry(0, 0L, 0L, 0.0d, null, this);
        }
    }

    /* WARN: Code duplicated, block: B:22:0x0088  */
    /* WARN: Code duplicated, block: B:25:0x009f  */
    /* WARN: Code duplicated, block: B:28:0x00b3  */
    /* WARN: Code duplicated, block: B:32:0x00d6 A[RETURN] */
    /* WARN: Code duplicated, block: B:33:0x00d7  */
    /* WARN: Code duplicated, block: B:36:0x00e5 A[RETURN] */
    /* WARN: Code duplicated, block: B:7:0x0016  */
    /* WARN: Code restructure failed: missing block: B:29:0x00c7, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r14, r1) == r2) goto L35;
     */
    /* WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00c7 -> B:18:0x004d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T, U> java.lang.Object executeWithRetry(int r19, long r20, long r22, double r24, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.haroldadmin.cnradapter.NetworkResponse<T, U>>, ? extends java.lang.Object> r26, kotlin.coroutines.Continuation<? super com.haroldadmin.cnradapter.NetworkResponse<T, U>> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.haroldadmin.cnradapter.ExtensionsKt.executeWithRetry(int, long, long, double, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <T, U> Object executeWithRetry$$forInline(int i, long j, long j2, double d, Function1<? super Continuation<? super NetworkResponse<T, U>>, ? extends Object> function1, Continuation<? super NetworkResponse<T, U>> continuation) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 < i2) {
            i3++;
            NetworkResponse networkResponse = (NetworkResponse) function1.invoke(null);
            if (!(networkResponse instanceof NetworkResponse.NetworkError)) {
                return networkResponse;
            }
            DelayKt.delay(j, null);
            j = RangesKt.coerceAtMost((long) (j * d), j2);
        }
        return function1.invoke(continuation);
    }

    public static /* synthetic */ Object executeWithRetry$default(int i, long j, long j2, double d, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 10;
        }
        if ((i2 & 2) != 0) {
            j = 100;
        }
        if ((i2 & 4) != 0) {
            j2 = 1000;
        }
        if ((i2 & 8) != 0) {
            d = 2.0d;
        }
        int i3 = i - 1;
        int i4 = 0;
        while (i4 < i3) {
            i4++;
            NetworkResponse networkResponse = (NetworkResponse) function1.invoke(null);
            if (!(networkResponse instanceof NetworkResponse.NetworkError)) {
                return networkResponse;
            }
            DelayKt.delay(j, null);
            j = RangesKt.coerceAtMost((long) (j * d), j2);
        }
        return function1.invoke(continuation);
    }

    public static final <T, U> T invoke(NetworkResponse<T, U> networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "<this>");
        if (networkResponse instanceof NetworkResponse.Success) {
            return (T) ((NetworkResponse.Success) networkResponse).getBody();
        }
        return null;
    }
}
