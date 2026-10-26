package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Savers.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/style/TextIndent;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaversKt$TextIndentSaver$2 extends Lambda implements Function1<Object, TextIndent> {
    public static final SaversKt$TextIndentSaver$2 INSTANCE = new SaversKt$TextIndentSaver$2();

    SaversKt$TextIndentSaver$2() {
        super(1);
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final TextIndent invoke(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextUnit textUnitRestore = null;
        TextUnit textUnitRestore2 = (Intrinsics.areEqual(obj2, (Object) false) || obj2 == null) ? null : SaversKt.getSaver(TextUnit.INSTANCE).restore(obj2);
        Intrinsics.checkNotNull(textUnitRestore2);
        long packedValue = textUnitRestore2.getPackedValue();
        Object obj3 = list.get(1);
        Saver<TextUnit, Object> saver = SaversKt.getSaver(TextUnit.INSTANCE);
        if (!Intrinsics.areEqual(obj3, (Object) false) && obj3 != null) {
            textUnitRestore = saver.restore(obj3);
        }
        Intrinsics.checkNotNull(textUnitRestore);
        return new TextIndent(packedValue, textUnitRestore.getPackedValue(), null);
    }
}
