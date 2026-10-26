package org.retroachivements.api.data.pojo.ticket;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: GetAchievementTicketStats.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetAchievementTicketStats;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetAchievementTicketStats {

    /* INFO: compiled from: GetAchievementTicketStats.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lorg/retroachivements/api/data/pojo/ticket/GetAchievementTicketStats$Response;", "", "achievementId", "", "achievementTitle", "", "achievementDescription", "url", "openTickets", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAchievementDescription", "()Ljava/lang/String;", "getAchievementId", "()J", "getAchievementTitle", "getOpenTickets", "getUrl", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("AchievementDescription")
        private final String achievementDescription;

        @SerializedName("AchievementID")
        private final long achievementId;

        @SerializedName("AchievementTitle")
        private final String achievementTitle;

        @SerializedName("OpenTickets")
        private final long openTickets;

        @SerializedName("URL")
        private final String url;

        public static /* synthetic */ Response copy$default(Response response, long j, String str, String str2, String str3, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = response.achievementId;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                str = response.achievementTitle;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = response.achievementDescription;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = response.url;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                j2 = response.openTickets;
            }
            return response.copy(j3, str4, str5, str6, j2);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final long getAchievementId() {
            return this.achievementId;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getAchievementTitle() {
            return this.achievementTitle;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getAchievementDescription() {
            return this.achievementDescription;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final long getOpenTickets() {
            return this.openTickets;
        }

        public final Response copy(long achievementId, String achievementTitle, String achievementDescription, String url, long openTickets) {
            Intrinsics.checkNotNullParameter(achievementTitle, "achievementTitle");
            Intrinsics.checkNotNullParameter(achievementDescription, "achievementDescription");
            Intrinsics.checkNotNullParameter(url, "url");
            return new Response(achievementId, achievementTitle, achievementDescription, url, openTickets);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.achievementId == response.achievementId && Intrinsics.areEqual(this.achievementTitle, response.achievementTitle) && Intrinsics.areEqual(this.achievementDescription, response.achievementDescription) && Intrinsics.areEqual(this.url, response.url) && this.openTickets == response.openTickets;
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.achievementId) * 31) + this.achievementTitle.hashCode()) * 31) + this.achievementDescription.hashCode()) * 31) + this.url.hashCode()) * 31) + Long.hashCode(this.openTickets);
        }

        public String toString() {
            return "Response(achievementId=" + this.achievementId + ", achievementTitle=" + this.achievementTitle + ", achievementDescription=" + this.achievementDescription + ", url=" + this.url + ", openTickets=" + this.openTickets + ')';
        }

        public Response(long j, String achievementTitle, String achievementDescription, String url, long j2) {
            Intrinsics.checkNotNullParameter(achievementTitle, "achievementTitle");
            Intrinsics.checkNotNullParameter(achievementDescription, "achievementDescription");
            Intrinsics.checkNotNullParameter(url, "url");
            this.achievementId = j;
            this.achievementTitle = achievementTitle;
            this.achievementDescription = achievementDescription;
            this.url = url;
            this.openTickets = j2;
        }

        public final long getAchievementId() {
            return this.achievementId;
        }

        public final String getAchievementTitle() {
            return this.achievementTitle;
        }

        public final String getAchievementDescription() {
            return this.achievementDescription;
        }

        public final String getUrl() {
            return this.url;
        }

        public final long getOpenTickets() {
            return this.openTickets;
        }
    }
}
