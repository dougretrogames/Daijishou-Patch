package org.apache.commons.collections4;

import java.util.Collection;

/* INFO: loaded from: classes5.dex */
public interface BoundedCollection<E> extends Collection<E> {
    boolean isFull();

    int maxSize();
}
