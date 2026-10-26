package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Savers.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/ParagraphStyle;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaversKt$ParagraphStyleSaver$1 extends Lambda implements Function2<SaverScope, ParagraphStyle, Object> {
    public static final SaversKt$ParagraphStyleSaver$1 INSTANCE = new SaversKt$ParagraphStyleSaver$1();

    SaversKt$ParagraphStyleSaver$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SaverScope saverScope, ParagraphStyle paragraphStyle) {
        return CollectionsKt.arrayListOf(SaversKt.save(TextAlign.m2769boximpl(paragraphStyle.getTextAlign())), SaversKt.save(TextDirection.m2783boximpl(paragraphStyle.getTextDirection())), SaversKt.save(TextUnit.m3065boximpl(paragraphStyle.getLineHeight()), SaversKt.getSaver(TextUnit.INSTANCE), saverScope), SaversKt.save(paragraphStyle.getTextIndent(), SaversKt.getSaver(TextIndent.INSTANCE), saverScope));
    }
}
