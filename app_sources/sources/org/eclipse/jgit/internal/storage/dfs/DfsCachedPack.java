package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import org.eclipse.jgit.internal.storage.pack.CachedPack;
import org.eclipse.jgit.internal.storage.pack.ObjectToPack;
import org.eclipse.jgit.internal.storage.pack.PackOutputStream;
import org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation;

/* INFO: loaded from: classes5.dex */
public class DfsCachedPack extends CachedPack {
    private final DfsPackFile pack;

    DfsCachedPack(DfsPackFile dfsPackFile) {
        this.pack = dfsPackFile;
    }

    public DfsPackFile getPackFile() {
        return this.pack;
    }

    public DfsPackDescription getPackDescription() {
        return this.pack.getPackDescription();
    }

    @Override // org.eclipse.jgit.internal.storage.pack.CachedPack
    public long getObjectCount() throws IOException {
        return getPackDescription().getObjectCount();
    }

    @Override // org.eclipse.jgit.internal.storage.pack.CachedPack
    public long getDeltaCount() throws IOException {
        return getPackDescription().getDeltaCount();
    }

    @Override // org.eclipse.jgit.internal.storage.pack.CachedPack
    public boolean hasObject(ObjectToPack objectToPack, StoredObjectRepresentation storedObjectRepresentation) {
        return ((DfsObjectRepresentation) storedObjectRepresentation).pack == this.pack;
    }

    void copyAsIs(PackOutputStream packOutputStream, DfsReader dfsReader) throws IOException {
        this.pack.copyPackAsIs(packOutputStream, dfsReader);
    }
}
