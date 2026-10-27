package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionRepositoryExtensionToKeywordPairEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToKeywordPairEntity;", "Landroid/os/Parcelable;", "id", "", "repositoryId", "", "extensionId", "keyword", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtensionId", "()Ljava/lang/String;", "setExtensionId", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getKeyword", "setKeyword", "getRepositoryId", "setRepositoryId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExtensionRepositoryExtensionToKeywordPairEntity implements Parcelable {
    public static final Parcelable.Creator<ExtensionRepositoryExtensionToKeywordPairEntity> CREATOR = new Creator();
    private String extensionId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f25id;
    private String keyword;
    private String repositoryId;

    /* JADX INFO: compiled from: ExtensionRepositoryExtensionToKeywordPairEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExtensionRepositoryExtensionToKeywordPairEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionRepositoryExtensionToKeywordPairEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExtensionRepositoryExtensionToKeywordPairEntity(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionRepositoryExtensionToKeywordPairEntity[] newArray(int i) {
            return new ExtensionRepositoryExtensionToKeywordPairEntity[i];
        }
    }

    public static /* synthetic */ ExtensionRepositoryExtensionToKeywordPairEntity copy$default(ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = extensionRepositoryExtensionToKeywordPairEntity.f25id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = extensionRepositoryExtensionToKeywordPairEntity.repositoryId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = extensionRepositoryExtensionToKeywordPairEntity.extensionId;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = extensionRepositoryExtensionToKeywordPairEntity.keyword;
        }
        return extensionRepositoryExtensionToKeywordPairEntity.copy(j2, str4, str5, str3);
    }

    public final long component1() {
        return this.f25id;
    }

    public final String component2() {
        return this.repositoryId;
    }

    public final String component3() {
        return this.extensionId;
    }

    public final String component4() {
        return this.keyword;
    }

    public final ExtensionRepositoryExtensionToKeywordPairEntity copy(long j, String repositoryId, String extensionId, String keyword) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return new ExtensionRepositoryExtensionToKeywordPairEntity(j, repositoryId, extensionId, keyword);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionRepositoryExtensionToKeywordPairEntity)) {
            return false;
        }
        ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity = (ExtensionRepositoryExtensionToKeywordPairEntity) obj;
        return this.f25id == extensionRepositoryExtensionToKeywordPairEntity.f25id && Intrinsics.areEqual(this.repositoryId, extensionRepositoryExtensionToKeywordPairEntity.repositoryId) && Intrinsics.areEqual(this.extensionId, extensionRepositoryExtensionToKeywordPairEntity.extensionId) && Intrinsics.areEqual(this.keyword, extensionRepositoryExtensionToKeywordPairEntity.keyword);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f25id) * 31) + this.repositoryId.hashCode()) * 31) + this.extensionId.hashCode()) * 31) + this.keyword.hashCode();
    }

    public String toString() {
        return "ExtensionRepositoryExtensionToKeywordPairEntity(id=" + this.f25id + ", repositoryId=" + this.repositoryId + ", extensionId=" + this.extensionId + ", keyword=" + this.keyword + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f25id);
        out.writeString(this.repositoryId);
        out.writeString(this.extensionId);
        out.writeString(this.keyword);
    }

    public ExtensionRepositoryExtensionToKeywordPairEntity(long j, String repositoryId, String extensionId, String keyword) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.f25id = j;
        this.repositoryId = repositoryId;
        this.extensionId = extensionId;
        this.keyword = keyword;
    }

    public /* synthetic */ ExtensionRepositoryExtensionToKeywordPairEntity(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, str3);
    }

    public final long getId() {
        return this.f25id;
    }

    public final void setId(long j) {
        this.f25id = j;
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

    public final String getKeyword() {
        return this.keyword;
    }

    public final void setKeyword(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyword = str;
    }
}
