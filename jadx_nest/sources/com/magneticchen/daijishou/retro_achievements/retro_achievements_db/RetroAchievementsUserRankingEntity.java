package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: RetroAchievementsUserRankingEntity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001.BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003JS\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\bHÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001a¨\u0006/"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "", "id", "", "userId", "", "whosePerspective", "granularity", "", "url", "imageUrl", "earnedPoints", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getEarnedPoints", "()I", "setEarnedPoints", "(I)V", "getGranularity", "setGranularity", "getId", "()J", "setId", "(J)V", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "getUrl", "setUrl", "getUserId", "setUserId", "getWhosePerspective", "setWhosePerspective", "component1", "component2", "component3", "component4", "component5", "component6", "component7", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class RetroAchievementsUserRankingEntity {
    public static final int ALL_TIME_GRANULARITY = 99;
    public static final int DAILY_GRANULARITY = 0;
    public static final int WEEKLY_GRANULARITY = 1;
    private int earnedPoints;
    private int granularity;
    private long id;
    private String imageUrl;
    private String url;
    private String userId;
    private String whosePerspective;

    public static /* synthetic */ RetroAchievementsUserRankingEntity copy$default(RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity, long j, String str, String str2, int i, String str3, String str4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = retroAchievementsUserRankingEntity.id;
        }
        long j2 = j;
        if ((i3 & 2) != 0) {
            str = retroAchievementsUserRankingEntity.userId;
        }
        String str5 = str;
        if ((i3 & 4) != 0) {
            str2 = retroAchievementsUserRankingEntity.whosePerspective;
        }
        String str6 = str2;
        if ((i3 & 8) != 0) {
            i = retroAchievementsUserRankingEntity.granularity;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            str3 = retroAchievementsUserRankingEntity.url;
        }
        return retroAchievementsUserRankingEntity.copy(j2, str5, str6, i4, str3, (i3 & 32) != 0 ? retroAchievementsUserRankingEntity.imageUrl : str4, (i3 & 64) != 0 ? retroAchievementsUserRankingEntity.earnedPoints : i2);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* INFO: renamed from: component3, reason: from getter */
    public final String getWhosePerspective() {
        return this.whosePerspective;
    }

    /* INFO: renamed from: component4, reason: from getter */
    public final int getGranularity() {
        return this.granularity;
    }

    /* INFO: renamed from: component5, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* INFO: renamed from: component6, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* INFO: renamed from: component7, reason: from getter */
    public final int getEarnedPoints() {
        return this.earnedPoints;
    }

    public final RetroAchievementsUserRankingEntity copy(long id2, String userId, String whosePerspective, int granularity, String url, String imageUrl, int earnedPoints) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(whosePerspective, "whosePerspective");
        return new RetroAchievementsUserRankingEntity(id2, userId, whosePerspective, granularity, url, imageUrl, earnedPoints);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RetroAchievementsUserRankingEntity)) {
            return false;
        }
        RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity = (RetroAchievementsUserRankingEntity) other;
        return this.id == retroAchievementsUserRankingEntity.id && Intrinsics.areEqual(this.userId, retroAchievementsUserRankingEntity.userId) && Intrinsics.areEqual(this.whosePerspective, retroAchievementsUserRankingEntity.whosePerspective) && this.granularity == retroAchievementsUserRankingEntity.granularity && Intrinsics.areEqual(this.url, retroAchievementsUserRankingEntity.url) && Intrinsics.areEqual(this.imageUrl, retroAchievementsUserRankingEntity.imageUrl) && this.earnedPoints == retroAchievementsUserRankingEntity.earnedPoints;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.id) * 31) + this.userId.hashCode()) * 31) + this.whosePerspective.hashCode()) * 31) + Integer.hashCode(this.granularity)) * 31;
        String str = this.url;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.imageUrl;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.earnedPoints);
    }

    public String toString() {
        return "RetroAchievementsUserRankingEntity(id=" + this.id + ", userId=" + this.userId + ", whosePerspective=" + this.whosePerspective + ", granularity=" + this.granularity + ", url=" + this.url + ", imageUrl=" + this.imageUrl + ", earnedPoints=" + this.earnedPoints + ")";
    }

    public RetroAchievementsUserRankingEntity(long j, String userId, String whosePerspective, int i, String str, String str2, int i2) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(whosePerspective, "whosePerspective");
        this.id = j;
        this.userId = userId;
        this.whosePerspective = whosePerspective;
        this.granularity = i;
        this.url = str;
        this.imageUrl = str2;
        this.earnedPoints = i2;
    }

    public /* synthetic */ RetroAchievementsUserRankingEntity(long j, String str, String str2, int i, String str3, String str4, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, str, str2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? 0 : i2);
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }


    public final void setWhosePerspective(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.whosePerspective = str;
    }


    public final void setGranularity(int i) {
        this.granularity = i;
    }


    public final void setUrl(String str) {
        this.url = str;
    }


    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }


    public final void setEarnedPoints(int i) {
        this.earnedPoints = i;
    }
}
