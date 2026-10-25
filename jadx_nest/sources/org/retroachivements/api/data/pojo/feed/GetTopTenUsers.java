package org.retroachivements.api.data.pojo.feed;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.SshConstants;

/* JADX INFO: compiled from: GetTopTenUsers.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/feed/GetTopTenUsers;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetTopTenUsers {

    /* JADX INFO: compiled from: GetTopTenUsers.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/feed/GetTopTenUsers$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/feed/GetTopTenUsers$Response$User;", "Lkotlin/collections/ArrayList;", "()V", SshConstants.USER, "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<User> {

        /* JADX INFO: compiled from: GetTopTenUsers.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lorg/retroachivements/api/data/pojo/feed/GetTopTenUsers$Response$User;", "", "userName", "", "totalPoints", "", "totalRatioPoints", "(Ljava/lang/String;JJ)V", "getTotalPoints", "()J", "getTotalRatioPoints", "getUserName", "()Ljava/lang/String;", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class User {

            @SerializedName(ExifInterface.GPS_MEASUREMENT_2D)
            private final long totalPoints;

            @SerializedName(ExifInterface.GPS_MEASUREMENT_3D)
            private final long totalRatioPoints;

            @SerializedName("1")
            private final String userName;

            public static /* synthetic */ User copy$default(User user, String str, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = user.userName;
                }
                if ((i & 2) != 0) {
                    j = user.totalPoints;
                }
                if ((i & 4) != 0) {
                    j2 = user.totalRatioPoints;
                }
                return user.copy(str, j, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUserName() {
                return this.userName;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getTotalPoints() {
                return this.totalPoints;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getTotalRatioPoints() {
                return this.totalRatioPoints;
            }

            public final User copy(String userName, long totalPoints, long totalRatioPoints) {
                Intrinsics.checkNotNullParameter(userName, "userName");
                return new User(userName, totalPoints, totalRatioPoints);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof User)) {
                    return false;
                }
                User user = (User) other;
                return Intrinsics.areEqual(this.userName, user.userName) && this.totalPoints == user.totalPoints && this.totalRatioPoints == user.totalRatioPoints;
            }

            public int hashCode() {
                return (((this.userName.hashCode() * 31) + Long.hashCode(this.totalPoints)) * 31) + Long.hashCode(this.totalRatioPoints);
            }

            public String toString() {
                return "User(userName=" + this.userName + ", totalPoints=" + this.totalPoints + ", totalRatioPoints=" + this.totalRatioPoints + ')';
            }

            public User(String userName, long j, long j2) {
                Intrinsics.checkNotNullParameter(userName, "userName");
                this.userName = userName;
                this.totalPoints = j;
                this.totalRatioPoints = j2;
            }

            public final String getUserName() {
                return this.userName;
            }

            public final long getTotalPoints() {
                return this.totalPoints;
            }

            public final long getTotalRatioPoints() {
                return this.totalRatioPoints;
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof User) {
                return contains((User) obj);
            }
            return false;
        }

        public /* bridge */ boolean contains(User user) {
            return super.contains((Object) user);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof User) {
                return indexOf((User) obj);
            }
            return -1;
        }

        public /* bridge */ int indexOf(User user) {
            return super.indexOf((Object) user);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof User) {
                return lastIndexOf((User) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(User user) {
            return super.lastIndexOf((Object) user);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ User remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof User) {
                return remove((User) obj);
            }
            return false;
        }

        public /* bridge */ boolean remove(User user) {
            return super.remove((Object) user);
        }

        public /* bridge */ User removeAt(int i) {
            return (User) super.remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }
    }
}
