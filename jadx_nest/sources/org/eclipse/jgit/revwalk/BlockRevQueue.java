package org.eclipse.jgit.revwalk;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
abstract class BlockRevQueue extends AbstractRevQueue {
    protected BlockFreeList free;

    protected BlockRevQueue(boolean z) {
        super(z);
        this.free = new BlockFreeList();
    }

    BlockRevQueue(Generator generator) throws IOException {
        super(generator.firstParent);
        this.free = new BlockFreeList();
        this.outputType = generator.outputType();
        generator.shareFreeList(this);
        while (true) {
            RevCommit next = generator.next();
            if (next == null) {
                return;
            } else {
                add(next);
            }
        }
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    public void shareFreeList(BlockRevQueue blockRevQueue) {
        this.free = blockRevQueue.free;
    }

    static final class BlockFreeList {
        private Block next;

        BlockFreeList() {
        }

        Block newBlock() {
            Block block = this.next;
            if (block == null) {
                return new Block();
            }
            this.next = block.next;
            block.clear();
            return block;
        }

        void freeBlock(Block block) {
            block.next = this.next;
            this.next = block;
        }

        void clear() {
            this.next = null;
        }
    }

    static final class Block {
        static final int BLOCK_SIZE = 256;
        final RevCommit[] commits = new RevCommit[256];
        int headIndex;
        Block next;
        int tailIndex;

        Block() {
        }

        boolean isFull() {
            return this.tailIndex == 256;
        }

        boolean isEmpty() {
            return this.headIndex == this.tailIndex;
        }

        boolean canUnpop() {
            return this.headIndex > 0;
        }

        void add(RevCommit revCommit) {
            RevCommit[] revCommitArr = this.commits;
            int i = this.tailIndex;
            this.tailIndex = i + 1;
            revCommitArr[i] = revCommit;
        }

        void unpop(RevCommit revCommit) {
            RevCommit[] revCommitArr = this.commits;
            int i = this.headIndex - 1;
            this.headIndex = i;
            revCommitArr[i] = revCommit;
        }

        RevCommit pop() {
            RevCommit[] revCommitArr = this.commits;
            int i = this.headIndex;
            this.headIndex = i + 1;
            return revCommitArr[i];
        }

        RevCommit peek() {
            return this.commits[this.headIndex];
        }

        void clear() {
            this.next = null;
            this.headIndex = 0;
            this.tailIndex = 0;
        }

        void resetToMiddle() {
            this.tailIndex = 128;
            this.headIndex = 128;
        }

        void resetToEnd() {
            this.tailIndex = 256;
            this.headIndex = 256;
        }
    }
}
