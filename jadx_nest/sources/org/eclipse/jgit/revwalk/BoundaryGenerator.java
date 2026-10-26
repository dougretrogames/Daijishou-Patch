package org.eclipse.jgit.revwalk;

import java.io.IOException;

/* INFO: loaded from: classes5.dex */
class BoundaryGenerator extends Generator {
    static final int UNINTERESTING = 4;
    Generator g;

    BoundaryGenerator(RevWalk revWalk, Generator generator) {
        super(generator.firstParent);
        this.g = new InitialGenerator(revWalk, generator);
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return this.g.outputType() | 16;
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    void shareFreeList(BlockRevQueue blockRevQueue) {
        this.g.shareFreeList(blockRevQueue);
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    RevCommit next() throws IOException {
        return this.g.next();
    }

    private class InitialGenerator extends Generator {
        private static final int DUPLICATE = 16;
        private static final int PARSED = 1;
        private final FIFORevQueue held;
        private final Generator source;
        private final RevWalk walk;

        InitialGenerator(RevWalk revWalk, Generator generator) {
            super(generator.firstParent);
            this.walk = revWalk;
            FIFORevQueue fIFORevQueue = new FIFORevQueue(this.firstParent);
            this.held = fIFORevQueue;
            this.source = generator;
            generator.shareFreeList(fIFORevQueue);
        }

        @Override // org.eclipse.jgit.revwalk.Generator
        int outputType() {
            return this.source.outputType();
        }

        @Override // org.eclipse.jgit.revwalk.Generator
        void shareFreeList(BlockRevQueue blockRevQueue) {
            blockRevQueue.shareFreeList(this.held);
        }

        @Override // org.eclipse.jgit.revwalk.Generator
        RevCommit next() throws IOException {
            RevCommit next = this.source.next();
            if (next != null) {
                int parentCount = next.getParentCount();
                for (int i = 0; i < parentCount && (!this.firstParent || i <= 0); i++) {
                    RevCommit parent = next.getParent(i);
                    if ((parent.flags & 4) != 0) {
                        this.held.add(parent);
                    }
                }
                return next;
            }
            FIFORevQueue fIFORevQueue = new FIFORevQueue(this.firstParent);
            fIFORevQueue.shareFreeList(this.held);
            while (true) {
                RevCommit next2 = this.held.next();
                if (next2 != null) {
                    if ((next2.flags & 16) == 0) {
                        if ((next2.flags & 1) == 0) {
                            next2.parseHeaders(this.walk);
                        }
                        next2.flags = 16 | next2.flags;
                        fIFORevQueue.add(next2);
                    }
                } else {
                    fIFORevQueue.removeFlag(16);
                    BoundaryGenerator.this.g = fIFORevQueue;
                    return fIFORevQueue.next();
                }
            }
        }
    }
}
