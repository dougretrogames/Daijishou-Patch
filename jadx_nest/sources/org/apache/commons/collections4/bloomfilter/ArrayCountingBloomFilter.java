package org.apache.commons.collections4.bloomfilter;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes5.dex */
public final class ArrayCountingBloomFilter implements CountingBloomFilter {
    private final int[] cells;
    private final Shape shape;
    private int state;

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int characteristics() {
        return 1;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CountingBloomFilter
    public int getMaxCell() {
        return Integer.MAX_VALUE;
    }

    private ArrayCountingBloomFilter(ArrayCountingBloomFilter arrayCountingBloomFilter) {
        this.shape = arrayCountingBloomFilter.shape;
        this.state = arrayCountingBloomFilter.state;
        this.cells = (int[]) arrayCountingBloomFilter.cells.clone();
    }

    public ArrayCountingBloomFilter(Shape shape) {
        Objects.requireNonNull(shape, "shape");
        this.shape = shape;
        this.cells = new int[shape.getNumberOfBits()];
    }

    @Override // org.apache.commons.collections4.bloomfilter.CountingBloomFilter
    public boolean add(CellExtractor cellExtractor) {
        Objects.requireNonNull(cellExtractor, "other");
        cellExtractor.processCells(new ArrayCountingBloomFilter$$ExternalSyntheticLambda2(this));
        return isValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean add(int i, int i2) {
        try {
            int[] iArr = this.cells;
            int i3 = iArr[i] + i2;
            this.state |= i3;
            iArr[i] = i3;
            return true;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("Filter only accepts values in the [0,%d) range", Integer.valueOf(getShape().getNumberOfBits())), e);
        }
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
    public int[] asIndexArray() {
        return IntStream.range(0, this.cells.length).filter(new ArrayCountingBloomFilter$$ExternalSyntheticLambda3(this)).toArray();
    }

    /* JADX INFO: renamed from: lambda$asIndexArray$0$org-apache-commons-collections4-bloomfilter-ArrayCountingBloomFilter, reason: not valid java name */
    /* synthetic */ boolean m5529xa6be2796(int i) {
        return this.cells[i] > 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int cardinality() {
        return (int) IntStream.range(0, this.cells.length).filter(new ArrayCountingBloomFilter$$ExternalSyntheticLambda4(this)).count();
    }

    /* JADX INFO: renamed from: lambda$cardinality$1$org-apache-commons-collections4-bloomfilter-ArrayCountingBloomFilter, reason: not valid java name */
    /* synthetic */ boolean m5530x217effda(int i) {
        return this.cells[i] > 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public void clear() {
        Arrays.fill(this.cells, 0);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(BitMapExtractor bitMapExtractor) {
        return contains(IndexExtractor.fromBitMapExtractor(bitMapExtractor));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(IndexExtractor indexExtractor) {
        return indexExtractor.processIndices(new ArrayCountingBloomFilter$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$contains$2$org-apache-commons-collections4-bloomfilter-ArrayCountingBloomFilter, reason: not valid java name */
    /* synthetic */ boolean m5531x4c2d03ee(int i) {
        return this.cells[i] != 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public ArrayCountingBloomFilter copy() {
        return new ArrayCountingBloomFilter(this);
    }

    @Override // org.apache.commons.collections4.bloomfilter.CountingBloomFilter
    public int getMaxInsert(CellExtractor cellExtractor) {
        int[] iArr = {Integer.MAX_VALUE};
        cellExtractor.processCells(new ArrayCountingBloomFilter$$ExternalSyntheticLambda0(this, iArr));
        return iArr[0];
    }

    /* JADX INFO: renamed from: lambda$getMaxInsert$3$org-apache-commons-collections4-bloomfilter-ArrayCountingBloomFilter, reason: not valid java name */
    /* synthetic */ boolean m5532x8ea261a5(int[] iArr, int i, int i2) {
        int i3 = this.cells[i] / i2;
        if (i3 < iArr[0]) {
            iArr[0] = i3;
        }
        return iArr[0] > 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public Shape getShape() {
        return this.shape;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CountingBloomFilter
    public boolean isValid() {
        return this.state >= 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public boolean processBitMaps(LongPredicate longPredicate) {
        Objects.requireNonNull(longPredicate, "consumer");
        int iNumberOfBitMaps = BitMaps.numberOfBitMaps(this.cells.length) - 1;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            long longBit = 0;
            if (i2 < iNumberOfBitMaps) {
                int i4 = 0;
                while (i4 < 64) {
                    int i5 = i3 + 1;
                    if (this.cells[i3] != 0) {
                        longBit |= BitMaps.getLongBit(i4);
                    }
                    i4++;
                    i3 = i5;
                }
                if (!longPredicate.test(longBit)) {
                    return false;
                }
                i2++;
            } else {
                while (true) {
                    int[] iArr = this.cells;
                    if (i3 < iArr.length) {
                        int i6 = i3 + 1;
                        if (iArr[i3] != 0) {
                            longBit |= BitMaps.getLongBit(i);
                        }
                        i++;
                        i3 = i6;
                    } else {
                        return longPredicate.test(longBit);
                    }
                }
            }
        }
    }

    @Override // org.apache.commons.collections4.bloomfilter.CellExtractor
    public boolean processCells(CellExtractor.CellPredicate cellPredicate) {
        Objects.requireNonNull(cellPredicate, "consumer");
        int i = 0;
        while (true) {
            int[] iArr = this.cells;
            if (i >= iArr.length) {
                return true;
            }
            int i2 = iArr[i];
            if (i2 != 0 && !cellPredicate.test(i, i2)) {
                return false;
            }
            i++;
        }
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
    public boolean processIndices(IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate, "consumer");
        int i = 0;
        while (true) {
            int[] iArr = this.cells;
            if (i >= iArr.length) {
                return true;
            }
            if (iArr[i] != 0 && !intPredicate.test(i)) {
                return false;
            }
            i++;
        }
    }

    @Override // org.apache.commons.collections4.bloomfilter.CountingBloomFilter
    public boolean subtract(CellExtractor cellExtractor) {
        Objects.requireNonNull(cellExtractor, "other");
        cellExtractor.processCells(new ArrayCountingBloomFilter$$ExternalSyntheticLambda5(this));
        return isValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean subtract(int i, int i2) {
        try {
            int[] iArr = this.cells;
            int i3 = iArr[i] - i2;
            this.state |= i3;
            iArr[i] = i3;
            return true;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("Filter only accepts values in the [0,%d) range", Integer.valueOf(getShape().getNumberOfBits())), e);
        }
    }
}
