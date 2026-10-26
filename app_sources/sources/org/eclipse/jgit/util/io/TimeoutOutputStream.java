package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class TimeoutOutputStream extends OutputStream {
    private final OutputStream dst;
    private final InterruptTimer myTimer;
    private int timeout;

    public TimeoutOutputStream(OutputStream outputStream, InterruptTimer interruptTimer) {
        this.dst = outputStream;
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

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            try {
                beginWrite();
                this.dst.write(i);
                endWrite();
            } catch (InterruptedIOException e) {
                throw writeTimedOut(e);
            }
        } catch (Throwable th) {
            endWrite();
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            try {
                beginWrite();
                this.dst.write(bArr, i, i2);
                endWrite();
            } catch (InterruptedIOException e) {
                throw writeTimedOut(e);
            }
        } catch (Throwable th) {
            endWrite();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            try {
                beginWrite();
                this.dst.flush();
                endWrite();
            } catch (InterruptedIOException e) {
                throw writeTimedOut(e);
            }
        } catch (Throwable th) {
            endWrite();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            try {
                beginWrite();
                this.dst.close();
                endWrite();
            } catch (InterruptedIOException e) {
                throw writeTimedOut(e);
            }
        } catch (Throwable th) {
            endWrite();
            throw th;
        }
    }

    private void beginWrite() {
        this.myTimer.begin(this.timeout);
    }

    private void endWrite() {
        this.myTimer.end();
    }

    private InterruptedIOException writeTimedOut(InterruptedIOException interruptedIOException) {
        InterruptedIOException interruptedIOException2 = new InterruptedIOException(MessageFormat.format(JGitText.get().writeTimedOut, Integer.valueOf(this.timeout)));
        interruptedIOException2.initCause(interruptedIOException);
        return interruptedIOException2;
    }
}
