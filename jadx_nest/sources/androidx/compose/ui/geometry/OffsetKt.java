package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* INFO: compiled from: Offset.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0011\u001a*\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a%\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"isFinite", "", "Landroidx/compose/ui/geometry/Offset;", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite-k-4lQ0M", "(J)Z", "isSpecified", "isSpecified-k-4lQ0M$annotations", "isSpecified-k-4lQ0M", "isUnspecified", "isUnspecified-k-4lQ0M$annotations", "isUnspecified-k-4lQ0M", "Offset", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-3MmeM6k", "(JLkotlin/jvm/functions/Function0;)J", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OffsetKt {
    /* INFO: renamed from: isFinite-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m307isFinitek4lQ0M$annotations(long j) {
    }

    /* INFO: renamed from: isSpecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m309isSpecifiedk4lQ0M$annotations(long j) {
    }

    /* INFO: renamed from: isUnspecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m311isUnspecifiedk4lQ0M$annotations(long j) {
    }

    /* INFO: renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m312lerpWko1d7g(long j, long j2, float f) {
        return Offset(MathHelpersKt.lerp(Offset.m289getXimpl(j), Offset.m289getXimpl(j2), f), MathHelpersKt.lerp(Offset.m290getYimpl(j), Offset.m290getYimpl(j2), f));
    }

    /* INFO: renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m306isFinitek4lQ0M(long j) {
        float fM289getXimpl = Offset.m289getXimpl(j);
        if (Float.isInfinite(fM289getXimpl) || Float.isNaN(fM289getXimpl)) {
            return false;
        }
        float fM290getYimpl = Offset.m290getYimpl(j);
        return (Float.isInfinite(fM290getYimpl) || Float.isNaN(fM290getYimpl)) ? false : true;
    }

    /* INFO: renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m308isSpecifiedk4lQ0M(long j) {
        return j != Offset.INSTANCE.m304getUnspecifiedF1C5BW0();
    }

    /* INFO: renamed from: isUnspecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m310isUnspecifiedk4lQ0M(long j) {
        return j == Offset.INSTANCE.m304getUnspecifiedF1C5BW0();
    }

    /* INFO: renamed from: takeOrElse-3MmeM6k, reason: not valid java name */
    public static final long m313takeOrElse3MmeM6k(long j, Function0<Offset> function0) {
        return m308isSpecifiedk4lQ0M(j) ? j : function0.invoke().getPackedValue();
    }

    public static final long Offset(float f, float f2) {
        return Offset.m281constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }
}
