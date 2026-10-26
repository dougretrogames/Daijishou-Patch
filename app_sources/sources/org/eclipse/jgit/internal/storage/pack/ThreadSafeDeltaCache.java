package org.eclipse.jgit.internal.storage.pack;

import java.util.concurrent.locks.ReentrantLock;
import org.eclipse.jgit.storage.pack.PackConfig;

/* INFO: loaded from: classes5.dex */
class ThreadSafeDeltaCache extends DeltaCache {
    private final ReentrantLock lock;

    ThreadSafeDeltaCache(PackConfig packConfig) {
        super(packConfig);
        this.lock = new ReentrantLock();
    }

    @Override // org.eclipse.jgit.internal.storage.pack.DeltaCache
    boolean canCache(int i, ObjectToPack objectToPack, ObjectToPack objectToPack2) {
        this.lock.lock();
        try {
            return super.canCache(i, objectToPack, objectToPack2);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.eclipse.jgit.internal.storage.pack.DeltaCache
    void credit(int i) {
        this.lock.lock();
        try {
            super.credit(i);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.eclipse.jgit.internal.storage.pack.DeltaCache
    DeltaCache.Ref cache(byte[] bArr, int i, int i2) {
        byte[] bArrResize = resize(bArr, i);
        this.lock.lock();
        try {
            return super.cache(bArrResize, i, i2);
        } finally {
            this.lock.unlock();
        }
    }
}
