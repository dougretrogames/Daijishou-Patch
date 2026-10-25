package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: DerivedState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class DerivedSnapshotState$currentRecord$result$1$1$result$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ IntRef $calculationLevelRef;
    final /* synthetic */ int $nestedCalculationLevel;
    final /* synthetic */ MutableObjectIntMap<StateObject> $newDependencies;
    final /* synthetic */ DerivedSnapshotState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DerivedSnapshotState$currentRecord$result$1$1$result$1(DerivedSnapshotState<T> derivedSnapshotState, IntRef intRef, MutableObjectIntMap<StateObject> mutableObjectIntMap, int i) {
        super(1);
        this.this$0 = derivedSnapshotState;
        this.$calculationLevelRef = intRef;
        this.$newDependencies = mutableObjectIntMap;
        this.$nestedCalculationLevel = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        if (obj == this.this$0) {
            throw new IllegalStateException("A derived state calculation cannot read itself".toString());
        }
        if (obj instanceof StateObject) {
            int element = this.$calculationLevelRef.getElement();
            MutableObjectIntMap<StateObject> mutableObjectIntMap = this.$newDependencies;
            mutableObjectIntMap.set(obj, Math.min(element - this.$nestedCalculationLevel, mutableObjectIntMap.getOrDefault(obj, Integer.MAX_VALUE)));
        }
    }
}
