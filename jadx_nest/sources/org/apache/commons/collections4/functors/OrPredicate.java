package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public final class OrPredicate<T> extends AbstractPredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -8791518325735182855L;
    private final Predicate<? super T> iPredicate1;
    private final Predicate<? super T> iPredicate2;

    public static <T> Predicate<T> orPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new OrPredicate((Predicate) Objects.requireNonNull(predicate, "predicate1"), (Predicate) Objects.requireNonNull(predicate2, "predicate2"));
    }

    public OrPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        this.iPredicate1 = predicate;
        this.iPredicate2 = predicate2;
    }

    @Override // org.apache.commons.collections4.functors.PredicateDecorator
    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate1, this.iPredicate2};
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        return this.iPredicate1.test(t) || this.iPredicate2.test(t);
    }
}
