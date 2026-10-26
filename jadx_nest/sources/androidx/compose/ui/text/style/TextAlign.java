package androidx.compose.ui.text.style;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* INFO: compiled from: TextAlign.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextAlign;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class TextAlign {
    private final int value;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Left = m2770constructorimpl(1);
    private static final int Right = m2770constructorimpl(2);
    private static final int Center = m2770constructorimpl(3);
    private static final int Justify = m2770constructorimpl(4);
    private static final int Start = m2770constructorimpl(5);
    private static final int End = m2770constructorimpl(6);
    private static final int Unspecified = m2770constructorimpl(Integer.MIN_VALUE);

    /* INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m2769boximpl(int i) {
        return new TextAlign(i);
    }

    /* INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2770constructorimpl(int i) {
        return i;
    }

    /* INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2771equalsimpl(int i, Object obj) {
        return (obj instanceof TextAlign) && i == ((TextAlign) obj).getValue();
    }

    /* INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2772equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2773hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2771equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2773hashCodeimpl(this.value);
    }

    /* INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ TextAlign(int i) {
        this.value = i;
    }

    public String toString() {
        return m2774toStringimpl(this.value);
    }

    /* INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2774toStringimpl(int i) {
        if (m2772equalsimpl0(i, Left)) {
            return "Left";
        }
        if (m2772equalsimpl0(i, Right)) {
            return "Right";
        }
        if (m2772equalsimpl0(i, Center)) {
            return "Center";
        }
        if (m2772equalsimpl0(i, Justify)) {
            return "Justify";
        }
        if (m2772equalsimpl0(i, Start)) {
            return "Start";
        }
        if (m2772equalsimpl0(i, End)) {
            return "End";
        }
        return m2772equalsimpl0(i, Unspecified) ? "Unspecified" : "Invalid";
    }

    /* INFO: compiled from: TextAlign.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/style/TextAlign$Companion;", "", "()V", "Center", "Landroidx/compose/ui/text/style/TextAlign;", "getCenter-e0LSkKk", "()I", "I", "End", "getEnd-e0LSkKk", "Justify", "getJustify-e0LSkKk", "Left", "getLeft-e0LSkKk", "Right", "getRight-e0LSkKk", "Start", "getStart-e0LSkKk", "Unspecified", "getUnspecified-e0LSkKk", "values", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* INFO: renamed from: getLeft-e0LSkKk, reason: not valid java name */
        public final int m2779getLefte0LSkKk() {
            return TextAlign.Left;
        }

        /* INFO: renamed from: getRight-e0LSkKk, reason: not valid java name */
        public final int m2780getRighte0LSkKk() {
            return TextAlign.Right;
        }

        /* INFO: renamed from: getCenter-e0LSkKk, reason: not valid java name */
        public final int m2776getCentere0LSkKk() {
            return TextAlign.Center;
        }

        /* INFO: renamed from: getJustify-e0LSkKk, reason: not valid java name */
        public final int m2778getJustifye0LSkKk() {
            return TextAlign.Justify;
        }

        /* INFO: renamed from: getStart-e0LSkKk, reason: not valid java name */
        public final int m2781getStarte0LSkKk() {
            return TextAlign.Start;
        }

        /* INFO: renamed from: getEnd-e0LSkKk, reason: not valid java name */
        public final int m2777getEnde0LSkKk() {
            return TextAlign.End;
        }

        public final List<TextAlign> values() {
            return CollectionsKt.listOf((Object[]) new TextAlign[]{TextAlign.m2769boximpl(m2779getLefte0LSkKk()), TextAlign.m2769boximpl(m2780getRighte0LSkKk()), TextAlign.m2769boximpl(m2776getCentere0LSkKk()), TextAlign.m2769boximpl(m2778getJustifye0LSkKk()), TextAlign.m2769boximpl(m2781getStarte0LSkKk()), TextAlign.m2769boximpl(m2777getEnde0LSkKk())});
        }

        /* INFO: renamed from: getUnspecified-e0LSkKk, reason: not valid java name */
        public final int m2782getUnspecifiede0LSkKk() {
            return TextAlign.Unspecified;
        }
    }
}
