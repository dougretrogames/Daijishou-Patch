package org.eclipse.jgit.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public class MessageWriter extends Writer {
    private final ByteArrayOutputStream buf = new ByteArrayOutputStream();
    private final OutputStreamWriter enc = new OutputStreamWriter(getRawStream(), StandardCharsets.UTF_8);

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        synchronized (this.buf) {
            this.enc.write(cArr, i, i2);
            this.enc.flush();
        }
    }

    public OutputStream getRawStream() {
        return this.buf;
    }

    public String toString() {
        return RawParseUtils.decode(this.buf.toByteArray());
    }
}
