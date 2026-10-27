package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0001CB]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00102\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003Jf\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u00105J\u0006\u00106\u001a\u00020\u0000J\t\u00107\u001a\u00020\u0005HÖ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\t\u0010=\u001a\u00020\rHÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006D"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/EventEntity;", "Landroid/os/Parcelable;", "id", "", "event", "", "timestamp", "Ljava/util/Date;", "playableItemId", "platformId", "playerId", "parcelable", "extra", "", "(JILjava/util/Date;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Landroid/os/Parcelable;Ljava/lang/String;)V", "getEvent", "()I", "setEvent", "(I)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getParcelable", "()Landroid/os/Parcelable;", "setParcelable", "(Landroid/os/Parcelable;)V", "getPlatformId", "()Ljava/lang/Long;", "setPlatformId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPlayableItemId", "setPlayableItemId", "getPlayerId", "setPlayerId", "getTimestamp", "()Ljava/util/Date;", "setTimestamp", "(Ljava/util/Date;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JILjava/util/Date;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Landroid/os/Parcelable;Ljava/lang/String;)Lcom/magneticchen/daijishou/data/db/entity/EventEntity;", "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EventEntity implements Parcelable {
    public static final int EMPTY_EVENT = -1;
    public static final int PLAYABLE_ITEM_PLAYED_EVENT = 1;
    public static final int PLAYABLE_ITEM_VIEWED_EVENT = 2;
    private int event;
    private String extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f17id;
    private Parcelable parcelable;
    private Long platformId;
    private Long playableItemId;
    private Long playerId;
    private Date timestamp;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<EventEntity> CREATOR = new Creator();

    /* JADX INFO: compiled from: EventEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EventEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EventEntity(parcel.readLong(), parcel.readInt(), (Date) parcel.readSerializable(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readParcelable(EventEntity.class.getClassLoader()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventEntity[] newArray(int i) {
            return new EventEntity[i];
        }
    }

    public EventEntity() {
        this(0L, 0, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ EventEntity copy$default(EventEntity eventEntity, long j, int i, Date date, Long l, Long l2, Long l3, Parcelable parcelable, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = eventEntity.f17id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            i = eventEntity.event;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            date = eventEntity.timestamp;
        }
        Date date2 = date;
        if ((i2 & 8) != 0) {
            l = eventEntity.playableItemId;
        }
        return eventEntity.copy(j2, i3, date2, l, (i2 & 16) != 0 ? eventEntity.platformId : l2, (i2 & 32) != 0 ? eventEntity.playerId : l3, (i2 & 64) != 0 ? eventEntity.parcelable : parcelable, (i2 & 128) != 0 ? eventEntity.extra : str);
    }

    public final long component1() {
        return this.f17id;
    }

    public final int component2() {
        return this.event;
    }

    public final Date component3() {
        return this.timestamp;
    }

    public final Long component4() {
        return this.playableItemId;
    }

    public final Long component5() {
        return this.platformId;
    }

    public final Long component6() {
        return this.playerId;
    }

    public final Parcelable component7() {
        return this.parcelable;
    }

    public final String component8() {
        return this.extra;
    }

    public final EventEntity copy(long j, int i, Date timestamp, Long l, Long l2, Long l3, Parcelable parcelable, String extra) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new EventEntity(j, i, timestamp, l, l2, l3, parcelable, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventEntity)) {
            return false;
        }
        EventEntity eventEntity = (EventEntity) obj;
        return this.f17id == eventEntity.f17id && this.event == eventEntity.event && Intrinsics.areEqual(this.timestamp, eventEntity.timestamp) && Intrinsics.areEqual(this.playableItemId, eventEntity.playableItemId) && Intrinsics.areEqual(this.platformId, eventEntity.platformId) && Intrinsics.areEqual(this.playerId, eventEntity.playerId) && Intrinsics.areEqual(this.parcelable, eventEntity.parcelable) && Intrinsics.areEqual(this.extra, eventEntity.extra);
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.f17id) * 31) + Integer.hashCode(this.event)) * 31) + this.timestamp.hashCode()) * 31;
        Long l = this.playableItemId;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.platformId;
        int iHashCode3 = (iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.playerId;
        int iHashCode4 = (iHashCode3 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Parcelable parcelable = this.parcelable;
        return ((iHashCode4 + (parcelable != null ? parcelable.hashCode() : 0)) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "EventEntity(id=" + this.f17id + ", event=" + this.event + ", timestamp=" + this.timestamp + ", playableItemId=" + this.playableItemId + ", platformId=" + this.platformId + ", playerId=" + this.playerId + ", parcelable=" + this.parcelable + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f17id);
        out.writeInt(this.event);
        out.writeSerializable(this.timestamp);
        Long l = this.playableItemId;
        if (l == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l.longValue());
        }
        Long l2 = this.platformId;
        if (l2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l2.longValue());
        }
        Long l3 = this.playerId;
        if (l3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l3.longValue());
        }
        out.writeParcelable(this.parcelable, i);
        out.writeString(this.extra);
    }

    public EventEntity(long j, int i, Date timestamp, Long l, Long l2, Long l3, Parcelable parcelable, String extra) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.f17id = j;
        this.event = i;
        this.timestamp = timestamp;
        this.playableItemId = l;
        this.platformId = l2;
        this.playerId = l3;
        this.parcelable = parcelable;
        this.extra = extra;
    }

    public final long getId() {
        return this.f17id;
    }

    public final void setId(long j) {
        this.f17id = j;
    }

    public final int getEvent() {
        return this.event;
    }

    public final void setEvent(int i) {
        this.event = i;
    }

    public /* synthetic */ EventEntity(long j, int i, Date date, Long l, Long l2, Long l3, Parcelable parcelable, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? new Date() : date, (i2 & 8) != 0 ? null : l, (i2 & 16) != 0 ? null : l2, (i2 & 32) != 0 ? null : l3, (i2 & 64) != 0 ? null : parcelable, (i2 & 128) != 0 ? "" : str);
    }

    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.timestamp = date;
    }

    public final Long getPlayableItemId() {
        return this.playableItemId;
    }

    public final void setPlayableItemId(Long l) {
        this.playableItemId = l;
    }

    public final Long getPlatformId() {
        return this.platformId;
    }

    public final void setPlatformId(Long l) {
        this.platformId = l;
    }

    public final Long getPlayerId() {
        return this.playerId;
    }

    public final void setPlayerId(Long l) {
        this.playerId = l;
    }

    public final Parcelable getParcelable() {
        return this.parcelable;
    }

    public final void setParcelable(Parcelable parcelable) {
        this.parcelable = parcelable;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }

    /* JADX INFO: compiled from: EventEntity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/EventEntity$Companion;", "", "()V", "EMPTY_EVENT", "", "PLAYABLE_ITEM_PLAYED_EVENT", "PLAYABLE_ITEM_VIEWED_EVENT", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final EventEntity copyAndResetDatabaseAndDeviceDependentValues() {
        EventEntity eventEntityCopy$default = copy$default(this, 0L, 0, null, null, null, null, null, null, 255, null);
        eventEntityCopy$default.f17id = 0L;
        eventEntityCopy$default.playableItemId = null;
        eventEntityCopy$default.platformId = null;
        eventEntityCopy$default.playerId = null;
        return eventEntityCopy$default;
    }
}
