package io.grpc;

import javax.annotation.Nullable;

/* INFO: loaded from: classes4.dex */
public final class InternalStatus {
    public static final Metadata.Key<String> MESSAGE_KEY = Status.MESSAGE_KEY;
    public static final Metadata.Key<Status> CODE_KEY = Status.CODE_KEY;

    private InternalStatus() {
    }

    public static StatusRuntimeException asRuntimeExceptionWithoutStacktrace(Status status, @Nullable Metadata metadata) {
        return new InternalStatusRuntimeException(status, metadata);
    }
}
