package org.eclipse.jgit.util;

/* INFO: loaded from: classes5.dex */
public final class NB {
    public static int compareUInt32(int i, int i2) {
        int i3 = (i >>> 1) - (i2 >>> 1);
        return i3 != 0 ? i3 : (i & 1) - (i2 & 1);
    }

    public static int compareUInt64(long j, long j2) {
        long j3 = (j >>> 1) - (j2 >>> 1);
        if (j3 > 0) {
            return 1;
        }
        if (j3 < 0) {
            return -1;
        }
        long j4 = (j & 1) - (j2 & 1);
        if (j4 > 0) {
            return 1;
        }
        return j4 < 0 ? -1 : 0;
    }

    public static int decodeUInt16(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public static int decodeUInt24(byte[] bArr, int i) {
        return (bArr[i + 2] & 255) | ((((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)) << 8);
    }

    public static int decodeInt32(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | (((((bArr[i] << 8) | (bArr[i + 1] & 255)) << 8) | (bArr[i + 2] & 255)) << 8);
    }

    public static long decodeInt64(byte[] bArr, int i) {
        return ((long) (bArr[i + 7] & 255)) | (((((((((((((((long) bArr[i]) << 8) | ((long) (bArr[i + 1] & 255))) << 8) | ((long) (bArr[i + 2] & 255))) << 8) | ((long) (bArr[i + 3] & 255))) << 8) | ((long) (bArr[i + 4] & 255))) << 8) | ((long) (bArr[i + 5] & 255))) << 8) | ((long) (bArr[i + 6] & 255))) << 8);
    }

    public static long decodeUInt32(byte[] bArr, int i) {
        return (((long) (bArr[i] & 255)) << 24) | ((long) (((((bArr[i + 1] & 255) << 8) | (bArr[i + 2] & 255)) << 8) | (bArr[i + 3] & 255)));
    }

    public static long decodeUInt64(byte[] bArr, int i) {
        return decodeUInt32(bArr, i + 4) | (decodeUInt32(bArr, i) << 32);
    }

    public static void encodeInt16(byte[] bArr, int i, int i2) {
        bArr[i + 1] = (byte) i2;
        bArr[i] = (byte) (i2 >>> 8);
    }

    public static void encodeInt24(byte[] bArr, int i, int i2) {
        bArr[i + 2] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >>> 8);
        bArr[i] = (byte) (i2 >>> 16);
    }

    public static void encodeInt32(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) i2;
        bArr[i + 2] = (byte) (i2 >>> 8);
        bArr[i + 1] = (byte) (i2 >>> 16);
        bArr[i] = (byte) (i2 >>> 24);
    }

    public static void encodeInt64(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) j;
        bArr[i + 6] = (byte) (j >>> 8);
        bArr[i + 5] = (byte) (j >>> 16);
        bArr[i + 4] = (byte) (j >>> 24);
        bArr[i + 3] = (byte) (j >>> 32);
        bArr[i + 2] = (byte) (j >>> 40);
        bArr[i + 1] = (byte) (j >>> 48);
        bArr[i] = (byte) (j >>> 56);
    }

    private NB() {
    }
}
