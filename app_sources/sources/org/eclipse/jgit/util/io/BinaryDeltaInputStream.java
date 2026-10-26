package org.eclipse.jgit.util.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class BinaryDeltaInputStream extends InputStream {
    private final byte[] base;
    private final InputStream delta;
    private int fromBase;
    private int fromDelta;
    private long resultLength;
    private long toDeliver = -1;
    private int baseOffset = -1;

    public BinaryDeltaInputStream(byte[] bArr, InputStream inputStream) {
        this.base = bArr;
        this.delta = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int next = readNext();
        if (next >= 0) {
            this.toDeliver--;
        }
        return next;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return super.read(bArr, i, i2);
    }

    private void initialize() throws IOException {
        long varInt = readVarInt(this.delta);
        if (varInt > 2147483647L || varInt < 0 || ((int) varInt) != this.base.length) {
            throw new IOException(MessageFormat.format(JGitText.get().binaryDeltaBaseLengthMismatch, Integer.valueOf(this.base.length), Long.valueOf(varInt)));
        }
        long varInt2 = readVarInt(this.delta);
        this.resultLength = varInt2;
        if (varInt2 < 0) {
            throw new StreamCorruptedException(JGitText.get().binaryDeltaInvalidResultLength);
        }
        this.toDeliver = varInt2;
        this.baseOffset = 0;
    }

    private int readNext() throws IOException {
        int i;
        if (this.baseOffset < 0) {
            initialize();
        }
        int i2 = this.fromBase;
        int i3 = 1;
        if (i2 > 0) {
            this.fromBase = i2 - 1;
            byte[] bArr = this.base;
            int i4 = this.baseOffset;
            this.baseOffset = i4 + 1;
            return bArr[i4] & 255;
        }
        int i5 = this.fromDelta;
        if (i5 > 0) {
            this.fromDelta = i5 - 1;
            return this.delta.read();
        }
        int i6 = this.delta.read();
        if (i6 < 0) {
            return -1;
        }
        if ((i6 & 128) == 0) {
            if (i6 != 0) {
                this.fromDelta = i6 - 1;
                return this.delta.read();
            }
            throw new StreamCorruptedException(JGitText.get().unsupportedCommand0);
        }
        int next = 0;
        long next2 = 0;
        int i7 = 0;
        while (true) {
            i = 16;
            if (i3 >= 16) {
                break;
            }
            if ((i6 & i3) != 0) {
                next2 |= ((long) next(this.delta)) << i7;
            }
            i3 *= 2;
            i7 += 8;
        }
        int i8 = 0;
        while (i < 128) {
            if ((i6 & i) != 0) {
                next |= next(this.delta) << i8;
            }
            i *= 2;
            i8 += 8;
        }
        if (next == 0) {
            next = 65536;
        }
        if (next2 > this.base.length - next) {
            throw new StreamCorruptedException(MessageFormat.format(JGitText.get().binaryDeltaInvalidOffset, Long.valueOf(next2), Integer.valueOf(next)));
        }
        this.baseOffset = (int) next2;
        this.fromBase = next;
        return readNext();
    }

    private int next(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i >= 0) {
            return i;
        }
        throw new EOFException();
    }

    private long readVarInt(InputStream inputStream) throws IOException {
        int next;
        long j = 0;
        int i = 0;
        do {
            next = next(inputStream);
            j |= ((long) (next & 127)) << i;
            i += 7;
        } while ((next & 128) != 0);
        return j;
    }

    public long getExpectedResultSize() throws IOException {
        if (this.baseOffset < 0) {
            initialize();
        }
        return this.resultLength;
    }

    public boolean isFullyConsumed() {
        try {
            return this.toDeliver == 0 && this.delta.read() < 0;
        } catch (IOException unused) {
            return this.toDeliver == 0;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delta.close();
    }
}
