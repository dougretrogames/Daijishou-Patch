package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionToLibraryPairEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\"HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"HÖ\u0001R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006-"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionToLibraryPairEntity;", "Landroid/os/Parcelable;", "id", "", "extensionId", "", "libraryId", "path", "export", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getExport", "()Z", "setExport", "(Z)V", "getExtensionId", "()Ljava/lang/String;", "setExtensionId", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getLibraryId", "setLibraryId", "getPath", "setPath", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExtensionToLibraryPairEntity implements Parcelable {
    public static final Parcelable.Creator<ExtensionToLibraryPairEntity> CREATOR = new Creator();
    private boolean export;
    private String extensionId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f26id;
    private String libraryId;
    private String path;

    /* JADX INFO: compiled from: ExtensionToLibraryPairEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExtensionToLibraryPairEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionToLibraryPairEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExtensionToLibraryPairEntity(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionToLibraryPairEntity[] newArray(int i) {
            return new ExtensionToLibraryPairEntity[i];
        }
    }

    public static /* synthetic */ ExtensionToLibraryPairEntity copy$default(ExtensionToLibraryPairEntity extensionToLibraryPairEntity, long j, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = extensionToLibraryPairEntity.f26id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = extensionToLibraryPairEntity.extensionId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = extensionToLibraryPairEntity.libraryId;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = extensionToLibraryPairEntity.path;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            z = extensionToLibraryPairEntity.export;
        }
        return extensionToLibraryPairEntity.copy(j2, str4, str5, str6, z);
    }

    public final long component1() {
        return this.f26id;
    }

    public final String component2() {
        return this.extensionId;
    }

    public final String component3() {
        return this.libraryId;
    }

    public final String component4() {
        return this.path;
    }

    public final boolean component5() {
        return this.export;
    }

    public final ExtensionToLibraryPairEntity copy(long j, String extensionId, String libraryId, String path, boolean z) {
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(libraryId, "libraryId");
        Intrinsics.checkNotNullParameter(path, "path");
        return new ExtensionToLibraryPairEntity(j, extensionId, libraryId, path, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionToLibraryPairEntity)) {
            return false;
        }
        ExtensionToLibraryPairEntity extensionToLibraryPairEntity = (ExtensionToLibraryPairEntity) obj;
        return this.f26id == extensionToLibraryPairEntity.f26id && Intrinsics.areEqual(this.extensionId, extensionToLibraryPairEntity.extensionId) && Intrinsics.areEqual(this.libraryId, extensionToLibraryPairEntity.libraryId) && Intrinsics.areEqual(this.path, extensionToLibraryPairEntity.path) && this.export == extensionToLibraryPairEntity.export;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f26id) * 31) + this.extensionId.hashCode()) * 31) + this.libraryId.hashCode()) * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.export);
    }

    public String toString() {
        return "ExtensionToLibraryPairEntity(id=" + this.f26id + ", extensionId=" + this.extensionId + ", libraryId=" + this.libraryId + ", path=" + this.path + ", export=" + this.export + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f26id);
        out.writeString(this.extensionId);
        out.writeString(this.libraryId);
        out.writeString(this.path);
        out.writeInt(this.export ? 1 : 0);
    }

    public ExtensionToLibraryPairEntity(long j, String extensionId, String libraryId, String path, boolean z) {
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(libraryId, "libraryId");
        Intrinsics.checkNotNullParameter(path, "path");
        this.f26id = j;
        this.extensionId = extensionId;
        this.libraryId = libraryId;
        this.path = path;
        this.export = z;
    }

    public /* synthetic */ ExtensionToLibraryPairEntity(long j, String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, str3, z);
    }

    public final long getId() {
        return this.f26id;
    }

    public final void setId(long j) {
        this.f26id = j;
    }

    public final String getExtensionId() {
        return this.extensionId;
    }

    public final void setExtensionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extensionId = str;
    }

    public final String getLibraryId() {
        return this.libraryId;
    }

    public final void setLibraryId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.libraryId = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final boolean getExport() {
        return this.export;
    }

    public final void setExport(boolean z) {
        this.export = z;
    }
}
