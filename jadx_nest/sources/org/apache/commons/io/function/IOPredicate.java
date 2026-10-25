package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOPredicate<T> {
    boolean test(T t) throws IOException;

    static <T> IOPredicate<T> alwaysFalse() {
        return (IOPredicate<T>) Constants.IO_PREDICATE_FALSE;
    }

    static <T> IOPredicate<T> alwaysTrue() {
        return (IOPredicate<T>) Constants.IO_PREDICATE_TRUE;
    }

    static <T> IOPredicate<T> isEqual(Object obj) {
        return obj == null ? new IOPredicate$$ExternalSyntheticLambda1() : new IOPredicate$$ExternalSyntheticLambda2(obj);
    }

    default IOPredicate<T> and(IOPredicate<? super T> iOPredicate) {
        Objects.requireNonNull(iOPredicate);
        return new IOPredicate$$ExternalSyntheticLambda4(this, iOPredicate);
    }

    static /* synthetic */ boolean lambda$and$1(IOPredicate _this, IOPredicate iOPredicate, Object obj) throws IOException {
        return _this.test(obj) && iOPredicate.test(obj);
    }

    default Predicate<T> asPredicate() {
        return new IOPredicate$$ExternalSyntheticLambda5(this);
    }

    static /* synthetic */ boolean lambda$negate$3(IOPredicate _this, Object obj) throws IOException {
        return !_this.test(obj);
    }

    default IOPredicate<T> negate() {
        return new IOPredicate$$ExternalSyntheticLambda0(this);
    }

    default IOPredicate<T> or(IOPredicate<? super T> iOPredicate) {
        Objects.requireNonNull(iOPredicate);
        return new IOPredicate$$ExternalSyntheticLambda3(this, iOPredicate);
    }

    static /* synthetic */ boolean lambda$or$4(IOPredicate _this, IOPredicate iOPredicate, Object obj) throws IOException {
        return _this.test(obj) || iOPredicate.test(obj);
    }
}
