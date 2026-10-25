package org.apache.commons.collections4;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface Predicate<T> extends java.util.function.Predicate<T> {
    boolean evaluate(T t);

    @Override // java.util.function.Predicate
    default boolean test(T t) {
        return evaluate(t);
    }
}
