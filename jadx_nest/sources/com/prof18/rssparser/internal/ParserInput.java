package com.prof18.rssparser.internal;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: ParserInput.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/prof18/rssparser/internal/ParserInput;", "", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "getInputStream", "()Ljava/io/InputStream;", "component1", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ParserInput {
    private final InputStream inputStream;

    public static /* synthetic */ ParserInput copy$default(ParserInput parserInput, InputStream inputStream, int i, Object obj) {
        if ((i & 1) != 0) {
            inputStream = parserInput.inputStream;
        }
        return parserInput.copy(inputStream);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final InputStream getInputStream() {
        return this.inputStream;
    }

    public final ParserInput copy(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return new ParserInput(inputStream);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ParserInput) && Intrinsics.areEqual(this.inputStream, ((ParserInput) other).inputStream);
    }

    public int hashCode() {
        return this.inputStream.hashCode();
    }

    public String toString() {
        return "ParserInput(inputStream=" + this.inputStream + ")";
    }

    public ParserInput(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        this.inputStream = inputStream;
    }

    public final InputStream getInputStream() {
        return this.inputStream;
    }
}
