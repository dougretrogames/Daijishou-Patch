package com.api.igdb.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* INFO: compiled from: ImageType.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/api/igdb/utils/ImageType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "JPEG", "PNG", "GIF", "WEBP", "igdb-api-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum ImageType {
    JPEG("jpg"),
    PNG("png"),
    GIF("gif"),
    WEBP("webp");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String type;

    public static EnumEntries<ImageType> getEntries() {
        return $ENTRIES;
    }

    ImageType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
