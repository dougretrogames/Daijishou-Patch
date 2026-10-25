package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes5.dex */
public class SwitchTransformer<T, R> implements Transformer<T, R>, Serializable {
    private static final long serialVersionUID = -6404460890903469332L;
    private final Transformer<? super T, ? extends R> iDefault;
    private final Predicate<? super T>[] iPredicates;
    private final Transformer<? super T, ? extends R>[] iTransformers;

    public static <I, O> Transformer<I, O> switchTransformer(Map<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> map) {
        Objects.requireNonNull(map, "map");
        if (map.isEmpty()) {
            return ConstantTransformer.nullTransformer();
        }
        Transformer<? super I, ? extends O> transformerRemove = map.remove(null);
        int size = map.size();
        if (size == 0) {
            return transformerRemove == null ? ConstantTransformer.nullTransformer() : transformerRemove;
        }
        Transformer[] transformerArr = new Transformer[size];
        Predicate[] predicateArr = new Predicate[size];
        int i = 0;
        for (Map.Entry<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> entry : map.entrySet()) {
            predicateArr[i] = entry.getKey();
            transformerArr[i] = entry.getValue();
            i++;
        }
        return new SwitchTransformer(false, predicateArr, transformerArr, transformerRemove);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(transformerArr);
        if (predicateArr.length != transformerArr.length) {
            throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
        }
        if (predicateArr.length == 0) {
            return transformer == 0 ? ConstantTransformer.nullTransformer() : transformer;
        }
        return new SwitchTransformer(predicateArr, transformerArr, transformer);
    }

    private SwitchTransformer(boolean z, Predicate<? super T>[] predicateArr, Transformer<? super T, ? extends R>[] transformerArr, Transformer<? super T, ? extends R> transformer) {
        this.iPredicates = z ? (Predicate[]) FunctorUtils.copy(predicateArr) : predicateArr;
        this.iTransformers = z ? (Transformer[]) FunctorUtils.copy(transformerArr) : transformerArr;
        this.iDefault = transformer == null ? ConstantTransformer.nullTransformer() : transformer;
    }

    public SwitchTransformer(Predicate<? super T>[] predicateArr, Transformer<? super T, ? extends R>[] transformerArr, Transformer<? super T, ? extends R> transformer) {
        this(true, predicateArr, transformerArr, transformer);
    }

    public Transformer<? super T, ? extends R> getDefaultTransformer() {
        return this.iDefault;
    }

    public Predicate<? super T>[] getPredicates() {
        return (Predicate[]) FunctorUtils.copy(this.iPredicates);
    }

    public Transformer<? super T, ? extends R>[] getTransformers() {
        return (Transformer[]) FunctorUtils.copy(this.iTransformers);
    }

    @Override // org.apache.commons.collections4.Transformer
    public R transform(T t) {
        int i = 0;
        while (true) {
            Predicate<? super T>[] predicateArr = this.iPredicates;
            if (i < predicateArr.length) {
                if (predicateArr[i].test(t)) {
                    return this.iTransformers[i].apply(t);
                }
                i++;
            } else {
                return this.iDefault.apply(t);
            }
        }
    }
}
