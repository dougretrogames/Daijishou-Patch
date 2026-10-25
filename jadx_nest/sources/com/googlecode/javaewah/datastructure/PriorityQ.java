package com.googlecode.javaewah.datastructure;

import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
public final class PriorityQ<T> {
    final T[] a;
    final Comparator<T> comp;
    int lastIndex = 0;

    public PriorityQ(int i, Comparator<T> comparator) {
        this.a = (T[]) new Object[i + 1];
        this.comp = comparator;
    }

    public int size() {
        return this.lastIndex;
    }

    private int compare(T t, T t2) {
        return this.comp.compare(t, t2);
    }

    public void toss(T t) {
        T[] tArr = this.a;
        int i = this.lastIndex + 1;
        this.lastIndex = i;
        tArr[i] = t;
    }

    public T peek() {
        return this.a[1];
    }

    public void buildHeap() {
        for (int i = this.lastIndex / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    public void percolateDown() {
        percolateDown(1);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    private void percolateDown(int i) {
        T t = this.a[i];
        while (true) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            int i4 = this.lastIndex;
            if (i3 <= i4) {
                if (compare(this.a[i2], t) < 0) {
                    T[] tArr = this.a;
                    if (compare(tArr[i3], tArr[i2]) < 0) {
                    }
                } else if (compare(this.a[i3], t) >= 0) {
                    i2 = i;
                }
                i2 = i3;
            } else if (i2 > i4 || compare(this.a[i2], t) >= 0) {
                i2 = i;
            }
            if (i != i2) {
                T[] tArr2 = this.a;
                tArr2[i] = tArr2[i2];
                i = i2;
            } else {
                this.a[i2] = t;
                return;
            }
        }
    }

    public T poll() {
        T[] tArr = this.a;
        T t = tArr[1];
        int i = this.lastIndex;
        this.lastIndex = i - 1;
        tArr[1] = tArr[i];
        percolateDown(1);
        return t;
    }

    public boolean isEmpty() {
        return this.lastIndex == 0;
    }
}
