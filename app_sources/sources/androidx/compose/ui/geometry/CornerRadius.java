package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: CornerRadius.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 12\u00020\u0001:\u00011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0013\u0010\fJ'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b(\u0010&J\u001e\u0010)\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u001aJ\u000f\u0010+\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u0016\u0010/\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Landroidx/compose/ui/geometry/CornerRadius;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "copy-OHQCggk", "(JFF)J", "div", "operand", "div-Bz7bX_o", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-vF7b-mM", "(JJ)J", "plus", "plus-vF7b-mM", "times", "times-Bz7bX_o", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-kKHJgLs", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class CornerRadius {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = CornerRadiusKt.CornerRadius$default(0.0f, 0.0f, 2, null);
    private final long packedValue;

    /* INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CornerRadius m255boximpl(long j) {
        return new CornerRadius(j);
    }

    /* INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m258constructorimpl(long j) {
        return j;
    }

    /* INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m262equalsimpl(long j, Object obj) {
        return (obj instanceof CornerRadius) && j == ((CornerRadius) obj).getPackedValue();
    }

    /* INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m263equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m266hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m262equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m266hashCodeimpl(this.packedValue);
    }

    /* INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ CornerRadius(long j) {
        this.packedValue = j;
    }

    /* INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m256component1impl(long j) {
        return m264getXimpl(j);
    }

    /* INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m257component2impl(long j) {
        return m265getYimpl(j);
    }

    /* INFO: renamed from: copy-OHQCggk, reason: not valid java name */
    public static final long m259copyOHQCggk(long j, float f, float f2) {
        return CornerRadiusKt.CornerRadius(f, f2);
    }

    /* INFO: renamed from: copy-OHQCggk$default, reason: not valid java name */
    public static /* synthetic */ long m260copyOHQCggk$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m264getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m265getYimpl(j);
        }
        return m259copyOHQCggk(j, f, f2);
    }

    /* INFO: compiled from: CornerRadius.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Landroidx/compose/ui/geometry/CornerRadius$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/CornerRadius;", "getZero-kKHJgLs$annotations", "getZero-kKHJgLs", "()J", "J", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* INFO: renamed from: getZero-kKHJgLs$annotations, reason: not valid java name */
        public static /* synthetic */ void m273getZerokKHJgLs$annotations() {
        }

        private Companion() {
        }

        /* INFO: renamed from: getZero-kKHJgLs, reason: not valid java name */
        public final long m274getZerokKHJgLs() {
            return CornerRadius.Zero;
        }
    }

    /* INFO: renamed from: unaryMinus-kKHJgLs, reason: not valid java name */
    public static final long m271unaryMinuskKHJgLs(long j) {
        return CornerRadiusKt.CornerRadius(-m264getXimpl(j), -m265getYimpl(j));
    }

    /* INFO: renamed from: minus-vF7b-mM, reason: not valid java name */
    public static final long m267minusvF7bmM(long j, long j2) {
        return CornerRadiusKt.CornerRadius(m264getXimpl(j) - m264getXimpl(j2), m265getYimpl(j) - m265getYimpl(j2));
    }

    /* INFO: renamed from: plus-vF7b-mM, reason: not valid java name */
    public static final long m268plusvF7bmM(long j, long j2) {
        return CornerRadiusKt.CornerRadius(m264getXimpl(j) + m264getXimpl(j2), m265getYimpl(j) + m265getYimpl(j2));
    }

    /* INFO: renamed from: times-Bz7bX_o, reason: not valid java name */
    public static final long m269timesBz7bX_o(long j, float f) {
        return CornerRadiusKt.CornerRadius(m264getXimpl(j) * f, m265getYimpl(j) * f);
    }

    /* INFO: renamed from: div-Bz7bX_o, reason: not valid java name */
    public static final long m261divBz7bX_o(long j, float f) {
        return CornerRadiusKt.CornerRadius(m264getXimpl(j) / f, m265getYimpl(j) / f);
    }

    public String toString() {
        return m270toStringimpl(this.packedValue);
    }

    /* INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m270toStringimpl(long j) {
        if (m264getXimpl(j) == m265getYimpl(j)) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(m264getXimpl(j), 1) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(m264getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m265getYimpl(j), 1) + ')';
    }

    /* INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m264getXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m265getYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
