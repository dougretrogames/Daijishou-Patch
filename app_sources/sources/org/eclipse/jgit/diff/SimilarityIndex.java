package org.eclipse.jgit.diff;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectStream;

/* INFO: loaded from: classes5.dex */
public class SimilarityIndex {
    private static final int KEY_SHIFT = 32;
    private static final long MAX_COUNT = 4294967295L;
    public static final TableFullException TABLE_FULL_OUT_OF_MEMORY = new TableFullException();
    private long hashedCnt;
    private int idSize;
    private int idHashBits = 8;
    private long[] idHash = new long[1 << 8];
    private int idGrowAt = growAt(8);

    public static class TableFullException extends Exception {
        private static final long serialVersionUID = 1;
    }

    private static long countOf(long j) {
        return j & 4294967295L;
    }

    private static int keyOf(long j) {
        return (int) (j >>> 32);
    }

    public static SimilarityIndex create(ObjectLoader objectLoader) throws TableFullException, IOException {
        SimilarityIndex similarityIndex = new SimilarityIndex();
        similarityIndex.hash(objectLoader);
        similarityIndex.sort();
        return similarityIndex;
    }

    SimilarityIndex() {
    }

    static boolean isBinary(ObjectLoader objectLoader) throws IOException {
        if (objectLoader.isLarge()) {
            Throwable th = null;
            try {
                ObjectStream objectStreamOpenStream = objectLoader.openStream();
                try {
                    return RawText.isBinary(objectStreamOpenStream);
                } finally {
                    if (objectStreamOpenStream != null) {
                        objectStreamOpenStream.close();
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
        byte[] cachedBytes = objectLoader.getCachedBytes();
        return RawText.isBinary(cachedBytes, cachedBytes.length, true);
    }

    void hash(ObjectLoader objectLoader) throws TableFullException, IOException {
        if (objectLoader.isLarge()) {
            hashLargeObject(objectLoader);
        } else {
            byte[] cachedBytes = objectLoader.getCachedBytes();
            hash(cachedBytes, 0, cachedBytes.length);
        }
    }

    private void hashLargeObject(ObjectLoader objectLoader) throws TableFullException, IOException {
        boolean z = !isBinary(objectLoader);
        Throwable th = null;
        try {
            ObjectStream objectStreamOpenStream = objectLoader.openStream();
            try {
                hash(objectStreamOpenStream, objectStreamOpenStream.getSize(), z);
            } finally {
                if (objectStreamOpenStream != null) {
                    objectStreamOpenStream.close();
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

    void hash(byte[] bArr, int i, int i2) throws TableFullException {
        int i3;
        boolean zIsBinary = RawText.isBinary(bArr, bArr.length, true);
        this.hashedCnt = 0L;
        while (i < i2) {
            int i4 = 5381;
            int i5 = 0;
            int i6 = i;
            while (true) {
                i3 = i6 + 1;
                int i7 = bArr[i6] & 255;
                if (!zIsBinary && i7 == 13 && i3 < i2 && bArr[i3] == 10) {
                    if (i3 >= i2) {
                        break;
                    }
                    break;
                    break;
                }
                i5++;
                if (i7 == 10) {
                    break;
                }
                i4 = (i4 << 5) + i4 + i7;
                if (i3 >= i2 || i3 - i >= 64) {
                    break;
                } else {
                    i6 = i3;
                }
            }
            this.hashedCnt += (long) i5;
            add(i4, i5);
            i = i3;
        }
    }

    void hash(InputStream inputStream, long j, boolean z) throws TableFullException, IOException {
        int i;
        int i2 = 4096;
        byte[] bArr = new byte[4096];
        long j2 = j;
        int i3 = 0;
        int i4 = 0;
        while (0 < j2) {
            int i5 = 5381;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i3 == i4) {
                    int i8 = inputStream.read(bArr, 0, i2);
                    if (i8 <= 0) {
                        throw new EOFException();
                    }
                    i4 = i8;
                    i3 = 0;
                }
                i6++;
                i = i3 + 1;
                int i9 = bArr[i3] & 255;
                if (!z || i9 != 13 || i >= i4 || bArr[i] != 10) {
                    i7++;
                    if (i9 == 10) {
                        break;
                    }
                    i5 = (i5 << 5) + i5 + i9;
                    if (i6 < 64 || i6 >= j2) {
                        break;
                    } else {
                        i3 = i;
                    }
                } else if (i6 < 64) {
                    break;
                    break;
                }
            }
            this.hashedCnt += (long) i7;
            add(i5, i7);
            j2 -= (long) i6;
            i3 = i;
            bArr = bArr;
            i2 = 4096;
        }
    }

    void sort() {
        Arrays.sort(this.idHash);
    }

    public int score(SimilarityIndex similarityIndex, int i) {
        long jMax = Math.max(this.hashedCnt, similarityIndex.hashedCnt);
        return jMax == 0 ? i : (int) ((common(similarityIndex) * ((long) i)) / jMax);
    }

    long common(SimilarityIndex similarityIndex) {
        return common(this, similarityIndex);
    }

    private static long common(SimilarityIndex similarityIndex, SimilarityIndex similarityIndex2) {
        return common(similarityIndex.idHash, similarityIndex.packedIndex(0), similarityIndex2.idHash, similarityIndex2.packedIndex(0));
    }

    private static long common(long[] jArr, int i, long[] jArr2, int i2) {
        long jMin = 0;
        if (i == jArr.length || i2 == jArr2.length) {
            return 0L;
        }
        int iKeyOf = keyOf(jArr[i]);
        int iKeyOf2 = keyOf(jArr2[i2]);
        while (true) {
            if (iKeyOf == iKeyOf2) {
                jMin += Math.min(countOf(jArr[i]), countOf(jArr2[i2]));
                i++;
                if (i == jArr.length) {
                    break;
                }
                iKeyOf = keyOf(jArr[i]);
                i2++;
                if (i2 == jArr2.length) {
                    break;
                }
                iKeyOf2 = keyOf(jArr2[i2]);
            } else if (iKeyOf < iKeyOf2) {
                i++;
                if (i == jArr.length) {
                    return jMin;
                }
                iKeyOf = keyOf(jArr[i]);
            } else {
                i2++;
                if (i2 == jArr2.length) {
                    return jMin;
                }
                iKeyOf2 = keyOf(jArr2[i2]);
            }
        }
        return jMin;
    }

    int size() {
        return this.idSize;
    }

    int key(int i) {
        return keyOf(this.idHash[packedIndex(i)]);
    }

    long count(int i) {
        return countOf(this.idHash[packedIndex(i)]);
    }

    int findIndex(int i) {
        for (int i2 = 0; i2 < this.idSize; i2++) {
            if (key(i2) == i) {
                return i2;
            }
        }
        return -1;
    }

    private int packedIndex(int i) {
        return (this.idHash.length - this.idSize) + i;
    }

    void add(int i, int i2) throws TableFullException {
        int i3 = (i * (-1640562687)) >>> 1;
        int iSlot = slot(i3);
        while (true) {
            long[] jArr = this.idHash;
            long j = jArr[iSlot];
            if (j == 0) {
                if (this.idGrowAt <= this.idSize) {
                    grow();
                    iSlot = slot(i3);
                } else {
                    jArr[iSlot] = pair(i3, i2);
                    this.idSize++;
                    return;
                }
            } else if (keyOf(j) == i3) {
                this.idHash[iSlot] = pair(i3, countOf(j) + ((long) i2));
                return;
            } else {
                iSlot++;
                if (iSlot >= this.idHash.length) {
                    iSlot = 0;
                }
            }
        }
    }

    private static long pair(int i, long j) throws TableFullException {
        if (4294967295L >= j) {
            return (((long) i) << 32) | j;
        }
        throw new TableFullException();
    }

    private int slot(int i) {
        return i >>> (31 - this.idHashBits);
    }

    private static int growAt(int i) {
        return ((1 << i) * (i - 3)) / i;
    }

    private void grow() throws TableFullException {
        long[] jArr;
        int i = this.idHashBits;
        if (i == 30) {
            throw new TableFullException();
        }
        long[] jArr2 = this.idHash;
        int i2 = i + 1;
        this.idHashBits = i2;
        this.idGrowAt = growAt(i2);
        try {
            this.idHash = new long[1 << this.idHashBits];
            for (long j : jArr2) {
                if (j != 0) {
                    int iSlot = slot(keyOf(j));
                    while (true) {
                        jArr = this.idHash;
                        if (jArr[iSlot] == 0) {
                            break;
                        }
                        iSlot++;
                        if (iSlot >= jArr.length) {
                            iSlot = 0;
                        }
                    }
                    jArr[iSlot] = j;
                }
            }
        } catch (OutOfMemoryError unused) {
            throw TABLE_FULL_OUT_OF_MEMORY;
        }
    }
}
