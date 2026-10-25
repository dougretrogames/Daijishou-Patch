package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: GetUserProgress.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserProgress;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserProgress {

    /* JADX INFO: compiled from: GetUserProgress.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserProgress$Response;", "Ljava/util/HashMap;", "", "Lorg/retroachivements/api/data/pojo/user/GetUserProgress$Response$Progress;", "Lkotlin/collections/HashMap;", "()V", "Progress", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends HashMap<String, Progress> {

        /* JADX INFO: compiled from: GetUserProgress.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserProgress$Response$Progress;", "", "numPossibleAchievements", "", "possibleScore", "numAchieved", "scoreAchieved", "numAchievedHardcore", "scoreAchievedHardcore", "(JJJJJJ)V", "getNumAchieved", "()J", "getNumAchievedHardcore", "getNumPossibleAchievements", "getPossibleScore", "getScoreAchieved", "getScoreAchievedHardcore", "component1", "component2", "component3", "component4", "component5", "component6", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Progress {

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

            public static /* synthetic */ Progress copy$default(Progress progress, long j, long j2, long j3, long j4, long j5, long j6, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = progress.numPossibleAchievements;
                }
                return progress.copy(j, (i & 2) != 0 ? progress.possibleScore : j2, (i & 4) != 0 ? progress.numAchieved : j3, (i & 8) != 0 ? progress.scoreAchieved : j4, (i & 16) != 0 ? progress.numAchievedHardcore : j5, (i & 32) != 0 ? progress.scoreAchievedHardcore : j6);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getNumPossibleAchievements() {
                return this.numPossibleAchievements;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getPossibleScore() {
                return this.possibleScore;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getNumAchieved() {
                return this.numAchieved;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final long getScoreAchieved() {
                return this.scoreAchieved;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final long getNumAchievedHardcore() {
                return this.numAchievedHardcore;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final long getScoreAchievedHardcore() {
                return this.scoreAchievedHardcore;
            }

            public final Progress copy(long numPossibleAchievements, long possibleScore, long numAchieved, long scoreAchieved, long numAchievedHardcore, long scoreAchievedHardcore) {
                return new Progress(numPossibleAchievements, possibleScore, numAchieved, scoreAchieved, numAchievedHardcore, scoreAchievedHardcore);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Progress)) {
                    return false;
                }
                Progress progress = (Progress) other;
                return this.numPossibleAchievements == progress.numPossibleAchievements && this.possibleScore == progress.possibleScore && this.numAchieved == progress.numAchieved && this.scoreAchieved == progress.scoreAchieved && this.numAchievedHardcore == progress.numAchievedHardcore && this.scoreAchievedHardcore == progress.scoreAchievedHardcore;
            }

            public int hashCode() {
                return (((((((((Long.hashCode(this.numPossibleAchievements) * 31) + Long.hashCode(this.possibleScore)) * 31) + Long.hashCode(this.numAchieved)) * 31) + Long.hashCode(this.scoreAchieved)) * 31) + Long.hashCode(this.numAchievedHardcore)) * 31) + Long.hashCode(this.scoreAchievedHardcore);
            }

            public String toString() {
                return "Progress(numPossibleAchievements=" + this.numPossibleAchievements + ", possibleScore=" + this.possibleScore + ", numAchieved=" + this.numAchieved + ", scoreAchieved=" + this.scoreAchieved + ", numAchievedHardcore=" + this.numAchievedHardcore + ", scoreAchievedHardcore=" + this.scoreAchievedHardcore + ')';
            }

            public Progress(long j, long j2, long j3, long j4, long j5, long j6) {
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

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Progress) {
                return containsValue((Progress) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(Progress progress) {
            return super.containsValue((Object) progress);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Progress>> entrySet() {
            return getEntries();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Progress get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ Progress get(String str) {
            return (Progress) super.get((Object) str);
        }

        public /* bridge */ Set<Map.Entry<String, Progress>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Progress) obj2);
        }

        public final /* bridge */ Progress getOrDefault(Object obj, Progress progress) {
            return !(obj instanceof String) ? progress : getOrDefault((String) obj, progress);
        }

        public /* bridge */ Progress getOrDefault(String str, Progress progress) {
            return (Progress) super.getOrDefault((Object) str, progress);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<Progress> getValues() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Progress remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        public /* bridge */ Progress remove(String str) {
            return (Progress) super.remove((Object) str);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof Progress)) {
                return remove((String) obj, (Progress) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str, Progress progress) {
            return super.remove((Object) str, (Object) progress);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Progress> values() {
            return getValues();
        }
    }
}
