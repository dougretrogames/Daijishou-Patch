package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;

/* INFO: loaded from: classes5.dex */
public interface PredicateDecorator<T> extends Predicate<T> {
    Predicate<? super T>[] getPredicates();
}
