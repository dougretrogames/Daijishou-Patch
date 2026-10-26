package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* INFO: loaded from: classes5.dex */
public final class TransformerPredicate<T> extends AbstractPredicate<T> implements Serializable {
    private static final long serialVersionUID = -2407966402920578741L;
    private final Transformer<? super T, Boolean> iTransformer;

    public static <T> Predicate<T> transformerPredicate(Transformer<? super T, Boolean> transformer) {
        return new TransformerPredicate((Transformer) Objects.requireNonNull(transformer, "transformer"));
    }

    public TransformerPredicate(Transformer<? super T, Boolean> transformer) {
        this.iTransformer = transformer;
    }

    public Transformer<? super T, Boolean> getTransformer() {
        return this.iTransformer;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        Boolean boolApply = this.iTransformer.apply(t);
        if (boolApply == null) {
            throw new FunctorException("Transformer must return an instanceof Boolean, it was a null object");
        }
        return boolApply.booleanValue();
    }
}
