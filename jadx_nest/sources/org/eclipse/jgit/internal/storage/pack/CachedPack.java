package org.eclipse.jgit.internal.storage.pack;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CachedPack {
    public long getDeltaCount() throws IOException {
        return 0L;
    }

    public abstract long getObjectCount() throws IOException;

    public abstract boolean hasObject(ObjectToPack objectToPack, StoredObjectRepresentation storedObjectRepresentation);
}
