package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextPainter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:55:? A[SYNTHETIC] */
    public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) throws Throwable {
        Canvas canvas2;
        Throwable th;
        Canvas canvas3;
        long jM556getBlack0d7_KjU;
        float alpha;
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m2818equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m2827getVisiblegIe3tQ8());
        if (z) {
            Rect rectM329Recttz77jQw = RectKt.m329Recttz77jQw(Offset.INSTANCE.m305getZeroF1C5BW0(), SizeKt.Size(IntSize.m3054getWidthimpl(textLayoutResult.getSize()), IntSize.m3053getHeightimpl(textLayoutResult.getSize())));
            canvas.save();
            canvas2 = null;
            Canvas.m503clipRectmtrdDE$default(canvas, rectM329Recttz77jQw, 0, 2, null);
        }
        SpanStyle spanStyle = textLayoutResult.getLayoutInput().getStyle().getSpanStyle();
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        Shadow shadow2 = shadow;
        Fill drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        try {
            Brush brush = spanStyle.getBrush();
            try {
                if (brush != null) {
                    if (spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                        try {
                            alpha = spanStyle.getTextForegroundStyle().getAlpha();
                        } catch (Throwable th2) {
                            th = th2;
                            canvas2 = canvas;
                            if (z) {
                                throw th;
                            }
                            canvas2.restore();
                            throw th;
                        }
                    } else {
                        alpha = 1.0f;
                    }
                    canvas3 = canvas;
                    MultiParagraph.m2258painthn5TExg$default(textLayoutResult.getMultiParagraph(), canvas3, brush, alpha, shadow2, textDecoration2, drawStyle2, 0, 64, null);
                } else {
                    canvas3 = canvas;
                    if (spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                        jM556getBlack0d7_KjU = spanStyle.getTextForegroundStyle().mo2674getColor0d7_KjU();
                    } else {
                        jM556getBlack0d7_KjU = Color.INSTANCE.m556getBlack0d7_KjU();
                    }
                    textLayoutResult.getMultiParagraph().m2262paintLG529CI(canvas3, (32 & 2) != 0 ? Color.INSTANCE.m566getUnspecified0d7_KjU() : jM556getBlack0d7_KjU, (32 & 4) != 0 ? null : shadow2, (32 & 8) != 0 ? null : textDecoration2, (32 & 16) == 0 ? drawStyle2 : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m1082getDefaultBlendMode0nO6VwU() : 0);
                }
                if (z) {
                    canvas3.restore();
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                if (z) {
                    throw th;
                }
                canvas2.restore();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            canvas2 = canvas;
        }
    }
}
