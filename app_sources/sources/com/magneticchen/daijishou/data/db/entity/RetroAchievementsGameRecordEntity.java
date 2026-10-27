package com.magneticchen.daijishou.data.db.entity;

import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetroAchievementsGameRecordEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bW\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u001cJ\t\u0010W\u001a\u00020\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010FJ\t\u0010Z\u001a\u00020\fHÆ\u0003J\t\u0010[\u001a\u00020\fHÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010a\u001a\u00020\fHÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\fHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"Jö\u0001\u0010l\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010mJ\u0013\u0010n\u001a\u00020o2\b\u0010p\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010q\u001a\u00020\fHÖ\u0001J\t\u0010r\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010+\"\u0004\b8\u0010-R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010+\"\u0004\b<\u0010-R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R \u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010'\"\u0004\bD\u0010)R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001e\"\u0004\bK\u0010 R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010@\"\u0004\bM\u0010BR \u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010'\"\u0004\bO\u0010)R\u001e\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001e\"\u0004\bQ\u0010 R\u001e\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001e\"\u0004\bS\u0010 R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010'\"\u0004\bU\u0010)R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010'¨\u0006s"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "", "id", "", "userId", "", "gameId", "name", "url", "imageUrl", "guideUrl", "forumTopicId", "", "consoleId", "consoleName", "rating", "", "ratingVotesCount", "totalPlayerCount", "distinctPlayerCount", "distinctCasualPlayerCount", "distinctHardcorePlayerCount", "releasedDate", "Ljava/util/Date;", "releasedDateGranularity", "achievementsCount", "unlockedAchievementsCount", "lastUpdatedTimestamp", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Float;IIJJJLjava/util/Date;Ljava/lang/String;IILjava/util/Date;)V", "getAchievementsCount", "()I", "setAchievementsCount", "(I)V", "getConsoleId", "()Ljava/lang/Long;", "setConsoleId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getConsoleName", "()Ljava/lang/String;", "setConsoleName", "(Ljava/lang/String;)V", "getDistinctCasualPlayerCount", "()J", "setDistinctCasualPlayerCount", "(J)V", "getDistinctHardcorePlayerCount", "setDistinctHardcorePlayerCount", "getDistinctPlayerCount", "setDistinctPlayerCount", "getForumTopicId", "()Ljava/lang/Integer;", "setForumTopicId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGameId", "setGameId", "getGuideUrl", "setGuideUrl", "getId", "setId", "getImageUrl", "setImageUrl", "getLastUpdatedTimestamp", "()Ljava/util/Date;", "setLastUpdatedTimestamp", "(Ljava/util/Date;)V", "getName", "setName", "getRating", "()Ljava/lang/Float;", "setRating", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getRatingVotesCount", "setRatingVotesCount", "getReleasedDate", "setReleasedDate", "getReleasedDateGranularity", "setReleasedDateGranularity", "getTotalPlayerCount", "setTotalPlayerCount", "getUnlockedAchievementsCount", "setUnlockedAchievementsCount", "getUrl", "setUrl", "getUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Float;IIJJJLjava/util/Date;Ljava/lang/String;IILjava/util/Date;)Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsGameRecordEntity {
    private int achievementsCount;
    private Long consoleId;
    private String consoleName;
    private long distinctCasualPlayerCount;
    private long distinctHardcorePlayerCount;
    private long distinctPlayerCount;
    private Integer forumTopicId;
    private long gameId;
    private String guideUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f38id;
    private String imageUrl;
    private Date lastUpdatedTimestamp;
    private String name;
    private Float rating;
    private int ratingVotesCount;
    private Date releasedDate;
    private String releasedDateGranularity;
    private int totalPlayerCount;
    private int unlockedAchievementsCount;
    private String url;
    private final String userId;

    public static /* synthetic */ RetroAchievementsGameRecordEntity copy$default(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity, long j, String str, long j2, String str2, String str3, String str4, String str5, Integer num, Long l, String str6, Float f, int i, int i2, long j3, long j4, long j5, Date date, String str7, int i3, int i4, Date date2, int i5, Object obj) {
        Date date3;
        int i6;
        long j6 = (i5 & 1) != 0 ? retroAchievementsGameRecordEntity.f38id : j;
        String str8 = (i5 & 2) != 0 ? retroAchievementsGameRecordEntity.userId : str;
        long j7 = (i5 & 4) != 0 ? retroAchievementsGameRecordEntity.gameId : j2;
        String str9 = (i5 & 8) != 0 ? retroAchievementsGameRecordEntity.name : str2;
        String str10 = (i5 & 16) != 0 ? retroAchievementsGameRecordEntity.url : str3;
        String str11 = (i5 & 32) != 0 ? retroAchievementsGameRecordEntity.imageUrl : str4;
        String str12 = (i5 & 64) != 0 ? retroAchievementsGameRecordEntity.guideUrl : str5;
        Integer num2 = (i5 & 128) != 0 ? retroAchievementsGameRecordEntity.forumTopicId : num;
        Long l2 = (i5 & 256) != 0 ? retroAchievementsGameRecordEntity.consoleId : l;
        String str13 = (i5 & 512) != 0 ? retroAchievementsGameRecordEntity.consoleName : str6;
        Float f2 = (i5 & CategoryWidgetViewModel.LIMIT) != 0 ? retroAchievementsGameRecordEntity.rating : f;
        int i7 = (i5 & 2048) != 0 ? retroAchievementsGameRecordEntity.ratingVotesCount : i;
        long j8 = j6;
        int i8 = (i5 & 4096) != 0 ? retroAchievementsGameRecordEntity.totalPlayerCount : i2;
        long j9 = (i5 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? retroAchievementsGameRecordEntity.distinctPlayerCount : j3;
        long j10 = (i5 & 16384) != 0 ? retroAchievementsGameRecordEntity.distinctCasualPlayerCount : j4;
        long j11 = (i5 & 32768) != 0 ? retroAchievementsGameRecordEntity.distinctHardcorePlayerCount : j5;
        Date date4 = (i5 & 65536) != 0 ? retroAchievementsGameRecordEntity.releasedDate : date;
        long j12 = j11;
        String str14 = (i5 & 131072) != 0 ? retroAchievementsGameRecordEntity.releasedDateGranularity : str7;
        int i9 = (i5 & 262144) != 0 ? retroAchievementsGameRecordEntity.achievementsCount : i3;
        String str15 = str14;
        int i10 = (i5 & 524288) != 0 ? retroAchievementsGameRecordEntity.unlockedAchievementsCount : i4;
        if ((i5 & 1048576) != 0) {
            i6 = i10;
            date3 = retroAchievementsGameRecordEntity.lastUpdatedTimestamp;
        } else {
            date3 = date2;
            i6 = i10;
        }
        return retroAchievementsGameRecordEntity.copy(j8, str8, j7, str9, str10, str11, str12, num2, l2, str13, f2, i7, i8, j9, j10, j12, date4, str15, i9, i6, date3);
    }

    public final long component1() {
        return this.f38id;
    }

    public final String component10() {
        return this.consoleName;
    }

    public final Float component11() {
        return this.rating;
    }

    public final int component12() {
        return this.ratingVotesCount;
    }

    public final int component13() {
        return this.totalPlayerCount;
    }

    public final long component14() {
        return this.distinctPlayerCount;
    }

    public final long component15() {
        return this.distinctCasualPlayerCount;
    }

    public final long component16() {
        return this.distinctHardcorePlayerCount;
    }

    public final Date component17() {
        return this.releasedDate;
    }

    public final String component18() {
        return this.releasedDateGranularity;
    }

    public final int component19() {
        return this.achievementsCount;
    }

    public final String component2() {
        return this.userId;
    }

    public final int component20() {
        return this.unlockedAchievementsCount;
    }

    public final Date component21() {
        return this.lastUpdatedTimestamp;
    }

    public final long component3() {
        return this.gameId;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.url;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final String component7() {
        return this.guideUrl;
    }

    public final Integer component8() {
        return this.forumTopicId;
    }

    public final Long component9() {
        return this.consoleId;
    }

    public final RetroAchievementsGameRecordEntity copy(long j, String userId, long j2, String str, String str2, String str3, String str4, Integer num, Long l, String str5, Float f, int i, int i2, long j3, long j4, long j5, Date date, String str6, int i3, int i4, Date date2) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new RetroAchievementsGameRecordEntity(j, userId, j2, str, str2, str3, str4, num, l, str5, f, i, i2, j3, j4, j5, date, str6, i3, i4, date2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetroAchievementsGameRecordEntity)) {
            return false;
        }
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity = (RetroAchievementsGameRecordEntity) obj;
        return this.f38id == retroAchievementsGameRecordEntity.f38id && Intrinsics.areEqual(this.userId, retroAchievementsGameRecordEntity.userId) && this.gameId == retroAchievementsGameRecordEntity.gameId && Intrinsics.areEqual(this.name, retroAchievementsGameRecordEntity.name) && Intrinsics.areEqual(this.url, retroAchievementsGameRecordEntity.url) && Intrinsics.areEqual(this.imageUrl, retroAchievementsGameRecordEntity.imageUrl) && Intrinsics.areEqual(this.guideUrl, retroAchievementsGameRecordEntity.guideUrl) && Intrinsics.areEqual(this.forumTopicId, retroAchievementsGameRecordEntity.forumTopicId) && Intrinsics.areEqual(this.consoleId, retroAchievementsGameRecordEntity.consoleId) && Intrinsics.areEqual(this.consoleName, retroAchievementsGameRecordEntity.consoleName) && Intrinsics.areEqual((Object) this.rating, (Object) retroAchievementsGameRecordEntity.rating) && this.ratingVotesCount == retroAchievementsGameRecordEntity.ratingVotesCount && this.totalPlayerCount == retroAchievementsGameRecordEntity.totalPlayerCount && this.distinctPlayerCount == retroAchievementsGameRecordEntity.distinctPlayerCount && this.distinctCasualPlayerCount == retroAchievementsGameRecordEntity.distinctCasualPlayerCount && this.distinctHardcorePlayerCount == retroAchievementsGameRecordEntity.distinctHardcorePlayerCount && Intrinsics.areEqual(this.releasedDate, retroAchievementsGameRecordEntity.releasedDate) && Intrinsics.areEqual(this.releasedDateGranularity, retroAchievementsGameRecordEntity.releasedDateGranularity) && this.achievementsCount == retroAchievementsGameRecordEntity.achievementsCount && this.unlockedAchievementsCount == retroAchievementsGameRecordEntity.unlockedAchievementsCount && Intrinsics.areEqual(this.lastUpdatedTimestamp, retroAchievementsGameRecordEntity.lastUpdatedTimestamp);
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.f38id) * 31) + this.userId.hashCode()) * 31) + Long.hashCode(this.gameId)) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.guideUrl;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.forumTopicId;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.consoleId;
        int iHashCode7 = (iHashCode6 + (l == null ? 0 : l.hashCode())) * 31;
        String str5 = this.consoleName;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Float f = this.rating;
        int iHashCode9 = (((((((((((iHashCode8 + (f == null ? 0 : f.hashCode())) * 31) + Integer.hashCode(this.ratingVotesCount)) * 31) + Integer.hashCode(this.totalPlayerCount)) * 31) + Long.hashCode(this.distinctPlayerCount)) * 31) + Long.hashCode(this.distinctCasualPlayerCount)) * 31) + Long.hashCode(this.distinctHardcorePlayerCount)) * 31;
        Date date = this.releasedDate;
        int iHashCode10 = (iHashCode9 + (date == null ? 0 : date.hashCode())) * 31;
        String str6 = this.releasedDateGranularity;
        int iHashCode11 = (((((iHashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31) + Integer.hashCode(this.achievementsCount)) * 31) + Integer.hashCode(this.unlockedAchievementsCount)) * 31;
        Date date2 = this.lastUpdatedTimestamp;
        return iHashCode11 + (date2 != null ? date2.hashCode() : 0);
    }

    public String toString() {
        return "RetroAchievementsGameRecordEntity(id=" + this.f38id + ", userId=" + this.userId + ", gameId=" + this.gameId + ", name=" + this.name + ", url=" + this.url + ", imageUrl=" + this.imageUrl + ", guideUrl=" + this.guideUrl + ", forumTopicId=" + this.forumTopicId + ", consoleId=" + this.consoleId + ", consoleName=" + this.consoleName + ", rating=" + this.rating + ", ratingVotesCount=" + this.ratingVotesCount + ", totalPlayerCount=" + this.totalPlayerCount + ", distinctPlayerCount=" + this.distinctPlayerCount + ", distinctCasualPlayerCount=" + this.distinctCasualPlayerCount + ", distinctHardcorePlayerCount=" + this.distinctHardcorePlayerCount + ", releasedDate=" + this.releasedDate + ", releasedDateGranularity=" + this.releasedDateGranularity + ", achievementsCount=" + this.achievementsCount + ", unlockedAchievementsCount=" + this.unlockedAchievementsCount + ", lastUpdatedTimestamp=" + this.lastUpdatedTimestamp + ")";
    }

    public RetroAchievementsGameRecordEntity(long j, String userId, long j2, String str, String str2, String str3, String str4, Integer num, Long l, String str5, Float f, int i, int i2, long j3, long j4, long j5, Date date, String str6, int i3, int i4, Date date2) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.f38id = j;
        this.userId = userId;
        this.gameId = j2;
        this.name = str;
        this.url = str2;
        this.imageUrl = str3;
        this.guideUrl = str4;
        this.forumTopicId = num;
        this.consoleId = l;
        this.consoleName = str5;
        this.rating = f;
        this.ratingVotesCount = i;
        this.totalPlayerCount = i2;
        this.distinctPlayerCount = j3;
        this.distinctCasualPlayerCount = j4;
        this.distinctHardcorePlayerCount = j5;
        this.releasedDate = date;
        this.releasedDateGranularity = str6;
        this.achievementsCount = i3;
        this.unlockedAchievementsCount = i4;
        this.lastUpdatedTimestamp = date2;
    }

    public /* synthetic */ RetroAchievementsGameRecordEntity(long j, String str, long j2, String str2, String str3, String str4, String str5, Integer num, Long l, String str6, Float f, int i, int i2, long j3, long j4, long j5, Date date, String str7, int i3, int i4, Date date2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0L : j, str, j2, (i5 & 8) != 0 ? null : str2, (i5 & 16) != 0 ? null : str3, (i5 & 32) != 0 ? null : str4, (i5 & 64) != 0 ? null : str5, (i5 & 128) != 0 ? null : num, (i5 & 256) != 0 ? null : l, (i5 & 512) != 0 ? null : str6, (i5 & CategoryWidgetViewModel.LIMIT) != 0 ? null : f, (i5 & 2048) != 0 ? 0 : i, (i5 & 4096) != 0 ? 0 : i2, (i5 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? 0L : j3, (i5 & 16384) != 0 ? 0L : j4, (32768 & i5) != 0 ? 0L : j5, (65536 & i5) != 0 ? null : date, (131072 & i5) != 0 ? null : str7, (262144 & i5) != 0 ? 0 : i3, (524288 & i5) != 0 ? 0 : i4, (i5 & 1048576) != 0 ? null : date2);
    }

    public final long getId() {
        return this.f38id;
    }

    public final void setId(long j) {
        this.f38id = j;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final long getGameId() {
        return this.gameId;
    }

    public final void setGameId(long j) {
        this.gameId = j;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
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

    public final String getGuideUrl() {
        return this.guideUrl;
    }

    public final void setGuideUrl(String str) {
        this.guideUrl = str;
    }

    public final Integer getForumTopicId() {
        return this.forumTopicId;
    }

    public final void setForumTopicId(Integer num) {
        this.forumTopicId = num;
    }

    public final Long getConsoleId() {
        return this.consoleId;
    }

    public final void setConsoleId(Long l) {
        this.consoleId = l;
    }

    public final String getConsoleName() {
        return this.consoleName;
    }

    public final void setConsoleName(String str) {
        this.consoleName = str;
    }

    public final Float getRating() {
        return this.rating;
    }

    public final void setRating(Float f) {
        this.rating = f;
    }

    public final int getRatingVotesCount() {
        return this.ratingVotesCount;
    }

    public final void setRatingVotesCount(int i) {
        this.ratingVotesCount = i;
    }

    public final int getTotalPlayerCount() {
        return this.totalPlayerCount;
    }

    public final void setTotalPlayerCount(int i) {
        this.totalPlayerCount = i;
    }

    public final long getDistinctPlayerCount() {
        return this.distinctPlayerCount;
    }

    public final void setDistinctPlayerCount(long j) {
        this.distinctPlayerCount = j;
    }

    public final long getDistinctCasualPlayerCount() {
        return this.distinctCasualPlayerCount;
    }

    public final void setDistinctCasualPlayerCount(long j) {
        this.distinctCasualPlayerCount = j;
    }

    public final long getDistinctHardcorePlayerCount() {
        return this.distinctHardcorePlayerCount;
    }

    public final void setDistinctHardcorePlayerCount(long j) {
        this.distinctHardcorePlayerCount = j;
    }

    public final Date getReleasedDate() {
        return this.releasedDate;
    }

    public final void setReleasedDate(Date date) {
        this.releasedDate = date;
    }

    public final String getReleasedDateGranularity() {
        return this.releasedDateGranularity;
    }

    public final void setReleasedDateGranularity(String str) {
        this.releasedDateGranularity = str;
    }

    public final int getAchievementsCount() {
        return this.achievementsCount;
    }

    public final void setAchievementsCount(int i) {
        this.achievementsCount = i;
    }

    public final int getUnlockedAchievementsCount() {
        return this.unlockedAchievementsCount;
    }

    public final void setUnlockedAchievementsCount(int i) {
        this.unlockedAchievementsCount = i;
    }

    public final Date getLastUpdatedTimestamp() {
        return this.lastUpdatedTimestamp;
    }

    public final void setLastUpdatedTimestamp(Date date) {
        this.lastUpdatedTimestamp = date;
    }
}
