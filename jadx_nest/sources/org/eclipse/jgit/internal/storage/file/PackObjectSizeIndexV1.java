package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;
import org.eclipse.jgit.util.NB;

/* JADX INFO: loaded from: classes5.dex */
class PackObjectSizeIndexV1 implements PackObjectSizeIndex {
    private static final byte BITS_24 = 24;
    private static final byte BITS_32 = 32;
    private final UInt24Array positions24;
    private final IntArray positions32;
    private final IntArray sizes32;
    private final LongArray sizes64;
    private final int threshold;

    static PackObjectSizeIndex parse(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8];
        inputStream.readNBytes(bArr, 0, 8);
        int iDecodeInt32 = NB.decodeInt32(bArr, 0);
        int iDecodeInt33 = NB.decodeInt32(bArr, 4);
        if (iDecodeInt33 == 0) {
            return new EmptyPackObjectSizeIndex(iDecodeInt32);
        }
        return new PackObjectSizeIndexV1(inputStream, iDecodeInt32, iDecodeInt33);
    }

    private PackObjectSizeIndexV1(InputStream inputStream, int i, int i2) throws IOException {
        this.threshold = i;
        UInt24Array uInt24Array = null;
        StreamHelper streamHelper = new StreamHelper(null);
        IntArray intArrayFrom = null;
        while (true) {
            byte b = streamHelper.readByte(inputStream);
            if (b != 0) {
                if (CommitConfig$$ExternalSyntheticBackport0.m(b, (byte) 24) == 0) {
                    uInt24Array = new UInt24Array(inputStream.readNBytes(streamHelper.readInt(inputStream) * 3));
                } else if (CommitConfig$$ExternalSyntheticBackport0.m(b, (byte) 32) == 0) {
                    intArrayFrom = IntArray.from(inputStream, streamHelper.readInt(inputStream));
                } else {
                    throw new UnsupportedEncodingException(String.format(JGitText.get().unknownPositionEncoding, Integer.toHexString(b)));
                }
            } else {
                this.positions24 = uInt24Array == null ? UInt24Array.EMPTY : uInt24Array;
                this.positions32 = intArrayFrom == null ? IntArray.EMPTY : intArrayFrom;
                this.sizes32 = IntArray.from(inputStream, i2);
                int i3 = streamHelper.readInt(inputStream);
                if (i3 == 0) {
                    this.sizes64 = LongArray.EMPTY;
                    return;
                }
                this.sizes64 = LongArray.from(inputStream, i3);
                if (streamHelper.readInt(inputStream) != 0) {
                    throw new IOException(JGitText.get().unsupportedSizesObjSizeIndex);
                }
                return;
            }
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackObjectSizeIndex
    public long getSize(int i) {
        int size;
        int iBinarySearch;
        if (!this.positions24.isEmpty() && i <= this.positions24.getLastValue()) {
            size = this.positions24.binarySearch(i);
        } else {
            size = (this.positions32.empty() || i < this.positions32.get(0) || (iBinarySearch = this.positions32.binarySearch(i)) < 0) ? -1 : iBinarySearch + this.positions24.size();
        }
        if (size < 0) {
            return -1L;
        }
        int i2 = this.sizes32.get(size);
        return i2 < 0 ? this.sizes64.get(Math.abs(i2) - 1) : i2;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackObjectSizeIndex
    public long getObjectCount() {
        return ((long) this.positions24.size()) + ((long) this.positions32.size());
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackObjectSizeIndex
    public int getThreshold() {
        return this.threshold;
    }

    private static class IntArray {
        private static final IntArray EMPTY = new IntArray(new byte[0]);
        private static final int INT_SIZE = 4;
        private final byte[] data;
        private final int size;

        static IntArray from(InputStream inputStream, int i) throws IOException {
            int i2 = i * 4;
            byte[] nBytes = inputStream.readNBytes(i2);
            if (nBytes.length < i2) {
                throw new IOException(MessageFormat.format(JGitText.get().unableToReadFullArray, Integer.valueOf(i)));
            }
            return new IntArray(nBytes);
        }

        private IntArray(byte[] bArr) {
            this.data = bArr;
            this.size = bArr.length / 4;
        }

        int binarySearch(int i) {
            int i2 = this.size;
            if (i2 == 0) {
                return -1;
            }
            int i3 = 0;
            do {
                int i4 = (i3 + i2) >>> 1;
                int iCompare = Integer.compare(i, get(i4));
                if (iCompare < 0) {
                    i2 = i4;
                } else {
                    if (iCompare == 0) {
                        return i4;
                    }
                    i3 = i4 + 1;
                }
            } while (i3 < i2);
            return -1;
        }

        int get(int i) {
            if (i < 0 || i >= this.size) {
                throw new IndexOutOfBoundsException(i);
            }
            return NB.decodeInt32(this.data, i * 4);
        }

        boolean empty() {
            return this.size == 0;
        }

        int size() {
            return this.size;
        }
    }

    private static class LongArray {
        private static final LongArray EMPTY = new LongArray(new byte[0]);
        private static final int LONG_SIZE = 8;
        private final byte[] data;
        private final int size;

        static LongArray from(InputStream inputStream, int i) throws IOException {
            int i2 = i * 8;
            byte[] nBytes = inputStream.readNBytes(i2);
            if (nBytes.length < i2) {
                throw new IOException(MessageFormat.format(JGitText.get().unableToReadFullArray, Integer.valueOf(i)));
            }
            return new LongArray(nBytes);
        }

        private LongArray(byte[] bArr) {
            this.data = bArr;
            this.size = bArr.length / 8;
        }

        long get(int i) {
            if (i < 0 || i >= this.size) {
                throw new IndexOutOfBoundsException(i);
            }
            return NB.decodeInt64(this.data, i * 8);
        }
    }

    private static class StreamHelper {
        private final byte[] buffer;

        /* synthetic */ StreamHelper(PackObjectSizeIndexV1IA packObjectSizeIndexV1IA) {
            this();
        }

        private StreamHelper() {
            this.buffer = new byte[8];
        }

        int readInt(InputStream inputStream) throws IOException {
            if (inputStream.readNBytes(this.buffer, 0, 4) < 4) {
                throw new IOException(JGitText.get().unableToReadFullInt);
            }
            return NB.decodeInt32(this.buffer, 0);
        }

        byte readByte(InputStream inputStream) throws IOException {
            if (inputStream.readNBytes(this.buffer, 0, 1) != 1) {
                throw new IOException(JGitText.get().cannotReadByte);
            }
            return this.buffer[0];
        }
    }

    private static class EmptyPackObjectSizeIndex implements PackObjectSizeIndex {
        private final int threshold;

        @Override // org.eclipse.jgit.internal.storage.file.PackObjectSizeIndex
        public long getObjectCount() {
            return 0L;
        }

        @Override // org.eclipse.jgit.internal.storage.file.PackObjectSizeIndex
        public long getSize(int i) {
            return -1L;
        }

        EmptyPackObjectSizeIndex(int i) {
            this.threshold = i;
        }

        @Override // org.eclipse.jgit.internal.storage.file.PackObjectSizeIndex
        public int getThreshold() {
            return this.threshold;
        }
    }
}
