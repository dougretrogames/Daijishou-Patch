package com.magneticchen.daijishou.data.db.entity;

import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import com.skydoves.balloon.internals.DefinitionKt;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetroAchievementsUserProfileEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\f0\u0010HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\f0\u0010HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010'J\t\u0010D\u001a\u00020\u000eHÆ\u0003J\u009e\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\u0007HÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\"\"\u0004\b$\u0010%R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010%R$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010%R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010%¨\u0006L"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;", "", "id", "", "url", "imageUrl", "softcorePoints", "", "hardcorePoints", "richPresenceMsg", "motto", "lastGameID", "", "averageCompletionPercentage", "", "recentPlayedGameIds", "", "completionProgressGameIds", "lastUpdatedTimestamp", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;FLjava/util/List;Ljava/util/List;Ljava/util/Date;)V", "getAverageCompletionPercentage", "()F", "setAverageCompletionPercentage", "(F)V", "getCompletionProgressGameIds", "()Ljava/util/List;", "setCompletionProgressGameIds", "(Ljava/util/List;)V", "getHardcorePoints", "()I", "setHardcorePoints", "(I)V", "getId", "()Ljava/lang/String;", "getImageUrl", "setImageUrl", "(Ljava/lang/String;)V", "getLastGameID", "()Ljava/lang/Long;", "setLastGameID", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLastUpdatedTimestamp", "()Ljava/util/Date;", "setLastUpdatedTimestamp", "(Ljava/util/Date;)V", "getMotto", "setMotto", "getRecentPlayedGameIds", "setRecentPlayedGameIds", "getRichPresenceMsg", "setRichPresenceMsg", "getSoftcorePoints", "setSoftcorePoints", "getUrl", "setUrl", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;FLjava/util/List;Ljava/util/List;Ljava/util/Date;)Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsUserProfileEntity {
    private float averageCompletionPercentage;
    private List<Long> completionProgressGameIds;
    private int hardcorePoints;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f41id;
    private String imageUrl;
    private Long lastGameID;
    private Date lastUpdatedTimestamp;
    private String motto;
    private List<Long> recentPlayedGameIds;
    private String richPresenceMsg;
    private int softcorePoints;
    private String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RetroAchievementsUserProfileEntity copy$default(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity, String str, String str2, String str3, int i, int i2, String str4, String str5, Long l, float f, List list, List list2, Date date, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = retroAchievementsUserProfileEntity.f41id;
        }
        if ((i3 & 2) != 0) {
            str2 = retroAchievementsUserProfileEntity.url;
        }
        if ((i3 & 4) != 0) {
            str3 = retroAchievementsUserProfileEntity.imageUrl;
        }
        if ((i3 & 8) != 0) {
            i = retroAchievementsUserProfileEntity.softcorePoints;
        }
        if ((i3 & 16) != 0) {
            i2 = retroAchievementsUserProfileEntity.hardcorePoints;
        }
        if ((i3 & 32) != 0) {
            str4 = retroAchievementsUserProfileEntity.richPresenceMsg;
        }
        if ((i3 & 64) != 0) {
            str5 = retroAchievementsUserProfileEntity.motto;
        }
        if ((i3 & 128) != 0) {
            l = retroAchievementsUserProfileEntity.lastGameID;
        }
        if ((i3 & 256) != 0) {
            f = retroAchievementsUserProfileEntity.averageCompletionPercentage;
        }
        if ((i3 & 512) != 0) {
            list = retroAchievementsUserProfileEntity.recentPlayedGameIds;
        }
        if ((i3 & CategoryWidgetViewModel.LIMIT) != 0) {
            list2 = retroAchievementsUserProfileEntity.completionProgressGameIds;
        }
        if ((i3 & 2048) != 0) {
            date = retroAchievementsUserProfileEntity.lastUpdatedTimestamp;
        }
        List list3 = list2;
        Date date2 = date;
        float f2 = f;
        List list4 = list;
        String str6 = str5;
        Long l2 = l;
        int i4 = i2;
        String str7 = str4;
        return retroAchievementsUserProfileEntity.copy(str, str2, str3, i, i4, str7, str6, l2, f2, list4, list3, date2);
    }

    public final String component1() {
        return this.f41id;
    }

    public final List<Long> component10() {
        return this.recentPlayedGameIds;
    }

    public final List<Long> component11() {
        return this.completionProgressGameIds;
    }

    public final Date component12() {
        return this.lastUpdatedTimestamp;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final int component4() {
        return this.softcorePoints;
    }

    public final int component5() {
        return this.hardcorePoints;
    }

    public final String component6() {
        return this.richPresenceMsg;
    }

    public final String component7() {
        return this.motto;
    }

    public final Long component8() {
        return this.lastGameID;
    }

    public final float component9() {
        return this.averageCompletionPercentage;
    }

    public final RetroAchievementsUserProfileEntity copy(String id2, String str, String str2, int i, int i2, String str3, String str4, Long l, float f, List<Long> recentPlayedGameIds, List<Long> completionProgressGameIds, Date date) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(recentPlayedGameIds, "recentPlayedGameIds");
        Intrinsics.checkNotNullParameter(completionProgressGameIds, "completionProgressGameIds");
        return new RetroAchievementsUserProfileEntity(id2, str, str2, i, i2, str3, str4, l, f, recentPlayedGameIds, completionProgressGameIds, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetroAchievementsUserProfileEntity)) {
            return false;
        }
        RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity = (RetroAchievementsUserProfileEntity) obj;
        return Intrinsics.areEqual(this.f41id, retroAchievementsUserProfileEntity.f41id) && Intrinsics.areEqual(this.url, retroAchievementsUserProfileEntity.url) && Intrinsics.areEqual(this.imageUrl, retroAchievementsUserProfileEntity.imageUrl) && this.softcorePoints == retroAchievementsUserProfileEntity.softcorePoints && this.hardcorePoints == retroAchievementsUserProfileEntity.hardcorePoints && Intrinsics.areEqual(this.richPresenceMsg, retroAchievementsUserProfileEntity.richPresenceMsg) && Intrinsics.areEqual(this.motto, retroAchievementsUserProfileEntity.motto) && Intrinsics.areEqual(this.lastGameID, retroAchievementsUserProfileEntity.lastGameID) && Float.compare(this.averageCompletionPercentage, retroAchievementsUserProfileEntity.averageCompletionPercentage) == 0 && Intrinsics.areEqual(this.recentPlayedGameIds, retroAchievementsUserProfileEntity.recentPlayedGameIds) && Intrinsics.areEqual(this.completionProgressGameIds, retroAchievementsUserProfileEntity.completionProgressGameIds) && Intrinsics.areEqual(this.lastUpdatedTimestamp, retroAchievementsUserProfileEntity.lastUpdatedTimestamp);
    }

    public int hashCode() {
        int iHashCode = this.f41id.hashCode() * 31;
        String str = this.url;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.imageUrl;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.softcorePoints)) * 31) + Integer.hashCode(this.hardcorePoints)) * 31;
        String str3 = this.richPresenceMsg;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.motto;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.lastGameID;
        int iHashCode6 = (((((((iHashCode5 + (l == null ? 0 : l.hashCode())) * 31) + Float.hashCode(this.averageCompletionPercentage)) * 31) + this.recentPlayedGameIds.hashCode()) * 31) + this.completionProgressGameIds.hashCode()) * 31;
        Date date = this.lastUpdatedTimestamp;
        return iHashCode6 + (date != null ? date.hashCode() : 0);
    }

    public String toString() {
        return "RetroAchievementsUserProfileEntity(id=" + this.f41id + ", url=" + this.url + ", imageUrl=" + this.imageUrl + ", softcorePoints=" + this.softcorePoints + ", hardcorePoints=" + this.hardcorePoints + ", richPresenceMsg=" + this.richPresenceMsg + ", motto=" + this.motto + ", lastGameID=" + this.lastGameID + ", averageCompletionPercentage=" + this.averageCompletionPercentage + ", recentPlayedGameIds=" + this.recentPlayedGameIds + ", completionProgressGameIds=" + this.completionProgressGameIds + ", lastUpdatedTimestamp=" + this.lastUpdatedTimestamp + ")";
    }

    public RetroAchievementsUserProfileEntity(String id2, String str, String str2, int i, int i2, String str3, String str4, Long l, float f, List<Long> recentPlayedGameIds, List<Long> completionProgressGameIds, Date date) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(recentPlayedGameIds, "recentPlayedGameIds");
        Intrinsics.checkNotNullParameter(completionProgressGameIds, "completionProgressGameIds");
        this.f41id = id2;
        this.url = str;
        this.imageUrl = str2;
        this.softcorePoints = i;
        this.hardcorePoints = i2;
        this.richPresenceMsg = str3;
        this.motto = str4;
        this.lastGameID = l;
        this.averageCompletionPercentage = f;
        this.recentPlayedGameIds = recentPlayedGameIds;
        this.completionProgressGameIds = completionProgressGameIds;
        this.lastUpdatedTimestamp = date;
    }

    public final String getId() {
        return this.f41id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final int getSoftcorePoints() {
        return this.softcorePoints;
    }

    public final void setSoftcorePoints(int i) {
        this.softcorePoints = i;
    }

    public final int getHardcorePoints() {
        return this.hardcorePoints;
    }

    public final void setHardcorePoints(int i) {
        this.hardcorePoints = i;
    }

    public final String getRichPresenceMsg() {
        return this.richPresenceMsg;
    }

    public final void setRichPresenceMsg(String str) {
        this.richPresenceMsg = str;
    }

    public final String getMotto() {
        return this.motto;
    }

    public final void setMotto(String str) {
        this.motto = str;
    }

    public final Long getLastGameID() {
        return this.lastGameID;
    }

    public final void setLastGameID(Long l) {
        this.lastGameID = l;
    }

    public final float getAverageCompletionPercentage() {
        return this.averageCompletionPercentage;
    }

    public final void setAverageCompletionPercentage(float f) {
        this.averageCompletionPercentage = f;
    }

    public /* synthetic */ RetroAchievementsUserProfileEntity(String str, String str2, String str3, int i, int i2, String str4, String str5, Long l, float f, List list, List list2, Date date, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? 0 : i, (i3 & 16) == 0 ? i2 : 0, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : str5, (i3 & 128) != 0 ? null : l, (i3 & 256) != 0 ? DefinitionKt.NO_Float_VALUE : f, (i3 & 512) != 0 ? new ArrayList() : list, (i3 & CategoryWidgetViewModel.LIMIT) != 0 ? new ArrayList() : list2, (i3 & 2048) != 0 ? null : date);
    }

    public final List<Long> getRecentPlayedGameIds() {
        return this.recentPlayedGameIds;
    }

    public final void setRecentPlayedGameIds(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.recentPlayedGameIds = list;
    }

    public final List<Long> getCompletionProgressGameIds() {
        return this.completionProgressGameIds;
    }

    public final void setCompletionProgressGameIds(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.completionProgressGameIds = list;
    }

    public final Date getLastUpdatedTimestamp() {
        return this.lastUpdatedTimestamp;
    }

    public final void setLastUpdatedTimestamp(Date date) {
        this.lastUpdatedTimestamp = date;
    }
}
