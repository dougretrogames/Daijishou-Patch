package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.DpRect;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* INFO: compiled from: MeasureScope.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MeasureScope extends IntrinsicMeasureScope {

    /* INFO: compiled from: MeasureScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isLookingAhead(MeasureScope measureScope) {
            return MeasureScope.super.isLookingAhead();
        }

        @Deprecated
        /* INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m1857roundToPxR2X_6o(MeasureScope measureScope, long j) {
            return MeasureScope.super.mo1778roundToPxR2X_6o(j);
        }

        @Deprecated
        /* INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m1858roundToPx0680j_4(MeasureScope measureScope, float f) {
            return MeasureScope.super.mo1779roundToPx0680j_4(f);
        }

        @Deprecated
        /* INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m1859toDpGaN1DYA(MeasureScope measureScope, long j) {
            return MeasureScope.super.mo1780toDpGaN1DYA(j);
        }

        @Deprecated
        /* INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1860toDpu2uoSUM(MeasureScope measureScope, float f) {
            return MeasureScope.super.mo1781toDpu2uoSUM(f);
        }

        @Deprecated
        /* INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1861toDpu2uoSUM(MeasureScope measureScope, int i) {
            return MeasureScope.super.mo1782toDpu2uoSUM(i);
        }

        @Deprecated
        /* INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m1862toDpSizekrfVVM(MeasureScope measureScope, long j) {
            return MeasureScope.super.mo1783toDpSizekrfVVM(j);
        }

        @Deprecated
        /* INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m1863toPxR2X_6o(MeasureScope measureScope, long j) {
            return MeasureScope.super.mo1784toPxR2X_6o(j);
        }

        @Deprecated
        /* INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m1864toPx0680j_4(MeasureScope measureScope, float f) {
            return MeasureScope.super.mo1785toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(MeasureScope measureScope, DpRect dpRect) {
            return MeasureScope.super.toRect(dpRect);
        }

        @Deprecated
        /* INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m1865toSizeXkaWNTQ(MeasureScope measureScope, long j) {
            return MeasureScope.super.mo1786toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m1866toSp0xMU5do(MeasureScope measureScope, float f) {
            return MeasureScope.super.mo1787toSp0xMU5do(f);
        }

        @Deprecated
        /* INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1867toSpkPz2Gy4(MeasureScope measureScope, float f) {
            return MeasureScope.super.mo1788toSpkPz2Gy4(f);
        }

        @Deprecated
        /* INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1868toSpkPz2Gy4(MeasureScope measureScope, int i) {
            return MeasureScope.super.mo1789toSpkPz2Gy4(i);
        }

        @Deprecated
        public static MeasureResult layout(MeasureScope measureScope, int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
            return MeasureScope.super.layout(i, i2, map, function1);
        }
    }

    /* WARN: Multi-variable type inference failed */
    static /* synthetic */ MeasureResult layout$default(MeasureScope measureScope, int i, int i2, Map map, Function1 function1, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
        if ((i3 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return measureScope.layout(i, i2, map, function1);
    }

    /* INFO: renamed from: androidx.compose.ui.layout.MeasureScope$layout$1, reason: invalid class name */
    /* INFO: compiled from: MeasureScope.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"androidx/compose/ui/layout/MeasureScope$layout$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements MeasureResult {
        final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
        final /* synthetic */ int $width;
        private final Map<AlignmentLine, Integer> alignmentLines;
        private final int height;
        final /* synthetic */ MeasureScope this$0;
        private final int width;

        /* WARN: Multi-variable type inference failed */
        AnonymousClass1(int i, int i2, Map<AlignmentLine, Integer> map, MeasureScope measureScope, Function1<? super Placeable.PlacementScope, Unit> function1) {
            this.$width = i;
            this.this$0 = measureScope;
            this.$placementBlock = function1;
            this.width = i;
            this.height = i2;
            this.alignmentLines = map;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        /* INFO: renamed from: getWidth, reason: from getter */
        public int get$width() {
            return this.width;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        /* INFO: renamed from: getHeight, reason: from getter */
        public int get$height() {
            return this.height;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public Map<AlignmentLine, Integer> getAlignmentLines() {
            return this.alignmentLines;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public void placeChildren() {
            MeasureScope measureScope = this.this$0;
            if (measureScope instanceof LookaheadCapablePlaceable) {
                this.$placementBlock.invoke(((LookaheadCapablePlaceable) measureScope).getPlacementScope());
            } else {
                this.$placementBlock.invoke(new SimplePlacementScope(this.$width, this.this$0.getLayoutDirection()));
            }
        }
    }

    default MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        return new AnonymousClass1(width, height, alignmentLines, this, placementBlock);
    }
}
