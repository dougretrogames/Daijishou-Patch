package org.eclipse.jgit.util.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public abstract class LimitedInputStream extends FilterInputStream {
    private long left;
    protected final long limit;
    private long mark;

    protected abstract void limitExceeded() throws IOException;

    protected LimitedInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.mark = -1L;
        this.left = j;
        this.limit = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return (int) Math.min(this.in.available(), this.left);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.in.mark(i);
        this.mark = this.left;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.left == 0) {
            if (this.in.available() == 0) {
                return -1;
            }
            limitExceeded();
        }
        int i = this.in.read();
        if (i != -1) {
            this.left--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.left == 0) {
            if (this.in.available() == 0) {
                return -1;
            }
            limitExceeded();
        }
        int i3 = this.in.read(bArr, i, (int) Math.min(i2, this.left));
        if (i3 != -1) {
            this.left -= (long) i3;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException(JGitText.get().unsupportedMark);
        }
        if (this.mark == -1) {
            throw new IOException(JGitText.get().unsetMark);
        }
        this.in.reset();
        this.left = this.mark;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.in.skip(Math.min(j, this.left));
        this.left -= jSkip;
        return jSkip;
    }
}
