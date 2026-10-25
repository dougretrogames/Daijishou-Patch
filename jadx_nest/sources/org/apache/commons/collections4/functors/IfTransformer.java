package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes5.dex */
public class IfTransformer<T, R> implements Transformer<T, R>, Serializable {
    private static final long serialVersionUID = 8069309411242014252L;
    private final Transformer<? super T, ? extends R> iFalseTransformer;
    private final Predicate<? super T> iPredicate;
    private final Transformer<? super T, ? extends R> iTrueTransformer;

    public static <I, O> Transformer<I, O> ifTransformer(Predicate<? super I> predicate, Transformer<? super I, ? extends O> transformer, Transformer<? super I, ? extends O> transformer2) {
        return new IfTransformer((Predicate) Objects.requireNonNull(predicate, "predicate"), (Transformer) Objects.requireNonNull(transformer, "trueTransformer"), (Transformer) Objects.requireNonNull(transformer2, "falseTransformer"));
    }

    public static <T> Transformer<T, T> ifTransformer(Predicate<? super T> predicate, Transformer<? super T, ? extends T> transformer) {
        return new IfTransformer((Predicate) Objects.requireNonNull(predicate, "predicate"), (Transformer) Objects.requireNonNull(transformer, "trueTransformer"), NOPTransformer.nopTransformer());
    }

    public IfTransformer(Predicate<? super T> predicate, Transformer<? super T, ? extends R> transformer, Transformer<? super T, ? extends R> transformer2) {
        this.iPredicate = predicate;
        this.iTrueTransformer = transformer;
        this.iFalseTransformer = transformer2;
    }

    public Transformer<? super T, ? extends R> getFalseTransformer() {
        return this.iFalseTransformer;
    }

    public Predicate<? super T> getPredicate() {
        return this.iPredicate;
    }

    public Transformer<? super T, ? extends R> getTrueTransformer() {
        return this.iTrueTransformer;
    }

    @Override // org.apache.commons.collections4.Transformer
    public R transform(T t) {
        if (this.iPredicate.test(t)) {
            return this.iTrueTransformer.apply(t);
        }
        return this.iFalseTransformer.apply(t);
    }
}
