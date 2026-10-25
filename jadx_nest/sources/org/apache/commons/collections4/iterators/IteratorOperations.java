package org.apache.commons.collections4.iterators;

import com.google.common.collect.CollectCollectors$$ExternalSyntheticLambda64;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public interface IteratorOperations<E> extends Iterator<E> {
    static /* synthetic */ HashSet $r8$lambda$j35xzDqY00kBEc7DMQyJC7sG_u4() {
        return new HashSet();
    }

    /* JADX INFO: renamed from: $r8$lambda$wBZ5N9SAmxJLRX-vx8hIUeo_fgc, reason: not valid java name */
    static /* synthetic */ ArrayList m5539$r8$lambda$wBZ5N9SAmxJLRXvx8hIUeo_fgc() {
        return new ArrayList();
    }

    default <C extends Collection<E>> C addTo(C c) {
        Objects.requireNonNull(c);
        forEachRemaining(new CollectCollectors$$ExternalSyntheticLambda64(c));
        return c;
    }

    default E removeNext() {
        E next = next();
        remove();
        return next;
    }

    default <C extends Collection<E>> C toCollection(Supplier<C> supplier) {
        return (C) addTo(supplier.get());
    }

    default List<E> toList() {
        return (List) toCollection(new IteratorOperations$$ExternalSyntheticLambda1());
    }

    default Set<E> toSet() {
        return (Set) toCollection(new IteratorOperations$$ExternalSyntheticLambda0());
    }
}
