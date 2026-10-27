package com.magneticchen.daijishou.ui.model;

import com.magneticchen.daijishou.data.db.entity.PlayerEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformWithPlayerEntitiesHolder.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014¨\u0006\""}, d2 = {"Lcom/magneticchen/daijishou/ui/model/PlatformWithPlayerEntitiesHolder;", "", "platformName", "", "platformShortName", "playerEntities", "", "Lcom/magneticchen/daijishou/data/db/entity/PlayerEntity;", "playerIds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getPlatformName", "()Ljava/lang/String;", "setPlatformName", "(Ljava/lang/String;)V", "getPlatformShortName", "setPlatformShortName", "getPlayerEntities", "()Ljava/util/List;", "setPlayerEntities", "(Ljava/util/List;)V", "getPlayerIds", "setPlayerIds", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformWithPlayerEntitiesHolder {
    private String platformName;
    private String platformShortName;
    private List<PlayerEntity> playerEntities;
    private List<Long> playerIds;

    public PlatformWithPlayerEntitiesHolder() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformWithPlayerEntitiesHolder copy$default(PlatformWithPlayerEntitiesHolder platformWithPlayerEntitiesHolder, String str, String str2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = platformWithPlayerEntitiesHolder.platformName;
        }
        if ((i & 2) != 0) {
            str2 = platformWithPlayerEntitiesHolder.platformShortName;
        }
        if ((i & 4) != 0) {
            list = platformWithPlayerEntitiesHolder.playerEntities;
        }
        if ((i & 8) != 0) {
            list2 = platformWithPlayerEntitiesHolder.playerIds;
        }
        return platformWithPlayerEntitiesHolder.copy(str, str2, list, list2);
    }

    public final String component1() {
        return this.platformName;
    }

    public final String component2() {
        return this.platformShortName;
    }

    public final List<PlayerEntity> component3() {
        return this.playerEntities;
    }

    public final List<Long> component4() {
        return this.playerIds;
    }

    public final PlatformWithPlayerEntitiesHolder copy(String platformName, String platformShortName, List<PlayerEntity> playerEntities, List<Long> playerIds) {
        Intrinsics.checkNotNullParameter(platformName, "platformName");
        Intrinsics.checkNotNullParameter(platformShortName, "platformShortName");
        Intrinsics.checkNotNullParameter(playerEntities, "playerEntities");
        Intrinsics.checkNotNullParameter(playerIds, "playerIds");
        return new PlatformWithPlayerEntitiesHolder(platformName, platformShortName, playerEntities, playerIds);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformWithPlayerEntitiesHolder)) {
            return false;
        }
        PlatformWithPlayerEntitiesHolder platformWithPlayerEntitiesHolder = (PlatformWithPlayerEntitiesHolder) obj;
        return Intrinsics.areEqual(this.platformName, platformWithPlayerEntitiesHolder.platformName) && Intrinsics.areEqual(this.platformShortName, platformWithPlayerEntitiesHolder.platformShortName) && Intrinsics.areEqual(this.playerEntities, platformWithPlayerEntitiesHolder.playerEntities) && Intrinsics.areEqual(this.playerIds, platformWithPlayerEntitiesHolder.playerIds);
    }

    public int hashCode() {
        return (((((this.platformName.hashCode() * 31) + this.platformShortName.hashCode()) * 31) + this.playerEntities.hashCode()) * 31) + this.playerIds.hashCode();
    }

    public String toString() {
        return "PlatformWithPlayerEntitiesHolder(platformName=" + this.platformName + ", platformShortName=" + this.platformShortName + ", playerEntities=" + this.playerEntities + ", playerIds=" + this.playerIds + ")";
    }

    public PlatformWithPlayerEntitiesHolder(String platformName, String platformShortName, List<PlayerEntity> playerEntities, List<Long> playerIds) {
        Intrinsics.checkNotNullParameter(platformName, "platformName");
        Intrinsics.checkNotNullParameter(platformShortName, "platformShortName");
        Intrinsics.checkNotNullParameter(playerEntities, "playerEntities");
        Intrinsics.checkNotNullParameter(playerIds, "playerIds");
        this.platformName = platformName;
        this.platformShortName = platformShortName;
        this.playerEntities = playerEntities;
        this.playerIds = playerIds;
    }

    public /* synthetic */ PlatformWithPlayerEntitiesHolder(String str, String str2, ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new ArrayList() : arrayList, (i & 8) != 0 ? new ArrayList() : arrayList2);
    }

    public final String getPlatformName() {
        return this.platformName;
    }

    public final void setPlatformName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.platformName = str;
    }

    public final String getPlatformShortName() {
        return this.platformShortName;
    }

    public final void setPlatformShortName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.platformShortName = str;
    }

    public final List<PlayerEntity> getPlayerEntities() {
        return this.playerEntities;
    }

    public final void setPlayerEntities(List<PlayerEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.playerEntities = list;
    }

    public final List<Long> getPlayerIds() {
        return this.playerIds;
    }

    public final void setPlayerIds(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.playerIds = list;
    }
}
