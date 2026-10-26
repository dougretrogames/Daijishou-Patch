package com.prof18.rssparser.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: HttpException.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/prof18/rssparser/exception/HttpException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "hashCode", "toString", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class HttpException extends Exception {
    private final int code;
    private final String message;

    public static /* synthetic */ HttpException copy$default(HttpException httpException, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = httpException.code;
        }
        if ((i2 & 2) != 0) {
            str = httpException.message;
        }
        return httpException.copy(i, str);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final HttpException copy(int code, String message) {
        return new HttpException(code, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpException)) {
            return false;
        }
        HttpException httpException = (HttpException) other;
        return this.code == httpException.code && Intrinsics.areEqual(this.message, httpException.message);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.message;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "HttpException(code=" + this.code + ", message=" + this.message + ")";
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public HttpException(int i, String str) {
        this.code = i;
        this.message = str;
    }
}
