package org.retroachivements.api.data.pojo.ticket;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.protocol.HTTP;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;

/* JADX INFO: compiled from: GetDeveloperTicketStats.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetDeveloperTicketStats;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetDeveloperTicketStats {

    /* JADX INFO: compiled from: GetDeveloperTicketStats.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006 "}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetDeveloperTicketStats$Response;", "", ConfigConstants.CONFIG_USER_SECTION, "", "open", "", "close", "resolved", "total", "url", "(Ljava/lang/String;JJJJLjava/lang/String;)V", "getClose", "()J", "getOpen", "getResolved", "getTotal", "getUrl", "()Ljava/lang/String;", "getUser", "component1", "component2", "component3", "component4", "component5", "component6", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName(HTTP.CONN_CLOSE)
        private final long close;

        @SerializedName("Open")
        private final long open;

        @SerializedName("Resolved")
        private final long resolved;

        @SerializedName("Total")
        private final long total;

        @SerializedName("URL")
        private final String url;

        @SerializedName(SshConstants.USER)
        private final String user;

        public static /* synthetic */ Response copy$default(Response response, String str, long j, long j2, long j3, long j4, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = response.user;
            }
            if ((i & 2) != 0) {
                j = response.open;
            }
            if ((i & 4) != 0) {
                j2 = response.close;
            }
            if ((i & 8) != 0) {
                j3 = response.resolved;
            }
            if ((i & 16) != 0) {
                j4 = response.total;
            }
            if ((i & 32) != 0) {
                str2 = response.url;
            }
            String str3 = str2;
            long j5 = j4;
            long j6 = j3;
            return response.copy(str, j, j2, j6, j5, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getOpen() {
            return this.open;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getClose() {
            return this.close;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getResolved() {
            return this.resolved;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getTotal() {
            return this.total;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final Response copy(String user, long open, long close, long resolved, long total, String url) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(url, "url");
            return new Response(user, open, close, resolved, total, url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return Intrinsics.areEqual(this.user, response.user) && this.open == response.open && this.close == response.close && this.resolved == response.resolved && this.total == response.total && Intrinsics.areEqual(this.url, response.url);
        }

        public int hashCode() {
            return (((((((((this.user.hashCode() * 31) + Long.hashCode(this.open)) * 31) + Long.hashCode(this.close)) * 31) + Long.hashCode(this.resolved)) * 31) + Long.hashCode(this.total)) * 31) + this.url.hashCode();
        }

        public String toString() {
            return "Response(user=" + this.user + ", open=" + this.open + ", close=" + this.close + ", resolved=" + this.resolved + ", total=" + this.total + ", url=" + this.url + ')';
        }

        public Response(String user, long j, long j2, long j3, long j4, String url) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(url, "url");
            this.user = user;
            this.open = j;
            this.close = j2;
            this.resolved = j3;
            this.total = j4;
            this.url = url;
        }

        public final String getUser() {
            return this.user;
        }

        public final long getOpen() {
            return this.open;
        }

        public final long getClose() {
            return this.close;
        }

        public final long getResolved() {
            return this.resolved;
        }

        public final long getTotal() {
            return this.total;
        }

        public final String getUrl() {
            return this.url;
        }
    }
}
