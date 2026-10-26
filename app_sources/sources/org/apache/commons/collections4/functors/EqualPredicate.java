package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.Predicate;

/* INFO: loaded from: classes5.dex */
public final class EqualPredicate<T> extends AbstractPredicate<T> implements Serializable {
    private static final long serialVersionUID = 5633766978029907089L;
    private final Equator<T> equator;
    private final T test;

    public static <T> Predicate<T> equalPredicate(T t) {
        if (t == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t);
    }

    public static <T> Predicate<T> equalPredicate(T t, Equator<T> equator) {
        if (t == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t, equator);
    }

    public EqualPredicate(T t) {
        this(t, null);
    }

    public EqualPredicate(T t, Equator<T> equator) {
        this.test = t;
        this.equator = equator;
    }

    public Object getValue() {
        return this.test;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        Equator<T> equator = this.equator;
        if (equator != null) {
            return equator.equate(this.test, t);
        }
        return Objects.equals(this.test, t);
    }
}
