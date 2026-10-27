package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PinAndPlayWidgetInstanceEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J:\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0000J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/PinAndPlayWidgetInstanceEntity;", "Landroid/os/Parcelable;", "id", "", "playableItemId", "alternativeImagePath", "", "lastUpdateTimestamp", "Ljava/util/Date;", "(JLjava/lang/Long;Ljava/lang/String;Ljava/util/Date;)V", "getAlternativeImagePath", "()Ljava/lang/String;", "setAlternativeImagePath", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getLastUpdateTimestamp", "()Ljava/util/Date;", "setLastUpdateTimestamp", "(Ljava/util/Date;)V", "getPlayableItemId", "()Ljava/lang/Long;", "setPlayableItemId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(JLjava/lang/Long;Ljava/lang/String;Ljava/util/Date;)Lcom/magneticchen/daijishou/data/db/entity/PinAndPlayWidgetInstanceEntity;", "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PinAndPlayWidgetInstanceEntity implements Parcelable {
    public static final Parcelable.Creator<PinAndPlayWidgetInstanceEntity> CREATOR = new Creator();
    private String alternativeImagePath;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f29id;
    private Date lastUpdateTimestamp;
    private Long playableItemId;

    /* JADX INFO: compiled from: PinAndPlayWidgetInstanceEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PinAndPlayWidgetInstanceEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PinAndPlayWidgetInstanceEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PinAndPlayWidgetInstanceEntity(parcel.readLong(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PinAndPlayWidgetInstanceEntity[] newArray(int i) {
            return new PinAndPlayWidgetInstanceEntity[i];
        }
    }

    public PinAndPlayWidgetInstanceEntity() {
        this(0L, null, null, null, 15, null);
    }

    public static /* synthetic */ PinAndPlayWidgetInstanceEntity copy$default(PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity, long j, Long l, String str, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pinAndPlayWidgetInstanceEntity.f29id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            l = pinAndPlayWidgetInstanceEntity.playableItemId;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            str = pinAndPlayWidgetInstanceEntity.alternativeImagePath;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            date = pinAndPlayWidgetInstanceEntity.lastUpdateTimestamp;
        }
        return pinAndPlayWidgetInstanceEntity.copy(j2, l2, str2, date);
    }

    public final long component1() {
        return this.f29id;
    }

    public final Long component2() {
        return this.playableItemId;
    }

    public final String component3() {
        return this.alternativeImagePath;
    }

    public final Date component4() {
        return this.lastUpdateTimestamp;
    }

    public final PinAndPlayWidgetInstanceEntity copy(long j, Long l, String str, Date lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(lastUpdateTimestamp, "lastUpdateTimestamp");
        return new PinAndPlayWidgetInstanceEntity(j, l, str, lastUpdateTimestamp);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PinAndPlayWidgetInstanceEntity)) {
            return false;
        }
        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity = (PinAndPlayWidgetInstanceEntity) obj;
        return this.f29id == pinAndPlayWidgetInstanceEntity.f29id && Intrinsics.areEqual(this.playableItemId, pinAndPlayWidgetInstanceEntity.playableItemId) && Intrinsics.areEqual(this.alternativeImagePath, pinAndPlayWidgetInstanceEntity.alternativeImagePath) && Intrinsics.areEqual(this.lastUpdateTimestamp, pinAndPlayWidgetInstanceEntity.lastUpdateTimestamp);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f29id) * 31;
        Long l = this.playableItemId;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.alternativeImagePath;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.lastUpdateTimestamp.hashCode();
    }

    public String toString() {
        return "PinAndPlayWidgetInstanceEntity(id=" + this.f29id + ", playableItemId=" + this.playableItemId + ", alternativeImagePath=" + this.alternativeImagePath + ", lastUpdateTimestamp=" + this.lastUpdateTimestamp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f29id);
        Long l = this.playableItemId;
        if (l == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l.longValue());
        }
        out.writeString(this.alternativeImagePath);
        out.writeSerializable(this.lastUpdateTimestamp);
    }

    public PinAndPlayWidgetInstanceEntity(long j, Long l, String str, Date lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(lastUpdateTimestamp, "lastUpdateTimestamp");
        this.f29id = j;
        this.playableItemId = l;
        this.alternativeImagePath = str;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public final long getId() {
        return this.f29id;
    }

    public final void setId(long j) {
        this.f29id = j;
    }

    public final Long getPlayableItemId() {
        return this.playableItemId;
    }

    public final void setPlayableItemId(Long l) {
        this.playableItemId = l;
    }

    public final String getAlternativeImagePath() {
        return this.alternativeImagePath;
    }

    public final void setAlternativeImagePath(String str) {
        this.alternativeImagePath = str;
    }

    public /* synthetic */ PinAndPlayWidgetInstanceEntity(long j, Long l, String str, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? new Date() : date);
    }

    public final Date getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }

    public final void setLastUpdateTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.lastUpdateTimestamp = date;
    }

    public final PinAndPlayWidgetInstanceEntity copyAndResetDatabaseAndDeviceDependentValues() {
        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntityCopy$default = copy$default(this, 0L, null, null, null, 15, null);
        pinAndPlayWidgetInstanceEntityCopy$default.f29id = 0L;
        return pinAndPlayWidgetInstanceEntityCopy$default;
    }
}
