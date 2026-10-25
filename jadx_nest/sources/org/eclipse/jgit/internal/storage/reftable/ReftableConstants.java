package org.eclipse.jgit.internal.storage.reftable;

/* JADX INFO: loaded from: classes5.dex */
class ReftableConstants {
    static final int FILE_FOOTER_LEN = 68;
    static final int FILE_HEADER_LEN = 24;
    static final byte INDEX_BLOCK_TYPE = 105;
    static final byte LOG_BLOCK_TYPE = 103;
    static final int LOG_DATA = 1;
    static final int LOG_NONE = 0;
    static final int MAX_BLOCK_SIZE = 16777215;
    static final int MAX_RESTARTS = 65535;
    static final byte OBJ_BLOCK_TYPE = 111;
    static final byte REF_BLOCK_TYPE = 114;
    static final int VALUE_1ID = 1;
    static final int VALUE_2ID = 2;
    static final int VALUE_NONE = 0;
    static final int VALUE_SYMREF = 3;
    static final int VALUE_TYPE_MASK = 7;
    static final byte VERSION_1 = 1;
    static final byte FILE_BLOCK_TYPE = 82;
    static final byte[] FILE_HEADER_MAGIC = {FILE_BLOCK_TYPE, 69, 70, 84};

    static long reverseUpdateIndex(long j) {
        return (-1) - j;
    }

    static boolean isFileHeaderMagic(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte[] bArr2 = FILE_HEADER_MAGIC;
        return i3 >= bArr2.length && bArr[i] == bArr2[0] && bArr[i + 1] == bArr2[1] && bArr[i + 2] == bArr2[2] && bArr[i + 3] == bArr2[3];
    }

    private ReftableConstants() {
    }
}
