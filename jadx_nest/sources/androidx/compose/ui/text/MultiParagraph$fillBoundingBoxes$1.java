package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: MultiParagraph.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "paragraphInfo", "Landroidx/compose/ui/text/ParagraphInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class MultiParagraph$fillBoundingBoxes$1 extends Lambda implements Function1<ParagraphInfo, Unit> {
    final /* synthetic */ float[] $array;
    final /* synthetic */ Ref.IntRef $currentArrayStart;
    final /* synthetic */ Ref.FloatRef $currentHeight;
    final /* synthetic */ long $range;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MultiParagraph$fillBoundingBoxes$1(long j, float[] fArr, Ref.IntRef intRef, Ref.FloatRef floatRef) {
        super(1);
        this.$range = j;
        this.$array = fArr;
        this.$currentArrayStart = intRef;
        this.$currentHeight = floatRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ParagraphInfo paragraphInfo) {
        invoke2(paragraphInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ParagraphInfo paragraphInfo) {
        long j = this.$range;
        float[] fArr = this.$array;
        Ref.IntRef intRef = this.$currentArrayStart;
        Ref.FloatRef floatRef = this.$currentHeight;
        long jTextRange = TextRangeKt.TextRange(paragraphInfo.toLocalIndex(paragraphInfo.getStartIndex() > TextRange.m2381getMinimpl(j) ? paragraphInfo.getStartIndex() : TextRange.m2381getMinimpl(j)), paragraphInfo.toLocalIndex(paragraphInfo.getEndIndex() < TextRange.m2380getMaximpl(j) ? paragraphInfo.getEndIndex() : TextRange.m2380getMaximpl(j)));
        paragraphInfo.getParagraph().mo2229fillBoundingBoxes8ffj60Q(jTextRange, fArr, intRef.element);
        int iM2379getLengthimpl = intRef.element + (TextRange.m2379getLengthimpl(jTextRange) * 4);
        for (int i = intRef.element; i < iM2379getLengthimpl; i += 4) {
            int i2 = i + 1;
            fArr[i2] = fArr[i2] + floatRef.element;
            int i3 = i + 3;
            fArr[i3] = fArr[i3] + floatRef.element;
        }
        intRef.element = iM2379getLengthimpl;
        floatRef.element += paragraphInfo.getParagraph().getHeight();
    }
}
