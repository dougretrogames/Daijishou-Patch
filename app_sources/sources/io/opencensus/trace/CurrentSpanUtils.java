package io.opencensus.trace;

import io.opencensus.common.Scope;
import io.opencensus.trace.unsafe.ContextHandleUtils;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* INFO: loaded from: classes4.dex */
final class CurrentSpanUtils {
    private CurrentSpanUtils() {
    }

    @Nullable
    static Span getCurrentSpan() {
        return ContextHandleUtils.getValue(ContextHandleUtils.currentContext());
    }

    static Scope withSpan(Span span, boolean z) {
        return new ScopeInSpan(span, z, null);
    }

    static Runnable withSpan(Span span, boolean z, Runnable runnable) {
        return new RunnableInSpan(span, runnable, z, null);
    }

    static <C> Callable<C> withSpan(Span span, boolean z, Callable<C> callable) {
        return new CallableInSpan(span, callable, z, null);
    }

    private static final class ScopeInSpan implements Scope {
        private final boolean endSpan;
        private final ContextHandle origContext;
        private final Span span;

        /* synthetic */ ScopeInSpan(Span span, boolean z, AnonymousClass1 anonymousClass1) {
            this(span, z);
        }

        private ScopeInSpan(Span span, boolean z) {
            this.span = span;
            this.endSpan = z;
            this.origContext = ContextHandleUtils.withValue(ContextHandleUtils.currentContext(), span).attach();
        }

        @Override // io.opencensus.common.Scope, io.opencensus.common.NonThrowingCloseable, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            ContextHandleUtils.currentContext().detach(this.origContext);
            if (this.endSpan) {
                this.span.end();
            }
        }
    }

    private static final class RunnableInSpan implements Runnable {
        private final boolean endSpan;
        private final Runnable runnable;
        private final Span span;

        /* synthetic */ RunnableInSpan(Span span, Runnable runnable, boolean z, AnonymousClass1 anonymousClass1) {
            this(span, runnable, z);
        }

        private RunnableInSpan(Span span, Runnable runnable, boolean z) {
            this.span = span;
            this.runnable = runnable;
            this.endSpan = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContextHandle contextHandleAttach = ContextHandleUtils.withValue(ContextHandleUtils.currentContext(), this.span).attach();
            try {
                this.runnable.run();
                ContextHandleUtils.currentContext().detach(contextHandleAttach);
                if (this.endSpan) {
                    this.span.end();
                }
            } catch (Throwable th) {
                try {
                    CurrentSpanUtils.setErrorStatus(this.span, th);
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    if (th instanceof Error) {
                        throw ((Error) th);
                    }
                    throw new RuntimeException("unexpected", th);
                } catch (Throwable th2) {
                    ContextHandleUtils.currentContext().detach(contextHandleAttach);
                    if (this.endSpan) {
                        this.span.end();
                    }
                    throw th2;
                }
            }
        }
    }

    private static final class CallableInSpan<V> implements Callable<V> {
        private final Callable<V> callable;
        private final boolean endSpan;
        private final Span span;

        /* synthetic */ CallableInSpan(Span span, Callable callable, boolean z, AnonymousClass1 anonymousClass1) {
            this(span, callable, z);
        }

        private CallableInSpan(Span span, Callable<V> callable, boolean z) {
            this.span = span;
            this.callable = callable;
            this.endSpan = z;
        }

        @Override // java.util.concurrent.Callable
        public V call() throws Exception {
            ContextHandle contextHandleAttach = ContextHandleUtils.withValue(ContextHandleUtils.currentContext(), this.span).attach();
            try {
                try {
                    try {
                        V vCall = this.callable.call();
                        ContextHandleUtils.currentContext().detach(contextHandleAttach);
                        if (this.endSpan) {
                            this.span.end();
                        }
                        return vCall;
                    } catch (Throwable th) {
                        CurrentSpanUtils.setErrorStatus(this.span, th);
                        if (th instanceof Error) {
                            throw th;
                        }
                        throw new RuntimeException("unexpected", th);
                    }
                } catch (Exception e) {
                    CurrentSpanUtils.setErrorStatus(this.span, e);
                    throw e;
                }
            } catch (Throwable th2) {
                ContextHandleUtils.currentContext().detach(contextHandleAttach);
                if (this.endSpan) {
                    this.span.end();
                }
                throw th2;
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static void setErrorStatus(Span span, Throwable th) {
        span.setStatus(Status.UNKNOWN.withDescription(th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage()));
    }
}
