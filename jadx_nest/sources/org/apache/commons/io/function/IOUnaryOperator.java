package org.apache.commons.io.function;

import java.io.IOException;
import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOUnaryOperator<T> extends IOFunction<T, T> {
    static /* synthetic */ Object lambda$identity$0(Object obj) throws IOException {
        return obj;
    }

    static <T> IOUnaryOperator<T> identity() {
        return new IOUnaryOperator$$ExternalSyntheticLambda1();
    }

    default UnaryOperator<T> asUnaryOperator() {
        return new IOUnaryOperator$$ExternalSyntheticLambda0(this);
    }
}
