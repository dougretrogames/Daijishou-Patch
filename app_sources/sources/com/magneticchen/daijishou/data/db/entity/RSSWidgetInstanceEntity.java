package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RSSWidgetInstanceEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0000J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/RSSWidgetInstanceEntity;", "Landroid/os/Parcelable;", "id", "", "url", "", "lastUpdateTimestamp", "Ljava/util/Date;", "(JLjava/lang/String;Ljava/util/Date;)V", "getId", "()J", "setId", "(J)V", "getLastUpdateTimestamp", "()Ljava/util/Date;", "setLastUpdateTimestamp", "(Ljava/util/Date;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RSSWidgetInstanceEntity implements Parcelable {
    public static final Parcelable.Creator<RSSWidgetInstanceEntity> CREATOR = new Creator();

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f35id;
    private Date lastUpdateTimestamp;
    private String url;

    /* JADX INFO: compiled from: RSSWidgetInstanceEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RSSWidgetInstanceEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RSSWidgetInstanceEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RSSWidgetInstanceEntity(parcel.readLong(), parcel.readString(), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RSSWidgetInstanceEntity[] newArray(int i) {
            return new RSSWidgetInstanceEntity[i];
        }
    }

    public RSSWidgetInstanceEntity() {
        this(0L, null, null, 7, null);
    }

    public static /* synthetic */ RSSWidgetInstanceEntity copy$default(RSSWidgetInstanceEntity rSSWidgetInstanceEntity, long j, String str, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            j = rSSWidgetInstanceEntity.f35id;
        }
        if ((i & 2) != 0) {
            str = rSSWidgetInstanceEntity.url;
        }
        if ((i & 4) != 0) {
            date = rSSWidgetInstanceEntity.lastUpdateTimestamp;
        }
        return rSSWidgetInstanceEntity.copy(j, str, date);
    }

    public final long component1() {
        return this.f35id;
    }

    public final String component2() {
        return this.url;
    }

    public final Date component3() {
        return this.lastUpdateTimestamp;
    }

    public final RSSWidgetInstanceEntity copy(long j, String str, Date lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(lastUpdateTimestamp, "lastUpdateTimestamp");
        return new RSSWidgetInstanceEntity(j, str, lastUpdateTimestamp);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RSSWidgetInstanceEntity)) {
            return false;
        }
        RSSWidgetInstanceEntity rSSWidgetInstanceEntity = (RSSWidgetInstanceEntity) obj;
        return this.f35id == rSSWidgetInstanceEntity.f35id && Intrinsics.areEqual(this.url, rSSWidgetInstanceEntity.url) && Intrinsics.areEqual(this.lastUpdateTimestamp, rSSWidgetInstanceEntity.lastUpdateTimestamp);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f35id) * 31;
        String str = this.url;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.lastUpdateTimestamp.hashCode();
    }

    public String toString() {
        return "RSSWidgetInstanceEntity(id=" + this.f35id + ", url=" + this.url + ", lastUpdateTimestamp=" + this.lastUpdateTimestamp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f35id);
        out.writeString(this.url);
        out.writeSerializable(this.lastUpdateTimestamp);
    }

    public RSSWidgetInstanceEntity(long j, String str, Date lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(lastUpdateTimestamp, "lastUpdateTimestamp");
        this.f35id = j;
        this.url = str;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public final long getId() {
        return this.f35id;
    }

    public final void setId(long j) {
        this.f35id = j;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public /* synthetic */ RSSWidgetInstanceEntity(long j, String str, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new Date() : date);
    }

    public final Date getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }

    public final void setLastUpdateTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.lastUpdateTimestamp = date;
    }

    public final RSSWidgetInstanceEntity copyAndResetDatabaseAndDeviceDependentValues() {
        RSSWidgetInstanceEntity rSSWidgetInstanceEntityCopy$default = copy$default(this, 0L, null, null, 7, null);
        rSSWidgetInstanceEntityCopy$default.f35id = 0L;
        return rSSWidgetInstanceEntityCopy$default;
    }
}
