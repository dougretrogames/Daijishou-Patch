package com.magneticchen.daijishou.daijishou_widget.widget_db;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: PinAndPlayWidgetInstanceEntity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J:\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0000J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widget_db/PinAndPlayWidgetInstanceEntity;", "Landroid/os/Parcelable;", "id", "", "playableItemId", "alternativeImagePath", "", "lastUpdateTimestamp", "Ljava/util/Date;", "(JLjava/lang/Long;Ljava/lang/String;Ljava/util/Date;)V", "getAlternativeImagePath", "()Ljava/lang/String;", "setAlternativeImagePath", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getLastUpdateTimestamp", "()Ljava/util/Date;", "setLastUpdateTimestamp", "(Ljava/util/Date;)V", "getPlayableItemId", "()Ljava/lang/Long;", "setPlayableItemId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(JLjava/lang/Long;Ljava/lang/String;Ljava/util/Date;)Lcom/magneticchen/daijishou/daijishou_widget/widget_db/PinAndPlayWidgetInstanceEntity;", "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PinAndPlayWidgetInstanceEntity implements Parcelable {
    public static final Parcelable.Creator<PinAndPlayWidgetInstanceEntity> CREATOR = new Creator();
    private String alternativeImagePath;
    private long id;
    private Date lastUpdateTimestamp;
    private Long playableItemId;

    /* INFO: compiled from: PinAndPlayWidgetInstanceEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PinAndPlayWidgetInstanceEntity> {
        /* WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PinAndPlayWidgetInstanceEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PinAndPlayWidgetInstanceEntity(parcel.readLong(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), (Date) parcel.readSerializable());
        }

        /* WARN: Can't rename method to resolve collision */
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
            j = pinAndPlayWidgetInstanceEntity.id;
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

    /* INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final Long getPlayableItemId() {
        return this.playableItemId;
    }

    /* INFO: renamed from: component3, reason: from getter */
    public final String getAlternativeImagePath() {
        return this.alternativeImagePath;
    }

    /* INFO: renamed from: component4, reason: from getter */
    public final Date getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }

    public final PinAndPlayWidgetInstanceEntity copy(long id2, Long playableItemId, String alternativeImagePath, Date lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(lastUpdateTimestamp, "lastUpdateTimestamp");
        return new PinAndPlayWidgetInstanceEntity(id2, playableItemId, alternativeImagePath, lastUpdateTimestamp);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PinAndPlayWidgetInstanceEntity)) {
            return false;
        }
        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity = (PinAndPlayWidgetInstanceEntity) other;
        return this.id == pinAndPlayWidgetInstanceEntity.id && Intrinsics.areEqual(this.playableItemId, pinAndPlayWidgetInstanceEntity.playableItemId) && Intrinsics.areEqual(this.alternativeImagePath, pinAndPlayWidgetInstanceEntity.alternativeImagePath) && Intrinsics.areEqual(this.lastUpdateTimestamp, pinAndPlayWidgetInstanceEntity.lastUpdateTimestamp);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        Long l = this.playableItemId;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.alternativeImagePath;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.lastUpdateTimestamp.hashCode();
    }

    public String toString() {
        return "PinAndPlayWidgetInstanceEntity(id=" + this.id + ", playableItemId=" + this.playableItemId + ", alternativeImagePath=" + this.alternativeImagePath + ", lastUpdateTimestamp=" + this.lastUpdateTimestamp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        Long l = this.playableItemId;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.alternativeImagePath);
        parcel.writeSerializable(this.lastUpdateTimestamp);
    }

    public PinAndPlayWidgetInstanceEntity(long j, Long l, String str, Date lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(lastUpdateTimestamp, "lastUpdateTimestamp");
        this.id = j;
        this.playableItemId = l;
        this.alternativeImagePath = str;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setPlayableItemId(Long l) {
        this.playableItemId = l;
    }


    public final void setAlternativeImagePath(String str) {
        this.alternativeImagePath = str;
    }

    public /* synthetic */ PinAndPlayWidgetInstanceEntity(long j, Long l, String str, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? new Date() : date);
    }


    public final void setLastUpdateTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.lastUpdateTimestamp = date;
    }

    public final PinAndPlayWidgetInstanceEntity copyAndResetDatabaseAndDeviceDependentValues() {
        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntityCopy$default = copy$default(this, 0L, null, null, null, 15, null);
        pinAndPlayWidgetInstanceEntityCopy$default.id = 0L;
        return pinAndPlayWidgetInstanceEntityCopy$default;
    }
}
