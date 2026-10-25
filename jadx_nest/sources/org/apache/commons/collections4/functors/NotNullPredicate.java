package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public final class NotNullPredicate<T> extends AbstractPredicate<T> implements Serializable {
    public static final Predicate INSTANCE = new NotNullPredicate();
    private static final long serialVersionUID = 7533784454832764388L;

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        return t != null;
    }

    public static <T> Predicate<T> notNullPredicate() {
        return INSTANCE;
    }

    private NotNullPredicate() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
