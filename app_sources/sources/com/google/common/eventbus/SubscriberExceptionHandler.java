package com.google.common.eventbus;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public interface SubscriberExceptionHandler {
    void handleException(Throwable exception, SubscriberExceptionContext context);
}
