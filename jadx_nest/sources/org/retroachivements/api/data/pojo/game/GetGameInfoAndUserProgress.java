package org.retroachivements.api.data.pojo.game;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* INFO: compiled from: GetGameInfoAndUserProgress.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameInfoAndUserProgress;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetGameInfoAndUserProgress {

    /* INFO: compiled from: GetGameInfoAndUserProgress.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bN\b\u0086\b\u0018\u00002\u00020\u0001:\u0001mB\u009b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\"\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f` \u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u001b\u0012\u0006\u0010$\u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005¢\u0006\u0002\u0010'J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0013HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u001bHÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J%\u0010Z\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f` HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u001bHÆ\u0003J\t\u0010^\u001a\u00020\u001bHÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003JÛ\u0002\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032$\b\u0002\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f` 2\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u0005HÆ\u0001J\u0013\u0010i\u001a\u00020\u00132\b\u0010j\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010k\u001a\u00020\u0003HÖ\u0001J\t\u0010l\u001a\u00020\u0005HÖ\u0001R2\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f` 8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010+R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010-R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010-R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00108R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0016\u0010!\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0016\u0010\"\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0016\u0010\u001a\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010#\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0016\u0010$\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010-R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010-R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0016\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010-R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0016\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010-R\u0016\u0010&\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010-R\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010+¨\u0006n"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameInfoAndUserProgress$Response;", "", "id", "", "title", "", "consoleId", "forumTopicId", "flags", "imageIcon", "imageTitle", "imageInGame", "imageBoxArt", "publisher", "developer", "genre", "released", "releasedAtGranularity", "isFinal", "", "richPresencePatch", "playersTotal", "userTotalPlaytime", "guideUrl", "consoleName", "parentGameId", "numDistinctPlayers", "", "numAchievements", "achievements", "Ljava/util/HashMap;", "Lorg/retroachivements/api/data/pojo/game/GetGameInfoAndUserProgress$Response$Achievement;", "Lkotlin/collections/HashMap;", "numAwardedToUser", "numAwardedToUserHardcore", "numDistinctPlayersCasual", "numDistinctPlayersHardcore", "userCompletion", "userCompletionHardcore", "(ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/util/HashMap;IIJJLjava/lang/String;Ljava/lang/String;)V", "getAchievements", "()Ljava/util/HashMap;", "getConsoleId", "()I", "getConsoleName", "()Ljava/lang/String;", "getDeveloper", "getFlags", "getForumTopicId", "getGenre", "getGuideUrl", "getId", "getImageBoxArt", "getImageIcon", "getImageInGame", "getImageTitle", "()Z", "getNumAchievements", "getNumAwardedToUser", "getNumAwardedToUserHardcore", "getNumDistinctPlayers", "()J", "getNumDistinctPlayersCasual", "getNumDistinctPlayersHardcore", "getParentGameId", "getPlayersTotal", "getPublisher", "getReleased", "getReleasedAtGranularity", "getRichPresencePatch", "getTitle", "getUserCompletion", "getUserCompletionHardcore", "getUserTotalPlaytime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "Achievement", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Achievements")
        private final HashMap<String, Achievement> achievements;

        @SerializedName("ConsoleID")
        private final int consoleId;

        @SerializedName("ConsoleName")
        private final String consoleName;

        @SerializedName("Developer")
        private final String developer;

        @SerializedName("Flags")
        private final String flags;

        @SerializedName("ForumTopicID")
        private final int forumTopicId;

        @SerializedName("Genre")
        private final String genre;

        @SerializedName("GuideURL")
        private final String guideUrl;

        @SerializedName("ID")
        private final int id;

        @SerializedName("ImageBoxArt")
        private final String imageBoxArt;

        @SerializedName("ImageIcon")
        private final String imageIcon;

        @SerializedName("ImageIngame")
        private final String imageInGame;

        @SerializedName("ImageTitle")
        private final String imageTitle;

        @SerializedName("IsFinal")
        @JsonAdapter(BooleanJsonDeserializer.class)
        private final boolean isFinal;

        @SerializedName("NumAchievements")
        private final int numAchievements;

        @SerializedName("NumAwardedToUser")
        private final int numAwardedToUser;

        @SerializedName("NumAwardedToUserHardcore")
        private final int numAwardedToUserHardcore;

        @SerializedName("NumDistinctPlayers")
        private final long numDistinctPlayers;

        @SerializedName("NumDistinctPlayersCasual")
        private final long numDistinctPlayersCasual;

        @SerializedName("NumDistinctPlayersHardcore")
        private final long numDistinctPlayersHardcore;

        @SerializedName("ParentGameID")
        private final String parentGameId;

        @SerializedName("PlayersTotal")
        private final int playersTotal;

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

        @SerializedName("UserCompletion")
        private final String userCompletion;

        @SerializedName("UserCompletionHardcore")
        private final String userCompletionHardcore;

        @SerializedName("UserTotalPlaytime")
        private final int userTotalPlaytime;

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, int i, String str, int i2, int i3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, String str12, int i4, int i5, String str13, String str14, String str15, long j, int i6, HashMap map, int i7, int i8, long j2, long j3, String str16, String str17, int i9, Object obj) {
            int i10 = (i9 & 1) != 0 ? response.id : i;
            String str18 = (i9 & 2) != 0 ? response.title : str;
            int i11 = (i9 & 4) != 0 ? response.consoleId : i2;
            int i12 = (i9 & 8) != 0 ? response.forumTopicId : i3;
            String str19 = (i9 & 16) != 0 ? response.flags : str2;
            String str20 = (i9 & 32) != 0 ? response.imageIcon : str3;
            String str21 = (i9 & 64) != 0 ? response.imageTitle : str4;
            String str22 = (i9 & 128) != 0 ? response.imageInGame : str5;
            String str23 = (i9 & 256) != 0 ? response.imageBoxArt : str6;
            String str24 = (i9 & 512) != 0 ? response.publisher : str7;
            String str25 = (i9 & 1024) != 0 ? response.developer : str8;
            String str26 = (i9 & 2048) != 0 ? response.genre : str9;
            String str27 = (i9 & 4096) != 0 ? response.released : str10;
            String str28 = (i9 & 8192) != 0 ? response.releasedAtGranularity : str11;
            int i13 = i10;
            boolean z2 = (i9 & 16384) != 0 ? response.isFinal : z;
            return response.copy(i13, str18, i11, i12, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, z2, (i9 & 32768) != 0 ? response.richPresencePatch : str12, (i9 & 65536) != 0 ? response.playersTotal : i4, (i9 & 131072) != 0 ? response.userTotalPlaytime : i5, (i9 & 262144) != 0 ? response.guideUrl : str13, (i9 & 524288) != 0 ? response.consoleName : str14, (i9 & 1048576) != 0 ? response.parentGameId : str15, (i9 & 2097152) != 0 ? response.numDistinctPlayers : j, (i9 & 4194304) != 0 ? response.numAchievements : i6, (i9 & 8388608) != 0 ? response.achievements : map, (i9 & 16777216) != 0 ? response.numAwardedToUser : i7, (i9 & MediaHttpDownloader.MAXIMUM_CHUNK_SIZE) != 0 ? response.numAwardedToUserHardcore : i8, (i9 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? response.numDistinctPlayersCasual : j2, (i9 & 134217728) != 0 ? response.numDistinctPlayersHardcore : j3, (i9 & 268435456) != 0 ? response.userCompletion : str16, (i9 & 536870912) != 0 ? response.userCompletionHardcore : str17);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final int getId() {
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
        public final int getPlayersTotal() {
            return this.playersTotal;
        }

        /* INFO: renamed from: component18, reason: from getter */
        public final int getUserTotalPlaytime() {
            return this.userTotalPlaytime;
        }

        /* INFO: renamed from: component19, reason: from getter */
        public final String getGuideUrl() {
            return this.guideUrl;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* INFO: renamed from: component20, reason: from getter */
        public final String getConsoleName() {
            return this.consoleName;
        }

        /* INFO: renamed from: component21, reason: from getter */
        public final String getParentGameId() {
            return this.parentGameId;
        }

        /* INFO: renamed from: component22, reason: from getter */
        public final long getNumDistinctPlayers() {
            return this.numDistinctPlayers;
        }

        /* INFO: renamed from: component23, reason: from getter */
        public final int getNumAchievements() {
            return this.numAchievements;
        }

        public final HashMap<String, Achievement> component24() {
            return this.achievements;
        }

        /* INFO: renamed from: component25, reason: from getter */
        public final int getNumAwardedToUser() {
            return this.numAwardedToUser;
        }

        /* INFO: renamed from: component26, reason: from getter */
        public final int getNumAwardedToUserHardcore() {
            return this.numAwardedToUserHardcore;
        }

        /* INFO: renamed from: component27, reason: from getter */
        public final long getNumDistinctPlayersCasual() {
            return this.numDistinctPlayersCasual;
        }

        /* INFO: renamed from: component28, reason: from getter */
        public final long getNumDistinctPlayersHardcore() {
            return this.numDistinctPlayersHardcore;
        }

        /* INFO: renamed from: component29, reason: from getter */
        public final String getUserCompletion() {
            return this.userCompletion;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final int getConsoleId() {
            return this.consoleId;
        }

        /* INFO: renamed from: component30, reason: from getter */
        public final String getUserCompletionHardcore() {
            return this.userCompletionHardcore;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final int getForumTopicId() {
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

        public final Response copy(int id2, String title, int consoleId, int forumTopicId, String flags, String imageIcon, String imageTitle, String imageInGame, String imageBoxArt, String publisher, String developer, String genre, String released, String releasedAtGranularity, boolean isFinal, String richPresencePatch, int playersTotal, int userTotalPlaytime, String guideUrl, String consoleName, String parentGameId, long numDistinctPlayers, int numAchievements, HashMap<String, Achievement> achievements, int numAwardedToUser, int numAwardedToUserHardcore, long numDistinctPlayersCasual, long numDistinctPlayersHardcore, String userCompletion, String userCompletionHardcore) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            Intrinsics.checkNotNullParameter(imageTitle, "imageTitle");
            Intrinsics.checkNotNullParameter(imageInGame, "imageInGame");
            Intrinsics.checkNotNullParameter(imageBoxArt, "imageBoxArt");
            Intrinsics.checkNotNullParameter(publisher, "publisher");
            Intrinsics.checkNotNullParameter(developer, "developer");
            Intrinsics.checkNotNullParameter(genre, "genre");
            Intrinsics.checkNotNullParameter(richPresencePatch, "richPresencePatch");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(achievements, "achievements");
            Intrinsics.checkNotNullParameter(userCompletion, "userCompletion");
            Intrinsics.checkNotNullParameter(userCompletionHardcore, "userCompletionHardcore");
            return new Response(id2, title, consoleId, forumTopicId, flags, imageIcon, imageTitle, imageInGame, imageBoxArt, publisher, developer, genre, released, releasedAtGranularity, isFinal, richPresencePatch, playersTotal, userTotalPlaytime, guideUrl, consoleName, parentGameId, numDistinctPlayers, numAchievements, achievements, numAwardedToUser, numAwardedToUserHardcore, numDistinctPlayersCasual, numDistinctPlayersHardcore, userCompletion, userCompletionHardcore);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.id == response.id && Intrinsics.areEqual(this.title, response.title) && this.consoleId == response.consoleId && this.forumTopicId == response.forumTopicId && Intrinsics.areEqual(this.flags, response.flags) && Intrinsics.areEqual(this.imageIcon, response.imageIcon) && Intrinsics.areEqual(this.imageTitle, response.imageTitle) && Intrinsics.areEqual(this.imageInGame, response.imageInGame) && Intrinsics.areEqual(this.imageBoxArt, response.imageBoxArt) && Intrinsics.areEqual(this.publisher, response.publisher) && Intrinsics.areEqual(this.developer, response.developer) && Intrinsics.areEqual(this.genre, response.genre) && Intrinsics.areEqual(this.released, response.released) && Intrinsics.areEqual(this.releasedAtGranularity, response.releasedAtGranularity) && this.isFinal == response.isFinal && Intrinsics.areEqual(this.richPresencePatch, response.richPresencePatch) && this.playersTotal == response.playersTotal && this.userTotalPlaytime == response.userTotalPlaytime && Intrinsics.areEqual(this.guideUrl, response.guideUrl) && Intrinsics.areEqual(this.consoleName, response.consoleName) && Intrinsics.areEqual(this.parentGameId, response.parentGameId) && this.numDistinctPlayers == response.numDistinctPlayers && this.numAchievements == response.numAchievements && Intrinsics.areEqual(this.achievements, response.achievements) && this.numAwardedToUser == response.numAwardedToUser && this.numAwardedToUserHardcore == response.numAwardedToUserHardcore && this.numDistinctPlayersCasual == response.numDistinctPlayersCasual && this.numDistinctPlayersHardcore == response.numDistinctPlayersHardcore && Intrinsics.areEqual(this.userCompletion, response.userCompletion) && Intrinsics.areEqual(this.userCompletionHardcore, response.userCompletionHardcore);
        }

        public int hashCode() {
            int iHashCode = ((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.consoleId)) * 31) + Integer.hashCode(this.forumTopicId)) * 31;
            String str = this.flags;
            int iHashCode2 = (((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.imageIcon.hashCode()) * 31) + this.imageTitle.hashCode()) * 31) + this.imageInGame.hashCode()) * 31) + this.imageBoxArt.hashCode()) * 31) + this.publisher.hashCode()) * 31) + this.developer.hashCode()) * 31) + this.genre.hashCode()) * 31;
            String str2 = this.released;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.releasedAtGranularity;
            int iHashCode4 = (((((((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.isFinal)) * 31) + this.richPresencePatch.hashCode()) * 31) + Integer.hashCode(this.playersTotal)) * 31) + Integer.hashCode(this.userTotalPlaytime)) * 31;
            String str4 = this.guideUrl;
            int iHashCode5 = (((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.consoleName.hashCode()) * 31;
            String str5 = this.parentGameId;
            return ((((((((((((((((((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Long.hashCode(this.numDistinctPlayers)) * 31) + Integer.hashCode(this.numAchievements)) * 31) + this.achievements.hashCode()) * 31) + Integer.hashCode(this.numAwardedToUser)) * 31) + Integer.hashCode(this.numAwardedToUserHardcore)) * 31) + Long.hashCode(this.numDistinctPlayersCasual)) * 31) + Long.hashCode(this.numDistinctPlayersHardcore)) * 31) + this.userCompletion.hashCode()) * 31) + this.userCompletionHardcore.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Response(id=");
            sb.append(this.id).append(", title=").append(this.title).append(", consoleId=").append(this.consoleId).append(", forumTopicId=").append(this.forumTopicId).append(", flags=").append(this.flags).append(", imageIcon=").append(this.imageIcon).append(", imageTitle=").append(this.imageTitle).append(", imageInGame=").append(this.imageInGame).append(", imageBoxArt=").append(this.imageBoxArt).append(", publisher=").append(this.publisher).append(", developer=").append(this.developer).append(", genre=");
            sb.append(this.genre).append(", released=").append(this.released).append(", releasedAtGranularity=").append(this.releasedAtGranularity).append(", isFinal=").append(this.isFinal).append(", richPresencePatch=").append(this.richPresencePatch).append(", playersTotal=").append(this.playersTotal).append(", userTotalPlaytime=").append(this.userTotalPlaytime).append(", guideUrl=").append(this.guideUrl).append(", consoleName=").append(this.consoleName).append(", parentGameId=").append(this.parentGameId).append(", numDistinctPlayers=").append(this.numDistinctPlayers).append(", numAchievements=").append(this.numAchievements);
            sb.append(", achievements=").append(this.achievements).append(", numAwardedToUser=").append(this.numAwardedToUser).append(", numAwardedToUserHardcore=").append(this.numAwardedToUserHardcore).append(", numDistinctPlayersCasual=").append(this.numDistinctPlayersCasual).append(", numDistinctPlayersHardcore=").append(this.numDistinctPlayersHardcore).append(", userCompletion=").append(this.userCompletion).append(", userCompletionHardcore=").append(this.userCompletionHardcore).append(')');
            return sb.toString();
        }

        public Response(int i, String title, int i2, int i3, String str, String imageIcon, String imageTitle, String imageInGame, String imageBoxArt, String publisher, String developer, String genre, String str2, String str3, boolean z, String richPresencePatch, int i4, int i5, String str4, String consoleName, String str5, long j, int i6, HashMap<String, Achievement> achievements, int i7, int i8, long j2, long j3, String userCompletion, String userCompletionHardcore) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            Intrinsics.checkNotNullParameter(imageTitle, "imageTitle");
            Intrinsics.checkNotNullParameter(imageInGame, "imageInGame");
            Intrinsics.checkNotNullParameter(imageBoxArt, "imageBoxArt");
            Intrinsics.checkNotNullParameter(publisher, "publisher");
            Intrinsics.checkNotNullParameter(developer, "developer");
            Intrinsics.checkNotNullParameter(genre, "genre");
            Intrinsics.checkNotNullParameter(richPresencePatch, "richPresencePatch");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(achievements, "achievements");
            Intrinsics.checkNotNullParameter(userCompletion, "userCompletion");
            Intrinsics.checkNotNullParameter(userCompletionHardcore, "userCompletionHardcore");
            this.id = i;
            this.title = title;
            this.consoleId = i2;
            this.forumTopicId = i3;
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
            this.playersTotal = i4;
            this.userTotalPlaytime = i5;
            this.guideUrl = str4;
            this.consoleName = consoleName;
            this.parentGameId = str5;
            this.numDistinctPlayers = j;
            this.numAchievements = i6;
            this.achievements = achievements;
            this.numAwardedToUser = i7;
            this.numAwardedToUserHardcore = i8;
            this.numDistinctPlayersCasual = j2;
            this.numDistinctPlayersHardcore = j3;
            this.userCompletion = userCompletion;
            this.userCompletionHardcore = userCompletionHardcore;
        }

        public final int getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getConsoleId() {
            return this.consoleId;
        }

        public final int getForumTopicId() {
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

        public final int getPlayersTotal() {
            return this.playersTotal;
        }

        public final int getUserTotalPlaytime() {
            return this.userTotalPlaytime;
        }

        public final String getGuideUrl() {
            return this.guideUrl;
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

        public final int getNumAchievements() {
            return this.numAchievements;
        }

        public final HashMap<String, Achievement> getAchievements() {
            return this.achievements;
        }

        public final int getNumAwardedToUser() {
            return this.numAwardedToUser;
        }

        public final int getNumAwardedToUserHardcore() {
            return this.numAwardedToUserHardcore;
        }

        public final long getNumDistinctPlayersCasual() {
            return this.numDistinctPlayersCasual;
        }

        public final long getNumDistinctPlayersHardcore() {
            return this.numDistinctPlayersHardcore;
        }

        public final String getUserCompletion() {
            return this.userCompletion;
        }

        public final String getUserCompletionHardcore() {
            return this.userCompletionHardcore;
        }

        /* INFO: compiled from: GetGameInfoAndUserProgress.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J¯\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0010HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006?"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameInfoAndUserProgress$Response$Achievement;", "", "id", "", "numAwarded", "", "numAwardedHardcore", "title", "description", "points", "trueRatio", "author", "dateModified", "dateCreated", "badgeName", "displayOrder", "", "memAddr", "type", "dateEarnedHardcore", "dateEarned", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getBadgeName", "getDateCreated", "getDateEarned", "getDateEarnedHardcore", "getDateModified", "getDescription", "getDisplayOrder", "()I", "getId", "getMemAddr", "getNumAwarded", "()J", "getNumAwardedHardcore", "getPoints", "getTitle", "getTrueRatio", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Achievement {

            @SerializedName("Author")
            private final String author;

            @SerializedName("BadgeName")
            private final String badgeName;

            @SerializedName("DateCreated")
            private final String dateCreated;

            @SerializedName("DateEarned")
            private final String dateEarned;

            @SerializedName("DateEarnedHardcore")
            private final String dateEarnedHardcore;

            @SerializedName("DateModified")
            private final String dateModified;

            @SerializedName("Description")
            private final String description;

            @SerializedName("DisplayOrder")
            private final int displayOrder;

            @SerializedName("ID")
            private final String id;

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

            @SerializedName("type")
            private final String type;

            public static /* synthetic */ Achievement copy$default(Achievement achievement, String str, long j, long j2, String str2, String str3, long j3, long j4, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, String str11, int i2, Object obj) {
                String str12 = (i2 & 1) != 0 ? achievement.id : str;
                return achievement.copy(str12, (i2 & 2) != 0 ? achievement.numAwarded : j, (i2 & 4) != 0 ? achievement.numAwardedHardcore : j2, (i2 & 8) != 0 ? achievement.title : str2, (i2 & 16) != 0 ? achievement.description : str3, (i2 & 32) != 0 ? achievement.points : j3, (i2 & 64) != 0 ? achievement.trueRatio : j4, (i2 & 128) != 0 ? achievement.author : str4, (i2 & 256) != 0 ? achievement.dateModified : str5, (i2 & 512) != 0 ? achievement.dateCreated : str6, (i2 & 1024) != 0 ? achievement.badgeName : str7, (i2 & 2048) != 0 ? achievement.displayOrder : i, (i2 & 4096) != 0 ? achievement.memAddr : str8, (i2 & 8192) != 0 ? achievement.type : str9, (i2 & 16384) != 0 ? achievement.dateEarnedHardcore : str10, (i2 & 32768) != 0 ? achievement.dateEarned : str11);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* INFO: renamed from: component10, reason: from getter */
            public final String getDateCreated() {
                return this.dateCreated;
            }

            /* INFO: renamed from: component11, reason: from getter */
            public final String getBadgeName() {
                return this.badgeName;
            }

            /* INFO: renamed from: component12, reason: from getter */
            public final int getDisplayOrder() {
                return this.displayOrder;
            }

            /* INFO: renamed from: component13, reason: from getter */
            public final String getMemAddr() {
                return this.memAddr;
            }

            /* INFO: renamed from: component14, reason: from getter */
            public final String getType() {
                return this.type;
            }

            /* INFO: renamed from: component15, reason: from getter */
            public final String getDateEarnedHardcore() {
                return this.dateEarnedHardcore;
            }

            /* INFO: renamed from: component16, reason: from getter */
            public final String getDateEarned() {
                return this.dateEarned;
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

            public final Achievement copy(String id2, long numAwarded, long numAwardedHardcore, String title, String description, long points, long trueRatio, String author, String dateModified, String dateCreated, String badgeName, int displayOrder, String memAddr, String type, String dateEarnedHardcore, String dateEarned) {
                Intrinsics.checkNotNullParameter(id2, "id");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(author, "author");
                Intrinsics.checkNotNullParameter(dateModified, "dateModified");
                Intrinsics.checkNotNullParameter(dateCreated, "dateCreated");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                Intrinsics.checkNotNullParameter(memAddr, "memAddr");
                return new Achievement(id2, numAwarded, numAwardedHardcore, title, description, points, trueRatio, author, dateModified, dateCreated, badgeName, displayOrder, memAddr, type, dateEarnedHardcore, dateEarned);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Achievement)) {
                    return false;
                }
                Achievement achievement = (Achievement) other;
                return Intrinsics.areEqual(this.id, achievement.id) && this.numAwarded == achievement.numAwarded && this.numAwardedHardcore == achievement.numAwardedHardcore && Intrinsics.areEqual(this.title, achievement.title) && Intrinsics.areEqual(this.description, achievement.description) && this.points == achievement.points && this.trueRatio == achievement.trueRatio && Intrinsics.areEqual(this.author, achievement.author) && Intrinsics.areEqual(this.dateModified, achievement.dateModified) && Intrinsics.areEqual(this.dateCreated, achievement.dateCreated) && Intrinsics.areEqual(this.badgeName, achievement.badgeName) && this.displayOrder == achievement.displayOrder && Intrinsics.areEqual(this.memAddr, achievement.memAddr) && Intrinsics.areEqual(this.type, achievement.type) && Intrinsics.areEqual(this.dateEarnedHardcore, achievement.dateEarnedHardcore) && Intrinsics.areEqual(this.dateEarned, achievement.dateEarned);
            }

            public int hashCode() {
                int iHashCode = ((((((((((((((((((((((((this.id.hashCode() * 31) + Long.hashCode(this.numAwarded)) * 31) + Long.hashCode(this.numAwardedHardcore)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Long.hashCode(this.points)) * 31) + Long.hashCode(this.trueRatio)) * 31) + this.author.hashCode()) * 31) + this.dateModified.hashCode()) * 31) + this.dateCreated.hashCode()) * 31) + this.badgeName.hashCode()) * 31) + Integer.hashCode(this.displayOrder)) * 31) + this.memAddr.hashCode()) * 31;
                String str = this.type;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.dateEarnedHardcore;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.dateEarned;
                return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Achievement(id=");
                sb.append(this.id).append(", numAwarded=").append(this.numAwarded).append(", numAwardedHardcore=").append(this.numAwardedHardcore).append(", title=").append(this.title).append(", description=").append(this.description).append(", points=").append(this.points).append(", trueRatio=").append(this.trueRatio).append(", author=").append(this.author).append(", dateModified=").append(this.dateModified).append(", dateCreated=").append(this.dateCreated).append(", badgeName=").append(this.badgeName).append(", displayOrder=");
                sb.append(this.displayOrder).append(", memAddr=").append(this.memAddr).append(", type=").append(this.type).append(", dateEarnedHardcore=").append(this.dateEarnedHardcore).append(", dateEarned=").append(this.dateEarned).append(')');
                return sb.toString();
            }

            public Achievement(String id2, long j, long j2, String title, String description, long j3, long j4, String author, String dateModified, String dateCreated, String badgeName, int i, String memAddr, String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(id2, "id");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(author, "author");
                Intrinsics.checkNotNullParameter(dateModified, "dateModified");
                Intrinsics.checkNotNullParameter(dateCreated, "dateCreated");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                Intrinsics.checkNotNullParameter(memAddr, "memAddr");
                this.id = id2;
                this.numAwarded = j;
                this.numAwardedHardcore = j2;
                this.title = title;
                this.description = description;
                this.points = j3;
                this.trueRatio = j4;
                this.author = author;
                this.dateModified = dateModified;
                this.dateCreated = dateCreated;
                this.badgeName = badgeName;
                this.displayOrder = i;
                this.memAddr = memAddr;
                this.type = str;
                this.dateEarnedHardcore = str2;
                this.dateEarned = str3;
            }

            public final String getId() {
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

            public final String getDateCreated() {
                return this.dateCreated;
            }

            public final String getBadgeName() {
                return this.badgeName;
            }

            public final int getDisplayOrder() {
                return this.displayOrder;
            }

            public final String getMemAddr() {
                return this.memAddr;
            }

            public final String getType() {
                return this.type;
            }

            public final String getDateEarnedHardcore() {
                return this.dateEarnedHardcore;
            }

            public final String getDateEarned() {
                return this.dateEarned;
            }
        }
    }
}
