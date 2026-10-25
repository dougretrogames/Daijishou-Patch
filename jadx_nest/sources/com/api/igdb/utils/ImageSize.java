package com.api.igdb.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ImageSize.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/api/igdb/utils/ImageSize;", "", "tSize", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTSize", "()Ljava/lang/String;", "MICRO", "THUMB", "COVER_SMALL", "COVER_BIG", "LOGO_MEDIUM", "SCREENSHOT_MEDIUM", "SCREENSHOT_BIG", "SCREENSHOT_HUGE", "HD", "FHD", "igdb-api-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum ImageSize {
    MICRO("t_micro"),
    THUMB("t_thumb"),
    COVER_SMALL("t_cover_small"),
    COVER_BIG("t_cover_big"),
    LOGO_MEDIUM("t_logo_med"),
    SCREENSHOT_MEDIUM("t_screenshot_med"),
    SCREENSHOT_BIG("t_screenshot_big"),
    SCREENSHOT_HUGE("t_screenshot_huge"),
    HD("t_720p"),
    FHD("t_1080p");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String tSize;

    public static EnumEntries<ImageSize> getEntries() {
        return $ENTRIES;
    }

    ImageSize(String str) {
        this.tSize = str;
    }

    public final String getTSize() {
        return this.tSize;
    }
}
