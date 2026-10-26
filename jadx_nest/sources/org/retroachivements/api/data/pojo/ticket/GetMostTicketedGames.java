package org.retroachivements.api.data.pojo.ticket;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: GetMostTicketedGames.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetMostTicketedGames;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetMostTicketedGames {

    /* INFO: compiled from: GetMostTicketedGames.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016B%\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetMostTicketedGames$Response;", "", "mostReportedGames", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/ticket/GetMostTicketedGames$Response$ReportedGame;", "Lkotlin/collections/ArrayList;", "url", "", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "getMostReportedGames", "()Ljava/util/ArrayList;", "getUrl", "()Ljava/lang/String;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "ReportedGame", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("MostReportedGames")
        private final ArrayList<ReportedGame> mostReportedGames;

        @SerializedName("URL")
        private final String url;

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, ArrayList arrayList, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = response.mostReportedGames;
            }
            if ((i & 2) != 0) {
                str = response.url;
            }
            return response.copy(arrayList, str);
        }

        public final ArrayList<ReportedGame> component1() {
            return this.mostReportedGames;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final Response copy(ArrayList<ReportedGame> mostReportedGames, String url) {
            Intrinsics.checkNotNullParameter(mostReportedGames, "mostReportedGames");
            Intrinsics.checkNotNullParameter(url, "url");
            return new Response(mostReportedGames, url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return Intrinsics.areEqual(this.mostReportedGames, response.mostReportedGames) && Intrinsics.areEqual(this.url, response.url);
        }

        public int hashCode() {
            return (this.mostReportedGames.hashCode() * 31) + this.url.hashCode();
        }

        public String toString() {
            return "Response(mostReportedGames=" + this.mostReportedGames + ", url=" + this.url + ')';
        }

        public Response(ArrayList<ReportedGame> mostReportedGames, String url) {
            Intrinsics.checkNotNullParameter(mostReportedGames, "mostReportedGames");
            Intrinsics.checkNotNullParameter(url, "url");
            this.mostReportedGames = mostReportedGames;
            this.url = url;
        }

        public final ArrayList<ReportedGame> getMostReportedGames() {
            return this.mostReportedGames;
        }

        public final String getUrl() {
            return this.url;
        }

        /* INFO: compiled from: GetMostTicketedGames.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetMostTicketedGames$Response$ReportedGame;", "", "gameId", "", "gameTitle", "", "gameIcon", "console", "openTicket", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getConsole", "()Ljava/lang/String;", "getGameIcon", "getGameId", "()J", "getGameTitle", "getOpenTicket", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ReportedGame {

            @SerializedName("Console")
            private final String console;

            @SerializedName("GameIcon")
            private final String gameIcon;

            @SerializedName("GameID")
            private final long gameId;

            @SerializedName("GameTitle")
            private final String gameTitle;

            @SerializedName("OpenTicket")
            private final long openTicket;

            public static /* synthetic */ ReportedGame copy$default(ReportedGame reportedGame, long j, String str, String str2, String str3, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = reportedGame.gameId;
                }
                long j3 = j;
                if ((i & 2) != 0) {
                    str = reportedGame.gameTitle;
                }
                String str4 = str;
                if ((i & 4) != 0) {
                    str2 = reportedGame.gameIcon;
                }
                String str5 = str2;
                if ((i & 8) != 0) {
                    str3 = reportedGame.console;
                }
                String str6 = str3;
                if ((i & 16) != 0) {
                    j2 = reportedGame.openTicket;
                }
                return reportedGame.copy(j3, str4, str5, str6, j2);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final long getGameId() {
                return this.gameId;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final String getGameTitle() {
                return this.gameTitle;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final String getGameIcon() {
                return this.gameIcon;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final String getConsole() {
                return this.console;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final long getOpenTicket() {
                return this.openTicket;
            }

            public final ReportedGame copy(long gameId, String gameTitle, String gameIcon, String console, long openTicket) {
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(console, "console");
                return new ReportedGame(gameId, gameTitle, gameIcon, console, openTicket);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReportedGame)) {
                    return false;
                }
                ReportedGame reportedGame = (ReportedGame) other;
                return this.gameId == reportedGame.gameId && Intrinsics.areEqual(this.gameTitle, reportedGame.gameTitle) && Intrinsics.areEqual(this.gameIcon, reportedGame.gameIcon) && Intrinsics.areEqual(this.console, reportedGame.console) && this.openTicket == reportedGame.openTicket;
            }

            public int hashCode() {
                return (((((((Long.hashCode(this.gameId) * 31) + this.gameTitle.hashCode()) * 31) + this.gameIcon.hashCode()) * 31) + this.console.hashCode()) * 31) + Long.hashCode(this.openTicket);
            }

            public String toString() {
                return "ReportedGame(gameId=" + this.gameId + ", gameTitle=" + this.gameTitle + ", gameIcon=" + this.gameIcon + ", console=" + this.console + ", openTicket=" + this.openTicket + ')';
            }

            public ReportedGame(long j, String gameTitle, String gameIcon, String console, long j2) {
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(console, "console");
                this.gameId = j;
                this.gameTitle = gameTitle;
                this.gameIcon = gameIcon;
                this.console = console;
                this.openTicket = j2;
            }

            public final long getGameId() {
                return this.gameId;
            }

            public final String getGameTitle() {
                return this.gameTitle;
            }

            public final String getGameIcon() {
                return this.gameIcon;
            }

            public final String getConsole() {
                return this.console;
            }

            public final long getOpenTicket() {
                return this.openTicket;
            }
        }
    }
}
