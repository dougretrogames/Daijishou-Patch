package org.apache.commons.codec.digest;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class Blake3 {
    private static final int BLOCK_INTS = 16;
    private static final int BLOCK_LEN = 64;
    private static final int CHAINING_VALUE_INTS = 8;
    private static final int CHUNK_END = 2;
    private static final int CHUNK_LEN = 1024;
    private static final int CHUNK_START = 1;
    private static final int DERIVE_KEY_CONTEXT = 32;
    private static final int DERIVE_KEY_MATERIAL = 64;
    private static final int KEYED_HASH = 16;
    private static final int KEY_INTS = 8;
    private static final int KEY_LEN = 32;
    private static final int OUT_LEN = 32;
    private static final int PARENT = 4;
    private static final int ROOT = 8;
    private final EngineState engineState;
    private static final int[] IV = {1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};
    private static final byte[][] MSG_SCHEDULE = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI}, new byte[]{2, 6, 3, 10, 7, 0, 4, Ascii.CR, 1, Ascii.VT, Ascii.FF, 5, 9, Ascii.SO, Ascii.SI, 8}, new byte[]{3, 4, 10, Ascii.FF, Ascii.CR, 2, 7, Ascii.SO, 6, 5, 9, 0, Ascii.VT, Ascii.SI, 8, 1}, new byte[]{10, 7, Ascii.FF, 9, Ascii.SO, 3, Ascii.CR, Ascii.SI, 4, 0, Ascii.VT, 2, 5, 8, 1, 6}, new byte[]{Ascii.FF, Ascii.CR, 9, Ascii.VT, Ascii.SI, 10, Ascii.SO, 8, 7, 2, 5, 3, 0, 1, 6, 4}, new byte[]{9, Ascii.SO, Ascii.VT, 5, 8, Ascii.FF, Ascii.SI, 1, Ascii.CR, 3, 0, 10, 2, 6, 4, 7}, new byte[]{Ascii.VT, Ascii.SI, 5, 0, 1, 9, 8, 6, Ascii.SO, 10, 2, Ascii.FF, 3, 4, 7, Ascii.CR}};

    private static final class ChunkState {
        private final byte[] block;
        private int blockLength;
        private int blocksCompressed;
        private int[] chainingValue;
        private final long chunkCounter;
        private final int flags;

        /* synthetic */ ChunkState(int[] iArr, long j, int i, AnonymousClass1 anonymousClass1) {
            this(iArr, j, i);
        }

        private ChunkState(int[] iArr, long j, int i) {
            this.block = new byte[64];
            this.chainingValue = iArr;
            this.chunkCounter = j;
            this.flags = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int length() {
            return (this.blocksCompressed * 64) + this.blockLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Output output() {
            return new Output(this.chainingValue, Blake3.unpackInts(this.block, 16), this.chunkCounter, this.blockLength, this.flags | startFlag() | 2, null);
        }

        private int startFlag() {
            return this.blocksCompressed == 0 ? 1 : 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update(byte[] bArr, int i, int i2) {
            while (i2 > 0) {
                if (this.blockLength == 64) {
                    this.chainingValue = Arrays.copyOf(Blake3.compress(this.chainingValue, Blake3.unpackInts(this.block, 16), 64, this.chunkCounter, this.flags | startFlag()), 8);
                    this.blocksCompressed++;
                    this.blockLength = 0;
                    Arrays.fill(this.block, (byte) 0);
                }
                int iMin = Math.min(64 - this.blockLength, i2);
                System.arraycopy(bArr, i, this.block, this.blockLength, iMin);
                this.blockLength += iMin;
                i += iMin;
                i2 -= iMin;
            }
        }
    }

    private static final class EngineState {
        private final int[][] cvStack;
        private final int flags;
        private final int[] key;
        private int stackLen;
        private ChunkState state;

        /* synthetic */ EngineState(int[] iArr, int i, AnonymousClass1 anonymousClass1) {
            this(iArr, i);
        }

        private EngineState(int[] iArr, int i) {
            this.cvStack = new int[54][];
            this.key = iArr;
            this.flags = i;
            this.state = new ChunkState(iArr, 0L, i, null);
        }

        private void addChunkCV(int[] iArr, long j) {
            while ((1 & j) == 0) {
                iArr = Blake3.parentChainingValue(popCV(), iArr, this.key, this.flags);
                j >>= 1;
            }
            pushCV(iArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void inputData(byte[] bArr, int i, int i2) {
            while (i2 > 0) {
                if (this.state.length() == 1024) {
                    int[] iArrChainingValue = this.state.output().chainingValue();
                    long j = this.state.chunkCounter + 1;
                    addChunkCV(iArrChainingValue, j);
                    this.state = new ChunkState(this.key, j, this.flags, null);
                }
                int iMin = Math.min(1024 - this.state.length(), i2);
                this.state.update(bArr, i, iMin);
                i += iMin;
                i2 -= iMin;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void outputHash(byte[] bArr, int i, int i2) {
            Output output = this.state.output();
            int i3 = this.stackLen;
            while (true) {
                int i4 = i3 - 1;
                if (i3 > 0) {
                    output = Blake3.parentOutput(this.cvStack[i4], output.chainingValue(), this.key, this.flags);
                    i3 = i4;
                } else {
                    output.rootOutputBytes(bArr, i, i2);
                    return;
                }
            }
        }

        private int[] popCV() {
            int[][] iArr = this.cvStack;
            int i = this.stackLen - 1;
            this.stackLen = i;
            return iArr[i];
        }

        private void pushCV(int[] iArr) {
            int[][] iArr2 = this.cvStack;
            int i = this.stackLen;
            this.stackLen = i + 1;
            iArr2[i] = iArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.stackLen = 0;
            Arrays.fill(this.cvStack, (Object) null);
            this.state = new ChunkState(this.key, 0L, this.flags, null);
        }
    }

    private static final class Output {
        private final int blockLength;
        private final int[] blockWords;
        private final long counter;
        private final int flags;
        private final int[] inputChainingValue;

        /* synthetic */ Output(int[] iArr, int[] iArr2, long j, int i, int i2, AnonymousClass1 anonymousClass1) {
            this(iArr, iArr2, j, i, i2);
        }

        private Output(int[] iArr, int[] iArr2, long j, int i, int i2) {
            this.inputChainingValue = iArr;
            this.blockWords = iArr2;
            this.counter = j;
            this.blockLength = i;
            this.flags = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int[] chainingValue() {
            return Arrays.copyOf(Blake3.compress(this.inputChainingValue, this.blockWords, this.blockLength, this.counter, this.flags), 8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void rootOutputBytes(byte[] bArr, int i, int i2) {
            int i3 = 0;
            while (i2 > 0) {
                int iMin = Math.min(64, i2);
                i2 -= iMin;
                int i4 = i3 + 1;
                int[] iArrCompress = Blake3.compress(this.inputChainingValue, this.blockWords, this.blockLength, i3, this.flags | 8);
                int i5 = 0;
                while (iMin > 0) {
                    int iMin2 = Math.min(4, iMin);
                    Blake3.packInt(iArrCompress[i5], bArr, i, iMin2);
                    i += iMin2;
                    iMin -= iMin2;
                    i5++;
                }
                i3 = i4;
            }
        }
    }

    private static void checkBufferArgs(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr);
        if (i < 0) {
            throw new IndexOutOfBoundsException("Offset must be non-negative");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Length must be non-negative");
        }
        int length = bArr.length;
        if (i > length - i2) {
            throw new IndexOutOfBoundsException("Offset " + i + " and length " + i2 + " out of bounds with buffer length " + length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] compress(int[] iArr, int[] iArr2, int i, long j, int i2) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, 16);
        System.arraycopy(IV, 0, iArrCopyOf, 8, 4);
        iArrCopyOf[12] = (int) j;
        iArrCopyOf[13] = (int) (j >> 32);
        iArrCopyOf[14] = i;
        iArrCopyOf[15] = i2;
        for (int i3 = 0; i3 < 7; i3++) {
            round(iArrCopyOf, iArr2, MSG_SCHEDULE[i3]);
        }
        for (int i4 = 0; i4 < iArrCopyOf.length / 2; i4++) {
            int i5 = i4 + 8;
            iArrCopyOf[i4] = iArrCopyOf[i4] ^ iArrCopyOf[i5];
            iArrCopyOf[i5] = iArrCopyOf[i5] ^ iArr[i4];
        }
        return iArrCopyOf;
    }

    private static void g(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = iArr[i] + iArr[i2] + i5;
        iArr[i] = i7;
        int iRotateRight = Integer.rotateRight(iArr[i4] ^ i7, 16);
        iArr[i4] = iRotateRight;
        int i8 = iArr[i3] + iRotateRight;
        iArr[i3] = i8;
        int iRotateRight2 = Integer.rotateRight(iArr[i2] ^ i8, 12);
        iArr[i2] = iRotateRight2;
        int i9 = iArr[i] + iRotateRight2 + i6;
        iArr[i] = i9;
        int iRotateRight3 = Integer.rotateRight(iArr[i4] ^ i9, 8);
        iArr[i4] = iRotateRight3;
        int i10 = iArr[i3] + iRotateRight3;
        iArr[i3] = i10;
        iArr[i2] = Integer.rotateRight(iArr[i2] ^ i10, 7);
    }

    public static byte[] hash(byte[] bArr) {
        return initHash().update(bArr).doFinalize(32);
    }

    public static Blake3 initHash() {
        return new Blake3(IV, 0);
    }

    public static Blake3 initKeyDerivationFunction(byte[] bArr) {
        Objects.requireNonNull(bArr);
        EngineState engineState = new EngineState(IV, 32, null);
        engineState.inputData(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[32];
        engineState.outputHash(bArr2, 0, 32);
        return new Blake3(unpackInts(bArr2, 8), 64);
    }

    public static Blake3 initKeyedHash(byte[] bArr) {
        Objects.requireNonNull(bArr);
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Blake3 keys must be 32 bytes");
        }
        return new Blake3(unpackInts(bArr, 8), 16);
    }

    public static byte[] keyedHash(byte[] bArr, byte[] bArr2) {
        return initKeyedHash(bArr).update(bArr2).doFinalize(32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void packInt(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i2 + i4] = (byte) (i >>> (i4 * 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] parentChainingValue(int[] iArr, int[] iArr2, int[] iArr3, int i) {
        return parentOutput(iArr, iArr2, iArr3, i).chainingValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Output parentOutput(int[] iArr, int[] iArr2, int[] iArr3, int i) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, 16);
        System.arraycopy(iArr2, 0, iArrCopyOf, 8, 8);
        return new Output((int[]) iArr3.clone(), iArrCopyOf, 0L, 64, i | 4, null);
    }

    private static void round(int[] iArr, int[] iArr2, byte[] bArr) {
        g(iArr, 0, 4, 8, 12, iArr2[bArr[0]], iArr2[bArr[1]]);
        g(iArr, 1, 5, 9, 13, iArr2[bArr[2]], iArr2[bArr[3]]);
        g(iArr, 2, 6, 10, 14, iArr2[bArr[4]], iArr2[bArr[5]]);
        g(iArr, 3, 7, 11, 15, iArr2[bArr[6]], iArr2[bArr[7]]);
        g(iArr, 0, 5, 10, 15, iArr2[bArr[8]], iArr2[bArr[9]]);
        g(iArr, 1, 6, 11, 12, iArr2[bArr[10]], iArr2[bArr[11]]);
        g(iArr, 2, 7, 8, 13, iArr2[bArr[12]], iArr2[bArr[13]]);
        g(iArr, 3, 4, 9, 14, iArr2[bArr[14]], iArr2[bArr[15]]);
    }

    private static int unpackInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] unpackInts(byte[] bArr, int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            iArr[i2] = unpackInt(bArr, i3);
            i2++;
            i3 += 4;
        }
        return iArr;
    }

    private Blake3(int[] iArr, int i) {
        this.engineState = new EngineState(iArr, i, null);
    }

    public Blake3 doFinalize(byte[] bArr) {
        return doFinalize(bArr, 0, bArr.length);
    }

    public Blake3 doFinalize(byte[] bArr, int i, int i2) {
        checkBufferArgs(bArr, i, i2);
        this.engineState.outputHash(bArr, i, i2);
        return this;
    }

    public byte[] doFinalize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Requested bytes must be non-negative");
        }
        byte[] bArr = new byte[i];
        doFinalize(bArr);
        return bArr;
    }

    public Blake3 reset() {
        this.engineState.reset();
        return this;
    }

    public Blake3 update(byte[] bArr) {
        return update(bArr, 0, bArr.length);
    }

    public Blake3 update(byte[] bArr, int i, int i2) {
        checkBufferArgs(bArr, i, i2);
        this.engineState.inputData(bArr, i, i2);
        return this;
    }
}
