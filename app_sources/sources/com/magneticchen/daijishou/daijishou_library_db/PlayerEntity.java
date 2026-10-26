package com.magneticchen.daijishou.daijishou_library_db;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: PlayerEntity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0001DBm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003Jq\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0006\u00108\u001a\u00020\u0000J\t\u00109\u001a\u00020\u0007HÖ\u0001J\u0013\u0010:\u001a\u00020\f2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u0007HÖ\u0001J\t\u0010>\u001a\u00020\u0005HÖ\u0001J\u0019\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006E"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/PlayerEntity;", "Landroid/os/Parcelable;", "id", "", "uniqueId", "", "player", "", "name", "description", "amStartArguments", "killPackageProcesses", "", "killPackageProcessesWarning", "acceptedFilenameRegex", "extra", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "getAcceptedFilenameRegex", "()Ljava/lang/String;", "setAcceptedFilenameRegex", "(Ljava/lang/String;)V", "getAmStartArguments", "setAmStartArguments", "getDescription", "setDescription", "getExtra", "setExtra", "getId", "()J", "setId", "(J)V", "getKillPackageProcesses", "()Z", "setKillPackageProcesses", "(Z)V", "getKillPackageProcessesWarning", "setKillPackageProcessesWarning", "getName", "setName", "getPlayer", "()I", "setPlayer", "(I)V", "getUniqueId", "setUniqueId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PlayerEntity implements Parcelable {
    public static final int ACTIVITIES_PLAYER = 2;
    public static final int FILES_PLAYER = 1;
    private String acceptedFilenameRegex;
    private String amStartArguments;
    private String description;
    private String extra;
    private long id;
    private boolean killPackageProcesses;
    private boolean killPackageProcessesWarning;
    private String name;
    private int player;
    private String uniqueId;
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new Creator();

    /* INFO: compiled from: PlayerEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PlayerEntity> {
        /* WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayerEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            int i = parcel.readInt();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            boolean z = true;
            if (parcel.readInt() == 0) {
                z = false;
            }
            return new PlayerEntity(j, string, i, string2, string3, string4, z, parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayerEntity[] newArray(int i) {
            return new PlayerEntity[i];
        }
    }

    public PlayerEntity() {
        this(0L, null, 0, null, null, null, false, false, null, null, 1023, null);
    }

    public static /* synthetic */ PlayerEntity copy$default(PlayerEntity playerEntity, long j, String str, int i, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = playerEntity.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = playerEntity.uniqueId;
        }
        return playerEntity.copy(j2, str, (i2 & 4) != 0 ? playerEntity.player : i, (i2 & 8) != 0 ? playerEntity.name : str2, (i2 & 16) != 0 ? playerEntity.description : str3, (i2 & 32) != 0 ? playerEntity.amStartArguments : str4, (i2 & 64) != 0 ? playerEntity.killPackageProcesses : z, (i2 & 128) != 0 ? playerEntity.killPackageProcessesWarning : z2, (i2 & 256) != 0 ? playerEntity.acceptedFilenameRegex : str5, (i2 & 512) != 0 ? playerEntity.extra : str6);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* INFO: renamed from: component10, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final String getUniqueId() {
        return this.uniqueId;
    }

    /* INFO: renamed from: component3, reason: from getter */
    public final int getPlayer() {
        return this.player;
    }

    /* INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* INFO: renamed from: component6, reason: from getter */
    public final String getAmStartArguments() {
        return this.amStartArguments;
    }

    /* INFO: renamed from: component7, reason: from getter */
    public final boolean getKillPackageProcesses() {
        return this.killPackageProcesses;
    }

    /* INFO: renamed from: component8, reason: from getter */
    public final boolean getKillPackageProcessesWarning() {
        return this.killPackageProcessesWarning;
    }

    /* INFO: renamed from: component9, reason: from getter */
    public final String getAcceptedFilenameRegex() {
        return this.acceptedFilenameRegex;
    }

    public final PlayerEntity copy(long id2, String uniqueId, int player, String name, String description, String amStartArguments, boolean killPackageProcesses, boolean killPackageProcessesWarning, String acceptedFilenameRegex, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amStartArguments, "amStartArguments");
        Intrinsics.checkNotNullParameter(acceptedFilenameRegex, "acceptedFilenameRegex");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new PlayerEntity(id2, uniqueId, player, name, description, amStartArguments, killPackageProcesses, killPackageProcessesWarning, acceptedFilenameRegex, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerEntity)) {
            return false;
        }
        PlayerEntity playerEntity = (PlayerEntity) other;
        return this.id == playerEntity.id && Intrinsics.areEqual(this.uniqueId, playerEntity.uniqueId) && this.player == playerEntity.player && Intrinsics.areEqual(this.name, playerEntity.name) && Intrinsics.areEqual(this.description, playerEntity.description) && Intrinsics.areEqual(this.amStartArguments, playerEntity.amStartArguments) && this.killPackageProcesses == playerEntity.killPackageProcesses && this.killPackageProcessesWarning == playerEntity.killPackageProcessesWarning && Intrinsics.areEqual(this.acceptedFilenameRegex, playerEntity.acceptedFilenameRegex) && Intrinsics.areEqual(this.extra, playerEntity.extra);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.uniqueId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.player)) * 31) + this.name.hashCode()) * 31;
        String str2 = this.description;
        return ((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.amStartArguments.hashCode()) * 31) + Boolean.hashCode(this.killPackageProcesses)) * 31) + Boolean.hashCode(this.killPackageProcessesWarning)) * 31) + this.acceptedFilenameRegex.hashCode()) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "PlayerEntity(id=" + this.id + ", uniqueId=" + this.uniqueId + ", player=" + this.player + ", name=" + this.name + ", description=" + this.description + ", amStartArguments=" + this.amStartArguments + ", killPackageProcesses=" + this.killPackageProcesses + ", killPackageProcessesWarning=" + this.killPackageProcessesWarning + ", acceptedFilenameRegex=" + this.acceptedFilenameRegex + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeString(this.uniqueId);
        parcel.writeInt(this.player);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.amStartArguments);
        parcel.writeInt(this.killPackageProcesses ? 1 : 0);
        parcel.writeInt(this.killPackageProcessesWarning ? 1 : 0);
        parcel.writeString(this.acceptedFilenameRegex);
        parcel.writeString(this.extra);
    }

    public PlayerEntity(long j, String str, int i, String name, String str2, String amStartArguments, boolean z, boolean z2, String acceptedFilenameRegex, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amStartArguments, "amStartArguments");
        Intrinsics.checkNotNullParameter(acceptedFilenameRegex, "acceptedFilenameRegex");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.id = j;
        this.uniqueId = str;
        this.player = i;
        this.name = name;
        this.description = str2;
        this.amStartArguments = amStartArguments;
        this.killPackageProcesses = z;
        this.killPackageProcessesWarning = z2;
        this.acceptedFilenameRegex = acceptedFilenameRegex;
        this.extra = extra;
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setUniqueId(String str) {
        this.uniqueId = str;
    }


    public final void setPlayer(int i) {
        this.player = i;
    }

    public /* synthetic */ PlayerEntity(long j, String str, int i, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? "Player name" : str2, (i2 & 16) == 0 ? str3 : null, (i2 & 32) != 0 ? "-a android.intent.action.VIEW\\n-n org.example.app/.AppActivity\\n-d {file.path}" : str4, (i2 & 64) != 0 ? false : z, (i2 & 128) == 0 ? z2 : true, (i2 & 256) != 0 ? "^(.*)\\.(?:ext1|ext2|ext3)$" : str5, (i2 & 512) != 0 ? "" : str6);
    }


    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }


    public final void setDescription(String str) {
        this.description = str;
    }


    public final void setAmStartArguments(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.amStartArguments = str;
    }


    public final void setKillPackageProcesses(boolean z) {
        this.killPackageProcesses = z;
    }


    public final void setKillPackageProcessesWarning(boolean z) {
        this.killPackageProcessesWarning = z;
    }


    public final void setAcceptedFilenameRegex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.acceptedFilenameRegex = str;
    }


    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }

    public final PlayerEntity copyAndResetDatabaseAndDeviceDependentValues() {
        PlayerEntity playerEntityCopy$default = copy$default(this, 0L, null, 0, null, null, null, false, false, null, null, 1023, null);
        playerEntityCopy$default.id = 0L;
        return playerEntityCopy$default;
    }
}
