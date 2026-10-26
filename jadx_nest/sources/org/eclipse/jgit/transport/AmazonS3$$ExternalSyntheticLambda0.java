package org.eclipse.jgit.transport;

import java.util.function.ToLongFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class AmazonS3$$ExternalSyntheticLambda0 implements ToLongFunction {
    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        return ((AmazonS3.KeyInfo) obj).getLastModifiedSecs();
    }
}
