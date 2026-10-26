package org.eclipse.jgit.internal.storage.file;

import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class SnapshottingRefDirectory$SnapshotRefDirectoryUpdate$$ExternalSyntheticLambda4 implements SnapshottingRefDirectory.FunctionThrowsException {
    public final /* synthetic */ SnapshottingRefDirectory.SnapshotRefDirectoryUpdate f$0;

    public /* synthetic */ SnapshottingRefDirectory$SnapshotRefDirectoryUpdate$$ExternalSyntheticLambda4(SnapshottingRefDirectory.SnapshotRefDirectoryUpdate snapshotRefDirectoryUpdate) {
        this.f$0 = snapshotRefDirectoryUpdate;
    }

    @Override // org.eclipse.jgit.internal.storage.file.SnapshottingRefDirectory.FunctionThrowsException
    public final Object apply(Object obj) {
        return super/*org.eclipse.jgit.internal.storage.file.RefDirectoryUpdate*/.update((RevWalk) obj);
    }
}
