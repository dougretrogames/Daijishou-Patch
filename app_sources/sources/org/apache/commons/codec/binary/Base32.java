package org.apache.commons.codec.binary;

import com.google.common.base.Ascii;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: loaded from: classes5.dex */
public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US};
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final long MASK_1BITS = 1;
    private static final long MASK_2BITS = 3;
    private static final long MASK_3BITS = 7;
    private static final long MASK_4BITS = 15;
    private static final int MASK_5BITS = 31;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    /* synthetic */ Base32(int i, byte[] bArr, byte[] bArr2, byte b, CodecPolicy codecPolicy, AnonymousClass1 anonymousClass1) {
        this(i, bArr, bArr2, b, codecPolicy);
    }

    public static class Builder extends BaseNCodec.AbstractBuilder<Base32, Builder> {
        public Builder() {
            super(Base32.ENCODE_TABLE);
        }

        @Override // java.util.function.Supplier
        public Base32 get() {
            return new Base32(getLineLength(), getLineSeparator(), getEncodeTable(), getPadding(), getDecodingPolicy(), null);
        }

        public Builder setHexDecodeTable(boolean z) {
            return setEncodeTable(Base32.decodeTable(z));
        }

        public Builder setHexEncodeTable(boolean z) {
            return setEncodeTable(Base32.encodeTable(z));
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* INFO: Access modifiers changed from: private */
    public static byte[] decodeTable(boolean z) {
        return z ? HEX_DECODE_TABLE : DECODE_TABLE;
    }

    /* INFO: Access modifiers changed from: private */
    public static byte[] encodeTable(boolean z) {
        return z ? HEX_ENCODE_TABLE : ENCODE_TABLE;
    }

    public Base32() {
        this(false);
    }

    public Base32(boolean z) {
        this(0, null, z, kotlin.io.encoding.Base64.padSymbol);
    }

    public Base32(boolean z, byte b) {
        this(0, null, z, b);
    }

    public Base32(byte b) {
        this(false, b);
    }

    public Base32(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false, kotlin.io.encoding.Base64.padSymbol);
    }

    public Base32(int i, byte[] bArr, boolean z) {
        this(i, bArr, z, kotlin.io.encoding.Base64.padSymbol);
    }

    public Base32(int i, byte[] bArr, boolean z, byte b) {
        this(i, bArr, z, b, DECODING_POLICY_DEFAULT);
    }

    public Base32(int i, byte[] bArr, boolean z, byte b, CodecPolicy codecPolicy) {
        this(i, bArr, encodeTable(z), b, codecPolicy);
    }

    private Base32(int i, byte[] bArr, byte[] bArr2, byte b, CodecPolicy codecPolicy) {
        super(5, 8, i, toLength(bArr), b, codecPolicy);
        Objects.requireNonNull(bArr2, "encodeTable");
        this.encodeTable = bArr2;
        this.decodeTable = bArr2 == HEX_ENCODE_TABLE ? HEX_DECODE_TABLE : DECODE_TABLE;
        if (i <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else {
            if (bArr == null) {
                throw new IllegalArgumentException("lineLength " + i + " > 0, but lineSeparator is null");
            }
            byte[] bArr3 = (byte[]) bArr.clone();
            if (containsAlphabetOrPad(bArr3)) {
                throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + StringUtils.newStringUtf8(bArr3) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
            }
            this.encodeSize = bArr3.length + 8;
            this.lineSeparator = bArr3;
        }
        if (isInAlphabet(b) || Character.isWhitespace(b)) {
            throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
        }
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
        int i5 = i;
        while (i4 < i2) {
            int i6 = i5 + 1;
            byte b2 = bArr[i5];
            if (b2 == this.pad) {
                context.eof = true;
                break;
            }
            byte[] bArrEnsureBufferSize = ensureBufferSize(i3, context);
            if (b2 >= 0) {
                byte[] bArr2 = this.decodeTable;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    context.modulus = (context.modulus + 1) % 8;
                    context.lbitWorkArea = (context.lbitWorkArea << 5) + ((long) b);
                    if (context.modulus == 0) {
                        int i7 = context.pos;
                        context.pos = i7 + 1;
                        bArrEnsureBufferSize[i7] = (byte) ((context.lbitWorkArea >> 32) & 255);
                        int i8 = context.pos;
                        context.pos = i8 + 1;
                        bArrEnsureBufferSize[i8] = (byte) ((context.lbitWorkArea >> 24) & 255);
                        int i9 = context.pos;
                        context.pos = i9 + 1;
                        bArrEnsureBufferSize[i9] = (byte) ((context.lbitWorkArea >> 16) & 255);
                        int i10 = context.pos;
                        context.pos = i10 + 1;
                        bArrEnsureBufferSize[i10] = (byte) ((context.lbitWorkArea >> 8) & 255);
                        int i11 = context.pos;
                        context.pos = i11 + 1;
                        bArrEnsureBufferSize[i11] = (byte) (context.lbitWorkArea & 255);
                    }
                }
            }
            i4++;
            i5 = i6;
        }
        if (!context.eof || context.modulus <= 0) {
            return;
        }
        byte[] bArrEnsureBufferSize2 = ensureBufferSize(i3, context);
        switch (context.modulus) {
            case 1:
                validateTrailingCharacters();
                break;
            case 2:
                break;
            case 3:
                validateTrailingCharacters();
                int i12 = context.pos;
                context.pos = i12 + 1;
                bArrEnsureBufferSize2[i12] = (byte) ((context.lbitWorkArea >> MASK_3BITS) & 255);
                return;
            case 4:
                validateCharacter(MASK_4BITS, context);
                context.lbitWorkArea >>= 4;
                int i13 = context.pos;
                context.pos = i13 + 1;
                bArrEnsureBufferSize2[i13] = (byte) ((context.lbitWorkArea >> 8) & 255);
                int i14 = context.pos;
                context.pos = i14 + 1;
                bArrEnsureBufferSize2[i14] = (byte) (context.lbitWorkArea & 255);
                return;
            case 5:
                validateCharacter(1L, context);
                context.lbitWorkArea >>= 1;
                int i15 = context.pos;
                context.pos = i15 + 1;
                bArrEnsureBufferSize2[i15] = (byte) ((context.lbitWorkArea >> 16) & 255);
                int i16 = context.pos;
                context.pos = i16 + 1;
                bArrEnsureBufferSize2[i16] = (byte) ((context.lbitWorkArea >> 8) & 255);
                int i17 = context.pos;
                context.pos = i17 + 1;
                bArrEnsureBufferSize2[i17] = (byte) (context.lbitWorkArea & 255);
                return;
            case 6:
                validateTrailingCharacters();
                context.lbitWorkArea >>= 6;
                int i18 = context.pos;
                context.pos = i18 + 1;
                bArrEnsureBufferSize2[i18] = (byte) ((context.lbitWorkArea >> 16) & 255);
                int i19 = context.pos;
                context.pos = i19 + 1;
                bArrEnsureBufferSize2[i19] = (byte) ((context.lbitWorkArea >> 8) & 255);
                int i20 = context.pos;
                context.pos = i20 + 1;
                bArrEnsureBufferSize2[i20] = (byte) (context.lbitWorkArea & 255);
                return;
            case 7:
                validateCharacter(MASK_3BITS, context);
                context.lbitWorkArea >>= 3;
                int i21 = context.pos;
                context.pos = i21 + 1;
                bArrEnsureBufferSize2[i21] = (byte) ((context.lbitWorkArea >> 24) & 255);
                int i22 = context.pos;
                context.pos = i22 + 1;
                bArrEnsureBufferSize2[i22] = (byte) ((context.lbitWorkArea >> 16) & 255);
                int i23 = context.pos;
                context.pos = i23 + 1;
                bArrEnsureBufferSize2[i23] = (byte) ((context.lbitWorkArea >> 8) & 255);
                int i24 = context.pos;
                context.pos = i24 + 1;
                bArrEnsureBufferSize2[i24] = (byte) (context.lbitWorkArea & 255);
                return;
            default:
                throw new IllegalStateException("Impossible modulus " + context.modulus);
        }
        validateCharacter(3L, context);
        int i25 = context.pos;
        context.pos = i25 + 1;
        bArrEnsureBufferSize2[i25] = (byte) ((context.lbitWorkArea >> 2) & 255);
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
                context.modulus = (context.modulus + 1) % 5;
                int i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                context.lbitWorkArea = (context.lbitWorkArea << 8) + ((long) i5);
                if (context.modulus == 0) {
                    int i6 = context.pos;
                    context.pos = i6 + 1;
                    bArrEnsureBufferSize[i6] = this.encodeTable[((int) (context.lbitWorkArea >> 35)) & 31];
                    int i7 = context.pos;
                    context.pos = i7 + 1;
                    bArrEnsureBufferSize[i7] = this.encodeTable[((int) (context.lbitWorkArea >> 30)) & 31];
                    int i8 = context.pos;
                    context.pos = i8 + 1;
                    bArrEnsureBufferSize[i8] = this.encodeTable[((int) (context.lbitWorkArea >> 25)) & 31];
                    int i9 = context.pos;
                    context.pos = i9 + 1;
                    bArrEnsureBufferSize[i9] = this.encodeTable[((int) (context.lbitWorkArea >> 20)) & 31];
                    int i10 = context.pos;
                    context.pos = i10 + 1;
                    bArrEnsureBufferSize[i10] = this.encodeTable[((int) (context.lbitWorkArea >> MASK_4BITS)) & 31];
                    int i11 = context.pos;
                    context.pos = i11 + 1;
                    bArrEnsureBufferSize[i11] = this.encodeTable[((int) (context.lbitWorkArea >> 10)) & 31];
                    int i12 = context.pos;
                    context.pos = i12 + 1;
                    bArrEnsureBufferSize[i12] = this.encodeTable[((int) (context.lbitWorkArea >> 5)) & 31];
                    int i13 = context.pos;
                    context.pos = i13 + 1;
                    bArrEnsureBufferSize[i13] = this.encodeTable[((int) context.lbitWorkArea) & 31];
                    context.currentLinePos += 8;
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
        int i14 = context.pos;
        int i15 = context.modulus;
        if (i15 != 0) {
            if (i15 == 1) {
                int i16 = context.pos;
                context.pos = i16 + 1;
                bArrEnsureBufferSize2[i16] = this.encodeTable[((int) (context.lbitWorkArea >> 3)) & 31];
                int i17 = context.pos;
                context.pos = i17 + 1;
                bArrEnsureBufferSize2[i17] = this.encodeTable[((int) (context.lbitWorkArea << 2)) & 31];
                int i18 = context.pos;
                context.pos = i18 + 1;
                bArrEnsureBufferSize2[i18] = this.pad;
                int i19 = context.pos;
                context.pos = i19 + 1;
                bArrEnsureBufferSize2[i19] = this.pad;
                int i20 = context.pos;
                context.pos = i20 + 1;
                bArrEnsureBufferSize2[i20] = this.pad;
                int i21 = context.pos;
                context.pos = i21 + 1;
                bArrEnsureBufferSize2[i21] = this.pad;
                int i22 = context.pos;
                context.pos = i22 + 1;
                bArrEnsureBufferSize2[i22] = this.pad;
                int i23 = context.pos;
                context.pos = i23 + 1;
                bArrEnsureBufferSize2[i23] = this.pad;
            } else if (i15 == 2) {
                int i24 = context.pos;
                context.pos = i24 + 1;
                bArrEnsureBufferSize2[i24] = this.encodeTable[((int) (context.lbitWorkArea >> 11)) & 31];
                int i25 = context.pos;
                context.pos = i25 + 1;
                bArrEnsureBufferSize2[i25] = this.encodeTable[((int) (context.lbitWorkArea >> 6)) & 31];
                int i26 = context.pos;
                context.pos = i26 + 1;
                bArrEnsureBufferSize2[i26] = this.encodeTable[((int) (context.lbitWorkArea >> 1)) & 31];
                int i27 = context.pos;
                context.pos = i27 + 1;
                bArrEnsureBufferSize2[i27] = this.encodeTable[((int) (context.lbitWorkArea << 4)) & 31];
                int i28 = context.pos;
                context.pos = i28 + 1;
                bArrEnsureBufferSize2[i28] = this.pad;
                int i29 = context.pos;
                context.pos = i29 + 1;
                bArrEnsureBufferSize2[i29] = this.pad;
                int i30 = context.pos;
                context.pos = i30 + 1;
                bArrEnsureBufferSize2[i30] = this.pad;
                int i31 = context.pos;
                context.pos = i31 + 1;
                bArrEnsureBufferSize2[i31] = this.pad;
            } else if (i15 == 3) {
                int i32 = context.pos;
                context.pos = i32 + 1;
                bArrEnsureBufferSize2[i32] = this.encodeTable[((int) (context.lbitWorkArea >> 19)) & 31];
                int i33 = context.pos;
                context.pos = i33 + 1;
                bArrEnsureBufferSize2[i33] = this.encodeTable[((int) (context.lbitWorkArea >> 14)) & 31];
                int i34 = context.pos;
                context.pos = i34 + 1;
                bArrEnsureBufferSize2[i34] = this.encodeTable[((int) (context.lbitWorkArea >> 9)) & 31];
                int i35 = context.pos;
                context.pos = i35 + 1;
                bArrEnsureBufferSize2[i35] = this.encodeTable[((int) (context.lbitWorkArea >> 4)) & 31];
                int i36 = context.pos;
                context.pos = i36 + 1;
                bArrEnsureBufferSize2[i36] = this.encodeTable[((int) (context.lbitWorkArea << 1)) & 31];
                int i37 = context.pos;
                context.pos = i37 + 1;
                bArrEnsureBufferSize2[i37] = this.pad;
                int i38 = context.pos;
                context.pos = i38 + 1;
                bArrEnsureBufferSize2[i38] = this.pad;
                int i39 = context.pos;
                context.pos = i39 + 1;
                bArrEnsureBufferSize2[i39] = this.pad;
            } else if (i15 == 4) {
                int i40 = context.pos;
                context.pos = i40 + 1;
                bArrEnsureBufferSize2[i40] = this.encodeTable[((int) (context.lbitWorkArea >> 27)) & 31];
                int i41 = context.pos;
                context.pos = i41 + 1;
                bArrEnsureBufferSize2[i41] = this.encodeTable[((int) (context.lbitWorkArea >> 22)) & 31];
                int i42 = context.pos;
                context.pos = i42 + 1;
                bArrEnsureBufferSize2[i42] = this.encodeTable[((int) (context.lbitWorkArea >> 17)) & 31];
                int i43 = context.pos;
                context.pos = i43 + 1;
                bArrEnsureBufferSize2[i43] = this.encodeTable[((int) (context.lbitWorkArea >> 12)) & 31];
                int i44 = context.pos;
                context.pos = i44 + 1;
                bArrEnsureBufferSize2[i44] = this.encodeTable[((int) (context.lbitWorkArea >> MASK_3BITS)) & 31];
                int i45 = context.pos;
                context.pos = i45 + 1;
                bArrEnsureBufferSize2[i45] = this.encodeTable[((int) (context.lbitWorkArea >> 2)) & 31];
                int i46 = context.pos;
                context.pos = i46 + 1;
                bArrEnsureBufferSize2[i46] = this.encodeTable[((int) (context.lbitWorkArea << 3)) & 31];
                int i47 = context.pos;
                context.pos = i47 + 1;
                bArrEnsureBufferSize2[i47] = this.pad;
            } else {
                throw new IllegalStateException("Impossible modulus " + context.modulus);
            }
        }
        context.currentLinePos += context.pos - i14;
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
    public boolean isInAlphabet(byte b) {
        if (b < 0) {
            return false;
        }
        byte[] bArr = this.decodeTable;
        return b < bArr.length && bArr[b] != -1;
    }

    private void validateCharacter(long j, BaseNCodec.Context context) {
        if (isStrictDecoding() && (j & context.lbitWorkArea) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 32 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void validateTrailingCharacters() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character(s) (before the paddings if any) are valid base 32 alphabet but not a possible encoding. Decoding requires either 2, 4, 5, or 7 trailing 5-bit characters to create bytes.");
        }
    }
}
