package org.apache.commons.codec.binary;

import com.google.common.base.Ascii;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

/* INFO: loaded from: classes5.dex */
public class Base16 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 4;
    private static final int BYTES_PER_ENCODED_BLOCK = 2;
    private static final int BYTES_PER_UNENCODED_BLOCK = 1;
    private static final int MASK_4BITS = 15;
    private final byte[] decodeTable;
    private final byte[] encodeTable;
    private static final byte[] UPPER_CASE_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI};
    private static final byte[] UPPER_CASE_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    private static final byte[] LOWER_CASE_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI};
    private static final byte[] LOWER_CASE_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public Base16() {
        this(false);
    }

    public Base16(boolean z) {
        this(z, DECODING_POLICY_DEFAULT);
    }

    private Base16(boolean z, byte[] bArr, CodecPolicy codecPolicy) {
        super(1, 2, 0, 0, kotlin.io.encoding.Base64.padSymbol, codecPolicy);
        Objects.requireNonNull(bArr, "encodeTable");
        this.encodeTable = bArr;
        this.decodeTable = bArr == LOWER_CASE_ENCODE_TABLE ? LOWER_CASE_DECODE_TABLE : UPPER_CASE_DECODE_TABLE;
    }

    public Base16(boolean z, CodecPolicy codecPolicy) {
        this(z, z ? LOWER_CASE_ENCODE_TABLE : UPPER_CASE_ENCODE_TABLE, codecPolicy);
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        if (context.eof || i2 < 0) {
            context.eof = true;
            if (context.ibitWorkArea != 0) {
                validateTrailingCharacter();
                return;
            }
            return;
        }
        int iMin = Math.min(bArr.length - i, i2);
        int i3 = (context.ibitWorkArea != 0 ? 1 : 0) + iMin;
        if (i3 == 1 && i3 == iMin) {
            context.ibitWorkArea = decodeOctet(bArr[i]) + 1;
            return;
        }
        int i4 = i + iMin;
        byte[] bArrEnsureBufferSize = ensureBufferSize((i3 % 2 == 0 ? i3 : i3 - 1) / 2, context);
        if (iMin < i3) {
            int i5 = i + 1;
            int iDecodeOctet = decodeOctet(bArr[i]) | ((context.ibitWorkArea - 1) << 4);
            int i6 = context.pos;
            context.pos = i6 + 1;
            bArrEnsureBufferSize[i6] = (byte) iDecodeOctet;
            context.ibitWorkArea = 0;
            i = i5;
        }
        int i7 = i4 - 1;
        while (i < i7) {
            int i8 = i + 1;
            int iDecodeOctet2 = decodeOctet(bArr[i]) << 4;
            i += 2;
            int iDecodeOctet3 = decodeOctet(bArr[i8]) | iDecodeOctet2;
            int i9 = context.pos;
            context.pos = i9 + 1;
            bArrEnsureBufferSize[i9] = (byte) iDecodeOctet3;
        }
        if (i < i4) {
            context.ibitWorkArea = decodeOctet(bArr[i]) + 1;
        }
    }

    private int decodeOctet(byte b) {
        int i = b & 255;
        byte[] bArr = this.decodeTable;
        byte b2 = i < bArr.length ? bArr[b] : (byte) -1;
        if (b2 != -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid octet in encoded value: " + ((int) b));
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    void encode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        if (context.eof) {
            return;
        }
        if (i2 < 0) {
            context.eof = true;
            return;
        }
        int i3 = i2 * 2;
        if (i3 < 0) {
            throw new IllegalArgumentException("Input length exceeds maximum size for encoded data: " + i2);
        }
        byte[] bArrEnsureBufferSize = ensureBufferSize(i3, context);
        int i4 = i2 + i;
        while (i < i4) {
            byte b = bArr[i];
            int i5 = (b >> 4) & 15;
            int i6 = b & Ascii.SI;
            int i7 = context.pos;
            context.pos = i7 + 1;
            bArrEnsureBufferSize[i7] = this.encodeTable[i5];
            int i8 = context.pos;
            context.pos = i8 + 1;
            bArrEnsureBufferSize[i8] = this.encodeTable[i6];
            i++;
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        int i = b & 255;
        byte[] bArr = this.decodeTable;
        return i < bArr.length && bArr[b] != -1;
    }

    private void validateTrailingCharacter() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character is a valid base 16 alphabet character but not a possible encoding. Decoding requires at least two characters to create one byte.");
        }
    }
}
