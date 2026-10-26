package com.googlecode.javaewah32;

/* INFO: loaded from: classes4.dex */
public final class IteratingBufferedRunningLengthWord32 implements IteratingRLW32, Cloneable {
    private BufferedRunningLengthWord32 brlw;
    private final Buffer32 buffer;
    private EWAHIterator32 iterator;
    private int literalWordStartPosition;

    public IteratingBufferedRunningLengthWord32(EWAHIterator32 eWAHIterator32) {
        this.iterator = eWAHIterator32;
        this.brlw = new BufferedRunningLengthWord32(this.iterator.next());
        this.literalWordStartPosition = this.iterator.literalWords() + this.brlw.literalWordOffset;
        this.buffer = this.iterator.buffer();
    }

    public IteratingBufferedRunningLengthWord32(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        this(EWAHIterator32.getEWAHIterator(eWAHCompressedBitmap32));
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public void discardFirstWords(int i) {
        while (i > 0) {
            if (this.brlw.RunningLength > i) {
                this.brlw.RunningLength -= i;
                return;
            }
            int i2 = i - this.brlw.RunningLength;
            this.brlw.RunningLength = 0;
            int i3 = i2 > this.brlw.NumberOfLiteralWords ? this.brlw.NumberOfLiteralWords : i2;
            this.literalWordStartPosition += i3;
            this.brlw.NumberOfLiteralWords -= i3;
            i = i2 - i3;
            if (i > 0 || this.brlw.size() == 0) {
                if (!this.iterator.hasNext()) {
                    return;
                }
                this.brlw.reset(this.iterator.next());
                this.literalWordStartPosition = this.iterator.literalWords();
            }
        }
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public void discardLiteralWords(int i) {
        this.literalWordStartPosition += i;
        this.brlw.NumberOfLiteralWords -= i;
        if (this.brlw.NumberOfLiteralWords == 0 && this.iterator.hasNext()) {
            this.brlw.reset(this.iterator.next());
            this.literalWordStartPosition = this.iterator.literalWords();
        }
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public void discardRunningWords() {
        this.brlw.RunningLength = 0;
        if (this.brlw.getNumberOfLiteralWords() == 0) {
            next();
        }
    }

    public int discharge(BitmapStorage32 bitmapStorage32, int i) {
        int numberOfLiteralWords = 0;
        while (getRunningLength() + numberOfLiteralWords <= i) {
            bitmapStorage32.addStreamOfEmptyWords(getRunningBit(), getRunningLength());
            int runningLength = numberOfLiteralWords + getRunningLength();
            if (getNumberOfLiteralWords() + runningLength > i) {
                int i2 = i - runningLength;
                writeLiteralWords(i2, bitmapStorage32);
                this.brlw.RunningLength = 0;
                this.brlw.NumberOfLiteralWords -= i2;
                this.literalWordStartPosition += i2;
                return i;
            }
            writeLiteralWords(getNumberOfLiteralWords(), bitmapStorage32);
            numberOfLiteralWords = runningLength + getNumberOfLiteralWords();
            if (!next()) {
                return numberOfLiteralWords;
            }
        }
        int i3 = i - numberOfLiteralWords;
        bitmapStorage32.addStreamOfEmptyWords(getRunningBit(), i3);
        this.brlw.RunningLength -= i3;
        return i;
    }

    public int dischargeNegated(BitmapStorage32 bitmapStorage32, int i) {
        int i2 = 0;
        while (i2 < i && size() > 0) {
            int runningLength = getRunningLength();
            if (i2 + runningLength > i) {
                runningLength = i - i2;
            }
            bitmapStorage32.addStreamOfEmptyWords(!getRunningBit(), runningLength);
            int i3 = i2 + runningLength;
            int numberOfLiteralWords = getNumberOfLiteralWords();
            if (numberOfLiteralWords + i3 > i) {
                numberOfLiteralWords = i - i3;
            }
            writeNegatedLiteralWords(numberOfLiteralWords, bitmapStorage32);
            discardFirstWords(runningLength + numberOfLiteralWords);
            i2 = i3 + numberOfLiteralWords;
        }
        return i2;
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public boolean next() {
        if (!this.iterator.hasNext()) {
            this.brlw.NumberOfLiteralWords = 0;
            this.brlw.RunningLength = 0;
            return false;
        }
        this.brlw.reset(this.iterator.next());
        this.literalWordStartPosition = this.iterator.literalWords();
        return true;
    }

    public void dischargeAsEmpty(BitmapStorage32 bitmapStorage32) {
        while (size() > 0) {
            bitmapStorage32.addStreamOfEmptyWords(false, size());
            discardFirstWords(size());
        }
    }

    public void discharge(BitmapStorage32 bitmapStorage32) {
        this.brlw.literalWordOffset = this.literalWordStartPosition - this.iterator.literalWords();
        discharge(this.brlw, this.iterator, bitmapStorage32);
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public int getLiteralWordAt(int i) {
        return this.buffer.getWord(this.literalWordStartPosition + i);
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public int getNumberOfLiteralWords() {
        return this.brlw.NumberOfLiteralWords;
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public boolean getRunningBit() {
        return this.brlw.RunningBit;
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public int getRunningLength() {
        return this.brlw.RunningLength;
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public int size() {
        return this.brlw.size();
    }

    public void writeLiteralWords(int i, BitmapStorage32 bitmapStorage32) {
        bitmapStorage32.addStreamOfLiteralWords(this.buffer, this.literalWordStartPosition, i);
    }

    public void writeNegatedLiteralWords(int i, BitmapStorage32 bitmapStorage32) {
        bitmapStorage32.addStreamOfNegatedLiteralWords(this.buffer, this.literalWordStartPosition, i);
    }

    protected static void discharge(BufferedRunningLengthWord32 bufferedRunningLengthWord32, EWAHIterator32 eWAHIterator32, BitmapStorage32 bitmapStorage32) {
        while (true) {
            bitmapStorage32.addStreamOfEmptyWords(bufferedRunningLengthWord32.getRunningBit(), bufferedRunningLengthWord32.getRunningLength());
            bitmapStorage32.addStreamOfLiteralWords(eWAHIterator32.buffer(), eWAHIterator32.literalWords() + bufferedRunningLengthWord32.literalWordOffset, bufferedRunningLengthWord32.getNumberOfLiteralWords());
            if (!eWAHIterator32.hasNext()) {
                return;
            } else {
                bufferedRunningLengthWord32 = new BufferedRunningLengthWord32(eWAHIterator32.next());
            }
        }
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IteratingBufferedRunningLengthWord32 m3476clone() throws CloneNotSupportedException {
        IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord32 = (IteratingBufferedRunningLengthWord32) super.clone();
        iteratingBufferedRunningLengthWord32.brlw = this.brlw.m3471clone();
        iteratingBufferedRunningLengthWord32.iterator = this.iterator.m3473clone();
        return iteratingBufferedRunningLengthWord32;
    }
}
