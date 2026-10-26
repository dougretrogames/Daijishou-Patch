package org.eclipse.jgit.lib;

import java.io.IOException;
import java.io.InputStream;

/* INFO: loaded from: classes5.dex */
public abstract class ObjectStream extends InputStream {
    public abstract long getSize();

    public abstract int getType();

    public static class SmallStream extends ObjectStream {
        private final byte[] data;
        private int mark;
        private int ptr;
        private final int type;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        public SmallStream(ObjectLoader objectLoader) {
            this(objectLoader.getType(), objectLoader.getCachedBytes());
        }

        public SmallStream(int i, byte[] bArr) {
            this.type = i;
            this.data = bArr;
        }

        @Override // org.eclipse.jgit.lib.ObjectStream
        public int getType() {
            return this.type;
        }

        @Override // org.eclipse.jgit.lib.ObjectStream
        public long getSize() {
            return this.data.length;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.data.length - this.ptr;
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            int iMin = (int) Math.min(available(), Math.max(0L, j));
            this.ptr += iMin;
            return iMin;
        }

        @Override // java.io.InputStream
        public int read() {
            int i = this.ptr;
            byte[] bArr = this.data;
            if (i == bArr.length) {
                return -1;
            }
            this.ptr = i + 1;
            return bArr[i] & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (this.ptr == this.data.length) {
                return -1;
            }
            int iMin = Math.min(available(), i2);
            System.arraycopy(this.data, this.ptr, bArr, i, iMin);
            this.ptr += iMin;
            return iMin;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.mark = this.ptr;
        }

        @Override // java.io.InputStream
        public void reset() {
            this.ptr = this.mark;
        }
    }

    public static class Filter extends ObjectStream {
        private final InputStream in;
        private final long size;
        private final int type;

        public Filter(int i, long j, InputStream inputStream) {
            this.type = i;
            this.size = j;
            this.in = inputStream;
        }

        @Override // org.eclipse.jgit.lib.ObjectStream
        public int getType() {
            return this.type;
        }

        @Override // org.eclipse.jgit.lib.ObjectStream
        public long getSize() {
            return this.size;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.in.available();
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            return this.in.skip(j);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return this.in.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return this.in.read(bArr, i, i2);
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.in.markSupported();
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.in.mark(i);
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            this.in.reset();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.in.close();
        }
    }
}
