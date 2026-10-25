package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;

/* JADX INFO: compiled from: ParcelableSnapshotMutableState.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J%\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"androidx/compose/runtime/ParcelableSnapshotMutableState$Companion$CREATOR$1", "Landroid/os/Parcelable$ClassLoaderCreator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "newArray", "", "size", "", "(I)[Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParcelableSnapshotMutableState$Companion$CREATOR$1 implements Parcelable.ClassLoaderCreator<ParcelableSnapshotMutableState<Object>> {
    ParcelableSnapshotMutableState$Companion$CREATOR$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public ParcelableSnapshotMutableState<Object> createFromParcel(Parcel parcel, ClassLoader loader) {
        SnapshotMutationPolicy snapshotMutationPolicyNeverEqualPolicy;
        if (loader == null) {
            loader = getClass().getClassLoader();
        }
        Object value = parcel.readValue(loader);
        int i = parcel.readInt();
        if (i == 0) {
            snapshotMutationPolicyNeverEqualPolicy = SnapshotStateKt.neverEqualPolicy();
        } else if (i == 1) {
            snapshotMutationPolicyNeverEqualPolicy = SnapshotStateKt.structuralEqualityPolicy();
        } else if (i == 2) {
            snapshotMutationPolicyNeverEqualPolicy = SnapshotStateKt.referentialEqualityPolicy();
        } else {
            throw new IllegalStateException("Unsupported MutableState policy " + i + " was restored");
        }
        return new ParcelableSnapshotMutableState<>(value, snapshotMutationPolicyNeverEqualPolicy);
    }

    @Override // android.os.Parcelable.Creator
    public ParcelableSnapshotMutableState<Object> createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }

    @Override // android.os.Parcelable.Creator
    public ParcelableSnapshotMutableState<Object>[] newArray(int size) {
        return new ParcelableSnapshotMutableState[size];
    }
}
