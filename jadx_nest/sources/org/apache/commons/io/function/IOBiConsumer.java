package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOBiConsumer<T, U> {
    void accept(T t, U u) throws IOException;

    static <T, U> IOBiConsumer<T, U> noop() {
        return Constants.IO_BI_CONSUMER;
    }

    default IOBiConsumer<T, U> andThen(IOBiConsumer<? super T, ? super U> iOBiConsumer) {
        Objects.requireNonNull(iOBiConsumer);
        return new IOBiConsumer$$ExternalSyntheticLambda0(this, iOBiConsumer);
    }

    static /* synthetic */ void lambda$andThen$0(IOBiConsumer _this, IOBiConsumer iOBiConsumer, Object obj, Object obj2) throws IOException {
        _this.accept(obj, obj2);
        iOBiConsumer.accept(obj, obj2);
    }

    default BiConsumer<T, U> asBiConsumer() {
        return new IOBiConsumer$$ExternalSyntheticLambda1(this);
    }
}
