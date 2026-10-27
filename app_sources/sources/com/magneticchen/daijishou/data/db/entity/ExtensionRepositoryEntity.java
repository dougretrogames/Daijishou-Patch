package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionRepositoryEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006+"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryEntity;", "Landroid/os/Parcelable;", "id", "", "name", "", "description", "baseUrl", "revisions", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getId", "()J", "setId", "(J)V", "getName", "setName", "getRevisions", "setRevisions", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExtensionRepositoryEntity implements Parcelable {
    public static final Parcelable.Creator<ExtensionRepositoryEntity> CREATOR = new Creator();
    private String baseUrl;
    private String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f21id;
    private String name;
    private long revisions;

    /* JADX INFO: compiled from: ExtensionRepositoryEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExtensionRepositoryEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionRepositoryEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExtensionRepositoryEntity(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionRepositoryEntity[] newArray(int i) {
            return new ExtensionRepositoryEntity[i];
        }
    }

    public static /* synthetic */ ExtensionRepositoryEntity copy$default(ExtensionRepositoryEntity extensionRepositoryEntity, long j, String str, String str2, String str3, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = extensionRepositoryEntity.f21id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = extensionRepositoryEntity.name;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = extensionRepositoryEntity.description;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = extensionRepositoryEntity.baseUrl;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            j2 = extensionRepositoryEntity.revisions;
        }
        return extensionRepositoryEntity.copy(j3, str4, str5, str6, j2);
    }

    public final long component1() {
        return this.f21id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.baseUrl;
    }

    public final long component5() {
        return this.revisions;
    }

    public final ExtensionRepositoryEntity copy(long j, String str, String str2, String baseUrl, long j2) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return new ExtensionRepositoryEntity(j, str, str2, baseUrl, j2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionRepositoryEntity)) {
            return false;
        }
        ExtensionRepositoryEntity extensionRepositoryEntity = (ExtensionRepositoryEntity) obj;
        return this.f21id == extensionRepositoryEntity.f21id && Intrinsics.areEqual(this.name, extensionRepositoryEntity.name) && Intrinsics.areEqual(this.description, extensionRepositoryEntity.description) && Intrinsics.areEqual(this.baseUrl, extensionRepositoryEntity.baseUrl) && this.revisions == extensionRepositoryEntity.revisions;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f21id) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        return ((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.baseUrl.hashCode()) * 31) + Long.hashCode(this.revisions);
    }

    public String toString() {
        return "ExtensionRepositoryEntity(id=" + this.f21id + ", name=" + this.name + ", description=" + this.description + ", baseUrl=" + this.baseUrl + ", revisions=" + this.revisions + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f21id);
        out.writeString(this.name);
        out.writeString(this.description);
        out.writeString(this.baseUrl);
        out.writeLong(this.revisions);
    }

    public ExtensionRepositoryEntity(long j, String str, String str2, String baseUrl, long j2) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.f21id = j;
        this.name = str;
        this.description = str2;
        this.baseUrl = baseUrl;
        this.revisions = j2;
    }

    public /* synthetic */ ExtensionRepositoryEntity(long j, String str, String str2, String str3, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, str3, (i & 16) != 0 ? 0L : j2);
    }

    public final long getId() {
        return this.f21id;
    }

    public final void setId(long j) {
        this.f21id = j;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final void setBaseUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.baseUrl = str;
    }

    public final long getRevisions() {
        return this.revisions;
    }

    public final void setRevisions(long j) {
        this.revisions = j;
    }
}
