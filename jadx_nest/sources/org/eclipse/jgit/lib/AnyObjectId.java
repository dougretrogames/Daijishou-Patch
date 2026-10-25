package org.eclipse.jgit.lib;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.References;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AnyObjectId implements Comparable<AnyObjectId> {
    private static final byte[] hexbyte = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    private static final char[] hexchar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    int w1;
    int w2;
    int w3;
    int w4;
    int w5;

    public abstract ObjectId toObjectId();

    public static boolean isEqual(AnyObjectId anyObjectId, AnyObjectId anyObjectId2) {
        if (References.isSameObject(anyObjectId, anyObjectId2)) {
            return true;
        }
        return anyObjectId.w3 == anyObjectId2.w3 && anyObjectId.w4 == anyObjectId2.w4 && anyObjectId.w5 == anyObjectId2.w5 && anyObjectId.w1 == anyObjectId2.w1 && anyObjectId.w2 == anyObjectId2.w2;
    }

    public final int getFirstByte() {
        return this.w1 >>> 24;
    }

    public final int getByte(int i) {
        int i2;
        int i3 = i >> 2;
        if (i3 == 0) {
            i2 = this.w1;
        } else if (i3 == 1) {
            i2 = this.w2;
        } else if (i3 == 2) {
            i2 = this.w3;
        } else if (i3 == 3) {
            i2 = this.w4;
        } else if (i3 == 4) {
            i2 = this.w5;
        } else {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return (i2 >>> ((3 - (i & 3)) * 8)) & 255;
    }

    @Override // java.lang.Comparable
    public final int compareTo(AnyObjectId anyObjectId) {
        if (this == anyObjectId) {
            return 0;
        }
        int iCompareUInt32 = NB.compareUInt32(this.w1, anyObjectId.w1);
        if (iCompareUInt32 != 0) {
            return iCompareUInt32;
        }
        int iCompareUInt33 = NB.compareUInt32(this.w2, anyObjectId.w2);
        if (iCompareUInt33 != 0) {
            return iCompareUInt33;
        }
        int iCompareUInt34 = NB.compareUInt32(this.w3, anyObjectId.w3);
        if (iCompareUInt34 != 0) {
            return iCompareUInt34;
        }
        int iCompareUInt35 = NB.compareUInt32(this.w4, anyObjectId.w4);
        return iCompareUInt35 != 0 ? iCompareUInt35 : NB.compareUInt32(this.w5, anyObjectId.w5);
    }

    public final int compareTo(byte[] bArr, int i) {
        int iCompareUInt32 = NB.compareUInt32(this.w1, NB.decodeInt32(bArr, i));
        if (iCompareUInt32 != 0) {
            return iCompareUInt32;
        }
        int iCompareUInt33 = NB.compareUInt32(this.w2, NB.decodeInt32(bArr, i + 4));
        if (iCompareUInt33 != 0) {
            return iCompareUInt33;
        }
        int iCompareUInt34 = NB.compareUInt32(this.w3, NB.decodeInt32(bArr, i + 8));
        if (iCompareUInt34 != 0) {
            return iCompareUInt34;
        }
        int iCompareUInt35 = NB.compareUInt32(this.w4, NB.decodeInt32(bArr, i + 12));
        return iCompareUInt35 != 0 ? iCompareUInt35 : NB.compareUInt32(this.w5, NB.decodeInt32(bArr, i + 16));
    }

    public final int compareTo(int[] iArr, int i) {
        int iCompareUInt32 = NB.compareUInt32(this.w1, iArr[i]);
        if (iCompareUInt32 != 0) {
            return iCompareUInt32;
        }
        int iCompareUInt33 = NB.compareUInt32(this.w2, iArr[i + 1]);
        if (iCompareUInt33 != 0) {
            return iCompareUInt33;
        }
        int iCompareUInt34 = NB.compareUInt32(this.w3, iArr[i + 2]);
        if (iCompareUInt34 != 0) {
            return iCompareUInt34;
        }
        int iCompareUInt35 = NB.compareUInt32(this.w4, iArr[i + 3]);
        return iCompareUInt35 != 0 ? iCompareUInt35 : NB.compareUInt32(this.w5, iArr[i + 4]);
    }

    public boolean startsWith(AbbreviatedObjectId abbreviatedObjectId) {
        return abbreviatedObjectId.prefixCompare(this) == 0;
    }

    public final int hashCode() {
        return this.w2;
    }

    public final boolean equals(AnyObjectId anyObjectId) {
        if (anyObjectId != null) {
            return isEqual(this, anyObjectId);
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AnyObjectId) {
            return equals((AnyObjectId) obj);
        }
        return false;
    }

    public void copyRawTo(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.w1);
        byteBuffer.putInt(this.w2);
        byteBuffer.putInt(this.w3);
        byteBuffer.putInt(this.w4);
        byteBuffer.putInt(this.w5);
    }

    public void copyRawTo(byte[] bArr, int i) {
        NB.encodeInt32(bArr, i, this.w1);
        NB.encodeInt32(bArr, i + 4, this.w2);
        NB.encodeInt32(bArr, i + 8, this.w3);
        NB.encodeInt32(bArr, i + 12, this.w4);
        NB.encodeInt32(bArr, i + 16, this.w5);
    }

    public void copyRawTo(int[] iArr, int i) {
        iArr[i] = this.w1;
        iArr[i + 1] = this.w2;
        iArr[i + 2] = this.w3;
        iArr[i + 3] = this.w4;
        iArr[i + 4] = this.w5;
    }

    public void copyRawTo(OutputStream outputStream) throws IOException {
        writeRawInt(outputStream, this.w1);
        writeRawInt(outputStream, this.w2);
        writeRawInt(outputStream, this.w3);
        writeRawInt(outputStream, this.w4);
        writeRawInt(outputStream, this.w5);
    }

    private static void writeRawInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i >>> 24);
        outputStream.write(i >>> 16);
        outputStream.write(i >>> 8);
        outputStream.write(i);
    }

    public void copyTo(OutputStream outputStream) throws IOException {
        outputStream.write(toHexByteArray());
    }

    public void copyTo(byte[] bArr, int i) {
        formatHexByte(bArr, i, this.w1);
        formatHexByte(bArr, i + 8, this.w2);
        formatHexByte(bArr, i + 16, this.w3);
        formatHexByte(bArr, i + 24, this.w4);
        formatHexByte(bArr, i + 32, this.w5);
    }

    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(toHexByteArray());
    }

    private byte[] toHexByteArray() {
        byte[] bArr = new byte[40];
        formatHexByte(bArr, 0, this.w1);
        formatHexByte(bArr, 8, this.w2);
        formatHexByte(bArr, 16, this.w3);
        formatHexByte(bArr, 24, this.w4);
        formatHexByte(bArr, 32, this.w5);
        return bArr;
    }

    private static void formatHexByte(byte[] bArr, int i, int i2) {
        int i3 = i + 7;
        while (i3 >= i && i2 != 0) {
            bArr[i3] = hexbyte[i2 & 15];
            i2 >>>= 4;
            i3--;
        }
        while (i3 >= i) {
            bArr[i3] = 48;
            i3--;
        }
    }

    public void copyTo(Writer writer) throws IOException {
        writer.write(toHexCharArray());
    }

    public void copyTo(char[] cArr, Writer writer) throws IOException {
        toHexCharArray(cArr);
        writer.write(cArr, 0, 40);
    }

    public void copyTo(char[] cArr, StringBuilder sb) {
        toHexCharArray(cArr);
        sb.append(cArr, 0, 40);
    }

    private char[] toHexCharArray() {
        char[] cArr = new char[40];
        toHexCharArray(cArr);
        return cArr;
    }

    private void toHexCharArray(char[] cArr) {
        formatHexChar(cArr, 0, this.w1);
        formatHexChar(cArr, 8, this.w2);
        formatHexChar(cArr, 16, this.w3);
        formatHexChar(cArr, 24, this.w4);
        formatHexChar(cArr, 32, this.w5);
    }

    static void formatHexChar(char[] cArr, int i, int i2) {
        int i3 = i + 7;
        while (i3 >= i && i2 != 0) {
            cArr[i3] = hexchar[i2 & 15];
            i2 >>>= 4;
            i3--;
        }
        while (i3 >= i) {
            cArr[i3] = '0';
            i3--;
        }
    }

    public String toString() {
        return "AnyObjectId[" + name() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    public final String name() {
        return new String(toHexCharArray());
    }

    public final String getName() {
        return name();
    }

    public AbbreviatedObjectId abbreviate(int i) {
        return new AbbreviatedObjectId(i, AbbreviatedObjectId.mask(i, 1, this.w1), AbbreviatedObjectId.mask(i, 2, this.w2), AbbreviatedObjectId.mask(i, 3, this.w3), AbbreviatedObjectId.mask(i, 4, this.w4), AbbreviatedObjectId.mask(i, 5, this.w5));
    }

    public final ObjectId copy() {
        if (getClass() == ObjectId.class) {
            return (ObjectId) this;
        }
        return new ObjectId(this);
    }
}
