package org.eclipse.jgit.internal.storage.dfs;

import java.util.Comparator;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsPackCompactor$$ExternalSyntheticLambda1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Long.signum(((DfsPackCompactor.ObjectIdWithOffset) obj).offset - ((DfsPackCompactor.ObjectIdWithOffset) obj2).offset);
    }
}
