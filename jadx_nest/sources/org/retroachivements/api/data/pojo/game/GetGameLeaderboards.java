package org.retroachivements.api.data.pojo.game;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* INFO: compiled from: GetGameLeaderboards.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameLeaderboards;", "", "()V", "Leaderboard", "Response", "TopEntry", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetGameLeaderboards {

    /* INFO: compiled from: GetGameLeaderboards.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameLeaderboards$Response;", "", "count", "", "total", "results", "", "Lorg/retroachivements/api/data/pojo/game/GetGameLeaderboards$Leaderboard;", "(JJLjava/util/List;)V", "getCount", "()J", "getResults", "()Ljava/util/List;", "getTotal", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Count")
        private final long count;

        @SerializedName("Results")
        private final List<Leaderboard> results;

        @SerializedName("Total")
        private final long total;

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, long j, long j2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = response.count;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = response.total;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                list = response.results;
            }
            return response.copy(j3, j4, list);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final long getTotal() {
            return this.total;
        }

        public final List<Leaderboard> component3() {
            return this.results;
        }

        public final Response copy(long count, long total, List<Leaderboard> results) {
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
            return (((Long.hashCode(this.count) * 31) + Long.hashCode(this.total)) * 31) + this.results.hashCode();
        }

        public String toString() {
            return "Response(count=" + this.count + ", total=" + this.total + ", results=" + this.results + ')';
        }

        public Response(long j, long j2, List<Leaderboard> results) {
            Intrinsics.checkNotNullParameter(results, "results");
            this.count = j;
            this.total = j2;
            this.results = results;
        }

        public final long getCount() {
            return this.count;
        }

        public final long getTotal() {
            return this.total;
        }

        public final List<Leaderboard> getResults() {
            return this.results;
        }
    }

    /* INFO: compiled from: GetGameLeaderboards.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameLeaderboards$Leaderboard;", "", "id", "", "rankAsc", "", "title", "", "description", ConfigConstants.CONFIG_KEY_FORMAT, "topEntry", "Lorg/retroachivements/api/data/pojo/game/GetGameLeaderboards$TopEntry;", "author", "authorUlid", "(JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/retroachivements/api/data/pojo/game/GetGameLeaderboards$TopEntry;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getAuthorUlid", "getDescription", "getFormat", "getId", "()J", "getRankAsc", "()Z", "getTitle", "getTopEntry", "()Lorg/retroachivements/api/data/pojo/game/GetGameLeaderboards$TopEntry;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Leaderboard {

        @SerializedName("Author")
        private final String author;

        @SerializedName("AuthorULID")
        private final String authorUlid;

        @SerializedName("Description")
        private final String description;

        @SerializedName("Format")
        private final String format;

        @SerializedName("ID")
        private final long id;

        @SerializedName("RankAsc")
        @JsonAdapter(BooleanJsonDeserializer.class)
        private final boolean rankAsc;

        @SerializedName("Title")
        private final String title;

        @SerializedName("TopEntry")
        private final TopEntry topEntry;

        public static /* synthetic */ Leaderboard copy$default(Leaderboard leaderboard, long j, boolean z, String str, String str2, String str3, TopEntry topEntry, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                j = leaderboard.id;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                z = leaderboard.rankAsc;
            }
            boolean z2 = z;
            if ((i & 4) != 0) {
                str = leaderboard.title;
            }
            String str6 = str;
            if ((i & 8) != 0) {
                str2 = leaderboard.description;
            }
            return leaderboard.copy(j2, z2, str6, str2, (i & 16) != 0 ? leaderboard.format : str3, (i & 32) != 0 ? leaderboard.topEntry : topEntry, (i & 64) != 0 ? leaderboard.author : str4, (i & 128) != 0 ? leaderboard.authorUlid : str5);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final boolean getRankAsc() {
            return this.rankAsc;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        /* INFO: renamed from: component6, reason: from getter */
        public final TopEntry getTopEntry() {
            return this.topEntry;
        }

        /* INFO: renamed from: component7, reason: from getter */
        public final String getAuthor() {
            return this.author;
        }

        /* INFO: renamed from: component8, reason: from getter */
        public final String getAuthorUlid() {
            return this.authorUlid;
        }

        public final Leaderboard copy(long id2, boolean rankAsc, String title, String description, String format, TopEntry topEntry, String author, String authorUlid) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(topEntry, "topEntry");
            Intrinsics.checkNotNullParameter(author, "author");
            Intrinsics.checkNotNullParameter(authorUlid, "authorUlid");
            return new Leaderboard(id2, rankAsc, title, description, format, topEntry, author, authorUlid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Leaderboard)) {
                return false;
            }
            Leaderboard leaderboard = (Leaderboard) other;
            return this.id == leaderboard.id && this.rankAsc == leaderboard.rankAsc && Intrinsics.areEqual(this.title, leaderboard.title) && Intrinsics.areEqual(this.description, leaderboard.description) && Intrinsics.areEqual(this.format, leaderboard.format) && Intrinsics.areEqual(this.topEntry, leaderboard.topEntry) && Intrinsics.areEqual(this.author, leaderboard.author) && Intrinsics.areEqual(this.authorUlid, leaderboard.authorUlid);
        }

        public int hashCode() {
            return (((((((((((((Long.hashCode(this.id) * 31) + Boolean.hashCode(this.rankAsc)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.format.hashCode()) * 31) + this.topEntry.hashCode()) * 31) + this.author.hashCode()) * 31) + this.authorUlid.hashCode();
        }

        public String toString() {
            return "Leaderboard(id=" + this.id + ", rankAsc=" + this.rankAsc + ", title=" + this.title + ", description=" + this.description + ", format=" + this.format + ", topEntry=" + this.topEntry + ", author=" + this.author + ", authorUlid=" + this.authorUlid + ')';
        }

        public Leaderboard(long j, boolean z, String title, String description, String format, TopEntry topEntry, String author, String authorUlid) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(topEntry, "topEntry");
            Intrinsics.checkNotNullParameter(author, "author");
            Intrinsics.checkNotNullParameter(authorUlid, "authorUlid");
            this.id = j;
            this.rankAsc = z;
            this.title = title;
            this.description = description;
            this.format = format;
            this.topEntry = topEntry;
            this.author = author;
            this.authorUlid = authorUlid;
        }

        public final long getId() {
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

        public final TopEntry getTopEntry() {
            return this.topEntry;
        }

        public final String getAuthor() {
            return this.author;
        }

        public final String getAuthorUlid() {
            return this.authorUlid;
        }
    }

    /* INFO: compiled from: GetGameLeaderboards.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameLeaderboards$TopEntry;", "", ConfigConstants.CONFIG_USER_SECTION, "", "ulid", "score", "", "formattedScore", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getFormattedScore", "()Ljava/lang/String;", "getScore", "()J", "getUlid", "getUser", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class TopEntry {

        @SerializedName("FormattedScore")
        private final String formattedScore;

        @SerializedName("Score")
        private final long score;

        @SerializedName("ULID")
        private final String ulid;

        @SerializedName(SshConstants.USER)
        private final String user;

        public static /* synthetic */ TopEntry copy$default(TopEntry topEntry, String str, String str2, long j, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = topEntry.user;
            }
            if ((i & 2) != 0) {
                str2 = topEntry.ulid;
            }
            if ((i & 4) != 0) {
                j = topEntry.score;
            }
            if ((i & 8) != 0) {
                str3 = topEntry.formattedScore;
            }
            String str4 = str3;
            return topEntry.copy(str, str2, j, str4);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final String getUser() {
            return this.user;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getUlid() {
            return this.ulid;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final long getScore() {
            return this.score;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final String getFormattedScore() {
            return this.formattedScore;
        }

        public final TopEntry copy(String user, String ulid, long score, String formattedScore) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(ulid, "ulid");
            Intrinsics.checkNotNullParameter(formattedScore, "formattedScore");
            return new TopEntry(user, ulid, score, formattedScore);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TopEntry)) {
                return false;
            }
            TopEntry topEntry = (TopEntry) other;
            return Intrinsics.areEqual(this.user, topEntry.user) && Intrinsics.areEqual(this.ulid, topEntry.ulid) && this.score == topEntry.score && Intrinsics.areEqual(this.formattedScore, topEntry.formattedScore);
        }

        public int hashCode() {
            return (((((this.user.hashCode() * 31) + this.ulid.hashCode()) * 31) + Long.hashCode(this.score)) * 31) + this.formattedScore.hashCode();
        }

        public String toString() {
            return "TopEntry(user=" + this.user + ", ulid=" + this.ulid + ", score=" + this.score + ", formattedScore=" + this.formattedScore + ')';
        }

        public TopEntry(String user, String ulid, long j, String formattedScore) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(ulid, "ulid");
            Intrinsics.checkNotNullParameter(formattedScore, "formattedScore");
            this.user = user;
            this.ulid = ulid;
            this.score = j;
            this.formattedScore = formattedScore;
        }

        public final String getUser() {
            return this.user;
        }

        public final String getUlid() {
            return this.ulid;
        }

        public final long getScore() {
            return this.score;
        }

        public final String getFormattedScore() {
            return this.formattedScore;
        }
    }
}
