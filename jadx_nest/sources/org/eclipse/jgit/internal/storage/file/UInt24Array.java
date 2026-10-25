package org.eclipse.jgit.internal.storage.file;

/* JADX INFO: loaded from: classes5.dex */
final class UInt24Array {
    public static final UInt24Array EMPTY = new UInt24Array(new byte[0]);
    private static final int ENTRY_SZ = 3;
    private final byte[] data;
    private final int size;

    UInt24Array(byte[] bArr) {
        this.data = bArr;
        this.size = bArr.length / 3;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    int size() {
        return this.size;
    }

    int get(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(i);
        }
        int i2 = i * 3;
        byte[] bArr = this.data;
        return (bArr[i2 + 2] & 255) | ((((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255)) << 8);
    }

    int binarySearch(int i) {
        if (((-16777216) & i) != 0) {
            throw new IllegalArgumentException("Too big value for 3 bytes");
        }
        int i2 = this.size;
        if (i2 == 0 || i2 == 0) {
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

    int getLastValue() {
        return get(this.size - 1);
    }
}
