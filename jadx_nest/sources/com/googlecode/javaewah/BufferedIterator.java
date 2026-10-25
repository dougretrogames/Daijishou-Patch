package com.googlecode.javaewah;

/* JADX INFO: loaded from: classes4.dex */
public class BufferedIterator implements IteratingRLW, Cloneable {
    private IteratingBufferedRunningLengthWord iteratingBrlw;
    private CloneableIterator<EWAHIterator> masterIterator;

    public BufferedIterator(CloneableIterator<EWAHIterator> cloneableIterator) {
        this.masterIterator = cloneableIterator;
        if (cloneableIterator.hasNext()) {
            this.iteratingBrlw = new IteratingBufferedRunningLengthWord(this.masterIterator.next());
        }
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public void discardFirstWords(long j) {
        while (j > 0) {
            if (this.iteratingBrlw.getRunningLength() > j) {
                this.iteratingBrlw.discardFirstWords(j);
                return;
            }
            IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord = this.iteratingBrlw;
            iteratingBufferedRunningLengthWord.discardFirstWords(iteratingBufferedRunningLengthWord.getRunningLength());
            long runningLength = j - this.iteratingBrlw.getRunningLength();
            long numberOfLiteralWords = runningLength > ((long) this.iteratingBrlw.getNumberOfLiteralWords()) ? this.iteratingBrlw.getNumberOfLiteralWords() : runningLength;
            this.iteratingBrlw.discardFirstWords(numberOfLiteralWords);
            j = runningLength - numberOfLiteralWords;
            if (j > 0 || this.iteratingBrlw.size() == 0) {
                if (!next()) {
                    return;
                }
            }
        }
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public void discardLiteralWords(long j) {
        this.iteratingBrlw.discardLiteralWords(j);
        if (this.iteratingBrlw.getNumberOfLiteralWords() == 0) {
            next();
        }
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public void discardRunningWords() {
        this.iteratingBrlw.discardRunningWords();
        if (this.iteratingBrlw.getNumberOfLiteralWords() == 0) {
            next();
        }
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public boolean next() {
        if (this.iteratingBrlw.next()) {
            return true;
        }
        if (!this.masterIterator.hasNext()) {
            return false;
        }
        this.iteratingBrlw = new IteratingBufferedRunningLengthWord(this.masterIterator.next());
        return true;
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public long getLiteralWordAt(int i) {
        return this.iteratingBrlw.getLiteralWordAt(i);
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public int getNumberOfLiteralWords() {
        return this.iteratingBrlw.getNumberOfLiteralWords();
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public boolean getRunningBit() {
        return this.iteratingBrlw.getRunningBit();
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public long getRunningLength() {
        return this.iteratingBrlw.getRunningLength();
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    public long size() {
        return this.iteratingBrlw.size();
    }

    @Override // com.googlecode.javaewah.IteratingRLW
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BufferedIterator m3456clone() throws CloneNotSupportedException {
        BufferedIterator bufferedIterator = (BufferedIterator) super.clone();
        bufferedIterator.iteratingBrlw = this.iteratingBrlw.m3456clone();
        bufferedIterator.masterIterator = this.masterIterator.clone();
        return bufferedIterator;
    }
}
