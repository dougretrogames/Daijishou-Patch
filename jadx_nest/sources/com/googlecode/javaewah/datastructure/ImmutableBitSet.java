package com.googlecode.javaewah.datastructure;

import com.googlecode.javaewah.IntIterator;
import java.nio.LongBuffer;
import java.util.Iterator;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ImmutableBitSet implements Cloneable, Iterable<Integer>, WordArray {
    private LongBuffer data;

    public ImmutableBitSet(LongBuffer longBuffer) {
        int i = (int) longBuffer.get(0);
        LongBuffer longBufferSlice = longBuffer.slice();
        longBufferSlice.position(1);
        LongBuffer longBufferSlice2 = longBufferSlice.slice();
        this.data = longBufferSlice2;
        longBufferSlice2.limit(i);
    }

    public BitSet asBitSet() {
        BitSet bitSet = new BitSet(size());
        this.data.rewind();
        this.data.get(bitSet.data, 0, bitSet.data.length);
        return bitSet;
    }

    public int cardinality() {
        int iLimit = this.data.limit();
        int iBitCount = 0;
        for (int i = 0; i < iLimit; i++) {
            iBitCount += Long.bitCount(this.data.get(i));
        }
        return iBitCount;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ImmutableBitSet m3468clone() {
        try {
            ImmutableBitSet immutableBitSet = (ImmutableBitSet) super.clone();
            immutableBitSet.data = this.data.duplicate();
            return immutableBitSet;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WordArray)) {
            return false;
        }
        WordArray wordArray = (WordArray) obj;
        for (int i = 0; i < Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); i++) {
            if (getWord(i) != wordArray.getWord(i)) {
                return false;
            }
        }
        WordArray wordArray2 = wordArray.getNumberOfWords() < getNumberOfWords() ? this : wordArray;
        for (int iMin = Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); iMin < Math.max(getNumberOfWords(), wordArray.getNumberOfWords()); iMin++) {
            if (wordArray2.getWord(iMin) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean empty() {
        int iLimit = this.data.limit();
        for (int i = 0; i < iLimit; i++) {
            if (this.data.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean get(int i) {
        return (this.data.get(i / 64) & (1 << (i % 64))) != 0;
    }

    public int hashCode() {
        int iLimit = this.data.limit();
        long j = 0;
        for (int i = 0; i < iLimit; i++) {
            j = (j * ((long) 31)) + this.data.get(i);
        }
        return (int) j;
    }

    /* JADX INFO: renamed from: com.googlecode.javaewah.datastructure.ImmutableBitSet$1, reason: invalid class name */
    class AnonymousClass1 implements IntIterator {
        private int i;
        private int j;

        AnonymousClass1() {
            this.i = ImmutableBitSet.this.nextSetBit(0);
        }

        @Override // com.googlecode.javaewah.IntIterator
        public boolean hasNext() {
            return this.i >= 0;
        }

        @Override // com.googlecode.javaewah.IntIterator
        public int next() {
            int i = this.i;
            this.j = i;
            this.i = ImmutableBitSet.this.nextSetBit(i + 1);
            return this.j;
        }
    }

    public IntIterator intIterator() {
        return new AnonymousClass1();
    }

    /* JADX INFO: renamed from: com.googlecode.javaewah.datastructure.ImmutableBitSet$2, reason: invalid class name */
    class AnonymousClass2 implements Iterator<Integer> {
        private int i;
        private int j;

        AnonymousClass2() {
            this.i = ImmutableBitSet.this.nextSetBit(0);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.i >= 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            int i = this.i;
            this.j = i;
            this.i = ImmutableBitSet.this.nextSetBit(i + 1);
            return Integer.valueOf(this.j);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new RuntimeException("Object is immutable");
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new AnonymousClass2();
    }

    public boolean intersects(BitSet bitSet) {
        for (int i = 0; i < Math.min(this.data.limit(), bitSet.data.length); i++) {
            if ((this.data.get(i) & bitSet.data[i]) != 0) {
                return true;
            }
        }
        return false;
    }

    public int nextSetBit(int i) {
        int iNumberOfTrailingZeros;
        int i2 = i / 64;
        if (i2 >= this.data.limit()) {
            return -1;
        }
        long j = this.data.get(i2) >>> (i % 64);
        if (j != 0) {
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        } else {
            do {
                i2++;
                if (i2 >= this.data.limit()) {
                    return -1;
                }
            } while (this.data.get(i2) == 0);
            i = i2 * 64;
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(this.data.get(i2));
        }
        return i + iNumberOfTrailingZeros;
    }

    public int nextUnsetBit(int i) {
        int iNumberOfTrailingZeros;
        int i2 = i / 64;
        if (i2 >= this.data.limit()) {
            return -1;
        }
        long j = (~this.data.get(i2)) >>> (i % 64);
        if (j != 0) {
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        } else {
            do {
                i2++;
                if (i2 >= this.data.limit()) {
                    return -1;
                }
            } while (this.data.get(i2) == -1);
            i = i2 * 64;
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~this.data.get(i2));
        }
        return i + iNumberOfTrailingZeros;
    }

    public int size() {
        return this.data.limit() * 64;
    }

    /* JADX INFO: renamed from: com.googlecode.javaewah.datastructure.ImmutableBitSet$3, reason: invalid class name */
    class AnonymousClass3 implements IntIterator {
        private int i;
        private int j;

        AnonymousClass3() {
            this.i = ImmutableBitSet.this.nextUnsetBit(0);
        }

        @Override // com.googlecode.javaewah.IntIterator
        public boolean hasNext() {
            return this.i >= 0;
        }

        @Override // com.googlecode.javaewah.IntIterator
        public int next() {
            int i = this.i;
            this.j = i;
            this.i = ImmutableBitSet.this.nextUnsetBit(i + 1);
            return this.j;
        }
    }

    public IntIterator unsetIntIterator() {
        return new AnonymousClass3();
    }

    @Override // com.googlecode.javaewah.datastructure.WordArray
    public int getNumberOfWords() {
        return this.data.limit();
    }

    @Override // com.googlecode.javaewah.datastructure.WordArray
    public long getWord(int i) {
        return this.data.get(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        IntIterator intIterator = intIterator();
        if (intIterator.hasNext()) {
            sb.append(intIterator.next());
        }
        while (intIterator.hasNext()) {
            sb.append(CollectionUtils.COMMA);
            sb.append(intIterator.next());
        }
        sb.append("}");
        return sb.toString();
    }
}
