package org.eclipse.jgit.revwalk;

import java.io.IOException;
import org.eclipse.jgit.errors.StopWalkException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.revwalk.filter.RevFilter;

/* JADX INFO: loaded from: classes5.dex */
class PendingGenerator extends Generator {
    private static final RevCommit INIT_LAST;
    static final int OVER_SCAN = 6;
    private static final int PARSED = 1;
    private static final int SEEN = 2;
    private static final int UNINTERESTING = 4;
    boolean canDispose;
    private final RevFilter filter;
    private RevCommit last;
    private final int output;
    private int overScan;
    private final DateRevQueue pending;
    private final RevWalk walker;

    static {
        RevCommit revCommit = new RevCommit(ObjectId.zeroId());
        INIT_LAST = revCommit;
        revCommit.commitTime = Integer.MAX_VALUE;
    }

    PendingGenerator(RevWalk revWalk, DateRevQueue dateRevQueue, RevFilter revFilter, int i) {
        super(revWalk.isFirstParent());
        this.last = INIT_LAST;
        this.overScan = 6;
        this.walker = revWalk;
        this.pending = dateRevQueue;
        this.filter = revFilter;
        this.output = i;
        this.canDispose = true;
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return this.output | 1;
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    RevCommit next() throws IOException {
        boolean zInclude;
        while (true) {
            try {
                RevCommit next = this.pending.next();
                if (next == null) {
                    return null;
                }
                if ((next.flags & 4) != 0) {
                    zInclude = false;
                } else {
                    if (this.filter.requiresCommitBody()) {
                        next.parseBody(this.walker);
                    }
                    zInclude = this.filter.include(this.walker, next);
                }
                int parentCount = next.getParentCount();
                for (int i = 0; i < parentCount; i++) {
                    RevCommit parent = next.getParent(i);
                    if ((!this.firstParent || i <= 0 || (next.flags & 4) != 0) && (parent.flags & 2) == 0) {
                        if ((parent.flags & 1) == 0) {
                            parent.parseHeaders(this.walker);
                        }
                        parent.flags |= 2;
                        this.pending.add(parent);
                    }
                }
                this.walker.carryFlagsImpl(next);
                if ((next.flags & 4) != 0) {
                    if (this.pending.everbodyHasFlag(4)) {
                        RevCommit revCommitPeek = this.pending.peek();
                        if (revCommitPeek != null && revCommitPeek.commitTime >= this.last.commitTime) {
                            this.overScan = 6;
                        } else {
                            int i2 = this.overScan - 1;
                            this.overScan = i2;
                            if (i2 == 0) {
                                throw StopWalkException.INSTANCE;
                            }
                        }
                    } else {
                        this.overScan = 6;
                    }
                    if (this.canDispose) {
                        next.disposeBody();
                    }
                } else {
                    if (zInclude) {
                        this.last = next;
                        return next;
                    }
                    if (this.canDispose) {
                        next.disposeBody();
                    }
                }
            } catch (StopWalkException unused) {
                this.pending.clear();
                return null;
            }
        }
    }
}
