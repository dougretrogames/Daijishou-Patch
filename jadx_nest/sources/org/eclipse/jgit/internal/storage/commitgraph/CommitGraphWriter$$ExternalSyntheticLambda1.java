package org.eclipse.jgit.internal.storage.commitgraph;

import java.util.function.ToLongFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CommitGraphWriter$$ExternalSyntheticLambda1 implements ToLongFunction {
    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        return ((CommitGraphWriter.ChunkHeader) obj).size;
    }
}
