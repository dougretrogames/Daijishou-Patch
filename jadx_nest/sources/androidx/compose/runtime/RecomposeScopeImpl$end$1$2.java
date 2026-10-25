package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RecomposeScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "composition", "Landroidx/compose/runtime/Composition;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class RecomposeScopeImpl$end$1$2 extends Lambda implements Function1<Composition, Unit> {
    final /* synthetic */ MutableObjectIntMap<Object> $instances;
    final /* synthetic */ int $token;
    final /* synthetic */ RecomposeScopeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecomposeScopeImpl$end$1$2(RecomposeScopeImpl recomposeScopeImpl, int i, MutableObjectIntMap<Object> mutableObjectIntMap) {
        super(1);
        this.this$0 = recomposeScopeImpl;
        this.$token = i;
        this.$instances = mutableObjectIntMap;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Composition composition) {
        invoke2(composition);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a7 A[LOOP:0: B:11:0x0031->B:39:0x00a7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ac A[EDGE_INSN: B:45:0x00ac->B:40:0x00ac BREAK  A[LOOP:0: B:11:0x0031->B:39:0x00a7], SYNTHETIC] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Composition composition) {
        int i;
        Composition composition2 = composition;
        if (this.this$0.currentToken == this.$token && Intrinsics.areEqual(this.$instances, this.this$0.trackedInstances) && (composition2 instanceof CompositionImpl)) {
            MutableObjectIntMap<Object> mutableObjectIntMap = this.$instances;
            int i2 = this.$token;
            RecomposeScopeImpl recomposeScopeImpl = this.this$0;
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i3 = 0;
                while (true) {
                    long j = jArr[i3];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i3 != length) {
                            break;
                            break;
                        } else {
                            i3++;
                            composition2 = composition;
                        }
                    } else {
                        int i4 = 8;
                        int i5 = 8 - ((~(i3 - length)) >>> 31);
                        int i6 = 0;
                        while (i6 < i5) {
                            if ((255 & j) < 128) {
                                int i7 = (i3 << 3) + i6;
                                Object obj = mutableObjectIntMap.keys[i7];
                                i = i4;
                                boolean z = mutableObjectIntMap.values[i7] != i2;
                                if (z) {
                                    CompositionImpl compositionImpl = (CompositionImpl) composition2;
                                    compositionImpl.removeObservation$runtime_release(obj, recomposeScopeImpl);
                                    DerivedState<?> derivedState = obj instanceof DerivedState ? (DerivedState) obj : null;
                                    if (derivedState != null) {
                                        compositionImpl.removeDerivedStateObservation$runtime_release(derivedState);
                                        MutableScatterMap mutableScatterMap = recomposeScopeImpl.trackedDependencies;
                                        if (mutableScatterMap != null) {
                                            mutableScatterMap.remove(derivedState);
                                            if (mutableScatterMap.get_size() == 0) {
                                                recomposeScopeImpl.trackedDependencies = null;
                                            }
                                        }
                                    }
                                }
                                if (z) {
                                    mutableObjectIntMap.removeValueAt(i7);
                                }
                            } else {
                                i = i4;
                            }
                            j >>= i;
                            i6++;
                            composition2 = composition;
                            i4 = i;
                        }
                        if (i5 != i4) {
                            break;
                        }
                        if (i3 != length) {
                            break;
                        }
                        i3++;
                        composition2 = composition;
                    }
                }
            }
            if (this.$instances.get_size() == 0) {
                this.this$0.trackedInstances = null;
            }
        }
    }
}
