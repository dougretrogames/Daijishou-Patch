package org.eclipse.jgit.util;

/* INFO: loaded from: classes5.dex */
public class Holder<T> {
    private T value;

    public Holder(T t) {
        set(t);
    }

    public T get() {
        return this.value;
    }

    public void set(T t) {
        this.value = t;
    }
}
