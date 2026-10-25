package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\b\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Density extends FontScaling {
    float getDensity();

    /* JADX INFO: compiled from: Density.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m2872toDpGaN1DYA(Density density, long j) {
            return Density.super.mo1780toDpGaN1DYA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m2879toSp0xMU5do(Density density, float f) {
            return Density.super.mo1787toSp0xMU5do(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m2877toPx0680j_4(Density density, float f) {
            return Density.super.mo1785toPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m2871roundToPx0680j_4(Density density, float f) {
            return Density.super.mo1779roundToPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m2876toPxR2X_6o(Density density, long j) {
            return Density.super.mo1784toPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m2870roundToPxR2X_6o(Density density, long j) {
            return Density.super.mo1778roundToPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2874toDpu2uoSUM(Density density, int i) {
            return Density.super.mo1782toDpu2uoSUM(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2881toSpkPz2Gy4(Density density, int i) {
            return Density.super.mo1789toSpkPz2Gy4(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2873toDpu2uoSUM(Density density, float f) {
            return Density.super.mo1781toDpu2uoSUM(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2880toSpkPz2Gy4(Density density, float f) {
            return Density.super.mo1788toSpkPz2Gy4(f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            return Density.super.toRect(dpRect);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m2878toSizeXkaWNTQ(Density density, long j) {
            return Density.super.mo1786toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m2875toDpSizekrfVVM(Density density, long j) {
            return Density.super.mo1783toDpSizekrfVVM(j);
        }
    }

    /* JADX INFO: renamed from: toPx-0680j_4 */
    default float mo1785toPx0680j_4(float f) {
        return f * getDensity();
    }

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    default int mo1779roundToPx0680j_4(float f) {
        float fMo1785toPx0680j_4 = mo1785toPx0680j_4(f);
        if (Float.isInfinite(fMo1785toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return MathKt.roundToInt(fMo1785toPx0680j_4);
    }

    /* JADX INFO: renamed from: toPx--R2X_6o */
    default float mo1784toPxR2X_6o(long j) {
        if (!TextUnitType.m3103equalsimpl0(TextUnit.m3074getTypeUIouoOA(j), TextUnitType.INSTANCE.m3108getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }
        return mo1785toPx0680j_4(mo1780toDpGaN1DYA(j));
    }

    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    default int mo1778roundToPxR2X_6o(long j) {
        return MathKt.roundToInt(mo1784toPxR2X_6o(j));
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo1782toDpu2uoSUM(int i) {
        return Dp.m2884constructorimpl(i / getDensity());
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo1789toSpkPz2Gy4(int i) {
        return mo1787toSp0xMU5do(mo1782toDpu2uoSUM(i));
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo1781toDpu2uoSUM(float f) {
        return Dp.m2884constructorimpl(f / getDensity());
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo1788toSpkPz2Gy4(float f) {
        return mo1787toSp0xMU5do(mo1781toDpu2uoSUM(f));
    }

    default Rect toRect(DpRect dpRect) {
        return new Rect(mo1785toPx0680j_4(dpRect.m2967getLeftD9Ej5fM()), mo1785toPx0680j_4(dpRect.m2969getTopD9Ej5fM()), mo1785toPx0680j_4(dpRect.m2968getRightD9Ej5fM()), mo1785toPx0680j_4(dpRect.m2966getBottomD9Ej5fM()));
    }

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    default long mo1786toSizeXkaWNTQ(long j) {
        if (j != DpSize.INSTANCE.m2991getUnspecifiedMYxV2XQ()) {
            return SizeKt.Size(mo1785toPx0680j_4(DpSize.m2982getWidthD9Ej5fM(j)), mo1785toPx0680j_4(DpSize.m2980getHeightD9Ej5fM(j)));
        }
        return Size.INSTANCE.m366getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    default long mo1783toDpSizekrfVVM(long j) {
        if (j != Size.INSTANCE.m366getUnspecifiedNHjbRc()) {
            return DpKt.m2906DpSizeYgX7TsA(mo1781toDpu2uoSUM(Size.m358getWidthimpl(j)), mo1781toDpu2uoSUM(Size.m355getHeightimpl(j)));
        }
        return DpSize.INSTANCE.m2991getUnspecifiedMYxV2XQ();
    }
}
