package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaylistWidgetInstanceEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003Js\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020(HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020(HÖ\u0001R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u00064"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/PlaylistWidgetInstanceEntity;", "Landroid/os/Parcelable;", "id", "", "whitelistedKeywordList", "", "", "blacklistedKeywordList", "selectedPlatformIdList", "blacklistedPlatformIdList", "whitelistedPlayableItemIdList", "blacklistedPlayableItemIdList", "(JLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBlacklistedKeywordList", "()Ljava/util/List;", "setBlacklistedKeywordList", "(Ljava/util/List;)V", "getBlacklistedPlatformIdList", "setBlacklistedPlatformIdList", "getBlacklistedPlayableItemIdList", "setBlacklistedPlayableItemIdList", "getId", "()J", "setId", "(J)V", "getSelectedPlatformIdList", "setSelectedPlatformIdList", "getWhitelistedKeywordList", "setWhitelistedKeywordList", "getWhitelistedPlayableItemIdList", "setWhitelistedPlayableItemIdList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlaylistWidgetInstanceEntity implements Parcelable {
    public static final Parcelable.Creator<PlaylistWidgetInstanceEntity> CREATOR = new Creator();
    private List<String> blacklistedKeywordList;
    private List<Long> blacklistedPlatformIdList;
    private List<Long> blacklistedPlayableItemIdList;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f34id;
    private List<Long> selectedPlatformIdList;
    private List<String> whitelistedKeywordList;
    private List<Long> whitelistedPlayableItemIdList;

    /* JADX INFO: compiled from: PlaylistWidgetInstanceEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PlaylistWidgetInstanceEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlaylistWidgetInstanceEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            ArrayList arrayList2 = arrayList;
            int i3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList3.add(Long.valueOf(parcel.readLong()));
            }
            ArrayList arrayList4 = arrayList3;
            int i5 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(i5);
            for (int i6 = 0; i6 != i5; i6++) {
                arrayList5.add(Long.valueOf(parcel.readLong()));
            }
            ArrayList arrayList6 = arrayList5;
            int i7 = parcel.readInt();
            ArrayList arrayList7 = new ArrayList(i7);
            for (int i8 = 0; i8 != i7; i8++) {
                arrayList7.add(Long.valueOf(parcel.readLong()));
            }
            return new PlaylistWidgetInstanceEntity(j, arrayListCreateStringArrayList, arrayListCreateStringArrayList2, arrayList2, arrayList4, arrayList6, arrayList7);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlaylistWidgetInstanceEntity[] newArray(int i) {
            return new PlaylistWidgetInstanceEntity[i];
        }
    }

    public PlaylistWidgetInstanceEntity() {
        this(0L, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaylistWidgetInstanceEntity copy$default(PlaylistWidgetInstanceEntity playlistWidgetInstanceEntity, long j, List list, List list2, List list3, List list4, List list5, List list6, int i, Object obj) {
        if ((i & 1) != 0) {
            j = playlistWidgetInstanceEntity.f34id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            list = playlistWidgetInstanceEntity.whitelistedKeywordList;
        }
        List list7 = list;
        if ((i & 4) != 0) {
            list2 = playlistWidgetInstanceEntity.blacklistedKeywordList;
        }
        List list8 = list2;
        if ((i & 8) != 0) {
            list3 = playlistWidgetInstanceEntity.selectedPlatformIdList;
        }
        List list9 = list3;
        if ((i & 16) != 0) {
            list4 = playlistWidgetInstanceEntity.blacklistedPlatformIdList;
        }
        return playlistWidgetInstanceEntity.copy(j2, list7, list8, list9, list4, (i & 32) != 0 ? playlistWidgetInstanceEntity.whitelistedPlayableItemIdList : list5, (i & 64) != 0 ? playlistWidgetInstanceEntity.blacklistedPlayableItemIdList : list6);
    }

    public final long component1() {
        return this.f34id;
    }

    public final List<String> component2() {
        return this.whitelistedKeywordList;
    }

    public final List<String> component3() {
        return this.blacklistedKeywordList;
    }

    public final List<Long> component4() {
        return this.selectedPlatformIdList;
    }

    public final List<Long> component5() {
        return this.blacklistedPlatformIdList;
    }

    public final List<Long> component6() {
        return this.whitelistedPlayableItemIdList;
    }

    public final List<Long> component7() {
        return this.blacklistedPlayableItemIdList;
    }

    public final PlaylistWidgetInstanceEntity copy(long j, List<String> whitelistedKeywordList, List<String> blacklistedKeywordList, List<Long> selectedPlatformIdList, List<Long> blacklistedPlatformIdList, List<Long> whitelistedPlayableItemIdList, List<Long> blacklistedPlayableItemIdList) {
        Intrinsics.checkNotNullParameter(whitelistedKeywordList, "whitelistedKeywordList");
        Intrinsics.checkNotNullParameter(blacklistedKeywordList, "blacklistedKeywordList");
        Intrinsics.checkNotNullParameter(selectedPlatformIdList, "selectedPlatformIdList");
        Intrinsics.checkNotNullParameter(blacklistedPlatformIdList, "blacklistedPlatformIdList");
        Intrinsics.checkNotNullParameter(whitelistedPlayableItemIdList, "whitelistedPlayableItemIdList");
        Intrinsics.checkNotNullParameter(blacklistedPlayableItemIdList, "blacklistedPlayableItemIdList");
        return new PlaylistWidgetInstanceEntity(j, whitelistedKeywordList, blacklistedKeywordList, selectedPlatformIdList, blacklistedPlatformIdList, whitelistedPlayableItemIdList, blacklistedPlayableItemIdList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaylistWidgetInstanceEntity)) {
            return false;
        }
        PlaylistWidgetInstanceEntity playlistWidgetInstanceEntity = (PlaylistWidgetInstanceEntity) obj;
        return this.f34id == playlistWidgetInstanceEntity.f34id && Intrinsics.areEqual(this.whitelistedKeywordList, playlistWidgetInstanceEntity.whitelistedKeywordList) && Intrinsics.areEqual(this.blacklistedKeywordList, playlistWidgetInstanceEntity.blacklistedKeywordList) && Intrinsics.areEqual(this.selectedPlatformIdList, playlistWidgetInstanceEntity.selectedPlatformIdList) && Intrinsics.areEqual(this.blacklistedPlatformIdList, playlistWidgetInstanceEntity.blacklistedPlatformIdList) && Intrinsics.areEqual(this.whitelistedPlayableItemIdList, playlistWidgetInstanceEntity.whitelistedPlayableItemIdList) && Intrinsics.areEqual(this.blacklistedPlayableItemIdList, playlistWidgetInstanceEntity.blacklistedPlayableItemIdList);
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.f34id) * 31) + this.whitelistedKeywordList.hashCode()) * 31) + this.blacklistedKeywordList.hashCode()) * 31) + this.selectedPlatformIdList.hashCode()) * 31) + this.blacklistedPlatformIdList.hashCode()) * 31) + this.whitelistedPlayableItemIdList.hashCode()) * 31) + this.blacklistedPlayableItemIdList.hashCode();
    }

    public String toString() {
        return "PlaylistWidgetInstanceEntity(id=" + this.f34id + ", whitelistedKeywordList=" + this.whitelistedKeywordList + ", blacklistedKeywordList=" + this.blacklistedKeywordList + ", selectedPlatformIdList=" + this.selectedPlatformIdList + ", blacklistedPlatformIdList=" + this.blacklistedPlatformIdList + ", whitelistedPlayableItemIdList=" + this.whitelistedPlayableItemIdList + ", blacklistedPlayableItemIdList=" + this.blacklistedPlayableItemIdList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f34id);
        out.writeStringList(this.whitelistedKeywordList);
        out.writeStringList(this.blacklistedKeywordList);
        List<Long> list = this.selectedPlatformIdList;
        out.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            out.writeLong(it.next().longValue());
        }
        List<Long> list2 = this.blacklistedPlatformIdList;
        out.writeInt(list2.size());
        Iterator<Long> it2 = list2.iterator();
        while (it2.hasNext()) {
            out.writeLong(it2.next().longValue());
        }
        List<Long> list3 = this.whitelistedPlayableItemIdList;
        out.writeInt(list3.size());
        Iterator<Long> it3 = list3.iterator();
        while (it3.hasNext()) {
            out.writeLong(it3.next().longValue());
        }
        List<Long> list4 = this.blacklistedPlayableItemIdList;
        out.writeInt(list4.size());
        Iterator<Long> it4 = list4.iterator();
        while (it4.hasNext()) {
            out.writeLong(it4.next().longValue());
        }
    }

    public PlaylistWidgetInstanceEntity(long j, List<String> whitelistedKeywordList, List<String> blacklistedKeywordList, List<Long> selectedPlatformIdList, List<Long> blacklistedPlatformIdList, List<Long> whitelistedPlayableItemIdList, List<Long> blacklistedPlayableItemIdList) {
        Intrinsics.checkNotNullParameter(whitelistedKeywordList, "whitelistedKeywordList");
        Intrinsics.checkNotNullParameter(blacklistedKeywordList, "blacklistedKeywordList");
        Intrinsics.checkNotNullParameter(selectedPlatformIdList, "selectedPlatformIdList");
        Intrinsics.checkNotNullParameter(blacklistedPlatformIdList, "blacklistedPlatformIdList");
        Intrinsics.checkNotNullParameter(whitelistedPlayableItemIdList, "whitelistedPlayableItemIdList");
        Intrinsics.checkNotNullParameter(blacklistedPlayableItemIdList, "blacklistedPlayableItemIdList");
        this.f34id = j;
        this.whitelistedKeywordList = whitelistedKeywordList;
        this.blacklistedKeywordList = blacklistedKeywordList;
        this.selectedPlatformIdList = selectedPlatformIdList;
        this.blacklistedPlatformIdList = blacklistedPlatformIdList;
        this.whitelistedPlayableItemIdList = whitelistedPlayableItemIdList;
        this.blacklistedPlayableItemIdList = blacklistedPlayableItemIdList;
    }

    public final long getId() {
        return this.f34id;
    }

    public final void setId(long j) {
        this.f34id = j;
    }

    public /* synthetic */ PlaylistWidgetInstanceEntity(long j, List list, List list2, List list3, List list4, List list5, List list6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? new ArrayList() : list2, (i & 8) != 0 ? new ArrayList() : list3, (i & 16) != 0 ? new ArrayList() : list4, (i & 32) != 0 ? new ArrayList() : list5, (i & 64) != 0 ? new ArrayList() : list6);
    }

    public final List<String> getWhitelistedKeywordList() {
        return this.whitelistedKeywordList;
    }

    public final void setWhitelistedKeywordList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.whitelistedKeywordList = list;
    }

    public final List<String> getBlacklistedKeywordList() {
        return this.blacklistedKeywordList;
    }

    public final void setBlacklistedKeywordList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.blacklistedKeywordList = list;
    }

    public final List<Long> getSelectedPlatformIdList() {
        return this.selectedPlatformIdList;
    }

    public final void setSelectedPlatformIdList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selectedPlatformIdList = list;
    }

    public final List<Long> getBlacklistedPlatformIdList() {
        return this.blacklistedPlatformIdList;
    }

    public final void setBlacklistedPlatformIdList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.blacklistedPlatformIdList = list;
    }

    public final List<Long> getWhitelistedPlayableItemIdList() {
        return this.whitelistedPlayableItemIdList;
    }

    public final void setWhitelistedPlayableItemIdList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.whitelistedPlayableItemIdList = list;
    }

    public final List<Long> getBlacklistedPlayableItemIdList() {
        return this.blacklistedPlayableItemIdList;
    }

    public final void setBlacklistedPlayableItemIdList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.blacklistedPlayableItemIdList = list;
    }
}
