package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: RetroAchievementsUserIndependentGameRecordEntity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u008c\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\fHÖ\u0001J\t\u0010D\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR \u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001e¨\u0006E"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserIndependentGameRecordEntity;", "", "id", "", "name", "", "url", "imageUrl", "forumTopicId", "consoleId", "consoleName", "achievementsCount", "", "points", "dateModified", "Ljava/util/Date;", "lastUpdatedTimestamp", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;IJLjava/util/Date;Ljava/util/Date;)V", "getAchievementsCount", "()I", "setAchievementsCount", "(I)V", "getConsoleId", "()Ljava/lang/Long;", "setConsoleId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getConsoleName", "()Ljava/lang/String;", "setConsoleName", "(Ljava/lang/String;)V", "getDateModified", "()Ljava/util/Date;", "setDateModified", "(Ljava/util/Date;)V", "getForumTopicId", "setForumTopicId", "getId", "()J", "setId", "(J)V", "getImageUrl", "setImageUrl", "getLastUpdatedTimestamp", "setLastUpdatedTimestamp", "getName", "setName", "getPoints", "setPoints", "getUrl", "setUrl", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;IJLjava/util/Date;Ljava/util/Date;)Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserIndependentGameRecordEntity;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class RetroAchievementsUserIndependentGameRecordEntity {
    private int achievementsCount;
    private Long consoleId;
    private String consoleName;
    private Date dateModified;
    private Long forumTopicId;
    private long id;
    private String imageUrl;
    private Date lastUpdatedTimestamp;
    private String name;
    private long points;
    private String url;

    public RetroAchievementsUserIndependentGameRecordEntity() {
        this(0L, null, null, null, null, null, null, 0, 0L, null, null, 2047, null);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* INFO: renamed from: component10, reason: from getter */
    public final Date getDateModified() {
        return this.dateModified;
    }

    /* INFO: renamed from: component11, reason: from getter */
    public final Date getLastUpdatedTimestamp() {
        return this.lastUpdatedTimestamp;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* INFO: renamed from: component4, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* INFO: renamed from: component5, reason: from getter */
    public final Long getForumTopicId() {
        return this.forumTopicId;
    }

    /* INFO: renamed from: component6, reason: from getter */
    public final Long getConsoleId() {
        return this.consoleId;
    }

    /* INFO: renamed from: component7, reason: from getter */
    public final String getConsoleName() {
        return this.consoleName;
    }

    /* INFO: renamed from: component8, reason: from getter */
    public final int getAchievementsCount() {
        return this.achievementsCount;
    }

    /* INFO: renamed from: component9, reason: from getter */
    public final long getPoints() {
        return this.points;
    }

    public final RetroAchievementsUserIndependentGameRecordEntity copy(long id2, String name, String url, String imageUrl, Long forumTopicId, Long consoleId, String consoleName, int achievementsCount, long points, Date dateModified, Date lastUpdatedTimestamp) {
        return new RetroAchievementsUserIndependentGameRecordEntity(id2, name, url, imageUrl, forumTopicId, consoleId, consoleName, achievementsCount, points, dateModified, lastUpdatedTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RetroAchievementsUserIndependentGameRecordEntity)) {
            return false;
        }
        RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity = (RetroAchievementsUserIndependentGameRecordEntity) other;
        return this.id == retroAchievementsUserIndependentGameRecordEntity.id && Intrinsics.areEqual(this.name, retroAchievementsUserIndependentGameRecordEntity.name) && Intrinsics.areEqual(this.url, retroAchievementsUserIndependentGameRecordEntity.url) && Intrinsics.areEqual(this.imageUrl, retroAchievementsUserIndependentGameRecordEntity.imageUrl) && Intrinsics.areEqual(this.forumTopicId, retroAchievementsUserIndependentGameRecordEntity.forumTopicId) && Intrinsics.areEqual(this.consoleId, retroAchievementsUserIndependentGameRecordEntity.consoleId) && Intrinsics.areEqual(this.consoleName, retroAchievementsUserIndependentGameRecordEntity.consoleName) && this.achievementsCount == retroAchievementsUserIndependentGameRecordEntity.achievementsCount && this.points == retroAchievementsUserIndependentGameRecordEntity.points && Intrinsics.areEqual(this.dateModified, retroAchievementsUserIndependentGameRecordEntity.dateModified) && Intrinsics.areEqual(this.lastUpdatedTimestamp, retroAchievementsUserIndependentGameRecordEntity.lastUpdatedTimestamp);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.forumTopicId;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.consoleId;
        int iHashCode6 = (iHashCode5 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str4 = this.consoleName;
        int iHashCode7 = (((((iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31) + Integer.hashCode(this.achievementsCount)) * 31) + Long.hashCode(this.points)) * 31;
        Date date = this.dateModified;
        int iHashCode8 = (iHashCode7 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.lastUpdatedTimestamp;
        return iHashCode8 + (date2 != null ? date2.hashCode() : 0);
    }

    public String toString() {
        return "RetroAchievementsUserIndependentGameRecordEntity(id=" + this.id + ", name=" + this.name + ", url=" + this.url + ", imageUrl=" + this.imageUrl + ", forumTopicId=" + this.forumTopicId + ", consoleId=" + this.consoleId + ", consoleName=" + this.consoleName + ", achievementsCount=" + this.achievementsCount + ", points=" + this.points + ", dateModified=" + this.dateModified + ", lastUpdatedTimestamp=" + this.lastUpdatedTimestamp + ")";
    }

    public RetroAchievementsUserIndependentGameRecordEntity(long j, String str, String str2, String str3, Long l, Long l2, String str4, int i, long j2, Date date, Date date2) {
        this.id = j;
        this.name = str;
        this.url = str2;
        this.imageUrl = str3;
        this.forumTopicId = l;
        this.consoleId = l2;
        this.consoleName = str4;
        this.achievementsCount = i;
        this.points = j2;
        this.dateModified = date;
        this.lastUpdatedTimestamp = date2;
    }

    public /* synthetic */ RetroAchievementsUserIndependentGameRecordEntity(long j, String str, String str2, String str3, Long l, Long l2, String str4, int i, long j2, Date date, Date date2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : l, (i2 & 32) != 0 ? null : l2, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? 0 : i, (i2 & 256) == 0 ? j2 : 0L, (i2 & 512) != 0 ? null : date, (i2 & 1024) != 0 ? null : date2);
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setName(String str) {
        this.name = str;
    }


    public final void setUrl(String str) {
        this.url = str;
    }


    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }


    public final void setForumTopicId(Long l) {
        this.forumTopicId = l;
    }


    public final void setConsoleId(Long l) {
        this.consoleId = l;
    }


    public final void setConsoleName(String str) {
        this.consoleName = str;
    }


    public final void setAchievementsCount(int i) {
        this.achievementsCount = i;
    }


    public final void setPoints(long j) {
        this.points = j;
    }


    public final void setDateModified(Date date) {
        this.dateModified = date;
    }


    public final void setLastUpdatedTimestamp(Date date) {
        this.lastUpdatedTimestamp = date;
    }
}
