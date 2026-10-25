package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class BlockSizeTooSmallException extends IOException {
    private static final long serialVersionUID = 1;
    private final int minBlockSize;

    BlockSizeTooSmallException(int i) {
        this.minBlockSize = i;
    }

    public int getMinimumBlockSize() {
        return this.minBlockSize;
    }
}
