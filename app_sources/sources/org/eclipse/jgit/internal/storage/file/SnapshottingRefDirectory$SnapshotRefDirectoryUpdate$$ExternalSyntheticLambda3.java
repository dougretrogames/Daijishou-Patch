package org.eclipse.jgit.internal.storage.file;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class SnapshottingRefDirectory$SnapshotRefDirectoryUpdate$$ExternalSyntheticLambda3 implements SnapshottingRefDirectory.SupplierThrowsException {
    public final /* synthetic */ SnapshottingRefDirectory.SnapshotRefDirectoryUpdate f$0;

    public /* synthetic */ SnapshottingRefDirectory$SnapshotRefDirectoryUpdate$$ExternalSyntheticLambda3(SnapshottingRefDirectory.SnapshotRefDirectoryUpdate snapshotRefDirectoryUpdate) {
        this.f$0 = snapshotRefDirectoryUpdate;
    }

    @Override // org.eclipse.jgit.internal.storage.file.SnapshottingRefDirectory.SupplierThrowsException
    public final Object call() {
        return super/*org.eclipse.jgit.internal.storage.file.RefDirectoryUpdate*/.forceUpdate();
    }
}
