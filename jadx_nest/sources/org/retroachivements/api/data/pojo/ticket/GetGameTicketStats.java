package org.retroachivements.api.data.pojo.ticket;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: GetGameTicketStats.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetGameTicketStats;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetGameTicketStats {

    /* JADX INFO: compiled from: GetGameTicketStats.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetGameTicketStats$Response;", "", "gameId", "", "gameTitle", "", "consoleName", "openTickets", "url", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getConsoleName", "()Ljava/lang/String;", "getGameId", "()J", "getGameTitle", "getOpenTickets", "getUrl", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("ConsoleName")
        private final String consoleName;

        @SerializedName("GameID")
        private final long gameId;

        @SerializedName("GameTitle")
        private final String gameTitle;

        @SerializedName("OpenTickets")
        private final long openTickets;

        @SerializedName("URL")
        private final String url;

        public static /* synthetic */ Response copy$default(Response response, long j, String str, String str2, long j2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = response.gameId;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                str = response.gameTitle;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = response.consoleName;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                j2 = response.openTickets;
            }
            long j4 = j2;
            if ((i & 16) != 0) {
                str3 = response.url;
            }
            return response.copy(j3, str4, str5, j4, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGameId() {
            return this.gameId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getGameTitle() {
            return this.gameTitle;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getConsoleName() {
            return this.consoleName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getOpenTickets() {
            return this.openTickets;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final Response copy(long gameId, String gameTitle, String consoleName, long openTickets, String url) {
            Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(url, "url");
            return new Response(gameId, gameTitle, consoleName, openTickets, url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.gameId == response.gameId && Intrinsics.areEqual(this.gameTitle, response.gameTitle) && Intrinsics.areEqual(this.consoleName, response.consoleName) && this.openTickets == response.openTickets && Intrinsics.areEqual(this.url, response.url);
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.gameId) * 31) + this.gameTitle.hashCode()) * 31) + this.consoleName.hashCode()) * 31) + Long.hashCode(this.openTickets)) * 31) + this.url.hashCode();
        }

        public String toString() {
            return "Response(gameId=" + this.gameId + ", gameTitle=" + this.gameTitle + ", consoleName=" + this.consoleName + ", openTickets=" + this.openTickets + ", url=" + this.url + ')';
        }

        public Response(long j, String gameTitle, String consoleName, long j2, String url) {
            Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(url, "url");
            this.gameId = j;
            this.gameTitle = gameTitle;
            this.consoleName = consoleName;
            this.openTickets = j2;
            this.url = url;
        }

        public final long getGameId() {
            return this.gameId;
        }

        public final String getGameTitle() {
            return this.gameTitle;
        }

        public final String getConsoleName() {
            return this.consoleName;
        }

        public final long getOpenTickets() {
            return this.openTickets;
        }

        public final String getUrl() {
            return this.url;
        }
    }
}
