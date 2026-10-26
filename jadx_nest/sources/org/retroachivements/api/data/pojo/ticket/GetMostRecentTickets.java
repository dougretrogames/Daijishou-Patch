package org.retroachivements.api.data.pojo.ticket;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* INFO: compiled from: GetMostRecentTickets.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetMostRecentTickets;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetMostRecentTickets {

    /* INFO: compiled from: GetMostRecentTickets.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB-\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetMostRecentTickets$Response;", "", "recentTicket", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/ticket/GetMostRecentTickets$Response$RecentTicket;", "Lkotlin/collections/ArrayList;", "openTickets", "", "url", "", "(Ljava/util/ArrayList;JLjava/lang/String;)V", "getOpenTickets", "()J", "getRecentTicket", "()Ljava/util/ArrayList;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "RecentTicket", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("OpenTickets")
        private final long openTickets;

        @SerializedName("RecentTickets")
        private final ArrayList<RecentTicket> recentTicket;

        @SerializedName("URL")
        private final String url;

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, ArrayList arrayList, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = response.recentTicket;
            }
            if ((i & 2) != 0) {
                j = response.openTickets;
            }
            if ((i & 4) != 0) {
                str = response.url;
            }
            return response.copy(arrayList, j, str);
        }

        public final ArrayList<RecentTicket> component1() {
            return this.recentTicket;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final long getOpenTickets() {
            return this.openTickets;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final Response copy(ArrayList<RecentTicket> recentTicket, long openTickets, String url) {
            Intrinsics.checkNotNullParameter(recentTicket, "recentTicket");
            Intrinsics.checkNotNullParameter(url, "url");
            return new Response(recentTicket, openTickets, url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return Intrinsics.areEqual(this.recentTicket, response.recentTicket) && this.openTickets == response.openTickets && Intrinsics.areEqual(this.url, response.url);
        }

        public int hashCode() {
            return (((this.recentTicket.hashCode() * 31) + Long.hashCode(this.openTickets)) * 31) + this.url.hashCode();
        }

        public String toString() {
            return "Response(recentTicket=" + this.recentTicket + ", openTickets=" + this.openTickets + ", url=" + this.url + ')';
        }

        public Response(ArrayList<RecentTicket> recentTicket, long j, String url) {
            Intrinsics.checkNotNullParameter(recentTicket, "recentTicket");
            Intrinsics.checkNotNullParameter(url, "url");
            this.recentTicket = recentTicket;
            this.openTickets = j;
            this.url = url;
        }

        public final ArrayList<RecentTicket> getRecentTicket() {
            return this.recentTicket;
        }

        public final long getOpenTickets() {
            return this.openTickets;
        }

        public final String getUrl() {
            return this.url;
        }

        /* INFO: compiled from: GetMostRecentTickets.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001dJ\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u0012HÆ\u0003J\t\u0010@\u001a\u00020\u0012HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010+J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\u0006HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003Jþ\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020\u00152\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020\u0012HÖ\u0001J\t\u0010V\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0016\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0016\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0016\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001fR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001fR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001fR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001f¨\u0006W"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetMostRecentTickets$Response$RecentTicket;", "", "id", "", "achievementId", "achievementType", "", "achievementTitle", "achievementDesc", "points", "badgeName", "achievementAuthor", "gameId", "consoleName", "gameTitle", "gameIcon", "reportedAt", "reportType", "", "reportState", "hardcore", "", "reportNotes", "reportedBy", "resolvedAt", "resolvedBy", "reportStateDescription", "reportTypeDescription", "url", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAchievementAuthor", "()Ljava/lang/String;", "getAchievementDesc", "getAchievementId", "()J", "getAchievementTitle", "getAchievementType", "getBadgeName", "getConsoleName", "getGameIcon", "getGameId", "getGameTitle", "getHardcore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "getPoints", "getReportNotes", "getReportState", "()I", "getReportStateDescription", "getReportType", "getReportTypeDescription", "getReportedAt", "getReportedBy", "getResolvedAt", "getResolvedBy", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/retroachivements/api/data/pojo/ticket/GetMostRecentTickets$Response$RecentTicket;", "equals", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RecentTicket {

            @SerializedName("AchievementAuthor")
            private final String achievementAuthor;

            @SerializedName("AchievementDesc")
            private final String achievementDesc;

            @SerializedName("AchievementID")
            private final long achievementId;

            @SerializedName("AchievementTitle")
            private final String achievementTitle;

            @SerializedName("AchievementType")
            private final String achievementType;

            @SerializedName("BadgeName")
            private final String badgeName;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("GameIcon")
            private final String gameIcon;

            @SerializedName("GameID")
            private final long gameId;

            @SerializedName("GameTitle")
            private final String gameTitle;

            @SerializedName("Hardcore")
            @JsonAdapter(BooleanJsonDeserializer.class)
            private final Boolean hardcore;

            @SerializedName("ID")
            private final long id;

            @SerializedName("Points")
            private final long points;

            @SerializedName("ReportNotes")
            private final String reportNotes;

            @SerializedName("ReportState")
            private final int reportState;

            @SerializedName("ReportStateDescription")
            private final String reportStateDescription;

            @SerializedName("ReportType")
            private final int reportType;

            @SerializedName("ReportTypeDescription")
            private final String reportTypeDescription;

            @SerializedName("ReportedAt")
            private final String reportedAt;

            @SerializedName("ReportedBy")
            private final String reportedBy;

            @SerializedName("ResolvedAt")
            private final String resolvedAt;

            @SerializedName("ResolvedBy")
            private final String resolvedBy;

            @SerializedName("URL")
            private final String url;

            public static /* synthetic */ RecentTicket copy$default(RecentTicket recentTicket, long j, long j2, String str, String str2, String str3, long j3, String str4, String str5, long j4, String str6, String str7, String str8, String str9, int i, int i2, Boolean bool, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i3, Object obj) {
                String str17;
                String str18;
                long j5 = (i3 & 1) != 0 ? recentTicket.id : j;
                long j6 = (i3 & 2) != 0 ? recentTicket.achievementId : j2;
                String str19 = (i3 & 4) != 0 ? recentTicket.achievementType : str;
                String str20 = (i3 & 8) != 0 ? recentTicket.achievementTitle : str2;
                String str21 = (i3 & 16) != 0 ? recentTicket.achievementDesc : str3;
                long j7 = (i3 & 32) != 0 ? recentTicket.points : j3;
                String str22 = (i3 & 64) != 0 ? recentTicket.badgeName : str4;
                String str23 = (i3 & 128) != 0 ? recentTicket.achievementAuthor : str5;
                long j8 = (i3 & 256) != 0 ? recentTicket.gameId : j4;
                String str24 = (i3 & 512) != 0 ? recentTicket.consoleName : str6;
                long j9 = j5;
                String str25 = (i3 & 1024) != 0 ? recentTicket.gameTitle : str7;
                String str26 = (i3 & 2048) != 0 ? recentTicket.gameIcon : str8;
                String str27 = str25;
                String str28 = (i3 & 4096) != 0 ? recentTicket.reportedAt : str9;
                int i4 = (i3 & 8192) != 0 ? recentTicket.reportType : i;
                int i5 = (i3 & 16384) != 0 ? recentTicket.reportState : i2;
                Boolean bool2 = (i3 & 32768) != 0 ? recentTicket.hardcore : bool;
                String str29 = (i3 & 65536) != 0 ? recentTicket.reportNotes : str10;
                String str30 = (i3 & 131072) != 0 ? recentTicket.reportedBy : str11;
                String str31 = (i3 & 262144) != 0 ? recentTicket.resolvedAt : str12;
                String str32 = (i3 & 524288) != 0 ? recentTicket.resolvedBy : str13;
                String str33 = (i3 & 1048576) != 0 ? recentTicket.reportStateDescription : str14;
                String str34 = (i3 & 2097152) != 0 ? recentTicket.reportTypeDescription : str15;
                if ((i3 & 4194304) != 0) {
                    str18 = str34;
                    str17 = recentTicket.url;
                } else {
                    str17 = str16;
                    str18 = str34;
                }
                return recentTicket.copy(j9, j6, str19, str20, str21, j7, str22, str23, j8, str24, str27, str26, str28, i4, i5, bool2, str29, str30, str31, str32, str33, str18, str17);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* INFO: renamed from: component10, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* INFO: renamed from: component11, reason: from getter */
            public final String getGameTitle() {
                return this.gameTitle;
            }

            /* INFO: renamed from: component12, reason: from getter */
            public final String getGameIcon() {
                return this.gameIcon;
            }

            /* INFO: renamed from: component13, reason: from getter */
            public final String getReportedAt() {
                return this.reportedAt;
            }

            /* INFO: renamed from: component14, reason: from getter */
            public final int getReportType() {
                return this.reportType;
            }

            /* INFO: renamed from: component15, reason: from getter */
            public final int getReportState() {
                return this.reportState;
            }

            /* INFO: renamed from: component16, reason: from getter */
            public final Boolean getHardcore() {
                return this.hardcore;
            }

            /* INFO: renamed from: component17, reason: from getter */
            public final String getReportNotes() {
                return this.reportNotes;
            }

            /* INFO: renamed from: component18, reason: from getter */
            public final String getReportedBy() {
                return this.reportedBy;
            }

            /* INFO: renamed from: component19, reason: from getter */
            public final String getResolvedAt() {
                return this.resolvedAt;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final long getAchievementId() {
                return this.achievementId;
            }

            /* INFO: renamed from: component20, reason: from getter */
            public final String getResolvedBy() {
                return this.resolvedBy;
            }

            /* INFO: renamed from: component21, reason: from getter */
            public final String getReportStateDescription() {
                return this.reportStateDescription;
            }

            /* INFO: renamed from: component22, reason: from getter */
            public final String getReportTypeDescription() {
                return this.reportTypeDescription;
            }

            /* INFO: renamed from: component23, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final String getAchievementType() {
                return this.achievementType;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final String getAchievementTitle() {
                return this.achievementTitle;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final String getAchievementDesc() {
                return this.achievementDesc;
            }

            /* INFO: renamed from: component6, reason: from getter */
            public final long getPoints() {
                return this.points;
            }

            /* INFO: renamed from: component7, reason: from getter */
            public final String getBadgeName() {
                return this.badgeName;
            }

            /* INFO: renamed from: component8, reason: from getter */
            public final String getAchievementAuthor() {
                return this.achievementAuthor;
            }

            /* INFO: renamed from: component9, reason: from getter */
            public final long getGameId() {
                return this.gameId;
            }

            public final RecentTicket copy(long id2, long achievementId, String achievementType, String achievementTitle, String achievementDesc, long points, String badgeName, String achievementAuthor, long gameId, String consoleName, String gameTitle, String gameIcon, String reportedAt, int reportType, int reportState, Boolean hardcore, String reportNotes, String reportedBy, String resolvedAt, String resolvedBy, String reportStateDescription, String reportTypeDescription, String url) {
                Intrinsics.checkNotNullParameter(achievementTitle, "achievementTitle");
                Intrinsics.checkNotNullParameter(achievementDesc, "achievementDesc");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                Intrinsics.checkNotNullParameter(achievementAuthor, "achievementAuthor");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(reportedAt, "reportedAt");
                Intrinsics.checkNotNullParameter(reportNotes, "reportNotes");
                Intrinsics.checkNotNullParameter(reportedBy, "reportedBy");
                Intrinsics.checkNotNullParameter(reportStateDescription, "reportStateDescription");
                Intrinsics.checkNotNullParameter(reportTypeDescription, "reportTypeDescription");
                return new RecentTicket(id2, achievementId, achievementType, achievementTitle, achievementDesc, points, badgeName, achievementAuthor, gameId, consoleName, gameTitle, gameIcon, reportedAt, reportType, reportState, hardcore, reportNotes, reportedBy, resolvedAt, resolvedBy, reportStateDescription, reportTypeDescription, url);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RecentTicket)) {
                    return false;
                }
                RecentTicket recentTicket = (RecentTicket) other;
                return this.id == recentTicket.id && this.achievementId == recentTicket.achievementId && Intrinsics.areEqual(this.achievementType, recentTicket.achievementType) && Intrinsics.areEqual(this.achievementTitle, recentTicket.achievementTitle) && Intrinsics.areEqual(this.achievementDesc, recentTicket.achievementDesc) && this.points == recentTicket.points && Intrinsics.areEqual(this.badgeName, recentTicket.badgeName) && Intrinsics.areEqual(this.achievementAuthor, recentTicket.achievementAuthor) && this.gameId == recentTicket.gameId && Intrinsics.areEqual(this.consoleName, recentTicket.consoleName) && Intrinsics.areEqual(this.gameTitle, recentTicket.gameTitle) && Intrinsics.areEqual(this.gameIcon, recentTicket.gameIcon) && Intrinsics.areEqual(this.reportedAt, recentTicket.reportedAt) && this.reportType == recentTicket.reportType && this.reportState == recentTicket.reportState && Intrinsics.areEqual(this.hardcore, recentTicket.hardcore) && Intrinsics.areEqual(this.reportNotes, recentTicket.reportNotes) && Intrinsics.areEqual(this.reportedBy, recentTicket.reportedBy) && Intrinsics.areEqual(this.resolvedAt, recentTicket.resolvedAt) && Intrinsics.areEqual(this.resolvedBy, recentTicket.resolvedBy) && Intrinsics.areEqual(this.reportStateDescription, recentTicket.reportStateDescription) && Intrinsics.areEqual(this.reportTypeDescription, recentTicket.reportTypeDescription) && Intrinsics.areEqual(this.url, recentTicket.url);
            }

            public int hashCode() {
                int iHashCode = ((Long.hashCode(this.id) * 31) + Long.hashCode(this.achievementId)) * 31;
                String str = this.achievementType;
                int iHashCode2 = (((((((((((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.achievementTitle.hashCode()) * 31) + this.achievementDesc.hashCode()) * 31) + Long.hashCode(this.points)) * 31) + this.badgeName.hashCode()) * 31) + this.achievementAuthor.hashCode()) * 31) + Long.hashCode(this.gameId)) * 31) + this.consoleName.hashCode()) * 31) + this.gameTitle.hashCode()) * 31) + this.gameIcon.hashCode()) * 31) + this.reportedAt.hashCode()) * 31) + Integer.hashCode(this.reportType)) * 31) + Integer.hashCode(this.reportState)) * 31;
                Boolean bool = this.hardcore;
                int iHashCode3 = (((((iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + this.reportNotes.hashCode()) * 31) + this.reportedBy.hashCode()) * 31;
                String str2 = this.resolvedAt;
                int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.resolvedBy;
                int iHashCode5 = (((((iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.reportStateDescription.hashCode()) * 31) + this.reportTypeDescription.hashCode()) * 31;
                String str4 = this.url;
                return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("RecentTicket(id=");
                sb.append(this.id).append(", achievementId=").append(this.achievementId).append(", achievementType=").append(this.achievementType).append(", achievementTitle=").append(this.achievementTitle).append(", achievementDesc=").append(this.achievementDesc).append(", points=").append(this.points).append(", badgeName=").append(this.badgeName).append(", achievementAuthor=").append(this.achievementAuthor).append(", gameId=").append(this.gameId).append(", consoleName=").append(this.consoleName).append(", gameTitle=").append(this.gameTitle).append(", gameIcon=");
                sb.append(this.gameIcon).append(", reportedAt=").append(this.reportedAt).append(", reportType=").append(this.reportType).append(", reportState=").append(this.reportState).append(", hardcore=").append(this.hardcore).append(", reportNotes=").append(this.reportNotes).append(", reportedBy=").append(this.reportedBy).append(", resolvedAt=").append(this.resolvedAt).append(", resolvedBy=").append(this.resolvedBy).append(", reportStateDescription=").append(this.reportStateDescription).append(", reportTypeDescription=").append(this.reportTypeDescription).append(", url=").append(this.url);
                sb.append(')');
                return sb.toString();
            }

            public RecentTicket(long j, long j2, String str, String achievementTitle, String achievementDesc, long j3, String badgeName, String achievementAuthor, long j4, String consoleName, String gameTitle, String gameIcon, String reportedAt, int i, int i2, Boolean bool, String reportNotes, String reportedBy, String str2, String str3, String reportStateDescription, String reportTypeDescription, String str4) {
                Intrinsics.checkNotNullParameter(achievementTitle, "achievementTitle");
                Intrinsics.checkNotNullParameter(achievementDesc, "achievementDesc");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                Intrinsics.checkNotNullParameter(achievementAuthor, "achievementAuthor");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(reportedAt, "reportedAt");
                Intrinsics.checkNotNullParameter(reportNotes, "reportNotes");
                Intrinsics.checkNotNullParameter(reportedBy, "reportedBy");
                Intrinsics.checkNotNullParameter(reportStateDescription, "reportStateDescription");
                Intrinsics.checkNotNullParameter(reportTypeDescription, "reportTypeDescription");
                this.id = j;
                this.achievementId = j2;
                this.achievementType = str;
                this.achievementTitle = achievementTitle;
                this.achievementDesc = achievementDesc;
                this.points = j3;
                this.badgeName = badgeName;
                this.achievementAuthor = achievementAuthor;
                this.gameId = j4;
                this.consoleName = consoleName;
                this.gameTitle = gameTitle;
                this.gameIcon = gameIcon;
                this.reportedAt = reportedAt;
                this.reportType = i;
                this.reportState = i2;
                this.hardcore = bool;
                this.reportNotes = reportNotes;
                this.reportedBy = reportedBy;
                this.resolvedAt = str2;
                this.resolvedBy = str3;
                this.reportStateDescription = reportStateDescription;
                this.reportTypeDescription = reportTypeDescription;
                this.url = str4;
            }

            public final long getId() {
                return this.id;
            }

            public final long getAchievementId() {
                return this.achievementId;
            }

            public final String getAchievementType() {
                return this.achievementType;
            }

            public final String getAchievementTitle() {
                return this.achievementTitle;
            }

            public final String getAchievementDesc() {
                return this.achievementDesc;
            }

            public final long getPoints() {
                return this.points;
            }

            public final String getBadgeName() {
                return this.badgeName;
            }

            public final String getAchievementAuthor() {
                return this.achievementAuthor;
            }

            public final long getGameId() {
                return this.gameId;
            }

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final String getGameTitle() {
                return this.gameTitle;
            }

            public final String getGameIcon() {
                return this.gameIcon;
            }

            public final String getReportedAt() {
                return this.reportedAt;
            }

            public final int getReportType() {
                return this.reportType;
            }

            public final int getReportState() {
                return this.reportState;
            }

            public final Boolean getHardcore() {
                return this.hardcore;
            }

            public final String getReportNotes() {
                return this.reportNotes;
            }

            public final String getReportedBy() {
                return this.reportedBy;
            }

            public final String getResolvedAt() {
                return this.resolvedAt;
            }

            public final String getResolvedBy() {
                return this.resolvedBy;
            }

            public final String getReportStateDescription() {
                return this.reportStateDescription;
            }

            public final String getReportTypeDescription() {
                return this.reportTypeDescription;
            }

            public final String getUrl() {
                return this.url;
            }
        }
    }
}
