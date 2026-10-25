package org.retroachivements.api.data.pojo.achievement;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* JADX INFO: compiled from: GetAchievementUnlocks.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetAchievementUnlocks {

    /* JADX INFO: compiled from: GetAchievementUnlocks.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks;", "Lkotlin/collections/ArrayList;", "()V", "Unlocks", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<Unlocks> {

        /* JADX INFO: compiled from: GetAchievementUnlocks.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0004,-./BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fHÆ\u0003J_\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018¨\u00060"}, d2 = {"Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks;", "", "achievement", "Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Achievement;", "console", "Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Console;", "game", "Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Game;", "unlocksCount", "", "unlocksHardcoreCount", "totalPlayers", "unlocks", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Unlock;", "Lkotlin/collections/ArrayList;", "(Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Achievement;Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Console;Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Game;JJJLjava/util/ArrayList;)V", "getAchievement", "()Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Achievement;", "getConsole", "()Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Console;", "getGame", "()Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Game;", "getTotalPlayers", "()J", "getUnlocks", "()Ljava/util/ArrayList;", "getUnlocksCount", "getUnlocksHardcoreCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "Achievement", "Console", "Game", "Unlock", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Unlocks {

            @SerializedName("Achievement")
            private final Achievement achievement;

            @SerializedName("Console")
            private final Console console;

            @SerializedName("Game")
            private final Game game;

            @SerializedName("TotalPlayers")
            private final long totalPlayers;

            @SerializedName("Unlocks")
            private final ArrayList<Unlock> unlocks;

            @SerializedName("UnlocksCount")
            private final long unlocksCount;

            @SerializedName("UnlocksHardcoreCount")
            private final long unlocksHardcoreCount;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Unlocks copy$default(Unlocks unlocks, Achievement achievement, Console console, Game game, long j, long j2, long j3, ArrayList arrayList, int i, Object obj) {
                if ((i & 1) != 0) {
                    achievement = unlocks.achievement;
                }
                if ((i & 2) != 0) {
                    console = unlocks.console;
                }
                if ((i & 4) != 0) {
                    game = unlocks.game;
                }
                if ((i & 8) != 0) {
                    j = unlocks.unlocksCount;
                }
                if ((i & 16) != 0) {
                    j2 = unlocks.unlocksHardcoreCount;
                }
                if ((i & 32) != 0) {
                    j3 = unlocks.totalPlayers;
                }
                if ((i & 64) != 0) {
                    arrayList = unlocks.unlocks;
                }
                ArrayList arrayList2 = arrayList;
                long j4 = j3;
                long j5 = j2;
                Game game2 = game;
                return unlocks.copy(achievement, console, game2, j, j5, j4, arrayList2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Achievement getAchievement() {
                return this.achievement;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Console getConsole() {
                return this.console;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Game getGame() {
                return this.game;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final long getUnlocksCount() {
                return this.unlocksCount;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final long getUnlocksHardcoreCount() {
                return this.unlocksHardcoreCount;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final long getTotalPlayers() {
                return this.totalPlayers;
            }

            public final ArrayList<Unlock> component7() {
                return this.unlocks;
            }

            public final Unlocks copy(Achievement achievement, Console console, Game game, long unlocksCount, long unlocksHardcoreCount, long totalPlayers, ArrayList<Unlock> unlocks) {
                Intrinsics.checkNotNullParameter(achievement, "achievement");
                Intrinsics.checkNotNullParameter(console, "console");
                Intrinsics.checkNotNullParameter(game, "game");
                Intrinsics.checkNotNullParameter(unlocks, "unlocks");
                return new Unlocks(achievement, console, game, unlocksCount, unlocksHardcoreCount, totalPlayers, unlocks);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Unlocks)) {
                    return false;
                }
                Unlocks unlocks = (Unlocks) other;
                return Intrinsics.areEqual(this.achievement, unlocks.achievement) && Intrinsics.areEqual(this.console, unlocks.console) && Intrinsics.areEqual(this.game, unlocks.game) && this.unlocksCount == unlocks.unlocksCount && this.unlocksHardcoreCount == unlocks.unlocksHardcoreCount && this.totalPlayers == unlocks.totalPlayers && Intrinsics.areEqual(this.unlocks, unlocks.unlocks);
            }

            public int hashCode() {
                return (((((((((((this.achievement.hashCode() * 31) + this.console.hashCode()) * 31) + this.game.hashCode()) * 31) + Long.hashCode(this.unlocksCount)) * 31) + Long.hashCode(this.unlocksHardcoreCount)) * 31) + Long.hashCode(this.totalPlayers)) * 31) + this.unlocks.hashCode();
            }

            public String toString() {
                return "Unlocks(achievement=" + this.achievement + ", console=" + this.console + ", game=" + this.game + ", unlocksCount=" + this.unlocksCount + ", unlocksHardcoreCount=" + this.unlocksHardcoreCount + ", totalPlayers=" + this.totalPlayers + ", unlocks=" + this.unlocks + ')';
            }

            public Unlocks(Achievement achievement, Console console, Game game, long j, long j2, long j3, ArrayList<Unlock> unlocks) {
                Intrinsics.checkNotNullParameter(achievement, "achievement");
                Intrinsics.checkNotNullParameter(console, "console");
                Intrinsics.checkNotNullParameter(game, "game");
                Intrinsics.checkNotNullParameter(unlocks, "unlocks");
                this.achievement = achievement;
                this.console = console;
                this.game = game;
                this.unlocksCount = j;
                this.unlocksHardcoreCount = j2;
                this.totalPlayers = j3;
                this.unlocks = unlocks;
            }

            public final Achievement getAchievement() {
                return this.achievement;
            }

            public final Console getConsole() {
                return this.console;
            }

            public final Game getGame() {
                return this.game;
            }

            public final long getUnlocksCount() {
                return this.unlocksCount;
            }

            public final long getUnlocksHardcoreCount() {
                return this.unlocksHardcoreCount;
            }

            public final long getTotalPlayers() {
                return this.totalPlayers;
            }

            public final ArrayList<Unlock> getUnlocks() {
                return this.unlocks;
            }

            /* JADX INFO: compiled from: GetAchievementUnlocks.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u001f"}, d2 = {"Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Unlock;", "", ConfigConstants.CONFIG_USER_SECTION, "", "raPoints", "", "dateAwarded", "hardcoreMode", "", "raSoftcorePoints", "", "(Ljava/lang/String;JLjava/lang/String;ZI)V", "getDateAwarded", "()Ljava/lang/String;", "getHardcoreMode", "()Z", "getRaPoints", "()J", "getRaSoftcorePoints", "()I", "getUser", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Unlock {

                @SerializedName("DateAwarded")
                private final String dateAwarded;

                @SerializedName("HardcoreMode")
                @JsonAdapter(BooleanJsonDeserializer.class)
                private final boolean hardcoreMode;

                @SerializedName("RAPoints")
                private final long raPoints;

                @SerializedName("RASoftcorePoints")
                private final int raSoftcorePoints;

                @SerializedName(SshConstants.USER)
                private final String user;

                public static /* synthetic */ Unlock copy$default(Unlock unlock, String str, long j, String str2, boolean z, int i, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        str = unlock.user;
                    }
                    if ((i2 & 2) != 0) {
                        j = unlock.raPoints;
                    }
                    if ((i2 & 4) != 0) {
                        str2 = unlock.dateAwarded;
                    }
                    if ((i2 & 8) != 0) {
                        z = unlock.hardcoreMode;
                    }
                    if ((i2 & 16) != 0) {
                        i = unlock.raSoftcorePoints;
                    }
                    int i3 = i;
                    String str3 = str2;
                    return unlock.copy(str, j, str3, z, i3);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getUser() {
                    return this.user;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final long getRaPoints() {
                    return this.raPoints;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final String getDateAwarded() {
                    return this.dateAwarded;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final boolean getHardcoreMode() {
                    return this.hardcoreMode;
                }

                /* JADX INFO: renamed from: component5, reason: from getter */
                public final int getRaSoftcorePoints() {
                    return this.raSoftcorePoints;
                }

                public final Unlock copy(String user, long raPoints, String dateAwarded, boolean hardcoreMode, int raSoftcorePoints) {
                    Intrinsics.checkNotNullParameter(user, "user");
                    Intrinsics.checkNotNullParameter(dateAwarded, "dateAwarded");
                    return new Unlock(user, raPoints, dateAwarded, hardcoreMode, raSoftcorePoints);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Unlock)) {
                        return false;
                    }
                    Unlock unlock = (Unlock) other;
                    return Intrinsics.areEqual(this.user, unlock.user) && this.raPoints == unlock.raPoints && Intrinsics.areEqual(this.dateAwarded, unlock.dateAwarded) && this.hardcoreMode == unlock.hardcoreMode && this.raSoftcorePoints == unlock.raSoftcorePoints;
                }

                public int hashCode() {
                    return (((((((this.user.hashCode() * 31) + Long.hashCode(this.raPoints)) * 31) + this.dateAwarded.hashCode()) * 31) + Boolean.hashCode(this.hardcoreMode)) * 31) + Integer.hashCode(this.raSoftcorePoints);
                }

                public String toString() {
                    return "Unlock(user=" + this.user + ", raPoints=" + this.raPoints + ", dateAwarded=" + this.dateAwarded + ", hardcoreMode=" + this.hardcoreMode + ", raSoftcorePoints=" + this.raSoftcorePoints + ')';
                }

                public Unlock(String user, long j, String dateAwarded, boolean z, int i) {
                    Intrinsics.checkNotNullParameter(user, "user");
                    Intrinsics.checkNotNullParameter(dateAwarded, "dateAwarded");
                    this.user = user;
                    this.raPoints = j;
                    this.dateAwarded = dateAwarded;
                    this.hardcoreMode = z;
                    this.raSoftcorePoints = i;
                }

                public final String getUser() {
                    return this.user;
                }

                public final long getRaPoints() {
                    return this.raPoints;
                }

                public final String getDateAwarded() {
                    return this.dateAwarded;
                }

                public final boolean getHardcoreMode() {
                    return this.hardcoreMode;
                }

                public final int getRaSoftcorePoints() {
                    return this.raSoftcorePoints;
                }
            }

            /* JADX INFO: compiled from: GetAchievementUnlocks.kt */
            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Game;", "", "id", "", "title", "", "(JLjava/lang/String;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Game {

                @SerializedName("ID")
                private final long id;

                @SerializedName("Title")
                private final String title;

                public static /* synthetic */ Game copy$default(Game game, long j, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        j = game.id;
                    }
                    if ((i & 2) != 0) {
                        str = game.title;
                    }
                    return game.copy(j, str);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final long getId() {
                    return this.id;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getTitle() {
                    return this.title;
                }

                public final Game copy(long id2, String title) {
                    Intrinsics.checkNotNullParameter(title, "title");
                    return new Game(id2, title);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Game)) {
                        return false;
                    }
                    Game game = (Game) other;
                    return this.id == game.id && Intrinsics.areEqual(this.title, game.title);
                }

                public int hashCode() {
                    return (Long.hashCode(this.id) * 31) + this.title.hashCode();
                }

                public String toString() {
                    return "Game(id=" + this.id + ", title=" + this.title + ')';
                }

                public Game(long j, String title) {
                    Intrinsics.checkNotNullParameter(title, "title");
                    this.id = j;
                    this.title = title;
                }

                public final long getId() {
                    return this.id;
                }

                public final String getTitle() {
                    return this.title;
                }
            }

            /* JADX INFO: compiled from: GetAchievementUnlocks.kt */
            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Console;", "", "id", "", "title", "", "(JLjava/lang/String;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Console {

                @SerializedName("ID")
                private final long id;

                @SerializedName("Title")
                private final String title;

                public static /* synthetic */ Console copy$default(Console console, long j, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        j = console.id;
                    }
                    if ((i & 2) != 0) {
                        str = console.title;
                    }
                    return console.copy(j, str);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final long getId() {
                    return this.id;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getTitle() {
                    return this.title;
                }

                public final Console copy(long id2, String title) {
                    Intrinsics.checkNotNullParameter(title, "title");
                    return new Console(id2, title);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Console)) {
                        return false;
                    }
                    Console console = (Console) other;
                    return this.id == console.id && Intrinsics.areEqual(this.title, console.title);
                }

                public int hashCode() {
                    return (Long.hashCode(this.id) * 31) + this.title.hashCode();
                }

                public String toString() {
                    return "Console(id=" + this.id + ", title=" + this.title + ')';
                }

                public Console(long j, String title) {
                    Intrinsics.checkNotNullParameter(title, "title");
                    this.id = j;
                    this.title = title;
                }

                public final long getId() {
                    return this.id;
                }

                public final String getTitle() {
                    return this.title;
                }
            }

            /* JADX INFO: compiled from: GetAchievementUnlocks.kt */
            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response$Unlocks$Achievement;", "", "id", "", "title", "", "description", "points", "trueRatio", "author", "dateCreated", "dateModified", "type", "(JLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getDateCreated", "getDateModified", "getDescription", "getId", "()J", "getPoints", "getTitle", "getTrueRatio", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Achievement {

                @SerializedName("Author")
                private final String author;

                @SerializedName("DateCreated")
                private final String dateCreated;

                @SerializedName("DateModified")
                private final String dateModified;

                @SerializedName("Description")
                private final String description;

                @SerializedName("ID")
                private final long id;

                @SerializedName("Points")
                private final long points;

                @SerializedName("Title")
                private final String title;

                @SerializedName("TruePoints")
                private final long trueRatio;

                @SerializedName("Type")
                private final String type;

                public static /* synthetic */ Achievement copy$default(Achievement achievement, long j, String str, String str2, long j2, long j3, String str3, String str4, String str5, String str6, int i, Object obj) {
                    if ((i & 1) != 0) {
                        j = achievement.id;
                    }
                    return achievement.copy(j, (i & 2) != 0 ? achievement.title : str, (i & 4) != 0 ? achievement.description : str2, (i & 8) != 0 ? achievement.points : j2, (i & 16) != 0 ? achievement.trueRatio : j3, (i & 32) != 0 ? achievement.author : str3, (i & 64) != 0 ? achievement.dateCreated : str4, (i & 128) != 0 ? achievement.dateModified : str5, (i & 256) != 0 ? achievement.type : str6);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final long getId() {
                    return this.id;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getTitle() {
                    return this.title;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final String getDescription() {
                    return this.description;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final long getPoints() {
                    return this.points;
                }

                /* JADX INFO: renamed from: component5, reason: from getter */
                public final long getTrueRatio() {
                    return this.trueRatio;
                }

                /* JADX INFO: renamed from: component6, reason: from getter */
                public final String getAuthor() {
                    return this.author;
                }

                /* JADX INFO: renamed from: component7, reason: from getter */
                public final String getDateCreated() {
                    return this.dateCreated;
                }

                /* JADX INFO: renamed from: component8, reason: from getter */
                public final String getDateModified() {
                    return this.dateModified;
                }

                /* JADX INFO: renamed from: component9, reason: from getter */
                public final String getType() {
                    return this.type;
                }

                public final Achievement copy(long id2, String title, String description, long points, long trueRatio, String author, String dateCreated, String dateModified, String type) {
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(description, "description");
                    Intrinsics.checkNotNullParameter(author, "author");
                    Intrinsics.checkNotNullParameter(dateCreated, "dateCreated");
                    Intrinsics.checkNotNullParameter(dateModified, "dateModified");
                    Intrinsics.checkNotNullParameter(type, "type");
                    return new Achievement(id2, title, description, points, trueRatio, author, dateCreated, dateModified, type);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Achievement)) {
                        return false;
                    }
                    Achievement achievement = (Achievement) other;
                    return this.id == achievement.id && Intrinsics.areEqual(this.title, achievement.title) && Intrinsics.areEqual(this.description, achievement.description) && this.points == achievement.points && this.trueRatio == achievement.trueRatio && Intrinsics.areEqual(this.author, achievement.author) && Intrinsics.areEqual(this.dateCreated, achievement.dateCreated) && Intrinsics.areEqual(this.dateModified, achievement.dateModified) && Intrinsics.areEqual(this.type, achievement.type);
                }

                public int hashCode() {
                    return (((((((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Long.hashCode(this.points)) * 31) + Long.hashCode(this.trueRatio)) * 31) + this.author.hashCode()) * 31) + this.dateCreated.hashCode()) * 31) + this.dateModified.hashCode()) * 31) + this.type.hashCode();
                }

                public String toString() {
                    return "Achievement(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", points=" + this.points + ", trueRatio=" + this.trueRatio + ", author=" + this.author + ", dateCreated=" + this.dateCreated + ", dateModified=" + this.dateModified + ", type=" + this.type + ')';
                }

                public Achievement(long j, String title, String description, long j2, long j3, String author, String dateCreated, String dateModified, String type) {
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(description, "description");
                    Intrinsics.checkNotNullParameter(author, "author");
                    Intrinsics.checkNotNullParameter(dateCreated, "dateCreated");
                    Intrinsics.checkNotNullParameter(dateModified, "dateModified");
                    Intrinsics.checkNotNullParameter(type, "type");
                    this.id = j;
                    this.title = title;
                    this.description = description;
                    this.points = j2;
                    this.trueRatio = j3;
                    this.author = author;
                    this.dateCreated = dateCreated;
                    this.dateModified = dateModified;
                    this.type = type;
                }

                public final long getId() {
                    return this.id;
                }

                public final String getTitle() {
                    return this.title;
                }

                public final String getDescription() {
                    return this.description;
                }

                public final long getPoints() {
                    return this.points;
                }

                public final long getTrueRatio() {
                    return this.trueRatio;
                }

                public final String getAuthor() {
                    return this.author;
                }

                public final String getDateCreated() {
                    return this.dateCreated;
                }

                public final String getDateModified() {
                    return this.dateModified;
                }

                public final String getType() {
                    return this.type;
                }
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Unlocks) {
                return contains((Unlocks) obj);
            }
            return false;
        }

        public /* bridge */ boolean contains(Unlocks unlocks) {
            return super.contains((Object) unlocks);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Unlocks) {
                return indexOf((Unlocks) obj);
            }
            return -1;
        }

        public /* bridge */ int indexOf(Unlocks unlocks) {
            return super.indexOf((Object) unlocks);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Unlocks) {
                return lastIndexOf((Unlocks) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(Unlocks unlocks) {
            return super.lastIndexOf((Object) unlocks);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ Unlocks remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof Unlocks) {
                return remove((Unlocks) obj);
            }
            return false;
        }

        public /* bridge */ boolean remove(Unlocks unlocks) {
            return super.remove((Object) unlocks);
        }

        public /* bridge */ Unlocks removeAt(int i) {
            return (Unlocks) super.remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }
    }
}
