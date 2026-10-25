package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: loaded from: classes5.dex */
public class BinaryCodec implements BinaryDecoder, BinaryEncoder {
    private static final int BIT_0 = 1;
    private static final int BIT_1 = 2;
    private static final int BIT_2 = 4;
    private static final int BIT_3 = 8;
    private static final int BIT_4 = 16;
    private static final int BIT_5 = 32;
    private static final int BIT_6 = 64;
    private static final int BIT_7 = 128;
    private static final char[] EMPTY_CHAR_ARRAY = new char[0];
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final int[] BITS = {1, 2, 4, 8, 16, 32, 64, 128};

    public static byte[] fromAscii(byte[] bArr) {
        if (isEmpty(bArr)) {
            return EMPTY_BYTE_ARRAY;
        }
        int length = bArr.length;
        int i = length >> 3;
        byte[] bArr2 = new byte[i];
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i) {
            int i4 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i4 < iArr.length) {
                    if (bArr[i2 - i4] == 49) {
                        bArr2[i3] = (byte) (iArr[i4] | bArr2[i3]);
                    }
                    i4++;
                }
            }
            i3++;
            i2 -= 8;
        }
        return bArr2;
    }

    public static byte[] fromAscii(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        int length = cArr.length;
        int i = length >> 3;
        byte[] bArr = new byte[i];
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i) {
            int i4 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i4 < iArr.length) {
                    if (cArr[i2 - i4] == '1') {
                        bArr[i3] = (byte) (iArr[i4] | bArr[i3]);
                    }
                    i4++;
                }
            }
            i3++;
            i2 -= 8;
        }
        return bArr;
    }

    static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static byte[] toAsciiBytes(byte[] bArr) {
        if (isEmpty(bArr)) {
            return EMPTY_BYTE_ARRAY;
        }
        int length = bArr.length;
        int i = length << 3;
        byte[] bArr2 = new byte[i];
        int i2 = i - 1;
        int i3 = 0;
        while (i3 < length) {
            int i4 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i4 < iArr.length) {
                    if ((iArr[i4] & bArr[i3]) == 0) {
                        bArr2[i2 - i4] = 48;
                    } else {
                        bArr2[i2 - i4] = 49;
                    }
                    i4++;
                }
            }
            i3++;
            i2 -= 8;
        }
        return bArr2;
    }

    public static char[] toAsciiChars(byte[] bArr) {
        if (isEmpty(bArr)) {
            return EMPTY_CHAR_ARRAY;
        }
        int length = bArr.length;
        int i = length << 3;
        char[] cArr = new char[i];
        int i2 = i - 1;
        int i3 = 0;
        while (i3 < length) {
            int i4 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i4 < iArr.length) {
                    if ((iArr[i4] & bArr[i3]) == 0) {
                        cArr[i2 - i4] = '0';
                    } else {
                        cArr[i2 - i4] = '1';
                    }
                    i4++;
                }
            }
            i3++;
            i2 -= 8;
        }
        return cArr;
    }

    public static String toAsciiString(byte[] bArr) {
        return new String(toAsciiChars(bArr));
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        return fromAscii(bArr);
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return EMPTY_BYTE_ARRAY;
        }
        if (obj instanceof byte[]) {
            return fromAscii((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return fromAscii((char[]) obj);
        }
        if (obj instanceof String) {
            return fromAscii(((String) obj).toCharArray());
        }
        throw new DecoderException("argument not a byte array");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return toAsciiBytes(bArr);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof byte[])) {
            throw new EncoderException("argument not a byte array");
        }
        return toAsciiChars((byte[]) obj);
    }

    public byte[] toByteArray(String str) {
        if (str == null) {
            return EMPTY_BYTE_ARRAY;
        }
        return fromAscii(str.toCharArray());
    }
}
