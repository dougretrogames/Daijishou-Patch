package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RememberSaveable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/MutableState;", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class RememberSaveableKt$mutableStateSaver$1$2<T> extends Lambda implements Function1<MutableState<Object>, MutableState<T>> {
    final /* synthetic */ Saver<T, Object> $this_with;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RememberSaveableKt$mutableStateSaver$1$2(Saver<T, Object> saver) {
        super(1);
        this.$this_with = saver;
    }

    @Override // kotlin.jvm.functions.Function1
    public final MutableState<T> invoke(MutableState<Object> mutableState) {
        T tRestore;
        if (!(mutableState instanceof SnapshotMutableState)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (mutableState.getValue() != null) {
            Saver<T, Object> saver = this.$this_with;
            Object value = mutableState.getValue();
            Intrinsics.checkNotNull(value);
            tRestore = saver.restore(value);
        } else {
            tRestore = null;
        }
        SnapshotMutationPolicy<T> policy = ((SnapshotMutableState) mutableState).getPolicy();
        Intrinsics.checkNotNull(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver$lambda$2?>");
        MutableState<T> mutableStateMutableStateOf = SnapshotStateKt.mutableStateOf(tRestore, policy);
        Intrinsics.checkNotNull(mutableStateMutableStateOf, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver$lambda$2>");
        return mutableStateMutableStateOf;
    }
}
