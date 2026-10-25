package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes5.dex */
public class TransformedCollection<E> extends AbstractCollectionDecorator<E> {
    private static final long serialVersionUID = 8692300188161871514L;
    protected final Transformer<? super E, ? extends E> transformer;

    public static <E> TransformedCollection<E> transformedCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        TransformedCollection<E> transformedCollection = new TransformedCollection<>(collection, transformer);
        if (!collection.isEmpty()) {
            Object[] array = collection.toArray();
            collection.clear();
            for (Object obj : array) {
                transformedCollection.decorated().add(transformer.apply(obj));
            }
        }
        return transformedCollection;
    }

    public static <E> TransformedCollection<E> transformingCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        return new TransformedCollection<>(collection, transformer);
    }

    protected TransformedCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        super(collection);
        this.transformer = (Transformer) Objects.requireNonNull(transformer, "transformer");
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        return decorated().add(transform(e));
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return decorated().addAll(transform((Collection) collection));
    }

    protected Collection<E> transform(Collection<? extends E> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(transform(it.next()));
        }
        return arrayList;
    }

    protected E transform(E e) {
        return this.transformer.apply(e);
    }
}
