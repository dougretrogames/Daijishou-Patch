package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOComparator<T> {
    int compare(T t, T t2) throws IOException;

    default Comparator<T> asComparator() {
        return new IOComparator$$ExternalSyntheticLambda0(this);
    }
}
