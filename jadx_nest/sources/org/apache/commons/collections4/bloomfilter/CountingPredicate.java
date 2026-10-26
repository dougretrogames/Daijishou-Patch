package org.apache.commons.collections4.bloomfilter;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* INFO: loaded from: classes5.dex */
class CountingPredicate<T> implements Predicate<T> {
    private final T[] ary;
    private final BiPredicate<T, T> func;
    private int idx;

    CountingPredicate(T[] tArr, BiPredicate<T, T> biPredicate) {
        this.ary = tArr;
        this.func = biPredicate;
    }

    boolean processRemaining() {
        int i = this.idx;
        T[] tArr = this.ary;
        int length = tArr.length;
        while (i != length && this.func.test(tArr[i], null)) {
            i++;
        }
        return i == length;
    }

    @Override // java.util.function.Predicate
    public boolean test(T t) {
        T t2;
        BiPredicate<T, T> biPredicate = this.func;
        int i = this.idx;
        T[] tArr = this.ary;
        if (i == tArr.length) {
            t2 = null;
        } else {
            this.idx = i + 1;
            t2 = tArr[i];
        }
        return biPredicate.test(t2, t);
    }
}
