package com.magneticchen.daijishou.data.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayableItemToGenrePairEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0000J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006("}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;", "Landroid/os/Parcelable;", "id", "", "playableItemId", "genreId", "", "extra", "(JJLjava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getGenreId", "setGenreId", "getId", "()J", "setId", "(J)V", "getPlayableItemId", "setPlayableItemId", "component1", "component2", "component3", "component4", "copy", "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlayableItemToGenrePairEntity implements Parcelable {
    public static final Parcelable.Creator<PlayableItemToGenrePairEntity> CREATOR = new Creator();
    private String extra;
    private String genreId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f32id;
    private long playableItemId;

    /* JADX INFO: compiled from: PlayableItemToGenrePairEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PlayableItemToGenrePairEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayableItemToGenrePairEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PlayableItemToGenrePairEntity(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayableItemToGenrePairEntity[] newArray(int i) {
            return new PlayableItemToGenrePairEntity[i];
        }
    }

    public static /* synthetic */ PlayableItemToGenrePairEntity copy$default(PlayableItemToGenrePairEntity playableItemToGenrePairEntity, long j, long j2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = playableItemToGenrePairEntity.f32id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = playableItemToGenrePairEntity.playableItemId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            str = playableItemToGenrePairEntity.genreId;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            str2 = playableItemToGenrePairEntity.extra;
        }
        return playableItemToGenrePairEntity.copy(j3, j4, str3, str2);
    }

    public final long component1() {
        return this.f32id;
    }

    public final long component2() {
        return this.playableItemId;
    }

    public final String component3() {
        return this.genreId;
    }

    public final String component4() {
        return this.extra;
    }

    public final PlayableItemToGenrePairEntity copy(long j, long j2, String genreId, String extra) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new PlayableItemToGenrePairEntity(j, j2, genreId, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayableItemToGenrePairEntity)) {
            return false;
        }
        PlayableItemToGenrePairEntity playableItemToGenrePairEntity = (PlayableItemToGenrePairEntity) obj;
        return this.f32id == playableItemToGenrePairEntity.f32id && this.playableItemId == playableItemToGenrePairEntity.playableItemId && Intrinsics.areEqual(this.genreId, playableItemToGenrePairEntity.genreId) && Intrinsics.areEqual(this.extra, playableItemToGenrePairEntity.extra);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f32id) * 31) + Long.hashCode(this.playableItemId)) * 31) + this.genreId.hashCode()) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "PlayableItemToGenrePairEntity(id=" + this.f32id + ", playableItemId=" + this.playableItemId + ", genreId=" + this.genreId + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f32id);
        out.writeLong(this.playableItemId);
        out.writeString(this.genreId);
        out.writeString(this.extra);
    }

    public PlayableItemToGenrePairEntity(long j, long j2, String genreId, String extra) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.f32id = j;
        this.playableItemId = j2;
        this.genreId = genreId;
        this.extra = extra;
    }

    public final long getId() {
        return this.f32id;
    }

    public final void setId(long j) {
        this.f32id = j;
    }

    public final long getPlayableItemId() {
        return this.playableItemId;
    }

    public final void setPlayableItemId(long j) {
        this.playableItemId = j;
    }

    public final String getGenreId() {
        return this.genreId;
    }

    public final void setGenreId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.genreId = str;
    }

    public /* synthetic */ PlayableItemToGenrePairEntity(long j, long j2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, str, (i & 8) != 0 ? "" : str2);
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }

    public final PlayableItemToGenrePairEntity copyAndResetDatabaseAndDeviceDependentValues() {
        PlayableItemToGenrePairEntity playableItemToGenrePairEntityCopy$default = copy$default(this, 0L, 0L, null, null, 15, null);
        playableItemToGenrePairEntityCopy$default.f32id = 0L;
        return playableItemToGenrePairEntityCopy$default;
    }
}
