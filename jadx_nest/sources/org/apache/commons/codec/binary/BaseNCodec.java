package org.apache.commons.codec.binary;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* INFO: loaded from: classes5.dex */
public abstract class BaseNCodec implements BinaryEncoder, BinaryDecoder {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    private static final int MAX_BUFFER_SIZE = 2147483639;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;

    @Deprecated
    protected final byte PAD;
    private final int chunkSeparatorLength;
    private final CodecPolicy decodingPolicy;
    private final int encodedBlockSize;
    protected final int lineLength;
    protected final byte pad;
    private final int unencodedBlockSize;
    protected static final CodecPolicy DECODING_POLICY_DEFAULT = CodecPolicy.LENIENT;
    static final byte[] CHUNK_SEPARATOR = {Ascii.CR, 10};

    abstract void decode(byte[] bArr, int i, int i2, Context context);

    abstract void encode(byte[] bArr, int i, int i2, Context context);

    protected int getDefaultBufferSize() {
        return 8192;
    }

    protected abstract boolean isInAlphabet(byte b);

    public static abstract class AbstractBuilder<T, B extends AbstractBuilder<T, B>> implements Supplier<T> {
        private final byte[] defaultEncodeTable;
        private byte[] encodeTable;
        private int lineLength;
        private CodecPolicy decodingPolicy = BaseNCodec.DECODING_POLICY_DEFAULT;
        private byte[] lineSeparator = BaseNCodec.CHUNK_SEPARATOR;
        private byte padding = 61;

        B asThis() {
            return this;
        }

        AbstractBuilder(byte[] bArr) {
            this.defaultEncodeTable = bArr;
            this.encodeTable = bArr;
        }

        CodecPolicy getDecodingPolicy() {
            return this.decodingPolicy;
        }

        byte[] getEncodeTable() {
            return this.encodeTable;
        }

        int getLineLength() {
            return this.lineLength;
        }

        byte[] getLineSeparator() {
            return this.lineSeparator;
        }

        byte getPadding() {
            return this.padding;
        }

        public B setDecodingPolicy(CodecPolicy codecPolicy) {
            if (codecPolicy == null) {
                codecPolicy = BaseNCodec.DECODING_POLICY_DEFAULT;
            }
            this.decodingPolicy = codecPolicy;
            return (B) asThis();
        }

        public B setEncodeTable(byte... bArr) {
            if (bArr == null) {
                bArr = this.defaultEncodeTable;
            }
            this.encodeTable = bArr;
            return (B) asThis();
        }

        public B setLineLength(int i) {
            this.lineLength = Math.max(0, i);
            return (B) asThis();
        }

        public B setLineSeparator(byte... bArr) {
            if (bArr == null) {
                bArr = BaseNCodec.CHUNK_SEPARATOR;
            }
            this.lineSeparator = bArr;
            return (B) asThis();
        }

        public B setPadding(byte b) {
            this.padding = b;
            return (B) asThis();
        }
    }

    static class Context {
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        Context() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos));
        }
    }

    private static int createPositiveCapacity(int i) {
        if (i < 0) {
            throw new OutOfMemoryError("Unable to allocate array size: " + (((long) i) & 4294967295L));
        }
        return Math.max(i, MAX_BUFFER_SIZE);
    }

    public static byte[] getChunkSeparator() {
        return (byte[]) CHUNK_SEPARATOR.clone();
    }

    @Deprecated
    protected static boolean isWhiteSpace(byte b) {
        return Character.isWhitespace(b);
    }

    private static byte[] resizeBuffer(Context context, int i) {
        int length = context.buffer.length * 2;
        if (Integer.compareUnsigned(length, i) < 0) {
            length = i;
        }
        if (Integer.compareUnsigned(length, MAX_BUFFER_SIZE) > 0) {
            length = createPositiveCapacity(i);
        }
        byte[] bArrCopyOf = Arrays.copyOf(context.buffer, length);
        context.buffer = bArrCopyOf;
        return bArrCopyOf;
    }

    static int toLength(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    protected BaseNCodec(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, (byte) 61);
    }

    protected BaseNCodec(int i, int i2, int i3, int i4, byte b) {
        this(i, i2, i3, i4, b, DECODING_POLICY_DEFAULT);
    }

    protected BaseNCodec(int i, int i2, int i3, int i4, byte b, CodecPolicy codecPolicy) {
        this.PAD = (byte) 61;
        this.unencodedBlockSize = i;
        this.encodedBlockSize = i2;
        this.lineLength = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.chunkSeparatorLength = i4;
        this.pad = b;
        this.decodingPolicy = (CodecPolicy) Objects.requireNonNull(codecPolicy, "codecPolicy");
    }

    int available(Context context) {
        if (hasData(context)) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    protected boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr != null) {
            for (byte b : bArr) {
                if (this.pad == b || isInAlphabet(b)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        if (BinaryCodec.isEmpty(bArr)) {
            return bArr;
        }
        Context context = new Context();
        decode(bArr, 0, bArr.length, context);
        decode(bArr, 0, -1, context);
        int i = context.pos;
        byte[] bArr2 = new byte[i];
        readResults(bArr2, 0, i, context);
        return bArr2;
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return BinaryCodec.isEmpty(bArr) ? bArr : encode(bArr, 0, bArr.length);
    }

    public byte[] encode(byte[] bArr, int i, int i2) {
        if (BinaryCodec.isEmpty(bArr)) {
            return bArr;
        }
        Context context = new Context();
        encode(bArr, i, i2, context);
        encode(bArr, i, -1, context);
        int i3 = context.pos - context.readPos;
        byte[] bArr2 = new byte[i3];
        readResults(bArr2, 0, i3, context);
        return bArr2;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof byte[])) {
            throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
        }
        return encode((byte[]) obj);
    }

    public String encodeAsString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    protected byte[] ensureBufferSize(int i, Context context) {
        if (context.buffer == null) {
            context.buffer = new byte[Math.max(i, getDefaultBufferSize())];
            context.pos = 0;
            context.readPos = 0;
        } else if ((context.pos + i) - context.buffer.length > 0) {
            return resizeBuffer(context, context.pos + i);
        }
        return context.buffer;
    }

    public CodecPolicy getCodecPolicy() {
        return this.decodingPolicy;
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i = this.unencodedBlockSize;
        long j = ((long) (((length + i) - 1) / i)) * ((long) this.encodedBlockSize);
        int i2 = this.lineLength;
        return i2 > 0 ? j + ((((((long) i2) + j) - 1) / ((long) i2)) * ((long) this.chunkSeparatorLength)) : j;
    }

    boolean hasData(Context context) {
        return context.pos > context.readPos;
    }

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        for (byte b : bArr) {
            if (!isInAlphabet(b) && (!z || (b != this.pad && !Character.isWhitespace(b)))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(StringUtils.getBytesUtf8(str), true);
    }

    public boolean isStrictDecoding() {
        return this.decodingPolicy == CodecPolicy.STRICT;
    }

    int readResults(byte[] bArr, int i, int i2, Context context) {
        if (!hasData(context)) {
            return context.eof ? -1 : 0;
        }
        int iMin = Math.min(available(context), i2);
        System.arraycopy(context.buffer, context.readPos, bArr, i, iMin);
        context.readPos += iMin;
        if (!hasData(context)) {
            context.readPos = 0;
            context.pos = 0;
        }
        return iMin;
    }
}
