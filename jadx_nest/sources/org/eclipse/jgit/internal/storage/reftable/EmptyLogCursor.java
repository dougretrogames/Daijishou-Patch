package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;
import org.eclipse.jgit.lib.ReflogEntry;

/* JADX INFO: loaded from: classes5.dex */
class EmptyLogCursor extends LogCursor {
    @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
    public String getRefName() {
        return null;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
    public ReflogEntry getReflogEntry() {
        return null;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
    public long getUpdateIndex() {
        return 0L;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
    public boolean next() throws IOException {
        return false;
    }

    EmptyLogCursor() {
    }
}
