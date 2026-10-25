package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOBiFunction<T, U, R> {
    R apply(T t, U u) throws IOException;

    default <V> IOBiFunction<T, U, V> andThen(IOFunction<? super R, ? extends V> iOFunction) {
        Objects.requireNonNull(iOFunction);
        return new IOBiFunction$$ExternalSyntheticLambda0(this, iOFunction);
    }

    default BiFunction<T, U, R> asBiFunction() {
        return new IOBiFunction$$ExternalSyntheticLambda1(this);
    }
}
