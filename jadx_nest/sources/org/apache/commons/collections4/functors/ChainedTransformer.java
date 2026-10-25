package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes5.dex */
public class ChainedTransformer<T> implements Transformer<T, T>, Serializable {
    private static final Transformer[] EMPTY_TRANSFORMER_ARRAY = new Transformer[0];
    private static final long serialVersionUID = 3514945074733160196L;
    private final Transformer<? super T, ? extends T>[] iTransformers;

    public static <T> Transformer<T, T> chainedTransformer(Collection<? extends Transformer<? super T, ? extends T>> collection) {
        Objects.requireNonNull(collection, "transformers");
        if (collection.isEmpty()) {
            return NOPTransformer.nopTransformer();
        }
        Transformer[] transformerArr = (Transformer[]) collection.toArray(EMPTY_TRANSFORMER_ARRAY);
        FunctorUtils.validate(transformerArr);
        return new ChainedTransformer(false, transformerArr);
    }

    public static <T> Transformer<T, T> chainedTransformer(Transformer<? super T, ? extends T>... transformerArr) {
        FunctorUtils.validate(transformerArr);
        if (transformerArr.length == 0) {
            return NOPTransformer.nopTransformer();
        }
        return new ChainedTransformer(transformerArr);
    }

    private ChainedTransformer(boolean z, Transformer<? super T, ? extends T>[] transformerArr) {
        this.iTransformers = z ? (Transformer[]) FunctorUtils.copy(transformerArr) : transformerArr;
    }

    public ChainedTransformer(Transformer<? super T, ? extends T>... transformerArr) {
        this(true, transformerArr);
    }

    public Transformer<? super T, ? extends T>[] getTransformers() {
        return (Transformer[]) FunctorUtils.copy(this.iTransformers);
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T t) {
        for (Transformer<? super T, ? extends T> transformer : this.iTransformers) {
            t = transformer.apply(t);
        }
        return t;
    }
}
