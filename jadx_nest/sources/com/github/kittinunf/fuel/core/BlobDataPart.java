package com.github.kittinunf.fuel.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: DataPart.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JN\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\n\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006&"}, d2 = {"Lcom/github/kittinunf/fuel/core/BlobDataPart;", "Lcom/github/kittinunf/fuel/core/DataPart;", "inputStream", "Ljava/io/InputStream;", "name", "", "filename", "contentLength", "", "contentType", "contentDisposition", "(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getContentDisposition", "()Ljava/lang/String;", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContentType", "getFilename", "getInputStream", "()Ljava/io/InputStream;", "getName", "component1", "component2", "component3", "component4", "component5", "component6", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/github/kittinunf/fuel/core/BlobDataPart;", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class BlobDataPart extends DataPart {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String contentDisposition;
    private final Long contentLength;
    private final String contentType;
    private final String filename;
    private final InputStream inputStream;
    private final String name;

    public static /* synthetic */ BlobDataPart copy$default(BlobDataPart blobDataPart, InputStream inputStream, String str, String str2, Long l, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            inputStream = blobDataPart.inputStream;
        }
        if ((i & 2) != 0) {
            str = blobDataPart.name;
        }
        if ((i & 4) != 0) {
            str2 = blobDataPart.filename;
        }
        if ((i & 8) != 0) {
            l = blobDataPart.getContentLength();
        }
        if ((i & 16) != 0) {
            str3 = blobDataPart.getContentType();
        }
        if ((i & 32) != 0) {
            str4 = blobDataPart.getContentDisposition();
        }
        String str5 = str3;
        String str6 = str4;
        return blobDataPart.copy(inputStream, str, str2, l, str5, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final InputStream getInputStream() {
        return this.inputStream;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    public final Long component4() {
        return getContentLength();
    }

    public final String component5() {
        return getContentType();
    }

    public final String component6() {
        return getContentDisposition();
    }

    public final BlobDataPart copy(InputStream inputStream, String name, String filename, Long contentLength, String contentType, String contentDisposition) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentDisposition, "contentDisposition");
        return new BlobDataPart(inputStream, name, filename, contentLength, contentType, contentDisposition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlobDataPart)) {
            return false;
        }
        BlobDataPart blobDataPart = (BlobDataPart) other;
        return Intrinsics.areEqual(this.inputStream, blobDataPart.inputStream) && Intrinsics.areEqual(this.name, blobDataPart.name) && Intrinsics.areEqual(this.filename, blobDataPart.filename) && Intrinsics.areEqual(getContentLength(), blobDataPart.getContentLength()) && Intrinsics.areEqual(getContentType(), blobDataPart.getContentType()) && Intrinsics.areEqual(getContentDisposition(), blobDataPart.getContentDisposition());
    }

    public int hashCode() {
        InputStream inputStream = this.inputStream;
        int iHashCode = (inputStream != null ? inputStream.hashCode() : 0) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.filename;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long contentLength = getContentLength();
        int iHashCode4 = (iHashCode3 + (contentLength != null ? contentLength.hashCode() : 0)) * 31;
        String contentType = getContentType();
        int iHashCode5 = (iHashCode4 + (contentType != null ? contentType.hashCode() : 0)) * 31;
        String contentDisposition = getContentDisposition();
        return iHashCode5 + (contentDisposition != null ? contentDisposition.hashCode() : 0);
    }

    public String toString() {
        return "BlobDataPart(inputStream=" + this.inputStream + ", name=" + this.name + ", filename=" + this.filename + ", contentLength=" + getContentLength() + ", contentType=" + getContentType() + ", contentDisposition=" + getContentDisposition() + ")";
    }

    public final InputStream getInputStream() {
        return this.inputStream;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ BlobDataPart(InputStream inputStream, String str, String str2, Long l, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str5;
        Long l2;
        if ((i & 4) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        if ((i & 8) != 0) {
            l2 = null;
        } else {
            l2 = l;
        }
        String strGuessContentType = (i & 16) != 0 ? INSTANCE.guessContentType(inputStream) : str3;
        if ((i & 32) != 0) {
            str4 = "form-data; name=\"" + str + '\"' + (str5 != null ? "; filename=\"" + str5 + '\"' : "");
        }
        this(inputStream, str, str5, l2, strGuessContentType, str4);
    }

    public final String getFilename() {
        return this.filename;
    }

    @Override // com.github.kittinunf.fuel.core.DataPart
    public Long getContentLength() {
        return this.contentLength;
    }

    @Override // com.github.kittinunf.fuel.core.DataPart
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.github.kittinunf.fuel.core.DataPart
    public String getContentDisposition() {
        return this.contentDisposition;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlobDataPart(InputStream inputStream, String name, String str, Long l, String contentType, String contentDisposition) {
        super(null);
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentDisposition, "contentDisposition");
        this.inputStream = inputStream;
        this.name = name;
        this.filename = str;
        this.contentLength = l;
        this.contentType = contentType;
        this.contentDisposition = contentDisposition;
    }

    /* JADX INFO: compiled from: DataPart.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/github/kittinunf/fuel/core/BlobDataPart$Companion;", "", "()V", "guessContentType", "", "stream", "Ljava/io/InputStream;", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String guessContentType(InputStream stream) throws IOException {
            Intrinsics.checkNotNullParameter(stream, "stream");
            try {
                String strGuessContentTypeFromStream = URLConnection.guessContentTypeFromStream(stream);
                return strGuessContentTypeFromStream != null ? strGuessContentTypeFromStream : "application/octet-stream";
            } catch (NoClassDefFoundError unused) {
            }
        }
    }

    @Override // com.github.kittinunf.fuel.core.DataPart
    public InputStream inputStream() {
        return this.inputStream;
    }
}
