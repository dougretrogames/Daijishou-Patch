package org.retroachivements.api.data.pojo.game;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: GetGame.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGame;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetGame {

    /* INFO: compiled from: GetGame.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003JÁ\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006B"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGame$Response;", "", "id", "", "title", "forumTopicID", "consoleID", "consoleName", "flags", "imageIcon", "gameIcon", "imageTitle", "imageIngame", "imageBoxArt", "publisher", "developer", "genre", "released", "releasedAtGranularity", "gameTitle", "console", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConsole", "()Ljava/lang/String;", "getConsoleID", "getConsoleName", "getDeveloper", "getFlags", "getForumTopicID", "getGameIcon", "getGameTitle", "getGenre", "getId", "getImageBoxArt", "getImageIcon", "getImageIngame", "getImageTitle", "getPublisher", "getReleased", "getReleasedAtGranularity", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Console")
        private final String console;

        @SerializedName("ConsoleID")
        private final String consoleID;

        @SerializedName("ConsoleName")
        private final String consoleName;

        @SerializedName("Developer")
        private final String developer;

        @SerializedName("Flags")
        private final String flags;

        @SerializedName("ForumTopicID")
        private final String forumTopicID;

        @SerializedName("GameIcon")
        private final String gameIcon;

        @SerializedName("GameTitle")
        private final String gameTitle;

        @SerializedName("Genre")
        private final String genre;

        @SerializedName("ID")
        private final String id;

        @SerializedName("ImageBoxArt")
        private final String imageBoxArt;

        @SerializedName("ImageIcon")
        private final String imageIcon;

        @SerializedName("ImageIngame")
        private final String imageIngame;

        @SerializedName("ImageTitle")
        private final String imageTitle;

        @SerializedName("Publisher")
        private final String publisher;

        @SerializedName("Released")
        private final String released;

        @SerializedName("ReleasedAtGranularity")
        private final String releasedAtGranularity;

        @SerializedName("Title")
        private final String title;

        public static /* synthetic */ Response copy$default(Response response, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i, Object obj) {
            String str19;
            String str20;
            String str21 = (i & 1) != 0 ? response.id : str;
            String str22 = (i & 2) != 0 ? response.title : str2;
            String str23 = (i & 4) != 0 ? response.forumTopicID : str3;
            String str24 = (i & 8) != 0 ? response.consoleID : str4;
            String str25 = (i & 16) != 0 ? response.consoleName : str5;
            String str26 = (i & 32) != 0 ? response.flags : str6;
            String str27 = (i & 64) != 0 ? response.imageIcon : str7;
            String str28 = (i & 128) != 0 ? response.gameIcon : str8;
            String str29 = (i & 256) != 0 ? response.imageTitle : str9;
            String str30 = (i & 512) != 0 ? response.imageIngame : str10;
            String str31 = (i & 1024) != 0 ? response.imageBoxArt : str11;
            String str32 = (i & 2048) != 0 ? response.publisher : str12;
            String str33 = (i & 4096) != 0 ? response.developer : str13;
            String str34 = (i & 8192) != 0 ? response.genre : str14;
            String str35 = str21;
            String str36 = (i & 16384) != 0 ? response.released : str15;
            String str37 = (i & 32768) != 0 ? response.releasedAtGranularity : str16;
            String str38 = (i & 65536) != 0 ? response.gameTitle : str17;
            if ((i & 131072) != 0) {
                str20 = str38;
                str19 = response.console;
            } else {
                str19 = str18;
                str20 = str38;
            }
            return response.copy(str35, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str36, str37, str20, str19);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* INFO: renamed from: component10, reason: from getter */
        public final String getImageIngame() {
            return this.imageIngame;
        }

        /* INFO: renamed from: component11, reason: from getter */
        public final String getImageBoxArt() {
            return this.imageBoxArt;
        }

        /* INFO: renamed from: component12, reason: from getter */
        public final String getPublisher() {
            return this.publisher;
        }

        /* INFO: renamed from: component13, reason: from getter */
        public final String getDeveloper() {
            return this.developer;
        }

        /* INFO: renamed from: component14, reason: from getter */
        public final String getGenre() {
            return this.genre;
        }

        /* INFO: renamed from: component15, reason: from getter */
        public final String getReleased() {
            return this.released;
        }

        /* INFO: renamed from: component16, reason: from getter */
        public final String getReleasedAtGranularity() {
            return this.releasedAtGranularity;
        }

        /* INFO: renamed from: component17, reason: from getter */
        public final String getGameTitle() {
            return this.gameTitle;
        }

        /* INFO: renamed from: component18, reason: from getter */
        public final String getConsole() {
            return this.console;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getForumTopicID() {
            return this.forumTopicID;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final String getConsoleID() {
            return this.consoleID;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final String getConsoleName() {
            return this.consoleName;
        }

        /* INFO: renamed from: component6, reason: from getter */
        public final String getFlags() {
            return this.flags;
        }

        /* INFO: renamed from: component7, reason: from getter */
        public final String getImageIcon() {
            return this.imageIcon;
        }

        /* INFO: renamed from: component8, reason: from getter */
        public final String getGameIcon() {
            return this.gameIcon;
        }

        /* INFO: renamed from: component9, reason: from getter */
        public final String getImageTitle() {
            return this.imageTitle;
        }

        public final Response copy(String id2, String title, String forumTopicID, String consoleID, String consoleName, String flags, String imageIcon, String gameIcon, String imageTitle, String imageIngame, String imageBoxArt, String publisher, String developer, String genre, String released, String releasedAtGranularity, String gameTitle, String console) {
            Intrinsics.checkNotNullParameter(id2, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(forumTopicID, "forumTopicID");
            Intrinsics.checkNotNullParameter(consoleID, "consoleID");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(flags, "flags");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
            Intrinsics.checkNotNullParameter(imageTitle, "imageTitle");
            Intrinsics.checkNotNullParameter(imageIngame, "imageIngame");
            Intrinsics.checkNotNullParameter(imageBoxArt, "imageBoxArt");
            Intrinsics.checkNotNullParameter(publisher, "publisher");
            Intrinsics.checkNotNullParameter(developer, "developer");
            Intrinsics.checkNotNullParameter(genre, "genre");
            Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
            Intrinsics.checkNotNullParameter(console, "console");
            return new Response(id2, title, forumTopicID, consoleID, consoleName, flags, imageIcon, gameIcon, imageTitle, imageIngame, imageBoxArt, publisher, developer, genre, released, releasedAtGranularity, gameTitle, console);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return Intrinsics.areEqual(this.id, response.id) && Intrinsics.areEqual(this.title, response.title) && Intrinsics.areEqual(this.forumTopicID, response.forumTopicID) && Intrinsics.areEqual(this.consoleID, response.consoleID) && Intrinsics.areEqual(this.consoleName, response.consoleName) && Intrinsics.areEqual(this.flags, response.flags) && Intrinsics.areEqual(this.imageIcon, response.imageIcon) && Intrinsics.areEqual(this.gameIcon, response.gameIcon) && Intrinsics.areEqual(this.imageTitle, response.imageTitle) && Intrinsics.areEqual(this.imageIngame, response.imageIngame) && Intrinsics.areEqual(this.imageBoxArt, response.imageBoxArt) && Intrinsics.areEqual(this.publisher, response.publisher) && Intrinsics.areEqual(this.developer, response.developer) && Intrinsics.areEqual(this.genre, response.genre) && Intrinsics.areEqual(this.released, response.released) && Intrinsics.areEqual(this.releasedAtGranularity, response.releasedAtGranularity) && Intrinsics.areEqual(this.gameTitle, response.gameTitle) && Intrinsics.areEqual(this.console, response.console);
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((((((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.forumTopicID.hashCode()) * 31) + this.consoleID.hashCode()) * 31) + this.consoleName.hashCode()) * 31) + this.flags.hashCode()) * 31) + this.imageIcon.hashCode()) * 31) + this.gameIcon.hashCode()) * 31) + this.imageTitle.hashCode()) * 31) + this.imageIngame.hashCode()) * 31) + this.imageBoxArt.hashCode()) * 31) + this.publisher.hashCode()) * 31) + this.developer.hashCode()) * 31) + this.genre.hashCode()) * 31;
            String str = this.released;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.releasedAtGranularity;
            return ((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.gameTitle.hashCode()) * 31) + this.console.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Response(id=");
            sb.append(this.id).append(", title=").append(this.title).append(", forumTopicID=").append(this.forumTopicID).append(", consoleID=").append(this.consoleID).append(", consoleName=").append(this.consoleName).append(", flags=").append(this.flags).append(", imageIcon=").append(this.imageIcon).append(", gameIcon=").append(this.gameIcon).append(", imageTitle=").append(this.imageTitle).append(", imageIngame=").append(this.imageIngame).append(", imageBoxArt=").append(this.imageBoxArt).append(", publisher=");
            sb.append(this.publisher).append(", developer=").append(this.developer).append(", genre=").append(this.genre).append(", released=").append(this.released).append(", releasedAtGranularity=").append(this.releasedAtGranularity).append(", gameTitle=").append(this.gameTitle).append(", console=").append(this.console).append(')');
            return sb.toString();
        }

        public Response(String id2, String title, String forumTopicID, String consoleID, String consoleName, String flags, String imageIcon, String gameIcon, String imageTitle, String imageIngame, String imageBoxArt, String publisher, String developer, String genre, String str, String str2, String gameTitle, String console) {
            Intrinsics.checkNotNullParameter(id2, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(forumTopicID, "forumTopicID");
            Intrinsics.checkNotNullParameter(consoleID, "consoleID");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(flags, "flags");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
            Intrinsics.checkNotNullParameter(imageTitle, "imageTitle");
            Intrinsics.checkNotNullParameter(imageIngame, "imageIngame");
            Intrinsics.checkNotNullParameter(imageBoxArt, "imageBoxArt");
            Intrinsics.checkNotNullParameter(publisher, "publisher");
            Intrinsics.checkNotNullParameter(developer, "developer");
            Intrinsics.checkNotNullParameter(genre, "genre");
            Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
            Intrinsics.checkNotNullParameter(console, "console");
            this.id = id2;
            this.title = title;
            this.forumTopicID = forumTopicID;
            this.consoleID = consoleID;
            this.consoleName = consoleName;
            this.flags = flags;
            this.imageIcon = imageIcon;
            this.gameIcon = gameIcon;
            this.imageTitle = imageTitle;
            this.imageIngame = imageIngame;
            this.imageBoxArt = imageBoxArt;
            this.publisher = publisher;
            this.developer = developer;
            this.genre = genre;
            this.released = str;
            this.releasedAtGranularity = str2;
            this.gameTitle = gameTitle;
            this.console = console;
        }

        public final String getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getForumTopicID() {
            return this.forumTopicID;
        }

        public final String getConsoleID() {
            return this.consoleID;
        }

        public final String getConsoleName() {
            return this.consoleName;
        }

        public final String getFlags() {
            return this.flags;
        }

        public final String getImageIcon() {
            return this.imageIcon;
        }

        public final String getGameIcon() {
            return this.gameIcon;
        }

        public final String getImageTitle() {
            return this.imageTitle;
        }

        public final String getImageIngame() {
            return this.imageIngame;
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

        public final String getGameTitle() {
            return this.gameTitle;
        }

        public final String getConsole() {
            return this.console;
        }
    }
}
