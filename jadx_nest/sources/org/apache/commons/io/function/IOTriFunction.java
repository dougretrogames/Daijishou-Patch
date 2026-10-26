package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOTriFunction<T, U, V, R> {
    R apply(T t, U u, V v) throws IOException;

    default <W> IOTriFunction<T, U, V, W> andThen(IOFunction<? super R, ? extends W> iOFunction) {
        Objects.requireNonNull(iOFunction);
        return new IOTriFunction$$ExternalSyntheticLambda0(this, iOFunction);
    }
}
