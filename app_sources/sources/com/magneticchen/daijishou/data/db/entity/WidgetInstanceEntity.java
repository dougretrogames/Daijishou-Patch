package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WidgetInstanceEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010$\u001a\u00020\u0000J\t\u0010%\u001a\u00020\nHÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\nHÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\nHÖ\u0001R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u00061"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/WidgetInstanceEntity;", "Landroid/os/Parcelable;", "id", "", "widgetId", "", "widgetInstanceId", "addedDateTimestamp", "Ljava/util/Date;", "position", "", "(JLjava/lang/String;JLjava/util/Date;I)V", "getAddedDateTimestamp", "()Ljava/util/Date;", "setAddedDateTimestamp", "(Ljava/util/Date;)V", "getId", "()J", "setId", "(J)V", "getPosition", "()I", "setPosition", "(I)V", "getWidgetId", "()Ljava/lang/String;", "setWidgetId", "(Ljava/lang/String;)V", "getWidgetInstanceId", "setWidgetInstanceId", "component1", "component2", "component3", "component4", "component5", "copy", "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetInstanceEntity implements Parcelable {
    public static final Parcelable.Creator<WidgetInstanceEntity> CREATOR = new Creator();
    private Date addedDateTimestamp;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f44id;
    private int position;
    private String widgetId;
    private long widgetInstanceId;

    /* JADX INFO: compiled from: WidgetInstanceEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WidgetInstanceEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetInstanceEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WidgetInstanceEntity(parcel.readLong(), parcel.readString(), parcel.readLong(), (Date) parcel.readSerializable(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetInstanceEntity[] newArray(int i) {
            return new WidgetInstanceEntity[i];
        }
    }

    public static /* synthetic */ WidgetInstanceEntity copy$default(WidgetInstanceEntity widgetInstanceEntity, long j, String str, long j2, Date date, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = widgetInstanceEntity.f44id;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            str = widgetInstanceEntity.widgetId;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            j2 = widgetInstanceEntity.widgetInstanceId;
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            date = widgetInstanceEntity.addedDateTimestamp;
        }
        Date date2 = date;
        if ((i2 & 16) != 0) {
            i = widgetInstanceEntity.position;
        }
        return widgetInstanceEntity.copy(j3, str2, j4, date2, i);
    }

    public final long component1() {
        return this.f44id;
    }

    public final String component2() {
        return this.widgetId;
    }

    public final long component3() {
        return this.widgetInstanceId;
    }

    public final Date component4() {
        return this.addedDateTimestamp;
    }

    public final int component5() {
        return this.position;
    }

    public final WidgetInstanceEntity copy(long j, String widgetId, long j2, Date addedDateTimestamp, int i) {
        Intrinsics.checkNotNullParameter(widgetId, "widgetId");
        Intrinsics.checkNotNullParameter(addedDateTimestamp, "addedDateTimestamp");
        return new WidgetInstanceEntity(j, widgetId, j2, addedDateTimestamp, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WidgetInstanceEntity)) {
            return false;
        }
        WidgetInstanceEntity widgetInstanceEntity = (WidgetInstanceEntity) obj;
        return this.f44id == widgetInstanceEntity.f44id && Intrinsics.areEqual(this.widgetId, widgetInstanceEntity.widgetId) && this.widgetInstanceId == widgetInstanceEntity.widgetInstanceId && Intrinsics.areEqual(this.addedDateTimestamp, widgetInstanceEntity.addedDateTimestamp) && this.position == widgetInstanceEntity.position;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f44id) * 31) + this.widgetId.hashCode()) * 31) + Long.hashCode(this.widgetInstanceId)) * 31) + this.addedDateTimestamp.hashCode()) * 31) + Integer.hashCode(this.position);
    }

    public String toString() {
        return "WidgetInstanceEntity(id=" + this.f44id + ", widgetId=" + this.widgetId + ", widgetInstanceId=" + this.widgetInstanceId + ", addedDateTimestamp=" + this.addedDateTimestamp + ", position=" + this.position + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f44id);
        out.writeString(this.widgetId);
        out.writeLong(this.widgetInstanceId);
        out.writeSerializable(this.addedDateTimestamp);
        out.writeInt(this.position);
    }

    public WidgetInstanceEntity(long j, String widgetId, long j2, Date addedDateTimestamp, int i) {
        Intrinsics.checkNotNullParameter(widgetId, "widgetId");
        Intrinsics.checkNotNullParameter(addedDateTimestamp, "addedDateTimestamp");
        this.f44id = j;
        this.widgetId = widgetId;
        this.widgetInstanceId = j2;
        this.addedDateTimestamp = addedDateTimestamp;
        this.position = i;
    }

    public final long getId() {
        return this.f44id;
    }

    public final void setId(long j) {
        this.f44id = j;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public final void setWidgetId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.widgetId = str;
    }

    public final long getWidgetInstanceId() {
        return this.widgetInstanceId;
    }

    public final void setWidgetInstanceId(long j) {
        this.widgetInstanceId = j;
    }

    public /* synthetic */ WidgetInstanceEntity(long j, String str, long j2, Date date, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, str, j2, (i2 & 8) != 0 ? new Date() : date, (i2 & 16) != 0 ? -1 : i);
    }

    public final Date getAddedDateTimestamp() {
        return this.addedDateTimestamp;
    }

    public final void setAddedDateTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.addedDateTimestamp = date;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final WidgetInstanceEntity copyAndResetDatabaseAndDeviceDependentValues() {
        WidgetInstanceEntity widgetInstanceEntityCopy$default = copy$default(this, 0L, null, 0L, null, 0, 31, null);
        widgetInstanceEntityCopy$default.f44id = 0L;
        return widgetInstanceEntityCopy$default;
    }
}
