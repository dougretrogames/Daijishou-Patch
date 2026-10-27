package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionRepositoryExtensionToCategoryPairEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006("}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToCategoryPairEntity;", "Landroid/os/Parcelable;", "id", "", "repositoryId", "", "extensionId", "category", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getExtensionId", "setExtensionId", "getId", "()J", "setId", "(J)V", "getRepositoryId", "setRepositoryId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExtensionRepositoryExtensionToCategoryPairEntity implements Parcelable {
    private String category;
    private String extensionId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f24id;
    private String repositoryId;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ExtensionRepositoryExtensionToCategoryPairEntity> CREATOR = new Creator();
    public static final String SCRAPER_CATEGORY = "scraper";
    public static final String EXTENSION_LIBRARIES_CATEGORY = "extension_libraries";
    public static final String LIBRARY_UI_CATEGORY = "library_ui";
    public static final String WIDGET_CATEGORY = "widget";
    private static final List<String> CATEGORY_LIST = CollectionsKt.listOf((Object[]) new String[]{SCRAPER_CATEGORY, EXTENSION_LIBRARIES_CATEGORY, LIBRARY_UI_CATEGORY, WIDGET_CATEGORY});

    /* JADX INFO: compiled from: ExtensionRepositoryExtensionToCategoryPairEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExtensionRepositoryExtensionToCategoryPairEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionRepositoryExtensionToCategoryPairEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExtensionRepositoryExtensionToCategoryPairEntity(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionRepositoryExtensionToCategoryPairEntity[] newArray(int i) {
            return new ExtensionRepositoryExtensionToCategoryPairEntity[i];
        }
    }

    public static /* synthetic */ ExtensionRepositoryExtensionToCategoryPairEntity copy$default(ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = extensionRepositoryExtensionToCategoryPairEntity.f24id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = extensionRepositoryExtensionToCategoryPairEntity.repositoryId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = extensionRepositoryExtensionToCategoryPairEntity.extensionId;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = extensionRepositoryExtensionToCategoryPairEntity.category;
        }
        return extensionRepositoryExtensionToCategoryPairEntity.copy(j2, str4, str5, str3);
    }

    public final long component1() {
        return this.f24id;
    }

    public final String component2() {
        return this.repositoryId;
    }

    public final String component3() {
        return this.extensionId;
    }

    public final String component4() {
        return this.category;
    }

    public final ExtensionRepositoryExtensionToCategoryPairEntity copy(long j, String repositoryId, String extensionId, String category) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(category, "category");
        return new ExtensionRepositoryExtensionToCategoryPairEntity(j, repositoryId, extensionId, category);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionRepositoryExtensionToCategoryPairEntity)) {
            return false;
        }
        ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity = (ExtensionRepositoryExtensionToCategoryPairEntity) obj;
        return this.f24id == extensionRepositoryExtensionToCategoryPairEntity.f24id && Intrinsics.areEqual(this.repositoryId, extensionRepositoryExtensionToCategoryPairEntity.repositoryId) && Intrinsics.areEqual(this.extensionId, extensionRepositoryExtensionToCategoryPairEntity.extensionId) && Intrinsics.areEqual(this.category, extensionRepositoryExtensionToCategoryPairEntity.category);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f24id) * 31) + this.repositoryId.hashCode()) * 31) + this.extensionId.hashCode()) * 31) + this.category.hashCode();
    }

    public String toString() {
        return "ExtensionRepositoryExtensionToCategoryPairEntity(id=" + this.f24id + ", repositoryId=" + this.repositoryId + ", extensionId=" + this.extensionId + ", category=" + this.category + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f24id);
        out.writeString(this.repositoryId);
        out.writeString(this.extensionId);
        out.writeString(this.category);
    }

    public ExtensionRepositoryExtensionToCategoryPairEntity(long j, String repositoryId, String extensionId, String category) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(category, "category");
        this.f24id = j;
        this.repositoryId = repositoryId;
        this.extensionId = extensionId;
        this.category = category;
    }

    public /* synthetic */ ExtensionRepositoryExtensionToCategoryPairEntity(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, str3);
    }

    public final long getId() {
        return this.f24id;
    }

    public final void setId(long j) {
        this.f24id = j;
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

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.category = str;
    }

    /* JADX INFO: compiled from: ExtensionRepositoryExtensionToCategoryPairEntity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToCategoryPairEntity$Companion;", "", "()V", "CATEGORY_LIST", "", "", "getCATEGORY_LIST", "()Ljava/util/List;", "EXTENSION_LIBRARIES_CATEGORY", "LIBRARY_UI_CATEGORY", "SCRAPER_CATEGORY", "WIDGET_CATEGORY", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getCATEGORY_LIST() {
            return ExtensionRepositoryExtensionToCategoryPairEntity.CATEGORY_LIST;
        }
    }
}
