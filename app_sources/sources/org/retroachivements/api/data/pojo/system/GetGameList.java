package org.retroachivements.api.data.pojo.system;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: GetGameList.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/system/GetGameList;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetGameList {

    /* INFO: compiled from: GetGameList.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/system/GetGameList$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/system/GetGameList$Response$Game;", "Lkotlin/collections/ArrayList;", "()V", "Game", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<Game> {

        /* INFO: compiled from: GetGameList.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0010j\b\u0012\u0004\u0012\u00020\u0005`\u0011¢\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0019\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0010j\b\u0012\u0004\u0012\u00020\u0005`\u0011HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0089\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0010j\b\u0012\u0004\u0012\u00020\u0005`\u0011HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\nHÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0010j\b\u0012\u0004\u0012\u00020\u0005`\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u00063"}, d2 = {"Lorg/retroachivements/api/data/pojo/system/GetGameList$Response$Game;", "", "id", "", "title", "", "consoleId", "consoleName", "imageIcon", "numAchievements", "", "numLeaderboards", "points", "dateModified", "forumTopicId", "hashes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;IJJLjava/lang/String;JLjava/util/ArrayList;)V", "getConsoleId", "()J", "getConsoleName", "()Ljava/lang/String;", "getDateModified", "getForumTopicId", "getHashes", "()Ljava/util/ArrayList;", "getId", "getImageIcon", "getNumAchievements", "()I", "getNumLeaderboards", "getPoints", "getTitle", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Game {

            @SerializedName("ConsoleID")
            private final long consoleId;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("DateModified")
            private final String dateModified;

            @SerializedName("ForumTopicID")
            private final long forumTopicId;

            @SerializedName("Hashes")
            private final ArrayList<String> hashes;

            @SerializedName("ID")
            private final long id;

            @SerializedName("ImageIcon")
            private final String imageIcon;

            @SerializedName("NumAchievements")
            private final int numAchievements;

            @SerializedName("NumLeaderboards")
            private final long numLeaderboards;

            @SerializedName("Points")
            private final long points;

            @SerializedName("Title")
            private final String title;

            /* INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* INFO: renamed from: component10, reason: from getter */
            public final long getForumTopicId() {
                return this.forumTopicId;
            }

            public final ArrayList<String> component11() {
                return this.hashes;
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
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final String getImageIcon() {
                return this.imageIcon;
            }

            /* INFO: renamed from: component6, reason: from getter */
            public final int getNumAchievements() {
                return this.numAchievements;
            }

            /* INFO: renamed from: component7, reason: from getter */
            public final long getNumLeaderboards() {
                return this.numLeaderboards;
            }

            /* INFO: renamed from: component8, reason: from getter */
            public final long getPoints() {
                return this.points;
            }

            /* INFO: renamed from: component9, reason: from getter */
            public final String getDateModified() {
                return this.dateModified;
            }

            public final Game copy(long id2, String title, long consoleId, String consoleName, String imageIcon, int numAchievements, long numLeaderboards, long points, String dateModified, long forumTopicId, ArrayList<String> hashes) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                Intrinsics.checkNotNullParameter(hashes, "hashes");
                return new Game(id2, title, consoleId, consoleName, imageIcon, numAchievements, numLeaderboards, points, dateModified, forumTopicId, hashes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Game)) {
                    return false;
                }
                Game game = (Game) other;
                return this.id == game.id && Intrinsics.areEqual(this.title, game.title) && this.consoleId == game.consoleId && Intrinsics.areEqual(this.consoleName, game.consoleName) && Intrinsics.areEqual(this.imageIcon, game.imageIcon) && this.numAchievements == game.numAchievements && this.numLeaderboards == game.numLeaderboards && this.points == game.points && Intrinsics.areEqual(this.dateModified, game.dateModified) && this.forumTopicId == game.forumTopicId && Intrinsics.areEqual(this.hashes, game.hashes);
            }

            public int hashCode() {
                int iHashCode = ((((((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.consoleId)) * 31) + this.consoleName.hashCode()) * 31) + this.imageIcon.hashCode()) * 31) + Integer.hashCode(this.numAchievements)) * 31) + Long.hashCode(this.numLeaderboards)) * 31) + Long.hashCode(this.points)) * 31;
                String str = this.dateModified;
                return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.forumTopicId)) * 31) + this.hashes.hashCode();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Game(id=");
                sb.append(this.id).append(", title=").append(this.title).append(", consoleId=").append(this.consoleId).append(", consoleName=").append(this.consoleName).append(", imageIcon=").append(this.imageIcon).append(", numAchievements=").append(this.numAchievements).append(", numLeaderboards=").append(this.numLeaderboards).append(", points=").append(this.points).append(", dateModified=").append(this.dateModified).append(", forumTopicId=").append(this.forumTopicId).append(", hashes=").append(this.hashes).append(')');
                return sb.toString();
            }

            public Game(long j, String title, long j2, String consoleName, String imageIcon, int i, long j3, long j4, String str, long j5, ArrayList<String> hashes) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                Intrinsics.checkNotNullParameter(hashes, "hashes");
                this.id = j;
                this.title = title;
                this.consoleId = j2;
                this.consoleName = consoleName;
                this.imageIcon = imageIcon;
                this.numAchievements = i;
                this.numLeaderboards = j3;
                this.points = j4;
                this.dateModified = str;
                this.forumTopicId = j5;
                this.hashes = hashes;
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

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final String getImageIcon() {
                return this.imageIcon;
            }

            public final int getNumAchievements() {
                return this.numAchievements;
            }

            public final long getNumLeaderboards() {
                return this.numLeaderboards;
            }

            public final long getPoints() {
                return this.points;
            }

            public final String getDateModified() {
                return this.dateModified;
            }

            public final long getForumTopicId() {
                return this.forumTopicId;
            }

            public final ArrayList<String> getHashes() {
                return this.hashes;
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Game) {
                return contains((Game) obj);
            }
            return false;
        }

        public /* bridge */ boolean contains(Game game) {
            return super.contains((Object) game);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Game) {
                return indexOf((Game) obj);
            }
            return -1;
        }

        public /* bridge */ int indexOf(Game game) {
            return super.indexOf((Object) game);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Game) {
                return lastIndexOf((Game) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(Game game) {
            return super.lastIndexOf((Object) game);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ Game remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof Game) {
                return remove((Game) obj);
            }
            return false;
        }

        public /* bridge */ boolean remove(Game game) {
            return super.remove((Object) game);
        }

        public /* bridge */ Game removeAt(int i) {
            return (Game) super.remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }
    }
}
