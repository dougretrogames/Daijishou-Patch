package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* INFO: compiled from: GetUserRecentAchievements.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserRecentAchievements;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserRecentAchievements {

    /* INFO: compiled from: GetUserRecentAchievements.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserRecentAchievements$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/user/GetUserRecentAchievements$Response$Achievement;", "Lkotlin/collections/ArrayList;", "()V", "Achievement", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<Achievement> {

        /* INFO: compiled from: GetUserRecentAchievements.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\fHÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jµ\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0003HÆ\u0001J\u0013\u0010?\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\fHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\u0014\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0016\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001b¨\u0006C"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserRecentAchievements$Response$Achievement;", "", "date", "", "hardcoreMode", "", "achievementId", "", "title", "description", "badgeName", "points", "", "trueRatio", "type", "author", "gameTitle", "gameIcon", "gameId", "consoleName", "cumulScore", "badgeUrl", "gameUrl", "(Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAchievementId", "()J", "getAuthor", "()Ljava/lang/String;", "getBadgeName", "getBadgeUrl", "getConsoleName", "getCumulScore", "()I", "getDate", "getDescription", "getGameIcon", "getGameId", "getGameTitle", "getGameUrl", "getHardcoreMode", "()Z", "getPoints", "getTitle", "getTrueRatio", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Achievement {

            @SerializedName("AchievementID")
            private final long achievementId;

            @SerializedName("Author")
            private final String author;

            @SerializedName("BadgeName")
            private final String badgeName;

            @SerializedName("BadgeUrl")
            private final String badgeUrl;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("CumulScore")
            private final int cumulScore;

            @SerializedName("Date")
            private final String date;

            @SerializedName("Description")
            private final String description;

            @SerializedName("GameIcon")
            private final String gameIcon;

            @SerializedName("GameID")
            private final long gameId;

            @SerializedName("GameTitle")
            private final String gameTitle;

            @SerializedName("GameUrl")
            private final String gameUrl;

            @SerializedName("HardcoreMode")
            @JsonAdapter(BooleanJsonDeserializer.class)
            private final boolean hardcoreMode;

            @SerializedName("Points")
            private final int points;

            @SerializedName("Title")
            private final String title;

            @SerializedName("TrueRatio")
            private final int trueRatio;

            @SerializedName("Type")
            private final String type;

            public static /* synthetic */ Achievement copy$default(Achievement achievement, String str, boolean z, long j, String str2, String str3, String str4, int i, int i2, String str5, String str6, String str7, String str8, long j2, String str9, int i3, String str10, String str11, int i4, Object obj) {
                String str12 = (i4 & 1) != 0 ? achievement.date : str;
                boolean z2 = (i4 & 2) != 0 ? achievement.hardcoreMode : z;
                long j3 = (i4 & 4) != 0 ? achievement.achievementId : j;
                String str13 = (i4 & 8) != 0 ? achievement.title : str2;
                String str14 = (i4 & 16) != 0 ? achievement.description : str3;
                String str15 = (i4 & 32) != 0 ? achievement.badgeName : str4;
                int i5 = (i4 & 64) != 0 ? achievement.points : i;
                int i6 = (i4 & 128) != 0 ? achievement.trueRatio : i2;
                String str16 = (i4 & 256) != 0 ? achievement.type : str5;
                String str17 = (i4 & 512) != 0 ? achievement.author : str6;
                String str18 = (i4 & 1024) != 0 ? achievement.gameTitle : str7;
                String str19 = (i4 & 2048) != 0 ? achievement.gameIcon : str8;
                String str20 = str12;
                boolean z3 = z2;
                long j4 = (i4 & 4096) != 0 ? achievement.gameId : j2;
                return achievement.copy(str20, z3, j3, str13, str14, str15, i5, i6, str16, str17, str18, str19, j4, (i4 & 8192) != 0 ? achievement.consoleName : str9, (i4 & 16384) != 0 ? achievement.cumulScore : i3, (32768 & i4) != 0 ? achievement.badgeUrl : str10, (i4 & 65536) != 0 ? achievement.gameUrl : str11);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final String getDate() {
                return this.date;
            }

            /* INFO: renamed from: component10, reason: from getter */
            public final String getAuthor() {
                return this.author;
            }

            /* INFO: renamed from: component11, reason: from getter */
            public final String getGameTitle() {
                return this.gameTitle;
            }

            /* INFO: renamed from: component12, reason: from getter */
            public final String getGameIcon() {
                return this.gameIcon;
            }

            /* INFO: renamed from: component13, reason: from getter */
            public final long getGameId() {
                return this.gameId;
            }

            /* INFO: renamed from: component14, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* INFO: renamed from: component15, reason: from getter */
            public final int getCumulScore() {
                return this.cumulScore;
            }

            /* INFO: renamed from: component16, reason: from getter */
            public final String getBadgeUrl() {
                return this.badgeUrl;
            }

            /* INFO: renamed from: component17, reason: from getter */
            public final String getGameUrl() {
                return this.gameUrl;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final boolean getHardcoreMode() {
                return this.hardcoreMode;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final long getAchievementId() {
                return this.achievementId;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            /* INFO: renamed from: component6, reason: from getter */
            public final String getBadgeName() {
                return this.badgeName;
            }

            /* INFO: renamed from: component7, reason: from getter */
            public final int getPoints() {
                return this.points;
            }

            /* INFO: renamed from: component8, reason: from getter */
            public final int getTrueRatio() {
                return this.trueRatio;
            }

            /* INFO: renamed from: component9, reason: from getter */
            public final String getType() {
                return this.type;
            }

            public final Achievement copy(String date, boolean hardcoreMode, long achievementId, String title, String description, String badgeName, int points, int trueRatio, String type, String author, String gameTitle, String gameIcon, long gameId, String consoleName, int cumulScore, String badgeUrl, String gameUrl) {
                Intrinsics.checkNotNullParameter(date, "date");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                Intrinsics.checkNotNullParameter(author, "author");
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(badgeUrl, "badgeUrl");
                Intrinsics.checkNotNullParameter(gameUrl, "gameUrl");
                return new Achievement(date, hardcoreMode, achievementId, title, description, badgeName, points, trueRatio, type, author, gameTitle, gameIcon, gameId, consoleName, cumulScore, badgeUrl, gameUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Achievement)) {
                    return false;
                }
                Achievement achievement = (Achievement) other;
                return Intrinsics.areEqual(this.date, achievement.date) && this.hardcoreMode == achievement.hardcoreMode && this.achievementId == achievement.achievementId && Intrinsics.areEqual(this.title, achievement.title) && Intrinsics.areEqual(this.description, achievement.description) && Intrinsics.areEqual(this.badgeName, achievement.badgeName) && this.points == achievement.points && this.trueRatio == achievement.trueRatio && Intrinsics.areEqual(this.type, achievement.type) && Intrinsics.areEqual(this.author, achievement.author) && Intrinsics.areEqual(this.gameTitle, achievement.gameTitle) && Intrinsics.areEqual(this.gameIcon, achievement.gameIcon) && this.gameId == achievement.gameId && Intrinsics.areEqual(this.consoleName, achievement.consoleName) && this.cumulScore == achievement.cumulScore && Intrinsics.areEqual(this.badgeUrl, achievement.badgeUrl) && Intrinsics.areEqual(this.gameUrl, achievement.gameUrl);
            }

            public int hashCode() {
                int iHashCode = ((((((((((((((this.date.hashCode() * 31) + Boolean.hashCode(this.hardcoreMode)) * 31) + Long.hashCode(this.achievementId)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.badgeName.hashCode()) * 31) + Integer.hashCode(this.points)) * 31) + Integer.hashCode(this.trueRatio)) * 31;
                String str = this.type;
                return ((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.author.hashCode()) * 31) + this.gameTitle.hashCode()) * 31) + this.gameIcon.hashCode()) * 31) + Long.hashCode(this.gameId)) * 31) + this.consoleName.hashCode()) * 31) + Integer.hashCode(this.cumulScore)) * 31) + this.badgeUrl.hashCode()) * 31) + this.gameUrl.hashCode();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Achievement(date=");
                sb.append(this.date).append(", hardcoreMode=").append(this.hardcoreMode).append(", achievementId=").append(this.achievementId).append(", title=").append(this.title).append(", description=").append(this.description).append(", badgeName=").append(this.badgeName).append(", points=").append(this.points).append(", trueRatio=").append(this.trueRatio).append(", type=").append(this.type).append(", author=").append(this.author).append(", gameTitle=").append(this.gameTitle).append(", gameIcon=");
                sb.append(this.gameIcon).append(", gameId=").append(this.gameId).append(", consoleName=").append(this.consoleName).append(", cumulScore=").append(this.cumulScore).append(", badgeUrl=").append(this.badgeUrl).append(", gameUrl=").append(this.gameUrl).append(')');
                return sb.toString();
            }

            public Achievement(String date, boolean z, long j, String title, String description, String badgeName, int i, int i2, String str, String author, String gameTitle, String gameIcon, long j2, String consoleName, int i3, String badgeUrl, String gameUrl) {
                Intrinsics.checkNotNullParameter(date, "date");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                Intrinsics.checkNotNullParameter(author, "author");
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(badgeUrl, "badgeUrl");
                Intrinsics.checkNotNullParameter(gameUrl, "gameUrl");
                this.date = date;
                this.hardcoreMode = z;
                this.achievementId = j;
                this.title = title;
                this.description = description;
                this.badgeName = badgeName;
                this.points = i;
                this.trueRatio = i2;
                this.type = str;
                this.author = author;
                this.gameTitle = gameTitle;
                this.gameIcon = gameIcon;
                this.gameId = j2;
                this.consoleName = consoleName;
                this.cumulScore = i3;
                this.badgeUrl = badgeUrl;
                this.gameUrl = gameUrl;
            }

            public final String getDate() {
                return this.date;
            }

            public final boolean getHardcoreMode() {
                return this.hardcoreMode;
            }

            public final long getAchievementId() {
                return this.achievementId;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getBadgeName() {
                return this.badgeName;
            }

            public final int getPoints() {
                return this.points;
            }

            public final int getTrueRatio() {
                return this.trueRatio;
            }

            public final String getType() {
                return this.type;
            }

            public final String getAuthor() {
                return this.author;
            }

            public final String getGameTitle() {
                return this.gameTitle;
            }

            public final String getGameIcon() {
                return this.gameIcon;
            }

            public final long getGameId() {
                return this.gameId;
            }

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final int getCumulScore() {
                return this.cumulScore;
            }

            public final String getBadgeUrl() {
                return this.badgeUrl;
            }

            public final String getGameUrl() {
                return this.gameUrl;
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Achievement) {
                return contains((Achievement) obj);
            }
            return false;
        }

        public /* bridge */ boolean contains(Achievement achievement) {
            return super.contains((Object) achievement);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Achievement) {
                return indexOf((Achievement) obj);
            }
            return -1;
        }

        public /* bridge */ int indexOf(Achievement achievement) {
            return super.indexOf((Object) achievement);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Achievement) {
                return lastIndexOf((Achievement) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(Achievement achievement) {
            return super.lastIndexOf((Object) achievement);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ Achievement remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof Achievement) {
                return remove((Achievement) obj);
            }
            return false;
        }

        public /* bridge */ boolean remove(Achievement achievement) {
            return super.remove((Object) achievement);
        }

        public /* bridge */ Achievement removeAt(int i) {
            return (Achievement) super.remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }
    }
}
