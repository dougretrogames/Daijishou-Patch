package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "changed", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class Recomposer$recompositionRunner$2$unregisterApplyObserver$1 extends Lambda implements Function2<Set<? extends Object>, Snapshot, Unit> {
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$recompositionRunner$2$unregisterApplyObserver$1(Recomposer recomposer) {
        super(2);
        this.this$0 = recomposer;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
        invoke2(set, snapshot);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004a A[Catch: all -> 0x0097, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001d, B:8:0x0022, B:10:0x002f, B:12:0x003a, B:16:0x0051, B:15:0x004a, B:26:0x0080, B:17:0x0054, B:18:0x005a, B:20:0x0060, B:22:0x0068, B:25:0x0078), top: B:36:0x0009 }] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Set<? extends Object> set, Snapshot snapshot) {
        CancellableContinuation cancellableContinuationDeriveStateLocked;
        Object obj = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (obj) {
            if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                if (set instanceof IdentityArraySet) {
                    IdentityArraySet identityArraySet = (IdentityArraySet) set;
                    Object[] values = identityArraySet.getValues();
                    int size = identityArraySet.size();
                    for (int i = 0; i < size; i++) {
                        Object obj2 = values[i];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        if (obj2 instanceof StateObjectImpl) {
                            ReaderKind.Companion companion = ReaderKind.INSTANCE;
                            if (((StateObjectImpl) obj2).m163isReadInh_f27i8$runtime_release(ReaderKind.m152constructorimpl(1))) {
                                recomposer.snapshotInvalidations.add(obj2);
                            }
                        } else {
                            recomposer.snapshotInvalidations.add(obj2);
                        }
                    }
                } else {
                    for (Object obj3 : set) {
                        if (obj3 instanceof StateObjectImpl) {
                            ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                            if (!((StateObjectImpl) obj3).m163isReadInh_f27i8$runtime_release(ReaderKind.m152constructorimpl(1))) {
                            }
                        }
                        recomposer.snapshotInvalidations.add(obj3);
                    }
                }
                cancellableContinuationDeriveStateLocked = recomposer.deriveStateLocked();
            } else {
                cancellableContinuationDeriveStateLocked = null;
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m3752constructorimpl(Unit.INSTANCE));
        }
    }
}
