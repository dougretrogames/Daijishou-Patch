package com.github.kittinunf.fuel.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: HttpException.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/github/kittinunf/fuel/core/HttpException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "httpCode", "", "httpMessage", "", "(ILjava/lang/String;)V", "fuel"}, k = 1, mv = {1, 4, 0})
public final class HttpException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(int i, String httpMessage) {
        super("HTTP Exception " + i + TokenParser.SP + httpMessage);
        Intrinsics.checkNotNullParameter(httpMessage, "httpMessage");
    }
}
