package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionRepositoryExtensionToAuthorPairEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003JI\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006/"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToAuthorPairEntity;", "Landroid/os/Parcelable;", "id", "", "repositoryId", "", "extensionId", "email", "name", "url", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "getExtensionId", "setExtensionId", "getId", "()J", "setId", "(J)V", "getName", "setName", "getRepositoryId", "setRepositoryId", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExtensionRepositoryExtensionToAuthorPairEntity implements Parcelable {
    public static final Parcelable.Creator<ExtensionRepositoryExtensionToAuthorPairEntity> CREATOR = new Creator();
    private String email;
    private String extensionId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f23id;
    private String name;
    private String repositoryId;
    private String url;

    /* JADX INFO: compiled from: ExtensionRepositoryExtensionToAuthorPairEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExtensionRepositoryExtensionToAuthorPairEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionRepositoryExtensionToAuthorPairEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExtensionRepositoryExtensionToAuthorPairEntity(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionRepositoryExtensionToAuthorPairEntity[] newArray(int i) {
            return new ExtensionRepositoryExtensionToAuthorPairEntity[i];
        }
    }

    public static /* synthetic */ ExtensionRepositoryExtensionToAuthorPairEntity copy$default(ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity, long j, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            j = extensionRepositoryExtensionToAuthorPairEntity.f23id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = extensionRepositoryExtensionToAuthorPairEntity.repositoryId;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = extensionRepositoryExtensionToAuthorPairEntity.extensionId;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = extensionRepositoryExtensionToAuthorPairEntity.email;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = extensionRepositoryExtensionToAuthorPairEntity.name;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = extensionRepositoryExtensionToAuthorPairEntity.url;
        }
        return extensionRepositoryExtensionToAuthorPairEntity.copy(j2, str6, str7, str8, str9, str5);
    }

    public final long component1() {
        return this.f23id;
    }

    public final String component2() {
        return this.repositoryId;
    }

    public final String component3() {
        return this.extensionId;
    }

    public final String component4() {
        return this.email;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.url;
    }

    public final ExtensionRepositoryExtensionToAuthorPairEntity copy(long j, String repositoryId, String extensionId, String email, String str, String str2) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(email, "email");
        return new ExtensionRepositoryExtensionToAuthorPairEntity(j, repositoryId, extensionId, email, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionRepositoryExtensionToAuthorPairEntity)) {
            return false;
        }
        ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity = (ExtensionRepositoryExtensionToAuthorPairEntity) obj;
        return this.f23id == extensionRepositoryExtensionToAuthorPairEntity.f23id && Intrinsics.areEqual(this.repositoryId, extensionRepositoryExtensionToAuthorPairEntity.repositoryId) && Intrinsics.areEqual(this.extensionId, extensionRepositoryExtensionToAuthorPairEntity.extensionId) && Intrinsics.areEqual(this.email, extensionRepositoryExtensionToAuthorPairEntity.email) && Intrinsics.areEqual(this.name, extensionRepositoryExtensionToAuthorPairEntity.name) && Intrinsics.areEqual(this.url, extensionRepositoryExtensionToAuthorPairEntity.url);
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.f23id) * 31) + this.repositoryId.hashCode()) * 31) + this.extensionId.hashCode()) * 31) + this.email.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ExtensionRepositoryExtensionToAuthorPairEntity(id=" + this.f23id + ", repositoryId=" + this.repositoryId + ", extensionId=" + this.extensionId + ", email=" + this.email + ", name=" + this.name + ", url=" + this.url + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f23id);
        out.writeString(this.repositoryId);
        out.writeString(this.extensionId);
        out.writeString(this.email);
        out.writeString(this.name);
        out.writeString(this.url);
    }

    public ExtensionRepositoryExtensionToAuthorPairEntity(long j, String repositoryId, String extensionId, String email, String str, String str2) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(email, "email");
        this.f23id = j;
        this.repositoryId = repositoryId;
        this.extensionId = extensionId;
        this.email = email;
        this.name = str;
        this.url = str2;
    }

    public /* synthetic */ ExtensionRepositoryExtensionToAuthorPairEntity(long j, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, str3, str4, str5);
    }

    public final long getId() {
        return this.f23id;
    }

    public final void setId(long j) {
        this.f23id = j;
    }

    public final String getRepositoryId() {
        return this.repositoryId;
    }

    public final void setRepositoryId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.repositoryId = str;
    }

    public final String getExtensionId() {
        return this.extensionId;
    }

    public final void setExtensionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extensionId = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.email = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}
