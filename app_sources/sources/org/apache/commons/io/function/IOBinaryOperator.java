package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.function.BinaryOperator;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOBinaryOperator<T> extends IOBiFunction<T, T, T> {
    static <T> IOBinaryOperator<T> maxBy(IOComparator<? super T> iOComparator) {
        Objects.requireNonNull(iOComparator);
        return new IOBinaryOperator$$ExternalSyntheticLambda1(iOComparator);
    }

    static /* synthetic */ Object lambda$maxBy$0(IOComparator iOComparator, Object obj, Object obj2) throws IOException {
        return iOComparator.compare(obj, obj2) >= 0 ? obj : obj2;
    }

    static <T> IOBinaryOperator<T> minBy(IOComparator<? super T> iOComparator) {
        Objects.requireNonNull(iOComparator);
        return new IOBinaryOperator$$ExternalSyntheticLambda2(iOComparator);
    }

    static /* synthetic */ Object lambda$minBy$1(IOComparator iOComparator, Object obj, Object obj2) throws IOException {
        return iOComparator.compare(obj, obj2) <= 0 ? obj : obj2;
    }

    default BinaryOperator<T> asBinaryOperator() {
        return new IOBinaryOperator$$ExternalSyntheticLambda0(this);
    }
}
