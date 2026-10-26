package com.magneticchen.daijishou.utils;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: BoundedInputStream.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/utils/BoundedInputStream;", "Ljava/io/InputStream;", "data", "maxBytes", "", "(Ljava/io/InputStream;J)V", "bytesRemaining", "available", "", "close", "", "mark", "limit", "markSupported", "", "read", "buf", "", "off", "len", "reset", "skip", "n", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BoundedInputStream extends InputStream {
    private long bytesRemaining;
    private final InputStream data;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public BoundedInputStream(InputStream data, long j) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.bytesRemaining = Math.max(j, 0L);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return (int) Math.min(this.data.available(), this.bytesRemaining);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.data.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int limit) {
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        Intrinsics.checkNotNullParameter(buf, "buf");
        long j = this.bytesRemaining;
        if (j <= 0) {
            return -1;
        }
        int i = this.data.read(buf, off, (int) Math.min(len, j));
        this.bytesRemaining -= (long) i;
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] buf) throws IOException {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return read(buf, 0, buf.length);
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("reset() not supported");
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        long jSkip = this.data.skip(Math.min(n, this.bytesRemaining));
        this.bytesRemaining -= jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bytesRemaining <= 0) {
            return -1;
        }
        int i = this.data.read();
        if (i >= 0) {
            this.bytesRemaining--;
        }
        return i;
    }
}
