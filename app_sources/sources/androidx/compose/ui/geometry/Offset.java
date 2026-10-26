package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: Offset.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 92\u00020\u0001:\u00019B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b \u0010\u000bJ\u000f\u0010!\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010\u000bJ\u0010\u0010#\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001bH\u0007¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b.\u0010,J\u001e\u0010/\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010\u0019J\u001e\u00101\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u0019J\u000f\u00103\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0016\u00107\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "copy-dBAh8RU", "(JFF)J", "div", "operand", "div-tuRUvjQ", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "getDistance", "getDistance-impl", "getDistanceSquared", "getDistanceSquared-impl", "hashCode", "", "hashCode-impl", "(J)I", "isValid", "isValid-impl", "(J)Z", "minus", "minus-MK-Hz9U", "(JJ)J", "plus", "plus-MK-Hz9U", "rem", "rem-tuRUvjQ", "times", "times-tuRUvjQ", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-F1C5BW0", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Offset {
    private final long packedValue;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    private static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);

    /* INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m278boximpl(long j) {
        return new Offset(j);
    }

    /* INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m281constructorimpl(long j) {
        return j;
    }

    /* INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m285equalsimpl(long j, Object obj) {
        return (obj instanceof Offset) && j == ((Offset) obj).getPackedValue();
    }

    /* INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m286equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m291hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m285equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m291hashCodeimpl(this.packedValue);
    }

    /* INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ Offset(long j) {
        this.packedValue = j;
    }

    /* INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m289getXimpl(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m290getYimpl(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m279component1impl(long j) {
        return m289getXimpl(j);
    }

    /* INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m280component2impl(long j) {
        return m290getYimpl(j);
    }

    /* INFO: renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m282copydBAh8RU(long j, float f, float f2) {
        return OffsetKt.Offset(f, f2);
    }

    /* INFO: renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m283copydBAh8RU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m289getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m290getYimpl(j);
        }
        return m282copydBAh8RU(j, f, f2);
    }

    /* INFO: compiled from: Offset.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/geometry/Offset$Companion;", "", "()V", "Infinite", "Landroidx/compose/ui/geometry/Offset;", "getInfinite-F1C5BW0$annotations", "getInfinite-F1C5BW0", "()J", "J", "Unspecified", "getUnspecified-F1C5BW0$annotations", "getUnspecified-F1C5BW0", "Zero", "getZero-F1C5BW0$annotations", "getZero-F1C5BW0", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* INFO: renamed from: getInfinite-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m300getInfiniteF1C5BW0$annotations() {
        }

        /* INFO: renamed from: getUnspecified-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m301getUnspecifiedF1C5BW0$annotations() {
        }

        /* INFO: renamed from: getZero-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m302getZeroF1C5BW0$annotations() {
        }

        private Companion() {
        }

        /* INFO: renamed from: getZero-F1C5BW0, reason: not valid java name */
        public final long m305getZeroF1C5BW0() {
            return Offset.Zero;
        }

        /* INFO: renamed from: getInfinite-F1C5BW0, reason: not valid java name */
        public final long m303getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* INFO: renamed from: getUnspecified-F1C5BW0, reason: not valid java name */
        public final long m304getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }
    }

    /* INFO: renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m292isValidimpl(long j) {
        if (Float.isNaN(m289getXimpl(j)) || Float.isNaN(m290getYimpl(j))) {
            throw new IllegalStateException("Offset argument contained a NaN value.".toString());
        }
        return true;
    }

    /* INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m287getDistanceimpl(long j) {
        return (float) Math.sqrt((m289getXimpl(j) * m289getXimpl(j)) + (m290getYimpl(j) * m290getYimpl(j)));
    }

    /* INFO: renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m288getDistanceSquaredimpl(long j) {
        return (m289getXimpl(j) * m289getXimpl(j)) + (m290getYimpl(j) * m290getYimpl(j));
    }

    /* INFO: renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m298unaryMinusF1C5BW0(long j) {
        return OffsetKt.Offset(-m289getXimpl(j), -m290getYimpl(j));
    }

    /* INFO: renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m293minusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m289getXimpl(j) - m289getXimpl(j2), m290getYimpl(j) - m290getYimpl(j2));
    }

    /* INFO: renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m294plusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m289getXimpl(j) + m289getXimpl(j2), m290getYimpl(j) + m290getYimpl(j2));
    }

    /* INFO: renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m296timestuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m289getXimpl(j) * f, m290getYimpl(j) * f);
    }

    /* INFO: renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m284divtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m289getXimpl(j) / f, m290getYimpl(j) / f);
    }

    /* INFO: renamed from: rem-tuRUvjQ, reason: not valid java name */
    public static final long m295remtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m289getXimpl(j) % f, m290getYimpl(j) % f);
    }

    /* INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m297toStringimpl(long j) {
        if (OffsetKt.m308isSpecifiedk4lQ0M(j)) {
            return "Offset(" + GeometryUtilsKt.toStringAsFixed(m289getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m290getYimpl(j), 1) + ')';
        }
        return "Offset.Unspecified";
    }

    public String toString() {
        return m297toStringimpl(this.packedValue);
    }
}
