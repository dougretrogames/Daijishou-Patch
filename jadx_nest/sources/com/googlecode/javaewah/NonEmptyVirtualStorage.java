package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
public class NonEmptyVirtualStorage implements BitmapStorage {
    private static final NonEmptyException nonEmptyException = new NonEmptyException();

    @Override // com.googlecode.javaewah.BitmapStorage
    public void clear() {
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void setSizeInBitsWithinLastWord(int i) {
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addWord(long j) {
        if (j != 0) {
            throw nonEmptyException;
        }
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addLiteralWord(long j) {
        if (j != 0) {
            throw nonEmptyException;
        }
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addStreamOfLiteralWords(Buffer buffer, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (buffer.getWord(i3) != 0) {
                throw nonEmptyException;
            }
        }
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addStreamOfEmptyWords(boolean z, long j) {
        if (z && j > 0) {
            throw nonEmptyException;
        }
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addStreamOfNegatedLiteralWords(Buffer buffer, int i, int i2) {
        if (i2 > 0) {
            throw nonEmptyException;
        }
    }

    static class NonEmptyException extends RuntimeException {
        private static final long serialVersionUID = 1;

        NonEmptyException() {
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }
}
