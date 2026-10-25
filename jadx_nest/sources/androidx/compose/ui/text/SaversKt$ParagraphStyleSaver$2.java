package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/ParagraphStyle;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaversKt$ParagraphStyleSaver$2 extends Lambda implements Function1<Object, ParagraphStyle> {
    public static final SaversKt$ParagraphStyleSaver$2 INSTANCE = new SaversKt$ParagraphStyleSaver$2();

    SaversKt$ParagraphStyleSaver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final ParagraphStyle invoke(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextIndent textIndentRestore = null;
        TextAlign textAlign = obj2 != null ? (TextAlign) obj2 : null;
        Intrinsics.checkNotNull(textAlign);
        int value = textAlign.getValue();
        Object obj3 = list.get(1);
        TextDirection textDirection = obj3 != null ? (TextDirection) obj3 : null;
        Intrinsics.checkNotNull(textDirection);
        int value2 = textDirection.getValue();
        Object obj4 = list.get(2);
        TextUnit textUnitRestore = (Intrinsics.areEqual(obj4, (Object) false) || obj4 == null) ? null : SaversKt.getSaver(TextUnit.INSTANCE).restore(obj4);
        Intrinsics.checkNotNull(textUnitRestore);
        long packedValue = textUnitRestore.getPackedValue();
        Object obj5 = list.get(3);
        Saver<TextIndent, Object> saver = SaversKt.getSaver(TextIndent.INSTANCE);
        if (!Intrinsics.areEqual(obj5, (Object) false) && obj5 != null) {
            textIndentRestore = saver.restore(obj5);
        }
        return new ParagraphStyle(value, value2, packedValue, textIndentRestore, (PlatformParagraphStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 496, (DefaultConstructorMarker) null);
    }
}
