package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* INFO: compiled from: Rgb.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "x", "invoke", "(D)Ljava/lang/Double;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class Rgb$oetf$1 extends Lambda implements Function1<Double, Double> {
    final /* synthetic */ Rgb this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    Rgb$oetf$1(Rgb rgb) {
        super(1);
        this.this$0 = rgb;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Double invoke(Double d) {
        return invoke(d.doubleValue());
    }

    public final Double invoke(double d) {
        return Double.valueOf(RangesKt.coerceIn(this.this$0.getOetfOrig().invoke(d), this.this$0.min, this.this$0.max));
    }
}
