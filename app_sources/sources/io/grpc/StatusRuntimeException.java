package io.grpc;

import javax.annotation.Nullable;

/* INFO: loaded from: classes4.dex */
public class StatusRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1950934672280720624L;
    private final Status status;
    private final Metadata trailers;

    public StatusRuntimeException(Status status) {
        this(status, null);
    }

    public StatusRuntimeException(Status status, @Nullable Metadata metadata) {
        super(Status.formatThrowableMessage(status), status.getCause());
        this.status = status;
        this.trailers = metadata;
    }

    public final Status getStatus() {
        return this.status;
    }

    @Nullable
    public final Metadata getTrailers() {
        return this.trailers;
    }
}
