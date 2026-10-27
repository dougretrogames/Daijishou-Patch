package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayableItemEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0002\u0010\u0016J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\u0012HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010A\u001a\u00020\u0014HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\t\u0010E\u001a\u00020\tHÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\t\u0010I\u001a\u00020\tHÆ\u0003J¤\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014HÆ\u0001¢\u0006\u0002\u0010KJ\t\u0010L\u001a\u00020\u0012HÖ\u0001J\u0013\u0010M\u001a\u00020\t2\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\u0012HÖ\u0001J\t\u0010Q\u001a\u00020\u0007HÖ\u0001J\u0019\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010+R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010+R\u001e\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010+R\u001e\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010+R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006W"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;", "Landroid/os/Parcelable;", "disjointSetPrimaryPlayableItemId", "", "mergedDisjointSetPrimaryPlayableItemIds", "", "mergedName", "", "mergedIsFavorite", "", "mergedIsCompleted", "defaultMergedIsCompleted", "defaultMergedIsFavorite", "mergedIsSearchable", "defaultMergedIsSearchable", "mergedIsVisible", "defaultMergedIsVisible", "mergedPlayedCount", "", "mergedLastPlayedTimestamp", "Ljava/util/Date;", "mergedAddedDateTimestamp", "(Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;ZZZZZZZZILjava/util/Date;Ljava/util/Date;)V", "getDefaultMergedIsCompleted", "()Z", "getDefaultMergedIsFavorite", "getDefaultMergedIsSearchable", "getDefaultMergedIsVisible", "getDisjointSetPrimaryPlayableItemId", "()Ljava/lang/Long;", "setDisjointSetPrimaryPlayableItemId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMergedAddedDateTimestamp", "()Ljava/util/Date;", "setMergedAddedDateTimestamp", "(Ljava/util/Date;)V", "getMergedDisjointSetPrimaryPlayableItemIds", "()Ljava/util/List;", "setMergedDisjointSetPrimaryPlayableItemIds", "(Ljava/util/List;)V", "getMergedIsCompleted", "setMergedIsCompleted", "(Z)V", "getMergedIsFavorite", "setMergedIsFavorite", "getMergedIsSearchable", "setMergedIsSearchable", "getMergedIsVisible", "setMergedIsVisible", "getMergedLastPlayedTimestamp", "setMergedLastPlayedTimestamp", "getMergedName", "()Ljava/lang/String;", "setMergedName", "(Ljava/lang/String;)V", "getMergedPlayedCount", "()I", "setMergedPlayedCount", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;ZZZZZZZZILjava/util/Date;Ljava/util/Date;)Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlayableItemEntityMergedInfo implements Parcelable {
    public static final Parcelable.Creator<PlayableItemEntityMergedInfo> CREATOR = new Creator();
    private final boolean defaultMergedIsCompleted;
    private final boolean defaultMergedIsFavorite;
    private final boolean defaultMergedIsSearchable;
    private final boolean defaultMergedIsVisible;
    private Long disjointSetPrimaryPlayableItemId;
    private Date mergedAddedDateTimestamp;
    private List<Long> mergedDisjointSetPrimaryPlayableItemIds;
    private boolean mergedIsCompleted;
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
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z = false;
            }
            if (parcel.readInt() == 0) {
                z = false;
            }
            if (parcel.readInt() == 0) {
                z = false;
            }
            if (parcel.readInt() == 0) {
                z = false;
            }
            if (parcel.readInt() == 0) {
                z = false;
            }
            if (parcel.readInt() == 0) {
                z = false;
            }
            return new PlayableItemEntityMergedInfo(lValueOf, arrayList2, string, z2, z, z, z, z, z, z, parcel.readInt() != 0, parcel.readInt(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayableItemEntityMergedInfo[] newArray(int i) {
            return new PlayableItemEntityMergedInfo[i];
        }
    }

    public PlayableItemEntityMergedInfo() {
        this(null, null, null, false, false, false, false, false, false, false, false, 0, null, null, 16383, null);
    }

    public final Long component1() {
        return this.disjointSetPrimaryPlayableItemId;
    }

    public final boolean component10() {
        return this.mergedIsVisible;
    }

    public final boolean component11() {
        return this.defaultMergedIsVisible;
    }

    public final int component12() {
        return this.mergedPlayedCount;
    }

    public final Date component13() {
        return this.mergedLastPlayedTimestamp;
    }

    public final Date component14() {
        return this.mergedAddedDateTimestamp;
    }

    public final List<Long> component2() {
        return this.mergedDisjointSetPrimaryPlayableItemIds;
    }

    public final String component3() {
        return this.mergedName;
    }

    public final boolean component4() {
        return this.mergedIsFavorite;
    }

    public final boolean component5() {
        return this.mergedIsCompleted;
    }

    public final boolean component6() {
        return this.defaultMergedIsCompleted;
    }

    public final boolean component7() {
        return this.defaultMergedIsFavorite;
    }

    public final boolean component8() {
        return this.mergedIsSearchable;
    }

    public final boolean component9() {
        return this.defaultMergedIsSearchable;
    }

    public final PlayableItemEntityMergedInfo copy(Long l, List<Long> mergedDisjointSetPrimaryPlayableItemIds, String mergedName, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, Date date, Date mergedAddedDateTimestamp) {
        Intrinsics.checkNotNullParameter(mergedDisjointSetPrimaryPlayableItemIds, "mergedDisjointSetPrimaryPlayableItemIds");
        Intrinsics.checkNotNullParameter(mergedName, "mergedName");
        Intrinsics.checkNotNullParameter(mergedAddedDateTimestamp, "mergedAddedDateTimestamp");
        return new PlayableItemEntityMergedInfo(l, mergedDisjointSetPrimaryPlayableItemIds, mergedName, z, z2, z3, z4, z5, z6, z7, z8, i, date, mergedAddedDateTimestamp);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayableItemEntityMergedInfo)) {
            return false;
        }
        PlayableItemEntityMergedInfo playableItemEntityMergedInfo = (PlayableItemEntityMergedInfo) obj;
        return Intrinsics.areEqual(this.disjointSetPrimaryPlayableItemId, playableItemEntityMergedInfo.disjointSetPrimaryPlayableItemId) && Intrinsics.areEqual(this.mergedDisjointSetPrimaryPlayableItemIds, playableItemEntityMergedInfo.mergedDisjointSetPrimaryPlayableItemIds) && Intrinsics.areEqual(this.mergedName, playableItemEntityMergedInfo.mergedName) && this.mergedIsFavorite == playableItemEntityMergedInfo.mergedIsFavorite && this.mergedIsCompleted == playableItemEntityMergedInfo.mergedIsCompleted && this.defaultMergedIsCompleted == playableItemEntityMergedInfo.defaultMergedIsCompleted && this.defaultMergedIsFavorite == playableItemEntityMergedInfo.defaultMergedIsFavorite && this.mergedIsSearchable == playableItemEntityMergedInfo.mergedIsSearchable && this.defaultMergedIsSearchable == playableItemEntityMergedInfo.defaultMergedIsSearchable && this.mergedIsVisible == playableItemEntityMergedInfo.mergedIsVisible && this.defaultMergedIsVisible == playableItemEntityMergedInfo.defaultMergedIsVisible && this.mergedPlayedCount == playableItemEntityMergedInfo.mergedPlayedCount && Intrinsics.areEqual(this.mergedLastPlayedTimestamp, playableItemEntityMergedInfo.mergedLastPlayedTimestamp) && Intrinsics.areEqual(this.mergedAddedDateTimestamp, playableItemEntityMergedInfo.mergedAddedDateTimestamp);
    }

    public int hashCode() {
        Long l = this.disjointSetPrimaryPlayableItemId;
        int iHashCode = (((((((((((((((((((((((l == null ? 0 : l.hashCode()) * 31) + this.mergedDisjointSetPrimaryPlayableItemIds.hashCode()) * 31) + this.mergedName.hashCode()) * 31) + Boolean.hashCode(this.mergedIsFavorite)) * 31) + Boolean.hashCode(this.mergedIsCompleted)) * 31) + Boolean.hashCode(this.defaultMergedIsCompleted)) * 31) + Boolean.hashCode(this.defaultMergedIsFavorite)) * 31) + Boolean.hashCode(this.mergedIsSearchable)) * 31) + Boolean.hashCode(this.defaultMergedIsSearchable)) * 31) + Boolean.hashCode(this.mergedIsVisible)) * 31) + Boolean.hashCode(this.defaultMergedIsVisible)) * 31) + Integer.hashCode(this.mergedPlayedCount)) * 31;
        Date date = this.mergedLastPlayedTimestamp;
        return ((iHashCode + (date != null ? date.hashCode() : 0)) * 31) + this.mergedAddedDateTimestamp.hashCode();
    }

    public String toString() {
        return "PlayableItemEntityMergedInfo(disjointSetPrimaryPlayableItemId=" + this.disjointSetPrimaryPlayableItemId + ", mergedDisjointSetPrimaryPlayableItemIds=" + this.mergedDisjointSetPrimaryPlayableItemIds + ", mergedName=" + this.mergedName + ", mergedIsFavorite=" + this.mergedIsFavorite + ", mergedIsCompleted=" + this.mergedIsCompleted + ", defaultMergedIsCompleted=" + this.defaultMergedIsCompleted + ", defaultMergedIsFavorite=" + this.defaultMergedIsFavorite + ", mergedIsSearchable=" + this.mergedIsSearchable + ", defaultMergedIsSearchable=" + this.defaultMergedIsSearchable + ", mergedIsVisible=" + this.mergedIsVisible + ", defaultMergedIsVisible=" + this.defaultMergedIsVisible + ", mergedPlayedCount=" + this.mergedPlayedCount + ", mergedLastPlayedTimestamp=" + this.mergedLastPlayedTimestamp + ", mergedAddedDateTimestamp=" + this.mergedAddedDateTimestamp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        Long l = this.disjointSetPrimaryPlayableItemId;
        if (l == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l.longValue());
        }
        List<Long> list = this.mergedDisjointSetPrimaryPlayableItemIds;
        out.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            out.writeLong(it.next().longValue());
        }
        out.writeString(this.mergedName);
        out.writeInt(this.mergedIsFavorite ? 1 : 0);
        out.writeInt(this.mergedIsCompleted ? 1 : 0);
        out.writeInt(this.defaultMergedIsCompleted ? 1 : 0);
        out.writeInt(this.defaultMergedIsFavorite ? 1 : 0);
        out.writeInt(this.mergedIsSearchable ? 1 : 0);
        out.writeInt(this.defaultMergedIsSearchable ? 1 : 0);
        out.writeInt(this.mergedIsVisible ? 1 : 0);
        out.writeInt(this.defaultMergedIsVisible ? 1 : 0);
        out.writeInt(this.mergedPlayedCount);
        out.writeSerializable(this.mergedLastPlayedTimestamp);
        out.writeSerializable(this.mergedAddedDateTimestamp);
    }

    public PlayableItemEntityMergedInfo(Long l, List<Long> mergedDisjointSetPrimaryPlayableItemIds, String mergedName, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, Date date, Date mergedAddedDateTimestamp) {
        Intrinsics.checkNotNullParameter(mergedDisjointSetPrimaryPlayableItemIds, "mergedDisjointSetPrimaryPlayableItemIds");
        Intrinsics.checkNotNullParameter(mergedName, "mergedName");
        Intrinsics.checkNotNullParameter(mergedAddedDateTimestamp, "mergedAddedDateTimestamp");
        this.disjointSetPrimaryPlayableItemId = l;
        this.mergedDisjointSetPrimaryPlayableItemIds = mergedDisjointSetPrimaryPlayableItemIds;
        this.mergedName = mergedName;
        this.mergedIsFavorite = z;
        this.mergedIsCompleted = z2;
        this.defaultMergedIsCompleted = z3;
        this.defaultMergedIsFavorite = z4;
        this.mergedIsSearchable = z5;
        this.defaultMergedIsSearchable = z6;
        this.mergedIsVisible = z7;
        this.defaultMergedIsVisible = z8;
        this.mergedPlayedCount = i;
        this.mergedLastPlayedTimestamp = date;
        this.mergedAddedDateTimestamp = mergedAddedDateTimestamp;
    }

    public final Long getDisjointSetPrimaryPlayableItemId() {
        return this.disjointSetPrimaryPlayableItemId;
    }

    public final void setDisjointSetPrimaryPlayableItemId(Long l) {
        this.disjointSetPrimaryPlayableItemId = l;
    }

    public /* synthetic */ PlayableItemEntityMergedInfo(Long l, List list, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, Date date, Date date2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : l, (i2 & 2) != 0 ? new ArrayList() : list, (i2 & 4) != 0 ? "Item name" : str, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? true : z2, (i2 & 32) != 0 ? true : z3, (i2 & 64) != 0 ? true : z4, (i2 & 128) != 0 ? true : z5, (i2 & 256) != 0 ? true : z6, (i2 & 512) != 0 ? true : z7, (i2 & CategoryWidgetViewModel.LIMIT) == 0 ? z8 : true, (i2 & 2048) != 0 ? 0 : i, (i2 & 4096) == 0 ? date : null, (i2 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? new Date() : date2);
    }

    public final List<Long> getMergedDisjointSetPrimaryPlayableItemIds() {
        return this.mergedDisjointSetPrimaryPlayableItemIds;
    }

    public final void setMergedDisjointSetPrimaryPlayableItemIds(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mergedDisjointSetPrimaryPlayableItemIds = list;
    }

    public final String getMergedName() {
        return this.mergedName;
    }

    public final void setMergedName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mergedName = str;
    }

    public final boolean getMergedIsFavorite() {
        return this.mergedIsFavorite;
    }

    public final void setMergedIsFavorite(boolean z) {
        this.mergedIsFavorite = z;
    }

    public final boolean getMergedIsCompleted() {
        return this.mergedIsCompleted;
    }

    public final void setMergedIsCompleted(boolean z) {
        this.mergedIsCompleted = z;
    }

    public final boolean getDefaultMergedIsCompleted() {
        return this.defaultMergedIsCompleted;
    }

    public final boolean getDefaultMergedIsFavorite() {
        return this.defaultMergedIsFavorite;
    }

    public final boolean getMergedIsSearchable() {
        return this.mergedIsSearchable;
    }

    public final void setMergedIsSearchable(boolean z) {
        this.mergedIsSearchable = z;
    }

    public final boolean getDefaultMergedIsSearchable() {
        return this.defaultMergedIsSearchable;
    }

    public final boolean getMergedIsVisible() {
        return this.mergedIsVisible;
    }

    public final void setMergedIsVisible(boolean z) {
        this.mergedIsVisible = z;
    }

    public final boolean getDefaultMergedIsVisible() {
        return this.defaultMergedIsVisible;
    }

    public final int getMergedPlayedCount() {
        return this.mergedPlayedCount;
    }

    public final void setMergedPlayedCount(int i) {
        this.mergedPlayedCount = i;
    }

    public final Date getMergedLastPlayedTimestamp() {
        return this.mergedLastPlayedTimestamp;
    }

    public final void setMergedLastPlayedTimestamp(Date date) {
        this.mergedLastPlayedTimestamp = date;
    }

    public final Date getMergedAddedDateTimestamp() {
        return this.mergedAddedDateTimestamp;
    }

    public final void setMergedAddedDateTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.mergedAddedDateTimestamp = date;
    }
}
