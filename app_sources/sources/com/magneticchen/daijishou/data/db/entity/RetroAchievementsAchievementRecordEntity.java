package com.magneticchen.daijishou.data.db.entity;

import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetroAchievementsAchievementRecordEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bG\b\u0087\b\u0018\u00002\u00020\u0001B·\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010J\u001a\u00020\u0010HÆ\u0003J\t\u0010K\u001a\u00020\nHÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0015HÆ\u0003J\t\u0010O\u001a\u00020\u0015HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010T\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010U\u001a\u00020\nHÆ\u0003J\t\u0010V\u001a\u00020\bHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\bHÆ\u0003JÄ\u0001\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010ZJ\u0013\u0010[\u001a\u00020\u00152\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\nHÖ\u0001J\t\u0010^\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR \u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010,\"\u0004\b/\u0010.R\u001e\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001dR\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001b\"\u0004\b?\u0010\u001dR \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR \u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001f\"\u0004\bE\u0010!R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001f\"\u0004\bG\u0010!¨\u0006_"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;", "", "id", "", "gameRecordId", "achievementId", "gameId", "userId", "", "orderingIndex", "", "name", "description", "url", "imageUrl", "unlockRate", "", "points", "unlockedPlayerCount", "unlockedHardcorePlayerCount", "isHardcoreUnlocked", "", "isUnlocked", "unlockedTimestamp", "Ljava/util/Date;", "(JJJLjava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIJJZZLjava/util/Date;)V", "getAchievementId", "()J", "setAchievementId", "(J)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getGameId", "()Ljava/lang/Long;", "setGameId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getGameRecordId", "getId", "setId", "getImageUrl", "setImageUrl", "()Z", "setHardcoreUnlocked", "(Z)V", "setUnlocked", "getName", "setName", "getOrderingIndex", "()I", "setOrderingIndex", "(I)V", "getPoints", "setPoints", "getUnlockRate", "()F", "setUnlockRate", "(F)V", "getUnlockedHardcorePlayerCount", "setUnlockedHardcorePlayerCount", "getUnlockedPlayerCount", "setUnlockedPlayerCount", "getUnlockedTimestamp", "()Ljava/util/Date;", "setUnlockedTimestamp", "(Ljava/util/Date;)V", "getUrl", "setUrl", "getUserId", "setUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JJJLjava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIJJZZLjava/util/Date;)Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsAchievementRecordEntity {
    private long achievementId;
    private String description;
    private Long gameId;
    private final long gameRecordId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f36id;
    private String imageUrl;
    private boolean isHardcoreUnlocked;
    private boolean isUnlocked;
    private String name;
    private int orderingIndex;
    private int points;
    private float unlockRate;
    private long unlockedHardcorePlayerCount;
    private long unlockedPlayerCount;
    private Date unlockedTimestamp;
    private String url;
    private String userId;

    public static /* synthetic */ RetroAchievementsAchievementRecordEntity copy$default(RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity, long j, long j2, long j3, Long l, String str, int i, String str2, String str3, String str4, String str5, float f, int i2, long j4, long j5, boolean z, boolean z2, Date date, int i3, Object obj) {
        long j6 = (i3 & 1) != 0 ? retroAchievementsAchievementRecordEntity.f36id : j;
        return retroAchievementsAchievementRecordEntity.copy(j6, (i3 & 2) != 0 ? retroAchievementsAchievementRecordEntity.gameRecordId : j2, (i3 & 4) != 0 ? retroAchievementsAchievementRecordEntity.achievementId : j3, (i3 & 8) != 0 ? retroAchievementsAchievementRecordEntity.gameId : l, (i3 & 16) != 0 ? retroAchievementsAchievementRecordEntity.userId : str, (i3 & 32) != 0 ? retroAchievementsAchievementRecordEntity.orderingIndex : i, (i3 & 64) != 0 ? retroAchievementsAchievementRecordEntity.name : str2, (i3 & 128) != 0 ? retroAchievementsAchievementRecordEntity.description : str3, (i3 & 256) != 0 ? retroAchievementsAchievementRecordEntity.url : str4, (i3 & 512) != 0 ? retroAchievementsAchievementRecordEntity.imageUrl : str5, (i3 & CategoryWidgetViewModel.LIMIT) != 0 ? retroAchievementsAchievementRecordEntity.unlockRate : f, (i3 & 2048) != 0 ? retroAchievementsAchievementRecordEntity.points : i2, (i3 & 4096) != 0 ? retroAchievementsAchievementRecordEntity.unlockedPlayerCount : j4, (i3 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? retroAchievementsAchievementRecordEntity.unlockedHardcorePlayerCount : j5, (i3 & 16384) != 0 ? retroAchievementsAchievementRecordEntity.isHardcoreUnlocked : z, (32768 & i3) != 0 ? retroAchievementsAchievementRecordEntity.isUnlocked : z2, (i3 & 65536) != 0 ? retroAchievementsAchievementRecordEntity.unlockedTimestamp : date);
    }

    public final long component1() {
        return this.f36id;
    }

    public final String component10() {
        return this.imageUrl;
    }

    public final float component11() {
        return this.unlockRate;
    }

    public final int component12() {
        return this.points;
    }

    public final long component13() {
        return this.unlockedPlayerCount;
    }

    public final long component14() {
        return this.unlockedHardcorePlayerCount;
    }

    public final boolean component15() {
        return this.isHardcoreUnlocked;
    }

    public final boolean component16() {
        return this.isUnlocked;
    }

    public final Date component17() {
        return this.unlockedTimestamp;
    }

    public final long component2() {
        return this.gameRecordId;
    }

    public final long component3() {
        return this.achievementId;
    }

    public final Long component4() {
        return this.gameId;
    }

    public final String component5() {
        return this.userId;
    }

    public final int component6() {
        return this.orderingIndex;
    }

    public final String component7() {
        return this.name;
    }

    public final String component8() {
        return this.description;
    }

    public final String component9() {
        return this.url;
    }

    public final RetroAchievementsAchievementRecordEntity copy(long j, long j2, long j3, Long l, String str, int i, String name, String str2, String str3, String str4, float f, int i2, long j4, long j5, boolean z, boolean z2, Date date) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new RetroAchievementsAchievementRecordEntity(j, j2, j3, l, str, i, name, str2, str3, str4, f, i2, j4, j5, z, z2, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetroAchievementsAchievementRecordEntity)) {
            return false;
        }
        RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity = (RetroAchievementsAchievementRecordEntity) obj;
        return this.f36id == retroAchievementsAchievementRecordEntity.f36id && this.gameRecordId == retroAchievementsAchievementRecordEntity.gameRecordId && this.achievementId == retroAchievementsAchievementRecordEntity.achievementId && Intrinsics.areEqual(this.gameId, retroAchievementsAchievementRecordEntity.gameId) && Intrinsics.areEqual(this.userId, retroAchievementsAchievementRecordEntity.userId) && this.orderingIndex == retroAchievementsAchievementRecordEntity.orderingIndex && Intrinsics.areEqual(this.name, retroAchievementsAchievementRecordEntity.name) && Intrinsics.areEqual(this.description, retroAchievementsAchievementRecordEntity.description) && Intrinsics.areEqual(this.url, retroAchievementsAchievementRecordEntity.url) && Intrinsics.areEqual(this.imageUrl, retroAchievementsAchievementRecordEntity.imageUrl) && Float.compare(this.unlockRate, retroAchievementsAchievementRecordEntity.unlockRate) == 0 && this.points == retroAchievementsAchievementRecordEntity.points && this.unlockedPlayerCount == retroAchievementsAchievementRecordEntity.unlockedPlayerCount && this.unlockedHardcorePlayerCount == retroAchievementsAchievementRecordEntity.unlockedHardcorePlayerCount && this.isHardcoreUnlocked == retroAchievementsAchievementRecordEntity.isHardcoreUnlocked && this.isUnlocked == retroAchievementsAchievementRecordEntity.isUnlocked && Intrinsics.areEqual(this.unlockedTimestamp, retroAchievementsAchievementRecordEntity.unlockedTimestamp);
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.f36id) * 31) + Long.hashCode(this.gameRecordId)) * 31) + Long.hashCode(this.achievementId)) * 31;
        Long l = this.gameId;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.userId;
        int iHashCode3 = (((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.orderingIndex)) * 31) + this.name.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.imageUrl;
        int iHashCode6 = (((((((((((((iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31) + Float.hashCode(this.unlockRate)) * 31) + Integer.hashCode(this.points)) * 31) + Long.hashCode(this.unlockedPlayerCount)) * 31) + Long.hashCode(this.unlockedHardcorePlayerCount)) * 31) + Boolean.hashCode(this.isHardcoreUnlocked)) * 31) + Boolean.hashCode(this.isUnlocked)) * 31;
        Date date = this.unlockedTimestamp;
        return iHashCode6 + (date != null ? date.hashCode() : 0);
    }

    public String toString() {
        return "RetroAchievementsAchievementRecordEntity(id=" + this.f36id + ", gameRecordId=" + this.gameRecordId + ", achievementId=" + this.achievementId + ", gameId=" + this.gameId + ", userId=" + this.userId + ", orderingIndex=" + this.orderingIndex + ", name=" + this.name + ", description=" + this.description + ", url=" + this.url + ", imageUrl=" + this.imageUrl + ", unlockRate=" + this.unlockRate + ", points=" + this.points + ", unlockedPlayerCount=" + this.unlockedPlayerCount + ", unlockedHardcorePlayerCount=" + this.unlockedHardcorePlayerCount + ", isHardcoreUnlocked=" + this.isHardcoreUnlocked + ", isUnlocked=" + this.isUnlocked + ", unlockedTimestamp=" + this.unlockedTimestamp + ")";
    }

    public RetroAchievementsAchievementRecordEntity(long j, long j2, long j3, Long l, String str, int i, String name, String str2, String str3, String str4, float f, int i2, long j4, long j5, boolean z, boolean z2, Date date) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f36id = j;
        this.gameRecordId = j2;
        this.achievementId = j3;
        this.gameId = l;
        this.userId = str;
        this.orderingIndex = i;
        this.name = name;
        this.description = str2;
        this.url = str3;
        this.imageUrl = str4;
        this.unlockRate = f;
        this.points = i2;
        this.unlockedPlayerCount = j4;
        this.unlockedHardcorePlayerCount = j5;
        this.isHardcoreUnlocked = z;
        this.isUnlocked = z2;
        this.unlockedTimestamp = date;
    }

    public final long getId() {
        return this.f36id;
    }

    public final void setId(long j) {
        this.f36id = j;
    }

    public final long getGameRecordId() {
        return this.gameRecordId;
    }

    public final long getAchievementId() {
        return this.achievementId;
    }

    public final void setAchievementId(long j) {
        this.achievementId = j;
    }

    public final Long getGameId() {
        return this.gameId;
    }

    public final void setGameId(Long l) {
        this.gameId = l;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final int getOrderingIndex() {
        return this.orderingIndex;
    }

    public final void setOrderingIndex(int i) {
        this.orderingIndex = i;
    }

    public /* synthetic */ RetroAchievementsAchievementRecordEntity(long j, long j2, long j3, Long l, String str, int i, String str2, String str3, String str4, String str5, float f, int i2, long j4, long j5, boolean z, boolean z2, Date date, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, j2, j3, (i3 & 8) != 0 ? null : l, (i3 & 16) != 0 ? null : str, (i3 & 32) != 0 ? 0 : i, (i3 & 64) != 0 ? "Achievement" : str2, (i3 & 128) != 0 ? null : str3, (i3 & 256) != 0 ? null : str4, (i3 & 512) != 0 ? null : str5, (i3 & CategoryWidgetViewModel.LIMIT) != 0 ? 1.0f : f, (i3 & 2048) != 0 ? 0 : i2, (i3 & 4096) != 0 ? 0L : j4, (i3 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? 0L : j5, (i3 & 16384) != 0 ? false : z, (32768 & i3) != 0 ? false : z2, (i3 & 65536) != 0 ? null : date);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
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

    public final float getUnlockRate() {
        return this.unlockRate;
    }

    public final void setUnlockRate(float f) {
        this.unlockRate = f;
    }

    public final int getPoints() {
        return this.points;
    }

    public final void setPoints(int i) {
        this.points = i;
    }

    public final long getUnlockedPlayerCount() {
        return this.unlockedPlayerCount;
    }

    public final void setUnlockedPlayerCount(long j) {
        this.unlockedPlayerCount = j;
    }

    public final long getUnlockedHardcorePlayerCount() {
        return this.unlockedHardcorePlayerCount;
    }

    public final void setUnlockedHardcorePlayerCount(long j) {
        this.unlockedHardcorePlayerCount = j;
    }

    public final boolean isHardcoreUnlocked() {
        return this.isHardcoreUnlocked;
    }

    public final void setHardcoreUnlocked(boolean z) {
        this.isHardcoreUnlocked = z;
    }

    public final boolean isUnlocked() {
        return this.isUnlocked;
    }

    public final void setUnlocked(boolean z) {
        this.isUnlocked = z;
    }

    public final Date getUnlockedTimestamp() {
        return this.unlockedTimestamp;
    }

    public final void setUnlockedTimestamp(Date date) {
        this.unlockedTimestamp = date;
    }
}
