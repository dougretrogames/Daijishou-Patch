package com.magneticchen.daijishou.daijishou_widget.widget_db;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: AppShortcutWidgetInstanceEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J5\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0000J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006+"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widget_db/AppShortcutWidgetInstanceEntity;", "Landroid/os/Parcelable;", "id", "", "resolveInfoStringId", "", "alternativeImagePath", "lastUpdateTimestamp", "Ljava/util/Date;", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/Date;)V", "getAlternativeImagePath", "()Ljava/lang/String;", "setAlternativeImagePath", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getLastUpdateTimestamp", "()Ljava/util/Date;", "setLastUpdateTimestamp", "(Ljava/util/Date;)V", "getResolveInfoStringId", "setResolveInfoStringId", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class AppShortcutWidgetInstanceEntity implements Parcelable {
    public static final Parcelable.Creator<AppShortcutWidgetInstanceEntity> CREATOR = new Creator();
    private String alternativeImagePath;
    private long id;
    private Date lastUpdateTimestamp;
    private String resolveInfoStringId;

    /* JADX INFO: compiled from: AppShortcutWidgetInstanceEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AppShortcutWidgetInstanceEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppShortcutWidgetInstanceEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AppShortcutWidgetInstanceEntity(parcel.readLong(), parcel.readString(), parcel.readString(), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppShortcutWidgetInstanceEntity[] newArray(int i) {
            return new AppShortcutWidgetInstanceEntity[i];
        }
    }

    public AppShortcutWidgetInstanceEntity() {
        this(0L, null, null, null, 15, null);
    }

    public static /* synthetic */ AppShortcutWidgetInstanceEntity copy$default(AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntity, long j, String str, String str2, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            j = appShortcutWidgetInstanceEntity.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = appShortcutWidgetInstanceEntity.resolveInfoStringId;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = appShortcutWidgetInstanceEntity.alternativeImagePath;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            date = appShortcutWidgetInstanceEntity.lastUpdateTimestamp;
        }
        return appShortcutWidgetInstanceEntity.copy(j2, str3, str4, date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getResolveInfoStringId() {
        return this.resolveInfoStringId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAlternativeImagePath() {
        return this.alternativeImagePath;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }

    public final AppShortcutWidgetInstanceEntity copy(long id2, String resolveInfoStringId, String alternativeImagePath, Date lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(lastUpdateTimestamp, "lastUpdateTimestamp");
        return new AppShortcutWidgetInstanceEntity(id2, resolveInfoStringId, alternativeImagePath, lastUpdateTimestamp);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppShortcutWidgetInstanceEntity)) {
            return false;
        }
        AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntity = (AppShortcutWidgetInstanceEntity) other;
        return this.id == appShortcutWidgetInstanceEntity.id && Intrinsics.areEqual(this.resolveInfoStringId, appShortcutWidgetInstanceEntity.resolveInfoStringId) && Intrinsics.areEqual(this.alternativeImagePath, appShortcutWidgetInstanceEntity.alternativeImagePath) && Intrinsics.areEqual(this.lastUpdateTimestamp, appShortcutWidgetInstanceEntity.lastUpdateTimestamp);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.resolveInfoStringId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.alternativeImagePath;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.lastUpdateTimestamp.hashCode();
    }

    public String toString() {
        return "AppShortcutWidgetInstanceEntity(id=" + this.id + ", resolveInfoStringId=" + this.resolveInfoStringId + ", alternativeImagePath=" + this.alternativeImagePath + ", lastUpdateTimestamp=" + this.lastUpdateTimestamp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeString(this.resolveInfoStringId);
        parcel.writeString(this.alternativeImagePath);
        parcel.writeSerializable(this.lastUpdateTimestamp);
    }

    public AppShortcutWidgetInstanceEntity(long j, String str, String str2, Date lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(lastUpdateTimestamp, "lastUpdateTimestamp");
        this.id = j;
        this.resolveInfoStringId = str;
        this.alternativeImagePath = str2;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setResolveInfoStringId(String str) {
        this.resolveInfoStringId = str;
    }


    public final void setAlternativeImagePath(String str) {
        this.alternativeImagePath = str;
    }

    public /* synthetic */ AppShortcutWidgetInstanceEntity(long j, String str, String str2, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? new Date() : date);
    }


    public final void setLastUpdateTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.lastUpdateTimestamp = date;
    }

    public final AppShortcutWidgetInstanceEntity copyAndResetDatabaseAndDeviceDependentValues() {
        AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntityCopy$default = copy$default(this, 0L, null, null, null, 15, null);
        appShortcutWidgetInstanceEntityCopy$default.id = 0L;
        if (this.alternativeImagePath != null) {
            String str = this.alternativeImagePath;
            Intrinsics.checkNotNull(str);
            if (new File(str).exists()) {
                return appShortcutWidgetInstanceEntityCopy$default;
            }
        }
        appShortcutWidgetInstanceEntityCopy$default.alternativeImagePath = null;
        return appShortcutWidgetInstanceEntityCopy$default;
    }
}
