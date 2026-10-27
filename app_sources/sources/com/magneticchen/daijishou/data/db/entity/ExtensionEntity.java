package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010=\u001a\u00020\u0012HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\bHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010F\u001a\u00020\bHÆ\u0003J¬\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010HJ\t\u0010I\u001a\u00020\fHÖ\u0001J\u0013\u0010J\u001a\u00020\b2\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020\fHÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001J\u0019\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\fHÖ\u0001R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001e\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010+\"\u0004\b,\u0010-R\u001e\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010+\"\u0004\b.\u0010-R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010+\"\u0004\b/\u0010-R\u001e\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010+\"\u0004\b0\u0010-R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R \u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"¨\u0006T"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionEntity;", "Landroid/os/Parcelable;", "id", "", "name", "description", "icon", "isPreloaded", "", "isNSFW", "version", "apiLevel", "", "isTopLevel", "isEnabled", "categories", "", "lastUpdateTimestamp", "Ljava/util/Date;", "installationTimestamp", "repositoryBaseUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;ZZLjava/util/List;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "getApiLevel", "()Ljava/lang/Integer;", "setApiLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCategories", "()Ljava/util/List;", "setCategories", "(Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getId", "setId", "getInstallationTimestamp", "()Ljava/util/Date;", "setInstallationTimestamp", "(Ljava/util/Date;)V", "()Z", "setEnabled", "(Z)V", "setNSFW", "setPreloaded", "setTopLevel", "getLastUpdateTimestamp", "setLastUpdateTimestamp", "getName", "setName", "getRepositoryBaseUrl", "setRepositoryBaseUrl", "getVersion", "setVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;ZZLjava/util/List;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)Lcom/magneticchen/daijishou/data/db/entity/ExtensionEntity;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExtensionEntity implements Parcelable {
    public static final Parcelable.Creator<ExtensionEntity> CREATOR = new Creator();
    private Integer apiLevel;
    private List<String> categories;
    private String description;
    private String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f20id;
    private Date installationTimestamp;
    private boolean isEnabled;
    private boolean isNSFW;
    private boolean isPreloaded;
    private boolean isTopLevel;
    private Date lastUpdateTimestamp;
    private String name;
    private String repositoryBaseUrl;
    private String version;

    /* JADX INFO: compiled from: ExtensionEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExtensionEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionEntity createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            boolean z3 = true;
            boolean z4 = false;
            if (parcel.readInt() == 0) {
                z3 = false;
            }
            if (parcel.readInt() != 0) {
                z4 = true;
            }
            String string5 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                z = false;
                z2 = z3;
            } else {
                z = z4;
                z2 = z;
            }
            if (parcel.readInt() != 0) {
                z = z3;
            }
            return new ExtensionEntity(string, string2, string3, string4, z3, z4, string5, numValueOf, z2, z, parcel.createStringArrayList(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionEntity[] newArray(int i) {
            return new ExtensionEntity[i];
        }
    }

    public final String component1() {
        return this.f20id;
    }

    public final boolean component10() {
        return this.isEnabled;
    }

    public final List<String> component11() {
        return this.categories;
    }

    public final Date component12() {
        return this.lastUpdateTimestamp;
    }

    public final Date component13() {
        return this.installationTimestamp;
    }

    public final String component14() {
        return this.repositoryBaseUrl;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.icon;
    }

    public final boolean component5() {
        return this.isPreloaded;
    }

    public final boolean component6() {
        return this.isNSFW;
    }

    public final String component7() {
        return this.version;
    }

    public final Integer component8() {
        return this.apiLevel;
    }

    public final boolean component9() {
        return this.isTopLevel;
    }

    public final ExtensionEntity copy(String id2, String str, String str2, String str3, boolean z, boolean z2, String version, Integer num, boolean z3, boolean z4, List<String> categories, Date date, Date installationTimestamp, String str4) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(installationTimestamp, "installationTimestamp");
        return new ExtensionEntity(id2, str, str2, str3, z, z2, version, num, z3, z4, categories, date, installationTimestamp, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionEntity)) {
            return false;
        }
        ExtensionEntity extensionEntity = (ExtensionEntity) obj;
        return Intrinsics.areEqual(this.f20id, extensionEntity.f20id) && Intrinsics.areEqual(this.name, extensionEntity.name) && Intrinsics.areEqual(this.description, extensionEntity.description) && Intrinsics.areEqual(this.icon, extensionEntity.icon) && this.isPreloaded == extensionEntity.isPreloaded && this.isNSFW == extensionEntity.isNSFW && Intrinsics.areEqual(this.version, extensionEntity.version) && Intrinsics.areEqual(this.apiLevel, extensionEntity.apiLevel) && this.isTopLevel == extensionEntity.isTopLevel && this.isEnabled == extensionEntity.isEnabled && Intrinsics.areEqual(this.categories, extensionEntity.categories) && Intrinsics.areEqual(this.lastUpdateTimestamp, extensionEntity.lastUpdateTimestamp) && Intrinsics.areEqual(this.installationTimestamp, extensionEntity.installationTimestamp) && Intrinsics.areEqual(this.repositoryBaseUrl, extensionEntity.repositoryBaseUrl);
    }

    public int hashCode() {
        int iHashCode = this.f20id.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int iHashCode4 = (((((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.isPreloaded)) * 31) + Boolean.hashCode(this.isNSFW)) * 31) + this.version.hashCode()) * 31;
        Integer num = this.apiLevel;
        int iHashCode5 = (((((((iHashCode4 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.isTopLevel)) * 31) + Boolean.hashCode(this.isEnabled)) * 31) + this.categories.hashCode()) * 31;
        Date date = this.lastUpdateTimestamp;
        int iHashCode6 = (((iHashCode5 + (date == null ? 0 : date.hashCode())) * 31) + this.installationTimestamp.hashCode()) * 31;
        String str4 = this.repositoryBaseUrl;
        return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ExtensionEntity(id=" + this.f20id + ", name=" + this.name + ", description=" + this.description + ", icon=" + this.icon + ", isPreloaded=" + this.isPreloaded + ", isNSFW=" + this.isNSFW + ", version=" + this.version + ", apiLevel=" + this.apiLevel + ", isTopLevel=" + this.isTopLevel + ", isEnabled=" + this.isEnabled + ", categories=" + this.categories + ", lastUpdateTimestamp=" + this.lastUpdateTimestamp + ", installationTimestamp=" + this.installationTimestamp + ", repositoryBaseUrl=" + this.repositoryBaseUrl + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f20id);
        out.writeString(this.name);
        out.writeString(this.description);
        out.writeString(this.icon);
        out.writeInt(this.isPreloaded ? 1 : 0);
        out.writeInt(this.isNSFW ? 1 : 0);
        out.writeString(this.version);
        Integer num = this.apiLevel;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
        out.writeInt(this.isTopLevel ? 1 : 0);
        out.writeInt(this.isEnabled ? 1 : 0);
        out.writeStringList(this.categories);
        out.writeSerializable(this.lastUpdateTimestamp);
        out.writeSerializable(this.installationTimestamp);
        out.writeString(this.repositoryBaseUrl);
    }

    public ExtensionEntity(String id2, String str, String str2, String str3, boolean z, boolean z2, String version, Integer num, boolean z3, boolean z4, List<String> categories, Date date, Date installationTimestamp, String str4) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(installationTimestamp, "installationTimestamp");
        this.f20id = id2;
        this.name = str;
        this.description = str2;
        this.icon = str3;
        this.isPreloaded = z;
        this.isNSFW = z2;
        this.version = version;
        this.apiLevel = num;
        this.isTopLevel = z3;
        this.isEnabled = z4;
        this.categories = categories;
        this.lastUpdateTimestamp = date;
        this.installationTimestamp = installationTimestamp;
        this.repositoryBaseUrl = str4;
    }

    public final String getId() {
        return this.f20id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f20id = str;
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

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final boolean isPreloaded() {
        return this.isPreloaded;
    }

    public final void setPreloaded(boolean z) {
        this.isPreloaded = z;
    }

    public final boolean isNSFW() {
        return this.isNSFW;
    }

    public final void setNSFW(boolean z) {
        this.isNSFW = z;
    }

    public /* synthetic */ ExtensionEntity(String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, Integer num, boolean z3, boolean z4, List list, Date date, Date date2, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? "0.0.0" : str5, (i & 128) != 0 ? null : num, z3, z4, list, (i & 2048) != 0 ? null : date, date2, (i & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? null : str6);
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public final Integer getApiLevel() {
        return this.apiLevel;
    }

    public final void setApiLevel(Integer num) {
        this.apiLevel = num;
    }

    public final boolean isTopLevel() {
        return this.isTopLevel;
    }

    public final void setTopLevel(boolean z) {
        this.isTopLevel = z;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final void setCategories(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.categories = list;
    }

    public final Date getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }

    public final void setLastUpdateTimestamp(Date date) {
        this.lastUpdateTimestamp = date;
    }

    public final Date getInstallationTimestamp() {
        return this.installationTimestamp;
    }

    public final void setInstallationTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.installationTimestamp = date;
    }

    public final String getRepositoryBaseUrl() {
        return this.repositoryBaseUrl;
    }

    public final void setRepositoryBaseUrl(String str) {
        this.repositoryBaseUrl = str;
    }
}
