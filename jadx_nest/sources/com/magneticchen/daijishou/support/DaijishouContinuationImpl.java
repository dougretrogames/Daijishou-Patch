package com.magneticchen.daijishou.support;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/**
 * Drop-in replacement for {@link ContinuationImpl} that lets the decompiled
 * coroutine state machines declare {@code throws Throwable} on their
 * {@code invokeSuspendImpl} implementation.
 */
public abstract class DaijishouContinuationImpl extends ContinuationImpl {

    @SuppressWarnings("unchecked")
    public DaijishouContinuationImpl(Continuation<?> completion) {
        super((Continuation<Object>) completion);
    }

    @SuppressWarnings("unchecked")
    public DaijishouContinuationImpl(Continuation<?> completion, CoroutineContext context) {
        super((Continuation<Object>) completion, context);
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
