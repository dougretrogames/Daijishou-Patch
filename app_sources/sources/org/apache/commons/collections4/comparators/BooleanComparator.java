package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;

/* INFO: loaded from: classes5.dex */
public final class BooleanComparator implements Comparator<Boolean>, Serializable {
    private static final long serialVersionUID = 1830042991606340609L;
    private final boolean trueFirst;
    private static final BooleanComparator TRUE_FIRST = new BooleanComparator(true);
    private static final BooleanComparator FALSE_FIRST = new BooleanComparator(false);

    public static BooleanComparator booleanComparator(boolean z) {
        return z ? TRUE_FIRST : FALSE_FIRST;
    }

    public static BooleanComparator getFalseFirstComparator() {
        return FALSE_FIRST;
    }

    public static BooleanComparator getTrueFirstComparator() {
        return TRUE_FIRST;
    }

    public BooleanComparator() {
        this(false);
    }

    public BooleanComparator(boolean z) {
        this.trueFirst = z;
    }

    @Override // java.util.Comparator
    public int compare(Boolean bool, Boolean bool2) {
        boolean zBooleanValue = bool.booleanValue();
        if (bool2.booleanValue() ^ zBooleanValue) {
            return zBooleanValue ^ this.trueFirst ? 1 : -1;
        }
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof BooleanComparator) && this.trueFirst == ((BooleanComparator) obj).trueFirst;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = "BooleanComparator".hashCode();
        return this.trueFirst ? iHashCode * (-1) : iHashCode;
    }

    public boolean sortsTrueFirst() {
        return this.trueFirst;
    }
}
