package org.retroachivements.api.data.pojo.feed;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.transport.SshConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* JADX INFO: compiled from: GetClaims.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/feed/GetClaims;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetClaims {

    /* JADX INFO: compiled from: GetClaims.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/feed/GetClaims$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/feed/GetClaims$Response$Claim;", "Lkotlin/collections/ArrayList;", "()V", "Claim", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<Claim> {

        /* JADX INFO: compiled from: GetClaims.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0016HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J³\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001J\u0013\u0010?\u001a\u00020\u00162\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\fHÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0016\u0010\u0010\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006C"}, d2 = {"Lorg/retroachivements/api/data/pojo/feed/GetClaims$Response$Claim;", "", "id", "", ConfigConstants.CONFIG_USER_SECTION, "", "gameId", "gameTitle", "gameIcon", "consoleName", "consoleId", "claimType", "", "setType", NotificationCompat.CATEGORY_STATUS, "extension", "special", ReflogEntry.PREFIX_CREATED, "updated", "doneTime", "minutesLeft", "userIsJrDev", "", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V", "getClaimType", "()I", "getConsoleId", "()J", "getConsoleName", "()Ljava/lang/String;", "getCreated", "getDoneTime", "getExtension", "getGameIcon", "getGameId", "getGameTitle", "getId", "getMinutesLeft", "getSetType", "getSpecial", "getStatus", "getUpdated", "getUser", "getUserIsJrDev", "()Z", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Claim {

            @SerializedName("ClaimType")
            private final int claimType;

            @SerializedName("ConsoleID")
            private final long consoleId;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("Created")
            private final String created;

            @SerializedName("DoneTime")
            private final String doneTime;

            @SerializedName("Extension")
            private final int extension;

            @SerializedName("GameIcon")
            private final String gameIcon;

            @SerializedName("GameID")
            private final long gameId;

            @SerializedName("GameTitle")
            private final String gameTitle;

            @SerializedName("ID")
            private final long id;

            @SerializedName("MinutesLeft")
            private final long minutesLeft;

            @SerializedName("SetType")
            private final int setType;

            @SerializedName("Special")
            private final int special;

            @SerializedName("Status")
            private final int status;

            @SerializedName("Updated")
            private final String updated;

            @SerializedName(SshConstants.USER)
            private final String user;

            @SerializedName("UserIsJrDev")
            @JsonAdapter(BooleanJsonDeserializer.class)
            private final boolean userIsJrDev;

            public static /* synthetic */ Claim copy$default(Claim claim, long j, String str, long j2, String str2, String str3, String str4, long j3, int i, int i2, int i3, int i4, int i5, String str5, String str6, String str7, long j4, boolean z, int i6, Object obj) {
                boolean z2;
                long j5;
                long j6 = (i6 & 1) != 0 ? claim.id : j;
                String str8 = (i6 & 2) != 0 ? claim.user : str;
                long j7 = (i6 & 4) != 0 ? claim.gameId : j2;
                String str9 = (i6 & 8) != 0 ? claim.gameTitle : str2;
                String str10 = (i6 & 16) != 0 ? claim.gameIcon : str3;
                String str11 = (i6 & 32) != 0 ? claim.consoleName : str4;
                long j8 = (i6 & 64) != 0 ? claim.consoleId : j3;
                int i7 = (i6 & 128) != 0 ? claim.claimType : i;
                int i8 = (i6 & 256) != 0 ? claim.setType : i2;
                int i9 = (i6 & 512) != 0 ? claim.status : i3;
                int i10 = (i6 & 1024) != 0 ? claim.extension : i4;
                long j9 = j6;
                int i11 = (i6 & 2048) != 0 ? claim.special : i5;
                String str12 = (i6 & 4096) != 0 ? claim.created : str5;
                int i12 = i11;
                String str13 = (i6 & 8192) != 0 ? claim.updated : str6;
                String str14 = (i6 & 16384) != 0 ? claim.doneTime : str7;
                long j10 = (i6 & 32768) != 0 ? claim.minutesLeft : j4;
                if ((i6 & 65536) != 0) {
                    j5 = j10;
                    z2 = claim.userIsJrDev;
                } else {
                    z2 = z;
                    j5 = j10;
                }
                return claim.copy(j9, str8, j7, str9, str10, str11, j8, i7, i8, i9, i10, i12, str12, str13, str14, j5, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final int getStatus() {
                return this.status;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final int getExtension() {
                return this.extension;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final int getSpecial() {
                return this.special;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final String getCreated() {
                return this.created;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final String getUpdated() {
                return this.updated;
            }

            /* JADX INFO: renamed from: component15, reason: from getter */
            public final String getDoneTime() {
                return this.doneTime;
            }

            /* JADX INFO: renamed from: component16, reason: from getter */
            public final long getMinutesLeft() {
                return this.minutesLeft;
            }

            /* JADX INFO: renamed from: component17, reason: from getter */
            public final boolean getUserIsJrDev() {
                return this.userIsJrDev;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getUser() {
                return this.user;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getGameId() {
                return this.gameId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getGameTitle() {
                return this.gameTitle;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getGameIcon() {
                return this.gameIcon;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final long getConsoleId() {
                return this.consoleId;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final int getClaimType() {
                return this.claimType;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final int getSetType() {
                return this.setType;
            }

            public final Claim copy(long id2, String user, long gameId, String gameTitle, String gameIcon, String consoleName, long consoleId, int claimType, int setType, int status, int extension, int special, String created, String updated, String doneTime, long minutesLeft, boolean userIsJrDev) {
                Intrinsics.checkNotNullParameter(user, "user");
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(created, "created");
                Intrinsics.checkNotNullParameter(updated, "updated");
                Intrinsics.checkNotNullParameter(doneTime, "doneTime");
                return new Claim(id2, user, gameId, gameTitle, gameIcon, consoleName, consoleId, claimType, setType, status, extension, special, created, updated, doneTime, minutesLeft, userIsJrDev);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Claim)) {
                    return false;
                }
                Claim claim = (Claim) other;
                return this.id == claim.id && Intrinsics.areEqual(this.user, claim.user) && this.gameId == claim.gameId && Intrinsics.areEqual(this.gameTitle, claim.gameTitle) && Intrinsics.areEqual(this.gameIcon, claim.gameIcon) && Intrinsics.areEqual(this.consoleName, claim.consoleName) && this.consoleId == claim.consoleId && this.claimType == claim.claimType && this.setType == claim.setType && this.status == claim.status && this.extension == claim.extension && this.special == claim.special && Intrinsics.areEqual(this.created, claim.created) && Intrinsics.areEqual(this.updated, claim.updated) && Intrinsics.areEqual(this.doneTime, claim.doneTime) && this.minutesLeft == claim.minutesLeft && this.userIsJrDev == claim.userIsJrDev;
            }

            public int hashCode() {
                return (((((((((((((((((((((((((((((((Long.hashCode(this.id) * 31) + this.user.hashCode()) * 31) + Long.hashCode(this.gameId)) * 31) + this.gameTitle.hashCode()) * 31) + this.gameIcon.hashCode()) * 31) + this.consoleName.hashCode()) * 31) + Long.hashCode(this.consoleId)) * 31) + Integer.hashCode(this.claimType)) * 31) + Integer.hashCode(this.setType)) * 31) + Integer.hashCode(this.status)) * 31) + Integer.hashCode(this.extension)) * 31) + Integer.hashCode(this.special)) * 31) + this.created.hashCode()) * 31) + this.updated.hashCode()) * 31) + this.doneTime.hashCode()) * 31) + Long.hashCode(this.minutesLeft)) * 31) + Boolean.hashCode(this.userIsJrDev);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Claim(id=");
                sb.append(this.id).append(", user=").append(this.user).append(", gameId=").append(this.gameId).append(", gameTitle=").append(this.gameTitle).append(", gameIcon=").append(this.gameIcon).append(", consoleName=").append(this.consoleName).append(", consoleId=").append(this.consoleId).append(", claimType=").append(this.claimType).append(", setType=").append(this.setType).append(", status=").append(this.status).append(", extension=").append(this.extension).append(", special=");
                sb.append(this.special).append(", created=").append(this.created).append(", updated=").append(this.updated).append(", doneTime=").append(this.doneTime).append(", minutesLeft=").append(this.minutesLeft).append(", userIsJrDev=").append(this.userIsJrDev).append(')');
                return sb.toString();
            }

            public Claim(long j, String user, long j2, String gameTitle, String gameIcon, String consoleName, long j3, int i, int i2, int i3, int i4, int i5, String created, String updated, String doneTime, long j4, boolean z) {
                Intrinsics.checkNotNullParameter(user, "user");
                Intrinsics.checkNotNullParameter(gameTitle, "gameTitle");
                Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(created, "created");
                Intrinsics.checkNotNullParameter(updated, "updated");
                Intrinsics.checkNotNullParameter(doneTime, "doneTime");
                this.id = j;
                this.user = user;
                this.gameId = j2;
                this.gameTitle = gameTitle;
                this.gameIcon = gameIcon;
                this.consoleName = consoleName;
                this.consoleId = j3;
                this.claimType = i;
                this.setType = i2;
                this.status = i3;
                this.extension = i4;
                this.special = i5;
                this.created = created;
                this.updated = updated;
                this.doneTime = doneTime;
                this.minutesLeft = j4;
                this.userIsJrDev = z;
            }

            public final long getId() {
                return this.id;
            }

            public final String getUser() {
                return this.user;
            }

            public final long getGameId() {
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

            public final long getConsoleId() {
                return this.consoleId;
            }

            public final int getClaimType() {
                return this.claimType;
            }

            public final int getSetType() {
                return this.setType;
            }

            public final int getStatus() {
                return this.status;
            }

            public final int getExtension() {
                return this.extension;
            }

            public final int getSpecial() {
                return this.special;
            }

            public final String getCreated() {
                return this.created;
            }

            public final String getUpdated() {
                return this.updated;
            }

            public final String getDoneTime() {
                return this.doneTime;
            }

            public final long getMinutesLeft() {
                return this.minutesLeft;
            }

            public final boolean getUserIsJrDev() {
                return this.userIsJrDev;
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
