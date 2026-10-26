package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

/* INFO: loaded from: classes5.dex */
public abstract class CatchAndRethrowClosure<T> implements Closure<T> {
    protected abstract void executeAndThrow(T t) throws Throwable;

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        try {
            executeAndThrow(t);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable th) {
            throw new FunctorException(th);
        }
    }
}
