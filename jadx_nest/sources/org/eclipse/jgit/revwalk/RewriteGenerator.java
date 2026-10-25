package org.eclipse.jgit.revwalk;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
class RewriteGenerator extends Generator {
    private static final int DUPLICATE = 16;
    private static final int REWRITE = 8;
    private final FIFORevQueue pending;
    private final Generator source;

    RewriteGenerator(Generator generator) {
        super(generator.firstParent);
        this.source = generator;
        this.pending = new FIFORevQueue(generator.firstParent);
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    void shareFreeList(BlockRevQueue blockRevQueue) {
        this.source.shareFreeList(blockRevQueue);
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return this.source.outputType() & (-5);
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    RevCommit next() throws IOException {
        RevCommit next = this.pending.next();
        if (next == null && (next = this.source.next()) == null) {
            return null;
        }
        applyFilterToParents(next);
        RevCommit[] parents = next.getParents();
        int length = parents.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            RevCommit revCommit = parents[i];
            RevCommit revCommitRewrite = rewrite(revCommit);
            if (this.firstParent) {
                if (revCommitRewrite == null) {
                    next.parents = RevCommit.NO_PARENTS;
                    return next;
                }
                next.parents = new RevCommit[]{revCommitRewrite};
                return next;
            }
            if (revCommit != revCommitRewrite) {
                parents[i] = revCommitRewrite;
                z = true;
            }
        }
        if (z) {
            next.parents = cleanup(parents);
        }
        return next;
    }

    private void applyFilterToParents(RevCommit revCommit) throws IOException {
        for (RevCommit revCommit2 : revCommit.getParents()) {
            while ((revCommit2.flags & 128) == 0) {
                RevCommit next = this.source.next();
                if (next == null) {
                    return;
                } else {
                    this.pending.add(next);
                }
            }
        }
    }

    private RevCommit rewrite(RevCommit revCommit) throws IOException {
        while (revCommit.getParentCount() <= 1 && (revCommit.flags & 4) == 0 && (revCommit.flags & 8) != 0) {
            if (revCommit.getParentCount() == 0) {
                return null;
            }
            applyFilterToParents(revCommit.getParent(0));
            revCommit = revCommit.getParent(0);
        }
        return revCommit;
    }

    private RevCommit[] cleanup(RevCommit[] revCommitArr) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < revCommitArr.length; i3++) {
            RevCommit revCommit = revCommitArr[i3];
            if (revCommit != null) {
                if ((revCommit.flags & 16) != 0) {
                    revCommitArr[i3] = null;
                } else {
                    revCommit.flags |= 16;
                    i2++;
                }
            }
        }
        if (i2 == revCommitArr.length) {
            int length = revCommitArr.length;
            while (i < length) {
                revCommitArr[i].flags &= -17;
                i++;
            }
            return revCommitArr;
        }
        RevCommit[] revCommitArr2 = new RevCommit[i2];
        int length2 = revCommitArr.length;
        int i4 = 0;
        while (i < length2) {
            RevCommit revCommit2 = revCommitArr[i];
            if (revCommit2 != null) {
                revCommitArr2[i4] = revCommit2;
                revCommit2.flags &= -17;
                i4++;
            }
            i++;
        }
        return revCommitArr2;
    }
}
