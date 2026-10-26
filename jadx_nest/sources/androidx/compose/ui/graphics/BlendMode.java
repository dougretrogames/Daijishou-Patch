package androidx.compose.ui.graphics;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* INFO: compiled from: BlendMode.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class BlendMode {
    private final int value;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Clear = m439constructorimpl(0);
    private static final int Src = m439constructorimpl(1);
    private static final int Dst = m439constructorimpl(2);
    private static final int SrcOver = m439constructorimpl(3);
    private static final int DstOver = m439constructorimpl(4);
    private static final int SrcIn = m439constructorimpl(5);
    private static final int DstIn = m439constructorimpl(6);
    private static final int SrcOut = m439constructorimpl(7);
    private static final int DstOut = m439constructorimpl(8);
    private static final int SrcAtop = m439constructorimpl(9);
    private static final int DstAtop = m439constructorimpl(10);
    private static final int Xor = m439constructorimpl(11);
    private static final int Plus = m439constructorimpl(12);
    private static final int Modulate = m439constructorimpl(13);
    private static final int Screen = m439constructorimpl(14);
    private static final int Overlay = m439constructorimpl(15);
    private static final int Darken = m439constructorimpl(16);
    private static final int Lighten = m439constructorimpl(17);
    private static final int ColorDodge = m439constructorimpl(18);
    private static final int ColorBurn = m439constructorimpl(19);
    private static final int Hardlight = m439constructorimpl(20);
    private static final int Softlight = m439constructorimpl(21);
    private static final int Difference = m439constructorimpl(22);
    private static final int Exclusion = m439constructorimpl(23);
    private static final int Multiply = m439constructorimpl(24);
    private static final int Hue = m439constructorimpl(25);
    private static final int Saturation = m439constructorimpl(26);
    private static final int Color = m439constructorimpl(27);
    private static final int Luminosity = m439constructorimpl(28);

    /* INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlendMode m438boximpl(int i) {
        return new BlendMode(i);
    }

    /* INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m439constructorimpl(int i) {
        return i;
    }

    /* INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m440equalsimpl(int i, Object obj) {
        return (obj instanceof BlendMode) && i == ((BlendMode) obj).getValue();
    }

    /* INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m441equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m442hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m440equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m442hashCodeimpl(this.value);
    }

    /* INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ BlendMode(int i) {
        this.value = i;
    }

    /* INFO: compiled from: BlendMode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u0019\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u0019\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006R\u0019\u0010\u001e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001f\u0010\u0006R\u0019\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u0019\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u0019\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u0019\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u0019\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006R\u0019\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u0019\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u0019\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b1\u0010\u0006R\u0019\u00102\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b3\u0010\u0006R\u0019\u00104\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b5\u0010\u0006R\u0019\u00106\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b7\u0010\u0006R\u0019\u00108\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b9\u0010\u0006R\u0019\u0010:\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b;\u0010\u0006R\u0019\u0010<\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b=\u0010\u0006R\u0019\u0010>\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b?\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode$Companion;", "", "()V", "Clear", "Landroidx/compose/ui/graphics/BlendMode;", "getClear-0nO6VwU", "()I", "I", "Color", "getColor-0nO6VwU", "ColorBurn", "getColorBurn-0nO6VwU", "ColorDodge", "getColorDodge-0nO6VwU", "Darken", "getDarken-0nO6VwU", "Difference", "getDifference-0nO6VwU", "Dst", "getDst-0nO6VwU", "DstAtop", "getDstAtop-0nO6VwU", "DstIn", "getDstIn-0nO6VwU", "DstOut", "getDstOut-0nO6VwU", "DstOver", "getDstOver-0nO6VwU", "Exclusion", "getExclusion-0nO6VwU", "Hardlight", "getHardlight-0nO6VwU", "Hue", "getHue-0nO6VwU", "Lighten", "getLighten-0nO6VwU", "Luminosity", "getLuminosity-0nO6VwU", "Modulate", "getModulate-0nO6VwU", "Multiply", "getMultiply-0nO6VwU", "Overlay", "getOverlay-0nO6VwU", "Plus", "getPlus-0nO6VwU", ExifInterface.TAG_SATURATION, "getSaturation-0nO6VwU", "Screen", "getScreen-0nO6VwU", "Softlight", "getSoftlight-0nO6VwU", "Src", "getSrc-0nO6VwU", "SrcAtop", "getSrcAtop-0nO6VwU", "SrcIn", "getSrcIn-0nO6VwU", "SrcOut", "getSrcOut-0nO6VwU", "SrcOver", "getSrcOver-0nO6VwU", "Xor", "getXor-0nO6VwU", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* INFO: renamed from: getClear-0nO6VwU, reason: not valid java name */
        public final int m445getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* INFO: renamed from: getSrc-0nO6VwU, reason: not valid java name */
        public final int m468getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* INFO: renamed from: getDst-0nO6VwU, reason: not valid java name */
        public final int m451getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* INFO: renamed from: getSrcOver-0nO6VwU, reason: not valid java name */
        public final int m472getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* INFO: renamed from: getDstOver-0nO6VwU, reason: not valid java name */
        public final int m455getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* INFO: renamed from: getSrcIn-0nO6VwU, reason: not valid java name */
        public final int m470getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* INFO: renamed from: getDstIn-0nO6VwU, reason: not valid java name */
        public final int m453getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* INFO: renamed from: getSrcOut-0nO6VwU, reason: not valid java name */
        public final int m471getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* INFO: renamed from: getDstOut-0nO6VwU, reason: not valid java name */
        public final int m454getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* INFO: renamed from: getSrcAtop-0nO6VwU, reason: not valid java name */
        public final int m469getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* INFO: renamed from: getDstAtop-0nO6VwU, reason: not valid java name */
        public final int m452getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* INFO: renamed from: getXor-0nO6VwU, reason: not valid java name */
        public final int m473getXor0nO6VwU() {
            return BlendMode.Xor;
        }

        /* INFO: renamed from: getPlus-0nO6VwU, reason: not valid java name */
        public final int m464getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* INFO: renamed from: getModulate-0nO6VwU, reason: not valid java name */
        public final int m461getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* INFO: renamed from: getScreen-0nO6VwU, reason: not valid java name */
        public final int m466getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* INFO: renamed from: getOverlay-0nO6VwU, reason: not valid java name */
        public final int m463getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* INFO: renamed from: getDarken-0nO6VwU, reason: not valid java name */
        public final int m449getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* INFO: renamed from: getLighten-0nO6VwU, reason: not valid java name */
        public final int m459getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* INFO: renamed from: getColorDodge-0nO6VwU, reason: not valid java name */
        public final int m448getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* INFO: renamed from: getColorBurn-0nO6VwU, reason: not valid java name */
        public final int m447getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* INFO: renamed from: getHardlight-0nO6VwU, reason: not valid java name */
        public final int m457getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* INFO: renamed from: getSoftlight-0nO6VwU, reason: not valid java name */
        public final int m467getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* INFO: renamed from: getDifference-0nO6VwU, reason: not valid java name */
        public final int m450getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* INFO: renamed from: getExclusion-0nO6VwU, reason: not valid java name */
        public final int m456getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* INFO: renamed from: getMultiply-0nO6VwU, reason: not valid java name */
        public final int m462getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* INFO: renamed from: getHue-0nO6VwU, reason: not valid java name */
        public final int m458getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* INFO: renamed from: getSaturation-0nO6VwU, reason: not valid java name */
        public final int m465getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* INFO: renamed from: getColor-0nO6VwU, reason: not valid java name */
        public final int m446getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* INFO: renamed from: getLuminosity-0nO6VwU, reason: not valid java name */
        public final int m460getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }
    }

    public String toString() {
        return m443toStringimpl(this.value);
    }

    /* INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m443toStringimpl(int i) {
        if (m441equalsimpl0(i, Clear)) {
            return "Clear";
        }
        if (m441equalsimpl0(i, Src)) {
            return "Src";
        }
        if (m441equalsimpl0(i, Dst)) {
            return "Dst";
        }
        if (m441equalsimpl0(i, SrcOver)) {
            return "SrcOver";
        }
        if (m441equalsimpl0(i, DstOver)) {
            return "DstOver";
        }
        if (m441equalsimpl0(i, SrcIn)) {
            return "SrcIn";
        }
        if (m441equalsimpl0(i, DstIn)) {
            return "DstIn";
        }
        if (m441equalsimpl0(i, SrcOut)) {
            return "SrcOut";
        }
        if (m441equalsimpl0(i, DstOut)) {
            return "DstOut";
        }
        if (m441equalsimpl0(i, SrcAtop)) {
            return "SrcAtop";
        }
        if (m441equalsimpl0(i, DstAtop)) {
            return "DstAtop";
        }
        if (m441equalsimpl0(i, Xor)) {
            return "Xor";
        }
        if (m441equalsimpl0(i, Plus)) {
            return "Plus";
        }
        if (m441equalsimpl0(i, Modulate)) {
            return "Modulate";
        }
        if (m441equalsimpl0(i, Screen)) {
            return "Screen";
        }
        if (m441equalsimpl0(i, Overlay)) {
            return "Overlay";
        }
        if (m441equalsimpl0(i, Darken)) {
            return "Darken";
        }
        if (m441equalsimpl0(i, Lighten)) {
            return "Lighten";
        }
        if (m441equalsimpl0(i, ColorDodge)) {
            return "ColorDodge";
        }
        if (m441equalsimpl0(i, ColorBurn)) {
            return "ColorBurn";
        }
        if (m441equalsimpl0(i, Hardlight)) {
            return "HardLight";
        }
        if (m441equalsimpl0(i, Softlight)) {
            return "Softlight";
        }
        if (m441equalsimpl0(i, Difference)) {
            return "Difference";
        }
        if (m441equalsimpl0(i, Exclusion)) {
            return "Exclusion";
        }
        if (m441equalsimpl0(i, Multiply)) {
            return "Multiply";
        }
        if (m441equalsimpl0(i, Hue)) {
            return "Hue";
        }
        if (m441equalsimpl0(i, Saturation)) {
            return ExifInterface.TAG_SATURATION;
        }
        if (m441equalsimpl0(i, Color)) {
            return "Color";
        }
        return m441equalsimpl0(i, Luminosity) ? "Luminosity" : "Unknown";
    }
}
