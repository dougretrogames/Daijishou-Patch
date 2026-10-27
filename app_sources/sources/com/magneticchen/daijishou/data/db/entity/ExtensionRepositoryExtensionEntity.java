package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionRepositoryExtensionEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b2\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\nHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\u0088\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010?J\t\u0010@\u001a\u00020\nHÖ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\nHÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001J\u0019\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\nHÖ\u0001R\"\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001e\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001e¨\u0006L"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionEntity;", "Landroid/os/Parcelable;", "id", "", "repositoryId", "", "extensionId", "name", "description", "versionCode", "", "versionName", "githubUrlString", "githubStars", "dependencies", "", "apiLevel", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/Integer;)V", "getApiLevel", "()Ljava/lang/Integer;", "setApiLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDependencies", "()Ljava/util/List;", "setDependencies", "(Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getExtensionId", "setExtensionId", "getGithubStars", "()I", "setGithubStars", "(I)V", "getGithubUrlString", "setGithubUrlString", "getId", "()J", "setId", "(J)V", "getName", "setName", "getRepositoryId", "setRepositoryId", "getVersionCode", "setVersionCode", "getVersionName", "setVersionName", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/Integer;)Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionEntity;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExtensionRepositoryExtensionEntity implements Parcelable {
    public static final Parcelable.Creator<ExtensionRepositoryExtensionEntity> CREATOR = new Creator();
    private Integer apiLevel;
    private List<String> dependencies;
    private String description;
    private String extensionId;
    private int githubStars;
    private String githubUrlString;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f22id;
    private String name;
    private String repositoryId;
    private int versionCode;
    private String versionName;

    /* JADX INFO: compiled from: ExtensionRepositoryExtensionEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExtensionRepositoryExtensionEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionRepositoryExtensionEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExtensionRepositoryExtensionEntity(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.createStringArrayList(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionRepositoryExtensionEntity[] newArray(int i) {
            return new ExtensionRepositoryExtensionEntity[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtensionRepositoryExtensionEntity copy$default(ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity, long j, String str, String str2, String str3, String str4, int i, String str5, String str6, int i2, List list, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = extensionRepositoryExtensionEntity.f22id;
        }
        return extensionRepositoryExtensionEntity.copy(j, (i3 & 2) != 0 ? extensionRepositoryExtensionEntity.repositoryId : str, (i3 & 4) != 0 ? extensionRepositoryExtensionEntity.extensionId : str2, (i3 & 8) != 0 ? extensionRepositoryExtensionEntity.name : str3, (i3 & 16) != 0 ? extensionRepositoryExtensionEntity.description : str4, (i3 & 32) != 0 ? extensionRepositoryExtensionEntity.versionCode : i, (i3 & 64) != 0 ? extensionRepositoryExtensionEntity.versionName : str5, (i3 & 128) != 0 ? extensionRepositoryExtensionEntity.githubUrlString : str6, (i3 & 256) != 0 ? extensionRepositoryExtensionEntity.githubStars : i2, (i3 & 512) != 0 ? extensionRepositoryExtensionEntity.dependencies : list, (i3 & CategoryWidgetViewModel.LIMIT) != 0 ? extensionRepositoryExtensionEntity.apiLevel : num);
    }

    public final long component1() {
        return this.f22id;
    }

    public final List<String> component10() {
        return this.dependencies;
    }

    public final Integer component11() {
        return this.apiLevel;
    }

    public final String component2() {
        return this.repositoryId;
    }

    public final String component3() {
        return this.extensionId;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.description;
    }

    public final int component6() {
        return this.versionCode;
    }

    public final String component7() {
        return this.versionName;
    }

    public final String component8() {
        return this.githubUrlString;
    }

    public final int component9() {
        return this.githubStars;
    }

    public final ExtensionRepositoryExtensionEntity copy(long j, String repositoryId, String extensionId, String str, String description, int i, String str2, String githubUrlString, int i2, List<String> dependencies, Integer num) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(githubUrlString, "githubUrlString");
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        return new ExtensionRepositoryExtensionEntity(j, repositoryId, extensionId, str, description, i, str2, githubUrlString, i2, dependencies, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionRepositoryExtensionEntity)) {
            return false;
        }
        ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity = (ExtensionRepositoryExtensionEntity) obj;
        return this.f22id == extensionRepositoryExtensionEntity.f22id && Intrinsics.areEqual(this.repositoryId, extensionRepositoryExtensionEntity.repositoryId) && Intrinsics.areEqual(this.extensionId, extensionRepositoryExtensionEntity.extensionId) && Intrinsics.areEqual(this.name, extensionRepositoryExtensionEntity.name) && Intrinsics.areEqual(this.description, extensionRepositoryExtensionEntity.description) && this.versionCode == extensionRepositoryExtensionEntity.versionCode && Intrinsics.areEqual(this.versionName, extensionRepositoryExtensionEntity.versionName) && Intrinsics.areEqual(this.githubUrlString, extensionRepositoryExtensionEntity.githubUrlString) && this.githubStars == extensionRepositoryExtensionEntity.githubStars && Intrinsics.areEqual(this.dependencies, extensionRepositoryExtensionEntity.dependencies) && Intrinsics.areEqual(this.apiLevel, extensionRepositoryExtensionEntity.apiLevel);
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.f22id) * 31) + this.repositoryId.hashCode()) * 31) + this.extensionId.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.versionCode)) * 31;
        String str2 = this.versionName;
        int iHashCode3 = (((((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.githubUrlString.hashCode()) * 31) + Integer.hashCode(this.githubStars)) * 31) + this.dependencies.hashCode()) * 31;
        Integer num = this.apiLevel;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ExtensionRepositoryExtensionEntity(id=" + this.f22id + ", repositoryId=" + this.repositoryId + ", extensionId=" + this.extensionId + ", name=" + this.name + ", description=" + this.description + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", githubUrlString=" + this.githubUrlString + ", githubStars=" + this.githubStars + ", dependencies=" + this.dependencies + ", apiLevel=" + this.apiLevel + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f22id);
        out.writeString(this.repositoryId);
        out.writeString(this.extensionId);
        out.writeString(this.name);
        out.writeString(this.description);
        out.writeInt(this.versionCode);
        out.writeString(this.versionName);
        out.writeString(this.githubUrlString);
        out.writeInt(this.githubStars);
        out.writeStringList(this.dependencies);
        Integer num = this.apiLevel;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
    }

    public ExtensionRepositoryExtensionEntity(long j, String repositoryId, String extensionId, String str, String description, int i, String str2, String githubUrlString, int i2, List<String> dependencies, Integer num) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(githubUrlString, "githubUrlString");
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        this.f22id = j;
        this.repositoryId = repositoryId;
        this.extensionId = extensionId;
        this.name = str;
        this.description = description;
        this.versionCode = i;
        this.versionName = str2;
        this.githubUrlString = githubUrlString;
        this.githubStars = i2;
        this.dependencies = dependencies;
        this.apiLevel = num;
    }

    public /* synthetic */ ExtensionRepositoryExtensionEntity(long j, String str, String str2, String str3, String str4, int i, String str5, String str6, int i2, List list, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, str, str2, str3, str4, i, (i3 & 64) != 0 ? null : str5, str6, (i3 & 256) != 0 ? 0 : i2, list, (i3 & CategoryWidgetViewModel.LIMIT) != 0 ? null : num);
    }

    public final long getId() {
        return this.f22id;
    }

    public final void setId(long j) {
        this.f22id = j;
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
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final void setVersionCode(int i) {
        this.versionCode = i;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final void setVersionName(String str) {
        this.versionName = str;
    }

    public final String getGithubUrlString() {
        return this.githubUrlString;
    }

    public final void setGithubUrlString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.githubUrlString = str;
    }

    public final int getGithubStars() {
        return this.githubStars;
    }

    public final void setGithubStars(int i) {
        this.githubStars = i;
    }

    public final List<String> getDependencies() {
        return this.dependencies;
    }

    public final void setDependencies(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dependencies = list;
    }

    public final Integer getApiLevel() {
        return this.apiLevel;
    }

    public final void setApiLevel(Integer num) {
        this.apiLevel = num;
    }
}
