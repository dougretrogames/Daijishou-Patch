package androidx.core.util;

import java.util.Objects;

/* INFO: loaded from: classes.dex */
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate$$ExternalSyntheticLambda3(this, predicate);
    }

    static /* synthetic */ boolean lambda$and$0(Predicate _this, Predicate predicate, Object obj) {
        return _this.test(obj) && predicate.test(obj);
    }

    static /* synthetic */ boolean lambda$negate$1(Predicate _this, Object obj) {
        return !_this.test(obj);
    }

    default Predicate<T> negate() {
        return new Predicate$$ExternalSyntheticLambda4(this);
    }

    default Predicate<T> or(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate$$ExternalSyntheticLambda0(this, predicate);
    }

    static /* synthetic */ boolean lambda$or$2(Predicate _this, Predicate predicate, Object obj) {
        return _this.test(obj) || predicate.test(obj);
    }

    static <T> Predicate<T> isEqual(Object obj) {
        if (obj == null) {
            return new Predicate$$ExternalSyntheticLambda1();
        }
        return new Predicate$$ExternalSyntheticLambda2(obj);
    }

    static <T> Predicate<T> not(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
