package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: RetroAchievementsUserAwardEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 P2\u00020\u0001:\u0001PB\u008f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0013J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u009e\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\tHÖ\u0001J\t\u0010O\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 R\u001e\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R \u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\"\"\u0004\b7\u0010$R\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001e\"\u0004\b9\u0010 R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010 ¨\u0006Q"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardEntity;", "", "id", "", "userId", "", "awardType", "awardData", "awardDataExtra", "", "awardedAt", "Ljava/util/Date;", "displayOrder", "title", "consoleId", "consoleName", "flags", "imageUrl", "lastUpdatedTimestamp", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/Integer;Ljava/util/Date;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Date;)V", "getAwardData", "()J", "setAwardData", "(J)V", "getAwardDataExtra", "()Ljava/lang/Integer;", "setAwardDataExtra", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAwardType", "()Ljava/lang/String;", "setAwardType", "(Ljava/lang/String;)V", "getAwardedAt", "()Ljava/util/Date;", "setAwardedAt", "(Ljava/util/Date;)V", "getConsoleId", "()Ljava/lang/Long;", "setConsoleId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getConsoleName", "setConsoleName", "getDisplayOrder", "()I", "setDisplayOrder", "(I)V", "getFlags", "setFlags", "getId", "setId", "getImageUrl", "setImageUrl", "getLastUpdatedTimestamp", "setLastUpdatedTimestamp", "getTitle", "setTitle", "getUserId", "setUserId", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/Integer;Ljava/util/Date;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Date;)Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardEntity;", "equals", "", "other", "hashCode", "toString", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class RetroAchievementsUserAwardEntity {
    private long awardData;
    private Integer awardDataExtra;
    private String awardType;
    private Date awardedAt;
    private Long consoleId;
    private String consoleName;
    private int displayOrder;
    private Integer flags;
    private long id;
    private String imageUrl;
    private Date lastUpdatedTimestamp;
    private String title;
    private String userId;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getConsoleName() {
        return this.consoleName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Date getLastUpdatedTimestamp() {
        return this.lastUpdatedTimestamp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAwardType() {
        return this.awardType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getAwardData() {
        return this.awardData;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getAwardDataExtra() {
        return this.awardDataExtra;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Date getAwardedAt() {
        return this.awardedAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getDisplayOrder() {
        return this.displayOrder;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Long getConsoleId() {
        return this.consoleId;
    }

    public final RetroAchievementsUserAwardEntity copy(long id2, String userId, String awardType, long awardData, Integer awardDataExtra, Date awardedAt, int displayOrder, String title, Long consoleId, String consoleName, Integer flags, String imageUrl, Date lastUpdatedTimestamp) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(awardType, "awardType");
        Intrinsics.checkNotNullParameter(title, "title");
        return new RetroAchievementsUserAwardEntity(id2, userId, awardType, awardData, awardDataExtra, awardedAt, displayOrder, title, consoleId, consoleName, flags, imageUrl, lastUpdatedTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RetroAchievementsUserAwardEntity)) {
            return false;
        }
        RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity = (RetroAchievementsUserAwardEntity) other;
        return this.id == retroAchievementsUserAwardEntity.id && Intrinsics.areEqual(this.userId, retroAchievementsUserAwardEntity.userId) && Intrinsics.areEqual(this.awardType, retroAchievementsUserAwardEntity.awardType) && this.awardData == retroAchievementsUserAwardEntity.awardData && Intrinsics.areEqual(this.awardDataExtra, retroAchievementsUserAwardEntity.awardDataExtra) && Intrinsics.areEqual(this.awardedAt, retroAchievementsUserAwardEntity.awardedAt) && this.displayOrder == retroAchievementsUserAwardEntity.displayOrder && Intrinsics.areEqual(this.title, retroAchievementsUserAwardEntity.title) && Intrinsics.areEqual(this.consoleId, retroAchievementsUserAwardEntity.consoleId) && Intrinsics.areEqual(this.consoleName, retroAchievementsUserAwardEntity.consoleName) && Intrinsics.areEqual(this.flags, retroAchievementsUserAwardEntity.flags) && Intrinsics.areEqual(this.imageUrl, retroAchievementsUserAwardEntity.imageUrl) && Intrinsics.areEqual(this.lastUpdatedTimestamp, retroAchievementsUserAwardEntity.lastUpdatedTimestamp);
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.id) * 31) + this.userId.hashCode()) * 31) + this.awardType.hashCode()) * 31) + Long.hashCode(this.awardData)) * 31;
        Integer num = this.awardDataExtra;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Date date = this.awardedAt;
        int iHashCode3 = (((((iHashCode2 + (date == null ? 0 : date.hashCode())) * 31) + Integer.hashCode(this.displayOrder)) * 31) + this.title.hashCode()) * 31;
        Long l = this.consoleId;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.consoleName;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.flags;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.imageUrl;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Date date2 = this.lastUpdatedTimestamp;
        return iHashCode7 + (date2 != null ? date2.hashCode() : 0);
    }

    public String toString() {
        return "RetroAchievementsUserAwardEntity(id=" + this.id + ", userId=" + this.userId + ", awardType=" + this.awardType + ", awardData=" + this.awardData + ", awardDataExtra=" + this.awardDataExtra + ", awardedAt=" + this.awardedAt + ", displayOrder=" + this.displayOrder + ", title=" + this.title + ", consoleId=" + this.consoleId + ", consoleName=" + this.consoleName + ", flags=" + this.flags + ", imageUrl=" + this.imageUrl + ", lastUpdatedTimestamp=" + this.lastUpdatedTimestamp + ")";
    }

    public RetroAchievementsUserAwardEntity(long j, String userId, String awardType, long j2, Integer num, Date date, int i, String title, Long l, String str, Integer num2, String str2, Date date2) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(awardType, "awardType");
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = j;
        this.userId = userId;
        this.awardType = awardType;
        this.awardData = j2;
        this.awardDataExtra = num;
        this.awardedAt = date;
        this.displayOrder = i;
        this.title = title;
        this.consoleId = l;
        this.consoleName = str;
        this.flags = num2;
        this.imageUrl = str2;
        this.lastUpdatedTimestamp = date2;
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }


    public final void setAwardType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.awardType = str;
    }


    public final void setAwardData(long j) {
        this.awardData = j;
    }


    public final void setAwardDataExtra(Integer num) {
        this.awardDataExtra = num;
    }


    public final void setAwardedAt(Date date) {
        this.awardedAt = date;
    }


    public final void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public /* synthetic */ RetroAchievementsUserAwardEntity(long j, String str, String str2, long j2, Integer num, Date date, int i, String str3, Long l, String str4, Integer num2, String str5, Date date2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, str, str2, j2, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? null : date, (i2 & 64) != 0 ? -1 : i, (i2 & 128) != 0 ? "" : str3, (i2 & 256) != 0 ? null : l, (i2 & 512) != 0 ? null : str4, (i2 & 1024) != 0 ? null : num2, (i2 & 2048) != 0 ? null : str5, (i2 & 4096) != 0 ? null : date2);
    }


    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }


    public final void setConsoleId(Long l) {
        this.consoleId = l;
    }


    public final void setConsoleName(String str) {
        this.consoleName = str;
    }


    public final void setFlags(Integer num) {
        this.flags = num;
    }


    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }


    public final void setLastUpdatedTimestamp(Date date) {
        this.lastUpdatedTimestamp = date;
    }
}
