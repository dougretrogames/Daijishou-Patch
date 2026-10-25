package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public final class ExceptionPredicate<T> extends AbstractPredicate<T> implements Serializable {
    public static final Predicate INSTANCE = new ExceptionPredicate();
    private static final long serialVersionUID = 7179106032121985545L;

    public static <T> Predicate<T> exceptionPredicate() {
        return INSTANCE;
    }

    private ExceptionPredicate() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        throw new FunctorException("ExceptionPredicate invoked");
    }
}
