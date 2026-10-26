package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* INFO: compiled from: RoundRect.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a@\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a8\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001c\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0015\u0010\f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", TypedValues.CycleType.S_WAVE_OFFSET, "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RoundRectKt {
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long jCornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, jCornerRadius, jCornerRadius, jCornerRadius, jCornerRadius, null);
    }

    /* INFO: renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m343RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.m264getXimpl(j), CornerRadius.m265getYimpl(j));
    }

    public static final RoundRect RoundRect(Rect rect, float f, float f2) {
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2);
    }

    /* INFO: renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m344RoundRectsniSvfs(Rect rect, long j) {
        return RoundRect(rect, CornerRadius.m264getXimpl(j), CornerRadius.m265getYimpl(j));
    }

    /* INFO: renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m341RoundRectZAM2FJo(Rect rect, long j, long j2, long j3, long j4) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    /* INFO: renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m345translateUv8p0NA(RoundRect roundRect, long j) {
        return new RoundRect(roundRect.getLeft() + Offset.m289getXimpl(j), roundRect.getTop() + Offset.m290getYimpl(j), roundRect.getRight() + Offset.m289getXimpl(j), roundRect.getBottom() + Offset.m290getYimpl(j), roundRect.m339getTopLeftCornerRadiuskKHJgLs(), roundRect.m340getTopRightCornerRadiuskKHJgLs(), roundRect.m338getBottomRightCornerRadiuskKHJgLs(), roundRect.m337getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final Rect getSafeInnerRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft() + (Math.max(CornerRadius.m264getXimpl(roundRect.m337getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getTop() + (Math.max(CornerRadius.m265getYimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m265getYimpl(roundRect.m340getTopRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getRight() - (Math.max(CornerRadius.m264getXimpl(roundRect.m340getTopRightCornerRadiuskKHJgLs()), CornerRadius.m264getXimpl(roundRect.m338getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getBottom() - (Math.max(CornerRadius.m265getYimpl(roundRect.m338getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m265getYimpl(roundRect.m337getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isEmpty(RoundRect roundRect) {
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(RoundRect roundRect) {
        float left = roundRect.getLeft();
        if (Float.isInfinite(left) || Float.isNaN(left)) {
            return false;
        }
        float top = roundRect.getTop();
        if (Float.isInfinite(top) || Float.isNaN(top)) {
            return false;
        }
        float right = roundRect.getRight();
        if (Float.isInfinite(right) || Float.isNaN(right)) {
            return false;
        }
        float bottom = roundRect.getBottom();
        return (Float.isInfinite(bottom) || Float.isNaN(bottom)) ? false : true;
    }

    public static final boolean isRect(RoundRect roundRect) {
        if (CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) != 0.0f && CornerRadius.m265getYimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) != 0.0f) {
            return false;
        }
        if (CornerRadius.m264getXimpl(roundRect.m340getTopRightCornerRadiuskKHJgLs()) != 0.0f && CornerRadius.m265getYimpl(roundRect.m340getTopRightCornerRadiuskKHJgLs()) != 0.0f) {
            return false;
        }
        if (CornerRadius.m264getXimpl(roundRect.m337getBottomLeftCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m265getYimpl(roundRect.m337getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) {
            return CornerRadius.m264getXimpl(roundRect.m338getBottomRightCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m265getYimpl(roundRect.m338getBottomRightCornerRadiuskKHJgLs()) == 0.0f;
        }
        return false;
    }

    public static final boolean isEllipse(RoundRect roundRect) {
        return CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m264getXimpl(roundRect.m340getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m265getYimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m265getYimpl(roundRect.m340getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m264getXimpl(roundRect.m340getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m264getXimpl(roundRect.m338getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m265getYimpl(roundRect.m340getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m265getYimpl(roundRect.m338getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m264getXimpl(roundRect.m338getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m264getXimpl(roundRect.m337getBottomLeftCornerRadiuskKHJgLs()) && CornerRadius.m265getYimpl(roundRect.m338getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m265getYimpl(roundRect.m337getBottomLeftCornerRadiuskKHJgLs()) && ((double) roundRect.getWidth()) <= ((double) CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs())) * 2.0d && ((double) roundRect.getHeight()) <= ((double) CornerRadius.m265getYimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs())) * 2.0d;
    }

    public static final boolean isCircle(RoundRect roundRect) {
        return roundRect.getWidth() == roundRect.getHeight() && isEllipse(roundRect);
    }

    public static final float getMinDimension(RoundRect roundRect) {
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMaxDimension(RoundRect roundRect) {
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final long getCenter(RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft() + (roundRect.getWidth() / 2.0f), roundRect.getTop() + (roundRect.getHeight() / 2.0f));
    }

    public static final boolean isSimple(RoundRect roundRect) {
        return CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m265getYimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) && CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m264getXimpl(roundRect.m340getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m265getYimpl(roundRect.m340getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m264getXimpl(roundRect.m338getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m265getYimpl(roundRect.m338getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m264getXimpl(roundRect.m337getBottomLeftCornerRadiuskKHJgLs()) && CornerRadius.m264getXimpl(roundRect.m339getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m265getYimpl(roundRect.m337getBottomLeftCornerRadiuskKHJgLs());
    }

    public static final RoundRect lerp(RoundRect roundRect, RoundRect roundRect2, float f) {
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f), CornerRadiusKt.m275lerp3Ry4LBc(roundRect.m339getTopLeftCornerRadiuskKHJgLs(), roundRect2.m339getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m275lerp3Ry4LBc(roundRect.m340getTopRightCornerRadiuskKHJgLs(), roundRect2.m340getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m275lerp3Ry4LBc(roundRect.m338getBottomRightCornerRadiuskKHJgLs(), roundRect2.m338getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m275lerp3Ry4LBc(roundRect.m337getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m337getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }
}
