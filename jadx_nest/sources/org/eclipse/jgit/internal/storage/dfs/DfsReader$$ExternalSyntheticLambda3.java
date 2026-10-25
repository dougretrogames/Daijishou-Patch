package org.eclipse.jgit.internal.storage.dfs;

import java.util.Comparator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsReader$$ExternalSyntheticLambda3 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Long.signum(((DfsObjectToPack) obj).getOffset() - ((DfsObjectToPack) obj2).getOffset());
    }
}
