package org.eclipse.jgit.revwalk;

import java.io.IOException;

/* INFO: loaded from: classes5.dex */
public class LIFORevQueue extends BlockRevQueue {
    private BlockRevQueue.Block head;

    @Override // org.eclipse.jgit.revwalk.BlockRevQueue, org.eclipse.jgit.revwalk.Generator
    public /* bridge */ /* synthetic */ void shareFreeList(BlockRevQueue blockRevQueue) {
        super.shareFreeList(blockRevQueue);
    }

    public LIFORevQueue() {
        super(false);
    }

    LIFORevQueue(Generator generator) throws IOException {
        super(generator);
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
    public void add(RevCommit revCommit) {
        BlockRevQueue.Block blockNewBlock = this.head;
        if (blockNewBlock == null || !blockNewBlock.canUnpop()) {
            blockNewBlock = this.free.newBlock();
            blockNewBlock.resetToEnd();
            blockNewBlock.next = this.head;
            this.head = blockNewBlock;
        }
        blockNewBlock.unpop(revCommit);
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue, org.eclipse.jgit.revwalk.Generator
    public RevCommit next() {
        BlockRevQueue.Block block = this.head;
        if (block == null) {
            return null;
        }
        RevCommit revCommitPop = block.pop();
        if (block.isEmpty()) {
            this.head = block.next;
            this.free.freeBlock(block);
        }
        return revCommitPop;
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
    public void clear() {
        this.head = null;
        this.free.clear();
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
    boolean everbodyHasFlag(int i) {
        for (BlockRevQueue.Block block = this.head; block != null; block = block.next) {
            for (int i2 = block.headIndex; i2 < block.tailIndex; i2++) {
                if ((block.commits[i2].flags & i) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
    boolean anybodyHasFlag(int i) {
        for (BlockRevQueue.Block block = this.head; block != null; block = block.next) {
            for (int i2 = block.headIndex; i2 < block.tailIndex; i2++) {
                if ((block.commits[i2].flags & i) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BlockRevQueue.Block block = this.head; block != null; block = block.next) {
            for (int i = block.headIndex; i < block.tailIndex; i++) {
                describe(sb, block.commits[i]);
            }
        }
        return sb.toString();
    }
}
