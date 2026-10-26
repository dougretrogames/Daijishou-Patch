package org.apache.commons.io.input;

import java.io.IOException;
import java.io.Reader;

/* INFO: loaded from: classes5.dex */
public class UnsynchronizedBufferedReader extends UnsynchronizedReader {
    private static final char NUL = 0;
    private char[] buf;
    private int end;
    private final Reader in;
    private int mark;
    private int markLimit;
    private int pos;

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    public UnsynchronizedBufferedReader(Reader reader) {
        this(reader, 8192);
    }

    public UnsynchronizedBufferedReader(Reader reader, int i) {
        this.mark = -1;
        this.markLimit = -1;
        if (i <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.in = reader;
        this.buf = new char[i];
    }

    final void chompNewline() throws IOException {
        if (this.pos == this.end && fillBuf() == -1) {
            return;
        }
        char[] cArr = this.buf;
        int i = this.pos;
        if (cArr[i] == '\n') {
            this.pos = i + 1;
        }
    }

    @Override // org.apache.commons.io.input.UnsynchronizedReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (isClosed()) {
            return;
        }
        this.in.close();
        this.buf = null;
        super.close();
    }

    /* WARN: Code duplicated, block: B:15:0x0025 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:16:0x0027  */
    private int fillBuf() throws IOException {
        int i = this.mark;
        if (i != -1) {
            int i2 = this.pos - i;
            int i3 = this.markLimit;
            if (i2 < i3) {
                if (i == 0) {
                    char[] cArr = this.buf;
                    if (i3 > cArr.length) {
                        int length = cArr.length * 2;
                        if (length <= i3) {
                            i3 = length;
                        }
                        char[] cArr2 = new char[i3];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.buf = cArr2;
                    } else if (i > 0) {
                        char[] cArr3 = this.buf;
                        System.arraycopy(cArr3, i, cArr3, 0, cArr3.length - i);
                        int i4 = this.pos;
                        int i5 = this.mark;
                        this.pos = i4 - i5;
                        this.end -= i5;
                        this.mark = 0;
                    }
                } else if (i > 0) {
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, i, cArr4, 0, cArr4.length - i);
                    int i6 = this.pos;
                    int i7 = this.mark;
                    this.pos = i6 - i7;
                    this.end -= i7;
                    this.mark = 0;
                }
                Reader reader = this.in;
                char[] cArr5 = this.buf;
                int i8 = this.pos;
                int i9 = reader.read(cArr5, i8, cArr5.length - i8);
                if (i9 != -1) {
                    this.end += i9;
                }
                return i9;
            }
        }
        Reader reader2 = this.in;
        char[] cArr6 = this.buf;
        int i10 = reader2.read(cArr6, 0, cArr6.length);
        if (i10 > 0) {
            this.mark = -1;
            this.pos = 0;
            this.end = i10;
        }
        return i10;
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        checkOpen();
        this.markLimit = i;
        this.mark = this.pos;
    }

    public int peek() throws IOException {
        mark(1);
        int i = read();
        reset();
        return i;
    }

    public int peek(char[] cArr) throws IOException {
        int length = cArr.length;
        mark(length);
        int i = read(cArr, 0, length);
        reset();
        return i;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        checkOpen();
        if (this.pos >= this.end && fillBuf() == -1) {
            return -1;
        }
        char[] cArr = this.buf;
        int i = this.pos;
        this.pos = i + 1;
        return cArr[i];
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        checkOpen();
        if (i < 0 || i > cArr.length - i2 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        while (i3 > 0) {
            int i4 = this.end;
            int i5 = this.pos;
            int i6 = i4 - i5;
            if (i6 > 0) {
                if (i6 >= i3) {
                    i6 = i3;
                }
                System.arraycopy(this.buf, i5, cArr, i, i6);
                this.pos += i6;
                i += i6;
                i3 -= i6;
            }
            if (i3 == 0 || (i3 < i2 && !this.in.ready())) {
                break;
            }
            int i7 = this.mark;
            if ((i7 == -1 || this.pos - i7 >= this.markLimit) && i3 >= this.buf.length) {
                int i8 = this.in.read(cArr, i, i3);
                if (i8 <= 0) {
                    break;
                }
                i3 -= i8;
                this.mark = -1;
                break;
            }
            if (fillBuf() == -1) {
                break;
            }
        }
        int i9 = i2 - i3;
        if (i9 > 0 || i9 == i2) {
            return i9;
        }
        return -1;
    }

    public String readLine() throws IOException {
        int i;
        checkOpen();
        if (this.pos == this.end && fillBuf() == -1) {
            return null;
        }
        for (int i2 = this.pos; i2 < this.end; i2++) {
            char c = this.buf[i2];
            if (c <= '\r') {
                if (c == '\n') {
                    char[] cArr = this.buf;
                    int i3 = this.pos;
                    String str = new String(cArr, i3, i2 - i3);
                    this.pos = i2 + 1;
                    return str;
                }
                if (c == '\r') {
                    char[] cArr2 = this.buf;
                    int i4 = this.pos;
                    String str2 = new String(cArr2, i4, i2 - i4);
                    int i5 = i2 + 1;
                    this.pos = i5;
                    if (i5 < this.end || fillBuf() != -1) {
                        char[] cArr3 = this.buf;
                        int i6 = this.pos;
                        if (cArr3[i6] == '\n') {
                            this.pos = i6 + 1;
                        }
                    }
                    return str2;
                }
            }
        }
        StringBuilder sb = new StringBuilder(80);
        char[] cArr4 = this.buf;
        int i7 = this.pos;
        sb.append(cArr4, i7, this.end - i7);
        char c2 = 0;
        while (true) {
            this.pos = this.end;
            if (c2 == '\n') {
                return sb.toString();
            }
            if (fillBuf() == -1) {
                if (sb.length() > 0 || c2 != 0) {
                    return sb.toString();
                }
                return null;
            }
            int i8 = this.pos;
            while (true) {
                i = this.end;
                if (i8 < i) {
                    char[] cArr5 = this.buf;
                    char c3 = cArr5[i8];
                    if (c2 != 0) {
                        if (c2 == '\r' && c3 == '\n') {
                            int i9 = this.pos;
                            if (i8 > i9) {
                                sb.append(cArr5, i9, (i8 - i9) - 1);
                            }
                            this.pos = i8 + 1;
                        } else {
                            int i10 = this.pos;
                            if (i8 > i10) {
                                sb.append(cArr5, i10, (i8 - i10) - 1);
                            }
                            this.pos = i8;
                        }
                        return sb.toString();
                    }
                    if (c3 == '\n' || c3 == '\r') {
                        c2 = c3;
                    }
                    i8++;
                }
            }
            if (c2 == 0) {
                char[] cArr6 = this.buf;
                int i11 = this.pos;
                sb.append(cArr6, i11, i - i11);
            } else {
                char[] cArr7 = this.buf;
                int i12 = this.pos;
                sb.append(cArr7, i12, (i - i12) - 1);
            }
        }
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        checkOpen();
        return this.end - this.pos > 0 || this.in.ready();
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        checkOpen();
        int i = this.mark;
        if (i == -1) {
            throw new IOException("mark == -1");
        }
        this.pos = i;
    }

    @Override // org.apache.commons.io.input.UnsynchronizedReader, java.io.Reader
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        checkOpen();
        if (j < 1) {
            return 0L;
        }
        int i = this.end;
        int i2 = this.pos;
        if (i - i2 >= j) {
            this.pos = i2 + Math.toIntExact(j);
            return j;
        }
        long j2 = i - i2;
        this.pos = i;
        while (j2 < j) {
            if (fillBuf() == -1) {
                return j2;
            }
            int i3 = this.end;
            int i4 = this.pos;
            long j3 = j - j2;
            if (i3 - i4 >= j3) {
                this.pos = i4 + Math.toIntExact(j3);
                return j;
            }
            j2 += (long) (i3 - i4);
            this.pos = i3;
        }
        return j;
    }
}
