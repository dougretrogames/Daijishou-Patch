package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public class ComparatorPredicate<T> extends AbstractPredicate<T> implements Serializable {
    private static final long serialVersionUID = -1863209236504077399L;
    private final Comparator<T> comparator;
    private final Criterion criterion;
    private final T object;

    public enum Criterion {
        EQUAL,
        GREATER,
        LESS,
        GREATER_OR_EQUAL,
        LESS_OR_EQUAL
    }

    public static <T> Predicate<T> comparatorPredicate(T t, Comparator<T> comparator) {
        return comparatorPredicate(t, comparator, Criterion.EQUAL);
    }

    public static <T> Predicate<T> comparatorPredicate(T t, Comparator<T> comparator, Criterion criterion) {
        return new ComparatorPredicate(t, (Comparator) Objects.requireNonNull(comparator, "comparator"), (Criterion) Objects.requireNonNull(criterion, "criterion"));
    }

    public ComparatorPredicate(T t, Comparator<T> comparator, Criterion criterion) {
        this.object = t;
        this.comparator = comparator;
        this.criterion = criterion;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        int iCompare = this.comparator.compare(this.object, t);
        int iOrdinal = this.criterion.ordinal();
        if (iOrdinal == 0) {
            return iCompare == 0;
        }
        if (iOrdinal == 1) {
            return iCompare > 0;
        }
        if (iOrdinal == 2) {
            return iCompare < 0;
        }
        if (iOrdinal == 3) {
            return iCompare >= 0;
        }
        if (iOrdinal == 4) {
            return iCompare <= 0;
        }
        throw new IllegalStateException("The current criterion '" + this.criterion + "' is invalid.");
    }
}
