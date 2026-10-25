package org.retroachivements.api.data.pojo.game;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: GetAchievementCount.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetAchievementCount;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetAchievementCount {

    /* JADX INFO: compiled from: GetAchievementCount.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetAchievementCount$Response;", "", "gameId", "", "achievementIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(JLjava/util/ArrayList;)V", "getAchievementIds", "()Ljava/util/ArrayList;", "getGameId", "()J", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("AchievementIDs")
        private final ArrayList<Long> achievementIds;

        @SerializedName("GameID")
        private final long gameId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, long j, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                j = response.gameId;
            }
            if ((i & 2) != 0) {
                arrayList = response.achievementIds;
            }
            return response.copy(j, arrayList);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGameId() {
            return this.gameId;
        }

        public final ArrayList<Long> component2() {
            return this.achievementIds;
        }

        public final Response copy(long gameId, ArrayList<Long> achievementIds) {
            Intrinsics.checkNotNullParameter(achievementIds, "achievementIds");
            return new Response(gameId, achievementIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.gameId == response.gameId && Intrinsics.areEqual(this.achievementIds, response.achievementIds);
        }

        public int hashCode() {
            return (Long.hashCode(this.gameId) * 31) + this.achievementIds.hashCode();
        }

        public String toString() {
            return "Response(gameId=" + this.gameId + ", achievementIds=" + this.achievementIds + ')';
        }

        public Response(long j, ArrayList<Long> achievementIds) {
            Intrinsics.checkNotNullParameter(achievementIds, "achievementIds");
            this.gameId = j;
            this.achievementIds = achievementIds;
        }

        public final long getGameId() {
            return this.gameId;
        }

        public final ArrayList<Long> getAchievementIds() {
            return this.achievementIds;
        }
    }
}
