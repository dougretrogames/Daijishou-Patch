package org.eclipse.jgit.revwalk;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
abstract class Generator {
    static final int HAS_REWRITE = 2;
    static final int HAS_UNINTERESTING = 16;
    static final int NEEDS_REWRITE = 4;
    static final int SORT_COMMIT_TIME_DESC = 1;
    static final int SORT_TOPO = 8;
    protected final boolean firstParent;

    abstract RevCommit next() throws IOException;

    abstract int outputType();

    void shareFreeList(BlockRevQueue blockRevQueue) {
    }

    protected Generator(boolean z) {
        this.firstParent = z;
    }
}
