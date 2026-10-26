package com.googlecode.javaewah32;

import com.googlecode.javaewah.ChunkIterator;
import com.googlecode.javaewah.IntIterator;
import com.googlecode.javaewah.LogicalElement;
import com.googlecode.javaewah32.symmetric.RunningBitmapMerge32;
import com.googlecode.javaewah32.symmetric.ThresholdFuncBitmap32;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: loaded from: classes4.dex */
public final class EWAHCompressedBitmap32 implements Cloneable, Externalizable, Iterable<Integer>, BitmapStorage32, LogicalElement<EWAHCompressedBitmap32> {
    public static final boolean ADJUST_CONTAINER_SIZE_WHEN_AGGREGATING = true;
    public static final int WORD_IN_BITS = 32;
    static final long serialVersionUID = 1;
    final Buffer32 buffer;
    private RunningLengthWord32 rlw;
    private int sizeInBits;

    private boolean mergeLiteralWordInCurrentRunningLength(boolean z, boolean z2, int i, int i2) {
        return (z == z2 || i == 0) && i2 == 1;
    }

    public EWAHCompressedBitmap32() {
        this(new IntArray());
    }

    public EWAHCompressedBitmap32(int i) {
        this(new IntArray(i));
    }

    public EWAHCompressedBitmap32(ByteBuffer byteBuffer) {
        this.rlw = null;
        this.sizeInBits = 0;
        IntBuffer intBufferAsIntBuffer = byteBuffer.asIntBuffer();
        this.sizeInBits = intBufferAsIntBuffer.get(0);
        int i = intBufferAsIntBuffer.get(1);
        int i2 = intBufferAsIntBuffer.get(i + 2);
        intBufferAsIntBuffer.position(2);
        IntBufferWrapper intBufferWrapper = new IntBufferWrapper(intBufferAsIntBuffer.slice(), i);
        this.buffer = intBufferWrapper;
        this.rlw = new RunningLengthWord32(intBufferWrapper, i2);
    }

    public EWAHCompressedBitmap32(IntBuffer intBuffer) {
        this(new IntBufferWrapper(intBuffer));
    }

    private EWAHCompressedBitmap32(Buffer32 buffer32) {
        this.rlw = null;
        this.sizeInBits = 0;
        this.buffer = buffer32;
        this.rlw = new RunningLengthWord32(buffer32, 0);
    }

    @Deprecated
    public void add(int i) {
        addWord(i);
    }

    @Deprecated
    public void add(int i, int i2) {
        addWord(i, i2);
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addWord(int i) {
        addWord(i, 32);
    }

    public void addWord(int i, int i2) {
        this.sizeInBits += i2;
        if (i == 0) {
            insertEmptyWord(false);
        } else if (i == -1) {
            insertEmptyWord(true);
        } else {
            insertLiteralWord(i);
        }
    }

    private void insertEmptyWord(boolean z) {
        boolean z2 = this.rlw.getNumberOfLiteralWords() == 0;
        int runningLength = this.rlw.getRunningLength();
        if (z2 && runningLength == 0) {
            this.rlw.setRunningBit(z);
        }
        if (z2 && this.rlw.getRunningBit() == z && runningLength < 65535) {
            this.rlw.setRunningLength(runningLength + 1);
            return;
        }
        this.buffer.push_back(0);
        this.rlw.position = this.buffer.sizeInWords() - 1;
        this.rlw.setRunningBit(z);
        this.rlw.setRunningLength(1);
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addLiteralWord(int i) {
        this.sizeInBits += 32;
        insertLiteralWord(i);
    }

    private void insertLiteralWord(int i) {
        int numberOfLiteralWords = this.rlw.getNumberOfLiteralWords();
        if (numberOfLiteralWords >= 32767) {
            this.buffer.push_back(0);
            this.rlw.position = this.buffer.sizeInWords() - 1;
            this.rlw.setNumberOfLiteralWords(1);
            this.buffer.push_back(i);
            return;
        }
        this.rlw.setNumberOfLiteralWords(numberOfLiteralWords + 1);
        this.buffer.push_back(i);
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addStreamOfLiteralWords(Buffer32 buffer32, int i, int i2) {
        while (i2 > 0) {
            int numberOfLiteralWords = this.rlw.getNumberOfLiteralWords();
            int i3 = 32767 - numberOfLiteralWords;
            if (i2 < i3) {
                i3 = i2;
            }
            this.rlw.setNumberOfLiteralWords(numberOfLiteralWords + i3);
            i2 -= i3;
            this.buffer.push_back(buffer32, i, i3);
            this.sizeInBits += i3 * 32;
            if (i2 > 0) {
                this.buffer.push_back(0);
                this.rlw.position = this.buffer.sizeInWords() - 1;
            }
        }
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addStreamOfEmptyWords(boolean z, int i) {
        if (i == 0) {
            return;
        }
        this.sizeInBits += i * 32;
        fastaddStreamOfEmptyWords(z, i);
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addStreamOfNegatedLiteralWords(Buffer32 buffer32, int i, int i2) {
        while (i2 > 0) {
            int numberOfLiteralWords = this.rlw.getNumberOfLiteralWords();
            int i3 = 32767 - numberOfLiteralWords;
            if (i2 < i3) {
                i3 = i2;
            }
            this.rlw.setNumberOfLiteralWords(numberOfLiteralWords + i3);
            i2 -= i3;
            this.buffer.negative_push_back(buffer32, i, i3);
            this.sizeInBits += i3 * 32;
            if (i2 > 0) {
                this.buffer.push_back(0);
                this.rlw.position = this.buffer.sizeInWords() - 1;
            }
        }
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public EWAHCompressedBitmap32 and(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap33 = new EWAHCompressedBitmap32(this.buffer.sizeInWords() > eWAHCompressedBitmap32.buffer.sizeInWords() ? this.buffer.sizeInWords() : eWAHCompressedBitmap32.buffer.sizeInWords());
        andToContainer(eWAHCompressedBitmap32, eWAHCompressedBitmap33);
        return eWAHCompressedBitmap33;
    }

    public void andToContainer(EWAHCompressedBitmap32 eWAHCompressedBitmap32, BitmapStorage32 bitmapStorage32) {
        int i;
        bitmapStorage32.clear();
        EWAHIterator32 eWAHIterator = eWAHCompressedBitmap32.getEWAHIterator();
        EWAHIterator32 eWAHIterator2 = getEWAHIterator();
        IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord32 = new IteratingBufferedRunningLengthWord32(eWAHIterator);
        IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord33 = new IteratingBufferedRunningLengthWord32(eWAHIterator2);
        while (iteratingBufferedRunningLengthWord32.size() > 0 && iteratingBufferedRunningLengthWord33.size() > 0) {
            while (true) {
                if (iteratingBufferedRunningLengthWord32.getRunningLength() <= 0 && iteratingBufferedRunningLengthWord33.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingBufferedRunningLengthWord32.getRunningLength() < iteratingBufferedRunningLengthWord33.getRunningLength();
                IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord34 = z ? iteratingBufferedRunningLengthWord32 : iteratingBufferedRunningLengthWord33;
                IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord35 = z ? iteratingBufferedRunningLengthWord33 : iteratingBufferedRunningLengthWord32;
                if (!iteratingBufferedRunningLengthWord35.getRunningBit()) {
                    bitmapStorage32.addStreamOfEmptyWords(false, iteratingBufferedRunningLengthWord35.getRunningLength());
                    iteratingBufferedRunningLengthWord34.discardFirstWords(iteratingBufferedRunningLengthWord35.getRunningLength());
                } else {
                    bitmapStorage32.addStreamOfEmptyWords(false, iteratingBufferedRunningLengthWord35.getRunningLength() - iteratingBufferedRunningLengthWord34.discharge(bitmapStorage32, iteratingBufferedRunningLengthWord35.getRunningLength()));
                }
                iteratingBufferedRunningLengthWord35.discardRunningWords();
            }
            int iMin = Math.min(iteratingBufferedRunningLengthWord32.getNumberOfLiteralWords(), iteratingBufferedRunningLengthWord33.getNumberOfLiteralWords());
            if (iMin > 0) {
                for (i = 0; i < iMin; i++) {
                    bitmapStorage32.addWord(iteratingBufferedRunningLengthWord32.getLiteralWordAt(i) & iteratingBufferedRunningLengthWord33.getLiteralWordAt(i));
                }
                iteratingBufferedRunningLengthWord32.discardLiteralWords(iMin);
                iteratingBufferedRunningLengthWord33.discardLiteralWords(iMin);
            }
        }
        bitmapStorage32.setSizeInBitsWithinLastWord(Math.max(sizeInBits(), eWAHCompressedBitmap32.sizeInBits()));
    }

    public int andCardinality(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        BitCounter32 bitCounter32 = new BitCounter32();
        andToContainer(eWAHCompressedBitmap32, bitCounter32);
        return bitCounter32.getCount();
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public EWAHCompressedBitmap32 andNot(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap33 = new EWAHCompressedBitmap32(this.buffer.sizeInWords() > eWAHCompressedBitmap32.buffer.sizeInWords() ? this.buffer.sizeInWords() : eWAHCompressedBitmap32.buffer.sizeInWords());
        andNotToContainer(eWAHCompressedBitmap32, eWAHCompressedBitmap33);
        return eWAHCompressedBitmap33;
    }

    public void andNotToContainer(EWAHCompressedBitmap32 eWAHCompressedBitmap32, BitmapStorage32 bitmapStorage32) {
        bitmapStorage32.clear();
        EWAHIterator32 eWAHIterator = getEWAHIterator();
        EWAHIterator32 eWAHIterator2 = eWAHCompressedBitmap32.getEWAHIterator();
        IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord32 = new IteratingBufferedRunningLengthWord32(eWAHIterator);
        IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord33 = new IteratingBufferedRunningLengthWord32(eWAHIterator2);
        while (true) {
            if (iteratingBufferedRunningLengthWord32.size() <= 0 || iteratingBufferedRunningLengthWord33.size() <= 0) {
                break;
            }
            while (true) {
                if (iteratingBufferedRunningLengthWord32.getRunningLength() <= 0 && iteratingBufferedRunningLengthWord33.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingBufferedRunningLengthWord32.getRunningLength() < iteratingBufferedRunningLengthWord33.getRunningLength();
                IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord34 = z ? iteratingBufferedRunningLengthWord32 : iteratingBufferedRunningLengthWord33;
                IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord35 = z ? iteratingBufferedRunningLengthWord33 : iteratingBufferedRunningLengthWord32;
                if ((iteratingBufferedRunningLengthWord35.getRunningBit() && z) || !(iteratingBufferedRunningLengthWord35.getRunningBit() || z)) {
                    bitmapStorage32.addStreamOfEmptyWords(false, iteratingBufferedRunningLengthWord35.getRunningLength());
                    iteratingBufferedRunningLengthWord34.discardFirstWords(iteratingBufferedRunningLengthWord35.getRunningLength());
                } else if (z) {
                    bitmapStorage32.addStreamOfEmptyWords(false, iteratingBufferedRunningLengthWord35.getRunningLength() - iteratingBufferedRunningLengthWord34.discharge(bitmapStorage32, iteratingBufferedRunningLengthWord35.getRunningLength()));
                } else {
                    bitmapStorage32.addStreamOfEmptyWords(true, iteratingBufferedRunningLengthWord35.getRunningLength() - iteratingBufferedRunningLengthWord34.dischargeNegated(bitmapStorage32, iteratingBufferedRunningLengthWord35.getRunningLength()));
                }
                iteratingBufferedRunningLengthWord35.discardRunningWords();
            }
            int iMin = Math.min(iteratingBufferedRunningLengthWord32.getNumberOfLiteralWords(), iteratingBufferedRunningLengthWord33.getNumberOfLiteralWords());
            if (iMin > 0) {
                for (int i = 0; i < iMin; i++) {
                    bitmapStorage32.addWord(iteratingBufferedRunningLengthWord32.getLiteralWordAt(i) & (~iteratingBufferedRunningLengthWord33.getLiteralWordAt(i)));
                }
                iteratingBufferedRunningLengthWord32.discardLiteralWords(iMin);
                iteratingBufferedRunningLengthWord33.discardLiteralWords(iMin);
            }
        }
        boolean z2 = iteratingBufferedRunningLengthWord32.size() > 0;
        if (!z2) {
            iteratingBufferedRunningLengthWord32 = iteratingBufferedRunningLengthWord33;
        }
        if (z2) {
            iteratingBufferedRunningLengthWord32.discharge(bitmapStorage32);
        }
        bitmapStorage32.setSizeInBitsWithinLastWord(Math.max(sizeInBits(), eWAHCompressedBitmap32.sizeInBits()));
    }

    public int andNotCardinality(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        BitCounter32 bitCounter32 = new BitCounter32();
        andNotToContainer(eWAHCompressedBitmap32, bitCounter32);
        return bitCounter32.getCount();
    }

    public int cardinality() {
        EWAHIterator32 eWAHIterator = getEWAHIterator();
        int iBitCount = 0;
        while (eWAHIterator.hasNext()) {
            RunningLengthWord32 next = eWAHIterator.next();
            if (next.getRunningBit()) {
                iBitCount += next.getRunningLength() * 32;
            }
            int numberOfLiteralWords = next.getNumberOfLiteralWords();
            int iLiteralWords = eWAHIterator.literalWords();
            for (int i = 0; i < numberOfLiteralWords; i++) {
                iBitCount += Integer.bitCount(eWAHIterator.buffer().getWord(iLiteralWords + i));
            }
        }
        return iBitCount;
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void clear() {
        this.sizeInBits = 0;
        this.buffer.clear();
        this.rlw.position = 0;
    }

    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public EWAHCompressedBitmap32 m3472clone() throws CloneNotSupportedException {
        EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32(this.buffer.m3475clone());
        eWAHCompressedBitmap32.sizeInBits = this.sizeInBits;
        eWAHCompressedBitmap32.rlw = new RunningLengthWord32(eWAHCompressedBitmap32.buffer, this.rlw.position);
        return eWAHCompressedBitmap32;
    }

    public void serialize(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.sizeInBits);
        int iSizeInWords = this.buffer.sizeInWords();
        dataOutput.writeInt(iSizeInWords);
        for (int i = 0; i < iSizeInWords; i++) {
            dataOutput.writeInt(this.buffer.getWord(i));
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
            this.buffer.push_back(dataInput.readInt());
        }
        this.rlw = new RunningLengthWord32(this.buffer, dataInput.readInt());
    }

    public boolean equals(Object obj) {
        if (obj instanceof EWAHCompressedBitmap32) {
            try {
                xorToContainer((EWAHCompressedBitmap32) obj, new NonEmptyVirtualStorage32());
                return true;
            } catch (NonEmptyVirtualStorage32.NonEmptyException unused) {
            }
        }
        return false;
    }

    private void fastaddStreamOfEmptyWords(boolean z, int i) {
        if (this.rlw.getRunningBit() != z && this.rlw.size() == 0) {
            this.rlw.setRunningBit(z);
        } else if (this.rlw.getNumberOfLiteralWords() != 0 || this.rlw.getRunningBit() != z) {
            this.buffer.push_back(0);
            this.rlw.position = this.buffer.sizeInWords() - 1;
            if (z) {
                this.rlw.setRunningBit(true);
            }
        }
        int runningLength = this.rlw.getRunningLength();
        int i2 = 65535 - runningLength;
        if (i < i2) {
            i2 = i;
        }
        this.rlw.setRunningLength(runningLength + i2);
        int i3 = i - i2;
        while (i3 >= 65535) {
            this.buffer.push_back(0);
            this.rlw.position = this.buffer.sizeInWords() - 1;
            if (z) {
                this.rlw.setRunningBit(true);
            }
            this.rlw.setRunningLength(65535);
            i3 -= 65535;
        }
        if (i3 > 0) {
            this.buffer.push_back(0);
            this.rlw.position = this.buffer.sizeInWords() - 1;
            if (z) {
                this.rlw.setRunningBit(true);
            }
            this.rlw.setRunningLength(i3);
        }
    }

    public EWAHIterator32 getEWAHIterator() {
        return new EWAHIterator32(this.buffer);
    }

    private ReverseEWAHIterator32 getReverseEWAHIterator() {
        return new ReverseEWAHIterator32(this.buffer);
    }

    public IteratingRLW32 getIteratingRLW() {
        return new IteratingBufferedRunningLengthWord32(this);
    }

    @Deprecated
    public List<Integer> getPositions() {
        return toList();
    }

    public List<Integer> toList() {
        ArrayList arrayList = new ArrayList();
        EWAHIterator32 eWAHIterator = getEWAHIterator();
        int runningLength = 0;
        while (eWAHIterator.hasNext()) {
            RunningLengthWord32 next = eWAHIterator.next();
            if (next.getRunningBit()) {
                int runningLength2 = next.getRunningLength();
                for (int i = 0; i < runningLength2; i++) {
                    int i2 = 0;
                    while (i2 < 32) {
                        arrayList.add(Integer.valueOf(runningLength));
                        i2++;
                        runningLength++;
                    }
                }
            } else {
                runningLength += next.getRunningLength() * 32;
            }
            int numberOfLiteralWords = next.getNumberOfLiteralWords();
            for (int i3 = 0; i3 < numberOfLiteralWords; i3++) {
                int word = eWAHIterator.buffer().getWord(eWAHIterator.literalWords() + i3);
                while (word != 0) {
                    int i4 = (-word) & word;
                    arrayList.add(Integer.valueOf(Integer.bitCount(i4 - 1) + runningLength));
                    word ^= i4;
                }
                runningLength += 32;
            }
        }
        while (arrayList.size() > 0 && ((Integer) arrayList.get(arrayList.size() - 1)).intValue() >= this.sizeInBits) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    public int hashCode() {
        EWAHIterator32 eWAHIterator = getEWAHIterator();
        int word = 0;
        while (eWAHIterator.hasNext()) {
            eWAHIterator.next();
            if (eWAHIterator.rlw.getRunningBit()) {
                word += eWAHIterator.rlw.getRunningLength() * (-1640531535);
            }
            int numberOfLiteralWords = eWAHIterator.rlw.getNumberOfLiteralWords();
            int iLiteralWords = eWAHIterator.literalWords();
            for (int i = 0; i < numberOfLiteralWords; i++) {
                word += (int) (((long) this.buffer.getWord(iLiteralWords + i)) * (-1640531535));
            }
        }
        return word;
    }

    public boolean intersects(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        try {
            andToContainer(eWAHCompressedBitmap32, new NonEmptyVirtualStorage32());
            return false;
        } catch (NonEmptyVirtualStorage32.NonEmptyException unused) {
            return true;
        }
    }

    public IntIterator intIterator() {
        return new IntIteratorImpl32(getEWAHIterator());
    }

    public IntIterator reverseIntIterator() {
        return new ReverseIntIterator32(getReverseEWAHIterator(), this.sizeInBits);
    }

    public boolean isEmpty() {
        return getFirstSetBit() < 0;
    }

    public IntIterator clearIntIterator() {
        return new ClearIntIterator32(getEWAHIterator(), this.sizeInBits);
    }

    public ChunkIterator chunkIterator() {
        return new ChunkIteratorImpl32(getEWAHIterator(), this.sizeInBits);
    }

    /* INFO: renamed from: com.googlecode.javaewah32.EWAHCompressedBitmap32$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<Integer> {
        private final IntIterator under;

        AnonymousClass1() {
            this.under = EWAHCompressedBitmap32.this.intIterator();
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
        RunningLengthWord32 next;
        EWAHIterator32 eWAHIterator = getEWAHIterator();
        if (eWAHIterator.hasNext()) {
            do {
                next = eWAHIterator.next();
                next.setRunningBit(!next.getRunningBit());
                int numberOfLiteralWords = next.getNumberOfLiteralWords();
                for (int i = 0; i < numberOfLiteralWords; i++) {
                    eWAHIterator.buffer().negateWord(eWAHIterator.literalWords() + i);
                }
            } while (eWAHIterator.hasNext());
            int i2 = this.sizeInBits % 32;
            if (i2 == 0) {
                return;
            }
            if (next.getNumberOfLiteralWords() == 0) {
                if (next.getRunningLength() <= 0 || !next.getRunningBit()) {
                    return;
                }
                if (next.getRunningLength() == 1 && next.position > 0) {
                    EWAHIterator32 eWAHIterator2 = getEWAHIterator();
                    int i3 = this.rlw.position;
                    while (eWAHIterator2.hasNext()) {
                        RunningLengthWord32 next2 = eWAHIterator2.next();
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
                insertLiteralWord((-1) >>> (32 - i2));
                return;
            }
            eWAHIterator.buffer().andWord((eWAHIterator.literalWords() + next.getNumberOfLiteralWords()) - 1, (-1) >>> (32 - i2));
        }
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public EWAHCompressedBitmap32 or(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap33 = new EWAHCompressedBitmap32(this.buffer.sizeInWords() + eWAHCompressedBitmap32.buffer.sizeInWords());
        orToContainer(eWAHCompressedBitmap32, eWAHCompressedBitmap33);
        return eWAHCompressedBitmap33;
    }

    public void orToContainer(EWAHCompressedBitmap32 eWAHCompressedBitmap32, BitmapStorage32 bitmapStorage32) {
        int i;
        bitmapStorage32.clear();
        EWAHIterator32 eWAHIterator = eWAHCompressedBitmap32.getEWAHIterator();
        EWAHIterator32 eWAHIterator2 = getEWAHIterator();
        IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord32 = new IteratingBufferedRunningLengthWord32(eWAHIterator);
        IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord33 = new IteratingBufferedRunningLengthWord32(eWAHIterator2);
        while (iteratingBufferedRunningLengthWord32.size() > 0 && iteratingBufferedRunningLengthWord33.size() > 0) {
            while (true) {
                if (iteratingBufferedRunningLengthWord32.getRunningLength() <= 0 && iteratingBufferedRunningLengthWord33.getRunningLength() <= 0) {
                    break;
                }
                boolean z = iteratingBufferedRunningLengthWord32.getRunningLength() < iteratingBufferedRunningLengthWord33.getRunningLength();
                IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord34 = z ? iteratingBufferedRunningLengthWord32 : iteratingBufferedRunningLengthWord33;
                IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord35 = z ? iteratingBufferedRunningLengthWord33 : iteratingBufferedRunningLengthWord32;
                if (iteratingBufferedRunningLengthWord35.getRunningBit()) {
                    bitmapStorage32.addStreamOfEmptyWords(true, iteratingBufferedRunningLengthWord35.getRunningLength());
                    iteratingBufferedRunningLengthWord34.discardFirstWords(iteratingBufferedRunningLengthWord35.getRunningLength());
                } else {
                    bitmapStorage32.addStreamOfEmptyWords(false, iteratingBufferedRunningLengthWord35.getRunningLength() - iteratingBufferedRunningLengthWord34.discharge(bitmapStorage32, iteratingBufferedRunningLengthWord35.getRunningLength()));
                }
                iteratingBufferedRunningLengthWord35.discardRunningWords();
            }
            int iMin = Math.min(iteratingBufferedRunningLengthWord32.getNumberOfLiteralWords(), iteratingBufferedRunningLengthWord33.getNumberOfLiteralWords());
            if (iMin > 0) {
                for (i = 0; i < iMin; i++) {
                    bitmapStorage32.addWord(iteratingBufferedRunningLengthWord32.getLiteralWordAt(i) | iteratingBufferedRunningLengthWord33.getLiteralWordAt(i));
                }
                iteratingBufferedRunningLengthWord32.discardLiteralWords(iMin);
                iteratingBufferedRunningLengthWord33.discardLiteralWords(iMin);
            }
        }
        if (iteratingBufferedRunningLengthWord33.size() > 0 && iteratingBufferedRunningLengthWord32.size() > 0) {
            throw new RuntimeException("fds");
        }
        if (iteratingBufferedRunningLengthWord32.size() <= 0) {
            iteratingBufferedRunningLengthWord32 = iteratingBufferedRunningLengthWord33;
        }
        iteratingBufferedRunningLengthWord32.discharge(bitmapStorage32);
        bitmapStorage32.setSizeInBitsWithinLastWord(Math.max(sizeInBits(), eWAHCompressedBitmap32.sizeInBits()));
    }

    public int orCardinality(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        BitCounter32 bitCounter32 = new BitCounter32();
        orToContainer(eWAHCompressedBitmap32, bitCounter32);
        return bitCounter32.getCount();
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
            IteratingRLW32 iteratingRLW = getIteratingRLW();
            int i2 = i / 32;
            int numberOfLiteralWords = 0;
            while (numberOfLiteralWords <= i2) {
                int runningLength = numberOfLiteralWords + iteratingRLW.getRunningLength();
                if (i2 < runningLength) {
                    return iteratingRLW.getRunningBit();
                }
                if (i2 < iteratingRLW.getNumberOfLiteralWords() + runningLength) {
                    return ((1 << i) & iteratingRLW.getLiteralWordAt(i2 - runningLength)) != 0;
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
            int runningLength = RunningLengthWord32.getRunningLength(this.buffer, i);
            boolean runningBit = RunningLengthWord32.getRunningBit(this.buffer, i);
            if (runningLength > 0 && runningBit) {
                return i2 * 32;
            }
            i2 += runningLength;
            int numberOfLiteralWords = RunningLengthWord32.getNumberOfLiteralWords(this.buffer, i);
            int i3 = i + 1;
            for (int i4 = i3; i4 <= i + numberOfLiteralWords; i4++) {
                int word = this.buffer.getWord(i4);
                if (word != 0) {
                    return (i2 * 32) + Integer.bitCount(((-word) & word) - 1);
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
        if (i > 2147483615 || i < 0) {
            throw new IndexOutOfBoundsException("Position should be between 0 and 2147483615");
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
                RunningLengthWord32 runningLengthWord32 = this.rlw;
                runningLengthWord32.setNumberOfLiteralWords(runningLengthWord32.getNumberOfLiteralWords() - 1);
                insertEmptyWord(false);
            }
            if (iDistanceInWords > 1) {
                fastaddStreamOfEmptyWords(false, iDistanceInWords - 1);
            }
            insertLiteralWord(1 << (i % 32));
        }
        if (this.rlw.getNumberOfLiteralWords() == 0) {
            RunningLengthWord32 runningLengthWord33 = this.rlw;
            runningLengthWord33.setRunningLength(runningLengthWord33.getRunningLength() - 1);
            insertLiteralWord(1 << (i % 32));
        }
        this.buffer.orLastWord(1 << (i % 32));
        if (this.buffer.getLastWord() == -1) {
            this.buffer.removeLastWord();
            RunningLengthWord32 runningLengthWord34 = this.rlw;
            runningLengthWord34.setNumberOfLiteralWords(runningLengthWord34.getNumberOfLiteralWords() - 1);
            insertEmptyWord(true);
        }
    }

    private void locateAndSet(int i, boolean z) {
        int iSizeInWords = this.buffer.sizeInWords();
        int i2 = 0;
        int i3 = 0;
        while (i3 < iSizeInWords) {
            int runningLength = RunningLengthWord32.getRunningLength(this.buffer, i3);
            boolean runningBit = RunningLengthWord32.getRunningBit(this.buffer, i3);
            int numberOfLiteralWords = RunningLengthWord32.getNumberOfLiteralWords(this.buffer, i3);
            int i4 = (runningLength * 32) + i2;
            if (i < i4) {
                setInRunningLength(z, i, i2, i3, runningLength, runningBit, numberOfLiteralWords);
                return;
            }
            int i5 = i;
            boolean z2 = z;
            int i6 = (numberOfLiteralWords * 32) + i4;
            if (i5 < i6) {
                setInLiteralWords(z2, i5, i4, i3, runningLength, runningBit, numberOfLiteralWords);
                return;
            }
            i3 += numberOfLiteralWords + 1;
            i2 = i6;
            z = z2;
            i = i5;
        }
    }

    private void setInRunningLength(boolean z, int i, int i2, int i3, int i4, boolean z2, int i5) {
        if (z != z2) {
            int i6 = (i - i2) / 32;
            int i7 = i6 + 1;
            int i8 = i7 == i4 ? 1 : 2;
            int i9 = i3 + 1;
            this.buffer.expand(i9, i8);
            int i10 = 1 << (i % 32);
            Buffer32 buffer32 = this.buffer;
            if (!z) {
                i10 = ~i10;
            }
            buffer32.setWord(i9, i10);
            if (this.rlw.position >= i9) {
                this.rlw.position += i8;
            }
            if (i8 == 1) {
                setRLWInfo(i3, z2, i4 - 1, i5 + 1);
                return;
            }
            setRLWInfo(i3, z2, i6, 1);
            setRLWInfo(i3 + 2, z2, i4 - i7, i5);
            if (this.rlw.position == i3) {
                this.rlw.position += 2;
            }
        }
    }

    private void setInLiteralWords(boolean z, int i, int i2, int i3, int i4, boolean z2, int i5) {
        int i6 = (i - i2) / 32;
        int i7 = i6 + 1;
        int i8 = 1 << (i % 32);
        if (z) {
            this.buffer.orWord(i3 + i7, i8);
        } else {
            this.buffer.andWord(i3 + i7, ~i8);
        }
        int i9 = i3 + i7;
        if (this.buffer.getWord(i9) == (z ? -1 : 0)) {
            boolean zMergeLiteralWordInCurrentRunningLength = mergeLiteralWordInCurrentRunningLength(z, z2, i4, i7);
            boolean zMergeLiteralWordInNextRunningLength = mergeLiteralWordInNextRunningLength(z, i5, i3, i7);
            if (zMergeLiteralWordInCurrentRunningLength && zMergeLiteralWordInNextRunningLength) {
                int i10 = i3 + 2;
                int runningLength = RunningLengthWord32.getRunningLength(this.buffer, i10);
                int numberOfLiteralWords = RunningLengthWord32.getNumberOfLiteralWords(this.buffer, i10);
                this.buffer.collapse(i3, 2);
                setRLWInfo(i3, z, i4 + 1 + runningLength, numberOfLiteralWords);
                if (this.rlw.position >= i10) {
                    this.rlw.position -= 2;
                    return;
                }
                return;
            }
            if (zMergeLiteralWordInCurrentRunningLength) {
                this.buffer.collapse(i3 + 1, 1);
                setRLWInfo(i3, z, i4 + 1, i5 - 1);
                if (this.rlw.position >= i3 + 2) {
                    this.rlw.position--;
                    return;
                }
                return;
            }
            if (zMergeLiteralWordInNextRunningLength) {
                int i11 = i3 + i5 + 1;
                int runningLength2 = RunningLengthWord32.getRunningLength(this.buffer, i11);
                int numberOfLiteralWords2 = RunningLengthWord32.getNumberOfLiteralWords(this.buffer, i11);
                this.buffer.collapse(i9, 1);
                setRLWInfo(i3, z2, i4, i5 - 1);
                setRLWInfo(i9, z, runningLength2 + 1, numberOfLiteralWords2);
                if (this.rlw.position >= i11) {
                    this.rlw.position -= (i5 + 1) - i7;
                    return;
                }
                return;
            }
            setRLWInfo(i3, z2, i4, i6);
            setRLWInfo(i9, z, 1, i5 - i7);
            if (this.rlw.position == i3) {
                this.rlw.position += i7;
            }
        }
    }

    private boolean mergeLiteralWordInNextRunningLength(boolean z, int i, int i2, int i3) {
        int i4 = i2 + i + 1;
        if (i != i3 || i4 >= this.buffer.sizeInWords()) {
            return false;
        }
        return z == RunningLengthWord32.getRunningBit(this.buffer, i4) || RunningLengthWord32.getRunningLength(this.buffer, i4) == 0;
    }

    private void setRLWInfo(int i, boolean z, int i2, int i3) {
        RunningLengthWord32.setRunningBit(this.buffer, i, z);
        RunningLengthWord32.setRunningLength(this.buffer, i, i2);
        RunningLengthWord32.setNumberOfLiteralWords(this.buffer, i, i3);
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void setSizeInBitsWithinLastWord(int i) {
        int i2 = (i + 31) / 32;
        int i3 = this.sizeInBits;
        if (i2 > (i3 + 31) / 32) {
            setSizeInBits(i, false);
            return;
        }
        if (i2 != (i3 + 31) / 32) {
            throw new RuntimeException("You can only reduce the size of the bitmap within the scope of the last word. To extend the bitmap, please call setSizeInbits(int,boolean): " + i + " " + this.sizeInBits);
        }
        this.sizeInBits = i;
        int i4 = i % 32;
        if (i4 == 0) {
            return;
        }
        if (this.rlw.getNumberOfLiteralWords() == 0) {
            if (this.rlw.getRunningLength() > 0) {
                RunningLengthWord32 runningLengthWord32 = this.rlw;
                runningLengthWord32.setRunningLength(runningLengthWord32.getRunningLength() - 1);
                insertLiteralWord(this.rlw.getRunningBit() ? (-1) >>> (32 - i4) : 0);
                return;
            }
            return;
        }
        this.buffer.andLastWord((-1) >>> (32 - i4));
    }

    public boolean setSizeInBits(int i, boolean z) {
        int i2 = this.sizeInBits;
        if (i <= i2) {
            return false;
        }
        if (i2 % 32 != 0) {
            if (!z) {
                if (this.rlw.getNumberOfLiteralWords() > 0) {
                    int i3 = this.sizeInBits;
                    int i4 = i - i3;
                    int i5 = i3 % 32;
                    int i6 = 32 - i5;
                    if (this.buffer.getLastWord() == 0) {
                        RunningLengthWord32 runningLengthWord32 = this.rlw;
                        runningLengthWord32.setNumberOfLiteralWords(runningLengthWord32.getNumberOfLiteralWords() - 1);
                        this.buffer.removeLastWord();
                        this.sizeInBits -= i5;
                    } else if (i5 > 0) {
                        this.sizeInBits += Math.min(i4, i6);
                    }
                }
            } else {
                if (this.rlw.getNumberOfLiteralWords() == 0) {
                    RunningLengthWord32 runningLengthWord33 = this.rlw;
                    runningLengthWord33.setRunningLength(runningLengthWord33.getRunningLength() - 1);
                    insertLiteralWord(0);
                }
                int i7 = this.sizeInBits;
                int iMin = Math.min(32 - (i7 % 32), i - i7);
                this.buffer.orLastWord(((-1) >>> (32 - iMin)) << (this.sizeInBits % 32));
                if (this.buffer.getLastWord() == -1) {
                    this.buffer.removeLastWord();
                    RunningLengthWord32 runningLengthWord34 = this.rlw;
                    runningLengthWord34.setNumberOfLiteralWords(runningLengthWord34.getNumberOfLiteralWords() - 1);
                    insertEmptyWord(true);
                }
                this.sizeInBits += iMin;
            }
        }
        addStreamOfEmptyWords(z, (i / 32) - (this.sizeInBits / 32));
        if (this.sizeInBits < i) {
            if (distanceInWords(i - 1) > 0) {
                insertLiteralWord(0);
            }
            if (z) {
                int i8 = this.sizeInBits;
                this.buffer.orLastWord(((-1) >>> (32 - (i - i8))) << (i8 % 32));
            }
            this.sizeInBits = i;
        }
        return true;
    }

    private int distanceInWords(int i) {
        return ((i + 32) / 32) - ((this.sizeInBits + 31) / 32);
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public int sizeInBits() {
        return this.sizeInBits;
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public int sizeInBytes() {
        return this.buffer.sizeInWords() * 4;
    }

    public static EWAHCompressedBitmap32 threshold(int i, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32();
        thresholdWithContainer(eWAHCompressedBitmap32, i, eWAHCompressedBitmap32Arr);
        return eWAHCompressedBitmap32;
    }

    static int maxSizeInBits(EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        int iMax = 0;
        for (EWAHCompressedBitmap32 eWAHCompressedBitmap32 : eWAHCompressedBitmap32Arr) {
            iMax = Math.max(iMax, eWAHCompressedBitmap32.sizeInBits());
        }
        return iMax;
    }

    public static void thresholdWithContainer(BitmapStorage32 bitmapStorage32, int i, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        new RunningBitmapMerge32().symmetric(new ThresholdFuncBitmap32(i), bitmapStorage32, eWAHCompressedBitmap32Arr);
    }

    public int[] toArray() {
        int[] iArr = new int[cardinality()];
        EWAHIterator32 eWAHIterator = getEWAHIterator();
        int i = 0;
        int i2 = 0;
        while (eWAHIterator.hasNext()) {
            RunningLengthWord32 next = eWAHIterator.next();
            int runningLength = next.getRunningLength();
            if (next.getRunningBit()) {
                for (int i3 = 0; i3 < runningLength; i3++) {
                    int i4 = 0;
                    while (i4 < 32) {
                        iArr[i2] = i;
                        i4++;
                        i2++;
                        i++;
                    }
                }
            } else {
                i += runningLength * 32;
            }
            int numberOfLiteralWords = next.getNumberOfLiteralWords();
            int iLiteralWords = eWAHIterator.literalWords();
            for (int i5 = 0; i5 < numberOfLiteralWords; i5++) {
                int word = eWAHIterator.buffer().getWord(iLiteralWords + i5);
                while (word != 0) {
                    int i6 = (-word) & word;
                    iArr[i2] = Integer.bitCount(i6 - 1) + i;
                    word ^= i6;
                    i2++;
                }
                i += 32;
            }
        }
        return iArr;
    }

    public String toDebugString() {
        StringBuilder sb = new StringBuilder("{\"size in bits\":");
        sb.append(this.sizeInBits).append(", \"size in words\":");
        sb.append(this.buffer.sizeInWords()).append(", \"content\": [");
        EWAHIterator32 eWAHIterator = getEWAHIterator();
        boolean z = true;
        while (eWAHIterator.hasNext()) {
            RunningLengthWord32 next = eWAHIterator.next();
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
                sb.append("\"0x").append(Integer.toHexString(eWAHIterator.buffer().getWord(eWAHIterator.literalWords() + i))).append("\",");
                i = i2;
            }
            if (i < next.getNumberOfLiteralWords()) {
                sb.append("\"0x").append(Integer.toHexString(eWAHIterator.buffer().getWord(eWAHIterator.literalWords() + i))).append("\"");
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

    public void swap(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        this.buffer.swap(eWAHCompressedBitmap32.buffer);
        int i = this.rlw.position;
        this.rlw.position = eWAHCompressedBitmap32.rlw.position;
        eWAHCompressedBitmap32.rlw.position = i;
        int i2 = this.sizeInBits;
        this.sizeInBits = eWAHCompressedBitmap32.sizeInBits;
        eWAHCompressedBitmap32.sizeInBits = i2;
    }

    public void trim() {
        this.buffer.trim();
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public EWAHCompressedBitmap32 xor(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap33 = new EWAHCompressedBitmap32(this.buffer.sizeInWords() + eWAHCompressedBitmap32.buffer.sizeInWords());
        xorToContainer(eWAHCompressedBitmap32, eWAHCompressedBitmap33);
        return eWAHCompressedBitmap33;
    }

    public void xorToContainer(EWAHCompressedBitmap32 eWAHCompressedBitmap32, BitmapStorage32 bitmapStorage32) {
        int i;
        int iDischargeNegated;
        bitmapStorage32.clear();
        EWAHIterator32 eWAHIterator = eWAHCompressedBitmap32.getEWAHIterator();
        EWAHIterator32 eWAHIterator2 = getEWAHIterator();
        IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord32 = new IteratingBufferedRunningLengthWord32(eWAHIterator);
        IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord33 = new IteratingBufferedRunningLengthWord32(eWAHIterator2);
        while (iteratingBufferedRunningLengthWord32.size() > 0 && iteratingBufferedRunningLengthWord33.size() > 0) {
            while (true) {
                if (iteratingBufferedRunningLengthWord32.getRunningLength() <= 0 && iteratingBufferedRunningLengthWord33.getRunningLength() <= 0) {
                    break;
                }
                i = iteratingBufferedRunningLengthWord32.getRunningLength() < iteratingBufferedRunningLengthWord33.getRunningLength() ? 1 : 0;
                IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord34 = i != 0 ? iteratingBufferedRunningLengthWord32 : iteratingBufferedRunningLengthWord33;
                IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord35 = i != 0 ? iteratingBufferedRunningLengthWord33 : iteratingBufferedRunningLengthWord32;
                if (!iteratingBufferedRunningLengthWord35.getRunningBit()) {
                    iDischargeNegated = iteratingBufferedRunningLengthWord34.discharge(bitmapStorage32, iteratingBufferedRunningLengthWord35.getRunningLength());
                } else {
                    iDischargeNegated = iteratingBufferedRunningLengthWord34.dischargeNegated(bitmapStorage32, iteratingBufferedRunningLengthWord35.getRunningLength());
                }
                bitmapStorage32.addStreamOfEmptyWords(iteratingBufferedRunningLengthWord35.getRunningBit(), iteratingBufferedRunningLengthWord35.getRunningLength() - iDischargeNegated);
                iteratingBufferedRunningLengthWord35.discardRunningWords();
            }
            int iMin = Math.min(iteratingBufferedRunningLengthWord32.getNumberOfLiteralWords(), iteratingBufferedRunningLengthWord33.getNumberOfLiteralWords());
            if (iMin > 0) {
                for (i = 0; i < iMin; i++) {
                    bitmapStorage32.addWord(iteratingBufferedRunningLengthWord32.getLiteralWordAt(i) ^ iteratingBufferedRunningLengthWord33.getLiteralWordAt(i));
                }
                iteratingBufferedRunningLengthWord32.discardLiteralWords(iMin);
                iteratingBufferedRunningLengthWord33.discardLiteralWords(iMin);
            }
        }
        if (iteratingBufferedRunningLengthWord32.size() <= 0) {
            iteratingBufferedRunningLengthWord32 = iteratingBufferedRunningLengthWord33;
        }
        iteratingBufferedRunningLengthWord32.discharge(bitmapStorage32);
        bitmapStorage32.setSizeInBitsWithinLastWord(Math.max(sizeInBits(), eWAHCompressedBitmap32.sizeInBits()));
    }

    public int xorCardinality(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        BitCounter32 bitCounter32 = new BitCounter32();
        xorToContainer(eWAHCompressedBitmap32, bitCounter32);
        return bitCounter32.getCount();
    }

    @Override // com.googlecode.javaewah.LogicalElement
    public EWAHCompressedBitmap32 compose(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap33 = new EWAHCompressedBitmap32(this.buffer.sizeInWords());
        composeToContainer(eWAHCompressedBitmap32, eWAHCompressedBitmap33);
        return eWAHCompressedBitmap33;
    }

    public void composeToContainer(EWAHCompressedBitmap32 eWAHCompressedBitmap32, EWAHCompressedBitmap32 eWAHCompressedBitmap33) {
        eWAHCompressedBitmap33.clear();
        ChunkIterator chunkIterator = chunkIterator();
        ChunkIterator chunkIterator2 = eWAHCompressedBitmap32.chunkIterator();
        int i = 0;
        while (chunkIterator.hasNext() && chunkIterator2.hasNext()) {
            if (!chunkIterator.nextBit()) {
                int iNextLength = chunkIterator.nextLength();
                i += iNextLength;
                eWAHCompressedBitmap33.setSizeInBits(i, false);
                chunkIterator.move(iNextLength);
            } else {
                int iMin = Math.min(chunkIterator.nextLength(), chunkIterator2.nextLength());
                i += iMin;
                eWAHCompressedBitmap33.setSizeInBits(i, chunkIterator2.nextBit());
                chunkIterator.move(iMin);
                chunkIterator2.move(iMin);
            }
        }
        eWAHCompressedBitmap33.setSizeInBits(this.sizeInBits, false);
    }

    public static void andWithContainer(BitmapStorage32 bitmapStorage32, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        if (eWAHCompressedBitmap32Arr.length == 1) {
            throw new IllegalArgumentException("Need at least one bitmap");
        }
        if (eWAHCompressedBitmap32Arr.length == 2) {
            eWAHCompressedBitmap32Arr[0].andToContainer(eWAHCompressedBitmap32Arr[1], bitmapStorage32);
            return;
        }
        int iCalculateInitialSize = calculateInitialSize(eWAHCompressedBitmap32Arr);
        EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32(iCalculateInitialSize);
        EWAHCompressedBitmap32 eWAHCompressedBitmap33 = new EWAHCompressedBitmap32(iCalculateInitialSize);
        eWAHCompressedBitmap32Arr[0].andToContainer(eWAHCompressedBitmap32Arr[1], eWAHCompressedBitmap32);
        for (int i = 2; i < eWAHCompressedBitmap32Arr.length - 1; i++) {
            eWAHCompressedBitmap32.andToContainer(eWAHCompressedBitmap32Arr[i], eWAHCompressedBitmap33);
            eWAHCompressedBitmap33.swap(eWAHCompressedBitmap32);
            eWAHCompressedBitmap33.clear();
        }
        eWAHCompressedBitmap32.andToContainer(eWAHCompressedBitmap32Arr[eWAHCompressedBitmap32Arr.length - 1], bitmapStorage32);
    }

    private static int calculateInitialSize(EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        int iMax = 0;
        for (EWAHCompressedBitmap32 eWAHCompressedBitmap32 : eWAHCompressedBitmap32Arr) {
            iMax = Math.max(eWAHCompressedBitmap32.buffer.sizeInWords(), iMax);
        }
        return iMax;
    }

    public static EWAHCompressedBitmap32 and(EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        if (eWAHCompressedBitmap32Arr.length == 1) {
            return eWAHCompressedBitmap32Arr[0];
        }
        if (eWAHCompressedBitmap32Arr.length == 2) {
            return eWAHCompressedBitmap32Arr[0].and(eWAHCompressedBitmap32Arr[1]);
        }
        int iCalculateInitialSize = calculateInitialSize(eWAHCompressedBitmap32Arr);
        EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32(iCalculateInitialSize);
        EWAHCompressedBitmap32 eWAHCompressedBitmap33 = new EWAHCompressedBitmap32(iCalculateInitialSize);
        eWAHCompressedBitmap32Arr[0].andToContainer(eWAHCompressedBitmap32Arr[1], eWAHCompressedBitmap32);
        for (int i = 2; i < eWAHCompressedBitmap32Arr.length; i++) {
            eWAHCompressedBitmap32.andToContainer(eWAHCompressedBitmap32Arr[i], eWAHCompressedBitmap33);
            eWAHCompressedBitmap33.swap(eWAHCompressedBitmap32);
            eWAHCompressedBitmap33.clear();
        }
        return eWAHCompressedBitmap32;
    }

    public static int andCardinality(EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        if (eWAHCompressedBitmap32Arr.length == 1) {
            return eWAHCompressedBitmap32Arr[0].cardinality();
        }
        BitCounter32 bitCounter32 = new BitCounter32();
        andWithContainer(bitCounter32, eWAHCompressedBitmap32Arr);
        return bitCounter32.getCount();
    }

    public static EWAHCompressedBitmap32 bitmapOf(int... iArr) {
        EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32();
        for (int i : iArr) {
            eWAHCompressedBitmap32.set(i);
        }
        return eWAHCompressedBitmap32;
    }

    public static void orWithContainer(BitmapStorage32 bitmapStorage32, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        if (eWAHCompressedBitmap32Arr.length < 2) {
            throw new IllegalArgumentException("You should provide at least two bitmaps, provided " + eWAHCompressedBitmap32Arr.length);
        }
        FastAggregation32.orToContainer(bitmapStorage32, eWAHCompressedBitmap32Arr);
    }

    public static void xorWithContainer(BitmapStorage32 bitmapStorage32, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        if (eWAHCompressedBitmap32Arr.length < 2) {
            throw new IllegalArgumentException("You should provide at least two bitmaps, provided " + eWAHCompressedBitmap32Arr.length);
        }
        FastAggregation32.xorToContainer(bitmapStorage32, eWAHCompressedBitmap32Arr);
    }

    public static EWAHCompressedBitmap32 or(EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        return FastAggregation32.or(eWAHCompressedBitmap32Arr);
    }

    public static EWAHCompressedBitmap32 xor(EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        return FastAggregation32.xor(eWAHCompressedBitmap32Arr);
    }

    public static int orCardinality(EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        if (eWAHCompressedBitmap32Arr.length == 1) {
            return eWAHCompressedBitmap32Arr[0].cardinality();
        }
        BitCounter32 bitCounter32 = new BitCounter32();
        orWithContainer(bitCounter32, eWAHCompressedBitmap32Arr);
        return bitCounter32.getCount();
    }

    public EWAHCompressedBitmap32 shift(int i) {
        boolean z;
        if (i < 0) {
            throw new IllegalArgumentException("Negative shifts unsupported at the moment.");
        }
        int iSizeInWords = this.buffer.sizeInWords();
        if (i > 0) {
            iSizeInWords += (i + 31) / 32;
        }
        EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32(iSizeInWords);
        IteratingRLW32 iteratingRLW = getIteratingRLW();
        int i2 = i % 32;
        eWAHCompressedBitmap32.addStreamOfEmptyWords(false, i / 32);
        if (i2 == 0) {
            do {
                int runningLength = iteratingRLW.getRunningLength();
                if (runningLength > 0) {
                    eWAHCompressedBitmap32.addStreamOfEmptyWords(iteratingRLW.getRunningBit(), runningLength);
                }
                int numberOfLiteralWords = iteratingRLW.getNumberOfLiteralWords();
                for (int i3 = 0; i3 < numberOfLiteralWords; i3++) {
                    eWAHCompressedBitmap32.addWord(iteratingRLW.getLiteralWordAt(i3));
                }
            } while (iteratingRLW.next());
        } else {
            int i4 = 0;
            do {
                int runningLength2 = iteratingRLW.getRunningLength();
                z = ((this.sizeInBits + 31) % 32) + i2 >= 32;
                if (runningLength2 > 0) {
                    if (iteratingRLW.getRunningBit()) {
                        eWAHCompressedBitmap32.addWord(i4 | ((-1) << i2));
                        i4 = (-1) >>> (32 - i2);
                    } else {
                        eWAHCompressedBitmap32.addWord(i4);
                        i4 = 0;
                    }
                    if (runningLength2 > 1) {
                        eWAHCompressedBitmap32.addStreamOfEmptyWords(iteratingRLW.getRunningBit(), runningLength2 - 1);
                    }
                }
                int numberOfLiteralWords2 = iteratingRLW.getNumberOfLiteralWords();
                for (int i5 = 0; i5 < numberOfLiteralWords2; i5++) {
                    int literalWordAt = iteratingRLW.getLiteralWordAt(i5);
                    eWAHCompressedBitmap32.addWord(i4 | (literalWordAt << i2));
                    i4 = literalWordAt >>> (32 - i2);
                }
            } while (iteratingRLW.next());
            if (z) {
                eWAHCompressedBitmap32.addWord(i4);
            }
        }
        eWAHCompressedBitmap32.sizeInBits = this.sizeInBits + i;
        return eWAHCompressedBitmap32;
    }
}
