package com.magneticchen.daijishou.daijishou_library_db;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: PlayableItemEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0002\u0010\u0014J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u00108\u001a\u00020\u0010HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010:\u001a\u00020\u0012HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\tHÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003J\t\u0010A\u001a\u00020\tHÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\u0090\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012HÆ\u0001¢\u0006\u0002\u0010DJ\t\u0010E\u001a\u00020\u0010HÖ\u0001J\u0013\u0010F\u001a\u00020\t2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\u0010HÖ\u0001J\t\u0010J\u001a\u00020\u0007HÖ\u0001J\u0019\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010(R\u001e\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010(R\u001e\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010(R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006P"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntityMergedInfo;", "Landroid/os/Parcelable;", "disjointSetPrimaryPlayableItemId", "", "mergedDisjointSetPrimaryPlayableItemIds", "", "mergedName", "", "mergedIsFavorite", "", "defaultMergedIsFavorite", "mergedIsSearchable", "defaultMergedIsSearchable", "mergedIsVisible", "defaultMergedIsVisible", "mergedPlayedCount", "", "mergedLastPlayedTimestamp", "Ljava/util/Date;", "mergedAddedDateTimestamp", "(Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;ZZZZZZILjava/util/Date;Ljava/util/Date;)V", "getDefaultMergedIsFavorite", "()Z", "getDefaultMergedIsSearchable", "getDefaultMergedIsVisible", "getDisjointSetPrimaryPlayableItemId", "()Ljava/lang/Long;", "setDisjointSetPrimaryPlayableItemId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMergedAddedDateTimestamp", "()Ljava/util/Date;", "setMergedAddedDateTimestamp", "(Ljava/util/Date;)V", "getMergedDisjointSetPrimaryPlayableItemIds", "()Ljava/util/List;", "setMergedDisjointSetPrimaryPlayableItemIds", "(Ljava/util/List;)V", "getMergedIsFavorite", "setMergedIsFavorite", "(Z)V", "getMergedIsSearchable", "setMergedIsSearchable", "getMergedIsVisible", "setMergedIsVisible", "getMergedLastPlayedTimestamp", "setMergedLastPlayedTimestamp", "getMergedName", "()Ljava/lang/String;", "setMergedName", "(Ljava/lang/String;)V", "getMergedPlayedCount", "()I", "setMergedPlayedCount", "(I)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;ZZZZZZILjava/util/Date;Ljava/util/Date;)Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntityMergedInfo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PlayableItemEntityMergedInfo implements Parcelable {
    public static final Parcelable.Creator<PlayableItemEntityMergedInfo> CREATOR = new Creator();
    private final boolean defaultMergedIsFavorite;
    private final boolean defaultMergedIsSearchable;
    private final boolean defaultMergedIsVisible;
    private Long disjointSetPrimaryPlayableItemId;
    private Date mergedAddedDateTimestamp;
    private List<Long> mergedDisjointSetPrimaryPlayableItemIds;
    private boolean mergedIsFavorite;
    private boolean mergedIsSearchable;
    private boolean mergedIsVisible;
    private Date mergedLastPlayedTimestamp;
    private String mergedName;
    private int mergedPlayedCount;

    /* JADX INFO: compiled from: PlayableItemEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PlayableItemEntityMergedInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayableItemEntityMergedInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            ArrayList arrayList2 = arrayList;
            String string = parcel.readString();
            boolean z = true;
            if (parcel.readInt() == 0) {
                z = false;
            }
            return new PlayableItemEntityMergedInfo(lValueOf, arrayList2, string, z, parcel.readInt() != 0, parcel.readInt() != 0 ? z : false, parcel.readInt() != 0 ? z : false, parcel.readInt() != 0 ? z : false, parcel.readInt() != 0 ? z : false, parcel.readInt(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayableItemEntityMergedInfo[] newArray(int i) {
            return new PlayableItemEntityMergedInfo[i];
        }
    }

    public PlayableItemEntityMergedInfo() {
        this(null, null, null, false, false, false, false, false, false, 0, null, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayableItemEntityMergedInfo copy$default(PlayableItemEntityMergedInfo playableItemEntityMergedInfo, Long l, List list, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Date date, Date date2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = playableItemEntityMergedInfo.disjointSetPrimaryPlayableItemId;
        }
        if ((i2 & 2) != 0) {
            list = playableItemEntityMergedInfo.mergedDisjointSetPrimaryPlayableItemIds;
        }
        if ((i2 & 4) != 0) {
            str = playableItemEntityMergedInfo.mergedName;
        }
        if ((i2 & 8) != 0) {
            z = playableItemEntityMergedInfo.mergedIsFavorite;
        }
        if ((i2 & 16) != 0) {
            z2 = playableItemEntityMergedInfo.defaultMergedIsFavorite;
        }
        if ((i2 & 32) != 0) {
            z3 = playableItemEntityMergedInfo.mergedIsSearchable;
        }
        if ((i2 & 64) != 0) {
            z4 = playableItemEntityMergedInfo.defaultMergedIsSearchable;
        }
        if ((i2 & 128) != 0) {
            z5 = playableItemEntityMergedInfo.mergedIsVisible;
        }
        if ((i2 & 256) != 0) {
            z6 = playableItemEntityMergedInfo.defaultMergedIsVisible;
        }
        if ((i2 & 512) != 0) {
            i = playableItemEntityMergedInfo.mergedPlayedCount;
        }
        if ((i2 & 1024) != 0) {
            date = playableItemEntityMergedInfo.mergedLastPlayedTimestamp;
        }
        if ((i2 & 2048) != 0) {
            date2 = playableItemEntityMergedInfo.mergedAddedDateTimestamp;
        }
        Date date3 = date;
        Date date4 = date2;
        boolean z7 = z6;
        int i3 = i;
        boolean z8 = z4;
        boolean z9 = z5;
        boolean z10 = z2;
        boolean z11 = z3;
        return playableItemEntityMergedInfo.copy(l, list, str, z, z10, z11, z8, z9, z7, i3, date3, date4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getDisjointSetPrimaryPlayableItemId() {
        return this.disjointSetPrimaryPlayableItemId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getMergedPlayedCount() {
        return this.mergedPlayedCount;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Date getMergedLastPlayedTimestamp() {
        return this.mergedLastPlayedTimestamp;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Date getMergedAddedDateTimestamp() {
        return this.mergedAddedDateTimestamp;
    }

    public final List<Long> component2() {
        return this.mergedDisjointSetPrimaryPlayableItemIds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMergedName() {
        return this.mergedName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getMergedIsFavorite() {
        return this.mergedIsFavorite;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getDefaultMergedIsFavorite() {
        return this.defaultMergedIsFavorite;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getMergedIsSearchable() {
        return this.mergedIsSearchable;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getDefaultMergedIsSearchable() {
        return this.defaultMergedIsSearchable;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getMergedIsVisible() {
        return this.mergedIsVisible;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getDefaultMergedIsVisible() {
        return this.defaultMergedIsVisible;
    }

    public final PlayableItemEntityMergedInfo copy(Long disjointSetPrimaryPlayableItemId, List<Long> mergedDisjointSetPrimaryPlayableItemIds, String mergedName, boolean mergedIsFavorite, boolean defaultMergedIsFavorite, boolean mergedIsSearchable, boolean defaultMergedIsSearchable, boolean mergedIsVisible, boolean defaultMergedIsVisible, int mergedPlayedCount, Date mergedLastPlayedTimestamp, Date mergedAddedDateTimestamp) {
        Intrinsics.checkNotNullParameter(mergedDisjointSetPrimaryPlayableItemIds, "mergedDisjointSetPrimaryPlayableItemIds");
        Intrinsics.checkNotNullParameter(mergedName, "mergedName");
        Intrinsics.checkNotNullParameter(mergedAddedDateTimestamp, "mergedAddedDateTimestamp");
        return new PlayableItemEntityMergedInfo(disjointSetPrimaryPlayableItemId, mergedDisjointSetPrimaryPlayableItemIds, mergedName, mergedIsFavorite, defaultMergedIsFavorite, mergedIsSearchable, defaultMergedIsSearchable, mergedIsVisible, defaultMergedIsVisible, mergedPlayedCount, mergedLastPlayedTimestamp, mergedAddedDateTimestamp);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayableItemEntityMergedInfo)) {
            return false;
        }
        PlayableItemEntityMergedInfo playableItemEntityMergedInfo = (PlayableItemEntityMergedInfo) other;
        return Intrinsics.areEqual(this.disjointSetPrimaryPlayableItemId, playableItemEntityMergedInfo.disjointSetPrimaryPlayableItemId) && Intrinsics.areEqual(this.mergedDisjointSetPrimaryPlayableItemIds, playableItemEntityMergedInfo.mergedDisjointSetPrimaryPlayableItemIds) && Intrinsics.areEqual(this.mergedName, playableItemEntityMergedInfo.mergedName) && this.mergedIsFavorite == playableItemEntityMergedInfo.mergedIsFavorite && this.defaultMergedIsFavorite == playableItemEntityMergedInfo.defaultMergedIsFavorite && this.mergedIsSearchable == playableItemEntityMergedInfo.mergedIsSearchable && this.defaultMergedIsSearchable == playableItemEntityMergedInfo.defaultMergedIsSearchable && this.mergedIsVisible == playableItemEntityMergedInfo.mergedIsVisible && this.defaultMergedIsVisible == playableItemEntityMergedInfo.defaultMergedIsVisible && this.mergedPlayedCount == playableItemEntityMergedInfo.mergedPlayedCount && Intrinsics.areEqual(this.mergedLastPlayedTimestamp, playableItemEntityMergedInfo.mergedLastPlayedTimestamp) && Intrinsics.areEqual(this.mergedAddedDateTimestamp, playableItemEntityMergedInfo.mergedAddedDateTimestamp);
    }

    public int hashCode() {
        Long l = this.disjointSetPrimaryPlayableItemId;
        int iHashCode = (((((((((((((((((((l == null ? 0 : l.hashCode()) * 31) + this.mergedDisjointSetPrimaryPlayableItemIds.hashCode()) * 31) + this.mergedName.hashCode()) * 31) + Boolean.hashCode(this.mergedIsFavorite)) * 31) + Boolean.hashCode(this.defaultMergedIsFavorite)) * 31) + Boolean.hashCode(this.mergedIsSearchable)) * 31) + Boolean.hashCode(this.defaultMergedIsSearchable)) * 31) + Boolean.hashCode(this.mergedIsVisible)) * 31) + Boolean.hashCode(this.defaultMergedIsVisible)) * 31) + Integer.hashCode(this.mergedPlayedCount)) * 31;
        Date date = this.mergedLastPlayedTimestamp;
        return ((iHashCode + (date != null ? date.hashCode() : 0)) * 31) + this.mergedAddedDateTimestamp.hashCode();
    }

    public String toString() {
        return "PlayableItemEntityMergedInfo(disjointSetPrimaryPlayableItemId=" + this.disjointSetPrimaryPlayableItemId + ", mergedDisjointSetPrimaryPlayableItemIds=" + this.mergedDisjointSetPrimaryPlayableItemIds + ", mergedName=" + this.mergedName + ", mergedIsFavorite=" + this.mergedIsFavorite + ", defaultMergedIsFavorite=" + this.defaultMergedIsFavorite + ", mergedIsSearchable=" + this.mergedIsSearchable + ", defaultMergedIsSearchable=" + this.defaultMergedIsSearchable + ", mergedIsVisible=" + this.mergedIsVisible + ", defaultMergedIsVisible=" + this.defaultMergedIsVisible + ", mergedPlayedCount=" + this.mergedPlayedCount + ", mergedLastPlayedTimestamp=" + this.mergedLastPlayedTimestamp + ", mergedAddedDateTimestamp=" + this.mergedAddedDateTimestamp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Long l = this.disjointSetPrimaryPlayableItemId;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        List<Long> list = this.mergedDisjointSetPrimaryPlayableItemIds;
        parcel.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeLong(it.next().longValue());
        }
        parcel.writeString(this.mergedName);
        parcel.writeInt(this.mergedIsFavorite ? 1 : 0);
        parcel.writeInt(this.defaultMergedIsFavorite ? 1 : 0);
        parcel.writeInt(this.mergedIsSearchable ? 1 : 0);
        parcel.writeInt(this.defaultMergedIsSearchable ? 1 : 0);
        parcel.writeInt(this.mergedIsVisible ? 1 : 0);
        parcel.writeInt(this.defaultMergedIsVisible ? 1 : 0);
        parcel.writeInt(this.mergedPlayedCount);
        parcel.writeSerializable(this.mergedLastPlayedTimestamp);
        parcel.writeSerializable(this.mergedAddedDateTimestamp);
    }

    public PlayableItemEntityMergedInfo(Long l, List<Long> mergedDisjointSetPrimaryPlayableItemIds, String mergedName, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Date date, Date mergedAddedDateTimestamp) {
        Intrinsics.checkNotNullParameter(mergedDisjointSetPrimaryPlayableItemIds, "mergedDisjointSetPrimaryPlayableItemIds");
        Intrinsics.checkNotNullParameter(mergedName, "mergedName");
        Intrinsics.checkNotNullParameter(mergedAddedDateTimestamp, "mergedAddedDateTimestamp");
        this.disjointSetPrimaryPlayableItemId = l;
        this.mergedDisjointSetPrimaryPlayableItemIds = mergedDisjointSetPrimaryPlayableItemIds;
        this.mergedName = mergedName;
        this.mergedIsFavorite = z;
        this.defaultMergedIsFavorite = z2;
        this.mergedIsSearchable = z3;
        this.defaultMergedIsSearchable = z4;
        this.mergedIsVisible = z5;
        this.defaultMergedIsVisible = z6;
        this.mergedPlayedCount = i;
        this.mergedLastPlayedTimestamp = date;
        this.mergedAddedDateTimestamp = mergedAddedDateTimestamp;
    }


    public final void setDisjointSetPrimaryPlayableItemId(Long l) {
        this.disjointSetPrimaryPlayableItemId = l;
    }

    public /* synthetic */ PlayableItemEntityMergedInfo(Long l, ArrayList arrayList, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Date date, Date date2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : l, (i2 & 2) != 0 ? new ArrayList() : arrayList, (i2 & 4) != 0 ? "Item name" : str, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? true : z2, (i2 & 32) != 0 ? true : z3, (i2 & 64) != 0 ? true : z4, (i2 & 128) != 0 ? true : z5, (i2 & 256) == 0 ? z6 : true, (i2 & 512) != 0 ? 0 : i, (i2 & 1024) == 0 ? date : null, (i2 & 2048) != 0 ? new Date() : date2);
    }

    public final List<Long> getMergedDisjointSetPrimaryPlayableItemIds() {
        return this.mergedDisjointSetPrimaryPlayableItemIds;
    }

    public final void setMergedDisjointSetPrimaryPlayableItemIds(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mergedDisjointSetPrimaryPlayableItemIds = list;
    }


    public final void setMergedName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mergedName = str;
    }


    public final void setMergedIsFavorite(boolean z) {
        this.mergedIsFavorite = z;
    }



    public final void setMergedIsSearchable(boolean z) {
        this.mergedIsSearchable = z;
    }



    public final void setMergedIsVisible(boolean z) {
        this.mergedIsVisible = z;
    }



    public final void setMergedPlayedCount(int i) {
        this.mergedPlayedCount = i;
    }


    public final void setMergedLastPlayedTimestamp(Date date) {
        this.mergedLastPlayedTimestamp = date;
    }


    public final void setMergedAddedDateTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.mergedAddedDateTimestamp = date;
    }
}
