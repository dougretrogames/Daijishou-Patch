package org.eclipse.jgit.internal.storage.file;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
class PackBitmapIndexV1 extends BasePackBitmapIndex {
    private static final int MAX_XOR_OFFSET = 126;
    static final int OPT_FULL = 1;
    private final ObjectIdOwnerMap<BasePackBitmapIndex.StoredBitmap> bitmaps;
    private final EWAHCompressedBitmap blobs;
    private final EWAHCompressedBitmap commits;
    private byte[] packChecksum;
    private final PackIndex packIndex;
    private final PackReverseIndex reverseIndex;
    private final EWAHCompressedBitmap tags;
    private final EWAHCompressedBitmap trees;
    static final byte[] MAGIC = {66, 73, 84, 77};
    private static final ExecutorService executor = Executors.newCachedThreadPool(new AnonymousClass1());

    static /* synthetic */ PackIndex lambda$0(PackIndex packIndex) throws IOException {
        return packIndex;
    }

    static /* synthetic */ PackReverseIndex lambda$1(PackReverseIndex packReverseIndex) throws IOException {
        return packReverseIndex;
    }

    /* INFO: renamed from: org.eclipse.jgit.internal.storage.file.PackBitmapIndexV1$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadFactory {
        private final ThreadFactory baseFactory = Executors.defaultThreadFactory();
        private final AtomicInteger threadNumber = new AtomicInteger(0);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.baseFactory.newThread(runnable);
            threadNewThread.setName("JGit-PackBitmapIndexV1-" + this.threadNumber.getAndIncrement());
            threadNewThread.setDaemon(true);
            return threadNewThread;
        }
    }

    PackBitmapIndexV1(InputStream inputStream, PackIndex packIndex, PackReverseIndex packReverseIndex) throws IOException {
        this(inputStream, new PackBitmapIndexV1$$ExternalSyntheticLambda1(packIndex), new PackBitmapIndexV1$$ExternalSyntheticLambda2(packReverseIndex), false);
    }

    PackBitmapIndexV1(InputStream inputStream, PackBitmapIndex.SupplierWithIOException<PackIndex> supplierWithIOException, PackBitmapIndex.SupplierWithIOException<PackReverseIndex> supplierWithIOException2, boolean z) throws IOException {
        PackBitmapIndex.SupplierWithIOException<PackReverseIndex> supplierWithIOException3;
        Future futureSubmit;
        PackReverseIndex packReverseIndex;
        IdxPositionBitmap idxPositionBitmap;
        super(new ObjectIdOwnerMap());
        this.bitmaps = getBitmaps();
        if (z) {
            ExecutorService executorService = executor;
            supplierWithIOException2.getClass();
            supplierWithIOException3 = supplierWithIOException2;
            futureSubmit = executorService.submit(new PackBitmapIndexV1$$ExternalSyntheticLambda0(supplierWithIOException3));
        } else {
            supplierWithIOException3 = supplierWithIOException2;
            futureSubmit = null;
        }
        byte[] bArr = new byte[32];
        int i = 0;
        IO.readFully(inputStream, bArr, 0, 32);
        int i2 = 0;
        while (true) {
            byte[] bArr2 = MAGIC;
            if (i2 < bArr2.length) {
                if (bArr[i2] != bArr2[i2]) {
                    byte[] bArr3 = new byte[bArr2.length];
                    System.arraycopy(bArr, 0, bArr3, 0, bArr2.length);
                    throw new IOException(MessageFormat.format(JGitText.get().expectedGot, Arrays.toString(bArr2), Arrays.toString(bArr3)));
                }
                i2++;
                i = 0;
            } else {
                char c = 4;
                int iDecodeUInt16 = NB.decodeUInt16(bArr, 4);
                if (iDecodeUInt16 != 1) {
                    throw new IOException(MessageFormat.format(JGitText.get().unsupportedPackIndexVersion, Integer.valueOf(iDecodeUInt16)));
                }
                int i3 = 6;
                int iDecodeUInt17 = NB.decodeUInt16(bArr, 6);
                if ((iDecodeUInt17 & 1) == 0) {
                    throw new IOException(MessageFormat.format(JGitText.get().expectedGot, 1, Integer.valueOf(iDecodeUInt17)));
                }
                long jDecodeUInt32 = NB.decodeUInt32(bArr, 8);
                if (jDecodeUInt32 > 2147483647L) {
                    throw new IOException(JGitText.get().indexFileIsTooLargeForJgit);
                }
                byte[] bArr4 = new byte[20];
                this.packChecksum = bArr4;
                System.arraycopy(bArr, 12, bArr4, i, bArr4.length);
                SimpleDataInput simpleDataInput = new SimpleDataInput(inputStream);
                this.commits = readBitmap(simpleDataInput);
                this.trees = readBitmap(simpleDataInput);
                this.blobs = readBitmap(simpleDataInput);
                this.tags = readBitmap(simpleDataInput);
                ArrayList arrayList = new ArrayList();
                byte b = 126;
                IdxPositionBitmap[] idxPositionBitmapArr = new IdxPositionBitmap[126];
                int i4 = i;
                while (i4 < ((int) jDecodeUInt32)) {
                    IO.readFully(inputStream, bArr, i, i3);
                    int iDecodeInt32 = NB.decodeInt32(bArr, i);
                    char c2 = c;
                    byte b2 = bArr[c2];
                    byte b3 = bArr[5];
                    EWAHCompressedBitmap bitmap = readBitmap(simpleDataInput);
                    if (iDecodeInt32 < 0) {
                        throw new IOException(MessageFormat.format(JGitText.get().invalidId, String.valueOf(iDecodeInt32)));
                    }
                    if (b2 < 0) {
                        throw new IOException(MessageFormat.format(JGitText.get().invalidId, String.valueOf((int) b2)));
                    }
                    if (b2 > b) {
                        throw new IOException(MessageFormat.format(JGitText.get().expectedLessThanGot, String.valueOf((int) b), String.valueOf((int) b2)));
                    }
                    if (b2 > i4) {
                        throw new IOException(MessageFormat.format(JGitText.get().expectedLessThanGot, String.valueOf(i4), String.valueOf((int) b2)));
                    }
                    if (b2 > 0) {
                        IdxPositionBitmap idxPositionBitmap2 = idxPositionBitmapArr[(i4 - b2) % 126];
                        if (idxPositionBitmap2 == null) {
                            throw new IOException(MessageFormat.format(JGitText.get().invalidId, String.valueOf((int) b2)));
                        }
                        idxPositionBitmap = idxPositionBitmap2;
                    } else {
                        idxPositionBitmap = null;
                    }
                    byte b4 = b;
                    IdxPositionBitmap idxPositionBitmap3 = new IdxPositionBitmap(iDecodeInt32, idxPositionBitmap, bitmap, b3);
                    arrayList.add(idxPositionBitmap3);
                    idxPositionBitmapArr[i4 % 126] = idxPositionBitmap3;
                    i4++;
                    c = c2;
                    b = b4;
                    i = 0;
                    i3 = 6;
                }
                this.packIndex = supplierWithIOException.get();
                while (i < arrayList.size()) {
                    IdxPositionBitmap idxPositionBitmap4 = (IdxPositionBitmap) arrayList.get(i);
                    BasePackBitmapIndex.StoredBitmap storedBitmap = new BasePackBitmapIndex.StoredBitmap(this.packIndex.getObjectId(idxPositionBitmap4.nthObjectId), idxPositionBitmap4.bitmap, idxPositionBitmap4.getXorStoredBitmap(), idxPositionBitmap4.flags);
                    idxPositionBitmap4.sb = storedBitmap;
                    this.bitmaps.add(storedBitmap);
                    i++;
                }
                if (z && futureSubmit != null) {
                    try {
                        packReverseIndex = (PackReverseIndex) futureSubmit.get();
                    } catch (InterruptedException | ExecutionException unused) {
                        packReverseIndex = supplierWithIOException3.get();
                    }
                } else {
                    packReverseIndex = supplierWithIOException3.get();
                }
                this.reverseIndex = packReverseIndex;
                return;
            }
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public int findPosition(AnyObjectId anyObjectId) {
        long jFindOffset = this.packIndex.findOffset(anyObjectId);
        if (jFindOffset == -1) {
            return -1;
        }
        return this.reverseIndex.findPosition(jFindOffset);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public ObjectId getObject(int i) throws IllegalArgumentException {
        ObjectId objectIdFindObjectByPosition = this.reverseIndex.findObjectByPosition(i);
        if (objectIdFindObjectByPosition != null) {
            return objectIdFindObjectByPosition;
        }
        throw new IllegalArgumentException();
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public int getObjectCount() {
        return (int) this.packIndex.getObjectCount();
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public EWAHCompressedBitmap ofObjectType(EWAHCompressedBitmap eWAHCompressedBitmap, int i) {
        if (i == 1) {
            return this.commits.and(eWAHCompressedBitmap);
        }
        if (i == 2) {
            return this.trees.and(eWAHCompressedBitmap);
        }
        if (i == 3) {
            return this.blobs.and(eWAHCompressedBitmap);
        }
        if (i == 4) {
            return this.tags.and(eWAHCompressedBitmap);
        }
        throw new IllegalArgumentException();
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public int getBitmapCount() {
        return this.bitmaps.size();
    }

    public boolean equals(Object obj) {
        return (obj instanceof PackBitmapIndexV1) && getPackIndex() == ((PackBitmapIndexV1) obj).getPackIndex();
    }

    public int hashCode() {
        return getPackIndex().hashCode();
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public byte[] getPackChecksum() {
        return this.packChecksum;
    }

    PackIndex getPackIndex() {
        return this.packIndex;
    }

    private static EWAHCompressedBitmap readBitmap(DataInput dataInput) throws IOException {
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap();
        eWAHCompressedBitmap.deserialize(dataInput);
        return eWAHCompressedBitmap;
    }

    private static final class IdxPositionBitmap {
        EWAHCompressedBitmap bitmap;
        int flags;
        int nthObjectId;
        BasePackBitmapIndex.StoredBitmap sb;
        IdxPositionBitmap xorIdxPositionBitmap;

        IdxPositionBitmap(int i, @Nullable IdxPositionBitmap idxPositionBitmap, EWAHCompressedBitmap eWAHCompressedBitmap, int i2) {
            this.nthObjectId = i;
            this.xorIdxPositionBitmap = idxPositionBitmap;
            this.bitmap = eWAHCompressedBitmap;
            this.flags = i2;
        }

        BasePackBitmapIndex.StoredBitmap getXorStoredBitmap() {
            IdxPositionBitmap idxPositionBitmap = this.xorIdxPositionBitmap;
            if (idxPositionBitmap == null) {
                return null;
            }
            return idxPositionBitmap.sb;
        }
    }
}
