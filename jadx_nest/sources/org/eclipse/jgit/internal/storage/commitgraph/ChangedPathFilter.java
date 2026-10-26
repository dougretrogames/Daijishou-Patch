package org.eclipse.jgit.internal.storage.commitgraph;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Set;
import org.apache.commons.codec.digest.MurmurHash3;

/* INFO: loaded from: classes5.dex */
public class ChangedPathFilter {
    public static final int BITS_PER_ENTRY = 10;
    public static final int PATH_HASH_COUNT = 7;
    private static final int SEED1 = 691726191;
    private static final int SEED2 = 2120511020;
    private final byte[] data;
    private final int length;
    private final int offset;
    public static final ChangedPathFilter FULL = new ChangedPathFilter(new byte[]{-1}, 0, 1);
    private static final ChangedPathFilter EMPTY = new ChangedPathFilter(new byte[1], 0, 1);

    private ChangedPathFilter(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.offset = i;
        this.length = i2;
    }

    public static ChangedPathFilter fromPaths(Set<ByteBuffer> set) {
        if (set.isEmpty()) {
            return EMPTY;
        }
        int i = -Math.floorDiv((-set.size()) * 10, 8);
        byte[] bArr = new byte[i];
        for (ByteBuffer byteBuffer : set) {
            add(bArr, byteBuffer.array(), byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
        }
        return new ChangedPathFilter(bArr, 0, i);
    }

    public static ChangedPathFilter fromFile(byte[] bArr, int i, int i2) {
        return new ChangedPathFilter(bArr, i, i2);
    }

    private static void add(byte[] bArr, byte[] bArr2, int i, int i2) {
        int iHash32x86 = MurmurHash3.hash32x86(bArr2, i, i2, SEED1);
        int iHash32x87 = MurmurHash3.hash32x86(bArr2, i, i2, SEED2);
        for (int i3 = 0; i3 < 7; i3++) {
            int iRemainderUnsigned = Integer.remainderUnsigned((i3 * iHash32x87) + iHash32x86, bArr.length * 8);
            int i4 = iRemainderUnsigned / 8;
            bArr[i4] = (byte) (((byte) (1 << (iRemainderUnsigned % 8))) | bArr[i4]);
        }
    }

    public boolean maybeContains(byte[] bArr) {
        int iHash32x86 = MurmurHash3.hash32x86(bArr, 0, bArr.length, SEED1);
        int iHash32x87 = MurmurHash3.hash32x86(bArr, 0, bArr.length, SEED2);
        int i = this.length * 8;
        for (int i2 = 0; i2 < 7; i2++) {
            int iRemainderUnsigned = Integer.remainderUnsigned((i2 * iHash32x87) + iHash32x86, i);
            if ((((byte) (1 << (iRemainderUnsigned % 8))) & this.data[this.offset + (iRemainderUnsigned / 8)]) == 0) {
                return false;
            }
        }
        return true;
    }

    public void writeTo(ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(this.data, this.offset, this.length);
    }
}
