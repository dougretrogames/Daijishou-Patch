package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* INFO: compiled from: GetUserProfile.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserProfile;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserProfile {

    /* INFO: compiled from: GetUserProfile.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\u0011HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\u0011HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003Jª\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u00112\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\nHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0012\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0016\u0010\u0013\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'¨\u0006@"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserProfile$Response;", "", ConfigConstants.CONFIG_USER_SECTION, "", "userPic", "memberSince", "richPresenceMsg", "lastGameID", "", "contribYield", "", "contribCount", "totalPoints", "totalSoftcorePoints", "totalTruePoints", "permissions", "untracked", "", "id", "userWallActive", "motto", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IIIIJIZJZLjava/lang/String;)V", "getContribCount", "()I", "getContribYield", "getId", "()J", "getLastGameID", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMemberSince", "()Ljava/lang/String;", "getMotto", "getPermissions", "getRichPresenceMsg", "getTotalPoints", "getTotalSoftcorePoints", "getTotalTruePoints", "getUntracked", "()Z", "getUser", "getUserPic", "getUserWallActive", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IIIIJIZJZLjava/lang/String;)Lorg/retroachivements/api/data/pojo/user/GetUserProfile$Response;", "equals", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("ContribCount")
        private final int contribCount;

        @SerializedName("ContribYield")
        private final int contribYield;

        @SerializedName("ID")
        private final long id;

        @SerializedName("LastGameID")
        private final Long lastGameID;

        @SerializedName("MemberSince")
        private final String memberSince;

        @SerializedName("Motto")
        private final String motto;

        @SerializedName("Permissions")
        private final int permissions;

        @SerializedName("RichPresenceMsg")
        private final String richPresenceMsg;

        @SerializedName("TotalPoints")
        private final int totalPoints;

        @SerializedName("TotalSoftcorePoints")
        private final int totalSoftcorePoints;

        @SerializedName("TotalTruePoints")
        private final long totalTruePoints;

        @SerializedName("Untracked")
        @JsonAdapter(BooleanJsonDeserializer.class)
        private final boolean untracked;

        @SerializedName(SshConstants.USER)
        private final String user;

        @SerializedName("UserPic")
        private final String userPic;

        @SerializedName("UserWallActive")
        @JsonAdapter(BooleanJsonDeserializer.class)
        private final boolean userWallActive;

        public static /* synthetic */ Response copy$default(Response response, String str, String str2, String str3, String str4, Long l, int i, int i2, int i3, int i4, long j, int i5, boolean z, long j2, boolean z2, String str5, int i6, Object obj) {
            String str6 = (i6 & 1) != 0 ? response.user : str;
            String str7 = (i6 & 2) != 0 ? response.userPic : str2;
            return response.copy(str6, str7, (i6 & 4) != 0 ? response.memberSince : str3, (i6 & 8) != 0 ? response.richPresenceMsg : str4, (i6 & 16) != 0 ? response.lastGameID : l, (i6 & 32) != 0 ? response.contribYield : i, (i6 & 64) != 0 ? response.contribCount : i2, (i6 & 128) != 0 ? response.totalPoints : i3, (i6 & 256) != 0 ? response.totalSoftcorePoints : i4, (i6 & 512) != 0 ? response.totalTruePoints : j, (i6 & 1024) != 0 ? response.permissions : i5, (i6 & 2048) != 0 ? response.untracked : z, (i6 & 4096) != 0 ? response.id : j2, (i6 & 8192) != 0 ? response.userWallActive : z2, (i6 & 16384) != 0 ? response.motto : str5);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final String getUser() {
            return this.user;
        }

        /* INFO: renamed from: component10, reason: from getter */
        public final long getTotalTruePoints() {
            return this.totalTruePoints;
        }

        /* INFO: renamed from: component11, reason: from getter */
        public final int getPermissions() {
            return this.permissions;
        }

        /* INFO: renamed from: component12, reason: from getter */
        public final boolean getUntracked() {
            return this.untracked;
        }

        /* INFO: renamed from: component13, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* INFO: renamed from: component14, reason: from getter */
        public final boolean getUserWallActive() {
            return this.userWallActive;
        }

        /* INFO: renamed from: component15, reason: from getter */
        public final String getMotto() {
            return this.motto;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getUserPic() {
            return this.userPic;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getMemberSince() {
            return this.memberSince;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final String getRichPresenceMsg() {
            return this.richPresenceMsg;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final Long getLastGameID() {
            return this.lastGameID;
        }

        /* INFO: renamed from: component6, reason: from getter */
        public final int getContribYield() {
            return this.contribYield;
        }

        /* INFO: renamed from: component7, reason: from getter */
        public final int getContribCount() {
            return this.contribCount;
        }

        /* INFO: renamed from: component8, reason: from getter */
        public final int getTotalPoints() {
            return this.totalPoints;
        }

        /* INFO: renamed from: component9, reason: from getter */
        public final int getTotalSoftcorePoints() {
            return this.totalSoftcorePoints;
        }

        public final Response copy(String user, String userPic, String memberSince, String richPresenceMsg, Long lastGameID, int contribYield, int contribCount, int totalPoints, int totalSoftcorePoints, long totalTruePoints, int permissions, boolean untracked, long id2, boolean userWallActive, String motto) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(userPic, "userPic");
            Intrinsics.checkNotNullParameter(memberSince, "memberSince");
            return new Response(user, userPic, memberSince, richPresenceMsg, lastGameID, contribYield, contribCount, totalPoints, totalSoftcorePoints, totalTruePoints, permissions, untracked, id2, userWallActive, motto);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return Intrinsics.areEqual(this.user, response.user) && Intrinsics.areEqual(this.userPic, response.userPic) && Intrinsics.areEqual(this.memberSince, response.memberSince) && Intrinsics.areEqual(this.richPresenceMsg, response.richPresenceMsg) && Intrinsics.areEqual(this.lastGameID, response.lastGameID) && this.contribYield == response.contribYield && this.contribCount == response.contribCount && this.totalPoints == response.totalPoints && this.totalSoftcorePoints == response.totalSoftcorePoints && this.totalTruePoints == response.totalTruePoints && this.permissions == response.permissions && this.untracked == response.untracked && this.id == response.id && this.userWallActive == response.userWallActive && Intrinsics.areEqual(this.motto, response.motto);
        }

        public int hashCode() {
            int iHashCode = ((((this.user.hashCode() * 31) + this.userPic.hashCode()) * 31) + this.memberSince.hashCode()) * 31;
            String str = this.richPresenceMsg;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.lastGameID;
            int iHashCode3 = (((((((((((((((((((iHashCode2 + (l == null ? 0 : l.hashCode())) * 31) + Integer.hashCode(this.contribYield)) * 31) + Integer.hashCode(this.contribCount)) * 31) + Integer.hashCode(this.totalPoints)) * 31) + Integer.hashCode(this.totalSoftcorePoints)) * 31) + Long.hashCode(this.totalTruePoints)) * 31) + Integer.hashCode(this.permissions)) * 31) + Boolean.hashCode(this.untracked)) * 31) + Long.hashCode(this.id)) * 31) + Boolean.hashCode(this.userWallActive)) * 31;
            String str2 = this.motto;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Response(user=");
            sb.append(this.user).append(", userPic=").append(this.userPic).append(", memberSince=").append(this.memberSince).append(", richPresenceMsg=").append(this.richPresenceMsg).append(", lastGameID=").append(this.lastGameID).append(", contribYield=").append(this.contribYield).append(", contribCount=").append(this.contribCount).append(", totalPoints=").append(this.totalPoints).append(", totalSoftcorePoints=").append(this.totalSoftcorePoints).append(", totalTruePoints=").append(this.totalTruePoints).append(", permissions=").append(this.permissions).append(", untracked=");
            sb.append(this.untracked).append(", id=").append(this.id).append(", userWallActive=").append(this.userWallActive).append(", motto=").append(this.motto).append(')');
            return sb.toString();
        }

        public Response(String user, String userPic, String memberSince, String str, Long l, int i, int i2, int i3, int i4, long j, int i5, boolean z, long j2, boolean z2, String str2) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(userPic, "userPic");
            Intrinsics.checkNotNullParameter(memberSince, "memberSince");
            this.user = user;
            this.userPic = userPic;
            this.memberSince = memberSince;
            this.richPresenceMsg = str;
            this.lastGameID = l;
            this.contribYield = i;
            this.contribCount = i2;
            this.totalPoints = i3;
            this.totalSoftcorePoints = i4;
            this.totalTruePoints = j;
            this.permissions = i5;
            this.untracked = z;
            this.id = j2;
            this.userWallActive = z2;
            this.motto = str2;
        }

        public final String getUser() {
            return this.user;
        }

        public final String getUserPic() {
            return this.userPic;
        }

        public final String getMemberSince() {
            return this.memberSince;
        }

        public final String getRichPresenceMsg() {
            return this.richPresenceMsg;
        }

        public final Long getLastGameID() {
            return this.lastGameID;
        }

        public final int getContribYield() {
            return this.contribYield;
        }

        public final int getContribCount() {
            return this.contribCount;
        }

        public final int getTotalPoints() {
            return this.totalPoints;
        }

        public final int getTotalSoftcorePoints() {
            return this.totalSoftcorePoints;
        }

        public final long getTotalTruePoints() {
            return this.totalTruePoints;
        }

        public final int getPermissions() {
            return this.permissions;
        }

        public final boolean getUntracked() {
            return this.untracked;
        }

        public final long getId() {
            return this.id;
        }

        public final boolean getUserWallActive() {
            return this.userWallActive;
        }

        public final String getMotto() {
            return this.motto;
        }
    }
}
