package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public final class AnyPredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = 7429999530934647542L;

    public static <T> Predicate<T> anyPredicate(Collection<? extends Predicate<? super T>> collection) {
        Predicate<T>[] predicateArrValidate = FunctorUtils.validate(collection);
        if (predicateArrValidate.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        if (predicateArrValidate.length == 1) {
            return predicateArrValidate[0];
        }
        return new AnyPredicate(predicateArrValidate);
    }

    public static <T> Predicate<T> anyPredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        if (predicateArr.length == 1) {
            return (Predicate<T>) predicateArr[0];
        }
        return new AnyPredicate((Predicate[]) FunctorUtils.copy(predicateArr));
    }

    public AnyPredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (predicate.test(t)) {
                return true;
            }
        }
        return false;
    }
}
