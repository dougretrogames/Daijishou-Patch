package org.apache.commons.collections4;

import java.util.function.Function;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
@Deprecated
public interface Transformer<T, R> extends Function<T, R> {
    R transform(T t);

    @Override // java.util.function.Function
    default R apply(T t) {
        return transform(t);
    }
}
