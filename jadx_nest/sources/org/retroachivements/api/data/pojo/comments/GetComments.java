package org.retroachivements.api.data.pojo.comments;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;

/* INFO: compiled from: GetComments.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lorg/retroachivements/api/data/pojo/comments/GetComments;", "", "()V", "Response", "Result", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetComments {

    /* INFO: compiled from: GetComments.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lorg/retroachivements/api/data/pojo/comments/GetComments$Response;", "", "count", "", "total", "results", "", "Lorg/retroachivements/api/data/pojo/comments/GetComments$Result;", "(JJLjava/util/List;)V", "getCount", "()J", "getResults", "()Ljava/util/List;", "getTotal", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* INFO: compiled from: GetComments.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lorg/retroachivements/api/data/pojo/comments/GetComments$Result;", "", ConfigConstants.CONFIG_USER_SECTION, "", "submitted", "commentText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCommentText", "()Ljava/lang/String;", "getSubmitted", "getUser", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Result {

        @SerializedName("CommentText")
        private final String commentText;

        @SerializedName("Submitted")
        private final String submitted;

        @SerializedName(SshConstants.USER)
        private final String user;

        public static /* synthetic */ Result copy$default(Result result, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = result.user;
            }
            if ((i & 2) != 0) {
                str2 = result.submitted;
            }
            if ((i & 4) != 0) {
                str3 = result.commentText;
            }
            return result.copy(str, str2, str3);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final String getUser() {
            return this.user;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getSubmitted() {
            return this.submitted;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getCommentText() {
            return this.commentText;
        }

        public final Result copy(String user, String submitted, String commentText) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(submitted, "submitted");
            Intrinsics.checkNotNullParameter(commentText, "commentText");
            return new Result(user, submitted, commentText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.user, result.user) && Intrinsics.areEqual(this.submitted, result.submitted) && Intrinsics.areEqual(this.commentText, result.commentText);
        }

        public int hashCode() {
            return (((this.user.hashCode() * 31) + this.submitted.hashCode()) * 31) + this.commentText.hashCode();
        }

        public String toString() {
            return "Result(user=" + this.user + ", submitted=" + this.submitted + ", commentText=" + this.commentText + ')';
        }

        public Result(String user, String submitted, String commentText) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(submitted, "submitted");
            Intrinsics.checkNotNullParameter(commentText, "commentText");
            this.user = user;
            this.submitted = submitted;
            this.commentText = commentText;
        }

        public final String getUser() {
            return this.user;
        }

        public final String getSubmitted() {
            return this.submitted;
        }

        public final String getCommentText() {
            return this.commentText;
        }
    }
}
