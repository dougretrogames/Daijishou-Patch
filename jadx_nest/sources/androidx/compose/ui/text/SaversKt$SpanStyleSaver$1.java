package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/SpanStyle;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaversKt$SpanStyleSaver$1 extends Lambda implements Function2<SaverScope, SpanStyle, Object> {
    public static final SaversKt$SpanStyleSaver$1 INSTANCE = new SaversKt$SpanStyleSaver$1();

    SaversKt$SpanStyleSaver$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SaverScope saverScope, SpanStyle spanStyle) {
        return CollectionsKt.arrayListOf(SaversKt.save(Color.m520boximpl(spanStyle.m2342getColor0d7_KjU()), SaversKt.getSaver(Color.INSTANCE), saverScope), SaversKt.save(TextUnit.m3065boximpl(spanStyle.getFontSize()), SaversKt.getSaver(TextUnit.INSTANCE), saverScope), SaversKt.save(spanStyle.getFontWeight(), SaversKt.getSaver(FontWeight.INSTANCE), saverScope), SaversKt.save(spanStyle.getFontStyle()), SaversKt.save(spanStyle.getFontSynthesis()), SaversKt.save(-1), SaversKt.save(spanStyle.getFontFeatureSettings()), SaversKt.save(TextUnit.m3065boximpl(spanStyle.getLetterSpacing()), SaversKt.getSaver(TextUnit.INSTANCE), saverScope), SaversKt.save(spanStyle.getBaselineShift(), SaversKt.getSaver(BaselineShift.INSTANCE), saverScope), SaversKt.save(spanStyle.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.INSTANCE), saverScope), SaversKt.save(spanStyle.getLocaleList(), SaversKt.getSaver(LocaleList.INSTANCE), saverScope), SaversKt.save(Color.m520boximpl(spanStyle.getBackground()), SaversKt.getSaver(Color.INSTANCE), saverScope), SaversKt.save(spanStyle.getTextDecoration(), SaversKt.getSaver(TextDecoration.INSTANCE), saverScope), SaversKt.save(spanStyle.getShadow(), SaversKt.getSaver(Shadow.INSTANCE), saverScope));
    }
}
