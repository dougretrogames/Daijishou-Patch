package io.grpc;

import javax.annotation.Nullable;

/* INFO: loaded from: classes4.dex */
class InternalStatusRuntimeException extends StatusRuntimeException {
    private static final long serialVersionUID = 0;

    public InternalStatusRuntimeException(Status status, @Nullable Metadata metadata) {
        super(status, metadata);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
