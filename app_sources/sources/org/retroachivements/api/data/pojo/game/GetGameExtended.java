package org.retroachivements.api.data.pojo.game;

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
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.transport.SshConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* INFO: compiled from: GetGameExtended.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameExtended;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetGameExtended {

    /* INFO: compiled from: GetGameExtended.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002pqB«\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!`\"\u0012\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003¢\u0006\u0002\u0010)J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0013HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J%\u0010_\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!`\"HÆ\u0003J\u0019\u0010`\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\t\u0010h\u001a\u00020\u0005HÆ\u0003J\t\u0010i\u001a\u00020\u0005HÆ\u0003Jë\u0002\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032$\b\u0002\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!`\"2\u0018\b\u0002\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&2\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u0003HÆ\u0001J\u0013\u0010k\u001a\u00020\u00132\b\u0010l\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010m\u001a\u00020nHÖ\u0001J\t\u0010o\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R2\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!`\"8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R&\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0016\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010+R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010>R\u0016\u0010\u001e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010/R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0016\u0010'\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010/R\u0016\u0010(\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010/R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010/R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010/R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010+R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010+R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010+R\u0016\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010+R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010+R\u0016\u0010\u001a\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010+¨\u0006r"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameExtended$Response;", "", "id", "", "title", "", "consoleId", "forumTopicId", "flags", "imageIcon", "imageTitle", "imageInGame", "imageBoxArt", "publisher", "developer", "genre", "released", "releasedAtGranularity", "isFinal", "", "richPresencePatch", "playersTotal", "achievementSetVersionHash", "achievementsPublished", "pointsTotal", "guideUrl", "updated", "consoleName", "parentGameId", "numDistinctPlayers", "numAchievements", "achievements", "Ljava/util/HashMap;", "Lorg/retroachivements/api/data/pojo/game/GetGameExtended$Response$Achievement;", "Lkotlin/collections/HashMap;", "claims", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/game/GetGameExtended$Response$Claim;", "Lkotlin/collections/ArrayList;", "numDistinctPlayersCasual", "numDistinctPlayersHardcore", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;JLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/util/HashMap;Ljava/util/ArrayList;JJ)V", "getAchievementSetVersionHash", "()Ljava/lang/String;", "getAchievements", "()Ljava/util/HashMap;", "getAchievementsPublished", "()J", "getClaims", "()Ljava/util/ArrayList;", "getConsoleId", "getConsoleName", "getDeveloper", "getFlags", "getForumTopicId", "getGenre", "getGuideUrl", "getId", "getImageBoxArt", "getImageIcon", "getImageInGame", "getImageTitle", "()Z", "getNumAchievements", "getNumDistinctPlayers", "getNumDistinctPlayersCasual", "getNumDistinctPlayersHardcore", "getParentGameId", "getPlayersTotal", "getPointsTotal", "getPublisher", "getReleased", "getReleasedAtGranularity", "getRichPresencePatch", "getTitle", "getUpdated", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "", "toString", "Achievement", "Claim", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("AchievementSetVersionHash")
        private final String achievementSetVersionHash;

        @SerializedName("Achievements")
        private final HashMap<String, Achievement> achievements;

        @SerializedName("AchievementsPublished")
        private final long achievementsPublished;

        @SerializedName("Claims")
        private final ArrayList<Claim> claims;

        @SerializedName("ConsoleID")
        private final String consoleId;

        @SerializedName("ConsoleName")
        private final String consoleName;

        @SerializedName("Developer")
        private final String developer;

        @SerializedName("Flags")
        private final String flags;

        @SerializedName("ForumTopicID")
        private final long forumTopicId;

        @SerializedName("Genre")
        private final String genre;

        @SerializedName("GuideURL")
        private final String guideUrl;

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

        @SerializedName("NumAchievements")
        private final long numAchievements;

        @SerializedName("NumDistinctPlayers")
        private final long numDistinctPlayers;

        @SerializedName("NumDistinctPlayersCasual")
        private final long numDistinctPlayersCasual;

        @SerializedName("NumDistinctPlayersHardcore")
        private final long numDistinctPlayersHardcore;

        @SerializedName("ParentGameID")
        private final String parentGameId;

        @SerializedName("PlayersTotal")
        private final long playersTotal;

        @SerializedName("PointsTotal")
        private final long pointsTotal;

        @SerializedName("Publisher")
        private final String publisher;

        @SerializedName("Released")
        private final String released;

        @SerializedName("ReleasedAtGranularity")
        private final String releasedAtGranularity;

        @SerializedName("RichPresencePatch")
        private final String richPresencePatch;

        @SerializedName("Title")
        private final String title;

        @SerializedName("Updated")
        private final String updated;

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, long j, String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, long j3, String str14, long j4, long j5, String str15, String str16, String str17, String str18, long j6, long j7, HashMap map, ArrayList arrayList, long j8, long j9, int i, Object obj) {
            long j10;
            long j11;
            long j12 = (i & 1) != 0 ? response.id : j;
            String str19 = (i & 2) != 0 ? response.title : str;
            String str20 = (i & 4) != 0 ? response.consoleId : str2;
            long j13 = (i & 8) != 0 ? response.forumTopicId : j2;
            String str21 = (i & 16) != 0 ? response.flags : str3;
            String str22 = (i & 32) != 0 ? response.imageIcon : str4;
            String str23 = (i & 64) != 0 ? response.imageTitle : str5;
            String str24 = (i & 128) != 0 ? response.imageInGame : str6;
            String str25 = (i & 256) != 0 ? response.imageBoxArt : str7;
            String str26 = (i & 512) != 0 ? response.publisher : str8;
            String str27 = (i & 1024) != 0 ? response.developer : str9;
            String str28 = (i & 2048) != 0 ? response.genre : str10;
            long j14 = j12;
            String str29 = (i & 4096) != 0 ? response.released : str11;
            String str30 = (i & 8192) != 0 ? response.releasedAtGranularity : str12;
            String str31 = str29;
            boolean z2 = (i & 16384) != 0 ? response.isFinal : z;
            String str32 = (i & 32768) != 0 ? response.richPresencePatch : str13;
            boolean z3 = z2;
            long j15 = (i & 65536) != 0 ? response.playersTotal : j3;
            String str33 = (i & 131072) != 0 ? response.achievementSetVersionHash : str14;
            long j16 = (i & 262144) != 0 ? response.achievementsPublished : j4;
            long j17 = (i & 524288) != 0 ? response.pointsTotal : j5;
            String str34 = (i & 1048576) != 0 ? response.guideUrl : str15;
            String str35 = (i & 2097152) != 0 ? response.updated : str16;
            String str36 = str34;
            String str37 = (i & 4194304) != 0 ? response.consoleName : str17;
            String str38 = (i & 8388608) != 0 ? response.parentGameId : str18;
            String str39 = str35;
            long j18 = (i & 16777216) != 0 ? response.numDistinctPlayers : j6;
            long j19 = (i & MediaHttpDownloader.MAXIMUM_CHUNK_SIZE) != 0 ? response.numAchievements : j7;
            HashMap map2 = (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? response.achievements : map;
            ArrayList arrayList2 = (i & 134217728) != 0 ? response.claims : arrayList;
            long j20 = (i & 268435456) != 0 ? response.numDistinctPlayersCasual : j8;
            if ((i & 536870912) != 0) {
                j11 = j20;
                j10 = response.numDistinctPlayersHardcore;
            } else {
                j10 = j9;
                j11 = j20;
            }
            return response.copy(j14, str19, str20, j13, str21, str22, str23, str24, str25, str26, str27, str28, str31, str30, z3, str32, j15, str33, j16, j17, str36, str39, str37, str38, j18, j19, map2, arrayList2, j11, j10);
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
        public final String getReleasedAtGranularity() {
            return this.releasedAtGranularity;
        }

        /* INFO: renamed from: component15, reason: from getter */
        public final boolean getIsFinal() {
            return this.isFinal;
        }

        /* INFO: renamed from: component16, reason: from getter */
        public final String getRichPresencePatch() {
            return this.richPresencePatch;
        }

        /* INFO: renamed from: component17, reason: from getter */
        public final long getPlayersTotal() {
            return this.playersTotal;
        }

        /* INFO: renamed from: component18, reason: from getter */
        public final String getAchievementSetVersionHash() {
            return this.achievementSetVersionHash;
        }

        /* INFO: renamed from: component19, reason: from getter */
        public final long getAchievementsPublished() {
            return this.achievementsPublished;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* INFO: renamed from: component20, reason: from getter */
        public final long getPointsTotal() {
            return this.pointsTotal;
        }

        /* INFO: renamed from: component21, reason: from getter */
        public final String getGuideUrl() {
            return this.guideUrl;
        }

        /* INFO: renamed from: component22, reason: from getter */
        public final String getUpdated() {
            return this.updated;
        }

        /* INFO: renamed from: component23, reason: from getter */
        public final String getConsoleName() {
            return this.consoleName;
        }

        /* INFO: renamed from: component24, reason: from getter */
        public final String getParentGameId() {
            return this.parentGameId;
        }

        /* INFO: renamed from: component25, reason: from getter */
        public final long getNumDistinctPlayers() {
            return this.numDistinctPlayers;
        }

        /* INFO: renamed from: component26, reason: from getter */
        public final long getNumAchievements() {
            return this.numAchievements;
        }

        public final HashMap<String, Achievement> component27() {
            return this.achievements;
        }

        public final ArrayList<Claim> component28() {
            return this.claims;
        }

        /* INFO: renamed from: component29, reason: from getter */
        public final long getNumDistinctPlayersCasual() {
            return this.numDistinctPlayersCasual;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getConsoleId() {
            return this.consoleId;
        }

        /* INFO: renamed from: component30, reason: from getter */
        public final long getNumDistinctPlayersHardcore() {
            return this.numDistinctPlayersHardcore;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final long getForumTopicId() {
            return this.forumTopicId;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final String getFlags() {
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

        public final Response copy(long id2, String title, String consoleId, long forumTopicId, String flags, String imageIcon, String imageTitle, String imageInGame, String imageBoxArt, String publisher, String developer, String genre, String released, String releasedAtGranularity, boolean isFinal, String richPresencePatch, long playersTotal, String achievementSetVersionHash, long achievementsPublished, long pointsTotal, String guideUrl, String updated, String consoleName, String parentGameId, long numDistinctPlayers, long numAchievements, HashMap<String, Achievement> achievements, ArrayList<Claim> claims, long numDistinctPlayersCasual, long numDistinctPlayersHardcore) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(consoleId, "consoleId");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            Intrinsics.checkNotNullParameter(imageTitle, "imageTitle");
            Intrinsics.checkNotNullParameter(imageInGame, "imageInGame");
            Intrinsics.checkNotNullParameter(imageBoxArt, "imageBoxArt");
            Intrinsics.checkNotNullParameter(publisher, "publisher");
            Intrinsics.checkNotNullParameter(developer, "developer");
            Intrinsics.checkNotNullParameter(genre, "genre");
            Intrinsics.checkNotNullParameter(richPresencePatch, "richPresencePatch");
            Intrinsics.checkNotNullParameter(achievementSetVersionHash, "achievementSetVersionHash");
            Intrinsics.checkNotNullParameter(updated, "updated");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(achievements, "achievements");
            Intrinsics.checkNotNullParameter(claims, "claims");
            return new Response(id2, title, consoleId, forumTopicId, flags, imageIcon, imageTitle, imageInGame, imageBoxArt, publisher, developer, genre, released, releasedAtGranularity, isFinal, richPresencePatch, playersTotal, achievementSetVersionHash, achievementsPublished, pointsTotal, guideUrl, updated, consoleName, parentGameId, numDistinctPlayers, numAchievements, achievements, claims, numDistinctPlayersCasual, numDistinctPlayersHardcore);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.id == response.id && Intrinsics.areEqual(this.title, response.title) && Intrinsics.areEqual(this.consoleId, response.consoleId) && this.forumTopicId == response.forumTopicId && Intrinsics.areEqual(this.flags, response.flags) && Intrinsics.areEqual(this.imageIcon, response.imageIcon) && Intrinsics.areEqual(this.imageTitle, response.imageTitle) && Intrinsics.areEqual(this.imageInGame, response.imageInGame) && Intrinsics.areEqual(this.imageBoxArt, response.imageBoxArt) && Intrinsics.areEqual(this.publisher, response.publisher) && Intrinsics.areEqual(this.developer, response.developer) && Intrinsics.areEqual(this.genre, response.genre) && Intrinsics.areEqual(this.released, response.released) && Intrinsics.areEqual(this.releasedAtGranularity, response.releasedAtGranularity) && this.isFinal == response.isFinal && Intrinsics.areEqual(this.richPresencePatch, response.richPresencePatch) && this.playersTotal == response.playersTotal && Intrinsics.areEqual(this.achievementSetVersionHash, response.achievementSetVersionHash) && this.achievementsPublished == response.achievementsPublished && this.pointsTotal == response.pointsTotal && Intrinsics.areEqual(this.guideUrl, response.guideUrl) && Intrinsics.areEqual(this.updated, response.updated) && Intrinsics.areEqual(this.consoleName, response.consoleName) && Intrinsics.areEqual(this.parentGameId, response.parentGameId) && this.numDistinctPlayers == response.numDistinctPlayers && this.numAchievements == response.numAchievements && Intrinsics.areEqual(this.achievements, response.achievements) && Intrinsics.areEqual(this.claims, response.claims) && this.numDistinctPlayersCasual == response.numDistinctPlayersCasual && this.numDistinctPlayersHardcore == response.numDistinctPlayersHardcore;
        }

        public int hashCode() {
            int iHashCode = ((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.consoleId.hashCode()) * 31) + Long.hashCode(this.forumTopicId)) * 31;
            String str = this.flags;
            int iHashCode2 = (((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.imageIcon.hashCode()) * 31) + this.imageTitle.hashCode()) * 31) + this.imageInGame.hashCode()) * 31) + this.imageBoxArt.hashCode()) * 31) + this.publisher.hashCode()) * 31) + this.developer.hashCode()) * 31) + this.genre.hashCode()) * 31;
            String str2 = this.released;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.releasedAtGranularity;
            int iHashCode4 = (((((((((((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.isFinal)) * 31) + this.richPresencePatch.hashCode()) * 31) + Long.hashCode(this.playersTotal)) * 31) + this.achievementSetVersionHash.hashCode()) * 31) + Long.hashCode(this.achievementsPublished)) * 31) + Long.hashCode(this.pointsTotal)) * 31;
            String str4 = this.guideUrl;
            int iHashCode5 = (((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.updated.hashCode()) * 31) + this.consoleName.hashCode()) * 31;
            String str5 = this.parentGameId;
            return ((((((((((((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Long.hashCode(this.numDistinctPlayers)) * 31) + Long.hashCode(this.numAchievements)) * 31) + this.achievements.hashCode()) * 31) + this.claims.hashCode()) * 31) + Long.hashCode(this.numDistinctPlayersCasual)) * 31) + Long.hashCode(this.numDistinctPlayersHardcore);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Response(id=");
            sb.append(this.id).append(", title=").append(this.title).append(", consoleId=").append(this.consoleId).append(", forumTopicId=").append(this.forumTopicId).append(", flags=").append(this.flags).append(", imageIcon=").append(this.imageIcon).append(", imageTitle=").append(this.imageTitle).append(", imageInGame=").append(this.imageInGame).append(", imageBoxArt=").append(this.imageBoxArt).append(", publisher=").append(this.publisher).append(", developer=").append(this.developer).append(", genre=");
            sb.append(this.genre).append(", released=").append(this.released).append(", releasedAtGranularity=").append(this.releasedAtGranularity).append(", isFinal=").append(this.isFinal).append(", richPresencePatch=").append(this.richPresencePatch).append(", playersTotal=").append(this.playersTotal).append(", achievementSetVersionHash=").append(this.achievementSetVersionHash).append(", achievementsPublished=").append(this.achievementsPublished).append(", pointsTotal=").append(this.pointsTotal).append(", guideUrl=").append(this.guideUrl).append(", updated=").append(this.updated).append(", consoleName=").append(this.consoleName);
            sb.append(", parentGameId=").append(this.parentGameId).append(", numDistinctPlayers=").append(this.numDistinctPlayers).append(", numAchievements=").append(this.numAchievements).append(", achievements=").append(this.achievements).append(", claims=").append(this.claims).append(", numDistinctPlayersCasual=").append(this.numDistinctPlayersCasual).append(", numDistinctPlayersHardcore=").append(this.numDistinctPlayersHardcore).append(')');
            return sb.toString();
        }

        public Response(long j, String title, String consoleId, long j2, String str, String imageIcon, String imageTitle, String imageInGame, String imageBoxArt, String publisher, String developer, String genre, String str2, String str3, boolean z, String richPresencePatch, long j3, String achievementSetVersionHash, long j4, long j5, String str4, String updated, String consoleName, String str5, long j6, long j7, HashMap<String, Achievement> achievements, ArrayList<Claim> claims, long j8, long j9) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(consoleId, "consoleId");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            Intrinsics.checkNotNullParameter(imageTitle, "imageTitle");
            Intrinsics.checkNotNullParameter(imageInGame, "imageInGame");
            Intrinsics.checkNotNullParameter(imageBoxArt, "imageBoxArt");
            Intrinsics.checkNotNullParameter(publisher, "publisher");
            Intrinsics.checkNotNullParameter(developer, "developer");
            Intrinsics.checkNotNullParameter(genre, "genre");
            Intrinsics.checkNotNullParameter(richPresencePatch, "richPresencePatch");
            Intrinsics.checkNotNullParameter(achievementSetVersionHash, "achievementSetVersionHash");
            Intrinsics.checkNotNullParameter(updated, "updated");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(achievements, "achievements");
            Intrinsics.checkNotNullParameter(claims, "claims");
            this.id = j;
            this.title = title;
            this.consoleId = consoleId;
            this.forumTopicId = j2;
            this.flags = str;
            this.imageIcon = imageIcon;
            this.imageTitle = imageTitle;
            this.imageInGame = imageInGame;
            this.imageBoxArt = imageBoxArt;
            this.publisher = publisher;
            this.developer = developer;
            this.genre = genre;
            this.released = str2;
            this.releasedAtGranularity = str3;
            this.isFinal = z;
            this.richPresencePatch = richPresencePatch;
            this.playersTotal = j3;
            this.achievementSetVersionHash = achievementSetVersionHash;
            this.achievementsPublished = j4;
            this.pointsTotal = j5;
            this.guideUrl = str4;
            this.updated = updated;
            this.consoleName = consoleName;
            this.parentGameId = str5;
            this.numDistinctPlayers = j6;
            this.numAchievements = j7;
            this.achievements = achievements;
            this.claims = claims;
            this.numDistinctPlayersCasual = j8;
            this.numDistinctPlayersHardcore = j9;
        }

        public final long getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getConsoleId() {
            return this.consoleId;
        }

        public final long getForumTopicId() {
            return this.forumTopicId;
        }

        public final String getFlags() {
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

        public final String getReleasedAtGranularity() {
            return this.releasedAtGranularity;
        }

        public final boolean isFinal() {
            return this.isFinal;
        }

        public final String getRichPresencePatch() {
            return this.richPresencePatch;
        }

        public final long getPlayersTotal() {
            return this.playersTotal;
        }

        public final String getAchievementSetVersionHash() {
            return this.achievementSetVersionHash;
        }

        public final long getAchievementsPublished() {
            return this.achievementsPublished;
        }

        public final long getPointsTotal() {
            return this.pointsTotal;
        }

        public final String getGuideUrl() {
            return this.guideUrl;
        }

        public final String getUpdated() {
            return this.updated;
        }

        public final String getConsoleName() {
            return this.consoleName;
        }

        public final String getParentGameId() {
            return this.parentGameId;
        }

        public final long getNumDistinctPlayers() {
            return this.numDistinctPlayers;
        }

        public final long getNumAchievements() {
            return this.numAchievements;
        }

        public final HashMap<String, Achievement> getAchievements() {
            return this.achievements;
        }

        public final ArrayList<Claim> getClaims() {
            return this.claims;
        }

        public final long getNumDistinctPlayersCasual() {
            return this.numDistinctPlayersCasual;
        }

        public final long getNumDistinctPlayersHardcore() {
            return this.numDistinctPlayersHardcore;
        }

        /* INFO: compiled from: GetGameExtended.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\u008b\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00065"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameExtended$Response$Achievement;", "", "id", "", "numAwarded", "numAwardedHardcore", "title", "", "description", "points", "trueRatio", "author", "dateModified", "badgeName", "displayOrder", "memAddr", "type", "(JJJLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getBadgeName", "getDateModified", "getDescription", "getDisplayOrder", "()J", "getId", "getMemAddr", "getNumAwarded", "getNumAwardedHardcore", "getPoints", "getTitle", "getTrueRatio", "getType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Achievement {

            @SerializedName("Author")
            private final String author;

            @SerializedName("BadgeName")
            private final String badgeName;

            @SerializedName("DateModified")
            private final String dateModified;

            @SerializedName("Description")
            private final String description;

            @SerializedName("DisplayOrder")
            private final long displayOrder;

            @SerializedName("ID")
            private final long id;

            @SerializedName("MemAddr")
            private final String memAddr;

            @SerializedName("NumAwarded")
            private final long numAwarded;

            @SerializedName("NumAwardedHardcore")
            private final long numAwardedHardcore;

            @SerializedName("Points")
            private final long points;

            @SerializedName("Title")
            private final String title;

            @SerializedName("TrueRatio")
            private final long trueRatio;

            @SerializedName("Type")
            private final String type;

            public static /* synthetic */ Achievement copy$default(Achievement achievement, long j, long j2, long j3, String str, String str2, long j4, long j5, String str3, String str4, String str5, long j6, String str6, String str7, int i, Object obj) {
                long j7 = (i & 1) != 0 ? achievement.id : j;
                return achievement.copy(j7, (i & 2) != 0 ? achievement.numAwarded : j2, (i & 4) != 0 ? achievement.numAwardedHardcore : j3, (i & 8) != 0 ? achievement.title : str, (i & 16) != 0 ? achievement.description : str2, (i & 32) != 0 ? achievement.points : j4, (i & 64) != 0 ? achievement.trueRatio : j5, (i & 128) != 0 ? achievement.author : str3, (i & 256) != 0 ? achievement.dateModified : str4, (i & 512) != 0 ? achievement.badgeName : str5, (i & 1024) != 0 ? achievement.displayOrder : j6, (i & 2048) != 0 ? achievement.memAddr : str6, (i & 4096) != 0 ? achievement.type : str7);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* INFO: renamed from: component10, reason: from getter */
            public final String getBadgeName() {
                return this.badgeName;
            }

            /* INFO: renamed from: component11, reason: from getter */
            public final long getDisplayOrder() {
                return this.displayOrder;
            }

            /* INFO: renamed from: component12, reason: from getter */
            public final String getMemAddr() {
                return this.memAddr;
            }

            /* INFO: renamed from: component13, reason: from getter */
            public final String getType() {
                return this.type;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final long getNumAwarded() {
                return this.numAwarded;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final long getNumAwardedHardcore() {
                return this.numAwardedHardcore;
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
            public final long getTrueRatio() {
                return this.trueRatio;
            }

            /* INFO: renamed from: component8, reason: from getter */
            public final String getAuthor() {
                return this.author;
            }

            /* INFO: renamed from: component9, reason: from getter */
            public final String getDateModified() {
                return this.dateModified;
            }

            public final Achievement copy(long id2, long numAwarded, long numAwardedHardcore, String title, String description, long points, long trueRatio, String author, String dateModified, String badgeName, long displayOrder, String memAddr, String type) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(author, "author");
                Intrinsics.checkNotNullParameter(dateModified, "dateModified");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                Intrinsics.checkNotNullParameter(memAddr, "memAddr");
                Intrinsics.checkNotNullParameter(type, "type");
                return new Achievement(id2, numAwarded, numAwardedHardcore, title, description, points, trueRatio, author, dateModified, badgeName, displayOrder, memAddr, type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Achievement)) {
                    return false;
                }
                Achievement achievement = (Achievement) other;
                return this.id == achievement.id && this.numAwarded == achievement.numAwarded && this.numAwardedHardcore == achievement.numAwardedHardcore && Intrinsics.areEqual(this.title, achievement.title) && Intrinsics.areEqual(this.description, achievement.description) && this.points == achievement.points && this.trueRatio == achievement.trueRatio && Intrinsics.areEqual(this.author, achievement.author) && Intrinsics.areEqual(this.dateModified, achievement.dateModified) && Intrinsics.areEqual(this.badgeName, achievement.badgeName) && this.displayOrder == achievement.displayOrder && Intrinsics.areEqual(this.memAddr, achievement.memAddr) && Intrinsics.areEqual(this.type, achievement.type);
            }

            public int hashCode() {
                return (((((((((((((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.numAwarded)) * 31) + Long.hashCode(this.numAwardedHardcore)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Long.hashCode(this.points)) * 31) + Long.hashCode(this.trueRatio)) * 31) + this.author.hashCode()) * 31) + this.dateModified.hashCode()) * 31) + this.badgeName.hashCode()) * 31) + Long.hashCode(this.displayOrder)) * 31) + this.memAddr.hashCode()) * 31) + this.type.hashCode();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Achievement(id=");
                sb.append(this.id).append(", numAwarded=").append(this.numAwarded).append(", numAwardedHardcore=").append(this.numAwardedHardcore).append(", title=").append(this.title).append(", description=").append(this.description).append(", points=").append(this.points).append(", trueRatio=").append(this.trueRatio).append(", author=").append(this.author).append(", dateModified=").append(this.dateModified).append(", badgeName=").append(this.badgeName).append(", displayOrder=").append(this.displayOrder).append(", memAddr=");
                sb.append(this.memAddr).append(", type=").append(this.type).append(')');
                return sb.toString();
            }

            public Achievement(long j, long j2, long j3, String title, String description, long j4, long j5, String author, String dateModified, String badgeName, long j6, String memAddr, String type) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(author, "author");
                Intrinsics.checkNotNullParameter(dateModified, "dateModified");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                Intrinsics.checkNotNullParameter(memAddr, "memAddr");
                Intrinsics.checkNotNullParameter(type, "type");
                this.id = j;
                this.numAwarded = j2;
                this.numAwardedHardcore = j3;
                this.title = title;
                this.description = description;
                this.points = j4;
                this.trueRatio = j5;
                this.author = author;
                this.dateModified = dateModified;
                this.badgeName = badgeName;
                this.displayOrder = j6;
                this.memAddr = memAddr;
                this.type = type;
            }

            public final long getId() {
                return this.id;
            }

            public final long getNumAwarded() {
                return this.numAwarded;
            }

            public final long getNumAwardedHardcore() {
                return this.numAwardedHardcore;
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

            public final long getTrueRatio() {
                return this.trueRatio;
            }

            public final String getAuthor() {
                return this.author;
            }

            public final String getDateModified() {
                return this.dateModified;
            }

            public final String getBadgeName() {
                return this.badgeName;
            }

            public final long getDisplayOrder() {
                return this.displayOrder;
            }

            public final String getMemAddr() {
                return this.memAddr;
            }

            public final String getType() {
                return this.type;
            }
        }

        /* INFO: compiled from: GetGameExtended.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\u009f\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\rHÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018¨\u0006<"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameExtended$Response$Claim;", "", "id", "", ConfigConstants.CONFIG_USER_SECTION, "", "gameId", "gameTitle", "gameIcon", "consoleName", "claimType", "setType", NotificationCompat.CATEGORY_STATUS, "", "extension", "special", ReflogEntry.PREFIX_CREATED, "doneTime", "updated", "minutesLeft", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJIJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getClaimType", "()J", "getConsoleName", "()Ljava/lang/String;", "getCreated", "getDoneTime", "getExtension", "getGameIcon", "getGameId", "getGameTitle", "getId", "getMinutesLeft", "getSetType", "getSpecial", "getStatus", "()I", "getUpdated", "getUser", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Claim {

            @SerializedName("ClaimType")
            private final long claimType;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("Created")
            private final String created;

            @SerializedName("DoneTime")
            private final String doneTime;

            @SerializedName("Extension")
            private final long extension;

            @SerializedName("GameIcon")
            private final String gameIcon;

            @SerializedName("GameID")
            private final String gameId;

            @SerializedName("GameTitle")
            private final String gameTitle;

            @SerializedName("ID")
            private final long id;

            @SerializedName("MinutesLeft")
            private final long minutesLeft;

            @SerializedName("SetType")
            private final long setType;

            @SerializedName("Special")
            private final long special;

            @SerializedName("Status")
            private final int status;

            @SerializedName("Updated")
            private final String updated;

            @SerializedName(SshConstants.USER)
            private final String user;

            public static /* synthetic */ Claim copy$default(Claim claim, long j, String str, String str2, String str3, String str4, String str5, long j2, long j3, int i, long j4, long j5, String str6, String str7, String str8, long j6, int i2, Object obj) {
                long j7;
                String str9;
                long j8 = (i2 & 1) != 0 ? claim.id : j;
                String str10 = (i2 & 2) != 0 ? claim.user : str;
                String str11 = (i2 & 4) != 0 ? claim.gameId : str2;
                String str12 = (i2 & 8) != 0 ? claim.gameTitle : str3;
                String str13 = (i2 & 16) != 0 ? claim.gameIcon : str4;
                String str14 = (i2 & 32) != 0 ? claim.consoleName : str5;
                long j9 = (i2 & 64) != 0 ? claim.claimType : j2;
                long j10 = (i2 & 128) != 0 ? claim.setType : j3;
                int i3 = (i2 & 256) != 0 ? claim.status : i;
                long j11 = (i2 & 512) != 0 ? claim.extension : j4;
                long j12 = j8;
                long j13 = (i2 & 1024) != 0 ? claim.special : j5;
                String str15 = (i2 & 2048) != 0 ? claim.created : str6;
                String str16 = (i2 & 4096) != 0 ? claim.doneTime : str7;
                String str17 = str15;
                String str18 = (i2 & 8192) != 0 ? claim.updated : str8;
                if ((i2 & 16384) != 0) {
                    str9 = str18;
                    j7 = claim.minutesLeft;
                } else {
                    j7 = j6;
                    str9 = str18;
                }
                return claim.copy(j12, str10, str11, str12, str13, str14, j9, j10, i3, j11, j13, str17, str16, str9, j7);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* INFO: renamed from: component10, reason: from getter */
            public final long getExtension() {
                return this.extension;
            }

            /* INFO: renamed from: component11, reason: from getter */
            public final long getSpecial() {
                return this.special;
            }

            /* INFO: renamed from: component12, reason: from getter */
            public final String getCreated() {
                return this.created;
            }

            /* INFO: renamed from: component13, reason: from getter */
            public final String getDoneTime() {
                return this.doneTime;
            }

            /* INFO: renamed from: component14, reason: from getter */
            public final String getUpdated() {
                return this.updated;
            }

            /* INFO: renamed from: component15, reason: from getter */
            public final long getMinutesLeft() {
                return this.minutesLeft;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final String getUser() {
                return this.user;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final String getGameId() {
                return this.gameId;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final String getGameTitle() {
                return this.gameTitle;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final String getGameIcon() {
                return this.gameIcon;
            }

            /* INFO: renamed from: component6, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* INFO: renamed from: component7, reason: from getter */
            public final long getClaimType() {
                return this.claimType;
            }

            /* INFO: renamed from: component8, reason: from getter */
            public final long getSetType() {
                return this.setType;
            }

            /* INFO: renamed from: component9, reason: from getter */
            public final int getStatus() {
                return this.status;
            }

            public final Claim copy(long id2, String user, String gameId, String gameTitle, String gameIcon, String consoleName, long claimType, long setType, int status, long extension, long special, String created, String doneTime, String updated, long minutesLeft) {
                Intrinsics.checkNotNullParameter(user, "user");
                Intrinsics.checkNotNullParameter(gameId, "gameId");
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(created, "created");
                Intrinsics.checkNotNullParameter(doneTime, "doneTime");
                Intrinsics.checkNotNullParameter(updated, "updated");
                return new Claim(id2, user, gameId, gameTitle, gameIcon, consoleName, claimType, setType, status, extension, special, created, doneTime, updated, minutesLeft);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Claim)) {
                    return false;
                }
                Claim claim = (Claim) other;
                return this.id == claim.id && Intrinsics.areEqual(this.user, claim.user) && Intrinsics.areEqual(this.gameId, claim.gameId) && Intrinsics.areEqual(this.gameTitle, claim.gameTitle) && Intrinsics.areEqual(this.gameIcon, claim.gameIcon) && Intrinsics.areEqual(this.consoleName, claim.consoleName) && this.claimType == claim.claimType && this.setType == claim.setType && this.status == claim.status && this.extension == claim.extension && this.special == claim.special && Intrinsics.areEqual(this.created, claim.created) && Intrinsics.areEqual(this.doneTime, claim.doneTime) && Intrinsics.areEqual(this.updated, claim.updated) && this.minutesLeft == claim.minutesLeft;
            }

            public int hashCode() {
                return (((((((((((((((((((((((((((Long.hashCode(this.id) * 31) + this.user.hashCode()) * 31) + this.gameId.hashCode()) * 31) + this.gameTitle.hashCode()) * 31) + this.gameIcon.hashCode()) * 31) + this.consoleName.hashCode()) * 31) + Long.hashCode(this.claimType)) * 31) + Long.hashCode(this.setType)) * 31) + Integer.hashCode(this.status)) * 31) + Long.hashCode(this.extension)) * 31) + Long.hashCode(this.special)) * 31) + this.created.hashCode()) * 31) + this.doneTime.hashCode()) * 31) + this.updated.hashCode()) * 31) + Long.hashCode(this.minutesLeft);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Claim(id=");
                sb.append(this.id).append(", user=").append(this.user).append(", gameId=").append(this.gameId).append(", gameTitle=").append(this.gameTitle).append(", gameIcon=").append(this.gameIcon).append(", consoleName=").append(this.consoleName).append(", claimType=").append(this.claimType).append(", setType=").append(this.setType).append(", status=").append(this.status).append(", extension=").append(this.extension).append(", special=").append(this.special).append(", created=");
                sb.append(this.created).append(", doneTime=").append(this.doneTime).append(", updated=").append(this.updated).append(", minutesLeft=").append(this.minutesLeft).append(')');
                return sb.toString();
            }

            public Claim(long j, String user, String gameId, String gameTitle, String gameIcon, String consoleName, long j2, long j3, int i, long j4, long j5, String created, String doneTime, String updated, long j6) {
                Intrinsics.checkNotNullParameter(user, "user");
                Intrinsics.checkNotNullParameter(gameId, "gameId");
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(created, "created");
                Intrinsics.checkNotNullParameter(doneTime, "doneTime");
                Intrinsics.checkNotNullParameter(updated, "updated");
                this.id = j;
                this.user = user;
                this.gameId = gameId;
                this.gameTitle = gameTitle;
                this.gameIcon = gameIcon;
                this.consoleName = consoleName;
                this.claimType = j2;
                this.setType = j3;
                this.status = i;
                this.extension = j4;
                this.special = j5;
                this.created = created;
                this.doneTime = doneTime;
                this.updated = updated;
                this.minutesLeft = j6;
            }

            public final long getId() {
                return this.id;
            }

            public final String getUser() {
                return this.user;
            }

            public final String getGameId() {
                return this.gameId;
            }

            public final String getGameTitle() {
                return this.gameTitle;
            }

            public final String getGameIcon() {
                return this.gameIcon;
            }

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final long getClaimType() {
                return this.claimType;
            }

            public final long getSetType() {
                return this.setType;
            }

            public final int getStatus() {
                return this.status;
            }

            public final long getExtension() {
                return this.extension;
            }

            public final long getSpecial() {
                return this.special;
            }

            public final String getCreated() {
                return this.created;
            }

            public final String getDoneTime() {
                return this.doneTime;
            }

            public final String getUpdated() {
                return this.updated;
            }

            public final long getMinutesLeft() {
                return this.minutesLeft;
            }
        }
    }
}
