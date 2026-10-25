package org.eclipse.jgit.internal.storage.io;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ProgressMonitor;

/* JADX INFO: loaded from: classes5.dex */
public class CancellableDigestOutputStream extends OutputStream {
    public static final int BYTES_TO_WRITE_BEFORE_CANCEL_CHECK = 131072;
    private long count;
    private final OutputStream out;
    private final ProgressMonitor writeMonitor;
    private final MessageDigest md = Constants.newMessageDigest();
    private long checkCancelAt = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;

    public CancellableDigestOutputStream(ProgressMonitor progressMonitor, OutputStream outputStream) {
        this.writeMonitor = progressMonitor;
        this.out = outputStream;
    }

    public final ProgressMonitor getWriteMonitor() {
        return this.writeMonitor;
    }

    public final byte[] getDigest() {
        return this.md.digest();
    }

    public final long length() {
        return this.count;
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        if (this.checkCancelAt <= this.count) {
            if (this.writeMonitor.isCancelled()) {
                throw new InterruptedIOException();
            }
            this.checkCancelAt = this.count + PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        this.out.write(i);
        this.md.update((byte) i);
        this.count++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            if (this.checkCancelAt <= this.count) {
                if (this.writeMonitor.isCancelled()) {
                    throw new InterruptedIOException();
                }
                this.checkCancelAt = this.count + PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            int iMin = Math.min(i2, 131072);
            this.out.write(bArr, i, iMin);
            this.md.update(bArr, i, iMin);
            this.count += (long) iMin;
            i += iMin;
            i2 -= iMin;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }
}
