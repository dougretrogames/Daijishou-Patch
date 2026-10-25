package com.magneticchen.daijishou.daijishou_widget.widget_db;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: ImageBlockWidgetInstanceEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0000J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ImageBlockWidgetInstanceEntity;", "Landroid/os/Parcelable;", "id", "", "imagePath", "", "lastUpdateTimestamp", "Ljava/util/Date;", "(JLjava/lang/String;Ljava/util/Date;)V", "getId", "()J", "setId", "(J)V", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "getLastUpdateTimestamp", "()Ljava/util/Date;", "setLastUpdateTimestamp", "(Ljava/util/Date;)V", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ImageBlockWidgetInstanceEntity implements Parcelable {
    public static final Parcelable.Creator<ImageBlockWidgetInstanceEntity> CREATOR = new Creator();
    private long id;
    private String imagePath;
    private Date lastUpdateTimestamp;

    /* JADX INFO: compiled from: ImageBlockWidgetInstanceEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ImageBlockWidgetInstanceEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ImageBlockWidgetInstanceEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageBlockWidgetInstanceEntity(parcel.readLong(), parcel.readString(), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ImageBlockWidgetInstanceEntity[] newArray(int i) {
            return new ImageBlockWidgetInstanceEntity[i];
        }
    }

    public ImageBlockWidgetInstanceEntity() {
        this(0L, null, null, 7, null);
    }

    public static /* synthetic */ ImageBlockWidgetInstanceEntity copy$default(ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity, long j, String str, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            j = imageBlockWidgetInstanceEntity.id;
        }
        if ((i & 2) != 0) {
            str = imageBlockWidgetInstanceEntity.imagePath;
        }
        if ((i & 4) != 0) {
            date = imageBlockWidgetInstanceEntity.lastUpdateTimestamp;
        }
        return imageBlockWidgetInstanceEntity.copy(j, str, date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImagePath() {
        return this.imagePath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }

    public final ImageBlockWidgetInstanceEntity copy(long id2, String imagePath, Date lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(lastUpdateTimestamp, "lastUpdateTimestamp");
        return new ImageBlockWidgetInstanceEntity(id2, imagePath, lastUpdateTimestamp);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageBlockWidgetInstanceEntity)) {
            return false;
        }
        ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity = (ImageBlockWidgetInstanceEntity) other;
        return this.id == imageBlockWidgetInstanceEntity.id && Intrinsics.areEqual(this.imagePath, imageBlockWidgetInstanceEntity.imagePath) && Intrinsics.areEqual(this.lastUpdateTimestamp, imageBlockWidgetInstanceEntity.lastUpdateTimestamp);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.imagePath;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.lastUpdateTimestamp.hashCode();
    }

    public String toString() {
        return "ImageBlockWidgetInstanceEntity(id=" + this.id + ", imagePath=" + this.imagePath + ", lastUpdateTimestamp=" + this.lastUpdateTimestamp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeString(this.imagePath);
        parcel.writeSerializable(this.lastUpdateTimestamp);
    }

    public ImageBlockWidgetInstanceEntity(long j, String str, Date lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(lastUpdateTimestamp, "lastUpdateTimestamp");
        this.id = j;
        this.imagePath = str;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setImagePath(String str) {
        this.imagePath = str;
    }

    public /* synthetic */ ImageBlockWidgetInstanceEntity(long j, String str, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new Date() : date);
    }


    public final void setLastUpdateTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.lastUpdateTimestamp = date;
    }

    public final ImageBlockWidgetInstanceEntity copyAndResetDatabaseAndDeviceDependentValues() {
        ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntityCopy$default = copy$default(this, 0L, null, null, 7, null);
        imageBlockWidgetInstanceEntityCopy$default.id = 0L;
        if (this.imagePath != null) {
            String str = this.imagePath;
            Intrinsics.checkNotNull(str);
            if (new File(str).exists()) {
                return imageBlockWidgetInstanceEntityCopy$default;
            }
        }
        imageBlockWidgetInstanceEntityCopy$default.imagePath = null;
        return imageBlockWidgetInstanceEntityCopy$default;
    }
}
