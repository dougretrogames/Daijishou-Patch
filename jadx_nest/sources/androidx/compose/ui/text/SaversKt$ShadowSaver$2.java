package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Savers.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/graphics/Shadow;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaversKt$ShadowSaver$2 extends Lambda implements Function1<Object, Shadow> {
    public static final SaversKt$ShadowSaver$2 INSTANCE = new SaversKt$ShadowSaver$2();

    SaversKt$ShadowSaver$2() {
        super(1);
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Shadow invoke(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Color colorRestore = (Intrinsics.areEqual(obj2, (Object) false) || obj2 == null) ? null : SaversKt.getSaver(Color.INSTANCE).restore(obj2);
        Intrinsics.checkNotNull(colorRestore);
        long jM540unboximpl = colorRestore.m540unboximpl();
        Object obj3 = list.get(1);
        Offset offsetRestore = (Intrinsics.areEqual(obj3, (Object) false) || obj3 == null) ? null : SaversKt.getSaver(Offset.INSTANCE).restore(obj3);
        Intrinsics.checkNotNull(offsetRestore);
        long packedValue = offsetRestore.getPackedValue();
        Object obj4 = list.get(2);
        Float f = obj4 != null ? (Float) obj4 : null;
        Intrinsics.checkNotNull(f);
        return new Shadow(jM540unboximpl, packedValue, f.floatValue(), null);
    }
}
