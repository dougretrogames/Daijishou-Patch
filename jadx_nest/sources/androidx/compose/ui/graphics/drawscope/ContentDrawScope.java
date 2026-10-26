package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;

/* INFO: compiled from: ContentDrawScope.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ContentDrawScope extends DrawScope {
    void drawContent();

    /* INFO: compiled from: ContentDrawScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m1030drawImageAZ2fEMs(ContentDrawScope contentDrawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            ContentDrawScope.super.mo987drawImageAZ2fEMs(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m1031getCenterF1C5BW0(ContentDrawScope contentDrawScope) {
            return ContentDrawScope.super.mo1080getCenterF1C5BW0();
        }

        @Deprecated
        /* INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m1032getSizeNHjbRc(ContentDrawScope contentDrawScope) {
            return ContentDrawScope.super.mo1081getSizeNHjbRc();
        }

        @Deprecated
        /* INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m1033roundToPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo1778roundToPxR2X_6o(j);
        }

        @Deprecated
        /* INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m1034roundToPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo1779roundToPx0680j_4(f);
        }

        @Deprecated
        /* INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m1035toDpGaN1DYA(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo1780toDpGaN1DYA(j);
        }

        @Deprecated
        /* INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1036toDpu2uoSUM(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo1781toDpu2uoSUM(f);
        }

        @Deprecated
        /* INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1037toDpu2uoSUM(ContentDrawScope contentDrawScope, int i) {
            return ContentDrawScope.super.mo1782toDpu2uoSUM(i);
        }

        @Deprecated
        /* INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m1038toDpSizekrfVVM(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo1783toDpSizekrfVVM(j);
        }

        @Deprecated
        /* INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m1039toPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo1784toPxR2X_6o(j);
        }

        @Deprecated
        /* INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m1040toPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo1785toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(ContentDrawScope contentDrawScope, DpRect dpRect) {
            return ContentDrawScope.super.toRect(dpRect);
        }

        @Deprecated
        /* INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m1041toSizeXkaWNTQ(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo1786toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m1042toSp0xMU5do(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo1787toSp0xMU5do(f);
        }

        @Deprecated
        /* INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1043toSpkPz2Gy4(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo1788toSpkPz2Gy4(f);
        }

        @Deprecated
        /* INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1044toSpkPz2Gy4(ContentDrawScope contentDrawScope, int i) {
            return ContentDrawScope.super.mo1789toSpkPz2Gy4(i);
        }
    }
}
