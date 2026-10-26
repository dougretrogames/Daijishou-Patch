package org.apache.commons.collections4;

import java.util.Comparator;

/* INFO: loaded from: classes5.dex */
public interface SortedBag<E> extends Bag<E> {
    Comparator<? super E> comparator();

    E first();

    E last();
}
