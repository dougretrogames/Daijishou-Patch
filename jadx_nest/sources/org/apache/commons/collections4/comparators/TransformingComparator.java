package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.Transformer;

/* INFO: loaded from: classes5.dex */
public class TransformingComparator<I, O> implements Comparator<I>, Serializable {
    private static final long serialVersionUID = 3456940356043606220L;
    private final Comparator<O> decorated;
    private final Transformer<? super I, ? extends O> transformer;

    public TransformingComparator(Transformer<? super I, ? extends O> transformer) {
        this(transformer, ComparatorUtils.NATURAL_COMPARATOR);
    }

    public TransformingComparator(Transformer<? super I, ? extends O> transformer, Comparator<O> comparator) {
        this.decorated = comparator;
        this.transformer = transformer;
    }

    @Override // java.util.Comparator
    public int compare(I i, I i2) {
        return this.decorated.compare(this.transformer.apply(i), this.transformer.apply(i2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            TransformingComparator transformingComparator = (TransformingComparator) obj;
            if (Objects.equals(this.decorated, transformingComparator.decorated) && Objects.equals(this.transformer, transformingComparator.transformer)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Comparator<O> comparator = this.decorated;
        int iHashCode = (629 + (comparator == null ? 0 : comparator.hashCode())) * 37;
        Transformer<? super I, ? extends O> transformer = this.transformer;
        return iHashCode + (transformer != null ? transformer.hashCode() : 0);
    }
}
