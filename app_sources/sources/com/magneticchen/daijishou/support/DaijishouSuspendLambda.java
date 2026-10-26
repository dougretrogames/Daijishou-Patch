package com.magneticchen.daijishou.support;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/**
 * Drop-in replacement for {@link SuspendLambda} that lets the decompiled
 * coroutine state machines declare {@code throws Throwable} on their
 * {@code invokeSuspendImpl} implementation.
 */
public abstract class DaijishouSuspendLambda extends SuspendLambda {

    public DaijishouSuspendLambda(int arity) {
        super(arity);
    }

    @SuppressWarnings("unchecked")
    public DaijishouSuspendLambda(int arity, Continuation<?> completion) {
        super(arity, (Continuation<Object>) completion);
    }

    public abstract Object invokeSuspendImpl(Object obj) throws Throwable;

    @Override
    public final Object invokeSuspend(Object obj) {
        try {
            return invokeSuspendImpl(obj);
        } catch (Throwable throwable) {
            throw DaijishouSupport.sneakyThrow(throwable);
        }
    }
}
