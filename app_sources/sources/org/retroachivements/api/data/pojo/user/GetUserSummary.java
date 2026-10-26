package org.retroachivements.api.data.pojo.user;

import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* INFO: compiled from: GetUserSummary.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserSummary;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserSummary {

    /* INFO: compiled from: GetUserSummary.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bO\b\u0086\b\u0018\u00002\u00020\u0001:\u0005nopqrBÓ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!`\"\u0012J\u0010#\u001aF\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0 0 j*\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$`\"`\"\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\u0006\u0010)\u001a\u00020\u0003¢\u0006\u0002\u0010*J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0018HÆ\u0003J\t\u0010U\u001a\u00020\u0018HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u001cHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J%\u0010[\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!`\"HÆ\u0003JM\u0010\\\u001aF\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0 0 j*\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$`\"`\"HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\u0019\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\fHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\t\u0010h\u001a\u00020\u0011HÆ\u0003J\u008d\u0003\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00052$\b\u0002\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!`\"2L\b\u0002\u0010#\u001aF\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0 0 j*\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$`\"`\"2\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u0003HÆ\u0001J\u0013\u0010j\u001a\u00020\u001c2\b\u0010k\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010l\u001a\u00020\u0018HÖ\u0001J\t\u0010m\u001a\u00020\u0003HÖ\u0001R2\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!`\"8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0016\u0010\u001a\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R\u0016\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010.RZ\u0010#\u001aF\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0 0 j*\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0 j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$`\"`\"8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010,R&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00107R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u00107R\u0016\u0010&\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010.R\u0016\u0010)\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u00107R\u0016\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010.R\u0016\u0010(\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0016\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010.R\u0016\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010.R\u0016\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010:R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u00107R\u0016\u0010'\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00107R\u0016\u0010\u001b\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010M¨\u0006s"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response;", "", ConfigConstants.CONFIG_USER_SECTION, "", "recentlyPlayedCount", "", "recentlyPlayed", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$RecentGame;", "Lkotlin/collections/ArrayList;", "memberSince", "lastActivity", "Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$Activity;", "richPresenceMsg", "richPresenceMsgDate", "lastGameId", "lastGame", "Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$LastGame;", "contribCount", "contribYield", "totalPoints", "totalSoftcorePoints", "totalTruePoints", "permissions", "", "untracked", "id", "userWallActive", "", "motto", "rank", "awarded", "Ljava/util/HashMap;", "Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$Award;", "Lkotlin/collections/HashMap;", "recentAchievements", "Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$Achievement;", "points", "softcorePoints", "userPic", "totalRanked", NotificationCompat.CATEGORY_STATUS, "(Ljava/lang/String;JLjava/util/ArrayList;Ljava/lang/String;Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$Activity;Ljava/lang/String;Ljava/lang/String;JLorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$LastGame;JJJJJIIJZLjava/lang/String;JLjava/util/HashMap;Ljava/util/HashMap;JJLjava/lang/String;JLjava/lang/String;)V", "getAwarded", "()Ljava/util/HashMap;", "getContribCount", "()J", "getContribYield", "getId", "getLastActivity", "()Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$Activity;", "getLastGame", "()Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$LastGame;", "getLastGameId", "getMemberSince", "()Ljava/lang/String;", "getMotto", "getPermissions", "()I", "getPoints", "getRank", "getRecentAchievements", "getRecentlyPlayed", "()Ljava/util/ArrayList;", "getRecentlyPlayedCount", "getRichPresenceMsg", "getRichPresenceMsgDate", "getSoftcorePoints", "getStatus", "getTotalPoints", "getTotalRanked", "getTotalSoftcorePoints", "getTotalTruePoints", "getUntracked", "getUser", "getUserPic", "getUserWallActive", "()Z", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "Achievement", "Activity", "Award", "LastGame", "RecentGame", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Awarded")
        private final HashMap<String, Award> awarded;

        @SerializedName("ContribCount")
        private final long contribCount;

        @SerializedName("ContribYield")
        private final long contribYield;

        @SerializedName("ID")
        private final long id;

        @SerializedName("LastActivity")
        private final Activity lastActivity;

        @SerializedName("LastGame")
        private final LastGame lastGame;

        @SerializedName("LastGameID")
        private final long lastGameId;

        @SerializedName("MemberSince")
        private final String memberSince;

        @SerializedName("Motto")
        private final String motto;

        @SerializedName("Permissions")
        private final int permissions;

        @SerializedName("Points")
        private final long points;

        @SerializedName("Rank")
        private final long rank;

        @SerializedName("RecentAchievements")
        private final HashMap<String, HashMap<String, Achievement>> recentAchievements;

        @SerializedName("RecentlyPlayed")
        private final ArrayList<RecentGame> recentlyPlayed;

        @SerializedName("RecentlyPlayedCount")
        private final long recentlyPlayedCount;

        @SerializedName("RichPresenceMsg")
        private final String richPresenceMsg;

        @SerializedName("RichPresenceMsgDate")
        private final String richPresenceMsgDate;

        @SerializedName("SoftcorePoints")
        private final long softcorePoints;

        @SerializedName("Status")
        private final String status;

        @SerializedName("TotalPoints")
        private final long totalPoints;

        @SerializedName("TotalRanked")
        private final long totalRanked;

        @SerializedName("TotalSoftcorePoints")
        private final long totalSoftcorePoints;

        @SerializedName("TotalTruePoints")
        private final long totalTruePoints;

        @SerializedName("Untracked")
        private final int untracked;

        @SerializedName(SshConstants.USER)
        private final String user;

        @SerializedName("UserPic")
        private final String userPic;

        @SerializedName("UserWallActive")
        @JsonAdapter(BooleanJsonDeserializer.class)
        private final boolean userWallActive;

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, String str, long j, ArrayList arrayList, String str2, Activity activity, String str3, String str4, long j2, LastGame lastGame, long j3, long j4, long j5, long j6, long j7, int i, int i2, long j8, boolean z, String str5, long j9, HashMap map, HashMap map2, long j10, long j11, String str6, long j12, String str7, int i3, Object obj) {
            String str8;
            long j13;
            String str9 = (i3 & 1) != 0 ? response.user : str;
            long j14 = (i3 & 2) != 0 ? response.recentlyPlayedCount : j;
            ArrayList arrayList2 = (i3 & 4) != 0 ? response.recentlyPlayed : arrayList;
            String str10 = (i3 & 8) != 0 ? response.memberSince : str2;
            Activity activity2 = (i3 & 16) != 0 ? response.lastActivity : activity;
            String str11 = (i3 & 32) != 0 ? response.richPresenceMsg : str3;
            String str12 = (i3 & 64) != 0 ? response.richPresenceMsgDate : str4;
            long j15 = (i3 & 128) != 0 ? response.lastGameId : j2;
            LastGame lastGame2 = (i3 & 256) != 0 ? response.lastGame : lastGame;
            long j16 = (i3 & 512) != 0 ? response.contribCount : j3;
            String str13 = str9;
            long j17 = (i3 & 1024) != 0 ? response.contribYield : j4;
            long j18 = (i3 & 2048) != 0 ? response.totalPoints : j5;
            long j19 = (i3 & 4096) != 0 ? response.totalSoftcorePoints : j6;
            long j20 = (i3 & 8192) != 0 ? response.totalTruePoints : j7;
            int i4 = (i3 & 16384) != 0 ? response.permissions : i;
            int i5 = (i3 & 32768) != 0 ? response.untracked : i2;
            long j21 = j20;
            long j22 = (i3 & 65536) != 0 ? response.id : j8;
            boolean z2 = (i3 & 131072) != 0 ? response.userWallActive : z;
            long j23 = j22;
            String str14 = (i3 & 262144) != 0 ? response.motto : str5;
            long j24 = (i3 & 524288) != 0 ? response.rank : j9;
            HashMap map3 = (i3 & 1048576) != 0 ? response.awarded : map;
            HashMap map4 = (i3 & 2097152) != 0 ? response.recentAchievements : map2;
            long j25 = (i3 & 4194304) != 0 ? response.points : j10;
            long j26 = (i3 & 8388608) != 0 ? response.softcorePoints : j11;
            String str15 = (i3 & 16777216) != 0 ? response.userPic : str6;
            long j27 = (i3 & MediaHttpDownloader.MAXIMUM_CHUNK_SIZE) != 0 ? response.totalRanked : j12;
            if ((i3 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0) {
                j13 = j27;
                str8 = response.status;
            } else {
                str8 = str7;
                j13 = j27;
            }
            return response.copy(str13, j14, arrayList2, str10, activity2, str11, str12, j15, lastGame2, j16, j17, j18, j19, j21, i4, i5, j23, z2, str14, j24, map3, map4, j25, j26, str15, j13, str8);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final String getUser() {
            return this.user;
        }

        /* INFO: renamed from: component10, reason: from getter */
        public final long getContribCount() {
            return this.contribCount;
        }

        /* INFO: renamed from: component11, reason: from getter */
        public final long getContribYield() {
            return this.contribYield;
        }

        /* INFO: renamed from: component12, reason: from getter */
        public final long getTotalPoints() {
            return this.totalPoints;
        }

        /* INFO: renamed from: component13, reason: from getter */
        public final long getTotalSoftcorePoints() {
            return this.totalSoftcorePoints;
        }

        /* INFO: renamed from: component14, reason: from getter */
        public final long getTotalTruePoints() {
            return this.totalTruePoints;
        }

        /* INFO: renamed from: component15, reason: from getter */
        public final int getPermissions() {
            return this.permissions;
        }

        /* INFO: renamed from: component16, reason: from getter */
        public final int getUntracked() {
            return this.untracked;
        }

        /* INFO: renamed from: component17, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* INFO: renamed from: component18, reason: from getter */
        public final boolean getUserWallActive() {
            return this.userWallActive;
        }

        /* INFO: renamed from: component19, reason: from getter */
        public final String getMotto() {
            return this.motto;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final long getRecentlyPlayedCount() {
            return this.recentlyPlayedCount;
        }

        /* INFO: renamed from: component20, reason: from getter */
        public final long getRank() {
            return this.rank;
        }

        public final HashMap<String, Award> component21() {
            return this.awarded;
        }

        public final HashMap<String, HashMap<String, Achievement>> component22() {
            return this.recentAchievements;
        }

        /* INFO: renamed from: component23, reason: from getter */
        public final long getPoints() {
            return this.points;
        }

        /* INFO: renamed from: component24, reason: from getter */
        public final long getSoftcorePoints() {
            return this.softcorePoints;
        }

        /* INFO: renamed from: component25, reason: from getter */
        public final String getUserPic() {
            return this.userPic;
        }

        /* INFO: renamed from: component26, reason: from getter */
        public final long getTotalRanked() {
            return this.totalRanked;
        }

        /* INFO: renamed from: component27, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        public final ArrayList<RecentGame> component3() {
            return this.recentlyPlayed;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final String getMemberSince() {
            return this.memberSince;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final Activity getLastActivity() {
            return this.lastActivity;
        }

        /* INFO: renamed from: component6, reason: from getter */
        public final String getRichPresenceMsg() {
            return this.richPresenceMsg;
        }

        /* INFO: renamed from: component7, reason: from getter */
        public final String getRichPresenceMsgDate() {
            return this.richPresenceMsgDate;
        }

        /* INFO: renamed from: component8, reason: from getter */
        public final long getLastGameId() {
            return this.lastGameId;
        }

        /* INFO: renamed from: component9, reason: from getter */
        public final LastGame getLastGame() {
            return this.lastGame;
        }

        public final Response copy(String user, long recentlyPlayedCount, ArrayList<RecentGame> recentlyPlayed, String memberSince, Activity lastActivity, String richPresenceMsg, String richPresenceMsgDate, long lastGameId, LastGame lastGame, long contribCount, long contribYield, long totalPoints, long totalSoftcorePoints, long totalTruePoints, int permissions, int untracked, long id2, boolean userWallActive, String motto, long rank, HashMap<String, Award> awarded, HashMap<String, HashMap<String, Achievement>> recentAchievements, long points, long softcorePoints, String userPic, long totalRanked, String status) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(recentlyPlayed, "recentlyPlayed");
            Intrinsics.checkNotNullParameter(memberSince, "memberSince");
            Intrinsics.checkNotNullParameter(lastActivity, "lastActivity");
            Intrinsics.checkNotNullParameter(lastGame, "lastGame");
            Intrinsics.checkNotNullParameter(awarded, "awarded");
            Intrinsics.checkNotNullParameter(recentAchievements, "recentAchievements");
            Intrinsics.checkNotNullParameter(userPic, "userPic");
            Intrinsics.checkNotNullParameter(status, "status");
            return new Response(user, recentlyPlayedCount, recentlyPlayed, memberSince, lastActivity, richPresenceMsg, richPresenceMsgDate, lastGameId, lastGame, contribCount, contribYield, totalPoints, totalSoftcorePoints, totalTruePoints, permissions, untracked, id2, userWallActive, motto, rank, awarded, recentAchievements, points, softcorePoints, userPic, totalRanked, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return Intrinsics.areEqual(this.user, response.user) && this.recentlyPlayedCount == response.recentlyPlayedCount && Intrinsics.areEqual(this.recentlyPlayed, response.recentlyPlayed) && Intrinsics.areEqual(this.memberSince, response.memberSince) && Intrinsics.areEqual(this.lastActivity, response.lastActivity) && Intrinsics.areEqual(this.richPresenceMsg, response.richPresenceMsg) && Intrinsics.areEqual(this.richPresenceMsgDate, response.richPresenceMsgDate) && this.lastGameId == response.lastGameId && Intrinsics.areEqual(this.lastGame, response.lastGame) && this.contribCount == response.contribCount && this.contribYield == response.contribYield && this.totalPoints == response.totalPoints && this.totalSoftcorePoints == response.totalSoftcorePoints && this.totalTruePoints == response.totalTruePoints && this.permissions == response.permissions && this.untracked == response.untracked && this.id == response.id && this.userWallActive == response.userWallActive && Intrinsics.areEqual(this.motto, response.motto) && this.rank == response.rank && Intrinsics.areEqual(this.awarded, response.awarded) && Intrinsics.areEqual(this.recentAchievements, response.recentAchievements) && this.points == response.points && this.softcorePoints == response.softcorePoints && Intrinsics.areEqual(this.userPic, response.userPic) && this.totalRanked == response.totalRanked && Intrinsics.areEqual(this.status, response.status);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.user.hashCode() * 31) + Long.hashCode(this.recentlyPlayedCount)) * 31) + this.recentlyPlayed.hashCode()) * 31) + this.memberSince.hashCode()) * 31) + this.lastActivity.hashCode()) * 31;
            String str = this.richPresenceMsg;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.richPresenceMsgDate;
            int iHashCode3 = (((((((((((((((((((((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Long.hashCode(this.lastGameId)) * 31) + this.lastGame.hashCode()) * 31) + Long.hashCode(this.contribCount)) * 31) + Long.hashCode(this.contribYield)) * 31) + Long.hashCode(this.totalPoints)) * 31) + Long.hashCode(this.totalSoftcorePoints)) * 31) + Long.hashCode(this.totalTruePoints)) * 31) + Integer.hashCode(this.permissions)) * 31) + Integer.hashCode(this.untracked)) * 31) + Long.hashCode(this.id)) * 31) + Boolean.hashCode(this.userWallActive)) * 31;
            String str3 = this.motto;
            return ((((((((((((((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Long.hashCode(this.rank)) * 31) + this.awarded.hashCode()) * 31) + this.recentAchievements.hashCode()) * 31) + Long.hashCode(this.points)) * 31) + Long.hashCode(this.softcorePoints)) * 31) + this.userPic.hashCode()) * 31) + Long.hashCode(this.totalRanked)) * 31) + this.status.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Response(user=");
            sb.append(this.user).append(", recentlyPlayedCount=").append(this.recentlyPlayedCount).append(", recentlyPlayed=").append(this.recentlyPlayed).append(", memberSince=").append(this.memberSince).append(", lastActivity=").append(this.lastActivity).append(", richPresenceMsg=").append(this.richPresenceMsg).append(", richPresenceMsgDate=").append(this.richPresenceMsgDate).append(", lastGameId=").append(this.lastGameId).append(", lastGame=").append(this.lastGame).append(", contribCount=").append(this.contribCount).append(", contribYield=").append(this.contribYield).append(", totalPoints=");
            sb.append(this.totalPoints).append(", totalSoftcorePoints=").append(this.totalSoftcorePoints).append(", totalTruePoints=").append(this.totalTruePoints).append(", permissions=").append(this.permissions).append(", untracked=").append(this.untracked).append(", id=").append(this.id).append(", userWallActive=").append(this.userWallActive).append(", motto=").append(this.motto).append(", rank=").append(this.rank).append(", awarded=").append(this.awarded).append(", recentAchievements=").append(this.recentAchievements).append(", points=").append(this.points);
            sb.append(", softcorePoints=").append(this.softcorePoints).append(", userPic=").append(this.userPic).append(", totalRanked=").append(this.totalRanked).append(", status=").append(this.status).append(')');
            return sb.toString();
        }

        public Response(String user, long j, ArrayList<RecentGame> recentlyPlayed, String memberSince, Activity lastActivity, String str, String str2, long j2, LastGame lastGame, long j3, long j4, long j5, long j6, long j7, int i, int i2, long j8, boolean z, String str3, long j9, HashMap<String, Award> awarded, HashMap<String, HashMap<String, Achievement>> recentAchievements, long j10, long j11, String userPic, long j12, String status) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(recentlyPlayed, "recentlyPlayed");
            Intrinsics.checkNotNullParameter(memberSince, "memberSince");
            Intrinsics.checkNotNullParameter(lastActivity, "lastActivity");
            Intrinsics.checkNotNullParameter(lastGame, "lastGame");
            Intrinsics.checkNotNullParameter(awarded, "awarded");
            Intrinsics.checkNotNullParameter(recentAchievements, "recentAchievements");
            Intrinsics.checkNotNullParameter(userPic, "userPic");
            Intrinsics.checkNotNullParameter(status, "status");
            this.user = user;
            this.recentlyPlayedCount = j;
            this.recentlyPlayed = recentlyPlayed;
            this.memberSince = memberSince;
            this.lastActivity = lastActivity;
            this.richPresenceMsg = str;
            this.richPresenceMsgDate = str2;
            this.lastGameId = j2;
            this.lastGame = lastGame;
            this.contribCount = j3;
            this.contribYield = j4;
            this.totalPoints = j5;
            this.totalSoftcorePoints = j6;
            this.totalTruePoints = j7;
            this.permissions = i;
            this.untracked = i2;
            this.id = j8;
            this.userWallActive = z;
            this.motto = str3;
            this.rank = j9;
            this.awarded = awarded;
            this.recentAchievements = recentAchievements;
            this.points = j10;
            this.softcorePoints = j11;
            this.userPic = userPic;
            this.totalRanked = j12;
            this.status = status;
        }

        public final String getUser() {
            return this.user;
        }

        public final long getRecentlyPlayedCount() {
            return this.recentlyPlayedCount;
        }

        public final ArrayList<RecentGame> getRecentlyPlayed() {
            return this.recentlyPlayed;
        }

        public final String getMemberSince() {
            return this.memberSince;
        }

        public final Activity getLastActivity() {
            return this.lastActivity;
        }

        public final String getRichPresenceMsg() {
            return this.richPresenceMsg;
        }

        public final String getRichPresenceMsgDate() {
            return this.richPresenceMsgDate;
        }

        public final long getLastGameId() {
            return this.lastGameId;
        }

        public final LastGame getLastGame() {
            return this.lastGame;
        }

        public final long getContribCount() {
            return this.contribCount;
        }

        public final long getContribYield() {
            return this.contribYield;
        }

        public final long getTotalPoints() {
            return this.totalPoints;
        }

        public final long getTotalSoftcorePoints() {
            return this.totalSoftcorePoints;
        }

        public final long getTotalTruePoints() {
            return this.totalTruePoints;
        }

        public final int getPermissions() {
            return this.permissions;
        }

        public final int getUntracked() {
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

        public final long getRank() {
            return this.rank;
        }

        public final HashMap<String, Award> getAwarded() {
            return this.awarded;
        }

        public final HashMap<String, HashMap<String, Achievement>> getRecentAchievements() {
            return this.recentAchievements;
        }

        public final long getPoints() {
            return this.points;
        }

        public final long getSoftcorePoints() {
            return this.softcorePoints;
        }

        public final String getUserPic() {
            return this.userPic;
        }

        public final long getTotalRanked() {
            return this.totalRanked;
        }

        public final String getStatus() {
            return this.status;
        }

        /* INFO: compiled from: GetUserSummary.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000fHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000fHÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001bR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006-"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$Achievement;", "", "id", "", "gameId", "gameTitle", "", "title", "description", "points", "badgeName", "isAwarded", "", "dateAwarded", "hardcoreAchieved", "", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZLjava/lang/String;I)V", "getBadgeName", "()Ljava/lang/String;", "getDateAwarded", "getDescription", "getGameId", "()J", "getGameTitle", "getHardcoreAchieved", "()I", "getId", "()Z", "getPoints", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Achievement {

            @SerializedName("BadgeName")
            private final String badgeName;

            @SerializedName("DateAwarded")
            private final String dateAwarded;

            @SerializedName("Description")
            private final String description;

            @SerializedName("GameID")
            private final long gameId;

            @SerializedName("GameTitle")
            private final String gameTitle;

            @SerializedName("HardcoreAchieved")
            private final int hardcoreAchieved;

            @SerializedName("ID")
            private final long id;

            @SerializedName("IsAwarded")
            @JsonAdapter(BooleanJsonDeserializer.class)
            private final boolean isAwarded;

            @SerializedName("Points")
            private final long points;

            @SerializedName("Title")
            private final String title;

            /* INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* INFO: renamed from: component10, reason: from getter */
            public final int getHardcoreAchieved() {
                return this.hardcoreAchieved;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final long getGameId() {
                return this.gameId;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final String getGameTitle() {
                return this.gameTitle;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final String getDescription() {
                return this.description;
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
            public final boolean getIsAwarded() {
                return this.isAwarded;
            }

            /* INFO: renamed from: component9, reason: from getter */
            public final String getDateAwarded() {
                return this.dateAwarded;
            }

            public final Achievement copy(long id2, long gameId, String gameTitle, String title, String description, long points, String badgeName, boolean isAwarded, String dateAwarded, int hardcoreAchieved) {
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                Intrinsics.checkNotNullParameter(dateAwarded, "dateAwarded");
                return new Achievement(id2, gameId, gameTitle, title, description, points, badgeName, isAwarded, dateAwarded, hardcoreAchieved);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Achievement)) {
                    return false;
                }
                Achievement achievement = (Achievement) other;
                return this.id == achievement.id && this.gameId == achievement.gameId && Intrinsics.areEqual(this.gameTitle, achievement.gameTitle) && Intrinsics.areEqual(this.title, achievement.title) && Intrinsics.areEqual(this.description, achievement.description) && this.points == achievement.points && Intrinsics.areEqual(this.badgeName, achievement.badgeName) && this.isAwarded == achievement.isAwarded && Intrinsics.areEqual(this.dateAwarded, achievement.dateAwarded) && this.hardcoreAchieved == achievement.hardcoreAchieved;
            }

            public int hashCode() {
                return (((((((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.gameId)) * 31) + this.gameTitle.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Long.hashCode(this.points)) * 31) + this.badgeName.hashCode()) * 31) + Boolean.hashCode(this.isAwarded)) * 31) + this.dateAwarded.hashCode()) * 31) + Integer.hashCode(this.hardcoreAchieved);
            }

            public String toString() {
                return "Achievement(id=" + this.id + ", gameId=" + this.gameId + ", gameTitle=" + this.gameTitle + ", title=" + this.title + ", description=" + this.description + ", points=" + this.points + ", badgeName=" + this.badgeName + ", isAwarded=" + this.isAwarded + ", dateAwarded=" + this.dateAwarded + ", hardcoreAchieved=" + this.hardcoreAchieved + ')';
            }

            public Achievement(long j, long j2, String gameTitle, String title, String description, long j3, String badgeName, boolean z, String dateAwarded, int i) {
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                Intrinsics.checkNotNullParameter(dateAwarded, "dateAwarded");
                this.id = j;
                this.gameId = j2;
                this.gameTitle = gameTitle;
                this.title = title;
                this.description = description;
                this.points = j3;
                this.badgeName = badgeName;
                this.isAwarded = z;
                this.dateAwarded = dateAwarded;
                this.hardcoreAchieved = i;
            }

            public final long getId() {
                return this.id;
            }

            public final long getGameId() {
                return this.gameId;
            }

            public final String getGameTitle() {
                return this.gameTitle;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getDescription() {
                return this.description;
            }

            public final long getPoints() {
                return this.points;
            }

            public final String getBadgeName() {
                return this.badgeName;
            }

            public final boolean isAwarded() {
                return this.isAwarded;
            }

            public final String getDateAwarded() {
                return this.dateAwarded;
            }

            public final int getHardcoreAchieved() {
                return this.hardcoreAchieved;
            }
        }

        /* INFO: compiled from: GetUserSummary.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$Award;", "", "numPossibleAchievements", "", "possibleScore", "numAchieved", "scoreAchieved", "numAchievedHardcore", "scoreAchievedHardcore", "(JJJJJJ)V", "getNumAchieved", "()J", "getNumAchievedHardcore", "getNumPossibleAchievements", "getPossibleScore", "getScoreAchieved", "getScoreAchievedHardcore", "component1", "component2", "component3", "component4", "component5", "component6", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Award {

            @SerializedName("NumAchieved")
            private final long numAchieved;

            @SerializedName("NumAchievedHardcore")
            private final long numAchievedHardcore;

            @SerializedName("NumPossibleAchievements")
            private final long numPossibleAchievements;

            @SerializedName("PossibleScore")
            private final long possibleScore;

            @SerializedName("ScoreAchieved")
            private final long scoreAchieved;

            @SerializedName("ScoreAchievedHardcore")
            private final long scoreAchievedHardcore;

            public static /* synthetic */ Award copy$default(Award award, long j, long j2, long j3, long j4, long j5, long j6, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = award.numPossibleAchievements;
                }
                return award.copy(j, (i & 2) != 0 ? award.possibleScore : j2, (i & 4) != 0 ? award.numAchieved : j3, (i & 8) != 0 ? award.scoreAchieved : j4, (i & 16) != 0 ? award.numAchievedHardcore : j5, (i & 32) != 0 ? award.scoreAchievedHardcore : j6);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final long getNumPossibleAchievements() {
                return this.numPossibleAchievements;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final long getPossibleScore() {
                return this.possibleScore;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final long getNumAchieved() {
                return this.numAchieved;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final long getScoreAchieved() {
                return this.scoreAchieved;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final long getNumAchievedHardcore() {
                return this.numAchievedHardcore;
            }

            /* INFO: renamed from: component6, reason: from getter */
            public final long getScoreAchievedHardcore() {
                return this.scoreAchievedHardcore;
            }

            public final Award copy(long numPossibleAchievements, long possibleScore, long numAchieved, long scoreAchieved, long numAchievedHardcore, long scoreAchievedHardcore) {
                return new Award(numPossibleAchievements, possibleScore, numAchieved, scoreAchieved, numAchievedHardcore, scoreAchievedHardcore);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Award)) {
                    return false;
                }
                Award award = (Award) other;
                return this.numPossibleAchievements == award.numPossibleAchievements && this.possibleScore == award.possibleScore && this.numAchieved == award.numAchieved && this.scoreAchieved == award.scoreAchieved && this.numAchievedHardcore == award.numAchievedHardcore && this.scoreAchievedHardcore == award.scoreAchievedHardcore;
            }

            public int hashCode() {
                return (((((((((Long.hashCode(this.numPossibleAchievements) * 31) + Long.hashCode(this.possibleScore)) * 31) + Long.hashCode(this.numAchieved)) * 31) + Long.hashCode(this.scoreAchieved)) * 31) + Long.hashCode(this.numAchievedHardcore)) * 31) + Long.hashCode(this.scoreAchievedHardcore);
            }

            public String toString() {
                return "Award(numPossibleAchievements=" + this.numPossibleAchievements + ", possibleScore=" + this.possibleScore + ", numAchieved=" + this.numAchieved + ", scoreAchieved=" + this.scoreAchieved + ", numAchievedHardcore=" + this.numAchievedHardcore + ", scoreAchievedHardcore=" + this.scoreAchievedHardcore + ')';
            }

            public Award(long j, long j2, long j3, long j4, long j5, long j6) {
                this.numPossibleAchievements = j;
                this.possibleScore = j2;
                this.numAchieved = j3;
                this.scoreAchieved = j4;
                this.numAchievedHardcore = j5;
                this.scoreAchievedHardcore = j6;
            }

            public final long getNumPossibleAchievements() {
                return this.numPossibleAchievements;
            }

            public final long getPossibleScore() {
                return this.possibleScore;
            }

            public final long getNumAchieved() {
                return this.numAchieved;
            }

            public final long getScoreAchieved() {
                return this.scoreAchieved;
            }

            public final long getNumAchievedHardcore() {
                return this.numAchievedHardcore;
            }

            public final long getScoreAchievedHardcore() {
                return this.scoreAchievedHardcore;
            }
        }

        /* INFO: compiled from: GetUserSummary.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JW\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006$"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$Activity;", "", "id", "", "timestamp", "", "lastUpdate", "activityType", "", ConfigConstants.CONFIG_USER_SECTION, "data", "data2", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityType", "()I", "getData", "()Ljava/lang/String;", "getData2", "getId", "()J", "getLastUpdate", "getTimestamp", "getUser", "component1", "component2", "component3", "component4", "component5", "component6", "component7", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Activity {

            @SerializedName("activitytype")
            private final int activityType;

            @SerializedName("data")
            private final String data;

            @SerializedName("data2")
            private final String data2;

            @SerializedName("ID")
            private final long id;

            @SerializedName("lastupdate")
            private final String lastUpdate;

            @SerializedName("timestamp")
            private final String timestamp;

            @SerializedName(SshConstants.USER)
            private final String user;

            public static /* synthetic */ Activity copy$default(Activity activity, long j, String str, String str2, int i, String str3, String str4, String str5, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    j = activity.id;
                }
                long j2 = j;
                if ((i2 & 2) != 0) {
                    str = activity.timestamp;
                }
                String str6 = str;
                if ((i2 & 4) != 0) {
                    str2 = activity.lastUpdate;
                }
                String str7 = str2;
                if ((i2 & 8) != 0) {
                    i = activity.activityType;
                }
                int i3 = i;
                if ((i2 & 16) != 0) {
                    str3 = activity.user;
                }
                return activity.copy(j2, str6, str7, i3, str3, (i2 & 32) != 0 ? activity.data : str4, (i2 & 64) != 0 ? activity.data2 : str5);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final String getTimestamp() {
                return this.timestamp;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final String getLastUpdate() {
                return this.lastUpdate;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final int getActivityType() {
                return this.activityType;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final String getUser() {
                return this.user;
            }

            /* INFO: renamed from: component6, reason: from getter */
            public final String getData() {
                return this.data;
            }

            /* INFO: renamed from: component7, reason: from getter */
            public final String getData2() {
                return this.data2;
            }

            public final Activity copy(long id2, String timestamp, String lastUpdate, int activityType, String user, String data, String data2) {
                Intrinsics.checkNotNullParameter(user, "user");
                return new Activity(id2, timestamp, lastUpdate, activityType, user, data, data2);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Activity)) {
                    return false;
                }
                Activity activity = (Activity) other;
                return this.id == activity.id && Intrinsics.areEqual(this.timestamp, activity.timestamp) && Intrinsics.areEqual(this.lastUpdate, activity.lastUpdate) && this.activityType == activity.activityType && Intrinsics.areEqual(this.user, activity.user) && Intrinsics.areEqual(this.data, activity.data) && Intrinsics.areEqual(this.data2, activity.data2);
            }

            public int hashCode() {
                int iHashCode = Long.hashCode(this.id) * 31;
                String str = this.timestamp;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.lastUpdate;
                int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.activityType)) * 31) + this.user.hashCode()) * 31;
                String str3 = this.data;
                int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.data2;
                return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
            }

            public String toString() {
                return "Activity(id=" + this.id + ", timestamp=" + this.timestamp + ", lastUpdate=" + this.lastUpdate + ", activityType=" + this.activityType + ", user=" + this.user + ", data=" + this.data + ", data2=" + this.data2 + ')';
            }

            public Activity(long j, String str, String str2, int i, String user, String str3, String str4) {
                Intrinsics.checkNotNullParameter(user, "user");
                this.id = j;
                this.timestamp = str;
                this.lastUpdate = str2;
                this.activityType = i;
                this.user = user;
                this.data = str3;
                this.data2 = str4;
            }

            public final long getId() {
                return this.id;
            }

            public final String getTimestamp() {
                return this.timestamp;
            }

            public final String getLastUpdate() {
                return this.lastUpdate;
            }

            public final int getActivityType() {
                return this.activityType;
            }

            public final String getUser() {
                return this.user;
            }

            public final String getData() {
                return this.data;
            }

            public final String getData2() {
                return this.data2;
            }
        }

        /* INFO: compiled from: GetUserSummary.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$RecentGame;", "", "gameId", "", "consoleId", "consoleName", "", "title", "imageIcon", "lastPlayed", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConsoleId", "()J", "getConsoleName", "()Ljava/lang/String;", "getGameId", "getImageIcon", "getLastPlayed", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RecentGame {

            @SerializedName("ConsoleID")
            private final long consoleId;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("GameID")
            private final long gameId;

            @SerializedName("ImageIcon")
            private final String imageIcon;

            @SerializedName("LastPlayed")
            private final String lastPlayed;

            @SerializedName("Title")
            private final String title;

            public static /* synthetic */ RecentGame copy$default(RecentGame recentGame, long j, long j2, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = recentGame.gameId;
                }
                long j3 = j;
                if ((i & 2) != 0) {
                    j2 = recentGame.consoleId;
                }
                long j4 = j2;
                if ((i & 4) != 0) {
                    str = recentGame.consoleName;
                }
                String str5 = str;
                if ((i & 8) != 0) {
                    str2 = recentGame.title;
                }
                return recentGame.copy(j3, j4, str5, str2, (i & 16) != 0 ? recentGame.imageIcon : str3, (i & 32) != 0 ? recentGame.lastPlayed : str4);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final long getGameId() {
                return this.gameId;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final long getConsoleId() {
                return this.consoleId;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final String getImageIcon() {
                return this.imageIcon;
            }

            /* INFO: renamed from: component6, reason: from getter */
            public final String getLastPlayed() {
                return this.lastPlayed;
            }

            public final RecentGame copy(long gameId, long consoleId, String consoleName, String title, String imageIcon, String lastPlayed) {
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                Intrinsics.checkNotNullParameter(lastPlayed, "lastPlayed");
                return new RecentGame(gameId, consoleId, consoleName, title, imageIcon, lastPlayed);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RecentGame)) {
                    return false;
                }
                RecentGame recentGame = (RecentGame) other;
                return this.gameId == recentGame.gameId && this.consoleId == recentGame.consoleId && Intrinsics.areEqual(this.consoleName, recentGame.consoleName) && Intrinsics.areEqual(this.title, recentGame.title) && Intrinsics.areEqual(this.imageIcon, recentGame.imageIcon) && Intrinsics.areEqual(this.lastPlayed, recentGame.lastPlayed);
            }

            public int hashCode() {
                return (((((((((Long.hashCode(this.gameId) * 31) + Long.hashCode(this.consoleId)) * 31) + this.consoleName.hashCode()) * 31) + this.title.hashCode()) * 31) + this.imageIcon.hashCode()) * 31) + this.lastPlayed.hashCode();
            }

            public String toString() {
                return "RecentGame(gameId=" + this.gameId + ", consoleId=" + this.consoleId + ", consoleName=" + this.consoleName + ", title=" + this.title + ", imageIcon=" + this.imageIcon + ", lastPlayed=" + this.lastPlayed + ')';
            }

            public RecentGame(long j, long j2, String consoleName, String title, String imageIcon, String lastPlayed) {
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                Intrinsics.checkNotNullParameter(lastPlayed, "lastPlayed");
                this.gameId = j;
                this.consoleId = j2;
                this.consoleName = consoleName;
                this.title = title;
                this.imageIcon = imageIcon;
                this.lastPlayed = lastPlayed;
            }

            public final long getGameId() {
                return this.gameId;
            }

            public final long getConsoleId() {
                return this.consoleId;
            }

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getImageIcon() {
                return this.imageIcon;
            }

            public final String getLastPlayed() {
                return this.lastPlayed;
            }
        }

        /* INFO: compiled from: GetUserSummary.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0012HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u00ad\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00109\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010#R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006>"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response$LastGame;", "", "id", "", "title", "", "consoleId", "forumTopicId", "flags", "imageIcon", "imageTitle", "imageInGame", "imageBoxArt", "publisher", "developer", "genre", "released", "isFinal", "", "consoleName", "richPresencePatch", "(JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getConsoleId", "()J", "getConsoleName", "()Ljava/lang/String;", "getDeveloper", "getFlags", "getForumTopicId", "getGenre", "getId", "getImageBoxArt", "getImageIcon", "getImageInGame", "getImageTitle", "()Z", "getPublisher", "getReleased", "getRichPresencePatch", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LastGame {

            @SerializedName("ConsoleID")
            private final long consoleId;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("Developer")
            private final String developer;

            @SerializedName("Flags")
            private final long flags;

            @SerializedName("ForumTopicID")
            private final long forumTopicId;

            @SerializedName("Genre")
            private final String genre;

            @SerializedName("ID")
            private final long id;

            @SerializedName("ImageBoxArt")
            private final String imageBoxArt;

            @SerializedName("ImageIcon")
            private final String imageIcon;

            @SerializedName("ImageInGame")
            private final String imageInGame;

            @SerializedName("ImageTitle")
            private final String imageTitle;

            @SerializedName("IsFinal")
            @JsonAdapter(BooleanJsonDeserializer.class)
            private final boolean isFinal;

            @SerializedName("Publisher")
            private final String publisher;

            @SerializedName("Released")
            private final String released;

            @SerializedName("RichPresencePatch")
            private final String richPresencePatch;

            @SerializedName("Title")
            private final String title;

            public static /* synthetic */ LastGame copy$default(LastGame lastGame, long j, String str, long j2, long j3, long j4, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10, String str11, int i, Object obj) {
                long j5 = (i & 1) != 0 ? lastGame.id : j;
                String str12 = (i & 2) != 0 ? lastGame.title : str;
                long j6 = (i & 4) != 0 ? lastGame.consoleId : j2;
                long j7 = (i & 8) != 0 ? lastGame.forumTopicId : j3;
                long j8 = (i & 16) != 0 ? lastGame.flags : j4;
                String str13 = (i & 32) != 0 ? lastGame.imageIcon : str2;
                String str14 = (i & 64) != 0 ? lastGame.imageTitle : str3;
                String str15 = (i & 128) != 0 ? lastGame.imageInGame : str4;
                String str16 = (i & 256) != 0 ? lastGame.imageBoxArt : str5;
                String str17 = (i & 512) != 0 ? lastGame.publisher : str6;
                long j9 = j5;
                String str18 = (i & 1024) != 0 ? lastGame.developer : str7;
                return lastGame.copy(j9, str12, j6, j7, j8, str13, str14, str15, str16, str17, str18, (i & 2048) != 0 ? lastGame.genre : str8, (i & 4096) != 0 ? lastGame.released : str9, (i & 8192) != 0 ? lastGame.isFinal : z, (i & 16384) != 0 ? lastGame.consoleName : str10, (i & 32768) != 0 ? lastGame.richPresencePatch : str11);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* INFO: renamed from: component10, reason: from getter */
            public final String getPublisher() {
                return this.publisher;
            }

            /* INFO: renamed from: component11, reason: from getter */
            public final String getDeveloper() {
                return this.developer;
            }

            /* INFO: renamed from: component12, reason: from getter */
            public final String getGenre() {
                return this.genre;
            }

            /* INFO: renamed from: component13, reason: from getter */
            public final String getReleased() {
                return this.released;
            }

            /* INFO: renamed from: component14, reason: from getter */
            public final boolean getIsFinal() {
                return this.isFinal;
            }

            /* INFO: renamed from: component15, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* INFO: renamed from: component16, reason: from getter */
            public final String getRichPresencePatch() {
                return this.richPresencePatch;
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
            public final long getForumTopicId() {
                return this.forumTopicId;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final long getFlags() {
                return this.flags;
            }

            /* INFO: renamed from: component6, reason: from getter */
            public final String getImageIcon() {
                return this.imageIcon;
            }

            /* INFO: renamed from: component7, reason: from getter */
            public final String getImageTitle() {
                return this.imageTitle;
            }

            /* INFO: renamed from: component8, reason: from getter */
            public final String getImageInGame() {
                return this.imageInGame;
            }

            /* INFO: renamed from: component9, reason: from getter */
            public final String getImageBoxArt() {
                return this.imageBoxArt;
            }

            public final LastGame copy(long id2, String title, long consoleId, long forumTopicId, long flags, String imageIcon, String imageTitle, String imageInGame, String imageBoxArt, String publisher, String developer, String genre, String released, boolean isFinal, String consoleName, String richPresencePatch) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                Intrinsics.checkNotNullParameter(imageTitle, "imageTitle");
                Intrinsics.checkNotNullParameter(imageInGame, "imageInGame");
                Intrinsics.checkNotNullParameter(imageBoxArt, "imageBoxArt");
                Intrinsics.checkNotNullParameter(publisher, "publisher");
                Intrinsics.checkNotNullParameter(developer, "developer");
                Intrinsics.checkNotNullParameter(genre, "genre");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                return new LastGame(id2, title, consoleId, forumTopicId, flags, imageIcon, imageTitle, imageInGame, imageBoxArt, publisher, developer, genre, released, isFinal, consoleName, richPresencePatch);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LastGame)) {
                    return false;
                }
                LastGame lastGame = (LastGame) other;
                return this.id == lastGame.id && Intrinsics.areEqual(this.title, lastGame.title) && this.consoleId == lastGame.consoleId && this.forumTopicId == lastGame.forumTopicId && this.flags == lastGame.flags && Intrinsics.areEqual(this.imageIcon, lastGame.imageIcon) && Intrinsics.areEqual(this.imageTitle, lastGame.imageTitle) && Intrinsics.areEqual(this.imageInGame, lastGame.imageInGame) && Intrinsics.areEqual(this.imageBoxArt, lastGame.imageBoxArt) && Intrinsics.areEqual(this.publisher, lastGame.publisher) && Intrinsics.areEqual(this.developer, lastGame.developer) && Intrinsics.areEqual(this.genre, lastGame.genre) && Intrinsics.areEqual(this.released, lastGame.released) && this.isFinal == lastGame.isFinal && Intrinsics.areEqual(this.consoleName, lastGame.consoleName) && Intrinsics.areEqual(this.richPresencePatch, lastGame.richPresencePatch);
            }

            public int hashCode() {
                int iHashCode = ((((((((((((((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.consoleId)) * 31) + Long.hashCode(this.forumTopicId)) * 31) + Long.hashCode(this.flags)) * 31) + this.imageIcon.hashCode()) * 31) + this.imageTitle.hashCode()) * 31) + this.imageInGame.hashCode()) * 31) + this.imageBoxArt.hashCode()) * 31) + this.publisher.hashCode()) * 31) + this.developer.hashCode()) * 31) + this.genre.hashCode()) * 31;
                String str = this.released;
                int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isFinal)) * 31) + this.consoleName.hashCode()) * 31;
                String str2 = this.richPresencePatch;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("LastGame(id=");
                sb.append(this.id).append(", title=").append(this.title).append(", consoleId=").append(this.consoleId).append(", forumTopicId=").append(this.forumTopicId).append(", flags=").append(this.flags).append(", imageIcon=").append(this.imageIcon).append(", imageTitle=").append(this.imageTitle).append(", imageInGame=").append(this.imageInGame).append(", imageBoxArt=").append(this.imageBoxArt).append(", publisher=").append(this.publisher).append(", developer=").append(this.developer).append(", genre=");
                sb.append(this.genre).append(", released=").append(this.released).append(", isFinal=").append(this.isFinal).append(", consoleName=").append(this.consoleName).append(", richPresencePatch=").append(this.richPresencePatch).append(')');
                return sb.toString();
            }

            public LastGame(long j, String title, long j2, long j3, long j4, String imageIcon, String imageTitle, String imageInGame, String imageBoxArt, String publisher, String developer, String genre, String str, boolean z, String consoleName, String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                Intrinsics.checkNotNullParameter(imageTitle, "imageTitle");
                Intrinsics.checkNotNullParameter(imageInGame, "imageInGame");
                Intrinsics.checkNotNullParameter(imageBoxArt, "imageBoxArt");
                Intrinsics.checkNotNullParameter(publisher, "publisher");
                Intrinsics.checkNotNullParameter(developer, "developer");
                Intrinsics.checkNotNullParameter(genre, "genre");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                this.id = j;
                this.title = title;
                this.consoleId = j2;
                this.forumTopicId = j3;
                this.flags = j4;
                this.imageIcon = imageIcon;
                this.imageTitle = imageTitle;
                this.imageInGame = imageInGame;
                this.imageBoxArt = imageBoxArt;
                this.publisher = publisher;
                this.developer = developer;
                this.genre = genre;
                this.released = str;
                this.isFinal = z;
                this.consoleName = consoleName;
                this.richPresencePatch = str2;
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

            public final long getForumTopicId() {
                return this.forumTopicId;
            }

            public final long getFlags() {
                return this.flags;
            }

            public final String getImageIcon() {
                return this.imageIcon;
            }

            public final String getImageTitle() {
                return this.imageTitle;
            }

            public final String getImageInGame() {
                return this.imageInGame;
            }

            public final String getImageBoxArt() {
                return this.imageBoxArt;
            }

            public final String getPublisher() {
                return this.publisher;
            }

            public final String getDeveloper() {
                return this.developer;
            }

            public final String getGenre() {
                return this.genre;
            }

            public final String getReleased() {
                return this.released;
            }

            public final boolean isFinal() {
                return this.isFinal;
            }

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final String getRichPresencePatch() {
                return this.richPresencePatch;
            }
        }
    }
}
