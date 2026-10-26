package org.eclipse.jgit.revwalk;

import java.io.IOException;

/* INFO: loaded from: classes5.dex */
class TopoSortGenerator extends Generator {
    private static final int TOPO_DELAY = 32;
    private final int outputType;
    private final FIFORevQueue pending;

    TopoSortGenerator(Generator generator) throws IOException {
        super(generator.firstParent);
        FIFORevQueue fIFORevQueue = new FIFORevQueue(this.firstParent);
        this.pending = fIFORevQueue;
        this.outputType = generator.outputType() | 8;
        generator.shareFreeList(fIFORevQueue);
        while (true) {
            RevCommit next = generator.next();
            if (next == null) {
                return;
            }
            for (RevCommit revCommit : next.getParents()) {
                revCommit.inDegree++;
                if (this.firstParent) {
                    break;
                }
            }
            this.pending.add(next);
        }
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return this.outputType;
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    void shareFreeList(BlockRevQueue blockRevQueue) {
        blockRevQueue.shareFreeList(this.pending);
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    RevCommit next() throws IOException {
        while (true) {
            RevCommit next = this.pending.next();
            if (next == null) {
                return null;
            }
            if (next.inDegree > 0) {
                next.flags |= 32;
            } else {
                for (RevCommit revCommit : next.getParents()) {
                    int i = revCommit.inDegree - 1;
                    revCommit.inDegree = i;
                    if (i == 0 && (revCommit.flags & 32) != 0) {
                        revCommit.flags &= -33;
                        this.pending.unpop(revCommit);
                    }
                    if (this.firstParent) {
                        break;
                    }
                }
                return next;
            }
        }
    }
}
