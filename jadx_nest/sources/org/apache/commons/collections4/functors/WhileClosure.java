package org.apache.commons.collections4.functors;

import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public class WhileClosure<T> implements Closure<T> {
    private final Closure<? super T> iClosure;
    private final boolean iDoLoop;
    private final Predicate<? super T> iPredicate;

    public static <E> Closure<E> whileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean z) {
        return new WhileClosure((Predicate) Objects.requireNonNull(predicate, "predicate"), (Closure) Objects.requireNonNull(closure, "closure"), z);
    }

    public WhileClosure(Predicate<? super T> predicate, Closure<? super T> closure, boolean z) {
        this.iPredicate = predicate;
        this.iClosure = closure;
        this.iDoLoop = z;
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        if (this.iDoLoop) {
            this.iClosure.accept(t);
        }
        while (this.iPredicate.test(t)) {
            this.iClosure.accept(t);
        }
    }

    public Closure<? super T> getClosure() {
        return this.iClosure;
    }

    public Predicate<? super T> getPredicate() {
        return this.iPredicate;
    }

    public boolean isDoLoop() {
        return this.iDoLoop;
    }
}
