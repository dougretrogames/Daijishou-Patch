package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: GetUserPoints.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserPoints;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserPoints {

    /* INFO: compiled from: GetUserPoints.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserPoints$Response;", "", "points", "", "softcorePoints", "(JJ)V", "getPoints", "()J", "getSoftcorePoints", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Points")
        private final long points;

        @SerializedName("SoftcorePoints")
        private final long softcorePoints;

        public static /* synthetic */ Response copy$default(Response response, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = response.points;
            }
            if ((i & 2) != 0) {
                j2 = response.softcorePoints;
            }
            return response.copy(j, j2);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final long getPoints() {
            return this.points;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final long getSoftcorePoints() {
            return this.softcorePoints;
        }

        public final Response copy(long points, long softcorePoints) {
            return new Response(points, softcorePoints);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.points == response.points && this.softcorePoints == response.softcorePoints;
        }

        public int hashCode() {
            return (Long.hashCode(this.points) * 31) + Long.hashCode(this.softcorePoints);
        }

        public String toString() {
            return "Response(points=" + this.points + ", softcorePoints=" + this.softcorePoints + ')';
        }

        public Response(long j, long j2) {
            this.points = j;
            this.softcorePoints = j2;
        }

        public final long getPoints() {
            return this.points;
        }

        public final long getSoftcorePoints() {
            return this.softcorePoints;
        }
    }
}
