package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: Response.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003*4\u0010\b\u001a\u0004\b\u0000\u0010\t\"\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\t0\n2\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\t0\n*L\u0010\f\u001a\u0004\b\u0000\u0010\t\" \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u000e0\r0\n2 \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u000e0\r0\n¨\u0006\u000f"}, d2 = {"isClientError", "", "Lcom/github/kittinunf/fuel/core/Response;", "(Lcom/github/kittinunf/fuel/core/Response;)Z", "isServerError", "isStatusInformational", "isStatusRedirection", "isSuccessful", "ResponseOf", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/Request;", "ResponseResultOf", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class ResponseKt {
    public static final boolean isStatusInformational(Response isStatusInformational) {
        Intrinsics.checkNotNullParameter(isStatusInformational, "$this$isStatusInformational");
        return isStatusInformational.getStatusCode() / 100 == 1;
    }

    public static final boolean isSuccessful(Response isSuccessful) {
        Intrinsics.checkNotNullParameter(isSuccessful, "$this$isSuccessful");
        return isSuccessful.getStatusCode() / 100 == 2;
    }

    public static final boolean isStatusRedirection(Response isStatusRedirection) {
        Intrinsics.checkNotNullParameter(isStatusRedirection, "$this$isStatusRedirection");
        return isStatusRedirection.getStatusCode() / 100 == 3;
    }

    public static final boolean isClientError(Response isClientError) {
        Intrinsics.checkNotNullParameter(isClientError, "$this$isClientError");
        return isClientError.getStatusCode() / 100 == 4;
    }

    public static final boolean isServerError(Response isServerError) {
        Intrinsics.checkNotNullParameter(isServerError, "$this$isServerError");
        return isServerError.getStatusCode() / 100 == 5;
    }
}
