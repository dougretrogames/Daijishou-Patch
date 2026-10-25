package org.eclipse.jgit.internal.storage.pack;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import org.eclipse.jgit.storage.pack.PackConfig;

/* JADX INFO: loaded from: classes5.dex */
class DeltaCache {
    private final int entryLimit;
    private final ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
    private final long size;
    private long used;

    DeltaCache(PackConfig packConfig) {
        this.size = packConfig.getDeltaCacheSize();
        this.entryLimit = packConfig.getDeltaCacheLimit();
    }

    boolean canCache(int i, ObjectToPack objectToPack, ObjectToPack objectToPack2) {
        long j = this.size;
        if (0 < j) {
            long j2 = i;
            if (j < this.used + j2) {
                checkForGarbageCollectedObjects();
                long j3 = this.size;
                if (0 < j3 && j3 < this.used + j2) {
                    return false;
                }
            }
        }
        if (i < this.entryLimit) {
            this.used += (long) i;
            return true;
        }
        if ((i >> 10) >= (objectToPack.getWeight() >> 20) + (objectToPack2.getWeight() >> 21)) {
            return false;
        }
        this.used += (long) i;
        return true;
    }

    void credit(int i) {
        this.used -= (long) i;
    }

    Ref cache(byte[] bArr, int i, int i2) {
        byte[] bArrResize = resize(bArr, i);
        if (i2 != bArrResize.length) {
            long j = this.used - ((long) i2);
            this.used = j;
            this.used = j + ((long) bArrResize.length);
        }
        return new Ref(bArrResize, this.queue);
    }

    byte[] resize(byte[] bArr, int i) {
        if (bArr.length == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    private void checkForGarbageCollectedObjects() {
        while (true) {
            Ref ref = (Ref) this.queue.poll();
            if (ref == null) {
                return;
            } else {
                this.used -= (long) ref.cost;
            }
        }
    }

    static class Ref extends SoftReference<byte[]> {
        final int cost;

        Ref(byte[] bArr, ReferenceQueue<byte[]> referenceQueue) {
            super(bArr, referenceQueue);
            this.cost = bArr.length;
        }
    }
}
