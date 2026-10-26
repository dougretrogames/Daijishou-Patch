package org.eclipse.jgit.treewalk.filter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
class ByteArraySet {
    private int grow;
    private Hasher hasher = new Hasher(null, 0);
    private int mask;
    private int size;
    private byte[][] table;

    ByteArraySet(int i) {
        initTable(1 << Integer.highestOneBit((i * 2) - 1));
    }

    private byte[] get(byte[] bArr, int i, int i2) {
        int i3 = this.mask;
        int i4 = i2 & i3;
        byte[][] bArr2 = this.table;
        while (true) {
            byte[] bArr3 = bArr2[i4];
            if (bArr3 == null) {
                return null;
            }
            if (equals(bArr3, bArr, i)) {
                return bArr3;
            }
            i4 = (i4 + 1) & i3;
        }
    }

    private static boolean equals(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length != i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    boolean contains(byte[] bArr, int i, int i2) {
        return get(bArr, i, i2) != null;
    }

    byte[] addIfAbsent(byte[] bArr, int i, int i2) {
        int i3 = this.mask;
        int i4 = i2 & i3;
        byte[][] bArr2 = this.table;
        while (true) {
            byte[] bArr3 = bArr2[i4];
            if (bArr3 != null) {
                if (equals(bArr3, bArr, i)) {
                    return bArr3;
                }
                i4 = (i4 + 1) & i3;
            } else {
                byte[] bArrCopyIfNotSameSize = copyIfNotSameSize(bArr, i);
                int i5 = this.size + 1;
                this.size = i5;
                if (i5 == this.grow) {
                    grow();
                    insert(bArrCopyIfNotSameSize, i2);
                    return bArrCopyIfNotSameSize;
                }
                bArr2[i4] = bArrCopyIfNotSameSize;
                return bArrCopyIfNotSameSize;
            }
        }
    }

    private static byte[] copyIfNotSameSize(byte[] bArr, int i) {
        if (bArr.length == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    int size() {
        return this.size;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    private void insert(byte[] bArr, int i) {
        int i2 = this.mask;
        int i3 = i & i2;
        byte[][] bArr2 = this.table;
        while (bArr2[i3] != null) {
            i3 = (i3 + 1) & i2;
        }
        bArr2[i3] = bArr;
    }

    private void grow() {
        byte[][] bArr = this.table;
        initTable(bArr.length << 1);
        for (byte[] bArr2 : bArr) {
            if (bArr2 != null) {
                this.hasher.init(bArr2, bArr2.length);
                insert(bArr2, this.hasher.hash());
            }
        }
    }

    private void initTable(int i) {
        if (i < 2) {
            i = 2;
        }
        this.grow = i >> 1;
        this.mask = i - 1;
        this.table = new byte[i][];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        for (byte[] bArr : this.table) {
            if (bArr != null) {
                if (sb.length() > 1) {
                    sb.append(" , ");
                }
                sb.append('\"');
                sb.append(RawParseUtils.decode(bArr));
                sb.append('\"');
                sb.append('(');
                sb.append(chainlength(bArr));
                sb.append(')');
            }
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    private int chainlength(byte[] bArr) {
        int iHash = new Hasher(bArr, bArr.length).hash();
        int i = this.mask;
        int i2 = iHash & i;
        byte[][] bArr2 = this.table;
        int i3 = 0;
        while (true) {
            byte[] bArr3 = bArr2[i2];
            if (bArr3 == null) {
                return -1;
            }
            if (equals(bArr3, bArr, bArr.length)) {
                return i3;
            }
            i2 = (i2 + 1) & i;
            i3++;
        }
    }

    static class Hasher {
        private byte[] data;
        private int hash;
        private int length;
        private int pos;

        Hasher(byte[] bArr, int i) {
            init(bArr, i);
        }

        void init(byte[] bArr, int i) {
            this.data = bArr;
            this.length = i;
            this.pos = 0;
            this.hash = 0;
        }

        int hash() {
            while (true) {
                int i = this.pos;
                if (i < this.length) {
                    int i2 = this.hash * 31;
                    byte[] bArr = this.data;
                    this.pos = i + 1;
                    this.hash = i2 + bArr[i];
                } else {
                    return this.hash;
                }
            }
        }

        int nextHash() {
            byte[] bArr;
            int i;
            int i2;
            do {
                int i3 = this.hash * 31;
                bArr = this.data;
                int i4 = this.pos;
                i = i3 + bArr[i4];
                this.hash = i;
                i2 = i4 + 1;
                this.pos = i2;
                if (i2 == this.length) {
                    break;
                }
            } while (bArr[i2] != 47);
            return i;
        }

        int getHash() {
            return this.hash;
        }

        boolean hasNext() {
            return this.pos < this.length;
        }

        public int length() {
            return this.pos;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.pos; i++) {
                sb.append((char) this.data[i]);
            }
            sb.append(" | ");
            for (int i2 = this.pos; i2 < this.length; i2++) {
                sb.append((char) this.data[i2]);
            }
            return sb.toString();
        }
    }

    byte[][] toArray() {
        byte[][] bArr = new byte[this.size][];
        int i = 0;
        for (byte[] bArr2 : this.table) {
            if (bArr2 != null) {
                bArr[i] = bArr2;
                i++;
            }
        }
        return bArr;
    }

    Set<byte[]> toSet() {
        return (Set) Arrays.stream(toArray()).collect(Collectors.toSet());
    }
}
