package com.magneticchen.daijishou.daijishou_widget.widget_db;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.FrameMetricsAggregator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: ChecklistWidgetChecklistItemEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00103\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003Jp\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u00106J\t\u00107\u001a\u000208HÖ\u0001J\u0013\u00109\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u000208HÖ\u0001J\t\u0010=\u001a\u00020\u0006HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u000208HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R \u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010$R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001a¨\u0006C"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ChecklistWidgetChecklistItemEntity;", "Landroid/os/Parcelable;", "id", "", "attachedWidgetInstanceId", "title", "", "checked", "", "playableItemId", "platformId", "playerId", "parcelable", "extra", "(JJLjava/lang/String;ZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Landroid/os/Parcelable;Ljava/lang/String;)V", "getAttachedWidgetInstanceId", "()J", "setAttachedWidgetInstanceId", "(J)V", "getChecked", "()Z", "setChecked", "(Z)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getId", "setId", "getParcelable", "()Landroid/os/Parcelable;", "setParcelable", "(Landroid/os/Parcelable;)V", "getPlatformId", "()Ljava/lang/Long;", "setPlatformId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPlayableItemId", "setPlayableItemId", "getPlayerId", "setPlayerId", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(JJLjava/lang/String;ZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Landroid/os/Parcelable;Ljava/lang/String;)Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ChecklistWidgetChecklistItemEntity;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ChecklistWidgetChecklistItemEntity implements Parcelable {
    public static final Parcelable.Creator<ChecklistWidgetChecklistItemEntity> CREATOR = new Creator();
    private long attachedWidgetInstanceId;
    private boolean checked;
    private String extra;
    private long id;
    private Parcelable parcelable;
    private Long platformId;
    private Long playableItemId;
    private Long playerId;
    private String title;

    /* JADX INFO: compiled from: ChecklistWidgetChecklistItemEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ChecklistWidgetChecklistItemEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChecklistWidgetChecklistItemEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChecklistWidgetChecklistItemEntity(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readParcelable(ChecklistWidgetChecklistItemEntity.class.getClassLoader()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChecklistWidgetChecklistItemEntity[] newArray(int i) {
            return new ChecklistWidgetChecklistItemEntity[i];
        }
    }

    public ChecklistWidgetChecklistItemEntity() {
        this(0L, 0L, null, false, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public static /* synthetic */ ChecklistWidgetChecklistItemEntity copy$default(ChecklistWidgetChecklistItemEntity checklistWidgetChecklistItemEntity, long j, long j2, String str, boolean z, Long l, Long l2, Long l3, Parcelable parcelable, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = checklistWidgetChecklistItemEntity.id;
        }
        return checklistWidgetChecklistItemEntity.copy(j, (i & 2) != 0 ? checklistWidgetChecklistItemEntity.attachedWidgetInstanceId : j2, (i & 4) != 0 ? checklistWidgetChecklistItemEntity.title : str, (i & 8) != 0 ? checklistWidgetChecklistItemEntity.checked : z, (i & 16) != 0 ? checklistWidgetChecklistItemEntity.playableItemId : l, (i & 32) != 0 ? checklistWidgetChecklistItemEntity.platformId : l2, (i & 64) != 0 ? checklistWidgetChecklistItemEntity.playerId : l3, (i & 128) != 0 ? checklistWidgetChecklistItemEntity.parcelable : parcelable, (i & 256) != 0 ? checklistWidgetChecklistItemEntity.extra : str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getAttachedWidgetInstanceId() {
        return this.attachedWidgetInstanceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getPlayableItemId() {
        return this.playableItemId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getPlatformId() {
        return this.platformId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getPlayerId() {
        return this.playerId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Parcelable getParcelable() {
        return this.parcelable;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    public final ChecklistWidgetChecklistItemEntity copy(long id2, long attachedWidgetInstanceId, String title, boolean checked, Long playableItemId, Long platformId, Long playerId, Parcelable parcelable, String extra) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new ChecklistWidgetChecklistItemEntity(id2, attachedWidgetInstanceId, title, checked, playableItemId, platformId, playerId, parcelable, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChecklistWidgetChecklistItemEntity)) {
            return false;
        }
        ChecklistWidgetChecklistItemEntity checklistWidgetChecklistItemEntity = (ChecklistWidgetChecklistItemEntity) other;
        return this.id == checklistWidgetChecklistItemEntity.id && this.attachedWidgetInstanceId == checklistWidgetChecklistItemEntity.attachedWidgetInstanceId && Intrinsics.areEqual(this.title, checklistWidgetChecklistItemEntity.title) && this.checked == checklistWidgetChecklistItemEntity.checked && Intrinsics.areEqual(this.playableItemId, checklistWidgetChecklistItemEntity.playableItemId) && Intrinsics.areEqual(this.platformId, checklistWidgetChecklistItemEntity.platformId) && Intrinsics.areEqual(this.playerId, checklistWidgetChecklistItemEntity.playerId) && Intrinsics.areEqual(this.parcelable, checklistWidgetChecklistItemEntity.parcelable) && Intrinsics.areEqual(this.extra, checklistWidgetChecklistItemEntity.extra);
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.attachedWidgetInstanceId)) * 31) + this.title.hashCode()) * 31) + Boolean.hashCode(this.checked)) * 31;
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
        return "ChecklistWidgetChecklistItemEntity(id=" + this.id + ", attachedWidgetInstanceId=" + this.attachedWidgetInstanceId + ", title=" + this.title + ", checked=" + this.checked + ", playableItemId=" + this.playableItemId + ", platformId=" + this.platformId + ", playerId=" + this.playerId + ", parcelable=" + this.parcelable + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeLong(this.attachedWidgetInstanceId);
        parcel.writeString(this.title);
        parcel.writeInt(this.checked ? 1 : 0);
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

    public ChecklistWidgetChecklistItemEntity(long j, long j2, String title, boolean z, Long l, Long l2, Long l3, Parcelable parcelable, String extra) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.id = j;
        this.attachedWidgetInstanceId = j2;
        this.title = title;
        this.checked = z;
        this.playableItemId = l;
        this.platformId = l2;
        this.playerId = l3;
        this.parcelable = parcelable;
        this.extra = extra;
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setAttachedWidgetInstanceId(long j) {
        this.attachedWidgetInstanceId = j;
    }

    public /* synthetic */ ChecklistWidgetChecklistItemEntity(long j, long j2, String str, boolean z, Long l, Long l2, Long l3, Parcelable parcelable, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? -1L : j2, (i & 4) != 0 ? "Checklist item" : str, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : l3, (i & 128) != 0 ? null : parcelable, (i & 256) != 0 ? "" : str2);
    }


    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }


    public final void setChecked(boolean z) {
        this.checked = z;
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
}
