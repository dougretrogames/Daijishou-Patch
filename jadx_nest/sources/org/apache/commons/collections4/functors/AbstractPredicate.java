package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;

/* INFO: loaded from: classes5.dex */
public abstract class AbstractPredicate<T> implements Predicate<T> {
    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        return test(t);
    }
}
