package org.eclipse.jgit.internal.storage.file;

import java.util.List;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SnapshottingRefDirectory$SnapshotPackedBatchRefUpdate$$ExternalSyntheticLambda1 implements SnapshottingRefDirectory.TriConsumerThrowsException {
    public final /* synthetic */ SnapshottingRefDirectory.SnapshotPackedBatchRefUpdate f$0;

    public /* synthetic */ SnapshottingRefDirectory$SnapshotPackedBatchRefUpdate$$ExternalSyntheticLambda1(SnapshottingRefDirectory.SnapshotPackedBatchRefUpdate snapshotPackedBatchRefUpdate) {
        this.f$0 = snapshotPackedBatchRefUpdate;
    }

    @Override // org.eclipse.jgit.internal.storage.file.SnapshottingRefDirectory.TriConsumerThrowsException
    public final void accept(Object obj, Object obj2, Object obj3) throws Throwable {
        super/*org.eclipse.jgit.internal.storage.file.PackedBatchRefUpdate*/.execute((RevWalk) obj, (ProgressMonitor) obj2, (List) obj3);
    }
}
