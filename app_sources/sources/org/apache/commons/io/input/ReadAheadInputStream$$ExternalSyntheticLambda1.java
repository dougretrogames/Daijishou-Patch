package org.apache.commons.io.input;

import java.util.concurrent.ThreadFactory;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class ReadAheadInputStream$$ExternalSyntheticLambda1 implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return ReadAheadInputStream.newDaemonThread(runnable);
    }
}
