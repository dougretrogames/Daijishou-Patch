package org.eclipse.jgit.util.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class TimeoutInputStream extends FilterInputStream {
    private final InterruptTimer myTimer;
    private int timeout;

    public TimeoutInputStream(InputStream inputStream, InterruptTimer interruptTimer) {
        super(inputStream);
        this.myTimer = interruptTimer;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidTimeout, Integer.valueOf(i)));
        }
        this.timeout = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        try {
            try {
                beginRead();
                int i = super.read();
                endRead();
                return i;
            } catch (InterruptedIOException e) {
                throw readTimedOut(e);
            }
        } catch (Throwable th) {
            endRead();
            throw th;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            try {
                beginRead();
                int i3 = super.read(bArr, i, i2);
                endRead();
                return i3;
            } catch (InterruptedIOException e) {
                throw readTimedOut(e);
            }
        } catch (Throwable th) {
            endRead();
            throw th;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            try {
                beginRead();
                long jSkip = super.skip(j);
                endRead();
                return jSkip;
            } catch (InterruptedIOException e) {
                throw readTimedOut(e);
            }
        } catch (Throwable th) {
            endRead();
            throw th;
        }
    }

    private void beginRead() {
        this.myTimer.begin(this.timeout);
    }

    private void endRead() {
        this.myTimer.end();
    }

    private InterruptedIOException readTimedOut(InterruptedIOException interruptedIOException) {
        InterruptedIOException interruptedIOException2 = new InterruptedIOException(MessageFormat.format(JGitText.get().readTimedOut, Integer.valueOf(this.timeout)));
        interruptedIOException2.initCause(interruptedIOException);
        return interruptedIOException2;
    }
}
