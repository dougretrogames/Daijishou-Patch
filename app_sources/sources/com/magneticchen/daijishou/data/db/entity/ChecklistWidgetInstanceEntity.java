package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChecklistWidgetInstanceEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/ChecklistWidgetInstanceEntity;", "Landroid/os/Parcelable;", "id", "", "title", "", "(JLjava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChecklistWidgetInstanceEntity implements Parcelable {
    public static final Parcelable.Creator<ChecklistWidgetInstanceEntity> CREATOR = new Creator();

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f16id;
    private String title;

    /* JADX INFO: compiled from: ChecklistWidgetInstanceEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ChecklistWidgetInstanceEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChecklistWidgetInstanceEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChecklistWidgetInstanceEntity(parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChecklistWidgetInstanceEntity[] newArray(int i) {
            return new ChecklistWidgetInstanceEntity[i];
        }
    }

    public ChecklistWidgetInstanceEntity() {
        this(0L, null, 3, null);
    }

    public static /* synthetic */ ChecklistWidgetInstanceEntity copy$default(ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = checklistWidgetInstanceEntity.f16id;
        }
        if ((i & 2) != 0) {
            str = checklistWidgetInstanceEntity.title;
        }
        return checklistWidgetInstanceEntity.copy(j, str);
    }

    public final long component1() {
        return this.f16id;
    }

    public final String component2() {
        return this.title;
    }

    public final ChecklistWidgetInstanceEntity copy(long j, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new ChecklistWidgetInstanceEntity(j, title);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChecklistWidgetInstanceEntity)) {
            return false;
        }
        ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity = (ChecklistWidgetInstanceEntity) obj;
        return this.f16id == checklistWidgetInstanceEntity.f16id && Intrinsics.areEqual(this.title, checklistWidgetInstanceEntity.title);
    }

    public int hashCode() {
        return (Long.hashCode(this.f16id) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "ChecklistWidgetInstanceEntity(id=" + this.f16id + ", title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f16id);
        out.writeString(this.title);
    }

    public ChecklistWidgetInstanceEntity(long j, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.f16id = j;
        this.title = title;
    }

    public final long getId() {
        return this.f16id;
    }

    public final void setId(long j) {
        this.f16id = j;
    }

    public /* synthetic */ ChecklistWidgetInstanceEntity(long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "Checklist" : str);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
