package org.retroachivements.api.data.pojo.game;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;

/* JADX INFO: compiled from: GetGameRankAndScore.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameRankAndScore;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetGameRankAndScore {

    /* JADX INFO: compiled from: GetGameRankAndScore.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameRankAndScore$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/game/GetGameRankAndScore$Response$RankAndScore;", "Lkotlin/collections/ArrayList;", "()V", "RankAndScore", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<RankAndScore> {

        /* JADX INFO: compiled from: GetGameRankAndScore.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameRankAndScore$Response$RankAndScore;", "", ConfigConstants.CONFIG_USER_SECTION, "", "numAchievements", "", "totalScore", "lastAward", "(Ljava/lang/String;JJLjava/lang/String;)V", "getLastAward", "()Ljava/lang/String;", "getNumAchievements", "()J", "getTotalScore", "getUser", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RankAndScore {

            @SerializedName("LastAward")
            private final String lastAward;

            @SerializedName("NumAchievements")
            private final long numAchievements;

            @SerializedName("TotalScore")
            private final long totalScore;

            @SerializedName(SshConstants.USER)
            private final String user;

            public static /* synthetic */ RankAndScore copy$default(RankAndScore rankAndScore, String str, long j, long j2, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = rankAndScore.user;
                }
                if ((i & 2) != 0) {
                    j = rankAndScore.numAchievements;
                }
                if ((i & 4) != 0) {
                    j2 = rankAndScore.totalScore;
                }
                if ((i & 8) != 0) {
                    str2 = rankAndScore.lastAward;
                }
                String str3 = str2;
                return rankAndScore.copy(str, j, j2, str3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUser() {
                return this.user;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getNumAchievements() {
                return this.numAchievements;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getTotalScore() {
                return this.totalScore;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getLastAward() {
                return this.lastAward;
            }

            public final RankAndScore copy(String user, long numAchievements, long totalScore, String lastAward) {
                Intrinsics.checkNotNullParameter(user, "user");
                Intrinsics.checkNotNullParameter(lastAward, "lastAward");
                return new RankAndScore(user, numAchievements, totalScore, lastAward);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RankAndScore)) {
                    return false;
                }
                RankAndScore rankAndScore = (RankAndScore) other;
                return Intrinsics.areEqual(this.user, rankAndScore.user) && this.numAchievements == rankAndScore.numAchievements && this.totalScore == rankAndScore.totalScore && Intrinsics.areEqual(this.lastAward, rankAndScore.lastAward);
            }

            public int hashCode() {
                return (((((this.user.hashCode() * 31) + Long.hashCode(this.numAchievements)) * 31) + Long.hashCode(this.totalScore)) * 31) + this.lastAward.hashCode();
            }

            public String toString() {
                return "RankAndScore(user=" + this.user + ", numAchievements=" + this.numAchievements + ", totalScore=" + this.totalScore + ", lastAward=" + this.lastAward + ')';
            }

            public RankAndScore(String user, long j, long j2, String lastAward) {
                Intrinsics.checkNotNullParameter(user, "user");
                Intrinsics.checkNotNullParameter(lastAward, "lastAward");
                this.user = user;
                this.numAchievements = j;
                this.totalScore = j2;
                this.lastAward = lastAward;
            }

            public final String getUser() {
                return this.user;
            }

            public final long getNumAchievements() {
                return this.numAchievements;
            }

            public final long getTotalScore() {
                return this.totalScore;
            }

            public final String getLastAward() {
                return this.lastAward;
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
