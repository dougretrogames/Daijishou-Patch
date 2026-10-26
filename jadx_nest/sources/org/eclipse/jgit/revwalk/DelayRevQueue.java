package org.eclipse.jgit.revwalk;

import java.io.IOException;

/* INFO: loaded from: classes5.dex */
final class DelayRevQueue extends Generator {
    private static final int OVER_SCAN = 6;
    private final FIFORevQueue delay;
    private final Generator pending;
    private int size;

    DelayRevQueue(Generator generator) {
        super(generator.firstParent);
        this.pending = generator;
        this.delay = new FIFORevQueue();
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return this.pending.outputType();
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    RevCommit next() throws IOException {
        RevCommit next;
        while (this.size < 6 && (next = this.pending.next()) != null) {
            this.delay.add(next);
            this.size++;
        }
        RevCommit next2 = this.delay.next();
        if (next2 == null) {
            return null;
        }
        this.size--;
        return next2;
    }
}
