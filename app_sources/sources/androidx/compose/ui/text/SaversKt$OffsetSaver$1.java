package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Savers.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/runtime/saveable/SaverScope;J)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaversKt$OffsetSaver$1 extends Lambda implements Function2<SaverScope, Offset, Object> {
    public static final SaversKt$OffsetSaver$1 INSTANCE = new SaversKt$OffsetSaver$1();

    SaversKt$OffsetSaver$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Offset offset) {
        return m2326invokeUv8p0NA(saverScope, offset.getPackedValue());
    }

    /* WARN: Multi-variable type inference failed */
    /* INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
    public final Object m2326invokeUv8p0NA(SaverScope saverScope, long j) {
        return Offset.m286equalsimpl0(j, Offset.INSTANCE.m304getUnspecifiedF1C5BW0()) ? (Serializable) false : CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(Offset.m289getXimpl(j))), SaversKt.save(Float.valueOf(Offset.m290getYimpl(j))));
    }
}
