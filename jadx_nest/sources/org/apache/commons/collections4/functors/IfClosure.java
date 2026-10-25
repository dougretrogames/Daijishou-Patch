package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public class IfClosure<T> implements Closure<T>, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure<? super T> iFalseClosure;
    private final Predicate<? super T> iPredicate;
    private final Closure<? super T> iTrueClosure;

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        return ifClosure(predicate, closure, NOPClosure.nopClosure());
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure, Closure<? super E> closure2) {
        return new IfClosure((Predicate) Objects.requireNonNull(predicate, "predicate"), (Closure) Objects.requireNonNull(closure, "trueClosure"), (Closure) Objects.requireNonNull(closure2, "falseClosure"));
    }

    public IfClosure(Predicate<? super T> predicate, Closure<? super T> closure) {
        this(predicate, closure, NOPClosure.nopClosure());
    }

    public IfClosure(Predicate<? super T> predicate, Closure<? super T> closure, Closure<? super T> closure2) {
        this.iPredicate = predicate;
        this.iTrueClosure = closure;
        this.iFalseClosure = closure2;
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        if (this.iPredicate.test(t)) {
            this.iTrueClosure.accept(t);
        } else {
            this.iFalseClosure.accept(t);
        }
    }

    public Closure<? super T> getFalseClosure() {
        return this.iFalseClosure;
    }

    public Predicate<? super T> getPredicate() {
        return this.iPredicate;
    }

    public Closure<? super T> getTrueClosure() {
        return this.iTrueClosure;
    }
}
