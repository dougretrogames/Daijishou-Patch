package org.apache.commons.codec.binary;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import okio.Utf8;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: loaded from: classes5.dex */
public class Base64 extends BaseNCodec {
    private static final int ALPHABET_LENGTH = 64;
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    private static final int DECODING_TABLE_LENGTH = 256;
    private static final int MASK_2BITS = 3;
    private static final int MASK_4BITS = 15;
    private static final int MASK_6BITS = 63;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final boolean isUrlSafe;
    private final byte[] lineSeparator;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, kotlin.io.encoding.Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* synthetic */ Base64(int i, byte[] bArr, byte b, byte[] bArr2, CodecPolicy codecPolicy, AnonymousClass1 anonymousClass1) {
        this(i, bArr, b, bArr2, codecPolicy);
    }

    public static class Builder extends BaseNCodec.AbstractBuilder<Base64, Builder> {
        public Builder() {
            super(Base64.STANDARD_ENCODE_TABLE);
        }

        @Override // java.util.function.Supplier
        public Base64 get() {
            return new Base64(getLineLength(), getLineSeparator(), getPadding(), getEncodeTable(), getDecodingPolicy(), null);
        }

        public Builder setUrlSafe(boolean z) {
            return setEncodeTable(Base64.toUrlSafeEncodeTable(z));
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (BinaryCodec.isEmpty(bArr)) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength > i) {
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
        }
        return base64.encode(bArr);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUsAscii(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUsAscii(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "bigInteger");
        return encodeBase64(toIntegerBytes(bigInteger), false);
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b) {
        if (b == 61) {
            return true;
        }
        if (b < 0) {
            return false;
        }
        byte[] bArr = DECODE_TABLE;
        return b < bArr.length && bArr[b] != -1;
    }

    public static boolean isBase64(byte[] bArr) {
        for (byte b : bArr) {
            if (!isBase64(b) && !Character.isWhitespace(b)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    static byte[] toIntegerBytes(BigInteger bigInteger) {
        int iBitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == iBitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = iBitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    /* INFO: Access modifiers changed from: private */
    public static byte[] toUrlSafeEncodeTable(boolean z) {
        return z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }

    public Base64() {
        this(0);
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base64(int i, byte[] bArr, boolean z) {
        this(i, bArr, kotlin.io.encoding.Base64.padSymbol, toUrlSafeEncodeTable(z), DECODING_POLICY_DEFAULT);
    }

    public Base64(int i, byte[] bArr, boolean z, CodecPolicy codecPolicy) {
        this(i, bArr, kotlin.io.encoding.Base64.padSymbol, toUrlSafeEncodeTable(z), codecPolicy);
    }

    private Base64(int i, byte[] bArr, byte b, byte[] bArr2, CodecPolicy codecPolicy) {
        super(3, 4, i, toLength(bArr), b, codecPolicy);
        Objects.requireNonNull(bArr2, "encodeTable");
        if (bArr2.length != 64) {
            throw new IllegalArgumentException("encodeTable must have exactly 64 entries.");
        }
        boolean z = bArr2 == URL_SAFE_ENCODE_TABLE;
        this.isUrlSafe = z;
        if (bArr2 == STANDARD_ENCODE_TABLE || z) {
            this.decodeTable = DECODE_TABLE;
            this.encodeTable = bArr2;
        } else {
            byte[] bArr3 = (byte[]) bArr2.clone();
            this.encodeTable = bArr3;
            this.decodeTable = calculateDecodeTable(bArr3);
        }
        if (bArr != null) {
            byte[] bArr4 = (byte[]) bArr.clone();
            if (containsAlphabetOrPad(bArr4)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StringUtils.newStringUtf8(bArr4) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
            }
            if (i > 0) {
                this.encodeSize = bArr4.length + 4;
                this.lineSeparator = bArr4;
                return;
            } else {
                this.encodeSize = 4;
                this.lineSeparator = null;
                return;
            }
        }
        this.encodeSize = 4;
        this.lineSeparator = null;
    }

    private byte[] calculateDecodeTable(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        Arrays.fill(bArr2, (byte) -1);
        for (int i = 0; i < bArr.length; i++) {
            bArr2[bArr[i]] = (byte) i;
        }
        return bArr2;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b;
        if (context.eof) {
            return;
        }
        if (i2 < 0) {
            context.eof = true;
        }
        int i3 = this.encodeSize - 1;
        int i4 = 0;
        while (i4 < i2) {
            byte[] bArrEnsureBufferSize = ensureBufferSize(i3, context);
            int i5 = i + 1;
            byte b2 = bArr[i];
            if (b2 == this.pad) {
                context.eof = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = this.decodeTable;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    context.modulus = (context.modulus + 1) % 4;
                    context.ibitWorkArea = (context.ibitWorkArea << 6) + b;
                    if (context.modulus == 0) {
                        int i6 = context.pos;
                        context.pos = i6 + 1;
                        bArrEnsureBufferSize[i6] = (byte) ((context.ibitWorkArea >> 16) & 255);
                        int i7 = context.pos;
                        context.pos = i7 + 1;
                        bArrEnsureBufferSize[i7] = (byte) ((context.ibitWorkArea >> 8) & 255);
                        int i8 = context.pos;
                        context.pos = i8 + 1;
                        bArrEnsureBufferSize[i8] = (byte) (context.ibitWorkArea & 255);
                    }
                }
            }
            i4++;
            i = i5;
        }
        if (!context.eof || context.modulus == 0) {
            return;
        }
        byte[] bArrEnsureBufferSize2 = ensureBufferSize(i3, context);
        int i9 = context.modulus;
        if (i9 == 1) {
            validateTrailingCharacter();
            return;
        }
        if (i9 == 2) {
            validateCharacter(15, context);
            context.ibitWorkArea >>= 4;
            int i10 = context.pos;
            context.pos = i10 + 1;
            bArrEnsureBufferSize2[i10] = (byte) (context.ibitWorkArea & 255);
            return;
        }
        if (i9 == 3) {
            validateCharacter(3, context);
            context.ibitWorkArea >>= 2;
            int i11 = context.pos;
            context.pos = i11 + 1;
            bArrEnsureBufferSize2[i11] = (byte) ((context.ibitWorkArea >> 8) & 255);
            int i12 = context.pos;
            context.pos = i12 + 1;
            bArrEnsureBufferSize2[i12] = (byte) (context.ibitWorkArea & 255);
            return;
        }
        throw new IllegalStateException("Impossible modulus " + context.modulus);
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    void encode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        if (context.eof) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                byte[] bArrEnsureBufferSize = ensureBufferSize(this.encodeSize, context);
                context.modulus = (context.modulus + 1) % 3;
                int i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                context.ibitWorkArea = (context.ibitWorkArea << 8) + i5;
                if (context.modulus == 0) {
                    int i6 = context.pos;
                    context.pos = i6 + 1;
                    bArrEnsureBufferSize[i6] = this.encodeTable[(context.ibitWorkArea >> 18) & 63];
                    int i7 = context.pos;
                    context.pos = i7 + 1;
                    bArrEnsureBufferSize[i7] = this.encodeTable[(context.ibitWorkArea >> 12) & 63];
                    int i8 = context.pos;
                    context.pos = i8 + 1;
                    bArrEnsureBufferSize[i8] = this.encodeTable[(context.ibitWorkArea >> 6) & 63];
                    int i9 = context.pos;
                    context.pos = i9 + 1;
                    bArrEnsureBufferSize[i9] = this.encodeTable[context.ibitWorkArea & 63];
                    context.currentLinePos += 4;
                    if (this.lineLength > 0 && this.lineLength <= context.currentLinePos) {
                        System.arraycopy(this.lineSeparator, 0, bArrEnsureBufferSize, context.pos, this.lineSeparator.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                }
                i3++;
                i = i4;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] bArrEnsureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i10 = context.pos;
        int i11 = context.modulus;
        if (i11 != 0) {
            if (i11 == 1) {
                int i12 = context.pos;
                context.pos = i12 + 1;
                bArrEnsureBufferSize2[i12] = this.encodeTable[(context.ibitWorkArea >> 2) & 63];
                int i13 = context.pos;
                context.pos = i13 + 1;
                bArrEnsureBufferSize2[i13] = this.encodeTable[(context.ibitWorkArea << 4) & 63];
                if (this.encodeTable == STANDARD_ENCODE_TABLE) {
                    int i14 = context.pos;
                    context.pos = i14 + 1;
                    bArrEnsureBufferSize2[i14] = this.pad;
                    int i15 = context.pos;
                    context.pos = i15 + 1;
                    bArrEnsureBufferSize2[i15] = this.pad;
                }
            } else if (i11 == 2) {
                int i16 = context.pos;
                context.pos = i16 + 1;
                bArrEnsureBufferSize2[i16] = this.encodeTable[(context.ibitWorkArea >> 10) & 63];
                int i17 = context.pos;
                context.pos = i17 + 1;
                bArrEnsureBufferSize2[i17] = this.encodeTable[(context.ibitWorkArea >> 4) & 63];
                int i18 = context.pos;
                context.pos = i18 + 1;
                bArrEnsureBufferSize2[i18] = this.encodeTable[(context.ibitWorkArea << 2) & 63];
                if (this.encodeTable == STANDARD_ENCODE_TABLE) {
                    int i19 = context.pos;
                    context.pos = i19 + 1;
                    bArrEnsureBufferSize2[i19] = this.pad;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + context.modulus);
            }
        }
        context.currentLinePos += context.pos - i10;
        if (this.lineLength <= 0 || context.currentLinePos <= 0) {
            return;
        }
        System.arraycopy(this.lineSeparator, 0, bArrEnsureBufferSize2, context.pos, this.lineSeparator.length);
        context.pos += this.lineSeparator.length;
    }

    byte[] getLineSeparator() {
        return this.lineSeparator;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    protected boolean isInAlphabet(byte b) {
        if (b < 0) {
            return false;
        }
        byte[] bArr = this.decodeTable;
        return b < bArr.length && bArr[b] != -1;
    }

    public boolean isUrlSafe() {
        return this.isUrlSafe;
    }

    private void validateCharacter(int i, BaseNCodec.Context context) {
        if (isStrictDecoding() && (i & context.ibitWorkArea) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void validateTrailingCharacter() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Decoding requires at least two trailing 6-bit characters to create bytes.");
        }
    }
}
