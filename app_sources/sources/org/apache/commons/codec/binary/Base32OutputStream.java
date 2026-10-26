package org.apache.commons.codec.binary;

import java.io.OutputStream;
import org.apache.commons.codec.CodecPolicy;

/* INFO: loaded from: classes5.dex */
public class Base32OutputStream extends BaseNCodecOutputStream {
    public Base32OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z) {
        super(outputStream, new Base32(false), z);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z, int i, byte[] bArr) {
        super(outputStream, new Base32(i, bArr), z);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z, int i, byte[] bArr, CodecPolicy codecPolicy) {
        super(outputStream, new Base32(i, bArr, false, kotlin.io.encoding.Base64.padSymbol, codecPolicy), z);
    }
}
