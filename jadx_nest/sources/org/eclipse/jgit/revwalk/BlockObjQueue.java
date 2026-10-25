package org.eclipse.jgit.revwalk;

/* JADX INFO: loaded from: classes5.dex */
class BlockObjQueue {
    private BlockFreeList free = new BlockFreeList();
    private Block head;
    private Block tail;

    BlockObjQueue() {
    }

    void add(RevObject revObject) {
        Block blockNewBlock = this.tail;
        if (blockNewBlock == null) {
            Block blockNewBlock2 = this.free.newBlock();
            blockNewBlock2.add(revObject);
            this.head = blockNewBlock2;
            this.tail = blockNewBlock2;
            return;
        }
        if (blockNewBlock.isFull()) {
            blockNewBlock = this.free.newBlock();
            this.tail.next = blockNewBlock;
            this.tail = blockNewBlock;
        }
        blockNewBlock.add(revObject);
    }

    RevObject next() {
        Block block = this.head;
        if (block == null) {
            return null;
        }
        RevObject revObjectPop = block.pop();
        if (block.isEmpty()) {
            Block block2 = block.next;
            this.head = block2;
            if (block2 == null) {
                this.tail = null;
            }
            this.free.freeBlock(block);
        }
        return revObjectPop;
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
    }

    static final class Block {
        private static final int BLOCK_SIZE = 256;
        int headIndex;
        Block next;
        final RevObject[] objects = new RevObject[256];
        int tailIndex;

        Block() {
        }

        boolean isFull() {
            return this.tailIndex == 256;
        }

        boolean isEmpty() {
            return this.headIndex == this.tailIndex;
        }

        void add(RevObject revObject) {
            RevObject[] revObjectArr = this.objects;
            int i = this.tailIndex;
            this.tailIndex = i + 1;
            revObjectArr[i] = revObject;
        }

        RevObject pop() {
            RevObject[] revObjectArr = this.objects;
            int i = this.headIndex;
            this.headIndex = i + 1;
            return revObjectArr[i];
        }

        void clear() {
            this.next = null;
            this.headIndex = 0;
            this.tailIndex = 0;
        }
    }
}
