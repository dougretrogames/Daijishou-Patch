package org.apache.commons.io.input;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Tailer$Builder$$ExternalSyntheticLambda0 implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return Tailer.Builder.newDaemonThread(runnable);
    }
}
