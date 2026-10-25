package org.eclipse.jgit.lib;

import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IndexDiff$$ExternalSyntheticLambda0 implements IndexDiff.WorkingTreeIteratorFactory {
    @Override // org.eclipse.jgit.lib.IndexDiff.WorkingTreeIteratorFactory
    public final WorkingTreeIterator getWorkingTreeIterator(Repository repository) {
        return new FileTreeIterator(repository);
    }
}
