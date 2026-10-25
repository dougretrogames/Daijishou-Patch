package com.github.kittinunf.fuel.core;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DataPart.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006\u0082\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/github/kittinunf/fuel/core/DataPart;", "", "()V", "contentDisposition", "", "getContentDisposition", "()Ljava/lang/String;", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "contentType", "getContentType", "inputStream", "Ljava/io/InputStream;", "Companion", "Lcom/github/kittinunf/fuel/core/InlineDataPart;", "Lcom/github/kittinunf/fuel/core/FileDataPart;", "Lcom/github/kittinunf/fuel/core/BlobDataPart;", "fuel"}, k = 1, mv = {1, 4, 0})
public abstract class DataPart {
    public static final String GENERIC_BYTE_CONTENT = "application/octet-stream";
    public static final String GENERIC_CONTENT = "text/plain";

    public abstract String getContentDisposition();

    public abstract Long getContentLength();

    public abstract String getContentType();

    public abstract InputStream inputStream();

    private DataPart() {
    }

    public /* synthetic */ DataPart(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
