package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: GetUserSetRequests.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserSetRequests;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserSetRequests {

    /* JADX INFO: compiled from: GetUserSetRequests.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserSetRequests$Response;", "", "requestedSets", "", "Lorg/retroachivements/api/data/pojo/user/GetUserSetRequests$Response$Set;", "totalRequests", "", "pointsForNext", "(Ljava/util/List;II)V", "getPointsForNext", "()I", "getRequestedSets", "()Ljava/util/List;", "getTotalRequests", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "", "Set", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("PointsForNext")
        private final int pointsForNext;

        @SerializedName("RequestedSets")
        private final List<Set> requestedSets;

        @SerializedName("TotalRequests")
        private final int totalRequests;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, List list, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = response.requestedSets;
            }
            if ((i3 & 2) != 0) {
                i = response.totalRequests;
            }
            if ((i3 & 4) != 0) {
                i2 = response.pointsForNext;
            }
            return response.copy(list, i, i2);
        }

        public final List<Set> component1() {
            return this.requestedSets;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTotalRequests() {
            return this.totalRequests;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPointsForNext() {
            return this.pointsForNext;
        }

        public final Response copy(List<Set> requestedSets, int totalRequests, int pointsForNext) {
            Intrinsics.checkNotNullParameter(requestedSets, "requestedSets");
            return new Response(requestedSets, totalRequests, pointsForNext);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return Intrinsics.areEqual(this.requestedSets, response.requestedSets) && this.totalRequests == response.totalRequests && this.pointsForNext == response.pointsForNext;
        }

        public int hashCode() {
            return (((this.requestedSets.hashCode() * 31) + Integer.hashCode(this.totalRequests)) * 31) + Integer.hashCode(this.pointsForNext);
        }

        public String toString() {
            return "Response(requestedSets=" + this.requestedSets + ", totalRequests=" + this.totalRequests + ", pointsForNext=" + this.pointsForNext + ')';
        }

        public Response(List<Set> requestedSets, int i, int i2) {
            Intrinsics.checkNotNullParameter(requestedSets, "requestedSets");
            this.requestedSets = requestedSets;
            this.totalRequests = i;
            this.pointsForNext = i2;
        }

        public final List<Set> getRequestedSets() {
            return this.requestedSets;
        }

        public final int getTotalRequests() {
            return this.totalRequests;
        }

        public final int getPointsForNext() {
            return this.pointsForNext;
        }

        /* JADX INFO: compiled from: GetUserSetRequests.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserSetRequests$Response$Set;", "", "gameId", "", "title", "", "consoleId", "consoleName", "imageIcon", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getConsoleId", "()I", "getConsoleName", "()Ljava/lang/String;", "getGameId", "getImageIcon", "getTitle", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Set {

            @SerializedName("ConsoleID")
            private final int consoleId;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("GameID")
            private final int gameId;

            @SerializedName("ImageIcon")
            private final String imageIcon;

            @SerializedName("Title")
            private final String title;

            public static /* synthetic */ Set copy$default(Set set, int i, String str, int i2, String str2, String str3, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = set.gameId;
                }
                if ((i3 & 2) != 0) {
                    str = set.title;
                }
                if ((i3 & 4) != 0) {
                    i2 = set.consoleId;
                }
                if ((i3 & 8) != 0) {
                    str2 = set.consoleName;
                }
                if ((i3 & 16) != 0) {
                    str3 = set.imageIcon;
                }
                String str4 = str3;
                int i4 = i2;
                return set.copy(i, str, i4, str2, str4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getGameId() {
                return this.gameId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getConsoleId() {
                return this.consoleId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getImageIcon() {
                return this.imageIcon;
            }

            public final Set copy(int gameId, String title, int consoleId, String consoleName, String imageIcon) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                return new Set(gameId, title, consoleId, consoleName, imageIcon);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Set)) {
                    return false;
                }
                Set set = (Set) other;
                return this.gameId == set.gameId && Intrinsics.areEqual(this.title, set.title) && this.consoleId == set.consoleId && Intrinsics.areEqual(this.consoleName, set.consoleName) && Intrinsics.areEqual(this.imageIcon, set.imageIcon);
            }

            public int hashCode() {
                return (((((((Integer.hashCode(this.gameId) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.consoleId)) * 31) + this.consoleName.hashCode()) * 31) + this.imageIcon.hashCode();
            }

            public String toString() {
                return "Set(gameId=" + this.gameId + ", title=" + this.title + ", consoleId=" + this.consoleId + ", consoleName=" + this.consoleName + ", imageIcon=" + this.imageIcon + ')';
            }

            public Set(int i, String title, int i2, String consoleName, String imageIcon) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                this.gameId = i;
                this.title = title;
                this.consoleId = i2;
                this.consoleName = consoleName;
                this.imageIcon = imageIcon;
            }

            public final int getGameId() {
                return this.gameId;
            }

            public final String getTitle() {
                return this.title;
            }

            public final int getConsoleId() {
                return this.consoleId;
            }

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final String getImageIcon() {
                return this.imageIcon;
            }
        }
    }
}
