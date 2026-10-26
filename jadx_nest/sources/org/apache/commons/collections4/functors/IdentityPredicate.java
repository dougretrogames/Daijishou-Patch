package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* INFO: loaded from: classes5.dex */
public final class IdentityPredicate<T> extends AbstractPredicate<T> implements Serializable {
    private static final long serialVersionUID = -89901658494523293L;
    private final T iValue;

    public static <T> Predicate<T> identityPredicate(T t) {
        if (t == null) {
            return NullPredicate.nullPredicate();
        }
        return new IdentityPredicate(t);
    }

    public IdentityPredicate(T t) {
        this.iValue = t;
    }

    public T getValue() {
        return this.iValue;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        return this.iValue == t;
    }
}
