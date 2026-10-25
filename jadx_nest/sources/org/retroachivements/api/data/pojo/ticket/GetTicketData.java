package org.retroachivements.api.data.pojo.ticket;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* JADX INFO: compiled from: GetTicketData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetTicketData;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetTicketData {

    /* JADX INFO: compiled from: GetTicketData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001dJ\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u0012HÆ\u0003J\t\u0010@\u001a\u00020\u0012HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010+J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\u0006HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003Jþ\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020\u00152\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020\u0012HÖ\u0001J\t\u0010V\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0016\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0016\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0016\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001fR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001fR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001fR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001f¨\u0006W"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetTicketData$Response;", "", "id", "", "achievementId", "achievementType", "", "achievementTitle", "achievementDesc", "points", "badgeName", "achievementAuthor", "gameId", "consoleName", "gameTitle", "gameIcon", "reportedAt", "reportType", "", "reportState", "hardcore", "", "reportNotes", "reportedBy", "resolvedAt", "resolvedBy", "reportStateDescription", "reportTypeDescription", "url", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAchievementAuthor", "()Ljava/lang/String;", "getAchievementDesc", "getAchievementId", "()J", "getAchievementTitle", "getAchievementType", "getBadgeName", "getConsoleName", "getGameIcon", "getGameId", "getGameTitle", "getHardcore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "getPoints", "getReportNotes", "getReportState", "()I", "getReportStateDescription", "getReportType", "getReportTypeDescription", "getReportedAt", "getReportedBy", "getResolvedAt", "getResolvedBy", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/retroachivements/api/data/pojo/ticket/GetTicketData$Response;", "equals", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

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

        public static /* synthetic */ Response copy$default(Response response, long j, long j2, String str, String str2, String str3, long j3, String str4, String str5, long j4, String str6, String str7, String str8, String str9, int i, int i2, Boolean bool, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i3, Object obj) {
            String str17;
            String str18;
            long j5 = (i3 & 1) != 0 ? response.id : j;
            long j6 = (i3 & 2) != 0 ? response.achievementId : j2;
            String str19 = (i3 & 4) != 0 ? response.achievementType : str;
            String str20 = (i3 & 8) != 0 ? response.achievementTitle : str2;
            String str21 = (i3 & 16) != 0 ? response.achievementDesc : str3;
            long j7 = (i3 & 32) != 0 ? response.points : j3;
            String str22 = (i3 & 64) != 0 ? response.badgeName : str4;
            String str23 = (i3 & 128) != 0 ? response.achievementAuthor : str5;
            long j8 = (i3 & 256) != 0 ? response.gameId : j4;
            String str24 = (i3 & 512) != 0 ? response.consoleName : str6;
            long j9 = j5;
            String str25 = (i3 & 1024) != 0 ? response.gameTitle : str7;
            String str26 = (i3 & 2048) != 0 ? response.gameIcon : str8;
            String str27 = str25;
            String str28 = (i3 & 4096) != 0 ? response.reportedAt : str9;
            int i4 = (i3 & 8192) != 0 ? response.reportType : i;
            int i5 = (i3 & 16384) != 0 ? response.reportState : i2;
            Boolean bool2 = (i3 & 32768) != 0 ? response.hardcore : bool;
            String str29 = (i3 & 65536) != 0 ? response.reportNotes : str10;
            String str30 = (i3 & 131072) != 0 ? response.reportedBy : str11;
            String str31 = (i3 & 262144) != 0 ? response.resolvedAt : str12;
            String str32 = (i3 & 524288) != 0 ? response.resolvedBy : str13;
            String str33 = (i3 & 1048576) != 0 ? response.reportStateDescription : str14;
            String str34 = (i3 & 2097152) != 0 ? response.reportTypeDescription : str15;
            if ((i3 & 4194304) != 0) {
                str18 = str34;
                str17 = response.url;
            } else {
                str17 = str16;
                str18 = str34;
            }
            return response.copy(j9, j6, str19, str20, str21, j7, str22, str23, j8, str24, str27, str26, str28, i4, i5, bool2, str29, str30, str31, str32, str33, str18, str17);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getConsoleName() {
            return this.consoleName;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getGameTitle() {
            return this.gameTitle;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getGameIcon() {
            return this.gameIcon;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getReportedAt() {
            return this.reportedAt;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final int getReportType() {
            return this.reportType;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final int getReportState() {
            return this.reportState;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Boolean getHardcore() {
            return this.hardcore;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getReportNotes() {
            return this.reportNotes;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getReportedBy() {
            return this.reportedBy;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getResolvedAt() {
            return this.resolvedAt;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getAchievementId() {
            return this.achievementId;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getResolvedBy() {
            return this.resolvedBy;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final String getReportStateDescription() {
            return this.reportStateDescription;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getReportTypeDescription() {
            return this.reportTypeDescription;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAchievementType() {
            return this.achievementType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAchievementTitle() {
            return this.achievementTitle;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAchievementDesc() {
            return this.achievementDesc;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getPoints() {
            return this.points;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getBadgeName() {
            return this.badgeName;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getAchievementAuthor() {
            return this.achievementAuthor;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final long getGameId() {
            return this.gameId;
        }

        public final Response copy(long id2, long achievementId, String achievementType, String achievementTitle, String achievementDesc, long points, String badgeName, String achievementAuthor, long gameId, String consoleName, String gameTitle, String gameIcon, String reportedAt, int reportType, int reportState, Boolean hardcore, String reportNotes, String reportedBy, String resolvedAt, String resolvedBy, String reportStateDescription, String reportTypeDescription, String url) {
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
            return new Response(id2, achievementId, achievementType, achievementTitle, achievementDesc, points, badgeName, achievementAuthor, gameId, consoleName, gameTitle, gameIcon, reportedAt, reportType, reportState, hardcore, reportNotes, reportedBy, resolvedAt, resolvedBy, reportStateDescription, reportTypeDescription, url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.id == response.id && this.achievementId == response.achievementId && Intrinsics.areEqual(this.achievementType, response.achievementType) && Intrinsics.areEqual(this.achievementTitle, response.achievementTitle) && Intrinsics.areEqual(this.achievementDesc, response.achievementDesc) && this.points == response.points && Intrinsics.areEqual(this.badgeName, response.badgeName) && Intrinsics.areEqual(this.achievementAuthor, response.achievementAuthor) && this.gameId == response.gameId && Intrinsics.areEqual(this.consoleName, response.consoleName) && Intrinsics.areEqual(this.gameTitle, response.gameTitle) && Intrinsics.areEqual(this.gameIcon, response.gameIcon) && Intrinsics.areEqual(this.reportedAt, response.reportedAt) && this.reportType == response.reportType && this.reportState == response.reportState && Intrinsics.areEqual(this.hardcore, response.hardcore) && Intrinsics.areEqual(this.reportNotes, response.reportNotes) && Intrinsics.areEqual(this.reportedBy, response.reportedBy) && Intrinsics.areEqual(this.resolvedAt, response.resolvedAt) && Intrinsics.areEqual(this.resolvedBy, response.resolvedBy) && Intrinsics.areEqual(this.reportStateDescription, response.reportStateDescription) && Intrinsics.areEqual(this.reportTypeDescription, response.reportTypeDescription) && Intrinsics.areEqual(this.url, response.url);
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
            StringBuilder sb = new StringBuilder("Response(id=");
            sb.append(this.id).append(", achievementId=").append(this.achievementId).append(", achievementType=").append(this.achievementType).append(", achievementTitle=").append(this.achievementTitle).append(", achievementDesc=").append(this.achievementDesc).append(", points=").append(this.points).append(", badgeName=").append(this.badgeName).append(", achievementAuthor=").append(this.achievementAuthor).append(", gameId=").append(this.gameId).append(", consoleName=").append(this.consoleName).append(", gameTitle=").append(this.gameTitle).append(", gameIcon=");
            sb.append(this.gameIcon).append(", reportedAt=").append(this.reportedAt).append(", reportType=").append(this.reportType).append(", reportState=").append(this.reportState).append(", hardcore=").append(this.hardcore).append(", reportNotes=").append(this.reportNotes).append(", reportedBy=").append(this.reportedBy).append(", resolvedAt=").append(this.resolvedAt).append(", resolvedBy=").append(this.resolvedBy).append(", reportStateDescription=").append(this.reportStateDescription).append(", reportTypeDescription=").append(this.reportTypeDescription).append(", url=").append(this.url);
            sb.append(')');
            return sb.toString();
        }

        public Response(long j, long j2, String str, String achievementTitle, String achievementDesc, long j3, String badgeName, String achievementAuthor, long j4, String consoleName, String gameTitle, String gameIcon, String reportedAt, int i, int i2, Boolean bool, String reportNotes, String reportedBy, String str2, String str3, String reportStateDescription, String reportTypeDescription, String str4) {
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
