package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.exifinterface.media.ExifInterface;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/* INFO: compiled from: SnapshotFlow.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "changed", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1 extends Lambda implements Function2<Set<? extends Object>, Snapshot, Unit> {
    final /* synthetic */ Channel<Set<Object>> $appliedChanges;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1(Channel<Set<Object>> channel) {
        super(2);
        this.$appliedChanges = channel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
        invoke2(set, snapshot);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Set<? extends Object> set, Snapshot snapshot) {
        this.$appliedChanges.mo5255trySendJP2dKIU(set);
    }
}
