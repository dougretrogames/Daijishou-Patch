package org.eclipse.jgit.revwalk;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class FIFORevQueue extends BlockRevQueue {
    private BlockRevQueue.Block head;
    private BlockRevQueue.Block tail;

    @Override // org.eclipse.jgit.revwalk.BlockRevQueue, org.eclipse.jgit.revwalk.Generator
    public /* bridge */ /* synthetic */ void shareFreeList(BlockRevQueue blockRevQueue) {
        super.shareFreeList(blockRevQueue);
    }

    public FIFORevQueue() {
        super(false);
    }

    FIFORevQueue(boolean z) {
        super(z);
    }

    FIFORevQueue(Generator generator) throws IOException {
        super(generator);
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
    public void add(RevCommit revCommit) {
        BlockRevQueue.Block blockNewBlock = this.tail;
        if (blockNewBlock == null) {
            BlockRevQueue.Block blockNewBlock2 = this.free.newBlock();
            blockNewBlock2.add(revCommit);
            this.head = blockNewBlock2;
            this.tail = blockNewBlock2;
            return;
        }
        if (blockNewBlock.isFull()) {
            blockNewBlock = this.free.newBlock();
            this.tail.next = blockNewBlock;
            this.tail = blockNewBlock;
        }
        blockNewBlock.add(revCommit);
    }

    public void unpop(RevCommit revCommit) {
        BlockRevQueue.Block block = this.head;
        if (block == null) {
            BlockRevQueue.Block blockNewBlock = this.free.newBlock();
            blockNewBlock.resetToMiddle();
            blockNewBlock.add(revCommit);
            this.head = blockNewBlock;
            this.tail = blockNewBlock;
            return;
        }
        if (block.canUnpop()) {
            block.unpop(revCommit);
            return;
        }
        BlockRevQueue.Block blockNewBlock2 = this.free.newBlock();
        blockNewBlock2.resetToEnd();
        blockNewBlock2.unpop(revCommit);
        blockNewBlock2.next = this.head;
        this.head = blockNewBlock2;
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue, org.eclipse.jgit.revwalk.Generator
    public RevCommit next() {
        BlockRevQueue.Block block = this.head;
        if (block == null) {
            return null;
        }
        RevCommit revCommitPop = block.pop();
        if (block.isEmpty()) {
            BlockRevQueue.Block block2 = block.next;
            this.head = block2;
            if (block2 == null) {
                this.tail = null;
            }
            this.free.freeBlock(block);
        }
        return revCommitPop;
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
    public void clear() {
        this.head = null;
        this.tail = null;
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

    void removeFlag(int i) {
        int i2 = ~i;
        for (BlockRevQueue.Block block = this.head; block != null; block = block.next) {
            for (int i3 = block.headIndex; i3 < block.tailIndex; i3++) {
                block.commits[i3].flags &= i2;
            }
        }
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
