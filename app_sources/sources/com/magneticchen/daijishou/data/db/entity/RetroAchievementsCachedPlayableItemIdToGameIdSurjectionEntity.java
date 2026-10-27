package com.magneticchen.daijishou.data.db.entity;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\f¨\u0006%"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;", "", "id", "", "isPermanent", "", "playableItemId", "gameId", "lastUpdatedTimestamp", "Ljava/util/Date;", "(JZJJLjava/util/Date;)V", "getGameId", "()J", "getId", "setId", "(J)V", "()Z", "setPermanent", "(Z)V", "getLastUpdatedTimestamp", "()Ljava/util/Date;", "setLastUpdatedTimestamp", "(Ljava/util/Date;)V", "getPlayableItemId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity {
    public static final Companion Companion = new Companion(null);
    private static final long NULL_GAME_ID = -1;
    private final long gameId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f37id;
    private boolean isPermanent;
    private Date lastUpdatedTimestamp;
    private final long playableItemId;

    public static /* synthetic */ RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity copy$default(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, long j, boolean z, long j2, long j3, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            j = retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.f37id;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            z = retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.isPermanent;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            j2 = retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.playableItemId;
        }
        return retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.copy(j4, z2, j2, (i & 8) != 0 ? retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.gameId : j3, (i & 16) != 0 ? retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.lastUpdatedTimestamp : date);
    }

    public final long component1() {
        return this.f37id;
    }

    public final boolean component2() {
        return this.isPermanent;
    }

    public final long component3() {
        return this.playableItemId;
    }

    public final long component4() {
        return this.gameId;
    }

    public final Date component5() {
        return this.lastUpdatedTimestamp;
    }

    public final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity copy(long j, boolean z, long j2, long j3, Date date) {
        return new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(j, z, j2, j3, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity)) {
            return false;
        }
        RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = (RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) obj;
        return this.f37id == retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.f37id && this.isPermanent == retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.isPermanent && this.playableItemId == retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.playableItemId && this.gameId == retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.gameId && Intrinsics.areEqual(this.lastUpdatedTimestamp, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.lastUpdatedTimestamp);
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.f37id) * 31) + Boolean.hashCode(this.isPermanent)) * 31) + Long.hashCode(this.playableItemId)) * 31) + Long.hashCode(this.gameId)) * 31;
        Date date = this.lastUpdatedTimestamp;
        return iHashCode + (date == null ? 0 : date.hashCode());
    }

    public String toString() {
        return "RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(id=" + this.f37id + ", isPermanent=" + this.isPermanent + ", playableItemId=" + this.playableItemId + ", gameId=" + this.gameId + ", lastUpdatedTimestamp=" + this.lastUpdatedTimestamp + ")";
    }

    public RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(long j, boolean z, long j2, long j3, Date date) {
        this.f37id = j;
        this.isPermanent = z;
        this.playableItemId = j2;
        this.gameId = j3;
        this.lastUpdatedTimestamp = date;
    }

    public /* synthetic */ RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(long j, boolean z, long j2, long j3, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? false : z, j2, j3, (i & 16) != 0 ? null : date);
    }

    public final long getId() {
        return this.f37id;
    }

    public final void setId(long j) {
        this.f37id = j;
    }

    public final boolean isPermanent() {
        return this.isPermanent;
    }

    public final void setPermanent(boolean z) {
        this.isPermanent = z;
    }

    public final long getPlayableItemId() {
        return this.playableItemId;
    }

    public final long getGameId() {
        return this.gameId;
    }

    public final Date getLastUpdatedTimestamp() {
        return this.lastUpdatedTimestamp;
    }

    public final void setLastUpdatedTimestamp(Date date) {
        this.lastUpdatedTimestamp = date;
    }

    /* JADX INFO: compiled from: RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity$Companion;", "", "()V", "NULL_GAME_ID", "", "getNULL_GAME_ID", "()J", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getNULL_GAME_ID() {
            return RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.NULL_GAME_ID;
        }
    }
}
