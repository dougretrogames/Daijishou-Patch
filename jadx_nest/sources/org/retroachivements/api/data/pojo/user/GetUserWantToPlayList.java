package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: GetUserWantToPlayList.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserWantToPlayList;", "", "()V", "Response", "Result", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserWantToPlayList {

    /* INFO: compiled from: GetUserWantToPlayList.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserWantToPlayList$Response;", "", "count", "", "total", "results", "", "Lorg/retroachivements/api/data/pojo/user/GetUserWantToPlayList$Result;", "(JJLjava/util/List;)V", "getCount", "()J", "getResults", "()Ljava/util/List;", "getTotal", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* INFO: compiled from: GetUserWantToPlayList.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006#"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserWantToPlayList$Result;", "", "id", "", "title", "", "consoleId", "consoleName", "imageIcon", "pointsTotal", "achievementsPublished", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;JJ)V", "getAchievementsPublished", "()J", "getConsoleId", "getConsoleName", "()Ljava/lang/String;", "getId", "getImageIcon", "getPointsTotal", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Result {

        @SerializedName("AchievementsPublished")
        private final long achievementsPublished;

        @SerializedName("ConsoleID")
        private final long consoleId;

        @SerializedName("ConsoleName")
        private final String consoleName;

        @SerializedName("ID")
        private final long id;

        @SerializedName("ImageIcon")
        private final String imageIcon;

        @SerializedName("PointsTotal")
        private final long pointsTotal;

        @SerializedName("Title")
        private final String title;

        public static /* synthetic */ Result copy$default(Result result, long j, String str, long j2, String str2, String str3, long j3, long j4, int i, Object obj) {
            if ((i & 1) != 0) {
                j = result.id;
            }
            long j5 = j;
            if ((i & 2) != 0) {
                str = result.title;
            }
            return result.copy(j5, str, (i & 4) != 0 ? result.consoleId : j2, (i & 8) != 0 ? result.consoleName : str2, (i & 16) != 0 ? result.imageIcon : str3, (i & 32) != 0 ? result.pointsTotal : j3, (i & 64) != 0 ? result.achievementsPublished : j4);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final long getConsoleId() {
            return this.consoleId;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final String getConsoleName() {
            return this.consoleName;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final String getImageIcon() {
            return this.imageIcon;
        }

        /* INFO: renamed from: component6, reason: from getter */
        public final long getPointsTotal() {
            return this.pointsTotal;
        }

        /* INFO: renamed from: component7, reason: from getter */
        public final long getAchievementsPublished() {
            return this.achievementsPublished;
        }

        public final Result copy(long id2, String title, long consoleId, String consoleName, String imageIcon, long pointsTotal, long achievementsPublished) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            return new Result(id2, title, consoleId, consoleName, imageIcon, pointsTotal, achievementsPublished);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return this.id == result.id && Intrinsics.areEqual(this.title, result.title) && this.consoleId == result.consoleId && Intrinsics.areEqual(this.consoleName, result.consoleName) && Intrinsics.areEqual(this.imageIcon, result.imageIcon) && this.pointsTotal == result.pointsTotal && this.achievementsPublished == result.achievementsPublished;
        }

        public int hashCode() {
            return (((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.consoleId)) * 31) + this.consoleName.hashCode()) * 31) + this.imageIcon.hashCode()) * 31) + Long.hashCode(this.pointsTotal)) * 31) + Long.hashCode(this.achievementsPublished);
        }

        public String toString() {
            return "Result(id=" + this.id + ", title=" + this.title + ", consoleId=" + this.consoleId + ", consoleName=" + this.consoleName + ", imageIcon=" + this.imageIcon + ", pointsTotal=" + this.pointsTotal + ", achievementsPublished=" + this.achievementsPublished + ')';
        }

        public Result(long j, String title, long j2, String consoleName, String imageIcon, long j3, long j4) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            this.id = j;
            this.title = title;
            this.consoleId = j2;
            this.consoleName = consoleName;
            this.imageIcon = imageIcon;
            this.pointsTotal = j3;
            this.achievementsPublished = j4;
        }

        public final long getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final long getConsoleId() {
            return this.consoleId;
        }

        public final String getConsoleName() {
            return this.consoleName;
        }

        public final String getImageIcon() {
            return this.imageIcon;
        }

        public final long getPointsTotal() {
            return this.pointsTotal;
        }

        public final long getAchievementsPublished() {
            return this.achievementsPublished;
        }
    }
}
