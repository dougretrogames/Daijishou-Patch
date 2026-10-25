package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RefCursor implements AutoCloseable {
    @Override // java.lang.AutoCloseable
    public abstract void close();

    public abstract Ref getRef();

    public abstract boolean next() throws IOException;

    public abstract void seekPastPrefix(String str) throws IOException;

    public boolean wasDeleted() {
        Ref ref = getRef();
        return ref.getStorage() == Ref.Storage.NEW && ref.getObjectId() == null;
    }
}
