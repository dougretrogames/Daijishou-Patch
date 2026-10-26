package io.opencensus.trace;

import javax.annotation.Nullable;

/* INFO: loaded from: classes4.dex */
public interface ContextManager {
    ContextHandle currentContext();

    Span getValue(ContextHandle contextHandle);

    ContextHandle withValue(ContextHandle contextHandle, @Nullable Span span);
}
