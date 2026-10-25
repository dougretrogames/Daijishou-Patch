package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SnapshottingRefDirectory$SnapshotPackedBatchRefUpdate$$ExternalSyntheticLambda0 implements SnapshottingRefDirectory.TriConsumerThrowsException {
    public final /* synthetic */ SnapshottingRefDirectory.SnapshotPackedBatchRefUpdate f$0;

    public /* synthetic */ SnapshottingRefDirectory$SnapshotPackedBatchRefUpdate$$ExternalSyntheticLambda0(SnapshottingRefDirectory.SnapshotPackedBatchRefUpdate snapshotPackedBatchRefUpdate) {
        this.f$0 = snapshotPackedBatchRefUpdate;
    }

    @Override // org.eclipse.jgit.internal.storage.file.SnapshottingRefDirectory.TriConsumerThrowsException
    public final void accept(Object obj, Object obj2, Object obj3) throws IOException {
        this.f$0.m5731x5bd856e1((RevWalk) obj, (ProgressMonitor) obj2, obj3);
    }
}
