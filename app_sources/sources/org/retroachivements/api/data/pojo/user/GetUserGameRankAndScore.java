package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;

/* INFO: compiled from: GetUserGameRankAndScore.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserGameRankAndScore;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserGameRankAndScore {

    /* INFO: compiled from: GetUserGameRankAndScore.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserGameRankAndScore$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/user/GetUserGameRankAndScore$Response$RankAndScore;", "Lkotlin/collections/ArrayList;", "()V", "RankAndScore", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<RankAndScore> {

        /* INFO: compiled from: GetUserGameRankAndScore.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserGameRankAndScore$Response$RankAndScore;", "", ConfigConstants.CONFIG_USER_SECTION, "", "totalScore", "", "lastAward", "userRank", "", "(Ljava/lang/String;JLjava/lang/String;I)V", "getLastAward", "()Ljava/lang/String;", "getTotalScore", "()J", "getUser", "getUserRank", "()I", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RankAndScore {

            @SerializedName("LastAward")
            private final String lastAward;

            @SerializedName("TotalScore")
            private final long totalScore;

            @SerializedName(SshConstants.USER)
            private final String user;

            @SerializedName("UserRank")
            private final int userRank;

            public static /* synthetic */ RankAndScore copy$default(RankAndScore rankAndScore, String str, long j, String str2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = rankAndScore.user;
                }
                if ((i2 & 2) != 0) {
                    j = rankAndScore.totalScore;
                }
                if ((i2 & 4) != 0) {
                    str2 = rankAndScore.lastAward;
                }
                if ((i2 & 8) != 0) {
                    i = rankAndScore.userRank;
                }
                return rankAndScore.copy(str, j, str2, i);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final String getUser() {
                return this.user;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final long getTotalScore() {
                return this.totalScore;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final String getLastAward() {
                return this.lastAward;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final int getUserRank() {
                return this.userRank;
            }

            public final RankAndScore copy(String user, long totalScore, String lastAward, int userRank) {
                Intrinsics.checkNotNullParameter(user, "user");
                Intrinsics.checkNotNullParameter(lastAward, "lastAward");
                return new RankAndScore(user, totalScore, lastAward, userRank);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RankAndScore)) {
                    return false;
                }
                RankAndScore rankAndScore = (RankAndScore) other;
                return Intrinsics.areEqual(this.user, rankAndScore.user) && this.totalScore == rankAndScore.totalScore && Intrinsics.areEqual(this.lastAward, rankAndScore.lastAward) && this.userRank == rankAndScore.userRank;
            }

            public int hashCode() {
                return (((((this.user.hashCode() * 31) + Long.hashCode(this.totalScore)) * 31) + this.lastAward.hashCode()) * 31) + Integer.hashCode(this.userRank);
            }

            public String toString() {
                return "RankAndScore(user=" + this.user + ", totalScore=" + this.totalScore + ", lastAward=" + this.lastAward + ", userRank=" + this.userRank + ')';
            }

            public RankAndScore(String user, long j, String lastAward, int i) {
                Intrinsics.checkNotNullParameter(user, "user");
                Intrinsics.checkNotNullParameter(lastAward, "lastAward");
                this.user = user;
                this.totalScore = j;
                this.lastAward = lastAward;
                this.userRank = i;
            }

            public final String getUser() {
                return this.user;
            }

            public final long getTotalScore() {
                return this.totalScore;
            }

            public final String getLastAward() {
                return this.lastAward;
            }

            public final int getUserRank() {
                return this.userRank;
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof RankAndScore) {
                return contains((RankAndScore) obj);
            }
            return false;
        }

        public /* bridge */ boolean contains(RankAndScore rankAndScore) {
            return super.contains((Object) rankAndScore);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof RankAndScore) {
                return indexOf((RankAndScore) obj);
            }
            return -1;
        }

        public /* bridge */ int indexOf(RankAndScore rankAndScore) {
            return super.indexOf((Object) rankAndScore);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof RankAndScore) {
                return lastIndexOf((RankAndScore) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(RankAndScore rankAndScore) {
            return super.lastIndexOf((Object) rankAndScore);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ RankAndScore remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof RankAndScore) {
                return remove((RankAndScore) obj);
            }
            return false;
        }

        public /* bridge */ boolean remove(RankAndScore rankAndScore) {
            return super.remove((Object) rankAndScore);
        }

        public /* bridge */ RankAndScore removeAt(int i) {
            return (RankAndScore) super.remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }
    }
}
