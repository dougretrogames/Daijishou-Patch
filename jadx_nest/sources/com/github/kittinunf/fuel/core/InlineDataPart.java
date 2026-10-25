package com.github.kittinunf.fuel.core;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: DataPart.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\""}, d2 = {"Lcom/github/kittinunf/fuel/core/InlineDataPart;", "Lcom/github/kittinunf/fuel/core/DataPart;", "content", "", "name", "filename", "contentType", "contentDisposition", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getContentDisposition", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "getContentType", "getFilename", "getName", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "hashCode", "", "inputStream", "Ljava/io/ByteArrayInputStream;", "toString", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class InlineDataPart extends DataPart {
    private final String content;
    private final String contentDisposition;
    private final String contentType;
    private final String filename;
    private final String name;

    public static /* synthetic */ InlineDataPart copy$default(InlineDataPart inlineDataPart, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inlineDataPart.content;
        }
        if ((i & 2) != 0) {
            str2 = inlineDataPart.name;
        }
        if ((i & 4) != 0) {
            str3 = inlineDataPart.filename;
        }
        if ((i & 8) != 0) {
            str4 = inlineDataPart.getContentType();
        }
        if ((i & 16) != 0) {
            str5 = inlineDataPart.getContentDisposition();
        }
        String str6 = str5;
        String str7 = str3;
        return inlineDataPart.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    public final String component4() {
        return getContentType();
    }

    public final String component5() {
        return getContentDisposition();
    }

    public final InlineDataPart copy(String content, String name, String filename, String contentType, String contentDisposition) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentDisposition, "contentDisposition");
        return new InlineDataPart(content, name, filename, contentType, contentDisposition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InlineDataPart)) {
            return false;
        }
        InlineDataPart inlineDataPart = (InlineDataPart) other;
        return Intrinsics.areEqual(this.content, inlineDataPart.content) && Intrinsics.areEqual(this.name, inlineDataPart.name) && Intrinsics.areEqual(this.filename, inlineDataPart.filename) && Intrinsics.areEqual(getContentType(), inlineDataPart.getContentType()) && Intrinsics.areEqual(getContentDisposition(), inlineDataPart.getContentDisposition());
    }

    public int hashCode() {
        String str = this.content;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.filename;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String contentType = getContentType();
        int iHashCode4 = (iHashCode3 + (contentType != null ? contentType.hashCode() : 0)) * 31;
        String contentDisposition = getContentDisposition();
        return iHashCode4 + (contentDisposition != null ? contentDisposition.hashCode() : 0);
    }

    public String toString() {
        return "InlineDataPart(content=" + this.content + ", name=" + this.name + ", filename=" + this.filename + ", contentType=" + getContentType() + ", contentDisposition=" + getContentDisposition() + ")";
    }

    public final String getContent() {
        return this.content;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ InlineDataPart(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        String str6 = str3;
        String str7 = (i & 8) != 0 ? "text/plain; charset=utf-8" : str4;
        if ((i & 16) != 0) {
            str5 = "form-data; name=\"" + str2 + '\"' + (str6 != null ? "; filename=\"" + str6 + '\"' : "");
        }
        this(str, str2, str6, str7, str5);
    }

    public final String getFilename() {
        return this.filename;
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
    public InlineDataPart(String content, String name, String str, String contentType, String contentDisposition) {
        super(null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentDisposition, "contentDisposition");
        this.content = content;
        this.name = name;
        this.filename = str;
        this.contentType = contentType;
        this.contentDisposition = contentDisposition;
    }

    @Override // com.github.kittinunf.fuel.core.DataPart
    public ByteArrayInputStream inputStream() {
        String str = this.content;
        Charset charset = Charsets.UTF_8;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    @Override // com.github.kittinunf.fuel.core.DataPart
    public Long getContentLength() {
        String str = this.content;
        Charset charset = Charsets.UTF_8;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return Long.valueOf(bytes.length);
    }
}
