package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* INFO: compiled from: SemanticsProperties.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/semantics/Role;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Role {
    private final int value;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Button = m2205constructorimpl(0);
    private static final int Checkbox = m2205constructorimpl(1);
    private static final int Switch = m2205constructorimpl(2);
    private static final int RadioButton = m2205constructorimpl(3);
    private static final int Tab = m2205constructorimpl(4);
    private static final int Image = m2205constructorimpl(5);
    private static final int DropdownList = m2205constructorimpl(6);

    /* INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Role m2204boximpl(int i) {
        return new Role(i);
    }

    /* INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2205constructorimpl(int i) {
        return i;
    }

    /* INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2206equalsimpl(int i, Object obj) {
        return (obj instanceof Role) && i == ((Role) obj).getValue();
    }

    /* INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2207equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2208hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2206equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2208hashCodeimpl(this.value);
    }

    /* INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* INFO: compiled from: SemanticsProperties.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/semantics/Role$Companion;", "", "()V", "Button", "Landroidx/compose/ui/semantics/Role;", "getButton-o7Vup1c", "()I", "I", "Checkbox", "getCheckbox-o7Vup1c", "DropdownList", "getDropdownList-o7Vup1c", "Image", "getImage-o7Vup1c", "RadioButton", "getRadioButton-o7Vup1c", "Switch", "getSwitch-o7Vup1c", "Tab", "getTab-o7Vup1c", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* INFO: renamed from: getButton-o7Vup1c, reason: not valid java name */
        public final int m2211getButtono7Vup1c() {
            return Role.Button;
        }

        /* INFO: renamed from: getCheckbox-o7Vup1c, reason: not valid java name */
        public final int m2212getCheckboxo7Vup1c() {
            return Role.Checkbox;
        }

        /* INFO: renamed from: getSwitch-o7Vup1c, reason: not valid java name */
        public final int m2216getSwitcho7Vup1c() {
            return Role.Switch;
        }

        /* INFO: renamed from: getRadioButton-o7Vup1c, reason: not valid java name */
        public final int m2215getRadioButtono7Vup1c() {
            return Role.RadioButton;
        }

        /* INFO: renamed from: getTab-o7Vup1c, reason: not valid java name */
        public final int m2217getTabo7Vup1c() {
            return Role.Tab;
        }

        /* INFO: renamed from: getImage-o7Vup1c, reason: not valid java name */
        public final int m2214getImageo7Vup1c() {
            return Role.Image;
        }

        /* INFO: renamed from: getDropdownList-o7Vup1c, reason: not valid java name */
        public final int m2213getDropdownListo7Vup1c() {
            return Role.DropdownList;
        }
    }

    private /* synthetic */ Role(int i) {
        this.value = i;
    }

    public String toString() {
        return m2209toStringimpl(this.value);
    }

    /* INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2209toStringimpl(int i) {
        if (m2207equalsimpl0(i, Button)) {
            return "Button";
        }
        if (m2207equalsimpl0(i, Checkbox)) {
            return "Checkbox";
        }
        if (m2207equalsimpl0(i, Switch)) {
            return "Switch";
        }
        if (m2207equalsimpl0(i, RadioButton)) {
            return "RadioButton";
        }
        if (m2207equalsimpl0(i, Tab)) {
            return "Tab";
        }
        if (m2207equalsimpl0(i, Image)) {
            return "Image";
        }
        return m2207equalsimpl0(i, DropdownList) ? "DropdownList" : "Unknown";
    }
}
