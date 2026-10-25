package org.eclipse.jgit.lib;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ObjectDatabase implements AutoCloseable {
    private static final Set<ObjectId> shallowCommits = Collections.emptySet();

    @Override // java.lang.AutoCloseable
    public abstract void close();

    public void create() throws IOException {
    }

    public boolean exists() {
        return true;
    }

    public abstract long getApproximateObjectCount();

    public ObjectDatabase newCachedDatabase() {
        return this;
    }

    public abstract ObjectInserter newInserter();

    public abstract ObjectReader newReader();

    protected ObjectDatabase() {
    }

    public Set<ObjectId> getShallowCommits() throws IOException {
        return shallowCommits;
    }

    public void setShallowCommits(Set<ObjectId> set) throws IOException {
        if (!set.isEmpty()) {
            throw new UnsupportedOperationException("Shallow commits expected to be empty.");
        }
    }

    public boolean has(AnyObjectId anyObjectId) throws IOException {
        Throwable th = null;
        try {
            ObjectReader objectReaderNewReader = newReader();
            try {
                return objectReaderNewReader.has(anyObjectId);
            } finally {
                if (objectReaderNewReader != null) {
                    objectReaderNewReader.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    public ObjectLoader open(AnyObjectId anyObjectId) throws IOException {
        return open(anyObjectId, -1);
    }

    public ObjectLoader open(AnyObjectId anyObjectId, int i) throws IOException {
        Throwable th = null;
        try {
            ObjectReader objectReaderNewReader = newReader();
            try {
                return objectReaderNewReader.open(anyObjectId, i);
            } finally {
                if (objectReaderNewReader != null) {
                    objectReaderNewReader.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }
}
