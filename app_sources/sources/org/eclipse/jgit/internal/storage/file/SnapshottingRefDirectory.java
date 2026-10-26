package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
class SnapshottingRefDirectory extends RefDirectory {
    private volatile boolean isValid;
    final RefDirectory refDb;
    private final Set<File> refreshedLooseRefDirs;

    /* INFO: Access modifiers changed from: private */
    @FunctionalInterface
    interface FunctionThrowsException<A, R, E extends Exception> {
        R apply(A a) throws Exception;
    }

    /* INFO: Access modifiers changed from: private */
    @FunctionalInterface
    interface SupplierThrowsException<R, E extends Exception> {
        R call() throws Exception;
    }

    /* INFO: Access modifiers changed from: private */
    @FunctionalInterface
    interface TriConsumerThrowsException<A1, A2, A3, E extends Exception> {
        void accept(A1 a1, A2 a2, A3 a3) throws Exception;
    }

    SnapshottingRefDirectory(RefDirectory refDirectory) {
        super(refDirectory);
        this.refreshedLooseRefDirs = ConcurrentHashMap.newKeySet();
        this.refDb = refDirectory;
    }

    @Override // org.eclipse.jgit.internal.storage.file.RefDirectory
    RefDirectory.PackedRefList getPackedRefs() throws IOException {
        if (!this.isValid) {
            synchronized (this) {
                if (!this.isValid) {
                    refreshSnapshot();
                }
            }
        }
        return this.packedRefs.get();
    }

    @Override // org.eclipse.jgit.internal.storage.file.RefDirectory
    void refreshPathToLooseRef(Path path) {
        for (int i = 1; i < path.getNameCount(); i++) {
            File fileFileFor = fileFor(path.subpath(0, i).toString());
            if (!this.refreshedLooseRefDirs.contains(fileFileFor)) {
                try {
                    InputStream inputStreamNewInputStream = Files.newInputStream(fileFileFor.toPath(), new OpenOption[0]);
                    if (inputStreamNewInputStream != null) {
                        inputStreamNewInputStream.close();
                    }
                    this.refreshedLooseRefDirs.add(fileFileFor);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (IOException unused) {
                        this.refreshedLooseRefDirs.add(fileFileFor);
                        return;
                    } catch (Throwable th2) {
                        this.refreshedLooseRefDirs.add(fileFileFor);
                        throw th2;
                    }
                }
            }
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.RefDirectory
    void delete(RefDirectoryUpdate refDirectoryUpdate) throws IOException {
        refreshSnapshot();
        super.delete(refDirectoryUpdate);
    }

    @Override // org.eclipse.jgit.internal.storage.file.RefDirectory, org.eclipse.jgit.lib.RefDatabase
    public RefDirectoryUpdate newUpdate(String str, boolean z) throws IOException {
        refreshSnapshot();
        return super.newUpdate(str, z);
    }

    @Override // org.eclipse.jgit.internal.storage.file.RefDirectory, org.eclipse.jgit.lib.RefDatabase
    public PackedBatchRefUpdate newBatchUpdate() {
        return new SnapshotPackedBatchRefUpdate(this);
    }

    @Override // org.eclipse.jgit.internal.storage.file.RefDirectory
    public PackedBatchRefUpdate newBatchUpdate(boolean z) {
        return new SnapshotPackedBatchRefUpdate(this, z);
    }

    @Override // org.eclipse.jgit.internal.storage.file.RefDirectory
    RefDirectoryUpdate newTemporaryUpdate() throws IOException {
        refreshSnapshot();
        return super.newTemporaryUpdate();
    }

    @Override // org.eclipse.jgit.internal.storage.file.RefDirectory
    RefDirectoryUpdate createRefDirectoryUpdate(Ref ref) {
        return new SnapshotRefDirectoryUpdate(this, ref);
    }

    @Override // org.eclipse.jgit.internal.storage.file.RefDirectory
    RefDirectoryRename createRefDirectoryRename(RefDirectoryUpdate refDirectoryUpdate, RefDirectoryUpdate refDirectoryUpdate2) {
        return new SnapshotRefDirectoryRename(refDirectoryUpdate, refDirectoryUpdate2);
    }

    synchronized void invalidateSnapshot() {
        this.refreshedLooseRefDirs.clear();
        this.isValid = false;
    }

    private synchronized void refreshSnapshot() throws IOException {
        compareAndSetPackedRefs(this.packedRefs.get(), this.refDb.getPackedRefs());
        this.isValid = true;
    }

    /* INFO: Access modifiers changed from: private */
    public static <T> T invalidateSnapshotOnError(SupplierThrowsException<T, IOException> supplierThrowsException, SnapshottingRefDirectory snapshottingRefDirectory) throws IOException {
        return (T) invalidateSnapshotOnError(new SnapshottingRefDirectory$$ExternalSyntheticLambda0(supplierThrowsException), null, snapshottingRefDirectory);
    }

    /* INFO: Access modifiers changed from: private */
    public static <A, R> R invalidateSnapshotOnError(FunctionThrowsException<A, R, IOException> functionThrowsException, A a, SnapshottingRefDirectory snapshottingRefDirectory) throws IOException {
        try {
            return functionThrowsException.apply(a);
        } catch (IOException e) {
            snapshottingRefDirectory.invalidateSnapshot();
            throw e;
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static <A1, A2, A3> void invalidateSnapshotOnError(TriConsumerThrowsException<A1, A2, A3, IOException> triConsumerThrowsException, A1 a1, A2 a2, A3 a3, SnapshottingRefDirectory snapshottingRefDirectory) throws Exception {
        try {
            triConsumerThrowsException.accept(a1, a2, a3);
        } catch (IOException e) {
            snapshottingRefDirectory.invalidateSnapshot();
            throw e;
        }
    }

    /* INFO: Access modifiers changed from: private */
    static class SnapshotRefDirectoryUpdate extends RefDirectoryUpdate {
        SnapshotRefDirectoryUpdate(RefDirectory refDirectory, Ref ref) {
            super(refDirectory, ref);
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        public RefUpdate.Result forceUpdate() throws IOException {
            return (RefUpdate.Result) SnapshottingRefDirectory.invalidateSnapshotOnError(new SnapshottingRefDirectory$SnapshotRefDirectoryUpdate$$ExternalSyntheticLambda3(this), getRefDatabase());
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        public RefUpdate.Result update() throws IOException {
            return (RefUpdate.Result) SnapshottingRefDirectory.invalidateSnapshotOnError(new SnapshottingRefDirectory$SnapshotRefDirectoryUpdate$$ExternalSyntheticLambda0(this), getRefDatabase());
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        public RefUpdate.Result update(RevWalk revWalk) throws IOException {
            return (RefUpdate.Result) SnapshottingRefDirectory.invalidateSnapshotOnError(new SnapshottingRefDirectory$SnapshotRefDirectoryUpdate$$ExternalSyntheticLambda4(this), revWalk, getRefDatabase());
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        public RefUpdate.Result delete() throws IOException {
            return (RefUpdate.Result) SnapshottingRefDirectory.invalidateSnapshotOnError(new SnapshottingRefDirectory$SnapshotRefDirectoryUpdate$$ExternalSyntheticLambda2(this), getRefDatabase());
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        public RefUpdate.Result delete(RevWalk revWalk) throws IOException {
            return (RefUpdate.Result) SnapshottingRefDirectory.invalidateSnapshotOnError(new SnapshottingRefDirectory$SnapshotRefDirectoryUpdate$$ExternalSyntheticLambda5(this), revWalk, getRefDatabase());
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        public RefUpdate.Result link(String str) throws IOException {
            return (RefUpdate.Result) SnapshottingRefDirectory.invalidateSnapshotOnError(new SnapshottingRefDirectory$SnapshotRefDirectoryUpdate$$ExternalSyntheticLambda1(this), str, getRefDatabase());
        }

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectoryUpdate
        protected void doAfterLocking(String str) {
            getRefDatabase().invalidateSnapshot();
        }

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectoryUpdate, org.eclipse.jgit.lib.RefUpdate
        public SnapshottingRefDirectory getRefDatabase() {
            return (SnapshottingRefDirectory) super.getRefDatabase();
        }
    }

    /* INFO: Access modifiers changed from: private */
    static class SnapshotRefDirectoryRename extends RefDirectoryRename {
        SnapshotRefDirectoryRename(RefDirectoryUpdate refDirectoryUpdate, RefDirectoryUpdate refDirectoryUpdate2) {
            super(refDirectoryUpdate, refDirectoryUpdate2);
        }

        @Override // org.eclipse.jgit.lib.RefRename
        public RefUpdate.Result rename() throws IOException {
            return (RefUpdate.Result) SnapshottingRefDirectory.invalidateSnapshotOnError(new SnapshottingRefDirectory$SnapshotRefDirectoryRename$$ExternalSyntheticLambda0(this), getRefDirectory());
        }

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectoryRename
        public SnapshottingRefDirectory getRefDirectory() {
            return (SnapshottingRefDirectory) super.getRefDirectory();
        }
    }

    /* INFO: Access modifiers changed from: private */
    static class SnapshotPackedBatchRefUpdate extends PackedBatchRefUpdate {
        SnapshotPackedBatchRefUpdate(RefDirectory refDirectory) {
            super(refDirectory);
        }

        SnapshotPackedBatchRefUpdate(RefDirectory refDirectory, boolean z) {
            super(refDirectory, z);
        }

        @Override // org.eclipse.jgit.internal.storage.file.PackedBatchRefUpdate, org.eclipse.jgit.lib.BatchRefUpdate
        public void execute(RevWalk revWalk, ProgressMonitor progressMonitor, List<String> list) throws Exception {
            SnapshottingRefDirectory.invalidateSnapshotOnError(new SnapshottingRefDirectory$SnapshotPackedBatchRefUpdate$$ExternalSyntheticLambda1(this), revWalk, progressMonitor, list, getRefDatabase());
        }

        @Override // org.eclipse.jgit.lib.BatchRefUpdate
        public void execute(RevWalk revWalk, ProgressMonitor progressMonitor) throws Exception {
            SnapshottingRefDirectory.invalidateSnapshotOnError(new SnapshottingRefDirectory$SnapshotPackedBatchRefUpdate$$ExternalSyntheticLambda0(this), revWalk, progressMonitor, null, getRefDatabase());
        }

        /* INFO: renamed from: lambda$1$org-eclipse-jgit-internal-storage-file-SnapshottingRefDirectory$SnapshotPackedBatchRefUpdate, reason: not valid java name */
        /* synthetic */ void m5731x5bd856e1(RevWalk revWalk, ProgressMonitor progressMonitor, Object obj) throws IOException {
            super.execute(revWalk, progressMonitor);
        }

        @Override // org.eclipse.jgit.lib.BatchRefUpdate
        public SnapshottingRefDirectory getRefDatabase() {
            return (SnapshottingRefDirectory) super.getRefDatabase();
        }
    }
}
