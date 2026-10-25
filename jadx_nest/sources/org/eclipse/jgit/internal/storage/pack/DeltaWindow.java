package org.eclipse.jgit.internal.storage.pack;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.storage.pack.PackConfig;
import org.eclipse.jgit.util.TemporaryBuffer;

/* JADX INFO: loaded from: classes5.dex */
final class DeltaWindow {
    private static final boolean NEXT_RES = false;
    private static final boolean NEXT_SRC = true;
    private DeltaWindowEntry bestBase;
    private final long bytesPerUnit;
    private long bytesProcessed;
    private final PackConfig config;
    private int cur;
    private Deflater deflater;
    private Object deltaBuf;
    private final DeltaCache deltaCache;
    private int deltaLen;
    private int end;
    private long loaded;
    private final int maxDepth;
    private final long maxMemory;
    private final ProgressMonitor monitor;
    private final ObjectReader reader;
    private DeltaWindowEntry res;
    private final ObjectToPack[] toSearch;

    private static int deflateBound(int i) {
        return ((i + 7) >> 3) + i + ((i + 63) >> 6) + 11;
    }

    DeltaWindow(PackConfig packConfig, DeltaCache deltaCache, ObjectReader objectReader, ProgressMonitor progressMonitor, long j, ObjectToPack[] objectToPackArr, int i, int i2) {
        this.config = packConfig;
        this.deltaCache = deltaCache;
        this.reader = objectReader;
        this.monitor = progressMonitor;
        this.bytesPerUnit = j;
        this.toSearch = objectToPackArr;
        this.cur = i;
        this.end = i2;
        this.maxMemory = Math.max(0L, packConfig.getDeltaSearchMemoryLimit());
        this.maxDepth = packConfig.getMaxDeltaDepth();
        this.res = DeltaWindowEntry.createWindow(packConfig.getDeltaSearchWindowSize());
    }

    synchronized DeltaTask.Slice remaining() {
        int i = this.end;
        int i2 = (i - this.cur) >>> 1;
        if (i2 == 0) {
            return null;
        }
        int i3 = i - i2;
        int pathHash = this.toSearch[i3].getPathHash();
        for (int i4 = i3 + 1; i4 < i; i4++) {
            if (pathHash != this.toSearch[i4].getPathHash()) {
                return new DeltaTask.Slice(i4, i);
            }
        }
        if (pathHash != this.toSearch[this.cur].getPathHash()) {
            do {
                i3--;
                if (this.cur >= i3) {
                }
            } while (pathHash == this.toSearch[i3].getPathHash());
            return new DeltaTask.Slice(i3 + 1, i);
        }
        return null;
    }

    synchronized boolean tryStealWork(DeltaTask.Slice slice) {
        if (slice.beginIndex > this.cur && this.end > slice.beginIndex) {
            this.end = slice.beginIndex;
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0093  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if (r8.maxMemory == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        clear(r8.res);
        r1 = estimateSize(r0);
        r3 = r8.res.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        if (r8.maxMemory >= (r8.loaded + r1)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r3 != r8.res) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        clear(r3);
        r3 = r3.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        r8.res.set(r0);
        clearWindowOnTypeSwitch();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        if (r8.res.object.isEdge() != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (r8.res.object.doNotAttemptDelta() == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
    
        r1 = r8.bytesPerUnit;
        r3 = r8.bytesProcessed + ((long) r0.getWeight());
        r8.bytesProcessed = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        if (r1 > r3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        r0 = (int) (r3 / r8.bytesPerUnit);
        r8.monitor.update(r0);
        r8.bytesProcessed -= ((long) r0) * r8.bytesPerUnit;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        searchInWindow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
    
        keepInWindow();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void search() throws java.io.IOException {
        /*
            r8 = this;
        L0:
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L8e
            int r0 = r8.end     // Catch: java.lang.Throwable -> L8b
            int r1 = r8.cur     // Catch: java.lang.Throwable -> L8b
            if (r0 > r1) goto L10
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L8b
            java.util.zip.Deflater r0 = r8.deflater
            if (r0 == 0) goto Lf
            r0.end()
        Lf:
            return
        L10:
            org.eclipse.jgit.internal.storage.pack.ObjectToPack[] r0 = r8.toSearch     // Catch: java.lang.Throwable -> L8b
            int r2 = r1 + 1
            r8.cur = r2     // Catch: java.lang.Throwable -> L8b
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L8b
            long r1 = r8.maxMemory     // Catch: java.lang.Throwable -> L8e
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L42
            org.eclipse.jgit.internal.storage.pack.DeltaWindowEntry r1 = r8.res     // Catch: java.lang.Throwable -> L8e
            r8.clear(r1)     // Catch: java.lang.Throwable -> L8e
            long r1 = estimateSize(r0)     // Catch: java.lang.Throwable -> L8e
            org.eclipse.jgit.internal.storage.pack.DeltaWindowEntry r3 = r8.res     // Catch: java.lang.Throwable -> L8e
            org.eclipse.jgit.internal.storage.pack.DeltaWindowEntry r3 = r3.next     // Catch: java.lang.Throwable -> L8e
        L2e:
            long r4 = r8.maxMemory     // Catch: java.lang.Throwable -> L8e
            long r6 = r8.loaded     // Catch: java.lang.Throwable -> L8e
            long r6 = r6 + r1
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L42
            org.eclipse.jgit.internal.storage.pack.DeltaWindowEntry r4 = r8.res     // Catch: java.lang.Throwable -> L8e
            if (r3 != r4) goto L3c
            goto L42
        L3c:
            r8.clear(r3)     // Catch: java.lang.Throwable -> L8e
            org.eclipse.jgit.internal.storage.pack.DeltaWindowEntry r3 = r3.next     // Catch: java.lang.Throwable -> L8e
            goto L2e
        L42:
            org.eclipse.jgit.internal.storage.pack.DeltaWindowEntry r1 = r8.res     // Catch: java.lang.Throwable -> L8e
            r1.set(r0)     // Catch: java.lang.Throwable -> L8e
            r8.clearWindowOnTypeSwitch()     // Catch: java.lang.Throwable -> L8e
            org.eclipse.jgit.internal.storage.pack.DeltaWindowEntry r1 = r8.res     // Catch: java.lang.Throwable -> L8e
            org.eclipse.jgit.internal.storage.pack.ObjectToPack r1 = r1.object     // Catch: java.lang.Throwable -> L8e
            boolean r1 = r1.isEdge()     // Catch: java.lang.Throwable -> L8e
            if (r1 != 0) goto L86
            org.eclipse.jgit.internal.storage.pack.DeltaWindowEntry r1 = r8.res     // Catch: java.lang.Throwable -> L8e
            org.eclipse.jgit.internal.storage.pack.ObjectToPack r1 = r1.object     // Catch: java.lang.Throwable -> L8e
            boolean r1 = r1.doNotAttemptDelta()     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto L5f
            goto L86
        L5f:
            long r1 = r8.bytesPerUnit     // Catch: java.lang.Throwable -> L8e
            long r3 = r8.bytesProcessed     // Catch: java.lang.Throwable -> L8e
            int r0 = r0.getWeight()     // Catch: java.lang.Throwable -> L8e
            long r5 = (long) r0     // Catch: java.lang.Throwable -> L8e
            long r3 = r3 + r5
            r8.bytesProcessed = r3     // Catch: java.lang.Throwable -> L8e
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 > 0) goto L81
            long r0 = r8.bytesPerUnit     // Catch: java.lang.Throwable -> L8e
            long r3 = r3 / r0
            int r0 = (int) r3     // Catch: java.lang.Throwable -> L8e
            org.eclipse.jgit.lib.ProgressMonitor r1 = r8.monitor     // Catch: java.lang.Throwable -> L8e
            r1.update(r0)     // Catch: java.lang.Throwable -> L8e
            long r1 = r8.bytesProcessed     // Catch: java.lang.Throwable -> L8e
            long r3 = (long) r0     // Catch: java.lang.Throwable -> L8e
            long r5 = r8.bytesPerUnit     // Catch: java.lang.Throwable -> L8e
            long r3 = r3 * r5
            long r1 = r1 - r3
            r8.bytesProcessed = r1     // Catch: java.lang.Throwable -> L8e
        L81:
            r8.searchInWindow()     // Catch: java.lang.Throwable -> L8e
            goto L0
        L86:
            r8.keepInWindow()     // Catch: java.lang.Throwable -> L8e
            goto L0
        L8b:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L8b
            throw r0     // Catch: java.lang.Throwable -> L8e
        L8e:
            r0 = move-exception
            java.util.zip.Deflater r1 = r8.deflater
            if (r1 == 0) goto L96
            r1.end()
        L96:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jgit.internal.storage.pack.DeltaWindow.search():void");
    }

    private static long estimateSize(ObjectToPack objectToPack) {
        return DeltaIndex.estimateIndexSize(objectToPack.getWeight());
    }

    private static long estimateIndexSize(DeltaWindowEntry deltaWindowEntry) {
        if (deltaWindowEntry.buffer == null) {
            return estimateSize(deltaWindowEntry.object);
        }
        int length = deltaWindowEntry.buffer.length;
        return DeltaIndex.estimateIndexSize(length) - ((long) length);
    }

    private void clearWindowOnTypeSwitch() {
        DeltaWindowEntry deltaWindowEntry = this.res.prev;
        if (deltaWindowEntry.empty() || this.res.type() == deltaWindowEntry.type()) {
            return;
        }
        while (deltaWindowEntry != this.res) {
            clear(deltaWindowEntry);
            deltaWindowEntry = deltaWindowEntry.prev;
        }
    }

    private void clear(DeltaWindowEntry deltaWindowEntry) {
        if (deltaWindowEntry.index != null) {
            this.loaded -= deltaWindowEntry.index.getIndexSize();
        } else if (deltaWindowEntry.buffer != null) {
            this.loaded -= (long) deltaWindowEntry.buffer.length;
        }
        deltaWindowEntry.set(null);
    }

    private void searchInWindow() throws IOException {
        DeltaWindowEntry deltaWindowEntry = this.res;
        do {
            deltaWindowEntry = deltaWindowEntry.prev;
            if (deltaWindowEntry == this.res || deltaWindowEntry.empty()) {
                DeltaWindowEntry deltaWindowEntry2 = this.bestBase;
                if (deltaWindowEntry2 == null) {
                    keepInWindow();
                    return;
                }
                ObjectToPack objectToPack = deltaWindowEntry2.object;
                ObjectToPack objectToPack2 = this.res.object;
                if (objectToPack.isEdge()) {
                    objectToPack2.setDeltaBase(objectToPack.copy());
                } else {
                    objectToPack2.setDeltaBase(objectToPack);
                }
                int deltaDepth = objectToPack.getDeltaDepth() + 1;
                objectToPack2.setDeltaDepth(deltaDepth);
                objectToPack2.clearReuseAsIs();
                cacheDelta(objectToPack, objectToPack2);
                if (deltaDepth < this.maxDepth) {
                    this.res.makeNext(this.bestBase);
                    this.res = this.bestBase.next;
                }
                this.bestBase = null;
                this.deltaBuf = null;
                return;
            }
        } while (delta(deltaWindowEntry));
        this.bestBase = null;
        this.deltaBuf = null;
    }

    private boolean delta(DeltaWindowEntry deltaWindowEntry) throws IOException {
        int iDeltaSizeLimit;
        OutputStream heap;
        if (this.res.size() < (deltaWindowEntry.size() >>> 4) || (iDeltaSizeLimit = deltaSizeLimit(deltaWindowEntry)) <= 8 || this.res.size() - deltaWindowEntry.size() > iDeltaSizeLimit) {
            return true;
        }
        try {
            DeltaIndex deltaIndexIndex = index(deltaWindowEntry);
            try {
                byte[] bArrBuffer = buffer(this.res);
                try {
                    if (iDeltaSizeLimit <= 8192) {
                        heap = new ArrayStream(iDeltaSizeLimit);
                    } else {
                        heap = new TemporaryBuffer.Heap(iDeltaSizeLimit);
                    }
                    if (deltaIndexIndex.encode(heap, bArrBuffer, iDeltaSizeLimit)) {
                        selectDeltaBase(deltaWindowEntry, heap);
                    }
                } catch (IOException unused) {
                }
                return true;
            } catch (LargeObjectException unused2) {
                return false;
            }
        } catch (IOException e) {
            if (deltaWindowEntry.object.isEdge()) {
                return true;
            }
            throw e;
        } catch (LargeObjectException unused3) {
            return true;
        }
    }

    private void selectDeltaBase(DeltaWindowEntry deltaWindowEntry, OutputStream outputStream) {
        this.bestBase = deltaWindowEntry;
        if (outputStream instanceof ArrayStream) {
            ArrayStream arrayStream = (ArrayStream) outputStream;
            this.deltaBuf = arrayStream.buf;
            this.deltaLen = arrayStream.cnt;
        } else {
            TemporaryBuffer.Heap heap = (TemporaryBuffer.Heap) outputStream;
            this.deltaBuf = heap;
            this.deltaLen = (int) heap.length();
        }
    }

    private int deltaSizeLimit(DeltaWindowEntry deltaWindowEntry) {
        DeltaWindowEntry deltaWindowEntry2 = this.bestBase;
        if (deltaWindowEntry2 == null) {
            return ((this.res.size() >>> 1) * (this.maxDepth - deltaWindowEntry.depth())) / this.maxDepth;
        }
        return (this.deltaLen * (this.maxDepth - deltaWindowEntry.depth())) / (this.maxDepth - deltaWindowEntry2.depth());
    }

    private void cacheDelta(ObjectToPack objectToPack, ObjectToPack objectToPack2) {
        if (this.deltaCache.canCache(this.deltaLen, objectToPack, objectToPack2)) {
            try {
                byte[] bArr = new byte[deflateBound(this.deltaLen)];
                ZipStream zipStream = new ZipStream(deflater(), bArr);
                Object obj = this.deltaBuf;
                if (obj instanceof byte[]) {
                    zipStream.write((byte[]) obj, 0, this.deltaLen);
                } else {
                    ((TemporaryBuffer.Heap) obj).writeTo(zipStream, null);
                }
                this.deltaBuf = null;
                objectToPack2.setCachedDelta(this.deltaCache.cache(bArr, zipStream.finish(), this.deltaLen));
                objectToPack2.setCachedSize(this.deltaLen);
            } catch (IOException | OutOfMemoryError unused) {
                this.deltaCache.credit(this.deltaLen);
            }
        }
    }

    private void keepInWindow() {
        this.res = this.res.next;
    }

    private DeltaIndex index(DeltaWindowEntry deltaWindowEntry) throws LargeObjectException, IOException {
        DeltaIndex deltaIndex = deltaWindowEntry.index;
        if (deltaIndex != null) {
            return deltaIndex;
        }
        checkLoadable(deltaWindowEntry, estimateIndexSize(deltaWindowEntry));
        try {
            DeltaIndex deltaIndex2 = new DeltaIndex(buffer(deltaWindowEntry));
            if (this.maxMemory != 0) {
                this.loaded += deltaIndex2.getIndexSize() - deltaIndex2.getSourceSize();
            }
            deltaWindowEntry.index = deltaIndex2;
            return deltaIndex2;
        } catch (OutOfMemoryError e) {
            LargeObjectException.OutOfMemory outOfMemory = new LargeObjectException.OutOfMemory(e);
            outOfMemory.setObjectId(deltaWindowEntry.object);
            throw outOfMemory;
        }
    }

    private byte[] buffer(DeltaWindowEntry deltaWindowEntry) throws LargeObjectException, IOException {
        byte[] bArrBuffer = deltaWindowEntry.buffer;
        if (bArrBuffer == null) {
            checkLoadable(deltaWindowEntry, deltaWindowEntry.size());
            bArrBuffer = PackWriter.buffer(this.config, this.reader, deltaWindowEntry.object);
            if (this.maxMemory != 0) {
                this.loaded += (long) bArrBuffer.length;
            }
            deltaWindowEntry.buffer = bArrBuffer;
        }
        return bArrBuffer;
    }

    private void checkLoadable(DeltaWindowEntry deltaWindowEntry, long j) {
        if (this.maxMemory == 0) {
            return;
        }
        DeltaWindowEntry deltaWindowEntry2 = this.res.next;
        while (this.maxMemory < this.loaded + j) {
            clear(deltaWindowEntry2);
            if (deltaWindowEntry2 != deltaWindowEntry) {
                deltaWindowEntry2 = deltaWindowEntry2.next;
            } else {
                throw new LargeObjectException.ExceedsLimit(this.maxMemory, this.loaded + j);
            }
        }
    }

    private Deflater deflater() {
        Deflater deflater = this.deflater;
        if (deflater == null) {
            this.deflater = new Deflater(this.config.getCompressionLevel());
        } else {
            deflater.reset();
        }
        return this.deflater;
    }

    static final class ZipStream extends OutputStream {
        private final Deflater deflater;
        private int outPtr;
        private final byte[] zbuf;

        ZipStream(Deflater deflater, byte[] bArr) {
            this.deflater = deflater;
            this.zbuf = bArr;
        }

        int finish() throws IOException {
            this.deflater.finish();
            while (true) {
                int i = this.outPtr;
                byte[] bArr = this.zbuf;
                if (i == bArr.length) {
                    throw new EOFException();
                }
                int iDeflate = this.deflater.deflate(bArr, i, bArr.length - i);
                if (iDeflate == 0) {
                    if (this.deflater.finished()) {
                        return this.outPtr;
                    }
                    throw new IOException();
                }
                this.outPtr += iDeflate;
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.deflater.setInput(bArr, i, i2);
            while (true) {
                int i3 = this.outPtr;
                byte[] bArr2 = this.zbuf;
                if (i3 == bArr2.length) {
                    throw new EOFException();
                }
                int iDeflate = this.deflater.deflate(bArr2, i3, bArr2.length - i3);
                if (iDeflate == 0) {
                    if (!this.deflater.needsInput()) {
                        throw new IOException();
                    }
                    return;
                }
                this.outPtr += iDeflate;
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    static final class ArrayStream extends OutputStream {
        final byte[] buf;
        int cnt;

        ArrayStream(int i) {
            this.buf = new byte[i];
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            int i2 = this.cnt;
            byte[] bArr = this.buf;
            if (i2 == bArr.length) {
                throw new IOException();
            }
            this.cnt = i2 + 1;
            bArr[i2] = (byte) i;
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            byte[] bArr2 = this.buf;
            int length = bArr2.length;
            int i3 = this.cnt;
            if (i2 > length - i3) {
                throw new IOException();
            }
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.cnt += i2;
        }
    }
}
