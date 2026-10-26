package io.opencensus.trace;

/* INFO: loaded from: classes4.dex */
public interface ContextHandle {
    ContextHandle attach();

    void detach(ContextHandle contextHandle);
}
