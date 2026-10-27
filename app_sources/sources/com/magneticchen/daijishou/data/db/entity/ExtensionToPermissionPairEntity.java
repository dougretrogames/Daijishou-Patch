package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionToPermissionPairEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionToPermissionPairEntity;", "Landroid/os/Parcelable;", "id", "", "extensionId", "", "permission", "extra", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtensionId", "()Ljava/lang/String;", "setExtensionId", "(Ljava/lang/String;)V", "getExtra", "setExtra", "getId", "()J", "setId", "(J)V", "getPermission", "setPermission", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExtensionToPermissionPairEntity implements Parcelable {
    public static final Parcelable.Creator<ExtensionToPermissionPairEntity> CREATOR = new Creator();
    private String extensionId;
    private String extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f27id;
    private String permission;

    /* JADX INFO: compiled from: ExtensionToPermissionPairEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExtensionToPermissionPairEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionToPermissionPairEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExtensionToPermissionPairEntity(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionToPermissionPairEntity[] newArray(int i) {
            return new ExtensionToPermissionPairEntity[i];
        }
    }

    public static /* synthetic */ ExtensionToPermissionPairEntity copy$default(ExtensionToPermissionPairEntity extensionToPermissionPairEntity, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = extensionToPermissionPairEntity.f27id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = extensionToPermissionPairEntity.extensionId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = extensionToPermissionPairEntity.permission;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = extensionToPermissionPairEntity.extra;
        }
        return extensionToPermissionPairEntity.copy(j2, str4, str5, str3);
    }

    public final long component1() {
        return this.f27id;
    }

    public final String component2() {
        return this.extensionId;
    }

    public final String component3() {
        return this.permission;
    }

    public final String component4() {
        return this.extra;
    }

    public final ExtensionToPermissionPairEntity copy(long j, String extensionId, String permission, String extra) {
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new ExtensionToPermissionPairEntity(j, extensionId, permission, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionToPermissionPairEntity)) {
            return false;
        }
        ExtensionToPermissionPairEntity extensionToPermissionPairEntity = (ExtensionToPermissionPairEntity) obj;
        return this.f27id == extensionToPermissionPairEntity.f27id && Intrinsics.areEqual(this.extensionId, extensionToPermissionPairEntity.extensionId) && Intrinsics.areEqual(this.permission, extensionToPermissionPairEntity.permission) && Intrinsics.areEqual(this.extra, extensionToPermissionPairEntity.extra);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f27id) * 31) + this.extensionId.hashCode()) * 31) + this.permission.hashCode()) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "ExtensionToPermissionPairEntity(id=" + this.f27id + ", extensionId=" + this.extensionId + ", permission=" + this.permission + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f27id);
        out.writeString(this.extensionId);
        out.writeString(this.permission);
        out.writeString(this.extra);
    }

    public ExtensionToPermissionPairEntity(long j, String extensionId, String permission, String extra) {
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.f27id = j;
        this.extensionId = extensionId;
        this.permission = permission;
        this.extra = extra;
    }

    public final long getId() {
        return this.f27id;
    }

    public final void setId(long j) {
        this.f27id = j;
    }

    public final String getExtensionId() {
        return this.extensionId;
    }

    public final void setExtensionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extensionId = str;
    }

    public final String getPermission() {
        return this.permission;
    }

    public final void setPermission(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.permission = str;
    }

    public /* synthetic */ ExtensionToPermissionPairEntity(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, (i & 8) != 0 ? "" : str3);
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }
}
