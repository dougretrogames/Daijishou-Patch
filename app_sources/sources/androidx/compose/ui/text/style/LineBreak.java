package androidx.compose.ui.text.style;

import androidx.webkit.Profile;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: LineBreak.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u001e2\u00020\u0001:\u0004\u001e\u001f !B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00078Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f\u0088\u0001\n\u0092\u0001\u00020\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/style/LineBreak;", "", "strategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "strictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "wordBreak", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "constructor-impl", "(III)I", "mask", "", "(I)I", "getStrategy-fcGXIks", "getStrictness-usljTpc", "getWordBreak-jp8hJ3c", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "copy-gijOMQM", "(IIII)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class LineBreak {
    private final int mask;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Simple = m2690constructorimpl(LineBreak_androidKt.packBytes(Strategy.INSTANCE.m2719getSimplefcGXIks(), Strictness.INSTANCE.m2730getNormalusljTpc(), WordBreak.INSTANCE.m2740getDefaultjp8hJ3c()));
    private static final int Heading = m2690constructorimpl(LineBreak_androidKt.packBytes(Strategy.INSTANCE.m2717getBalancedfcGXIks(), Strictness.INSTANCE.m2729getLooseusljTpc(), WordBreak.INSTANCE.m2741getPhrasejp8hJ3c()));
    private static final int Paragraph = m2690constructorimpl(LineBreak_androidKt.packBytes(Strategy.INSTANCE.m2718getHighQualityfcGXIks(), Strictness.INSTANCE.m2731getStrictusljTpc(), WordBreak.INSTANCE.m2740getDefaultjp8hJ3c()));
    private static final int Unspecified = m2690constructorimpl(0);

    /* INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineBreak m2689boximpl(int i) {
        return new LineBreak(i);
    }

    /* INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2690constructorimpl(int i) {
        return i;
    }

    /* INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2694equalsimpl(int i, Object obj) {
        return (obj instanceof LineBreak) && i == ((LineBreak) obj).getMask();
    }

    /* INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2695equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2699hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2694equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m2699hashCodeimpl(this.mask);
    }

    /* INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMask() {
        return this.mask;
    }

    private /* synthetic */ LineBreak(int i) {
        this.mask = i;
    }

    /* INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2691constructorimpl(int i, int i2, int i3) {
        return m2690constructorimpl(LineBreak_androidKt.packBytes(i, i2, i3));
    }

    /* INFO: renamed from: getStrategy-fcGXIks, reason: not valid java name */
    public static final int m2696getStrategyfcGXIks(int i) {
        return Strategy.m2711constructorimpl(LineBreak_androidKt.unpackByte1(i));
    }

    /* INFO: renamed from: getStrictness-usljTpc, reason: not valid java name */
    public static final int m2697getStrictnessusljTpc(int i) {
        return Strictness.m2722constructorimpl(LineBreak_androidKt.unpackByte2(i));
    }

    /* INFO: renamed from: getWordBreak-jp8hJ3c, reason: not valid java name */
    public static final int m2698getWordBreakjp8hJ3c(int i) {
        return WordBreak.m2734constructorimpl(LineBreak_androidKt.unpackByte3(i));
    }

    /* INFO: renamed from: copy-gijOMQM$default, reason: not valid java name */
    public static /* synthetic */ int m2693copygijOMQM$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = m2696getStrategyfcGXIks(i);
        }
        if ((i5 & 2) != 0) {
            i3 = m2697getStrictnessusljTpc(i);
        }
        if ((i5 & 4) != 0) {
            i4 = m2698getWordBreakjp8hJ3c(i);
        }
        return m2692copygijOMQM(i, i2, i3, i4);
    }

    /* INFO: renamed from: copy-gijOMQM, reason: not valid java name */
    public static final int m2692copygijOMQM(int i, int i2, int i3, int i4) {
        return m2691constructorimpl(i2, i3, i4);
    }

    public String toString() {
        return m2700toStringimpl(this.mask);
    }

    /* INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2700toStringimpl(int i) {
        return "LineBreak(strategy=" + ((Object) Strategy.m2715toStringimpl(m2696getStrategyfcGXIks(i))) + ", strictness=" + ((Object) Strictness.m2726toStringimpl(m2697getStrictnessusljTpc(i))) + ", wordBreak=" + ((Object) WordBreak.m2738toStringimpl(m2698getWordBreakjp8hJ3c(i))) + ')';
    }

    /* INFO: compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Companion;", "", "()V", "Heading", "Landroidx/compose/ui/text/style/LineBreak;", "getHeading-rAG3T2k$annotations", "getHeading-rAG3T2k", "()I", "I", "Paragraph", "getParagraph-rAG3T2k$annotations", "getParagraph-rAG3T2k", "Simple", "getSimple-rAG3T2k$annotations", "getSimple-rAG3T2k", "Unspecified", "getUnspecified-rAG3T2k$annotations", "getUnspecified-rAG3T2k", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* INFO: renamed from: getHeading-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m2702getHeadingrAG3T2k$annotations() {
        }

        /* INFO: renamed from: getParagraph-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m2703getParagraphrAG3T2k$annotations() {
        }

        /* INFO: renamed from: getSimple-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m2704getSimplerAG3T2k$annotations() {
        }

        /* INFO: renamed from: getUnspecified-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m2705getUnspecifiedrAG3T2k$annotations() {
        }

        private Companion() {
        }

        /* INFO: renamed from: getSimple-rAG3T2k, reason: not valid java name */
        public final int m2708getSimplerAG3T2k() {
            return LineBreak.Simple;
        }

        /* INFO: renamed from: getHeading-rAG3T2k, reason: not valid java name */
        public final int m2706getHeadingrAG3T2k() {
            return LineBreak.Heading;
        }

        /* INFO: renamed from: getParagraph-rAG3T2k, reason: not valid java name */
        public final int m2707getParagraphrAG3T2k() {
            return LineBreak.Paragraph;
        }

        /* INFO: renamed from: getUnspecified-rAG3T2k, reason: not valid java name */
        public final int m2709getUnspecifiedrAG3T2k() {
            return LineBreak.Unspecified;
        }
    }

    /* INFO: compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Strategy {
        private final int value;

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Simple = m2711constructorimpl(1);
        private static final int HighQuality = m2711constructorimpl(2);
        private static final int Balanced = m2711constructorimpl(3);
        private static final int Unspecified = m2711constructorimpl(0);

        /* INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strategy m2710boximpl(int i) {
            return new Strategy(i);
        }

        /* INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m2711constructorimpl(int i) {
            return i;
        }

        /* INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m2712equalsimpl(int i, Object obj) {
            return (obj instanceof Strategy) && i == ((Strategy) obj).getValue();
        }

        /* INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2713equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m2714hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m2712equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m2714hashCodeimpl(this.value);
        }

        /* INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* INFO: compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy$Companion;", "", "()V", "Balanced", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "getBalanced-fcGXIks", "()I", "I", "HighQuality", "getHighQuality-fcGXIks", "Simple", "getSimple-fcGXIks", "Unspecified", "getUnspecified-fcGXIks", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* INFO: renamed from: getSimple-fcGXIks, reason: not valid java name */
            public final int m2719getSimplefcGXIks() {
                return Strategy.Simple;
            }

            /* INFO: renamed from: getHighQuality-fcGXIks, reason: not valid java name */
            public final int m2718getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* INFO: renamed from: getBalanced-fcGXIks, reason: not valid java name */
            public final int m2717getBalancedfcGXIks() {
                return Strategy.Balanced;
            }

            /* INFO: renamed from: getUnspecified-fcGXIks, reason: not valid java name */
            public final int m2720getUnspecifiedfcGXIks() {
                return Strategy.Unspecified;
            }
        }

        private /* synthetic */ Strategy(int i) {
            this.value = i;
        }

        public String toString() {
            return m2715toStringimpl(this.value);
        }

        /* INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2715toStringimpl(int i) {
            if (m2713equalsimpl0(i, Simple)) {
                return "Strategy.Simple";
            }
            if (m2713equalsimpl0(i, HighQuality)) {
                return "Strategy.HighQuality";
            }
            if (m2713equalsimpl0(i, Balanced)) {
                return "Strategy.Balanced";
            }
            return m2713equalsimpl0(i, Unspecified) ? "Strategy.Unspecified" : "Invalid";
        }
    }

    /* INFO: compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Strictness {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Default = m2722constructorimpl(1);
        private static final int Loose = m2722constructorimpl(2);
        private static final int Normal = m2722constructorimpl(3);
        private static final int Strict = m2722constructorimpl(4);
        private static final int Unspecified = m2722constructorimpl(0);
        private final int value;

        /* INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strictness m2721boximpl(int i) {
            return new Strictness(i);
        }

        /* INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m2722constructorimpl(int i) {
            return i;
        }

        /* INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m2723equalsimpl(int i, Object obj) {
            return (obj instanceof Strictness) && i == ((Strictness) obj).getValue();
        }

        /* INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2724equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m2725hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m2723equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m2725hashCodeimpl(this.value);
        }

        /* INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* INFO: compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness$Companion;", "", "()V", Profile.DEFAULT_PROFILE_NAME, "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "getDefault-usljTpc", "()I", "I", "Loose", "getLoose-usljTpc", "Normal", "getNormal-usljTpc", "Strict", "getStrict-usljTpc", "Unspecified", "getUnspecified-usljTpc", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* INFO: renamed from: getDefault-usljTpc, reason: not valid java name */
            public final int m2728getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* INFO: renamed from: getLoose-usljTpc, reason: not valid java name */
            public final int m2729getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* INFO: renamed from: getNormal-usljTpc, reason: not valid java name */
            public final int m2730getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* INFO: renamed from: getStrict-usljTpc, reason: not valid java name */
            public final int m2731getStrictusljTpc() {
                return Strictness.Strict;
            }

            /* INFO: renamed from: getUnspecified-usljTpc, reason: not valid java name */
            public final int m2732getUnspecifiedusljTpc() {
                return Strictness.Unspecified;
            }
        }

        private /* synthetic */ Strictness(int i) {
            this.value = i;
        }

        public String toString() {
            return m2726toStringimpl(this.value);
        }

        /* INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2726toStringimpl(int i) {
            if (m2724equalsimpl0(i, Default)) {
                return "Strictness.None";
            }
            if (m2724equalsimpl0(i, Loose)) {
                return "Strictness.Loose";
            }
            if (m2724equalsimpl0(i, Normal)) {
                return "Strictness.Normal";
            }
            if (m2724equalsimpl0(i, Strict)) {
                return "Strictness.Strict";
            }
            return m2724equalsimpl0(i, Unspecified) ? "Strictness.Unspecified" : "Invalid";
        }
    }

    /* INFO: compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class WordBreak {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Default = m2734constructorimpl(1);
        private static final int Phrase = m2734constructorimpl(2);
        private static final int Unspecified = m2734constructorimpl(0);
        private final int value;

        /* INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ WordBreak m2733boximpl(int i) {
            return new WordBreak(i);
        }

        /* INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m2734constructorimpl(int i) {
            return i;
        }

        /* INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m2735equalsimpl(int i, Object obj) {
            return (obj instanceof WordBreak) && i == ((WordBreak) obj).getValue();
        }

        /* INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2736equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m2737hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m2735equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m2737hashCodeimpl(this.value);
        }

        /* INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* INFO: compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak$Companion;", "", "()V", Profile.DEFAULT_PROFILE_NAME, "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "getDefault-jp8hJ3c", "()I", "I", "Phrase", "getPhrase-jp8hJ3c", "Unspecified", "getUnspecified-jp8hJ3c", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* INFO: renamed from: getDefault-jp8hJ3c, reason: not valid java name */
            public final int m2740getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* INFO: renamed from: getPhrase-jp8hJ3c, reason: not valid java name */
            public final int m2741getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }

            /* INFO: renamed from: getUnspecified-jp8hJ3c, reason: not valid java name */
            public final int m2742getUnspecifiedjp8hJ3c() {
                return WordBreak.Unspecified;
            }
        }

        private /* synthetic */ WordBreak(int i) {
            this.value = i;
        }

        public String toString() {
            return m2738toStringimpl(this.value);
        }

        /* INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2738toStringimpl(int i) {
            if (m2736equalsimpl0(i, Default)) {
                return "WordBreak.None";
            }
            if (m2736equalsimpl0(i, Phrase)) {
                return "WordBreak.Phrase";
            }
            return m2736equalsimpl0(i, Unspecified) ? "WordBreak.Unspecified" : "Invalid";
        }
    }
}
