package org.eclipse.jgit.util.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.Base85;

/* INFO: loaded from: classes5.dex */
public class BinaryHunkInputStream extends InputStream {
    private byte[] buffer;
    private final InputStream in;
    private int lineNumber;
    private int pos = 0;

    public BinaryHunkInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.pos;
        if (i < 0) {
            return -1;
        }
        byte[] bArr = this.buffer;
        if (bArr == null || i == bArr.length) {
            fillBuffer();
        }
        int i2 = this.pos;
        if (i2 < 0) {
            return -1;
        }
        byte[] bArr2 = this.buffer;
        this.pos = i2 + 1;
        return bArr2[i2] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return super.read(bArr, i, i2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
        this.buffer = null;
    }

    private void fillBuffer() throws IOException {
        int i;
        int i2 = this.in.read();
        if (i2 < 0) {
            this.pos = i2;
            this.buffer = null;
            return;
        }
        this.lineNumber++;
        if (65 <= i2 && i2 <= 90) {
            i = i2 - 64;
        } else {
            if (97 > i2 || i2 > 122) {
                throw new StreamCorruptedException(MessageFormat.format(JGitText.get().binaryHunkInvalidLength, Integer.valueOf(this.lineNumber), Integer.toHexString(i2)));
            }
            i = i2 - 70;
        }
        int iEncodedLength = Base85.encodedLength(i);
        byte[] bArr = new byte[iEncodedLength];
        for (int i3 = 0; i3 < iEncodedLength; i3++) {
            int i4 = this.in.read();
            if (i4 < 0 || i4 == 13 || i4 == 10) {
                throw new EOFException(MessageFormat.format(JGitText.get().binaryHunkInvalidLength, Integer.valueOf(this.lineNumber)));
            }
            bArr[i3] = (byte) i4;
        }
        int i5 = this.in.read();
        if (i5 == 13) {
            i5 = this.in.read();
        }
        if (i5 >= 0 && i5 != 10) {
            throw new StreamCorruptedException(MessageFormat.format(JGitText.get().binaryHunkMissingNewline, Integer.valueOf(this.lineNumber)));
        }
        try {
            this.buffer = Base85.decode(bArr, i);
            this.pos = 0;
        } catch (IllegalArgumentException e) {
            StreamCorruptedException streamCorruptedException = new StreamCorruptedException(MessageFormat.format(JGitText.get().binaryHunkDecodeError, Integer.valueOf(this.lineNumber)));
            streamCorruptedException.initCause(e);
            throw streamCorruptedException;
        }
    }
}
