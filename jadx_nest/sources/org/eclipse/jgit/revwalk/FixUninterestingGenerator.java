package org.eclipse.jgit.revwalk;

import java.io.IOException;

/* INFO: loaded from: classes5.dex */
final class FixUninterestingGenerator extends Generator {
    private final Generator pending;

    FixUninterestingGenerator(Generator generator) {
        super(generator.firstParent);
        this.pending = generator;
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return this.pending.outputType();
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    RevCommit next() throws IOException {
        RevCommit next;
        do {
            next = this.pending.next();
            if (next == null) {
                return null;
            }
        } while ((next.flags & 4) != 0);
        return next;
    }
}
