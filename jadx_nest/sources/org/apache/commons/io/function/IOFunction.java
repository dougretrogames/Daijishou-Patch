package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOFunction<T, R> {
    R apply(T t) throws IOException;

    static <T> IOFunction<T, T> identity() {
        return Constants.IO_FUNCTION_ID;
    }

    default IOConsumer<T> andThen(Consumer<? super R> consumer) {
        Objects.requireNonNull(consumer, "after");
        return new IOFunction$$ExternalSyntheticLambda5(this, consumer);
    }

    default <V> IOFunction<T, V> andThen(Function<? super R, ? extends V> function) {
        Objects.requireNonNull(function, "after");
        return new IOFunction$$ExternalSyntheticLambda4(this, function);
    }

    default IOConsumer<T> andThen(IOConsumer<? super R> iOConsumer) {
        Objects.requireNonNull(iOConsumer, "after");
        return new IOFunction$$ExternalSyntheticLambda3(this, iOConsumer);
    }

    default <V> IOFunction<T, V> andThen(IOFunction<? super R, ? extends V> iOFunction) {
        Objects.requireNonNull(iOFunction, "after");
        return new IOFunction$$ExternalSyntheticLambda1(this, iOFunction);
    }

    default Function<T, R> asFunction() {
        return new IOFunction$$ExternalSyntheticLambda0(this);
    }

    default <V> IOFunction<V, R> compose(Function<? super V, ? extends T> function) {
        Objects.requireNonNull(function, "before");
        return new IOFunction$$ExternalSyntheticLambda2(this, function);
    }

    default <V> IOFunction<V, R> compose(IOFunction<? super V, ? extends T> iOFunction) {
        Objects.requireNonNull(iOFunction, "before");
        return new IOFunction$$ExternalSyntheticLambda7(this, iOFunction);
    }

    default IOSupplier<R> compose(IOSupplier<? extends T> iOSupplier) {
        Objects.requireNonNull(iOSupplier, "before");
        return new IOFunction$$ExternalSyntheticLambda6(this, iOSupplier);
    }

    default IOSupplier<R> compose(Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "before");
        return new IOFunction$$ExternalSyntheticLambda8(this, supplier);
    }
}
