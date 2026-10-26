package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Closure;

/* INFO: loaded from: classes5.dex */
public class ChainedClosure<T> implements Closure<T>, Serializable {
    private static final long serialVersionUID = -3520677225766901240L;
    private final Closure<? super T>[] iClosures;

    public static <E> Closure<E> chainedClosure(Closure<? super E>... closureArr) {
        FunctorUtils.validate(closureArr);
        if (closureArr.length == 0) {
            return NOPClosure.nopClosure();
        }
        return new ChainedClosure(closureArr);
    }

    public static <E> Closure<E> chainedClosure(Collection<? extends Closure<? super E>> collection) {
        Objects.requireNonNull(collection, "closures");
        if (collection.isEmpty()) {
            return NOPClosure.nopClosure();
        }
        Closure[] closureArr = new Closure[collection.size()];
        Iterator<? extends Closure<? super E>> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            closureArr[i] = it.next();
            i++;
        }
        FunctorUtils.validate(closureArr);
        return new ChainedClosure(false, closureArr);
    }

    private ChainedClosure(boolean z, Closure<? super T>... closureArr) {
        this.iClosures = z ? (Closure[]) FunctorUtils.copy(closureArr) : closureArr;
    }

    public ChainedClosure(Closure<? super T>... closureArr) {
        this(true, closureArr);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        for (Closure<? super T> closure : this.iClosures) {
            closure.accept(t);
        }
    }

    public Closure<? super T>[] getClosures() {
        return (Closure[]) FunctorUtils.copy(this.iClosures);
    }
}
