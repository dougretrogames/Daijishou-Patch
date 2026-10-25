package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.filter.AndRevFilter;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilter;

/* JADX INFO: loaded from: classes5.dex */
class StartGenerator extends Generator {
    private final RevWalk walker;

    @Override // org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return 0;
    }

    StartGenerator(RevWalk revWalk) {
        super(revWalk.isFirstParent());
        this.walker = revWalk;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0125  */
    /* JADX WARN: Code duplicated, block: B:67:0x012d  */
    /* JADX WARN: Code duplicated, block: B:69:0x0134  */
    /* JADX WARN: Code duplicated, block: B:70:0x0136  */
    /* JADX WARN: Code duplicated, block: B:72:0x013c  */
    @Override // org.eclipse.jgit.revwalk.Generator
    RevCommit next() throws IOException {
        DateRevQueue dateRevQueueNewDateRevQueue;
        int i;
        Generator delayRevQueue;
        Generator topoNonIntermixSortGenerator;
        Generator fixUninterestingGenerator;
        int i2;
        RevWalk revWalk = this.walker;
        RevFilter revFilter = revWalk.getRevFilter();
        TreeFilter treeFilter = revWalk.getTreeFilter();
        AbstractRevQueue abstractRevQueue = this.walker.queue;
        if (revFilter == RevFilter.MERGE_BASE) {
            if (treeFilter != TreeFilter.ALL) {
                throw new IllegalStateException(MessageFormat.format(JGitText.get().cannotCombineTreeFilterWithRevFilter, treeFilter, revFilter));
            }
            if (revWalk.isFirstParent()) {
                throw new IllegalStateException(JGitText.get().cannotFindMergeBaseUsingFirstParent);
            }
            MergeBaseGenerator mergeBaseGenerator = new MergeBaseGenerator(revWalk);
            this.walker.pending = mergeBaseGenerator;
            this.walker.queue = AbstractRevQueue.EMPTY_QUEUE;
            mergeBaseGenerator.init(abstractRevQueue);
            return mergeBaseGenerator.next();
        }
        boolean zAnybodyHasFlag = abstractRevQueue.anybodyHasFlag(4);
        boolean zHasRevSort = this.walker.hasRevSort(RevSort.BOUNDARY);
        if (!zHasRevSort && (this.walker instanceof ObjectWalk)) {
            zHasRevSort = true;
        }
        if (zHasRevSort && !zAnybodyHasFlag) {
            zHasRevSort = false;
        }
        if (abstractRevQueue instanceof DateRevQueue) {
            dateRevQueueNewDateRevQueue = (DateRevQueue) abstractRevQueue;
        } else {
            dateRevQueueNewDateRevQueue = RevWalk.newDateRevQueue(abstractRevQueue);
        }
        if (treeFilter != TreeFilter.ALL) {
            if (revWalk.getRewriteParents()) {
                i = 6;
                i2 = 8;
            } else {
                i = 0;
                i2 = 0;
            }
            revFilter = AndRevFilter.create(new TreeRevFilter(revWalk, treeFilter, i2), revFilter);
        } else {
            i = 0;
        }
        this.walker.queue = abstractRevQueue;
        Object obj = this.walker;
        if (obj instanceof DepthWalk) {
            delayRevQueue = new DepthGenerator((DepthWalk) obj, dateRevQueueNewDateRevQueue);
        } else {
            PendingGenerator pendingGenerator = new PendingGenerator(revWalk, dateRevQueueNewDateRevQueue, revFilter, i);
            if (this.walker.hasRevSort(RevSort.BOUNDARY)) {
                pendingGenerator.canDispose = false;
            }
            delayRevQueue = pendingGenerator;
        }
        if ((delayRevQueue.outputType() & 4) != 0) {
            delayRevQueue = new RewriteGenerator(delayRevQueue);
        }
        if (this.walker.hasRevSort(RevSort.TOPO) && this.walker.hasRevSort(RevSort.TOPO_KEEP_BRANCH_TOGETHER)) {
            throw new IllegalStateException(JGitText.get().cannotCombineTopoSortWithTopoKeepBranchTogetherSort);
        }
        if (this.walker.hasRevSort(RevSort.TOPO) && (delayRevQueue.outputType() & 8) == 0) {
            topoNonIntermixSortGenerator = new TopoSortGenerator(delayRevQueue);
        } else {
            if (this.walker.hasRevSort(RevSort.TOPO_KEEP_BRANCH_TOGETHER) && (delayRevQueue.outputType() & 8) == 0) {
                topoNonIntermixSortGenerator = new TopoNonIntermixSortGenerator(delayRevQueue);
            }
            if (this.walker.hasRevSort(RevSort.REVERSE)) {
                delayRevQueue = new LIFORevQueue(delayRevQueue);
            }
            if (zHasRevSort) {
                fixUninterestingGenerator = new BoundaryGenerator(revWalk, delayRevQueue);
            } else {
                if (zAnybodyHasFlag) {
                    if (dateRevQueueNewDateRevQueue.peek() != null) {
                        delayRevQueue = new DelayRevQueue(delayRevQueue);
                    }
                    fixUninterestingGenerator = new FixUninterestingGenerator(delayRevQueue);
                }
                revWalk.pending = delayRevQueue;
                return delayRevQueue.next();
            }
            delayRevQueue = fixUninterestingGenerator;
            revWalk.pending = delayRevQueue;
            return delayRevQueue.next();
        }
        delayRevQueue = topoNonIntermixSortGenerator;
        if (this.walker.hasRevSort(RevSort.REVERSE)) {
            delayRevQueue = new LIFORevQueue(delayRevQueue);
        }
        if (zHasRevSort) {
            fixUninterestingGenerator = new BoundaryGenerator(revWalk, delayRevQueue);
        } else {
            if (zAnybodyHasFlag) {
                if (dateRevQueueNewDateRevQueue.peek() != null) {
                    delayRevQueue = new DelayRevQueue(delayRevQueue);
                }
                fixUninterestingGenerator = new FixUninterestingGenerator(delayRevQueue);
            }
            revWalk.pending = delayRevQueue;
            return delayRevQueue.next();
        }
        delayRevQueue = fixUninterestingGenerator;
        revWalk.pending = delayRevQueue;
        return delayRevQueue.next();
    }
}
