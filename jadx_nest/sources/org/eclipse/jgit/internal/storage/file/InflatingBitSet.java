package org.eclipse.jgit.internal.storage.file;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import com.googlecode.javaewah.IntIterator;

/* JADX INFO: loaded from: classes5.dex */
final class InflatingBitSet {
    private static final long[] EMPTY = new long[0];
    private final EWAHCompressedBitmap bitmap;
    private long[] inflated;
    private IntIterator iterator;
    private int nextPosition;
    private final int sizeInBits;

    private static final int block(int i) {
        return i >> 6;
    }

    private static final long mask(int i) {
        return 1 << i;
    }

    InflatingBitSet(EWAHCompressedBitmap eWAHCompressedBitmap) {
        this(eWAHCompressedBitmap, EMPTY);
    }

    private InflatingBitSet(EWAHCompressedBitmap eWAHCompressedBitmap, long[] jArr) {
        this.nextPosition = -1;
        this.bitmap = eWAHCompressedBitmap;
        this.inflated = jArr;
        this.sizeInBits = eWAHCompressedBitmap.sizeInBits();
    }

    final boolean maybeContains(int i) {
        if (get(i)) {
            return true;
        }
        return this.nextPosition <= i && i < this.sizeInBits;
    }

    final boolean contains(int i) {
        if (get(i)) {
            return true;
        }
        int i2 = this.nextPosition;
        if (i <= i2 || i >= this.sizeInBits) {
            return i == i2;
        }
        IntIterator intIterator = this.iterator;
        if (intIterator == null) {
            IntIterator intIterator2 = this.bitmap.intIterator();
            this.iterator = intIterator2;
            if (!intIterator2.hasNext()) {
                return false;
            }
            this.nextPosition = this.iterator.next();
        } else if (!intIterator.hasNext()) {
            return false;
        }
        int iBlock = block(i);
        if (iBlock >= this.inflated.length) {
            long[] jArr = new long[block(this.sizeInBits) + 1];
            long[] jArr2 = this.inflated;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            this.inflated = jArr;
        }
        int iBlock2 = block(this.nextPosition);
        long jMask = mask(this.nextPosition);
        int iMax = Math.max(this.nextPosition, i) | 63;
        while (this.iterator.hasNext()) {
            int next = this.iterator.next();
            this.nextPosition = next;
            if (iMax < next) {
                break;
            }
            int iBlock3 = block(next);
            long jMask2 = mask(this.nextPosition);
            if (iBlock2 == iBlock3) {
                jMask |= jMask2;
            } else {
                this.inflated[iBlock2] = jMask;
                iBlock2 = iBlock3;
                jMask = jMask2;
            }
        }
        this.inflated[iBlock2] = jMask;
        return iBlock2 == iBlock && (jMask & mask(i)) != 0;
    }

    private final boolean get(int i) {
        int iBlock = block(i);
        long[] jArr = this.inflated;
        return iBlock < jArr.length && (jArr[iBlock] & mask(i)) != 0;
    }

    private final boolean isEmpty() {
        return this.sizeInBits == 0;
    }

    final InflatingBitSet or(EWAHCompressedBitmap eWAHCompressedBitmap) {
        return eWAHCompressedBitmap.sizeInBits() == 0 ? this : new InflatingBitSet(this.bitmap.or(eWAHCompressedBitmap), this.inflated);
    }

    final InflatingBitSet andNot(EWAHCompressedBitmap eWAHCompressedBitmap) {
        return isEmpty() ? this : new InflatingBitSet(this.bitmap.andNot(eWAHCompressedBitmap));
    }

    final InflatingBitSet xor(EWAHCompressedBitmap eWAHCompressedBitmap) {
        if (isEmpty()) {
            return eWAHCompressedBitmap.sizeInBits() == 0 ? this : new InflatingBitSet(eWAHCompressedBitmap);
        }
        return new InflatingBitSet(this.bitmap.xor(eWAHCompressedBitmap));
    }

    final EWAHCompressedBitmap getBitmap() {
        return this.bitmap;
    }
}
