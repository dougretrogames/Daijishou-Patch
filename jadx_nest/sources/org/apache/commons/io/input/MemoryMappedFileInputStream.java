package org.apache.commons.io.input;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import org.apache.commons.io.build.AbstractStreamBuilder;

/* JADX INFO: loaded from: classes5.dex */
public final class MemoryMappedFileInputStream extends AbstractInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 262144;
    private static final ByteBuffer EMPTY_BUFFER = ByteBuffer.wrap(new byte[0]).asReadOnlyBuffer();
    private ByteBuffer buffer;
    private final int bufferSize;
    private final FileChannel channel;
    private long nextBufferPosition;

    /* synthetic */ MemoryMappedFileInputStream(Builder builder, AnonymousClass1 anonymousClass1) throws IOException {
        this(builder);
    }

    public static class Builder extends AbstractStreamBuilder<MemoryMappedFileInputStream, Builder> {
        public Builder() {
            setBufferSizeDefault(262144);
            setBufferSize(262144);
        }

        @Override // org.apache.commons.io.function.IOSupplier
        public MemoryMappedFileInputStream get() throws IOException {
            return new MemoryMappedFileInputStream(this, null);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private MemoryMappedFileInputStream(Builder builder) throws IOException {
        this.buffer = EMPTY_BUFFER;
        this.bufferSize = builder.getBufferSize();
        this.channel = FileChannel.open(builder.getPath(), StandardOpenOption.READ);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.buffer.remaining();
    }

    private void cleanBuffer() {
        if (ByteBufferCleaner.isSupported() && this.buffer.isDirect()) {
            ByteBufferCleaner.clean(this.buffer);
        }
    }

    @Override // org.apache.commons.io.input.AbstractInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (isClosed()) {
            return;
        }
        cleanBuffer();
        this.buffer = EMPTY_BUFFER;
        this.channel.close();
        super.close();
    }

    int getBufferSize() {
        return this.bufferSize;
    }

    private void nextBuffer() throws IOException {
        long size = this.channel.size() - this.nextBufferPosition;
        if (size > 0) {
            long jMin = Math.min(size, this.bufferSize);
            cleanBuffer();
            this.buffer = this.channel.map(FileChannel.MapMode.READ_ONLY, this.nextBufferPosition, jMin);
            this.nextBufferPosition += jMin;
            return;
        }
        this.buffer = EMPTY_BUFFER;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        checkOpen();
        if (!this.buffer.hasRemaining()) {
            nextBuffer();
            if (!this.buffer.hasRemaining()) {
                return -1;
            }
        }
        return Short.toUnsignedInt(this.buffer.get());
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        checkOpen();
        if (!this.buffer.hasRemaining()) {
            nextBuffer();
            if (!this.buffer.hasRemaining()) {
                return -1;
            }
        }
        int iMin = Math.min(this.buffer.remaining(), i2);
        this.buffer.get(bArr, i, iMin);
        return iMin;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        checkOpen();
        if (j <= 0) {
            return 0L;
        }
        if (j <= this.buffer.remaining()) {
            ByteBuffer byteBuffer = this.buffer;
            byteBuffer.position((int) (((long) byteBuffer.position()) + j));
            return j;
        }
        long jRemaining = ((long) this.buffer.remaining()) + Math.min(this.channel.size() - this.nextBufferPosition, j - ((long) this.buffer.remaining()));
        this.nextBufferPosition += jRemaining - ((long) this.buffer.remaining());
        nextBuffer();
        return jRemaining;
    }
}
