package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: Dp.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u0007H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u0016\u0010\u0012\u001a\u00020\u0007H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000bJ$\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001cH\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010'J\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001bJ\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001cH\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001dJ\u000f\u0010,\u001a\u00020-H\u0017¢\u0006\u0004\b.\u0010/R \u0010\u0006\u001a\u00020\u00078FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\tR \u0010\r\u001a\u00020\u00078FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, d2 = {"Landroidx/compose/ui/unit/DpSize;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM$annotations", "()V", "getHeight-D9Ej5fM", "(J)F", "getPackedValue$annotations", "width", "getWidth-D9Ej5fM$annotations", "getWidth-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "copy-DwJknco", "(JFF)J", "div", "other", "", "div-Gh9hcWk", "(JF)J", "", "(JI)J", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "minus", "minus-e_xh8Ic", "(JJ)J", "plus", "plus-e_xh8Ic", "times", "times-Gh9hcWk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class DpSize {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Unspecified = DpKt.m2906DpSizeYgX7TsA(Dp.INSTANCE.m2904getUnspecifiedD9Ej5fM(), Dp.INSTANCE.m2904getUnspecifiedD9Ej5fM());
    private static final long Zero;
    private final long packedValue;

    /* INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m2970boximpl(long j) {
        return new DpSize(j);
    }

    /* INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2973constructorimpl(long j) {
        return j;
    }

    /* INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2978equalsimpl(long j, Object obj) {
        return (obj instanceof DpSize) && j == ((DpSize) obj).getPackedValue();
    }

    /* INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2979equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* INFO: renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2981getHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* INFO: renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2983getWidthD9Ej5fM$annotations() {
    }

    /* INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2984hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2978equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2984hashCodeimpl(this.packedValue);
    }

    /* INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ DpSize(long j) {
        this.packedValue = j;
    }

    /* INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m2982getWidthD9Ej5fM(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("DpSize is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Dp.m2884constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m2980getHeightD9Ej5fM(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("DpSize is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Dp.m2884constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* INFO: renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m2974copyDwJknco(long j, float f, float f2) {
        return DpKt.m2906DpSizeYgX7TsA(f, f2);
    }

    /* INFO: renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m2975copyDwJknco$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2982getWidthD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m2980getHeightD9Ej5fM(j);
        }
        return m2974copyDwJknco(j, f, f2);
    }

    /* INFO: renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m2985minuse_xh8Ic(long j, long j2) {
        return DpKt.m2906DpSizeYgX7TsA(Dp.m2884constructorimpl(m2982getWidthD9Ej5fM(j) - m2982getWidthD9Ej5fM(j2)), Dp.m2884constructorimpl(m2980getHeightD9Ej5fM(j) - m2980getHeightD9Ej5fM(j2)));
    }

    /* INFO: renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m2986pluse_xh8Ic(long j, long j2) {
        return DpKt.m2906DpSizeYgX7TsA(Dp.m2884constructorimpl(m2982getWidthD9Ej5fM(j) + m2982getWidthD9Ej5fM(j2)), Dp.m2884constructorimpl(m2980getHeightD9Ej5fM(j) + m2980getHeightD9Ej5fM(j2)));
    }

    /* INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m2971component1D9Ej5fM(long j) {
        return m2982getWidthD9Ej5fM(j);
    }

    /* INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m2972component2D9Ej5fM(long j) {
        return m2980getHeightD9Ej5fM(j);
    }

    /* INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m2988timesGh9hcWk(long j, int i) {
        float f = i;
        return DpKt.m2906DpSizeYgX7TsA(Dp.m2884constructorimpl(m2982getWidthD9Ej5fM(j) * f), Dp.m2884constructorimpl(m2980getHeightD9Ej5fM(j) * f));
    }

    /* INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m2987timesGh9hcWk(long j, float f) {
        return DpKt.m2906DpSizeYgX7TsA(Dp.m2884constructorimpl(m2982getWidthD9Ej5fM(j) * f), Dp.m2884constructorimpl(m2980getHeightD9Ej5fM(j) * f));
    }

    /* INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m2977divGh9hcWk(long j, int i) {
        float f = i;
        return DpKt.m2906DpSizeYgX7TsA(Dp.m2884constructorimpl(m2982getWidthD9Ej5fM(j) / f), Dp.m2884constructorimpl(m2980getHeightD9Ej5fM(j) / f));
    }

    /* INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m2976divGh9hcWk(long j, float f) {
        return DpKt.m2906DpSizeYgX7TsA(Dp.m2884constructorimpl(m2982getWidthD9Ej5fM(j) / f), Dp.m2884constructorimpl(m2980getHeightD9Ej5fM(j) / f));
    }

    public String toString() {
        return m2989toStringimpl(this.packedValue);
    }

    /* INFO: compiled from: Dp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/DpSize$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpSize;", "getUnspecified-MYxV2XQ", "()J", "J", "Zero", "getZero-MYxV2XQ", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* INFO: renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m2992getZeroMYxV2XQ() {
            return DpSize.Zero;
        }

        /* INFO: renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m2991getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }
    }

    /* INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2989toStringimpl(long j) {
        if (j != INSTANCE.m2991getUnspecifiedMYxV2XQ()) {
            return ((Object) Dp.m2895toStringimpl(m2982getWidthD9Ej5fM(j))) + " x " + ((Object) Dp.m2895toStringimpl(m2980getHeightD9Ej5fM(j)));
        }
        return "DpSize.Unspecified";
    }

    static {
        float f = 0;
        Zero = DpKt.m2906DpSizeYgX7TsA(Dp.m2884constructorimpl(f), Dp.m2884constructorimpl(f));
    }
}
