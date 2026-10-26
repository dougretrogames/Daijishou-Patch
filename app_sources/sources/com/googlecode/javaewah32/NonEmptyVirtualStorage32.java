package com.googlecode.javaewah32;

/* INFO: loaded from: classes4.dex */
public class NonEmptyVirtualStorage32 implements BitmapStorage32 {
    private static final NonEmptyException nonEmptyException = new NonEmptyException();

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void clear() {
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void setSizeInBitsWithinLastWord(int i) {
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addWord(int i) {
        if (i != 0) {
            throw nonEmptyException;
        }
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addLiteralWord(int i) {
        if (i != 0) {
            throw nonEmptyException;
        }
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addStreamOfLiteralWords(Buffer32 buffer32, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (buffer32.getWord(i3) != 0) {
                throw nonEmptyException;
            }
        }
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addStreamOfEmptyWords(boolean z, int i) {
        if (z && i > 0) {
            throw nonEmptyException;
        }
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addStreamOfNegatedLiteralWords(Buffer32 buffer32, int i, int i2) {
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
