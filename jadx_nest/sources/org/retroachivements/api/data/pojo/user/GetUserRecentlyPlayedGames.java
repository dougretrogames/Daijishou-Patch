package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: GetUserRecentlyPlayedGames.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserRecentlyPlayedGames;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserRecentlyPlayedGames {

    /* JADX INFO: compiled from: GetUserRecentlyPlayedGames.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserRecentlyPlayedGames$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/user/GetUserRecentlyPlayedGames$Response$Game;", "Lkotlin/collections/ArrayList;", "()V", "Game", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<Game> {

        /* JADX INFO: compiled from: GetUserRecentlyPlayedGames.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J©\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0005HÖ\u0001J\t\u0010>\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0016\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001b¨\u0006?"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserRecentlyPlayedGames$Response$Game;", "", "gameId", "", "consoleId", "", "consoleName", "", "title", "imageIcon", "imageTitle", "imageIngame", "imageBoxArt", "lastPlayed", "achievementsTotal", "numPossibleAchievements", "possibleScore", "numAchieved", "scoreAchieved", "numAchievedHardcore", "scoreAchievedHardcore", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJJJ)V", "getAchievementsTotal", "()J", "getConsoleId", "()I", "getConsoleName", "()Ljava/lang/String;", "getGameId", "getImageBoxArt", "getImageIcon", "getImageIngame", "getImageTitle", "getLastPlayed", "getNumAchieved", "getNumAchievedHardcore", "getNumPossibleAchievements", "getPossibleScore", "getScoreAchieved", "getScoreAchievedHardcore", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Game {

            @SerializedName("AchievementsTotal")
            private final long achievementsTotal;

            @SerializedName("ConsoleID")
            private final int consoleId;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("GameID")
            private final long gameId;

            @SerializedName("ImageBoxArt")
            private final String imageBoxArt;

            @SerializedName("ImageIcon")
            private final String imageIcon;

            @SerializedName("ImageIngame")
            private final String imageIngame;

            @SerializedName("ImageTitle")
            private final String imageTitle;

            @SerializedName("LastPlayed")
            private final String lastPlayed;

            @SerializedName("NumAchieved")
            private final long numAchieved;

            @SerializedName("NumAchievedHardcore")
            private final long numAchievedHardcore;

            @SerializedName("NumPossibleAchievements")
            private final long numPossibleAchievements;

            @SerializedName("PossibleScore")
            private final long possibleScore;

            @SerializedName("ScoreAchieved")
            private final long scoreAchieved;

            @SerializedName("ScoreAchievedHardcore")
            private final long scoreAchievedHardcore;

            @SerializedName("Title")
            private final String title;

            public static /* synthetic */ Game copy$default(Game game, long j, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i2, Object obj) {
                long j9;
                long j10;
                long j11 = (i2 & 1) != 0 ? game.gameId : j;
                int i3 = (i2 & 2) != 0 ? game.consoleId : i;
                String str8 = (i2 & 4) != 0 ? game.consoleName : str;
                String str9 = (i2 & 8) != 0 ? game.title : str2;
                String str10 = (i2 & 16) != 0 ? game.imageIcon : str3;
                String str11 = (i2 & 32) != 0 ? game.imageTitle : str4;
                String str12 = (i2 & 64) != 0 ? game.imageIngame : str5;
                String str13 = (i2 & 128) != 0 ? game.imageBoxArt : str6;
                String str14 = (i2 & 256) != 0 ? game.lastPlayed : str7;
                long j12 = (i2 & 512) != 0 ? game.achievementsTotal : j2;
                long j13 = (i2 & 1024) != 0 ? game.numPossibleAchievements : j3;
                long j14 = j11;
                long j15 = (i2 & 2048) != 0 ? game.possibleScore : j4;
                long j16 = (i2 & 4096) != 0 ? game.numAchieved : j5;
                long j17 = (i2 & 8192) != 0 ? game.scoreAchieved : j6;
                long j18 = (i2 & 16384) != 0 ? game.numAchievedHardcore : j7;
                if ((i2 & 32768) != 0) {
                    j10 = j18;
                    j9 = game.scoreAchievedHardcore;
                } else {
                    j9 = j8;
                    j10 = j18;
                }
                return game.copy(j14, i3, str8, str9, str10, str11, str12, str13, str14, j12, j13, j15, j16, j17, j10, j9);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGameId() {
                return this.gameId;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final long getAchievementsTotal() {
                return this.achievementsTotal;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final long getNumPossibleAchievements() {
                return this.numPossibleAchievements;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final long getPossibleScore() {
                return this.possibleScore;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final long getNumAchieved() {
                return this.numAchieved;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final long getScoreAchieved() {
                return this.scoreAchieved;
            }

            /* JADX INFO: renamed from: component15, reason: from getter */
            public final long getNumAchievedHardcore() {
                return this.numAchievedHardcore;
            }

            /* JADX INFO: renamed from: component16, reason: from getter */
            public final long getScoreAchievedHardcore() {
                return this.scoreAchievedHardcore;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getConsoleId() {
                return this.consoleId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getImageIcon() {
                return this.imageIcon;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getImageTitle() {
                return this.imageTitle;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getImageIngame() {
                return this.imageIngame;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final String getImageBoxArt() {
                return this.imageBoxArt;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getLastPlayed() {
                return this.lastPlayed;
            }

            public final Game copy(long gameId, int consoleId, String consoleName, String title, String imageIcon, String imageTitle, String imageIngame, String imageBoxArt, String lastPlayed, long achievementsTotal, long numPossibleAchievements, long possibleScore, long numAchieved, long scoreAchieved, long numAchievedHardcore, long scoreAchievedHardcore) {
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                Intrinsics.checkNotNullParameter(imageTitle, "imageTitle");
                Intrinsics.checkNotNullParameter(imageIngame, "imageIngame");
                Intrinsics.checkNotNullParameter(imageBoxArt, "imageBoxArt");
                Intrinsics.checkNotNullParameter(lastPlayed, "lastPlayed");
                return new Game(gameId, consoleId, consoleName, title, imageIcon, imageTitle, imageIngame, imageBoxArt, lastPlayed, achievementsTotal, numPossibleAchievements, possibleScore, numAchieved, scoreAchieved, numAchievedHardcore, scoreAchievedHardcore);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Game)) {
                    return false;
                }
                Game game = (Game) other;
                return this.gameId == game.gameId && this.consoleId == game.consoleId && Intrinsics.areEqual(this.consoleName, game.consoleName) && Intrinsics.areEqual(this.title, game.title) && Intrinsics.areEqual(this.imageIcon, game.imageIcon) && Intrinsics.areEqual(this.imageTitle, game.imageTitle) && Intrinsics.areEqual(this.imageIngame, game.imageIngame) && Intrinsics.areEqual(this.imageBoxArt, game.imageBoxArt) && Intrinsics.areEqual(this.lastPlayed, game.lastPlayed) && this.achievementsTotal == game.achievementsTotal && this.numPossibleAchievements == game.numPossibleAchievements && this.possibleScore == game.possibleScore && this.numAchieved == game.numAchieved && this.scoreAchieved == game.scoreAchieved && this.numAchievedHardcore == game.numAchievedHardcore && this.scoreAchievedHardcore == game.scoreAchievedHardcore;
            }

            public int hashCode() {
                return (((((((((((((((((((((((((((((Long.hashCode(this.gameId) * 31) + Integer.hashCode(this.consoleId)) * 31) + this.consoleName.hashCode()) * 31) + this.title.hashCode()) * 31) + this.imageIcon.hashCode()) * 31) + this.imageTitle.hashCode()) * 31) + this.imageIngame.hashCode()) * 31) + this.imageBoxArt.hashCode()) * 31) + this.lastPlayed.hashCode()) * 31) + Long.hashCode(this.achievementsTotal)) * 31) + Long.hashCode(this.numPossibleAchievements)) * 31) + Long.hashCode(this.possibleScore)) * 31) + Long.hashCode(this.numAchieved)) * 31) + Long.hashCode(this.scoreAchieved)) * 31) + Long.hashCode(this.numAchievedHardcore)) * 31) + Long.hashCode(this.scoreAchievedHardcore);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Game(gameId=");
                sb.append(this.gameId).append(", consoleId=").append(this.consoleId).append(", consoleName=").append(this.consoleName).append(", title=").append(this.title).append(", imageIcon=").append(this.imageIcon).append(", imageTitle=").append(this.imageTitle).append(", imageIngame=").append(this.imageIngame).append(", imageBoxArt=").append(this.imageBoxArt).append(", lastPlayed=").append(this.lastPlayed).append(", achievementsTotal=").append(this.achievementsTotal).append(", numPossibleAchievements=").append(this.numPossibleAchievements).append(", possibleScore=");
                sb.append(this.possibleScore).append(", numAchieved=").append(this.numAchieved).append(", scoreAchieved=").append(this.scoreAchieved).append(", numAchievedHardcore=").append(this.numAchievedHardcore).append(", scoreAchievedHardcore=").append(this.scoreAchievedHardcore).append(')');
                return sb.toString();
            }

            public Game(long j, int i, String consoleName, String title, String imageIcon, String imageTitle, String imageIngame, String imageBoxArt, String lastPlayed, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                Intrinsics.checkNotNullParameter(imageTitle, "imageTitle");
                Intrinsics.checkNotNullParameter(imageIngame, "imageIngame");
                Intrinsics.checkNotNullParameter(imageBoxArt, "imageBoxArt");
                Intrinsics.checkNotNullParameter(lastPlayed, "lastPlayed");
                this.gameId = j;
                this.consoleId = i;
                this.consoleName = consoleName;
                this.title = title;
                this.imageIcon = imageIcon;
                this.imageTitle = imageTitle;
                this.imageIngame = imageIngame;
                this.imageBoxArt = imageBoxArt;
                this.lastPlayed = lastPlayed;
                this.achievementsTotal = j2;
                this.numPossibleAchievements = j3;
                this.possibleScore = j4;
                this.numAchieved = j5;
                this.scoreAchieved = j6;
                this.numAchievedHardcore = j7;
                this.scoreAchievedHardcore = j8;
            }

            public final long getGameId() {
                return this.gameId;
            }

            public final int getConsoleId() {
                return this.consoleId;
            }

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getImageIcon() {
                return this.imageIcon;
            }

            public final String getImageTitle() {
                return this.imageTitle;
            }

            public final String getImageIngame() {
                return this.imageIngame;
            }

            public final String getImageBoxArt() {
                return this.imageBoxArt;
            }

            public final String getLastPlayed() {
                return this.lastPlayed;
            }

            public final long getAchievementsTotal() {
                return this.achievementsTotal;
            }

            public final long getNumPossibleAchievements() {
                return this.numPossibleAchievements;
            }

            public final long getPossibleScore() {
                return this.possibleScore;
            }

            public final long getNumAchieved() {
                return this.numAchieved;
            }

            public final long getScoreAchieved() {
                return this.scoreAchieved;
            }

            public final long getNumAchievedHardcore() {
                return this.numAchievedHardcore;
            }

            public final long getScoreAchievedHardcore() {
                return this.scoreAchievedHardcore;
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Game) {
                return contains((Game) obj);
            }
            return false;
        }

        public /* bridge */ boolean contains(Game game) {
            return super.contains((Object) game);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Game) {
                return indexOf((Game) obj);
            }
            return -1;
        }

        public /* bridge */ int indexOf(Game game) {
            return super.indexOf((Object) game);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Game) {
                return lastIndexOf((Game) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(Game game) {
            return super.lastIndexOf((Object) game);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ Game remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof Game) {
                return remove((Game) obj);
            }
            return false;
        }

        public /* bridge */ boolean remove(Game game) {
            return super.remove((Object) game);
        }

        public /* bridge */ Game removeAt(int i) {
            return (Game) super.remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }
    }
}
