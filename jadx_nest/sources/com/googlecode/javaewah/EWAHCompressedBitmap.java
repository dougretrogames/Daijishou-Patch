package com.googlecode.javaewah;

import com.googlecode.javaewah.symmetric.RunningBitmapMerge;
import com.googlecode.javaewah.symmetric.ThresholdFuncBitmap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: loaded from: classes4.dex */
public final class EWAHCompressedBitmap implements Cloneable, Externalizable, Iterable<Integer>, BitmapStorage, LogicalElement<EWAHCompressedBitmap> {
    public static final boolean ADJUST_CONTAINER_SIZE_WHEN_AGGREGATING = true;
    public static final int WORD_IN_BITS = 64;
    static final long serialVersionUID = 1;
    final Buffer buffer;
    private RunningLengthWord rlw;
    private int sizeInBits;

    private boolean mergeLiteralWordInCurrentRunningLength(boolean z, boolean z2, long j, int i) {
        return (z == z2 || j == 0) && i == 1;
    }

    public EWAHCompressedBitmap() {
        this(new LongArray());
    }

    public EWAHCompressedBitmap(int i) {
        this(new LongArray(i));
    }

    public EWAHCompressedBitmap(ByteBuffer byteBuffer) {
        this.rlw = null;
        this.sizeInBits = 0;
        IntBuffer intBufferAsIntBuffer = byteBuffer.asIntBuffer();
        this.sizeInBits = intBufferAsIntBuffer.get(0);
        int i = intBufferAsIntBuffer.get(1);
        int i2 = intBufferAsIntBuffer.get((i * 2) + 2);
        LongBuffer longBufferAsLongBuffer = byteBuffer.asLongBuffer();
        longBufferAsLongBuffer.position(1);
        LongBufferWrapper longBufferWrapper = new LongBufferWrapper(longBufferAsLongBuffer.slice(), i);
        this.buffer = longBufferWrapper;
        this.rlw = new RunningLengthWord(longBufferWrapper, i2);
    }

    public EWAHCompressedBitmap(LongBuffer longBuffer) {
        this(new LongBufferWrapper(longBuffer));
    }

    private EWAHCompressedBitmap(Buffer buffer) {
        this.rlw = null;
        this.sizeInBits = 0;
        this.buffer = buffer;
        this.rlw = new RunningLengthWord(buffer, 0);
    }

    @Deprecated
    public void add(long j) {
        addWord(j);
    }

    @Deprecated
    public void add(long j, int i) {
        addWord(j, i);
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addWord(long j) {
        addWord(j, 64);
    }

    public void addWord(long j, int i) {
        this.sizeInBits += i;
        if (j == 0) {
            insertEmptyWord(false);
        } else if (j == -1) {
            insertEmptyWord(true);
        } else {
            insertLiteralWord(j);
        }
    }

    private void insertEmptyWord(boolean z) {
        boolean z2 = this.rlw.getNumberOfLiteralWords() == 0;
        long runningLength = this.rlw.getRunningLength();
        if (z2 && runningLength == 0) {
            this.rlw.setRunningBit(z);
        }
        if (z2 && this.rlw.getRunningBit() == z && runningLength < 4294967295L) {
            this.rlw.setRunningLength(runningLength + 1);
            return;
        }
        this.buffer.push_back(0L);
        this.rlw.position = this.buffer.sizeInWords() - 1;
        this.rlw.setRunningBit(z);
        this.rlw.setRunningLength(1L);
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addLiteralWord(long j) {
        this.sizeInBits += 64;
        insertLiteralWord(j);
    }

    private void insertLiteralWord(long j) {
        int numberOfLiteralWords = this.rlw.getNumberOfLiteralWords();
        if (numberOfLiteralWords >= Integer.MAX_VALUE) {
            this.buffer.push_back(0L);
            this.rlw.position = this.buffer.sizeInWords() - 1;
            this.rlw.setNumberOfLiteralWords(1L);
            this.buffer.push_back(j);
            return;
        }
        this.rlw.setNumberOfLiteralWords(numberOfLiteralWords + 1);
        this.buffer.push_back(j);
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addStreamOfLiteralWords(Buffer buffer, int i, int i2) {
        while (i2 > 0) {
            int numberOfLiteralWords = this.rlw.getNumberOfLiteralWords();
            int i3 = Integer.MAX_VALUE - numberOfLiteralWords;
            if (i2 < i3) {
                i3 = i2;
            }
            this.rlw.setNumberOfLiteralWords(numberOfLiteralWords + i3);
            i2 -= i3;
            this.buffer.push_back(buffer, i, i3);
            this.sizeInBits += i3 * 64;
            if (i2 > 0) {
                this.buffer.push_back(0L);
                this.rlw.position = this.buffer.sizeInWords() - 1;
            }
        }
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addStreamOfEmptyWords(boolean z, long j) {
        if (j == 0) {
            return;
        }
        this.sizeInBits += (int) (64 * j);
        fastaddStreamOfEmptyWords(z, j);
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addStreamOfNegatedLiteralWords(Buffer buffer, int i, int i2) {
        while (i2 > 0) {
            int numberOfLiteralWords = this.rlw.getNumberOfLiteralWords();
            int i3 = Integer.MAX_VALUE - numberOfLiteralWords;
            if (i2 < i3) {
                i3 = i2;
            }
            this.rlw.setNumberOfLiteralWords(numberOfLiteralWords + i3);
            i2 -= i3;
            this.buffer.negative_push_back(buffer, i, i3);
            this.sizeInBits += i3 * 64;
            if (i2 > 0) {
                this.buffer.push_back(0L);
                this.rlw.position = this.buffer.sizeInWords() - 1;
            }
        }
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public EWAHCompressedBitmap and(EWAHCompressedBitmap eWAHCompressedBitmap) {
        EWAHCompressedBitmap eWAHCompressedBitmap2 = new EWAHCompressedBitmap(this.buffer.sizeInWords() > eWAHCompressedBitmap.buffer.sizeInWords() ? this.buffer.sizeInWords() : eWAHCompressedBitmap.buffer.sizeInWords());
        andToContainer(eWAHCompressedBitmap, eWAHCompressedBitmap2);
        return eWAHCompressedBitmap2;
    }

    public void andToContainer(EWAHCompressedBitmap eWAHCompressedBitmap, BitmapStorage bitmapStorage) {
        int i;
        bitmapStorage.clear();
        EWAHIterator eWAHIterator = eWAHCompressedBitmap.getEWAHIterator();
        EWAHIterator eWAHIterator2 = getEWAHIterator();
        IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord = new IteratingBufferedRunningLengthWord(eWAHIterator);
        IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord2 = new IteratingBufferedRunningLengthWord(eWAHIterator2);
        while (iteratingBufferedRunningLengthWord.size() > 0 && iteratingBufferedRunningLengthWord2.size() > 0) {
            while (true) {
                if (iteratingBufferedRunningLengthWord.getRunningLength() <= 0 && iteratingBufferedRunningLengthWord2.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingBufferedRunningLengthWord.getRunningLength() < iteratingBufferedRunningLengthWord2.getRunningLength();
                IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord3 = z ? iteratingBufferedRunningLengthWord : iteratingBufferedRunningLengthWord2;
                IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord4 = z ? iteratingBufferedRunningLengthWord2 : iteratingBufferedRunningLengthWord;
                if (!iteratingBufferedRunningLengthWord4.getRunningBit()) {
                    bitmapStorage.addStreamOfEmptyWords(false, iteratingBufferedRunningLengthWord4.getRunningLength());
                    iteratingBufferedRunningLengthWord3.discardFirstWords(iteratingBufferedRunningLengthWord4.getRunningLength());
                } else {
                    bitmapStorage.addStreamOfEmptyWords(false, iteratingBufferedRunningLengthWord4.getRunningLength() - iteratingBufferedRunningLengthWord3.discharge(bitmapStorage, iteratingBufferedRunningLengthWord4.getRunningLength()));
                }
                iteratingBufferedRunningLengthWord4.discardRunningWords();
            }
            int iMin = Math.min(iteratingBufferedRunningLengthWord.getNumberOfLiteralWords(), iteratingBufferedRunningLengthWord2.getNumberOfLiteralWords());
            if (iMin > 0) {
                for (i = 0; i < iMin; i++) {
                    bitmapStorage.addWord(iteratingBufferedRunningLengthWord.getLiteralWordAt(i) & iteratingBufferedRunningLengthWord2.getLiteralWordAt(i));
                }
                long j = iMin;
                iteratingBufferedRunningLengthWord.discardLiteralWords(j);
                iteratingBufferedRunningLengthWord2.discardLiteralWords(j);
            }
        }
        bitmapStorage.setSizeInBitsWithinLastWord(Math.max(sizeInBits(), eWAHCompressedBitmap.sizeInBits()));
    }

    public int andCardinality(EWAHCompressedBitmap eWAHCompressedBitmap) {
        BitCounter bitCounter = new BitCounter();
        andToContainer(eWAHCompressedBitmap, bitCounter);
        return bitCounter.getCount();
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public EWAHCompressedBitmap andNot(EWAHCompressedBitmap eWAHCompressedBitmap) {
        EWAHCompressedBitmap eWAHCompressedBitmap2 = new EWAHCompressedBitmap((this.buffer.sizeInWords() > eWAHCompressedBitmap.buffer.sizeInWords() ? this.buffer : eWAHCompressedBitmap.buffer).sizeInWords());
        andNotToContainer(eWAHCompressedBitmap, eWAHCompressedBitmap2);
        return eWAHCompressedBitmap2;
    }

    public void andNotToContainer(EWAHCompressedBitmap eWAHCompressedBitmap, BitmapStorage bitmapStorage) {
        bitmapStorage.clear();
        EWAHIterator eWAHIterator = getEWAHIterator();
        EWAHIterator eWAHIterator2 = eWAHCompressedBitmap.getEWAHIterator();
        IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord = new IteratingBufferedRunningLengthWord(eWAHIterator);
        IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord2 = new IteratingBufferedRunningLengthWord(eWAHIterator2);
        while (true) {
            if (iteratingBufferedRunningLengthWord.size() <= 0 || iteratingBufferedRunningLengthWord2.size() <= 0) {
                break;
            }
            while (true) {
                if (iteratingBufferedRunningLengthWord.getRunningLength() <= 0 && iteratingBufferedRunningLengthWord2.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingBufferedRunningLengthWord.getRunningLength() < iteratingBufferedRunningLengthWord2.getRunningLength();
                IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord3 = z ? iteratingBufferedRunningLengthWord : iteratingBufferedRunningLengthWord2;
                IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord4 = z ? iteratingBufferedRunningLengthWord2 : iteratingBufferedRunningLengthWord;
                if ((iteratingBufferedRunningLengthWord4.getRunningBit() && z) || !(iteratingBufferedRunningLengthWord4.getRunningBit() || z)) {
                    bitmapStorage.addStreamOfEmptyWords(false, iteratingBufferedRunningLengthWord4.getRunningLength());
                    iteratingBufferedRunningLengthWord3.discardFirstWords(iteratingBufferedRunningLengthWord4.getRunningLength());
                } else if (z) {
                    bitmapStorage.addStreamOfEmptyWords(false, iteratingBufferedRunningLengthWord4.getRunningLength() - iteratingBufferedRunningLengthWord3.discharge(bitmapStorage, iteratingBufferedRunningLengthWord4.getRunningLength()));
                } else {
                    bitmapStorage.addStreamOfEmptyWords(true, iteratingBufferedRunningLengthWord4.getRunningLength() - iteratingBufferedRunningLengthWord3.dischargeNegated(bitmapStorage, iteratingBufferedRunningLengthWord4.getRunningLength()));
                }
                iteratingBufferedRunningLengthWord4.discardRunningWords();
            }
            int iMin = Math.min(iteratingBufferedRunningLengthWord.getNumberOfLiteralWords(), iteratingBufferedRunningLengthWord2.getNumberOfLiteralWords());
            if (iMin > 0) {
                for (int i = 0; i < iMin; i++) {
                    bitmapStorage.addWord(iteratingBufferedRunningLengthWord.getLiteralWordAt(i) & (~iteratingBufferedRunningLengthWord2.getLiteralWordAt(i)));
                }
                long j = iMin;
                iteratingBufferedRunningLengthWord.discardLiteralWords(j);
                iteratingBufferedRunningLengthWord2.discardLiteralWords(j);
            }
        }
        boolean z2 = iteratingBufferedRunningLengthWord.size() > 0;
        if (!z2) {
            iteratingBufferedRunningLengthWord = iteratingBufferedRunningLengthWord2;
        }
        if (z2) {
            iteratingBufferedRunningLengthWord.discharge(bitmapStorage);
        }
        bitmapStorage.setSizeInBitsWithinLastWord(Math.max(sizeInBits(), eWAHCompressedBitmap.sizeInBits()));
    }

    public int andNotCardinality(EWAHCompressedBitmap eWAHCompressedBitmap) {
        BitCounter bitCounter = new BitCounter();
        andNotToContainer(eWAHCompressedBitmap, bitCounter);
        return bitCounter.getCount();
    }

    public int cardinality() {
        EWAHIterator eWAHIterator = getEWAHIterator();
        int iBitCount = 0;
        while (eWAHIterator.hasNext()) {
            RunningLengthWord next = eWAHIterator.next();
            if (next.getRunningBit()) {
                iBitCount += (int) (next.getRunningLength() * 64);
            }
            int numberOfLiteralWords = next.getNumberOfLiteralWords();
            int iLiteralWords = eWAHIterator.literalWords();
            for (int i = 0; i < numberOfLiteralWords; i++) {
                iBitCount += Long.bitCount(eWAHIterator.buffer().getWord(iLiteralWords + i));
            }
        }
        return iBitCount;
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void clear() {
        this.sizeInBits = 0;
        this.buffer.clear();
        this.rlw.position = 0;
    }

    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public EWAHCompressedBitmap m3460clone() throws CloneNotSupportedException {
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap(this.buffer.m3465clone());
        eWAHCompressedBitmap.sizeInBits = this.sizeInBits;
        eWAHCompressedBitmap.rlw = new RunningLengthWord(eWAHCompressedBitmap.buffer, this.rlw.position);
        return eWAHCompressedBitmap;
    }

    public void serialize(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.sizeInBits);
        int iSizeInWords = this.buffer.sizeInWords();
        dataOutput.writeInt(iSizeInWords);
        for (int i = 0; i < iSizeInWords; i++) {
            dataOutput.writeLong(this.buffer.getWord(i));
        }
        dataOutput.writeInt(this.rlw.position);
    }

    public void deserialize(DataInput dataInput) throws IOException {
        this.sizeInBits = dataInput.readInt();
        int i = dataInput.readInt();
        this.buffer.clear();
        this.buffer.removeLastWord();
        this.buffer.ensureCapacity(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.buffer.push_back(dataInput.readLong());
        }
        this.rlw = new RunningLengthWord(this.buffer, dataInput.readInt());
    }

    public boolean equals(Object obj) {
        if (obj instanceof EWAHCompressedBitmap) {
            try {
                xorToContainer((EWAHCompressedBitmap) obj, new NonEmptyVirtualStorage());
                return true;
            } catch (NonEmptyVirtualStorage.NonEmptyException unused) {
            }
        }
        return false;
    }

    private void fastaddStreamOfEmptyWords(boolean z, long j) {
        if (this.rlw.getRunningBit() != z && this.rlw.size() == 0) {
            this.rlw.setRunningBit(z);
        } else if (this.rlw.getNumberOfLiteralWords() != 0 || this.rlw.getRunningBit() != z) {
            this.buffer.push_back(0L);
            this.rlw.position = this.buffer.sizeInWords() - 1;
            if (z) {
                this.rlw.setRunningBit(true);
            }
        }
        long runningLength = this.rlw.getRunningLength();
        long j2 = 4294967295L - runningLength;
        if (j < j2) {
            j2 = j;
        }
        this.rlw.setRunningLength(runningLength + j2);
        long j3 = j - j2;
        while (j3 >= 4294967295L) {
            this.buffer.push_back(0L);
            this.rlw.position = this.buffer.sizeInWords() - 1;
            if (z) {
                this.rlw.setRunningBit(true);
            }
            this.rlw.setRunningLength(4294967295L);
            j3 -= 4294967295L;
        }
        if (j3 > 0) {
            this.buffer.push_back(0L);
            this.rlw.position = this.buffer.sizeInWords() - 1;
            if (z) {
                this.rlw.setRunningBit(true);
            }
            this.rlw.setRunningLength(j3);
        }
    }

    public EWAHIterator getEWAHIterator() {
        return new EWAHIterator(this.buffer);
    }

    private ReverseEWAHIterator getReverseEWAHIterator() {
        return new ReverseEWAHIterator(this.buffer);
    }

    public IteratingRLW getIteratingRLW() {
        return new IteratingBufferedRunningLengthWord(this);
    }

    @Deprecated
    public List<Integer> getPositions() {
        return toList();
    }

    public List<Integer> toList() {
        ArrayList arrayList = new ArrayList();
        EWAHIterator eWAHIterator = getEWAHIterator();
        int runningLength = 0;
        while (eWAHIterator.hasNext()) {
            RunningLengthWord next = eWAHIterator.next();
            if (next.getRunningBit()) {
                long runningLength2 = next.getRunningLength();
                for (long j = 0; j < runningLength2; j++) {
                    int i = 0;
                    while (i < 64) {
                        arrayList.add(Integer.valueOf(runningLength));
                        i++;
                        runningLength++;
                    }
                }
            } else {
                runningLength += (int) (next.getRunningLength() * 64);
            }
            int numberOfLiteralWords = next.getNumberOfLiteralWords();
            for (int i2 = 0; i2 < numberOfLiteralWords; i2++) {
                long word = eWAHIterator.buffer().getWord(eWAHIterator.literalWords() + i2);
                while (word != 0) {
                    long j2 = (-word) & word;
                    arrayList.add(Integer.valueOf(Long.bitCount(j2 - 1) + runningLength));
                    word ^= j2;
                }
                runningLength += 64;
            }
        }
        while (arrayList.size() > 0 && ((Integer) arrayList.get(arrayList.size() - 1)).intValue() >= this.sizeInBits) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    public int hashCode() {
        EWAHIterator eWAHIterator = getEWAHIterator();
        int i = 0;
        while (eWAHIterator.hasNext()) {
            eWAHIterator.next();
            if (eWAHIterator.rlw.getRunningBit()) {
                long runningLength = eWAHIterator.rlw.getRunningLength();
                i = i + ((int) (runningLength * (-1640531535))) + ((int) ((runningLength >>> 32) * (-1640531535)));
            }
            int numberOfLiteralWords = eWAHIterator.rlw.getNumberOfLiteralWords();
            int iLiteralWords = eWAHIterator.literalWords();
            for (int i2 = 0; i2 < numberOfLiteralWords; i2++) {
                long word = this.buffer.getWord(iLiteralWords + i2);
                i = (int) (((long) ((int) (((long) i) + (word * (-1640531535))))) + ((word >>> 32) * (-1640531535)));
            }
        }
        return i;
    }

    public boolean intersects(EWAHCompressedBitmap eWAHCompressedBitmap) {
        try {
            andToContainer(eWAHCompressedBitmap, new NonEmptyVirtualStorage());
            return false;
        } catch (NonEmptyVirtualStorage.NonEmptyException unused) {
            return true;
        }
    }

    public IntIterator intIterator() {
        return new IntIteratorImpl(getEWAHIterator());
    }

    public IntIterator reverseIntIterator() {
        return new ReverseIntIterator(getReverseEWAHIterator(), this.sizeInBits);
    }

    public boolean isEmpty() {
        return getFirstSetBit() < 0;
    }

    public IntIterator clearIntIterator() {
        return new ClearIntIterator(getEWAHIterator(), this.sizeInBits);
    }

    public ChunkIterator chunkIterator() {
        return new ChunkIteratorImpl(getEWAHIterator(), this.sizeInBits);
    }

    /* INFO: renamed from: com.googlecode.javaewah.EWAHCompressedBitmap$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<Integer> {
        private final IntIterator under;

        AnonymousClass1() {
            this.under = EWAHCompressedBitmap.this.intIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.under.hasNext();
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            return Integer.valueOf(this.under.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("bitsets do not support remove");
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new AnonymousClass1();
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public void not() {
        RunningLengthWord next;
        EWAHIterator eWAHIterator = getEWAHIterator();
        if (eWAHIterator.hasNext()) {
            do {
                next = eWAHIterator.next();
                next.setRunningBit(!next.getRunningBit());
                int numberOfLiteralWords = next.getNumberOfLiteralWords();
                for (int i = 0; i < numberOfLiteralWords; i++) {
                    eWAHIterator.buffer().negateWord(eWAHIterator.literalWords() + i);
                }
            } while (eWAHIterator.hasNext());
            int i2 = this.sizeInBits % 64;
            if (i2 == 0) {
                return;
            }
            if (next.getNumberOfLiteralWords() == 0) {
                if (next.getRunningLength() <= 0 || !next.getRunningBit()) {
                    return;
                }
                if (next.getRunningLength() == 1 && next.position > 0) {
                    EWAHIterator eWAHIterator2 = getEWAHIterator();
                    int i3 = this.rlw.position;
                    while (eWAHIterator2.hasNext()) {
                        RunningLengthWord next2 = eWAHIterator2.next();
                        if (next2.position >= next.position) {
                            break;
                        } else {
                            i3 = next2.position;
                        }
                    }
                    this.rlw.position = i3;
                    this.buffer.removeLastWord();
                } else {
                    next.setRunningLength(next.getRunningLength() - 1);
                }
                insertLiteralWord((-1) >>> (64 - i2));
                return;
            }
            eWAHIterator.buffer().andWord((eWAHIterator.literalWords() + next.getNumberOfLiteralWords()) - 1, (-1) >>> (64 - i2));
        }
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public EWAHCompressedBitmap or(EWAHCompressedBitmap eWAHCompressedBitmap) {
        EWAHCompressedBitmap eWAHCompressedBitmap2 = new EWAHCompressedBitmap(this.buffer.sizeInWords() + eWAHCompressedBitmap.buffer.sizeInWords());
        orToContainer(eWAHCompressedBitmap, eWAHCompressedBitmap2);
        return eWAHCompressedBitmap2;
    }

    public void orToContainer(EWAHCompressedBitmap eWAHCompressedBitmap, BitmapStorage bitmapStorage) {
        int i;
        bitmapStorage.clear();
        EWAHIterator eWAHIterator = eWAHCompressedBitmap.getEWAHIterator();
        EWAHIterator eWAHIterator2 = getEWAHIterator();
        IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord = new IteratingBufferedRunningLengthWord(eWAHIterator);
        IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord2 = new IteratingBufferedRunningLengthWord(eWAHIterator2);
        while (iteratingBufferedRunningLengthWord.size() > 0 && iteratingBufferedRunningLengthWord2.size() > 0) {
            while (true) {
                if (iteratingBufferedRunningLengthWord.getRunningLength() <= 0 && iteratingBufferedRunningLengthWord2.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingBufferedRunningLengthWord.getRunningLength() < iteratingBufferedRunningLengthWord2.getRunningLength();
                IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord3 = z ? iteratingBufferedRunningLengthWord : iteratingBufferedRunningLengthWord2;
                IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord4 = z ? iteratingBufferedRunningLengthWord2 : iteratingBufferedRunningLengthWord;
                if (iteratingBufferedRunningLengthWord4.getRunningBit()) {
                    bitmapStorage.addStreamOfEmptyWords(true, iteratingBufferedRunningLengthWord4.getRunningLength());
                    iteratingBufferedRunningLengthWord3.discardFirstWords(iteratingBufferedRunningLengthWord4.getRunningLength());
                } else {
                    bitmapStorage.addStreamOfEmptyWords(false, iteratingBufferedRunningLengthWord4.getRunningLength() - iteratingBufferedRunningLengthWord3.discharge(bitmapStorage, iteratingBufferedRunningLengthWord4.getRunningLength()));
                }
                iteratingBufferedRunningLengthWord4.discardRunningWords();
            }
            int iMin = Math.min(iteratingBufferedRunningLengthWord.getNumberOfLiteralWords(), iteratingBufferedRunningLengthWord2.getNumberOfLiteralWords());
            if (iMin > 0) {
                for (i = 0; i < iMin; i++) {
                    bitmapStorage.addWord(iteratingBufferedRunningLengthWord.getLiteralWordAt(i) | iteratingBufferedRunningLengthWord2.getLiteralWordAt(i));
                }
                long j = iMin;
                iteratingBufferedRunningLengthWord.discardLiteralWords(j);
                iteratingBufferedRunningLengthWord2.discardLiteralWords(j);
            }
        }
        if (iteratingBufferedRunningLengthWord.size() <= 0) {
            iteratingBufferedRunningLengthWord = iteratingBufferedRunningLengthWord2;
        }
        iteratingBufferedRunningLengthWord.discharge(bitmapStorage);
        bitmapStorage.setSizeInBitsWithinLastWord(Math.max(sizeInBits(), eWAHCompressedBitmap.sizeInBits()));
    }

    public int orCardinality(EWAHCompressedBitmap eWAHCompressedBitmap) {
        BitCounter bitCounter = new BitCounter();
        orToContainer(eWAHCompressedBitmap, bitCounter);
        return bitCounter.getCount();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        deserialize(objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        serialize(objectOutput);
    }

    public int serializedSizeInBytes() {
        return sizeInBytes() + 12;
    }

    public boolean get(int i) {
        if (i >= 0 && i < this.sizeInBits) {
            IteratingRLW iteratingRLW = getIteratingRLW();
            int i2 = i / 64;
            int numberOfLiteralWords = 0;
            while (numberOfLiteralWords <= i2) {
                int runningLength = numberOfLiteralWords + ((int) iteratingRLW.getRunningLength());
                if (i2 < runningLength) {
                    return iteratingRLW.getRunningBit();
                }
                if (i2 < iteratingRLW.getNumberOfLiteralWords() + runningLength) {
                    return (iteratingRLW.getLiteralWordAt(i2 - runningLength) & (1 << i)) != 0;
                }
                numberOfLiteralWords = runningLength + iteratingRLW.getNumberOfLiteralWords();
                iteratingRLW.next();
            }
        }
        return false;
    }

    public int getFirstSetBit() {
        int iSizeInWords = this.buffer.sizeInWords();
        int i = 0;
        int i2 = 0;
        while (i < iSizeInWords) {
            long runningLength = RunningLengthWord.getRunningLength(this.buffer, i);
            boolean runningBit = RunningLengthWord.getRunningBit(this.buffer, i);
            if (runningLength > 0 && runningBit) {
                return i2 * 64;
            }
            i2 += (int) runningLength;
            long numberOfLiteralWords = RunningLengthWord.getNumberOfLiteralWords(this.buffer, i);
            int i3 = i + 1;
            for (int i4 = i3; i4 <= ((long) i) + numberOfLiteralWords; i4++) {
                long word = this.buffer.getWord(i4);
                if (word != 0) {
                    return (i2 * 64) + Long.bitCount(((-word) & word) - 1);
                }
                i2++;
            }
            i = i3;
        }
        return -1;
    }

    public boolean clear(int i) {
        return set(i, false);
    }

    public boolean set(int i) {
        return set(i, true);
    }

    private boolean set(int i, boolean z) {
        if (i > 2147483583 || i < 0) {
            throw new IndexOutOfBoundsException("Position should be between 0 and 2147483583");
        }
        if (i < this.sizeInBits) {
            locateAndSet(i, z);
            return true;
        }
        extendAndSet(i, z);
        return true;
    }

    private void extendAndSet(int i, boolean z) {
        int iDistanceInWords = distanceInWords(i);
        this.sizeInBits = i + 1;
        if (!z) {
            if (iDistanceInWords > 0) {
                fastaddStreamOfEmptyWords(false, iDistanceInWords);
                return;
            }
            return;
        }
        if (iDistanceInWords > 0) {
            if (this.rlw.getNumberOfLiteralWords() > 0 && this.buffer.getLastWord() == 0) {
                this.buffer.removeLastWord();
                RunningLengthWord runningLengthWord = this.rlw;
                runningLengthWord.setNumberOfLiteralWords(runningLengthWord.getNumberOfLiteralWords() - 1);
                insertEmptyWord(false);
            }
            if (iDistanceInWords > 1) {
                fastaddStreamOfEmptyWords(false, iDistanceInWords - 1);
            }
            insertLiteralWord(1 << (i % 64));
            return;
        }
        if (this.rlw.getNumberOfLiteralWords() == 0) {
            RunningLengthWord runningLengthWord2 = this.rlw;
            runningLengthWord2.setRunningLength(runningLengthWord2.getRunningLength() - 1);
            insertLiteralWord(1 << (i % 64));
            return;
        }
        this.buffer.orLastWord(1 << (i % 64));
        if (this.buffer.getLastWord() == -1) {
            this.buffer.removeLastWord();
            RunningLengthWord runningLengthWord3 = this.rlw;
            runningLengthWord3.setNumberOfLiteralWords(runningLengthWord3.getNumberOfLiteralWords() - 1);
            insertEmptyWord(true);
        }
    }

    private void locateAndSet(int i, boolean z) {
        EWAHCompressedBitmap eWAHCompressedBitmap = this;
        int iSizeInWords = eWAHCompressedBitmap.buffer.sizeInWords();
        int i2 = 0;
        int i3 = 0;
        while (i3 < iSizeInWords) {
            long runningLength = RunningLengthWord.getRunningLength(eWAHCompressedBitmap.buffer, i3);
            boolean runningBit = RunningLengthWord.getRunningBit(eWAHCompressedBitmap.buffer, i3);
            long numberOfLiteralWords = RunningLengthWord.getNumberOfLiteralWords(eWAHCompressedBitmap.buffer, i3);
            long j = runningLength * 64;
            long j2 = i;
            if (j2 < ((long) i2) + j) {
                setInRunningLength(z, i, i2, i3, runningLength, runningBit, numberOfLiteralWords);
                return;
            }
            int i4 = i2 + ((int) j);
            long j3 = numberOfLiteralWords * 64;
            if (j2 < ((long) i4) + j3) {
                setInLiteralWords(z, i, i4, i3, runningLength, runningBit, numberOfLiteralWords);
                return;
            } else {
                i2 = i4 + ((int) j3);
                i3 += (int) (numberOfLiteralWords + 1);
                eWAHCompressedBitmap = this;
            }
        }
    }

    private void setInRunningLength(boolean z, int i, int i2, int i3, long j, boolean z2, long j2) {
        if (z != z2) {
            int i4 = (i - i2) / 64;
            long j3 = i4 + 1;
            int i5 = j3 == j ? 1 : 2;
            int i6 = i3 + 1;
            this.buffer.expand(i6, i5);
            long j4 = 1 << (i % 64);
            Buffer buffer = this.buffer;
            if (!z) {
                j4 = ~j4;
            }
            buffer.setWord(i6, j4);
            if (this.rlw.position >= i6) {
                this.rlw.position += i5;
            }
            if (i5 == 1) {
                setRLWInfo(i3, z2, j - 1, j2 + 1);
                return;
            }
            setRLWInfo(i3, z2, i4, 1L);
            setRLWInfo(i3 + 2, z2, j - j3, j2);
            if (this.rlw.position == i3) {
                this.rlw.position += 2;
            }
        }
    }

    private void setInLiteralWords(boolean z, int i, int i2, int i3, long j, boolean z2, long j2) {
        int i4 = (i - i2) / 64;
        int i5 = i4 + 1;
        long j3 = 1 << (i % 64);
        if (z) {
            this.buffer.orWord(i3 + i5, j3);
        } else {
            this.buffer.andWord(i3 + i5, ~j3);
        }
        int i6 = i3 + i5;
        if (this.buffer.getWord(i6) == (z ? -1L : 0L)) {
            boolean zMergeLiteralWordInCurrentRunningLength = mergeLiteralWordInCurrentRunningLength(z, z2, j, i5);
            boolean zMergeLiteralWordInNextRunningLength = mergeLiteralWordInNextRunningLength(z, j2, i3, i5);
            if (zMergeLiteralWordInCurrentRunningLength && zMergeLiteralWordInNextRunningLength) {
                int i7 = i3 + 2;
                long runningLength = RunningLengthWord.getRunningLength(this.buffer, i7);
                long numberOfLiteralWords = RunningLengthWord.getNumberOfLiteralWords(this.buffer, i7);
                this.buffer.collapse(i3, 2);
                setRLWInfo(i3, z, j + 1 + runningLength, numberOfLiteralWords);
                if (this.rlw.position >= i7) {
                    this.rlw.position -= 2;
                    return;
                }
                return;
            }
            if (zMergeLiteralWordInCurrentRunningLength) {
                this.buffer.collapse(i3 + 1, 1);
                setRLWInfo(i3, z, j + 1, j2 - 1);
                if (this.rlw.position >= i3 + 2) {
                    this.rlw.position--;
                    return;
                }
                return;
            }
            if (zMergeLiteralWordInNextRunningLength) {
                int i8 = (int) (((long) i3) + j2 + 1);
                long runningLength2 = RunningLengthWord.getRunningLength(this.buffer, i8);
                long numberOfLiteralWords2 = RunningLengthWord.getNumberOfLiteralWords(this.buffer, i8);
                this.buffer.collapse(i6, 1);
                setRLWInfo(i3, z2, j, j2 - 1);
                setRLWInfo(i6, z, runningLength2 + 1, numberOfLiteralWords2);
                if (this.rlw.position >= i8) {
                    RunningLengthWord runningLengthWord = this.rlw;
                    runningLengthWord.position = (int) (((long) runningLengthWord.position) - ((j2 + 1) - ((long) i5)));
                    return;
                }
                return;
            }
            setRLWInfo(i3, z2, j, i4);
            setRLWInfo(i6, z, 1L, j2 - ((long) i5));
            if (this.rlw.position == i3) {
                this.rlw.position += i5;
            }
        }
    }

    private boolean mergeLiteralWordInNextRunningLength(boolean z, long j, int i, int i2) {
        int i3 = (int) (((long) i) + j + 1);
        if (j != i2 || i3 >= this.buffer.sizeInWords()) {
            return false;
        }
        return z == RunningLengthWord.getRunningBit(this.buffer, i3) || RunningLengthWord.getRunningLength(this.buffer, i3) == 0;
    }

    private void setRLWInfo(int i, boolean z, long j, long j2) {
        RunningLengthWord.setRunningBit(this.buffer, i, z);
        RunningLengthWord.setRunningLength(this.buffer, i, j);
        RunningLengthWord.setNumberOfLiteralWords(this.buffer, i, j2);
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void setSizeInBitsWithinLastWord(int i) {
        int i2 = (i + 63) / 64;
        int i3 = this.sizeInBits;
        if (i2 > (i3 + 63) / 64) {
            setSizeInBits(i, false);
            return;
        }
        if (i2 != (i3 + 63) / 64) {
            throw new RuntimeException("You can only reduce the size of the bitmap within the scope of the last word. To extend the bitmap, please call setSizeInBits(int,boolean).");
        }
        this.sizeInBits = i;
        int i4 = i % 64;
        if (i4 == 0) {
            return;
        }
        if (this.rlw.getNumberOfLiteralWords() != 0) {
            this.buffer.andLastWord((-1) >>> (64 - i4));
            return;
        }
        if (this.rlw.getRunningLength() > 0) {
            RunningLengthWord runningLengthWord = this.rlw;
            runningLengthWord.setRunningLength(runningLengthWord.getRunningLength() - 1);
            insertLiteralWord(this.rlw.getRunningBit() ? (-1) >>> (64 - i4) : 0L);
        }
    }

    public boolean setSizeInBits(int i, boolean z) {
        int i2 = this.sizeInBits;
        if (i <= i2) {
            return false;
        }
        if (i2 % 64 != 0) {
            if (!z) {
                if (this.rlw.getNumberOfLiteralWords() > 0) {
                    int i3 = this.sizeInBits;
                    int i4 = i - i3;
                    int i5 = i3 % 64;
                    int i6 = 64 - i5;
                    if (this.buffer.getLastWord() == 0) {
                        RunningLengthWord runningLengthWord = this.rlw;
                        runningLengthWord.setNumberOfLiteralWords(runningLengthWord.getNumberOfLiteralWords() - 1);
                        this.buffer.removeLastWord();
                        this.sizeInBits -= i5;
                    } else if (i5 > 0) {
                        this.sizeInBits += Math.min(i4, i6);
                    }
                }
            } else {
                if (this.rlw.getNumberOfLiteralWords() == 0) {
                    RunningLengthWord runningLengthWord2 = this.rlw;
                    runningLengthWord2.setRunningLength(runningLengthWord2.getRunningLength() - 1);
                    insertLiteralWord(0L);
                }
                int i7 = this.sizeInBits;
                int iMin = Math.min(64 - (i7 % 64), i - i7);
                this.buffer.orLastWord(((-1) >>> (64 - iMin)) << (this.sizeInBits % 64));
                if (this.buffer.getLastWord() == -1) {
                    this.buffer.removeLastWord();
                    RunningLengthWord runningLengthWord3 = this.rlw;
                    runningLengthWord3.setNumberOfLiteralWords(runningLengthWord3.getNumberOfLiteralWords() - 1);
                    insertEmptyWord(true);
                }
                this.sizeInBits += iMin;
            }
        }
        addStreamOfEmptyWords(z, (i / 64) - (this.sizeInBits / 64));
        if (this.sizeInBits < i) {
            if (distanceInWords(i - 1) > 0) {
                insertLiteralWord(0L);
            }
            if (z) {
                int i8 = this.sizeInBits;
                this.buffer.orLastWord(((-1) >>> (64 - (i - i8))) << (i8 % 64));
            }
            this.sizeInBits = i;
        }
        return true;
    }

    private int distanceInWords(int i) {
        return ((i + 64) / 64) - ((this.sizeInBits + 63) / 64);
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public int sizeInBits() {
        return this.sizeInBits;
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public int sizeInBytes() {
        return this.buffer.sizeInWords() * 8;
    }

    public static EWAHCompressedBitmap threshold(int i, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap();
        thresholdWithContainer(eWAHCompressedBitmap, i, eWAHCompressedBitmapArr);
        return eWAHCompressedBitmap;
    }

    static int maxSizeInBits(EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        int iMax = 0;
        for (EWAHCompressedBitmap eWAHCompressedBitmap : eWAHCompressedBitmapArr) {
            iMax = Math.max(iMax, eWAHCompressedBitmap.sizeInBits());
        }
        return iMax;
    }

    public static void thresholdWithContainer(BitmapStorage bitmapStorage, int i, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        new RunningBitmapMerge().symmetric(new ThresholdFuncBitmap(i), bitmapStorage, eWAHCompressedBitmapArr);
    }

    public int[] toArray() {
        int[] iArr = new int[cardinality()];
        EWAHIterator eWAHIterator = getEWAHIterator();
        int i = 0;
        int i2 = 0;
        while (eWAHIterator.hasNext()) {
            RunningLengthWord next = eWAHIterator.next();
            long runningLength = next.getRunningLength();
            if (next.getRunningBit()) {
                for (int i3 = 0; i3 < runningLength; i3++) {
                    int i4 = 0;
                    while (i4 < 64) {
                        iArr[i2] = i;
                        i4++;
                        i2++;
                        i++;
                    }
                }
            } else {
                i = (int) (((long) i) + (runningLength * 64));
            }
            int numberOfLiteralWords = next.getNumberOfLiteralWords();
            int iLiteralWords = eWAHIterator.literalWords();
            for (int i5 = 0; i5 < numberOfLiteralWords; i5++) {
                long word = eWAHIterator.buffer().getWord(iLiteralWords + i5);
                while (word != 0) {
                    long j = (-word) & word;
                    iArr[i2] = Long.bitCount(j - 1) + i;
                    word ^= j;
                    i2++;
                }
                i += 64;
            }
        }
        return iArr;
    }

    public String toDebugString() {
        StringBuilder sb = new StringBuilder("{\"size in bits\":");
        sb.append(this.sizeInBits).append(", \"size in words\":");
        sb.append(this.buffer.sizeInWords()).append(", \"content\": [");
        EWAHIterator eWAHIterator = getEWAHIterator();
        boolean z = true;
        while (eWAHIterator.hasNext()) {
            RunningLengthWord next = eWAHIterator.next();
            if (!z) {
                sb.append(CollectionUtils.COMMA);
            }
            sb.append(CollectionUtils.DEFAULT_TOSTRING_PREFIX);
            if (next.getRunningBit()) {
                sb.append(next.getRunningLength()).append(", \"1x11\", ");
            } else {
                sb.append(next.getRunningLength()).append(", \"0x00\", ");
            }
            sb.append(CollectionUtils.DEFAULT_TOSTRING_PREFIX);
            z = false;
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= next.getNumberOfLiteralWords()) {
                    break;
                }
                sb.append("\"0x").append(Long.toHexString(eWAHIterator.buffer().getWord(eWAHIterator.literalWords() + i))).append("\",");
                i = i2;
            }
            if (i < next.getNumberOfLiteralWords()) {
                sb.append("\"0x").append(Long.toHexString(eWAHIterator.buffer().getWord(eWAHIterator.literalWords() + i))).append("\"");
            }
            sb.append("]]");
        }
        sb.append("]}");
        return sb.toString();
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

    public void swap(EWAHCompressedBitmap eWAHCompressedBitmap) {
        this.buffer.swap(eWAHCompressedBitmap.buffer);
        int i = this.rlw.position;
        this.rlw.position = eWAHCompressedBitmap.rlw.position;
        eWAHCompressedBitmap.rlw.position = i;
        int i2 = this.sizeInBits;
        this.sizeInBits = eWAHCompressedBitmap.sizeInBits;
        eWAHCompressedBitmap.sizeInBits = i2;
    }

    public void trim() {
        this.buffer.trim();
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public EWAHCompressedBitmap xor(EWAHCompressedBitmap eWAHCompressedBitmap) {
        EWAHCompressedBitmap eWAHCompressedBitmap2 = new EWAHCompressedBitmap(this.buffer.sizeInWords() + eWAHCompressedBitmap.buffer.sizeInWords());
        xorToContainer(eWAHCompressedBitmap, eWAHCompressedBitmap2);
        return eWAHCompressedBitmap2;
    }

    public void xorToContainer(EWAHCompressedBitmap eWAHCompressedBitmap, BitmapStorage bitmapStorage) {
        int i;
        long jDischargeNegated;
        bitmapStorage.clear();
        EWAHIterator eWAHIterator = eWAHCompressedBitmap.getEWAHIterator();
        EWAHIterator eWAHIterator2 = getEWAHIterator();
        IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord = new IteratingBufferedRunningLengthWord(eWAHIterator);
        IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord2 = new IteratingBufferedRunningLengthWord(eWAHIterator2);
        while (iteratingBufferedRunningLengthWord.size() > 0 && iteratingBufferedRunningLengthWord2.size() > 0) {
            while (true) {
                if (iteratingBufferedRunningLengthWord.getRunningLength() <= 0 && iteratingBufferedRunningLengthWord2.getRunningLength() <= 0) {
                    break;
                }
                i = iteratingBufferedRunningLengthWord.getRunningLength() < iteratingBufferedRunningLengthWord2.getRunningLength() ? 1 : 0;
                IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord3 = i != 0 ? iteratingBufferedRunningLengthWord : iteratingBufferedRunningLengthWord2;
                IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord4 = i != 0 ? iteratingBufferedRunningLengthWord2 : iteratingBufferedRunningLengthWord;
                if (!iteratingBufferedRunningLengthWord4.getRunningBit()) {
                    jDischargeNegated = iteratingBufferedRunningLengthWord3.discharge(bitmapStorage, iteratingBufferedRunningLengthWord4.getRunningLength());
                } else {
                    jDischargeNegated = iteratingBufferedRunningLengthWord3.dischargeNegated(bitmapStorage, iteratingBufferedRunningLengthWord4.getRunningLength());
                }
                bitmapStorage.addStreamOfEmptyWords(iteratingBufferedRunningLengthWord4.getRunningBit(), iteratingBufferedRunningLengthWord4.getRunningLength() - jDischargeNegated);
                iteratingBufferedRunningLengthWord4.discardRunningWords();
            }
            int iMin = Math.min(iteratingBufferedRunningLengthWord.getNumberOfLiteralWords(), iteratingBufferedRunningLengthWord2.getNumberOfLiteralWords());
            if (iMin > 0) {
                for (i = 0; i < iMin; i++) {
                    bitmapStorage.addWord(iteratingBufferedRunningLengthWord.getLiteralWordAt(i) ^ iteratingBufferedRunningLengthWord2.getLiteralWordAt(i));
                }
                long j = iMin;
                iteratingBufferedRunningLengthWord.discardLiteralWords(j);
                iteratingBufferedRunningLengthWord2.discardLiteralWords(j);
            }
        }
        if (iteratingBufferedRunningLengthWord.size() <= 0) {
            iteratingBufferedRunningLengthWord = iteratingBufferedRunningLengthWord2;
        }
        iteratingBufferedRunningLengthWord.discharge(bitmapStorage);
        bitmapStorage.setSizeInBitsWithinLastWord(Math.max(sizeInBits(), eWAHCompressedBitmap.sizeInBits()));
    }

    public int xorCardinality(EWAHCompressedBitmap eWAHCompressedBitmap) {
        BitCounter bitCounter = new BitCounter();
        xorToContainer(eWAHCompressedBitmap, bitCounter);
        return bitCounter.getCount();
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public EWAHCompressedBitmap compose(EWAHCompressedBitmap eWAHCompressedBitmap) {
        EWAHCompressedBitmap eWAHCompressedBitmap2 = new EWAHCompressedBitmap(this.buffer.sizeInWords());
        composeToContainer(eWAHCompressedBitmap, eWAHCompressedBitmap2);
        return eWAHCompressedBitmap2;
    }

    public void composeToContainer(EWAHCompressedBitmap eWAHCompressedBitmap, EWAHCompressedBitmap eWAHCompressedBitmap2) {
        eWAHCompressedBitmap2.clear();
        ChunkIterator chunkIterator = chunkIterator();
        ChunkIterator chunkIterator2 = eWAHCompressedBitmap.chunkIterator();
        int i = 0;
        while (chunkIterator.hasNext() && chunkIterator2.hasNext()) {
            if (!chunkIterator.nextBit()) {
                int iNextLength = chunkIterator.nextLength();
                i += iNextLength;
                eWAHCompressedBitmap2.setSizeInBits(i, false);
                chunkIterator.move(iNextLength);
            } else {
                int iMin = Math.min(chunkIterator.nextLength(), chunkIterator2.nextLength());
                i += iMin;
                eWAHCompressedBitmap2.setSizeInBits(i, chunkIterator2.nextBit());
                chunkIterator.move(iMin);
                chunkIterator2.move(iMin);
            }
        }
        eWAHCompressedBitmap2.setSizeInBits(this.sizeInBits, false);
    }

    public static void andWithContainer(BitmapStorage bitmapStorage, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        if (eWAHCompressedBitmapArr.length == 1) {
            throw new IllegalArgumentException("Need at least one bitmap");
        }
        int i = 2;
        if (eWAHCompressedBitmapArr.length == 2) {
            eWAHCompressedBitmapArr[0].andToContainer(eWAHCompressedBitmapArr[1], bitmapStorage);
            return;
        }
        int iCalculateInitialSize = calculateInitialSize(eWAHCompressedBitmapArr);
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap(iCalculateInitialSize);
        EWAHCompressedBitmap eWAHCompressedBitmap2 = new EWAHCompressedBitmap(iCalculateInitialSize);
        eWAHCompressedBitmapArr[0].andToContainer(eWAHCompressedBitmapArr[1], eWAHCompressedBitmap);
        while (i < eWAHCompressedBitmapArr.length - 1) {
            eWAHCompressedBitmap.andToContainer(eWAHCompressedBitmapArr[i], eWAHCompressedBitmap2);
            eWAHCompressedBitmap.clear();
            i++;
            EWAHCompressedBitmap eWAHCompressedBitmap3 = eWAHCompressedBitmap2;
            eWAHCompressedBitmap2 = eWAHCompressedBitmap;
            eWAHCompressedBitmap = eWAHCompressedBitmap3;
        }
        eWAHCompressedBitmap.andToContainer(eWAHCompressedBitmapArr[eWAHCompressedBitmapArr.length - 1], bitmapStorage);
    }

    private static int calculateInitialSize(EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        int iMax = 0;
        for (EWAHCompressedBitmap eWAHCompressedBitmap : eWAHCompressedBitmapArr) {
            iMax = Math.max(eWAHCompressedBitmap.buffer.sizeInWords(), iMax);
        }
        return iMax;
    }

    public static EWAHCompressedBitmap and(EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        if (eWAHCompressedBitmapArr.length == 1) {
            return eWAHCompressedBitmapArr[0];
        }
        if (eWAHCompressedBitmapArr.length == 2) {
            return eWAHCompressedBitmapArr[0].and(eWAHCompressedBitmapArr[1]);
        }
        int iCalculateInitialSize = calculateInitialSize(eWAHCompressedBitmapArr);
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap(iCalculateInitialSize);
        EWAHCompressedBitmap eWAHCompressedBitmap2 = new EWAHCompressedBitmap(iCalculateInitialSize);
        eWAHCompressedBitmapArr[0].andToContainer(eWAHCompressedBitmapArr[1], eWAHCompressedBitmap);
        for (int i = 2; i < eWAHCompressedBitmapArr.length; i++) {
            eWAHCompressedBitmap.andToContainer(eWAHCompressedBitmapArr[i], eWAHCompressedBitmap2);
            eWAHCompressedBitmap2.swap(eWAHCompressedBitmap);
            eWAHCompressedBitmap2.clear();
        }
        return eWAHCompressedBitmap;
    }

    public static int andCardinality(EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        if (eWAHCompressedBitmapArr.length == 1) {
            return eWAHCompressedBitmapArr[0].cardinality();
        }
        BitCounter bitCounter = new BitCounter();
        andWithContainer(bitCounter, eWAHCompressedBitmapArr);
        return bitCounter.getCount();
    }

    public static EWAHCompressedBitmap bitmapOf(int... iArr) {
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap();
        for (int i : iArr) {
            eWAHCompressedBitmap.set(i);
        }
        return eWAHCompressedBitmap;
    }

    public static void orWithContainer(BitmapStorage bitmapStorage, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        if (eWAHCompressedBitmapArr.length < 2) {
            throw new IllegalArgumentException("You should provide at least two bitmaps, provided " + eWAHCompressedBitmapArr.length);
        }
        FastAggregation.orToContainer(bitmapStorage, eWAHCompressedBitmapArr);
    }

    public static void xorWithContainer(BitmapStorage bitmapStorage, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        if (eWAHCompressedBitmapArr.length < 2) {
            throw new IllegalArgumentException("You should provide at least two bitmaps, provided " + eWAHCompressedBitmapArr.length);
        }
        FastAggregation.xorToContainer(bitmapStorage, eWAHCompressedBitmapArr);
    }

    public static EWAHCompressedBitmap or(EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        if (eWAHCompressedBitmapArr.length == 1) {
            return eWAHCompressedBitmapArr[0];
        }
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap((int) (((double) calculateInitialSize(eWAHCompressedBitmapArr)) * 1.5d));
        orWithContainer(eWAHCompressedBitmap, eWAHCompressedBitmapArr);
        return eWAHCompressedBitmap;
    }

    public static EWAHCompressedBitmap xor(EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        if (eWAHCompressedBitmapArr.length == 1) {
            return eWAHCompressedBitmapArr[0];
        }
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap((int) (((double) calculateInitialSize(eWAHCompressedBitmapArr)) * 1.5d));
        xorWithContainer(eWAHCompressedBitmap, eWAHCompressedBitmapArr);
        return eWAHCompressedBitmap;
    }

    public static int orCardinality(EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        if (eWAHCompressedBitmapArr.length == 1) {
            return eWAHCompressedBitmapArr[0].cardinality();
        }
        BitCounter bitCounter = new BitCounter();
        orWithContainer(bitCounter, eWAHCompressedBitmapArr);
        return bitCounter.getCount();
    }

    public EWAHCompressedBitmap shift(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative shifts unsupported at the moment.");
        }
        int iSizeInWords = this.buffer.sizeInWords();
        if (i > 0) {
            iSizeInWords += (i + 63) / 64;
        }
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap(iSizeInWords);
        IteratingRLW iteratingRLW = getIteratingRLW();
        int i2 = i % 64;
        eWAHCompressedBitmap.addStreamOfEmptyWords(false, i / 64);
        if (i2 == 0) {
            do {
                long runningLength = iteratingRLW.getRunningLength();
                if (runningLength > 0) {
                    eWAHCompressedBitmap.addStreamOfEmptyWords(iteratingRLW.getRunningBit(), runningLength);
                }
                int numberOfLiteralWords = iteratingRLW.getNumberOfLiteralWords();
                for (int i3 = 0; i3 < numberOfLiteralWords; i3++) {
                    eWAHCompressedBitmap.addWord(iteratingRLW.getLiteralWordAt(i3));
                }
            } while (iteratingRLW.next());
        } else {
            boolean z = ((this.sizeInBits + 63) % 64) + i2 >= 64;
            long j = 0;
            do {
                long runningLength2 = iteratingRLW.getRunningLength();
                if (runningLength2 > 0) {
                    if (iteratingRLW.getRunningBit()) {
                        eWAHCompressedBitmap.addWord(j | ((-1) << i2));
                        j = (-1) >>> (64 - i2);
                    } else {
                        eWAHCompressedBitmap.addWord(j);
                        j = 0;
                    }
                    if (runningLength2 > 1) {
                        eWAHCompressedBitmap.addStreamOfEmptyWords(iteratingRLW.getRunningBit(), runningLength2 - 1);
                    }
                }
                int numberOfLiteralWords2 = iteratingRLW.getNumberOfLiteralWords();
                for (int i4 = 0; i4 < numberOfLiteralWords2; i4++) {
                    long literalWordAt = iteratingRLW.getLiteralWordAt(i4);
                    eWAHCompressedBitmap.addWord(j | (literalWordAt << i2));
                    j = literalWordAt >>> (64 - i2);
                }
            } while (iteratingRLW.next());
            if (z) {
                eWAHCompressedBitmap.addWord(j);
            }
        }
        eWAHCompressedBitmap.sizeInBits = this.sizeInBits + i;
        return eWAHCompressedBitmap;
    }
}
