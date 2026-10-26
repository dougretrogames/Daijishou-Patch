package org.retroachivements.api.data.pojo.user;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.transport.SshConstants;

/* INFO: compiled from: GetUserClaims.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserClaims;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserClaims {

    /* INFO: compiled from: GetUserClaims.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserClaims$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/user/GetUserClaims$Response$Claim;", "Lkotlin/collections/ArrayList;", "()V", "Claim", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<Claim> {

        /* INFO: compiled from: GetUserClaims.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\u009f\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\rHÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018¨\u0006<"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserClaims$Response$Claim;", "", "id", "", ConfigConstants.CONFIG_USER_SECTION, "", "gameId", "gameTitle", "gameIcon", "consoleName", "claimType", "setType", NotificationCompat.CATEGORY_STATUS, "", "extension", "special", ReflogEntry.PREFIX_CREATED, "doneTime", "updated", "minutesLeft", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJIJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getClaimType", "()J", "getConsoleName", "()Ljava/lang/String;", "getCreated", "getDoneTime", "getExtension", "getGameIcon", "getGameId", "getGameTitle", "getId", "getMinutesLeft", "getSetType", "getSpecial", "getStatus", "()I", "getUpdated", "getUser", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Claim {

            @SerializedName("ClaimType")
            private final long claimType;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("Created")
            private final String created;

            @SerializedName("DoneTime")
            private final String doneTime;

            @SerializedName("Extension")
            private final long extension;

            @SerializedName("GameIcon")
            private final String gameIcon;

            @SerializedName("GameID")
            private final String gameId;

            @SerializedName("GameTitle")
            private final String gameTitle;

            @SerializedName("ID")
            private final long id;

            @SerializedName("MinutesLeft")
            private final long minutesLeft;

            @SerializedName("SetType")
            private final long setType;

            @SerializedName("Special")
            private final long special;

            @SerializedName("Status")
            private final int status;

            @SerializedName("Updated")
            private final String updated;

            @SerializedName(SshConstants.USER)
            private final String user;

            public static /* synthetic */ Claim copy$default(Claim claim, long j, String str, String str2, String str3, String str4, String str5, long j2, long j3, int i, long j4, long j5, String str6, String str7, String str8, long j6, int i2, Object obj) {
                long j7;
                String str9;
                long j8 = (i2 & 1) != 0 ? claim.id : j;
                String str10 = (i2 & 2) != 0 ? claim.user : str;
                String str11 = (i2 & 4) != 0 ? claim.gameId : str2;
                String str12 = (i2 & 8) != 0 ? claim.gameTitle : str3;
                String str13 = (i2 & 16) != 0 ? claim.gameIcon : str4;
                String str14 = (i2 & 32) != 0 ? claim.consoleName : str5;
                long j9 = (i2 & 64) != 0 ? claim.claimType : j2;
                long j10 = (i2 & 128) != 0 ? claim.setType : j3;
                int i3 = (i2 & 256) != 0 ? claim.status : i;
                long j11 = (i2 & 512) != 0 ? claim.extension : j4;
                long j12 = j8;
                long j13 = (i2 & 1024) != 0 ? claim.special : j5;
                String str15 = (i2 & 2048) != 0 ? claim.created : str6;
                String str16 = (i2 & 4096) != 0 ? claim.doneTime : str7;
                String str17 = str15;
                String str18 = (i2 & 8192) != 0 ? claim.updated : str8;
                if ((i2 & 16384) != 0) {
                    str9 = str18;
                    j7 = claim.minutesLeft;
                } else {
                    j7 = j6;
                    str9 = str18;
                }
                return claim.copy(j12, str10, str11, str12, str13, str14, j9, j10, i3, j11, j13, str17, str16, str9, j7);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* INFO: renamed from: component10, reason: from getter */
            public final long getExtension() {
                return this.extension;
            }

            /* INFO: renamed from: component11, reason: from getter */
            public final long getSpecial() {
                return this.special;
            }

            /* INFO: renamed from: component12, reason: from getter */
            public final String getCreated() {
                return this.created;
            }

            /* INFO: renamed from: component13, reason: from getter */
            public final String getDoneTime() {
                return this.doneTime;
            }

            /* INFO: renamed from: component14, reason: from getter */
            public final String getUpdated() {
                return this.updated;
            }

            /* INFO: renamed from: component15, reason: from getter */
            public final long getMinutesLeft() {
                return this.minutesLeft;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final String getUser() {
                return this.user;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final String getGameId() {
                return this.gameId;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final String getGameTitle() {
                return this.gameTitle;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final String getGameIcon() {
                return this.gameIcon;
            }

            /* INFO: renamed from: component6, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* INFO: renamed from: component7, reason: from getter */
            public final long getClaimType() {
                return this.claimType;
            }

            /* INFO: renamed from: component8, reason: from getter */
            public final long getSetType() {
                return this.setType;
            }

            /* INFO: renamed from: component9, reason: from getter */
            public final int getStatus() {
                return this.status;
            }

            public final Claim copy(long id2, String user, String gameId, String gameTitle, String gameIcon, String consoleName, long claimType, long setType, int status, long extension, long special, String created, String doneTime, String updated, long minutesLeft) {
                Intrinsics.checkNotNullParameter(user, "user");
                Intrinsics.checkNotNullParameter(gameId, "gameId");
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(created, "created");
                Intrinsics.checkNotNullParameter(doneTime, "doneTime");
                Intrinsics.checkNotNullParameter(updated, "updated");
                return new Claim(id2, user, gameId, gameTitle, gameIcon, consoleName, claimType, setType, status, extension, special, created, doneTime, updated, minutesLeft);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Claim)) {
                    return false;
                }
                Claim claim = (Claim) other;
                return this.id == claim.id && Intrinsics.areEqual(this.user, claim.user) && Intrinsics.areEqual(this.gameId, claim.gameId) && Intrinsics.areEqual(this.gameTitle, claim.gameTitle) && Intrinsics.areEqual(this.gameIcon, claim.gameIcon) && Intrinsics.areEqual(this.consoleName, claim.consoleName) && this.claimType == claim.claimType && this.setType == claim.setType && this.status == claim.status && this.extension == claim.extension && this.special == claim.special && Intrinsics.areEqual(this.created, claim.created) && Intrinsics.areEqual(this.doneTime, claim.doneTime) && Intrinsics.areEqual(this.updated, claim.updated) && this.minutesLeft == claim.minutesLeft;
            }

            public int hashCode() {
                return (((((((((((((((((((((((((((Long.hashCode(this.id) * 31) + this.user.hashCode()) * 31) + this.gameId.hashCode()) * 31) + this.gameTitle.hashCode()) * 31) + this.gameIcon.hashCode()) * 31) + this.consoleName.hashCode()) * 31) + Long.hashCode(this.claimType)) * 31) + Long.hashCode(this.setType)) * 31) + Integer.hashCode(this.status)) * 31) + Long.hashCode(this.extension)) * 31) + Long.hashCode(this.special)) * 31) + this.created.hashCode()) * 31) + this.doneTime.hashCode()) * 31) + this.updated.hashCode()) * 31) + Long.hashCode(this.minutesLeft);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Claim(id=");
                sb.append(this.id).append(", user=").append(this.user).append(", gameId=").append(this.gameId).append(", gameTitle=").append(this.gameTitle).append(", gameIcon=").append(this.gameIcon).append(", consoleName=").append(this.consoleName).append(", claimType=").append(this.claimType).append(", setType=").append(this.setType).append(", status=").append(this.status).append(", extension=").append(this.extension).append(", special=").append(this.special).append(", created=");
                sb.append(this.created).append(", doneTime=").append(this.doneTime).append(", updated=").append(this.updated).append(", minutesLeft=").append(this.minutesLeft).append(')');
                return sb.toString();
            }

            public Claim(long j, String user, String gameId, String gameTitle, String gameIcon, String consoleName, long j2, long j3, int i, long j4, long j5, String created, String doneTime, String updated, long j6) {
                Intrinsics.checkNotNullParameter(user, "user");
                Intrinsics.checkNotNullParameter(gameId, "gameId");
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(created, "created");
                Intrinsics.checkNotNullParameter(doneTime, "doneTime");
                Intrinsics.checkNotNullParameter(updated, "updated");
                this.id = j;
                this.user = user;
                this.gameId = gameId;
                this.gameTitle = gameTitle;
                this.gameIcon = gameIcon;
                this.consoleName = consoleName;
                this.claimType = j2;
                this.setType = j3;
                this.status = i;
                this.extension = j4;
                this.special = j5;
                this.created = created;
                this.doneTime = doneTime;
                this.updated = updated;
                this.minutesLeft = j6;
            }

            public final long getId() {
                return this.id;
            }

            public final String getUser() {
                return this.user;
            }

            public final String getGameId() {
                return this.gameId;
            }

            public final String getGameTitle() {
                return this.gameTitle;
            }

            public final String getGameIcon() {
                return this.gameIcon;
            }

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final long getClaimType() {
                return this.claimType;
            }

            public final long getSetType() {
                return this.setType;
            }

            public final int getStatus() {
                return this.status;
            }

            public final long getExtension() {
                return this.extension;
            }

            public final long getSpecial() {
                return this.special;
            }

            public final String getCreated() {
                return this.created;
            }

            public final String getDoneTime() {
                return this.doneTime;
            }

            public final String getUpdated() {
                return this.updated;
            }

            public final long getMinutesLeft() {
                return this.minutesLeft;
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Claim) {
                return contains((Claim) obj);
            }
            return false;
        }

        public /* bridge */ boolean contains(Claim claim) {
            return super.contains((Object) claim);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Claim) {
                return indexOf((Claim) obj);
            }
            return -1;
        }

        public /* bridge */ int indexOf(Claim claim) {
            return super.indexOf((Object) claim);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Claim) {
                return lastIndexOf((Claim) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(Claim claim) {
            return super.lastIndexOf((Object) claim);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ Claim remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof Claim) {
                return remove((Claim) obj);
            }
            return false;
        }

        public /* bridge */ boolean remove(Claim claim) {
            return super.remove((Object) claim);
        }

        public /* bridge */ Claim removeAt(int i) {
            return (Claim) super.remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }
    }
}
