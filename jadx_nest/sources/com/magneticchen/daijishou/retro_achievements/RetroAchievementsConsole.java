package com.magneticchen.daijishou.retro_achievements;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetroAchievementsConsole.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsConsole;", "", "id", "", "name", "", "iconUrl", "active", "", "isGameSystem", "(JLjava/lang/String;Ljava/lang/String;ZZ)V", "getActive", "()Z", "getIconUrl", "()Ljava/lang/String;", "getId", "()J", "getName", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsConsole {
    private final boolean active;
    private final String iconUrl;
    private final long id;
    private final boolean isGameSystem;
    private final String name;

    public RetroAchievementsConsole(long j, String name, String iconUrl, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.id = j;
        this.name = name;
        this.iconUrl = iconUrl;
        this.active = z;
        this.isGameSystem = z2;
    }

    public /* synthetic */ RetroAchievementsConsole(long j, String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final boolean getActive() {
        return this.active;
    }

    /* JADX INFO: renamed from: isGameSystem, reason: from getter */
    public final boolean getIsGameSystem() {
        return this.isGameSystem;
    }
}
