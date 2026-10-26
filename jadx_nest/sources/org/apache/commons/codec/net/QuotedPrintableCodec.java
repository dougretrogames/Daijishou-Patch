package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

/* INFO: loaded from: classes5.dex */
public class QuotedPrintableCodec implements BinaryEncoder, BinaryDecoder, StringEncoder, StringDecoder {
    private static final byte CR = 13;
    private static final byte ESCAPE_CHAR = 61;
    private static final byte LF = 10;
    private static final int MIN_BYTES = 3;
    private static final BitSet PRINTABLE_CHARS = new BitSet(256);
    private static final int SAFE_LENGTH = 73;
    private static final byte SPACE = 32;
    private static final byte TAB = 9;
    private final Charset charset;
    private final boolean strict;

    private static boolean isWhitespace(int i) {
        return i == 32 || i == 9;
    }

    static {
        for (int i = 33; i <= 60; i++) {
            PRINTABLE_CHARS.set(i);
        }
        for (int i2 = 62; i2 <= 126; i2++) {
            PRINTABLE_CHARS.set(i2);
        }
        BitSet bitSet = PRINTABLE_CHARS;
        bitSet.set(9);
        bitSet.set(32);
    }

    public static final byte[] decodeQuotedPrintable(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == 61) {
                int i2 = i + 1;
                try {
                    byte b2 = bArr[i2];
                    if (b2 == 13) {
                        i = i2;
                    } else {
                        i += 2;
                        byteArrayOutputStream.write((char) ((Utils.digit16(b2) << 4) + Utils.digit16(bArr[i])));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DecoderException("Invalid quoted-printable encoding", e);
                }
            } else if (b != 13 && b != 10) {
                byteArrayOutputStream.write(b);
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static int encodeByte(int i, boolean z, ByteArrayOutputStream byteArrayOutputStream) {
        if (z) {
            return encodeQuotedPrintable(i, byteArrayOutputStream);
        }
        byteArrayOutputStream.write(i);
        return 1;
    }

    public static final byte[] encodeQuotedPrintable(BitSet bitSet, byte[] bArr) {
        return encodeQuotedPrintable(bitSet, bArr, false);
    }

    public static final byte[] encodeQuotedPrintable(BitSet bitSet, byte[] bArr, boolean z) {
        int i;
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = PRINTABLE_CHARS;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        if (z) {
            if (length < 3) {
                return null;
            }
            int iEncodeByte = 1;
            int i2 = 0;
            while (true) {
                i = length - 3;
                if (i2 >= i) {
                    break;
                }
                int unsignedOctet = getUnsignedOctet(i2, bArr);
                if (iEncodeByte < 73) {
                    iEncodeByte += encodeByte(unsignedOctet, !bitSet.get(unsignedOctet), byteArrayOutputStream);
                } else {
                    encodeByte(unsignedOctet, !bitSet.get(unsignedOctet) || isWhitespace(unsignedOctet), byteArrayOutputStream);
                    byteArrayOutputStream.write(61);
                    byteArrayOutputStream.write(13);
                    byteArrayOutputStream.write(10);
                    iEncodeByte = 1;
                }
                i2++;
            }
            int unsignedOctet2 = getUnsignedOctet(i, bArr);
            if (iEncodeByte + encodeByte(unsignedOctet2, !bitSet.get(unsignedOctet2) || (isWhitespace(unsignedOctet2) && iEncodeByte > 68), byteArrayOutputStream) > 71) {
                byteArrayOutputStream.write(61);
                byteArrayOutputStream.write(13);
                byteArrayOutputStream.write(10);
            }
            int i3 = length - 2;
            int i4 = i3;
            while (i4 < length) {
                int unsignedOctet3 = getUnsignedOctet(i4, bArr);
                encodeByte(unsignedOctet3, !bitSet.get(unsignedOctet3) || (i4 > i3 && isWhitespace(unsignedOctet3)), byteArrayOutputStream);
                i4++;
            }
        } else {
            int length2 = bArr.length;
            for (int i5 = 0; i5 < length2; i5++) {
                int i6 = bArr[i5];
                if (i6 < 0) {
                    i6 += 256;
                }
                if (bitSet.get(i6)) {
                    byteArrayOutputStream.write(i6);
                } else {
                    encodeQuotedPrintable(i6, byteArrayOutputStream);
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static int encodeQuotedPrintable(int i, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char cHexDigit = Utils.hexDigit(i >> 4);
        char cHexDigit2 = Utils.hexDigit(i);
        byteArrayOutputStream.write(cHexDigit);
        byteArrayOutputStream.write(cHexDigit2);
        return 3;
    }

    private static int getUnsignedOctet(int i, byte[] bArr) {
        byte b = bArr[i];
        return b < 0 ? b + 256 : b;
    }

    public QuotedPrintableCodec() {
        this(StandardCharsets.UTF_8, false);
    }

    public QuotedPrintableCodec(boolean z) {
        this(StandardCharsets.UTF_8, z);
    }

    public QuotedPrintableCodec(Charset charset) {
        this(charset, false);
    }

    public QuotedPrintableCodec(Charset charset, boolean z) {
        this.charset = charset;
        this.strict = z;
    }

    public QuotedPrintableCodec(String str) throws IllegalArgumentException {
        this(Charset.forName(str), false);
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        return decodeQuotedPrintable(bArr);
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable decoded");
    }

    @Override // org.apache.commons.codec.StringDecoder
    public String decode(String str) throws DecoderException {
        return decode(str, getCharset());
    }

    public String decode(String str, Charset charset) throws DecoderException {
        if (str == null) {
            return null;
        }
        return new String(decode(StringUtils.getBytesUsAscii(str)), charset);
    }

    public String decode(String str, String str2) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(decode(StringUtils.getBytesUsAscii(str)), str2);
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return encodeQuotedPrintable(PRINTABLE_CHARS, bArr, this.strict);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable encoded");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) throws EncoderException {
        return encode(str, getCharset());
    }

    public String encode(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return StringUtils.newStringUsAscii(encode(str.getBytes(charset)));
    }

    public String encode(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return StringUtils.newStringUsAscii(encode(str.getBytes(str2)));
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getDefaultCharset() {
        return this.charset.name();
    }
}
