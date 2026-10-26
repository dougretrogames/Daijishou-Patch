package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
public final class IteratingBufferedRunningLengthWord implements IteratingRLW, Cloneable {
    private BufferedRunningLengthWord brlw;
    private final Buffer buffer;
    private EWAHIterator iterator;
    private int literalWordStartPosition;

    public IteratingBufferedRunningLengthWord(EWAHIterator eWAHIterator) {
        this.iterator = eWAHIterator;
        this.brlw = new BufferedRunningLengthWord(this.iterator.next());
        this.literalWordStartPosition = this.iterator.literalWords() + this.brlw.literalWordOffset;
        this.buffer = this.iterator.buffer();
    }

    public IteratingBufferedRunningLengthWord(EWAHCompressedBitmap eWAHCompressedBitmap) {
        this(EWAHIterator.getEWAHIterator(eWAHCompressedBitmap));
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public void discardFirstWords(long j) {
        while (j > 0) {
            if (this.brlw.runningLength > j) {
                this.brlw.runningLength -= j;
                return;
            }
            long j2 = j - this.brlw.runningLength;
            this.brlw.runningLength = 0L;
            long j3 = j2 > ((long) this.brlw.numberOfLiteralWords) ? this.brlw.numberOfLiteralWords : j2;
            this.literalWordStartPosition += (int) j3;
            BufferedRunningLengthWord bufferedRunningLengthWord = this.brlw;
            bufferedRunningLengthWord.numberOfLiteralWords = (int) (((long) bufferedRunningLengthWord.numberOfLiteralWords) - j3);
            j = j2 - j3;
            if (j > 0 || this.brlw.size() == 0) {
                if (!this.iterator.hasNext()) {
                    return;
                }
                this.brlw.reset(this.iterator.next());
                this.literalWordStartPosition = this.iterator.literalWords();
            }
        }
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public void discardLiteralWords(long j) {
        this.literalWordStartPosition = (int) (((long) this.literalWordStartPosition) + j);
        BufferedRunningLengthWord bufferedRunningLengthWord = this.brlw;
        bufferedRunningLengthWord.numberOfLiteralWords = (int) (((long) bufferedRunningLengthWord.numberOfLiteralWords) - j);
        if (this.brlw.numberOfLiteralWords == 0 && this.iterator.hasNext()) {
            this.brlw.reset(this.iterator.next());
            this.literalWordStartPosition = this.iterator.literalWords();
        }
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public void discardRunningWords() {
        this.brlw.runningLength = 0L;
        if (this.brlw.getNumberOfLiteralWords() == 0) {
            next();
        }
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public boolean next() {
        if (!this.iterator.hasNext()) {
            this.brlw.numberOfLiteralWords = 0;
            this.brlw.runningLength = 0L;
            return false;
        }
        this.brlw.reset(this.iterator.next());
        this.literalWordStartPosition = this.iterator.literalWords();
        return true;
    }

    public long discharge(BitmapStorage bitmapStorage, long j) {
        long numberOfLiteralWords = 0;
        while (getRunningLength() + numberOfLiteralWords <= j) {
            bitmapStorage.addStreamOfEmptyWords(getRunningBit(), getRunningLength());
            long runningLength = numberOfLiteralWords + getRunningLength();
            if (((long) getNumberOfLiteralWords()) + runningLength > j) {
                int i = (int) (j - runningLength);
                writeLiteralWords(i, bitmapStorage);
                this.brlw.runningLength = 0L;
                this.brlw.numberOfLiteralWords -= i;
                this.literalWordStartPosition += i;
                return j;
            }
            writeLiteralWords(getNumberOfLiteralWords(), bitmapStorage);
            numberOfLiteralWords = runningLength + ((long) getNumberOfLiteralWords());
            if (!next()) {
                return numberOfLiteralWords;
            }
        }
        long j2 = (int) (j - numberOfLiteralWords);
        bitmapStorage.addStreamOfEmptyWords(getRunningBit(), j2);
        this.brlw.runningLength -= j2;
        return j;
    }

    public long dischargeNegated(BitmapStorage bitmapStorage, long j) {
        long j2 = 0;
        while (j2 < j && size() > 0) {
            long runningLength = getRunningLength();
            if (j2 + runningLength > j) {
                runningLength = j - j2;
            }
            bitmapStorage.addStreamOfEmptyWords(!getRunningBit(), runningLength);
            long j3 = j2 + runningLength;
            int numberOfLiteralWords = getNumberOfLiteralWords();
            if (((long) numberOfLiteralWords) + j3 > j) {
                numberOfLiteralWords = (int) (j - j3);
            }
            writeNegatedLiteralWords(numberOfLiteralWords, bitmapStorage);
            long j4 = numberOfLiteralWords;
            discardFirstWords(runningLength + j4);
            j2 = j3 + j4;
        }
        return j2;
    }

    public void dischargeAsEmpty(BitmapStorage bitmapStorage) {
        while (size() > 0) {
            bitmapStorage.addStreamOfEmptyWords(false, size());
            discardFirstWords(size());
        }
    }

    public void discharge(BitmapStorage bitmapStorage) {
        this.brlw.literalWordOffset = this.literalWordStartPosition - this.iterator.literalWords();
        discharge(this.brlw, this.iterator, bitmapStorage);
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public long getLiteralWordAt(int i) {
        return this.buffer.getWord(this.literalWordStartPosition + i);
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public int getNumberOfLiteralWords() {
        return this.brlw.numberOfLiteralWords;
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public boolean getRunningBit() {
        return this.brlw.runningBit;
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public long getRunningLength() {
        return this.brlw.runningLength;
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public long size() {
        return this.brlw.size();
    }

    public void writeLiteralWords(int i, BitmapStorage bitmapStorage) {
        bitmapStorage.addStreamOfLiteralWords(this.buffer, this.literalWordStartPosition, i);
    }

    public void writeNegatedLiteralWords(int i, BitmapStorage bitmapStorage) {
        bitmapStorage.addStreamOfNegatedLiteralWords(this.buffer, this.literalWordStartPosition, i);
    }

    private static void discharge(BufferedRunningLengthWord bufferedRunningLengthWord, EWAHIterator eWAHIterator, BitmapStorage bitmapStorage) {
        while (true) {
            bitmapStorage.addStreamOfEmptyWords(bufferedRunningLengthWord.getRunningBit(), bufferedRunningLengthWord.getRunningLength());
            bitmapStorage.addStreamOfLiteralWords(eWAHIterator.buffer(), eWAHIterator.literalWords() + bufferedRunningLengthWord.literalWordOffset, bufferedRunningLengthWord.getNumberOfLiteralWords());
            if (!eWAHIterator.hasNext()) {
                return;
            } else {
                bufferedRunningLengthWord = new BufferedRunningLengthWord(eWAHIterator.next());
            }
        }
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IteratingBufferedRunningLengthWord m3462clone() throws CloneNotSupportedException {
        IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord = (IteratingBufferedRunningLengthWord) super.clone();
        iteratingBufferedRunningLengthWord.brlw = this.brlw.m3458clone();
        iteratingBufferedRunningLengthWord.iterator = this.iterator.m3461clone();
        return iteratingBufferedRunningLengthWord;
    }
}
