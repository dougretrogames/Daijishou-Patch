package com.magneticchen.daijishou.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetroAchievementsConsole.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/data/RetroAchievementsConsole;", "", "id", "", "name", "", "iconUrl", "(JLjava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getId", "()J", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsConsole {
    private final String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f9id;
    private final String name;

    public static /* synthetic */ RetroAchievementsConsole copy$default(RetroAchievementsConsole retroAchievementsConsole, long j, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = retroAchievementsConsole.f9id;
        }
        if ((i & 2) != 0) {
            str = retroAchievementsConsole.name;
        }
        if ((i & 4) != 0) {
            str2 = retroAchievementsConsole.iconUrl;
        }
        return retroAchievementsConsole.copy(j, str, str2);
    }

    public final long component1() {
        return this.f9id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final RetroAchievementsConsole copy(long j, String name, String iconUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        return new RetroAchievementsConsole(j, name, iconUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetroAchievementsConsole)) {
            return false;
        }
        RetroAchievementsConsole retroAchievementsConsole = (RetroAchievementsConsole) obj;
        return this.f9id == retroAchievementsConsole.f9id && Intrinsics.areEqual(this.name, retroAchievementsConsole.name) && Intrinsics.areEqual(this.iconUrl, retroAchievementsConsole.iconUrl);
    }

    public int hashCode() {
        return (((Long.hashCode(this.f9id) * 31) + this.name.hashCode()) * 31) + this.iconUrl.hashCode();
    }

    public String toString() {
        return "RetroAchievementsConsole(id=" + this.f9id + ", name=" + this.name + ", iconUrl=" + this.iconUrl + ")";
    }

    public RetroAchievementsConsole(long j, String name, String iconUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.f9id = j;
        this.name = name;
        this.iconUrl = iconUrl;
    }

    public final long getId() {
        return this.f9id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }
}
