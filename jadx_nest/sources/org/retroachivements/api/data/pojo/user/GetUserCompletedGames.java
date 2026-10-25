package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* JADX INFO: compiled from: GetUserCompletedGames.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserCompletedGames;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserCompletedGames {

    /* JADX INFO: compiled from: GetUserCompletedGames.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserCompletedGames$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/user/GetUserCompletedGames$Response$Game;", "Lkotlin/collections/ArrayList;", "()V", "Game", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<Game> {

        /* JADX INFO: compiled from: GetUserCompletedGames.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006*"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserCompletedGames$Response$Game;", "", "gameId", "", "title", "", "imageIcon", "consoleId", "consoleName", "maxPossible", "numAwarded", "pctWon", "hardcoreMode", "", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JJLjava/lang/String;Z)V", "getConsoleId", "()J", "getConsoleName", "()Ljava/lang/String;", "getGameId", "getHardcoreMode", "()Z", "getImageIcon", "getMaxPossible", "getNumAwarded", "getPctWon", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Game {

            @SerializedName("ConsoleID")
            private final long consoleId;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("GameID")
            private final long gameId;

            @SerializedName("HardcoreMode")
            @JsonAdapter(BooleanJsonDeserializer.class)
            private final boolean hardcoreMode;

            @SerializedName("ImageIcon")
            private final String imageIcon;

            @SerializedName("MaxPossible")
            private final long maxPossible;

            @SerializedName("NumAwarded")
            private final long numAwarded;

            @SerializedName("PctWon")
            private final String pctWon;

            @SerializedName("Title")
            private final String title;

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGameId() {
                return this.gameId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getImageIcon() {
                return this.imageIcon;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final long getConsoleId() {
                return this.consoleId;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final long getMaxPossible() {
                return this.maxPossible;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final long getNumAwarded() {
                return this.numAwarded;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final String getPctWon() {
                return this.pctWon;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final boolean getHardcoreMode() {
                return this.hardcoreMode;
            }

            public final Game copy(long gameId, String title, String imageIcon, long consoleId, String consoleName, long maxPossible, long numAwarded, String pctWon, boolean hardcoreMode) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(pctWon, "pctWon");
                return new Game(gameId, title, imageIcon, consoleId, consoleName, maxPossible, numAwarded, pctWon, hardcoreMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Game)) {
                    return false;
                }
                Game game = (Game) other;
                return this.gameId == game.gameId && Intrinsics.areEqual(this.title, game.title) && Intrinsics.areEqual(this.imageIcon, game.imageIcon) && this.consoleId == game.consoleId && Intrinsics.areEqual(this.consoleName, game.consoleName) && this.maxPossible == game.maxPossible && this.numAwarded == game.numAwarded && Intrinsics.areEqual(this.pctWon, game.pctWon) && this.hardcoreMode == game.hardcoreMode;
            }

            public int hashCode() {
                return (((((((((((((((Long.hashCode(this.gameId) * 31) + this.title.hashCode()) * 31) + this.imageIcon.hashCode()) * 31) + Long.hashCode(this.consoleId)) * 31) + this.consoleName.hashCode()) * 31) + Long.hashCode(this.maxPossible)) * 31) + Long.hashCode(this.numAwarded)) * 31) + this.pctWon.hashCode()) * 31) + Boolean.hashCode(this.hardcoreMode);
            }

            public String toString() {
                return "Game(gameId=" + this.gameId + ", title=" + this.title + ", imageIcon=" + this.imageIcon + ", consoleId=" + this.consoleId + ", consoleName=" + this.consoleName + ", maxPossible=" + this.maxPossible + ", numAwarded=" + this.numAwarded + ", pctWon=" + this.pctWon + ", hardcoreMode=" + this.hardcoreMode + ')';
            }

            public Game(long j, String title, String imageIcon, long j2, String consoleName, long j3, long j4, String pctWon, boolean z) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(pctWon, "pctWon");
                this.gameId = j;
                this.title = title;
                this.imageIcon = imageIcon;
                this.consoleId = j2;
                this.consoleName = consoleName;
                this.maxPossible = j3;
                this.numAwarded = j4;
                this.pctWon = pctWon;
                this.hardcoreMode = z;
            }

            public final long getGameId() {
                return this.gameId;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getImageIcon() {
                return this.imageIcon;
            }

            public final long getConsoleId() {
                return this.consoleId;
            }

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final long getMaxPossible() {
                return this.maxPossible;
            }

            public final long getNumAwarded() {
                return this.numAwarded;
            }

            public final String getPctWon() {
                return this.pctWon;
            }

            public final boolean getHardcoreMode() {
                return this.hardcoreMode;
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
