package org.apache.commons.collections4;

import java.util.Iterator;

/* INFO: loaded from: classes5.dex */
public interface OrderedIterator<E> extends Iterator<E> {
    boolean hasPrevious();

    E previous();
}
