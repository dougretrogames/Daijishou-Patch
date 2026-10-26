package io.opencensus.trace.unsafe;

import io.grpc.Context;
import io.opencensus.trace.ContextHandle;
import io.opencensus.trace.ContextManager;
import io.opencensus.trace.Span;
import javax.annotation.Nullable;

/* INFO: loaded from: classes4.dex */
public class ContextManagerImpl implements ContextManager {
    @Override // io.opencensus.trace.ContextManager
    public ContextHandle currentContext() {
        return wrapContext(Context.current());
    }

    @Override // io.opencensus.trace.ContextManager
    public ContextHandle withValue(ContextHandle contextHandle, @Nullable Span span) {
        return wrapContext(ContextUtils.withValue(unwrapContext(contextHandle), span));
    }

    @Override // io.opencensus.trace.ContextManager
    public Span getValue(ContextHandle contextHandle) {
        return ContextUtils.getValue(unwrapContext(contextHandle));
    }

    private static ContextHandle wrapContext(Context context) {
        return new ContextHandleImpl(context);
    }

    private static Context unwrapContext(ContextHandle contextHandle) {
        return ((ContextHandleImpl) contextHandle).getContext();
    }

    protected ContextManagerImpl() {
    }
}
