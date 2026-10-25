package org.retroachivements.api.data.pojo.game;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;

/* JADX INFO: compiled from: GetLeaderboardEntries.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetLeaderboardEntries;", "", "()V", "Entry", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetLeaderboardEntries {

    /* JADX INFO: compiled from: GetLeaderboardEntries.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetLeaderboardEntries$Response;", "", "count", "", "total", "results", "", "Lorg/retroachivements/api/data/pojo/game/GetLeaderboardEntries$Entry;", "(JJLjava/util/List;)V", "getCount", "()J", "getResults", "()Ljava/util/List;", "getTotal", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Count")
        private final long count;

        @SerializedName("Results")
        private final List<Entry> results;

        @SerializedName("Total")
        private final long total;

        /* JADX WARN: Multi-variable type inference failed */
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

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTotal() {
            return this.total;
        }

        public final List<Entry> component3() {
            return this.results;
        }

        public final Response copy(long count, long total, List<Entry> results) {
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

        public Response(long j, long j2, List<Entry> results) {
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

        public final List<Entry> getResults() {
            return this.results;
        }
    }

    /* JADX INFO: compiled from: GetLeaderboardEntries.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetLeaderboardEntries$Entry;", "", ConfigConstants.CONFIG_USER_SECTION, "", "dateSubmitted", "score", "", "formattedScore", "rank", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;J)V", "getDateSubmitted", "()Ljava/lang/String;", "getFormattedScore", "getRank", "()J", "getScore", "getUser", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Entry {

        @SerializedName("DateSubmitted")
        private final String dateSubmitted;

        @SerializedName("FormattedScore")
        private final String formattedScore;

        @SerializedName("Rank")
        private final long rank;

        @SerializedName("Score")
        private final long score;

        @SerializedName(SshConstants.USER)
        private final String user;

        public static /* synthetic */ Entry copy$default(Entry entry, String str, String str2, long j, String str3, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = entry.user;
            }
            if ((i & 2) != 0) {
                str2 = entry.dateSubmitted;
            }
            if ((i & 4) != 0) {
                j = entry.score;
            }
            if ((i & 8) != 0) {
                str3 = entry.formattedScore;
            }
            if ((i & 16) != 0) {
                j2 = entry.rank;
            }
            String str4 = str3;
            long j3 = j;
            return entry.copy(str, str2, j3, str4, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDateSubmitted() {
            return this.dateSubmitted;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getScore() {
            return this.score;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getFormattedScore() {
            return this.formattedScore;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getRank() {
            return this.rank;
        }

        public final Entry copy(String user, String dateSubmitted, long score, String formattedScore, long rank) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(dateSubmitted, "dateSubmitted");
            Intrinsics.checkNotNullParameter(formattedScore, "formattedScore");
            return new Entry(user, dateSubmitted, score, formattedScore, rank);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return Intrinsics.areEqual(this.user, entry.user) && Intrinsics.areEqual(this.dateSubmitted, entry.dateSubmitted) && this.score == entry.score && Intrinsics.areEqual(this.formattedScore, entry.formattedScore) && this.rank == entry.rank;
        }

        public int hashCode() {
            return (((((((this.user.hashCode() * 31) + this.dateSubmitted.hashCode()) * 31) + Long.hashCode(this.score)) * 31) + this.formattedScore.hashCode()) * 31) + Long.hashCode(this.rank);
        }

        public String toString() {
            return "Entry(user=" + this.user + ", dateSubmitted=" + this.dateSubmitted + ", score=" + this.score + ", formattedScore=" + this.formattedScore + ", rank=" + this.rank + ')';
        }

        public Entry(String user, String dateSubmitted, long j, String formattedScore, long j2) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(dateSubmitted, "dateSubmitted");
            Intrinsics.checkNotNullParameter(formattedScore, "formattedScore");
            this.user = user;
            this.dateSubmitted = dateSubmitted;
            this.score = j;
            this.formattedScore = formattedScore;
            this.rank = j2;
        }

        public final String getUser() {
            return this.user;
        }

        public final String getDateSubmitted() {
            return this.dateSubmitted;
        }

        public final long getScore() {
            return this.score;
        }

        public final String getFormattedScore() {
            return this.formattedScore;
        }

        public final long getRank() {
            return this.rank;
        }
    }
}
