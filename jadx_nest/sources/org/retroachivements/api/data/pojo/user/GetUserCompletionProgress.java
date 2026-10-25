package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: GetUserCompletionProgress.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserCompletionProgress;", "", "()V", "Progress", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserCompletionProgress {

    /* JADX INFO: compiled from: GetUserCompletionProgress.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001a"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserCompletionProgress$Response;", "", "count", "", "total", "results", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/user/GetUserCompletionProgress$Progress;", "Lkotlin/collections/ArrayList;", "(JJLjava/util/ArrayList;)V", "getCount", "()J", "getResults", "()Ljava/util/ArrayList;", "getTotal", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Count")
        private final long count;

        @SerializedName("Results")
        private final ArrayList<Progress> results;

        @SerializedName("Total")
        private final long total;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, long j, long j2, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                j = response.count;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = response.total;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                arrayList = response.results;
            }
            return response.copy(j3, j4, arrayList);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTotal() {
            return this.total;
        }

        public final ArrayList<Progress> component3() {
            return this.results;
        }

        public final Response copy(long count, long total, ArrayList<Progress> results) {
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

        public Response(long j, long j2, ArrayList<Progress> results) {
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

        public final ArrayList<Progress> getResults() {
            return this.results;
        }
    }

    /* JADX INFO: compiled from: GetUserCompletionProgress.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003Jw\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\bHÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u00060"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserCompletionProgress$Progress;", "", "gameId", "", "title", "", "imageIcon", "consoleId", "", "consoleName", "maxPossible", "numAwarded", "numAwardedHardcore", "mostRecentAwardedDate", "highestAwardKind", "highestAwardDate", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConsoleId", "()I", "getConsoleName", "()Ljava/lang/String;", "getGameId", "()J", "getHighestAwardDate", "getHighestAwardKind", "getImageIcon", "getMaxPossible", "getMostRecentAwardedDate", "getNumAwarded", "getNumAwardedHardcore", "getTitle", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Progress {

        @SerializedName("ConsoleID")
        private final int consoleId;

        @SerializedName("ConsoleName")
        private final String consoleName;

        @SerializedName("GameID")
        private final long gameId;

        @SerializedName("HighestAwardDate")
        private final String highestAwardDate;

        @SerializedName("HighestAwardKind")
        private final String highestAwardKind;

        @SerializedName("ImageIcon")
        private final String imageIcon;

        @SerializedName("MaxPossible")
        private final long maxPossible;

        @SerializedName("MostRecentAwardedDate")
        private final String mostRecentAwardedDate;

        @SerializedName("NumAwarded")
        private final long numAwarded;

        @SerializedName("NumAwardedHardcore")
        private final long numAwardedHardcore;

        @SerializedName("Title")
        private final String title;

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGameId() {
            return this.gameId;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getHighestAwardKind() {
            return this.highestAwardKind;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getHighestAwardDate() {
            return this.highestAwardDate;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getImageIcon() {
            return this.imageIcon;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getConsoleId() {
            return this.consoleId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getConsoleName() {
            return this.consoleName;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getMaxPossible() {
            return this.maxPossible;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final long getNumAwarded() {
            return this.numAwarded;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final long getNumAwardedHardcore() {
            return this.numAwardedHardcore;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getMostRecentAwardedDate() {
            return this.mostRecentAwardedDate;
        }

        public final Progress copy(long gameId, String title, String imageIcon, int consoleId, String consoleName, long maxPossible, long numAwarded, long numAwardedHardcore, String mostRecentAwardedDate, String highestAwardKind, String highestAwardDate) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(mostRecentAwardedDate, "mostRecentAwardedDate");
            Intrinsics.checkNotNullParameter(highestAwardKind, "highestAwardKind");
            Intrinsics.checkNotNullParameter(highestAwardDate, "highestAwardDate");
            return new Progress(gameId, title, imageIcon, consoleId, consoleName, maxPossible, numAwarded, numAwardedHardcore, mostRecentAwardedDate, highestAwardKind, highestAwardDate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Progress)) {
                return false;
            }
            Progress progress = (Progress) other;
            return this.gameId == progress.gameId && Intrinsics.areEqual(this.title, progress.title) && Intrinsics.areEqual(this.imageIcon, progress.imageIcon) && this.consoleId == progress.consoleId && Intrinsics.areEqual(this.consoleName, progress.consoleName) && this.maxPossible == progress.maxPossible && this.numAwarded == progress.numAwarded && this.numAwardedHardcore == progress.numAwardedHardcore && Intrinsics.areEqual(this.mostRecentAwardedDate, progress.mostRecentAwardedDate) && Intrinsics.areEqual(this.highestAwardKind, progress.highestAwardKind) && Intrinsics.areEqual(this.highestAwardDate, progress.highestAwardDate);
        }

        public int hashCode() {
            return (((((((((((((((((((Long.hashCode(this.gameId) * 31) + this.title.hashCode()) * 31) + this.imageIcon.hashCode()) * 31) + Integer.hashCode(this.consoleId)) * 31) + this.consoleName.hashCode()) * 31) + Long.hashCode(this.maxPossible)) * 31) + Long.hashCode(this.numAwarded)) * 31) + Long.hashCode(this.numAwardedHardcore)) * 31) + this.mostRecentAwardedDate.hashCode()) * 31) + this.highestAwardKind.hashCode()) * 31) + this.highestAwardDate.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Progress(gameId=");
            sb.append(this.gameId).append(", title=").append(this.title).append(", imageIcon=").append(this.imageIcon).append(", consoleId=").append(this.consoleId).append(", consoleName=").append(this.consoleName).append(", maxPossible=").append(this.maxPossible).append(", numAwarded=").append(this.numAwarded).append(", numAwardedHardcore=").append(this.numAwardedHardcore).append(", mostRecentAwardedDate=").append(this.mostRecentAwardedDate).append(", highestAwardKind=").append(this.highestAwardKind).append(", highestAwardDate=").append(this.highestAwardDate).append(')');
            return sb.toString();
        }

        public Progress(long j, String title, String imageIcon, int i, String consoleName, long j2, long j3, long j4, String mostRecentAwardedDate, String highestAwardKind, String highestAwardDate) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(mostRecentAwardedDate, "mostRecentAwardedDate");
            Intrinsics.checkNotNullParameter(highestAwardKind, "highestAwardKind");
            Intrinsics.checkNotNullParameter(highestAwardDate, "highestAwardDate");
            this.gameId = j;
            this.title = title;
            this.imageIcon = imageIcon;
            this.consoleId = i;
            this.consoleName = consoleName;
            this.maxPossible = j2;
            this.numAwarded = j3;
            this.numAwardedHardcore = j4;
            this.mostRecentAwardedDate = mostRecentAwardedDate;
            this.highestAwardKind = highestAwardKind;
            this.highestAwardDate = highestAwardDate;
        }

        public final long getGameId() {
            return this.gameId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getImageIcon() {
            return this.imageIcon;
        }

        public final int getConsoleId() {
            return this.consoleId;
        }

        public final String getConsoleName() {
            return this.consoleName;
        }

        public final long getMaxPossible() {
            return this.maxPossible;
        }

        public final long getNumAwarded() {
            return this.numAwarded;
        }

        public final long getNumAwardedHardcore() {
            return this.numAwardedHardcore;
        }

        public final String getMostRecentAwardedDate() {
            return this.mostRecentAwardedDate;
        }

        public final String getHighestAwardKind() {
            return this.highestAwardKind;
        }

        public final String getHighestAwardDate() {
            return this.highestAwardDate;
        }
    }
}
