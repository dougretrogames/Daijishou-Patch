package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* INFO: loaded from: classes5.dex */
public final class TruePredicate<T> extends AbstractPredicate<T> implements Serializable {
    public static final Predicate INSTANCE = new TruePredicate();
    private static final long serialVersionUID = 3374767158756189740L;

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        return true;
    }

    public static <T> Predicate<T> truePredicate() {
        return INSTANCE;
    }

    private TruePredicate() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
