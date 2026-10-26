package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* INFO: compiled from: DrawScope.kt */
/* INFO: loaded from: classes.dex */
@DrawScopeMarker
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 n2\u00020\u0001:\u0001nJp\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Jp\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b&\u0010'JX\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b*\u0010+JX\u0010(\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b,\u0010-JN\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b1\u00102Jl\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H'ø\u0001\u0000¢\u0006\u0004\b9\u0010:Jv\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010;\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0004\b=\u0010>Jj\u0010?\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bG\u0010HJj\u0010?\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bI\u0010JJX\u0010K\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bL\u0010MJX\u0010K\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bN\u0010OJL\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bS\u0010TJL\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010$\u001a\u00020%2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bU\u0010VJp\u0010W\u001a\u00020\u00122\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b\\\u0010]Jp\u0010W\u001a\u00020\u00122\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b^\u0010_JX\u0010`\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\ba\u0010MJX\u0010`\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bb\u0010OJb\u0010c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010d\u001a\u00020e2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bf\u0010gJb\u0010c\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010d\u001a\u00020e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ\u001e\u0010j\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010k\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\bl\u0010mR\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006oÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "drawArc", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "offsetSize", TypedValues.CycleType.S_WAVE_OFFSET, "offsetSize-PENXr5M", "(JJ)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DrawScope extends Density {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* INFO: renamed from: drawArc-illE91I */
    void mo982drawArcillE91I(Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawArc-yD3GUKo */
    void mo983drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawCircle-V9BoPsw */
    void mo984drawCircleV9BoPsw(Brush brush, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawCircle-VaOC9Bg */
    void mo985drawCircleVaOC9Bg(long color, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* INFO: renamed from: drawImage-9jGpkUE */
    /* synthetic */ void mo986drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawImage-gbVJVH8 */
    void mo988drawImagegbVJVH8(ImageBitmap image, long topLeft, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawLine-1RTmtNc */
    void mo989drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawLine-NGM6Ib0 */
    void mo990drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawOval-AsUm42w */
    void mo991drawOvalAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawOval-n-J9OG0 */
    void mo992drawOvalnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawPath-GBMwjPU */
    void mo993drawPathGBMwjPU(Path path, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawPath-LG529CI */
    void mo994drawPathLG529CI(Path path, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawPoints-F8ZwMP8 */
    void mo995drawPointsF8ZwMP8(List<Offset> points, int pointMode, long color, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawPoints-Gsft0Ws */
    void mo996drawPointsGsft0Ws(List<Offset> points, int pointMode, Brush brush, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawRect-AsUm42w */
    void mo997drawRectAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawRect-n-J9OG0 */
    void mo998drawRectnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawRoundRect-ZuiqVtQ */
    void mo999drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* INFO: renamed from: drawRoundRect-u-Aw5IA */
    void mo1000drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode);

    DrawContext getDrawContext();

    LayoutDirection getLayoutDirection();

    /* INFO: compiled from: DrawScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m1106roundToPxR2X_6o(DrawScope drawScope, long j) {
            return DrawScope.super.mo1778roundToPxR2X_6o(j);
        }

        @Deprecated
        /* INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m1107roundToPx0680j_4(DrawScope drawScope, float f) {
            return DrawScope.super.mo1779roundToPx0680j_4(f);
        }

        @Deprecated
        /* INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m1108toDpGaN1DYA(DrawScope drawScope, long j) {
            return DrawScope.super.mo1780toDpGaN1DYA(j);
        }

        @Deprecated
        /* INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1109toDpu2uoSUM(DrawScope drawScope, float f) {
            return DrawScope.super.mo1781toDpu2uoSUM(f);
        }

        @Deprecated
        /* INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1110toDpu2uoSUM(DrawScope drawScope, int i) {
            return DrawScope.super.mo1782toDpu2uoSUM(i);
        }

        @Deprecated
        /* INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m1111toDpSizekrfVVM(DrawScope drawScope, long j) {
            return DrawScope.super.mo1783toDpSizekrfVVM(j);
        }

        @Deprecated
        /* INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m1112toPxR2X_6o(DrawScope drawScope, long j) {
            return DrawScope.super.mo1784toPxR2X_6o(j);
        }

        @Deprecated
        /* INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m1113toPx0680j_4(DrawScope drawScope, float f) {
            return DrawScope.super.mo1785toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(DrawScope drawScope, DpRect dpRect) {
            return DrawScope.super.toRect(dpRect);
        }

        @Deprecated
        /* INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m1114toSizeXkaWNTQ(DrawScope drawScope, long j) {
            return DrawScope.super.mo1786toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m1115toSp0xMU5do(DrawScope drawScope, float f) {
            return DrawScope.super.mo1787toSp0xMU5do(f);
        }

        @Deprecated
        /* INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1116toSpkPz2Gy4(DrawScope drawScope, float f) {
            return DrawScope.super.mo1788toSpkPz2Gy4(f);
        }

        @Deprecated
        /* INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1117toSpkPz2Gy4(DrawScope drawScope, int i) {
            return DrawScope.super.mo1789toSpkPz2Gy4(i);
        }

        @Deprecated
        /* INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m1104getCenterF1C5BW0(DrawScope drawScope) {
            return DrawScope.super.mo1080getCenterF1C5BW0();
        }

        @Deprecated
        /* INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m1105getSizeNHjbRc(DrawScope drawScope) {
            return DrawScope.super.mo1081getSizeNHjbRc();
        }

        @Deprecated
        /* INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m1089drawImageAZ2fEMs(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            DrawScope.super.mo987drawImageAZ2fEMs(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
        }
    }

    /* INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    default long mo1080getCenterF1C5BW0() {
        return SizeKt.m368getCenteruvyYCjk(getDrawContext().mo1006getSizeNHjbRc());
    }

    /* INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    default long mo1081getSizeNHjbRc() {
        return getDrawContext().mo1006getSizeNHjbRc();
    }

    /* INFO: renamed from: drawLine-1RTmtNc$default, reason: not valid java name */
    static /* synthetic */ void m1067drawLine1RTmtNc$default(DrawScope drawScope, Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }
        drawScope.mo989drawLine1RTmtNc(brush, j, j2, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? Stroke.INSTANCE.m1147getDefaultCapKaPHkGw() : i, (i3 & 32) != 0 ? null : pathEffect, (i3 & 64) != 0 ? 1.0f : f2, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i2);
    }

    /* INFO: renamed from: drawLine-NGM6Ib0$default, reason: not valid java name */
    static /* synthetic */ void m1068drawLineNGM6Ib0$default(DrawScope drawScope, long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }
        drawScope.mo990drawLineNGM6Ib0(j, j2, j3, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? Stroke.INSTANCE.m1147getDefaultCapKaPHkGw() : i, (i3 & 32) != 0 ? null : pathEffect, (i3 & 64) != 0 ? 1.0f : f2, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i2);
    }

    /* INFO: renamed from: drawRect-AsUm42w$default, reason: not valid java name */
    static /* synthetic */ void m1075drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }
        long jM305getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m305getZeroF1C5BW0() : j;
        drawScope.mo997drawRectAsUm42w(brush, jM305getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1079offsetSizePENXr5M(drawScope.mo1081getSizeNHjbRc(), jM305getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawRect-n-J9OG0$default, reason: not valid java name */
    static /* synthetic */ void m1076drawRectnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }
        long jM305getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m305getZeroF1C5BW0() : j2;
        drawScope.mo998drawRectnJ9OG0(j, jM305getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1079offsetSizePENXr5M(drawScope.mo1081getSizeNHjbRc(), jM305getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawImage-gbVJVH8$default, reason: not valid java name */
    static /* synthetic */ void m1066drawImagegbVJVH8$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }
        drawScope.mo988drawImagegbVJVH8(imageBitmap, (i2 & 2) != 0 ? Offset.INSTANCE.m305getZeroF1C5BW0() : j, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawImage-9jGpkUE$default, reason: not valid java name */
    static /* synthetic */ void m1064drawImage9jGpkUE$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
        }
        long jM3022getZeronOccac = (i2 & 2) != 0 ? IntOffset.INSTANCE.m3022getZeronOccac() : j;
        long jIntSize = (i2 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        drawScope.mo986drawImage9jGpkUE(imageBitmap, jM3022getZeronOccac, jIntSize, (i2 & 8) != 0 ? IntOffset.INSTANCE.m3022getZeronOccac() : j3, (i2 & 16) != 0 ? jIntSize : j4, (i2 & 32) != 0 ? 1.0f : f, (i2 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 128) != 0 ? null : colorFilter, (i2 & 256) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawImage-AZ2fEMs$default, reason: not valid java name */
    static /* synthetic */ void m1065drawImageAZ2fEMs$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
        long jM3022getZeronOccac = (i3 & 2) != 0 ? IntOffset.INSTANCE.m3022getZeronOccac() : j;
        long jIntSize = (i3 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        drawScope.mo987drawImageAZ2fEMs(imageBitmap, jM3022getZeronOccac, jIntSize, (i3 & 8) != 0 ? IntOffset.INSTANCE.m3022getZeronOccac() : j3, (i3 & 16) != 0 ? jIntSize : j4, (i3 & 32) != 0 ? 1.0f : f, (i3 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i, (i3 & 512) != 0 ? INSTANCE.m1083getDefaultFilterQualityfv9h1I() : i2);
    }

    /* INFO: renamed from: drawImage-AZ2fEMs */
    default void mo987drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        m1065drawImageAZ2fEMs$default(this, image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, 0, 512, null);
    }

    /* INFO: renamed from: drawRoundRect-ZuiqVtQ$default, reason: not valid java name */
    static /* synthetic */ void m1077drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }
        long jM305getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m305getZeroF1C5BW0() : j;
        drawScope.mo999drawRoundRectZuiqVtQ(brush, jM305getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1079offsetSizePENXr5M(drawScope.mo1081getSizeNHjbRc(), jM305getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? CornerRadius.INSTANCE.m274getZerokKHJgLs() : j3, (i2 & 16) != 0 ? 1.0f : f, (i2 & 32) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 64) != 0 ? null : colorFilter, (i2 & 128) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawRoundRect-u-Aw5IA$default, reason: not valid java name */
    static /* synthetic */ void m1078drawRoundRectuAw5IA$default(DrawScope drawScope, long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, Object obj) {
        DrawScope drawScope2;
        long jM1079offsetSizePENXr5M;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }
        long jM305getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m305getZeroF1C5BW0() : j2;
        if ((i2 & 4) != 0) {
            drawScope2 = drawScope;
            jM1079offsetSizePENXr5M = drawScope2.m1079offsetSizePENXr5M(drawScope.mo1081getSizeNHjbRc(), jM305getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            jM1079offsetSizePENXr5M = j3;
        }
        drawScope2.mo1000drawRoundRectuAw5IA(j, jM305getZeroF1C5BW0, jM1079offsetSizePENXr5M, (i2 & 8) != 0 ? CornerRadius.INSTANCE.m274getZerokKHJgLs() : j4, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? 1.0f : f, (i2 & 64) != 0 ? null : colorFilter, (i2 & 128) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawCircle-V9BoPsw$default, reason: not valid java name */
    static /* synthetic */ void m1062drawCircleV9BoPsw$default(DrawScope drawScope, Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        }
        drawScope.mo984drawCircleV9BoPsw(brush, (i2 & 2) != 0 ? Size.m357getMinDimensionimpl(drawScope.mo1081getSizeNHjbRc()) / 2.0f : f, (i2 & 4) != 0 ? drawScope.mo1080getCenterF1C5BW0() : j, (i2 & 8) != 0 ? 1.0f : f2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawCircle-VaOC9Bg$default, reason: not valid java name */
    static /* synthetic */ void m1063drawCircleVaOC9Bg$default(DrawScope drawScope, long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }
        if ((i2 & 2) != 0) {
            f = Size.m357getMinDimensionimpl(drawScope.mo1081getSizeNHjbRc()) / 2.0f;
        }
        drawScope.mo985drawCircleVaOC9Bg(j, f, (i2 & 4) != 0 ? drawScope.mo1080getCenterF1C5BW0() : j2, (i2 & 8) != 0 ? 1.0f : f2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawOval-AsUm42w$default, reason: not valid java name */
    static /* synthetic */ void m1069drawOvalAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
        }
        long jM305getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m305getZeroF1C5BW0() : j;
        drawScope.mo991drawOvalAsUm42w(brush, jM305getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1079offsetSizePENXr5M(drawScope.mo1081getSizeNHjbRc(), jM305getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawOval-n-J9OG0$default, reason: not valid java name */
    static /* synthetic */ void m1070drawOvalnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
        }
        long jM305getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m305getZeroF1C5BW0() : j2;
        drawScope.mo992drawOvalnJ9OG0(j, jM305getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1079offsetSizePENXr5M(drawScope.mo1081getSizeNHjbRc(), jM305getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawArc-illE91I$default, reason: not valid java name */
    static /* synthetic */ void m1060drawArcillE91I$default(DrawScope drawScope, Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        DrawScope drawScope2;
        long jM1079offsetSizePENXr5M;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        }
        long jM305getZeroF1C5BW0 = (i2 & 16) != 0 ? Offset.INSTANCE.m305getZeroF1C5BW0() : j;
        if ((i2 & 32) != 0) {
            drawScope2 = drawScope;
            jM1079offsetSizePENXr5M = drawScope2.m1079offsetSizePENXr5M(drawScope.mo1081getSizeNHjbRc(), jM305getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            jM1079offsetSizePENXr5M = j2;
        }
        drawScope2.mo982drawArcillE91I(brush, f, f2, z, jM305getZeroF1C5BW0, jM1079offsetSizePENXr5M, (i2 & 64) != 0 ? 1.0f : f3, (i2 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawArc-yD3GUKo$default, reason: not valid java name */
    static /* synthetic */ void m1061drawArcyD3GUKo$default(DrawScope drawScope, long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        DrawScope drawScope2;
        long jM1079offsetSizePENXr5M;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        }
        long jM305getZeroF1C5BW0 = (i2 & 16) != 0 ? Offset.INSTANCE.m305getZeroF1C5BW0() : j2;
        if ((i2 & 32) != 0) {
            drawScope2 = drawScope;
            jM1079offsetSizePENXr5M = drawScope2.m1079offsetSizePENXr5M(drawScope.mo1081getSizeNHjbRc(), jM305getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            jM1079offsetSizePENXr5M = j3;
        }
        drawScope2.mo983drawArcyD3GUKo(j, f, f2, z, jM305getZeroF1C5BW0, jM1079offsetSizePENXr5M, (i2 & 64) != 0 ? 1.0f : f3, (i2 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawPath-LG529CI$default, reason: not valid java name */
    static /* synthetic */ void m1072drawPathLG529CI$default(DrawScope drawScope, Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        drawScope.mo994drawPathLG529CI(path, j, f2, drawStyle2, colorFilter, (i2 & 32) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i);
    }

    /* INFO: renamed from: drawPath-GBMwjPU$default, reason: not valid java name */
    static /* synthetic */ void m1071drawPathGBMwjPU$default(DrawScope drawScope, Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i2 & 32) != 0) {
            i = INSTANCE.m1082getDefaultBlendMode0nO6VwU();
        }
        drawScope.mo993drawPathGBMwjPU(path, brush, f2, drawStyle2, colorFilter2, i);
    }

    /* INFO: renamed from: drawPoints-F8ZwMP8$default, reason: not valid java name */
    static /* synthetic */ void m1073drawPointsF8ZwMP8$default(DrawScope drawScope, List list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }
        drawScope.mo995drawPointsF8ZwMP8(list, i, j, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? StrokeCap.INSTANCE.m884getButtKaPHkGw() : i2, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i3);
    }

    /* INFO: renamed from: drawPoints-Gsft0Ws$default, reason: not valid java name */
    static /* synthetic */ void m1074drawPointsGsft0Ws$default(DrawScope drawScope, List list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
        }
        drawScope.mo996drawPointsGsft0Ws(list, i, brush, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? StrokeCap.INSTANCE.m884getButtKaPHkGw() : i2, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? INSTANCE.m1082getDefaultBlendMode0nO6VwU() : i3);
    }

    /* INFO: renamed from: offsetSize-PENXr5M, reason: not valid java name */
    private default long m1079offsetSizePENXr5M(long j, long j2) {
        return SizeKt.Size(Size.m358getWidthimpl(j) - Offset.m289getXimpl(j2), Size.m355getHeightimpl(j) - Offset.m290getYimpl(j2));
    }

    /* INFO: compiled from: DrawScope.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", "", "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "DefaultFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getDefaultFilterQuality-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.INSTANCE.m472getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.INSTANCE.m631getLowfv9h1I();

        private Companion() {
        }

        /* INFO: renamed from: getDefaultBlendMode-0nO6VwU, reason: not valid java name */
        public final int m1082getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* INFO: renamed from: getDefaultFilterQuality-f-v9h1I, reason: not valid java name */
        public final int m1083getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }
}
