package com.prof18.rssparser.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: RssParsingException.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/prof18/rssparser/exception/RssParsingException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "getMessage", "()Ljava/lang/String;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "hashCode", "", "toString", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class RssParsingException extends Exception {
    private final Throwable cause;
    private final String message;

    public static /* synthetic */ RssParsingException copy$default(RssParsingException rssParsingException, String str, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rssParsingException.message;
        }
        if ((i & 2) != 0) {
            th = rssParsingException.cause;
        }
        return rssParsingException.copy(str, th);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final Throwable getCause() {
        return this.cause;
    }

    public final RssParsingException copy(String message, Throwable cause) {
        return new RssParsingException(message, cause);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RssParsingException)) {
            return false;
        }
        RssParsingException rssParsingException = (RssParsingException) other;
        return Intrinsics.areEqual(this.message, rssParsingException.message) && Intrinsics.areEqual(this.cause, rssParsingException.cause);
    }

    public int hashCode() {
        String str = this.message;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Throwable th = this.cause;
        return iHashCode + (th != null ? th.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "RssParsingException(message=" + this.message + ", cause=" + this.cause + ")";
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public RssParsingException(String str, Throwable th) {
        this.message = str;
        this.cause = th;
    }
}
