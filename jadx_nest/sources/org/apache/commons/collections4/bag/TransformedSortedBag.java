package org.apache.commons.collections4.bag;

import java.util.Comparator;
import org.apache.commons.collections4.SortedBag;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes5.dex */
public class TransformedSortedBag<E> extends TransformedBag<E> implements SortedBag<E> {
    private static final long serialVersionUID = -251737742649401930L;

    public static <E> TransformedSortedBag<E> transformedSortedBag(SortedBag<E> sortedBag, Transformer<? super E, ? extends E> transformer) {
        TransformedSortedBag<E> transformedSortedBag = new TransformedSortedBag<>(sortedBag, transformer);
        if (!sortedBag.isEmpty()) {
            Object[] array = sortedBag.toArray();
            sortedBag.clear();
            for (Object obj : array) {
                transformedSortedBag.decorated().add(transformer.apply(obj));
            }
        }
        return transformedSortedBag;
    }

    public static <E> TransformedSortedBag<E> transformingSortedBag(SortedBag<E> sortedBag, Transformer<? super E, ? extends E> transformer) {
        return new TransformedSortedBag<>(sortedBag, transformer);
    }

    protected TransformedSortedBag(SortedBag<E> sortedBag, Transformer<? super E, ? extends E> transformer) {
        super(sortedBag, transformer);
    }

    @Override // org.apache.commons.collections4.SortedBag
    public Comparator<? super E> comparator() {
        return getSortedBag().comparator();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E first() {
        return getSortedBag().first();
    }

    protected SortedBag<E> getSortedBag() {
        return (SortedBag) decorated();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E last() {
        return getSortedBag().last();
    }
}
