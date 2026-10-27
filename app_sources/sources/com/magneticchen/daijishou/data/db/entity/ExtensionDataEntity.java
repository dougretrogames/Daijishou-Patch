package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionDataEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020!HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020!HÖ\u0001R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006,"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionDataEntity;", "Landroid/os/Parcelable;", "id", "", "extensionId", "", "keyString", "isPublic", "", "dataJsonString", "(JLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getDataJsonString", "()Ljava/lang/String;", "setDataJsonString", "(Ljava/lang/String;)V", "getExtensionId", "setExtensionId", "getId", "()J", "setId", "(J)V", "()Z", "setPublic", "(Z)V", "getKeyString", "setKeyString", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExtensionDataEntity implements Parcelable {
    public static final Parcelable.Creator<ExtensionDataEntity> CREATOR = new Creator();
    private String dataJsonString;
    private String extensionId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f18id;
    private boolean isPublic;
    private String keyString;

    /* JADX INFO: compiled from: ExtensionDataEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExtensionDataEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionDataEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExtensionDataEntity(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionDataEntity[] newArray(int i) {
            return new ExtensionDataEntity[i];
        }
    }

    public static /* synthetic */ ExtensionDataEntity copy$default(ExtensionDataEntity extensionDataEntity, long j, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = extensionDataEntity.f18id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = extensionDataEntity.extensionId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = extensionDataEntity.keyString;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            z = extensionDataEntity.isPublic;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str3 = extensionDataEntity.dataJsonString;
        }
        return extensionDataEntity.copy(j2, str4, str5, z2, str3);
    }

    public final long component1() {
        return this.f18id;
    }

    public final String component2() {
        return this.extensionId;
    }

    public final String component3() {
        return this.keyString;
    }

    public final boolean component4() {
        return this.isPublic;
    }

    public final String component5() {
        return this.dataJsonString;
    }

    public final ExtensionDataEntity copy(long j, String extensionId, String keyString, boolean z, String dataJsonString) {
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(keyString, "keyString");
        Intrinsics.checkNotNullParameter(dataJsonString, "dataJsonString");
        return new ExtensionDataEntity(j, extensionId, keyString, z, dataJsonString);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionDataEntity)) {
            return false;
        }
        ExtensionDataEntity extensionDataEntity = (ExtensionDataEntity) obj;
        return this.f18id == extensionDataEntity.f18id && Intrinsics.areEqual(this.extensionId, extensionDataEntity.extensionId) && Intrinsics.areEqual(this.keyString, extensionDataEntity.keyString) && this.isPublic == extensionDataEntity.isPublic && Intrinsics.areEqual(this.dataJsonString, extensionDataEntity.dataJsonString);
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f18id) * 31) + this.extensionId.hashCode()) * 31) + this.keyString.hashCode()) * 31) + Boolean.hashCode(this.isPublic)) * 31) + this.dataJsonString.hashCode();
    }

    public String toString() {
        return "ExtensionDataEntity(id=" + this.f18id + ", extensionId=" + this.extensionId + ", keyString=" + this.keyString + ", isPublic=" + this.isPublic + ", dataJsonString=" + this.dataJsonString + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f18id);
        out.writeString(this.extensionId);
        out.writeString(this.keyString);
        out.writeInt(this.isPublic ? 1 : 0);
        out.writeString(this.dataJsonString);
    }

    public ExtensionDataEntity(long j, String extensionId, String keyString, boolean z, String dataJsonString) {
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(keyString, "keyString");
        Intrinsics.checkNotNullParameter(dataJsonString, "dataJsonString");
        this.f18id = j;
        this.extensionId = extensionId;
        this.keyString = keyString;
        this.isPublic = z;
        this.dataJsonString = dataJsonString;
    }

    public /* synthetic */ ExtensionDataEntity(long j, String str, String str2, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, z, str3);
    }

    public final long getId() {
        return this.f18id;
    }

    public final void setId(long j) {
        this.f18id = j;
    }

    public final String getExtensionId() {
        return this.extensionId;
    }

    public final void setExtensionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extensionId = str;
    }

    public final String getKeyString() {
        return this.keyString;
    }

    public final void setKeyString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyString = str;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final void setPublic(boolean z) {
        this.isPublic = z;
    }

    public final String getDataJsonString() {
        return this.dataJsonString;
    }

    public final void setDataJsonString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataJsonString = str;
    }
}
