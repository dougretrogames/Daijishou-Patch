package com.magneticchen.daijishou.data.db.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: WidgetInstanceEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/WidgetId;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "ACTIVITY", "APP_SHORTCUT", "CHECKLIST", "CATEGORY", "IMAGE_BLOCK", "PIN_AND_PLAY", "PLAYLIST", "RANDOM", "RETRO_ACHIEVEMENTS", "RSS", "SHORTCUT", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum WidgetId {
    ACTIVITY("activity"),
    APP_SHORTCUT("app_shortcut"),
    CHECKLIST("checklist"),
    CATEGORY("category"),
    IMAGE_BLOCK("image_block"),
    PIN_AND_PLAY("pin_and_play"),
    PLAYLIST("playlist"),
    RANDOM("random"),
    RETRO_ACHIEVEMENTS("retro_achievements"),
    RSS("rss"),
    SHORTCUT("shortcut");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f43id;

    public static EnumEntries<WidgetId> getEntries() {
        return $ENTRIES;
    }

    WidgetId(String str) {
        this.f43id = str;
    }

    public final String getId() {
        return this.f43id;
    }
}
