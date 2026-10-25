package org.eclipse.jgit.lib;

import java.io.Serializable;
import java.text.MessageFormat;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.errors.InvalidObjectIdException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class AbbreviatedObjectId implements Serializable {
    private static final long serialVersionUID = 1;
    final int nibbles;
    final int w1;
    final int w2;
    final int w3;
    final int w4;
    final int w5;

    static int mask(int i, int i2, int i3) {
        int i4 = (i2 - 1) * 8;
        if (i4 + 8 <= i) {
            return i3;
        }
        if (i <= i4) {
            return 0;
        }
        int i5 = 32 - ((i - i4) * 4);
        return (i3 >>> i5) << i5;
    }

    public static final boolean isId(String str) {
        if (str.length() >= 2 && 40 >= str.length()) {
            for (int i = 0; i < str.length(); i++) {
                try {
                    RawParseUtils.parseHexInt4((byte) str.charAt(i));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public static final AbbreviatedObjectId fromString(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 > 40) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidIdLength, Integer.valueOf(i3), 40));
        }
        return fromHexString(bArr, i, i2);
    }

    public static final AbbreviatedObjectId fromObjectId(AnyObjectId anyObjectId) {
        return new AbbreviatedObjectId(40, anyObjectId.w1, anyObjectId.w2, anyObjectId.w3, anyObjectId.w4, anyObjectId.w5);
    }

    public static final AbbreviatedObjectId fromString(String str) {
        if (str.length() > 40) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidId, str));
        }
        byte[] bArrEncodeASCII = Constants.encodeASCII(str);
        return fromHexString(bArrEncodeASCII, 0, bArrEncodeASCII.length);
    }

    private static final AbbreviatedObjectId fromHexString(byte[] bArr, int i, int i2) {
        try {
            return new AbbreviatedObjectId(i2 - i, hexUInt32(bArr, i, i2), hexUInt32(bArr, i + 8, i2), hexUInt32(bArr, i + 16, i2), hexUInt32(bArr, i + 24, i2), hexUInt32(bArr, i + 32, i2));
        } catch (ArrayIndexOutOfBoundsException e) {
            InvalidObjectIdException invalidObjectIdException = new InvalidObjectIdException(bArr, i, i2 - i);
            invalidObjectIdException.initCause(e);
            throw invalidObjectIdException;
        }
    }

    private static final int hexUInt32(byte[] bArr, int i, int i2) {
        if (8 <= i2 - i) {
            return RawParseUtils.parseHexInt32(bArr, i);
        }
        int i3 = 0;
        int hexInt4 = 0;
        while (i3 < 8 && i < i2) {
            hexInt4 = (hexInt4 << 4) | RawParseUtils.parseHexInt4(bArr[i]);
            i3++;
            i++;
        }
        return hexInt4 << ((8 - i3) * 4);
    }

    AbbreviatedObjectId(int i, int i2, int i3, int i4, int i5, int i6) {
        this.nibbles = i;
        this.w1 = i2;
        this.w2 = i3;
        this.w3 = i4;
        this.w4 = i5;
        this.w5 = i6;
    }

    public int length() {
        return this.nibbles;
    }

    public boolean isComplete() {
        return length() == 40;
    }

    public ObjectId toObjectId() {
        if (isComplete()) {
            return new ObjectId(this.w1, this.w2, this.w3, this.w4, this.w5);
        }
        return null;
    }

    public final int prefixCompare(AnyObjectId anyObjectId) {
        int iCompareUInt32 = NB.compareUInt32(this.w1, mask(1, anyObjectId.w1));
        if (iCompareUInt32 != 0) {
            return iCompareUInt32;
        }
        int iCompareUInt33 = NB.compareUInt32(this.w2, mask(2, anyObjectId.w2));
        if (iCompareUInt33 != 0) {
            return iCompareUInt33;
        }
        int iCompareUInt34 = NB.compareUInt32(this.w3, mask(3, anyObjectId.w3));
        if (iCompareUInt34 != 0) {
            return iCompareUInt34;
        }
        int iCompareUInt35 = NB.compareUInt32(this.w4, mask(4, anyObjectId.w4));
        return iCompareUInt35 != 0 ? iCompareUInt35 : NB.compareUInt32(this.w5, mask(5, anyObjectId.w5));
    }

    public final int prefixCompare(byte[] bArr, int i) {
        int iCompareUInt32 = NB.compareUInt32(this.w1, mask(1, NB.decodeInt32(bArr, i)));
        if (iCompareUInt32 != 0) {
            return iCompareUInt32;
        }
        int iCompareUInt33 = NB.compareUInt32(this.w2, mask(2, NB.decodeInt32(bArr, i + 4)));
        if (iCompareUInt33 != 0) {
            return iCompareUInt33;
        }
        int iCompareUInt34 = NB.compareUInt32(this.w3, mask(3, NB.decodeInt32(bArr, i + 8)));
        if (iCompareUInt34 != 0) {
            return iCompareUInt34;
        }
        int iCompareUInt35 = NB.compareUInt32(this.w4, mask(4, NB.decodeInt32(bArr, i + 12)));
        return iCompareUInt35 != 0 ? iCompareUInt35 : NB.compareUInt32(this.w5, mask(5, NB.decodeInt32(bArr, i + 16)));
    }

    public final int prefixCompare(int[] iArr, int i) {
        int iCompareUInt32 = NB.compareUInt32(this.w1, mask(1, iArr[i]));
        if (iCompareUInt32 != 0) {
            return iCompareUInt32;
        }
        int iCompareUInt33 = NB.compareUInt32(this.w2, mask(2, iArr[i + 1]));
        if (iCompareUInt33 != 0) {
            return iCompareUInt33;
        }
        int iCompareUInt34 = NB.compareUInt32(this.w3, mask(3, iArr[i + 2]));
        if (iCompareUInt34 != 0) {
            return iCompareUInt34;
        }
        int iCompareUInt35 = NB.compareUInt32(this.w4, mask(4, iArr[i + 3]));
        return iCompareUInt35 != 0 ? iCompareUInt35 : NB.compareUInt32(this.w5, mask(5, iArr[i + 4]));
    }

    public final int getFirstByte() {
        return this.w1 >>> 24;
    }

    private int mask(int i, int i2) {
        return mask(this.nibbles, i, i2);
    }

    public int hashCode() {
        return this.w1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbbreviatedObjectId) {
            AbbreviatedObjectId abbreviatedObjectId = (AbbreviatedObjectId) obj;
            if (this.nibbles == abbreviatedObjectId.nibbles && this.w1 == abbreviatedObjectId.w1 && this.w2 == abbreviatedObjectId.w2 && this.w3 == abbreviatedObjectId.w3 && this.w4 == abbreviatedObjectId.w4 && this.w5 == abbreviatedObjectId.w5) {
                return true;
            }
        }
        return false;
    }

    public final String name() {
        char[] cArr = new char[40];
        AnyObjectId.formatHexChar(cArr, 0, this.w1);
        if (this.nibbles <= 8) {
            return new String(cArr, 0, this.nibbles);
        }
        AnyObjectId.formatHexChar(cArr, 8, this.w2);
        if (this.nibbles <= 16) {
            return new String(cArr, 0, this.nibbles);
        }
        AnyObjectId.formatHexChar(cArr, 16, this.w3);
        if (this.nibbles <= 24) {
            return new String(cArr, 0, this.nibbles);
        }
        AnyObjectId.formatHexChar(cArr, 24, this.w4);
        if (this.nibbles <= 32) {
            return new String(cArr, 0, this.nibbles);
        }
        AnyObjectId.formatHexChar(cArr, 32, this.w5);
        return new String(cArr, 0, this.nibbles);
    }

    public String toString() {
        return "AbbreviatedObjectId[" + name() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
