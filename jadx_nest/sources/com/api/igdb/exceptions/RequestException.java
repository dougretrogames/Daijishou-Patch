package com.api.igdb.exceptions;

import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.result.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequestException.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/api/igdb/exceptions/RequestException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "statusCode", "", "request", "Lcom/github/kittinunf/fuel/core/Request;", "result", "Lcom/github/kittinunf/result/Result;", "", "Lcom/github/kittinunf/fuel/core/FuelError;", "(ILcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/result/Result;)V", "getRequest", "()Lcom/github/kittinunf/fuel/core/Request;", "getResult", "()Lcom/github/kittinunf/result/Result;", "getStatusCode", "()I", "igdb-api-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RequestException extends Exception {
    private final Request request;
    private final Result<String, FuelError> result;
    private final int statusCode;

    /* JADX WARN: Multi-variable type inference failed */
    public RequestException(int i, Request request, Result<String, ? extends FuelError> result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        this.statusCode = i;
        this.request = request;
        this.result = result;
    }

    public final Request getRequest() {
        return this.request;
    }

    public final Result<String, FuelError> getResult() {
        return this.result;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}
