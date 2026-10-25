package androidx.compose.ui.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextRange;", "it", "", "invoke-VqIyPBM"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaversKt$TextRangeSaver$2 extends Lambda implements Function1<Object, TextRange> {
    public static final SaversKt$TextRangeSaver$2 INSTANCE = new SaversKt$TextRangeSaver$2();

    SaversKt$TextRangeSaver$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: invoke-VqIyPBM, reason: not valid java name and merged with bridge method [inline-methods] */
    public final TextRange invoke(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Integer num = obj2 != null ? (Integer) obj2 : null;
        Intrinsics.checkNotNull(num);
        int iIntValue = num.intValue();
        Object obj3 = list.get(1);
        Integer num2 = obj3 != null ? (Integer) obj3 : null;
        Intrinsics.checkNotNull(num2);
        return TextRange.m2371boximpl(TextRangeKt.TextRange(iIntValue, num2.intValue()));
    }
}
