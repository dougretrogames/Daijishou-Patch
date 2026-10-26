package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;

/* INFO: loaded from: classes5.dex */
public class ForClosure<T> implements Closure<T> {
    private final Closure<? super T> iClosure;
    private final int iCount;

    /* WARN: Multi-variable type inference failed */
    public static <E> Closure<E> forClosure(int i, Closure<? super E> closure) {
        if (i <= 0 || closure == 0) {
            return NOPClosure.nopClosure();
        }
        return i == 1 ? closure : new ForClosure(i, closure);
    }

    public ForClosure(int i, Closure<? super T> closure) {
        this.iCount = i;
        this.iClosure = closure;
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        for (int i = 0; i < this.iCount; i++) {
            this.iClosure.accept(t);
        }
    }

    public Closure<? super T> getClosure() {
        return this.iClosure;
    }

    public int getCount() {
        return this.iCount;
    }
}
