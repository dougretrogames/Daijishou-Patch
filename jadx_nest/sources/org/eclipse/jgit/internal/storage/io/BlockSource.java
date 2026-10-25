package org.eclipse.jgit.internal.storage.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BlockSource implements AutoCloseable {
    public void adviseSequentialRead(long j, long j2) {
    }

    @Override // java.lang.AutoCloseable
    public abstract void close();

    public abstract ByteBuffer read(long j, int i) throws IOException;

    public abstract long size() throws IOException;

    /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.io.BlockSource$1, reason: invalid class name */
    class AnonymousClass1 extends BlockSource {
        private final /* synthetic */ byte[] val$content;

        @Override // org.eclipse.jgit.internal.storage.io.BlockSource, java.lang.AutoCloseable
        public void close() {
        }

        AnonymousClass1(byte[] bArr) {
            this.val$content = bArr;
        }

        @Override // org.eclipse.jgit.internal.storage.io.BlockSource
        public ByteBuffer read(long j, int i) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            byte[] bArr = this.val$content;
            if (j < bArr.length) {
                int i2 = (int) j;
                byteBufferAllocate.put(this.val$content, i2, Math.min(i, bArr.length - i2));
            }
            return byteBufferAllocate;
        }

        @Override // org.eclipse.jgit.internal.storage.io.BlockSource
        public long size() {
            return this.val$content.length;
        }
    }

    public static BlockSource from(byte[] bArr) {
        return new AnonymousClass1(bArr);
    }

    public static BlockSource from(FileInputStream fileInputStream) {
        return from(fileInputStream.getChannel());
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.io.BlockSource$2, reason: invalid class name */
    class AnonymousClass2 extends BlockSource {
        private final /* synthetic */ FileChannel val$ch;

        AnonymousClass2(FileChannel fileChannel) {
            this.val$ch = fileChannel;
        }

        @Override // org.eclipse.jgit.internal.storage.io.BlockSource
        public ByteBuffer read(long j, int i) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.val$ch.position(j);
            while (this.val$ch.read(byteBufferAllocate) > 0 && byteBufferAllocate.position() < i) {
            }
            return byteBufferAllocate;
        }

        @Override // org.eclipse.jgit.internal.storage.io.BlockSource
        public long size() throws IOException {
            return this.val$ch.size();
        }

        @Override // org.eclipse.jgit.internal.storage.io.BlockSource, java.lang.AutoCloseable
        public void close() {
            try {
                this.val$ch.close();
            } catch (IOException unused) {
            }
        }
    }

    public static BlockSource from(FileChannel fileChannel) {
        return new AnonymousClass2(fileChannel);
    }
}
