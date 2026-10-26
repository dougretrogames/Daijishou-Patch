package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayDeque;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
class MergeBaseGenerator extends Generator {
    private static final int CONTINUE = 0;
    private static final int CONTINUE_ON_STACK = 2;
    private static final int HAVE_ALL = 1;
    private static final int IN_PENDING = 2;
    private static final int MERGE_BASE = 8;
    private static final int PARSED = 1;
    private static final int POPPED = 16;
    private int branchMask;
    private int mergeBaseAncestor;
    private final DateRevQueue pending;
    private int recarryMask;
    private int recarryTest;
    private ArrayDeque<RevCommit> ret;
    private CarryStack stack;
    private final RevWalk walker;

    @Override // org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return 0;
    }

    MergeBaseGenerator(RevWalk revWalk) {
        super(revWalk.isFirstParent());
        this.mergeBaseAncestor = -1;
        this.ret = new ArrayDeque<>();
        this.walker = revWalk;
        this.pending = new DateRevQueue(this.firstParent);
    }

    void init(AbstractRevQueue abstractRevQueue) throws IOException {
        while (true) {
            try {
                RevCommit next = abstractRevQueue.next();
                if (next == null) {
                    break;
                } else {
                    add(next);
                }
            } catch (Throwable th) {
                this.walker.freeFlag(this.branchMask | this.mergeBaseAncestor);
                throw th;
            }
        }
        int i = this.branchMask;
        this.recarryTest = i | 16;
        this.recarryMask = i | 24;
        this.mergeBaseAncestor = this.walker.allocFlag();
        while (true) {
            RevCommit revCommit_next = _next();
            if (revCommit_next != null) {
                this.ret.add(revCommit_next);
            } else {
                this.walker.freeFlag(this.branchMask | this.mergeBaseAncestor);
                return;
            }
        }
    }

    private void add(RevCommit revCommit) {
        int iAllocFlag = this.walker.allocFlag();
        this.branchMask |= iAllocFlag;
        if ((revCommit.flags & this.branchMask) != 0) {
            throw new IllegalStateException(MessageFormat.format(JGitText.get().staleRevFlagsOn, revCommit.name()));
        }
        revCommit.flags = iAllocFlag | revCommit.flags;
        this.pending.add(revCommit);
    }

    private RevCommit _next() throws IOException {
        while (true) {
            RevCommit next = this.pending.next();
            if (next == null) {
                return null;
            }
            for (RevCommit revCommit : next.getParents()) {
                if ((revCommit.flags & 2) == 0) {
                    if ((1 & revCommit.flags) == 0) {
                        revCommit.parseHeaders(this.walker);
                    }
                    revCommit.flags |= 2;
                    this.pending.add(revCommit);
                }
            }
            int i = next.flags;
            int i2 = this.branchMask;
            int i3 = i & i2;
            boolean z = i3 == i2;
            if (z) {
                i3 |= this.mergeBaseAncestor | 8;
            }
            carryOntoHistory(next, i3);
            if ((next.flags & 8) != 0) {
                if (this.pending.everbodyHasFlag(8)) {
                    return null;
                }
            } else {
                next.flags |= 16;
                if (z) {
                    next.flags |= 8;
                    return next;
                }
            }
        }
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    RevCommit next() throws IOException {
        while (!this.ret.isEmpty()) {
            RevCommit revCommitRemove = this.ret.remove();
            if ((revCommitRemove.flags & this.mergeBaseAncestor) == 0) {
                return revCommitRemove;
            }
        }
        return null;
    }

    private void carryOntoHistory(RevCommit revCommit, int i) {
        this.stack = null;
        while (true) {
            carryOntoHistoryInnerLoop(revCommit, i);
            CarryStack carryStack = this.stack;
            if (carryStack == null) {
                return;
            }
            revCommit = carryStack.c;
            i = this.stack.carry;
            this.stack = this.stack.prev;
        }
    }

    private void carryOntoHistoryInnerLoop(RevCommit revCommit, int i) {
        do {
            RevCommit[] parents = revCommit.getParents();
            if (parents == null || parents.length == 0) {
                return;
            }
            int length = parents.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                RevCommit revCommit2 = parents[i2];
                if (carryOntoOne(revCommit2, i) == 0) {
                    this.stack = new CarryStack(this.stack, revCommit2, i);
                }
            }
            revCommit = parents[length];
        } while (carryOntoOne(revCommit, i) == 0);
    }

    private int carryOntoOne(RevCommit revCommit, int i) {
        int i2 = (revCommit.flags & i) == i ? 1 : 0;
        revCommit.flags = i | revCommit.flags;
        if ((revCommit.flags & this.recarryMask) != this.recarryTest) {
            return i2;
        }
        revCommit.flags &= -17;
        this.pending.add(revCommit);
        this.stack = new CarryStack(this.stack, revCommit, this.branchMask | 8);
        return 2;
    }

    private static class CarryStack {
        final RevCommit c;
        final int carry;
        final CarryStack prev;

        CarryStack(CarryStack carryStack, RevCommit revCommit, int i) {
            this.prev = carryStack;
            this.c = revCommit;
            this.carry = i;
        }
    }
}
