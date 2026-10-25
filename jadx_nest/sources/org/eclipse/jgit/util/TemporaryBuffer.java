package org.eclipse.jgit.util;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ProgressMonitor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TemporaryBuffer extends OutputStream {
    protected static final int DEFAULT_IN_CORE_LIMIT = 1048576;
    ArrayList<Block> blocks;
    private int inCoreLimit;
    private int initialBlocks;
    private OutputStream overflow;

    protected abstract OutputStream overflow() throws IOException;

    protected TemporaryBuffer(int i) {
        this(i, i);
    }

    protected TemporaryBuffer(int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        this.inCoreLimit = i2;
        this.initialBlocks = ((i - 1) / 8192) + 1;
        reset();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        OutputStream outputStream = this.overflow;
        if (outputStream != null) {
            outputStream.write(i);
            return;
        }
        Block blockLast = last();
        if (blockLast.isFull()) {
            if (reachedInCoreLimit()) {
                this.overflow.write(i);
                return;
            } else {
                blockLast = new Block();
                this.blocks.add(blockLast);
            }
        }
        byte[] bArr = blockLast.buffer;
        int i2 = blockLast.count;
        blockLast.count = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.overflow == null) {
            while (i2 > 0) {
                Block blockLast = last();
                if (blockLast.isFull()) {
                    if (reachedInCoreLimit()) {
                        break;
                    }
                    blockLast = new Block();
                    this.blocks.add(blockLast);
                }
                int iMin = Math.min(blockLast.buffer.length - blockLast.count, i2);
                System.arraycopy(bArr, i, blockLast.buffer, blockLast.count, iMin);
                blockLast.count += iMin;
                i2 -= iMin;
                i += iMin;
            }
        }
        if (i2 > 0) {
            this.overflow.write(bArr, i, i2);
        }
    }

    protected void doFlush() throws IOException {
        if (this.overflow == null) {
            switchToOverflow();
        }
        this.overflow.flush();
    }

    public void copy(InputStream inputStream) throws IOException {
        if (this.blocks != null) {
            while (true) {
                Block blockLast = last();
                if (blockLast.isFull()) {
                    if (reachedInCoreLimit()) {
                        break;
                    }
                    blockLast = new Block();
                    this.blocks.add(blockLast);
                }
                int i = inputStream.read(blockLast.buffer, blockLast.count, blockLast.buffer.length - blockLast.count);
                if (i < 1) {
                    return;
                } else {
                    blockLast.count += i;
                }
            }
        }
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 <= 0) {
                return;
            } else {
                this.overflow.write(bArr, 0, i2);
            }
        }
    }

    public long length() {
        return inCoreLength();
    }

    private long inCoreLength() {
        return ((((long) this.blocks.size()) - 1) * PlaybackStateCompat.ACTION_PLAY_FROM_URI) + ((long) last().count);
    }

    public byte[] toByteArray() throws IOException {
        long length = length();
        if (2147483647L < length) {
            throw new OutOfMemoryError(JGitText.get().lengthExceedsMaximumArraySize);
        }
        byte[] bArr = new byte[(int) length];
        int i = 0;
        for (Block block : this.blocks) {
            System.arraycopy(block.buffer, 0, bArr, i, block.count);
            i += block.count;
        }
        return bArr;
    }

    public String toString(int i) {
        try {
            return RawParseUtils.decode(toByteArray(i));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public byte[] toByteArray(int i) throws IOException {
        long jMin = Math.min(length(), i);
        if (2147483647L < jMin) {
            throw new OutOfMemoryError(JGitText.get().lengthExceedsMaximumArraySize);
        }
        int i2 = (int) jMin;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (Block block : this.blocks) {
            int iMin = Math.min(i2 - i3, block.count);
            System.arraycopy(block.buffer, 0, bArr, i3, iMin);
            i3 += iMin;
            if (i3 == i2) {
                break;
            }
        }
        return bArr;
    }

    public void writeTo(OutputStream outputStream, ProgressMonitor progressMonitor) throws IOException {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        for (Block block : this.blocks) {
            outputStream.write(block.buffer, 0, block.count);
            progressMonitor.update(block.count / 1024);
        }
    }

    public InputStream openInputStream() throws IOException {
        return new BlockInputStream();
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.util.TemporaryBuffer$1, reason: invalid class name */
    class AnonymousClass1 extends BlockInputStream {
        final /* synthetic */ TemporaryBuffer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TemporaryBuffer temporaryBuffer, TemporaryBuffer temporaryBuffer2) {
            super();
            this.this$0 = temporaryBuffer2;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.this$0.destroy();
        }
    }

    public InputStream openInputStreamWithAutoDestroy() throws IOException {
        return new AnonymousClass1(this, this);
    }

    public void reset() {
        if (this.overflow != null) {
            destroy();
        }
        ArrayList<Block> arrayList = this.blocks;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.blocks = new ArrayList<>(this.initialBlocks);
        }
        this.blocks.add(new Block(Math.min(this.inCoreLimit, 8192)));
    }

    private Block last() {
        ArrayList<Block> arrayList = this.blocks;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean reachedInCoreLimit() throws IOException {
        if (inCoreLength() < this.inCoreLimit) {
            return false;
        }
        switchToOverflow();
        return true;
    }

    private void switchToOverflow() throws IOException {
        this.overflow = overflow();
        ArrayList<Block> arrayList = this.blocks;
        Block blockRemove = arrayList.remove(arrayList.size() - 1);
        for (Block block : this.blocks) {
            this.overflow.write(block.buffer, 0, block.count);
        }
        this.blocks = null;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.overflow, 8192);
        this.overflow = bufferedOutputStream;
        bufferedOutputStream.write(blockRemove.buffer, 0, blockRemove.count);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.overflow;
        if (outputStream != null) {
            try {
                outputStream.close();
            } finally {
                this.overflow = null;
            }
        }
    }

    public void destroy() {
        this.blocks = null;
        OutputStream outputStream = this.overflow;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            } finally {
                this.overflow = null;
            }
        }
    }

    public static class LocalFile extends TemporaryBuffer {
        private final File directory;
        private File onDiskFile;

        public LocalFile(File file) {
            this(file, 1048576);
        }

        public LocalFile(File file, int i) {
            super(i);
            this.directory = file;
        }

        @Override // org.eclipse.jgit.util.TemporaryBuffer
        protected OutputStream overflow() throws IOException {
            this.onDiskFile = File.createTempFile("jgit_", ".buf", this.directory);
            return new BufferedOutputStream(new FileOutputStream(this.onDiskFile));
        }

        @Override // org.eclipse.jgit.util.TemporaryBuffer
        public long length() {
            File file = this.onDiskFile;
            if (file == null) {
                return super.length();
            }
            return file.length();
        }

        @Override // org.eclipse.jgit.util.TemporaryBuffer
        public byte[] toByteArray() throws IOException {
            if (this.onDiskFile == null) {
                return super.toByteArray();
            }
            long length = length();
            if (2147483647L < length) {
                throw new OutOfMemoryError(JGitText.get().lengthExceedsMaximumArraySize);
            }
            int i = (int) length;
            byte[] bArr = new byte[i];
            Throwable th = null;
            try {
                FileInputStream fileInputStream = new FileInputStream(this.onDiskFile);
                try {
                    IO.readFully(fileInputStream, bArr, 0, i);
                    return bArr;
                } finally {
                    fileInputStream.close();
                }
            } catch (Throwable th2) {
                if (0 == 0) {
                    throw th2;
                }
                if (null != th2) {
                    th.addSuppressed(th2);
                }
                throw null;
            }
        }

        @Override // org.eclipse.jgit.util.TemporaryBuffer
        public byte[] toByteArray(int i) throws IOException {
            if (this.onDiskFile == null) {
                return super.toByteArray(i);
            }
            long jMin = Math.min(length(), i);
            if (2147483647L < jMin) {
                throw new OutOfMemoryError(JGitText.get().lengthExceedsMaximumArraySize);
            }
            int i2 = (int) jMin;
            byte[] bArr = new byte[i2];
            Throwable th = null;
            try {
                FileInputStream fileInputStream = new FileInputStream(this.onDiskFile);
                int i3 = 0;
                do {
                    try {
                        int i4 = fileInputStream.read(bArr, i3, i2 - i3);
                        if (i4 < 0) {
                            break;
                        }
                        i3 += i4;
                    } finally {
                        fileInputStream.close();
                    }
                } while (i3 != i2);
                return bArr;
            } catch (Throwable th2) {
                if (0 == 0) {
                    throw th2;
                }
                if (null != th2) {
                    th.addSuppressed(th2);
                }
                throw null;
            }
        }

        @Override // org.eclipse.jgit.util.TemporaryBuffer
        public void writeTo(OutputStream outputStream, ProgressMonitor progressMonitor) throws IOException {
            if (this.onDiskFile == null) {
                super.writeTo(outputStream, progressMonitor);
                return;
            }
            if (progressMonitor == null) {
                progressMonitor = NullProgressMonitor.INSTANCE;
            }
            Throwable th = null;
            try {
                FileInputStream fileInputStream = new FileInputStream(this.onDiskFile);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i >= 0) {
                            outputStream.write(bArr, 0, i);
                            progressMonitor.update(i / 1024);
                        } else {
                            fileInputStream.close();
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    fileInputStream.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null != th3) {
                    th.addSuppressed(th3);
                }
                throw null;
            }
        }

        @Override // org.eclipse.jgit.util.TemporaryBuffer
        public InputStream openInputStream() throws IOException {
            if (this.onDiskFile == null) {
                return super.openInputStream();
            }
            return new FileInputStream(this.onDiskFile);
        }

        @Override // org.eclipse.jgit.util.TemporaryBuffer
        public InputStream openInputStreamWithAutoDestroy() throws IOException {
            if (this.onDiskFile == null) {
                return super.openInputStreamWithAutoDestroy();
            }
            return new AnonymousClass1(this.onDiskFile);
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.util.TemporaryBuffer$LocalFile$1, reason: invalid class name */
        class AnonymousClass1 extends FileInputStream {
            AnonymousClass1(File file) throws FileNotFoundException {
                super(file);
            }

            @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                LocalFile.this.destroy();
            }
        }

        @Override // org.eclipse.jgit.util.TemporaryBuffer
        public void destroy() {
            super.destroy();
            File file = this.onDiskFile;
            if (file != null) {
                try {
                    if (!file.delete()) {
                        this.onDiskFile.deleteOnExit();
                    }
                } finally {
                    this.onDiskFile = null;
                }
            }
        }
    }

    public static class Heap extends TemporaryBuffer {
        public Heap(int i) {
            super(i);
        }

        public Heap(int i, int i2) {
            super(i, i2);
        }

        @Override // org.eclipse.jgit.util.TemporaryBuffer
        protected OutputStream overflow() throws IOException {
            throw new IOException(JGitText.get().inMemoryBufferLimitExceeded);
        }
    }

    static class Block {
        static final int SZ = 8192;
        final byte[] buffer;
        int count;

        Block() {
            this.buffer = new byte[8192];
        }

        Block(int i) {
            this.buffer = new byte[i];
        }

        boolean isFull() {
            return this.count == this.buffer.length;
        }
    }

    private class BlockInputStream extends InputStream {
        private Block block;
        private int blockIndex;
        private int blockPos;
        private byte[] singleByteBuffer;

        BlockInputStream() {
            this.block = TemporaryBuffer.this.blocks.get(this.blockIndex);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.singleByteBuffer == null) {
                this.singleByteBuffer = new byte[1];
            }
            if (read(this.singleByteBuffer) == 1) {
                return this.singleByteBuffer[0] & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (0 < j) {
                int iMin = (int) Math.min(this.block.count - this.blockPos, j);
                if (iMin > 0) {
                    this.blockPos += iMin;
                    long j3 = iMin;
                    j2 += j3;
                    j -= j3;
                } else if (!nextBlock()) {
                    break;
                }
            }
            return j2;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            if (i2 == 0) {
                return 0;
            }
            while (i2 > 0) {
                int iMin = Math.min(this.block.count - this.blockPos, i2);
                if (iMin > 0) {
                    System.arraycopy(this.block.buffer, this.blockPos, bArr, i, iMin);
                    this.blockPos += iMin;
                    i += iMin;
                    i2 -= iMin;
                    i3 += iMin;
                } else if (!nextBlock()) {
                    break;
                }
            }
            if (i3 > 0) {
                return i3;
            }
            return -1;
        }

        private boolean nextBlock() {
            int i = this.blockIndex + 1;
            this.blockIndex = i;
            if (i >= TemporaryBuffer.this.blocks.size()) {
                return false;
            }
            this.block = TemporaryBuffer.this.blocks.get(this.blockIndex);
            this.blockPos = 0;
            return true;
        }
    }
}
