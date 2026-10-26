package com.google.api.client.http;

import java.io.IOException;

/* INFO: loaded from: classes3.dex */
@Deprecated
public interface BackOffPolicy {
    public static final long STOP = -1;

    long getNextBackOffMillis() throws IOException;

    boolean isBackOffRequired(int i);

    void reset();
}
