package org.apache.commons.io.function;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.Supplier;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOSupplier<T> {
    T get() throws IOException;

    default Supplier<T> asSupplier() {
        return new IOSupplier$$ExternalSyntheticLambda0(this);
    }

    default T getUnchecked() throws UncheckedIOException {
        return (T) Uncheck.get(this);
    }
}
