package org.apache.commons.collections4.functors;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes5.dex */
final class FunctorUtils {
    /* JADX WARN: Multi-variable type inference failed */
    static <R extends Function<I, O>, P extends Function<? super I, ? extends O>, I, O> R coerce(P p) {
        return p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <R extends Predicate<T>, P extends Predicate<? super T>, T> R coerce(P p) {
        return p;
    }

    static <T extends Consumer<?>> T[] copy(T... tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Consumer[]) tArr.clone());
    }

    static <T extends Predicate<?>> T[] copy(T... tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Predicate[]) tArr.clone());
    }

    static <T extends Function<?, ?>> T[] copy(T... tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Function[]) tArr.clone());
    }

    static <T> org.apache.commons.collections4.Predicate<? super T>[] validate(Collection<? extends Predicate<? super T>> collection) {
        Objects.requireNonNull(collection, "predicates");
        org.apache.commons.collections4.Predicate<? super T>[] predicateArr = new org.apache.commons.collections4.Predicate[collection.size()];
        Iterator<? extends Predicate<? super T>> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            org.apache.commons.collections4.Predicate<? super T> predicate = (org.apache.commons.collections4.Predicate) it.next();
            predicateArr[i] = predicate;
            if (predicate == null) {
                throw new NullPointerException("predicates[" + i + CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
            }
            i++;
        }
        return predicateArr;
    }

    static void validate(Consumer<?>... consumerArr) {
        Objects.requireNonNull(consumerArr, "closures");
        for (int i = 0; i < consumerArr.length; i++) {
            if (consumerArr[i] == null) {
                throw new NullPointerException("closures[" + i + CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
            }
        }
    }

    static void validate(Function<?, ?>... functionArr) {
        Objects.requireNonNull(functionArr, "functions");
        for (int i = 0; i < functionArr.length; i++) {
            if (functionArr[i] == null) {
                throw new NullPointerException("functions[" + i + CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
            }
        }
    }

    static void validate(Predicate<?>... predicateArr) {
        Objects.requireNonNull(predicateArr, "predicates");
        for (int i = 0; i < predicateArr.length; i++) {
            if (predicateArr[i] == null) {
                throw new NullPointerException("predicates[" + i + CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
            }
        }
    }

    private FunctorUtils() {
    }
}
