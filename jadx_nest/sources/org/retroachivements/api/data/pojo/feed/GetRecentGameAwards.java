package org.retroachivements.api.data.pojo.feed;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;

/* INFO: compiled from: GetRecentGameAwards.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lorg/retroachivements/api/data/pojo/feed/GetRecentGameAwards;", "", "()V", "Response", "Result", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetRecentGameAwards {

    /* INFO: compiled from: GetRecentGameAwards.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lorg/retroachivements/api/data/pojo/feed/GetRecentGameAwards$Response;", "", "count", "", "total", "results", "", "Lorg/retroachivements/api/data/pojo/feed/GetRecentGameAwards$Result;", "(JJLjava/util/List;)V", "getCount", "()J", "getResults", "()Ljava/util/List;", "getTotal", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Count")
        private final long count;

        @SerializedName("Results")
        private final List<Result> results;

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

        public final List<Result> component3() {
            return this.results;
        }

        public final Response copy(long count, long total, List<Result> results) {
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

        public Response(long j, long j2, List<Result> results) {
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

        public final List<Result> getResults() {
            return this.results;
        }
    }

    /* INFO: compiled from: GetRecentGameAwards.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lorg/retroachivements/api/data/pojo/feed/GetRecentGameAwards$Result;", "", ConfigConstants.CONFIG_USER_SECTION, "", "awardKind", "awardDate", "gameId", "", "gameTitle", "consoleId", "consoleName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;)V", "getAwardDate", "()Ljava/lang/String;", "getAwardKind", "getConsoleId", "()J", "getConsoleName", "getGameId", "getGameTitle", "getUser", "component1", "component2", "component3", "component4", "component5", "component6", "component7", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Result {

        @SerializedName("AwardDate")
        private final String awardDate;

        @SerializedName("AwardKind")
        private final String awardKind;

        @SerializedName("ConsoleID")
        private final long consoleId;

        @SerializedName("ConsoleName")
        private final String consoleName;

        @SerializedName("GameID")
        private final long gameId;

        @SerializedName("GameTitle")
        private final String gameTitle;

        @SerializedName(SshConstants.USER)
        private final String user;

        public static /* synthetic */ Result copy$default(Result result, String str, String str2, String str3, long j, String str4, long j2, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = result.user;
            }
            if ((i & 2) != 0) {
                str2 = result.awardKind;
            }
            if ((i & 4) != 0) {
                str3 = result.awardDate;
            }
            if ((i & 8) != 0) {
                j = result.gameId;
            }
            if ((i & 16) != 0) {
                str4 = result.gameTitle;
            }
            if ((i & 32) != 0) {
                j2 = result.consoleId;
            }
            if ((i & 64) != 0) {
                str5 = result.consoleName;
            }
            String str6 = str4;
            long j3 = j;
            String str7 = str3;
            return result.copy(str, str2, str7, j3, str6, j2, str5);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final String getUser() {
            return this.user;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getAwardKind() {
            return this.awardKind;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getAwardDate() {
            return this.awardDate;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final long getGameId() {
            return this.gameId;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final String getGameTitle() {
            return this.gameTitle;
        }

        /* INFO: renamed from: component6, reason: from getter */
        public final long getConsoleId() {
            return this.consoleId;
        }

        /* INFO: renamed from: component7, reason: from getter */
        public final String getConsoleName() {
            return this.consoleName;
        }

        public final Result copy(String user, String awardKind, String awardDate, long gameId, String gameTitle, long consoleId, String consoleName) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(awardKind, "awardKind");
            Intrinsics.checkNotNullParameter(awardDate, "awardDate");
            Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            return new Result(user, awardKind, awardDate, gameId, gameTitle, consoleId, consoleName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.user, result.user) && Intrinsics.areEqual(this.awardKind, result.awardKind) && Intrinsics.areEqual(this.awardDate, result.awardDate) && this.gameId == result.gameId && Intrinsics.areEqual(this.gameTitle, result.gameTitle) && this.consoleId == result.consoleId && Intrinsics.areEqual(this.consoleName, result.consoleName);
        }

        public int hashCode() {
            return (((((((((((this.user.hashCode() * 31) + this.awardKind.hashCode()) * 31) + this.awardDate.hashCode()) * 31) + Long.hashCode(this.gameId)) * 31) + this.gameTitle.hashCode()) * 31) + Long.hashCode(this.consoleId)) * 31) + this.consoleName.hashCode();
        }

        public String toString() {
            return "Result(user=" + this.user + ", awardKind=" + this.awardKind + ", awardDate=" + this.awardDate + ", gameId=" + this.gameId + ", gameTitle=" + this.gameTitle + ", consoleId=" + this.consoleId + ", consoleName=" + this.consoleName + ')';
        }

        public Result(String user, String awardKind, String awardDate, long j, String gameTitle, long j2, String consoleName) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(awardKind, "awardKind");
            Intrinsics.checkNotNullParameter(awardDate, "awardDate");
            Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            this.user = user;
            this.awardKind = awardKind;
            this.awardDate = awardDate;
            this.gameId = j;
            this.gameTitle = gameTitle;
            this.consoleId = j2;
            this.consoleName = consoleName;
        }

        public final String getUser() {
            return this.user;
        }

        public final String getAwardKind() {
            return this.awardKind;
        }

        public final String getAwardDate() {
            return this.awardDate;
        }

        public final long getGameId() {
            return this.gameId;
        }

        public final String getGameTitle() {
            return this.gameTitle;
        }

        public final long getConsoleId() {
            return this.consoleId;
        }

        public final String getConsoleName() {
            return this.consoleName;
        }
    }
}
