package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionDependencyPairEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ExtensionDependencyPairEntity;", "Landroid/os/Parcelable;", "id", "", "providerExtensionId", "", "requirerExtensionId", "versionConstraint", "extra", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getProviderExtensionId", "setProviderExtensionId", "getRequirerExtensionId", "setRequirerExtensionId", "getVersionConstraint", "setVersionConstraint", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExtensionDependencyPairEntity implements Parcelable {
    public static final Parcelable.Creator<ExtensionDependencyPairEntity> CREATOR = new Creator();
    private String extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f19id;
    private String providerExtensionId;
    private String requirerExtensionId;
    private String versionConstraint;

    /* JADX INFO: compiled from: ExtensionDependencyPairEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExtensionDependencyPairEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionDependencyPairEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExtensionDependencyPairEntity(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtensionDependencyPairEntity[] newArray(int i) {
            return new ExtensionDependencyPairEntity[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f19id);
        out.writeString(this.providerExtensionId);
        out.writeString(this.requirerExtensionId);
        out.writeString(this.versionConstraint);
        out.writeString(this.extra);
    }

    public ExtensionDependencyPairEntity(long j, String providerExtensionId, String requirerExtensionId, String versionConstraint, String extra) {
        Intrinsics.checkNotNullParameter(providerExtensionId, "providerExtensionId");
        Intrinsics.checkNotNullParameter(requirerExtensionId, "requirerExtensionId");
        Intrinsics.checkNotNullParameter(versionConstraint, "versionConstraint");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.f19id = j;
        this.providerExtensionId = providerExtensionId;
        this.requirerExtensionId = requirerExtensionId;
        this.versionConstraint = versionConstraint;
        this.extra = extra;
    }

    public final long getId() {
        return this.f19id;
    }

    public final void setId(long j) {
        this.f19id = j;
    }

    public final String getProviderExtensionId() {
        return this.providerExtensionId;
    }

    public final void setProviderExtensionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.providerExtensionId = str;
    }

    public final String getRequirerExtensionId() {
        return this.requirerExtensionId;
    }

    public final void setRequirerExtensionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requirerExtensionId = str;
    }

    public final String getVersionConstraint() {
        return this.versionConstraint;
    }

    public final void setVersionConstraint(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.versionConstraint = str;
    }

    public /* synthetic */ ExtensionDependencyPairEntity(long j, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, str3, (i & 16) != 0 ? "" : str4);
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }
}
