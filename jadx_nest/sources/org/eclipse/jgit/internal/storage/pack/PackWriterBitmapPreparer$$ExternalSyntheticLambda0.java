package org.eclipse.jgit.internal.storage.pack;

import java.util.Comparator;
import org.eclipse.jgit.revwalk.RevCommit;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PackWriterBitmapPreparer$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Integer.signum(((RevCommit) obj2).getCommitTime() - ((RevCommit) obj).getCommitTime());
    }
}
