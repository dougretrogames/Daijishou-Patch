package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* INFO: loaded from: classes5.dex */
public final class NonePredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = 2007613066565892961L;

    public static <T> Predicate<T> nonePredicate(Collection<? extends Predicate<? super T>> collection) {
        Predicate[] predicateArrValidate = FunctorUtils.validate(collection);
        if (predicateArrValidate.length == 0) {
            return TruePredicate.truePredicate();
        }
        return new NonePredicate(predicateArrValidate);
    }

    public static <T> Predicate<T> nonePredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return TruePredicate.truePredicate();
        }
        return new NonePredicate((Predicate[]) FunctorUtils.copy(predicateArr));
    }

    public NonePredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (predicate.test(t)) {
                return false;
            }
        }
        return true;
    }
}
