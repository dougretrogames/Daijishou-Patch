package org.retroachivements.api.data.pojo.game;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* JADX INFO: compiled from: GetUserGameLeaderboard.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetUserGameLeaderboard;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserGameLeaderboard {

    /* JADX INFO: compiled from: GetUserGameLeaderboard.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetUserGameLeaderboard$Response;", "", "count", "", "total", "results", "", "Lorg/retroachivements/api/data/pojo/game/GetUserGameLeaderboard$Response$Result;", "(IILjava/util/List;)V", "getCount", "()I", "getResults", "()Ljava/util/List;", "getTotal", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "", "Result", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Count")
        private final int count;

        @SerializedName("Results")
        private final List<Result> results;

        @SerializedName("Total")
        private final int total;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, int i, int i2, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = response.count;
            }
            if ((i3 & 2) != 0) {
                i2 = response.total;
            }
            if ((i3 & 4) != 0) {
                list = response.results;
            }
            return response.copy(i, i2, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        public final List<Result> component3() {
            return this.results;
        }

        public final Response copy(int count, int total, List<Result> results) {
            Intrinsics.checkNotNullParameter(results, "results");
            return new Response(count, total, results);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.count == response.count && this.total == response.total && Intrinsics.areEqual(this.results, response.results);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.count) * 31) + Integer.hashCode(this.total)) * 31) + this.results.hashCode();
        }

        public String toString() {
            return "Response(count=" + this.count + ", total=" + this.total + ", results=" + this.results + ')';
        }

        public Response(int i, int i2, List<Result> results) {
            Intrinsics.checkNotNullParameter(results, "results");
            this.count = i;
            this.total = i2;
            this.results = results;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getTotal() {
            return this.total;
        }

        public final List<Result> getResults() {
            return this.results;
        }

        /* JADX INFO: compiled from: GetUserGameLeaderboard.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\"B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetUserGameLeaderboard$Response$Result;", "", "id", "", "rankAsc", "", "title", "", "description", ConfigConstants.CONFIG_KEY_FORMAT, "userEntry", "Lorg/retroachivements/api/data/pojo/game/GetUserGameLeaderboard$Response$Result$UserEntry;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/retroachivements/api/data/pojo/game/GetUserGameLeaderboard$Response$Result$UserEntry;)V", "getDescription", "()Ljava/lang/String;", "getFormat", "getId", "()I", "getRankAsc", "()Z", "getTitle", "getUserEntry", "()Lorg/retroachivements/api/data/pojo/game/GetUserGameLeaderboard$Response$Result$UserEntry;", "component1", "component2", "component3", "component4", "component5", "component6", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "UserEntry", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Result {

            @SerializedName("Description")
            private final String description;

            @SerializedName("Format")
            private final String format;

            @SerializedName("ID")
            private final int id;

            @SerializedName("RankAsc")
            @JsonAdapter(BooleanJsonDeserializer.class)
            private final boolean rankAsc;

            @SerializedName("Title")
            private final String title;

            @SerializedName("UserEntry")
            private final UserEntry userEntry;

            public static /* synthetic */ Result copy$default(Result result, int i, boolean z, String str, String str2, String str3, UserEntry userEntry, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = result.id;
                }
                if ((i2 & 2) != 0) {
                    z = result.rankAsc;
                }
                if ((i2 & 4) != 0) {
                    str = result.title;
                }
                if ((i2 & 8) != 0) {
                    str2 = result.description;
                }
                if ((i2 & 16) != 0) {
                    str3 = result.format;
                }
                if ((i2 & 32) != 0) {
                    userEntry = result.userEntry;
                }
                String str4 = str3;
                UserEntry userEntry2 = userEntry;
                return result.copy(i, z, str, str2, str4, userEntry2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getRankAsc() {
                return this.rankAsc;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getFormat() {
                return this.format;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final UserEntry getUserEntry() {
                return this.userEntry;
            }

            public final Result copy(int id2, boolean rankAsc, String title, String description, String format, UserEntry userEntry) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(format, "format");
                Intrinsics.checkNotNullParameter(userEntry, "userEntry");
                return new Result(id2, rankAsc, title, description, format, userEntry);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Result)) {
                    return false;
                }
                Result result = (Result) other;
                return this.id == result.id && this.rankAsc == result.rankAsc && Intrinsics.areEqual(this.title, result.title) && Intrinsics.areEqual(this.description, result.description) && Intrinsics.areEqual(this.format, result.format) && Intrinsics.areEqual(this.userEntry, result.userEntry);
            }

            public int hashCode() {
                return (((((((((Integer.hashCode(this.id) * 31) + Boolean.hashCode(this.rankAsc)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.format.hashCode()) * 31) + this.userEntry.hashCode();
            }

            public String toString() {
                return "Result(id=" + this.id + ", rankAsc=" + this.rankAsc + ", title=" + this.title + ", description=" + this.description + ", format=" + this.format + ", userEntry=" + this.userEntry + ')';
            }

            public Result(int i, boolean z, String title, String description, String format, UserEntry userEntry) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(format, "format");
                Intrinsics.checkNotNullParameter(userEntry, "userEntry");
                this.id = i;
                this.rankAsc = z;
                this.title = title;
                this.description = description;
                this.format = format;
                this.userEntry = userEntry;
            }

            public final int getId() {
                return this.id;
            }

            public final boolean getRankAsc() {
                return this.rankAsc;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getFormat() {
                return this.format;
            }

            public final UserEntry getUserEntry() {
                return this.userEntry;
            }

            /* JADX INFO: compiled from: GetUserGameLeaderboard.kt */
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetUserGameLeaderboard$Response$Result$UserEntry;", "", ConfigConstants.CONFIG_USER_SECTION, "", "ulid", "score", "", "formattedScore", "rank", "dateUpdated", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getDateUpdated", "()Ljava/lang/String;", "getFormattedScore", "getRank", "()I", "getScore", "getUlid", "getUser", "component1", "component2", "component3", "component4", "component5", "component6", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class UserEntry {

                @SerializedName("DateUpdated")
                private final String dateUpdated;

                @SerializedName("FormattedScore")
                private final String formattedScore;

                @SerializedName("Rank")
                private final int rank;

                @SerializedName("Score")
                private final int score;

                @SerializedName("ULID")
                private final String ulid;

                @SerializedName(SshConstants.USER)
                private final String user;

                public static /* synthetic */ UserEntry copy$default(UserEntry userEntry, String str, String str2, int i, String str3, int i2, String str4, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        str = userEntry.user;
                    }
                    if ((i3 & 2) != 0) {
                        str2 = userEntry.ulid;
                    }
                    if ((i3 & 4) != 0) {
                        i = userEntry.score;
                    }
                    if ((i3 & 8) != 0) {
                        str3 = userEntry.formattedScore;
                    }
                    if ((i3 & 16) != 0) {
                        i2 = userEntry.rank;
                    }
                    if ((i3 & 32) != 0) {
                        str4 = userEntry.dateUpdated;
                    }
                    int i4 = i2;
                    String str5 = str4;
                    return userEntry.copy(str, str2, i, str3, i4, str5);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getUser() {
                    return this.user;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getUlid() {
                    return this.ulid;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final int getScore() {
                    return this.score;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final String getFormattedScore() {
                    return this.formattedScore;
                }

                /* JADX INFO: renamed from: component5, reason: from getter */
                public final int getRank() {
                    return this.rank;
                }

                /* JADX INFO: renamed from: component6, reason: from getter */
                public final String getDateUpdated() {
                    return this.dateUpdated;
                }

                public final UserEntry copy(String user, String ulid, int score, String formattedScore, int rank, String dateUpdated) {
                    Intrinsics.checkNotNullParameter(user, "user");
                    Intrinsics.checkNotNullParameter(ulid, "ulid");
                    Intrinsics.checkNotNullParameter(formattedScore, "formattedScore");
                    Intrinsics.checkNotNullParameter(dateUpdated, "dateUpdated");
                    return new UserEntry(user, ulid, score, formattedScore, rank, dateUpdated);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof UserEntry)) {
                        return false;
                    }
                    UserEntry userEntry = (UserEntry) other;
                    return Intrinsics.areEqual(this.user, userEntry.user) && Intrinsics.areEqual(this.ulid, userEntry.ulid) && this.score == userEntry.score && Intrinsics.areEqual(this.formattedScore, userEntry.formattedScore) && this.rank == userEntry.rank && Intrinsics.areEqual(this.dateUpdated, userEntry.dateUpdated);
                }

                public int hashCode() {
                    return (((((((((this.user.hashCode() * 31) + this.ulid.hashCode()) * 31) + Integer.hashCode(this.score)) * 31) + this.formattedScore.hashCode()) * 31) + Integer.hashCode(this.rank)) * 31) + this.dateUpdated.hashCode();
                }

                public String toString() {
                    return "UserEntry(user=" + this.user + ", ulid=" + this.ulid + ", score=" + this.score + ", formattedScore=" + this.formattedScore + ", rank=" + this.rank + ", dateUpdated=" + this.dateUpdated + ')';
                }

                public UserEntry(String user, String ulid, int i, String formattedScore, int i2, String dateUpdated) {
                    Intrinsics.checkNotNullParameter(user, "user");
                    Intrinsics.checkNotNullParameter(ulid, "ulid");
                    Intrinsics.checkNotNullParameter(formattedScore, "formattedScore");
                    Intrinsics.checkNotNullParameter(dateUpdated, "dateUpdated");
                    this.user = user;
                    this.ulid = ulid;
                    this.score = i;
                    this.formattedScore = formattedScore;
                    this.rank = i2;
                    this.dateUpdated = dateUpdated;
                }

                public final String getUser() {
                    return this.user;
                }

                public final String getUlid() {
                    return this.ulid;
                }

                public final int getScore() {
                    return this.score;
                }

                public final String getFormattedScore() {
                    return this.formattedScore;
                }

                public final int getRank() {
                    return this.rank;
                }

                public final String getDateUpdated() {
                    return this.dateUpdated;
                }
            }
        }
    }
}
