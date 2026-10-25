package org.retroachivements.api.data.pojo.event;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* JADX INFO: compiled from: GetAchievementOfTheWeek.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetAchievementOfTheWeek {

    /* JADX INFO: compiled from: GetAchievementOfTheWeek.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u000556789B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\u0019\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003Js\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0007HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0016\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 ¨\u0006:"}, d2 = {"Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response;", "", "achievement", "Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Achievement;", "startAt", "", "totalPlayers", "", "console", "Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Console;", "forumTopic", "Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$ForumTopic;", "game", "Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Game;", "unlocks", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Unlock;", "Lkotlin/collections/ArrayList;", "unlocksCount", "unlocksHardcoreCount", "(Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Achievement;Ljava/lang/String;JLorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Console;Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$ForumTopic;Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Game;Ljava/util/ArrayList;JJ)V", "getAchievement", "()Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Achievement;", "getConsole", "()Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Console;", "getForumTopic", "()Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$ForumTopic;", "getGame", "()Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Game;", "getStartAt", "()Ljava/lang/String;", "getTotalPlayers", "()J", "getUnlocks", "()Ljava/util/ArrayList;", "getUnlocksCount", "getUnlocksHardcoreCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "Achievement", "Console", "ForumTopic", "Game", "Unlock", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Achievement")
        private final Achievement achievement;

        @SerializedName("Console")
        private final Console console;

        @SerializedName("ForumTopic")
        private final ForumTopic forumTopic;

        @SerializedName("Game")
        private final Game game;

        @SerializedName("StartAt")
        private final String startAt;

        @SerializedName("TotalPlayers")
        private final long totalPlayers;

        @SerializedName("Unlocks")
        private final ArrayList<Unlock> unlocks;

        @SerializedName("UnlocksCount")
        private final long unlocksCount;

        @SerializedName("UnlocksHardcoreCount")
        private final long unlocksHardcoreCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, Achievement achievement, String str, long j, Console console, ForumTopic forumTopic, Game game, ArrayList arrayList, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                achievement = response.achievement;
            }
            if ((i & 2) != 0) {
                str = response.startAt;
            }
            if ((i & 4) != 0) {
                j = response.totalPlayers;
            }
            if ((i & 8) != 0) {
                console = response.console;
            }
            if ((i & 16) != 0) {
                forumTopic = response.forumTopic;
            }
            if ((i & 32) != 0) {
                game = response.game;
            }
            if ((i & 64) != 0) {
                arrayList = response.unlocks;
            }
            if ((i & 128) != 0) {
                j2 = response.unlocksCount;
            }
            if ((i & 256) != 0) {
                j3 = response.unlocksHardcoreCount;
            }
            long j4 = j3;
            long j5 = j2;
            long j6 = j;
            return response.copy(achievement, str, j6, console, forumTopic, game, arrayList, j5, j4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Achievement getAchievement() {
            return this.achievement;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getStartAt() {
            return this.startAt;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getTotalPlayers() {
            return this.totalPlayers;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Console getConsole() {
            return this.console;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ForumTopic getForumTopic() {
            return this.forumTopic;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Game getGame() {
            return this.game;
        }

        public final ArrayList<Unlock> component7() {
            return this.unlocks;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final long getUnlocksCount() {
            return this.unlocksCount;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final long getUnlocksHardcoreCount() {
            return this.unlocksHardcoreCount;
        }

        public final Response copy(Achievement achievement, String startAt, long totalPlayers, Console console, ForumTopic forumTopic, Game game, ArrayList<Unlock> unlocks, long unlocksCount, long unlocksHardcoreCount) {
            Intrinsics.checkNotNullParameter(achievement, "achievement");
            Intrinsics.checkNotNullParameter(startAt, "startAt");
            Intrinsics.checkNotNullParameter(console, "console");
            Intrinsics.checkNotNullParameter(forumTopic, "forumTopic");
            Intrinsics.checkNotNullParameter(game, "game");
            Intrinsics.checkNotNullParameter(unlocks, "unlocks");
            return new Response(achievement, startAt, totalPlayers, console, forumTopic, game, unlocks, unlocksCount, unlocksHardcoreCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return Intrinsics.areEqual(this.achievement, response.achievement) && Intrinsics.areEqual(this.startAt, response.startAt) && this.totalPlayers == response.totalPlayers && Intrinsics.areEqual(this.console, response.console) && Intrinsics.areEqual(this.forumTopic, response.forumTopic) && Intrinsics.areEqual(this.game, response.game) && Intrinsics.areEqual(this.unlocks, response.unlocks) && this.unlocksCount == response.unlocksCount && this.unlocksHardcoreCount == response.unlocksHardcoreCount;
        }

        public int hashCode() {
            return (((((((((((((((this.achievement.hashCode() * 31) + this.startAt.hashCode()) * 31) + Long.hashCode(this.totalPlayers)) * 31) + this.console.hashCode()) * 31) + this.forumTopic.hashCode()) * 31) + this.game.hashCode()) * 31) + this.unlocks.hashCode()) * 31) + Long.hashCode(this.unlocksCount)) * 31) + Long.hashCode(this.unlocksHardcoreCount);
        }

        public String toString() {
            return "Response(achievement=" + this.achievement + ", startAt=" + this.startAt + ", totalPlayers=" + this.totalPlayers + ", console=" + this.console + ", forumTopic=" + this.forumTopic + ", game=" + this.game + ", unlocks=" + this.unlocks + ", unlocksCount=" + this.unlocksCount + ", unlocksHardcoreCount=" + this.unlocksHardcoreCount + ')';
        }

        public Response(Achievement achievement, String startAt, long j, Console console, ForumTopic forumTopic, Game game, ArrayList<Unlock> unlocks, long j2, long j3) {
            Intrinsics.checkNotNullParameter(achievement, "achievement");
            Intrinsics.checkNotNullParameter(startAt, "startAt");
            Intrinsics.checkNotNullParameter(console, "console");
            Intrinsics.checkNotNullParameter(forumTopic, "forumTopic");
            Intrinsics.checkNotNullParameter(game, "game");
            Intrinsics.checkNotNullParameter(unlocks, "unlocks");
            this.achievement = achievement;
            this.startAt = startAt;
            this.totalPlayers = j;
            this.console = console;
            this.forumTopic = forumTopic;
            this.game = game;
            this.unlocks = unlocks;
            this.unlocksCount = j2;
            this.unlocksHardcoreCount = j3;
        }

        public final Achievement getAchievement() {
            return this.achievement;
        }

        public final String getStartAt() {
            return this.startAt;
        }

        public final long getTotalPlayers() {
            return this.totalPlayers;
        }

        public final Console getConsole() {
            return this.console;
        }

        public final ForumTopic getForumTopic() {
            return this.forumTopic;
        }

        public final Game getGame() {
            return this.game;
        }

        public final ArrayList<Unlock> getUnlocks() {
            return this.unlocks;
        }

        public final long getUnlocksCount() {
            return this.unlocksCount;
        }

        public final long getUnlocksHardcoreCount() {
            return this.unlocksHardcoreCount;
        }

        /* JADX INFO: compiled from: GetAchievementOfTheWeek.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003Je\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Achievement;", "", "id", "", "title", "", "description", "points", "trueRatio", "type", "author", "dateCreated", "dateModified", "(JLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getDateCreated", "getDateModified", "getDescription", "getId", "()J", "getPoints", "getTitle", "getTrueRatio", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

            @SerializedName("TrueRatio")
            private final long trueRatio;

            @SerializedName("Type")
            private final String type;

            public static /* synthetic */ Achievement copy$default(Achievement achievement, long j, String str, String str2, long j2, long j3, String str3, String str4, String str5, String str6, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = achievement.id;
                }
                return achievement.copy(j, (i & 2) != 0 ? achievement.title : str, (i & 4) != 0 ? achievement.description : str2, (i & 8) != 0 ? achievement.points : j2, (i & 16) != 0 ? achievement.trueRatio : j3, (i & 32) != 0 ? achievement.type : str3, (i & 64) != 0 ? achievement.author : str4, (i & 128) != 0 ? achievement.dateCreated : str5, (i & 256) != 0 ? achievement.dateModified : str6);
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
            public final String getType() {
                return this.type;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getAuthor() {
                return this.author;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final String getDateCreated() {
                return this.dateCreated;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getDateModified() {
                return this.dateModified;
            }

            public final Achievement copy(long id2, String title, String description, long points, long trueRatio, String type, String author, String dateCreated, String dateModified) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(author, "author");
                Intrinsics.checkNotNullParameter(dateCreated, "dateCreated");
                Intrinsics.checkNotNullParameter(dateModified, "dateModified");
                return new Achievement(id2, title, description, points, trueRatio, type, author, dateCreated, dateModified);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Achievement)) {
                    return false;
                }
                Achievement achievement = (Achievement) other;
                return this.id == achievement.id && Intrinsics.areEqual(this.title, achievement.title) && Intrinsics.areEqual(this.description, achievement.description) && this.points == achievement.points && this.trueRatio == achievement.trueRatio && Intrinsics.areEqual(this.type, achievement.type) && Intrinsics.areEqual(this.author, achievement.author) && Intrinsics.areEqual(this.dateCreated, achievement.dateCreated) && Intrinsics.areEqual(this.dateModified, achievement.dateModified);
            }

            public int hashCode() {
                int iHashCode = ((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Long.hashCode(this.points)) * 31) + Long.hashCode(this.trueRatio)) * 31;
                String str = this.type;
                return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.author.hashCode()) * 31) + this.dateCreated.hashCode()) * 31) + this.dateModified.hashCode();
            }

            public String toString() {
                return "Achievement(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", points=" + this.points + ", trueRatio=" + this.trueRatio + ", type=" + this.type + ", author=" + this.author + ", dateCreated=" + this.dateCreated + ", dateModified=" + this.dateModified + ')';
            }

            public Achievement(long j, String title, String description, long j2, long j3, String str, String author, String dateCreated, String dateModified) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(author, "author");
                Intrinsics.checkNotNullParameter(dateCreated, "dateCreated");
                Intrinsics.checkNotNullParameter(dateModified, "dateModified");
                this.id = j;
                this.title = title;
                this.description = description;
                this.points = j2;
                this.trueRatio = j3;
                this.type = str;
                this.author = author;
                this.dateCreated = dateCreated;
                this.dateModified = dateModified;
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

            public final String getType() {
                return this.type;
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
        }

        /* JADX INFO: compiled from: GetAchievementOfTheWeek.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Console;", "", "id", "", "title", "", "(JLjava/lang/String;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        /* JADX INFO: compiled from: GetAchievementOfTheWeek.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$ForumTopic;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ForumTopic {

            @SerializedName("ID")
            private final String id;

            public static /* synthetic */ ForumTopic copy$default(ForumTopic forumTopic, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = forumTopic.id;
                }
                return forumTopic.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            public final ForumTopic copy(String id2) {
                Intrinsics.checkNotNullParameter(id2, "id");
                return new ForumTopic(id2);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ForumTopic) && Intrinsics.areEqual(this.id, ((ForumTopic) other).id);
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public String toString() {
                return "ForumTopic(id=" + this.id + ')';
            }

            public ForumTopic(String id2) {
                Intrinsics.checkNotNullParameter(id2, "id");
                this.id = id2;
            }

            public final String getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: GetAchievementOfTheWeek.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Game;", "", "id", "", "title", "", "(JLjava/lang/String;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Game {

            @SerializedName("ID")
            private final long id;

            @SerializedName("title")
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

        /* JADX INFO: compiled from: GetAchievementOfTheWeek.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u001f"}, d2 = {"Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response$Unlock;", "", ConfigConstants.CONFIG_USER_SECTION, "", "raPoints", "", "dateAwarded", "hardcoreMode", "", "raSoftcorePoints", "", "(Ljava/lang/String;JLjava/lang/String;ZI)V", "getDateAwarded", "()Ljava/lang/String;", "getHardcoreMode", "()Z", "getRaPoints", "()J", "getRaSoftcorePoints", "()I", "getUser", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    }
}
