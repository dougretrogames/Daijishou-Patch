package com.magneticchen.daijishou.daijishou_library_db;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: PlayableItemToGenrePairEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0000J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006("}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemToGenrePairEntity;", "Landroid/os/Parcelable;", "id", "", "playableItemId", "genreId", "", "extra", "(JJLjava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getGenreId", "setGenreId", "getId", "()J", "setId", "(J)V", "getPlayableItemId", "setPlayableItemId", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PlayableItemToGenrePairEntity implements Parcelable {
    public static final Parcelable.Creator<PlayableItemToGenrePairEntity> CREATOR = new Creator();
    private String extra;
    private String genreId;
    private long id;
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
            j = playableItemToGenrePairEntity.id;
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPlayableItemId() {
        return this.playableItemId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGenreId() {
        return this.genreId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    public final PlayableItemToGenrePairEntity copy(long id2, long playableItemId, String genreId, String extra) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new PlayableItemToGenrePairEntity(id2, playableItemId, genreId, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayableItemToGenrePairEntity)) {
            return false;
        }
        PlayableItemToGenrePairEntity playableItemToGenrePairEntity = (PlayableItemToGenrePairEntity) other;
        return this.id == playableItemToGenrePairEntity.id && this.playableItemId == playableItemToGenrePairEntity.playableItemId && Intrinsics.areEqual(this.genreId, playableItemToGenrePairEntity.genreId) && Intrinsics.areEqual(this.extra, playableItemToGenrePairEntity.extra);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.id) * 31) + Long.hashCode(this.playableItemId)) * 31) + this.genreId.hashCode()) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "PlayableItemToGenrePairEntity(id=" + this.id + ", playableItemId=" + this.playableItemId + ", genreId=" + this.genreId + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeLong(this.playableItemId);
        parcel.writeString(this.genreId);
        parcel.writeString(this.extra);
    }

    public PlayableItemToGenrePairEntity(long j, long j2, String genreId, String extra) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.id = j;
        this.playableItemId = j2;
        this.genreId = genreId;
        this.extra = extra;
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setPlayableItemId(long j) {
        this.playableItemId = j;
    }


    public final void setGenreId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.genreId = str;
    }

    public /* synthetic */ PlayableItemToGenrePairEntity(long j, long j2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, str, (i & 8) != 0 ? "" : str2);
    }


    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }

    public final PlayableItemToGenrePairEntity copyAndResetDatabaseAndDeviceDependentValues() {
        PlayableItemToGenrePairEntity playableItemToGenrePairEntityCopy$default = copy$default(this, 0L, 0L, null, null, 15, null);
        playableItemToGenrePairEntityCopy$default.id = 0L;
        return playableItemToGenrePairEntityCopy$default;
    }
}
