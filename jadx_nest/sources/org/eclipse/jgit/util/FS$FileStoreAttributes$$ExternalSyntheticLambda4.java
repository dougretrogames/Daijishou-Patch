package org.eclipse.jgit.util;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FS$FileStoreAttributes$$ExternalSyntheticLambda4 implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return FS.FileStoreAttributes.lambda$0(runnable);
    }
}
