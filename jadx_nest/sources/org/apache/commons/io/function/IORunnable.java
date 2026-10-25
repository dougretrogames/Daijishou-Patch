package org.apache.commons.io.function;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IORunnable {
    void run() throws IOException;

    static IORunnable noop() {
        return Constants.IO_RUNNABLE;
    }

    default Runnable asRunnable() {
        return new IORunnable$$ExternalSyntheticLambda0(this);
    }
}
