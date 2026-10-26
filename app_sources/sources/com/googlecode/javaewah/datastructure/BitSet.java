package com.googlecode.javaewah.datastructure;

import com.googlecode.javaewah.IntIterator;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: loaded from: classes4.dex */
public class BitSet implements Cloneable, Iterable<Integer>, Externalizable, WordArray {
    static final long serialVersionUID = 7997698588986878754L;
    long[] data;

    public BitSet(int i) {
        this.data = new long[(i + 63) / 64];
    }

    public BitSet() {
        this.data = new long[0];
    }

    public void and(WordArray wordArray) {
        for (int i = 0; i < Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); i++) {
            long[] jArr = this.data;
            jArr[i] = jArr[i] & wordArray.getWord(i);
        }
    }

    public int andcardinality(WordArray wordArray) {
        int iBitCount = 0;
        for (int i = 0; i < Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); i++) {
            iBitCount += Long.bitCount(getWord(i) & wordArray.getWord(i));
        }
        return iBitCount;
    }

    public void andNot(WordArray wordArray) {
        for (int i = 0; i < Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); i++) {
            long[] jArr = this.data;
            jArr[i] = jArr[i] & (~wordArray.getWord(i));
        }
    }

    public int andNotcardinality(WordArray wordArray) {
        int iBitCount = 0;
        for (int i = 0; i < Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); i++) {
            iBitCount += Long.bitCount(getWord(i) & (~wordArray.getWord(i)));
        }
        return iBitCount;
    }

    public int cardinality() {
        int iBitCount = 0;
        for (long j : this.data) {
            iBitCount += Long.bitCount(j);
        }
        return iBitCount;
    }

    public void clear() {
        Arrays.fill(this.data, 0L);
    }

    public void clear(int i) {
        unset(i);
    }

    public void clear(int i, int i2) {
        if (i == i2) {
            return;
        }
        int i3 = i / 64;
        int i4 = (i2 - 1) / 64;
        if (i3 == i4) {
            long[] jArr = this.data;
            jArr[i3] = (~(((-1) >>> (-i2)) & ((-1) << i))) & jArr[i3];
            return;
        }
        long[] jArr2 = this.data;
        jArr2[i3] = jArr2[i3] & (~((-1) << i));
        while (true) {
            i3++;
            if (i3 < i4) {
                this.data[i3] = 0;
            } else {
                long[] jArr3 = this.data;
                jArr3[i4] = (~((-1) >>> (-i2))) & jArr3[i4];
                return;
            }
        }
    }

    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitSet m3467clone() {
        try {
            BitSet bitSet = (BitSet) super.clone();
            bitSet.data = Arrays.copyOf(this.data, getNumberOfWords());
            return bitSet;
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
        for (long j : this.data) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public void flip(int i) {
        long[] jArr = this.data;
        int i2 = i / 64;
        jArr[i2] = jArr[i2] ^ (1 << (i % 64));
    }

    public void flip(int i, int i2) {
        if (i == i2) {
            return;
        }
        int i3 = i / 64;
        int i4 = (i2 - 1) / 64;
        long[] jArr = this.data;
        jArr[i3] = jArr[i3] ^ (~((-1) << i));
        while (i3 < i4) {
            long[] jArr2 = this.data;
            jArr2[i3] = ~jArr2[i3];
            i3++;
        }
        long[] jArr3 = this.data;
        jArr3[i4] = jArr3[i4] ^ ((-1) >>> (-i2));
    }

    public boolean get(int i) {
        return (this.data[i / 64] & (1 << (i % 64))) != 0;
    }

    public int hashCode() {
        long word = 0;
        for (int i = 0; i < this.data.length; i++) {
            word = (word * ((long) 31)) + getWord(i);
        }
        return (int) word;
    }

    /* INFO: renamed from: com.googlecode.javaewah.datastructure.BitSet$1, reason: invalid class name */
    class AnonymousClass1 implements IntIterator {
        private int i;
        private int j;

        AnonymousClass1() {
            this.i = BitSet.this.nextSetBit(0);
        }

        @Override // com.googlecode.javaewah.IntIterator
        public boolean hasNext() {
            return this.i >= 0;
        }

        @Override // com.googlecode.javaewah.IntIterator
        public int next() {
            int i = this.i;
            this.j = i;
            this.i = BitSet.this.nextSetBit(i + 1);
            return this.j;
        }
    }

    public IntIterator intIterator() {
        return new AnonymousClass1();
    }

    /* INFO: renamed from: com.googlecode.javaewah.datastructure.BitSet$2, reason: invalid class name */
    class AnonymousClass2 implements Iterator<Integer> {
        private int i;
        private int j;

        AnonymousClass2() {
            this.i = BitSet.this.nextSetBit(0);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.i >= 0;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            int i = this.i;
            this.j = i;
            this.i = BitSet.this.nextSetBit(i + 1);
            return Integer.valueOf(this.j);
        }

        @Override // java.util.Iterator
        public void remove() {
            BitSet.this.unset(this.j);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new AnonymousClass2();
    }

    public boolean intersects(WordArray wordArray) {
        for (int i = 0; i < Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); i++) {
            if ((getWord(i) & wordArray.getWord(i)) != 0) {
                return true;
            }
        }
        return false;
    }

    public int nextSetBit(int i) {
        long j;
        int i2 = i / 64;
        if (i2 >= getNumberOfWords()) {
            return -1;
        }
        long j2 = this.data[i2] >>> i;
        if (j2 != 0) {
            return i + Long.numberOfTrailingZeros(j2);
        }
        do {
            i2++;
            if (i2 >= getNumberOfWords()) {
                return -1;
            }
            j = this.data[i2];
        } while (j == 0);
        return (i2 * 64) + Long.numberOfTrailingZeros(j);
    }

    public int nextUnsetBit(int i) {
        long j;
        int i2 = i / 64;
        if (i2 >= getNumberOfWords()) {
            return -1;
        }
        long j2 = (~this.data[i2]) >>> i;
        if (j2 != 0) {
            return i + Long.numberOfTrailingZeros(j2);
        }
        do {
            i2++;
            if (i2 >= getNumberOfWords()) {
                return -1;
            }
            j = this.data[i2];
        } while (j == -1);
        return (i2 * 64) + Long.numberOfTrailingZeros(~j);
    }

    public void or(WordArray wordArray) {
        if (getNumberOfWords() < wordArray.getNumberOfWords()) {
            resize(wordArray.getNumberOfWords() * 64);
        }
        for (int i = 0; i < getNumberOfWords(); i++) {
            long[] jArr = this.data;
            jArr[i] = jArr[i] | wordArray.getWord(i);
        }
    }

    public int orcardinality(WordArray wordArray) {
        int iBitCount = 0;
        for (int i = 0; i < Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); i++) {
            iBitCount += Long.bitCount(getWord(i) | wordArray.getWord(i));
        }
        WordArray wordArray2 = wordArray.getNumberOfWords() < getNumberOfWords() ? this : wordArray;
        for (int iMin = Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); iMin < Math.max(getNumberOfWords(), wordArray.getNumberOfWords()); iMin++) {
            iBitCount += Long.bitCount(wordArray2.getWord(iMin));
        }
        return iBitCount;
    }

    public void removeWord(int i) {
        long[] jArr = this.data;
        long[] jArr2 = new long[jArr.length - 1];
        if (i == 0) {
            System.arraycopy(jArr, 1, jArr2, 0, i - 1);
        }
        int i2 = i - 1;
        System.arraycopy(this.data, 0, jArr2, 0, i2);
        long[] jArr3 = this.data;
        System.arraycopy(jArr3, i, jArr2, i2, jArr3.length - i);
        this.data = jArr2;
    }

    public void resize(int i) {
        this.data = Arrays.copyOf(this.data, (i + 63) / 64);
    }

    public void set(int i) {
        long[] jArr = this.data;
        int i2 = i / 64;
        jArr[i2] = jArr[i2] | (1 << (i % 64));
    }

    public void set(int i, boolean z) {
        if (z) {
            set(i);
        } else {
            unset(i);
        }
    }

    public void set(int i, int i2) {
        if (i == i2) {
            return;
        }
        int i3 = i / 64;
        int i4 = (i2 - 1) / 64;
        if (i3 == i4) {
            long[] jArr = this.data;
            jArr[i3] = (((-1) >>> (-i2)) & ((-1) << i)) | jArr[i3];
            return;
        }
        long[] jArr2 = this.data;
        jArr2[i3] = jArr2[i3] | ((-1) << i);
        while (true) {
            i3++;
            if (i3 < i4) {
                this.data[i3] = -1;
            } else {
                long[] jArr3 = this.data;
                jArr3[i4] = ((-1) >>> (-i2)) | jArr3[i4];
                return;
            }
        }
    }

    public void set(int i, int i2, boolean z) {
        if (z) {
            set(i, i2);
        } else {
            clear(i, i2);
        }
    }

    public int size() {
        return getNumberOfWords() * 64;
    }

    public void trim() {
        for (int numberOfWords = getNumberOfWords() - 1; numberOfWords >= 0; numberOfWords--) {
            if (getWord(numberOfWords) != 0) {
                int i = numberOfWords + 1;
                if (i < getNumberOfWords()) {
                    this.data = Arrays.copyOf(this.data, i);
                    return;
                }
                return;
            }
        }
        this.data = new long[0];
    }

    public void unset(int i) {
        long[] jArr = this.data;
        int i2 = i / 64;
        jArr[i2] = jArr[i2] & (~(1 << (i % 64)));
    }

    /* INFO: renamed from: com.googlecode.javaewah.datastructure.BitSet$3, reason: invalid class name */
    class AnonymousClass3 implements IntIterator {
        private int i;
        private int j;

        AnonymousClass3() {
            this.i = BitSet.this.nextUnsetBit(0);
        }

        @Override // com.googlecode.javaewah.IntIterator
        public boolean hasNext() {
            return this.i >= 0;
        }

        @Override // com.googlecode.javaewah.IntIterator
        public int next() {
            int i = this.i;
            this.j = i;
            this.i = BitSet.this.nextUnsetBit(i + 1);
            return this.j;
        }
    }

    public IntIterator unsetIntIterator() {
        return new AnonymousClass3();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        serialize(objectOutput);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        deserialize(objectInput);
    }

    public void serialize(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(getNumberOfWords());
        for (long j : this.data) {
            dataOutput.writeLong(j);
        }
    }

    public void deserialize(DataInput dataInput) throws IOException {
        int i = (int) dataInput.readLong();
        this.data = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.data[i2] = dataInput.readLong();
        }
    }

    public void xor(WordArray wordArray) {
        if (getNumberOfWords() < wordArray.getNumberOfWords()) {
            resize(wordArray.getNumberOfWords() * 64);
        }
        for (int i = 0; i < getNumberOfWords(); i++) {
            long[] jArr = this.data;
            jArr[i] = jArr[i] ^ wordArray.getWord(i);
        }
    }

    public int xorcardinality(WordArray wordArray) {
        int iBitCount = 0;
        for (int i = 0; i < Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); i++) {
            iBitCount += Long.bitCount(getWord(i) ^ wordArray.getWord(i));
        }
        WordArray wordArray2 = wordArray.getNumberOfWords() < getNumberOfWords() ? this : wordArray;
        int iMax = Math.max(getNumberOfWords(), wordArray.getNumberOfWords());
        for (int iMin = Math.min(getNumberOfWords(), wordArray.getNumberOfWords()); iMin < iMax; iMin++) {
            iBitCount += Long.bitCount(wordArray2.getWord(iMin));
        }
        return iBitCount;
    }

    @Override // com.googlecode.javaewah.datastructure.WordArray
    public int getNumberOfWords() {
        return this.data.length;
    }

    @Override // com.googlecode.javaewah.datastructure.WordArray
    public long getWord(int i) {
        return this.data[i];
    }

    public static BitSet bitmapOf(int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            if (i < i2) {
                i = i2;
            }
        }
        BitSet bitSet = new BitSet(i + 1);
        for (int i3 : iArr) {
            bitSet.set(i3);
        }
        return bitSet;
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
