package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOIntConsumer {
    public static final IOIntConsumer NOOP = new IOIntConsumer$$ExternalSyntheticLambda2();

    static /* synthetic */ void lambda$static$0(int i) throws IOException {
    }

    void accept(int i) throws IOException;

    default IOIntConsumer andThen(IOIntConsumer iOIntConsumer) {
        Objects.requireNonNull(iOIntConsumer);
        return new IOIntConsumer$$ExternalSyntheticLambda1(this, iOIntConsumer);
    }

    static /* synthetic */ void lambda$andThen$1(IOIntConsumer _this, IOIntConsumer iOIntConsumer, int i) throws IOException {
        _this.accept(i);
        iOIntConsumer.accept(i);
    }

    default Consumer<Integer> asConsumer() {
        return new IOIntConsumer$$ExternalSyntheticLambda0(this);
    }

    default IntConsumer asIntConsumer() {
        return new IOIntConsumer$$ExternalSyntheticLambda3(this);
    }
}
