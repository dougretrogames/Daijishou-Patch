package org.apache.commons.codec.net;

import java.nio.ByteBuffer;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: loaded from: classes5.dex */
public class PercentCodec implements BinaryEncoder, BinaryDecoder {
    private static final byte ESCAPE_CHAR = 37;
    private final BitSet alwaysEncodeChars;
    private int alwaysEncodeCharsMax;
    private int alwaysEncodeCharsMin;
    private final boolean plusForSpace;

    private boolean isAsciiChar(byte b) {
        return b >= 0;
    }

    public PercentCodec() {
        this.alwaysEncodeChars = new BitSet();
        this.alwaysEncodeCharsMin = Integer.MAX_VALUE;
        this.alwaysEncodeCharsMax = Integer.MIN_VALUE;
        this.plusForSpace = false;
        insertAlwaysEncodeChar(ESCAPE_CHAR);
    }

    public PercentCodec(byte[] bArr, boolean z) {
        this.alwaysEncodeChars = new BitSet();
        this.alwaysEncodeCharsMin = Integer.MAX_VALUE;
        this.alwaysEncodeCharsMax = Integer.MIN_VALUE;
        this.plusForSpace = z;
        insertAlwaysEncodeChars(bArr);
    }

    private boolean canEncode(byte b) {
        if (isAsciiChar(b)) {
            return inAlwaysEncodeCharsRange(b) && this.alwaysEncodeChars.get(b);
        }
        return true;
    }

    private boolean containsSpace(byte[] bArr) {
        for (byte b : bArr) {
            if (b == 32) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(expectedDecodingBytes(bArr));
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == 37) {
                try {
                    int iDigit16 = Utils.digit16(bArr[i + 1]);
                    i += 2;
                    byteBufferAllocate.put((byte) ((iDigit16 << 4) + Utils.digit16(bArr[i])));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DecoderException("Invalid percent decoding: ", e);
                }
            } else if (this.plusForSpace && b == 43) {
                byteBufferAllocate.put((byte) 32);
            } else {
                byteBufferAllocate.put(b);
            }
            i++;
        }
        return byteBufferAllocate.array();
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be Percent decoded");
    }

    private byte[] doEncode(byte[] bArr, int i, boolean z) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        for (byte b : bArr) {
            if (z && canEncode(b)) {
                if (b < 0) {
                    b = (byte) (b + 256);
                }
                char cHexDigit = Utils.hexDigit(b >> 4);
                char cHexDigit2 = Utils.hexDigit(b);
                byteBufferAllocate.put(ESCAPE_CHAR);
                byteBufferAllocate.put((byte) cHexDigit);
                byteBufferAllocate.put((byte) cHexDigit2);
            } else if (this.plusForSpace && b == 32) {
                byteBufferAllocate.put((byte) 43);
            } else {
                byteBufferAllocate.put(b);
            }
        }
        return byteBufferAllocate.array();
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) throws EncoderException {
        if (bArr == null) {
            return null;
        }
        int iExpectedEncodingBytes = expectedEncodingBytes(bArr);
        boolean z = iExpectedEncodingBytes != bArr.length;
        return (z || (this.plusForSpace && containsSpace(bArr))) ? doEncode(bArr, iExpectedEncodingBytes, z) : bArr;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be Percent encoded");
    }

    private int expectedDecodingBytes(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            i += bArr[i] == 37 ? 3 : 1;
            i2++;
        }
        return i2;
    }

    private int expectedEncodingBytes(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            i += canEncode(b) ? 3 : 1;
        }
        return i;
    }

    private boolean inAlwaysEncodeCharsRange(byte b) {
        return b >= this.alwaysEncodeCharsMin && b <= this.alwaysEncodeCharsMax;
    }

    private void insertAlwaysEncodeChar(byte b) {
        if (b < 0) {
            throw new IllegalArgumentException("byte must be >= 0");
        }
        this.alwaysEncodeChars.set(b);
        if (b < this.alwaysEncodeCharsMin) {
            this.alwaysEncodeCharsMin = b;
        }
        if (b > this.alwaysEncodeCharsMax) {
            this.alwaysEncodeCharsMax = b;
        }
    }

    private void insertAlwaysEncodeChars(byte[] bArr) {
        if (bArr != null) {
            for (byte b : bArr) {
                insertAlwaysEncodeChar(b);
            }
        }
        insertAlwaysEncodeChar(ESCAPE_CHAR);
    }
}
