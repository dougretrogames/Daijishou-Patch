package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: Blur.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BlurKt {
    /* JADX INFO: renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m183blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m186boximpl(BlurredEdgeTreatment.INSTANCE.m193getRectangleGoahg());
        }
        return m182blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m192unboximpl());
    }

    /* JADX INFO: renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m182blur1fqSgw(Modifier modifier, float f, float f2, Shape shape) {
        int iM905getDecal3opZhB0;
        boolean z;
        if (shape != null) {
            iM905getDecal3opZhB0 = TileMode.INSTANCE.m904getClamp3opZhB0();
            z = true;
        } else {
            iM905getDecal3opZhB0 = TileMode.INSTANCE.m905getDecal3opZhB0();
            z = false;
        }
        float f3 = 0;
        return ((Dp.m2883compareTo0680j_4(f, Dp.m2884constructorimpl(f3)) <= 0 || Dp.m2883compareTo0680j_4(f2, Dp.m2884constructorimpl(f3)) <= 0) && !z) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new BlurKt$blur$1(f, f2, iM905getDecal3opZhB0, shape, z));
    }

    /* JADX INFO: renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m185blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m186boximpl(BlurredEdgeTreatment.INSTANCE.m193getRectangleGoahg());
        }
        return m184blurF8QBwvs(modifier, f, blurredEdgeTreatment.m192unboximpl());
    }

    /* JADX INFO: renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m184blurF8QBwvs(Modifier modifier, float f, Shape shape) {
        return m182blur1fqSgw(modifier, f, f, shape);
    }
}
