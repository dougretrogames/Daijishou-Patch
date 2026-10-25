package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;

/* JADX INFO: loaded from: classes5.dex */
public final class NOPClosure<T> implements Closure<T>, Serializable {
    public static final Closure INSTANCE = new NOPClosure();
    private static final long serialVersionUID = 3518477308466486130L;

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
    }

    public static <E> Closure<E> nopClosure() {
        return INSTANCE;
    }

    private NOPClosure() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
