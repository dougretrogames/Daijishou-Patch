package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOQuadFunction<T, U, V, W, R> {
    R apply(T t, U u, V v, W w) throws IOException;

    default <X> IOQuadFunction<T, U, V, W, X> andThen(IOFunction<? super R, ? extends X> iOFunction) {
        Objects.requireNonNull(iOFunction);
        return new IOQuadFunction$$ExternalSyntheticLambda0(this, iOFunction);
    }
}
