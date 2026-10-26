package org.eclipse.jgit.patch;

import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class BinaryHunk {
    int endOffset;
    private final FileHeader file;
    private int length;
    final int startOffset;
    private Type type;
    private static final byte[] LITERAL = Constants.encodeASCII("literal ");
    private static final byte[] DELTA = Constants.encodeASCII("delta ");

    public enum Type {
        LITERAL_DEFLATED,
        DELTA_DEFLATED;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] typeArrValuesCustom = values();
            int length = typeArrValuesCustom.length;
            Type[] typeArr = new Type[length];
            System.arraycopy(typeArrValuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }

    BinaryHunk(FileHeader fileHeader, int i) {
        this.file = fileHeader;
        this.startOffset = i;
    }

    public FileHeader getFileHeader() {
        return this.file;
    }

    public byte[] getBuffer() {
        return this.file.buf;
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    public int getEndOffset() {
        return this.endOffset;
    }

    public Type getType() {
        return this.type;
    }

    public int getSize() {
        return this.length;
    }

    int parseHunk(int i, int i2) {
        byte[] bArr = this.file.buf;
        byte[] bArr2 = LITERAL;
        if (RawParseUtils.match(bArr, i, bArr2) >= 0) {
            this.type = Type.LITERAL_DEFLATED;
            this.length = RawParseUtils.parseBase10(bArr, bArr2.length + i, null);
        } else {
            byte[] bArr3 = DELTA;
            if (RawParseUtils.match(bArr, i, bArr3) < 0) {
                return -1;
            }
            this.type = Type.DELTA_DEFLATED;
            this.length = RawParseUtils.parseBase10(bArr, bArr3.length + i, null);
        }
        int iNextLF = RawParseUtils.nextLF(bArr, i);
        while (iNextLF < i2) {
            boolean z = bArr[iNextLF] == 10;
            iNextLF = RawParseUtils.nextLF(bArr, iNextLF);
            if (z) {
                return iNextLF;
            }
        }
        return iNextLF;
    }
}
