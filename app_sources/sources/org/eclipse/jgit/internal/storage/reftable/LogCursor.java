package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.lib.ReflogEntry;

/* INFO: loaded from: classes5.dex */
public abstract class LogCursor implements AutoCloseable {
    @Override // java.lang.AutoCloseable
    public abstract void close();

    public abstract String getRefName();

    @Nullable
    public abstract ReflogEntry getReflogEntry();

    public abstract long getUpdateIndex();

    public abstract boolean next() throws IOException;
}
