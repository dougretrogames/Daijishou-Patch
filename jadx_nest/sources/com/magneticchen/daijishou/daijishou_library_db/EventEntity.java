package com.magneticchen.daijishou.daijishou_library_db;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: EventEntity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0001CB]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00102\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003Jf\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u00105J\u0006\u00106\u001a\u00020\u0000J\t\u00107\u001a\u00020\u0005HÖ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\t\u0010=\u001a\u00020\rHÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006D"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;", "Landroid/os/Parcelable;", "id", "", NotificationCompat.CATEGORY_EVENT, "", "timestamp", "Ljava/util/Date;", "playableItemId", "platformId", "playerId", "parcelable", "extra", "", "(JILjava/util/Date;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Landroid/os/Parcelable;Ljava/lang/String;)V", "getEvent", "()I", "setEvent", "(I)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getParcelable", "()Landroid/os/Parcelable;", "setParcelable", "(Landroid/os/Parcelable;)V", "getPlatformId", "()Ljava/lang/Long;", "setPlatformId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPlayableItemId", "setPlayableItemId", "getPlayerId", "setPlayerId", "getTimestamp", "()Ljava/util/Date;", "setTimestamp", "(Ljava/util/Date;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(JILjava/util/Date;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Landroid/os/Parcelable;Ljava/lang/String;)Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;", "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class EventEntity implements Parcelable {
    public static final int EMPTY_EVENT = -1;
    public static final int PLAYABLE_ITEM_PLAYED_EVENT = 1;
    public static final int PLAYABLE_ITEM_VIEWED_EVENT = 2;
    private int event;
    private String extra;
    private long id;
    private Parcelable parcelable;
    private Long platformId;
    private Long playableItemId;
    private Long playerId;
    private Date timestamp;
    public static final Parcelable.Creator<EventEntity> CREATOR = new Creator();

    /* INFO: compiled from: EventEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EventEntity> {
        /* WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EventEntity(parcel.readLong(), parcel.readInt(), (Date) parcel.readSerializable(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readParcelable(EventEntity.class.getClassLoader()), parcel.readString());
        }

        /* WARN: Can't rename method to resolve collision */
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
            j = eventEntity.id;
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

    /* INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final int getEvent() {
        return this.event;
    }

    /* INFO: renamed from: component3, reason: from getter */
    public final Date getTimestamp() {
        return this.timestamp;
    }

    /* INFO: renamed from: component4, reason: from getter */
    public final Long getPlayableItemId() {
        return this.playableItemId;
    }

    /* INFO: renamed from: component5, reason: from getter */
    public final Long getPlatformId() {
        return this.platformId;
    }

    /* INFO: renamed from: component6, reason: from getter */
    public final Long getPlayerId() {
        return this.playerId;
    }

    /* INFO: renamed from: component7, reason: from getter */
    public final Parcelable getParcelable() {
        return this.parcelable;
    }

    /* INFO: renamed from: component8, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    public final EventEntity copy(long id2, int event, Date timestamp, Long playableItemId, Long platformId, Long playerId, Parcelable parcelable, String extra) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new EventEntity(id2, event, timestamp, playableItemId, platformId, playerId, parcelable, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventEntity)) {
            return false;
        }
        EventEntity eventEntity = (EventEntity) other;
        return this.id == eventEntity.id && this.event == eventEntity.event && Intrinsics.areEqual(this.timestamp, eventEntity.timestamp) && Intrinsics.areEqual(this.playableItemId, eventEntity.playableItemId) && Intrinsics.areEqual(this.platformId, eventEntity.platformId) && Intrinsics.areEqual(this.playerId, eventEntity.playerId) && Intrinsics.areEqual(this.parcelable, eventEntity.parcelable) && Intrinsics.areEqual(this.extra, eventEntity.extra);
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.id) * 31) + Integer.hashCode(this.event)) * 31) + this.timestamp.hashCode()) * 31;
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
        return "EventEntity(id=" + this.id + ", event=" + this.event + ", timestamp=" + this.timestamp + ", playableItemId=" + this.playableItemId + ", platformId=" + this.platformId + ", playerId=" + this.playerId + ", parcelable=" + this.parcelable + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeInt(this.event);
        parcel.writeSerializable(this.timestamp);
        Long l = this.playableItemId;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        Long l2 = this.platformId;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        Long l3 = this.playerId;
        if (l3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        }
        parcel.writeParcelable(this.parcelable, flags);
        parcel.writeString(this.extra);
    }

    public EventEntity(long j, int i, Date timestamp, Long l, Long l2, Long l3, Parcelable parcelable, String extra) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.id = j;
        this.event = i;
        this.timestamp = timestamp;
        this.playableItemId = l;
        this.platformId = l2;
        this.playerId = l3;
        this.parcelable = parcelable;
        this.extra = extra;
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setEvent(int i) {
        this.event = i;
    }

    public /* synthetic */ EventEntity(long j, int i, Date date, Long l, Long l2, Long l3, Parcelable parcelable, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? new Date() : date, (i2 & 8) != 0 ? null : l, (i2 & 16) != 0 ? null : l2, (i2 & 32) != 0 ? null : l3, (i2 & 64) != 0 ? null : parcelable, (i2 & 128) != 0 ? "" : str);
    }


    public final void setTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.timestamp = date;
    }


    public final void setPlayableItemId(Long l) {
        this.playableItemId = l;
    }


    public final void setPlatformId(Long l) {
        this.platformId = l;
    }


    public final void setPlayerId(Long l) {
        this.playerId = l;
    }


    public final void setParcelable(Parcelable parcelable) {
        this.parcelable = parcelable;
    }


    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }

    public final EventEntity copyAndResetDatabaseAndDeviceDependentValues() {
        EventEntity eventEntityCopy$default = copy$default(this, 0L, 0, null, null, null, null, null, null, 255, null);
        eventEntityCopy$default.id = 0L;
        eventEntityCopy$default.playableItemId = null;
        eventEntityCopy$default.platformId = null;
        eventEntityCopy$default.playerId = null;
        return eventEntityCopy$default;
    }
}
